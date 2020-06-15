package ru.stqa.course.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.course.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if ( app.contact().all().size() == 0 ) {
            app.contact().create(new ContactData().withFirstname("Irok").withLastname("Test").withEmail("test@gmail.com")
                    .withGroup("test1").withHomePhone("7 985 190 33 33").withMobilePhone("7 995-193-44-15").withWorkPhone("7 (910) 290 34 15"),true);
        }
    }

    @Test
    public void testContactPhones() {
        app.goTo().gotoHomePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    }

    private <T> String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
                .stream().filter((s) -> ! s.equals("")) //отбрасывание пустых строк
                .map(ContactPhoneTests::cleaned) //применение функции очистки строк (и возвращение потока состоящего из результатов)
                .collect(Collectors.joining("\n")); // склеивание

    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()+]", "");
    }
}