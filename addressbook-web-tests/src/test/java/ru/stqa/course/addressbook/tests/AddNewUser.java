package ru.stqa.course.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.course.addressbook.model.UserData;

public class AddNewUser extends TestBase {

  @Test
  public void testUserCreation() throws Exception {
    app.gotoNewUserPage("add new");
    app.fillUserForm(new UserData("Irok", "Test", "test@gmail.com"));
    app.submitUserCreation(By.xpath("(//input[@name='submit'])[2]"));
    app.returnToHomePage("home page");
    app.logout("Logout");
  }

}
