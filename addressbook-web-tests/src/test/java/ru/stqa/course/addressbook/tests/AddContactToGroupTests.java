package ru.stqa.course.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.course.addressbook.model.ContactData;
import ru.stqa.course.addressbook.model.GroupData;
import ru.stqa.course.addressbook.model.Groups;

import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class AddContactToGroupTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if ( app.db().contacts().stream().filter(e -> (e.getGroups().isEmpty())).collect(Collectors.toSet()).size() == 0 ) {
            app.contact().create(new ContactData().withFirstname("Irok").withLastname("Test"), true);
        }

        if ( app.db().groups().size() == 0 ) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test"));
        }
    }


    @Test
    public void testAddContactToGroup() {
        app.goTo().HomePage();
        Groups groups = app.db().groups();
        GroupData group = groups.iterator().next();
        ContactData contact = app.db().contacts().
                stream().filter(c -> (c.getGroups().isEmpty())).collect(Collectors.toSet()).
                iterator().next();
        app.contact().addToGroup(contact, group);
        app.goTo().HomePage();
        int contactId = contact.getId();
        contact = app.db().contacts().
                stream().filter(c -> (c.getId() == contactId)).collect(Collectors.toSet()).iterator().next();
        assertThat(contact.getGroups(), contains(group));
    }
}
