package org.auto.test.runner;

/*import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.*;
import org.auto.common.Common;
import org.auto.setup.Configurations;
import org.auto.steps.definition.AddMinimalToDoStepsBack;
import org.junit.*;

@Epic("Adding Notes")
@Feature("Adding Notes")*/
public class AddMinimalToDoTest {

    /*Configurations config;
    AndroidDriver driver;
    AddMinimalToDoStepsBack addSteps;

    @Before
    public void setUp(){
        System.out.println("Before setUp");
        config = Common.getInstance().getConfigurations("emulator-554", "http://127.0.0.1:4723/wd/hub");
        this.driver = Common.getInstance().getDriver();
        addSteps = new AddMinimalToDoStepsBack(this.driver);
    }

    @Test
    @Story("Adding basic ToDo Note")
    @Description("Adding a basic ToDo Note without reminder")
    @Severity(SeverityLevel.NORMAL)
    public void addSimpleToDoNote(){

        config.launchApp();
        addSteps.goToAddToDoNote();
        addSteps.addSimpleToDoNote("Basic Note", false);
        addSteps.checkListToDos("Basic Note", false);
        config.closeDriver();

    }

    @Test
    @Story("Adding basic ToDo Note with default reminder")
    @Description("Adding a basic ToDo Note with default Date and Time reminder")
    @Severity(SeverityLevel.NORMAL)
    public void addToDoNoteWithDefaultReminder(){

        config.launchApp();
        addSteps.goToAddToDoNote();
        addSteps.addSimpleToDoNote("Meeting on Monday with Kate", true);
        addSteps.checkListToDos("Meeting on Monday with Kate", true);
        config.closeDriver();

    }*/

}
