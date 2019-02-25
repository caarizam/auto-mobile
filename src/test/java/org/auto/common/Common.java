package org.auto.common;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Common {

    AndroidDriver<AndroidElement> driver;

    public Common(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
    }



}
