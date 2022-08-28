package ru.ibs.framework.steps;

import io.cucumber.java.ru.И;
import ru.ibs.framework.managers.PageManager;

public class ExtendedFiltersPageStep {
    PageManager pageManager = PageManager.getInstance();

    @И("^Все фильтры открылись$")
    public void checkFiltersOpen() {
        pageManager.getExtendedFiltersPage().checkFiltersOpen();
    }

    @И("^Задать минимальную цену '(.+)'$")
    public void fillMinPrice(String value) {
        pageManager.getExtendedFiltersPage().fillMinPrice(value);
    }

    @И("^Выбрать чекбокс '(.+)'$")
    public void enableCheckbox(String checkboxName) {
        pageManager.getExtendedFiltersPage().enableCheckbox(checkboxName);
    }

    @И("^Показать результаты$")
    public void showResults() {
        pageManager.getExtendedFiltersPage().showResults();
    }

}
