package section.features.params_client;

import base_test.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import section.authtorize.auth.Auth;
import section.client.Client;
import section.menu.features.Features;

import static config.StaticProp.getTestUrl;

/**
 * Created by Renat on 12.07.2016.
 */
@RunWith(JUnit4.class)
public class TestParamsClient extends BaseTest {

    @BeforeClass
    public static void auth() {
        Auth auth = new Auth();
        auth.authByProperty(getTestUrl());
    }

    @Before
    public  void openParams() {
        Features features = new Features();
        features.openSectionFeatures();
        features.openParamsClient();
    }

    @Test
    public void addressAndPassport() {
        ParamsClient param = new ParamsClient();
        param.address(true);
        param.passport(true);
        param.sex(true);
        param.saveButtonClick();

        Client client = new Client();
        client.openSectionClient();
        client.newClientButtonClick();

        Assert.assertTrue(client.isAddress());
        Assert.assertTrue(client.isPassport());
        Assert.assertTrue(client.isSex());

        Features features = new Features();
        features.openSectionFeatures();
        features.openParamsClient();
        param.address(false);
        param.passport(false);
        param.sex(false);
        param.saveButtonClick();
    }



}
