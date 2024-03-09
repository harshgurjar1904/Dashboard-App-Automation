package StepDefinitions.Setup;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.digivalet.utils.AppiumUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass extends AppiumUtils{

	public static AndroidDriver driver;
	public AppiumDriverLocalService service;
	public static String path ="src/test/java/StepDefinitions/LoginModule/LoginTestData.json";
	public static int n=0;
	public static String correctEmail;
	public static String correctPassword;
	public static String unitNo;
	public static String residentName;

	static {
        try {
            correctEmail = getData(path,n,"emailAddress");
			correctPassword =getData(path,n,"password");
			unitNo=getData(path,n,"unitNo");
			residentName=getData(path,n,"residentName");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
	@BeforeClass
	public void configorAppium() throws IOException {

				Properties prop=new Properties();
				FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\Resources\\data.properties");
				prop.load(fis);
				String ipAddress=prop.getProperty("ipAddress");
				int portNo=Integer.parseInt(prop.getProperty("portNo"));
				String systemUserName=prop.getProperty("systenUserName1");
				String deviceName=prop.getProperty("deviceName1");
				int duration=Integer.parseInt(prop.getProperty("duration"));
				String appPath=System.getProperty("user.dir")+"\\Resources\\base.apk";


				service=startAppiumServer(systemUserName,ipAddress,portNo);
				UiAutomator2Options option= new UiAutomator2Options();
				option.setDeviceName(deviceName); 				
				option.setApp(appPath);
				option.autoGrantPermissions();
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



}
