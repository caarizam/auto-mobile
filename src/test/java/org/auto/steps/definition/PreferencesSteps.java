package org.auto.steps.definition;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.auto.common.Common;
import org.auto.page.object.HomePage;
import org.auto.page.object.PreferencesPage;

public class PreferencesSteps {

    AndroidDriver driver;
    HomePage homePage;
    PreferencesPage preferencesPage;

    public PreferencesSteps(AndroidDriver driver){

        this.driver = driver;
        homePage = new HomePage(this.driver);
        preferencesPage = new PreferencesPage(this.driver);

    }

    @Step("Navigate to Preferences menu")
    public void goToPreferences(){

        homePage.clickOnPreference();

    }

    @Step("Set dependencies values with \"{wifiSettingsText}\"")
    public void setDependencies(boolean checkWifiOption, String wifiSettingsText, boolean okCancel){

        preferencesPage.clickOnDependencies();
        Common.getInstance().takeScreenShot();
        preferencesPage.setDependenciesValues(checkWifiOption, wifiSettingsText, okCancel);
        Common.getInstance().takeScreenShot();

    }

    @Step("Navigate to Fragment menu")
    public void goToFragmentSection(){

        preferencesPage.clickOnFragment();

    }

    @Step("Set Fragment values")
    public void setFragmentOptions(){

        Common.getInstance().takeScreenShot();
        preferencesPage.setFragmentValues();
        Common.getInstance().takeScreenShot();

    }

}
