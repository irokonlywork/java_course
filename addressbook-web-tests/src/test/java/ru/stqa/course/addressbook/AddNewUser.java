package ru.stqa.course.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AddNewUser extends TestBase {

  @Test
  public void testUserCreation() throws Exception {
    gotoNewUserPage("add new");
    fillUserForm(new UserData("Irok", "Test", "test@gmail.com"));
    submitUserCreation(By.xpath("(//input[@name='submit'])[2]"));
    returnToHomePage("home page");
    logout("Logout");
  }

}
