package section.menu.menu;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Renat on 09.06.2016.
 */
public class MenuPage {

    private SelenideElement services = $("[href='/clientix/services/default']");
    private SelenideElement clients  = $("[href='/clientix/client/default']");
    private SelenideElement schedule = $("[href='/clientix/schedule/default']");
    private SelenideElement features = $("[href='/clientix/settings/features']");
    private SelenideElement employee = $("[href='/clientix/employee/default']");
    private SelenideElement settings = $("[href='/clientix/settings/account']");

    public SelenideElement getServices() {
        return services;
    }

    public SelenideElement getClients() {
        return clients;
    }

    public SelenideElement getSchedule() { return schedule; }

    public SelenideElement getFeatures() { return features; }

    public SelenideElement getEmployee() { return employee; }

    public SelenideElement getSettings() { return settings; }
}
