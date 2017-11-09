package section.employee;

import base_test.BaseTest;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.yandex.qatools.allure.annotations.Stories;
import section.authtorize.auth.Auth;
import utils.Utils;

import static com.codeborne.selenide.Selenide.sleep;
import static config.StaticProp.getTestUrl;

/**
 * Created by Renat on 03.06.2016.
 */
@Stories("Employee Story")
@RunWith(JUnit4.class)
public class TestEmployee extends BaseTest {

    @BeforeClass
    public static void auth() {
        Auth auth = new Auth();
        auth.authByProperty(getTestUrl());
    }

    @Test
    public void testNewEmployeeAndRemove() {
        String tmp = Utils.getTmpNumbersString(6);
        String name = "Autotest_name_" + tmp;
        String phone = Utils.getTmpNumbersString(10);
        String position = "admin";

        Employee employee = new Employee();
        employee.openSectionEmployee();
        employee.newEmployeeButtonClick();
        employee.fillEmployeeData(name, phone, position);

        Assert.assertTrue(employee.isWorkBySheduleCheckboxChecked());
        employee.saveNewEmployeeButtonClick();

        Assert.assertEquals(name, employee.getNameEmloyeeView());
        Assert.assertEquals(position, employee.getPositionEmployeeView());
        Assert.assertEquals(phone, employee.getPhoneEmployeeView());

        employee.openRemoveItem();
        employee.removeButtonClick();
        sleep(300);
        Assert.assertEquals("Сотрудник удален", employee.getRemoveLabelView());
    }

    @Test
    public void testEditEmployeeAndRemove() {
        String tmp = Utils.getTmpNumbersString(6);
        String name = "Autotest_name_" + tmp;
        String phone = Utils.getTmpNumbersString(10);
        String position = "admin";

        String tmp2 = Utils.getTmpNumbersString(6);
        String name2 = "Autotest_name_Edit" + tmp2;
        String phone2 = Utils.getTmpNumbersString(10);
        String position2 = "Editadmin";

        Employee employee = new Employee();
        employee.openSectionEmployee();
        employee.newEmployeeButtonClick();
        employee.fillEmployeeData(name, phone, position);
        Assert.assertTrue(employee.isWorkBySheduleCheckboxChecked());
        employee.saveNewEmployeeButtonClick();

        employee.openEditButtonClick();
        employee.clearData();
        employee.fillEmployeeData(name2, phone2, position2);
        employee.saveEditEmployeeButtonClick();

        Assert.assertEquals(name2, employee.getNameEmloyeeView());
        Assert.assertEquals(position2, employee.getPositionEmployeeView());
        Assert.assertEquals(phone2, employee.getPhoneEmployeeView());


        employee.openRemoveItem();
        employee.removeButtonClick();
        sleep(300);
        Assert.assertEquals("Сотрудник удален", employee.getRemoveLabelView());
    }

}


