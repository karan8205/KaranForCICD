package DAMS.PageObjects;

import static DAMS.Resources.Listeners.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DAMS.ObjectManager.PageObjectManager;
import DAMS.Resources.AbstractComponents;
import DAMS.Resources.BaseClass;

public class Onboard_new_ECU_page extends AbstractComponents {
	WebDriver driver;

	public Onboard_new_ECU_page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[text()=\"Onboard New ECU\"]")
	private WebElement Onboard_New_ECU;

	@FindBy(xpath = "//*[text()=\"For whom * \"]")
	private WebElement Onboard_For_whom;

	@FindBy(xpath = "//*[text()=\"Myself\"]")
	private WebElement Onboard_Myself;

	@FindBy(xpath = "//span[@class=\"mat-radio-outer-circle\"]")
	private WebElement Onboard_Myself_radiobutton;

	@FindBy(xpath = "//*[text()=\"Are you the ECU Owner?\"]")
	private WebElement Onboard_Are_you_the_ECU_Owner;

	@FindBy(xpath = "//span[@class='mat-checkbox-inner-container']")
	private WebElement Onboard_Are_you_the_ECU_Owner_checkbox;

	@FindBy(xpath = "//*[text()=\"ECU Qualifier * \"]")
	private WebElement onboard_ECU_Qualifier;

	@FindBy(xpath = "//*[text()=\"ECU Owner * \"]")
	private WebElement onboard_ECU_Owner;

	@FindBy(xpath = "//*[text()=\"ECU Supplier Name * \"]")
	private WebElement onboard_ECU_Supplier_Name;

	@FindBy(xpath = "//*[text()=\"Status GTC Acceptance * \"]")
	private WebElement onboard_Status_GTC_Acceptance;

	@FindBy(xpath = "//*[text()=\"ECU Owner Deputy* \"]")
	private WebElement onboard_ECU_Owner_Deputy;

	@FindBy(xpath = "//*[text()=\"Supplier Responsible * \"]")
	private WebElement onboard_Supplier_Responsible;

	@FindBy(xpath = "//*[text()=\"CS Architect Component Name * \"]")
	private WebElement onboard_CS_Architect_Component_Name;

	@FindBy(xpath = "//span[text()=\"Submit\"]")
	private WebElement onboard_Submit;

	@FindBy(xpath = "//span[text()=\"Review\"]")
	private WebElement onboard_review;

	@FindBy(xpath = "//div[@role=\"alertdialog\"]")
	private WebElement onboard_alertdialog;

	@FindBy(xpath = "//span[text()=\"Cancel\"]")
	private WebElement onboard_cancel;

	@FindBy(xpath = "//input[@placeholder='Enter ECU Qualifier']")
	private WebElement onboard_Enter_ECU_Qualifier;

	@FindBy(xpath = "//Input[@data-placeholder=\"Enter the ShortId\"]")
	private WebElement onboard_Enter_ECU_shortID;

	@FindBy(xpath = "//input[@aria-invalid=\"false\"]")
	private WebElement onboard_Enter_ECU_shortID_disabled;

	@FindBy(xpath = "//input[@id=\"supplier_name\"]")
	private WebElement onboard_Enter_supplier_name;

	@FindBy(xpath = "//app-ecu-onboard/mat-card/mat-card/div/form/div[1]/div[5]/mat-form-field/div/div[1]/div/mat-select/div/div[1]/span")
	private WebElement onboard_GTC;

	@FindBy(xpath = "//div[@role='listbox']//span")
	private List<WebElement> ECU_dropdown_option;

	@FindBy(xpath = "//input[@id='EcuOwnerDeputyName']")
	private WebElement onboard_ECUOwnerdeputy;

	@FindBy(xpath = "//input[@id='supplier_responsible']")
	private WebElement onboard_ECUsupplier;

	@FindBy(xpath = "//input[@id='architect_name']")
	private WebElement onboard_CSarchitect;

	@FindBy(xpath = "//mat-checkbox[@formcontrolname=\"isEcuOwner\"]/label/span")
	private WebElement are_you_ECU_Owner_Checkbox;
	
	@FindBy(xpath = "//mat-select[@placeholder ='Please select GTC acceptance']")
	private WebElement Please_select_GTC_acceptance;
	
	@FindBy(xpath = "//span[text()='Review']")
	private WebElement Onboard_ReviewBtn;
	
	
	//mat-select[@placeholder ='Please select GTC acceptance']
	
	public void onBoardECUEnabled() {
		waitForWebElementToAppear(Onboard_New_ECU);
		click(Onboard_New_ECU);
	}

