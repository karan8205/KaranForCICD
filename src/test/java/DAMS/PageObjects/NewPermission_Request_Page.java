package DAMS.PageObjects;

import static DAMS.Resources.Listeners.test;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DAMS.Resources.AbstractComponents;
import DAMS.Resources.BaseClass;

public class NewPermission_Request_Page extends AbstractComponents {
	WebDriver driver;
	public static Logger logger = Logger.getLogger("DAMS");

	public NewPermission_Request_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()='Diagnostic Authority']")
	private WebElement Diagnostic_Authority_text;

	@FindBy(xpath = "//mat-select[@placeholder='Please select your user role']")
	private WebElement Userrole_dropdown;

	@FindBy(xpath = "//div/span[text()='Please select your role']")
	private WebElement functional_role_dropdown;

	@FindBy(xpath = "//div[@role='listbox']//span")
	private List<WebElement> Userrole_dropdown_option;

	@FindBy(xpath = "//mat-option/span[contains(text(),\" ECU Supplier - Key Management \")]")
	private List<WebElement> Userrole_dropdown_option_ECU_supplier;

	@FindBy(xpath = "//div/span[text()='Please select the required ECU']")
	private WebElement ECU_dropdown;

	@FindBy(xpath = "//mat-option/span")
	private List<WebElement> ECU_dropdown_option;

	@FindBy(xpath = "//*[@id='reason']")
	private WebElement reason_field;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submit_button;

	@FindBy(xpath = "//span[text()='Request Overview']")
	private WebElement Request_Overview;

	@FindBy(xpath = "//mat-option/span")
	private List<WebElement> Authorization_List;

	@FindBy(xpath = "//mat-card-content[1]/div/div[2]/mat-form-field/div/div[1]/div[3]/mat-select/div/div[1]")
	private WebElement Authorization_dropdown;

	@FindBy(xpath = "//*[text()='Special Cases']")
	private WebElement SpecialCase_text;

	@FindBy(xpath = "//div/span[text()='Please select the case']")
	private WebElement SpecialCase_dropdown;

	@FindBy(xpath = "//div/span[text()='Please select the required Nest-T Testing Case']")
	private WebElement SpecialCase_NestT_dropdown;
	
	@FindBy(xpath = "//div/span[text()='Please select the required permission']")
	private WebElement SpecialCase_DiagPermission_dropdown;

	@FindBy(xpath = "//div/span[text()='Please select the required ECU Qualifier']")
	private WebElement NestT_ECUQualifier;
	
	@FindBy(xpath = "//div/span[text()='Please select the required ECU Qualifier']")
	private WebElement FOTA_ECUQualifier;

	@FindBy(xpath = "//textarea[@id='reason']")
	private WebElement ERA_reason_field;

	@FindBy(xpath = "//*[text()=\" Create 1 ECU Certificate with multiple ECU Qualifier\"]")
	private WebElement grouping_field;

	@FindBy(xpath = "//div/textarea[@data-placeholder='Maximum 500 characters only']")
	private WebElement ERA_reason_field1;

	@FindBy(xpath = "//*[@id='reasonSpecialCase']")
	private WebElement nest_reason_field1;

	@FindBy(xpath = "(//span[text()='Please select the origin COT'])[1]")
	private WebElement OriginCOT_dropdown;

	@FindBy(xpath = "//*[@placeholder=\"Please select the required ECU\"]")
	private WebElement ecu_dropdown;

	@FindBy(xpath = "(//span[text()='Please select the target COT'])[1]")
	private WebElement TargetCOT_dropdown;

	@FindBy(xpath = "//span[text()='Enhance Right Authority']")
	private WebElement EnhanceRight_Authority_text;

	@FindBy(xpath = "//div/span[text()='Please select the certificate']")
	private WebElement ERA_DA_dropdown;

	@FindBy(xpath = "//input[@placeholder='Enter Service ID']")
	private WebElement ServiceID;

	@FindBy(xpath = "//input[@placeholder='Number Of Days']")
	private WebElement Validity;

	@FindBy(xpath = "//span[text()=\"Technical User\"]")
	private WebElement Technical_User;

	@FindBy(xpath = "//label[text()=\"Service Principal ID\"]")
	private WebElement Technical_User_id;

	@FindBy(xpath = "//mat-select[@role=\"combobox\"]")
	private WebElement Technical_User_id_drpdwn;

	@FindBy(xpath = "//div[text()='ECU Certificate Request']")
	private WebElement ECU_Certifate_request_text;

	@FindBy(xpath = "//mat-select[@placeholder='Please select the COT']")
	private WebElement selectCOT_dropdown;

	@FindBy(xpath = "//div/span[text()='Please select the case']")
	private WebElement Fota_userrole;

	@FindBy(xpath = "//div/span[text()='Please select the required permission']")
	private WebElement Fota_Diag_permission;

	@FindBy(xpath = "//div/span[text()='Please select the required ECU Qualifier']")
	private WebElement Fota_ECU_Qualifier;

	@FindBy(xpath = "//input[@placeholder='Enter Service ID']")
	private WebElement Fota_ServiceID;

	@FindBy(xpath = "//input[@data-placeholder='Year']")
	private WebElement Fota_Year;

	@FindBy(xpath = "//input[@data-placeholder='Month']")
	private WebElement Fota_Month;

	@FindBy(xpath = "//input[@data-placeholder='Days' and @min='0']")
	private WebElement Fota_day;

	@FindBy(xpath = "//input[@data-placeholder='Days' and @min='1']")
	private WebElement Fota_EnhanceCert_validity;

	@FindBy(xpath = "//textarea[@id='reasonSpecialCase']")
	private WebElement Fota_Reason;

	@FindBy(xpath = "//div/span[text()='Please select your role']")
	private WebElement FNrole_dropdown;

	@FindBy(xpath = "//input[@data-placeholder=\"Enter KMS system IP address\"]")
	private WebElement KMS_system_IP_address;
	
	@FindBy(xpath = "//*[text()=' Root Link ']")
	private WebElement RootLinkChkbox;
	
	@FindBy(xpath = "//*[text()=' Root Link Swap ']")
	private WebElement RootLinkSwapChkbox;
	
	@FindBy(xpath = "//*[contains(text(),' Backend Link ')]//parent::div//div[@class='mdc-checkbox']")
	private WebElement BackendChkbox;
	
	@FindBy(xpath = "//*[contains(text(),' Backend Link Swap ')]")
	private WebElement BackendSwapChkbox;
	
	@FindBy(xpath = "(//span[contains(text(),'Please select the root COT')])[1]")
	private WebElement BackendPleaseSelectTheRootCOT;
	
	@FindBy(xpath = "//*[contains(text(),'Backend Origin COT')]")
	private WebElement BackendPleaseSelectTheOriginCOT;
	
	@FindBy(xpath = "//*[contains(text(),'Backend Target COT')]")
	private WebElement BackendPleaseSelectTheTargetCOT;	
	
	@FindBy(xpath = "//input[@formcontrolname='permissionValidityYear']")
	private WebElement PermissionValidityFOTA;	
	
	@FindBy(xpath = "(//input[@id='permission-validityDays'])[last()]")
	private WebElement EnhanceValidityFOTA;	
	
	
	@FindBy(xpath = "//input[@placeholder='Enter ECU Qualifier']")
	private WebElement ecuQualifier;	
	
	@FindBy(xpath = "//mat-radio-button[.=' Service Principal ']")
	private WebElement ServicePrincipalRadioBtn;	
	
	
	public boolean Diagnostic_Authority_display() {
		return Diagnostic_Authority_text.isDisplayed();
	}

	public String select_user_role(String name) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		waitForWebElementToAppear(Userrole_dropdown);
		Userrole_dropdown.isDisplayed();
		click(Userrole_dropdown);
//		moveToElement(Userrole_dropdown);
		String str = clickelementmatchingtext(Userrole_dropdown_option, name);
		return str;

	}

	public String select_functional_role(String name) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Thread.sleep(2000);
		logger.info("**** functional role value :"+name);
		waitForWebElementToAppear(functional_role_dropdown);
		functional_role_dropdown.isDisplayed();		
//		clickJS(functional_role_dropdown);
		functional_role_dropdown.click();
		Thread.sleep(1000);
		String xpathExpression = String.format("//span[text()=' %s ']", name);
		clickJS(driver.findElement(By.xpath(xpathExpression)));
