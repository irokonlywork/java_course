package ru.stqa.course.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.course.addressbook.model.ContactData;
import ru.stqa.course.addressbook.model.GroupData;

import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.not;
import static java.util.stream.Collectors.toSet;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class RemoveContactFromGroupTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.contact().create(new ContactData().withFirstname("Irok").withLastname("Test"), true);
        }

        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test"));
        }

        if (app.db().groups().stream().filter(g -> !g.getContacts().isEmpty()).collect(toSet()).isEmpty()) {
            GroupData group = app.db().groups().iterator().next();
            ContactData contact = app.db().contacts().iterator().next();
            app.contact().addToGroup(contact, group);
        }
    }

    @Test
    public void testRemoveContactFromGroup() {
        app.goTo().HomePage();
        GroupData group = app.db().groups().
                stream().filter(g -> !g.getContacts().isEmpty()).collect(toSet()).iterator().next();
        ContactData contact = app.db().contacts().
                stream().filter(c -> c.getGroups().contains(group)).collect(toSet()).iterator().next();
        app.contact().removeFromGroup(contact, group);

        int contactId = contact.getId();
        contact = app.db().contacts().
                stream().filter(c -> (c.getId() == contactId)).collect(Collectors.toSet()).
                iterator().next();
        assertThat(contact.getGroups(), not(contains(group)));
    }
}

