package org.auto.common;

import cucumber.api.Scenario;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.auto.setup.Configurations;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Common {

    private static Common instance;

    private Common(){}

    private AndroidDriver<AndroidElement> driver = null;
    private Configurations configurations = null;
    private Scenario tmpScenario;


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
    public void takeScreenShot(){
        try{
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            this.tmpScenario.embed(screenshot, "image/png");

        }catch (Exception ex){

        }
    }

    /**
     * This method allows to add a text as evidence's part
     * @param message
     * @return
     */
    public void saveTextLog(String message){
        this.tmpScenario.write(message);
    }

    /**
     * This method get the text sent from the feature file and return an expected value
     * @param text String that could be can, cannot, will, will not
     * @return boolean true = it's expected to see the value, false = it's not expected to see the value
     */
    public boolean getExpected(String text){

        boolean expected = false;
        switch (text){
            case "can":
                expected = true;
                break;

            case "cannot":
                expected = false;
                break;

            case "will":
                expected = true;
                break;

            case "will not":
                expected = false;
                break;

            default:
                expected = false;
                break;
        }

        return expected;

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

    public Scenario getTmpScenario() {
        return tmpScenario;
    }

    public void setTmpScenario(Scenario tmpScenario) {
        this.tmpScenario = tmpScenario;
    }
}
