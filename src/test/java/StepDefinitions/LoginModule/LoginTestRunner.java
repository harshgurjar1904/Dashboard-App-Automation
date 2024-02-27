package StepDefinitions.LoginModule;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/LoginModule/login.feature",glue={"StepDefinitions/LoginModule"}, monochrome = true, plugin = {"pretty","html:target/htmlReports"},tags="@ValidLoginTest")
public class LoginTestRunner {
}
