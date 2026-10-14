package org.auto.steps.definition;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.auto.common.Common;
import org.auto.page.object.TasksPage;
import org.auto.page.object.HomePage;
import org.auto.setup.Configurations;
import org.junit.jupiter.api.Assertions;

public class TasksSteps {

    AndroidDriver driver;
    Configurations config;
    HomePage homePage;
    TasksPage addPage;

    public TasksSteps(){

    }

    @Before
    public void initValues(){
        this.config = Common.getInstance().getConfigurations("emulator-5554", "http://127.0.0.1:4723");
        this.driver = Common.getInstance().getDriver();
        homePage = new HomePage(this.driver);
        addPage = new TasksPage(this.driver);
    }


    @Given("^the access to the application$")
    public void theAccessToTheApplication() {
        this.config.launchApp();
        Common.getInstance().takeScreenShot();
        homePage.loginAction("test@example.com", "123456789");
    }

    @When("^a user add the note with title \"([^\"]*)\" and reminder switch to \"([^\"]*)\"$")
    public void aUserAddTheNoteWithAndSwitch(String nameToDo, boolean switchReminder) {
        homePage.clickOnAddButton();
        addPage.addSimpleToDo(nameToDo, switchReminder);

    }

    @Then("^the user \"([^\"]*)\" see that \"([^\"]*)\" with reminder set to \"([^\"]*)\" in the home page list$")
    public void theUserCanSeeThatWithReminderSetToInTheHomePageList(String isVisible, String nameToDo, boolean dateTime) {
        boolean expected = Common.getInstance().getExpected(isVisible);
        boolean checkItem = homePage.getListToDos(nameToDo, dateTime);

        Assertions.assertEquals(expected, checkItem, "The item with value " + nameToDo + " was not found");

    }

    @After
    public void closeApp(){

        //this.driver.closeApp();

    }


}
