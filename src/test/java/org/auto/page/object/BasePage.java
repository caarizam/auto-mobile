package org.auto.page.object;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriverWait wait;
    protected AndroidDriver<AndroidElement> driver;

    public BasePage(AndroidDriver<AndroidElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
    }

    public boolean isElementVisible(AndroidElement androidElement, int timeOut){
        try{
            wait = new WebDriverWait(this.driver, timeOut);
            wait.until(ExpectedConditions.visibilityOf(androidElement));
            return true;
        }catch (Exception ex){
            return false;
        }
    }

}
