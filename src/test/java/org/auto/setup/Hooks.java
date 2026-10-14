package org.auto.setup;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.auto.common.Common;
import org.auto.page.object.HomePage;

public class Hooks {


    @Before
    public void setUp(){
    }

    @After
    public void confirmation(Scenario scenario){
    }

    @AfterAll
    public void tearDown() {
        try {
            HomePage homePage = new HomePage(Common.getInstance().getDriver());
            homePage.logoutAction();
        } catch (Exception e) {
            System.out.println("Exception on tearDown: " + e.getMessage());
        }
    }

}
