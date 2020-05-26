package ru.stqa.course.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.course.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

    public ContactHelper(ChromeDriver wd) {
        super(wd);
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("email"), contactData.getEmail());
    }

    public void submitContactCreation() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void gotoNewContactPage() {
        click(By.linkText("add new"));
    }

    public void initContactModification(){
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void submitContactModification(){
        click(By.xpath("(//input[@name='update'])[2]"));
    }

    public void selectContact() {
        click(By.xpath("(//input[@name='selected[]'])"));
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
}
