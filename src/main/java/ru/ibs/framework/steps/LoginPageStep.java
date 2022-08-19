package ru.ibs.framework.steps;

import io.cucumber.java.ru.И;
import ru.ibs.framework.managers.PageManager;
import ru.ibs.framework.pages.MainPage;
import ru.ibs.framework.utils.PropConst;

public class LoginPageStep {
    PageManager pageManager = PageManager.getInstance();

    @И("^Открыть страницу логина$")
    public void getUrl() {
        pageManager.getLoginPage().getUrl();
    }

    @И("^Залогиниться$")
    public void login() {
        pageManager.getLoginPage().login();
    }
}
