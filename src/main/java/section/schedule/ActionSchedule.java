package section.schedule;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Renat on 07.06.2016.
 */
public class ActionSchedule {

    private SelenideElement form = $("#actionsPanel");

    private SelenideElement removeFormButton = form.$(".jsClick_init_remove");
    private SelenideElement removeSelectedButton = $("#removeUnitPanel .jsRemoveSelectedButton");

    public SelenideElement getRemoveFormButton() {
        return removeFormButton;
    }

    public SelenideElement getRemoveSelectedButton() {
        return removeSelectedButton;
    }
}
