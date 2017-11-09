package section.schedule;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by Renat on 06.06.2016.
 */
public class SchedulePage {

    private SelenideElement scheduleForm = $("#schedule");

    private SelenideElement dataId;
    private ElementsCollection monthDayCollection;

    private String cssScheduled = "_type_scheduled";

    private String day;
    private String dataStart;
    private String month;

    private String getDay(String data) {
        day = "[data-date='" + data + "']";
        return day;
    }

    private String getDataMonth(String year, String month) {
        return "[data-month='" + year + "-" + month + "-01']";
    }

    private String getDataMaster(String id) {
       return "[data-master='" + id +"']";
    }
    public SelenideElement getDataStart(String id, String data, String time) {
        return $(getDay(data)
                + " "
                + getDataMaster(id)
                + " "
                + "[data-start='" + data + " " + time + "'] ");
    }

    public SelenideElement getScheduleRecordTime(String id, String data, String time) {
        return getDataStart(id, data, time).$(".b-schedule-record_time");
    }

    public SelenideElement getDataId(String id) {
        return $("[data-id='" + id + "']");
    }

    public ElementsCollection getMonthDayCollection(String id, String year, String month) {
        return $$(getDataMonth(year, month)
                + " "
                + getDataMaster(id)
                + " "
                + ".b-schedule-month-record");
    }
    public ElementsCollection getMonthDayCollection2(String id, String year, String month) {
        return $$(getDataMonth(year, month)
                + " "
                + getDataMaster(id)
                + " "
                + ".b-schedule-month-record_cr");
    }
    //.$(".b-schedule-month-record-time")
    public String getCssScheduled() { return cssScheduled; }

    public ElementsCollection getRecordsList(String date) {
        return  $$("[data-date='" + date + "'] [data-master] [data-id]");
    }
}
