package ru.stqa.course.addressbook;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import org.openqa.selenium.*;

public class AddNewUser {
  private WebDriver wd;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
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

  @Test
  public void testUserCreation() throws Exception {
    gotoNewUserPage("add new");
    fillUserForm(new UserData("Irok", "Test", "test@gmail.com"));
    submitUserCreation(By.xpath("(//input[@name='submit'])[2]"));
    returnToHomePage("home page");
    logout("Logout");
  }

  private void logout(String logout) {
    wd.findElement(By.linkText(logout)).click();
  }

  private void fillUserForm(UserData userData) {
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

  private void submitUserCreation(By xpath) {
    wd.findElement(xpath).click();
  }

  private void returnToHomePage(String s) {
    wd.findElement(By.linkText(s)).click();
  }

  private void gotoNewUserPage(String s) {
    wd.findElement(By.linkText(s)).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
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

}
