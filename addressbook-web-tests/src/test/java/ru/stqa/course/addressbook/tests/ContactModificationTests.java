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
        if ( app.db().contacts().size() == 0 ) {
            app.contact().create(new ContactData().withFirstname("Irok").withLastname("Test").withEmail("test@gmail.com").withGroup("test1"),true);
        }
    }

    @Test
    public void ContactModification() {
        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact =  new ContactData()
                .withId(modifiedContact.getId()).withFirstname("Irok1").withLastname("Test2").withEmail("test3@gmail.com")
                .withHomePhone("111").withMobilePhone("222").withWorkPhone("333")
                .withHomeAddress("").withSecondaryAddress("").withTwoEmail("").withThreeEmail("");
        app.contact().modify(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }
}
