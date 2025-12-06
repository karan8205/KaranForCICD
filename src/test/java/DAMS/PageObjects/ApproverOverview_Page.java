package DAMS.PageObjects;

import DAMS.ObjectManager.PageObjectManager;
import DAMS.Resources.AbstractComponents;
import DAMS.Resources.BaseClass;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static DAMS.Resources.Listeners.test;

public class ApproverOverview_Page extends AbstractComponents {
	WebDriver driver;
	public static Logger logger = Logger.getLogger("DAMS");
	String approval_date_txt;
	String approval_status;

	public ApproverOverview_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//mat-grid-tile-header[text()=\" Approver Overview\"]")
	private WebElement approver_Overview_title;

	@FindBy(xpath = "//label[text()=\"Approver\"]")
	private WebElement approver_txt;

	@FindBy(xpath = "//label[text()=\"Approver\"]/parent::div/p")
	private WebElement approver_info_txt;

	@FindBy(xpath = "//label[text()=\"Authorization\"]")
	private WebElement authorization_txt;

	@FindBy(xpath = "//span[text()=\"Functional Role\"]")
	private WebElement functional_role_option;

	@FindBy(xpath = "//label[text()=\"Applicant Type\"]")
	private WebElement applicant_type;

	@FindBy(xpath = "//span[text()=\"Technical User \"]")
	private WebElement Technical_User_type;

	@FindBy(xpath = "//span[text()=\"Internal \"]")
	private WebElement internal_type;

	@FindBy(xpath = "//span[text()=\"External \"]")
	private WebElement external_type;

	@FindBy(xpath = "//span[text()=\"Supplier \"]")
	private WebElement supplier_type;

	@FindBy(xpath = "//span[text()=\"Change view:\"]")
	private WebElement change_view_txt;

	@FindBy(xpath = "//span[text()=\"Condensed\"]")
	private WebElement condensed_btn;

	@FindBy(xpath = "//span[text()=\"Reset Filters\"]")
	private WebElement reset_filter;

	@FindBy(xpath = "//span[text()=\"Complete\"]")
	private WebElement complete_btn;

	@FindBy(xpath = "//div/span[text()=\"Done\"]")
	private WebElement Done;

	@FindBy(xpath = "//span[text()='Reject']")
	private WebElement reject;

	@FindBy(xpath = "//textarea[@placeholder=\"Maximum character limit is 500\"]")
	private WebElement rejection_reason;

	@FindBy(xpath = "//span[text()='Submit']")
	private WebElement submit_button;

	@FindBy(xpath = "//span[text()='Approver Overview']")
	private WebElement menu_Id_Approver_Overview1;

//	@FindBy(xpath = "//mat-card-content[1]/div/div[2]/mat-form-field/div/div[1]/div[3]/mat-select/div/div[1]")
//	private WebElement Authorization_dropdown;
	
	@FindBy(xpath = "//mat-select-trigger[text()=' Pending Permission Requests ']")
	private WebElement Authorization_dropdown;

	@FindBy(xpath = "//mat-option/span/div/span[not( @title='Select to view pending requests')]")
	private List<WebElement> Authorization_List;

	@FindBy(xpath = "//table//span[contains(text(),'Approve')]//parent::button")
	private WebElement Approver_Overview_approve_request;

	@FindBy(xpath = "//span[text()='Refresh']")
	private WebElement refresh_button;

	@FindBy(xpath = "//table/tbody/tr[1]/td[7]/span/span")
	private WebElement application_number;

	@FindBy(xpath = "//input[contains(@placeholder,'Search')]")
	private WebElement search_item;

	@FindBy(xpath = "//span[text()=\"Nest T Testing\"]")
	private WebElement NestT_Testing_option;

	@FindBy(xpath = "//span[text()=\"Replacement Package\"]")
	private WebElement replacement_package_option;

	@FindBy(xpath = "//span[text()=\"Enhance Right\"]")
	private WebElement Enhance_Right_option;

	@FindBy(xpath = "//span[text()=\"ECU Certificate Request\"]")
	private WebElement ECU_Certificate_Request_option;

	@FindBy(xpath = "//span[text()=\"FOTA\"]")
	private WebElement FOTA_option;

	@FindBy(xpath = "//span[text()=\"Onboard New ECU\"]")
	private WebElement Onboard_New_ECU_option;

	@FindBy(xpath = "//div[text()=\"Requester ID\"]")
	private WebElement Approver_Overview_Requester_id;

	@FindBy(xpath = "//div[text()=\"User Type\"]")
	private WebElement Approver_Overview_User_Type;

	@FindBy(xpath = "//div[text()=\"Service Principal ID\"]")
	private WebElement Approver_Overview_Technical_User_ID;

	@FindBy(xpath = "//i[@id=\"Approval Status\"]")
	private WebElement Approver_Overview_approval_status_filter;

	@FindBy(xpath = "//i[@id=\"ECU Qualifier\"]")
	private WebElement Approver_Overview_ECU_Qualifier_filter;

	@FindBy(xpath = "//i[@id=\"Approval Status\"]")
	private WebElement Approver_Overview_approval_status_filter1;

	@FindBy(xpath = "//th[contains(@class,\"Requester-ID \")]/div/i")
	private WebElement Approver_Overview_requester_id_filter;

	@FindBy(xpath = "//input[@placeholder='Search here']")
	private WebElement Approver_Overview_filter_search;
	@FindBy(xpath = "//mat-checkbox[.=' PENDING ']")
	private WebElement Approver_Overview_filter_checkbox;
	
	@FindBy(xpath = "//span[text()=\"Apply Filter\"]")
	private WebElement Approver_Overview_apply_filter;

	@FindBy(xpath = "//div[text()=\"Username\"]")
	private WebElement Approver_Overview_Username;

	@FindBy(xpath = "//div[text()=\"Department\"]")
	private WebElement Approver_Overview_Department;

	@FindBy(xpath = "//div[text()=\"Applicant Type\"]")
	private WebElement Approver_Overview_Applicant_Type;

	@FindBy(xpath = "//div[text()=\"Application Number\"]")
	private WebElement Approver_Overview_Application_Number;

	@FindBy(xpath = "//div[text()=\"Functional Role\"]")
	private WebElement Approver_Overview_Functional_Role;

	@FindBy(xpath = "//div[text()=\"Approval Status\"]")
	private WebElement Approver_Overview_Approval_Status;
	
	@FindBy(xpath = "//span[@class='mat-sort-header ng-tns-c162-60 ng-star-inserted']")
	private WebElement ECU_Chain_Of_Trust_Type;

	@FindBy(xpath = "//div[text()=\"Business Unit\"]")
	private WebElement Approver_Overview_Business_Unit;

	@FindBy(xpath = "//div[text()=\"Company Name of the Requester\"]")
	private WebElement Approver_Overview_Company_Name_of_the_Requester;

	@FindBy(xpath = "//div[text()=\"ECU Qualifier\"]")
	private WebElement Approver_Overview_ECU_Qualifier;

	@FindBy(xpath = "//div[text()=\"Standard Permissions/Certificate\"]")
	private WebElement Approver_Overview_Standard_Permissions_Certificate;

	@FindBy(xpath = "//div[text()=\"GTC Signed Status\"]")
	private WebElement Approver_Overview_GTC_Signed_Status;

	@FindBy(xpath = "//div[text()=\"Reason for Functional Role Request\"]")
	private WebElement Approver_Overview_Reason_for_Functional_Role_Request;

	@FindBy(xpath = "//div[text()=\"Reason for Rejection\"]")
	private WebElement Approver_Overview_Reason_for_Rejection;

	@FindBy(xpath = "//div[text()=\"Request Date\"]")
	private WebElement Approver_Overview_Request_Date;

	@FindBy(xpath = "//div[text()=\"Approval Date\"]")
	private WebElement Approver_Overview_Approval_Date;

	@FindBy(xpath = "//th[text()=\"Change Request Status\"]")
	private WebElement Approver_Overview_Change_Request_Status;

	@FindBy(xpath = "//span[text()=\"Diagnostic Authority\"]")
	private WebElement Daignostic_authority_option;

	@FindBy(xpath = "//div[text()=\"Username\"]")
	private WebElement Approver_Overview_username;

	@FindBy(xpath = "//div[text()=\"User Role\"]")
	private WebElement Approver_Overview_User_role;

	@FindBy(xpath = "//div[contains(text(),\"ECU Qualifier\")]")
	private WebElement Approver_Overview_ECU_qualifier;

	@FindBy(xpath = "//div[text()=\"Reason for Diagnostic Authority Request\"]")
	private WebElement Approver_Overview_Reason_for_Diagnostic_Authority_Request;

	@FindBy(xpath = "//div[text()=\"Nest-T Testing Case\"]")
	private WebElement Approver_Overview_NestT_Testing_Case;

	@FindBy(xpath = "//div[text()=\"Origin COT\"]")
	private WebElement Approver_Overview_origin_COT;

	@FindBy(xpath = "//div[text()=\"Target COT\"]")
	private WebElement Approver_Overview_target_COT;

	@FindBy(xpath = "//div[text()=\"Reason for Nest T Request\"]")
	private WebElement Approver_Overview_Reason_for_NestT;

