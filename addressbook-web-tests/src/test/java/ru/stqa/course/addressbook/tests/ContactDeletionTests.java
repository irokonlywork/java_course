package ru.stqa.course.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.course.addressbook.model.ContactData;
import ru.stqa.course.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if ( app.db().contacts().size() == 0 ) {
            app.contact().create(new ContactData().withFirstname("Irok").withLastname("Test").withEmail("test@gmail.com"),true);
        }
    }

    @Test
    public void testContactDeletion() {
        Contacts before = app.db().contacts();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Contacts after = app.db().contacts();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(deletedContact);
        assertThat(after, equalTo(before.without(deletedContact)));
            Assert.assertEquals(before, after);
        verifyContactListInUI();
    }
}

