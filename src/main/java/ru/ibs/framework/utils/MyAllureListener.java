package ru.ibs.framework.utils;

import io.qameta.allure.Attachment;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.ibs.framework.managers.DriverManager;

public class MyAllureListener extends AllureJunit5 implements TestWatcher {
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        getScreenshot();
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] getScreenshot() {
        return ((TakesScreenshot) DriverManager.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
