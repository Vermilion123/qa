package base_test;

import com.codeborne.selenide.WebDriverRunner;
import config.WebDriverFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.net.MalformedURLException;

/**
 * Created by Renat on 27.06.2016.
 */
public class BaseTest {

    @BeforeClass
    public static void setUp() throws MalformedURLException {
        WebDriverRunner.setWebDriver(WebDriverFactory.createDriver());
    }

    @AfterClass
    public static void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}
