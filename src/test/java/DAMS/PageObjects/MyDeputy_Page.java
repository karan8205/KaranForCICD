package DAMS.PageObjects;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DAMS.ObjectManager.PageObjectManager;
import DAMS.Resources.AbstractComponents;

public class MyDeputy_Page extends AbstractComponents {
	WebDriver driver;

	public MyDeputy_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='My Deputy']")
	private WebElement menu_Id_Mydeputy;

	@FindBy(xpath = "//input[@aria-autocomplete='list']")
	private WebElement search_deputy;

	@FindBy(xpath = "//button/span[text()='Add']")
	private WebElement Add_button;

	@FindBy(xpath = "//*[text()=\" My Deputy List\"]")
	private WebElement My_DeputyList;

	@FindBy(xpath = "//*[text()=\"Delegator\"]")
	private WebElement Deputy;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,'delegator')]")
	private WebElement Deputy_txt;

	@FindBy(xpath = "//*[text()=\"Email\"]")
	private WebElement Email;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"email\")]")
	private WebElement Email_txt;

	@FindBy(xpath = "//*[text()=\"Username\"]")
	private WebElement Username;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"username\")]")
	private WebElement Username_txt;

	@FindBy(xpath = "//*[text()=\"Action\"]")
	private WebElement Action;

	@FindBy(xpath = "//*[text()=\"delete\"]")
	private WebElement Action_txt;
	
	@FindBy(xpath = "//*[text()=\"Delegator\"]")
	private WebElement Delegator;
	
	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"delegator\")]")
	private WebElement Delegator_txt;
	
	@FindBy(xpath = "//*[contains(text(),\"Are you \")]")
	private WebElement confirmation_popup;
	
	@FindBy(xpath = "//*[text()=\"Back\"]")
	private WebElement Back;
	
	@FindBy(xpath = "//*[text()=\"Ok\"]")
	private WebElement Ok;
	
	public void Mydeputy_enabled() throws InterruptedException {
		Thread.sleep(5000);
		waitForWebElementToAppear(menu_Id_Mydeputy);
		menu_Id_Mydeputy.isEnabled();
		click(menu_Id_Mydeputy);
		Thread.sleep(2000);
	}
	
	public boolean deletebtn_displayed() {
		return Action_txt.isDisplayed();
			
		}

	public void Validate_Mydeputy(String name) throws Throwable {
		waitForWebElementToAppear(search_deputy);
		click(search_deputy);
		search_deputy.sendKeys(name);
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[text()='" + name + "']")).click();
		Thread.sleep(100);
		waitForWebElementToAppear(Add_button);
		click(Add_button);
	}

//	public void myDeputy_list(String deputy_txt, String email_txt, String username_txt) throws InterruptedException {
//		Thread.sleep(2000);
//		waitForWebElementToAppear(Deputy);
//		Deputy_txt.getText().contains(deputy_txt);
//		Thread.sleep(2000);
//		waitForWebElementToAppear(Email);
//		Email_txt.getText().contains(email_txt);
//		Thread.sleep(2000);
//		waitForWebElementToAppear(Username);
//		Username_txt.getText().contains(username_txt);
//	}
	public void my_Delegator_list(String delegator_txt, String Delegator_email_txt, String Delegator_username_txt) {
		waitForWebElementToAppear(Delegator);
		waitForWebElementToAppear(Email);
		waitForWebElementToAppear(Username);
		Delegator_txt.getText().contains(delegator_txt);
		Email_txt.getText().contains(Delegator_email_txt);
		Username_txt.getText().contains(Delegator_username_txt);
		
	}
	
	public void remove_my_Deputy() throws Throwable {
		Thread.sleep(3000);
		waitForWebElementToAppear(Action_txt);
		clickJS(Action_txt);
		waitForWebElementToAppear(confirmation_popup);
		waitForWebElementToAppear(Back);
		waitForWebElementToAppear(Ok);
		clickJS(Back);
		waitForWebElementToAppear(Action_txt);
		clickJS(Action_txt);
		Thread.sleep(200);
		clickJS(Ok);
		Thread.sleep(200);
		waitForWebElementnotToAppear(Deputy);
		waitForWebElementnotToAppear(Email);
		waitForWebElementnotToAppear(Username);
		waitForWebElementnotToAppear(Action);

	}
	
	public void remove_my_Delegator() {
		waitForWebElementnotToAppear(Delegator);
		waitForWebElementnotToAppear(Email);
		waitForWebElementnotToAppear(Username);

	}	
}