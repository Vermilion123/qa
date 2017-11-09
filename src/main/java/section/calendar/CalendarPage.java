package section.calendar;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by Renat on 10.06.2016.
 */

public class CalendarPage {


    private SelenideElement appointmentPanelColumnClient   = $("#addEditAppointment .jsColumnClient");
    private SelenideElement appointmentPanelColumnServices = $("#addEditAppointment .jsColumnService");
    private SelenideElement appointmentPanelColumnEmployee = $("#addEditAppointment .jsColumnSpecialist");
    private SelenideElement appointmentAutocomplete = $("#addEditAppointment #jsClientsAutocompleteList");
    private SelenideElement appointmentAutocompleteServices = $("#addEditAppointment #jsServicesAutocompleteList");
    private SelenideElement appointmentAutocompleteEmployee = $("#addEditAppointment #jsExecutorsAutocompleteList");
    private SelenideElement buttonTooltipShowCalendar = $("#addEditAppointment .jsTooltipShowCalendar");
    private SelenideElement appointmentNewClientButton = $("#formWidget .jsButtonClientAdd");
    private SelenideElement subclientName = $("#Clients #label-subclient_name");
    private SelenideElement typeOfPet = $("#Clients #label-species");
    private SelenideElement name = $("#Clients #label-first_name");
    private SelenideElement phone = $("#Clients #label-phone");
    private SelenideElement saveNewClientButtonClick = $("#Clients .jsButtonClientSave");
    private SelenideElement nameViewClient = $("#viewChosenClient .b-appointment-viewclient-client_name");
    private SelenideElement phoneViewClient = $("#viewChosenClient .b-appointment-viewclient-phone");
    private ElementsCollection saveNewRecordPopUpButton = $$("#calendar .jsSaveNewAppointmentPopUp");
    private SelenideElement firstPanelNotComingButton = $(".jsCalendarPanels .jsNotButtonHasntCome");
    private ElementsCollection firstPanelWantComeButton = $$(".jsCalendarPanels .jsButtonWontCome");
    private SelenideElement firstPanelTooltip = $(".jsTooltipText");
    private SelenideElement firstPanelClientName = $("#recordPanelClientInfo .p-calendar-record-client_name");
    private SelenideElement firstPanelClientPhone = $("#recordPanelClientInfo .p-calendar-record-phone");
    private SelenideElement firstPanelEmployeeName = $("#recordPanelInfo .p-calendar-record-info_string");
    private SelenideElement firstPanelEditButton = $(".jsTabEdit");
    private SelenideElement secondPanelExecutorName = $("#viewEditAppointment .p-calendar-appointment-client_name");
    private SelenideElement secondPanelClientName = $("#viewEditAppointment .p-calendar-appointment-executor_name");
    private SelenideElement newAppointmentPopUp = $(".jsAddNewAppointmentPopUp");
    private SelenideElement appointmentInputClient = $("#label-client_id");
    private SelenideElement appointmentInputService = $("#label-services_ids");
    private SelenideElement appointmentServiceErrorText = $("#services_ids .element_error");
    private SelenideElement appointmentClientErrorText = $("#client_id .element_error");
    private SelenideElement appointmentNewServiceButtonClick = $("#formWidget .jsButtonServiceAdd");
    private SelenideElement appointmentServiceName = $("#addService #label-name");
    private SelenideElement durationMin = $("#duration_min");
    private SelenideElement appointmentSaveNewService = $("#submit button");
    private SelenideElement calendarDays = $("#calendar .b-calendar_days");

    public SelenideElement getAppointmentPanelColumnClient() {
        return appointmentPanelColumnClient;
    }

    public SelenideElement getAppointmentPanelColumnServices() {
        return appointmentPanelColumnServices;
    }

    public SelenideElement getAppointmentPanelColumnEmployee() {
        return appointmentPanelColumnEmployee;
    }

    public SelenideElement getAppointmentAutocompleteClient() {
        return appointmentAutocomplete;
    }

