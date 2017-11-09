package critical;

import base_test.BaseTest;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.yandex.qatools.allure.annotations.Stories;
import section.authtorize.auth.Auth;
import section.client.Client;
import section.materials.Materials;
import section.services.Services;
import utils.HelpMethods;
import utils.Utils;

import static com.codeborne.selenide.Selenide.sleep;
import static config.StaticProp.getTestUrl;


@Stories("Critical test")
@RunWith(JUnit4.class)
public class CriticalTest extends BaseTest {

    @BeforeClass
    public static void auth() {
        Auth auth = new Auth();
        auth.authByProperty(getTestUrl());
    }

    //Проверить что добавленный клиент не пропадет через минуту
    @Test()
    public void testNewClientNotDisappearInAMinute() {
        String tmp          =  Utils.getTmpNumbersString(6);
        String name         = "Autotest_name_" + tmp;
        String lastName     = "Autotest_lastname_" + tmp;
        String patronName   = "Autotest_thirdname_" + tmp;
        String phone        =  Utils.getTmpNumbersString(10);
        String groups       = "Autotest_group";
        String note         = "Autotest_notes";

        Client client = new Client();
        client.openSectionClient();
        client.newClientButtonClick();
        client.fillClientData(name, lastName, patronName, phone, groups, note);
        client.saveNewClientButton();
        sleep(60000);
        client.openSectionClient();
        client.openFirstClientViewClientList();
        client.viewClientMoreInfoButton();
        String[] fullNameViewWithNew = client.getFullNameClientView().split("\\s");

        Assert.assertEquals(lastName + " " + name, fullNameViewWithNew[0] + " " + fullNameViewWithNew[1]);
        Assert.assertEquals(phone, HelpMethods.unMaskPhone(client.getPhoneClientView()));
        Assert.assertEquals(groups, client.getMoreInfoData().get("Группы клиентов"));
        Assert.assertEquals(note, client.getMoreInfoData().get("Заметка"));
    }

    @Test
    public void testFilterSearchClientByName() {
        String tmp           =  Utils.getTmpNumbersString(6);
        String name         = "Autotest_name_" + tmp;
        String lastName     = "Autotest_lastname_" + tmp;
        String patronName   = "Autotest_thirdname_" + tmp;
        String phone        =  Utils.getTmpNumbersString(10);
        String groups       = "Autotest_group";
        String note         = "Autotest_notes";

        Client client = new Client();
        client.openSectionClient();
        client.newClientButtonClick();
        client.fillClientData(name, lastName, patronName, phone, groups, note);
        client.saveNewClientButton();
        sleep(60000);
        client.openSectionClient();
        client.filterClick();
        client.filterInputByName(name);
        client.findClientInClientList(name);
        client.viewClientMoreInfoButton();
        String[] fullNameViewWithNew = client.getFullNameClientView().split("\\s");

        Assert.assertEquals(lastName + " " + name, fullNameViewWithNew[0] + " " + fullNameViewWithNew[1]);
        Assert.assertEquals(phone, HelpMethods.unMaskPhone(client.getPhoneClientView()));
        Assert.assertEquals(groups, client.getMoreInfoData().get("Группы клиентов"));
        Assert.assertEquals(note, client.getMoreInfoData().get("Заметка"));
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
    public void testNewMaterialNotDisappearInMinute() {
        String tmp = Utils.getTmpNumbersString(6);
        String name = "Autotest material " + Utils.getTmpNumbersString(6);
        String count = Utils.getTmpNumbersString(4);
        String priceSell = tmp;

        Materials materials = new Materials();
        materials.openSectionMaterials();
        materials.newMaterialButtonClick();
        materials.fillMaterilsData(name, count, priceSell);
        materials.saveNewMaterialButtonClick();
        sleep(60000);
        materials.openSectionMaterials();
        materials.openFirstMaterialInList();

        Assert.assertEquals(name, materials.getName());
        Assert.assertEquals(count, materials.getCount());
        Assert.assertEquals(priceSell, materials.getPriceSell());
    }

    @Test
    public void testSearchMaterialInFilter() {
        String tmp = Utils.getTmpNumbersString(6);
        String name = "Autotest material " + Utils.getTmpNumbersString(6);
        String count = Utils.getTmpNumbersString(4);
        String priceSell = tmp;

        Materials materials = new Materials();
        materials.openSectionMaterials();
        materials.newMaterialButtonClick();
        materials.fillMaterilsData(name, count, priceSell);
        materials.saveNewMaterialButtonClick();
        sleep(60000);
        materials.openSectionMaterials();
        materials.filterInputNameMaterial(name);
        materials.findMaterialInList(name);

        Assert.assertEquals(name, materials.getName());
        Assert.assertEquals(count, materials.getCount());
        Assert.assertEquals(priceSell, materials.getPriceSell());
    }

}
