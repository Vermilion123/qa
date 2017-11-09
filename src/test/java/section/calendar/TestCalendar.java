package section.calendar;

import base_test.BaseTest;
import com.codeborne.selenide.Condition;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.yandex.qatools.allure.annotations.Stories;
import section.authtorize.auth.Auth;
import section.calendar.controllers.CalendarController;
import section.employee.Employee;
import section.schedule.Schedule;
import utils.Utils;

import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static config.StaticProp.getTestUrl;

/**
 * Created by Renat on 10.06.2016.
 */
@Stories("Calendar Story")
@RunWith(JUnit4.class)
public class TestCalendar extends BaseTest {

    @BeforeClass
    public static void auth() {
        Auth auth = new Auth();
        auth.authByProperty(getTestUrl());
    }

    @Test
    public void testOpenAppointmentsForms() {
        String tmp = Utils.getTmpNumbersString(6);
        String name = "Autotest_" + tmp;
        String phone = Utils.getTmpNumbersString(10);
        String idEmployee;

        Employee employee = new Employee();
        employee.openSectionEmployee();
        employee.newEmployeeButtonClick();
        employee.fillEmployeeData(name, phone);
        employee.saveNewEmployeeButtonClick();
        sleep(300);
        idEmployee = employee.getId();
        String date = LocalDate.now().toString();
        String startTime = "08:00:00";


        Schedule schedule = new Schedule();
        schedule.openScheduleSection();
        schedule.addScheduleTodayByIdClick(idEmployee, date, startTime);
        Assert.assertEquals("08:00 - 16:00", schedule.getScheduleRecordTimeText(idEmployee, LocalDate.now().toString(),startTime));


        Calendar calendar = new Calendar();
        calendar.openSectionCalendar();
        Assert.assertTrue(calendar.calendarDaysVisible());
        calendar.recordClientButtonClick();

        calendar.appointmentPanelColumnClientClick();
        Assert.assertTrue(calendar.hasAppointmentPanelClient());
        calendar.buttonTooltipShowCalendarClick();

        calendar.appointmentPanelColumnServicesClick();
        Assert.assertTrue(calendar.hasAppointmentPanelServices());
        calendar.buttonTooltipShowCalendarClick();

        calendar.appointmentPanelColumnEmployeeClick();
        Assert.assertTrue(calendar.hasAppointmentPanelEmployee());
    }

    @Test
    public void addNewRecordByCrumb() {
        String tmp = Utils.getTmpNumbersString(6);
        String name = "Autotest_" + tmp;
        String phone = Utils.getTmpNumbersString(10);
        String idEmployee;

        Employee employee = new Employee();
        employee.openSectionEmployee();
        employee.newEmployeeButtonClick();
        employee.fillEmployeeData(name, phone);
        employee.saveNewEmployeeButtonClick();
        sleep(300);
        idEmployee = employee.getId();
        String date = LocalDate.now().toString();
        String startTime = "08:00:00";


        Schedule schedule = new Schedule();
        schedule.openScheduleSection();
        schedule.addScheduleTodayByIdClick(idEmployee, date, startTime);
        Assert.assertEquals("08:00 - 16:00", schedule.getScheduleRecordTimeText(idEmployee, LocalDate.now().toString(),startTime));

        Calendar calendar = new Calendar();
        calendar.openSectionCalendar();
        calendar.recordClientButtonClick();
        calendar.appointmentPanelColumnClientClick();
        calendar.addNewClientButtonClick();
        calendar.fillDataClient(name, phone);
        calendar.saveNewClientButtonClick();

        Assert.assertEquals(name, calendar.nameViewClient());
        Assert.assertEquals(phone, calendar.phoneViewClient());

        calendar.recordSaveButtonClick();
        calendar.addNewRecord(idEmployee, date, startTime);
        calendar.saveNewRecordPopUpClick();

        $("#recordPanelClientInfo").should(Condition.visible);
        Assert.assertTrue(calendar.hasAppointment(idEmployee, date, startTime));
        Assert.assertEquals(name, calendar.getClientNameAppointment(idEmployee, date, startTime));

        Assert.assertEquals(name, calendar.firstPanelClientName());
        Assert.assertEquals(phone, calendar.firstPanelClientPhone());
        Assert.assertEquals(name, calendar.firstPanelEmployeeName());

        calendar.firstPanelEditButtonClick();
        Assert.assertEquals(name, calendar.secondPanelClientName());
        Assert.assertEquals(name, calendar.secondPanelExecutorName());

        calendar.firstPanelNotComingClick();
        calendar.firstPanelWantComeClick();

        Assert.assertEquals("После закрытия панели запись будет убрана с календаря", calendar.firstPanelTooltipText());
     }

