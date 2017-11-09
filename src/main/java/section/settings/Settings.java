package section.settings;

import section.settings.settingsAccount.SettingsAccount;

import static com.codeborne.selenide.Selenide.open;
import static config.StaticProp.getTestUrl;

/**
 * Created by Renat on 24.06.2016.
 */
public class Settings {

    private SettingsAccount settingsAccount;

    public Settings() {
        settingsAccount = new SettingsAccount();
    }

    public void openSectionSettings() { open(getTestUrl() + "/clientix/settings/account"); }

}
