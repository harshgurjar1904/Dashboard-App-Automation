package StepDefinitions.OutletModule;

import com.google.common.collect.ImmutableMap;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import jdk.internal.org.jline.terminal.TerminalBuilder;
import org.digivalet.Modules.OutletModule.OutletProductOrdering;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ProductOrderingFromOutlet extends OutletTestRunner{

//    adb shell dumpsy window | find "mCurrentFocus"
//    com.paragon.sensonicstaff/com.paragon.sensonicstaff.ui.activities.dashboard.DashboardActivity
    @Before(value="@GoToMoreSection")
    public void resetToMore(){
        driver.executeScript("mobile:startActivity", ImmutableMap.of("intent","com.paragon.sensonicstaff/com.paragon.sensonicstaff.ui.activities.dashboard.DashboardActivity"));
    }


    @Given("^I am on Outlet requests list  Screen$")
    public void userIsOnOutletRequestsListScreen() {
        OutletProductOrdering opo=new OutletProductOrdering(driver);
        opo.tapOnMore();
        opo.findOutlet(outletName);
    }

    @When("^I tap on plus icon$")
    public void userTapOnPlusIcon() {
        OutletProductOrdering opo=new OutletProductOrdering(driver);
        opo.tapOnAddButton();
    }

    @Then("^I am redirected to the Outlet requests screen$")
    public void userIsRedirectedToTheOutletRequestsScreen() {
        System.out.println(outletName);
    }


    @When("^I select Unit if unit is not auto fetched$")
    public void userSelectUnitIfNotAutoFetched() throws InterruptedException {
        OutletProductOrdering opo=new OutletProductOrdering(driver);
        opo.selectUnitNo(unitNo);
    }

    @And("^I select BookFor if book for is not auto fetched$")
    public void userSelectBookForIfBookForIsNotAutoFetched() throws InterruptedException {
        OutletProductOrdering opo=new OutletProductOrdering(driver);
        opo.selectResidentName(residentName);
    }

    @And("^I select BookFrom if book from is not auto fetched$")
    public void userSelectBookFromIfBookFromIsNotAutoFetched() throws InterruptedException {
        OutletProductOrdering opo=new OutletProductOrdering(driver);
        opo.selectOutletInstance(bookFrom);
    }

    @And("^I select Now schedule$")
    public void userSelectNowSchedule() {
        OutletProductOrdering opo=new OutletProductOrdering(driver);
        opo.selectNowSchedule();
    }

    @And("^I search the ProductName in searchbar$")
    public void userSearchTheProductNameInSearchbar() {
        OutletProductOrdering opo=new OutletProductOrdering(driver);
        opo.searchOnSearchbar(productName);
    }

    @Then("^I click on the searched product$")
    public void userClickOnTheSearchedProduct() {
        OutletProductOrdering opo=new OutletProductOrdering(driver);
        opo.selectProduct();
    }

    @Then("^I select the ProductQuantity$")
    public void userSelectTheProductQuantity() {
        OutletProductOrdering opo=new OutletProductOrdering(driver);
        opo.increaseCounterTo(productQuantity);
    }

    @And("^I click on Add to Cart button$")
    public void userClickOnAddToCartButton() {
        OutletProductOrdering opo=new OutletProductOrdering(driver);
        opo.tapOnAddToCartButton();
    }

    @Then("Cart icon will visible, click on it")
    public void cartIconWillVisibleClickOnIt() {
        OutletProductOrdering opo=new OutletProductOrdering(driver);
        opo.tapOnCartButton(1074,174);
    }

    @Then("^I am redirected to the order cart screen tap on Checkout button$")
    public void userIsRedirectedToTheOrderCartScreenTapOnCheckoutButton() {
        OutletProductOrdering opo=new OutletProductOrdering(driver);
        opo.tapOnAddToCartButton();
    }

    @Then("^I am redirected to the Request list screen$")
    public void userIsRedirectedToTheRequestListScreen() throws InterruptedException {
        System.out.println("Order is placed successfully");
    }

    @When("^I click on the request$")
    public void userClickOnTheRequest() throws InterruptedException {
        OutletProductOrdering opo=new OutletProductOrdering(driver);
        opo.getBookingList();
    }

    @Then("^I verify the order details$")
    public void userVerifyTheOrderDetails() {
        OutletProductOrdering opo=new OutletProductOrdering(driver);
        opo.BookingVerification(unitNo,residentName,productName,productQuantity,bookFrom);
    }

    @Then("^I select the Boolean Modifier$")
    public void iSelectTheBooleanModifier() {
        OutletProductOrdering opo=new OutletProductOrdering(driver);
        opo.addBooleanModifiers(modifierFamily, modifierName);

    }

    @Then("^I select the Boolean addon$")
    public void iSelectTheBooleanAddon() {
        OutletProductOrdering opo=new OutletProductOrdering(driver);
        opo.addBooleanAddon(addonName);
    }

    @Then("I verify the order details with addon details")
    public void iVerifyTheOrderDetailsWithAddon() {
        OutletProductOrdering opo=new OutletProductOrdering(driver);
        opo.BookingVerification(unitNo,residentName,productName,productQuantity,bookFrom);
        opo.modifierAndAddonVerification(addonQuantity1,addonName);
    }

    @Then("I verify the order details with modifier details")
    public void iVerifyTheOrderDetailsWithModifierDetails() {
        OutletProductOrdering opo=new OutletProductOrdering(driver);
        opo.BookingVerification(unitNo,residentName,productName,productQuantity,bookFrom);

    }

    @Then("I select the Quantity Modifier")
    public void iSelectTheQuantityModifier() throws InterruptedException {
        OutletProductOrdering opo=new OutletProductOrdering(driver);
        opo.addQuantityModifiers(modifierFamily, modifierName, modifierQuantity);
    }

    @Then("I select the Quantity addon")
    public void iSelectTheQuantityAddon() throws InterruptedException {
        OutletProductOrdering opo=new OutletProductOrdering(driver);
        opo.addQuantityAddon(addonName, addonQuantity);
    }

    @Then("I verify the order details with modifier and addon details")
    public void iVerifyTheOrderDetailsWithModifierAndAddonDetails() {
        OutletProductOrdering opo=new OutletProductOrdering(driver);
        opo.BookingVerification(unitNo,residentName,productName,productQuantity,bookFrom);
        opo.modifierAndAddonVerification(modifierQuantity1,modifierName,addonQuantity1,addonName);
    }
}
