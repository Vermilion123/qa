package section.services;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Renat on 27.05.2016.
 */
public class ServicePage {

    private SelenideElement serviceForm = $("#Services");
    private SelenideElement serviceView = $("#serviceView");
    private SelenideElement serviceList = $("#serviceList");

    private SelenideElement name = serviceForm.$("#label-name");
    private SelenideElement group = serviceForm.$("#label-service_groups");
    private SelenideElement price = serviceForm.$("#label-price");
    private ElementsCollection keyMoreInfo = serviceView.$$(".p-service-view-info_label");

    private ElementsCollection valueMoreInfo = serviceView.$$(".p-service-view-info_value");
    private SelenideElement serviceGroupsView = serviceView.$(".p-service-list-group");
    private ElementsCollection listServices = serviceList.$$(".BModelSearchListElement");

    private SelenideElement serviceViewName = serviceView.$(".p-service-view-name");

    public SelenideElement getName() {
        return name;
    }

    public SelenideElement getGroup() {
        return group;
    }

    public SelenideElement getPrice() {
        return price;
    }

    public ElementsCollection getKeyMoreInfo() {
        return keyMoreInfo;
    }
    public ElementsCollection getValueMoreInfo() {
        return valueMoreInfo;
    }

    public SelenideElement getGroupsServiceView() {
        return serviceGroupsView;
    }

    public ElementsCollection getListServices() {
        return listServices;
    }

    public SelenideElement getServiceViewName() {
        return serviceViewName;
    }

}
