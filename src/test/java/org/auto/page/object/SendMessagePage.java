package org.auto.page.object;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.auto.common.Common;

public class SendMessagePage extends BasePage{

    public SendMessagePage(AndroidDriver<AndroidElement> driver){
        super(driver);
    }

    @AndroidFindBy( id = "sms_enable_receiver")
    private AndroidElement enableReceiverCheckbox;

    @AndroidFindBy( id = "sms_recipient")
    private AndroidElement recipientTextField;

    @AndroidFindBy( id = "sms_content")
    private AndroidElement messageBodyTextField;

    @AndroidFindBy( id = "sms_send_message")
    private AndroidElement sendButton;

    @AndroidFindBy( id = "sms_status")
    private AndroidElement smsStatusLabel;

    public String sendSms(boolean enableReceiver, String recipient, String message){

        String tmpText = "no message";
        isElementVisible(this.enableReceiverCheckbox, LONG_TIME_WAIT);

        if(enableReceiver && !this.enableReceiverCheckbox.isSelected()){
            this.enableReceiverCheckbox.click();
        }else if(!enableReceiver && this.enableReceiverCheckbox.isSelected()){
            this.enableReceiverCheckbox.click();
        }

        this.recipientTextField.sendKeys(recipient);
        this.messageBodyTextField.sendKeys(message);

        this.driver.hideKeyboard();

        Common.getInstance().takeScreenShot();

        this.sendButton.click();

        isElementVisible(this.smsStatusLabel, LONG_TIME_WAIT);

        tmpText = this.smsStatusLabel.getText();

        return tmpText;
    }

}
