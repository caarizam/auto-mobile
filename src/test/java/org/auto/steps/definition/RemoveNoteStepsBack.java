package org.auto.steps.definition;

/*import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Step;
import org.auto.page.object.AddToDoPage;
import org.auto.page.object.HomePage;
import org.junit.Assert;
*/
public class RemoveNoteStepsBack {

    /*AndroidDriver driver;
    HomePage homePage;
    AddToDoPage addPage;

    public RemoveNoteStepsBack(AndroidDriver driver){

        this.driver = driver;
        homePage = new HomePage(this.driver);
        addPage = new AddToDoPage(this.driver);
    }

    @Step("Get the element to remove \"{nameToDo}\"")
    public void getAndRemoveNote(String nameToDo, boolean dateTime){

        AndroidElement elementToRemove = homePage.getListToDosElement(nameToDo, dateTime);

        if(elementToRemove != null){

            homePage.removeElement(elementToRemove);
            boolean checkItem = homePage.getListToDos(nameToDo, dateTime);
            Assert.assertEquals("The item with value \"" + nameToDo + "\" was not removed", false, checkItem);

        }else{
            Assert.assertTrue("The item with value \"" + nameToDo + "\" was not found", false);
        }



    }*/

}
