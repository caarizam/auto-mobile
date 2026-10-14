package org.auto.page.object;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.time.Duration.ofMillis;

public class BasePage {

    protected WebDriverWait wait;
    protected AndroidDriver driver;

    public BasePage(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
    }

    protected final int SHORT_TIME_WAIT = 3;
    protected final int MID_TIME_WAIT = 5;
    protected final int LONG_TIME_WAIT = 8;

    /**
     * This method allow to check if an element is visible or not, also
     * create an assert with a failure
     * @param androidElement WebElement to check if is visible or not
     * @param timeOut Int Explicit time to wait the element
     * @param message String message to add in case of failure
     * @param expected boolean True of False
     * @return
     */
    public boolean isElementVisible(WebElement androidElement, int timeOut, String message, boolean expected){

        boolean isVisible = false;
        try{

            wait = new WebDriverWait(this.driver, Duration.ofSeconds(timeOut));
            wait.until(ExpectedConditions.visibilityOf(androidElement));

            isVisible = true;

        }catch (Exception ex){
            isVisible = false;
        }

        Assertions.assertEquals(expected, isVisible, message);

        return isVisible;
    }

    /**
     * This method perform a horizontal swipe to delete a note
     * @param androidElement WebElement that we want to delete
     * @return boolean True on success of False on failure
     */
    public boolean horizontalSwipeRemove(WebElement androidElement){

        try{
            int x1Position = androidElement.getLocation().getX();
            int y1Position = androidElement.getLocation().getY();

            int elementWidth = androidElement.getSize().getWidth();
            int elementHeight = androidElement.getSize().getHeight();

            int x2Position = x1Position + (int)(elementWidth * 0.99);
            int y2Position = y1Position + (elementHeight / 2);

            x1Position = (int)(elementWidth * 0.2);

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 1)
                    .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x1Position, y2Position))
                    .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(new Pause(finger, ofMillis(1300)))
                    .addAction(finger.createPointerMove(ofMillis(500), PointerInput.Origin.viewport(), x2Position, y2Position))
                    .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            this.driver.perform(List.of(swipe));

            return true;

        }catch (Exception ex){
            return false;
        }

    }

}
