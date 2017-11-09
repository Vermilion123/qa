package section.employee;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by Renat on 03.06.2016.
 */
public class EmployeePage {

    private SelenideElement formEmployee = $("#Users");
    private SelenideElement viewEmloyee = $("#employeeView");

    private SelenideElement inputName = $("#Users #label-name");
    private SelenideElement inputPhone = $("#Users #label-phone");
    private SelenideElement inputPosition = $("#Users #label-position");

    private SelenideElement nameView = $("#employeeView .p-employee-view-employee_name");
    private SelenideElement positionView = $("#employeeView .p-employee-view-employee_position");
    private SelenideElement phoneView = $("#employeeView .p-employee-view-phone_text");


    private SelenideElement removeItem = $("#employeeView .jsButtonArchive");
    private SelenideElement removeButton = $("#false button");
    private SelenideElement removeStatusView = $("#Users .optionalShown  .element-button_label");
    private SelenideElement workBySheduleCheckbox = $("#Users #label-using_schedule");
    private ElementsCollection allEmployee = $$("#employeeList .p-employee-list_row");
    private SelenideElement employeeList = $("#employeeList");
    private SelenideElement emplyeeViewRemoveStatus = $("#employeeView .p-employee-view-status-indicator_text");


    public void setInputName(String inputName) {
        this.inputName.val(inputName);
    }

    public void setInputPhone(String inputPhone) {
        this.inputPhone.val(inputPhone);
    }

    public void setInputPosition(String inputPosition) {
        this.inputPosition.val(inputPosition);
    }

    public SelenideElement getInputName() {
        return inputName;
    }

    public SelenideElement getInputPhone() {
        return inputPhone;
    }

    public SelenideElement getInputPosition() {
        return inputPosition;
    }

    public SelenideElement getNameView() { return nameView; }

    public SelenideElement getPositionView() {
        return positionView;
    }

    public SelenideElement getPhoneView() {
        return phoneView;
    }

    public SelenideElement getRemoveItem() {  return removeItem; }

    public SelenideElement getRemoveButton() { return removeButton; }

    public SelenideElement getRemoveStatusView() {
        return removeStatusView;
    }

    public SelenideElement getWorkBySheduleCheckbox() {
        return workBySheduleCheckbox;
    }

    public ElementsCollection getAllEmployee() { return allEmployee; }

    public SelenideElement getEmployeeList() { return employeeList; }

    public SelenideElement getEmplyeeViewRemoveStatus() {
        return emplyeeViewRemoveStatus;
    }
}
