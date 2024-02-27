package StepDefinitions.LoginModule;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",glue={"StepDefinitions"}, monochrome = true, plugin = {"pretty","html:target/htmlReports"},tags="@LoginTest")
public class JunitLoginTestRunner{
}
