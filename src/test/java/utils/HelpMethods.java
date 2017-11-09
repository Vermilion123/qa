package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Created by Renat on 01.03.2016.
 */
public class HelpMethods {

    public static String getTmpString() {
        return getTmpNumbersString(4);
    }

    public static String getTmpNumbersString(int length){
        StringBuilder builder = new StringBuilder();
        builder.append(System.currentTimeMillis());
        while(builder.length() < length){
            builder.append(System.currentTimeMillis());
        }
        return builder.toString().substring(builder.length() - length);
    }

    public static String unMaskPhone(String maskedPhone){
        maskedPhone = maskedPhone.substring(maskedPhone.indexOf("("));
        return maskedPhone.replaceAll("\\D", "");
    }

    public static String getTmpPhone(String countryCode, int lenght) {
        return countryCode + getTmpNumbersString(lenght);
    }

    public static void openNewTab(WebDriver driver){
        ((JavascriptExecutor)driver).executeScript("window.open();");
    }

    private static String[] prepareCodes(String pageSource){
        String left = "<body>";
        String right = "</body>";
        pageSource = pageSource.substring(pageSource.lastIndexOf(left) + left.length());
        pageSource = pageSource.substring(0, pageSource.indexOf(right));
        String [] ret = pageSource.split(",");
        for(int i = 0; i < ret.length; i++){
            ret[i] = ret[i].replaceAll("\\D", "");
        }
        return ret;
    }

    private static String[] prepareWord(String pageSource){
        String left = "<body>";
        String right = "</body>";
        pageSource = pageSource.substring(pageSource.lastIndexOf(left) + left.length());
        pageSource = pageSource.substring(0, pageSource.indexOf(right));
        String [] ret = pageSource.split(",");
        for(int i = 0; i < ret.length; i++){
            ret[i] = ret[i].replaceAll("\\W", "");
        }
        return ret;
    }

    public static String[] getSMSCodeFromBackdoor(String phone, String backdoorRoute){
        String ret = getDataFromBackdoor(backdoorRoute);
        return prepareCodes(ret);
    }

    public static String[] getCaptchaFromBackdoor(String backdoorRoute){
        String ret = getDataFromBackdoor(backdoorRoute);
        return prepareWord(ret);
    }

    public static String getDataFromBackdoor(String backdoorRoute){
        WebDriver driver = getWebDriver();
        String lastTab = driver.getWindowHandle();
        openNewTab(driver);
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        driver.navigate().to(backdoorRoute);
        String ret = getPageSourceFromBackdoor(driver);
        closeActiveTab(driver);
        driver.switchTo().window(lastTab);
        return ret;
    }

    @Step("получить исходники страницы бэкдора")
    public static String getPageSourceFromBackdoor(WebDriver driver) {
        return driver.getPageSource();
    }

    private static void closeActiveTab(WebDriver driver) {
        ((JavascriptExecutor)driver).executeScript("window.close();");
    }



}