    @Test
    public void addNewAppointmentFromPopUp() {
        String tmp = Utils.getTmpNumbersString(6);
        String name = "Autotest_" + tmp;
        String phone = Utils.getTmpNumbersString(10);
        String idEmployee;

        Employee employee = new Employee();
        employee.openSectionEmployee();
        employee.newEmployeeButtonClick();
        employee.fillEmployeeData(name, phone);
        employee.saveNewEmployeeButtonClick();
        sleep(300);
        idEmployee = employee.getId();
        String date = LocalDate.now().toString();
        String startTime = "08:00:00";


        Schedule schedule = new Schedule();
        schedule.openScheduleSection();
        schedule.addScheduleTodayByIdClick(idEmployee, date, startTime);
        Assert.assertEquals("08:00 - 16:00", schedule.getScheduleRecordTimeText(idEmployee, LocalDate.now().toString(),startTime));

        Calendar calendar = new Calendar();
        calendar.openSectionCalendar();
        calendar.addNewRecord(idEmployee, date, startTime);
        calendar.newAppointmentPopUpClick();
        calendar.appointmentPanelColumnClientClick();
        calendar.addNewClientButtonClick();
        calendar.fillDataClient(name, phone);
        calendar.saveNewClientButtonClick();
        calendar.recordSaveButtonClick();

        $("#recordPanelClientInfo").should(Condition.visible);
        Assert.assertTrue(calendar.hasAppointment(idEmployee, date, startTime));
        Assert.assertEquals(name, calendar.getClientNameAppointment(idEmployee, date, startTime));
        Assert.assertEquals(name, calendar.firstPanelClientName());
        Assert.assertEquals(phone, calendar.firstPanelClientPhone());
        Assert.assertEquals(name, calendar.firstPanelEmployeeName());

        calendar.firstPanelEditButtonClick();
        Assert.assertEquals(name, calendar.secondPanelClientName());
        Assert.assertEquals(name, calendar.secondPanelExecutorName());

        calendar.firstPanelNotComingClick();
        calendar.firstPanelWantComeClick();

        Assert.assertEquals("После закрытия панели запись будет убрана с календаря", calendar.firstPanelTooltipText());

    }

    @Test
    public void validatorNotEmptyClientAndService() {
        String tmp = Utils.getTmpNumbersString(6);
        String name = "Autotest_" + tmp;
        String phone = Utils.getTmpNumbersString(10);
        String idEmployee;

        Employee employee = new Employee();
        employee.openSectionEmployee();
        employee.newEmployeeButtonClick();
        employee.fillEmployeeData(name, phone);
        employee.saveNewEmployeeButtonClick();
        sleep(300);
        idEmployee = employee.getId();
        String date = LocalDate.now().toString();
        String startTime = "08:00:00";


        Schedule schedule = new Schedule();
        schedule.openScheduleSection();
        schedule.addScheduleTodayByIdClick(idEmployee, date, startTime);
        Assert.assertEquals("08:00 - 16:00", schedule.getScheduleRecordTimeText(idEmployee, LocalDate.now().toString(),startTime));

        Calendar calendar = new Calendar();
        calendar.openSectionCalendar();
        calendar.addNewRecord(idEmployee, date, startTime);
        calendar.newAppointmentPopUpClick();
        calendar.appointmentPanelColumnClientClick();
        calendar.appointmentInputClient(name);
        calendar.appointmentPanelColumnServicesClick();
        calendar.appointmentInputService(name);
        calendar.recordSaveButtonClick();

        Assert.assertEquals("Выберите, пожалуйста, клиента", calendar.appointmentClientErrorText());
        Assert.assertEquals("Вам необходимо выбрать услугу из списка найденных ниже, либо добавить новую услугу. Также можно оставить выбор услуги пустым.",
                calendar.appointmentServiceErrorText());

    }

