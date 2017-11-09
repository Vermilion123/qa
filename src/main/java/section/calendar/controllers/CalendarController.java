package section.calendar.controllers;

import org.junit.Assert;
import section.calendar.Calendar;

/**
 * Created by Renat on 14.06.2016.
 */
public class CalendarController {

    private Calendar calendar;

    public CalendarController(Calendar calendar) {
        this.calendar = calendar;
    }

    public void addNewAppointmentWithServicDurationByCrumb(String name, String phone, String hours, String min, String idEmployee, String date, String startTime) {
        calendar.recordClientButtonClick();
        calendar.appointmentPanelColumnClientClick();
        calendar.addNewClientButtonClick();
        calendar.fillDataClient(name, phone);
        calendar.saveNewClientButtonClick();

        calendar.appointmentPanelColumnServicesClick();
        calendar.appointmentNewServiceButtonClick();
        calendar.fillDataService(name, hours, min);
        calendar.appointmentSaveNewServiceButtonClick();

        calendar.recordSaveButtonClick();
        calendar.addNewRecord(idEmployee, date, startTime);
        calendar.recordSaveButtonClick();

        Assert.assertEquals(min, calendar.getDurationAppointment(idEmployee, date, startTime));

        calendar.firstPanelNotComingClick();
        calendar.firstPanelWantComeClick();
    }


}
