package section.schedule;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import section.breadcrumbs.BreadCrumbsPage;

import static com.codeborne.selenide.Selenide.open;
import static config.StaticProp.getTestUrl;

/**
 * Created by Renat on 06.06.2016.
 */
public class Schedule {

    private SchedulePage schedulePage;
    private ActionSchedule action;
    private BreadCrumbsPage bread;

    public Schedule() {
        schedulePage = new SchedulePage();
        action = new ActionSchedule();
        bread = new BreadCrumbsPage();
    }


    public void openScheduleSection() { open(getTestUrl() + "/clientix/schedule/default"); }

    public void openMonthMode() { bread.getMonthModeButton().should(Condition.visible).click(); }

    public void actionButtonClick() { bread.getScheduleActionButton().should(Condition.visible).click(); }

    public void removeButtonClick() { action.getRemoveFormButton().should(Condition.visible).click(); }

    public void removeSelectedButtonClick() { action.getRemoveSelectedButton().should(Condition.visible).click(); }


    public void addScheduleTodayByIdClick(String id, String data, String startTime) {
        schedulePage.getDataStart(id, data, startTime)
                .should(Condition.visible)
                .click();
    }

    public boolean hasScheduleRecordTime(String id, String data, String startTme) {
        return schedulePage.getScheduleRecordTime(id, data, startTme).has(Condition.visible);
    }

    public void getScheduleRecordTimeClick(String id, String data, String startTme) {
        schedulePage.getScheduleRecordTime(id, data, startTme).should(Condition.visible).click();
    }

    public String getScheduleRecordTimeText(String id, String data, String startTme) {
        return schedulePage.getScheduleRecordTime(id, data, startTme).should(Condition.visible).text();
    }

    public boolean hasDisplayedEmployee(String idEmployee) {
        return schedulePage.getDataId(idEmployee).has(Condition.visible);
    }

    public void addScheduleInMothByIdClick(String idEmployee, String year, String month, String day) {
        schedulePage.getMonthDayCollection(idEmployee, year, month).get(Integer.parseInt(day) - 1).should(Condition.visible).click();
    }

    public void getScheduleInMothByIdClick(String idEmployee, String year, String month, String day) {
        schedulePage.getMonthDayCollection2(idEmployee, year, month).get(Integer.parseInt(day)).should(Condition.visible).click();
    }


    public boolean hasScheduledInMonthRecordTime(String idEmployee, String year, String month, String day) {
        return schedulePage.getMonthDayCollection(idEmployee, year, month).get(Integer.parseInt(day) - 1).has(Condition.cssClass(schedulePage.getCssScheduled()));
    }

    public void removeAllScheduleToday(String date) {
        actionButtonClick();
        removeButtonClick();
        if (schedulePage.getRecordsList(date).size() != 0) {
            for (SelenideElement e : schedulePage.getRecordsList(date)) {
                e.click();
            }
            removeSelectedButtonClick();
        }
    }
}
