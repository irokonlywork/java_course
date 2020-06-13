package ru.stqa.course.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.course.addressbook.model.ContactData;

import java.util.ArrayList;
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

    public void initContactModification(int i){
        wd.findElements(By.xpath("//img[@alt='Edit']")).get(i).click();
    }

    public void submitContactModification(){
        click(By.xpath("(//input[@name='update'])[2]"));
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
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
        homePage();
    }

    public void modify(int index, ContactData contact) {
        initContactModification(index);
        fillContactForm(contact, false);
        submitContactModification();
        homePage();
    }

    public void delete(int index) {
        selectContact(index);
        deleteSelectedContact();
        selectAlert();
        switchTo();
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

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            List<WebElement> cells = element.findElements(By.cssSelector("td")); //разбивает строку на ячейки
                String lastname = cells.get(1).getText();
                String firstname = cells.get(2).getText();
                int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
                ContactData contact = new ContactData(id, firstname, lastname, null, null);
                contacts.add(contact);
            }
        return contacts;
    }
}
