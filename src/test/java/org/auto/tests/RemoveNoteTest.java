package org.auto.tests;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.*;
import org.auto.common.Common;
import org.auto.setup.Configurations;
import org.auto.steps.definition.AddMinimalToDoSteps;
import org.auto.steps.definition.RemoveNoteSteps;
import org.junit.Before;
import org.junit.Test;

@Epic("Removing Notes")
@Feature("Removing Notes")
public class RemoveNoteTest {

    Configurations config;
    AndroidDriver driver;
    AddMinimalToDoSteps addSteps;
    RemoveNoteSteps removeSteps;

    @Before
    public void setUp(){
        System.out.println("Before setUp");
        config = Common.getInstance().getConfigurations("emulator-554", "http://127.0.0.1:4723/wd/hub");
        this.driver = Common.getInstance().getDriver();
        addSteps = new AddMinimalToDoSteps(this.driver);
        removeSteps = new RemoveNoteSteps(this.driver);
    }

    @Test
    @Story("Adding a note and removing a note")
    @Description("Adding a basic ToDo note, check if the note was added, remove the note and check if it was removed")
    @Severity(SeverityLevel.NORMAL)
    public void addAndRemoveNote(){

        config.launchApp();
        addSteps.goToAddToDoNote();
        addSteps.addSimpleToDoNote("Old note-remove", true);
        removeSteps.getAndRemoveNote("Old note-remove", true);
        config.closeDriver();

    }
}