	public void verify_onboardECU_field() throws InterruptedException {
//		waitForWebElementToAppear(Onboard_New_ECU);
//		waitForWebElementToAppear(Onboard_For_whom);
//		waitForWebElementToAppear(Onboard_Myself);
//		waitForWebElementToAppear(Onboard_Myself_radiobutton);
//		waitForWebElementToAppear(Onboard_Are_you_the_ECU_Owner);
//		waitForWebElementToAppear(Onboard_Are_you_the_ECU_Owner_checkbox);
//		waitForWebElementToAppear(onboard_ECU_Qualifier);
//		waitForWebElementToAppear(onboard_ECU_Owner);
//		waitForWebElementToAppear(onboard_ECU_Supplier_Name);
//		waitForWebElementToAppear(onboard_Status_GTC_Acceptance);
//		waitForWebElementToAppear(onboard_ECU_Owner_Deputy);
//		waitForWebElementToAppear(onboard_Supplier_Responsible);
//		waitForWebElementToAppear(onboard_CS_Architect_Component_Name);
//		waitForWebElementToAppear(onboard_Submit);
//		waitForWebElementToAppear(onboard_cancel);

		Onboard_Myself_radiobutton.isSelected();

//		if (!Onboard_Are_you_the_ECU_Owner_checkbox.isSelected()) {
//			if (!onboard_Submit.isEnabled()) {
				click(Onboard_Are_you_the_ECU_Owner_checkbox);
//				onboard_Enter_ECU_Qualifier.isDisplayed();
//				waitForWebElementToAppear(onboard_Enter_ECU_Qualifier);
//			}
//		}
	}

	public void onboard_Status_GTC_Acceptance_Select(String string) throws Throwable {
		click(Please_select_GTC_acceptance);
		Thread.sleep(1000);
		logger.info(string);
		clickelementmatchingtext(ECU_dropdown_option, string);

		
	}
	
	public String Enter_ECU_Qualifier_onboardECU(String name) throws InterruptedException {
		waitForWebElementToAppear(onboard_Enter_ECU_Qualifier);
		clickJS(onboard_Enter_ECU_Qualifier);
		onboard_Enter_ECU_Qualifier.sendKeys(name);
		return onboard_Enter_ECU_Qualifier.getText();
	}
	
	public String Enter_ECU_Qualifier_onboardECU_more_than_one(String[] eCU_Qualifiers2) throws InterruptedException {
		waitForWebElementToAppear(onboard_Enter_ECU_Qualifier);
		clickJS(onboard_Enter_ECU_Qualifier);
		for (String string : eCU_Qualifiers2) {
			onboard_Enter_ECU_Qualifier.sendKeys(string);
			type(onboard_Enter_ECU_Qualifier, Keys.ENTER);
		}
		
		return onboard_Enter_ECU_Qualifier.getText();
	}

	public void Enter_ECU_shortID_onboardECU(String name) throws InterruptedException {
		waitForWebElementToAppear(onboard_Enter_ECU_shortID);
		clickJS(onboard_Enter_ECU_shortID);
		onboard_Enter_ECU_shortID.sendKeys(name);
	}

	public void Enter_supplier_name_onboardECU(String name) throws InterruptedException {
		waitForWebElementToAppear(onboard_Enter_supplier_name);
		clickJS(onboard_Enter_supplier_name);
		onboard_Enter_supplier_name.sendKeys(name);
	}

	public void select_GTC_onboardECU(String name) throws InterruptedException {
		waitForWebElementToAppear(onboard_GTC);
		clickJS(onboard_GTC);
		clickelementmatchingtext(ECU_dropdown_option, name);
	}

	public void enter_ECUOwnerDeputy(String name) throws InterruptedException {
		waitForWebElementToAppear(onboard_ECUOwnerdeputy);
		clickJS(onboard_ECUOwnerdeputy);
		onboard_ECUOwnerdeputy.sendKeys(name);
	}

	public void enter_SupplierResponse(String name) throws InterruptedException {
		waitForWebElementToAppear(onboard_ECUsupplier);
		clickJS(onboard_ECUsupplier);
		onboard_ECUsupplier.sendKeys(name);
	}

	public void enter_CSArchitect(String name) throws InterruptedException {
		waitForWebElementToAppear(onboard_CSarchitect);
		clickJS(onboard_CSarchitect);
		onboard_CSarchitect.sendKeys(name);
	}

	public String clickelementmatchingtext(List<WebElement> elements, String name) throws InterruptedException {
		String usertype1 = null;
		for (int i = 0; i < elements.size(); i++) {
			WebElement txt = elements.get(i);
			String usertype = txt.getText().trim();
			 name = name.trim();
			if (usertype.equals(name)) {
				usertype1 = usertype;
				clickJS(txt);
			}
		}
		return usertype1;
	}

