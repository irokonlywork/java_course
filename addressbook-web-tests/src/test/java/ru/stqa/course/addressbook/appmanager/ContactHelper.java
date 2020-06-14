package ru.stqa.course.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.course.addressbook.model.ContactData;
import ru.stqa.course.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("email"), contactData.getEmail());

        if ( creation ) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void submitContactCreation() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void gotoNewContactPage() {
        click(By.linkText("add new"));
    }

    public void initContactModification(int index){
        wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
    }

    private void initContactModificationById(int id) {
        wd.findElement(By.cssSelector("a[href='edit.php?id=" + id +"']")).click();
    }

    private void initContactModificationById2(int id) {
        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id))); //находим чекбокс
        WebElement row = checkbox.findElement(By.xpath("./../..")); //поиск относительно чекбокса по xpath запросу, переход к родительскому элементу (т.е. к строке)
        List<WebElement> cells = row.findElements(By.tagName("td")); //из полного списка ячеек берем все элементы с tagName td
        cells.get(7).findElement(By.tagName("a")).click(); //среди найденных ячеек берем по номеру нужную (по номеру столбца), внутри ячейки находим ссылку tagName("a")
    }


    public void submitContactModification(){
        click(By.xpath("(//input[@name='update'])[2]"));
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id +"']")).click();
    }

    public void deleteSelectedContact(){
        click(By.xpath("//input[@value='Delete']"));
    }

    public void selectAlert(){
        assert (true);
    }

    public void switchTo() {
        wd.switchTo().alert().accept();
    }

    public void create(ContactData contact, boolean creation) {
        gotoNewContactPage();
        fillContactForm(contact, creation);
        submitContactCreation();
        contactCache = null;
        homePage();
    }

    public void modify(ContactData contact) {
        initContactModificationById(contact.getId());
        fillContactForm(contact, false);
        submitContactModification();
        contactCache = null;
        homePage();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteSelectedContact();
        selectAlert();
        switchTo();
        contactCache = null;
        refresh();
    }

    public void homePage() {
        if ( isElementPresent(By.id("maintable")) ) {
            return;
        }
        click(By.linkText("home page"));
    }

    public void await() {
        wd.findElements(By.cssSelector("div.msgbox"));
    }

    public void refresh() {
        wd.get("https://localhost/addressbook/index.php");
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    private Contacts contactCache = null;

    public Contacts all() {
        if ( contactCache != null ) {
            return new Contacts(contactCache);
        }

        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            List<WebElement> cells = element.findElements(By.cssSelector("td")); //разбивает строку на ячейки
                String lastname = cells.get(1).getText();
                String firstname = cells.get(2).getText();
                int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
                String[] phones = cells.get(5).getText().split("\n");
            contactCache.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
                    .withHomePhone(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2]));
            }
        return new Contacts(contactCache);
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
    }
}
