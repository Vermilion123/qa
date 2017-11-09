package section.widget;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by Renat on 27.05.2016.
 */
public class WidgetPage {

    private SelenideElement chooseServiceButton = $(".jsSwitchService");
    private SelenideElement chooseExecutorButton = $(".jsSwitchExecutor");
    private ElementsCollection collectionServices = $$(".jsButtonChooseService");
    private ElementsCollection collectionDays = $$(".jsButtonChooseDay");
    private ElementsCollection collectionTime = $$(".jsButtonChooseTime");
    private SelenideElement labelName = $("#label-first_name");
    private SelenideElement labelPhone = $("#label-phone");
    private SelenideElement labelCode = $("#label-code");

    

    public void setLabelCode(SelenideElement labelCode) {
        this.labelCode = labelCode;
    }
    public SelenideElement getLabelCode() {
        return labelCode;
    }

    public void setLabelPhone(SelenideElement labelPhone) {
        this.labelPhone = labelPhone;
    }
    public SelenideElement getLabelPhone() {
        return labelPhone;
    }

    public void setLabelName(SelenideElement labelName) {
        this.labelName = labelName;
    }
    public SelenideElement getLabelName() {
        return labelName;
    }


    public ElementsCollection getCollectionTime() {
        return collectionTime;
    }

    public ElementsCollection getCollectionDays() {
        return collectionDays;
    }

    public ElementsCollection getCollectionServices() {
        return collectionServices;
    }



    public SelenideElement getChooseServiceButton() {
        return chooseServiceButton;
    }

    public SelenideElement getChooseExecutorButton() {
        return chooseExecutorButton;
    }
}
