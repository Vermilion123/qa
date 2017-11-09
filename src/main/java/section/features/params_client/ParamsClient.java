package section.features.params_client;

import com.codeborne.selenide.Condition;
import section.breadcrumbs.BreadCrumbsPage;



/**
 * Created by Renat on 12.07.2016.
 */
public class ParamsClient {

    private ParamsClientPage page;
    private BreadCrumbsPage bread;


    public ParamsClient() {
        page = new ParamsClientPage();
        bread = new BreadCrumbsPage();
    }


    public void saveButtonClick() { bread.getSaveParamsClientButton().click(); }

    public void address(boolean status) {
        if (status) {
            if (!page.getAddress().should(Condition.visible).has(Condition.cssClass("checked")))
                page.getAddress().click();
        } else {
            if (page.getAddress().should(Condition.visible).has(Condition.cssClass("checked")))
            page.getAddress().click();
        }
    }

    public void passport(boolean status) {
        if (status) {
            if (!page.getPassport().should(Condition.visible).has(Condition.cssClass("checked")))
                page.getPassport().click();
        } else {
            if (page.getPassport().should(Condition.visible).has(Condition.cssClass("checked")))
            page.getPassport().click();
        }
    }

    public void sex(boolean status) {
        if (!System.getProperty("base_version").toLowerCase().equals("friend")) {
            if (status) {
                if (!page.getSex().should(Condition.visible).has(Condition.cssClass("checked")))
                    page.getSex().click();
            } else {
                if (page.getSex().should(Condition.visible).has(Condition.cssClass("checked")))
                    page.getSex().click();
            }
        }
    }

}
