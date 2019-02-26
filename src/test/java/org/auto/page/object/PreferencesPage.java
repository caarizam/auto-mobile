package org.auto.page.object;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.auto.common.Common;


public class PreferencesPage extends BasePage {

    public PreferencesPage(AndroidDriver<AndroidElement> driver){
        super(driver);
    }

    /*Preference dependencies section*/
    @AndroidFindBy( xpath = "//android.widget.TextView[@text='3. Preference dependencies']")
    private AndroidElement dependenciesOption;

    @AndroidFindBy( className = "android.widget.CheckBox")
    private AndroidElement wifiOptionCheckbox;

    @AndroidFindBy( xpath = "//android.widget.TextView[@text='WiFi settings']")
    private AndroidElement titleElementOption;

    @AndroidFindBy( id = "edit")
    private AndroidElement editText;

    @AndroidFindBy( id = "button1")
    private AndroidElement okButton;

    @AndroidFindBy( id = "button2")
    private AndroidElement cancelButton;


    /*Preference fragment section*/
    @AndroidFindBy( xpath = "//android.widget.TextView[@text='7. Fragment']")
    private AndroidElement fragmentOption;

    @AndroidFindBy( xpath = "//android.widget.LinearLayout[@index='4']")
    private AndroidElement listPreferencesOptions;

    @AndroidFindBy( xpath = "//android.widget.CheckedTextView[@text='Beta Option 02']")
    private AndroidElement optionBeta2RadioButton;


    public void clickOnDependencies(){

        isElementVisible(this.dependenciesOption, LONG_TIME_WAIT);
        this.dependenciesOption.click();

    }

    public void setDependenciesValues(boolean checkWifiOption, String wifiSettingsText, boolean okCancel){

        isElementVisible(this.wifiOptionCheckbox, LONG_TIME_WAIT);

        if(!this.wifiOptionCheckbox.isSelected() && checkWifiOption){

            wifiOptionCheckbox.click();

        }else if(this.wifiOptionCheckbox.isSelected() && !checkWifiOption){

            wifiOptionCheckbox.click();

        }

        this.titleElementOption.click();

        isElementVisible(this.editText, MID_TIME_WAIT);
        this.editText.click();
        this.editText.clear();
        this.editText.sendKeys(wifiSettingsText);

        this.driver.hideKeyboard();

        if(okCancel){
            this.okButton.click();
        }else{
            this.cancelButton.click();
        }

        isElementVisible(this.wifiOptionCheckbox, MID_TIME_WAIT);

    }

    public void clickOnFragment(){

        isElementVisible(this.fragmentOption, LONG_TIME_WAIT);
        this.fragmentOption.click();

    }

    public void setFragmentValues(){

        isElementVisible(this.listPreferencesOptions, LONG_TIME_WAIT);
        this.listPreferencesOptions.click();
        isElementVisible(this.optionBeta2RadioButton, MID_TIME_WAIT);
        this.optionBeta2RadioButton.click();

    }

}
