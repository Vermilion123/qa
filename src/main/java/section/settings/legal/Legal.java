package section.settings.legal;

import com.codeborne.selenide.Condition;
import section.breadcrumbs.BreadCrumbsPage;
import utils.Utils;

/**
 * Created by Renat on 01.07.2016.
 */
public class Legal {

    private LegalPage legalPage;
    private BreadCrumbsPage bread;

    public Legal() {
        bread = new BreadCrumbsPage();
        legalPage = new LegalPage();
    }

    public void openSectionLegal() {
        legalPage.getLegalSection().should(Condition.visible).click();
    }

    public void saveButtonClick() {
        bread.getSaveLegalButton().should(Condition.visible).click();
    }

    public String getName() {
        return legalPage.getName().val();
    }

    public String getPhone() {
        return Utils.unMaskPhone(legalPage.getPhone().val());
    }

    public String getAddress() {
        return legalPage.getAddress().val();
    }

    public String getIndex() {
        return legalPage.getIndex().val().replaceAll("\\s", "");
    }

    public String getInn() {
        return legalPage.getInn().val().replaceAll("\\s", "");
    }

    public String getKpp() {
        return legalPage.getKpp().val().replaceAll("\\s", "");
    }

    public String getOgrn() {
        return legalPage.getOgrn().val();
    }

    public void fillData(String name, String phone, String address, String index, String inn, String kpp, String ogrn) {
        clearData();
        legalPage.setName(name);
        legalPage.setPhone(phone);
        legalPage.setAddress(address);
        legalPage.setIndex(index);
        legalPage.setInn(inn);
        legalPage.setKpp(kpp);
        legalPage.setOgrn(ogrn);
    }

    private void clearData() {
        legalPage.getName().clear();
        legalPage.getPhone().pressEscape().val("");
        legalPage.getAddress().clear();
        legalPage.getIndex().clear();
        legalPage.getInn().pressEscape().val("");
        legalPage.getKpp().clear();
        legalPage.getOgrn().clear();
    }

}