    public SelenideElement getAppointmentAutocompleteServices() {
        return appointmentAutocompleteServices;
    }

    public SelenideElement getAppointmentAutocompleteEmployee() {
        return appointmentAutocompleteEmployee;
    }

    public SelenideElement getButtonTooltipShowCalendar() {
        return buttonTooltipShowCalendar;
    }

    public SelenideElement getWaitingListButton(String data) {
        return $("[data-date='" + data + "'] .b-calendar-day-waitinglist");
    }

    public SelenideElement getAppointmentNewClientButton() {
        return appointmentNewClientButton;
    }

    public SelenideElement getSubclientName() {
        return subclientName;
    }

    public void setSubclientName(String name) {
        this.subclientName.val(name);
    }

    public SelenideElement getTypeOfPet() {
        return typeOfPet;
    }

    public void setTypeOfPet(String type) {
        typeOfPet.val(type);
    }

    public void setName(String name) {
        this.name.val(name);
    }

    public void setPhone(String phone) {
        this.phone.val(phone);
    }

    public SelenideElement getSaveNewClientButtonClick() {
        return saveNewClientButtonClick;
    }

    public SelenideElement getNameViewClient() {
        return nameViewClient;
    }

    public SelenideElement getPhoneViewClient() {
        return phoneViewClient;
    }

    public ElementsCollection getSaveNewRecordPopUpButton() {
        return saveNewRecordPopUpButton;
    }


    public SelenideElement getCalendarItem(String idEmployee, String date, String startTime) {
        return $("#calendar " +
                "[data-date='" + date +"'] "
                + "[data-master='" + idEmployee + "'] "
                + "[data-start='" + date + " "+ startTime + "']");
    }

    public SelenideElement getFirstPanelNotComingButton() {
        return firstPanelNotComingButton;
    }

    public ElementsCollection getFirstPanelWantComeButton() { return firstPanelWantComeButton; }

    public SelenideElement getFirstPanelTooltip() {
        return firstPanelTooltip;
    }

    public SelenideElement getFirstPanelClientName() { return firstPanelClientName; }

    public SelenideElement getFirstPanelClientPhone() { return firstPanelClientPhone; }

    public SelenideElement getFirstPanelEmployeeName() { return firstPanelEmployeeName; }

    public SelenideElement getfirstPanelEditButton() { return firstPanelEditButton; }

    public SelenideElement getSecondPanelExecutorName() { return secondPanelExecutorName; }

    public SelenideElement getSecondPanelClientName() { return secondPanelClientName; }

    public SelenideElement getNewAppointmentPopUp() { return newAppointmentPopUp; }

    public void setAppointmentInputClient(String value) {
        this.appointmentInputClient.val(value);
    }

    public void setAppointmentInputService(String name) {
        this.appointmentInputService.val(name);
    }

    public SelenideElement getAppointmentServiceErrorText() {
        return appointmentServiceErrorText;
    }

    public SelenideElement getAppointmentClientErrorText() {
        return appointmentClientErrorText;
    }

    public SelenideElement getAppointmentNewServiceButtonClick() { return appointmentNewServiceButtonClick; }

    public void setAppointmentServiceName(String name) { appointmentServiceName.val(name); }

    public SelenideElement getDurationMin() { return durationMin;}

    public SelenideElement chooseDurationMin(String min) {
        return $("#duration_min [data-id='" + min +"']");
    }

    public SelenideElement getAppointmentSaveNewService() {
        return appointmentSaveNewService;
    }

    public SelenideElement durationAppointment(String idEmployee, String data, String startTime) {
        return null;
    }

    public ElementsCollection getAppointmentsList(String date) {
        return $$("#calendar [data-date='" + date + "'] [data-master] [data-id] ");
    }

    public SelenideElement getCalendarDays() {
        return calendarDays;
    }
}

// #calendar [data-date='2016-06-10'] [data-master='3748'] [data-start='2016-06-10 13:45:00']