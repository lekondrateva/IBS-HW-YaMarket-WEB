package ru.ibs.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LessonOne {

    WebDriver driver;
    WebDriverWait wait;
    final String URL = "http://training.appline.ru/user/login";

    final String LOGIN = "Taraskina Valeriya";
    final String PASS = "testing";
    final String LOGIN_ENTER_XPATH = "//input[@id=\"prependedInput\"]";
    final String PASS_ENTER_XPATH = "//input[@id=\"prependedInput2\"]";

    final String QUICK_PANEL_XPATH = "//h1[@class=\"oro-subtitle\"]";

    final String EXPENSES_XPATH = "//div/ul/li/a/span[@class=\"title\" and text()=\"Расходы\"]";
    final String TRIP_XPATH = "//*[text()=\"Командировки\"]";
    final String CREATE_TRIP_XPATH = "//*[@title=\"Создать командировку\"]";
    final String CREATE_TRIP_HEADER_XPATH = "//h1[@class='user-name']";

    final String UNIT_LIST_XPATH = "//select[@name='crm_business_trip[businessUnit]']";
    final String SELECT_UNIT_XPATH = "//option[text()='Research & Development']";

    final String OPEN_LIST_XPATH = "//a[@id='company-selector-show']";
    final String DROP_DOWN_LIST_XPATH = "//span[@class='select2-chosen']";
    final String EDGE_COMPANY_XPATH = "//div[text()='(Edge) Призрачная Организация Охотников']";

    final String CHECKBOX_XPATH = "//input[@type='checkbox' and @data-ftid='crm_business_trip_tasks_1']";

    final String ARRIVAL_CITY_XPATH = "//input[@name='crm_business_trip[arrivalCity]']";
    final String DEPART_TIME_XPATH = "//input[contains(@id,'date_selector_crm_business_trip_departureDatePlan')]";
    final String RETURN_TIME_XPATH = "//input[contains(@id,'date_selector_crm_business_trip_returnDatePlan')]";

    final String SAVE_AND_EXIT_XPATH = "//button[@class='btn btn-success action-button']";
    final String ERROR_XPATH = "//span[@class='validation-failed']";

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, 10, 2000);
        driver.get(URL);
    }

    @Test
    public void createTripWithoutEmployees() {

        // пройти авторизацию
        driver.findElement(By.xpath(LOGIN_ENTER_XPATH)).sendKeys(LOGIN);
        WebElement passField = driver.findElement(By.xpath(PASS_ENTER_XPATH));
        passField.sendKeys(PASS);
        passField.submit();

        // проверить наличие заголовка Панель быстрого запуска
        Assert.assertEquals("Панель быстрого запуска", driver.findElement(By.xpath(QUICK_PANEL_XPATH)).getText());

        // в всплывающем окне Расходы нажать на Командировки
        Actions action = new Actions(driver);
        waitUntilElementToBeVisible(By.xpath(EXPENSES_XPATH));
        WebElement expenses = driver.findElement(By.xpath(EXPENSES_XPATH));
        action.moveToElement(expenses);
        action.perform();
        driver.findElement(By.xpath(TRIP_XPATH)).click();

        // нажать на Создать командировку
        driver.findElement(By.xpath(CREATE_TRIP_XPATH)).click();

        // проверить наличие на странице заголовка Создать командировку
        WebElement tripCreatingHeader = driver.findElement(By.xpath(CREATE_TRIP_HEADER_XPATH));
        Assert.assertTrue("Страница не загрузилась", tripCreatingHeader.isDisplayed());
        Assert.assertEquals("Создать командировку", tripCreatingHeader.getText());

        // на странице создания командировки заполнить или выбрать поля
        // подразделение - выбрать отдел + проверка заполнения
        WebElement unitsList = driver.findElement(By.xpath(UNIT_LIST_XPATH));
        unitsList.click();
        driver.findElement(By.xpath(SELECT_UNIT_XPATH)).click();
        Assert.assertEquals("Research & Development", unitsList.findElement(By.xpath("./../span")).getText());

        // открыть список, выбрать организацию + проверка заполнения
        driver.findElement(By.xpath(OPEN_LIST_XPATH)).click();
        WebElement dropDownList = driver.findElement(By.xpath(DROP_DOWN_LIST_XPATH));
        dropDownList.click();
        driver.findElement(By.xpath(EDGE_COMPANY_XPATH)).click();
        Assert.assertEquals("(Edge) Призрачная Организация Охотников", dropDownList.getText());

        // поставить чексбокс "Заказ билетов" + проверка заполнения
        WebElement checkbox = driver.findElement(By.xpath(CHECKBOX_XPATH));
        checkbox.click();
        Assert.assertTrue("Чекбокс не выбран", checkbox.isSelected());

        // указать город прибытия + проверка заполнения
        WebElement arrivalCity = driver.findElement(By.xpath(ARRIVAL_CITY_XPATH));
        fillInputField(arrivalCity, "Уфа");

        // указать дату выезда + проверка заполнения
        WebElement departDate = driver.findElement(By.xpath(DEPART_TIME_XPATH));
        fillInputField(departDate, "30.09.2022");
        driver.findElement(By.xpath("//html")).click();

        // указать дату возвращения + проверка заполнения
        WebElement returnDate = driver.findElement(By.xpath(RETURN_TIME_XPATH));
        fillInputField(returnDate, "03.10.2022");
        driver.findElement(By.xpath("//html")).click();

        // "сохранить и закрыть"
        driver.findElement(By.xpath(SAVE_AND_EXIT_XPATH)).click();

        // появилось сообщение "Список командируемых сотрудников не может быть пустым"
        waitUntilElementToBeVisible(By.xpath(ERROR_XPATH));
        String actualText = driver.findElement(By.xpath(ERROR_XPATH)).getText();
        Assert.assertEquals("Список командируемых сотрудников не может быть пустым", actualText);
    }

    private void waitUntilElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    private void waitUntilElementToBeVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void fillInputField(WebElement element, String value) {
        waitUntilElementToBeClickable(element);
        element.click();
        element.clear();
        element.sendKeys(value);
        boolean checkFlag = wait.until(ExpectedConditions.attributeContains(element, "value", value));
        Assert.assertTrue("Поле было заполнено некорректно", checkFlag);
    }

    @After
    public void exit() {
        driver.quit();
    }
}
