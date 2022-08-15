package ru.ibs.tests;

import org.junit.Test;
import ru.ibs.tests.base.BaseTests;

public class LessonOne extends BaseTests {

    @Test
    public void createTripWithoutEmployees() {

        // пройти авторизацию
        pageManager.getLoginPage().login()
                .checkOpenPage()
                .selectBaseMenuByText("Расходы")
                .selectSubMenuByText("Командировки")
                .createTrip()
                .checkHeader()
                .selectUnit("Research & Development")
                .selectCompany("(Edge) Призрачная Организация Охотников")
                .enableCheckbox("Заказ билетов")
                .fillField("Город прибытия", "Уфа")
                .fillField("Планируемая дата выезда", "30.09.2022")
                .fillField("Планируемая дата возвращения", "03.10.2022")
                .saveAndClose()
                .checkErrorMessage();
    }

}
