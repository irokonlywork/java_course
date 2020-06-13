package ru.stqa.course.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;

    private ContactHelper contactHelper;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if ( browser.equals(BrowserType.CHROME) ) {
            wd = new ChromeDriver();
        } else if ( browser.equals(BrowserType.FIREFOX) ) {
            wd = new FirefoxDriver();
        } else if ( browser.equals(BrowserType.SAFARI) ) {
            wd = new SafariDriver();
        }
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        wd.get("https://localhost/addressbook/index.php");
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        contactHelper = new ContactHelper(wd);
        sessionHelper.login("user", "admin", "pass", "secret", By.xpath("//input[@value='Login']"));
    }

    public void stop() {
        wd.quit();
    }

    public void logout() {
        click(By.linkText("Logout"));
    }

    private void click(By locator) {
        wd.findElement(locator).click();
    }



    public GroupHelper group() {
        return groupHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}
