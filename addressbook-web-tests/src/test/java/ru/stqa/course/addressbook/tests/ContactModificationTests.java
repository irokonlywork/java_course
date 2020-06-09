package ru.stqa.course.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.course.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void ContactModification() {
        if (! app.getContactHelper().isThereAContact() ) {
            app.getContactHelper().createContact(new ContactData("Irok", "Test", "test@gmail.com", "test1"),true);
        }
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("Irok1", "Test2", "test@gmail.com", null), false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().gotoHomePage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before);
    }
}
