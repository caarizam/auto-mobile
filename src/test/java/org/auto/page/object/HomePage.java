package org.auto.page.object;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.auto.common.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;


public class HomePage extends BasePage {

    public HomePage(AndroidDriver driver){
        super(driver);
    }

    @AndroidFindBy( xpath = "//android.widget.EditText[@resource-id='username']")
    private WebElement usernameTextField;

    @AndroidFindBy( xpath = "//android.widget.EditText[@resource-id='password']")
    private WebElement passwordTextField;

    @AndroidFindBy( xpath = "//android.view.View[@resource-id='login_button']/android.widget.Button")
    private WebElement loginButton;

    @AndroidFindBy( xpath = "//android.view.View[@resource-id='logout_button']")
    private WebElement logoutButton;

    @AndroidFindBy( xpath = "//android.widget.TextView[@text='Minimal']")
    private WebElement appTitleLabel;

    @AndroidFindBy( uiAutomator = "new UiSelector().index(0)")
    private WebElement menuOptions;

    @AndroidFindBy( xpath = "//android.widget.TextView[@text='Settings']")
    private WebElement settingOption;

    @AndroidFindBy( xpath = "//android.widget.TextView[@text='About']")
    private WebElement aboutOption;

    @AndroidFindBy( xpath = "//android.widget.TextView[@text='Preference']")
    private WebElement addToDoButton;

    @AndroidFindBy( xpath = "//android.widget.TextView[@text='You don't have any todos']")
    private WebElement generalEmptyLabel;

    @AndroidFindBy( id = "listItemLinearLayout")
    private List<WebElement> listElementsLabel;

    @AndroidFindBy( id = "addToDoItemFAB")
    private WebElement addButton;

    public void loginAction(String username, String password){

        if(isElementVisible(this.loginButton, LONG_TIME_WAIT, "Login button is no visible", true)){
        //this.usernameTextField.click();
            this.usernameTextField.sendKeys(username);
            this.passwordTextField.sendKeys(password);
            this.loginButton.click();
        }

    }

    public void logoutAction() {
        try {
            if(isElementVisible(this.logoutButton, LONG_TIME_WAIT, "Logout button is no visible", true)){
                this.logoutButton.click();
            }
        } catch (Exception e) {
            System.out.println("Exception on logoutAction: " + e.getMessage());
        }
    }

    /**
     * This method performs a click on the add button
     */
    public void clickOnAddButton(){

        if(isElementVisible(this.addButton, LONG_TIME_WAIT, "Add ToDo button is no visible", true)){
            this.addButton.click();
        }

    }

    /**
     * This method gets a list of the elements present in the home page and then
     * compare them with the parameters given
     * @param nameToDo String name of the note
     * @param dateTime boolean to check if the note must have a time or not
     * @return boolean true the element was found, false the element was not found
     */
    public boolean getListToDos(String nameToDo, boolean dateTime){

        WebElement tmpItem;
        String nameText, dateText;
        int size, i;
        boolean foundElement = false;

        if(isElementVisible(this.appTitleLabel, LONG_TIME_WAIT, "App Title is no visible", true)){

            Common.getInstance().takeScreenShot();

            size = listElementsLabel.size();

            for(i = 0; i < size; i++){

                tmpItem = getItemFromList("toDoListItemTextview", listElementsLabel.get(i));
                nameText = tmpItem != null ? tmpItem.getText() : "null";

                tmpItem = getItemFromList("todoListItemTimeTextView", listElementsLabel.get(i));
                dateText = tmpItem != null ? tmpItem.getText() : "null";

                if(nameText.equals(nameToDo)){

                    if(dateTime){
                        if(!dateText.equals("null")){
                            return true;
                        }else{
                            foundElement = false;
                        }
                    }else{
                        return true;
                    }

                }

            }
        }

        return foundElement;

    }

    /**
     * This method gets a list of the elements present in the home page and then
     * compare them with the parameters given
     * @param nameToDo String name of the note
     * @param dateTime boolean to check if the note must have a time or not
     * @return WebElement the element found out or null if the element was not found
     */
    public WebElement getListToDosElement(String nameToDo, boolean dateTime){

        WebElement tmpItem;
        String nameText, dateText;
        int size, i;

        if(isElementVisible(this.appTitleLabel, LONG_TIME_WAIT, "App Title is no visible", true)){

            Common.getInstance().takeScreenShot();

            size = listElementsLabel.size();

            for(i = 0; i < size; i++){

                tmpItem = getItemFromList("toDoListItemTextview", listElementsLabel.get(i));
                nameText = tmpItem != null ? tmpItem.getText() : "null";

                tmpItem = getItemFromList("todoListItemTimeTextView", listElementsLabel.get(i));
                dateText = tmpItem != null ? tmpItem.getText() : "null";

                if(nameText.equals(nameToDo)){

                    if(dateTime){
                        if(!dateText.equals("null")){
                            return listElementsLabel.get(i);
                        }
                    }else{
                        return listElementsLabel.get(i);
                    }

                }

            }
        }

        return null;

    }

    public WebElement getItemFromList(String identifier, WebElement itemElement){

        try{

            WebElement element = itemElement.findElement(By.id(identifier));
            return element;

        }catch (NoSuchElementException ex){

            return null;

        }

    }

    /**
     * This method deletes and element given through a swipe method
     * @param element WebElement that we want to delete
     * @return True on success and False on failure
     */
    public boolean removeElement(WebElement element){

        boolean result = horizontalSwipeRemove(element);
        Common.getInstance().takeScreenShot();
        return result;

    }

}
