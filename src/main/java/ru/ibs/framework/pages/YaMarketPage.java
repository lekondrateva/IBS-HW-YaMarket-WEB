package ru.ibs.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class YaMarketPage extends BaseYaPage {

    @FindBy(xpath = "//a[@id='logoPartMarket']/span")
    private WebElement header;

    @FindBy(xpath = "//*[@id='catalogPopupButton']")
    private WebElement catalog;

    @FindBy(xpath = "//*[@role='tablist' and @data-tid]/li/a/span")
    private List<WebElement> menuList;

    @FindBy(xpath = "//li[@data-tid]/div/a")
    private List<WebElement> subMenuList;

    @FindBy(xpath = "//div[@role='heading']/div/a")
    private List<WebElement> categoriesList;

    @FindBy(xpath = "//*[@class='_1YdrM']/div/a")
    private List<WebElement> subMenuCategoriesList;

    @FindBy(xpath = "//button[@data-tid]/span/span")
    private WebElement allFilters;

    @FindBy(xpath = "//article[@class]")
    private List<WebElement> itemList;

    @FindBy(xpath = "//span[contains(text(), 'Показать')]")
    private WebElement pageDown;

    @FindBy(xpath = "(//article[@class])[1]//h3/a")
    private WebElement firstFoundItem;

    @FindBy(xpath = "//input[@id='header-search']")
    private WebElement mainSearchField;

    private static String savedItem = null;
    private static WebElement foundElement = null;

    public YaMarketPage checkOpenPage(String unitName) {
        ArrayList<String> tabs2 = new ArrayList<String>(driverManager.getDriver().getWindowHandles());
        driverManager.getDriver().switchTo().window(tabs2.get(1));
        waitUntilElementToBeVisible(header);
        Assert.assertEquals(unitName, header.getText());
        return pageManager.getYaMarketPage();
    }

    public YaMarketPage selectBaseMenuByText(String nameMenu) {
        catalog.click();
        for (WebElement itemMenu : menuList) {
            if (itemMenu.getText().contains(nameMenu)) {
                new Actions(driverManager.getDriver())
                        .moveToElement(itemMenu)
                        .perform();
                return pageManager.getYaMarketPage();
            }
        }
        Assert.fail("Меню с текстом " + nameMenu + " не найдено на странице");
        return pageManager.getYaMarketPage();
    }

    public YaMarketPage selectSubMenuByText(String nameSubMenu) {
        for (WebElement itemMenu : subMenuList) {
            if (itemMenu.getText().contains(nameSubMenu)) {
                itemMenu.click();
                return pageManager.getYaMarketPage();
            }
        }
        Assert.fail("Меню с текстом " + nameSubMenu + " не найдено на странице");
        return pageManager.getYaMarketPage();
    }

    public YaMarketPage selectCategoryByText(String categoryName) {
        for (WebElement itemMenu : categoriesList) {
            if (itemMenu.getText().contains(categoryName)) {
                itemMenu.click();
                return pageManager.getYaMarketPage();
            }
        }
        Assert.fail("Категория с текстом " + categoryName + " не найдена на странице");
        return pageManager.getYaMarketPage();
    }

    public YaMarketPage selectSubCategoryByText(String subCategoryName) {
        for (WebElement itemMenu : subMenuCategoriesList) {
            if (itemMenu.getText().contains(subCategoryName)) {
                itemMenu.click();
                return pageManager.getYaMarketPage();
            }
        }
        Assert.fail("Категория с текстом " + subCategoryName + " не найдена на странице");
        return pageManager.getYaMarketPage();
    }

    public ExtendedFiltersPage openAllFilters() {
        waitUntilElementToBeVisible(allFilters);
        allFilters.click();
        return pageManager.getExtendedFiltersPage();
    }

    public YaMarketPage countResultsOnPage(int count) {
        JavascriptExecutor js = ((JavascriptExecutor) driverManager.getDriver());
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Assert.assertEquals("Количество элементов на странице не равно" + count,
                count, itemList.size());
        return pageManager.getYaMarketPage();
    }

    public String saveElement() {
        savedItem = firstFoundItem.getAttribute("title");
        return savedItem;
    }

    public WebElement findElement() {
        fillInputField(mainSearchField, savedItem);
        mainSearchField.submit();
        foundElement = firstFoundItem;
        return foundElement;
    }

    public YaMarketPage assertItem() {
        Assert.assertEquals("Искомый элемент не найден",
                savedItem, foundElement.getAttribute("title"));
        return pageManager.getYaMarketPage();
    }

}