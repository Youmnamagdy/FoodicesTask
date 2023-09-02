package googleTestCases;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/java/googleTestCases/google.feature",
        glue = {"googleTestCases"},
        plugin = {"pretty", "html:target/cucumber-reports/report.html"}
)

public class googleTestRunner extends AbstractTestNGCucumberTests {
}
