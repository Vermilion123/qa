package section.menu;

import base_test.BaseTest;
import com.codeborne.selenide.Condition;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Stories;
import section.authtorize.auth.Auth;
import section.calendar.Calendar;
import section.menu.menu.Menu;

import static com.codeborne.selenide.Selenide.$;
import static config.StaticProp.getTestUrl;

/**
 * Created by Renat on 09.06.2016.
 */
@Stories("Menu Story")
@RunWith(JUnit4.class)
public class TestMenu extends BaseTest {

    @BeforeClass
    public static void auth() {
        Auth auth = new Auth();
        auth.authByProperty(getTestUrl());
    }

    @Test
    public void openEverySection() {
        Menu menu = new Menu();
        Calendar calendar = new Calendar();
        Assert.assertTrue(calendar.calendarDaysVisible());

        openSectionServices(menu);
        openSectionClients(menu);
        openSectionSchedule(menu);
        openSectionFeatures(menu);
        openSectionEmployee(menu);
        openSectionSettings(menu);
    }

    @Step
    public void openSectionServices(Menu menu) {
        menu.menuButtonClick();
        menu.servicesSectionClick();
        $("#serviceList").should(Condition.visible);
    }

    @Step
    public void openSectionClients(Menu menu) {
        menu.menuButtonClick();
        menu.clientsSectionClick();
        $("#listClients").should(Condition.visible);
    }

    @Step
    public void openSectionSchedule(Menu menu) {
        menu.menuButtonClick();
        menu.scheduleSectionClick();
        $("#schedule").should(Condition.visible);
    }
    @Step
    public void openSectionFeatures(Menu menu) {
        menu.menuButtonClick();
        menu.featuresSectionClick();
        $("#smsSettingsList").should(Condition.visible);
    }

    @Step
    public void openSectionEmployee(Menu menu) {
        menu.menuButtonClick();
        menu.employeeSectionClick();
        $("#employeeList").should(Condition.visible);
    }
    @Step
    public void openSectionSettings(Menu menu) {
        menu.menuButtonClick();
        menu.settingsSectionClick();
        $("#listSettings").should(Condition.visible);
    }

}
