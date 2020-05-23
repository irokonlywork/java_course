package ru.stqa.course.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.gotoGroupPage("groups");
    app.selectGroup("selected[]");
    app.deleteSelectedGroups("delete");
    app.returnToGroupPage();
  }

}
