package StepDefinitions.Setup;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.apache.commons.io.FileUtils;
import org.digivalet.Modules.LoginModule.LoginPage;
import org.digivalet.utils.AppiumUtils;

import io.cucumber.java.en.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseClass extends AppiumUtils{
	public static AndroidDriver driver;
	public AppiumDriverLocalService service;
	public static String correctEmail;
	public static String correctPassword;
//	public static LoginPage loginDriver=new LoginPage(driver);
	@BeforeClass
	public void configorAppium() throws IOException {
	
				Properties prop=new Properties(); 
				FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\Resources\\data.properties");
				prop.load(fis);
				String ipAddress=prop.getProperty("ipAddress");
				int portNo=Integer.parseInt(prop.getProperty("portNo"));
				String systemUserName=prop.getProperty("systenUserName2");
				String deviceName=prop.getProperty("deviceName2");
				int duration=Integer.parseInt(prop.getProperty("duration"));
				String appPath=System.getProperty("user.dir")+"\\Resources\\base.apk";
				service=startAppiumServer(systemUserName,ipAddress,portNo);
				UiAutomator2Options option= new UiAutomator2Options();
				option.setDeviceName(deviceName); 				
				option.setApp(appPath); 
				driver= new AndroidDriver(service.getUrl(), option);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
	}
	
	@AfterClass
	public void tearDown() {

		//stop the driver 
		driver.quit(); // closing the opened app on virtual phone
		//stop the service or appium server
		service.stop();
	}
	@DataProvider(parallel = true)
	public Object[][] getLoginData() throws IOException {

		List<HashMap<String,String>> data=getJsonData("src/test/java/StepDefinitions/LoginModule/loginTestData.json");
		return new Object[][]{{data.get(0)}};
	}

	@Test(dataProvider="getLoginData",priority = -2)
	public void setLoginData(HashMap<String,String> input) {
		correctEmail = input.get("emailAddress");
		correctPassword = input.get("password");
	}

}