package ru.stqa.course.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.course.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.gotoGroupPage("groups");
    app.initGroupCreation("new");
    app.fillGroupForm(new GroupData("test1", "test2", "test3"));
    app.submitGroupCreation("group page");
    app.returnToGroupPage();
  }

}
