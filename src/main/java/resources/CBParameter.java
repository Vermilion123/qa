package resources;

/**
 * Created by Renat on 02.06.2016.
 */
public class CBParameter {
    private CBParameter() {}

    public static final String BROWSER          =   System.getProperty("browser");
    public static final String BROWSER_VERSION  =   System.getProperty("browser_version");
    public static final String OS               =   System.getProperty("os").replace("_", " ");
    public static final String OS_VERSION       =   System.getProperty("os_version").replace("_", " ");
    public static final String RESOLUTION       =   System.getProperty("browser_resolution");
    public static final String DEBUG            =   "true";
}
