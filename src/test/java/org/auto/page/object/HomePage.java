package org.auto.page.object;

import com.fasterxml.jackson.databind.ser.Serializers;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    public HomePage(AndroidDriver<AndroidElement> driver){
        super(driver);
    }

    @AndroidFindBy( xpath = "//android.widget.TextView[@text='OS']")
    private AndroidElement osMenu;

    @AndroidFindBy( xpath = "//android.widget.TextView[@text='SMS Messaging']")
    private AndroidElement smsMessagingOption;

    public void clickOnOsMenu(){

        isElementVisible(this.osMenu, 4);
        this.osMenu.click();;
    }

    public void clickOnSmsOption(){

        isElementVisible(this.osMenu, 4);
        this.smsMessagingOption.click();

    }
}
