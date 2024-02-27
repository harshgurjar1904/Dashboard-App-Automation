package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jdk.internal.org.jline.terminal.TerminalBuilder;

public class LoginSteps {
    @Given("User is on login page")
    public void user_is_on_login_page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Login step");
    //    throw new io.cucumber.java.PendingException();
    }

    @When("user enter email and password")
    public void user_enter_email_and_password() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("email and password step");
//        throw new io.cucumber.java.PendingException();
    }

    @When("Click on the Login button")
    public void click_on_the_login_button() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Login button step");
//        throw new io.cucumber.java.PendingException();
    }

    @Then("User is navigated to the residents screen")
    public void user_is_navigated_to_the_residents_screen() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Resident screen step");
//        throw new io.cucumber.java.PendingException();
    }

}
