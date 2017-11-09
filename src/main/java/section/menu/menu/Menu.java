package section.menu.menu;

import com.codeborne.selenide.Condition;
import section.breadcrumbs.BreadCrumbsPage;

/**
 * Created by Renat on 09.06.2016.
 */
public class Menu {

    private BreadCrumbsPage bread;
    private MenuPage menuPage;

    public Menu() {
        bread = new BreadCrumbsPage();
        menuPage = new MenuPage();
    }

    public void menuButtonClick() { bread.getMenuButton().should(Condition.visible).click(); }

    public void servicesSectionClick() {
        menuPage.getServices().should(Condition.visible).click();
    }
    public void clientsSectionClick() {
        menuPage.getClients().should(Condition.visible).click();
    }
    public void scheduleSectionClick() { menuPage.getSchedule().should(Condition.visible).click(); }
    public void featuresSectionClick() { menuPage.getFeatures().should(Condition.visible).click(); }
    public void employeeSectionClick() { menuPage.getEmployee().should(Condition.visible).click(); }
    public void settingsSectionClick() { menuPage.getSettings().should(Condition.visible).click(); }
}