	@FindBy(xpath = "//div[text()=\"Reason for Replacement Package Request\"]")
	private WebElement Approver_Overview_Reason_for_Replacement_Package_Request;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Requester-ID \")]")
	private WebElement Approver_Overview_Requester_ID_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"User-Type \")]")
	private WebElement Approver_Overview_Usertype_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Technical-User-ID \")]")
	private WebElement Technical_user_ID;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Username\")]")
	private WebElement username;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Department\")]")
	private WebElement department;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Applicant-Type\")]")
	private WebElement Approver_Overview_applicant_type_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Application-Number\")]")
	private WebElement Approver_Overview_applicant_number_txt;
	
	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Application-Number\")]")
	private List<WebElement> Approver_Overview_applicant_numbers_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Functional-Role\")]")
	private WebElement Approver_Overview_Functional_role_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Approval-Status\")]")
	private WebElement Approver_Overview_approval_status_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Business-Unit \")]")
	private WebElement Approver_Overview_Business_Unit_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Company-Name-of-the-Requester \")]")
	private WebElement Approver_Overview_Company_Name_of_the_Requester_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"ECU-Qualifier\")]")
	private WebElement Approver_Overview_ECU_Qualifier_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Standard-Permissions-Certificate\")]")
	private WebElement Approver_Overview_standard_permission_cert_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"GTC-Signed-Status\")]")
	private WebElement Approver_Overview_GTC_status;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Reason-for-Functional-Role-Request\")]")
	private WebElement Approver_Overview_reason_for_Functional_Role_Request_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Reason-for-Rejection\")]")
	private WebElement Approver_Overview_Reason_for_Rejection_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Request-Date\")]")
	private WebElement Approver_Overview_request_date_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Approval-Date\")]")
	private WebElement Approver_Overview_Approval_date_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"User-Role \")]")
	private WebElement Approver_Overview_user_role_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Reason-for-Diagnostic-Authority-Request \")]")
	private WebElement Approver_Overview_Reason_for_Diagnostic_Authority_Request_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Nest-T-Testing-Case \")]")
	private WebElement Approver_Overview_Nest_T_Testing_Case_NestT;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,'Reason-for-Request')]")
	private WebElement Approver_Overview_Reason_for_NestT_Request_NestT;

	@FindBy(xpath = "//div[text()=\"ECU Owner\"]")
	private WebElement Approver_Overview_ECU_Owner;

	@FindBy(xpath = "//div[text()=\"Supplier Name\"]")
	private WebElement Approver_Overview_Supplier_Name;

	@FindBy(xpath = "//div[text()=\"Status GTC Acceptance\"]")
	private WebElement Approver_Overview_Status_GTC_Acceptance;

	@FindBy(xpath = "//div[text()=\"Supplier Responsible\"]")
	private WebElement Approver_Overview_Supplier_Responsible;

	@FindBy(xpath = "//div[text()=\"CS Architect Component Name\"]")
	private WebElement Approver_Overview_CS_Architect;

	@FindBy(xpath = "//div[text()=\"Target ECU ID\"]")
	private WebElement Approver_Overview_Target_ECU;

	@FindBy(xpath = "//div[text()=\"Service IDs\"]")
	private WebElement Approver_Overview_Service_ID;

	@FindBy(xpath = "//div[text()=\"Validity (Days)\"]")
	private WebElement Approver_Overview_Validity;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"ECU-Owner \")]")
	private WebElement Approver_Overview_ECU_Owner_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Supplier-Name \")]")
	private WebElement Approver_Overview_Supplier_Name_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Status-GTC-Acceptance \")]")
	private WebElement Approver_Overview_Status_GTC_Acceptance_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Supplier-Responsible \")]")
	private WebElement Approver_Overview_Supplier_Responsible_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"CS-Architect-Component\")]")
	private WebElement Approver_Overview_CS_Architect_Component_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Target-ECU-ID \")]")
	private WebElement Approver_Overview_Target_ECU_ID_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Service-IDs \")]")
	private WebElement Approver_Overview_Service_IDs_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"DiagAuth-Certificate \")]")
	private WebElement Approver_Overview__DiagAuth_Certificatetxt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Validity--Days\")]")
	private WebElement Approver_Overview_Validity_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Origin-COT \")]")
	private WebElement Approver_Overview__Origin_COT_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Target-COT \")]")
	private WebElement Approver_Overview_Target_COT_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Reason-for-Request \")]")
	private WebElement Approver_Overview_Replacement_Package_Request_txt;

	@FindBy(xpath = "//div[text()=\"DiagAuth Certificate\"]")
	private WebElement Approver_Overview_DiagAuth_Cert;

	@FindBy(xpath = "//div[text()=\"Diagnostic Permission\"]")
	private WebElement Approver_Overview_Diagnostic_Permission;

	@FindBy(xpath = "//div[text()=\"Additional Service IDs\"]")
	private WebElement Approver_Overview_Additional_ServiceIDs;

	@FindBy(xpath = "//div[text()=\"Permission Validity (Days)\"]")
	private WebElement Approver_Overview_Permission_Validity;

	@FindBy(xpath = "//div[text()=\"Permission Validity Status\"]")
	private WebElement Approver_Overview_Permission_Validity_Status;

	@FindBy(xpath = "//div[text()=\"Enhance Cert validity (Days)\"]")
	private WebElement Approver_Overview_Enhance_Cert_validity;

	@FindBy(xpath = "//div[text()=\"Reason for FOTA Request\"]")
	private WebElement Approver_Overview_Reason_for_FOTA_Request;

	@FindBy(xpath = "//div[text()=\"Reason for Enhance Right Request\"]")
	private WebElement Approver_Overview_Reason_for_Enhance_Right_Request;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Diagnostic-Permission \")]")
	private WebElement Approver_Overview_Diagnostic_Permission_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Additional-Service-IDs \")]")
	private WebElement Approver_Overview_Additional_Service_IDs_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Permission-Validity--Days\")]")
	private WebElement Approver_Overview_Permission_Validity_Days_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Permission-Validity-Status \")]")
	private WebElement Approver_Overview_Permission_Validity_Status_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Enhance-Cert-validity\")]")
	private WebElement Approver_Overview_Enhance_Cert_validity_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Reason-for-FOTA-Request \")]")
	private WebElement Approver_Overview_Reason_for_FOTA_Request_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Target-ECU \")]")
	private WebElement Target_ECU_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Tool-Type \")]")
	private WebElement Tool_Type_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Reason-for-Request \")]")
	private WebElement Reason_for_Special_Enhance_Request_txt;

	@FindBy(xpath = "//div[text()=\"Action Type\"]")
	private WebElement Action_Type;

	@FindBy(xpath = "//div[text()=\"Reason for Updating Functional Role Request\"]")
	private WebElement Reason_for_Updating_Functional_Role_Request;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Action-Type \")]")
	private WebElement Action_Type_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Reason-for-Request \")]")
	private WebElement Reason_for_Updating_Functional_Role_Request_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"COT\")]")
	private WebElement Approver_Overview_COT_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"ECU-Qualifier-Group \")]")
	private WebElement Approver_Overview_ECU_Qualifier_Group_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"KMS-System-IP-Address \")]")
	private WebElement Approver_Overview_KMS_System_IP_Address_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Reason-for-ECU-Certificate-Request \")]")
	private WebElement Approver_Overview_Reason_for_ECU_Certificate_Request_txt;

	@FindBy(xpath = "//div[text()=\"COT\"]")
	private WebElement Approver_Overview_COT;

	@FindBy(xpath = "//div[text()=\"ECU Qualifier Group\"]")
	private WebElement Approver_Overview_ECU_Qualifier_Group;

	@FindBy(xpath = "//div[text()=\"KMS System IP Address\"]")
	private WebElement Approver_Overview_KMS_System_IP_Address;

	@FindBy(xpath = "//div[text()=\"Reason for ECU Certificate Request\"]")
	private WebElement Approver_Overview_Reason_for_ECU_Certificate_Request;
	
	@FindBy(xpath = "//*[text()=\"Submit\"]")
	private WebElement Submit;
	
	@FindBy(xpath = "//textarea[@placeholder='Maximum character limit is 500']")
	private WebElement RejectionTxt;
	


	public String change_request_status() throws InterruptedException {
		Thread.sleep(5000);
		waitForWebElementToAppear(Done);
		String dr = Done.getText();
		return dr;
	}

	public void approver_Overview_reject() throws InterruptedException {
//		Scrollright_waitForWebElementToAppear(Approver_Overview_Approval_Status);
		AbstractComponents.waitForelementToBeClickable(reject);
		Thread.sleep(2000);
//		click(reject);
		reject.click();
	}

	public void reason_for_rejection(String reason) {
		waitForWebElementToAppear(rejection_reason);
		waitForWebElementToAppear(rejection_reason);
		type(rejection_reason, reason);
		AbstractComponents.waitForelementToBeClickable(submit_button);
		clickJS(submit_button);
	}

	public void filter_search(String status) throws Throwable {
		try {
			Thread.sleep(2000);
			waitForWebElementToAppear(Approver_Overview_approval_status_filter);
			click(Approver_Overview_approval_status_filter);
			type(Approver_Overview_filter_search, status);
			Thread.sleep(2000);
			waitForWebElementToAppear(Approver_Overview_filter_checkbox);
			click(Approver_Overview_filter_checkbox);
			
			click(Approver_Overview_apply_filter);

		} catch (Exception e) {
			waitForWebElementToAppear(Approver_Overview_approval_status_filter1);
			clickJS(Approver_Overview_approval_status_filter1);
			AbstractComponents.waitForelementToBeClickable(Approver_Overview_approval_status_filter1);
			Thread.sleep(1500);
			type(Approver_Overview_filter_search, status);
			waitForWebElementToAppear(Approver_Overview_filter_checkbox);
			clickJS(Approver_Overview_filter_checkbox);
			clickJS(Approver_Overview_apply_filter);
			AbstractComponents.waitForelementToBeClickable(Approver_Overview_apply_filter);
		}
	}
	
	public void ECU_search(String status) throws Throwable {
		try {
			waitForWebElementToAppear(Approver_Overview_ECU_Qualifier_filter);
			clickJS(Approver_Overview_ECU_Qualifier_filter);
			type(Approver_Overview_filter_search, status);
			waitForWebElementToAppear(Approver_Overview_filter_checkbox);
			clickJS(Approver_Overview_filter_checkbox);
			clickJS(Approver_Overview_apply_filter);
			AbstractComponents.waitForelementToBeClickable(Approver_Overview_apply_filter);

		} catch (Exception e) {
			waitForWebElementToAppear(Approver_Overview_ECU_Qualifier_filter);
			clickJS(Approver_Overview_ECU_Qualifier_filter);
			type(Approver_Overview_filter_search, status);
			waitForWebElementToAppear(Approver_Overview_filter_checkbox);
			clickJS(Approver_Overview_filter_checkbox);
			clickJS(Approver_Overview_apply_filter);
			AbstractComponents.waitForelementToBeClickable(Approver_Overview_apply_filter);
		}
	}

	public void filter_search1(String status) throws Throwable {
		waitForWebElementToAppear(Approver_Overview_approval_status_filter1);
		clickJS(Approver_Overview_approval_status_filter1);
		type(Approver_Overview_filter_search, status);
		waitForWebElementToAppear(Approver_Overview_filter_checkbox);
		clickJS(Approver_Overview_filter_checkbox);
		clickJS(Approver_Overview_apply_filter);
		AbstractComponents.waitForelementToBeClickable(Approver_Overview_apply_filter);
	}

	public void approver_Overview_enabled1() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(1000);
		menu_Id_Approver_Overview1.isEnabled();
		AbstractComponents.waitForelementToBeClickable(menu_Id_Approver_Overview1);
		clickJS(menu_Id_Approver_Overview1);
		logger.info("Clicked");
		Thread.sleep(5000);
	}

	public void Authorization_roledropdown(String name) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		waitForWebElementToAppear(Authorization_dropdown);
		logger.info("***Authorization_List: "+name);
		clickJS(Authorization_dropdown);
		clickelementmatchingtext(Authorization_List, name);
	}

	public void clickelementmatchingtext(List<WebElement> elements, String User_type) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		for (int i = 0; i < Authorization_List.size(); i++) {
			logger.info(Authorization_List.get(i).getText());
			logger.info(User_type);
			if (elements.get(i).getText().equalsIgnoreCase(User_type)) {
				waitForelementToBeClickable(elements.get(i));
				Thread.sleep(200);
				click(elements.get(i));
				break;
			}
		}
	}

	public void User_type(String type) {
		String user_type = String.format("//span[contains(text(),'%s')]", type);
		clickJS(driver.findElement(By.xpath(user_type)));

	}

	public void reset_filter() {
		AbstractComponents.waitForelementToBeClickable(reset_filter);
		clickJS(reset_filter);

	}

	public void internal_type() {

//		clickJS(internal_type);

	}

	public void external_type() {

//		clickJS(external_type);

	}

	public void supplier_type() {

//		clickJS(supplier_type);

	}

	public void technical_user_type() {

		clickJS(Technical_User_type);

	}

	public void complete_btn() throws InterruptedException {

		clickJS(complete_btn);
		Thread.sleep(500);

	}

	public void approve_Request(String status) throws Throwable {

		try {
			Thread.sleep(5000);
			waitForPageLoad(driver);
			AbstractComponents.waitForWebElementToAppear(Approver_Overview_approve_request);
			AbstractComponents.waitForelementToBeClickable(Approver_Overview_approve_request);
			click(Approver_Overview_approve_request);
			Thread.sleep(1000);
		} catch (StaleElementReferenceException e) {
			filter_search(status);
			WebElement dynmaic_xpath = dynmaic_xpath("Approve");
			AbstractComponents.waitForelementToBeClickable(dynmaic_xpath);
			clickJS(dynmaic_xpath);
		}

	}
	
	public void onBoard_Approval(String value,String id) throws InterruptedException {
	
		approver_Overview_enabled1();
		Authorization_roledropdown(value);
		search_here(id);
		complete_btn();
		Scrollright_waitForWebElementToAppear(Approver_Overview_Reason_for_Rejection);
		click(Approver_Overview_approve_request);
		Thread.sleep(1000);	
	}
	
	public void Pending_Request_Approval(String value,String id) throws InterruptedException {
		
		approver_Overview_enabled1();
		Authorization_roledropdown(value);
		search_here(id);
		complete_btn();
		Thread.sleep(2000);
		Scrollright_waitForWebElementToAppear(Approver_Overview_approve_request);
		click(Approver_Overview_approve_request);
		Thread.sleep(1000);	
	}
	
	public void TwoLevelApprovel() throws Throwable {
		AbstractComponents.waitForelementToBeClickable(Approver_Overview_approve_request);

		click(Approver_Overview_approve_request);
		test.pass("User is able to approve 1st level approval");
		logger.info("User is able to approve 1st level approval");
		Thread.sleep(4000);
		AbstractComponents.waitForelementToBeClickable(Approver_Overview_approve_request);
		click(Approver_Overview_approve_request);
		
	}
	public void TwoLevelApprovel_Service(String applicationNumber) throws Throwable {
		ArrayList<String> al = new ArrayList<>();
		Thread.sleep(3000);
		waitForPageLoad(driver);
		waitForWebElementToAppear(Approver_Overview_approve_request);
		AbstractComponents.waitForelementToBeClickable(Approver_Overview_approve_request);
		click(Approver_Overview_approve_request);
		test.pass("User is able to approve 1st level approval");
		logger.info("User is able to approve 1st level approval");
		Thread.sleep(4000);
		AbstractComponents.waitForelementToBeClickable(Approver_Overview_approve_request);
		f.functional_role_Overview_enabled1();
		String id =f.functionalValidation(applicationNumber);
		al.add(id);
		al.add(applicationNumber);
		approver_overview.approver_Overview_enabled1();
		approver_overview.search_here(applicationNumber);
		AbstractComponents.waitForelementToBeClickable(Approver_Overview_approve_request);
		click(Approver_Overview_approve_request);
	}
	public void TwoLevelApprovel_Service_DA_EA(String applicationNumber,String requesttype,String approval_status,String approval_date, String userrole) throws Throwable {
		ArrayList<String> al = new ArrayList<>();
		AbstractComponents.waitForelementToBeClickable(Approver_Overview_approve_request);
		click(Approver_Overview_approve_request);
		test.pass("User is able to approve 1st level approval");
		logger.info("User is able to approve 1st level approval");
		Thread.sleep(4000);
		AbstractComponents.waitForelementToBeClickable(Approver_Overview_approve_request);
		req.request_Overview_page_ServicePrincipal(requesttype,applicationNumber,approval_status,approval_date,userrole);
		approver_overview.approver_Overview_enabled1();
		approver_overview.search_here(applicationNumber);
		AbstractComponents.waitForelementToBeClickable(Approver_Overview_approve_request);
		click(Approver_Overview_approve_request);
	}
	
	public void search_ECU(String status) throws Throwable {

		try {
			ECU_search(status);
		} catch (StaleElementReferenceException e) {
			ECU_search(status);
		}

	}

	public void approve_Request1(String status) throws Throwable {
		filter_search1(status);
		clickJS(Approver_Overview_approve_request);

	}

	public void search_here(String object) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		search_item.clear();
		search_item.sendKeys(object);
		type(search_item, Keys.ENTER);
	}
	
	public void rejectiontxt(String object) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		RejectionTxt.sendKeys(object);
		type(RejectionTxt, Keys.ENTER);
	}

	public void not_able_to_view_request() {
		if (!Approver_Overview_Application_Number.isDisplayed()) {
			test.pass("Deputy approver not able to view the request");
		}
	}

	public String Approver_Overview_Requester_ID_txt() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		waitForWebElementToAppear(Approver_Overview_Requester_ID_txt);
		return Approver_Overview_Requester_ID_txt.getText().trim();

	}

	public String Approver_Overview_Usertype_txt() {
		waitForWebElementToAppear(Approver_Overview_Usertype_txt);
		return Approver_Overview_Usertype_txt.getText().trim();

	}

	public String Approver_Techincal_user_Id_txt() {
		waitForWebElementToAppear(Technical_user_ID);
		return Technical_user_ID.getText().trim();

	}

	public String Approver_username_txt() {
		waitForWebElementToAppear(username);
		return username.getText().trim();

	}

	public String Approver_department_txt() {
		waitForWebElementToAppear(department);
		return department.getText().trim();

	}

	public String Approver_applicant_type_txt() {
		waitForWebElementToAppear(Approver_Overview_applicant_type_txt);
		return Approver_Overview_applicant_type_txt.getText().trim();

	}

	public String Approver_Overview_applicant_number_txt() {
		waitForWebElementToAppear(Approver_Overview_applicant_number_txt);
		return Approver_Overview_applicant_number_txt.getText().trim();

	}

	public String Approver_Overview_Functional_role_txt() {
		waitForWebElementToAppear(Approver_Overview_Functional_role_txt);
		return Approver_Overview_Functional_role_txt.getText().trim();

	}

	public String Approver_Overview_approval_status_txt() throws InterruptedException {
		Thread.sleep(2000);
		waitForWebElementToAppear(Approver_Overview_approval_status_txt);
		return Approver_Overview_approval_status_txt.getText().trim();

	}

	public String Approver_Overview_Business_Unit_txt() {
		waitForWebElementToAppear(Approver_Overview_Business_Unit_txt);
		return Approver_Overview_Business_Unit_txt.getText().trim();

	}

	public String Approver_Overview_Company_Name_of_the_Requester_txt() {
		waitForWebElementToAppear(Approver_Overview_Company_Name_of_the_Requester_txt);
		return Approver_Overview_Company_Name_of_the_Requester_txt.getText().trim();

	}

	public String Approver_Overview_ECU_Qualifier_txt() {
		waitForWebElementToAppear(Approver_Overview_ECU_Qualifier_txt);
		return Approver_Overview_ECU_Qualifier_txt.getText().trim();

	}

	public String Approver_Overview_standard_permission_cert_txt() {
		waitForWebElementToAppear(Approver_Overview_standard_permission_cert_txt);
		return Approver_Overview_standard_permission_cert_txt.getText().trim();

	}

	public String Approver_Overview_GTC_status() {
		waitForWebElementToAppear(Approver_Overview_GTC_status);
		return Approver_Overview_GTC_status.getText().trim();

	}

	public String Approver_Overview_reason_for_Functional_Role_Request_txt() {
		waitForWebElementToAppear(Approver_Overview_reason_for_Functional_Role_Request_txt);
		return Approver_Overview_reason_for_Functional_Role_Request_txt.getText().trim();

	}

	public String Approver_Overview_Reason_for_Rejection_txt() {
		waitForWebElementToAppear(Approver_Overview_Reason_for_Rejection_txt);
		return Approver_Overview_Reason_for_Rejection_txt.getText().trim();

	}

	public String Approver_Overview_request_date_txt() {
		waitForWebElementToAppear(Approver_Overview_request_date_txt);
		return Approver_Overview_request_date_txt.getText().trim();

	}

	public String Approver_Overview_approval_date_txt() {
		waitForWebElementToAppear(Approver_Overview_Approval_date_txt);
		return Approver_Overview_Approval_date_txt.getText().trim();

	}

	public String Approver_Overview_user_role_txt() {
		waitForWebElementToAppear(Approver_Overview_user_role_txt);
		return Approver_Overview_user_role_txt.getText().trim();

	}

	public String Approver_Overview_Reason_for_Diagnostic_Authority_Request_txt() {
		waitForWebElementToAppear(Approver_Overview_Reason_for_Diagnostic_Authority_Request_txt);
		return Approver_Overview_Reason_for_Diagnostic_Authority_Request_txt.getText().trim();

	}

	public String Approver_Overview_Reason_for_NestT_Request_NestT() {
		waitForWebElementToAppear(Approver_Overview_Reason_for_NestT_Request_NestT);
		return Approver_Overview_Reason_for_NestT_Request_NestT.getText().trim();

	}

	public String Approver_Overview_Nest_T_Testing_Case_NestT() {
		waitForWebElementToAppear(Approver_Overview_Nest_T_Testing_Case_NestT);
		return Approver_Overview_Nest_T_Testing_Case_NestT.getText().trim();

	}

	public String Approver_Overview_Supplier_Responsible_txt() {
		waitForWebElementToAppear(Approver_Overview_Supplier_Responsible_txt);
		return Approver_Overview_Supplier_Responsible_txt.getText().trim();

	}

	public String Approver_Overview_Status_GTC_Acceptance_txt() {
		waitForWebElementToAppear(Approver_Overview_Status_GTC_Acceptance_txt);
		return Approver_Overview_Status_GTC_Acceptance_txt.getText().trim();

	}

	public String Approver_Overview_Supplier_Name_txt() {
		waitForWebElementToAppear(Approver_Overview_Supplier_Name_txt);
		return Approver_Overview_Supplier_Name_txt.getText().trim();

	}

	public String Approver_Overview_ECU_Owner_txt() {
		waitForWebElementToAppear(Approver_Overview_ECU_Owner_txt);
		return Approver_Overview_ECU_Owner_txt.getText().trim();

	}

	public String Approver_Overview_Target_ECU_ID_txt() {
		waitForWebElementToAppear(Approver_Overview_Target_ECU_ID_txt);
		return Approver_Overview_Target_ECU_ID_txt.getText().trim();
	}

	public String Approver_Overview_CS_Architect_Component_txt() {
		waitForWebElementToAppear(Approver_Overview_CS_Architect_Component_txt);
		return Approver_Overview_CS_Architect_Component_txt.getText().trim();
	}

	public String Approver_Overview_Service_IDs_txt() {
		waitForWebElementToAppear(Approver_Overview_Service_IDs_txt);
		return Approver_Overview_Service_IDs_txt.getText().trim();
	}

	public String Approver_Overview__DiagAuth_Certificatetxt() {
		waitForWebElementToAppear(Approver_Overview__DiagAuth_Certificatetxt);
		return Approver_Overview__DiagAuth_Certificatetxt.getText().trim();
	}

	public String Approver_Overview_Validity_txt() {
		waitForWebElementToAppear(Approver_Overview_Validity_txt);
		return Approver_Overview_Validity_txt.getText().trim();
	}

	public String Approver_Overview__Origin_COT_txt() {
		waitForWebElementToAppear(Approver_Overview__Origin_COT_txt);
		return Approver_Overview__Origin_COT_txt.getText().trim();
	}

	public String Approver_Overview_Target_COT_txt() {
		waitForWebElementToAppear(Approver_Overview_Target_COT_txt);
		return Approver_Overview_Target_COT_txt.getText().trim();
	}

	public String Approver_Overview_Replacement_Package_Request_txt() {
		waitForWebElementToAppear(Approver_Overview_Replacement_Package_Request_txt);
		return Approver_Overview_Replacement_Package_Request_txt.getText().trim();
	}

	public String Approver_Overview_Additional_Service_IDs_txt() {

		waitForWebElementToAppear(Approver_Overview_Additional_Service_IDs_txt);
		return Approver_Overview_Additional_Service_IDs_txt.getText().trim();

	}

	public String Approver_Overview_Permission_Validity_Days_txt() {

		waitForWebElementToAppear(Approver_Overview_Permission_Validity_Days_txt);
		return Approver_Overview_Permission_Validity_Days_txt.getText().trim();

	}

	public String Approver_Overview_Permission_Validity_Status_txt() {

		waitForWebElementToAppear(Approver_Overview_Permission_Validity_Status_txt);
		return Approver_Overview_Permission_Validity_Status_txt.getText().trim();

	}

	public String Approver_Overview_Enhance_Cert_validity_txt() {

		waitForWebElementToAppear(Approver_Overview_Enhance_Cert_validity_txt);
		return Approver_Overview_Enhance_Cert_validity_txt.getText().trim();

	}

	public String Approver_Overview_Reason_for_FOTA_Request_txt() {

		waitForWebElementToAppear(Approver_Overview_Reason_for_FOTA_Request_txt);
		return Approver_Overview_Reason_for_FOTA_Request_txt.getText().trim();

	}

	public String Approver_Overview_Diagnostic_Permission_txt() {

		waitForWebElementToAppear(Approver_Overview_Diagnostic_Permission_txt);
		return Approver_Overview_Diagnostic_Permission_txt.getText().trim();

	}

	public String Target_ECU_txt() {
		waitForWebElementToAppear(Target_ECU_txt);
		return Target_ECU_txt.getText().trim();

	}

	public String Tool_Type_txt() {
		waitForWebElementToAppear(Tool_Type_txt);
		return Tool_Type_txt.getText().trim();

	}

	public String Reason_for_Special_Enhance_Request_txt() {
		waitForWebElementToAppear(Reason_for_Special_Enhance_Request_txt);
		return Reason_for_Special_Enhance_Request_txt.getText().trim();

	}

	public String Action_Type_txt() {
		waitForWebElementToAppear(Action_Type_txt);
		return Action_Type_txt.getText().trim();

	}

	public String Reason_for_Updating_Functional_Role_Request_txt() {
		waitForWebElementToAppear(Reason_for_Updating_Functional_Role_Request_txt);
		return Reason_for_Updating_Functional_Role_Request_txt.getText().trim();

	}

	public String Approver_Overview_COT_txt() {
		waitForWebElementToAppear(Approver_Overview_COT_txt);
		return Approver_Overview_COT_txt.getText().trim();

	}

	public String Approver_Overview_ECU_Qualifier_Group_txt() {
		waitForWebElementToAppear(Approver_Overview_ECU_Qualifier_Group_txt);
		return Approver_Overview_ECU_Qualifier_Group_txt.getText().trim();

	}

	public String Approver_Overview_KMS_System_IP_Address_txt() {
		waitForWebElementToAppear(Approver_Overview_KMS_System_IP_Address_txt);
		return Approver_Overview_KMS_System_IP_Address_txt.getText().trim();

	}

	public String Request_Overview_Reason_for_ECU_Certificate_Request_txt() {
		waitForWebElementToAppear(Approver_Overview_Reason_for_ECU_Certificate_Request_txt);
		return Approver_Overview_Reason_for_ECU_Certificate_Request_txt.getText().trim();

	}

	public void approverOverviewPage(String authorization_value, List<Object> functional_role_Overview_table_input,
			String functional_role_selected) throws Throwable {
		approver_Overview_enabled1();
		Authorization_roledropdown(authorization_value);
		if (functional_role_selected.equals("Internal")) {
			internal_type();
		} else if (functional_role_selected.equals("External")) {
			external_type();
		} else {
			supplier_type();
		}
		complete_btn();
		search_here(functional_role_Overview_table_input.get(1).toString());
		Thread.sleep(2000);
		Scrollright_waitForWebElementToAppear(Approver_Overview_Functional_Role);
		Approver_Overview_Requester_ID_txt().equals(functional_role_Overview_table_input.get(2).toString());
////		Approver_username_txt().equals(functional_role_Overview_table_input.get(5).toString());
//		Approver_department_txt().equals(functional_role_Overview_table_input.get(6).toString());
//		Approver_applicant_type_txt().equals(functional_role_Overview_table_input.get(7).toString());
//		Approver_Overview_applicant_number_txt().equals(functional_role_Overview_table_input.get(1).toString());
//		Approver_Overview_Functional_role_txt().equals(functional_role_Overview_table_input.get(8).toString());
//		Approver_Overview_reason_for_Functional_Role_Request_txt().equals(funational_role_Overview_table_input.get(16).toString());
		
//		Approver_Overview_approval_status_txt().equals(functional_role_Overview_table_input.get(0).toString());
//		Approver_Overview_standard_permission_cert_txt().equals(functional_role_Overview_table_input.get(15).toString());
//		
//		Approver_Overview_request_date_txt().equals(functional_role_Overview_table_input.get(13).toString());
		approval_date_txt = Approver_Overview_approval_date_txt();
		approval_date_txt.equals(functional_role_Overview_table_input.get(14).toString());
		Thread.sleep(2000);

	}

	public void approverOverviewPage_for_more_than_one_ECU(String authorization_value,
			List<Object> funational_role_Overview_table_input, String functional_role_selected, String status, String eCU_selected2)
			throws Throwable {
		approver_Overview_enabled1();
		Authorization_roledropdown(authorization_value);
		complete_btn();
		search_here(funational_role_Overview_table_input.get(1).toString());
		List<List<String>> secondTableValues = BaseClass.getTableValuesExcludingLastColumn(driver,
				By.xpath("//table/tbody"));
		boolean allFirstTableValuesPresentInSecondTable = BaseClass.checkFirstTableValuesPresenceSkippingCertainColumns(
				(List<List<String>>) funational_role_Overview_table_input.get(4), secondTableValues);
		if (allFirstTableValuesPresentInSecondTable) {
			test.info("All values from the first table are present in the second table.");
		} else {
			test.info("Not all values from the first table are present in the second table.");
		}
		Thread.sleep(200);
	}

	public String reject_FR_Request(String reason, String authorization_value, List<Object> user_name,
			String functional_role_selected) throws Throwable {
		approverOverviewPage(authorization_value, user_name, functional_role_selected);
		return approver_overview_reject_request(reason);
	}

	public String approver_overview_reject_request(String reason) throws Throwable {
		approver_Overview_reject();
		reason_for_rejection(reason);
		Thread.sleep(3000);
		String done_status = change_request_status();
		if (done_status.trim().equals("Done")) {
			test.info("status changed to done");
		}
		approval_status = Approver_Overview_approval_status_txt();
		Approver_Overview_standard_permission_cert_txt().trim().equals("N/A");
		return approval_status;

	}

	public String approvetheFR_Request(String authorization_value, List<Object> username,
			String functional_role_selected, String status) throws Throwable {

		approverOverviewPage(authorization_value, username, functional_role_selected);
		return approve_request(status);
	}

	public String approvetheFR_Request_for_more_than_one_ECU(String authorization_value, List<Object> username,
			String functional_role_selected, String status, String ECU_selected) throws Throwable {

		approverOverviewPage_for_more_than_one_ECU(authorization_value, username, functional_role_selected,
				status,ECU_selected);
		return approve_request_for_more_than_one_ECU(ECU_selected);
	}

	public String approve_request_for_more_than_one_ECU(String eCU_selected) throws InterruptedException {
		try {
			clickJS(Approver_Overview_ECU_Qualifier_filter);
			type(Approver_Overview_filter_search, eCU_selected);
			waitForWebElementToAppear(Approver_Overview_filter_checkbox);
			clickJS(Approver_Overview_filter_checkbox);
			clickJS(Approver_Overview_apply_filter);
			clickJS(Approver_Overview_approve_request);
			reset_filter();
			reset_filter();
			test.pass("APprover is able to approve the request");
			String done_status = change_request_status();
			if (done_status.trim().equals("Done")) {
				test.info("status changed to done");
			}
		} catch (Exception e) {
			waitForWebElementToAppear(Approver_Overview_ECU_Qualifier_filter);
			clickJS(Approver_Overview_ECU_Qualifier_filter);
			type(Approver_Overview_filter_search, eCU_selected);
			waitForWebElementToAppear(Approver_Overview_filter_checkbox);
			clickJS(Approver_Overview_filter_checkbox);
			clickJS(Approver_Overview_apply_filter);
			clickJS(Approver_Overview_approve_request);
			reset_filter();
			reset_filter();
			test.pass("APprover is able to approve the request");
			String done_status = change_request_status();
			if (done_status.trim().equals("Done")) {
				test.info("status changed to done");
			}
		}
		approval_status = Approver_Overview_approval_status_txt();
		return approval_status;
	}

	public String approve_request(String status) throws Throwable {
		try {
			approve_Request(status);
			test.pass("Approver is able to approve the request");
			String done_status = change_request_status();
			if (done_status.trim().equals("Done")) {
				test.info("status changed to done");
			}
			reset_filter();
			Thread.sleep(200);
			reset_filter();
//			test.pass("APprover is able to approve the request");
//			String done_status = change_request_status();
//			if (done_status.trim().equals("Done")) {
//				test.info("status changed to done");
//			}
		} catch (StaleElementReferenceException e) {
			approve_Request1(status);
			reset_filter();
			reset_filter();
			test.pass("Approver is able to approve the request");
			String done_status = change_request_status();
			if (done_status.trim().equals("Done")) {
				test.info("status changed to done");
			}
		}

		approval_status = Approver_Overview_approval_status_txt();
		return approval_status;
	}

	public String approvetheDA_Request(String authorization_value, String status, List<String> create_DA_request)
			throws Throwable {
		approverOverviewPage_for_DA(authorization_value, create_DA_request);
		approve_Request(status);
		test.pass("APprover is able to approve the request");
		reset_filter();
		reset_filter();
		String done_status = change_request_status();
		if (done_status.trim().equals("Done")) {
			test.info("status changed to done");
		}
		approval_status = Approver_Overview_approval_status_txt();
		return approval_status;
	}
	
	public String approvetheDA_Request(String authorization_value, String status, String id)throws Throwable {	
		approver_Overview_enabled1();
		Thread.sleep(2000);
		Authorization_roledropdown(authorization_value);
		Thread.sleep(2000);
		search_here(id);
		approve_Request(status);
		test.pass("Approver is able to approve the request");
		Thread.sleep(3000);
		String done_status = change_request_status();
		if (done_status.trim().equals("Done")) {
			test.info("status changed to done");
		}
		approval_status = Approver_Overview_approval_status_txt();
		reset_filter();
		return approval_status;
	}

	public void approverOverviewPage_for_DA(String authorization_value, List<String> create_DA_request)
			throws Throwable {
		approver_Overview_enabled1();
		Authorization_roledropdown(authorization_value);
//		if (create_DA_request.get(4).equals("Internal")) {
//			internal_type();
//		} else if (create_DA_request.get(4).equals("External")) {
//			external_type();
//		} else {
//			supplier_type();
//		}
		complete_btn();
		search_here(create_DA_request.get(5));
//		Approver_Overview_Requester_ID_txt().equals(create_DA_request.get(1));
//		Approver_username_txt().equals(create_DA_request.get(2));
//		Approver_Overview_Usertype_txt().equals(create_DA_request.get(9));
//		Approver_department_txt().equals(create_DA_request.get(3));
//		Approver_applicant_type_txt().equals(create_DA_request.get(4));
//		Approver_Overview_Functional_role_txt().equals(create_DA_request.get(11));
//		Approver_Overview_applicant_number_txt().equals(create_DA_request.get(5));
//		Approver_Overview_user_role_txt().equals(create_DA_request.get(13));
//		Approver_Overview_ECU_Qualifier_txt().equals(create_DA_request.get(12));
//		Approver_Overview_approval_status_txt().equals(create_DA_request.get(0));
//		Approver_Overview_Reason_for_Diagnostic_Authority_Request_txt().equals(create_DA_request.get(14));
//		Approver_Overview_Reason_for_Rejection_txt().equals(create_DA_request.get(6));
//		Approver_Overview_request_date_txt().equals(create_DA_request.get(7));
//		Approver_Overview_approval_date_txt().equals(create_DA_request.get(8));

	}

	public String rejecttheDA_Request(String authorization_value, List<String> create_DA_request, String reason)
			throws Throwable {
		approverOverviewPage_for_DA(authorization_value, create_DA_request);
		approver_Overview_reject();
		reason_for_rejection(reason);
		String done_status = change_request_status();
		if (done_status.trim().equals("Done")) {
			test.info("status changed to done");
		}
		approval_status = Approver_Overview_approval_status_txt();
		refresh();
		return approval_status;
	}
	public String rejecttheDA_Request(String authorization_value, String reason,String search)
			throws Throwable {
		//hari
//		approverOverviewPage_for_DA(authorization_value, create_DA_request);
		approver_Overview_enabled1();
		Thread.sleep(2000);
		Authorization_roledropdown(authorization_value);
		Thread.sleep(2000);
		System.out.println(search);
		search_here(search);		
		complete_btn();	
		approver_Overview_reject();
		reason_for_rejection(reason);
		String done_status = change_request_status();
		if (done_status.trim().equals("Done")) {
			test.info("status changed to done");
		}
		approval_status = Approver_Overview_approval_status_txt();
		refresh();
		return approval_status;
	}

	public String approveEnhanceRight_authority_Request(Object object, String authorization_value, String status,
			List<Object> create_Enhance_Right_Authority_request) throws Throwable {
		approverOverviewPage_for_Enhance_right_authority(object, authorization_value,
				create_Enhance_Right_Authority_request);
		approve_Request(status);
		test.pass("APprover is able to approve the request");
		reset_filter();
		reset_filter();
		String done_status = change_request_status();
		if (done_status.trim().equals("Done")) {
			test.info("status changed to done");
		}
		approval_status = Approver_Overview_approval_status_txt();
		return approval_status;
	}
	public String approveEnhanceRight_authority_Request(HashMap<String, String> input,String id) throws Throwable {
//		approverOverviewPage_for_Enhance_right_authority(input);
//		String id = input.get("Application Number");	
		approver_Overview_enabled1();
		Authorization_roledropdown("Enhance Right");
		Thread.sleep(2000);
		complete_btn();
		Thread.sleep(2000);
		search_here(id);
		Thread.sleep(2000);
		approve_Request("");
		Thread.sleep(3000);
		req.scrollForReason();
		test.pass("Approver is able to approve the request");
		reset_filter();
		//reset_filter();
		String done_status = change_request_status();
		if (done_status.trim().equals("Done")) {
			test.info("status changed to done");
		}
		approval_status = Approver_Overview_approval_status_txt();
		refresh();
		Thread.sleep(5000);
		return approval_status;
	}
	
	public void approverOverviewPage_for_Enhance_right_authority(Object object, String authorization_value,
			List<Object> create_Enhance_Right_Authority_request) throws Throwable {
		approver_Overview_enabled1();
		Authorization_roledropdown(authorization_value);
		complete_btn();
		search_here(create_Enhance_Right_Authority_request.get(7).toString());
		Approver_Overview_Requester_ID_txt().equals(create_Enhance_Right_Authority_request.get(1));
		Approver_username_txt().equals(create_Enhance_Right_Authority_request.get(2));
		Approver_department_txt().equals(create_Enhance_Right_Authority_request.get(5));
		Approver_applicant_type_txt().equals(create_Enhance_Right_Authority_request.get(6));
		Approver_Overview_applicant_number_txt().equals(create_Enhance_Right_Authority_request.get(7));
		Approver_Overview_Target_ECU_ID_txt().equals(create_Enhance_Right_Authority_request.get(8));
		Approver_Overview_Service_IDs_txt().equals(create_Enhance_Right_Authority_request.get(9));
		Approver_Overview_Validity_txt().equals(create_Enhance_Right_Authority_request.get(11));
		Approver_Overview_approval_status_txt().equals(create_Enhance_Right_Authority_request.get(0));
		Approver_Overview__DiagAuth_Certificatetxt().equals(create_Enhance_Right_Authority_request.get(10));
		Approver_Overview_Reason_for_Rejection_txt().equals(create_Enhance_Right_Authority_request.get(13));
		Approver_Overview_request_date_txt().equals(create_Enhance_Right_Authority_request.get(14));
		Approver_Overview_approval_date_txt().equals(create_Enhance_Right_Authority_request.get(15));

	}
	public void approverOverviewPage_for_Enhance_right_authority(HashMap<String, String> input) throws Throwable {
		approver_Overview_enabled1();
		Authorization_roledropdown("Enhance Right");
		Thread.sleep(2000);
		complete_btn();
		Thread.sleep(2000);
		String id = input.get("Application Number");
		search_here(id);
//		Approver_Overview_Requester_ID_txt().equals(create_Enhance_Right_Authority_request.get(1));
//		Approver_username_txt().equals(create_Enhance_Right_Authority_request.get(2));
//		Approver_department_txt().equals(create_Enhance_Right_Authority_request.get(5));
//		Approver_applicant_type_txt().equals(create_Enhance_Right_Authority_request.get(6));
//		Approver_Overview_applicant_number_txt().equals(create_Enhance_Right_Authority_request.get(7));
//		Approver_Overview_Target_ECU_ID_txt().equals(create_Enhance_Right_Authority_request.get(8));
//		Approver_Overview_Service_IDs_txt().equals(create_Enhance_Right_Authority_request.get(9));
//		Approver_Overview_Validity_txt().equals(create_Enhance_Right_Authority_request.get(11));
//		Approver_Overview_approval_status_txt().equals(create_Enhance_Right_Authority_request.get(0));
//		Approver_Overview__DiagAuth_Certificatetxt().equals(create_Enhance_Right_Authority_request.get(10));
//		Approver_Overview_Reason_for_Rejection_txt().equals(create_Enhance_Right_Authority_request.get(13));
//		Approver_Overview_request_date_txt().equals(create_Enhance_Right_Authority_request.get(14));
//		Approver_Overview_approval_date_txt().equals(create_Enhance_Right_Authority_request.get(15));

	}

	public String reject_Enhance_right_Request(Object object, String authorization_value, String reason,
			List<Object> create_Enhance_Right_Authority_request) throws Throwable {
		approverOverviewPage_for_Enhance_right_authority(object, authorization_value,
				create_Enhance_Right_Authority_request);
		approver_Overview_reject();
		reason_for_rejection(reason);
		String done_status = change_request_status();
		if (done_status.trim().equals("Done")) {
			test.info("status changed to done");
		}
		approval_status = Approver_Overview_approval_status_txt();
		return approval_status;
	}
	
	public String reject_Enhance_right_Request(String reason) throws Throwable {
	
		approver_Overview_reject();
		reason_for_rejection(reason);
		String done_status = change_request_status();
		if (done_status.trim().equals("Done")) {
			test.info("status changed to done");
		}
		approval_status = Approver_Overview_approval_status_txt();		
		refresh();
		return approval_status;
	}

	public String approve_replacement_Package_Request(String user_type, String status, String authorization,
			List<String> create_replacement_package_request) throws Throwable {
		approverOverviewPage_for_replacement_package(authorization, user_type, create_replacement_package_request);
		approve_Request(status);
		test.pass("Approver is able to approve the request");
		reset_filter();
		reset_filter();
		String done_status = change_request_status();
		if (done_status.trim().equals("Done")) {
			test.info("status changed to done");
		}
		approval_status = Approver_Overview_approval_status_txt();
		return approval_status;
	}

	public void approverOverviewPage_for_replacement_package(String authorization, String type,
			List<String> create_replacement_package_request) throws Throwable {
		approver_Overview_enabled1();
		Authorization_roledropdown(authorization);
		User_type(type);
		complete_btn();
		search_here(create_replacement_package_request.get(5));
		Thread.sleep(3000);
		Approver_Overview_Requester_ID_txt().equals(create_replacement_package_request.get(1));
		Approver_username_txt().equals(create_replacement_package_request.get(2));
		Approver_department_txt().equals(create_replacement_package_request.get(3));
		Approver_applicant_type_txt().equals(create_replacement_package_request.get(4));
		Approver_Overview_applicant_number_txt().equals(create_replacement_package_request.get(5));
		Approver_Overview__Origin_COT_txt().equals(create_replacement_package_request.get(6));
		Approver_Overview_Target_COT_txt().equals(create_replacement_package_request.get(7));
		Approver_Overview_ECU_Qualifier_txt().equals(create_replacement_package_request.get(8));
		Approver_Overview_approval_status_txt().equals(create_replacement_package_request.get(0));
		Approver_Overview_Replacement_Package_Request_txt().equals(create_replacement_package_request.get(9));
		Approver_Overview_Reason_for_Rejection_txt().equals(create_replacement_package_request.get(10));
		Approver_Overview_request_date_txt().equals(create_replacement_package_request.get(11));
		Approver_Overview_approval_date_txt().equals(create_replacement_package_request.get(12));

	}

	public String reject_replacement_package_Request(String reason, String authorization, String user_type,
			List<String> create_replacement_package_request) throws Throwable {
		approverOverviewPage_for_replacement_package(authorization, user_type, create_replacement_package_request);
		approver_Overview_reject();
		Thread.sleep(3000);
		reason_for_rejection(reason);
		Thread.sleep(3000);
		String done_status = change_request_status();
		if (done_status.trim().equals("Done")) {
			test.info("status changed to done");
		}
		approval_status = Approver_Overview_approval_status_txt();
		return approval_status;
	}

	public String approvethenestT_Request(String authorization, String status,
			List<String> create_special_cases_nestT_request) throws Throwable {
		approverOverviewPage_for_NestT(authorization, create_special_cases_nestT_request);
		Thread.sleep(3000);
		approve_Request(status);
		test.pass("Approver is able to approve the request");
		Thread.sleep(3000);
		reset_filter();
		reset_filter();
		String done_status = change_request_status();
		if (done_status.trim().equals("Done")) {
			test.info("status changed to done");
		}
		approval_status = Approver_Overview_approval_status_txt();
		return approval_status;
	}
	
	public String approve_Multiple_nestT_Request(String authorization,String request_type, String status) throws Throwable {
		
		req.request_Overview();
		req.select_request_type(request_type);
		search_here(prop.getUser_name());
		filter_search(prop.getStatus_pending());
		List<String > applicantNumber = new ArrayList<>();
		
		for(WebElement element : Approver_Overview_applicant_numbers_txt) {
			if(!element.getText().isEmpty()){
			applicantNumber.add(element.getText());}
		}
		logger.info(applicantNumber);
		for(String id:applicantNumber) {
		approver_Overview_enabled1();
		refresh();
		Thread.sleep(8000);
		Authorization_roledropdown(authorization);
		search_here(id);
		approve_Request(status);
				test.pass("Approver is able to approve the request");
				reset_filter();
				reset_filter();
				String done_status = change_request_status();
				if (done_status.trim().equals("Done")) {
					test.info("status changed to done");
				}
		}	
				
		
		approval_status = Approver_Overview_approval_status_txt();
		return approval_status;
	}

	public String multiple_Approve_Request(String authorization,String status,List<String> applicantNumber) throws Throwable {
		for(String id:applicantNumber) {
			approver_Overview_enabled1();
			refresh();
			Thread.sleep(8000);
			Authorization_roledropdown(authorization);
			search_here(id);
			approve_Request(status);
			test.pass("Approver is able to approve the request");
			reset_filter();
			reset_filter();
			String done_status = change_request_status();
			if (done_status.trim().equals("Done")) {
				test.info("status changed to done");
			}		
		}
			approval_status = Approver_Overview_approval_status_txt();
			return approval_status;
		}

	
	public void approverOverviewPage_for_NestT(String authorization, List<String> create_special_cases_nestT_request)
			throws Throwable {
		approver_Overview_enabled1();
		Thread.sleep(3000);
		Thread.sleep(3000);
		Authorization_roledropdown(authorization);
//		if (create_special_cases_nestT_request.get(4).equals("Internal")) {
//			internal_type();
//		} else if (create_special_cases_nestT_request.get(4).equals("External")) {
//			external_type();
//		} else {
//			supplier_type();
//		}
		complete_btn();
		search_here(prop.getUser_name());
		Thread.sleep(3000);
//		Approver_Overview_Requester_ID_txt().equals(create_special_cases_nestT_request.get(1));
//		Approver_username_txt().equals(create_special_cases_nestT_request.get(2));
//		Approver_department_txt().equals(create_special_cases_nestT_request.get(3));
//		Approver_applicant_type_txt().equals(create_special_cases_nestT_request.get(4));
//		Approver_Overview_applicant_number_txt().equals(create_special_cases_nestT_request.get(5));
//		Approver_Overview_ECU_Qualifier_txt().equals(create_special_cases_nestT_request.get(7));
//		Approver_Overview_approval_status_txt().equals(create_special_cases_nestT_request.get(5));
//		Approver_Overview_Reason_for_NestT_Request_NestT().equals(create_special_cases_nestT_request.get(6));
//		Approver_Overview_Reason_for_Rejection_txt().equals(create_special_cases_nestT_request.get(8));
//		Approver_Overview_request_date_txt().equals(create_special_cases_nestT_request.get(9));
//		Approver_Overview_approval_date_txt().equals(create_special_cases_nestT_request.get(10));
	}

	public String rejecttheNestT_Request(String reason, String authorization,
			List<String> create_special_cases_nestT_request) throws Throwable {
		approverOverviewPage_for_NestT(authorization, create_special_cases_nestT_request);
		approver_Overview_reject();
		Thread.sleep(3000);
		reason_for_rejection(reason);
		Thread.sleep(3000);
		String done_status = change_request_status();
		if (done_status.trim().equals("Done")) {
			test.info("status changed to done");
		}
		approval_status = Approver_Overview_approval_status_txt();
		return approval_status;
	}

	public String approvetheFR_Request_MyDeputy(String application, String authorization_value, String status)
			throws Throwable {
		approver_Overview_enabled1();
		Authorization_roledropdown(authorization_value);
		supplier_type();
		complete_btn();
		search_here(application);
		approve_Request(status);
		reset_filter();
		reset_filter();
		test.pass("APprover is able to approve the request");
		String done_status = change_request_status();
		if (done_status.trim().equals("Done")) {
			test.info("status changed to done");
		}
		approval_status = Approver_Overview_approval_status_txt();
		return approval_status;
	}

	public void not_able_to_view_FR_request(String application, String authorization_value) throws Throwable {
		approver_Overview_enabled1();
		Thread.sleep(3000);
		Thread.sleep(3000);
		Authorization_roledropdown(authorization_value);
		Thread.sleep(200);
		supplier_type();
		complete_btn();
		search_here(application);
		not_able_to_view_request();
	}

	public String approveTechnical_user_Request(String authorization_value, String username, String status,
			List<Object> string) throws Throwable {
		Thread.sleep(3000);
		approverOverviewPage_for_Technical_user(authorization_value, username, string);
		Thread.sleep(3000);
		try {
			Thread.sleep(3000);
			approve_Request(status);
			reset_filter();
			reset_filter();
			test.pass("APprover is able to approve the request");
			Thread.sleep(3000);
			String done_status = change_request_status();
			if (done_status.trim().equals("Done")) {
				test.info("status changed to done");
			}
		} catch (StaleElementReferenceException e) {
			Thread.sleep(3000);
			approve_Request1(status);
			reset_filter();
			reset_filter();
			test.pass("APprover is able to approve the request");
			Thread.sleep(3000);
			String done_status = change_request_status();
			if (done_status.trim().equals("Done")) {
				test.info("status changed to done");
			}
		}

		approval_status = Approver_Overview_approval_status_txt();
		if (Approver_Overview_Functional_role_txt().equals("Production")) {
			Approver_Overview_standard_permission_cert_txt().equals("Production,After-Sales STANDARD");
		} else {
			Approver_Overview_standard_permission_cert_txt().equals("Global, TCU");
		}

		return approval_status;
	}

	public void approverOverviewPage_for_Technical_user(String authorization_value, String user_name,
			List<Object> string) throws Throwable {
		approver_Overview_enabled1();
		Thread.sleep(3000);
		Thread.sleep(3000);
		Authorization_roledropdown(authorization_value);
		technical_user_type();
		complete_btn();
		search_here(user_name);
		Approver_Overview_Requester_ID_txt().equals(string.get(2));
		Approver_Overview_Usertype_txt().equals(string.get(3));
		Approver_department_txt().equals(string.get(6));
		Approver_applicant_type_txt().equals(string.get(7));
		Approver_Overview_applicant_number_txt().equals(string.get(1));
		Approver_Overview_Functional_role_txt().equals(string.get(8));
		Approver_Overview_reason_for_Functional_Role_Request_txt().equals(string.get(16));
		Approver_Overview_approval_status_txt().equals(string.get(0));
		Approver_Overview_standard_permission_cert_txt().equals(string.get(15));
		Approver_Overview_request_date_txt().equals(string.get(13));
		approval_date_txt = Approver_Overview_approval_date_txt();
		approval_date_txt.equals(string.get(14));
		Thread.sleep(3000);

	}

	public String approveFOTA_Request(Object object, String status, List<String> request_Overview_table_FOTA)
			throws Throwable {
		approverOverviewPage_for_FOTA(object, request_Overview_table_FOTA);
		Thread.sleep(3000);
		approve_Request(status);
		test.pass("APprover is able to approve the request");
		Thread.sleep(3000);
		reset_filter();
		reset_filter();
		String done_status = change_request_status();
		if (done_status.trim().equals("Done")) {
			test.info("status changed to done");
		}
		approval_status = Approver_Overview_approval_status_txt();
		return approval_status;
	}

	public void approverOverviewPage_for_FOTA(Object object, List<String> request_Overview_table_FOTA)
			throws Throwable {
		approver_Overview_enabled1();
		Authorization_roledropdown("FOTA");
		complete_btn();
		search_here((String) object);
		Thread.sleep(3000);
		Approver_Overview_Requester_ID_txt().equals(request_Overview_table_FOTA.get(1));
		Approver_username_txt().equals(request_Overview_table_FOTA.get(2));
		Approver_department_txt().equals(request_Overview_table_FOTA.get(5));
		Approver_applicant_type_txt().equals(request_Overview_table_FOTA.get(6));
		Approver_Overview_applicant_number_txt().equals(request_Overview_table_FOTA.get(7));
		Approver_Overview_Diagnostic_Permission_txt().equals(request_Overview_table_FOTA.get(8));
		Approver_Overview_ECU_Qualifier_txt().equals(request_Overview_table_FOTA.get(9));
		Approver_Overview_Additional_Service_IDs_txt().equals(request_Overview_table_FOTA.get(10));
		Approver_Overview_Permission_Validity_Days_txt().equals(request_Overview_table_FOTA.get(11));
	//	Approver_Overview_Permission_Validity_Status_txt().equals(request_Overview_table_FOTA.get(12));
		Approver_Overview_Enhance_Cert_validity_txt().equals(request_Overview_table_FOTA.get(13));
		Approver_Overview_Reason_for_FOTA_Request_txt().equals(request_Overview_table_FOTA.get(14));
		Approver_Overview_approval_status_txt().equals(request_Overview_table_FOTA.get(0));
		Approver_Overview_Reason_for_Rejection_txt().equals(request_Overview_table_FOTA.get(16));
		Approver_Overview_request_date_txt().equals(request_Overview_table_FOTA.get(17));
		Approver_Overview_approval_date_txt().equals(request_Overview_table_FOTA.get(18));

	}

	public String reject_Technical_user_Request(String reason, String authorization_value,
			String functional_role_selected, List<Object> functional_role_table_validation_for_Technical_user)
			throws Throwable {
		approverOverviewPage(authorization_value, functional_role_table_validation_for_Technical_user,
				functional_role_selected);
		approver_Overview_reject();
		reason_for_rejection(reason);
		String done_status = change_request_status();
		if (done_status.trim().equals("Done")) {
			test.info("status changed to done");
		}
		approval_status = Approver_Overview_approval_status_txt();
		Approver_Overview_standard_permission_cert_txt().trim().equals("N/A");
		return approval_status;
	}

	public String approve_special_enhanced_right_Request(String authorization_value, String status,
			List<String> create_DA_request) throws Throwable {
		approverOverviewPage_for_special_enhanced_right(authorization_value, create_DA_request);
		approve_Request(status);
		test.pass("Approver is able to approve the request");
		Thread.sleep(3000);
		String done_status = change_request_status();
		if (done_status.trim().equals("Done")) {
			test.info("status changed to done"); 
		}
		approval_status = Approver_Overview_approval_status_txt();
		return approval_status;
	}

	public String approve_Update_Functional_Role(String authorization_value, String status,
			List<String> create_DA_request) throws Throwable {
//		approverOverviewPage_for_update_functional_role(authorization_value, create_DA_request);
		approver_Overview_enabled1();
		Thread.sleep(3000);
		approve_Request(status);
		test.pass("APprover is able to approve the request");
		Thread.sleep(3000);
		reset_filter();
		reset_filter();
//		String done_status = change_request_status();
//		if (done_status.trim().equals("Done")) {
//			test.info("status changed to done");
//		}
		approval_status = Approver_Overview_approval_status_txt();
		return approval_status;
	}
	

	public void approverOverviewPage_for_special_enhanced_right(String authorization_value,
			List<String> create_DA_request) throws Throwable {
		approver_Overview_enabled1();
		Thread.sleep(3000);
		refresh();

		Thread.sleep(3000);
		Authorization_roledropdown(authorization_value);
		complete_btn();
		search_here(create_DA_request.get(5));
		Thread.sleep(3000);
	}

	
	public void approverOverviewPage_for_Special_Access(String authorization_value,
			String publisher) throws Throwable {
		approver_Overview_enabled1();
		Thread.sleep(3000);
		refresh();
		Thread.sleep(3000);
		Authorization_roledropdown(authorization_value);
		complete_btn();
		search_here(publisher);
		Thread.sleep(3000);
		approve_Request("PENDING");
	}
	public void approverOverviewPage_for_update_functional_role(String authorization_value,
			List<String> create_DA_request) throws Throwable {
		approver_Overview_enabled1();
		Thread.sleep(3000);
//		Thread.sleep(3000);
//		Authorization_roledropdown(authorization_value);
		complete_btn();
		search_here(create_DA_request.get(5));
		Thread.sleep(3000);
		Approver_Overview_Requester_ID_txt().equals(create_DA_request.get(1));
		Approver_username_txt().equals(create_DA_request.get(2));
		Approver_department_txt().equals(create_DA_request.get(3));
		Approver_Overview_applicant_number_txt().equals(create_DA_request.get(4));
		Action_Type_txt().equals(create_DA_request.get(5));
		Approver_Overview_Functional_role_txt().equals(create_DA_request.get(6));
		Approver_Overview_ECU_Qualifier_txt().equals(create_DA_request.get(8));
		Approver_Overview_approval_status_txt().equals(create_DA_request.get(0));
		Reason_for_Updating_Functional_Role_Request_txt().equals(create_DA_request.get(7));
		Approver_Overview_Reason_for_Rejection_txt().equals(create_DA_request.get(9));
		Approver_Overview_request_date_txt().equals(create_DA_request.get(10));
		Approver_Overview_approval_date_txt().equals(create_DA_request.get(11));

	}

	public String approveOnboard_new_ECU_Request(String application_number, String user_type, String status,
			List<Object> request_Overview_table_validation) throws Throwable {
		approverOverviewPage_for_OnBoard_new_ECU(application_number, user_type, request_Overview_table_validation);
		Thread.sleep(3000);
		approve_Request(status);
		test.pass("APprover is able to approve the request");
		reset_filter();
		reset_filter();
		String done_status = change_request_status();
		if (done_status.trim().equals("Done")) {
			test.info("status changed to done");
		}
		approval_status = Approver_Overview_approval_status_txt();
		return approval_status;
	}

	public void approverOverviewPage_for_OnBoard_new_ECU(String status, String user_type,
			List<Object> request_Overview_table_validation) throws Throwable {
		approver_Overview_enabled1();
		Authorization_roledropdown("Onboard New ECU");
		User_type(user_type);
		complete_btn();
		search_here(request_Overview_table_validation.get(1).toString());
		Approver_Overview_Requester_ID_txt().equals(request_Overview_table_validation.get(2));
		Approver_username_txt().equals(request_Overview_table_validation.get(3));
		Approver_department_txt().equals(request_Overview_table_validation.get(4));
		Approver_applicant_type_txt().equals(request_Overview_table_validation.get(5));
		Approver_Overview_applicant_number_txt().equals(request_Overview_table_validation.get(1));
		Approver_Overview_ECU_Qualifier_txt().equals(request_Overview_table_validation.get(6));
		Approver_Overview_approval_status_txt().equals(request_Overview_table_validation.get(0));
		Approver_Overview_ECU_Owner_txt().equals(request_Overview_table_validation.get(7));
		Approver_Overview_Supplier_Name_txt().equals(request_Overview_table_validation.get(8));
		Approver_Overview_Status_GTC_Acceptance_txt().equals(request_Overview_table_validation.get(9));
		Approver_Overview_Supplier_Responsible_txt().equals(request_Overview_table_validation.get(10));
		Approver_Overview_CS_Architect_Component_txt().equals(request_Overview_table_validation.get(11));
		Approver_Overview_Reason_for_Rejection_txt().equals(request_Overview_table_validation.get(12));
		Approver_Overview_request_date_txt().equals(request_Overview_table_validation.get(13));
		Approver_Overview_approval_date_txt().equals(request_Overview_table_validation.get(14));

	}

	public String rejecttheOnboard_new_ECU_Request(String reason, String status, String user_type,
			List<Object> request_Overview_table_validation) throws Throwable {
		SoftAssert s = new SoftAssert();
		approverOverviewPage_for_OnBoard_new_ECU(status, user_type, request_Overview_table_validation);
		approver_Overview_reject();
		reason_for_rejection(reason);
		String done_status = change_request_status();
		s.assertEquals(done_status.trim(), "Done");
		approval_status = Approver_Overview_approval_status_txt();
		return approval_status;
	}

	public String approveECU_Certificate_Request(String object, String authorization_value, String status,
			List<String> create_ECU_Cert_request) throws Throwable {
		approverOverviewPage_for_ECU_certificate_request(object, authorization_value, create_ECU_Cert_request);
		approve_Request(status);
		test.pass("APprover is able to approve the request");
		reset_filter();
		reset_filter();
		String done_status = change_request_status();
		if (done_status.trim().equals("Done")) {
			test.info("status changed to done");
		}
		approval_status = Approver_Overview_approval_status_txt();
		return approval_status;
	}
	
	public String approveECU_Certificate_Request_for_more_than_one(Object object, String authorization_value, String status,
			List<List<String>> request_Overview_table_values_ECU_certificate_request_for_more_than_one, String ecu) throws Throwable {
		approverOverviewPage_for_ECU_certificate_request_for_more_than_one(object, authorization_value, request_Overview_table_values_ECU_certificate_request_for_more_than_one,ecu);
		search_ECU(ecu);
		approve_Request(status);
		test.pass("APprover is able to approve the request");
		reset_filter();
		reset_filter();
		search_ECU(ecu);
		filter_search("APPROVED");
		String done_status = change_request_status();
		if (done_status.trim().equals("Done")) {
			test.info("status changed to done");
		}
		approval_status = Approver_Overview_approval_status_txt();
		return approval_status;
	}
	
	public String approveECU_Certificate_Request_for_grouping(Object object, String authorization_value, String status,
			List<List<String>> request_Overview_table_values_ECU_certificate_request_for_more_than_one, Object object2) throws Throwable {
		approverOverviewPage_for_ECU_certificate_request_for_grouping(object, authorization_value, request_Overview_table_values_ECU_certificate_request_for_more_than_one,object2);
		search_ECU(object2.toString());
		approve_Request(status);
		test.pass("APprover is able to approve the request");
		reset_filter();
		reset_filter();
		search_ECU(object2.toString());
		String done_status = change_request_status();
		if (done_status.trim().equals("Done")) {
			test.info("status changed to done");
		}
		approval_status = Approver_Overview_approval_status_txt();
		return approval_status;
	}

	public void approverOverviewPage_for_ECU_certificate_request(String application_num, String authorization_value,
			List<String> create_ECU_Cert_request) throws Throwable {
		approver_Overview_enabled1();
		Authorization_roledropdown(authorization_value);
		complete_btn();
		search_here(application_num);
		// Approver_overview_list_of_columns(authorization_value,
		// create_ECU_Cert_request.get(4));
		Approver_Overview_Requester_ID_txt().equals(create_ECU_Cert_request.get(1));
		Approver_username_txt().equals(create_ECU_Cert_request.get(2));
		Approver_department_txt().equals(create_ECU_Cert_request.get(3));
		Approver_applicant_type_txt().equals(create_ECU_Cert_request.get(4));
		Approver_Overview_applicant_number_txt().equals(create_ECU_Cert_request.get(5));
		Approver_Overview_COT_txt().equals(create_ECU_Cert_request.get(6));
		Approver_Overview_approval_status_txt().equals(create_ECU_Cert_request.get(0));
		Approver_Overview_ECU_Qualifier_txt().equals(create_ECU_Cert_request.get(7));
		Approver_Overview_ECU_Qualifier_Group_txt().equals(create_ECU_Cert_request.get(8));
		// Approver_Overview_KMS_System_IP_Address_txt().equals(create_ECU_Cert_request.get(9));
		Request_Overview_Reason_for_ECU_Certificate_Request_txt().equals(create_ECU_Cert_request.get(10));
		Approver_Overview_Reason_for_Rejection_txt().equals(create_ECU_Cert_request.get(11));
		Approver_Overview_request_date_txt().equals(create_ECU_Cert_request.get(12));
		Approver_Overview_approval_date_txt().equals(create_ECU_Cert_request.get(13));

	}
	
	public void approverOverviewPage_for_ECU_certificate_request_for_more_than_one(Object object, String authorization_value,
			List<List<String>> request_Overview_table_values_ECU_certificate_request_for_more_than_one, String ecu) throws Throwable {
		approver_Overview_enabled1();
		Authorization_roledropdown(authorization_value);
		complete_btn();
		search_here(ecu);
		// Approver_overview_list_of_columns(authorization_value,
		// create_ECU_Cert_request.get(4));
		List<List<String>> secondTableValues = BaseClass.getTableValuesExcludingLastColumn(driver,
				By.xpath("//table/tbody"));
		boolean allFirstTableValuesPresentInSecondTable = BaseClass.checkFirstTableValuesPresenceSkippingCertainColumns(
				 request_Overview_table_values_ECU_certificate_request_for_more_than_one, secondTableValues);
		if (allFirstTableValuesPresentInSecondTable) {
			test.info("All values from the first table are present in the second table.");
		} else {
			test.info("Not all values from the first table are present in the second table.");
		}

	}
	
	public void approverOverviewPage_for_ECU_certificate_request_for_grouping(Object object, String authorization_value,
			List<List<String>> request_Overview_table_values_ECU_certificate_request_for_more_than_one, Object object2) throws Throwable {
		approver_Overview_enabled1();
		Authorization_roledropdown(authorization_value);
		complete_btn();
		search_here(object2.toString());
		// Approver_overview_list_of_columns(authorization_value,
		// create_ECU_Cert_request.get(4));
		List<List<String>> secondTableValues = BaseClass.getTableValuesExcludingLastColumn(driver,
				By.xpath("//table/tbody"));
		boolean allFirstTableValuesPresentInSecondTable = BaseClass.checkFirstTableValuesPresenceSkippingCertainColumns(
				 request_Overview_table_values_ECU_certificate_request_for_more_than_one, secondTableValues);
		if (allFirstTableValuesPresentInSecondTable) {
			test.info("All values from the first table are present in the second table.");
		} else {
			test.info("Not all values from the first table are present in the second table.");
		}

	}

	public void Approver_overview_list_of_columns(String authorization, String applicant) {
		waitForWebElementToAppear(approver_Overview_title);
		waitForWebElementToAppear(approver_txt);
		waitForWebElementToAppear(approver_info_txt);
		waitForWebElementToAppear(authorization_txt);
		waitForWebElementToAppear(dynmaic_xpath(authorization));
		waitForWebElementToAppear(applicant_type);
		waitForWebElementToAppear(dynmaic_xpath(applicant));
		waitForWebElementToAppear(change_view_txt);
		waitForWebElementToAppear(condensed_btn);
		waitForWebElementToAppear(complete_btn);
		waitForWebElementToAppear(Approver_Overview_Requester_id);
		waitForWebElementToAppear(Approver_Overview_Department);
		waitForWebElementToAppear(Approver_Overview_Applicant_Type);
		waitForWebElementToAppear(Approver_Overview_Application_Number);
		waitForWebElementToAppear(Approver_Overview_Approval_Status);
		waitForWebElementToAppear(Approver_Overview_Reason_for_Rejection);
		waitForWebElementToAppear(Approver_Overview_Request_Date);
		waitForWebElementToAppear(Approver_Overview_Approval_Date);
		waitForWebElementToAppear(Approver_Overview_Change_Request_Status);
		if (authorization.equals("Functional Role")) {
			if (applicant.equalsIgnoreCase("External") || applicant.equalsIgnoreCase("Internal")) {
				waitForWebElementToAppear(Approver_Overview_User_Type);
			}
			waitForWebElementToAppear(Approver_Overview_Functional_Role);
			if (applicant.equalsIgnoreCase("External") || applicant.equalsIgnoreCase("Internal")) {
				waitForWebElementToAppear(Approver_Overview_Business_Unit);
			}
			if (applicant.equalsIgnoreCase("External") || applicant.equalsIgnoreCase("Internal")) {
				waitForWebElementToAppear(Approver_Overview_Business_Unit);
			}
			if (applicant.equalsIgnoreCase("External") || applicant.equalsIgnoreCase("Supplier")) {
				waitForWebElementToAppear(Approver_Overview_Company_Name_of_the_Requester);
			}
			if (applicant.equalsIgnoreCase("Supplier")) {
				waitForWebElementToAppear(Approver_Overview_ECU_Qualifier);
			}
			waitForWebElementToAppear(Approver_Overview_Standard_Permissions_Certificate);
			waitForWebElementToAppear(Approver_Overview_Reason_for_Functional_Role_Request);
		} else if (authorization.equals("Diagnostic Authority")) {
			waitForWebElementToAppear(Approver_Overview_User_Type);
			waitForWebElementToAppear(Approver_Overview_username);
			waitForWebElementToAppear(Approver_Overview_Functional_Role);
			waitForWebElementToAppear(Approver_Overview_User_role);
			waitForWebElementToAppear(Approver_Overview_ECU_qualifier);
			waitForWebElementToAppear(Approver_Overview_Reason_for_Diagnostic_Authority_Request);
		} else if (authorization.equals("Nest T Testing")) {
			waitForWebElementToAppear(Approver_Overview_username);
			waitForWebElementToAppear(Approver_Overview_NestT_Testing_Case);
			waitForWebElementToAppear(Approver_Overview_ECU_qualifier);
			waitForWebElementToAppear(Approver_Overview_Reason_for_NestT);
		} else if (authorization.equals("Replacement Package")) {
			waitForWebElementToAppear(Approver_Overview_username);
			waitForWebElementToAppear(Approver_Overview_origin_COT);
			waitForWebElementToAppear(Approver_Overview_target_COT);
			waitForWebElementToAppear(Approver_Overview_ECU_qualifier);
			waitForWebElementToAppear(Approver_Overview_Reason_for_Replacement_Package_Request);
		} else if (authorization.equals("Enhance Right")) {
			waitForWebElementToAppear(Approver_Overview_User_Type);
			waitForWebElementToAppear(Approver_Overview_Technical_User_ID);
			waitForWebElementToAppear(Approver_Overview_username);
			waitForWebElementToAppear(Approver_Overview_Target_ECU);
			waitForWebElementToAppear(Approver_Overview_Service_ID);
			waitForWebElementToAppear(Approver_Overview_DiagAuth_Cert);
			waitForWebElementToAppear(Approver_Overview_Validity);
			waitForWebElementToAppear(Approver_Overview_Reason_for_Enhance_Right_Request);
		} else if (authorization.equals("FOTA")) {
			waitForWebElementToAppear(Approver_Overview_User_Type);
			waitForWebElementToAppear(Approver_Overview_Technical_User_ID);
			waitForWebElementToAppear(Approver_Overview_Diagnostic_Permission);
			waitForWebElementToAppear(Approver_Overview_Approval_Status);
			waitForWebElementToAppear(Approver_Overview_ECU_Qualifier);
			waitForWebElementToAppear(Approver_Overview_Additional_ServiceIDs);
			waitForWebElementToAppear(Approver_Overview_Permission_Validity);
			waitForWebElementToAppear(Approver_Overview_Permission_Validity_Status);
			waitForWebElementToAppear(Approver_Overview_Enhance_Cert_validity);
			waitForWebElementToAppear(Approver_Overview_Reason_for_FOTA_Request);
		} else if (authorization.equals("Onboard New ECU")) {
			waitForWebElementToAppear(Approver_Overview_username);
			waitForWebElementToAppear(Approver_Overview_ECU_qualifier);
			waitForWebElementToAppear(Approver_Overview_ECU_Owner);
			waitForWebElementToAppear(Approver_Overview_Supplier_Name);
			waitForWebElementToAppear(Approver_Overview_Status_GTC_Acceptance);
			waitForWebElementToAppear(Approver_Overview_Supplier_Responsible);
			waitForWebElementToAppear(Approver_Overview_CS_Architect);
		} else if (authorization.equals("ECU Certificate Request")) {
			waitForWebElementToAppear(Approver_Overview_username);
			waitForWebElementToAppear(Approver_Overview_COT);
			waitForWebElementToAppear(Approver_Overview_ECU_Qualifier);
			waitForWebElementToAppear(Approver_Overview_ECU_Qualifier_Group);
			waitForWebElementToAppear(Approver_Overview_KMS_System_IP_Address);
			waitForWebElementToAppear(Approver_Overview_Reason_for_ECU_Certificate_Request);
		}
	}
	
public void Reject_Request_Approval(String value,String id) throws InterruptedException {
		approver_Overview_enabled1();
		Authorization_roledropdown(value);
		search_here(id);
		complete_btn();
		Scrollright_waitForWebElementToAppear(Approver_Overview_Request_Date);
		Thread.sleep(1000);
		waitForelementToBeClickable(reject);
		click(reject);
		Thread.sleep(1000);	
		rejectiontxt("Reject");
		waitForWebElementToAppear(Submit);
		click(Submit);
		}
public void Reject_Request(String id) throws InterruptedException {	
	approver_Overview_enabled1();
	search_here(id);
	complete_btn();
	Scrollright_waitForWebElementToAppear(Approver_Overview_Request_Date);
	Thread.sleep(1000);
	waitForelementToBeClickable(reject);
	reject.click();
	Thread.sleep(1000);	
	rejectiontxt("Reject");
	waitForWebElementToAppear(Submit);
	click(Submit);
}





}