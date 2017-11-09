//package section.waitinglist;
//
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.JUnit4;
//import ru.yandex.qatools.allure.annotations.Stories;
//import section.authtorize.auth.Auth;
//
//import java.net.MalformedURLException;
//
//import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
//import static config.StaticProp.*;
//
///**
// * Created by Renat on 09.06.2016.
// */
//@Stories("WaitingList Story")
//@RunWith(JUnit4.class)
//public class TestWaitingList {
//
//    @BeforeClass
//    public static void setDriver() throws MalformedURLException {
//        setUp();
//    }
//    @BeforeClass
//    public static void setTestUrl() {
//        testUrl = getTestUrl() + "/login";
//    }
//
//
//    @BeforeClass
//    public static void auth() {
//        Auth auth = new Auth();
//        auth.authByProperty(testUrl);
//    }
//
//    @Test
//    public void addNewWaitingListItemFromAutocomplete() {
////        String tmp = Utils.getTmpNumbersString(6);
////        String name = "Autotest_name_" + tmp;
////        String phone = Utils.getTmpNumbersString(10);
////        String idEmployee;
////
////        Employee employee = new Employee();
////        employee.openSectionEmployee();
////        employee.newEmployeeButtonClick();
////        employee.fillEmployeeData(name, phone);
////        employee.saveNewEmployeeButtonClick();
////        sleep(300);
////        idEmployee = employee.getId();
////        String data = LocalDate.now().toString();
//////        String startTime = "08:00:00";
////
//////        Schedule schedule = new Schedule();
//////        schedule.addScheduleTodayByIdClick(idEmployee, data, startTime);
////
////
//
//        //if (waitingList.hasFirstClientAutocomplete()) {
////        waitingList.firstClientAutocompleteClick();
////        Calendar calendar = new Calendar();
////        calendar.openWaitingListButtonClick(data);
////        WaitingList waitingList = new WaitingList();
////        waitingList.newWaitingListItemButtonClick();
////        waitingList.autocompleteClientClick();
////        waitingList.inputClientName(name);
////        waitingList.inputClientPhone(phone);
////        waitingList.saveNewClient();
////        waitingList.autocompleteEmployeeClick();
////        waitingList.firstEmployeeAutocompleteClick();
//
//
//    }
//
//    @AfterClass
//    public static void closeDriver() {
//        closeWebDriver();
//    }
//}
