package org.auto.page.object;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class SmsMessagingPage extends BasePage{

    public SmsMessagingPage(AndroidDriver<AndroidElement> driver){
        super(driver);
    }

    @AndroidFindBy( id = "sms_enable_receiver")
    private AndroidElement enableReceiverCheckbox;

    @AndroidFindBy( id = "sms_recipient")
    private AndroidElement recipientTextField;

    @AndroidFindBy( id = "sms_content")
    private AndroidElement messageBodyTextField;

    @AndroidFindBy( xpath = "sms_send_message")
    private AndroidElement sendButton;

    public void sendSms(boolean enableReceiver, String recipient, String message){

        isElementVisible(this.enableReceiverCheckbox, 5);

        if(enableReceiver){
            this.enableReceiverCheckbox.click();
        }

        this.recipientTextField.sendKeys(recipient);
        this.messageBodyTextField.sendKeys(message);

        this.driver.hideKeyboard();

        this.sendButton.click();

    }

}
