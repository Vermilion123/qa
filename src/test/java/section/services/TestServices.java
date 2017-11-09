package section.services;

import base_test.BaseTest;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.yandex.qatools.allure.annotations.Stories;
import section.authtorize.auth.Auth;
import utils.Utils;

import static com.codeborne.selenide.Selenide.sleep;
import static config.StaticProp.getTestUrl;

/**
 * Created by Renat on 27.05.2016.
 */
@Stories("Service story")
@RunWith(JUnit4.class)
public class TestServices extends BaseTest {

    private String tmp = Utils.getTmpNumbersString(6);
    private String name = "Autotest_name_" + tmp;
    private String group = "Autotest_group_" + tmp;
    private String price = Utils.getTmpNumbersString(4);

    @BeforeClass
    public static void auth() {
        Auth auth = new Auth();
        auth.authByProperty(getTestUrl());
    }

    @Test
    public void testAddNewService() {
        Services services = new Services();
        services.openSectionService();
        services.newServiceButtonClick();
        services.fillServiceData(name, group, price);
        services.saveNewServiceButton();
        Assert.assertEquals(name, services.getServiceViewName());
        Assert.assertEquals(group, services.getMoreInfoDataGroups());
        Assert.assertEquals(price, services.getMoreInfoDataServiceView().get("Стоимость"));
    }

    @Test
    public void testNewServiceNotDisappearInMunite() {
        String tmp = Utils.getTmpNumbersString(6);
        String name = "Autotest_name_" + tmp;
        String group = "Autotest_group_" + tmp;
        String price = Utils.getTmpNumbersString(4);

        Services services = new Services();
        services.openSectionService();
        services.newServiceButtonClick();
        services.fillServiceData(name, group, price);
        services.saveNewServiceButton();
        sleep(60000);
        services.openSectionService();
        services.filterClick();
        services.filterInputServiceByName(name);
        services.findServiceInServiceList(name);

        Assert.assertEquals(name, services.getServiceViewName());
        Assert.assertEquals(group, services.getMoreInfoDataGroups());
        Assert.assertEquals(price, services.getMoreInfoDataServiceView().get("Стоимость"));
    }

    @Test
    public void testEditService() {
        String tmp = Utils.getTmpNumbersString(6);
        String name = "Autotest_name_" + tmp;
        String group = "Autotest_group_" + tmp;
        String price = Utils.getTmpNumbersString(4);

        Services services = new Services();
        services.openSectionService();
        services.newServiceButtonClick();
        services.fillServiceData(name, group, price);
        services.saveNewServiceButton();
        services.editServicesButtonClick();
        services.clearData();
        services.fillServiceData(name, group, price);
        services.saveEditServceButtonClick();

        Assert.assertEquals(name, services.getServiceViewName());
        Assert.assertEquals(group, services.getMoreInfoDataGroups());
        Assert.assertEquals(price, services.getMoreInfoDataServiceView().get("Стоимость"));
    }

}
