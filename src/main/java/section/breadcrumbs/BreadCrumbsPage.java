package section.breadcrumbs;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Renat on 13.05.2016.
 */
public class BreadCrumbsPage {

    private SelenideElement breadCrumbsForm = $("#breadCrumbs");
    private SelenideElement materialBreadForm = $("#materialBreadCrumbs");

    private SelenideElement addClientButton = breadCrumbsForm.$(".jsAddButton");
    private SelenideElement saveClientButton = breadCrumbsForm.$(".jsSaveButtonCreate");
    private SelenideElement cancelClientButton = breadCrumbsForm.$(".jsCancelButton");
    private SelenideElement editClientButton = breadCrumbsForm.$(".jsEditButton");
    private SelenideElement filterButton = breadCrumbsForm.$(".jsFiltersButton");
    private SelenideElement addServiceButton = breadCrumbsForm.$(".jsButtonServiceAdd");
    private SelenideElement serviceAddSaveButton = breadCrumbsForm.$(".jsButtonServiceAddSave");
    private SelenideElement editServicesButton = breadCrumbsForm.$(".jsButtonServiceEdit");
    private SelenideElement saveEditServiceButton = breadCrumbsForm.$(".jsButtonServiceEditSave");
    private SelenideElement newMaterialBytton = materialBreadForm.$(".jsClick_init_materialAdd");
    private SelenideElement saveNewMaterialButton = materialBreadForm.$(".jsClick_submit_materialAdd");
    private SelenideElement newEmployeeButton = breadCrumbsForm.$(".jsButtonEmployeeAdd");
    private SelenideElement saveNewEmployeeButton = breadCrumbsForm.$(".jsButtonEmployeeAddSave");
    private SelenideElement editEmployeeButton = breadCrumbsForm.$(".jsButtonEmployeeEdit");
    private SelenideElement saveEditEmloyeeButton = breadCrumbsForm.$(".jsButtonEmployeeEditSave");
    private SelenideElement saveEditClientButton = breadCrumbsForm.$(".jsSaveButtonEdit");
    private SelenideElement scheduleActionButton = breadCrumbsForm.$(".jsClick_toggle_schedulePanel");
    private SelenideElement monthModeButton = $(".element_button.element-radiolist_button.class-month");
    private SelenideElement weeklyModeButton = $(".element_button.element-radiolist_button.class-week");
    private SelenideElement newAbonementButton = $(".jsClick_load_abonementAdd");
    private SelenideElement saveNewAbonementButton = $(".jsClick_submit_abonementAdd");
    private SelenideElement menuButton = $(".jsMenuButton ");
    private SelenideElement recordClientButton = breadCrumbsForm.$(".jsAddButton");
    private SelenideElement recordSaveButton = breadCrumbsForm.$(".jsButtonRecordSave");
    private SelenideElement saveTimeZoneButton = breadCrumbsForm.$(".jsButtonAccountSave");
    private SelenideElement saveInfoByCompanyButton = breadCrumbsForm.$(".jsButtonCompanySave");
    private SelenideElement saveLegalButton = breadCrumbsForm.$(".jsButtonLegalSave");
    private SelenideElement saveLeadSource = breadCrumbsForm.$(".jsButtonLeadSourceSave");
    private SelenideElement cancelNewClientSave = breadCrumbsForm.$(".jsCancelButton");
    private SelenideElement saveParamsClientButton = breadCrumbsForm.$(".jsButtonClientFieldsSave");


    public SelenideElement getSaveEditClientButton() { return saveEditClientButton; }

    public SelenideElement getAddClientButton() {
        return addClientButton;
    }

    public SelenideElement getSaveClientButton() { return saveClientButton; }

    public SelenideElement getCancelClientButton() {
        return cancelClientButton;
    }

    public SelenideElement getEditClientButton() { return editClientButton; }

    public SelenideElement getFilterButton() { return filterButton; }

    public SelenideElement getAddServiceButton() { return addServiceButton; }

    public SelenideElement getServiceAddSaveButton() { return serviceAddSaveButton; }

    public SelenideElement getEditServicesButton() {
        return editServicesButton;
    }

    public SelenideElement getSaveEditServiceButton() {
        return saveEditServiceButton;
    }

    public SelenideElement getNewMaterialBytton() { return newMaterialBytton; }

    public SelenideElement getSaveNewMaterialButton() { return saveNewMaterialButton; }

    public SelenideElement getNewEmployeeButton() { return newEmployeeButton; }

    public SelenideElement getSaveNewEmployeeButton() { return saveNewEmployeeButton; }

    public SelenideElement getEditEmployeeButton() { return editEmployeeButton; }

    public SelenideElement getSaveEditEmloyeeButton() { return saveEditEmloyeeButton; }

    public SelenideElement getScheduleActionButton() { return scheduleActionButton; }

    public SelenideElement getMonthModeButton() { return monthModeButton; }

    public SelenideElement getWeeklyModeButton() { return weeklyModeButton; }

    public SelenideElement getNewAbonementButton() { return newAbonementButton; }

    public SelenideElement getSaveNewAbonementButton() { return saveNewAbonementButton; }

    public SelenideElement getMenuButton() {
        return menuButton;
    }

    public SelenideElement getRecordClientButton() { return recordClientButton; }

    public SelenideElement getRecordSaveButton() { return recordSaveButton; }

    public SelenideElement getSaveTimeZoneButton() {
        return saveTimeZoneButton;
    }

    public SelenideElement getSaveInfoByCompanyButton() { return saveInfoByCompanyButton; }

    public SelenideElement getSaveLegalButton() {
        return saveLegalButton;
    }

    public SelenideElement getSaveLeadSource() { return saveLeadSource; }

    public SelenideElement getCancelNewClientSave() {
        return cancelNewClientSave;
    }

    public SelenideElement getSaveParamsClientButton() {
        return saveParamsClientButton;
    }
}
