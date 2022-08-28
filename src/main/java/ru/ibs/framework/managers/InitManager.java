package ru.ibs.framework.managers;

import java.time.Duration;

import static ru.ibs.framework.utils.PropConst.IMPLICITLY_WAIT;
import static ru.ibs.framework.utils.PropConst.PAGE_LOAD_TIMEOUT;

public class InitManager {

    private static final TestPropManager props = TestPropManager.getInstance();
    private static final DriverManager driverManager = DriverManager.getInstance();

    public static void initFramework() {

        driverManager.getDriver().manage().window().maximize();
        driverManager.getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(Integer.parseInt(props.getProperty(IMPLICITLY_WAIT))));
        driverManager.getDriver().manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(props.getProperty(PAGE_LOAD_TIMEOUT))));
    }

    public static void quitFramework() {
        driverManager.quitDriver();
    }

    public static void closeFramework() {
        driverManager.closeDriver();
    }

}
