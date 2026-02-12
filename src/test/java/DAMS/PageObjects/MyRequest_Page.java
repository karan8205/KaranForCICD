package DAMS.PageObjects;

import static DAMS.Resources.Listeners.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DAMS.Resources.AbstractComponents;

public class MyRequest_Page extends AbstractComponents {
	WebDriver driver;

	public MyRequest_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='My Requests']")
	private WebElement My_Request;

	@FindBy(xpath = "//span[text()='New Permission']")
	private WebElement NewPermission_request;

	@FindBy(xpath = "//span[text()='Onboard New ECU']")
	private WebElement OnboardECU_request;
	
	@FindBy(xpath = "//span[text()='Home']")
	private WebElement homeBtn;

	
	public void clickHomeButton() throws InterruptedException {
		try {
		waitForPageLoad(driver);
		waitForWebElementToAppear(homeBtn);
		refresh();
		waitForPageLoad(driver);
		Thread.sleep(2000);
		homeBtn.click();
		Thread.sleep(2000);
		waitForPageLoad(driver);
		}catch(Exception e) {
			Thread.sleep(2000);
			waitForPageLoad(driver);
			waitForWebElementToAppear(homeBtn);	
			clickJS(homeBtn);
		}
	}
	
	public void select_NewPermission_request() throws InterruptedException {
		//hari
//		refresh();
		Thread.sleep(5000);
		//homeBtn.click();
//		//
		//refresh();
		//Thread.sleep(4000);
		waitForPageLoad(driver);
		waitForWebElementToAppear(My_Request);
		
//		if(My_Request.isEnabled()) {
			AbstractComponents.waitForWebElementToAppear(My_Request);
			AbstractComponents.waitForelementToBeClickable(My_Request);
			Thread.sleep(2000);
			clickElement(My_Request);
			Thread.sleep(1000);
			AbstractComponents.waitForelementToBeClickable(NewPermission_request);
			clickElement(NewPermission_request);
			
			Thread.sleep(1000);
			test.pass("User is able to select New permission request");
			logger.info("User is able to select New permission request");
//		}


	}
	//hari
	public void newPermissionRequest() throws InterruptedException {
		Thread.sleep(1000);
		AbstractComponents.waitForelementToBeClickable(NewPermission_request);
		clickJS(NewPermission_request);
		Thread.sleep(1000);
	}

	public void My_Request_enabled_onboardECU() throws InterruptedException {
		refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		clickJS(My_Request);
		AbstractComponents.waitForelementToBeClickable(My_Request);
		clickJS(OnboardECU_request);
		AbstractComponents.waitForelementToBeClickable(OnboardECU_request);
		test.pass("User is able to select onborad ECU");
		logger.info("User is able to select onborad ECU");

	}
}