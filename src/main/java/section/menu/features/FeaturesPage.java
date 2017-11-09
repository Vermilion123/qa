package section.menu.features;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Renat on 09.06.2016.
 */
public class FeaturesPage {

    private SelenideElement abonementItem = $("#listSettings .p-settings-list_row .jsClick_load_abonementSettings");
    private SelenideElement paramsClient = $(".jsButtonClientFields");


    public SelenideElement getAbonementItem() { return abonementItem; }


    public SelenideElement getParamsClient() { return paramsClient; }
}
