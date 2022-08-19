package ru.ibs.framework.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TripCreatingPage extends BasePage {

    @FindBy(xpath = "//h1[@class='user-name']")
    private WebElement creatingTrip;

    @FindBy(xpath = "//select[@name='crm_business_trip[businessUnit]']")
    private WebElement units;

    @FindBy(xpath = "//select[@data-name='field__business-unit']/option")
    private List<WebElement> unitsList;

    @FindBy(xpath = "//a[@id='company-selector-show']")
    private WebElement companyListOpening;

    @FindBy(xpath = "//span[@class='select2-chosen']")
    private WebElement dropDownCompanyList;

    @FindBy(xpath = "//li[@class='select2-results-dept-0 select2-result select2-result-selectable']/div")
    private List<WebElement> companyList;

    @FindBy(xpath = "//div[@class='oro-clearfix']/label")
    private List<WebElement> checkboxes;

    @FindBy(xpath = "//input[@name='crm_business_trip[arrivalCity]']")
    private WebElement arrivalCity;

    @FindBy(xpath = "//input[contains(@id,'date_selector_crm_business_trip_departureDatePlan')]")
    private WebElement departureDate;

    @FindBy(xpath = "//input[contains(@id,'date_selector_crm_business_trip_returnDatePlan')]")
    private WebElement returnDate;

    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    private WebElement saveAndCloseBtn;

    @FindBy(xpath = "//span[@class='validation-failed']")
    private WebElement errorField;

    public TripCreatingPage checkHeader() {
        Assert.assertTrue("Страница не загрузилась", creatingTrip.isDisplayed());
        Assert.assertEquals("Создать командировку", creatingTrip.getText());
        return pageManager.getTripCreatingPage();
    }

    public TripCreatingPage selectUnit(String unitName) {
        units.click();
        for (WebElement itemMenu : unitsList) {
            if (itemMenu.getText().contains(unitName)) {
                itemMenu.click();
                return pageManager.getTripCreatingPage();
            }
        }
        Assert.fail("Отдел " + unitName + "не найден на странице");
        Assert.assertEquals(unitName, units.findElement(By.xpath("./../span")).getText());
        return pageManager.getTripCreatingPage();
    }

    public TripCreatingPage selectCompany(String companyName) {
        companyListOpening.click();
        dropDownCompanyList.click();
        for (WebElement itemMenu : companyList) {
            if (itemMenu.getText().contains(companyName)) {
                itemMenu.click();
                return pageManager.getTripCreatingPage();
            }
        }
        Assert.fail("Организация " + companyName + "не найдена на странице");
        Assert.assertEquals(companyName, dropDownCompanyList.getText());
        return pageManager.getTripCreatingPage();
    }

    public TripCreatingPage enableCheckbox(String checkboxName) {
        for (WebElement itemMenu : checkboxes) {
            if (itemMenu.getText().contains(checkboxName)) {
                itemMenu.click();
                Assert.assertTrue("Чекбокс не выбран", itemMenu.findElement(By.xpath("./../input")).isSelected());
                return pageManager.getTripCreatingPage();
            }
        }
        Assert.fail("Чекбокс " + checkboxName + "не найден на странице");
        return pageManager.getTripCreatingPage();
    }

    public TripCreatingPage fillField(String nameField, String value) {
        WebElement element = null;
        switch (nameField) {
            case "Город прибытия":
                fillInputField(arrivalCity, value);
                element = arrivalCity;
                break;
            case "Планируемая дата выезда":
                fillInputField(departureDate, value);
                element = departureDate;
                driverManager.getDriver().findElement(By.xpath("//html")).click();
                break;
            case "Планируемая дата возвращения":
                fillInputField(returnDate, value);
                driverManager.getDriver().findElement(By.xpath("//html")).click();
                element = returnDate;
                break;
            default:
                Assert.fail("Поле с наименованием '" + nameField + "' отсутствует на странице " +
                        "'Оформления командировки'");

        }
        Assert.assertEquals("Поле '" + nameField + "' было заполнено некорректно",
                value, element.getAttribute("value"));
        return pageManager.getTripCreatingPage();
    }

    public TripCreatingPage saveAndClose() {
        saveAndCloseBtn.click();
        return pageManager.getTripCreatingPage();
    }

    public TripCreatingPage checkErrorMessage() {
        waitUntilElementToBeVisible(errorField);
        Assert.assertEquals("Список командируемых сотрудников не может быть пустым", errorField.getText());
        return pageManager.getTripCreatingPage();
    }
}
