//package section.widget;
//
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.runner.RunWith;
//import org.junit.runners.JUnit4;
//import ru.yandex.qatools.allure.annotations.Stories;
//import section.authtorize.auth.Auth;
//
//import java.net.MalformedURLException;
//
//import static config.StaticProp.getTestUrl;
//import static config.StaticProp.setUp;
//import static config.StaticProp.testUrl;
//
///**
// * Created by Renat on 27.05.2016.
// */
//@Stories("Service story")
//@RunWith(JUnit4.class)
//public class TestWidget {
//
//    @BeforeClass
//    public static void setDriver() throws MalformedURLException {
//        setUp();
//    }
//
//    @BeforeClass
//    public static void setTestUrl() {
//        testUrl = getTestUrl() + "/login";
//    }
//
//    @BeforeClass
//    public static void Auth() {
//        Auth auth = new Auth();
//        auth.authByProperty(testUrl);
//    }
//
//
//
//
//
//
//    @AfterClass
//    public static void closeDriver() {
//        closeDriver();
//    }
//
//}
