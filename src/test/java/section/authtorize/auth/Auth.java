package section.authtorize.auth;

import com.codeborne.selenide.Condition;
import config.credentials.CredentialsLoader;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Properties;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by jazzt on 10.02.16.
 */
public class Auth {

    @Step("AUTH: phone {0}, pass {1}" )
    public void auth(String phone, String pass) {
        $("#label-phone").val(phone).pressTab();
        $("#label-password").val(pass).pressTab();
        $("#loginPassForm_element button").click();
        $("body #calendar").should(Condition.visible);
    }

    private String[] authWithDataFromProperties() {
        Properties prop = CredentialsLoader.getInstance();
        String version = System.getProperty("base_version");
        String loginByVersion = prop.getProperty(version);
        return loginByVersion.split(",");
    }


    public void authByProperty(String url) {
        Auth page = new Auth();
        openAuthUrl(url + "/login");
        String phone = authWithDataFromProperties()[0],
                pass = authWithDataFromProperties()[1];
        page.auth(phone, pass);
        // TODO make good
        System.out.println("AUTH: phone:" + phone + ", pass:" + pass);
    }

    private void openAuthUrl(String url) {
        open(url);
        $(".p-auth").should(Condition.visible);
    }
}
