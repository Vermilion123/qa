package config.credentials;


import config.StaticParameters;
import config.dns.URLHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Renat on 01.07.2016.
 */
public class CredentialsLoader {

    private CredentialsLoader() {}

    public static Properties getInstance() {
        return fabricCredentials();
    }

    private static Properties fabricCredentials() {
        Properties properties = null;
        if (URLHelper.isProd()) {
            properties = loadCredentials(StaticParameters.prodCredentialsPath);
        } else if (URLHelper.isPredProd()) {
            properties = loadCredentials(StaticParameters.predProdCredentialsPath);
        } else if (URLHelper.isDev()) {
            properties = loadCredentials(StaticParameters.devCredentialsPath);
        }
        return properties;
    }

    private static Properties loadCredentials(String filename) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
