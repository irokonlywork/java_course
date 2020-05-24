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

    public void submitContactCreation(By xpath) {
        click(xpath);
    }

    public void gotoNewContactPage(String s) {
        click(By.linkText(s));
    }

    public void initContactModification(String edit){
        click(By.xpath(edit));
    }

    public void submitContactModification(String update){
        click(By.xpath(update));
    }

    public void selectContact() {
        click(By.id("6"));
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
