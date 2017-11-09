package section.employee;

import com.codeborne.selenide.Condition;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Renat on 15.02.2016.
 */
public class EmployeePage122 {

    @Step("добавить сотрудника")
    public void addEmployee(String name, String phone) {
        $("#breadCrumbs .jsButtonEmployeeAdd").should(Condition.visible).click();
        $("#employeeAdd #label-name").val(name);
        $("#employeeAdd #label-phone").val(phone);
        String position = "admin";
        $("#employeeAdd #label-position").val(position);
        $("#breadCrumbs .jsButtonEmployeeAddSave").click();
        // TODO: 15.02.2016 дописать дату рождения, загрузку фото, емэйл
    }

    @Step("проверить добавленного сотрудника")
    public void checkAdd(String name, String phone, String position) {
        $(".p-section.employee-view-employee_name").should(Condition.text(name));
        $(".p-section.employee-view-employee_position").should(Condition.text(position));
    }

    @Step("проверить предоставление доступа")
    public void checkAccess() {
        $("#employeeView .jsButtonAccess").should(Condition.visible).click();
        $(".p-section.employee-access-label_access").should(Condition.text("отсутствует"));
        $("#no_access button").should(Condition.visible).click();

        $(".p-section.employee-access-label_access").should(Condition.hasText("предоставлен"));
        $("#has_access button").should(Condition.visible).click();
    }


    @Step("Удалить сотрудника")
    public void removeStuff() {
        $("#employeeView .jsButtonArchive").click();
        $("#false .element_label-span").should(Condition.hasText("Сотрудник активен"));
        $("#false button").click();
        $("#true .element_label-span").should(Condition.hasText("Сотрудник удален"));
    }
}
