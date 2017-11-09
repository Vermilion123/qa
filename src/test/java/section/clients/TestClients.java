package section.clients;

import base_test.BaseTest;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.yandex.qatools.allure.annotations.Stories;
import section.authtorize.auth.Auth;
import section.client.Client;
import utils.HelpMethods;
import utils.Utils;

import static com.codeborne.selenide.Selenide.sleep;
import static config.StaticProp.getTestUrl;

/**
 * Created by Renat on 11.05.2016.
 */

@Stories("Client story")
@RunWith(JUnit4.class)
public class TestClients extends BaseTest{

    @BeforeClass
    public static void auth() {
        Auth auth = new Auth();
        auth.authByProperty(getTestUrl());
    }

     //Проверить добавление нового клиента: клиент добавляется, данные в карточке клиента корректны
    @Test()
    public void testCreateNewClient() {
        String tmp          = Utils.getTmpNumbersString(6);
        String name         = "Autotest_name_" + tmp;
        String lastName     = "Autotest_lastname_" + tmp;
        String patronName   = "Au_" + tmp;
        String phone        = Utils.getTmpNumbersString(10);
        String groups       = "Autotest_group";
        String note         = "Autotest_notes";

        Client client = new Client();
        client.openSectionClient();
        client.newClientButtonClick();
        client.fillClientData(name, lastName, patronName, phone, groups, note);
        client.saveNewClientButton();
        client.viewClientMoreInfoButton();
        String[] fullNameViewWithNew = client.getFullNameClientView().split("\\s");

        Assert.assertEquals(lastName + " " + name + " " + patronName+"новый", fullNameViewWithNew[0] + " " + fullNameViewWithNew[1]+ " " + fullNameViewWithNew[2]);
        Assert.assertEquals(phone, HelpMethods.unMaskPhone(client.getPhoneClientView()));
        Assert.assertEquals(groups, client.getMoreInfoData().get("Группы клиентов"));
        Assert.assertEquals(note, client.getMoreInfoData().get("Заметка"));
    }



    //Проверить что добавленный клиент не пропадет через минуту
    @Test()
    public void testNewClientNotDisappearInAMinute() {
        String tmp           =  Utils.getTmpNumbersString(6);
        String name         = "Autotest_name_" + tmp;
        String lastName     = "Autotest_lastname_" + tmp;
        String patronName   = "Au_" + tmp;
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


    //Проверить редактирование клиента: клиент редактируется, данные в карточке клиента корректны
    @Test
    public void testEditClient() {
        String tmp           =  Utils.getTmpNumbersString(6);
        String name         = "Autotest_name_" + tmp;
        String lastName     = "Autotest_lastname_" + tmp;
        String patronName   = "Au_" + tmp;
        String phone        =  Utils.getTmpNumbersString(10);
        String groups       = "Autotest_group";
        String note         = "Autotest_notes";

        String tmp2           =  Utils.getTmpNumbersString(6);
        String name2         = "Autotest_name_" + tmp2;
        String lastName2     = "Autotest_lastname_" + tmp2;
        String patronName2   = "Au_" + tmp2;
        String phone2        =  Utils.getTmpNumbersString(10);
        String groups2       = "Autotest_group";
        String note2         = "Autotest_notes";

        Client client = new Client();
        client.openSectionClient();
        client.newClientButtonClick();
        client.fillClientData(name,lastName,patronName,phone,groups,note);
        client.saveNewClientButton();
        client.editClientButtonClick();
        client.clearData();
        client.fillClientData(name2,lastName2,patronName2,phone2,groups2,note2);
        client.saveEditCLientButtonClick();
        client.viewClientMoreInfoButton();
        String[] fullNameViewWithNew = client.getFullNameClientView().split("\\s");

        Assert.assertEquals(lastName2 + " " + name2, fullNameViewWithNew[0] + " " + fullNameViewWithNew[1]);
        Assert.assertEquals(phone2, HelpMethods.unMaskPhone(client.getPhoneClientView()));
        Assert.assertEquals(groups2, client.getMoreInfoData().get("Группы клиентов"));
        Assert.assertEquals(note2, client.getMoreInfoData().get("Заметка"));
    }

    @Test
    public void testFilterSearchClientByName() {
        String tmp           =  Utils.getTmpNumbersString(6);
        String name         = "Autotest_name_" + tmp;
        String lastName     = "Autotest_lastname_" + tmp;
        String patronName   = "Au_" + tmp;
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

//    @Test
//    public void testScrollClientList() {
//        Client client = new Client();
//        client.openSectionClient();
//        //JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
//        $("#listClients").should(Condition.visible);
//        //executeJavaScript("window.location.href = 'http://google.com'");
//        String injectJQuery = "var element1 = document.createElement(\"script\");\n" +
//                "element1.src = \"//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js\";\n" +
//                "element1.type=\"text/javascript\";\n" +
//                "document.getElementsByTagName(\"head\")[0].appendChild(element1);";
//        String scriptjq = "$('#listClients').scrollTop(1000)";
//        String scriptjs = "document.getElementById(\"listClients\").scrollTop=800;";
//        //executeJavaScript(injectJQuery);
//        executeJavaScript("");
//        String script = "$('[data-id=\"50622\"] .jsViewItem').click();";
//
//        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
//        js.executeScript(script);
//        $("[data-id=\"50413\"]").should(Condition.visible);
//        sleep(5000);
//    }




    // пример быстрого добавления клиента
//    @Test
//    public void ss() {
//        open(getTestUrl() + "/clientix/client/default");
//        $("#breadCrumbs .jsAddButton").click();
//        $("#Clients #label-first_name").val(name);
//        $("#Clients #label-second_name").val(lastName);
//        $("#Clients #label-patron_name").val(patronName);
//        $("#Clients #label-phone").val(phone).pressTab();
//        $("#Clients #label-phone").click();
//
//        $(".jsSaveButtonCreate").click();
//        $("#viewClient").should(Condition.visible);
//    }

}
