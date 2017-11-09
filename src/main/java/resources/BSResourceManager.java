package resources;

import resources.factoryresource.IFactoryResourceManager;

import java.util.ResourceBundle;

/**
 * Created by Renat on 02.06.2016.
 */
public class BSResourceManager implements IFactoryResourceManager{
    private final static BSResourceManager instance = new BSResourceManager();

    private ResourceBundle bundle = ResourceBundle.getBundle("bs.properties");

    public static BSResourceManager getInstance() {
        return instance;
    }

    public String getValue(String key) {
        return bundle.getString(key);
    }
}
