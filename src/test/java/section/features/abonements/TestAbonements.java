package section.features.abonements;

import base_test.BaseTest;
import com.codeborne.selenide.Condition;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.yandex.qatools.allure.annotations.Stories;
import section.authtorize.auth.Auth;
import section.menu.features.Features;
import utils.Utils;

import static com.codeborne.selenide.Selenide.$;
import static config.StaticProp.getTestUrl;

/**
 * Created by Renat on 09.06.2016.
 */
@Stories("Client story")
@RunWith(JUnit4.class)
public class TestAbonements extends BaseTest {

    @BeforeClass
    public static void auth() {
        Auth auth = new Auth();
        auth.authByProperty(getTestUrl());
    }

    @Test
    public void tooltipIsDisplayed() {
        Features features = new Features();
        features.openSectionFeatures();
        features.openItemAbonetments();
        Abonements abonements = new Abonements();
        abonements.tooltipClick();
        Assert.assertTrue(abonements.isDisplayedTooltip());
        abonements.tooltipClick();
        Assert.assertFalse(abonements.isDisplayedTooltip());
    }

    @Test
    public void addNewAbonement() {
        String tmp = Utils.getTmpNumbersString(6);
        String name = "Autotest_" + tmp;
        String count = Utils.getTmpNumbersString(3);
        Features features = new Features();
        features.openSectionFeatures();
        features.openItemAbonetments();
        Abonements abonements = new Abonements();
        abonements.enableAbonements();
        abonements.newAbonementButtonClick();
        abonements.fillData(name, count);
        abonements.saveNewAbonementButtonClick();
        $("#abonementList").should(Condition.visible).click();
    }

}
