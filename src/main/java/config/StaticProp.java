package config;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import resources.CBParameter;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

/**
 * Created by Renat on 04.02.2016.
 */
public class StaticProp {


    //TODO 1- вынести константы в проперти; 2 - вынести propertyload отдельно
//    public static final String USERNAME = manager.getValue("bs.user");
//    public static final String AUTOMATE_KEY = manager.getValue("bs.key");
    public static final String USERNAME = "daniilprytkov1";
    public static final String AUTOMATE_KEY = "GPFzuC5Lxw8bXztJpujN";
    public static final String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
    public static String testUrl;
    public static final String BASE_URL = "base_url";
    private static final String DRIVER_WIN_PATH = "drivers/win/chromedriver.exe";
    private static WebDriver driver;

    private static DesiredCapabilities readCapabilitiesFromPropertyes() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser",           CBParameter.BROWSER);
        caps.setCapability("browser_version",   CBParameter.BROWSER_VERSION);
        caps.setCapability("os",                CBParameter.OS);
        caps.setCapability("os_version",        CBParameter.OS_VERSION);
        caps.setCapability("resolution",        CBParameter.RESOLUTION);
        caps.setCapability("browserstack.debug",CBParameter.DEBUG);
        return caps;
    }


    public static WebDriver createDriver() throws MalformedURLException {
        WebDriver driver;
        Boolean isRemote = Boolean.valueOf(System.getProperty("remote_testing"));
        if (isRemote) {
            DesiredCapabilities caps = readCapabilitiesFromPropertyes();
            driver = new RemoteWebDriver(new URL(URL), caps);
        } else {
            System.setProperty("webdriver.chrome.driver", DRIVER_WIN_PATH);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static void setUp() throws MalformedURLException {
        WebDriverRunner.setWebDriver(createDriver());
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static String getTestUrl() {
        return getPreffix() + getBaseUrl() + getUrlSuffix();
    }

    public static String getBaseUrl() {
        return System.getProperty(BASE_URL);
    }

    public static String getPreffix() {
        if (!getBaseUrl().contains("test2") ||
                !getBaseUrl().contains("zettacode"))
            return "http://";
        return "https://";
    }
    private static String getUrlSuffix() {
        if (getBaseUrl().contains("klientiks.ru")) {
            return "";
        } else {
            return "/gefest";
        }
    }


    public static boolean isProd() { return getBaseUrl().equals("klientiks.ru"); }
    public static boolean isPredprod() { return getBaseUrl().contains("test2"); }


    public static Properties loadCredentialPropertyes() {
        if (getBaseUrl().contains("zettacode")) return loadPropertyes("src/main/resources/credentials/credentials_dev.properties");
        else if (getBaseUrl().contains("test2")) return loadPropertyes("src/main/resources/credentials/credentials_predprod.properties");
        else return loadPropertyes("src/main/resources/credentials/credentials_prod.properties");
    }

    public static Properties loadPropertyes(String filename) {
        Properties prop = new Properties();
        try  {
            prop.load(new FileInputStream(filename));
        } catch (IOException e) {
            System.out.println("properties file not found" + filename);
            e.printStackTrace();
        }
        return prop;
    }
}
