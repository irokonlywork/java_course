package ru.stqa.course.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.course.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void ContactModification() {
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("Irok", "Test", "test@gmail.com"));
        app.getContactHelper().submitContactModification();
        app.returnToHomePage();
    }
}
