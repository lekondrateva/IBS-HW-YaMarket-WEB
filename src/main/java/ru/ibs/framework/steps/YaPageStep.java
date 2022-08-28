package ru.ibs.framework.steps;

import io.cucumber.java.ru.И;
import ru.ibs.framework.managers.PageManager;

public class YaPageStep {
    PageManager pageManager = PageManager.getInstance();

    @И("^Зайти на yandex.ru$")
    public void getUrl() {
        pageManager.getYaPage().getUrl();
    }

    @И("^Перейти в '(.+)'$")
    public void getUnit(String unitName) {
        pageManager.getYaPage().getUnit(unitName);
    }

}
