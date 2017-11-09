package section.features.lead_source;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import section.breadcrumbs.BreadCrumbsPage;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

/**
 * Created by Renat on 05.07.2016.
 */
public class LeadSource {
    private LeadSourcePage page;
    private BreadCrumbsPage bread;

    public LeadSource() {
        page = new LeadSourcePage();
        bread = new BreadCrumbsPage();
    }

    public void saveButtonClick() { bread.getSaveLeadSource().should(visible).click();     }
    public void openLeadSourceSection() { page.getLeadSource().should(Condition.visible).click();  }


    public void addSource(String source) {
        page.setLabelKey(source);
    }

    public boolean containsSourceCollection(String source) {
        return page.getLeadSourceCollection().filterBy(text(source)).get(0).is(Condition.visible);
    }

    public void remove(String source) {
        page.getLeadSourceCollection().filter(text(source)).get(0).find(".remove").click();
    }


    public void askSourceClient(boolean status) {
        if (status) {
            if (!page.getAskSourceCLient().should(visible).has(cssClass("checked")))
                page.getAskSourceCLient().click();
        } else {
            if (page.getAskSourceCLient().should(visible).has(cssClass("checked")))
                page.getAskSourceCLient().click();
        }
    }

    public void makeFieldRequired(boolean status) {
        if (status) {
            if (!page.getMakeFieldRequired().should(visible).has(cssClass("checked")))
                page.getMakeFieldRequired().click();
        } else {
            if (page.getMakeFieldRequired().should(visible).has(cssClass("checked")))
                page.getMakeFieldRequired().click();
        }
    }

    public void removeAll() {
        if (!page.getLeadSourceCollection().isEmpty()) {
            for (SelenideElement e : page.getLeadSourceCollection()) {
                e.$(".remove").click();
            }
        }
    }
}
