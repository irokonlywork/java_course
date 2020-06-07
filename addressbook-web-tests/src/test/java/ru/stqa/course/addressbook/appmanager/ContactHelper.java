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

    public void initContactModification(int index){
        wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
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

    public void createContact(ContactData contact, boolean creation) {
        gotoNewContactPage();
        fillContactForm(contact, creation);
        submitContactCreation();
        gotoHomePage();
    }

    private void gotoHomePage() {
        if ( isElementPresent(By.id("maintable")) ) {
            return;
        }
        click(By.linkText("home page"));
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String fistname = element.getText();
            String lastname = element.getText();
            ContactData contact = new ContactData(fistname, lastname, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}
