package section.settings.info_by_company;

import com.codeborne.selenide.Condition;
import section.breadcrumbs.BreadCrumbsPage;
import utils.Utils;

/**
 * Created by Renat on 01.07.2016.
 */
public class InfoByComp {

    private InfoByCompPage page;
    private BreadCrumbsPage bread;
    private String companyName;
    private String companyPhone;
    private String companyAddress;
    private String companyCity;

    public InfoByComp() {
        page = new InfoByCompPage();
        bread = new BreadCrumbsPage();
    }

    public void openSectionInfoByComp() {
        page.getSectionInfoByCom().should(Condition.visible).click();
    }

    public void saveButtonClick() {
        bread.getSaveInfoByCompanyButton().should(Condition.visible).click();
    }

    public void fillData(String name, String phone, String address, String city) {
        clearData();
        page.setNameCompany(name);
        page.getPhone().pressEscape();
        page.setPhone(phone);
        page.setAddress(address);
        page.setCity(city);
    }

    private void clearData() {
        page.getNameCompany().clear();
        page.getAddress().clear();
        page.getCity().clear();
    }

    public String getCompanyName() {
        return page.getNameCompany().val();
    }

    public String getCompanyPhone() {
        return Utils.unMaskPhone(page.getPhone().val());
    }

    public String getCompanyAddress() {
        return page.getAddress().val();
    }

    public String getCompanyCity() {
        return page.getCity().val();
    }
}
