package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/fratureFiles/Web/Sample/login.feature",
        monochrome = true,
        plugin = {"json:target/cucumber.json", "pretty"},
        glue = {"com.cucumber.StepDefinitions", "UtilFactory"}
)


public class Runner extends AbstractTestNGCucumberTests {

}
