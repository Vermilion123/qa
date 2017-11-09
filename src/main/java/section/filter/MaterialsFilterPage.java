package section.filter;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Renat on 02.06.2016.
 */
public class MaterialsFilterPage {

    private SelenideElement form = $("#materialSearch");

    private SelenideElement name = form.find("#label-name");

    public void setName(String name) {
        this.name.val(name);
    }

    public SelenideElement getName() {
        return name;
    }
}
