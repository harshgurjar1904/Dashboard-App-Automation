package StepDefinitions.LoginModule;

import StepDefinitions.Setup.BaseClass;
import io.cucumber.java.en.*;
import org.digivalet.Modules.LoginModule.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginFunctionalityTest extends BaseClass {

    LoginPage loginDriver;
    @Given("^User is on login page$")
    public void user_is_on_login_page(){
        loginDriver=new LoginPage(driver);
        System.out.println("On Login Page");
    }

    @When("^User enter (.*) and (.*)$")
    public void userEnterEmailAndPassword(String email, String password) {
        loginDriver.sendEmailAddress(email);
        loginDriver.sendPasssword(password);
    }

    @And("^User click on Login button$")
    public void userClickOnLoginButton() {
        loginDriver.tapLoginButton();
    }

    @Then("^User get email (.*) message$")
    public void userGetEmailErrorMessage(String error) {
        String emailError=driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/email_error_text\"]")).getText();
        Assert.assertEquals(emailError,error);
    }
    @Then("^User get password (.*) message$")
    public void userGetPasswordErrorMessage(String error) {
        String emailError=driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/password_error_text\"]")).getText();
        Assert.assertEquals(emailError,error);
    }

    @Then("^User is navigated to the residents screen with correct (.*)$")
    public void userIsNavigatedToTheResidentsScreenWithCorrectEmail(String email) {
        loginDriver.allowPermission();
        driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc='More']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/label_feature_name\" and @text=\"Account\"]")).click();
        String getEmail=driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/staff_email\"]")).getText();
        Assert.assertEquals(getEmail, email);
    }

    @Then("^User get Incorrect (.*) message$")
    public void userGetIncorrectErrorMessage(String error) {
        String invalidError=driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/password_error_text\"]")).getText();
        Assert.assertEquals(invalidError,error);
    }
}
