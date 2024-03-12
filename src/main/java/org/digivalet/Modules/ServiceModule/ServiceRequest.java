package org.digivalet.Modules.ServiceModule;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.digivalet.utils.PortalAppUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class ServiceRequest extends PortalAppUtils {

    AndroidDriver driver;

    public ServiceRequest(AndroidDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/label_unit_value\"]")
    private WebElement unitNoFieldLocator;

    @AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/label_user_type_value\"]")
    private WebElement bookForLocator;

    @AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/label_service_value\"]")
    private WebElement serviceLocator;

    @AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/label_special_entity_value\"]")
    private WebElement specialEntityFieldLocator;

    @AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/label_room_name\"]")
    private WebElement requestUnitNoLocator;

    @AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/label_resident_name\"]")
    private WebElement requestResidentNameLocator;

    @AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/label_servicename\"]")
    private WebElement requestServiceNameLocator;

    @AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/label_package_value\"]")
    private WebElement requestPackageNameLocator;

    @AndroidFindBy(xpath="//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.paragon.sensonicstaff:id/date_time_rv\"]")
    private WebElement dateTimePickerLocator;



    @AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/Delivery_time_value\"]")
    private WebElement preferredDeliveryTimeLocator;



    public void openService(){
        openFeature("Services");
    }
    public void addNewServiceRequest(){
        tapOnAddButton();
    }
    public void selectUnitNo(String unitNo) throws InterruptedException {
        if(!unitNoFieldLocator.getText().contains(unitNo)) {
            unitNoFieldLocator.click();
            scrollToTextAndTap(unitNo);
        }

    }

    public void selectResidentName(String residentName) throws InterruptedException {
        if(!bookForLocator.getText().contains(residentName)) {
            bookForLocator.click();
            scrollToTextAndTap(residentName);
            tapONDoneButton();
        }
    }

    public void selectServiceInstance(String serviceName) throws InterruptedException {
        if(!serviceLocator.getText().contains(serviceName)) {
            serviceLocator.click();
            scrollToTextAndTap(serviceName);
        }
    }

    public void selectSpecialEntity(String entityName){
        specialEntityFieldLocator.click();
        scrollToTextAndTap(entityName);
        tapONDoneButton();
    }

    public void selectRequestDate(String date){
        WebElement parent=driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.paragon.sensonicstaff:id/date_time_rv\"]"));
        List<WebElement> childElement=parent.findElements(By.className("android.view.ViewGroup"));
        WebElement datePickerLocator=childElement.get(0).findElements(By.className("android.widget.TextView")).get(1);
        datePickerLocator.click();
        selectParticularDate(date);
    }

    public void selectDeliveryDate(String date){
        scrollToText("Note");
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/delivery_date_value\"]")).click();
        selectParticularDate(date);
    }


    public void selectDeliveryTimeSlot(String timeSlot) throws InterruptedException {
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/Delivery_time_value\"]")).click();
        selectParticularTimeSlot(timeSlot);

    }
    public void selectPreferredTimeSlot(String timeSlot) throws InterruptedException {
        WebElement parent=driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.paragon.sensonicstaff:id/date_time_rv\"]"));
        List<WebElement> childElement=parent.findElements(By.className("android.view.ViewGroup"));
        System.out.println("childElement size "+childElement.size());
        WebElement timeSlotPickerLocator=childElement.get(1).findElements(By.className("android.widget.TextView")).get(1);
        timeSlotPickerLocator.click();
        selectParticularTimeSlot(timeSlot);

    }



    public void selectRequestTime(String time) throws InterruptedException {

        WebElement parent=driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.paragon.sensonicstaff:id/date_time_rv\"]"));
        List<WebElement> childElement=parent.findElements(By.className("android.view.ViewGroup"));
        WebElement timePickerLocator=childElement.get(1).findElements(By.className("android.widget.TextView")).get(1);
        timePickerLocator.click();
        Thread.sleep(2000);
        selectTime(time);

    }
    public void selectRequestTimeInTimeSlot(String time) throws InterruptedException {

        WebElement parent=driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.paragon.sensonicstaff:id/date_time_rv\"]"));
        List<WebElement> childElement=parent.findElements(By.className("android.view.ViewGroup"));
        WebElement timePickerLocator=childElement.get(2).findElements(By.className("android.widget.TextView")).get(1);
        timePickerLocator.click();
        Thread.sleep(2000);
        selectTime(time);

    }

    public void selectDeliveryTime(String time) throws InterruptedException {
        preferredDeliveryTimeLocator.click();
        Thread.sleep(2000);
        selectTime(time);
    }

    public void selectBooleanPackage(String packageName){
        WebElement packagesSelector=driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.paragon.sensonicstaff:id/package_rv\"]"));
        List<WebElement> packageItemNames=packagesSelector.findElements(By.className("android.widget.TextView"));
        List<WebElement> packageItemSelectors=packagesSelector.findElements(By.id("com.paragon.sensonicstaff:id/checkbox"));
        int packageItemSize=packageItemNames.size();
        int packageSelectorSize=packageItemSelectors.size();
        int temp1=0;
        int temp2=0;
        System.out.println(packageItemSize);
        System.out.println(packageSelectorSize);

        while(temp1<packageItemSize){
            if(packageItemNames.get(temp1).getText().contains(packageName)){
                System.out.println(packageItemNames.get(temp1).getText());
                System.out.println("value of temp 2 "+temp2);
                packageItemSelectors.get(temp2).click();
                break;
            }

            if(!packageItemNames.get(temp1).getText().contains("$")){
                temp2++;
            }
            temp1++;
        }

    }

    public void selectQuantityPackage(String packageName,String packageQuantity){
        WebElement packagesSelector=driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.paragon.sensonicstaff:id/package_rv\"]"));
        List<WebElement> packageItemNames=packagesSelector.findElements(By.className("android.widget.TextView"));
        List<WebElement> packageItemSelectors=packagesSelector.findElements(By.className("android.widget.ImageView"));
        int packageItemSize=packageItemNames.size();
        int packageSelectorSize=packageItemSelectors.size();
        int temp1=0;
        int temp2=0;
        System.out.println(packageItemSize);
        System.out.println(packageSelectorSize);

        while(temp1<packageItemSize){

            if(packageItemNames.get(temp1).getText().contains(packageName)){
                System.out.println(packageItemNames.get(temp1).getText());
                packageItemSelectors.get(temp2).click();
                List<WebElement> plusLocator=packagesSelector.findElements(By.id("com.paragon.sensonicstaff:id/plus"));
                int temp3=1;
                System.out.println("size of plusLocator list "+plusLocator.size());
                while(temp3<Integer.parseInt(packageQuantity)){
                    plusLocator.get(0).click();
                    temp3++;
                }
                break;
            }

            if(!packageItemNames.get(temp1).getText().contains("$")){
                temp2++;
            }
            temp1++;
        }

    }

    public void selectPreferenceType(String preferenceType) {
        WebElement preferencesSection = driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.paragon.sensonicstaff:id/preference_rv\"]"));
        List<WebElement> preferencesName = preferencesSection.findElements(By.className("android.widget.TextView"));

        int s1 = preferencesName.size();
        int temp1 = 0;
        while (temp1 < s1) {
            if(preferencesName.get(temp1).getText().contains(preferenceType)){
                preferencesName.get(temp1).click();
                break;
            }
            temp1++;
        }
    }

    public void selectPreferenceName( String preferenceName){
        WebElement preferencesSection = driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.paragon.sensonicstaff:id/multi_price_rv\"]"));
        List<WebElement> preferencesName = preferencesSection.findElements(By.className("android.widget.TextView"));
        int s1 = preferencesName.size();
        int temp1 = 0;
        while (temp1 < s1) {
            if(preferencesName.get(temp1).getText().contains(preferenceName)){
                preferencesName.get(temp1).click();
                break;
            }
            temp1++;
        }
        tapONSaveButton();

    }

    public void getServiceRequest(String serviceName) throws InterruptedException {
        tapONFilterButton();
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/item_tv\" and @text=\"Today\"]")).click();
        WebElement servicetag= driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id=\"com.paragon.sensonicstaff:id/clBtnSelectTenants\"]"));
        List<WebElement> childElement= servicetag.findElements(By.className("android.widget.ImageView"));
        childElement.get(0).click();
        System.out.println("step passed");
        searchOnSearchbar(serviceName);
        driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.paragon.sensonicstaff:id/spinner_rv\"]/android.widget.LinearLayout")).click();
        tapONDoneButton();
        tapONSaveButton();
        Thread.sleep(3000);
        List<WebElement> requestList=driver.findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.paragon.sensonicstaff:id/requests_lists\"]"));
        int s1=requestList.size();
        System.out.println("size of list "+s1);
        requestList.get(s1-1).click();
    }

    public void verifyRequestDetails(String unitNo, String residentName, String serviceName, String packageName){
        String getUnitNO=requestUnitNoLocator.getText();
        String getResidentName=requestResidentNameLocator.getText();
        String getServiceName=requestServiceNameLocator.getText();
        String  getPackageName=requestPackageNameLocator.getText();
        System.out.println(getUnitNO + " "+getResidentName+" "+getServiceName+" "+getPackageName);
        System.out.println(unitNo.substring(0,4)+ " "+residentName+" "+serviceName+" "+packageName);
        System.out.println(getUnitNO.contains(unitNo.substring(0,4))+" "+getResidentName.contains(residentName) +" "+getServiceName.contains(serviceName)+getPackageName.contains(packageName));
        if(getUnitNO.contains(unitNo.substring(0,4)) && getResidentName.contains(residentName) && getServiceName.contains(serviceName) && getPackageName.contains(packageName)){
            System.out.println("Details matched");
        }
        else{
            System.out.println("Details doesn't match!");
        }

    }



}
