package DAMS.PageObjects;

import static DAMS.Resources.Listeners.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import DAMS.Resources.AbstractComponents;
import DAMS.Resources.BaseClass;

public class MyRequest_Page extends AbstractComponents {

	public MyRequest_Page(WebDriver driver) {
		super(BaseClass.getDriver());
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
		waitForPageLoad(BaseClass.getDriver());
		waitForWebElementToAppear(homeBtn);
		refresh();
		waitForPageLoad(BaseClass.getDriver());
		Thread.sleep(2000);
		homeBtn.click();
		Thread.sleep(2000);
		waitForPageLoad(BaseClass.getDriver());
		}catch(Exception e) {
			Thread.sleep(2000);
			waitForPageLoad(BaseClass.getDriver());
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
		waitForPageLoad(BaseClass.getDriver());
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
		BaseClass.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		clickJS(My_Request);
		AbstractComponents.waitForelementToBeClickable(My_Request);
		clickJS(OnboardECU_request);
		AbstractComponents.waitForelementToBeClickable(OnboardECU_request);
		test.pass("User is able to select onborad ECU");
		logger.info("User is able to select onborad ECU");

	}
}