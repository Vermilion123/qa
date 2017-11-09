package section.employee;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import section.breadcrumbs.BreadCrumbsPage;
import utils.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static config.StaticProp.getTestUrl;

/**
 * Created by Renat on 03.06.2016.
 */
public class Employee {

    private BreadCrumbsPage bread;
    private EmployeePage employeePage;

    public Employee() {
        bread = new BreadCrumbsPage();
        employeePage = new EmployeePage();
    }

    public void openSectionEmployee() { open(getTestUrl() + "/clientix/employee/default"); }

    public void openEmployeeByURL(String idEmployee) { open(getTestUrl() + "/clientix/employee/default/id/" + idEmployee);}

    public void newEmployeeButtonClick() { bread.getNewEmployeeButton().should(Condition.visible).click(); }

    public void saveNewEmployeeButtonClick() { bread.getSaveNewEmployeeButton().should(Condition.visible).click(); }

    public void openEditButtonClick() { bread.getEditEmployeeButton().should(Condition.visible).click(); }

    public void saveEditEmployeeButtonClick() { bread.getSaveEditEmloyeeButton().should(Condition.visible).click(); }

    public void openRemoveItem() { employeePage.getRemoveItem().should(Condition.visible).click(); }

    public void fillEmployeeData(String name, String phone) {
        employeePage.setInputName(name);
        employeePage.setInputPhone(phone);
    }

    public void fillEmployeeData(String name, String phone, String position) {
        employeePage.setInputName(name);
        employeePage.setInputPhone(phone);
        employeePage.setInputPosition(position);
    }

    public String getNameEmloyeeView() {
        return employeePage.getNameView().should(Condition.visible).text();
    }
    public String getPositionEmployeeView() {
        return employeePage.getPositionView().should(Condition.visible).text();
    }

    public String getPhoneEmployeeView() {
        return Utils.unMaskPhone(employeePage.getPhoneView().should(Condition.visible).text());
    }


    public void removeButtonClick() {
        employeePage.getRemoveButton().should(Condition.visible).click();
    }

    public String getRemoveLabelView() {
        return employeePage.getRemoveStatusView().should(Condition.visible).text();
    }

    public void clearData() {
        clearElementValue(employeePage.getInputName());
        clearElementValue(employeePage.getInputPhone());
        clearElementValue(employeePage.getInputPosition());
    }

    private void clearElementValue(SelenideElement e) {
        e.clear();
        e.val("");
    }

    public boolean isWorkBySheduleCheckboxChecked() {
        return employeePage.getWorkBySheduleCheckbox().is(Condition.attribute("checked"));
    }

    public String getId() {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(url());
        return m.find() ? m.group() : "not found id";
    }

    public ElementsCollection getAllEmployee() { return employeePage.getAllEmployee(); }

    public boolean isEmployeeListVisible() { return employeePage.getEmployeeList().should(Condition.visible).is(Condition.visible);}

    public boolean employeeViewRemoveStatus() { return employeePage.getEmplyeeViewRemoveStatus().should(Condition.visible).text().trim().equals("Удален"); }
    public void removeAllEmployee() {
        for (SelenideElement e : employeePage.getAllEmployee()) {
            if (!e.find(".p-employee-list_label").exists()) {
                e.$(".jsButtonView").should(Condition.visible).click();
                if (!employeeViewRemoveStatus()) {
                    if(employeePage.getRemoveItem().isDisplayed()) {
                        openRemoveItem();
                        removeButtonClick();
                        $(".jsBreadSecond").should(Condition.visible).click();
                    }
                }
            }
        }
    }
}