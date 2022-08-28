package ru.ibs.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ExtendedFiltersPage extends BaseYaPage {

    @FindBy(xpath = "//div[@class='tamef']/h1")
    private WebElement allFiltersHeader;

    @FindBy(xpath = "//div[@data-filter-id='glprice']//div[@data-prefix='от']/input")
    private WebElement priceMin;

    @FindBy(xpath = "//button/h4[contains(text(), 'Производитель')]/../..//div/input")
    private WebElement searchingBrands;

    @FindBy(xpath = "//button/h4[contains(text(), 'Производитель')]/../..//label/div")
    private List<WebElement> brandList;

    @FindBy(xpath = "//*[@data-tid=\"4add5a7e\"]//a[contains(text(), 'Показать')]")
    private WebElement showResults;

    public ExtendedFiltersPage checkFiltersOpen() {
        waitUntilElementToBeVisible(allFiltersHeader);
        Assert.assertEquals("Все фильтры", allFiltersHeader.getText());
        return pageManager.getExtendedFiltersPage();
    }

    public ExtendedFiltersPage fillMinPrice(String value) {
        waitUntilElementToBeVisible(priceMin);
        fillInputField(priceMin, value);
        Assert.assertEquals("Поле было заполнено некорректно",
                value, priceMin.getAttribute("value"));
        return pageManager.getExtendedFiltersPage();
    }

    public ExtendedFiltersPage enableCheckbox(String checkboxName) {
        searchingBrands.click();
        searchingBrands.clear();
        searchingBrands.sendKeys(checkboxName);
        for (WebElement itemMenu : brandList) {
            if (itemMenu.getText().contains(checkboxName)) {
                waitUntilElementToBeClickable(itemMenu);
                itemMenu.click();
                Assert.assertTrue("Чекбокс не выбран", itemMenu.findElement(By.xpath("./../input")).isSelected());
                return pageManager.getExtendedFiltersPage();
            }
        }
        Assert.fail("Чекбокс " + checkboxName + "не найден на странице");
        return pageManager.getExtendedFiltersPage();
    }

    public YaMarketPage showResults() {
        showResults.click();
        return pageManager.getYaMarketPage();
    }

}