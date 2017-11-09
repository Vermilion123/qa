package config.dns;

import static config.StaticProp.getBaseUrl;

/**
 * Created by Renat on 01.07.2016.
 */
public class URLHelper {

    public static String getTestUrl() {
        return getPreffix() + getBaseUrl() + getSuffix();
    }

    public static boolean isProd() {
        return getBaseUrl().equals("klientiks.ru");
    }

    public static boolean isPredProd() {
        return getBaseUrl().contains("test2");
    }

    public static boolean isDev() {
        return getBaseUrl().contains("zettacode");
    }

    private static String getPreffix() {
        return isProd() ? "https://" : "http://";
    }

    private static String getSuffix() {
        return isDev() ? "/gefest" : "";
    }
}
