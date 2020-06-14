package ru.stqa.course.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.course.addressbook.model.ContactData;
import ru.stqa.course.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if ( app.contact().all().size() == 0 ) {
            app.contact().create(new ContactData().withFirstname("Irok").withLastname("Test").withEmail("test@gmail.com").withGroup("test1"),true);
        }
    }

    @Test
    public void ContactModification() {
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact =  new ContactData()
                .withId(modifiedContact.getId()).withFirstname("Irok1").withLastname("Test2").withEmail("test@gmail.com");
        app.contact().modify(contact);
        Contacts after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }
}
