package section.schedule;

import base_test.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.yandex.qatools.allure.annotations.Stories;
import section.authtorize.auth.Auth;
import section.calendar.Calendar;
import section.employee.Employee;
import utils.Utils;

import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.sleep;
import static config.StaticProp.getTestUrl;

/**
 * Created by Renat on 06.06.2016.
 */
@Stories("Schedule Story")
@RunWith(JUnit4.class)
public class TestShedule extends BaseTest {

    @BeforeClass
    public static void auth() {
        Auth auth = new Auth();
        auth.authByProperty(getTestUrl());
    }

    @Test
    public void testAddNewStuffAddHimSheduleThenRemoveStuff() {
        String tmp = Utils.getTmpNumbersString(6);
        String name = "Autotest_name_" + tmp;
        String phone = Utils.getTmpNumbersString(10);
        String idEmployee;

        Employee employee = new Employee();
        employee.openSectionEmployee();
        employee.newEmployeeButtonClick();
        employee.fillEmployeeData(name, phone);
        employee.saveNewEmployeeButtonClick();

        Assert.assertEquals(name, employee.getNameEmloyeeView());
        Assert.assertEquals(phone, employee.getPhoneEmployeeView());

        idEmployee = employee.getId();

        String startTime = "08:00:00";

        Schedule schedule = new Schedule();
        schedule.openScheduleSection();
        schedule.addScheduleTodayByIdClick(idEmployee, LocalDate.now().toString(),startTime);

        Assert.assertEquals(schedule.getScheduleRecordTimeText(idEmployee, LocalDate.now().toString(),startTime), "08:00 - 16:00");

        schedule.actionButtonClick();
        schedule.removeButtonClick();
        schedule.getScheduleRecordTimeClick(idEmployee, LocalDate.now().toString(), startTime);
        schedule.removeSelectedButtonClick();

        employee.openEmployeeByURL(idEmployee);
        employee.openRemoveItem();
        employee.removeButtonClick();
        sleep(300);
        Assert.assertEquals("Сотрудник удален", employee.getRemoveLabelView());
    }

    @Test
    public void notDisplayedDeleteEmployeeInSchedule() {
        String tmp = Utils.getTmpNumbersString(6);
        String name = "Autotest_name_" + tmp;
        String phone = Utils.getTmpNumbersString(10);
        String idEmployee;

        Employee employee = new Employee();
        employee.openSectionEmployee();
        employee.newEmployeeButtonClick();
        employee.fillEmployeeData(name, phone);
        employee.saveNewEmployeeButtonClick();

        Assert.assertEquals(name, employee.getNameEmloyeeView());
        Assert.assertEquals(phone, employee.getPhoneEmployeeView());

        idEmployee = employee.getId();

        employee.openRemoveItem();
        employee.removeButtonClick();
        sleep(300);
        Assert.assertEquals("Сотрудник удален", employee.getRemoveLabelView());

        Schedule schedule = new Schedule();
        schedule.openScheduleSection();

        Assert.assertFalse(schedule.hasDisplayedEmployee(idEmployee));
    }


    @Test
    public void removeSchedule() {
        String tmp = Utils.getTmpNumbersString(6);
        String name = "Autotest_name_" + tmp;
        String phone = Utils.getTmpNumbersString(10);
        String idEmployee;

        Employee employee = new Employee();
        employee.openSectionEmployee();
        employee.newEmployeeButtonClick();
        employee.fillEmployeeData(name, phone);
        employee.saveNewEmployeeButtonClick();

        Assert.assertEquals(name, employee.getNameEmloyeeView());
        Assert.assertEquals(phone, employee.getPhoneEmployeeView());

        idEmployee = employee.getId();
        String startTime = "08:00:00";

        Schedule schedule = new Schedule();
        schedule.openScheduleSection();
        schedule.addScheduleTodayByIdClick(idEmployee, LocalDate.now().toString(),startTime);

        Assert.assertEquals("08:00 - 16:00", schedule.getScheduleRecordTimeText(idEmployee, LocalDate.now().toString(),startTime));

        schedule.actionButtonClick();
        schedule.removeButtonClick();
        schedule.getScheduleRecordTimeClick(idEmployee, LocalDate.now().toString(), startTime);
        schedule.removeSelectedButtonClick();

        sleep(300);
        Assert.assertFalse(schedule.hasScheduleRecordTime(idEmployee, LocalDate.now().toString(), startTime));

        employee.openEmployeeByURL(idEmployee);
        employee.openRemoveItem();
        employee.removeButtonClick();
        sleep(300);
        Assert.assertEquals("Сотрудник удален", employee.getRemoveLabelView());

    }

