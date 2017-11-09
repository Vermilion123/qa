package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import resources.CBParameter;

import java.net.MalformedURLException;
import java.net.URL;

import static config.os.OsHelper.getPathToDriverByOs;


/**
 * Created by Renat on 27.06.2016.
 */
public class WebDriverFactory {

    private static WebDriver factoryLocalDrivers() throws MalformedURLException {
        WebDriver driver = null;
        String browser = System.getProperty("browser").toLowerCase();
        if (browser.equals("chrome")) {
            driver = createChromeDriver();
        }
        return driver;
    }

    public static WebDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", getPathToDriverByOs());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        return new ChromeDriver(options);
    }

    public static WebDriver createRemoteDriver() {
        WebDriver driver = null;
        DesiredCapabilities caps  = readCapabilitiesFromPropertyes();
        try {
            driver = new RemoteWebDriver(new URL(StaticParameters.URL), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    public static WebDriver createDriver() throws MalformedURLException {
        WebDriver driver;
        boolean isRemote = Boolean.valueOf(System.getProperty("remote_testing"));
        if (isRemote) {
            driver = createRemoteDriver();
        } else {
            driver = factoryLocalDrivers();
        }
        return driver;
    }

    private static DesiredCapabilities readCapabilitiesFromPropertyes() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", CBParameter.BROWSER);
        caps.setCapability("browser_version", CBParameter.BROWSER_VERSION);
        caps.setCapability("os", CBParameter.OS);
        caps.setCapability("os_version", CBParameter.OS_VERSION);
        caps.setCapability("resolution", CBParameter.RESOLUTION);
        caps.setCapability("browserstack.debug", CBParameter.DEBUG);
        return caps;
    }

}
