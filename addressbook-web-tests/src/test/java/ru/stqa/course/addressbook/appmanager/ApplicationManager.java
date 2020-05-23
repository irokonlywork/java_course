package ru.stqa.course.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.course.addressbook.model.GroupData;
import ru.stqa.course.addressbook.model.UserData;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private WebDriver wd;

    public void init() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("https://localhost/addressbook/index.php");
        login("user", "admin", "pass", "secret", By.xpath("//input[@value='Login']"));
    }

    private void login(String user, String username, String pass, String password, By xpath) {
      wd.findElement(By.name(user)).clear();
      wd.findElement(By.name(user)).sendKeys(username);
      wd.findElement(By.name(pass)).click();
      wd.findElement(By.name(pass)).clear();
      wd.findElement(By.name(pass)).sendKeys(password);
      wd.findElement(xpath).click();
    }

    public void returnToGroupPage() {
      wd.findElement(By.linkText("Logout")).click();
    }

    public void submitGroupCreation(String s) {
      wd.findElement(By.linkText(s)).click();
    }

    public void fillGroupForm(GroupData groupData) {
      wd.findElement(By.name("group_name")).click();
      wd.findElement(By.name("group_name")).clear();
      wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
      wd.findElement(By.name("group_header")).click();
      wd.findElement(By.name("group_header")).clear();
      wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
      wd.findElement(By.name("group_footer")).click();
      wd.findElement(By.name("group_footer")).clear();
      wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
      wd.findElement(By.name("submit")).click();
    }

    public void initGroupCreation(String s) {
      wd.findElement(By.name(s)).click();
    }

    public void gotoGroupPage(String groups) {
      wd.findElement(By.linkText(groups)).click();
    }

    public void stop() {
        wd.quit();
    }

    private boolean isElementPresent(By by) {
      try {
        wd.findElement(by);
        return true;
      } catch (NoSuchElementException e) {
        return false;
      }
    }

    private boolean isAlertPresent() {
      try {
        wd.switchTo().alert();
        return true;
      } catch (NoAlertPresentException e) {
        return false;
      }
    }

    public void deleteSelectedGroups(String delete) {
      wd.findElement(By.name(delete)).click();
    }

    public void selectGroup(String s) {
      wd.findElement(By.name(s)).click();
    }

    public void logout(String logout) {
      wd.findElement(By.linkText(logout)).click();
    }

    public void fillUserForm(UserData userData) {
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

    public void submitUserCreation(By xpath) {
      wd.findElement(xpath).click();
    }

    public void returnToHomePage(String s) {
      wd.findElement(By.linkText(s)).click();
    }

    public void gotoNewUserPage(String s) {
      wd.findElement(By.linkText(s)).click();
    }
}
