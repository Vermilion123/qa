package section.client;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import section.breadcrumbs.BreadCrumbsPage;
import section.filter.ClientFilterPage;
import utils.Utils;

import java.util.Map;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static config.StaticProp.getTestUrl;

/**
 * Created by Renat on 16.05.2016.
 */
public class Client {

    private BreadCrumbsPage bread;
    private ClientPage clientPage;
    private ClientFilterPage filter;

    public Client() {
        bread = new BreadCrumbsPage();
        clientPage = new ClientPage();
        filter = new ClientFilterPage();
    }

    public void openSectionClient() {
        open(getTestUrl() + "/clientix/client/default");
    }

    public void newClientButtonClick() {
        bread.getAddClientButton().click();
    }
    public void editClientButtonClick() { bread.getEditClientButton().should(visible).click(); }
    public void saveNewClientButton() { bread.getSaveClientButton().click(); }
    public void saveEditCLientButtonClick() { bread.getSaveEditClientButton().should(visible).click(); }

    public void fillClientData(String name, String lastName, String patronName, String phone, String groups, String note) {
            clientPage.setName(name);
            clientPage.setLastName(lastName);
            //fixme blocking save client if input: name, lastname, patronname
            clientPage.setPatronName(patronName);
            clientPage.setGroups(groups);
            clientPage.setNote(note);
            clientPage.setPhone(phone);
    }

    public void viewClientMoreInfoButton() {
        clientPage.getViewForm().should(visible);
        clientPage.getMoreInfoButton().should(visible).click();
    }

    public Map<String, String> getMoreInfoData() {
        return Utils.getMapInfo(clientPage.getKeyMoreInfo(), clientPage.getValueMoreInfo());
    }
//    public void getMoreInfoData() {
//        for (Map.Entry entry : Utils.getMapInfo(clientPage.getKeyMoreInfo(), clientPage.getValueMoreInfo()).entrySet()) {
//            SelenideElement key = (SelenideElement) entry.getKey();
//            SelenideElement value = (SelenideElement) entry.getValue();
//
//        }
//    }

    public String getFullNameClientView() {
        return clientPage.getClientViewName().getText();
    }

    public String getPhoneClientView() {
        return clientPage.getClientViewPhone().getText();
    }

    public boolean hasClientListElements() {
        return clientPage.getClientListCollection().size() != 0;
    }


    public void openFirstClientViewClientList() {
        clientPage.getClientListCollection().get(0).$(".jsViewItem").click();
    }

    public void clearData() {
        clearElementValue(clientPage.getName());
        clearElementValue(clientPage.getLastName());
        clearElementValue(clientPage.getNote());
        clientPage.getPhone().clear();
        clientPage.getPhone().val("");
        $(".remove").click(); // for groups
    }

    private void clearElementValue(SelenideElement e) {
        e.clear();
        //e.val("");
    }

    public void filterClick() {
        bread.getFilterButton().click();
    }

    public boolean hasClientListGreenClient() {
         return $(".row-client-storage").should(visible).exists();
    }

    public void filterInputByName(String name) {
        filter.setName(name);
    }

    public void findClientInClientList(String name) {
        for (SelenideElement e : clientPage.getClientListCollection()) {
            if (e.$(".p-client-list_name").getText().contains(name)) {
                e.$(".p-client-list_name").click();
            }
        }
    }

    public void leadSourceClick() {
        clientPage.getLeadSource().should(visible).click();
    }

    public boolean isLeadSourceDisplayed() {
        return clientPage.getLeadSource().is(visible);
    }

    public boolean containsLeadSourceCollection(String source) {
        return clientPage.getLeadSourceCollection().filterBy(Condition.attribute("data-id", source)).isEmpty();
    }

    public void cancelNewClientSaveButtonClick() {
        bread.getCancelNewClientSave().click();
    }

    public void filterLeadSourceClick() {
        filter.getLeadSource().should(visible).click();
    }


    public boolean containsFilterLeadSourceCollection(String source) {
        return filter.getLeadSourceCollection().filterBy(Condition.attribute("data-id", source)).isEmpty();
    }

    public String errorLeadSource() {
        return clientPage.getLeadSourceError().text();
    }

    public boolean isAddress() {
        return clientPage.getAddress().is(visible);
    }

    public boolean isSex() {
        return clientPage.getSex().is(visible);
    }

    public boolean isPassport() {
        return clientPage.getPassportSerial().is(visible)
                && clientPage.getPassportNumber().is(visible)
                && clientPage.getPassportAuthor().is(visible)
                && clientPage.getPassportCreated().is(visible);
    }


}
