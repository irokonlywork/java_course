package ru.stqa.course.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationHelper {
    private ChromeDriver wd;

    public NavigationHelper(ChromeDriver wd) {
        this.wd = wd;
    }

    public void gotoGroupPage(String groups) {
      wd.findElement(By.linkText(groups)).click();
    }
}