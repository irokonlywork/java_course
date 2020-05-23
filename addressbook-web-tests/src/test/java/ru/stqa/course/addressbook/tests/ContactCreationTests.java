package ru.stqa.course.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.course.addressbook.model.UserData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testUserCreation() throws Exception {
    app.getContactHelper().gotoNewContactPage("add new");
    app.getContactHelper().fillContactForm(new UserData("Irok", "Test", "test@gmail.com"));
    app.getContactHelper().submitContactCreation(By.xpath("(//input[@name='submit'])[2]"));
    app.returnToHomePage("home page");
    app.logout("Logout");
  }

}
