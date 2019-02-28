package org.auto.page.object;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import org.junit.Assert;
import org.junit.platform.suite.api.ExcludePackages;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

public class BasePage {

    protected WebDriverWait wait;
    protected AndroidDriver<AndroidElement> driver;

    public BasePage(AndroidDriver<AndroidElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
    }

    protected final int SHORT_TIME_WAIT = 3;
    protected final int MID_TIME_WAIT = 5;
    protected final int LONG_TIME_WAIT = 8;

    /**
     * This method allow to check if an element is visible or not, also
     * create an assert with a failure
     * @param androidElement AndroidElement to check if is visible or not
     * @param timeOut Int Explicit time to wait the element
     * @param message String message to add in case of failure
     * @param expected boolean True of False
     * @return
     */
    public boolean isElementVisible(AndroidElement androidElement, int timeOut, String message, boolean expected){

        boolean isVisible = false;
        try{

            wait = new WebDriverWait(this.driver, timeOut);
            wait.until(ExpectedConditions.visibilityOf(androidElement));

            isVisible = true;

        }catch (Exception ex){
            System.out.println("Exception  :" + ex.getClass().toString());
            isVisible = false;
        }

        Assert.assertEquals(message, isVisible, expected);

        return isVisible;
    }

    /**
     * This method perform a horizontal swipe to delete a note
     * @param androidElement AndroidElement that we want to delete
     * @return boolean True on success of False on failure
     */
    public boolean horizontalSwipeRemove(AndroidElement androidElement){

        try{
            int x1Position = androidElement.getLocation().getX();
            int y1Position = androidElement.getLocation().getY();

            int elementWidth = androidElement.getSize().getWidth();
            int elementHeight = androidElement.getSize().getHeight();

            int x2Position = x1Position + (int)(elementWidth * 0.99);
            int y2Position = y1Position + (elementHeight / 2);

            x1Position = (int)(elementWidth * 0.2);

            TouchAction touch = new TouchAction(this.driver);
            touch.longPress(LongPressOptions.longPressOptions().withPosition(point(x1Position, y2Position)).withDuration(ofMillis(1300))).moveTo(point(x2Position, y2Position)).release().perform();

            return true;

        }catch (Exception ex){
            return false;
        }

    }

}
