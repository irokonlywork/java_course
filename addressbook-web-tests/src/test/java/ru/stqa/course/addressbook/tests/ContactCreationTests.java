package ru.stqa.course.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.course.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().gotoNewContactPage("add new");
    app.getContactHelper().fillContactForm(new ContactData("Irok", "Test", "test@gmail.com"));
    app.getContactHelper().submitContactCreation(By.xpath("(//input[@name='submit'])[2]"));
    app.returnToHomePage("home page");
    app.logout("Logout");
  }

}
