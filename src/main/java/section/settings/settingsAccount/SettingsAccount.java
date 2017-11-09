package section.settings.settingsAccount;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import section.breadcrumbs.BreadCrumbsPage;

/**
 * Created by Renat on 21.06.2016.
 */
public class SettingsAccount {

    private SettingsAccountPage settingsAccountPage;
    private BreadCrumbsPage bread;

    public SettingsAccount() {
        settingsAccountPage = new SettingsAccountPage();
        bread = new BreadCrumbsPage();
    }

    public void timeZoneClick() { settingsAccountPage.getTimeZoceAC().should(Condition.visible).click();}

    public boolean isActivTimeZone(int i) { return settingsAccountPage.getTimeZoneCollecton().get(i).has(Condition.cssClass("active")); }

    public ElementsCollection getTimezoneCollection() { return settingsAccountPage.getTimeZoneCollecton(); }

    public void saveButtonClick() { bread.getSaveTimeZoneButton().should(Condition.visible).click();}
}
