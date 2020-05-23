package ru.stqa.course.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(ChromeDriver wd) {
        super(wd);
    }

    public void gotoGroupPage(String groups) {
      click(By.linkText(groups));
    }
}
