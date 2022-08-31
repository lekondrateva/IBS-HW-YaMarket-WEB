package ru.ibs.framework.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.ibs.framework.managers.DriverManager;
import ru.ibs.framework.managers.InitManager;

public class Hooks {

    @Before
    public void before() {
        InitManager.initFramework();
        DriverManager.getInstance().getDriver();
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
    public void afterAll() {
        InitManager.quitFramework();
    }

}
