package DAMS.PageObjects;

import static DAMS.Resources.Listeners.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import DAMS.Resources.AbstractComponents;
import DAMS.Resources.BaseClass;

public class LoginPage extends AbstractComponents {

	public LoginPage(WebDriver driver) {
		super(BaseClass.getDriver());
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
	//hari
	@FindBy(xpath = "//input[@id='signInName']")
	WebElement BusinessID_UserID;
	@FindBy(xpath = "//button[@type='button']")
	WebElement BusinessID_UserID_Continue;
	@FindBy(xpath = "//input[@id='password']")
	WebElement BusinessID_Password;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement BusinessID_Password_Continue;
	@FindBy(xpath = "//input[@value='secondaryEmail']")
	WebElement BusinessID_SecondaryEmail;
	@FindBy(xpath = "//button[@id='continue']")
	WebElement BusinessID_Email_Continue;
	@FindBy(xpath = "//button[text()='Send verification code']")
	WebElement BusinessID_VerificationCode;
	@FindBy(xpath = "//input[@id='verificationCode']")
	WebElement BusinessID_VerificationCodeInput;
	@FindBy(xpath = "//button[text()='Verify code']")
	WebElement BusinessID_VerifyCodeBtn;
	
	
	public void goTo(String url){
		BaseClass.getDriver().get(url);
	}
//	public void cleanup(String username, String password,String url) throws Throwable {
//		loginApplicationasRequester_MFA(username, password, url);
//		String generate_OTP_for_MFA = BaseClass.generate_OTP_for_MFA();
//		enter_verification_code(generate_OTP_for_MFA);
//	}
	public void loginApplicationasRequester_MFA(String username, String password,String url) throws InterruptedException {
        test.info("Environment : " + url);
		logger.info("URL : "+url);
		goTo(url);
//		test.pass("Navigate to URL"+ url);
		Thread.sleep(3000);
		logIn_MFA.click();
		clickJS(username_MFA);
		type(username_MFA, username);
		click(next_MFA);
		test.pass("User is able to enter username and clicks on next button");
		Thread.sleep(3000);
		clickJS(password_MFA);
		type(password_MFA, password);
		click(Signin_Submit_MFA);
//		test.pass("User is able to enter password and clicks on sign-in button");
		//hari
//		MFA_bypass.click();
//		verification_code.click();
//		otpField.click();
	}
	public void loginApplicationasRequester_MFA_Supplier(String username, String password,String url) throws InterruptedException {
        
		test.info("Environment : " + url);
		logger.info("URL : "+url);
		goTo(url);
		Thread.sleep(3000);
		clickJS(BusinessID_UserID);
		type(BusinessID_UserID, username);
		clickJS(BusinessID_UserID_Continue);
		test.pass("User is able to enter username and clicks on Continue button");
		clickJS(BusinessID_Password);
		type(BusinessID_Password, password);
		waitForelementToBeClickable(BusinessID_Password_Continue);
		clickJS(BusinessID_Password_Continue);
		test.pass("User is able to enter password and clicks on Continue button");
		Thread.sleep(3000);
		waitForWebElementToAppear(BusinessID_SecondaryEmail);
		waitForelementToBeClickable(BusinessID_SecondaryEmail);
		Thread.sleep(2000);
		click(BusinessID_SecondaryEmail);
		clickJS(BusinessID_Email_Continue);
		waitForelementToBeClickable(BusinessID_VerificationCode);
		clickJS(BusinessID_VerificationCode);
		
		String authCode = null;
        try {
            authCode = DAMS.Resources.EmailUtil.getVerificationCodeFromOutlook();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        if (authCode != null) {
            enter_BusinessID_verification_code(authCode);
        } else {
            throw new RuntimeException("MFA Verification Code was not retrieved from Outlook.");
        }
		
	}
	public void enter_verification_code(String otp) throws InterruptedException {
		otpField.sendKeys(otp);
		clickJS(verifyButton);
		test.pass("User is able to enter otp and clicks on verify button");

	}
	
	public void enter_BusinessID_verification_code(String otp) throws InterruptedException {
        waitForWebElementToAppear(BusinessID_VerificationCodeInput);
		BusinessID_VerificationCodeInput.sendKeys(otp);
		clickJS(BusinessID_VerifyCodeBtn);
		test.pass("User is able to enter Business ID otp and clicks on verify button");
	}
}