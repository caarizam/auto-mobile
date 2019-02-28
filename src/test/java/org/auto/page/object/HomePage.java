package org.auto.page.object;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.auto.common.Common;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;


public class HomePage extends BasePage {

    public HomePage(AndroidDriver<AndroidElement> driver){
        super(driver);
    }

    @AndroidFindBy( xpath = "//android.widget.TextView[@text='Minimal']")
    private AndroidElement appTitleLabel;

    @AndroidFindBy( uiAutomator = "new UiSelector().index(0)")
    private AndroidElement menuOptions;

    @AndroidFindBy( xpath = "//android.widget.TextView[@text='Settings']")
    private AndroidElement settingOption;

    @AndroidFindBy( xpath = "//android.widget.TextView[@text='About']")
    private AndroidElement aboutOption;

    @AndroidFindBy( xpath = "//android.widget.TextView[@text='Preference']")
    private AndroidElement addToDoButton;

    @AndroidFindBy( xpath = "//android.widget.TextView[@text='You don't have any todos']")
    private AndroidElement generalEmptyLabel;

    @AndroidFindBy( id = "listItemLinearLayout")
    private List<AndroidElement> listElementsLabel;

    @AndroidFindBy( id = "addToDoItemFAB")
    private AndroidElement addButton;

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

        AndroidElement tmpItem;
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

                System.out.println("nameText  :" + nameText);
                System.out.println("dateText  :" + dateText);

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
     * @return AndroidElement the element found out or null if the element was not found
     */
    public AndroidElement getListToDosElement(String nameToDo, boolean dateTime){

        AndroidElement tmpItem;
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

    public AndroidElement getItemFromList(String identifier, AndroidElement itemElement){

        try{

            AndroidElement element = (AndroidElement) itemElement.findElementById(identifier);
            return element;

        }catch (NoSuchElementException ex){

            return null;

        }

    }

    /**
     * This method deletes and element given through a swipe method
     * @param element AndroidElement that we want to delete
     * @return True on success and False on failure
     */
    public boolean removeElement(AndroidElement element){

        boolean result = horizontalSwipeRemove(element);
        Common.getInstance().takeScreenShot();
        return result;

    }

}
