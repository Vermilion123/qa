package resources;

import config.PropertyUtils;
import resources.credentials.DevCredentials;
import resources.credentials.PredProdCredentials;
import resources.credentials.ProdCredeantials;
import resources.factoryresource.IFactoryResourceManager;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Renat on 02.06.2016.
 */
public class FactoryResourceManager {

    public static Properties getInstance() throws IOException {
        return new PropertyUtils().getInstance();
    }

    public static IFactoryResourceManager getDev() {
        return BSResourceManager.getInstance();
    }

    public static IFactoryResourceManager getResourceManager(String prop) {
        IFactoryResourceManager resourceManager;
        switch (prop) {
            case "PROD":
                resourceManager = ProdCredeantials.getInstance();
                break;
            case "PEDPROD":
                resourceManager = PredProdCredentials.getInstance();
                break;
            case "DEV":
                resourceManager = DevCredentials.getInstance();
                break;
            case "BROUSERSTACK":
                resourceManager = BSResourceManager.getInstance();
        }
        return PredProdCredentials.getInstance();
    }

}
