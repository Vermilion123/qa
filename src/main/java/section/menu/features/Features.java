package section.menu.features;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.open;
import static config.StaticProp.getTestUrl;

/**
 * Created by Renat on 09.06.2016.
 */
public class Features {

    private FeaturesPage featuresPage;

    public Features() {
        featuresPage = new FeaturesPage();
    }

    public void openSectionFeatures() { open(getTestUrl() + "/clientix/settings/features"); }
    public void openItemAbonetments() { featuresPage.getAbonementItem().should(Condition.visible).click(); }

    public void openParamsClient() { featuresPage.getParamsClient().click(); }
}
