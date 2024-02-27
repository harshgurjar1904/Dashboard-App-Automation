package StepDefinitions.ServiceModule;


import StepDefinitions.Setup.BaseClass;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@CucumberOptions(features="src/test/resources/Features",glue={"StepDefinitions"}, monochrome = true,  plugin = {"pretty","html:target/htmlReports"},tags="@ServiceTest")
public class ServiceTestRunner extends BaseClass {
    public static String unitNo;
    public static String residentName;
    public static String serviceName;
    public static String packageName;
    public static String addonName;
    public static String addonQuantity;
    public static String preferenceTypeName;
    public static String preferenceName;

    @DataProvider(parallel = true)
    public Object[][] getData() throws IOException {
        List<HashMap<String,String>> data=getJsonData("src/test/java/StepDefinitions/ServiceModule/serviceTestdata.json");
        return new Object[][]{{data.get(5)}};
    }

    @Test(dataProvider="getData",priority=-1)
    public void dataSetter(HashMap<String,String> input) {
        unitNo = input.get("unitNo");
        residentName = input.get("residentName");
        serviceName=input.get("serviceName");
//        packageName=input.get("packageName");
        addonName=input.get("addonName");
        addonQuantity=input.get("addonQuantity");
//        preferenceTypeName=input.get("preferenceTypeName");
//        preferenceName=input.get("preferenceName");
    }


}
