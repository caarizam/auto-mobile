package org.auto.setup;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;
import org.auto.common.Common;

public class Hooks {


    @Before
    public void setUp(){
        System.out.println("hooks before");
    }

    @After
    public void confirmation(Scenario scenario){
        System.out.println("hooks after " + scenario.getName());
    }

}
