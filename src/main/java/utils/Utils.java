
package utils;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.JavascriptExecutor;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static config.StaticProp.getDriver;

/**
 * Created by jazzt on 10.02.16.
 */
public class Utils {

    public static Boolean isPageLoad() {
        return
        ((JavascriptExecutor) getDriver()).executeScript("return document.readyState").equals("complete");
    }

    public static String getTmpNumbersString (int length) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        while (builder.length() < length) {
            builder.append(random.nextInt(10));
        }
        String result = builder.toString().substring(builder.length() - length);
        return result.charAt(0) == '0' ? result.replaceFirst("0", "1") : result;

    }

//    public static String getTmpNumbersString(int length) {
//        StringBuilder builder = new StringBuilder();
//        builder.append(System.currentTimeMillis());
//        while (builder.length() < length) {
//            builder.append(System.currentTimeMillis());
//        }
//        String result = builder.toString().substring(builder.length() - length);
//
//        return result.charAt(0) == '0' ? 1 + result : result;
//    }

    public static Map<String, String> getMapInfo(ElementsCollection key, ElementsCollection value) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < key.size(); i++) {
            map.put(key.get(i).getText(), value.get(i).getText());
        }
        return map;
    }

    public static String unMaskPhone(String maskedPhone){
        maskedPhone = maskedPhone.substring(maskedPhone.indexOf("("));
        return maskedPhone.replaceAll("\\D", "");
    }

    public static String  wrapperDate(String date) {
        return date.length() == 1 ? "0" + date : date;
    }

    public static void main(String[] args) {
        LocalDate.now().getMonth();
        System.out.println( Integer.parseInt(wrapperDate(String.valueOf(LocalDate.now().getMonthValue()))));
    }


}
