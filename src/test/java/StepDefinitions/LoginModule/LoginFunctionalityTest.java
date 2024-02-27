//package StepDefinitions.LoginModule;
//
//import StepDefinitions.Setup.BaseClass;
//
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.options.UiAutomator2Options;
//import io.appium.java_client.service.local.AppiumDriverLocalService;
//import io.cucumber.java.AfterAll;
//import io.cucumber.java.BeforeAll;
//import io.cucumber.java.en.*;
//import org.digivalet.Modules.LoginModule.LoginPage;
//import org.digivalet.utils.AppiumUtils;
//import org.openqa.selenium.By;
//import org.testng.Assert;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.time.Duration;
//import java.util.Properties;
//
//
//public class LoginFunctionalityTest extends AppiumUtils {
//
//
//    public static AndroidDriver driver;
//    public static AppiumDriverLocalService service;
//
//    @BeforeAll
//    public static void configorAppium() throws IOException {
//
//        Properties prop=new Properties();
//        FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\Resources\\data.properties");
//        prop.load(fis);
//        String ipAddress=prop.getProperty("ipAddress");
//        int portNo=Integer.parseInt(prop.getProperty("portNo"));
//        String systemUserName=prop.getProperty("systenUserName2");
//        String deviceName=prop.getProperty("deviceName2");
//        int duration=Integer.parseInt(prop.getProperty("duration"));
//        String appPath=System.getProperty("user.dir")+"\\Resources\\base.apk";
//        service=startAppiumServer(systemUserName,ipAddress,portNo);
//        UiAutomator2Options option= new UiAutomator2Options();
//        option.setDeviceName(deviceName);
//        option.setApp(appPath);
//        driver= new AndroidDriver(service.getUrl(), option);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
//    }
//
//    @AfterAll
//    public static void tearDown() {
//
//        //stop the driver
//        driver.quit(); // closing the opened app on virtual phone
//        //stop the service or appium server
//        service.stop();
//    }
//
//    @Given("^User is on login page$")
//    public void user_is_on_login_page(){
//        System.out.println("On Login Page");
//    }
//
//    @When("^User enter (.*) and (.*)$")
//    public void userEnterEmailAndPassword(String email, String password) {
//        LoginPage loginDriver=new LoginPage(driver);
//        loginDriver.sendEmailAddress(email);
//        loginDriver.sendPasssword(password);
//    }
//
//    @And("^User click on Login button$")
//    public void userClickOnLoginButton() {
//        LoginPage loginDriver=new LoginPage(driver);
//        loginDriver.tapLoginButton();
//    }
//
//    @Then("^User get email (.*) message$")
//    public void userGetEmailErrorMessage(String error) {
//        String emailError=driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/email_error_text\"]")).getText();
//        Assert.assertEquals(emailError,error);
//    }
//    @Then("^User get password (.*) message$")
//    public void userGetPasswordErrorMessage(String error) {
//        String emailError=driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/password_error_text\"]")).getText();
//        Assert.assertEquals(emailError,error);
//    }
//
//    @Then("^User is navigated to the residents screen and verify (.*)$")
//    public void userIsNavigatedToTheResidentsScreenAndVerifyEmail(String email) {
//        LoginPage loginDriver=new LoginPage(driver);
//        loginDriver.allowPermission();
//        driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc='More']")).click();
//        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/label_feature_name\" and @text=\"Account\"]")).click();
//        String getEmail=driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/staff_email\"]")).getText();
//        Assert.assertEquals(getEmail, email);
//    }
//
//    @Then("^User get Incorrect (.*) message$")
//    public void userGetIncorrectErrorMessage(String error) {
//        String invalidError=driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/password_error_text\"]")).getText();
//        Assert.assertEquals(invalidError,error);
//    }
//
//}
