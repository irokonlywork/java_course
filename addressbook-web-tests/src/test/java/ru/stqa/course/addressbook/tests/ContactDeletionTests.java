package ru.stqa.course.addressbook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().selectAlert();
        app.getContactHelper().switchTo();

    }
}

