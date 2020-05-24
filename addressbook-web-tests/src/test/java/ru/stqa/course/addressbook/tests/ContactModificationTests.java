package ru.stqa.course.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.course.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void ContactModification() {
        app.getContactHelper().initContactModification("//img[@alt='Edit']");
        app.getContactHelper().fillContactForm(new ContactData("Irok", "Test", "test@gmail.com"));
        app.getContactHelper().submitContactModification("(//input[@name='update'])[2]");
        app.returnToHomePage("home page");
    }
}
