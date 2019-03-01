package org.auto.steps.definition;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.auto.common.Common;
import org.auto.page.object.AddToDoPage;
import org.auto.page.object.HomePage;
import org.auto.setup.Configurations;
import org.junit.Assert;

public class RemoveSteps {

    AndroidDriver driver;
    HomePage homePage;

    public void RemoveSteps(){
        System.out.println("Constructor RemoveSteps");
        Configurations config = Common.getInstance().getConfigurations("emulator-554", "http://127.0.0.1:4723/wd/hub");
        this.driver = Common.getInstance().getDriver();
        homePage = new HomePage(this.driver);
    }

    @And("^the user search and delete the note with name \"([^\"]*)\" and reminder switch to \"([^\"]*)\"$")
    public void theUserSearchAndDeleteTheNoteWithNameAndReminderSwitchTo(String nameToDo, boolean switchReminder) {

        System.out.println("Step And the user search and delete " + nameToDo);
        AndroidElement elementToRemove = homePage.getListToDosElement(nameToDo, switchReminder);

        if(elementToRemove != null){

            homePage.removeElement(elementToRemove);
            boolean checkItem = homePage.getListToDos(nameToDo, switchReminder);
            Assert.assertEquals("The item with value \"" + nameToDo + "\" was not removed", false, checkItem);

        }else{
            Assert.assertTrue("The item with value \"" + nameToDo + "\" was not found", false);
        }

    }
}
