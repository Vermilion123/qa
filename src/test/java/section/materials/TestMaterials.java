package section.materials;

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
 * Created by Renat on 01.06.2016.
 */

@Stories("Materials Story")
@RunWith(JUnit4.class)
public class TestMaterials extends BaseTest {

    private String tmp = Utils.getTmpNumbersString(6);
    private String name = "Autotest material " + Utils.getTmpNumbersString(6);
    private String count = Utils.getTmpNumbersString(4);
    private String priceSell = tmp;

    @BeforeClass
    public static void auth() {
        Auth auth = new Auth();
        auth.authByProperty(getTestUrl());
    }

    @Test
    public void testNewMaterial() {
        Materials materials = new Materials();
        materials.openSectionMaterials();
        materials.newMaterialButtonClick();
        materials.fillMaterilsData(name, count, priceSell);
        materials.saveNewMaterialButtonClick();
        materials.openFirstMaterialInList();

        Assert.assertEquals(name, materials.getName());
        Assert.assertEquals(count, materials.getCount());
        Assert.assertEquals(priceSell, materials.getPriceSell());
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