    @Test
    public void chooseClientAndNotEmptyService() {
        String tmp = Utils.getTmpNumbersString(6);
        String name = "Autotest_" + tmp;
        String phone = Utils.getTmpNumbersString(10);
        String idEmployee;

        Employee employee = new Employee();
        employee.openSectionEmployee();
        employee.newEmployeeButtonClick();
        employee.fillEmployeeData(name, phone);
        employee.saveNewEmployeeButtonClick();
        sleep(300);
        idEmployee = employee.getId();
        String date = LocalDate.now().toString();
        String startTime = "08:00:00";


        Schedule schedule = new Schedule();
        schedule.openScheduleSection();
        schedule.addScheduleTodayByIdClick(idEmployee, date, startTime);
        Assert.assertEquals("08:00 - 16:00", schedule.getScheduleRecordTimeText(idEmployee, LocalDate.now().toString(),startTime));

        Calendar calendar = new Calendar();
        calendar.openSectionCalendar();
        calendar.addNewRecord(idEmployee, date, startTime);
        calendar.newAppointmentPopUpClick();
        calendar.appointmentPanelColumnClientClick();
        calendar.addNewClientButtonClick();
        calendar.fillDataClient(name, phone);
        calendar.saveNewClientButtonClick();

        Assert.assertEquals(name, calendar.nameViewClient());
        Assert.assertEquals(phone, calendar.phoneViewClient());

        calendar.appointmentPanelColumnServicesClick();
        calendar.appointmentInputService(name);
        calendar.recordSaveButtonClick();
        Assert.assertEquals("Вам необходимо выбрать услугу из списка найденных ниже, либо добавить новую услугу. Также можно оставить выбор услуги пустым.",
                calendar.appointmentServiceErrorText());
    }

    @Test
    public void appointmentByCrumbWithServicesDifferentDuration() {
        String tmp = Utils.getTmpNumbersString(6);
        String name = "Autotest_" + tmp;
        String phone = Utils.getTmpNumbersString(10);

        String tmp2 = Utils.getTmpNumbersString(6);
        String name2 = "Autotest_" + tmp2;
        String phone2 = Utils.getTmpNumbersString(10);

        String tmp3 = Utils.getTmpNumbersString(6);
        String name3 = "Autotest_" + tmp3;
        String phone3 = Utils.getTmpNumbersString(10);

        String idEmployee;

        Employee employee = new Employee();
        employee.openSectionEmployee();
        employee.newEmployeeButtonClick();
        employee.fillEmployeeData(name, phone);
        employee.saveNewEmployeeButtonClick();
        sleep(300);
        idEmployee = employee.getId();
        String date = LocalDate.now().toString();
        String startTime = "08:00:00";

        Schedule schedule = new Schedule();
        schedule.openScheduleSection();
        schedule.addScheduleTodayByIdClick(idEmployee, date, startTime);
        Assert.assertEquals("08:00 - 16:00", schedule.getScheduleRecordTimeText(idEmployee, LocalDate.now().toString(),startTime));

        Calendar calendar = new Calendar();

        CalendarController controller = new CalendarController(calendar);
        calendar.openSectionCalendar();


        controller.addNewAppointmentWithServicDurationByCrumb(name,  phone,  "0", "15", idEmployee, date, startTime);
        controller.addNewAppointmentWithServicDurationByCrumb(name2, phone2, "0", "30", idEmployee, date, startTime);
        controller.addNewAppointmentWithServicDurationByCrumb(name3, phone3, "0", "45", idEmployee, date, startTime);

    }


    @After
    public void removeAppointmentsScheduleAndEmployee() {
        String date = LocalDate.now().toString();
        Calendar calendar = new Calendar();
        calendar.openSectionCalendar();
        Assert.assertTrue(calendar.calendarDaysVisible());
        calendar.removeAllAppontmentsToday(date);

        Schedule schedule = new Schedule();
        schedule.openScheduleSection();
        schedule.removeAllScheduleToday(date);

        Employee employee = new Employee();
        employee.openSectionEmployee();
        Assert.assertTrue(employee.isEmployeeListVisible());
        employee.removeAllEmployee();
    }

}
