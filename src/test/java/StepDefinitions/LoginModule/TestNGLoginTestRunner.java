package StepDefinitions.LoginModule;


import StepDefinitions.Setup.BaseClass;
import io.cucumber.testng.CucumberOptions;
import org.digivalet.Modules.LoginModule.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


@CucumberOptions(features="src/test/resources/Features",glue={"StepDefinitions"}, monochrome = true, plugin = {"pretty","html:target/htmlReports"},tags="@LoginTest")
public class TestNGLoginTestRunner extends BaseClass {
//    public static String correctEmail;
//    public static String correctPassword;
    public static String incorrectEmail;
    public static String incorrectPassword;

    @DataProvider(parallel = true)
    public Object[][] getLoginData() throws IOException {

        List<HashMap<String,String>> data=getJsonData("src/test/java/StepDefinitions/LoginModule/loginTestData.json");
        return new Object[][]{{data.get(0)}};
    }

    @Test(dataProvider="getLoginData",priority = -1)
    public void setLoginData(HashMap<String,String> input) {
        correctEmail=input.get("emailAddress");
        correctPassword=input.get("password");
        incorrectEmail=input.get("incorrectEmailAddress");
        incorrectPassword=input.get("incorrectPassword");
    }


}
