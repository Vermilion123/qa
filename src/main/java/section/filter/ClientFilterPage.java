package section.filter;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by Renat on 20.05.2016.
 */
public class ClientFilterPage {

    private SelenideElement form = $("#searchClients");
    private SelenideElement name = form.$("#label-name");
    private SelenideElement leadSource = $("#searchClients #label-lead_source");
    private ElementsCollection leadSourceCollection = $$("#searchClients #lead_source ul li");


    public void setName(String name) {
        this.name.val(name);
    }

    public SelenideElement getLeadSource() {
        return leadSource;
    }

    public ElementsCollection getLeadSourceCollection() {
        return leadSourceCollection;
    }
}
