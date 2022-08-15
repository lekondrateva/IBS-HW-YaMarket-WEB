package ru.ibs.tests.base;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import ru.ibs.framework.managers.DriverManager;
import ru.ibs.framework.managers.InitManager;
import ru.ibs.framework.managers.PageManager;
import ru.ibs.framework.managers.TestPropManager;
import ru.ibs.framework.utils.PropConst;

public class BaseTests {

    private DriverManager driverManager = DriverManager.getInstance();
    private TestPropManager propManager = TestPropManager.getInstance();
    protected PageManager pageManager = PageManager.getInstance();

    @BeforeClass
    public static void beforeClass () {
        InitManager.initFramework();
    }

    @Before
    public void before() {
        driverManager.getDriver().get(propManager.getProperty(PropConst.BASE_URL));
    }

    @AfterClass
    public static void after() {
        InitManager.quitFramework();
    }

}
