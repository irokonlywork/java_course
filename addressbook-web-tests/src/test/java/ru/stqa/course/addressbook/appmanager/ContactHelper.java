package ru.stqa.course.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.course.addressbook.model.UserData;

public class ContactHelper {

    private ChromeDriver wd;

    public ContactHelper(ChromeDriver wd) {

        this.wd = wd;
    }

    public void fillContactForm(UserData userData) {
      wd.findElement(By.name("firstname")).click();
      wd.findElement(By.name("firstname")).clear();
      wd.findElement(By.name("firstname")).sendKeys(userData.getFirstname());
      wd.findElement(By.name("lastname")).click();
      wd.findElement(By.name("lastname")).clear();
      wd.findElement(By.name("lastname")).sendKeys(userData.getLastname());
      wd.findElement(By.name("email")).click();
      wd.findElement(By.name("email")).clear();
      wd.findElement(By.name("email")).sendKeys(userData.getEmail());
    }

    public void submitContactCreation(By xpath) {
      wd.findElement(xpath).click();
    }

    public void gotoNewContactPage(String s) {
      wd.findElement(By.linkText(s)).click();
    }
}
