package section.waitinglist;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Renat on 09.06.2016.
 */
public class WaitingListPage {


    private SelenideElement newWaitingListItemButton = $("#waitingListItemEdit .jsClickToAddItem");
    private SelenideElement clientAutocomplete;

    public SelenideElement getNewWaitingListItemButton() {
        return newWaitingListItemButton;
    }

    public SelenideElement getClientAutocomplete() {
        return clientAutocomplete;
    }
}