//		return driver.findElement(By.xpath("//div[contains(@class,\"mat-select-value\")]")).getText();
        return name;
	}

	public void reason_field(String txt) {
		try {
			logger.info("reason : "+txt);
			waitForWebElementToAppear(reason_field);
			clickJS(reason_field);
			reason_field.sendKeys(txt);
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			scrollDown(reason_field);
			waitForWebElementToAppear(reason_field);
			clickJS(reason_field);
			reason_field.sendKeys(txt);
		}
	}

	public String get_reason_field_value() {
		return reason_field.getAttribute("value");

	}

	public String get_reason_field_value_NestT() {
		return nest_reason_field1.getAttribute("value");

	}

	public String select_ECU_Restriction(String name) throws InterruptedException {
		scrollDown(ECU_dropdown);
		waitForWebElementToAppear(ECU_dropdown);
		Thread.sleep(2000);
		clickJS(ECU_dropdown);
		Thread.sleep(2000);
	String str = clickelementmatchingtext(ECU_dropdown_option, name);
		return str;
	}

	public String ECU_Restriction_visible_or_not(String name) throws InterruptedException {
		scrollDown(ECU_dropdown);
		waitForWebElementToAppear(ECU_dropdown);
		Thread.sleep(4000);
		ECU_dropdown.click();
		String str = clickelementmatchingtext(ECU_dropdown_option, name);
		return str;
	}

	public String user_role_visible_or_not(String name) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		waitForWebElementToAppear(Userrole_dropdown);
		Userrole_dropdown.isDisplayed();
		clickJS(Userrole_dropdown);
		String str = User_role_visible_or_not(Userrole_dropdown_option, name);
		return str;

	}

	public String replacement_package_ECUQualifier_visible_or_not(String name) throws InterruptedException {
		waitForWebElementToAppear(NestT_ECUQualifier);
		Thread.sleep(500);
		clickJS(NestT_ECUQualifier);
		String str = ECU_visible_or_not(ECU_dropdown_option, name);
		return str;
	}

	public String clickelementmatchingtext(List<WebElement> elements, Object name) throws InterruptedException {
		String usertype1 = null;
		for (int i = 0; i < elements.size(); i++) {
			WebElement txt = elements.get(i);
			Thread.sleep(1000);
			String usertype = txt.getText().trim();
			Thread.sleep(500);
			logger.info("usertype: "+usertype+" *** name : "+name);
			if (usertype.equals(name)) {
				usertype1 = usertype;
				AbstractComponents.waitForWebElementToAppear(txt);
				Thread.sleep(500);
				click(txt);
				break;
			}
		}
		return usertype1;
	}

	public String clickelementmatchingtext(List<WebElement> elements, List<Object> name) throws InterruptedException {
		String usertype1 = null;
		for (int i = 0; i < elements.size(); i++) {
			WebElement txt = elements.get(i);
			String usertype = txt.getText();
			if (usertype.equals(name.toString())) {
				usertype1 = usertype;
				clickJS(txt);
			}
		}
		return usertype1;
	}

	public String ECU_visible_or_not(List<WebElement> elements, String name) throws InterruptedException {
		String usertype1 = null;
		for (int i = 0; i < elements.size(); i++) {
			WebElement txt = elements.get(i);
			String usertype = txt.getText();
			if (!usertype.equals(name)) {
				test.pass("selected ECU is not visible for pending/approved request");
				break;
			} else {
				test.pass("selected ECU is visible for rejected request");
			}
		}
		return usertype1;
	}

	public String User_role_visible_or_not(List<WebElement> elements, String name) throws InterruptedException {
		String usertype1 = null;
		for (int i = 0; i < elements.size(); i++) {
			WebElement txt = elements.get(i);
			String usertype = txt.getText();
			if (!usertype.equals(name)) {
				test.pass(" User role is not visible for pending/approved request");
				break;
			} else {
				test.pass("User role is visible for rejected request");
			}
		}
		return usertype1;
	}

	public void submit_button() {
		waitForWebElementToAppear(submit_button);
//		AbstractComponents.waitForelementToBeClickable(submit_button);
		clickJS(submit_button);
	}

	public boolean Request_Overview_enabled() throws InterruptedException {
		waitForPageLoad(driver);
		waitForWebElementToAppear(Request_Overview);
		Thread.sleep(2000);
		return Request_Overview.isEnabled();

	}

	public void Authorization_roledropdown(String name) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		waitForWebElementToAppear(Authorization_dropdown);
		clickJS(Authorization_dropdown);
		clickelementmatchingtext_value(Authorization_List, name);
	}

	public void clickelementmatchingtext_value(List<WebElement> elements, String User_type) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		for (int i = 0; i < elements.size(); i++) {
			logger.info(elements.get(i).getText());
			if (elements.get(i).getText().equalsIgnoreCase(User_type)) {
				elements.get(i).click();
				break;
			}

		}

	}

	public boolean SpecialCase_display() {
		waitForWebElementToAppear(SpecialCase_text);
		SpecialCase_text.isDisplayed();
		SpecialCase_text.click();
		return SpecialCase_text.isDisplayed();
	}

	public String select_SpecialCase(String name) throws InterruptedException {
		waitForWebElementToAppear(SpecialCase_dropdown);
		Thread.sleep(2000);
		clickJS(SpecialCase_dropdown);
		//SpecialCase_dropdown.click();
		String str = clickelementmatchingtext(ECU_dropdown_option, name);
		return str;
	}

	public String select_NestT_Testingcase(String name) throws InterruptedException {
		Thread.sleep(3000);
		//scrollDown(SpecialCase_NestT_dropdown);
		waitForPageLoad(driver);
		waitForWebElementToAppear(SpecialCase_NestT_dropdown);
		waitForelementToBeClickable(SpecialCase_NestT_dropdown);
		Thread.sleep(4000);
		//clickJS(SpecialCase_NestT_dropdown);
		SpecialCase_NestT_dropdown.click();
		String str = clickelementmatchingtext(ECU_dropdown_option, name);
		return str;
	}
	public String select_DiagPermission(String name) throws InterruptedException {
		Thread.sleep(2000);
		waitForWebElementToAppear(SpecialCase_DiagPermission_dropdown);
		waitForelementToBeClickable(SpecialCase_DiagPermission_dropdown);
		Thread.sleep(1000);
//		clickJS(SpecialCase_DiagPermission_dropdown);
		clickJS(SpecialCase_DiagPermission_dropdown);
		String str = clickelementmatchingtext(ECU_dropdown_option, name);
		return str;
	}
	public String select_ServiceID(String name) throws InterruptedException {
		try {
			waitForWebElementToAppear(Fota_ServiceID);
			click(Fota_ServiceID);
//			scrollDown(nest_reason_field1);
			Fota_ServiceID.sendKeys(name);
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			scrollDown(Fota_ServiceID);
			waitForWebElementToAppear(Fota_ServiceID);
			clickJS(Fota_ServiceID);
//			scrollDown(nest_reason_field1);
			Fota_ServiceID.sendKeys(name);
		}
		return name;
	}
	
	public String select_PermissionValidity(String name) throws InterruptedException {
		try {
			waitForWebElementToAppear(PermissionValidityFOTA);
			doubleClick(PermissionValidityFOTA);
//			scrollDown(nest_reason_field1);
			PermissionValidityFOTA.sendKeys(name);
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			scrollDown(PermissionValidityFOTA);
			waitForWebElementToAppear(PermissionValidityFOTA);
			clickJS(PermissionValidityFOTA);
//			scrollDown(nest_reason_field1);
			PermissionValidityFOTA.sendKeys(name);
		}
		return name;
	}
	
	public String select_EnhanceValidity(String name) throws InterruptedException {
		try {
			waitForWebElementToAppear(EnhanceValidityFOTA);
			doubleClick(EnhanceValidityFOTA);
			EnhanceValidityFOTA.sendKeys(name);
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
//			scrollDown(EnhanceValidityFOTA);
			waitForWebElementToAppear(EnhanceValidityFOTA);
			click(EnhanceValidityFOTA);
			EnhanceValidityFOTA.sendKeys(name);
		}
		return name;
	}
	
	public String select_ECUQualifier_FOTA(String name) throws InterruptedException {
		Thread.sleep(2000);
		waitForWebElementToAppear(FOTA_ECUQualifier);
		clickJS(FOTA_ECUQualifier);
		String str = clickelementmatchingtext(ECU_dropdown_option, name);
		return str;
	}
	

	public String select_ECUQualifier_NestT(String name) throws InterruptedException {
		Thread.sleep(5000);
		waitForPageLoad(driver);
		waitForWebElementToAppear(NestT_ECUQualifier);
		waitForPageLoad(driver);
		waitForWebElementToAppear(NestT_ECUQualifier);
		click(NestT_ECUQualifier);
//		waitForelementToBeClickable(NestT_ECUQualifier);
//		NestT_ECUQualifier.click();
		String str = clickelementmatchingtext(ECU_dropdown_option, name);
		return str;
	}

	public void select_ECUQualifier_Onboard(String name) throws InterruptedException {
		Thread.sleep(2000);
		try {
		waitForWebElementToAppear(ecuQualifier);
		click(ecuQualifier);
		logger.info(name);
        ecuQualifier.sendKeys(name);
		
	}catch(Exception e) {
		scrollDown(ecuQualifier);
		clickJS(ecuQualifier);
		ecuQualifier.sendKeys(name);
	}
	}	

	public void NestT_reason_field(String txt) {
		try {
			waitForWebElementToAppear(nest_reason_field1);
			doubleClick(nest_reason_field1);
//			scrollDown(nest_reason_field1);
			nest_reason_field1.sendKeys(txt);
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			scrollDown(nest_reason_field1);
			waitForWebElementToAppear(nest_reason_field1);
			clickJS(nest_reason_field1);
//			scrollDown(nest_reason_field1);
			nest_reason_field1.sendKeys(txt);
		}
	}
	public void FOTA_reason_field(String txt) {
		try {
			waitForWebElementToAppear(Fota_Reason);
			doubleClick(Fota_Reason);
//			scrollDown(nest_reason_field1);
			Fota_Reason.sendKeys(txt);
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			scrollDown(Fota_Reason);
			waitForWebElementToAppear(Fota_Reason);
			clickJS(Fota_Reason);
//			scrollDown(nest_reason_field1);
			Fota_Reason.sendKeys(txt);
		}
	}
	
	public void replacement_reason_field(String txt) {
		try {
			waitForWebElementToAppear(nest_reason_field1);
			scrollDown(nest_reason_field1);
			logger.info(txt);
			clickJS(nest_reason_field1);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			clickJS(nest_reason_field1);
			nest_reason_field1.sendKeys(txt);
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			scrollDown(ERA_reason_field);
			waitForWebElementToAppear(ERA_reason_field);
			clickJS(ERA_reason_field);
//			scrollDown(nest_reason_field1);
			nest_reason_field1.sendKeys(txt);
		}
	}

	public String getelementmatchingtext(List<WebElement> elements) {
		String txt = null;
		if (elements.size() != 0) {
			for (int i = 0; i < elements.size(); i++) {
				txt = elements.get(i).getText();

			}
		}
		return txt;
	}

	public String select_orginCOT() throws InterruptedException {
		waitForWebElementToAppear(OriginCOT_dropdown);
		click(OriginCOT_dropdown);
		return getelementmatchingtext(ECU_dropdown_option);

	}
	
	public void select_BackEndCOTSelection(String root,String origin,String target) throws InterruptedException {
//		Log.info(root+"\t"+origin+"\t"+target);
		waitForPageLoad(driver);
		Thread.sleep(3000);
		waitForWebElementToAppear(BackendPleaseSelectTheRootCOT);
		click(BackendPleaseSelectTheRootCOT);
		String str = clickelementmatchingtext(ECU_dropdown_option, root);
		Thread.sleep(1000);
		waitForWebElementToAppear(BackendPleaseSelectTheOriginCOT);
		waitForelementToBeClickable(BackendPleaseSelectTheOriginCOT);
		Thread.sleep(1000);
		click(BackendPleaseSelectTheOriginCOT);
		Thread.sleep(1000);
		String str1 = clickelementmatchingtext(ECU_dropdown_option, origin);
		waitForWebElementToAppear(BackendPleaseSelectTheTargetCOT);
		Thread.sleep(1000);
		click(BackendPleaseSelectTheTargetCOT);
		Thread.sleep(500);
		String str2 = clickelementmatchingtext(ECU_dropdown_option, target);
	}

	public String select_origin_COT_type(String name) throws InterruptedException {
		String Str = clickelementmatchingtext(ECU_dropdown_option, name);
		return Str;
	}

	public String select_targetCOT() throws InterruptedException {
		waitForWebElementToAppear(TargetCOT_dropdown);
		isEnabled(TargetCOT_dropdown);
		
		click(TargetCOT_dropdown);
		return getelementmatchingtext(ECU_dropdown_option);

	}

	public void select_target_COT_type(String name) throws InterruptedException {
		String xpathExpression = String.format("//span[contains(text(),'%s')]", name);
		clickJS(driver.findElement(By.xpath(xpathExpression)));

	}

	public boolean EnhanceRight__Authority_display() {
		waitForWebElementToAppear(EnhanceRight_Authority_text);
		EnhanceRight_Authority_text.isDisplayed();
		EnhanceRight_Authority_text.click();
		return EnhanceRight_Authority_text.isDisplayed();
	}

	public List<String> DiagAuth_Certificate_values() throws InterruptedException {
		List<String> actualvalues = new ArrayList<String>();
		Thread.sleep(2000);
		clickJS(ERA_DA_dropdown);
		for (WebElement webElement : Authorization_List) {
			actualvalues.add(webElement.getText());

		}
		return actualvalues;

	}

	public String DiagAuth_Certificate(String cert) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		waitForWebElementToAppear(ERA_DA_dropdown);
		ERA_DA_dropdown.isDisplayed();
		clickJS(ERA_DA_dropdown);
		driver.findElement(By.xpath("//div[@role='listbox']//span[text()=' " + cert + " ']")).click();
		return cert;
	}

	public void ERA_select_ECU_Restriction(String name) throws InterruptedException {
		scrollDown(ECU_dropdown);
		waitForWebElementToAppear(ECU_dropdown);
		Thread.sleep(500);
		clickJS(ECU_dropdown);
		String str = clickelementmatchingtext(ECU_dropdown_option, name);
	}

	public void select_ServiceID_Validity(String serviceID, String validity) throws InterruptedException {
		scrollDown(ServiceID);
		waitForWebElementToAppear(ServiceID);
		clickJS(ServiceID);
		ServiceID.sendKeys(serviceID);
		waitForWebElementToAppear(Validity);
		clickJS(Validity);
		Validity.sendKeys(validity);

	}

	public void ERA_reason_field(String txt) {
		try {
			waitForWebElementToAppear(ERA_reason_field);
			doubleClick(ERA_reason_field);
			reason_field.sendKeys(txt);
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			scrollDown(ERA_reason_field);
			waitForWebElementToAppear(ERA_reason_field);
			clickJS(ERA_reason_field);
			reason_field.sendKeys(txt);
		}
	}

	public void select_technical_user(Object object) throws Throwable {
		waitForWebElementToAppear(Technical_User);
		clickJS(Technical_User);
		waitForWebElementToAppear(Technical_User_id);
		clickJS(Technical_User_id_drpdwn);
		clickelementmatchingtext(Authorization_List, object);

	}

	public boolean ECU_Cerficate_Request() {
		waitForWebElementToAppear(ECU_Certifate_request_text);
		ECU_Certifate_request_text.isDisplayed();
		ECU_Certifate_request_text.click();
		return ECU_Certifate_request_text.isDisplayed();
	}

	public void KMS_System_IP_Address(String name) throws InterruptedException {
		waitForWebElementToAppear(KMS_system_IP_address);
		clickJS(KMS_system_IP_address);
		KMS_system_IP_address.sendKeys(name);
	}

	public void select_COT(String name) throws InterruptedException {
		waitForWebElementToAppear(selectCOT_dropdown);
		click(selectCOT_dropdown);
		Thread.sleep(2000);
		String str = clickelementmatchingtext(ECU_dropdown_option, name);
	}

	public String select_ECUQualifier(String name) throws InterruptedException {
		waitForWebElementToAppear(ecu_dropdown);
		Thread.sleep(1000);
		click(ecu_dropdown);
		logger.info(name);
		String str = clickelementmatchingtext(ECU_dropdown_option, name);
		return str;
	}

	public String select_ECUQualifier_more_than_one(String[] values) throws InterruptedException {
		waitForWebElementToAppear(ecu_dropdown);
		clickJS(ecu_dropdown);
		String str = null;
		for (String string : values) {
			str = clickelementmatchingtext(ECU_dropdown_option, string);
		}

		return str;
	}

	public String grouping_ecu() {
		
		return getText(driver.findElement(By.xpath("//span[@class=\"span2 ng-star-inserted\"]")));
	}

	public void SpecialCase_FOTA(String Special_Case, String Diag_permission, String ECU_Qualifier,
			String Add_ServiceID, String Validity_year, String Validity_month, String Validity_day,
			String Enhance_cert_validity, String reason) throws InterruptedException {
		clickJS(Fota_Diag_permission);
		String space = " ";
		String Diag_perm = space.concat(Diag_permission).concat(space);
		String xpathExpression = String.format("//span[contains(text(),'%s')]", Diag_perm);
		clickJS(driver.findElement(By.xpath(xpathExpression)));
		waitForWebElementToAppear(Fota_ECU_Qualifier);
		Fota_ECU_Qualifier.isDisplayed();
		clickJS(Fota_ECU_Qualifier);
		clickelementmatchingtext(Userrole_dropdown_option, ECU_Qualifier);
		waitForWebElementToAppear(Fota_ServiceID);
		Fota_ServiceID.isDisplayed();
		Fota_ServiceID.sendKeys(Add_ServiceID);
		waitForWebElementToAppear(Fota_Year);
		Fota_Year.isDisplayed();
		Fota_Year.sendKeys(Validity_year);
		waitForWebElementToAppear(Fota_Month);
		Fota_Month.isDisplayed();
		Fota_Month.sendKeys(Validity_month);
		waitForWebElementToAppear(Fota_day);
		Fota_day.isDisplayed();
		Fota_day.sendKeys(Validity_day);
		waitForWebElementToAppear(Fota_EnhanceCert_validity);
		Fota_EnhanceCert_validity.isDisplayed();
		Fota_EnhanceCert_validity.sendKeys(Enhance_cert_validity);
		reason_field_Technical(reason);
		submit_button();
		test.info("FOTA Request is Created");
		logger.info("FOTA Request is Created");
	}

	public void reason_field_Technical(String txt) {
		try {
			waitForWebElementToAppear(ERA_reason_field);
			doubleClick(ERA_reason_field);
			ERA_reason_field1.sendKeys(txt);
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			scrollDown(ERA_reason_field);
			waitForWebElementToAppear(ERA_reason_field);
			clickJS(ERA_reason_field);
			ERA_reason_field1.sendKeys(txt);
		}
	}

	public boolean raise_Diagnostic_Authority_Request(HashMap<String, String> input, Object object, String user_role,
		String ECU_Restriction, String Reason_for_DA) throws Throwable {
		Diagnostic_Authority_display();
		Thread.sleep(3000);

		String value_selected = object.toString();
		logger.info("Value selected : "+value_selected);
//		if (value_selected.contains("ECU Supplier - Key Management")|| value_selected.contains("ECU Supplier – Development")
//				|| value_selected.contains("ECU Supplier - Warranty Return")||value_selected.contains("Vehicle Validation")) {
			select_functional_role(value_selected);
			Thread.sleep(2000);
//		}
		Thread.sleep(200);
		String userrole = select_user_role(user_role);
		test.info("User role is Selected:  " + userrole);
		logger.info("User role is Selected:  " + userrole);
		if (user_role.equalsIgnoreCase("Development ENHANCED") || (user_role.equalsIgnoreCase("Production"))) {
			String ECU = select_ECU_Restriction(ECU_Restriction);
			test.info("ECU Restriction:  " + ECU);
			logger.info("ECU Restriction:  " + ECU);
			reason_field(Reason_for_DA);
			submit_button();
			test.pass("Diagnostic Authority Request is Created");
			logger.info("Diagnostic Authority Request is Created");
		} else {
			reason_field(Reason_for_DA);
			Thread.sleep(1000);
			submit_button();
			test.pass("Diagnostic Authority Request is Created");
			logger.info("Diagnostic Authority Request is Created");
		}
		Thread.sleep(3000);

		return Request_Overview_enabled();
	}

	public List<Object> raise_Enhance_Right_Request(HashMap<String, String> input, String[] cert, Object object,
			String Target_ECU, String Service_ID, String Validity, String Reason_for_ER) throws InterruptedException, AWTException {
		EnhanceRight__Authority_display();
		String value_selected = input.get("Functional_role_internal");
		//String functional_role = null;
//		if (value_selected.contains("ECU Supplier - Key Management")
//				|| value_selected.contains("ECU Supplier - Warranty Return")) {
			String select_functional_role = select_functional_role(value_selected);
			String user_role = input.get("User_role");
			Thread.sleep(2000);
			String ECU_Restriction = input.get("ECU_Restriction");
			Thread.sleep(2000);
			
			//functional_role = select_functional_role.split("-")[2];
			 
			test.pass("functional role selected" + value_selected);
			logger.info("functional role selected" + value_selected);
			Thread.sleep(200);
//		}else if(value_selected.contains("ECU Supplier – Development")) {
//			String select_functional_role = select_functional_role(value_selected);
//			functional_role = select_functional_role.split("-")[1];
//			 
//			test.pass("functional role selected" + value_selected);
//			logger.info("functional role selected" + value_selected);
//			Thread.sleep(200);
//		}
		//hari
//		else if(value_selected.contains("Vehicle Validation")) {
//			String select_functional_role = select_functional_role(value_selected);
//			logger.info("****** select functional role : "+select_functional_role);
//			functional_role=select_functional_role;
//		}
		List<String> diag_cert_values = DiagAuth_Certificate_values();
//		for (String string : cert) {
//			logger.info("*****"+string);
//			logger.info("**** "+diag_cert_values);
//			if (diag_cert_values.contains(string)) {
//				test.pass("value " + cert + "is present in dropdown");
//				logger.info("value " + cert + "is present in dropdown");
//			}
//		}
		DiagAuth_Certificate(cert[0]);
		BaseClass.minimize_window();
		BaseClass.minimize_window();
		String select_ECU_Restriction = select_ECU_Restriction(ECU_Restriction);
		test.pass("ECu selected" + select_ECU_Restriction);
		logger.info("ECu selected" + select_ECU_Restriction);
		BaseClass.maximize_window();
		String serviceId= getRandomServiceId();		

		select_ServiceID_Validity(serviceId,input.get(Validity));
		ERA_reason_field(Reason_for_ER);
		test.pass("User is able to enter serviceID,validity and reason");
		logger.info("User is able to enter serviceID,validity and reason");
		submit_button();
		test.pass("EnhancedRightAuthority Request is Created");
		logger.info("EnhancedRightAuthority Request is Created");
		System.out.println();
		System.out.println(select_ECU_Restriction);
		return Arrays.asList(Request_Overview_enabled(),select_ECU_Restriction);

	}
	public List<Object> raise_Enhance_Right_Request(HashMap<String, String> input) throws InterruptedException, AWTException {
		EnhanceRight__Authority_display();
//		BaseClass.minimize_window();
		String value_selected = input.get("Functional_role_internal");
		//String functional_role = null;
//		if (value_selected.contains("ECU Supplier - Key Management")
//				|| value_selected.contains("ECU Supplier - Warranty Return")) {
//			String select_functional_role = select_functional_role(value_selected);
			String user_roles = input.get("User_role_EA");
			String[] ur= user_roles.split("/");
			Thread.sleep(2000);
			String ECU_Restrictions = input.get("ECU_Restriction_EA");
			String[] ECU= ECU_Restrictions.split("/");
			Thread.sleep(2000);
			
			//functional_role = select_functional_role.split("-")[2];
			 
			test.pass("functional role selected" + value_selected);
			logger.info("functional role selected" + value_selected);
//		}else if(value_selected.contains("ECU Supplier – Development")) {
//			String select_functional_role = select_functional_role(value_selected);
//			functional_role = select_functional_role.split("-")[1];
//			 
//			test.pass("functional role selected" + value_selected);
//			logger.info("functional role selected" + value_selected);
//			Thread.sleep(200);
//		}
		//hari
//		else if(value_selected.contains("Vehicle Validation")) {
//			String select_functional_role = select_functional_role(value_selected);
//			logger.info("****** select functional role : "+select_functional_role);
//			functional_role=select_functional_role;
//		}
			logger.info(Arrays.toString(ECU));
			logger.info(Arrays.toString(ur));
			
			for(int i=0;i<ur.length;i++) {
				Thread.sleep(3000);
				String user_role = ur[i];
				String ECU_Restriction = ECU[i];	
				select_functional_role(value_selected);
				logger.info(user_role);
			
		List<String> diag_cert_values = DiagAuth_Certificate_values();
//		for (String string : cert) {
//			logger.info("*****"+string);
//			logger.info("**** "+diag_cert_values);
//			if (diag_cert_values.contains(string)) {
//				test.pass("value " + cert + "is present in dropdown");
//				logger.info("value " + cert + "is present in dropdown");
//			}
//		}
		DiagAuth_Certificate(user_role);
//		BaseClass.minimize_window();
		
		String select_ECU_Restriction = select_ECU_Restriction(ECU_Restriction);
		test.pass("ECu selected" + select_ECU_Restriction);
		logger.info("ECu selected" + select_ECU_Restriction);
//		BaseClass.maximize_window();
		String serviceId = getRandomServiceId();
		
		select_ServiceID_Validity(serviceId,input.get("Validity"));
		ERA_reason_field(input.get("Reason_for_ER"));
		test.pass("User is able to enter serviceID,validity and reason");
		logger.info("User is able to enter serviceID,validity and reason");
		submit_button();
		
		waitForPageLoad(driver);
		Thread.sleep(3000);
			}
		test.pass("EnhancedRightAuthority Request is Created");
		logger.info("EnhancedRightAuthority Request is Created");
//		System.out.println();
//		System.out.println(select_ECU_Restriction);
		return Arrays.asList(Request_Overview_enabled());

	}
	public List<Object> raise_Enhance_Right_Request_External(HashMap<String, String> input) throws InterruptedException, AWTException {
		EnhanceRight__Authority_display();
		String value_selected = input.get("Functional_role_External");
			String user_roles = input.get("User_role_EA");
			String[] ur= user_roles.split("/");
			Thread.sleep(2000);
			String ECU_Restrictions = input.get("ECU_Restriction_EA");
			String[] ECU= ECU_Restrictions.split("/");
			Thread.sleep(2000);			 
			test.pass("functional role selected" + value_selected);
			logger.info("functional role selected" + value_selected);
			logger.info(Arrays.toString(ECU));
			logger.info(Arrays.toString(ur));			
			for(int i=0;i<ur.length;i++) {
				String user_role = ur[i];
				String ECU_Restriction = ECU[i];	
				select_functional_role(value_selected);
				logger.info(user_role);			
		List<String> diag_cert_values = DiagAuth_Certificate_values();
		DiagAuth_Certificate(user_role);		
		String select_ECU_Restriction = select_ECU_Restriction(ECU_Restriction);
		test.pass("ECU selected" + select_ECU_Restriction);
		logger.info("ECU selected" + select_ECU_Restriction);
		String serviceId= getRandomServiceId();		
		select_ServiceID_Validity(serviceId,input.get("Validity"));
		ERA_reason_field(input.get("Reason_for_ER"));
		test.pass("User is able to enter serviceID,validity and reason");
		logger.info("User is able to enter serviceID,validity and reason");
		submit_button();
			}
		test.pass("EnhancedRightAuthority Request is Created");
		logger.info("EnhancedRightAuthority Request is Created");
		return Arrays.asList(Request_Overview_enabled());

	}

	public List<Object> raise_Enhance_Right_Request_Supplier(HashMap<String, String> input) throws InterruptedException, AWTException {
		EnhanceRight__Authority_display();
		Thread.sleep(2000);
		String value_selected = input.get("Functional_role_Certificate");
			String user_roles = input.get("User_role_EA");
			logger.info(user_roles);
			
			String[] ur= user_roles.split("/");
			Thread.sleep(2000);
			String ECU_Restrictions = input.get("ECU_Restriction_EA");
			logger.info(ECU_Restrictions);
			String[] ECU= ECU_Restrictions.split("/");
			Thread.sleep(2000);
			 
			test.pass("functional role selected" + value_selected);
			logger.info("functional role selected" + value_selected);
			logger.info(Arrays.toString(ECU));
			logger.info(Arrays.toString(ur));
			
			for(int i=0;i<ur.length;i++) {
				String user_role = ur[i];
				String ECU_Restriction = ECU[i];	
				select_functional_role(value_selected);
				logger.info(user_role);
			
		List<String> diag_cert_values = DiagAuth_Certificate_values();
		DiagAuth_Certificate(user_role);
        logger.info(ECU_Restriction);
		
		String select_ECU_Restriction = select_ECU_Restriction(ECU_Restriction);
		test.pass("ECU selected" + select_ECU_Restriction);
		logger.info("ECU selected" + select_ECU_Restriction);

		String serviceId= getRandomServiceId();		

		select_ServiceID_Validity(serviceId,input.get("Validity"));
		ERA_reason_field(input.get("Reason_for_ER"));
		test.pass("User is able to enter serviceID,validity and reason");
		logger.info("User is able to enter serviceID,validity and reason");
		submit_button();
			}
		test.pass("EnhancedRightAuthority Request is Created");
		logger.info("EnhancedRightAuthority Request is Created");
		return Arrays.asList(Request_Overview_enabled());

	}
	
	public List<Object> raise_Enhance_Right_Request_ServicePrincipal(HashMap<String, String> input) throws InterruptedException, AWTException {
		Thread.sleep(2000);
		click(ServicePrincipalRadioBtn);
		Thread.sleep(2000);
		EnhanceRight__Authority_display();
		String value_selected = input.get("Functional_role");
			String user_roles = input.get("User_role_EA");
			String[] ur= user_roles.split("/");
			Thread.sleep(2000);
			String ECU_Restrictions = input.get("ECU_Restriction");
			logger.info(ECU_Restrictions);
			String[] ECU= ECU_Restrictions.split("/");
			Thread.sleep(2000);
			 
			test.pass("functional role selected" + value_selected);
			logger.info("functional role selected" + value_selected);
			logger.info(Arrays.toString(ECU));
			logger.info(Arrays.toString(ur));
			
			for(int i=0;i<ur.length;i++) {
				String user_role = ur[i];
				String ECU_Restriction = ECU[i];	
				select_functional_role(value_selected);
				logger.info(user_role);
			
		List<String> diag_cert_values = DiagAuth_Certificate_values();
		DiagAuth_Certificate(user_role);
        logger.info(ECU_Restriction);
		
		String select_ECU_Restriction = select_ECU_Restriction(ECU_Restriction);
		test.pass("ECU selected" + select_ECU_Restriction);
		logger.info("ECU selected" + select_ECU_Restriction);

		String serviceId= getRandomServiceId();		

		select_ServiceID_Validity(serviceId,input.get("Validity"));
		ERA_reason_field(input.get("Reason_for_ER"));
		test.pass("User is able to enter serviceID,validity and reason");
		logger.info("User is able to enter serviceID,validity and reason");
		submit_button();
			}
		test.pass("EnhancedRightAuthority Request is Created");
		logger.info("EnhancedRightAuthority Request is Created");
		return Arrays.asList(Request_Overview_enabled());

	}


	public boolean raise_replacement_package_Request(String functionalRole,String Special_Case,
			String Orgin_COT, String Reason_for_RP, String Target_COT, String ECU_Qualifier_for_RP,String BackendRoot_COT,String BackendOrigin_COT,String BackendTarget_COT)
			throws InterruptedException, Throwable {
		SpecialCase_display();
		select_functional_role(functionalRole);
		String SpecialCase = select_SpecialCase(Special_Case);
		test.info("SpecialCase:  " + SpecialCase);
		logger.info("SpecialCase:  " + SpecialCase);
		Thread.sleep(3000);	
		scrollDown(RootLinkChkbox);
		RootLinkChkbox.click();
		RootLinkSwapChkbox.click();
		String origin_cot = select_orginCOT();
		Thread.sleep(3000);
		String select_origin_COT_type = select_origin_COT_type(Orgin_COT);
		test.pass("User selected the origin_cot: " + select_origin_COT_type);
		logger.info("User selected the origin_cot: " + select_origin_COT_type);
		Thread.sleep(1000);
		String target_cot = select_targetCOT();
		Thread.sleep(1000);
		select_target_COT_type(Target_COT);
		scrollDown(nest_reason_field1);
		BackendChkbox.click();
		BackendSwapChkbox.click();
		Thread.sleep(2000);
		select_BackEndCOTSelection(BackendRoot_COT,BackendOrigin_COT,BackendTarget_COT);
		String ECU = select_ECUQualifier_NestT(ECU_Qualifier_for_RP);
		test.info("ECUQualifier:  " + ECU);
		replacement_reason_field(Reason_for_RP);
		Thread.sleep(2000);	
		submit_button();
		test.pass("Replacement Package SpecialCase Request is Created");
		logger.info("Replacement Package SpecialCase Request is Created");
		return Request_Overview_enabled();
	}
	
	public boolean raise_Multiple_replacement_package_Request(Map<String,String>input)
			throws InterruptedException, Throwable {		
		String functionalRole=input.get("Functional_role_internal");
		String Special_Case = input.get("SpecialCase");
		String Orgin_COT = input.get("Orgin_COT"); 
		String Target_COT=input.get("Target_COT");
		String BackendRoot_COT=input.get("BackendRoot_COT");
		String BackendOrigin_COT = input.get("BackendOrigin_COT");
		String BackendTarget_COT = input.get("BackendTarget_COT");
		String ECU_Qualifier_for_RP = input.get("ECU_Qualifier_for_RP");
		String Reason_for_RP = input.get("Reason_for_RP");	
		SpecialCase_display();
		select_functional_role(functionalRole);
		String SpecialCase = select_SpecialCase(Special_Case);
		test.info("SpecialCase:  " + SpecialCase);
		logger.info("SpecialCase:  " + SpecialCase);
		String[] ECU = ECU_Qualifier_for_RP.split("/");
		for(int i=0;i<ECU.length;i++) {
			String ECU_Qualifier_Replacement = ECU[i];
		scrollDown(RootLinkChkbox);
		Thread.sleep(5000);
		waitForPageLoad(driver);
		waitForWebElementToAppear(RootLinkChkbox);
		waitForPageLoad(driver);
		waitForWebElementToAppear(RootLinkChkbox);
		Thread.sleep(3000);
		RootLinkChkbox.click();
		RootLinkSwapChkbox.click();
		String origin_cot = select_orginCOT();
		Thread.sleep(2000);
		String select_origin_COT_type = select_origin_COT_type(Orgin_COT);
		test.pass("User selected the origin_cot: " + select_origin_COT_type);
		logger.info("User selected the origin_cot: " + select_origin_COT_type);
		Thread.sleep(2000);
		String target_cot = select_targetCOT();
		Thread.sleep(2000);
		select_target_COT_type(Target_COT);
		scrollDown(nest_reason_field1);
		BackendChkbox.click();
		BackendSwapChkbox.click();
		Thread.sleep(1000);
		select_BackEndCOTSelection(BackendRoot_COT,BackendOrigin_COT,BackendTarget_COT);
		String ECUs = select_ECUQualifier_NestT(ECU_Qualifier_Replacement);
		test.info("ECUQualifier:  " + ECUs);
		replacement_reason_field(Reason_for_RP);
		Thread.sleep(1000);	
		submit_button();
		}
		test.pass("Replacement Package SpecialCase Request is Created");
		logger.info("Replacement Package SpecialCase Request is Created");
		return Request_Overview_enabled();
	}
	public boolean raise_Multiple_replacement_package_Request_Supplier(Map<String,String>input)
			throws InterruptedException, Throwable {		
		String functionalRole=input.get("Functional_role_Certificate");
		String Special_Case = input.get("SpecialCase");
		String Orgin_COT = input.get("Orgin_COT"); 
		String Target_COT=input.get("Target_COT");
		String BackendRoot_COT=input.get("BackendRoot_COT");
		String BackendOrigin_COT = input.get("BackendOrigin_COT");
		String BackendTarget_COT = input.get("BackendTarget_COT");
		String ECU_Qualifier_for_RP = input.get("ECU_Qualifier_for_RP");
		String Reason_for_RP = input.get("Reason_for_RP");	
		SpecialCase_display();
		select_functional_role(functionalRole);
		String SpecialCase = select_SpecialCase(Special_Case);
		test.info("SpecialCase:  " + SpecialCase);
		logger.info("SpecialCase:  " + SpecialCase);
		String[] ECU = ECU_Qualifier_for_RP.split("/");
		for(int i=0;i<ECU.length;i++) {
			String ECU_Qualifier_Replacement = ECU[i];
		scrollDown(RootLinkChkbox);
		Thread.sleep(3000);	
		RootLinkChkbox.click();
		RootLinkSwapChkbox.click();
		String origin_cot = select_orginCOT();
		Thread.sleep(2000);
		String select_origin_COT_type = select_origin_COT_type(Orgin_COT);
		test.pass("User selected the origin_cot: " + select_origin_COT_type);
		logger.info("User selected the origin_cot: " + select_origin_COT_type);
		Thread.sleep(2000);
		String target_cot = select_targetCOT();
		Thread.sleep(2000);
		select_target_COT_type(Target_COT);
		scrollDown(nest_reason_field1);
		BackendChkbox.click();
		BackendSwapChkbox.click();
		Thread.sleep(1000);
		select_BackEndCOTSelection(BackendRoot_COT,BackendOrigin_COT,BackendTarget_COT);
		String ECUs = select_ECUQualifier_NestT(ECU_Qualifier_Replacement);
		test.info("ECUQualifier:  " + ECUs);
		replacement_reason_field(Reason_for_RP);
		Thread.sleep(1000);	
		submit_button();
		}
		test.pass("Replacement Package SpecialCase Request is Created");
		logger.info("Replacement Package SpecialCase Request is Created");
		return Request_Overview_enabled();
	}
	public boolean raise_replacement_package_Request(String functionalRole,String Special_Case,String Reason_for_RP, String ECU_Qualifier_for_RP,String BackendRoot_COT,String BackendOrigin_COT,String BackendTarget_COT)
			throws InterruptedException, Throwable {
		waitForPageLoad(driver);
		SpecialCase_display();
		select_functional_role(functionalRole);
		String SpecialCase = select_SpecialCase(Special_Case);
		test.info("SpecialCase:  " + SpecialCase);
		logger.info("SpecialCase:  " + SpecialCase);
		String[] ECU = ECU_Qualifier_for_RP.split("/");
		for(int i=0;i<ECU.length;i++) {
			String ECU_Qualifier_Replacement = ECU[i];
		Thread.sleep(5000);	
		waitForPageLoad(driver);
		waitForWebElementToAppear(BackendChkbox);
		waitForPageLoad(driver);
		waitForWebElementToAppear(BackendChkbox);
		BackendChkbox.click();
		Thread.sleep(3000);
		select_BackEndCOTSelection(BackendRoot_COT,BackendOrigin_COT,BackendTarget_COT);
		scrollDown(NestT_ECUQualifier);
		String ECUs = select_ECUQualifier_NestT(ECU_Qualifier_Replacement);
		test.info("ECUQualifier:  " + ECUs);
		Thread.sleep(2000);
		
		replacement_reason_field(Reason_for_RP);
		submit_button();
		}
		test.pass("Replacement Package SpecialCase Request is Created");
		logger.info("Replacement Package SpecialCase Request is Created");
		return Request_Overview_enabled();
	}
	public boolean raise_replacement_package_Request(String functionalRole,String Special_Case,
			String Orgin_COT, String Reason_for_RP, String Target_COT, String ECU_Qualifier_for_RP)
			throws InterruptedException, Throwable {
		SpecialCase_display();
		select_functional_role(functionalRole);
		String SpecialCase = select_SpecialCase(Special_Case);	
		test.info("SpecialCase:  " + SpecialCase);
		logger.info("SpecialCase:  " + SpecialCase);
		String[] ECU = ECU_Qualifier_for_RP.split("/");	
		for(int i=0;i<ECU.length;i++) {
			String ECU_Qualifier_Replacement = ECU[i];
		Thread.sleep(5000);
		waitForPageLoad(driver);
		waitForWebElementToAppear(RootLinkChkbox);
		waitForPageLoad(driver);
		waitForelementToBeClickable(RootLinkChkbox);
		Thread.sleep(3000);
		RootLinkChkbox.click();
		String origin_cot = select_orginCOT();
		Thread.sleep(2000);
		String select_origin_COT_type = select_origin_COT_type(Orgin_COT);
		test.pass("User selected the origin_cot: " + select_origin_COT_type);
		logger.info("User selected the origin_cot: " + select_origin_COT_type);
		Thread.sleep(1000);
		String target_cot = select_targetCOT();
		Thread.sleep(2000);
		select_target_COT_type(Target_COT);		
		String ECUs = select_ECUQualifier_NestT(ECU_Qualifier_Replacement);
		test.info("ECUQualifier:  " + ECUs);
		Thread.sleep(2000);
		replacement_reason_field(Reason_for_RP);
		submit_button();
		}
		test.pass("Replacement Package SpecialCase Request is Created");
		logger.info("Replacement Package SpecialCase Request is Created");
		return Request_Overview_enabled();
	}

	public boolean raise_nestT_Request(String SpecialCase_nestT, String NestT_TestingCase, String ECU_Qualifier_nestT,
			String Reason_for_nestT,String value_selected) throws InterruptedException, AWTException {
		SpecialCase_display();
		String[] ECUs = ECU_Qualifier_nestT.split("/");
		String[] NestTTC = NestT_TestingCase.split("/");
		Thread.sleep(2000);
		logger.info(value_selected);
		select_functional_role(value_selected);
		logger.info(value_selected);
		logger.info(SpecialCase_nestT);
		String SpecialCase = select_SpecialCase(SpecialCase_nestT);
		test.info("SpecialCase:  " + SpecialCase);
		logger.info("SpecialCase:  " + SpecialCase);
		for(int i=0;i<ECUs.length;i++) {
			String ECU_Qualifier_nestTs = ECUs[i];
			String TestCase=NestTTC[i];
			Thread.sleep(5000);
		String NestT = select_NestT_Testingcase(TestCase);
		test.info("Nest_T:  " + NestT);
		logger.info("Nest_T:  " + NestT);
		logger.info("ECUQualifier:  " + ECU_Qualifier_nestTs);
		String ECU = select_ECUQualifier_NestT(ECU_Qualifier_nestTs);
		test.info("ECUQualifier:  " + ECU);
		logger.info("ECUQualifier:  " + ECU);
		NestT_reason_field(Reason_for_nestT);
		Thread.sleep(2000);
		submit_button();
		test.pass("NEST_T SpecialCase Request is Created");
		logger.info("NEST_T SpecialCase Request is Created");
		}
		return Request_Overview_enabled();
	}
	public boolean raise_nestT_Request_Multiple(Map<String,String>input) throws InterruptedException, AWTException {
//		SpecialCase_display();
		Thread.sleep(2000);
		//hari
		String Ecu_Qualifier=input.get("ECU_Qualifier_nestT");
		String[] ECU = Ecu_Qualifier.split("/");
		String nestT = input.get("NestT_TestingCase");
		String[] NestTTC = nestT.split("/");
		for(int i=0;(i<ECU.length) ;i++) {
			String ECU_Qualifier_nestT = ECU[i];
			String TestCase=NestTTC[i];
			SpecialCase_display();
		logger.info(input.get("Functional_role_internal"));
		select_functional_role(input.get("Functional_role_internal"));
		String SpecialCase = select_SpecialCase(input.get("SpecialCase_nestT"));
		test.info("SpecialCase:  " + SpecialCase);
		logger.info("SpecialCase:  " + SpecialCase);
		String NestT = select_NestT_Testingcase(TestCase);
		test.info("Nest_T:  " + NestT);
		logger.info("Nest_T:  " + NestT);
		logger.info("ECUQualifier:  " + ECU_Qualifier_nestT);
		if(!TestCase.equalsIgnoreCase("Nest-T Central Authentication")) {
		 select_ECUQualifier_NestT(ECU_Qualifier_nestT);
		test.info("ECUQualifier:  " + ECU_Qualifier_nestT);
		logger.info("ECUQualifier:  " + ECU_Qualifier_nestT);
		}
		NestT_reason_field(input.get("Reason_for_nestT"));
		Thread.sleep(2000);
		submit_button();
		refresh();
		}
		test.pass("NEST_T SpecialCase Request is Created");
		logger.info("NEST_T SpecialCase Request is Created");
		return Request_Overview_enabled();
	}
	public boolean raise_nestT_Request_Supplier_Multiple(Map<String,String>input) throws InterruptedException, AWTException {
//		SpecialCase_display();
		Thread.sleep(2000);
		//hari
		String Ecu_Qualifier=input.get("ECU_Qualifier_nestT");
		String[] ECU = Ecu_Qualifier.split("/");
		String nestT = input.get("NestT_TestingCase");
		String[] NestTTC = nestT.split("/");
		for(int i=0;i<ECU.length;i++) {
			String ECU_Qualifier_nestT = ECU[i];
			String TestCase=NestTTC[i];
			SpecialCase_display();
		logger.info(input.get("Functional_role_Certificate"));
		select_functional_role(input.get("Functional_role_Certificate"));
		String SpecialCase = select_SpecialCase(input.get("SpecialCase_nestT"));
		test.info("SpecialCase:  " + SpecialCase);
		logger.info("SpecialCase:  " + SpecialCase);
		String NestT = select_NestT_Testingcase(TestCase);
		test.info("Nest_T:  " + NestT);
		logger.info("Nest_T:  " + NestT);
		logger.info("ECUQualifier:  " + ECU_Qualifier_nestT);
		if(!TestCase.equalsIgnoreCase("Nest-T Central Authentication")) {
		 select_ECUQualifier_NestT(ECU_Qualifier_nestT);
		test.info("ECUQualifier:  " + ECU_Qualifier_nestT);
		logger.info("ECUQualifier:  " + ECU_Qualifier_nestT);
		}
		NestT_reason_field(input.get("Reason_for_nestT"));
		Thread.sleep(2000);
		submit_button();
		refresh();
		}
		test.pass("NEST_T SpecialCase Request is Created");
		logger.info("NEST_T SpecialCase Request is Created");
		return Request_Overview_enabled();
	}
	public boolean raise_nestT_Request_Central(String SpecialCase_nestT, String NestT_TestingCase, String ECU_Qualifier_nestT,
			String Reason_for_nestT,String value_selected) throws InterruptedException, AWTException {
		SpecialCase_display();
		Thread.sleep(2000);
		//hari
		logger.info(value_selected);
		select_functional_role(value_selected);
		logger.info(value_selected);
		String SpecialCase = select_SpecialCase(SpecialCase_nestT);
		test.info("SpecialCase:  " + SpecialCase);
		logger.info("SpecialCase:  " + SpecialCase);
		String NestT = select_NestT_Testingcase(NestT_TestingCase);
		test.info("Nest_T:  " + NestT);
		logger.info("Nest_T:  " + NestT);
		logger.info("ECUQualifier:  " + ECU_Qualifier_nestT);
//		String ECU = select_ECUQualifier_NestT(ECU_Qualifier_nestT);
//		test.info("ECUQualifier:  " + ECU);
//		logger.info("ECUQualifier:  " + ECU);
		NestT_reason_field(Reason_for_nestT);
		Thread.sleep(2000);
		submit_button();
		test.pass("NEST_T SpecialCase Request is Created");
		logger.info("NEST_T SpecialCase Request is Created");
		return Request_Overview_enabled();
	}
	
	public boolean raise_FOTA_Request_xOTA(String SpecialCaseFOTA, String DiagPermission, String ECU_Qualifier_FOTA,
			String Reason_for_FOTA,String value_selected,String ServiceID,String PermissionValidity,String EnhanceValidity) throws InterruptedException, AWTException {
		
		click(ServicePrincipalRadioBtn);
		Thread.sleep(2000);
//		SpecialCase_display();
//		Thread.sleep(2000);
		BaseClass.minimize_window();
		//hari
		logger.info(value_selected);
		select_functional_role(value_selected);
		logger.info(value_selected);
		String SpecialCase = select_SpecialCase(SpecialCaseFOTA);
		test.info("SpecialCase:  " + SpecialCase);
		logger.info("SpecialCase:  " + SpecialCase);
		String DiagPer = select_DiagPermission(DiagPermission);
		test.info("DiagPermission:  " + DiagPer);
		logger.info("DiagPermission:  " + DiagPer);
		Thread.sleep(500);
		String ECU_FOTA = select_ECUQualifier_FOTA(ECU_Qualifier_FOTA);
		test.info("ECUQualifier:  " + ECU_FOTA);
		logger.info("ECUQualifier:  " + ECU_FOTA);
		Thread.sleep(500);
		FOTA_reason_field(Reason_for_FOTA);
		String ServID = select_ServiceID(ServiceID);
		test.info("ServiceID:  " + ServID);
		logger.info("ServiceID:  " + ServID);
		Thread.sleep(500);
		String PerVal = select_PermissionValidity(PermissionValidity);
		test.info("PermissionValidity:  " + PerVal);
		logger.info("PermissionValidity:  " + PerVal);
		Thread.sleep(500);
		String EnhValidity =select_EnhanceValidity(EnhanceValidity);
		test.info("EnhanceValidity:  " + EnhValidity);
		logger.info("EnhanceValidity:  " + EnhValidity);
//		FOTA_reason_field(Reason_for_FOTA);
		Thread.sleep(2000);
		submit_button();
		test.pass("FOTA SpecialCase Request is Created");
		logger.info("FOTA SpecialCase Request is Created");
		return Request_Overview_enabled();
	}

	public boolean raise_Diagnostic_Authority_Request(HashMap<String, String> input, Object object) throws Throwable {
		Diagnostic_Authority_display();
		Thread.sleep(3000);
		Robot robot = new Robot();
		logger.info("About to zoom out");
		for (int i = 0; i < 3; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
		String value_selected = object.toString();
		if (value_selected.contains("ECU Supplier - Key Management")
				|| value_selected.contains("ECU Supplier – Development")
				|| value_selected.contains("ECU Supplier - Warranty Return")) {
			select_functional_role(value_selected);
			Thread.sleep(200);
		}
		String userrole = select_user_role(input.get("User_role"));
		test.info("User role is Selected:  " + userrole);
		if (userrole.equalsIgnoreCase("Development ENHANCED") || (userrole.equalsIgnoreCase("Production"))) {
			String ECU = select_ECU_Restriction(input.get("ECU_Restriction"));
			test.info("ECU Restriction:  " + ECU);
			reason_field(input.get("Reason_for_DA"));
			submit_button();
			test.pass("Diagnostic Authority Request is Created");
		} else {
			reason_field(input.get("Reason_for_DA"));
			submit_button();
			test.pass("Diagnostic Authority Request is Created");
		}
		Thread.sleep(3000);

		return Request_Overview_enabled();
	}

	public boolean raise_Enhance_Right_Request(HashMap<String, String> input, String[] cert, Object object)
			throws InterruptedException {
		EnhanceRight__Authority_display();
		String value_selected = object.toString();
		if (value_selected.contains("ECU Supplier - Key Management")
				|| value_selected.contains("ECU Supplier – Development")
				|| value_selected.contains("ECU Supplier - Warranty Return")) {
			select_functional_role(value_selected);
		}
		List<String> diag_cert_values = DiagAuth_Certificate_values();
		for (String string : cert) {
			if (diag_cert_values.contains(string)) {
				logger.info("value " + cert + "is present in dropdown");
			}
		}
		DiagAuth_Certificate(cert[0]);
		ERA_select_ECU_Restriction(input.get("Target_ECU"));
		String serviceId= getRandomServiceId();		

		select_ServiceID_Validity(serviceId, input.get("Validity"));
		ERA_reason_field(input.get("Reason_for_ER"));
		submit_button();
		test.pass("EnhancedRightAuthority Request is Created");
		return Request_Overview_enabled();

	}

	public boolean raise_FOTA_request(String Special_Case, String Diag_permission, String ECU_Qualifier,
			String Add_ServiceID, String Validity_year, String Validity_month, String Validity_day,
			String Enhance_cert_validity, String reason) throws Throwable {
		SpecialCase_display();
		String SpecialCase = select_SpecialCase(Special_Case);
		test.info("SpecialCase:  " + SpecialCase);
		logger.info("SpecialCase:  " + SpecialCase);
		Thread.sleep(100);
		BaseClass.minimize_window();
		SpecialCase_FOTA(Special_Case, Diag_permission, ECU_Qualifier, Add_ServiceID, Validity_year, Validity_month,
				Validity_day, Enhance_cert_validity, reason);
		return Request_Overview_enabled();
	}

	public boolean raise_ECU_Certificate_request(HashMap<String, String> input, String fileContent) throws Throwable {
		ECU_Cerficate_Request();
		Thread.sleep(500);
		select_COT(input.get("Select_Cot"));
		Thread.sleep(500);
		String ECU_Qualifier = select_ECUQualifier(fileContent);
		test.info("Selected newly Onboarded ECU" + ECU_Qualifier);
		Thread.sleep(500);
		KMS_System_IP_Address(input.get("kpm"));
		Thread.sleep(500);
		ERA_reason_field(input.get("Reason2"));
		submit_button();
		Thread.sleep(500);
		test.pass("ECU certificate request Request is Created");
		return Request_Overview_enabled();

	}

	public boolean raise_ECU_Certificate_request_for_more_than_one(HashMap<String, String> input, String[] values)
			throws Throwable {
		ECU_Cerficate_Request();
		select_COT(input.get("Select_Cot"));
		String ECU_Qualifier = select_ECUQualifier_more_than_one(values);
		test.info("Selected newly Onboarded ECU" + ECU_Qualifier);
		KMS_System_IP_Address(input.get("kpm"));
		ERA_reason_field(input.get("Reason2"));
		submit_button();
		test.pass("ECU certificate request Request is Created");
		return Request_Overview_enabled();

	}

	public boolean raise_ECU_Certificate_request_for_grouping(HashMap<String, String> input, String[] values)
			throws Throwable {
		ECU_Cerficate_Request();
		Thread.sleep(500);
		select_COT(input.get("Select_Cot"));
		Thread.sleep(500);
		String ECU_Qualifier = select_ECUQualifier_more_than_one(values);
		test.info("Selected newly Onboarded ECU" + ECU_Qualifier);
		clickJS(driver.findElement(By.xpath("//span[@class=\"mat-checkbox-inner-container\"]")));
		String grouping_ecu = grouping_ecu();
		KMS_System_IP_Address(input.get("kpm"));
		ERA_reason_field(input.get("Reason2"));
		submit_button();
		test.pass("ECU certificate request Request is Created");
		return Request_Overview_enabled();

	}
	
	public boolean raise_ECU_Certificate_Request(HashMap<String, String> input) throws Throwable {
		ECU_Cerficate_Request();
		Thread.sleep(500);
		select_functional_role(input.get("Functional_role_supplier"));
		Thread.sleep(1000);
		select_COT(input.get("Select_Cot"));
		Thread.sleep(1000);
		String ECU_Qualifier = select_ECUQualifier(input.get("ECU_Supplier"));
		test.info("Selected newly Onboarded ECU" + ECU_Qualifier);
		Thread.sleep(500);
		KMS_System_IP_Address(input.get("kpm"));
		Thread.sleep(500);
		ERA_reason_field(input.get("Reason2"));
//		submit_button();
		submit_button.click();
		Thread.sleep(500);
		test.pass("ECU certificate request Request is Created");
		return Request_Overview_enabled();

	}


	public boolean Diagnostic_Authority_ECU_Visible_or_not_for_pending_Approved(HashMap<String, String> input,
			Object object, String user_role, String ECU_Restriction) throws Throwable {
		Diagnostic_Authority_display();
		String value_selected = object.toString();
		logger.info("value selected : "+value_selected);
//		if (value_selected.contains("ECU Supplier - Key Management")
//				|| value_selected.contains("ECU Supplier – Development")
//				|| value_selected.contains("ECU Supplier - Warranty Return")) {
		//hari
		if (value_selected.contains("ECU Supplier - Key Management")
				|| value_selected.contains("ECU Supplier – Development")
				|| value_selected.contains("ECU Supplier - Warranty Return")||value_selected.contains("Vehicle Validation")) {
			select_functional_role(value_selected);
		}

		if (user_role.equalsIgnoreCase("Development ENHANCED") || (user_role.equalsIgnoreCase("Production"))) {
			String userrole = select_user_role(user_role);
			test.info("User role is Selected:  " + userrole);
			String ecu_Restriction_visible_or_not = ECU_Restriction_visible_or_not(ECU_Restriction);
			test.pass("selcted ECU is not visible" + ecu_Restriction_visible_or_not);
		} else {
			String userrole1 = user_role_visible_or_not(user_role);
			test.pass("User role is not visible:  " + userrole1);
		}

		return Request_Overview_enabled();
	}

	public boolean replacement_package_ECU_Visible_or_not_for_pending_approved_rejected(HashMap<String, String> input,
			String Special_Case, String Orgin_COT, String Reason_for_RP, String Target_COT, String ECU_Qualifier_for_RP,String BackendRoot_COT,String BackendOrigin_COT,String BackendTarget_COT)
			throws InterruptedException, Throwable {
		SpecialCase_display();
		
		select_functional_role(input.get("Functional_role_internal"));
		Thread.sleep(2000);
		
		String SpecialCase = select_SpecialCase(Special_Case);
		test.info("SpecialCase:  " + SpecialCase);
		logger.info("SpecialCase:  " + SpecialCase);
		Thread.sleep(1000);
		
		RootLinkChkbox.click();
		RootLinkSwapChkbox.click();
		String origin_cot = select_orginCOT();
		Thread.sleep(3000);

		String select_origin_COT_type = select_origin_COT_type(Orgin_COT);
		test.pass("User selected the origin_cot: " + select_origin_COT_type);
		logger.info("User selected the origin_cot: " + select_origin_COT_type);
		Thread.sleep(1000);
		NestT_reason_field(Reason_for_RP);
		Thread.sleep(1000);
		String target_cot = select_targetCOT();
		Thread.sleep(1000);

		select_target_COT_type(Target_COT);
		
		BackendChkbox.click();
		BackendSwapChkbox.click();
		
		select_BackEndCOTSelection(BackendRoot_COT,BackendOrigin_COT,BackendTarget_COT);
		
		String ECU = replacement_package_ECUQualifier_visible_or_not(ECU_Qualifier_for_RP);
		test.info("ECUQualifier:  " + ECU);
		logger.info("ECUQualifier:  " + ECU);
		return Request_Overview_enabled();
	}
	public boolean Diagnostic_Authority_ECU_Visible_or_not_for_pending_Approved(HashMap<String, String> input) throws Throwable {		
//		Diagnostic_Authority_display();
		String value_selected = input.get("Functional_role_internal");
		Thread.sleep(500);
		String user_roles = input.get("User_role_DA");
		String[] ur=user_roles.split("/");
		Thread.sleep(500);
		String ECU_Restrictions = input.get("ECU_Restriction_DA");
		String [] ECU = ECU_Restrictions.split("/");
		Thread.sleep(500);
		logger.info("value selected : "+value_selected);
		logger.info(Arrays.toString(ECU));
		logger.info(Arrays.toString(ur)); 

		//hari
		for(int i=0;i<ur.length;i++) {
			String user_role=ur[i];
			Thread.sleep(1000);
			String ECU_Restriction=ECU[i];
			Thread.sleep(5000);
			select_functional_role(value_selected);
			logger.info(user_role);
		if (user_role.equalsIgnoreCase("Development ENHANCED") || (user_role.equalsIgnoreCase("Production")) || (user_role.equalsIgnoreCase("After-Sales ENHANCED")) || user_role.equalsIgnoreCase("Development - ATG")) {
			Thread.sleep(2000);
			String userrole = select_user_role(user_role);
			test.info("User role is Selected:  " + userrole);
			String ecu_Restriction_visible_or_not = ECU_Restriction_visible_or_not(ECU_Restriction);
			test.pass("selcted ECU is not visible" + ecu_Restriction_visible_or_not);
			logger.info("selcted ECU is " + ecu_Restriction_visible_or_not);

		} 
		
		else {
			String userrole = select_user_role(user_role);
			test.info("User role is Selected:  " + userrole);
		}
		Thread.sleep(500);
		
		reason_field(input.get("Reason_for_DA"));
        Thread.sleep(2000);
		click(submit_button);
		}

		return Request_Overview_enabled();
	}
	public boolean Diagnostic_Authority_External_Created(HashMap<String, String> input) throws Throwable {		
		//Diagnostic_Authority_display();
		String value_selected = input.get("Functional_role_External");
		Thread.sleep(500);
		String user_roles = input.get("User_role_DA");
		String[] ur=user_roles.split("/");
		Thread.sleep(500);
		String ECU_Restrictions = input.get("ECU_Restriction_DA");
		String [] ECU = ECU_Restrictions.split("/");
		Thread.sleep(500);
		logger.info("value selected : "+value_selected);
//		if (value_selected.contains("ECU Supplier - Key Management")
//				|| value_selected.contains("ECU Supplier – Development")
//				|| value_selected.contains("ECU Supplier - Warranty Return")) {
		logger.info(Arrays.toString(ECU));
		logger.info(Arrays.toString(ur));

		//hari
		for(int i=0;i<ur.length;i++) {
			String user_role=ur[i];
			Thread.sleep(1000);
			String ECU_Restriction=ECU[i];
			select_functional_role(value_selected);
			logger.info(user_role);
		if (user_role.equalsIgnoreCase("Development ENHANCED") || (user_role.equalsIgnoreCase("Production"))) {
			Thread.sleep(2000);
			String userrole = select_user_role(user_role);
			test.info("User role is Selected:  " + userrole);
			String ecu_Restriction_visible_or_not = ECU_Restriction_visible_or_not(ECU_Restriction);
			test.pass("selcted ECU is not visible" + ecu_Restriction_visible_or_not);
			logger.info("selcted ECU is " + ecu_Restriction_visible_or_not);

		} 
		
		else {
			String userrole = select_user_role(user_role);
			test.info("User role is Selected:  " + userrole);
		}
		Thread.sleep(3000);
		
		reason_field(input.get("Reason_for_DA"));
        Thread.sleep(3000);
		click(submit_button);
		}

		return Request_Overview_enabled();
	}
	public boolean Diagnostic_Authority_Supplier_Created(HashMap<String, String> input) throws Throwable {		
		//Diagnostic_Authority_display();
		String value_selected = input.get("Functional_role_Certificate");
		
		String user_roles = input.get("User_role_DA");
		String[] ur=user_roles.split("/");
		Thread.sleep(2000);
		String ECU_Restrictions = input.get("ECU_Restriction_DA");
		String [] ECU = ECU_Restrictions.split("/");
		Thread.sleep(2000);
		logger.info("value selected : "+value_selected);
//		if (value_selected.contains("ECU Supplier - Key Management")
//				|| value_selected.contains("ECU Supplier – Development")
//				|| value_selected.contains("ECU Supplier - Warranty Return")) {
		logger.info(Arrays.toString(ECU));
		logger.info(Arrays.toString(ur));

		//hari
		for(int i=0;((i<ur.length && i<ECU.length));i++) {
			String user_role=ur[i];
			String ECU_Restriction=ECU[i];
			Thread.sleep(3000);
			waitForPageLoad(driver);
			
			select_functional_role(value_selected);
			logger.info(user_role);
		if (user_role.equalsIgnoreCase("Development ENHANCED") || (user_role.equalsIgnoreCase("Production"))||user_role.equalsIgnoreCase("After-Sales ENHANCED")) {
			Thread.sleep(2000);
			String userrole = select_user_role(user_role);
			test.info("User role is Selected:  " + userrole);
			String ecu_Restriction_visible_or_not = ECU_Restriction_visible_or_not(ECU_Restriction);
			test.pass("selcted ECU is not visible" + ecu_Restriction_visible_or_not);
			logger.info("selcted ECU is " + ecu_Restriction_visible_or_not);

		} 
		
		else {
			String userrole = select_user_role(user_role);
			test.info("User role is Selected:  " + userrole);
		}
		Thread.sleep(3000);
		
		reason_field(input.get("Reason_for_DA"));
        Thread.sleep(3000);
		click(submit_button);
		}

		return Request_Overview_enabled();
	}
	
	public boolean Diagnostic_Authority_ServicePrincipal_Created(HashMap<String, String> input) throws Throwable {		
		//Diagnostic_Authority_display();
		Thread.sleep(2000);
		waitForWebElementToAppear(ServicePrincipalRadioBtn);
		Thread.sleep(2000);
		click(ServicePrincipalRadioBtn);
		Thread.sleep(2000);
		String value_selected = input.get("Functional_role");
		String user_roles = input.get("User_role");
		String[] ur=user_roles.split("/");
		Thread.sleep(2000);
		String ECU_Restrictions = input.get("ECU_Restriction");
		String [] ECU = ECU_Restrictions.split("-");
		Thread.sleep(2000);
		logger.info("value selected : "+value_selected);
//		if (value_selected.contains("ECU Supplier - Key Management")
//				|| value_selected.contains("ECU Supplier – Development")
//				|| value_selected.contains("ECU Supplier - Warranty Return")) {
		logger.info(Arrays.toString(ECU));
		logger.info(Arrays.toString(ur));

		//hari
		for(int i=0;i<ur.length;i++) {
			String user_role=ur[i];
			String ECU_Restriction=ECU[i];
			select_functional_role(value_selected);
			logger.info(user_role);
		if (user_role.equalsIgnoreCase("Development ENHANCED") || (user_role.equalsIgnoreCase("Production"))) {
			Thread.sleep(2000);
			String userrole = select_user_role(user_role);
			test.info("User role is Selected:  " + userrole);
			String ecu_Restriction_visible_or_not = ECU_Restriction_visible_or_not(ECU_Restriction);
			test.pass("selcted ECU is not visible" + ecu_Restriction_visible_or_not);
			logger.info("selcted ECU is " + ecu_Restriction_visible_or_not);

		} 
		
		else {
			String userrole = select_user_role(user_role);
			test.info("User role is Selected:  " + userrole);
		}
		Thread.sleep(3000);
		
		reason_field(input.get("Reason_for_DA"));
        Thread.sleep(3000);
		click(submit_button);
		}

		return Request_Overview_enabled();
	}


}
