package section.authtorize.registr;

import com.codeborne.selenide.Condition;
import ru.yandex.qatools.allure.annotations.Step;
import section.authtorize.auth.SMSCenterHelper;

import static com.codeborne.selenide.Selenide.*;
import static config.StaticProp.*;

/**
 * Created by Renat on 06.04.2016.
 */
public class RegisterPage {


    @Step
    private void openRegisterPage() {
        open(getTestUrl() + "/register?version=" + System.getProperty("base_version"));
    }

    @Step
    private void goTo2Step(String name) {
        $("#label-name").val(name).pressTab();
        $("#step-1 button").click();
        $("#regUserName").should(Condition.text(name));
    }

    @Step
    private void fill2Step(String phone) throws Exception {
        $("#label-phone").val(phone.substring(1, phone.length())).pressTab();
        $("#send button").click();
        sleep(5000);
        SMSCenterHelper sms = new SMSCenterHelper();
        Integer[] codes = sms.getCodesFromTwoAccounts(phone);
        $("#label-code").val(codes[1].toString()).pressTab();
        if ($(".element_error").isDisplayed()) {
            $("#label-code").clear();
            $("#label-code").val(codes[0].toString());
        }
        $("#registrationForm #step-2 .ButtonStepForward").click();
        $("#breadCrumbs").should(Condition.visible);
    }

    @Step
    private void makeAccountTest() {
        if (isProd())
            open(getPreffix() + getBaseUrl() + "/clientix/employee/testAccount");
        back();
        $("#breadCrumbs").should(Condition.visible);
    }

    @Step
    public void register(String name, String phone) throws Exception {
        openRegisterPage();
        goTo2Step(name);
        fill2Step(phone);
        makeAccountTest();
    }
}
