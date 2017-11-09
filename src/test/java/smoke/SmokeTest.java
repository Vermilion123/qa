//package smoke;
//
//import com.codeborne.selenide.Condition;
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.JUnit4;
//import org.junit.runners.MethodSorters;
//import ru.yandex.qatools.allure.annotations.Step;
//import ru.yandex.qatools.allure.annotations.Stories;
//import section.authtorize.auth.Auth;
//import section.authtorize.registr.RegisterPage;
//import section.clendar.CalendarStepsNew;
//import section.clendar.ServicesStepsNew;
//import section.clients.ClientPage;
//import section.employee.EmployeePage122;
//import section.schedule.steps.ScheduleStepsNew;
//import section.services.ServicesPage;
//import utils.HelpMethods;
//import utils.Utils;
//
//import java.net.MalformedURLException;
//
//import static com.codeborne.selenide.Selenide.*;
//import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
//import static config.StaticProp.*;
//
//
//
//@Stories("SmokeTest for one account. Register - Make something - Delete Account")
//@FixMethodOrder(MethodSorters.JVM)
//@RunWith(JUnit4.class)
//public class SmokeTest {
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
//    @Test
//    public void registTest() throws Exception {
//        RegisterPage page = new RegisterPage();
//        // iphone 79817225284
//        page.register("Autotest", "79817225284");
//    }
//
//    @Test
//    public void servicesVanishAfterMin() {
//        Auth auth = new Auth();
//        auth.authByProperty(testUrl);
//
//        open(getTestUrl() +"/clientix/services/default"); // todo
//
//        String tmpNumbersString = Utils.getTmpNumbersString(6);
//        String //name="autoset " + tmpNumbersString,
//                price = Utils.getTmpNumbersString(4),
//                groups="auto set hero";
//        ServicesPage services = new ServicesPage();
//        services.addNewService(tmpNumbersString, groups, price, "1", "30");
//        sleep(60000);
//        services.checkAfter1Min(tmpNumbersString);
////        open(getTestUrl() + "/site/logout");
////        $(".p-auth_right_center").should(Condition.visible);
//    }
//
//    @Test
//    public void clientsVanishesAfterMin() throws InterruptedException {
////        Auth auth = new Auth();
////        auth.authByProperty(testUrl);
//
//        open(getTestUrl() + "/clientix/client/default"); // todo
//        String tmpNumbersString = Utils.getTmpNumbersString(6);
//        String //name="autoset " + tmpNumbersString,
//                phoneClient= Utils.getTmpNumbersString(11),
//                groups="auto set hero";
//        ClientPage client = new ClientPage();
//        //client.addNewClient(tmpNumbersString, phoneClient, groups);
//        sleep(60000);
//        client.checkAfter1Min(tmpNumbersString);
////        open(getTestUrl() + "/site/logout");
////        $(".p-auth_right_center").should(Condition.visible);
//    }
//
//    @Test
//    public void employeeAdd() {
////        Auth auth = new Auth();
////        auth.authByProperty(testUrl);
//
//        open(getTestUrl() + "/clientix/employee/default"); // todo
//        EmployeePage122 employee = new EmployeePage122();
//        String name="autoset " + Utils.getTmpNumbersString(6),
//                phone2 = Utils.getTmpNumbersString(11), position = "admin";
//        employee.addEmployee(name, phone2);
//        employee.checkAdd(name, phone2, position);
//        employee.checkAccess();
//        employee.removeStuff();
////        open(getTestUrl() + "/site/logout");
////        $(".p-auth_right_center").should(Condition.visible);
//
//    }
//
//    @Test
//    public void serviceFilterArchive() {
////        Auth auth = new Auth();
////        auth.authByProperty(testUrl);
//        //===
//        open(getTestUrl() + "/clientix/services/default"); // todo
//
//        String name= Utils.getTmpNumbersString(4),
//                price = Utils.getTmpNumbersString(4),
//                groups="archive";
//        ServicesPage services = new ServicesPage();
//        services.addNewService(name, groups, price, "1", "30");
//        sleep(60000);
//        services.makeArchive();
//        open(getTestUrl() + "/clientix/services/default");
//        services.checkFilterArchive(name);
////        open(getTestUrl() + "/site/logout");
////        $(".p-auth_right_center").should(Condition.visible);
//
//    }
//
//    @Test
//    public void serviceFilterPromoted() {
////        Auth auth = new Auth();
////        auth.authByProperty(testUrl);
//        //===
//        open(getTestUrl() + "/clientix/services/default"); // todo
//
//        String name= Utils.getTmpNumbersString(4),
//                price = Utils.getTmpNumbersString(4),
//                groups="promoted";
//        ServicesPage services = new ServicesPage();
//        services.addNewService(name, groups, price, "1", "30");
//        sleep(60000);
//        services.makePromoted(name);
//        open(getTestUrl() + "/clientix/services/default");
//        services.checkFilterPromoted(name);
////        open(getTestUrl() + "/site/logout");
////        $(".p-auth_right_center").should(Condition.visible);
//
//    }
//
//    @Test
//    public void serviceFilterGroups() {
////        Auth auth = new Auth();
////        auth.authByProperty(testUrl);
//        //===
//        open(getTestUrl() + "/clientix/services/default"); // todo
//        String name= Utils.getTmpNumbersString(4),
//                price = Utils.getTmpNumbersString(4),
//                groups="promoted";
//        ServicesPage services = new ServicesPage();
//        services.addNewService(name, groups, price, "1", "30");
//        sleep(60000);
//        services.checkFilterGroups(groups);
////        open(getTestUrl() + "/site/logout");
////        $(".p-auth_right_center").should(Condition.visible);
//
//    }
//
//
//    //@Test
//    public void smokeCalendar() {
////        Auth auth = new Auth();
////        auth.authByProperty(testUrl);
//
//
//        String tmp = Utils.getTmpNumbersString(6);
//        String name =  tmp;
//        String phone = Utils.getTmpNumbersString(11);
//        String services = "autoTest " + tmp;
//
//
//        open(getTestUrl() + "/clientix/schedule/default");
//        ScheduleStepsNew scheduleStepsNew = new ScheduleStepsNew();
//        String day = HelpMethods.getToday();
//
//
//        String nameStuff = $$(".b-schedule-title_name").get(0).text();//scheduleStepsNew.getNameStuffCollection()[0];
//        scheduleStepsNew.addSheduleByNameToday(nameStuff, day);
//
//
//        open(getTestUrl() + "/clientix/calendar/default");
//        CalendarStepsNew calendar = new CalendarStepsNew();
//        ServicesStepsNew service2 = new ServicesStepsNew();
//        // TODO: добавить проверку невозможности удаления расписания при существующей записи
//        calendar.addAppoinmentByNameWithService(nameStuff, day, name, phone, name, name, tmp, 2, 1, service2);
//        calendar.check2panel(nameStuff, day, name, phone, name, name, tmp, 2, 1);
//        calendar.check2PanelValues(day, nameStuff, name, phone);
//        calendar.check3PanelValues(name, nameStuff, name);
//        calendar.checkWillComeAndNotCome(day, nameStuff, name, name);
//        calendar.checkComeAndNotCome(day, nameStuff, name, name);
//    }
//
//
//    @Step
//    public void deleteAccount() {
//        open(getPreffix() + getBaseUrl() + "/clientix/BD/SuicideEntireAccount");
//        back();
//        $(".p-auth").should(Condition.visible);
//    }
//
//    @AfterClass
//    public static void logout() {
//        closeWebDriver();
//    }
//}
