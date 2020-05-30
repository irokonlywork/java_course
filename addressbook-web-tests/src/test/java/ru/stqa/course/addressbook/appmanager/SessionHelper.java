package ru.stqa.course.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String user, String username, String pass, String password, By xpath) {
        type(By.name(user), username);
        type(By.name(pass), password);
        click(xpath);
    }
}
