package ru.ibs.framework.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.ibs.framework.managers.DriverManager;
import ru.ibs.framework.managers.InitManager;

public class Hooks {

    @BeforeEach
    public void before() {
        InitManager.initFramework();
        DriverManager.getInstance().getDriver();
    }

//    @AfterEach
//    public void after() {
//        InitManager.closeFramework();
//    }

    @AfterEach
    public void afterAll() {
        InitManager.quitFramework();
    }

}
