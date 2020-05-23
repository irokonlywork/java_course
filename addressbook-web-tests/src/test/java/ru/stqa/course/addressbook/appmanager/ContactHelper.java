package ru.stqa.course.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.course.addressbook.model.UserData;

public class ContactHelper extends HelperBase {

    public ContactHelper(ChromeDriver wd) {
        super(wd);
    }

    public void fillContactForm(UserData userData) {
        type(By.name("firstname"), userData.getFirstname());
        type(By.name("lastname"), userData.getLastname());
        type(By.name("email"), userData.getEmail());
    }

    public void submitContactCreation(By xpath) {
        click(xpath);
    }

    public void gotoNewContactPage(String s) {
        click(By.linkText(s));
    }
}
