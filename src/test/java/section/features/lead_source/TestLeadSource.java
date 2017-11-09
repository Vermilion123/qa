
package section.features.lead_source;

import base_test.BaseTest;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import section.authtorize.auth.Auth;
import section.client.Client;
import section.menu.features.Features;
import utils.Utils;

import static com.codeborne.selenide.Selenide.sleep;
import static config.StaticProp.getTestUrl;

/**
 * Created by Renat on 05.07.2016.
 */
@RunWith(JUnit4.class)
public class TestLeadSource extends BaseTest {

    @BeforeClass
    public static void auth() {
        Auth auth = new Auth();
        auth.authByProperty(getTestUrl());
    }

    @Before
    public void openSection() {
        Features features = new Features();
        features.openSectionFeatures();
        LeadSource leadSource = new LeadSource();
        leadSource.openLeadSourceSection();
    }

    @Test
    public void addNewSource() {
        LeadSource leadSource = new LeadSource();
        String source = "source_" + Utils.getTmpNumbersString(5);
        leadSource.addSource(source);
        leadSource.saveButtonClick();
        leadSource.openLeadSourceSection();
        Assert.assertTrue(leadSource.containsSourceCollection(source));
    }

    @Test
    public void removeSource() {
        LeadSource leadSource = new LeadSource();
        String source = "source_" + Utils.getTmpNumbersString(5);
        leadSource.addSource(source);
        leadSource.remove(source);
        leadSource.saveButtonClick();
        leadSource.openLeadSourceSection();
        Assert.assertFalse(leadSource.containsSourceCollection(source));
    }

    @Test
    public void newSourceInClientAndFilter() {
        LeadSource source = new LeadSource();
        String sourceName = "source_" + Utils.getTmpNumbersString(3);
        source.addSource(sourceName);
        source.askSourceClient(true);
        source.saveButtonClick();

        Client client = new Client();
        client.openSectionClient();
        client.newClientButtonClick();
        client.leadSourceClick();

        Assert.assertTrue(client.containsLeadSourceCollection(sourceName));
        client.cancelNewClientSaveButtonClick();

        client.filterClick();
        client.filterLeadSourceClick();
        Assert.assertTrue(client.containsFilterLeadSourceCollection(sourceName));
    }

    @Test
    public void askLeadSourceDisable() {
        LeadSource source = new LeadSource();
        source.askSourceClient(false);
        source.saveButtonClick();
        Client client = new Client();
        client.openSectionClient();
        client.newClientButtonClick();
        Assert.assertFalse(client.isLeadSourceDisplayed());
    }

    @Test
    public void makeFieldSourceRequired() {
        LeadSource source = new LeadSource();
        source.askSourceClient(true);
        source.makeFieldRequired(true);
        source.saveButtonClick();
        Client client = new Client();
        client.openSectionClient();
        client.newClientButtonClick();
        client.saveNewClientButton();
        Assert.assertEquals("Укажите, откуда клиент о вас узнал",client.errorLeadSource());
        Features features = new Features();
        features.openSectionFeatures();
        source.openLeadSourceSection();
        source.makeFieldRequired(false);
        source.saveButtonClick();
    }

    @AfterClass
    public static void removeAll() {
        LeadSource leadSource = new LeadSource();
        sleep(300);
        leadSource.removeAll();
        leadSource.saveButtonClick();
    }
}
