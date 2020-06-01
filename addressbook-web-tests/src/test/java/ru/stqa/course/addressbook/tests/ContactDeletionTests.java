package ru.stqa.course.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.course.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        if (! app.getContactHelper().isThereAContact() ) {
            app.getContactHelper().createContact(new ContactData("Irok", "Test", "test@gmail.com", "test1"),true);
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().selectAlert();
        app.getContactHelper().switchTo();

    }
}