	public void submit_button() {
		waitForWebElementToAppear(onboard_Submit);
		if (onboard_Submit.isEnabled()) {
			clickJS(onboard_Submit);
		}
	}

	public void onboard_review() {
		waitForWebElementToAppear(onboard_review);
		if (onboard_review.isEnabled()) {
			clickJS(onboard_review);
		}
		waitForWebElementnotToAppear(onboard_review);
	}

	public boolean is_review_button_enabled() {
		waitForWebElementToAppear(onboard_review);
		return onboard_review.isEnabled();
	}

	public void alertdialog(String approval_status) {
		if (approval_status.equals("APPROVED") || approval_status.equals("PENDING")) {
			waitForWebElementToAppear(onboard_alertdialog);
		} else {
			waitForWebElementToAppear(onboard_alertdialog);
		}

	}

	public void alertdialog() {
		waitForWebElementToAppear(onboard_alertdialog);

	}

	public void click_checkbox_Are_you_ECu_owner() {
		waitForWebElementToAppear(are_you_ECU_Owner_Checkbox);
		clickJS(Onboard_Are_you_the_ECU_Owner);

	}

	public String are_you_ECU_Owner_Checkbox_not_selected(String ECU_Owner, String supplier_name, String gtc,
			String deputy_owner, String supplier_responsible, String CS_ArchitectName, String ECU_Qualifier)
			throws Throwable {
		
		//
		onBoardECUEnabled();
		//
		String enter_ECU_Qualifier_onboardECU = null;
		if (!are_you_ECU_Owner_Checkbox.isSelected()) {
			verify_onboardECU_field();
			enter_ECU_Qualifier_onboardECU = Enter_ECU_Qualifier_onboardECU(ECU_Qualifier);
			Enter_ECU_shortID_onboardECU(ECU_Owner);
			Enter_supplier_name_onboardECU(supplier_name);
			select_GTC_onboardECU(gtc);
			enter_ECUOwnerDeputy(deputy_owner);
			enter_SupplierResponse(supplier_responsible);
			enter_CSArchitect(CS_ArchitectName);
			submit_button();
		}
		return enter_ECU_Qualifier_onboardECU;
	}
	
	
	public void Onboard_ECU_Pending_Request(HashMap<String,String>input) throws Throwable {
		
		onBoardECUEnabled();
		Onboard_Myself_radiobutton.isSelected();
		 String value_selected = input.get("Functional_role_internal");
		 newper.select_functional_role(value_selected);
	     onboard_Status_GTC_Acceptance_Select(input.get("GTC"));
	     Random rand = new Random();
	     int randomNum = 100 + rand.nextInt(900);
	     String randomECUQualifier = "AWB" + randomNum + "T";
	     newper.select_ECUQualifier_Onboard(randomECUQualifier);		   
//		 newper.select_ECUQualifier_Onboard(input.get("ECU_Qualifier_nestT"));
		 waitForWebElementToAppear(Onboard_Are_you_the_ECU_Owner_checkbox);
		 waitForelementToBeClickable(Onboard_Are_you_the_ECU_Owner_checkbox);
		 Thread.sleep(2000);
		 clickJS(Onboard_Are_you_the_ECU_Owner_checkbox);
//		verify_onboardECU_field();
		Enter_supplier_name_onboardECU(input.get("ECU_SupplierName"));
		enter_ECUOwnerDeputy(input.get("ECU_OwnerDeputy"));
		enter_SupplierResponse(input.get("Supplier_Responsible"));
		enter_CSArchitect(input.get("CS_ArchitectName"));
		submit_button();
		clickJS(Onboard_ReviewBtn);
	}
	
	
	public String are_you_ECU_Owner_Checkbox_not_selected_more_than_one(String ECU_Owner, String supplier_name, String gtc,
			String deputy_owner, String supplier_responsible, String CS_ArchitectName, String[] eCU_Qualifiers2)
			throws Throwable {
		String enter_ECU_Qualifier_onboardECU = null;
		if (!are_you_ECU_Owner_Checkbox.isSelected()) {
			verify_onboardECU_field();
			enter_ECU_Qualifier_onboardECU = Enter_ECU_Qualifier_onboardECU_more_than_one(eCU_Qualifiers2);
			Enter_ECU_shortID_onboardECU(ECU_Owner);
			Enter_supplier_name_onboardECU(supplier_name);
			select_GTC_onboardECU(gtc);
			enter_ECUOwnerDeputy(deputy_owner);
			enter_SupplierResponse(supplier_responsible);
			enter_CSArchitect(CS_ArchitectName);
			submit_button();
		}
		return enter_ECU_Qualifier_onboardECU;
	}

