package section.settings.settingsAccount;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by Renat on 21.06.2016.
 */
public class SettingsAccountPage {

    private SelenideElement timeZoneAC = $("#label-timezone");
    private ElementsCollection timeZoneCollecton = $$("#Accounts ul li");

    public SelenideElement getTimeZoceAC() { return timeZoneAC; }

    public ElementsCollection getTimeZoneCollecton() { return  timeZoneCollecton; }


}
