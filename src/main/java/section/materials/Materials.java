
package section.materials;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import section.breadcrumbs.BreadCrumbsPage;
import section.filter.MaterialsFilterPage;

import static com.codeborne.selenide.Selenide.open;
import static config.StaticProp.getTestUrl;

/**
 * Created by Renat on 01.06.2016.
 */
public class Materials {

    private MaterialsPage materialsPage;
    private BreadCrumbsPage bread;
    private MaterialsFilterPage filter;

    public Materials() {
        materialsPage = new MaterialsPage();
        bread = new BreadCrumbsPage();
        filter = new MaterialsFilterPage();
    }

    public void openSectionMaterials() { open(getTestUrl() + "/clientix/materials/default"); }

    public void newMaterialButtonClick() { bread.getNewMaterialBytton().should(Condition.visible).click(); }

    public void saveNewMaterialButtonClick() { bread.getSaveNewMaterialButton().should(Condition.visible).click(); }

    public void fillMaterilsData(String name, String count, String priceSell) {
        materialsPage.setName(name);
        materialsPage.setCount(count);
        materialsPage.setPriceSell(priceSell);
    }

    public void openFirstMaterialInList() {
        materialsPage.getMaterialListCollection().get(0).$(".jsClick_init_materialView").should(Condition.visible).click();
    }

    public String getName() { return materialsPage.getName().getValue(); }
    public String getCount() { return materialsPage.getCount().getValue(); }
    public String getPriceSell() { return materialsPage.getPriceSell().getValue(); }

    public void filterInputNameMaterial(String name) {
        filter.setName(name);
    }

    public void findMaterialInList(String name) {
        for (SelenideElement e : materialsPage.getMaterialListCollection()) {
            if (e.$(".p-material-list_text").text().equals(name)) {
                e.$(".jsClick_init_materialView").click();
            }
        }
    }
}
