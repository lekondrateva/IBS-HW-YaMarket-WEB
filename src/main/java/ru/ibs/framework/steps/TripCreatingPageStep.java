package ru.ibs.framework.steps;

import io.cucumber.java.ru.И;
import ru.ibs.framework.managers.PageManager;

public class TripCreatingPageStep {
    PageManager pageManager = PageManager.getInstance();

    @И("^Заголовок 'Создать командировку' появился$")
    public void checkHeader() {
        pageManager.getTripCreatingPage().checkHeader();
    }

    @И("^Выбрать '(.+)' отдел$")
    public void selectUnit(String unitName) {
        pageManager.getTripCreatingPage().selectUnit(unitName);
    }

    @И("^Выбрать '(.+)' организацию$")
    public void selectCompany(String companyName) {
        pageManager.getTripCreatingPage().selectCompany(companyName);
    }

    @И("^Включить '(.+)' чекбокс$")
    public void enableCheckbox(String checkboxName) {
        pageManager.getTripCreatingPage().enableCheckbox(checkboxName);
    }

    @И("^Заполнить поле '(.+)' значением '(.+)'$")
    public void fillField(String nameField, String value) {
        pageManager.getTripCreatingPage().fillField(nameField, value);
    }

    @И("^Сохранить и закрыть$")
    public void saveAndClose() {
        pageManager.getTripCreatingPage().saveAndClose();
    }

    @И("^Появилось сообщение об ошибке$")
    public void checkErrorMessage() {
        pageManager.getTripCreatingPage().checkErrorMessage();
    }
}
