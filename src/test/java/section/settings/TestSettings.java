package section.settings;

import base_test.BaseTest;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.yandex.qatools.allure.annotations.Stories;
import section.authtorize.auth.Auth;
import section.settings.info_by_company.InfoByComp;
import section.settings.legal.Legal;
import section.settings.settingsAccount.SettingsAccount;
import utils.Utils;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selenide.$;
import static config.StaticProp.getTestUrl;

/**
 * Created by Renat on 21.06.2016.
 */
@Stories("Settings story")
@RunWith(JUnit4.class)
public class TestSettings extends BaseTest {

    @BeforeClass
    public static void auth() {
        Auth auth = new Auth();
        auth.authByProperty(getTestUrl());
    }

    @Test
    public void defaultTimezoneIsMoscow() {
        Settings settings = new Settings();
        settings.openSectionSettings();
        SettingsAccount accountSettings = new SettingsAccount();

        accountSettings.timeZoneClick();
        accountSettings.getTimezoneCollection().shouldHave(size(25));
        accountSettings.getTimezoneCollection().get(15).should(cssClass("active"));
    }

    @Test
    public void changeTimezone() {
        Settings settings = new Settings();
        settings.openSectionSettings();
        SettingsAccount accountSettings = new SettingsAccount();

        accountSettings.timeZoneClick();
        accountSettings.getTimezoneCollection().get(0).click();
        accountSettings.saveButtonClick();

        accountSettings.timeZoneClick();
        accountSettings.getTimezoneCollection().get(0).should(cssClass("active"));
        accountSettings.getTimezoneCollection().get(15).click();
        accountSettings.saveButtonClick();

        accountSettings.timeZoneClick();
        accountSettings.getTimezoneCollection().get(15).should(cssClass("active"));

    }

    @Test
    public void editDataInfoByComplany() {
        String tmp = Utils.getTmpNumbersString(6);
        String name = "autotest_" + tmp;
        String phone = Utils.getTmpNumbersString(10);
        String address = "Baskov per " + tmp;
        String city = "Saint-Petersburg " + tmp;


        Settings settings = new Settings();
        settings.openSectionSettings();
        InfoByComp info = new InfoByComp();
        info.openSectionInfoByComp();
        info.fillData(name, phone, address, city);
        info.saveButtonClick();

        Assert.assertTrue($(".form_error").text().equals("Настройки успешно сохранены."));

        info.openSectionInfoByComp();
        Assert.assertEquals(name, info.getCompanyName());
        Assert.assertEquals(phone, info.getCompanyPhone());
        Assert.assertEquals(address, info.getCompanyAddress());
        Assert.assertEquals(city, info.getCompanyCity());
    }

    @Test
    public void editLegalData() {
        String tmp = Utils.getTmpNumbersString(6);
        String name = "autotest_" + tmp;
        String phone = Utils.getTmpNumbersString(10);
        String address = "Baskov per " + tmp;
        String index = Utils.getTmpNumbersString(6);
        String inn = Utils.getTmpNumbersString(12);
        String kpp = Utils.getTmpNumbersString(9);
        String ogrn = Utils.getTmpNumbersString(13);

        Settings settings = new Settings();
        Legal legal = new Legal();

        settings.openSectionSettings();
        legal.openSectionLegal();
        legal.fillData(name, phone, address, index, inn, kpp, ogrn);
        legal.saveButtonClick();

        Assert.assertTrue($(".form_error").text().equals("Настройки успешно сохранены."));

        legal.openSectionLegal();

        Assert.assertEquals(name, legal.getName());
        Assert.assertEquals(phone, legal.getPhone());
        Assert.assertEquals(address, legal.getAddress());
        Assert.assertEquals(index, legal.getIndex());
        Assert.assertEquals(inn, legal.getInn());
        Assert.assertEquals(kpp, legal.getKpp());
        Assert.assertEquals(ogrn, legal.getOgrn());
    }
}
