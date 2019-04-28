package org.auto.steps.definition;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import org.auto.common.Common;
import org.auto.page.object.AddToDoPage;
import org.auto.page.object.HomePage;
import org.auto.setup.Configurations;
import org.junit.Assert;

public class AddNotesSteps {

    AndroidDriver driver;
    HomePage homePage;
    AddToDoPage addPage;

    public AddNotesSteps(){

    }

    @Before
    public void initValues(){
        Configurations config = Common.getInstance().getConfigurations("emulator-554", "http://127.0.0.1:4723/wd/hub");
        this.driver = Common.getInstance().getDriver();
        homePage = new HomePage(this.driver);
        addPage = new AddToDoPage(this.driver);
    }


    @Given("^the access to the application$")
    public void theAccessToTheApplication() {
        this.driver.launchApp();
        Common.getInstance().takeScreenShot();

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

        Assert.assertEquals("The item with value " + nameToDo + " was not found", checkItem, expected);

    }

    @After
    public void closeApp(){

        //this.driver.closeApp();

    }


}
