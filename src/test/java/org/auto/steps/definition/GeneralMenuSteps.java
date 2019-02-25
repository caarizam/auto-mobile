package org.auto.steps.definition;

import io.appium.java_client.android.AndroidDriver;
import org.auto.page.object.HomePage;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.auto.page.object.SmsMessagingPage;
import org.openqa.selenium.support.PageFactory;

public class GeneralMenuSteps {

    HomePage homePage;
    SmsMessagingPage smsMessaging;
    AndroidDriver driver;

    public GeneralMenuSteps(AndroidDriver driver){
        this.driver = driver;
    }

    public void goToOsMenu(){

        homePage = new HomePage(this.driver);

        homePage.clickOnOsMenu();

        homePage.clickOnSmsOption();




    }

    public void sendSms(boolean enableReceiver, String recipient, String message){
        smsMessaging = new SmsMessagingPage(this.driver);

        smsMessaging.sendSms(enableReceiver, recipient, message);
    }

}
