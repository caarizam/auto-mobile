package org.auto.tests;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.*;
import org.auto.common.Common;
import org.auto.setup.Configurations;
import org.auto.steps.definition.PreferencesSteps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@Epic("Testing basic menus")
@Feature("Setting up basic preferences")
public class PreferencesTest {

    Configurations config;
    AndroidDriver driver;
    PreferencesSteps preferencesSteps;

    @Before
    public void setUp(){
        config = new Configurations("emulator-554", "src/test/resources/app", "http://127.0.0.1:4723/wd/hub", "app.apk");
        driver = config.getDriver();
        preferencesSteps = new PreferencesSteps(this.driver);
        Common.getInstance().setDriver(this.driver);
    }

    @Test
    @Story("Basic flow navigation and set preferences")
    @Description("Navigate through the pages and setting up preferences")
    @Severity(SeverityLevel.NORMAL)
    public void basicFlowAndPreferences(){

        preferencesSteps.goToPreferences();
        preferencesSteps.setDependencies(true, "basic-setting", true);

        Common.getInstance().goBackButton();

        preferencesSteps.goToFragmentSection();
        preferencesSteps.setFragmentOptions();

    }

    @After
    public void afterTest(){
        Common.getInstance().quitDriver();
    }

}
