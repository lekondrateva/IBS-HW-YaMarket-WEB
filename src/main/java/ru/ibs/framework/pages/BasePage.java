package ru.ibs.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ibs.framework.managers.DriverManager;
import ru.ibs.framework.managers.PageManager;
import ru.ibs.framework.managers.TestPropManager;

import java.time.Duration;

public class BasePage {

    protected DriverManager driverManager = DriverManager.getInstance();
    protected PageManager pageManager = PageManager.getInstance();
    protected TestPropManager propManager = TestPropManager.getInstance();

    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(10), Duration.ofSeconds(1));

    public BasePage () {
        PageFactory.initElements(driverManager.getDriver(), this);
    }

    protected void waitUntilElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void fillInputField(WebElement element, String value) {
        waitUntilElementToBeClickable(element);
        element.click();
        element.clear();
        element.sendKeys(value);
        boolean checkFlag = wait.until(ExpectedConditions.attributeContains(element, "value", value));
        Assert.assertTrue("Поле было заполнено некорректно", checkFlag);
    }
}
