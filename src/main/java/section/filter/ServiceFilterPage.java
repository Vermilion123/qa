package section.filter;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Renat on 01.06.2016.
 */
public class ServiceFilterPage {

    private SelenideElement form = $("#searchServices");

    private SelenideElement name = form.$("#label-name");



    public void setName(String name) {
        this.name.val(name);
    }

    public SelenideElement getName() {
        return name;
    }
}