    @Test
    public void swapScheduleBetweenTwoEmployees() {
        String tmp = Utils.getTmpNumbersString(6);
        String name1 = "Autotest_name_" + tmp;
        String phone1 = Utils.getTmpNumbersString(10);
        String idEmployee1;

        String tmp2 = Utils.getTmpNumbersString(6);
        String name2 = "Autotest_name_" + tmp2;
        String phone2 = Utils.getTmpNumbersString(10);
        String idEmployee2;

        String startTime = "08:00:00";
        String date = LocalDate.now().toString();

        Employee employee = new Employee();
        employee.openSectionEmployee();
        employee.newEmployeeButtonClick();
        employee.fillEmployeeData(name1, phone1);
        employee.saveNewEmployeeButtonClick();

        Assert.assertEquals(name1, employee.getNameEmloyeeView());
        Assert.assertEquals(phone1, employee.getPhoneEmployeeView());

        idEmployee1 = employee.getId();

        employee.newEmployeeButtonClick();
        employee.fillEmployeeData(name2, phone2);
        employee.saveNewEmployeeButtonClick();

        Assert.assertEquals(name2, employee.getNameEmloyeeView());
        Assert.assertEquals(phone2, employee.getPhoneEmployeeView());

        idEmployee2 = employee.getId();

        Schedule schedule = new Schedule();
        schedule.openScheduleSection();
        schedule.addScheduleTodayByIdClick(idEmployee1, date, startTime);
        schedule.getScheduleRecordTimeClick(idEmployee1, date, startTime);
        schedule.addScheduleTodayByIdClick(idEmployee2, date, startTime);

        Assert.assertEquals(schedule.getScheduleRecordTimeText(idEmployee2, LocalDate.now().toString(),startTime), "08:00 - 16:00");
        Assert.assertFalse(schedule.hasScheduleRecordTime(idEmployee1, LocalDate.now().toString(), startTime));

        schedule.actionButtonClick();
        schedule.removeButtonClick();
        schedule.getScheduleRecordTimeClick(idEmployee2, LocalDate.now().toString(), startTime);
        schedule.removeSelectedButtonClick();

        employee.openEmployeeByURL(idEmployee1);
        employee.openEmployeeByURL(idEmployee1);
        employee.openRemoveItem();
        employee.removeButtonClick();
        sleep(300);
        Assert.assertEquals("Сотрудник удален", employee.getRemoveLabelView());

        employee.openEmployeeByURL(idEmployee2);
        employee.openEmployeeByURL(idEmployee2);
        employee.openRemoveItem();
        employee.removeButtonClick();
        sleep(300);
        Assert.assertEquals("Сотрудник удален", employee.getRemoveLabelView());

    }

    @Test
    public void moveScheduleTo8Hours() {
        String tmp = Utils.getTmpNumbersString(6);
        String name = "Autotest_name_" + tmp;
        String phone = Utils.getTmpNumbersString(10);
        String idEmployee;

        Employee employee = new Employee();
        employee.openSectionEmployee();
        employee.newEmployeeButtonClick();
        employee.fillEmployeeData(name, phone);
        employee.saveNewEmployeeButtonClick();

        Assert.assertEquals(name, employee.getNameEmloyeeView());
        Assert.assertEquals(phone, employee.getPhoneEmployeeView());

        idEmployee = employee.getId();
        String startTime1 = "08:00:00";
        String startTime2 = "16:00:00";
        String date = LocalDate.now().toString();

        Schedule schedule = new Schedule();
        schedule.openScheduleSection();
        schedule.addScheduleTodayByIdClick(idEmployee, date, startTime1);
        schedule.getScheduleRecordTimeClick(idEmployee, date, startTime1);

        schedule.addScheduleTodayByIdClick(idEmployee, date, startTime2);

        // todo make test with settings work time company 16 hours
        Assert.assertEquals(schedule.getScheduleRecordTimeText(idEmployee, LocalDate.now().toString(),"13:30:00"), "13:30 - 21:30");

        schedule.actionButtonClick();
        schedule.removeButtonClick();
        schedule.getScheduleRecordTimeClick(idEmployee, LocalDate.now().toString(), "13:30:00");
        schedule.removeSelectedButtonClick();

        employee.openEmployeeByURL(idEmployee);
        employee.openRemoveItem();
        employee.removeButtonClick();
        sleep(300);
        Assert.assertEquals("Сотрудник удален", employee.getRemoveLabelView());
    }

    //todo not work hz why
//    @Test
//    public void addScheduleInModeMonth() {
//        String tmp = Utils.getTmpNumbersString(6);
//        String name = "Autotest_name_" + tmp;
//        String phone = Utils.getTmpNumbersString(10);
//        String idEmployee;
//
//        Employee employee = new Employee();
//        employee.openSectionEmployee();
//        employee.newEmployeeButtonClick();
//        employee.fillEmployeeData(name, phone);
//        employee.saveNewEmployeeButtonClick();
//
//        Assert.assertEquals(name, employee.getNameEmloyeeView());
//        Assert.assertEquals(phone, employee.getPhoneEmployeeView());
//
//        idEmployee = employee.getId();
//        String month = Utils.wrapperDate("" +LocalDate.now().getMonthValue());
//        String year = "" + LocalDate.now().getYear();
//        String day = "" + LocalDate.now().getDayOfMonth();
//
//        Schedule schedule = new Schedule();
//        schedule.openScheduleSection();
//        schedule.openMonthMode();
//        schedule.addScheduleInMothByIdClick(idEmployee, year, month, day);
//
//
//        Assert.assertTrue(schedule.hasScheduledInMonthRecordTime(idEmployee, year, month, day));
//
//        schedule.actionButtonClick();
//        schedule.removeButtonClick();
//        sleep(500);
//        schedule.getScheduleInMothByIdClick(idEmployee, year, month, day);
//        schedule.removeSelectedButtonClick();
//
//        employee.openEmployeeByURL(idEmployee);
//        employee.openRemoveItem();
//        employee.removeButtonClick();
//        sleep(300);
//        Assert.assertEquals("Сотрудник удален", employee.getRemoveLabelView());
//    }


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
