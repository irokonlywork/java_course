package ru.stqa.course.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.course.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {

    @Test
    public void GroupModification() {
        app.getNavigationHelper().gotoGroupPage("groups");
        app.getGroupHelper().selectGroup("selected[]");
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
    }
}
