package ru.ibs.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.ibs.framework.utils.PropConst;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id=\"prependedInput\"]")
    private WebElement loginEnterField;

    @FindBy(xpath = "//input[@id=\"prependedInput2\"]")
    private WebElement passEnterField;

    public LoginPage getUrl() {
        driverManager.getDriver().get(propManager.getProperty(PropConst.BASE_URL));
        return pageManager.getLoginPage();
    }

    public MainPage login() {
        loginEnterField.sendKeys(propManager.getProperty(PropConst.LOGIN));
        passEnterField.sendKeys(propManager.getProperty(PropConst.PASSWORD));
        passEnterField.submit();
        return pageManager.getMainPage();
    }

}
