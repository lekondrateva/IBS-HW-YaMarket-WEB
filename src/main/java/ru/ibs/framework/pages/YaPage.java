package ru.ibs.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.ibs.framework.utils.PropConst;

import java.util.List;

public class YaPage extends BaseYaPage{

    @FindBy(xpath = "//li/a/div[@class='services-new__item-title']")
    private List<WebElement> units;;

    public YaPage getUrl() {
        driverManager.getDriver().get(propManager.getProperty(PropConst.BASE_YA_URL));
        return pageManager.getYaPage();
    }

    public YaMarketPage getUnit(String unitName) {
        for (WebElement itemMenu : units) {
            if (itemMenu.getText().contains(unitName)) {
                itemMenu.click();
                return pageManager.getYaMarketPage();
            }
        }
        Assert.fail("Раздел " + unitName + "не найден на странице");
        return pageManager.getYaMarketPage();
    }

}
