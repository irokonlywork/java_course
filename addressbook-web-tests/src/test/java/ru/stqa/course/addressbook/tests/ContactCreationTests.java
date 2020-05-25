package ru.stqa.course.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.course.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().gotoNewContactPage();
    app.getContactHelper().fillContactForm(new ContactData("Irok", "Test", "test@gmail.com"));
    app.getContactHelper().submitContactCreation();
    app.returnToHomePage();
  }

}