	public void are_you_ECU_Owner_Checkbox_selected(String ECU_Owner, String supplier_name, String gtc,
			String deputy_owner, String supplier_responsible, String CS_ArchitectName, String ECU_Qualifier)
			throws Throwable {
		click_checkbox_Are_you_ECu_owner();
		verify_onboardECU_field();
		Enter_ECU_Qualifier_onboardECU(ECU_Qualifier);
		Enter_supplier_name_onboardECU(supplier_name);
		select_GTC_onboardECU(gtc);
		enter_ECUOwnerDeputy(deputy_owner);
		enter_SupplierResponse(supplier_responsible);
		enter_CSArchitect(CS_ArchitectName);
		submit_button();

	}
	
	public void are_you_ECU_Owner_Checkbox_selected_for_more_than_one(String ECU_Owner, String supplier_name, String gtc,
			String deputy_owner, String supplier_responsible, String CS_ArchitectName, String[] eCU_Qualifiers2)
			throws Throwable {
		click_checkbox_Are_you_ECu_owner();
		verify_onboardECU_field();
		Enter_ECU_Qualifier_onboardECU_more_than_one(eCU_Qualifiers2);
		Enter_supplier_name_onboardECU(supplier_name);
		select_GTC_onboardECU(gtc);
		enter_ECUOwnerDeputy(deputy_owner);
		enter_SupplierResponse(supplier_responsible);
		enter_CSArchitect(CS_ArchitectName);
		submit_button();

	}

	public String review_button_in_onboard_new_Page_for_OWN_ECU(HashMap<String, String> input, String ECU_Owner,
			String ECU_SupplierName, String GTC, String ECU_OwnerDeputy, String Supplier_Responsible,
			String CS_ArchitectName) throws Throwable {
		String random = BaseClass.generateRandomString(4,"API-");
		are_you_ECU_Owner_Checkbox_selected(ECU_Owner, ECU_SupplierName, GTC, ECU_OwnerDeputy, Supplier_Responsible,
				CS_ArchitectName, random);
		onboard_review();
		return random;

	}
	
	public String[] review_button_in_onboard_new_Page_for_OWN_ECU_for_more_than_one_ECU(HashMap<String, String> input, String ECU_Owner,
			String ECU_SupplierName, String GTC, String ECU_OwnerDeputy, String Supplier_Responsible,
			String CS_ArchitectName, String[] eCU_Qualifiers2) throws Throwable {
		are_you_ECU_Owner_Checkbox_selected_for_more_than_one(ECU_Owner, ECU_SupplierName, GTC, ECU_OwnerDeputy, Supplier_Responsible,
				CS_ArchitectName, eCU_Qualifiers2);
		onboard_review();
		return eCU_Qualifiers2;

	}
	
	public String create_Onboard_new_ECU_checkbox_not_selected(HashMap<String, String> input) throws Throwable {
		String random =BaseClass.generateRandomString(4,"ECU-");
		are_you_ECU_Owner_Checkbox_not_selected(input.get("ECU_Owner"), input.get("ECU_SupplierName"),
				input.get("GTC"), input.get("ECU_OwnerDeputy"), input.get("Supplier_Responsible"),
				input.get("CS_ArchitectName"), random);
		return random;

	}
	
	public String[] create_Onboard_new_ECU_checkbox_not_selected_more_than_one(HashMap<String, String> input, String[] eCU_Qualifiers2) throws Throwable {
		are_you_ECU_Owner_Checkbox_not_selected_more_than_one(input.get("ECU_Owner"), input.get("ECU_SupplierName"),
				input.get("GTC"), input.get("ECU_OwnerDeputy"), input.get("Supplier_Responsible"),
				input.get("CS_ArchitectName"), eCU_Qualifiers2);
		return eCU_Qualifiers2;

	}
	
	public String review_button_in_request_Overview_Page_for_OWN_ECU(HashMap<String, String> input)
			throws Throwable {
		String random = BaseClass.generateRandomString(4,"ECU-");
		are_you_ECU_Owner_Checkbox_selected(input.get("ECU_Owner"), input.get("ECU_SupplierName"),
				input.get("GTC"), input.get("ECU_OwnerDeputy"), input.get("Supplier_Responsible"),
				input.get("CS_ArchitectName"), random);
		return  random;

	}
	
	public String[] review_button_in_request_Overview_Page_for_more_than_one_OWN_ECU(HashMap<String, String> input, String[] eCU_Qualifiers2)
			throws Throwable {
		are_you_ECU_Owner_Checkbox_selected_for_more_than_one(input.get("ECU_Owner"), input.get("ECU_SupplierName"),
				input.get("GTC"), input.get("ECU_OwnerDeputy"), input.get("Supplier_Responsible"),
				input.get("CS_ArchitectName"), eCU_Qualifiers2);
		return  eCU_Qualifiers2;

	}

}
