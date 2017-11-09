package resources.credentials;

import resources.factoryresource.IFactoryResourceManager;

import java.util.ResourceBundle;

/**
 * Created by Renat on 02.06.2016.
 */
public class ProdCredeantials implements IFactoryResourceManager {

    private final static ProdCredeantials instance = new ProdCredeantials();

    private ResourceBundle bundle = ResourceBundle.getBundle("/credentials/credentials_prod.properties");

    public static ProdCredeantials getInstance() {
        return instance;
    }

    public String getValue(String key) {
        return bundle.getString(key);
    }

}
