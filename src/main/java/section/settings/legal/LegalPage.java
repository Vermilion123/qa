package section.settings.legal;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Renat on 01.07.2016.
 */
public class LegalPage {
    private SelenideElement name = $("#Accounts #label-legal_name");
    private SelenideElement phone = $("#Accounts #label-legal_phone");
    private SelenideElement address = $("#Accounts #label-legal_address");
    private SelenideElement index = $("#Accounts #label-legal_index");
    private SelenideElement inn = $("#Accounts #label-legal_inn");
    private SelenideElement kpp = $("#Accounts #label-legal_kpp");
    private SelenideElement ogrn = $("#Accounts #label-legal_ogrn");
    private SelenideElement legalSection = $(".jsButtonLegal");


    public void setName(String name) {
        this.name.val(name);
    }

    public void setPhone(String phone) {
        this.phone.val(phone);
    }

    public void setIndex(String index) {
        this.index.val(index);
    }

    public void setInn(String inn) {
        this.inn.val(inn);
    }

    public void setAddress(String address) {
        this.address.val(address);
    }

    public void setKpp(String kpp) {
        this.kpp.val(kpp);
    }

    public void setOgrn(String ogrn) {
        this.ogrn.val(ogrn);
    }

    public SelenideElement getName() {
        return name;
    }

    public SelenideElement getPhone() {
        return phone;
    }

    public SelenideElement getIndex() {
        return index;
    }


    public SelenideElement getInn() {
        return inn;
    }

    public SelenideElement getAddress() {
        return address;
    }

    public SelenideElement getKpp() {
        return kpp;
    }

    public SelenideElement getOgrn() {
        return ogrn;
    }

    public SelenideElement getLegalSection() {
        return legalSection;
    }
}
