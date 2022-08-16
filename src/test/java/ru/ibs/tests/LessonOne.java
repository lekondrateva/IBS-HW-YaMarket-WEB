package ru.ibs.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.ibs.tests.base.BaseTests;

public class LessonOne extends BaseTests {

    @Test
    @DisplayName("Создать командировку без указания командируемых сотрудников")
    public void createTripWithoutEmployees() {

        // пройти авторизацию
        pageManager.getLoginPage().login()
                .checkOpenPage()
                .selectBaseMenuByText("Расходы")
                .selectSubMenuByText("Командировки")
                .createTrip()
                .checkHeader()
                .selectUnit("Research & Developmente")
                .selectCompany("(Edge) Призрачная Организация Охотников")
                .enableCheckbox("Заказ билетов")
                .fillField("Город прибытия", "Уфа")
                .fillField("Планируемая дата выезда", "30.09.2022")
                .fillField("Планируемая дата возвращения", "03.10.2022")
                .saveAndClose()
                .checkErrorMessage();
    }

}
