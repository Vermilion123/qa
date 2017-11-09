package section.materials;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Renat on 01.06.2016.
 */
public class MaterialsPage {

    private SelenideElement name = $("#ServicesMaterials #label-name");
    private SelenideElement count = $("#ServicesMaterials #label-quantity");
    private SelenideElement amount = $("#ServicesMaterials #label-amount");
    private SelenideElement priceSell = $("#ServicesMaterials #label-price");

    private SelenideElement materialList = $("#materialList");
    private ElementsCollection materialListCollection = materialList.$$(".p-material-list_row ");

    public ElementsCollection getMaterialListCollection() {
        return materialListCollection;
    }

    public SelenideElement getName() { return name; }

    public void setName(String name) {
        this.name.val(name);
    }

    public void setCount(String count) {
        this.count.val(count);
    }

    public void setPriceSell(String priceSell) {
        this.priceSell.val(priceSell);
    }

    public SelenideElement getCount() {
        return amount;
    }

    public SelenideElement getPriceSell() {
        return priceSell;
    }
}
