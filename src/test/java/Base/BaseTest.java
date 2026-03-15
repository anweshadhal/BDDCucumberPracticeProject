package Base;

import Driver.DriverFactory;
import Utilities.ConfigReader;
import Utilities.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;

import static Utilities.ScreenshotUtil.folder;


public class BaseTest {
    @Before
    public void setUp() throws IOException {
        DriverFactory.initDriver();
        DriverFactory.getDriver().get(ConfigReader.getProperty("baseURL"));

    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
