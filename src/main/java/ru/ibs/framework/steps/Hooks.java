package ru.ibs.framework.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.ibs.framework.managers.DriverManager;
import ru.ibs.framework.managers.InitManager;


public class Hooks {


    @Before(order = 10)
    public void before() {
        InitManager.initFramework();
    }

    @After
    public void tearDown(Scenario scenario) {
        String screenshotName = scenario.getName().replace(" ", "_");
        try {
            if (scenario.isFailed()) {
                scenario.log("Alarm!");
                TakesScreenshot ts = (TakesScreenshot) DriverManager.getInstance().getDriver();
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", screenshotName);
            }
        } catch (Exception e) {
                e.printStackTrace();
            }
        }

    @After
    public void after() {
        InitManager.quitFramework();
    }
}
