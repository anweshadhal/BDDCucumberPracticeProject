package Hooks;
import Driver.DriverFactory;
import Utilities.ScreenshotUtil;
import io.cucumber.java.AfterStep;

public class CucumberHooks {
    @AfterStep
    public void takeScreenshotAfterStep() {

        ScreenshotUtil.attachScreenshot(DriverFactory.getDriver());

    }
}
