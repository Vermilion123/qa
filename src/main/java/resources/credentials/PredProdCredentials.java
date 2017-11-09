package resources.credentials;

import resources.factoryresource.IFactoryResourceManager;

import java.util.ResourceBundle;

/**
 * Created by Renat on 02.06.2016.
 */
public class PredProdCredentials implements IFactoryResourceManager {
    private final static PredProdCredentials instance = new PredProdCredentials();

    private ResourceBundle bundle = ResourceBundle.getBundle("/credentials/credentials_predprod.properties");

    public static PredProdCredentials getInstance() {
        return instance;
    }

    public String getValue(String key) {
        return bundle.getString(key);
    }

}
