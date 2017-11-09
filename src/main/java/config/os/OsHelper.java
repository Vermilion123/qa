package config.os;

import config.StaticParameters;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Renat on 27.06.2016.
 */
public class OsHelper {

    private static Map<String, String> map = new HashMap<>();
    private static String OS;

    static {
        map.put("win", StaticParameters.DRIVER_WIN_PATH);
        map.put("unix", StaticParameters.DRIVER_UNIX_PATH);
        OS = System.getProperty("os.name").toLowerCase();
    }

    public static String getPathToDriverByOs() {
        if (isWindows())
            return map.get("win");
        return map.get("unix");
    }

    public static boolean isWindows() {
        return OS.contains("win");
    }
    public static void main(String[] args) {
        System.out.println(isWindows());
    }
}
