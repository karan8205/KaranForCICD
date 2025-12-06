package DAMS.PageObjects;

import static DAMS.Resources.Listeners.test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import DAMS.Resources.AbstractComponents;
import DAMS.Resources.BaseClass;

public class LoginPage extends AbstractComponents {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//MFA
	@FindBy(xpath = "//button[text()=\"Login with Daimler Truck Account\"]")
	WebElement logIn_MFA;
	@FindBy(xpath = "//input[@type=\"email\"]")
	WebElement username_MFA;
	@FindBy(xpath = "//input[@type=\"submit\"]")
	WebElement next_MFA;
	@FindBy(xpath = "//input[@type=\"password\"]")
	WebElement password_MFA;
	@FindBy(xpath = "//input[@data-report-event=\"Signin_Submit\"]")
	WebElement Signin_Submit_MFA;
	@FindBy(xpath = "//a[text()=\"I can't use my Microsoft Authenticator app right now\"]")
	WebElement MFA_bypass;
	@FindBy(xpath = "//div[text()=\"Use a verification code\"]")
	WebElement verification_code;
	@FindBy(xpath = "//input[@name=\"otc\"]")
	WebElement otpField;
	@FindBy(xpath = "//input[@type=\"submit\"]")
	WebElement verifyButton;

	public void goTo(String url){
		driver.get(url);
	}
	public void cleanup(String username, String password,String url) throws Throwable {
		loginApplicationasRequester_MFA(username, password, url);
		String generate_OTP_for_MFA = BaseClass.generate_OTP_for_MFA();
		enter_verification_code(generate_OTP_for_MFA);
	}
	public void loginApplicationasRequester_MFA(String username, String password,String url) throws InterruptedException {
		goTo(url);
//		test.pass("Navigate to URL"+ url);
		Thread.sleep(3000);
		logIn_MFA.click();
		clickJS(username_MFA);
		type(username_MFA, username);
		click(next_MFA);
		test.pass("User is able to enter username and clicks on next button");
		Thread.sleep(3000);
		password_MFA.click();
		type(password_MFA, password);
		click(Signin_Submit_MFA);
//		test.pass("User is able to enter password and clicks on sign-in button");
		//hari
//		MFA_bypass.click();
//		verification_code.click();
//		otpField.click();
	}
	public void enter_verification_code(String otp) throws InterruptedException {
		otpField.sendKeys(otp);
		clickJS(verifyButton);
		test.pass("User is able to enter otp and clicks on verify button");

	}
}