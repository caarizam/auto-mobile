package org.auto.setup;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Platform;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Configurations {

    private String deviceName;
    public AndroidDriver driver;
    private String urlAppium;
    private String appPackage = "com.monkeybot.towermanage";
    private String appActivity = "com.monkeybot.towermanage.MainActivity";

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
            UiAutomator2Options options = new UiAutomator2Options()
                    .setPlatformName(Platform.ANDROID.toString())
                    .setDeviceName(deviceName)
                    .setNewCommandTimeout(Duration.ofSeconds(20))
                    .setAppPackage(this.appPackage)
                    .setAppActivity(this.appActivity)
                    .setFullReset(false)
                    .setNoReset(false);

            driver = new AndroidDriver(new URL(urlAppium), options);

            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        }catch (MalformedURLException ex){
            return null;
        }

        return driver;

    }

    public void launchApp(){

        this.driver.activateApp(this.appPackage);

    }

    public void goBackButton(){
        this.driver.navigate().back();
    }

    public void closeDriver(){
        this.driver.terminateApp(this.appPackage);
    }

    public void quitDriver(){


        this.driver.quit();

    }

}
