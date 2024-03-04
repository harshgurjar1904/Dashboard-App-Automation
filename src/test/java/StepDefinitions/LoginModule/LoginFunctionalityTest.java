package StepDefinitions.LoginModule;

import StepDefinitions.TestRunner.TestRunner;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.digivalet.Modules.LoginModule.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;

import static org.digivalet.utils.AppiumUtils.getData;

public class LoginFunctionalityTest extends TestRunner {
//    public static LoginPage loginDriver=new LoginPage(driver);
    public static String incorrectEmail;
    public static String incorrectPassword;
    static {
        try {
            incorrectEmail = getData(0,"incorrectEmailAddress");
            incorrectPassword =getData(0,"incorrectPassword");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Before(value="@LoginTest")
    public void reset(){
        LoginPage loginDriver=new LoginPage(driver);
        loginDriver.emailFieldLocator.clear();
        loginDriver.passwordlocator.clear();
    }
    @Given("^I am on login page$")
    public void user_is_on_login_page(){
        System.out.println("On Login Page");
    }

    @When("^I am not  entering email and password$")
    public void userNotEnterEmailAndPassword() {
    }

    @And("^I click on Login button$")
    public void userClickOnLoginButton() {
        LoginPage loginDriver=new LoginPage(driver);
       loginDriver.tapLoginButton();
    }


    @Then("I get email address error")
    public void iGetEmailAddressError() {
        String emailError=driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/email_error_text\"]")).getText();
        Assert.assertEquals(emailError,"Email address can't be blank.");
    }

    @When("I am entering email")
    public void iAmEnteringEmail() {
        LoginPage loginDriver=new LoginPage(driver);
        loginDriver.sendEmailAddress(correctEmail);
    }

    @Then("I get password error")
    public void iGetPasswordError() {
        String emailError=driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/password_error_text\"]")).getText();
        Assert.assertEquals(emailError,"Password can't be blank.");
    }

    @When("I am entering  password")
    public void iAmEnteringPassword() {
        LoginPage loginDriver=new LoginPage(driver);
        loginDriver.sendPasssword(correctPassword);
    }

    @When("I am entering incorrect email and correct password")
    public void iAmEnteringIncorrectEmailAndCorrectPassword() {
        LoginPage loginDriver=new LoginPage(driver);
        loginDriver.sendEmailAddress(incorrectEmail);
        loginDriver.sendPasssword(correctPassword);
    }

    @Then("I get Incorrect error")
    public void iGetIncorrectError() {
        String invalidError=driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/password_error_text\"]")).getText();
        Assert.assertEquals(invalidError,"Incorrect username or password.");
    }

    @When("I am entering correct email and incorrect password")
    public void iAmEnteringCorrectEmailAndIncorrectPassword() {
        LoginPage loginDriver=new LoginPage(driver);
        loginDriver.sendEmailAddress(correctEmail);
        loginDriver.sendPasssword(incorrectPassword);
    }

    @When("I am  entering incorrect email and incorrect password")
    public void iAmEnteringIncorrectEmailAndIncorrectPassword() {
        LoginPage loginDriver=new LoginPage(driver);
        loginDriver.sendEmailAddress(incorrectEmail);
        loginDriver.sendPasssword(incorrectPassword);
    }

    @When("I am entering correct email and correct password")
    public void iAmEnteringCorrectEmailAndCorrectPassword() {
        LoginPage loginDriver=new LoginPage(driver);
        loginDriver.sendEmailAddress(correctEmail);
        loginDriver.sendPasssword(correctPassword);
    }

    @Then("I am navigated to the residents screen and verify email")
    public void iAmNavigatedToTheResidentsScreenAndVerifyEmail() {
        LoginPage loginDriver=new LoginPage(driver);
        loginDriver.allowPermission();
        driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc='More']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/label_feature_name\" and @text=\"Account\"]")).click();
        String getEmail=driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/staff_email\"]")).getText();
        Assert.assertEquals(getEmail, correctEmail);
    }

    @Then("I am navigated to the residents screen")
    public void iAmNavigatedToTheResidentsScreen() {
        LoginPage loginDriver=new LoginPage(driver);
        loginDriver.allowPermission();
    }
}
