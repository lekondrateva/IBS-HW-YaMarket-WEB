package ru.ibs.framework.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.ibs.framework.utils.PropConst;

import java.time.Duration;

public class DriverManager {

        private WebDriver driver;
        private TestPropManager propManager = TestPropManager.getInstance();
        private static DriverManager INSTANCE = null;

    private DriverManager() {
    }

    public static DriverManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DriverManager();
        }
        return INSTANCE;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    private void initDriver() {
        if (propManager.getProperty(PropConst.TYPE_BROWSER).equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", propManager.getProperty(PropConst.PATH_CHROME_DRIVER_WINDOWS));
            driver = new ChromeDriver();
        } else if (propManager.getProperty(PropConst.TYPE_BROWSER).equals("firefox")) {
            System.setProperty("webdriver.firefox.driver", propManager.getProperty(PropConst.PATH_FIREFOX_DRIVER_WINDOWS));
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

}
