package section.features.abonements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by Renat on 09.06.2016.
 */
public class AbonementsPage {

    private SelenideElement enableAbonementsLabel = $("#AccountSettings #ABONEMENTS_ENABLED .element_label ");
    private SelenideElement tooltip = $("#AccountSettings .jsEl_settingInfo");
    private SelenideElement enableAbonementsCheckbox = $("#AccountSettings #ABONEMENTS_ENABLED .element_button ");
    private SelenideElement nameLabel = $("#ServicePacks #label-name");
    private SelenideElement count = $("#ServicePacks #label-duration_value");
    private SelenideElement countVisits = $("#ServicePacks #label-visits_count");
    private SelenideElement price = $("#ServicePacks #label-discounted_price");
    private SelenideElement duration_type = $("#ServicePacks #label-duration_type");

    public SelenideElement getTooltip() {
        return tooltip;
    }

    public SelenideElement getEnableAbonementsLabel() {
        return enableAbonementsLabel;
    }

    public SelenideElement getEnableAbonementsCheckbox() {
        return enableAbonementsCheckbox;
    }

    public SelenideElement getNameLabel() {
        return nameLabel;
    }

    public void setName(String name) {
        nameLabel.val(name);
    }

    public void setCount(String count) {
        this.count.val(count);
    }

    public void setCountVisits(String countVisits) {
        this.countVisits.val(countVisits);
    }

    public void setPrice(String price) {
        this.price.val(price);
    }

    public SelenideElement getDurationType() {
        return duration_type;
    }
    public ElementsCollection getElementsCollectionDurationType() {
        return $$("#ServicePacks ul li");
    }
}
