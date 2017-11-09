package section.waitinglist;

import com.codeborne.selenide.Condition;

/**
 * Created by Renat on 09.06.2016.
 */
public class WaitingList {

    private WaitingListPage waitingListPage;

    public WaitingList() {
        waitingListPage = new WaitingListPage();
    }

    public void newWaitingListItemButtonClick() {
        waitingListPage.getNewWaitingListItemButton().should(Condition.visible).click();
    }

    public void autocompleteClientClick() { waitingListPage.getClientAutocomplete().should(Condition.visible).click(); }
}
