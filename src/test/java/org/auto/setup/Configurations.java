package org.auto.setup;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class Configurations {

    private DesiredCapabilities desiredCapabilities;
    private String deviceName;
    public AndroidDriver driver;
    private String urlAppium;
    private String appPackage = "com.avjindersinghsekhon.minimaltodo";
    private String appActivity = "com.example.avjindersinghsekhon.toodle.MainActivity";

    public Configurations(String deviceName, String urlAppium){

        this.deviceName = deviceName;
        this.urlAppium = urlAppium;

    }

    /**
     * This method create the instance of the driver
     * @return AndroidDriver
     */
    public AndroidDriver getDriver() {

        try{
            desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "20");

            desiredCapabilities.setCapability("appPackage", this.appPackage);
            desiredCapabilities.setCapability("appActivity", this.appActivity);

            desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, "false");
            desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, "true");

            driver = new AndroidDriver(new URL(urlAppium), desiredCapabilities);

            //driver.launchApp();
            //driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
            //driver.resetApp();

        }catch (MalformedURLException ex){
            return null;
        }

        return driver;

    }

    public void launchApp(){

        this.driver.launchApp();

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

}
