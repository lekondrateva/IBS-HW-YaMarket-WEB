package ru.ibs.framework.steps;

import io.cucumber.java.ru.И;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import ru.ibs.framework.managers.PageManager;
import ru.ibs.framework.pages.MainPage;
import ru.ibs.framework.pages.TripCreatingPage;

public class MainPageStep {
    PageManager pageManager = PageManager.getInstance();

    @И("^Открылась главная страница$")
    public void checkOpenPage () {
        pageManager.getMainPage().checkOpenPage();
    }

    @И("^Нажать на 'Создать командировку'$")
    public void createTrip() {
        pageManager.getMainPage().createTrip();
    }

    @И("^Выбрать меню '(.+)'$")
    public void selectBaseMenuByText(String nameMenu) {
        pageManager.getMainPage().selectBaseMenuByText(nameMenu);
    }

    @И("^Выбрать подменю '(.+)'$")
    public void selectSubMenuByText(String nameSubMenu) {
        pageManager.getMainPage().selectSubMenuByText(nameSubMenu);
    }
}
