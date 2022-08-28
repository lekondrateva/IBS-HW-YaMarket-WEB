package ru.ibs.framework.steps;

import io.cucumber.java.ru.И;
import ru.ibs.framework.managers.PageManager;

public class YaMarketPageStep {
    PageManager pageManager = PageManager.getInstance();

    @И("^Открылась страница '(.+)'$")
    public void checkOpenPage(String unitName) {
        pageManager.getYaMarketPage().checkOpenPage(unitName);
    }

    @И("^Выбрать меню '(.+)'$")
    public void selectBaseMenuByText(String nameMenu) {
        pageManager.getYaMarketPage().selectBaseMenuByText(nameMenu);
    }

    @И("^Выбрать подменю '(.+)'$")
    public void selectSubMenuByText(String nameSubMenu) {
        pageManager.getYaMarketPage().selectSubMenuByText(nameSubMenu);
    }

    @И("^Выбрать категорию '(.+)'$")
    public void selectCategoryByText(String сategoryName) {
        pageManager.getYaMarketPage().selectCategoryByText(сategoryName);
    }

    @И("^Выбрать подкатегорию '(.+)'$")
    public void selectSubCategoryByText(String subCategoryName) {
        pageManager.getYaMarketPage().selectSubCategoryByText(subCategoryName);
    }

    @И("^Открыть все фильтры$")
    public void openAllFilters() {
        pageManager.getYaMarketPage().openAllFilters();
    }

    @И("^Количество элементов на странице равно \"(\\d+)\"$")
    public void countResultsOnPage(int count) {
        pageManager.getYaMarketPage().countResultsOnPage(count);
    }

    @И("^Сохранить первый найденный элемент$")
    public void saveElement() {
        pageManager.getYaMarketPage().saveElement();
    }

    @И("^Найти сохраненный элемент в поиске$")
    public void findElement() {
        pageManager.getYaMarketPage().findElement();
    }

    @И("^Сравнить найденный элемент с сохраненным$")
    public void assertItem() {
        pageManager.getYaMarketPage().assertItem();
    }

}
