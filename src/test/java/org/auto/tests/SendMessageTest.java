package org.auto.tests;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.*;
import org.auto.common.Common;
import org.auto.setup.Configurations;
import org.auto.steps.definition.SendMessageSteps;
import org.junit.Before;
import org.junit.Test;


@Epic("Testing basic menus")
@Feature("Sending a message")
public class SendMessageTest {

    Configurations config;
    AndroidDriver driver;
    SendMessageSteps generalSteps;

    @Before
    public void setUp(){
        config = new Configurations("emulator-554", "src/test/resources/app", "http://127.0.0.1:4723/wd/hub", "app.apk");
        driver = config.getDriver();
        generalSteps = new SendMessageSteps(driver);
        Common.getInstance().setDriver(this.driver);
    }

    @Test
    @Story("Navigate to message option and send a message")
    @Description("Send a text message with a recipient")
    @Severity(SeverityLevel.BLOCKER)
    public void sendSmsWithRecipient(){

        generalSteps.goToOsMenu();
        generalSteps.sendSms(true, "3214567", "Meeting at 5PM", "Message sent!");


    }

    @Test
    @Story("Navigate to message option and try to send a message without recipient")
    @Description("Send a text message without recipient")
    @Severity(SeverityLevel.BLOCKER)
    public void sendSmsWithoutRecipient(){

        generalSteps.goToOsMenu();
        generalSteps.sendSms(true, "", "Meeting at 9PM", "Message sent!");


    }

}
