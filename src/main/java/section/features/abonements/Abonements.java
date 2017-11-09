package section.features.abonements;

import com.codeborne.selenide.Condition;
import section.breadcrumbs.BreadCrumbsPage;

/**
 * Created by Renat on 09.06.2016.
 */
public class Abonements {

    private AbonementsPage abonementsPage;
    private BreadCrumbsPage bread;

    public Abonements() {
        abonementsPage = new AbonementsPage();
        bread = new BreadCrumbsPage();
    }

    public void tooltipClick() {
        abonementsPage.getEnableAbonementsLabel().should(Condition.visible).click();
    }

    public void newAbonementButtonClick() {
        bread.getNewAbonementButton().should(Condition.visible).click();
    }

    public void saveNewAbonementButtonClick() {
        bread.getSaveNewAbonementButton().should(Condition.visible).click();
    }

    public boolean isDisplayedTooltip() {
        return abonementsPage.getTooltip().isDisplayed();
    }

    public void enableAbonements() {
        if (!abonementsPage.getEnableAbonementsCheckbox().is(Condition.cssClass("checked")))
            abonementsPage.getEnableAbonementsCheckbox().click();
    }

    public void fillData(String name, String count) {
        abonementsPage.setName(name);
        abonementsPage.setCount(count);
        abonementsPage.setCountVisits(count);
        abonementsPage.setPrice(count);
        abonementsPage.getDurationType().click();
        abonementsPage.getElementsCollectionDurationType().get(0).click();
    }
}
