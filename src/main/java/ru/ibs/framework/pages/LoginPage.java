package ru.ibs.framework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.ibs.framework.utils.PropConst;

public class LoginPage extends BasePage {



    @FindBy(xpath = "//input[@id=\"prependedInput\"]")
    private WebElement loginEnterField;

    @FindBy(xpath = "//input[@id=\"prependedInput2\"]")
    private WebElement passEnterField;

    @Step ("Логин")
    public MainPage login() {
        loginEnterField.sendKeys(propManager.getProperty(PropConst.LOGIN));
        passEnterField.sendKeys(propManager.getProperty(PropConst.PASSWORD));
        passEnterField.submit();
        return pageManager.getMainPage();
    }

}
