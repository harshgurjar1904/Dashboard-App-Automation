package StepDefinitions.ServiceModule;

import StepDefinitions.TestRunner.TestRunner;
import io.cucumber.java.en.*;
import org.digivalet.Modules.ServiceModule.ServiceRequest;

import java.io.IOException;

public class ServiceModuleStepDef extends TestRunner {

    public static String path ="src/test/java/StepDefinitions/ServiceModule/serviceTestdata.json";
    public static int n=9;
    public static String serviceName;
    public static String packageName;
    public static String addonName;
    public static String addonQuantity;
    public static String preferenceTypeName;
    public static String preferenceName;
    public static String specialEntityName;
    public static String anotherPackageName;
    public static String requestDate;
    public static String preferredTime;
    public static String deliveryTime;
    public static String preferredTimeSlot;
    public static String deliveryDate;
    public static String deliveryTimeSlot;





    static {
        try {
            serviceName = getData(path,n,"serviceName");
            packageName=getData(path,n,"packageName");
            anotherPackageName=getData(path,n,"anotherPackageName");
            addonName=getData(path,n,"addonName");
            addonQuantity=getData(path,n,"addonQuantity");
            preferenceTypeName=getData(path,n,"preferenceTypeName");
            preferenceName=getData(path,n,"preferenceName");
            specialEntityName=getData(path,n,"petName");
            requestDate =getData(path,n,"date");
            preferredTime =getData(path,n,"time");
            deliveryTime=getData(path,n,"deliveryTime");
            preferredTimeSlot =getData(path,n,"timeSlot");
            deliveryDate=getData(path,n,"deliveryDate");
            deliveryTimeSlot=getData(path,n,"deliveryTimeSlot");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Given("I am on Service requests list  Screen")
    public void iAmOnServiceRequestsListScreen() {
        ServiceRequest serviceDriver= new ServiceRequest(driver);
        serviceDriver.tapOnMore();
        serviceDriver.openService();
    }

    @When("I tap on the add service button")
    public void iTapOnTheAddServiceButton() {
        ServiceRequest serviceDriver= new ServiceRequest(driver);
        serviceDriver.tapOnAddButton();
    }


    @Then("I am redirected to New Service Request Screen")
    public void iAmRedirectedToNewServiceRequestScreen() {
        System.out.println("I am new service request screen");
    }

    @When("I select Unit No if unit is not auto fetched")
    public void iSelectUnitNoIfUnitIsNotAutoFetched() throws InterruptedException {
        ServiceRequest serviceDriver= new ServiceRequest(driver);
        serviceDriver.selectUnitNo(unitNo);
    }
    @And("I select Resident Name in BookFor if  not auto fetched")
    public void iSelectResidentNameInBookForIfNotAutoFetched() throws InterruptedException {
        ServiceRequest serviceDriver= new ServiceRequest(driver);
        serviceDriver.selectResidentName(residentName);
    }

    @And("I select Service Name")
    public void iSelectServiceName() throws InterruptedException {
        ServiceRequest serviceDriver= new ServiceRequest(driver);
        serviceDriver.selectServiceInstance(serviceName);

    }

    @Then("I can see the Packages section")
    public void iCanSeeThePackagesSection() {
        System.out.println("Package Section appears");
    }



    @When("^I select the package$")
    public void iSelectThePackage() {
        ServiceRequest serviceDriver= new ServiceRequest(driver);
        serviceDriver.selectBooleanPackage(packageName);

    }

    @And("I tap on the Save button")
    public void iTapOnTheSaveButton() throws InterruptedException {
        ServiceRequest serviceDriver= new ServiceRequest(driver);
        serviceDriver.tapONSaveButton();
        Thread.sleep(5000);
    }

    @Then("I can see request is created successfully")
    public void iCanSeeRequestIsCreatedSuccessfully() {
        System.out.println("Request created successfully");
    }

    @When("I tap on created request")
    public void iTapOnCreatedRequest() throws InterruptedException {
        ServiceRequest serviceDriver= new ServiceRequest(driver);
        serviceDriver.getServiceRequest(serviceName);
    }

    @Then("I can verify request details with package")
    public void iCanVerifyRequestDetails() {
        ServiceRequest serviceDriver= new ServiceRequest(driver);
        serviceDriver.verifyRequestDetails(unitNo,residentName,serviceName,packageName);
    }

    @Then("I can see the addon section")
    public void iCanSeeTheAddonSection() {
        System.out.println("Addon Section appears");
    }

    @When("I select the addon")
    public void iSelectTheAddon() {
        ServiceRequest serviceDriver= new ServiceRequest(driver);
        serviceDriver.selectBooleanPackage(addonName);
    }

    @Then("I can verify request details with addon")
    public void iCanVerifyRequestDetailsWithAddon() {
        ServiceRequest serviceDriver= new ServiceRequest(driver);
        serviceDriver.verifyRequestDetails(unitNo,residentName,serviceName,addonName);

    }

    @And("I can increase the quantity of addon")
    public void iCanIncreaseTheQuantityOfAddon() {
     System.out.println("Quantity increased");
    }

    @Then("I can see the Preferences section")
    public void iCanSeeThePreferencesSection() {
        ServiceRequest serviceDriver= new ServiceRequest(driver);
        serviceDriver.selectPreferenceType(preferenceTypeName);
    }

    @When("I select the single select preference")
    public void iSelectTheSingleSelectPreference() throws InterruptedException {
        ServiceRequest serviceDriver= new ServiceRequest(driver);
        serviceDriver.selectPreferenceName(preferenceName);
    }

    @And("I select pet")
    public void iSelectPet() {
        ServiceRequest serviceDriver=new ServiceRequest(driver);
        serviceDriver.selectSpecialEntity(specialEntityName);
    }

    @And("I select one more package")
    public void iSelectOneMorePackage() {
        ServiceRequest serviceDriver= new ServiceRequest(driver);
        serviceDriver.selectBooleanPackage(anotherPackageName);
    }

    @And("I select the future date")
    public void iSelectTheFutureDate() {
        ServiceRequest serviceDriver=new ServiceRequest(driver);
        serviceDriver.selectRequestDate(requestDate);

    }

    @And("I select the preferred Request time")
    public void iSelectThePreferredTime() throws InterruptedException {
        ServiceRequest serviceDriver=new ServiceRequest(driver);
        serviceDriver.selectRequestTime(preferredTime);
    }

    @And("I select the preferred Delivery time")
    public void iSelectThePreferredDeliveryTime() throws InterruptedException {
        ServiceRequest serviceDriver=new ServiceRequest(driver);
        serviceDriver.selectDeliveryTime(deliveryTime);
    }

    @And("I select Request Time slot")
    public void iSelectRequestTimeSlot() throws InterruptedException {
        ServiceRequest serviceDriver=new ServiceRequest(driver);
        serviceDriver.selectPreferredTimeSlot(preferredTimeSlot);


    }

    @And("I select delivery date")
    public void iSelectDeliveryDate() {
        ServiceRequest serviceDriver = new ServiceRequest(driver);
        serviceDriver.selectDeliveryDate(deliveryDate);

    }

    @And("I select Delivery slot")
    public void iSelectDeliverySlot() throws InterruptedException {
        ServiceRequest serviceDriver = new ServiceRequest(driver);
        serviceDriver.selectDeliveryTimeSlot(deliveryTimeSlot);
    }

    @And("I select the preferred Request time in selected slot")
    public void iSelectThePreferredRequestTimeInSelectedSlot() throws InterruptedException {
        ServiceRequest serviceDriver=new ServiceRequest(driver);
        serviceDriver.selectRequestTimeInTimeSlot(preferredTime);
    }
}
