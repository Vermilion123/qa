package section.client;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by Renat on 16.05.2016.
 */
public class ClientPage {

    /**
     * client list form start
     */
    private SelenideElement clientListForm = $("#listClients");

    private ElementsCollection clienListCollection = clientListForm.$$(".p-client-list_row");
    private SelenideElement leadSourceError = $("#lead_source .element_error");



    public ElementsCollection getClientListCollection() {
        return clienListCollection;
    }



    /**
     * client list form end
     */

    /**
     * add client form start
     */
    private SelenideElement name = $("#label-first_name");
    private SelenideElement lastName = $("#Clients #label-second_name");
    private SelenideElement patronName = $("#Clients #label-patron_name");
    private SelenideElement phone = $("#Clients #label-phone");
    private SelenideElement groups = $("#Clients #label-client_groups");
    private SelenideElement note = $("#Clients #label-client_memo");
    private SelenideElement leadSource = $("#Clients #label-lead_source");
    private SelenideElement address = $("#Clients #label-living_address");
    private SelenideElement sex = $("#Clients #sex");
    private SelenideElement passportSerial = $("#Clients #passport_serial");
    private SelenideElement passportNumber = $("#Clients #passport_number");
    private SelenideElement passportCreated = $("#Clients #passport_created");
    private SelenideElement passportAuthor = $("#Clients #passport_author");

    private ElementsCollection leadSourceCollection = $$("#Clients #lead_source ul li");

    public void setName(String name) { this.name.val(name); }

    public void setLastName(String lastName) { this.lastName.val(lastName); }

    public void setPatronName(String patronName) {
        this.patronName.val(patronName);
    }

    public void setPhone(String phone) {
        this.phone.val(phone);
    }

    public void setGroups(String groups) {
        this.groups.val(groups);
    }

    public void setNote(String note) {
        this.note.val(note);
    }

    public SelenideElement getName() { return name; }

    public SelenideElement getLastName() {
        return lastName;
    }

    public SelenideElement getPatronName() {
        return patronName;
    }



    public SelenideElement getGroups() {
        return groups;
    }

    public SelenideElement getNote() {
        return note;
    }

    public SelenideElement getAddress() { return address; }

    public SelenideElement getSex() { return sex; }

    public SelenideElement getPassportSerial() { return passportSerial; }
    public SelenideElement getPassportNumber() { return passportNumber; }
    public SelenideElement getPassportAuthor() { return passportAuthor; }
    public SelenideElement getPassportCreated() { return passportCreated; }


    /**
     * add client form end
     */



    /**
     * view client form start
     */

    private SelenideElement viewForm = $("#viewClient");


    private SelenideElement clientViewName = $("#viewClient .p-client-view_name");
    private SelenideElement clientViewPhone = $("#viewClient .p-client-view_tel");
    private SelenideElement moreInfoButton = $("#viewClient .p-client-view-moreinfo_button");

    private ElementsCollection keyMoreInfo =  viewForm.$(".p-client-view-moreinfo_dropdown").$("ul").$$(".p-client-view-moreinfo_label");
    private ElementsCollection valueMoreInfo =  viewForm.$(".p-client-view-moreinfo_dropdown").$("ul").$$(".p-client-view-moreinfo_value");

    public SelenideElement getClientViewName() {
        return clientViewName;
    }

    public SelenideElement getClientViewPhone() {
        return clientViewPhone;
    }

    public ElementsCollection getKeyMoreInfo() {
        return keyMoreInfo;
    }

    public ElementsCollection getValueMoreInfo() {
        return valueMoreInfo;
    }

    public SelenideElement getMoreInfoButton() { return moreInfoButton; }

    public SelenideElement getPhone() {
        return phone;
    }

    public SelenideElement getViewForm() {
        return viewForm;
    }

    public SelenideElement getLeadSource() {
        return leadSource;
    }

    public ElementsCollection getLeadSourceCollection() {
        return leadSourceCollection;
    }

    public SelenideElement getLeadSourceError() {
        return leadSourceError;
    }




    /**
     * view client form end
     */
}
