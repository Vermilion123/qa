package section.calendar;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import section.breadcrumbs.BreadCrumbsPage;
import utils.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static config.StaticProp.getTestUrl;

/**
 * Created by Renat on 10.06.2016.
 */
public class Calendar {

    private BreadCrumbsPage bread;
    private CalendarPage calendarPage;
    private SelenideElement calendarVisible = $("#calendar");
    private String durationAppointment;

    public Calendar() {
        bread = new BreadCrumbsPage();
        calendarPage = new CalendarPage();
    }

    public void openSectionCalendar() { open(getTestUrl() + "/clientix/calendar/default"); }

    public void recordClientButtonClick() { bread.getRecordClientButton().should(Condition.visible).click(); }
    public void recordSaveButtonClick() { bread.getRecordSaveButton().should(Condition.visible).click(); }


    public void appointmentPanelColumnClientClick()   { calendarPage.getAppointmentPanelColumnClient().should(Condition.visible).click(); }
    public void appointmentPanelColumnServicesClick() { calendarPage.getAppointmentPanelColumnServices().should(Condition.visible).click(); }
    public void appointmentPanelColumnEmployeeClick() { calendarPage.getAppointmentPanelColumnEmployee().should(Condition.visible).click(); }

    public boolean hasAppointmentPanelClient()   { return calendarPage.getAppointmentAutocompleteClient().has(Condition.visible); }
    public boolean hasAppointmentPanelServices() { return calendarPage.getAppointmentAutocompleteServices().has(Condition.visible); }
    public boolean hasAppointmentPanelEmployee() { return calendarPage.getAppointmentAutocompleteEmployee().has(Condition.visible); }

    public void buttonTooltipShowCalendarClick() { calendarPage.getButtonTooltipShowCalendar().should(Condition.visible).click(); }

    public void openWaitingListButtonClick(String data) { calendarPage.getWaitingListButton(data).should(Condition.visible).click(); }

    public void addNewClientButtonClick() { calendarPage.getAppointmentNewClientButton().should(Condition.visible).click(); }

    public void fillDataClient(String name, String phone) {
        calendarPage.setName(name);
        calendarPage.setPhone(phone);
        if (calendarPage.getTypeOfPet().is(Condition.visible)) {
            calendarPage.setTypeOfPet("type");
        }
        if (calendarPage.getSubclientName().is(Condition.visible)) {
            calendarPage.setSubclientName("subclient");
        }
    }
    public void saveNewClientButtonClick() { calendarPage.getSaveNewClientButtonClick().should(Condition.visible).click(); }

    public String nameViewClient() { return calendarPage.getNameViewClient().text(); }
    public String phoneViewClient() { return Utils.unMaskPhone(calendarPage.getPhoneViewClient().text()); }

    public void saveNewRecordPopUpClick() { calendarPage.getSaveNewRecordPopUpButton().get(2).should(Condition.visible).click();}

    public void addNewRecord(String idEmployee, String date, String startTime) {
        calendarPage.getCalendarItem(idEmployee, date, startTime).should(Condition.visible).click();
    }

    public boolean hasAppointment(String idEmployee, String date, String startTime) {
        return calendarPage.getCalendarItem(idEmployee, date, startTime).$(".b-calendar-record_client").exists();
    }

    public String getClientNameAppointment(String idEmployee, String date, String startTime) {
        return calendarPage.getCalendarItem(idEmployee, date, startTime).$(".b-calendar-record_client").text();
    }

    public void firstPanelNotComingClick() { calendarPage.getFirstPanelNotComingButton().should(Condition.visible).click(); }

    public void firstPanelWantComeClick() { calendarPage.getFirstPanelWantComeButton().get(0).should(Condition.visible).click();}

    public String firstPanelTooltipText() { return calendarPage.getFirstPanelTooltip().should(Condition.visible).text(); }

    public boolean isCalendarVisible() { return calendarVisible.should(Condition.visible).is(Condition.visible); }

    public String firstPanelClientName() { return calendarPage.getFirstPanelClientName().text(); }

    public String firstPanelClientPhone() { return Utils.unMaskPhone(calendarPage.getFirstPanelClientPhone().text()); }

    public String firstPanelEmployeeName() { return calendarPage.getFirstPanelEmployeeName().text(); }

    public void firstPanelEditButtonClick() { calendarPage.getfirstPanelEditButton().should(Condition.visible).click(); }

    public String secondPanelClientName() { return calendarPage.getSecondPanelClientName().should(Condition.visible).text(); }

    public String secondPanelExecutorName() { return calendarPage.getSecondPanelExecutorName().should(Condition.visible).text(); }

    public void newAppointmentPopUpClick() { calendarPage.getNewAppointmentPopUp().should(Condition.visible).click(); }

    public void appointmentInputClient(String value) { calendarPage.setAppointmentInputClient(value); }

    public void appointmentInputService(String name) { calendarPage.setAppointmentInputService(name); }

    public String appointmentServiceErrorText() { return calendarPage.getAppointmentServiceErrorText().should(Condition.visible).text(); }

    public String appointmentClientErrorText() { return calendarPage.getAppointmentClientErrorText().should(Condition.visible).text(); }

    public void appointmentNewServiceButtonClick() { calendarPage.getAppointmentNewServiceButtonClick().should(Condition.visible).click(); }

    public void fillDataService(String name,String hh, String min) {
        calendarPage.setAppointmentServiceName(name);
        chooseDurationMin(min);
    }

    private void chooseDurationMin(String min) {
        calendarPage.getDurationMin().should(Condition.visible).click();
        calendarPage.chooseDurationMin(min).should(Condition.visible).click();
    }

    public void appointmentSaveNewServiceButtonClick() { calendarPage.getAppointmentSaveNewService().should(Condition.visible).click(); }

    public String getDurationAppointment(String idEmployee, String data, String startTime) { return parseDurationAppointment(calendarPage.getCalendarItem(idEmployee, data, startTime).should(Condition.visible).toString()); }

    private String parseDurationAppointment(String elem) {
        Pattern p = Pattern.compile("_\\d+m");
        Matcher m = p.matcher(elem);
        String r = "";
        if (m.find()) {
            r = m.group();
        }
        r = r.replaceAll("\\D+", "");
        return r;
    }

    public void removeAllAppontmentsToday(String date) {
        if (calendarPage.getAppointmentsList(date).size() != 0) {
            for (SelenideElement e : calendarPage.getAppointmentsList(date)) {
                e.should(Condition.visible).click();
                firstPanelNotComingClick();
                firstPanelWantComeClick();
            }
        }
    }

    public boolean calendarDaysVisible() {
        return calendarPage.getCalendarDays().should(Condition.visible).isDisplayed();
    }
}
