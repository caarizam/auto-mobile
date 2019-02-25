package org.auto.setup;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Configurations {

    private DesiredCapabilities desiredCapabilities;
    private String deviceName;
    public AndroidDriver driver;
    private String path;
    private String appName;
    private String urlAppium;

    public Configurations(String deviceName, String path, String urlAppium, String appName){

        this.deviceName = deviceName;
        this.path = path;
        this.urlAppium = urlAppium;
        this.appName = appName;

    }

    public AndroidDriver getDriver() {

        try{
            File fileAppDir = new File(path);
            File fileApp = new File(fileAppDir, appName);

            desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "20");
            desiredCapabilities.setCapability(MobileCapabilityType.APP, fileApp.getAbsolutePath());

            driver = new AndroidDriver(new URL(urlAppium), desiredCapabilities);
            //driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

            driver.resetApp();

        }catch (MalformedURLException ex){
            return null;
        }

        return driver;

    }



}
