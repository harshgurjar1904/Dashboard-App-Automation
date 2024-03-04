package StepDefinitions.TestRunner;

import StepDefinitions.Setup.BaseClass;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@CucumberOptions(features="src/test/resources/Features",glue={"StepDefinitions"}, monochrome = true,  plugin = {"pretty","html:target/htmlReports"},tags="@ServiceTest")
public class TestRunner extends BaseClass {

}
