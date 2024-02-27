package StepDefinitions.OutletModule;

import StepDefinitions.Setup.BaseClass;
import io.cucumber.testng.CucumberOptions;
import org.digivalet.Modules.OutletModule.OutletProductOrdering;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@CucumberOptions(features="src/test/resources/Features",glue={"StepDefinitions"}, monochrome = true,  plugin = {"pretty","html:target/htmlReports"},tags="@OutletTest")
public class OutletTestRunner extends BaseClass {

    public static String outletName;
    public static String bookFrom;
    public static String unitNo;
    public static String residentName;
    public static String productName;
    public static int productQuantity;
    public static String modifierFamily;
    public static String modifierName;
    public static int modifierQuantity;
    public static String modifierQuantity1;

    public static String addonName;
    public static int addonQuantity;
    public static  String addonQuantity1;



    @DataProvider(parallel = true)
    public Object[][] getData() throws IOException {
        List<HashMap<String,String>> data=getJsonData("src/test/java/StepDefinitions/OutletModule/outletTestData1.json");
        return new Object[][]{{data.get(0)}};
    }

    @Test(dataProvider="getData",priority=-1)
    public void dataSetter(HashMap<String,String> input) {
        outletName=input.get("outletName");
        bookFrom=input.get("outletInstance");
        unitNo=input.get("unitNo");
        residentName=input.get("residentName");
        productName=input.get("productName");
        productQuantity=Integer.parseInt(input.get("productQuantity"));
        modifierFamily=input.get("modifierFamily");
        modifierName=input.get("modifierName");
        modifierQuantity1=input.get("modifierQuantity");
        modifierQuantity=Integer.parseInt(modifierQuantity1);
        addonName=input.get("addonName");
        addonQuantity1=input.get("addonQuantity");
        addonQuantity=Integer.parseInt(addonQuantity1);
    }


}
