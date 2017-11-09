package section.settings.info_by_company;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Renat on 01.07.2016.
 */
public class InfoByCompPage {

    private SelenideElement sectionInfoByCom = $(".jsButtonCompany");
    private SelenideElement nameCompany = $("#label-company_name");
    private SelenideElement phone = $("#label-phone");
    private SelenideElement address = $("#label-address");
    private SelenideElement city = $("#label-city");

    public SelenideElement getSectionInfoByCom() { return sectionInfoByCom; }

    public void setNameCompany(String name) {
        this.nameCompany.val(name);
    }

    public void setPhone(String phone) {
        this.phone.val(phone);
    }

    public void setAddress(String address) {
        this.address.val(address);
    }

    public void setCity(String city) {
        this.city.val(city);
    }

    public SelenideElement getNameCompany() {
        return nameCompany;
    }

    public SelenideElement getPhone() {
        return phone;
    }

    public SelenideElement getAddress() {
        return address;
    }

    public SelenideElement getCity() {
        return city;
    }
}
