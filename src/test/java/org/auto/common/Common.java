package org.auto.common;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;

public class Common {

    private static Common instance;

    private Common(){}

    private AndroidDriver<AndroidElement> driver;


    public static Common getInstance() {
        if (instance == null) {
            instance = new Common();
        }
        return instance;
    }

    @Attachment(value = "Screenshot evidence", type = "image/jpg")
    public byte[] takeScreenShot(){
        try{
            byte[] screenShot = driver.getScreenshotAs(OutputType.BYTES);
            return screenShot;

        }catch (Exception ex){
            return null;
        }
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message){
        return message;
    }

    public void goBackButton(){
        this.driver.navigate().back();
    }

    public void closeDriver(){
        this.driver.closeApp();
    }

    public void quitDriver(){
        this.driver.quit();
    }

    public AndroidDriver<AndroidElement> getDriver() {
        return driver;
    }

    public void setDriver(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }
}
