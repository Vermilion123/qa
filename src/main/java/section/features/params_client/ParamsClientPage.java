package section.features.params_client;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Renat on 12.07.2016.
 */
public class ParamsClientPage {

    private SelenideElement address = $("#COMPONENT_CLIENT_LIVING_ADDRESS_FIELD .element_button");
    private SelenideElement passport = $("#COMPONENT_CLIENT_PASSPORT_FIELD .element_button");
    private SelenideElement sex = $("#COMPONENT_CLIENT_SEX_FIELD .element_button");

    public SelenideElement getAddress() {
        return address;
    }

    public SelenideElement getPassport() {
        return passport;
    }

    public SelenideElement getSex() {
        return sex;
    }
}
