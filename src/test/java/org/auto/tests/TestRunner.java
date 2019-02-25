package org.auto.tests;

import io.appium.java_client.android.AndroidDriver;
import org.auto.setup.Configurations;
import org.auto.steps.definition.GeneralMenuSteps;
import org.junit.Before;
import org.junit.Test;

public class TestRunner {

    Configurations config;
    AndroidDriver driver;
    GeneralMenuSteps generalSteps;

    @Before
    public void setUp(){
        config = new Configurations("emulator-554", "C:/dev/java_projects/auto-mobile/src/test/resources/app", "http://127.0.0.1:4723/wd/hub", "app.apk");
        driver = config.getDriver();
        generalSteps = new GeneralMenuSteps(driver);
    }

    @Test
    public void test(){

        generalSteps.goToOsMenu();
        generalSteps.sendSms(true, "3214567", "Meeting at 5PM");

    }

}
