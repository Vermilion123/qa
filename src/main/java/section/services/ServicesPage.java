package section.services;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by jazzt on 11.02.16.
 */
public class ServicesPage {

    @Step
    public void addNewService(String name, String groups, String price, String hh, String mm) {
        $("#breadCrumbs .jsButtonServiceAdd").click();
        $("#serviceAdd #label-name").val(name).pressTab();
        $("#serviceAdd #label-service_groups").val(groups).pressTab();
        $("#serviceAdd #label-price").val(price).pressTab();
        $("#serviceAdd #label-duration_hour").val(hh).pressTab();
        $("#serviceAdd #label-duration_min").val(mm).pressTab();
        $("#breadCrumbs .jsButtonServiceAddSave").click();
    }

    @Step("сделать архивной")
    public void makeArchive() {
        $("#breadCrumbs .jsButtonServiceEdit").click();
        $(".element_label.element-checkbox_label").click();
        $(".jsMessageArchive").should(Condition.visible);
        $(".element-checkbox_button").click();
        $(".element-checkbox_button").shouldHave(Condition.cssClass("checked"));
        $("#breadCrumbs .jsButtonServiceEditSave").click();
    }

    @Step
    public void checkAfter1Min(String name) {
        open("https://klientiks.ru/clientix/services/default/");
        $("#breadCrumbs .jsFiltersButton").should(Condition.visible).click();
        $("#label-name").val(name).pressEnter();
        assertEquals(true, isListCollection(name, getListServices()));
    }


    private ElementsCollection getListServices() {
        return $$(".p-services-list_row");
    }

    private boolean isListCollectionArchive (String name, ElementsCollection collection) {
        for (SelenideElement e : collection) {
            if (e.should(Condition.visible).text().split("\n")[1].equals(name))
                return true;
        }
        return false;
    }

    private boolean isListCollection(String name, ElementsCollection collection) {
        for (SelenideElement e : collection) {
            if (e.should(Condition.visible).text().split("\n")[0].equals(name))
                return true;
        }
        return false;
    }

    @Step("проверить в фильтре отображение архивных услуги - {0}")
    public void checkFilterArchive(String name) {
        $("#breadCrumbs .jsFiltersButton").click();
        $("#archived .class-1").click();
        assertTrue(isListCollectionArchive(name, getListServices()));
    }

    @Step("проверить в фильтре отображение продвигаемых услуг - {0}")
    public void checkFilterPromoted(String name) {
        $("#breadCrumbs .jsFiltersButton").click();
        $("#promoted .class-1").click();
        assertTrue(isListCollection(name, getListServices()));
    }

    @Step("проверить в фильтре отображние продвигаемых услуг - {0}")
    public void makePromoted(String name) {
        $(".jsButtonPromote").click();
        $(".element-checkbox_button").click();
        $(".element-checkbox_button").shouldHave(Condition.cssClass("checked"));
    }

    @Step("проверить в фильтре отображение фильтра по группам")
    public void checkFilterGroups(String groups) {
        $("#breadCrumbs .jsFiltersButton").click();
        $("#label-service_groups").click();
        ElementsCollection collections = $$("#service_groups  ul li");
        assertTrue(groups.split("\\s")[0],
                isListACElement(groups.split("\\s")[0], collections));
    }

    private boolean isListACElement(String name, ElementsCollection collection) {
        for (SelenideElement e : collection) {
            if (e.has(Condition.text(name))) return true;
        }
        return false;
    }

}

// #listClients .p-client-list_name