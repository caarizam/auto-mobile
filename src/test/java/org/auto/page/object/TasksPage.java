package org.auto.page.object;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.auto.common.Common;

public class TasksPage extends BasePage {

    public TasksPage(AndroidDriver driver){
        super(driver);
    }

    @AndroidFindBy( uiAutomator = "new UiSelector().description(\"Navigate up\")")
    private WebElement closeButton;

    @AndroidFindBy( className = "bi")
    private WebElement titleLabel;

    @AndroidFindBy( id = "userToDoEditText")
    private WebElement editTitle;

    @AndroidFindBy( id = "makeToDoFloatingActionButton")
    private WebElement createToDoButton;

    @AndroidFindBy( id = "toDoHasDateSwitchCompat")
    private WebElement remindMeSwitchButton;

    @AndroidFindBy( id = "userToDoRemindMeTextView")
    private WebElement remindMeLabel;

    @AndroidFindBy( id = "newTodoDateEditText")
    private WebElement dateCalendarEdit;
    //ok
    @AndroidFindBy( xpath = "//android.widget.Button[@text='CANCEL']")
    private WebElement dateCalendarCancel;
    //cancel
    @AndroidFindBy( xpath = "//android.widget.Button[@text='OK']")
    private WebElement dateCalendaOk;


    @AndroidFindBy( id = "newTodoTimeEditText")
    private WebElement dateTimeEdit;
    //ok
    @AndroidFindBy( xpath = "//android.widget.Button[@text='CANCEL']")
    private WebElement dateTimeEditCancel;
    //cancel
    @AndroidFindBy( xpath = "//android.widget.Button[@text='OK']")
    private WebElement dateTimeEditOk;


    @AndroidFindBy( id = "newToDoDateTimeReminderTextView")
    private WebElement messagesConfirmationLabel;

    /**
     * This method add a ToDo note
     * @param nameToDo String name of the note to add
     * @param switchReminder boolean that switch if it need a reminder or not
     */
    public void addSimpleToDo(String nameToDo, boolean switchReminder){

        if(isElementVisible(titleLabel, LONG_TIME_WAIT, "Add button is no visisble", true)){
            Common.getInstance().takeScreenShot();
            editTitle.click();
            editTitle.clear();
            editTitle.sendKeys(nameToDo);
            this.driver.hideKeyboard();

            if(switchReminder){
                remindMeSwitchButton.click();
                isElementVisible(remindMeLabel, MID_TIME_WAIT, "Switch reminder is no visible", true);
            }

            Common.getInstance().takeScreenShot();
            createToDoButton.click();
        }



    }

}
