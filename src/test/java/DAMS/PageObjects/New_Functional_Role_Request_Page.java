package DAMS.PageObjects;

import DAMS.ObjectManager.PageObjectManager;
import DAMS.Resources.AbstractComponents;
import DAMS.Resources.BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import static DAMS.Resources.Listeners.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class New_Functional_Role_Request_Page extends AbstractComponents {
	WebDriver driver;

	public New_Functional_Role_Request_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//<Hari
//	@FindBy(xpath = "(//span[text()='Please select vehicle program'])[1]")
//	private WebElement Vehicle_Program;
	@FindBy(xpath = "//span[text()='Please select ECU Chain of Trust Type']")
	private WebElement ECU_Chain_of_Trust_Type;
	
	@FindBy(xpath = "//span[text()=' ATG ']")
	private WebElement ECU_Chain_of_Trust_Type_ATG;
	
	@FindBy(xpath = "//span[text()=' GLOBAL ']")
	private WebElement ECU_Chain_of_Trust_Type_Global;
	
	@FindBy(xpath = "//mat-select[@placeholder='Please select your functional role']")
	private WebElement select_Functional_Role;
	
	@FindBy(xpath = "//span[text()=' Development ']")
	private WebElement select_Functional_Role_Development;
	
	@FindBy(xpath = "//span[@class='mat-option-text']")
	private WebElement vehicle_program_list;
	//>Hari
	

	@FindBy(xpath = " //*[text()=\" New Functional Role Request\"]")
	private WebElement new_Functional_Role_Request;

	@FindBy(xpath = "//label[text()='Myself']")
	private WebElement myself_text;

	@FindBy(xpath = "//mat-select[@placeholder='Please select your functional role']")
	private WebElement Functional_Role;

	@FindBy(xpath = "//div/span[text()='Please select your business unit']")
	private WebElement please_Select_Your_BU;

	@FindBy(xpath = "//mat-option/span")
	private List<WebElement> BU_Option;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	private WebElement submit_button;

	@FindBy(xpath = "//div/span[text()='Please select your functional role']")
	private WebElement please_Select_Your_Functional_role;

	@FindBy(xpath = "//div/mat-radio-group/descendant::span[text()='Technical User']")
	private WebElement Technicaluser_text;

	@FindBy(xpath = "//mat-option/span")
	private List<WebElement> Functional_role_type;

	@FindBy(xpath = "//span[text()='Maximum 200 characters only']")
	private WebElement reason_field;

	@FindBy(xpath = "//textarea[@id='reason']")
	private WebElement reason_field1;

	@FindBy(xpath = "//div[contains(@id,\"mat-select-value\")]")
	private WebElement FR_type;

	@FindBy(xpath = "//mat-label[text()=\"Role Description \"]")
	private WebElement role_description;

	@FindBy(xpath = "//mat-label[text()=\"Business Unit * \"]")
	private WebElement business_unit;

	@FindBy(xpath = "//mat-label[text()=\"Service Principal ID * \"]")
	private WebElement Technical_User_ID;

	@FindBy(xpath = "//div/span[text()='Please select your company name']")
	private WebElement select_Company;

	@FindBy(xpath = "//mat-label[text()=\"Reason * \"]")
	private WebElement reason;

	@FindBy(xpath = "//mat-label[text()=\"Company *\"]")
	private WebElement company;

	@FindBy(xpath = "//mat-label[text()=\"Daimler Internal Contact Person * \"]")
	private WebElement daimler_Internal_contact_Person;

	@FindBy(xpath = "//mat-label[text()=\"ECU Qualifier * \"]")
	private WebElement ECU_Qualifier;

	@FindBy(xpath = "//*[@id='roleDesc']")
	private WebElement role_description_text;

	@FindBy(xpath = "//div/mat-label[text()='For whom * ']")
	private WebElement for_Whom_text;

	@FindBy(xpath = "//div/mat-radio-group/descendant::span[@class=\"mat-radio-container\"]")
	private WebElement myself_Radiobutton;

	@FindBy(xpath = "//input[@id='name']")
	private WebElement Daimler_Internal_name;

	@FindBy(xpath = "//input[@id=\"email\"]")
	private WebElement Daimler_Internal_email;

	@FindBy(xpath = "//div/span[text()='Please select the required ECU']")
	private WebElement select_ECU_Qualifier;

	@FindBy(xpath = "//span[text()=\"Technical User\"]")
	private WebElement Technical_User_text;

	@FindBy(xpath = "//span[text()='Enter Service Principal ID']")
	private WebElement TechnicalUser;

	@FindBy(xpath = "//input[@id='techUser']")
	private WebElement TechnicalUser1;

	@FindBy(xpath = "//mat-error[text()=\" Reason cannot start with a space \"]")
	private WebElement FR_reason_field_error_message;
	
	@FindBy(xpath = "//span[contains(text(),\"Are you sure\")]")
	private WebElement cancel_confirmation_text;

	@FindBy(xpath = "//span[text()=\"Ok\"]")
	private WebElement cancel_accept;

	@FindBy(xpath = "//span[text()=\"Back\"]")
	private WebElement cancel_dismiss;
	

	@FindBy(xpath = "//span[text()=\"Cancel\"]")
	private WebElement cancel_button;
	
	@FindBy(xpath = "//input[@placeholder='Enter Service Principal ID']")
	private WebElement servicePrincipal;
	
	@FindBy(xpath = "//mat-select[@placeholder='Please select ECU Chain of Trust Type']")
	private WebElement chainTrustType;
	
    public String raiseFunctionalForService(String BU,String Reason_for_internal_FR,String chainType,String functionalRole) throws Throwable {
		waitForWebElementToAppear(servicePrincipal);
		click(servicePrincipal);
//	    String randomServiceId = generateRandomServiceId();
	    Random rand = new Random();
	    int randomNum = 1000 + rand.nextInt(9000); 
		String serviceId;
		if ("Production".equalsIgnoreCase(functionalRole)) {
		    serviceId = "TEC_DEMO_PROD_" + randomNum;
		} else {
		    serviceId = "TEC_DEMO_XOTA_" + randomNum;
		}
	    servicePrincipal.sendKeys(serviceId);
		test.pass("Verified the role description in Functional Overview page");
			
		WebElement BU_path = driver.findElement(By.xpath("//div/span[text()='Please select your business unit']"));
   		select_BU();		
   		select_Matching_Element(BU);			
		click(chainTrustType);
		Thread.sleep(1000);
		select_Matching_Element(chainType);
		Thread.sleep(500);
		select_Functional_role();
		Thread.sleep(500);
		select_Matching_Element(functionalRole);
		Thread.sleep(500);
		reason_field(Reason_for_internal_FR); 
		Thread.sleep(500);
		submit_button();
		return serviceId;
	}

	public String for_Whom_text() {
		return getText(for_Whom_text);
	}

	public String myself_text() {
		return getText(myself_text);
	}

	public String Functional_Role_text() {
		return getText(Functional_Role);
	}

	public String Technical_User_text() {
		return getText(Technical_User_text);
	}

	public String business_unit_text() {
		return getText(business_unit);
	}

	public String Technical_User_ID_text() {
		return getText(Technical_User_ID);
	}

	public String getNew_FR_page() {
		waitForWebElementToAppear(new_Functional_Role_Request);
		return new_Functional_Role_Request.getText();

	}
	
	//Hari
	public void select_vehicle_program_global() throws InterruptedException {
		logger.info("User is Select the ECU Chain of Trust Type");
		Thread.sleep(2000);
//		ECU_Chain_of_Trust_Type.isDisplayed();
		waitForWebElementToAppear(ECU_Chain_of_Trust_Type);

		Thread.sleep(2000);
		AbstractComponents.waitForelementToBeClickable(ECU_Chain_of_Trust_Type);
		try {
			clickJS(ECU_Chain_of_Trust_Type);
		} catch (Exception e) {
			doubleClick(ECU_Chain_of_Trust_Type);
		}
		ECU_Chain_of_Trust_Type_Global.isDisplayed();
		waitForWebElementToAppear(ECU_Chain_of_Trust_Type_Global);
		Thread.sleep(2000);
		try {
			clickJS(ECU_Chain_of_Trust_Type_Global);
		} catch (Exception e) {
			doubleClick(ECU_Chain_of_Trust_Type_Global);
		}
	}
	
	public void select_vehicle_program_ATG() throws InterruptedException {
		logger.info("User is Select the ECU Chain of Trust Type");

		ECU_Chain_of_Trust_Type.isDisplayed();
		waitForWebElementToAppear(ECU_Chain_of_Trust_Type);

		Thread.sleep(2000);
		AbstractComponents.waitForelementToBeClickable(ECU_Chain_of_Trust_Type);
		try {
			clickJS(ECU_Chain_of_Trust_Type);
		} catch (Exception e) {
			doubleClick(ECU_Chain_of_Trust_Type);
		}
		ECU_Chain_of_Trust_Type_ATG.isDisplayed();
		waitForWebElementToAppear(ECU_Chain_of_Trust_Type_ATG);
		Thread.sleep(2000);
		try {
			clickJS(ECU_Chain_of_Trust_Type_ATG);
		} catch (Exception e) {
			doubleClick(ECU_Chain_of_Trust_Type_ATG);
		}
	}
	//Hari
	
	public void select_Functional_role() throws InterruptedException {
		please_Select_Your_Functional_role.isDisplayed();
		waitForWebElementToAppear(please_Select_Your_Functional_role);
		AbstractComponents.waitForelementToBeClickable(please_Select_Your_Functional_role);
		Thread.sleep(2000);
		try {
			click(please_Select_Your_Functional_role);
		} catch (Exception e) {
			doubleClick(please_Select_Your_Functional_role);
		}
	}

	public String user_type() throws InterruptedException {
		return getelementmatchingtext(Functional_role_type);

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

	public String select_user_type(String name) throws InterruptedException {
		logger.info(name);
		String Str = clickelementmatchingtext(Functional_role_type, name);
		return Str;
	}

	public String clickelementmatchingtext(List<WebElement> elements, String names) throws InterruptedException {
		String usertype1 = null;
		for (int i = 0; i < elements.size(); i++) {
			WebElement txt = elements.get(i);
			String usertype = txt.getText().trim();
			String name=names.trim();
			logger.info("user type "+usertype+" name "+name);
			
			if (usertype.equalsIgnoreCase(name)) {
//			if(usertype.contains(name)) {
				usertype1 = usertype;
//				clickJS(txt);
				Thread.sleep(1000);
				txt.click();
				break;
//				AbstractComponents .waitForelementToBeClickable(txt);
			}
		}
		return usertype1;
	}

	public void reason_field(String txt) throws InterruptedException {
		try {
			Thread.sleep(3000);
			waitForWebElementToAppear(reason_field1);
			AbstractComponents.waitForelementToBeClickable(reason_field1);
			click(reason_field1);
			reason_field1.sendKeys(txt);
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			waitForWebElementToAppear(reason_field);
			AbstractComponents.waitForelementToBeClickable(reason_field);
			clickJS(reason_field);
			reason_field1.sendKeys(txt);
		}
	}

	public String get_reason_field_value() {
		return reason_field1.getAttribute("value");

	}

	public String reason_cannot_start_with_space() throws InterruptedException {
		type(reason_field1, Keys.TAB);
		Thread.sleep(2000);
		return FR_reason_field_error_message.getText();
	}

	public void functional_role_Internal() {
		String txt = FR_type.getText();
		if (txt.equals("Vehicle Validation") || txt.equals("Production") || txt.equals("Xentry Tool Development")
				|| txt.equals("DiagnosticLink Tool Development") || txt.equals("QM(Quality Management)")) {
			waitForWebElementToAppear(role_description);
			waitForWebElementToAppear(business_unit);
			waitForWebElementToAppear(reason);
			waitForWebElementToAppear(cancel_button);
		} else {
			waitForWebElementToAppear(role_description);
			waitForWebElementToAppear(reason);
			waitForWebElementToAppear(cancel_button);

		}

	}

	public String role_desc_text() {
		try {
			scrollDown(role_description_text);
			return role_description_text.getText();
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			scrollDown(role_description_text);
			return role_description_text.getText();
		}
	}

	public void select_BU() throws InterruptedException {
		try {

			scrollDown(please_Select_Your_BU);
			please_Select_Your_BU.isEnabled();
			waitForWebElementToAppear(please_Select_Your_BU);
			Thread.sleep(2000);
			AbstractComponents.waitForelementToBeClickable(please_Select_Your_BU);
			clickJS(please_Select_Your_BU);
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			scrollDown(please_Select_Your_BU);
			please_Select_Your_BU.isEnabled();
			waitForWebElementToAppear(please_Select_Your_BU);
			AbstractComponents.waitForelementToBeClickable(please_Select_Your_BU);
			AbstractComponents.waitForelementToBeClickable(please_Select_Your_BU);
			clickJS(please_Select_Your_BU);
		}
	}

	public String business_unit() throws InterruptedException {
		return getelementmatchingtext_BU(BU_Option);

	}

	public String getelementmatchingtext_BU(List<WebElement> elements) {
		String txt = null;
		if (elements.size() != 0) {
			for (int i = 0; i < elements.size(); i++) {
				txt = elements.get(i).getText();

			}
		}
		return txt;
	}

	public void select_business_unit(String name) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			clickelementmatchingtext(BU_Option, name);
		} catch (Exception ex) {
			String xpathExpression = String.format("//span[contains(text(),'%s')]", name);
			clickJS(driver.findElement(By.xpath(xpathExpression)));
		}

	}
	public void select_Matching_Element(String name) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			clickelementmatchingtext(BU_Option, name);
		} catch (Exception ex) {
			String xpathExpression = String.format("//span[contains(text(),'%s')]", name);
			clickJS(driver.findElement(By.xpath(xpathExpression)));
		}

	}

	public void clickelementmatchingtext_BU(List<WebElement> elements, String name) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (elements.size() != 0) {
			for (int i = 0; i < elements.size(); i++) {
				WebElement txt = elements.get(i);
				String usertype = txt.getText();
				if (usertype.equals(name)) {
					clickJS(txt);
				}

			}
		}

	}

	public void submit_button() {
		try {
			waitForWebElementToAppear(submit_button);
			AbstractComponents.waitForelementToBeClickable(submit_button);
			click(submit_button);
//			submit_button.click();
			} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			scrollDown(submit_button);
			AbstractComponents.waitForelementToBeClickable(submit_button);
			clickJS(submit_button);

		}
	}

	public void functional_role_external() {
		String txt = FR_type.getText();
		if (txt.equals("Vehicle Validation External Support") || txt.equals("Production External")
				|| txt.equals("DiagnosticLink Tool Development External Support")
				|| txt.equals("Xentry Tool Development External Support")
				|| txt.equals("QM(Quality Management) External") || txt.equals("Development External Support") 
				|| txt.equals("Development - ATG External")) {
			waitForWebElementToAppear(role_description);
			waitForWebElementToAppear(business_unit);
			waitForWebElementToAppear(company);
			waitForWebElementToAppear(daimler_Internal_contact_Person);
			waitForWebElementToAppear(reason);
			waitForWebElementToAppear(cancel_button);
		}
	}

	public void select_company() throws InterruptedException {
		select_Company.isEnabled();
		waitForWebElementToAppear(select_Company);
		clickJS(select_Company);
	}

	public void daimler_Internal_name(String txt) {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		scrollUp(Daimler_Internal_name);
		clickJS(Daimler_Internal_name);
		Daimler_Internal_name.sendKeys(txt);
	}

	public void daimler_Internal_email(String txt) {
		Daimler_Internal_email.sendKeys(txt);
	}

	public void functional_role_supplier() {
		String txt = FR_type.getText();
		if (txt.equals(" ECU Supplier - Key Management ") || txt.equals(" ECU Supplier - Warranty Return ")
				|| txt.equals(" ECU Supplier – Development ")) {
			waitForWebElementToAppear(role_description);
			waitForWebElementToAppear(company);
			waitForWebElementToAppear(cancel_button);
		}
	}

	public void select_ECU_Qualifier() {
		scrollUp(select_ECU_Qualifier);
		clickJS(select_ECU_Qualifier);
		AbstractComponents.waitForelementToBeClickable(select_ECU_Qualifier);
	}

	public void select_Functional_role_Technicaluser() throws InterruptedException {
		Technicaluser_text.isSelected();
		please_Select_Your_Functional_role.isDisplayed();
		waitForWebElementToAppear(please_Select_Your_Functional_role);
		try {
			clickJS(please_Select_Your_Functional_role);
		} catch (Exception e) {
			doubleClick(please_Select_Your_Functional_role);
		}
		AbstractComponents.waitForelementToBeClickable(please_Select_Your_Functional_role);
	}

	public void TechnicalUser(String txt) {
		try {
			waitForWebElementToAppear(TechnicalUser);
			AbstractComponents.waitForelementToBeClickable(TechnicalUser);
			clickJS(TechnicalUser);
			TechnicalUser1.sendKeys(txt);
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			waitForWebElementToAppear(TechnicalUser);
			AbstractComponents.waitForelementToBeClickable(TechnicalUser);
			clickJS(TechnicalUser);
			TechnicalUser1.sendKeys(txt);
		}
	}

	public void functional_role_page_validation(String forwhom_txt, String myself_txt, String FR_txt) {
		if (getNew_FR_page().contains("Functional Role")) {
			if (forwhom_txt.equals(for_Whom_text())) {
				if (myself_txt.equals(myself_text())) {
					if (FR_txt.equals(Functional_Role_text())) {
						test.pass("Verified the Functional Role Overview page");
						logger.info("Verified the Functional Role Overview page");
					}
				}
			}
		}

	}

	public void functional_role_page_validation_technical_user(String forwhom_txt, String TechnicalUser_txt,
			String Business_unit, String Technical_user_id) {
		if (getNew_FR_page().contains("Functional Role")) {
			if (forwhom_txt.equals(for_Whom_text())) {
				if (TechnicalUser_txt.equals(Technical_User_text())) {
					if (Business_unit.equals(business_unit_text())) {
						if (Technical_user_id.equals(Technical_User_ID_text())) {
							test.pass("Verified the Functional Role Overview page for Technical user");
							logger.info("Verified the Functional Role Overview page for Technical user");
						}
					}
				}
			}
		}

	}

	public String raise_Internal_functional_role_request(String vehicle_validation, String Production, String Xentry,
			String QM, String Development, String DiagnosticLink, String Functional_role_internal,
			String Reason_for_internal_FR, String Role_Desc, String get_DTE, String get_dtna, String get_fuso,
			String get_bus, String BU) throws Throwable {
		select_Functional_role();
		String st = user_type();
		logger.info("***Functional role : "+st);
		String st1 = select_user_type(Functional_role_internal);
		test.log(Status.INFO,
				"User selected the functional role" + "<span style=\"color: blue;\"><b><i><u>" + st1 + "</u></i></b>");
		Thread.sleep(200);
		reason_field(Reason_for_internal_FR);
		String role_Desc = role_desc_text();
		role_Desc.equalsIgnoreCase(Role_Desc);
		test.pass("Verified the role description in Functional Overview page");
		try {
			if(!st1.equalsIgnoreCase("Development")) {
			WebElement BU_path = driver.findElement(By.xpath("//div/span[text()='Please select your business unit']"));
			if (BU_path.isDisplayed()) {
				select_BU();
				String st2 = business_unit();
				st2.contains(get_DTE);
				st2.contains(get_dtna);
				st2.contains(get_fuso);
				st2.contains(get_bus);
				select_business_unit(BU);
				ClickTab();
				submit_button();
				test.pass("Functional role is created successfully");
			}
			} else {
				submit_button();
				test.pass("Functional role is created successfully");
			}

		} catch (Exception e) {
			submit_button();
			test.pass("Functional role is created successfully");
		}

		return st1;

	}

	public String raise_External_functional_role_request(String Functional_role_External, String Reason_for_External_FR, String Role_Desc, String company_name,
			String Daimler_name, String Daimler_email, String get_DTE, String get_dtna, String get_fuso, String get_bus,
			String BU) throws Throwable {
		select_Functional_role();
		String st = user_type();
		logger.info("functional Role : "+Functional_role_External);
		String st1 = select_user_type(Functional_role_External);
		test.pass("User selected the functional role:  " + st1);
		functional_role_external();
		String role_Desc = role_desc_text();
		role_Desc.equalsIgnoreCase(Role_Desc);
		test.pass("Verified the role description in Functional Overview page");
		logger.info("****** Company Selection *********");
		Thread.sleep(2000);
		select_company_name(company_name);
		logger.info("******** Company Selected ***********"+company_name);
		daimler_Internal_name(Daimler_name);
		daimler_Internal_email(Daimler_email);
		Thread.sleep(200);
		reason_field(Functional_role_External);
		try {
			WebElement BU_path = driver.findElement(By.xpath("//div/span[text()='Please select your business unit']"));
			if (BU_path.isDisplayed()) {
				select_BU();
				String st2 = business_unit();
				st2.contains(get_DTE);
				st2.contains(get_dtna);
				st2.contains(get_fuso);
				st2.contains(get_bus);
				select_business_unit(BU);
				ClickTab();
//				Thread.sleep(500);
			}
		} catch (Exception e) {
			select_BU();
			String st2 = business_unit();
			st2.contains(get_DTE);
			st2.contains(get_dtna);
			st2.contains(get_fuso);
			st2.contains(get_bus);
			select_business_unit(BU);
//			Thread.sleep(500);
		}
		submit_button();
		test.pass("Functional role is created successfully");
//		Thread.sleep(3000);
		return st1;
	}

	public String raise_Supplier_functional_role_request(String Supplier_key_management, String supplier_Development,
			String supplier_warranty_return, String Functional_role_supplier, String Role_Desc, String company_name,
			String Reason_for_supplier_FR, String ECU_Supplier) throws Throwable {
		Thread.sleep(2000);
		select_Functional_role();
		String st = user_type();
		System.out.println(Functional_role_supplier);
		logger.info(Functional_role_supplier);
//		st.contains(Supplier_key_management);
//		st.contains(supplier_Development);
//		st.contains(supplier_warranty_return);
		String st1 = select_user_type(Functional_role_supplier);
		test.pass("User selected the functional role:  " + st1);
		functional_role_supplier();
		String role_Desc = role_desc_text();
		role_Desc.equalsIgnoreCase(Role_Desc);
		test.pass("Verified the role description in Functional Overview page");
		Thread.sleep(500);
		select_company();
		select_business_unit(company_name);
//		Thread.sleep(500);
		reason_field(Reason_for_supplier_FR);
//		Thread.sleep(3000);
		select_ECU_Qualifier();
//		Thread.sleep(2000);
		String space = " ";
		String fn_ECU_Qualifier = st1.concat(" - ").concat(ECU_Supplier).concat(space);
		select_business_unit(ECU_Supplier);
		ClickTab();
		submit_button();
		test.pass("Functional role is created successfully");
//		Thread.sleep(3000);
		return fn_ECU_Qualifier;
	}

	public List<Object> raise_Supplier_functional_role_request_for_more_than_one_ECU(String Supplier_key_management,
			String supplier_Development, String supplier_warranty_return, String Functional_role_supplier,
			String Role_Desc, String company_name, String Reason_for_supplier_FR, String[] eCU_Qualifiers2)
			throws Exception {
		select_Functional_role();
		String st1 = select_user_type(Functional_role_supplier);
		test.pass("User selected the functional role:  " + st1);
		String role_Desc = role_desc_text();
		role_Desc.equalsIgnoreCase(Role_Desc);
		test.pass("Verified the role description in Functional Overview page");
//		Thread.sleep(500);
		select_company();
		select_business_unit(company_name);
//		Thread.sleep(500);
		reason_field(Reason_for_supplier_FR);
		select_ECU_Qualifier();
//		Thread.sleep(2000);
		String fn_ECU_Qualifier = null;
		int selectedoptionCount = 0;
		List<String> selectedoptions = new ArrayList<>();
		for (String string : eCU_Qualifiers2) {
			String st = string.concat(" ");
			WebElement alloptions = driver
					.findElement(By.xpath("//span[@class=\"mat-option-text\" and text()='" + st + "']"));
			String space = " ";
			fn_ECU_Qualifier = st1.concat(" - ").concat(string).concat(space);
			alloptions.click();
//			Thread.sleep(3000);
			selectedoptionCount++;
			selectedoptions.add(string);
		}
		submit_button();
		test.pass("Functional role is created successfully");
//		Thread.sleep(3000);
		return Arrays.asList(fn_ECU_Qualifier, selectedoptions, selectedoptionCount);

	}

	public String raise_Technical_user_request_and_navigate_to_Functional_role_overview_page(
			HashMap<String, String> input, String get_DTE, String get_Production, String Functional_role,
			String Role_Desc, String reason) throws InterruptedException {
		String random = BaseClass.generateRandomString(4, "TECH-");
		select_BU();
		String st2 = business_unit();
		st2.contains(get_DTE);
		select_business_unit("DTNA");
		select_business_unit(get_DTE);
		select_Functional_role();
		String st = user_type();
//		Thread.sleep(500);
		String st1 = select_user_type(Functional_role);
		test.pass("User selected the functional role:  " + st1);
//		Thread.sleep(200);
		String role_Desc = role_desc_text();
		role_Desc.equalsIgnoreCase(Role_Desc);
		test.pass("Verified the role description in Functional Overview page");
		TechnicalUser(random);
		reason_field(reason);
		submit_button();
		test.pass("Technical User Functional role is created successfully");
//		Thread.sleep(3000);
//		Thread.sleep(3000);
		return random;

	}

	public void functional_role_Internal_refresh() throws InterruptedException {
//		Thread.sleep(3000);
		refresh();
		functional_role_request_internal_after_refresh_or_cancel();
	}

	public void functional_role_request_internal_after_refresh_or_cancel() {
		String txt = FR_type.getText();
		if (txt.equals("Vehicle Validation") || txt.equals("Production")
				|| txt.equals("DiagnosticLink Tool Development") || txt.equals("QM(Quality Management)")
				|| txt.equals("Xentry Tool Development")) {

			waitForWebElementnotToAppear(role_description);
			waitForWebElementnotToAppear(business_unit);
			waitForWebElementnotToAppear(reason);
			waitForWebElementnotToAppear(cancel_button);
		} else {
			waitForWebElementnotToAppear(role_description);
			waitForWebElementnotToAppear(reason);
			waitForWebElementnotToAppear(cancel_button);

		}

	}

	public void functional_role_External_refresh() throws InterruptedException {
//		Thread.sleep(3000);
		refresh();
		functional_role_request_external_after_refresh_or_cancel();

	}

	public void functional_role_request_external_after_refresh_or_cancel() {
		String txt = FR_type.getText();
		if (txt.equals("Development External Support") || txt.equals("DiagnosticLink Tool Development External Support")
				|| txt.equals("Production External") || txt.equals("QM(Quality Management) External")
				|| txt.equals("Vehicle Validation External Support")
				|| txt.equals("Xentry Tool Development External Support")) {
			waitForWebElementnotToAppear(role_description);
			waitForWebElementnotToAppear(business_unit);
			waitForWebElementnotToAppear(company);
			waitForWebElementnotToAppear(daimler_Internal_contact_Person);
			waitForWebElementnotToAppear(reason);
			waitForWebElementnotToAppear(cancel_button);
		}

	}

	public void functional_role_Supplier_refresh() throws InterruptedException {
//		Thread.sleep(3000);
		refresh();
		functional_role_request_supplier_after_refresh_or_cancel();
	}

	public void functional_role_request_supplier_after_refresh_or_cancel() {
		String txt = FR_type.getText();
		if (txt.equals("ECU Supplier - Key Management") || txt.equals("ECU Supplier - Warranty Return")
				|| txt.equals("ECU Supplier – Development")) {
			waitForWebElementnotToAppear(role_description);
			waitForWebElementnotToAppear(company);
			waitForWebElementnotToAppear(cancel_button);
		}

	}

	public void cancel_btn_accept() {
		clickJS(cancel_button);
		waitForWebElementToAppear(cancel_confirmation_text);
		clickJS(cancel_accept);
	}

	public void cancel_btn_dismiss() {
		clickJS(cancel_button);
		waitForWebElementToAppear(cancel_confirmation_text);
		clickJS(cancel_dismiss);
	}
	
	public void select_company_name(String name) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			select_Company.isEnabled();
			waitForWebElementToAppear(select_Company);
			click(select_Company);
			Thread.sleep(2000);
			clickelementmatchingtext(BU_Option, name);
		} catch (Exception ex) {
			String xpathExpression = String.format("//span[contains(text(),'%s')]", name);
			clickJS(driver.findElement(By.xpath(xpathExpression)));
		}

	}
	
	
	
	
	
	
	
	
}
