package section.features.lead_source;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by Renat on 05.07.2016.
 */
public class LeadSourcePage {
    private SelenideElement leadSource= $(".jsButtonLeadSource");
    private SelenideElement labelKey = $("#key_values #label-key_values");
    private ElementsCollection leadSourceCollection = $$("#leadSourceList .split");
    private SelenideElement askSourceCLient = $("#COMPONENT_CLIENT_LEAD_SOURCE_ANALYTICS .element_button");
    private SelenideElement makeFieldRequired = $("#COMPONENT_CLIENT_LEAD_SOURCE_ANALYTICS_FIELD_REQUIRED .element_button");

    public SelenideElement getLeadSource() {
        return leadSource;
    }

    public SelenideElement getLabelKey() {
        return labelKey;
    }

    public void setLabelKey(String key) {
        labelKey.val(key).pressEnter();
    }


    public ElementsCollection getLeadSourceCollection() {
        return leadSourceCollection;
    }

    public SelenideElement getAskSourceCLient() {
        return askSourceCLient;
    }

    public SelenideElement getMakeFieldRequired() {
        return makeFieldRequired;
    }
}
