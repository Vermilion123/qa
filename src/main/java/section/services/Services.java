package section.services;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import section.breadcrumbs.BreadCrumbsPage;
import section.filter.ServiceFilterPage;
import utils.Utils;

import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static config.StaticProp.getTestUrl;

/**
 * Created by Renat on 27.05.2016.
 */
public class Services {

    private BreadCrumbsPage bread;
    private ServicePage servicePage;
    private ServiceFilterPage serviceFilterPage;

    public Services() {
        bread = new BreadCrumbsPage();
        servicePage = new ServicePage();
        serviceFilterPage = new ServiceFilterPage();
    }

    public void openSectionService() { open(getTestUrl() + "/clientix/services/default"); }

    public void newServiceButtonClick() {
        bread.getAddServiceButton().should(Condition.visible).click();
    }

    public void saveNewServiceButton() {
        bread.getServiceAddSaveButton().should(Condition.visible).click();
    }

    public void editServicesButtonClick() { bread.getEditServicesButton().should(Condition.visible).click(); }

    public void saveEditServceButtonClick() { bread.getSaveEditServiceButton().should(Condition.visible).click(); }

    public void fillServiceData(String name, String group, String price) {
        servicePage.getName().val(name);
        servicePage.getGroup().val(group);
        servicePage.getPrice().val(price);
    }

    public String getMoreInfoDataGroups() {
        return servicePage.getGroupsServiceView().getText();
    }

    public String getServiceViewName() {
        return servicePage.getServiceViewName().text();
    }

    public Map<String, String> getMoreInfoDataServiceView() {
        return Utils.getMapInfo(servicePage.getKeyMoreInfo(), servicePage.getValueMoreInfo());
    }

    public void filterClick() {
        bread.getFilterButton().should(Condition.visible).click();
    }

    public void filterInputServiceByName(String name) {
        serviceFilterPage.setName(name);
    }

    public void findServiceInServiceList(String name) {
        for (SelenideElement e : servicePage.getListServices()) {
            // take first column with service name
            if (e.$$(".p-service-list_text").get(0).getText().equals(name)) {
                e.$$(".p-service-list_text").get(0).click();
            }
        }
    }

    public void chooseFirstServiceInList() {
        servicePage.getListServices().get(0).$(".jsButtonView").should(Condition.visible).click();
    }


    public boolean hasServicesListElement() {
        return servicePage.getListServices().size() != 0;
    }

    public void clearData() {
        clearElementValue(servicePage.getName());
        clearElementValue(servicePage.getPrice());
        $(".remove").click(); // for groups

    }

    private void clearElementValue(SelenideElement e) {
        e.clear();
        e.val("");
    }
}
