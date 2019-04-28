package org.auto.page.object;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.auto.common.Common;

public class AddToDoPage extends BasePage {

    public AddToDoPage(AndroidDriver<AndroidElement> driver){
        super(driver);
    }

    @AndroidFindBy( uiAutomator = "new UiSelector().description(\"Navigate up\")")
    private AndroidElement closeButton;

    @AndroidFindBy( className = "bi")
    private AndroidElement titleLabel;

    @AndroidFindBy( id = "userToDoEditText")
    private AndroidElement editTitle;

    @AndroidFindBy( id = "makeToDoFloatingActionButton")
    private AndroidElement createToDoButton;

    @AndroidFindBy( id = "toDoHasDateSwitchCompat")
    private AndroidElement remindMeSwitchButton;

    @AndroidFindBy( id = "userToDoRemindMeTextView")
    private AndroidElement remindMeLabel;

    @AndroidFindBy( id = "newTodoDateEditText")
    private AndroidElement dateCalendarEdit;
    //ok
    @AndroidFindBy( xpath = "//android.widget.Button[@text='CANCEL']")
    private AndroidElement dateCalendarCancel;
    //cancel
    @AndroidFindBy( xpath = "//android.widget.Button[@text='OK']")
    private AndroidElement dateCalendaOk;


    @AndroidFindBy( id = "newTodoTimeEditText")
    private AndroidElement dateTimeEdit;
    //ok
    @AndroidFindBy( xpath = "//android.widget.Button[@text='CANCEL']")
    private AndroidElement dateTimeEditCancel;
    //cancel
    @AndroidFindBy( xpath = "//android.widget.Button[@text='OK']")
    private AndroidElement dateTimeEditOk;


    @AndroidFindBy( id = "newToDoDateTimeReminderTextView")
    private AndroidElement messagesConfirmationLabel;

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
