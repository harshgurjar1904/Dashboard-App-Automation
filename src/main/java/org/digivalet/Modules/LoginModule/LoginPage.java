package org.digivalet.Modules.LoginModule;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.digivalet.utils.PortalAppUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PortalAppUtils {
	
	AndroidDriver driver;
	public LoginPage(AndroidDriver driver) {
        super(driver);
        this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id=\"com.paragon.sensonicstaff:id/label_email_address\"]")
	public WebElement emailFieldLocator;
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id=\"com.paragon.sensonicstaff:id/label_password\"]")
	public WebElement passwordlocator;
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/btn_login\"]")
	private WebElement loginButtonLocator;

	public void sendEmailAddress(String emailAddress) {
		emailFieldLocator.sendKeys(emailAddress);
	}

	public void sendPasssword(String password) {
		passwordlocator.sendKeys(password);
	}
	
	public void tapLoginButton() {
		loginButtonLocator.click();
	}

}
