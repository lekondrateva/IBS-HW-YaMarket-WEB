package ru.ibs.framework.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainPage extends BasePage {

    @FindBy(xpath = "//h1[@class=\"oro-subtitle\"]")
    private WebElement header;

    @FindBy(xpath = "//ul[@class='nav nav-multilevel main-menu']/li/a/span")
    private List<WebElement> listBaseMenu;

    @FindBy(xpath = "//ul/li[@data-route]/a/span")
    private List<WebElement> listSubMenu;

    @FindBy(xpath = "//*[@title=\"Создать командировку\"]")
    private WebElement creatingTrip;

    public MainPage checkOpenPage() {
        waitUntilElementToBeVisible(header);
        Assert.assertEquals("Панель быстрого запуска", header.getText());
        return pageManager.getMainPage();
    }

    public TripCreatingPage createTrip() {
        waitUntilElementToBeClickable(creatingTrip);
        creatingTrip.click();
        return pageManager.getTripCreatingPage();
    }

    public MainPage selectBaseMenuByText(String nameMenu) {
        for (WebElement itemMenu : listBaseMenu) {
            if (itemMenu.getText().contains(nameMenu)) {
                itemMenu.click();
                return pageManager.getMainPage();
            }
        }
        Assert.fail("Меню с текстом " + nameMenu + " не найдено на странице");
        return pageManager.getMainPage();
    }

    public MainPage selectSubMenuByText(String nameSubMenu) {
        for (WebElement itemMenu : listSubMenu) {
            if (itemMenu.getText().contains(nameSubMenu)) {
                itemMenu.click();
                return pageManager.getMainPage();
            }
        }
        Assert.fail("Меню с текстом " + nameSubMenu + " не найдено на странице");
        return pageManager.getMainPage();
    }


}
