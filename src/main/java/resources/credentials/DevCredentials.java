package resources.credentials;

import resources.factoryresource.IFactoryResourceManager;

import java.util.ResourceBundle;

/**
 * Created by Renat on 02.06.2016.
 */
public class DevCredentials implements IFactoryResourceManager {

    private final static DevCredentials instance = new DevCredentials();

    private ResourceBundle bundle = ResourceBundle.getBundle("/credentials/credentials_dev.properties");

    public static DevCredentials getInstance() {
        return instance;
    }

    public String getValue(String key) {
        return bundle.getString(key);
    }

}
