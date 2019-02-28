package org.auto.common;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Attachment;
import org.auto.setup.Configurations;
import org.openqa.selenium.OutputType;

public class Common {

    private static Common instance;

    private Common(){}

    private AndroidDriver<AndroidElement> driver = null;
    private Configurations configurations = null;


    public static Common getInstance() {
        if (instance == null) {
            instance = new Common();
        }
        return instance;
    }

    /**
     * This method allows to add an image as evidence
     * @return
     */
    @Attachment(value = "Screenshot evidence", type = "image/jpg")
    public byte[] takeScreenShot(){
        try{
            byte[] screenShot = driver.getScreenshotAs(OutputType.BYTES);
            return screenShot;

        }catch (Exception ex){
            return null;
        }
    }

    /**
     * This method allows to add a text as evidence's part
     * @param message
     * @return
     */
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message){
        return message;
    }

    /**
     * This method delay for the seconds given
     * @param seconds
     */
    public void forcedDelay(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public AndroidDriver<AndroidElement> getDriver() {

        return driver;

    }

    public void setDriver(AndroidDriver<AndroidElement> driver) {

        System.out.println("setDriver");
        if(this.driver == null){
            System.out.println("driver is null");
            this.driver = driver;
        }
    }

    public Configurations getConfigurations(String deviceName, String urlAppium) {

        System.out.println("getConfigurations");
        if(configurations == null){
            System.out.println("Configurations is null");
            configurations = new Configurations(deviceName, urlAppium);
            this.driver = configurations.getDriver();
        }

        return configurations;
    }

    public void setConfigurations(Configurations configurations) {
        this.configurations = configurations;
    }
}
