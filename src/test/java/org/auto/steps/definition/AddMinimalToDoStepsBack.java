package org.auto.steps.definition;

import io.appium.java_client.android.AndroidDriver;
//import io.qameta.allure.Step;
import org.auto.common.Common;
import org.auto.page.object.AddToDoPage;
import org.auto.page.object.HomePage;
import org.junit.Assert;

public class AddMinimalToDoStepsBack {

    /*AndroidDriver driver;
    HomePage homePage;
    AddToDoPage addPage;


    public AddMinimalToDoStepsBack(AndroidDriver driver){

        this.driver = driver;
        homePage = new HomePage(this.driver);
        addPage = new AddToDoPage(this.driver);
    }

    @Step("Go to screen Add ToDo Note")
    public void goToAddToDoNote(){
        Common.getInstance().takeScreenShot();
        homePage.clickOnAddButton();
    }

    @Step("Add Simple ToDo Note with Title \"{nameToDo}\" and reminder set to \"{switchReminder}\"")
    public void addSimpleToDoNote(String nameToDo, boolean switchReminder){

        addPage.addSimpleToDo(nameToDo, switchReminder);

    }

    @Step("Check if the item was added")
    public void checkListToDos(String nameToDo, boolean dateTime){

        boolean checkItem = homePage.getListToDos(nameToDo, dateTime);
        Assert.assertTrue("The item with value " + nameToDo + " was not found", checkItem);

    }*/

}
