package Runner;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"StepDefinitions","Base"},
        plugin = { "pretty", "html:target/cucumber/report.html",
                     "json:target/cucumber/report.json ",
                     "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
                },
        tags = "@smoke"
)
public class runner {
}
