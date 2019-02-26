package org.auto.steps.definition;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.auto.common.Common;
import org.auto.page.object.HomePage;
import org.auto.page.object.SendMessagePage;
import org.junit.Assert;

public class SendMessageSteps {

    HomePage homePage;
    SendMessagePage smsMessaging;
    AndroidDriver driver;

    public SendMessageSteps(AndroidDriver driver){
        this.driver = driver;
    }

    @Step("Go to SMS Option")
    public void goToOsMenu(){

        homePage = new HomePage(this.driver);
        homePage.clickOnOsMenu();
        homePage.clickOnSmsOption();
        Common.getInstance().takeScreenShot();

    }

    @Step("Send a message \"{message}\" to the recipient \"{recipient}\"")
    public void sendSms(boolean enableReceiver, String recipient, String message, String confirmation){
        String tmpText;

        smsMessaging = new SendMessagePage(this.driver);

        tmpText = smsMessaging.sendSms(enableReceiver, recipient, message);
        Common.getInstance().takeScreenShot();
        Assert.assertEquals(confirmation, tmpText);
    }

}
