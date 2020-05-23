package ru.stqa.course.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.course.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {

    public GroupHelper(ChromeDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        click(By.linkText("Logout"));
    }

    public void submitGroupCreation(String s) {
        click(By.linkText(s));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
        click(By.name("submit"));
    }

    public void initGroupCreation(String s) {
        click(By.name(s));
    }

    public void deleteSelectedGroups(String delete) {
        click(By.name(delete));
    }

    public void selectGroup(String s) {
        click(By.name(s));
    }
}
