package ru.stqa.course.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.course.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase {

    @Test (enabled = true)
    public void testContactAddress() {
        app.goTo().HomePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAllAddresses(), equalTo(mergeAddresses(contactInfoFromEditForm)));
    }

    private <T> String mergeAddresses(ContactData contact) {
        return Arrays.asList(contact.getHomeAddress(), contact.getSecondaryAddress())
                .stream().filter((s) -> ! s.equals("")) //отбрасывание пустых строк
                .map(ContactAddressTests::cleaned) //применение функции очистки строк (и возвращение потока состоящего из результатов)
                .collect(Collectors.joining("\n")); // склеивание
    }

    private static <R> String cleaned(String address) {
        return address.replaceAll("\\s", "").replaceAll("[-()+]", "");
    }

}
