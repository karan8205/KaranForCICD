package DAMS.PageObjects;

import DAMS.ObjectManager.PageObjectManager;

import DAMS.Resources.AbstractComponents;
import DAMS.Resources.BaseClass;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static DAMS.Resources.Listeners.test;

public class Request_overview_page extends AbstractComponents {
	WebDriver driver;
	public static Logger logger = Logger.getLogger("DAMS");

	String user_ID;
	String username;
	String department;
	String applicant_type_txt;
	String applicant_number;
	String Approval_status;
	String Request_date;
	String Approval_date;
	String Reason_for_Rejection;
	String Functional_role_txt;
	String User_role_txt;
	String ECU_Qualifier_txt;
	String Reason_for_Diagnostic_Authority_Request_txt;
	String requester_ID;
	String usertype;
	String Target_ECU_ID;
	String Service_ID_txt;
	String DiagAuth_Cert_txt;
	String Validity_txt;
	String Reason_for_Enhance_Right_Request_txt;
	String Origin_COT_txt;
	String Target_COT_txt;
	String ECU_Qualifier_for_nestT_txt;
	String Replacement_Package_Request_txt;
	String Reason_for_nestT_testing_case_txt;
	String Diagnostic_Permission_txt;
	String Additional_Service_IDs_txt;
	String Permission_Validity_Days_txt;
	String Permission_Validity_Status_txt;
	String Enhance_Cert_validity_txt;
	String Reason_for_FOTA_Request;
	String onboard_ECU_Owner;
	String onboard_Supplier_Name;
	String onboard_Status_GTC_Acceptance;
	String onboard_Supplier_Responsible;
	String onboard_CS_Architect_Component_Name;
	String COT;
	String ECU_Qualifier_Group;
	String KMS_System_IP_Address;
	String ECU_Certificate_Request;

	public Request_overview_page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Request Overview']")
	private WebElement request_Overview;

	@FindBy(xpath = "//mat-grid-tile-header[text()=\" Certificate Overview\"]")
	private WebElement Certificate_Overview;

	@FindBy(xpath = "//label[text()=\"Applicant\"]")
	private WebElement request_Overview_applicant;
	
	@FindBy(xpath = "//span[text()='Refresh']")
	private WebElement refresh_button;

	@FindBy(xpath = "//span[text()=\"All \"]")
	private WebElement request_Overview_all;

	@FindBy(xpath = "//span[text()=\"Myself \"]")
	private WebElement Certificate_Overview_myself;

	@FindBy(xpath = "//mat-label[text()='Request Type']")
	private WebElement request_Overview_request_type;

	@FindBy(xpath = "//mat-select[@role=\"combobox\"]")
	private WebElement request_type_drpdwn;
	//mat-select[@role=\"combobox\"]
	@FindBy(xpath = "(//mat-select[@role=\"combobox\"])[2]")
	private WebElement requesttypedrpdwn;

	@FindBy(xpath = "//span[@class=\"mdc-list-item__primary-text\"]")
	private List<WebElement> request_drpdwn_option;

	@FindBy(xpath = "//span[text()=\"Enhance Right\"]")
	private WebElement enhance_Right;

	@FindBy(xpath = "//span[text()=\"Diagnostic Authority\"]")
	private WebElement Diagnostic_Authority;

	@FindBy(xpath = "//label[text()=\"Status\"]")
	private WebElement enhance_Right_status;

	@FindBy(xpath = "//span[text()=\"All \"]")
	private WebElement request_overview_ALL;

	@FindBy(xpath = "//span[text()=\"Pending \"]")
	private WebElement request_overview_pending;

	@FindBy(xpath = "//span[text()=\"Approved \"]")
	private WebElement request_overview_Approved;

	@FindBy(xpath = "//span[text()=\"Rejected \"]")
	private WebElement request_overview_Rejected;

	@FindBy(xpath = "//span[text()=\"Reset\"]")
	private WebElement request_overview_Reset;

	@FindBy(xpath = "//span[text()=\"Refresh\"]")
	private WebElement request_overview_Refresh;

	@FindBy(xpath = "//span[text()=\"Reset Filters\"]")
	private WebElement request_overview_Reset_Filters;

	@FindBy(xpath = "//input[contains(@placeholder,\"Search\")]")
	private WebElement search_here;

	@FindBy(xpath = "//div[text()=\"Requester ID\"]")
	private WebElement Request_Overview_Requester_id;

	@FindBy(xpath = "//div[text()=\"User Type\"]")
	private WebElement Request_Overview_user_type;

	@FindBy(xpath = "//div[text()=\"Service Principal ID\"]")
	private WebElement Request_Overview_user_id;

	@FindBy(xpath = "//div[text()=\"Username\"]")
	private WebElement Request_Overview_username;

	@FindBy(xpath = "//div[text()=\"Department\"]")
	private WebElement Request_Overview_department;

	@FindBy(xpath = "//div[text()=\"Applicant Type\"]")
	private WebElement Request_Overview_applicant_type;

	@FindBy(xpath = "//div[text()=\"Application Number\"]")
	private WebElement Request_Overview_applicant_number;

	@FindBy(xpath = "//div[text()=\"DiagAuth Certificate\"]")
	private WebElement Request_Overview_DiagAuth_Cert;

	@FindBy(xpath = "(//div[text()=\"Functional Role\"])[1]")
	private WebElement Request_Overview_Functional_Role;

	@FindBy(xpath = "//div[text()=\"Nest-T Testing Case\"]")
	private WebElement Request_Overview_NestT;

	@FindBy(xpath = "//div[text()=\"User Role\"]")
	private WebElement Request_Overview_User_role;

	@FindBy(xpath = "//div[text()=\"ECU Qualifier (Diagnostic)\"]")
	private WebElement Request_Overview_ECU_Qualifier;

	@FindBy(xpath = "//div[text()=\"ECU Qualifier\"]")
	private WebElement Request_Overview_ECU_Qualifier_nestT;

	@FindBy(xpath = "//div[text()=\"Target ECU ID\"]")
	private WebElement Request_Overview_Target_ECU;

	@FindBy(xpath = "//div[text()=\"Diagnostic Authority\"]")
	private WebElement Request_Overview_Diagnostic_Permission;
	
	@FindBy(xpath = "//div[text()=\"Diagnostic Permission\"]")
	private WebElement Request_Overview_Diagnostic_Permission_FOTA;

	@FindBy(xpath = "//div[text()=\"Additional Service IDs\"]")
	private WebElement Request_Overview_Additional_ServiceIDs;

	@FindBy(xpath = "//div[text()=\"Permission Validity (Days)\"]")
	private WebElement Request_Overview_Permission_Validity;

	@FindBy(xpath = "//div[text()=\"Permission Validity Status\"]")
	private WebElement Request_Overview_Permission_Validity_Status;

	@FindBy(xpath = "//div[text()=\"Enhance Cert validity (Days)\"]")
	private WebElement Request_Overview_Enhance_Cert_validity;

	@FindBy(xpath = "//div[text()=\"Reason for FOTA Request\"]")
	private WebElement Request_Overview_Reason_for_FOTA_Request;
	
	@FindBy(xpath = "//*[text()='ECU Certificate Request']")
	private WebElement ECU_Certificate_Request_btn;

	@FindBy(xpath = "//div[text()=\"Service IDs\"]")
	private WebElement Request_Overview_Service_ID;

	@FindBy(xpath = "//div[text()=\"Approval Status\"]")
	private WebElement Request_Overview_Approval_status;

	@FindBy(xpath = "//div[text()=\"ECU Owner\"]")
	private WebElement Request_Overview_ECU_Owner;

	@FindBy(xpath = "//div[text()=\"Supplier Name\"]")
	private WebElement Request_Overview_Supplier_Name;

	@FindBy(xpath = "//div[text()=\"Status GTC Acceptance\"]")
	private WebElement Request_Overview_Status_GTC_Acceptance;

	@FindBy(xpath = "//div[text()=\"Supplier Responsible\"]")
	private WebElement Request_Overview_Supplier_Responsible;

	@FindBy(xpath = "//div[text()=\"CS Architect Component Name\"]")
	private WebElement Request_Overview_CS_Architect;

	@FindBy(xpath = "//div[text()=\"Request Date\"]")
	private WebElement Request_Overview_Request_Date;

	@FindBy(xpath = "//div[text()=\"Approval Date\"]")
	private WebElement Request_Overview_Approval_Date;

	@FindBy(xpath = "//div[text()=\"COT\"]")
	private WebElement Request_Overview_COT;

	@FindBy(xpath = "//div[text()=\"ECU Qualifier Group\"]")
	private WebElement Request_Overview_ECU_Qualifier_Group;

	@FindBy(xpath = "//div[text()=\"KMS System IP Address\"]")
	private WebElement Request_Overview_KMS_System_IP_Address;

	@FindBy(xpath = "//div[text()=\"Reason for ECU Certificate Request\"]")
	private WebElement Request_Overview_Reason_for_ECU_Certificate_Request;

	@FindBy(xpath = "//div[text()=\"Reason for Request\"]")
	private WebElement Request_Overview_Reason_for_Diag_Auth_Request;

	@FindBy(xpath = "//div[text()='Reason for Request']")
	private WebElement Request_Overview_Reason_for_NestT_Request;

	@FindBy(xpath = "//div[text()='Reason for Request']")
	private WebElement Request_Overview_Reason_for_Enhance_Right_Request;

	@FindBy(xpath = "//div[text()=\"Validity (Days)\"]")
	private WebElement Request_Overview_Validity;

	@FindBy(xpath = "//div[text()=\"Reason for Rejection\"]")
	private WebElement Request_Overview_Reason_for_Rejection;

	@FindBy(xpath = "//div[text()=\"Origin COT\"]")
	private WebElement Request_Overview_Origin_COT;

	@FindBy(xpath = "//div[text()=\"Target COT\"]")
	private WebElement Request_Overview_Target_COT;

	@FindBy(xpath = "//div[text()='Reason for Request']")
	private WebElement Request_Overview_Replacement_Package_Request;

	@FindBy(xpath = "//table/tbody/tr/td")
	private WebElement Request_Overview_requester_Id_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Username\")]")
	private WebElement Request_Overview_username_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"User-Type \")]")
	private WebElement Request_Overview_Usertype_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Service-Principal-ID \")]")
	private WebElement Request_Overview_Technical_User_id_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Department\")]")
	private WebElement Request_Overview_department_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Applicant-Type\")]")
	private WebElement Request_Overview_applicant_type_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Functional-Role \")]")
	private WebElement Request_Overview_Functional_role_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"User-Role \")]")
	private WebElement Request_Overview_User_role_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"ECU-Qualifier--Diagnostic\")]")
	private WebElement Request_Overview_ECU_Qualifier_txt;

	@FindBy(xpath = "//td[contains(@class,'Reason-for-Request')]")
	private WebElement Request_Overview_Reason_for_Diagnostic_Authority_Request_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Reason-for-Nest-T\")]")
	private WebElement Request_Overview_Reason_for_nestT_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"ECU-Qualifier\")]")
	private WebElement Request_Overview_ECU_Qualifier_for_nestT_txt;
	
	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Target-ECU-ID \")]")
	private WebElement Request_Overview_ECU_Qualifier_for_ER_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Nest-T-Testing-Case \")]")
	private WebElement Request_Overview_Reason_for_nestT_testing_case_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"ECU-Owner \")]")
	private WebElement Request_Overview_onboard_ECU_Owner;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Supplier-Name \")]")
	private WebElement Request_Overview__onboard_Supplier_Name;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Status-GTC-Acceptance \")]")
	private WebElement Request_Overview__onboard_Status_GTC_Acceptance;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Supplier-Responsible \")]")
	private WebElement Request_Overview__onboard_Supplier_Responsible;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"CS-Architect-Component-Name \")]")
	private WebElement Request_Overview__onboard_CS_Architect_Component_Name;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"COT\")]")
	private WebElement Request_Overview_COT_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Application-Number \")]")
	private WebElement Request_Overview_applicant_number_txt;
	
	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Application-Number \")]")
	private List<WebElement> Request_Overview_applicant_numbers_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"ECU-Qualifier-Group \")]")
	private WebElement Request_Overview_ECU_Qualifier_Group_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"KMS-System-IP-Address \")]")
	private WebElement Request_Overview_KMS_System_IP_Address_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Reason-for-ECU-Certificate-Request \")]")
	private WebElement Request_Overview_Reason_for_ECU_Certificate_Request_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"DiagAuth-Certificate\")]")
	private WebElement Request_Overview_DiagAuth_Cert_txt;
	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,'User-Role')]")
	private List<WebElement> Request_Overview_userRole_txts;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Target-ECU-ID\")]")
	private WebElement Request_Overview_Target_ECU_ID_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Service-IDs\")]")
	private WebElement Request_Overview_Service_ID_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Approval-Status\")]")
	private WebElement Request_Overview_Approval_status_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Request-Date\")]")
	private WebElement Request_Overview_Request_date_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Approval-Date\")]")
	private WebElement Request_Overview_Approval_date_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,'Reason-for-Request')]")
	private WebElement Request_Overview_Reason_for_Enhance_Right_Request_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Reason-for-Rejection\")]")
	private WebElement Request_Overview_Reason_for_Rejection_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Approval-Status\")]")
	private WebElement Request_Overview_approval_status_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Approval-Date\")]")
	private WebElement FR_Overview_Approval_date_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Reason-for-Rejection\")]")
	private WebElement FR_Overview_Approver_Reason_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Origin-COT \")]")
	private WebElement Request_Overview_Origin_COT_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Target-COT \")]")
	private WebElement Request_Overview_Target_COT_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Diagnostic-Permission \")]")
	private WebElement Request_Overview_Diagnostic_Permission_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Additional-Service-IDs \")]")
	private WebElement Request_Overview_Additional_Service_IDs_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Permission-Validity--Days\")]")
	private WebElement Request_Overview_Permission_Validity_Days_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Permission-Validity-Status \")]")
	private WebElement Request_Overview_Permission_Validity_Status_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Enhance-Cert-validity\")]")
	private WebElement Request_Overview_Enhance_Cert_validity_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Reason-for-FOTA-Request \")]")
	private WebElement Request_Overview_Reason_for_FOTA_Request_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,'Reason-for-Request ')]")
	private WebElement Request_Overview_Replacement_Package_Request_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Validity--Days\")]")
	private WebElement Request_Overview_Validity_txt;

	@FindBy(xpath = "//span[text()=\"Technical User \"]")
	private WebElement Request_Overview_Technical_User;

	@FindBy(xpath = "//span[text()=\"Review\"]")
	private WebElement Request_Overview_review_button;

	@FindBy(xpath = "//span[text()=\" Reviewed\"]")
	private WebElement Request_Overview_reviewed_txt;
	
	@FindBy(xpath = "//p[text()='Approval Level 2']")
	private WebElement ApprovalLevel2;
	
	@FindBy(xpath = "//span[text()='Close']")
	private WebElement CloseHyperlink;
	
	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Approval-Status\")]//button")
	private static WebElement Request_Overview_approval_status_txt_link;
	
	@FindBy(xpath = "(//mat-select[@role=\"combobox\"])[1]")
	private static WebElement RequestOvewview_ApplicantType;
	
	

	public void request_Overview() throws InterruptedException {
		Thread.sleep(5000);
		waitForelementToBeClickable(request_Overview);
		Thread.sleep(4000);
		click(request_Overview);
		Thread.sleep(2000);
	}

	public void request_type_drpdwn() {
		request_type_drpdwn.click();
	}

	public void enhance_Right() {
		enhance_Right.click();
	}

	public void Diag_Auth() {
		clickJS(Diagnostic_Authority);
	}

	public void request_overview_pending() {
//		clickJS(request_overview_pending);
		request_overview_pending.click();
	}
	
	public void search_here(String object) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		search_here.clear();
		search_here.sendKeys(object);
		type(search_here, Keys.ENTER);
	}
	
	public void scrollForReason() throws InterruptedException {
		if(Request_Overview_Reason_for_Diag_Auth_Request.isEnabled()) {
			Scrollright_waitForWebElementToAppear(Request_Overview_Reason_for_Diag_Auth_Request);
			Thread.sleep(2000);
		}
	}

	public void search_here_UserID(Object values) {
		type(search_here, values);
	}
	public void select_Enhance_Right() {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		waitForWebElementToAppear(requesttypedrpdwn);
		clickJS(requesttypedrpdwn);
		waitForWebElementToAppear(enhance_Right);
		click(enhance_Right);

		
	}
	
	public String onBoard_Request_Validation(String request_Type) throws InterruptedException, AWTException {
		
		request_Overview();
		select_request_type(request_Type);
        String	applicant_number=Request_Overview_applicant_number_txt();
		search_here(applicant_number);
		Thread.sleep(1000);	
		refresh_button.click();
		Thread.sleep(3000);
		waitForWebElementToAppear(Request_Overview_approval_status_txt);
		click(Request_Overview_approval_status_txt);
		Thread.sleep(3000);
		click(CloseHyperlink);
	    return applicant_number;
	}

	public void Certificate_Overview() {
		waitForWebElementToAppear(Certificate_Overview);
		waitForWebElementToAppear(Request_Overview_applicant_type);
		waitForWebElementToAppear(request_Overview_request_type);
		waitForWebElementToAppear(request_overview_Refresh);
		waitForWebElementToAppear(request_overview_Reset_Filters);
		waitForWebElementToAppear(search_here);
	}

	public void Certificate_Overview__list_of_Column_Diag_Auth() {
		waitForWebElementToAppear(Request_Overview_Requester_id);
		waitForWebElementToAppear(Request_Overview_username);
		waitForWebElementToAppear(Request_Overview_user_type);
		waitForWebElementToAppear(Request_Overview_user_id);
		waitForWebElementToAppear(Request_Overview_department);
		waitForWebElementToAppear(Request_Overview_applicant_type);
		waitForWebElementToAppear(Request_Overview_Functional_Role);
		waitForWebElementToAppear(Request_Overview_applicant_number);
		waitForWebElementToAppear(Request_Overview_User_role);
		waitForWebElementToAppear(Request_Overview_ECU_Qualifier);
		waitForWebElementToAppear(Request_Overview_Approval_status);
		waitForWebElementToAppear(Request_Overview_Reason_for_Diag_Auth_Request);
		waitForWebElementToAppear(Request_Overview_Reason_for_Rejection);
		waitForWebElementToAppear(Request_Overview_Request_Date);
		waitForWebElementToAppear(Request_Overview_Approval_Date);

	}

	public void Certificate_Overview__list_of_Column_replacement_package() {
		waitForWebElementToAppear(Request_Overview_Requester_id);
		waitForWebElementToAppear(Request_Overview_username);
		waitForWebElementToAppear(Request_Overview_department);
		waitForWebElementToAppear(Request_Overview_applicant_type);
		waitForWebElementToAppear(Request_Overview_applicant_number);
		waitForWebElementToAppear(Request_Overview_Origin_COT);
		waitForWebElementToAppear(Request_Overview_Target_COT);
		waitForWebElementToAppear(Request_Overview_Approval_status);
		waitForWebElementToAppear(Request_Overview_ECU_Qualifier_nestT);
		waitForWebElementToAppear(Request_Overview_Replacement_Package_Request);
		waitForWebElementToAppear(Request_Overview_Reason_for_Rejection);
		waitForWebElementToAppear(Request_Overview_Request_Date);
		waitForWebElementToAppear(Request_Overview_Approval_Date);

	}

	public void Certificate_Overview__list_of_Column_NestT() {
		waitForWebElementToAppear(Request_Overview_Requester_id);
		waitForWebElementToAppear(Request_Overview_username);
		waitForWebElementToAppear(Request_Overview_department);
		waitForWebElementToAppear(Request_Overview_applicant_type);
		waitForWebElementToAppear(Request_Overview_applicant_number);
		waitForWebElementToAppear(Request_Overview_NestT);
		waitForWebElementToAppear(Request_Overview_Approval_status);
		waitForWebElementToAppear(Request_Overview_ECU_Qualifier_nestT);
		waitForWebElementToAppear(Request_Overview_Reason_for_NestT_Request);
		waitForWebElementToAppear(Request_Overview_Reason_for_Rejection);
		waitForWebElementToAppear(Request_Overview_Request_Date);
		waitForWebElementToAppear(Request_Overview_Approval_Date);

	}

	public void Certificate_Overview__list_of_Column_Enhanced_Right() {
		//hari
////		requesttypedrpdwn.click();
//		clickJS(requesttypedrpdwn);
////		enhance_Right.click();
//		clickJS(enhance_Right);
//		//
		waitForWebElementToAppear(Request_Overview_Requester_id);
		waitForWebElementToAppear(Request_Overview_username);
		waitForWebElementToAppear(Request_Overview_user_type);
		waitForWebElementToAppear(Request_Overview_user_id);
		waitForWebElementToAppear(Request_Overview_department);
		waitForWebElementToAppear(Request_Overview_applicant_type);
		waitForWebElementToAppear(Request_Overview_applicant_number);
		waitForWebElementToAppear(Request_Overview_Target_ECU);
		waitForWebElementToAppear(Request_Overview_Approval_status);
		waitForWebElementToAppear(Request_Overview_Service_ID);
		waitForWebElementToAppear(Request_Overview_DiagAuth_Cert);
		waitForWebElementToAppear(Request_Overview_Validity);
		waitForWebElementToAppear(Request_Overview_Reason_for_Enhance_Right_Request);
		waitForWebElementToAppear(Request_Overview_Reason_for_Rejection);
		waitForWebElementToAppear(Request_Overview_Request_Date);
		waitForWebElementToAppear(Request_Overview_Approval_Date);

	}

	public void Certificate_Overview__list_of_Column_FOTA() {
		waitForWebElementToAppear(Request_Overview_Requester_id);
		waitForWebElementToAppear(Request_Overview_username);
		waitForWebElementToAppear(Request_Overview_user_type);
		waitForWebElementToAppear(Request_Overview_user_id);
		waitForWebElementToAppear(Request_Overview_department);
		waitForWebElementToAppear(Request_Overview_applicant_type);
		waitForWebElementToAppear(Request_Overview_applicant_number);
		waitForWebElementToAppear(Request_Overview_Diagnostic_Permission_FOTA);
		waitForWebElementToAppear(Request_Overview_Approval_status);
		waitForWebElementToAppear(Request_Overview_ECU_Qualifier_nestT);
		waitForWebElementToAppear(Request_Overview_Additional_ServiceIDs);
		waitForWebElementToAppear(Request_Overview_Permission_Validity);
	//	waitForWebElementToAppear(Request_Overview_Permission_Validity_Status);
		waitForWebElementToAppear(Request_Overview_Enhance_Cert_validity);
		waitForWebElementToAppear(Request_Overview_Reason_for_FOTA_Request);
		waitForWebElementToAppear(Request_Overview_Reason_for_Rejection);
		waitForWebElementToAppear(Request_Overview_Request_Date);
		waitForWebElementToAppear(Request_Overview_Approval_Date);

	}

	public void Certificate_Overview__list_of_Column_onboard_new_ECU() {
		waitForWebElementToAppear(Request_Overview_Requester_id);
		waitForWebElementToAppear(Request_Overview_username);
		waitForWebElementToAppear(Request_Overview_department);
		waitForWebElementToAppear(Request_Overview_applicant_type);
		waitForWebElementToAppear(Request_Overview_applicant_number);
		waitForWebElementToAppear(Request_Overview_ECU_Qualifier_nestT);
		waitForWebElementToAppear(Request_Overview_Approval_status);
		waitForWebElementToAppear(Request_Overview_ECU_Owner);
		waitForWebElementToAppear(Request_Overview_Supplier_Name);
		waitForWebElementToAppear(Request_Overview_Status_GTC_Acceptance);
		waitForWebElementToAppear(Request_Overview_Supplier_Responsible);
		waitForWebElementToAppear(Request_Overview_CS_Architect);
		waitForWebElementToAppear(Request_Overview_Reason_for_Rejection);
		waitForWebElementToAppear(Request_Overview_Request_Date);
		waitForWebElementToAppear(Request_Overview_Approval_Date);

	}

	public void request_Overview_Review_button_ECU_Cert() {
		try {
			if (Request_Overview_reviewed_txt.isDisplayed()) {
				waitForWebElementToAppear(Request_Overview_reviewed_txt);
			}
		} catch (Exception e) {
			clickJS(Request_Overview_review_button);
			waitForWebElementToAppear(Request_Overview_review_button);
		}
	}

	public String Request_Overview_user_Id_txt() {
		waitForWebElementToAppear(Request_Overview_Technical_User_id_txt);
		return Request_Overview_Technical_User_id_txt.getText().trim();

	}

	public String Request_Overview_requester_Id_txt() {
		waitForWebElementToAppear(Request_Overview_requester_Id_txt);
		return Request_Overview_requester_Id_txt.getText().trim();

	}

	public String Request_Overview_username_txt() {
		waitForWebElementToAppear(Request_Overview_username_txt);
		return Request_Overview_username_txt.getText().trim();

	}

	public String Request_Overview_usertype_txt() {
		waitForWebElementToAppear(Request_Overview_Usertype_txt);
		return Request_Overview_Usertype_txt.getText().trim();

	}

	public String Request_Overview_department_txt() {
		waitForWebElementToAppear(Request_Overview_department_txt);
		return Request_Overview_department_txt.getText().trim();

	}

	public String Request_Overview_applicant_type_txt() {
		waitForWebElementToAppear(Request_Overview_applicant_type_txt);
		return Request_Overview_applicant_type_txt.getText().trim();

	}

	public String Request_Overview_applicant_number_txt() {
		waitForWebElementToAppear(Request_Overview_applicant_number_txt);
		return Request_Overview_applicant_number_txt.getText().trim();

	}

	public String Request_Overview_DiagAuth_Cert_txt() {
		waitForWebElementToAppear(Request_Overview_DiagAuth_Cert_txt);
		return Request_Overview_DiagAuth_Cert_txt.getText().trim();

	}

	public String Request_Overview_Target_ECU_ID_txt() {
		waitForWebElementToAppear(Request_Overview_Target_ECU_ID_txt);
		return Request_Overview_Target_ECU_ID_txt.getText().trim();

	}

	public String Request_Overview_Service_ID_txt() {
		waitForWebElementToAppear(Request_Overview_Service_ID_txt);
		return Request_Overview_Service_ID_txt.getText().trim();

	}

	public String Request_Overview_Approval_status_txt() {
		waitForWebElementToAppear(Request_Overview_Approval_status_txt);
		return Request_Overview_Approval_status_txt.getText().trim();

	}

	public String Request_Overview_Request_date_txt() {
		waitForWebElementToAppear(Request_Overview_Request_date_txt);
		return Request_Overview_Request_date_txt.getText().trim();

	}

	public String Request_Overview_Approval_date_txt() {
		waitForWebElementToAppear(Request_Overview_Approval_date_txt);
		return Request_Overview_Approval_date_txt.getText().trim();

	}

	public String Request_Overview_Reason_for_Enhance_Right_Request_txt() {
		waitForWebElementToAppear(Request_Overview_Reason_for_Enhance_Right_Request_txt);
		return Request_Overview_Reason_for_Enhance_Right_Request_txt.getText().trim();

	}

	public String Request_Overview_Reason_for_Rejection_txt() {
		waitForWebElementToAppear(Request_Overview_Reason_for_Rejection_txt);
		return Request_Overview_Reason_for_Rejection_txt.getText().trim();

	}

	public String approval_status_txt() {
		waitForWebElementToAppear(Request_Overview_approval_status_txt);
		return Request_Overview_approval_status_txt.getText().trim();

	}

	public String Approval_date_txt() {
		waitForWebElementToAppear(FR_Overview_Approval_date_txt);
		return FR_Overview_Approval_date_txt.getText().trim();

	}

	public String Approver_Reason_txt() {
		waitForWebElementToAppear(FR_Overview_Approver_Reason_txt);
		return FR_Overview_Approver_Reason_txt.getText().trim();

	}

	public String Request_Overview_Functional_role_txt() {
		waitForWebElementToAppear(Request_Overview_Functional_role_txt);
		return Request_Overview_Functional_role_txt.getText().trim();
	}

	public String Request_Overview_User_role_txt() {
		waitForWebElementToAppear(Request_Overview_User_role_txt);
		return Request_Overview_User_role_txt.getText().trim();

	}

	public String Request_Overview_ECU_Qualifier_txt() throws InterruptedException {
		refresh();
		Thread.sleep(5000);
		waitForWebElementToAppear(Request_Overview_ECU_Qualifier_txt);
		return Request_Overview_ECU_Qualifier_txt.getText().trim();

	}
	
	public String Request_Overview_ECU_Qualifier_for_ER_txt() {
		waitForWebElementToAppear(Request_Overview_ECU_Qualifier_for_ER_txt);
		return Request_Overview_ECU_Qualifier_for_ER_txt.getText().trim();

	}

	public String Request_Overview_Reason_for_Diagnostic_Authority_Request_txt() {
		waitForWebElementToAppear(Request_Overview_Reason_for_Diagnostic_Authority_Request_txt);
		return Request_Overview_Reason_for_Diagnostic_Authority_Request_txt.getText().trim();

	}

	public String Request_Overview_Reason_for_nestT_txt() {
		waitForWebElementToAppear(Request_Overview_Reason_for_nestT_txt);
		return Request_Overview_Reason_for_nestT_txt.getText().trim();

	}

	public String Request_Overview_Reason_for_Requester_ID_txt() {
		waitForWebElementToAppear(Request_Overview_Reason_for_nestT_testing_case_txt);
		return Request_Overview_Reason_for_nestT_testing_case_txt.getText().trim();

	}

	public String Request_Overview_Reason_for_nestT_testing_case_txt() {
		waitForWebElementToAppear(Request_Overview_Reason_for_nestT_testing_case_txt);
		return Request_Overview_Reason_for_nestT_testing_case_txt.getText().trim();

	}

	public String Request_Overview_ECU_Qualifier_for_nestT_txt() {
		waitForWebElementToAppear(Request_Overview_ECU_Qualifier_for_nestT_txt);
		return Request_Overview_ECU_Qualifier_for_nestT_txt.getText().trim();

	}

	public String Request_Overview_onboard_ECU_Owner() {
		waitForWebElementToAppear(Request_Overview_onboard_ECU_Owner);
		return Request_Overview_onboard_ECU_Owner.getText().trim();

	}

	public String Request_Overview_onboard_Supplier_Name() {
		waitForWebElementToAppear(Request_Overview__onboard_Supplier_Name);
		return Request_Overview__onboard_Supplier_Name.getText().trim();

	}

	public String Request_Overview__onboard_Status_GTC_Acceptance() {
		waitForWebElementToAppear(Request_Overview__onboard_Status_GTC_Acceptance);
		return Request_Overview__onboard_Status_GTC_Acceptance.getText().trim();

	}

	public String Request_Overview__onboard_Supplier_Responsible() {
		waitForWebElementToAppear(Request_Overview__onboard_Supplier_Responsible);
		return Request_Overview__onboard_Supplier_Responsible.getText().trim();

	}

	public String Request_Overview__onboard_CS_Architect_Component_Name() {
		waitForWebElementToAppear(Request_Overview__onboard_CS_Architect_Component_Name);
		return Request_Overview__onboard_CS_Architect_Component_Name.getText().trim();

	}

	public String Request_Overview_Origin_COT_txt() {

		waitForWebElementToAppear(Request_Overview_Origin_COT_txt);
		return Request_Overview_Origin_COT_txt.getText().trim();

	}

	public String Request_Overview_Additional_Service_IDs_txt() {

		waitForWebElementToAppear(Request_Overview_Additional_Service_IDs_txt);
		return Request_Overview_Additional_Service_IDs_txt.getText().trim();

	}

	public String Request_Overview_Permission_Validity_Days_txt() {

		waitForWebElementToAppear(Request_Overview_Permission_Validity_Days_txt);
		return Request_Overview_Permission_Validity_Days_txt.getText().trim();

	}

	public String Request_Overview_Permission_Validity_Status_txt() {

		waitForWebElementToAppear(Request_Overview_Permission_Validity_Status_txt);
		return Request_Overview_Permission_Validity_Status_txt.getText().trim();

	}

	public String Request_Overview_Enhance_Cert_validity_txt() {

		waitForWebElementToAppear(Request_Overview_Enhance_Cert_validity_txt);
		return Request_Overview_Enhance_Cert_validity_txt.getText().trim();

	}

	public String Request_Overview_Reason_for_FOTA_Request() {

		waitForWebElementToAppear(Request_Overview_Reason_for_FOTA_Request_txt);
		return Request_Overview_Reason_for_FOTA_Request_txt.getText().trim();

	}

	public String Request_Overview_Diagnostic_Permission_txt() {

		waitForWebElementToAppear(Request_Overview_Diagnostic_Permission_txt);
		return Request_Overview_Diagnostic_Permission_txt.getText().trim();

	}

	public String Request_Overview_Target_COT_txt() {

		waitForWebElementToAppear(Request_Overview_Target_COT_txt);
		return Request_Overview_Target_COT_txt.getText().trim();

	}

	public String Request_Overview_Replacement_Package_Request_txt() {

		waitForWebElementToAppear(Request_Overview_Replacement_Package_Request_txt);
		return Request_Overview_Replacement_Package_Request_txt.getText().trim();

	}

	public String Request_Overview_Validity_txt() {

		waitForWebElementToAppear(Request_Overview_Validity_txt);
		return Request_Overview_Validity_txt.getText().trim();

	}

	public String Request_Overview_COT_txt() {
		waitForWebElementToAppear(Request_Overview_COT_txt);
		return Request_Overview_COT_txt.getText().trim();

	}

	public String Request_Overview_ECU_Qualifier_Group_txt() {
		waitForWebElementToAppear(Request_Overview_ECU_Qualifier_Group_txt);
		return Request_Overview_ECU_Qualifier_Group_txt.getText().trim();

	}

	public String Request_Overview_KMS_System_IP_Address_txt() {
		waitForWebElementToAppear(Request_Overview_KMS_System_IP_Address_txt);
		return Request_Overview_KMS_System_IP_Address_txt.getText().trim();

	}

	public String Request_Overview_Reason_for_ECU_Certificate_Request_txt() {
		waitForWebElementToAppear(Request_Overview_Reason_for_ECU_Certificate_Request_txt);
		return Request_Overview_Reason_for_ECU_Certificate_Request_txt.getText().trim();

	}


	
	
	
	public void select_request_type(String request_type) throws InterruptedException, AWTException {
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		waitForWebElementToAppear(request_type_drpdwn);
//		clickJS(request_type_drpdwn);
//		Thread.sleep(1000);
//		Thread.sleep(3000);
//		logger.info(request_type);
//		clickelementmatchingtext(request_drpdwn_option, request_type);
//		Thread.sleep(3000);
//		Thread.sleep(1000);
//		hari
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		waitForWebElementToAppear(requesttypedrpdwn);
		Thread.sleep(2000);
		clickJS(requesttypedrpdwn);
		Thread.sleep(2000);
		logger.info(request_type);
		clickelementmatchingtext(request_drpdwn_option, request_type);
	}
	public void select_Applicant_type(String applicant_type) throws InterruptedException, AWTException {
//		hari
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		waitForWebElementToAppear(RequestOvewview_ApplicantType);
		clickJS(RequestOvewview_ApplicantType);	
		Thread.sleep(1000);
		logger.info(applicant_type);
		clickelementmatchingtext(request_drpdwn_option, applicant_type);
	}

	public String clickelementmatchingtext(List<WebElement> elements, String request_type) throws InterruptedException {
		String usertype1 = null;
		for (int i = 0; i < elements.size(); i++) {
			WebElement txt = elements.get(i);
			String usertype = txt.getText();
			if (usertype.equals(request_type)) {
				usertype1 = usertype;
				clickJS(txt);
				Thread.sleep(1000);
			}
		}
		return usertype1;
	}
	
	public void select_applicant_type(String applicant_type) {
		if (applicant_type.equals("Technical User")) {
			clickJS(Request_Overview_Technical_User);
		}
	}

	public void click_review_button() {
		clickJS(Request_Overview_review_button);
		waitForWebElementToAppear(Request_Overview_reviewed_txt);
	}

	public List<String> request_Overview_table_validation(Object values, String applicant_type) throws InterruptedException {
		request_Overview();
		Certificate_Overview();
		select_applicant_type(applicant_type);
		search_here_UserID(values);
		Certificate_Overview__list_of_Column_Diag_Auth();
//		Assert.assertNotEquals(Request_Overview_requester_Id_txt(), "N/A", "Requester_Id");
//		Assert.assertNotEquals(Request_Overview_usertype_txt(), "N/A", "user_type");
//		Assert.assertNotEquals(Request_Overview_username_txt(), "N/A", "username");
//		Assert.assertNotEquals(Request_Overview_user_Id_txt(), "N/A", "User Id");
//		Assert.assertNotEquals(Request_Overview_applicant_type_txt(), "N/A", "applicant_type");
//		Assert.assertNotEquals(Request_Overview_applicant_number_txt(), "N/A", "applicant_number");
//		Assert.assertNotEquals(Request_Overview_Functional_role_txt(), "N/A", "Functional_role");
//		Assert.assertEquals(Request_Overview_Approval_status_txt(), "PENDING", "approval_status");
		if (Request_Overview_Functional_role_txt().equals("Development ENHANCED")
				|| Request_Overview_Functional_role_txt().equals("Production")) {
			Assert.assertNotEquals(Request_Overview_ECU_Qualifier_txt(), "N/A", "ECu Qualifier");
		}
		Assert.assertEquals(Request_Overview_Reason_for_Rejection_txt(), "N/A", "Reason for rejection");
		//Assert.assertEquals(Request_Overview_Request_date_txt(), BaseClass.todays_date(), "request_date");
		Assert.assertNotEquals(Request_Overview_Reason_for_Diagnostic_Authority_Request_txt(), "N/A",
				"reason_for_request");
		requester_ID = Request_Overview_requester_Id_txt();
		username = Request_Overview_username_txt();
		department = Request_Overview_department_txt();
		applicant_type_txt = Request_Overview_applicant_type_txt();
		applicant_number = Request_Overview_applicant_number_txt();
		Approval_status = Request_Overview_Approval_status_txt();
		Reason_for_Rejection = Request_Overview_Reason_for_Rejection_txt();
		Request_date = Request_Overview_Request_date_txt();
		Approval_date = Request_Overview_Approval_date_txt();
		usertype = Request_Overview_usertype_txt();
		user_ID = Request_Overview_user_Id_txt();
		Functional_role_txt = Request_Overview_Functional_role_txt();
		ECU_Qualifier_txt = Request_Overview_ECU_Qualifier_txt();
		User_role_txt = Request_Overview_User_role_txt();
		Reason_for_Diagnostic_Authority_Request_txt = Request_Overview_Reason_for_Diagnostic_Authority_Request_txt();
		return Arrays.asList(Approval_status, requester_ID, username, department, applicant_type_txt, applicant_number,
				Reason_for_Rejection, Request_date, Approval_date, usertype, user_ID, Functional_role_txt,
				ECU_Qualifier_txt, User_role_txt, Reason_for_Diagnostic_Authority_Request_txt);
	}

	public List<Object> request_Overview_table_validation_for_Enhanced_right(String request_type, String userID,
			String applicant_type, List<Object> request_Overview_enabled) throws Throwable {
		request_Overview();
		Certificate_Overview();
		select_applicant_type(applicant_type);
		select_request_type(request_type);
		search_here_UserID(userID);
		Certificate_Overview__list_of_Column_Enhanced_Right();
		requester_ID = Request_Overview_requester_Id_txt();
		username = Request_Overview_username_txt();
		usertype = Request_Overview_usertype_txt();
		user_ID = Request_Overview_user_Id_txt();
		department = Request_Overview_department_txt();
		applicant_type_txt = Request_Overview_applicant_type_txt();
		applicant_number = Request_Overview_applicant_number_txt();
		Target_ECU_ID = Request_Overview_Target_ECU_ID_txt();
		Approval_status = Request_Overview_Approval_status_txt();
		Service_ID_txt = Request_Overview_Service_ID_txt();
		DiagAuth_Cert_txt = Request_Overview_DiagAuth_Cert_txt();
		Validity_txt = Request_Overview_Validity_txt();
		
		Reason_for_Enhance_Right_Request_txt = Request_Overview_Reason_for_Enhance_Right_Request_txt();
		Reason_for_Rejection = Request_Overview_Reason_for_Rejection_txt();
		Request_date = Request_Overview_Request_date_txt();
		Approval_date = Request_Overview_Approval_date_txt();
		return Arrays.asList(Approval_status, requester_ID, username, usertype, user_ID, department, applicant_type_txt,
				applicant_number, Target_ECU_ID, Service_ID_txt, DiagAuth_Cert_txt, Validity_txt,
				Reason_for_Enhance_Right_Request_txt, Reason_for_Rejection, Request_date, Approval_date,request_Overview_enabled.get(1),request_Overview_enabled.get(2));
	}

	public List<Object> request_Overview_table_validation_for_Enhanced_right_for_TU(String request_type, String userID,String applicant_type) throws Throwable {
		request_Overview();
		Certificate_Overview();
		select_applicant_type(applicant_type);
		select_request_type(request_type);
		search_here_UserID(userID);
		Certificate_Overview__list_of_Column_Enhanced_Right();
		requester_ID = Request_Overview_requester_Id_txt();
		username = Request_Overview_username_txt();
		usertype = Request_Overview_usertype_txt();
		user_ID = Request_Overview_user_Id_txt();
		department = Request_Overview_department_txt();
		applicant_type_txt = Request_Overview_applicant_type_txt();
		applicant_number = Request_Overview_applicant_number_txt();
		Target_ECU_ID = Request_Overview_Target_ECU_ID_txt();
		Approval_status = Request_Overview_Approval_status_txt();
		Service_ID_txt = Request_Overview_Service_ID_txt();
		DiagAuth_Cert_txt = Request_Overview_DiagAuth_Cert_txt();
		Validity_txt = Request_Overview_Validity_txt();
		Reason_for_Enhance_Right_Request_txt = Request_Overview_Reason_for_Enhance_Right_Request_txt();
		Reason_for_Rejection = Request_Overview_Reason_for_Rejection_txt();
		Request_date = Request_Overview_Request_date_txt();
		Approval_date = Request_Overview_Approval_date_txt();
		return Arrays.asList(Approval_status, requester_ID, username, usertype, user_ID, department, applicant_type_txt,
				applicant_number, Target_ECU_ID, Service_ID_txt, DiagAuth_Cert_txt, Validity_txt,
				Reason_for_Enhance_Right_Request_txt, Reason_for_Rejection, Request_date, Approval_date);
	}

	public List<String> request_Overview_table_validation_for_replacement_package(String request_type, String user_ID)
			throws Throwable {
		request_Overview();
		Certificate_Overview();
		select_request_type(request_type);
		req.search_here(prop.getUser_name());
		approver_overview.filter_search(prop.getStatus_pending());
		req.scrollForReason();
//		search_here_UserID(prop.getUser_name());
		Certificate_Overview__list_of_Column_replacement_package();
		requester_ID = Request_Overview_requester_Id_txt();
		username = Request_Overview_username_txt();
		department = Request_Overview_department_txt();
		applicant_type_txt = Request_Overview_applicant_type_txt();
		applicant_number = Request_Overview_applicant_number_txt();
		Origin_COT_txt = Request_Overview_Origin_COT_txt();
		Target_COT_txt = Request_Overview_Target_COT_txt();
		Approval_status = Request_Overview_Approval_status_txt();
		ECU_Qualifier_for_nestT_txt = Request_Overview_ECU_Qualifier_for_nestT_txt();
		Replacement_Package_Request_txt = Request_Overview_Replacement_Package_Request_txt();
		Reason_for_Rejection = Request_Overview_Reason_for_Rejection_txt();
		Request_date = Request_Overview_Request_date_txt();
		Approval_date = Request_Overview_Approval_date_txt();
		
		return Arrays.asList(Approval_status, requester_ID, username, department, applicant_type_txt, applicant_number,
				Origin_COT_txt, Target_COT_txt, ECU_Qualifier_for_nestT_txt, Replacement_Package_Request_txt,
				Reason_for_Rejection, Request_date, Approval_date);
	}
	
	public List<String> multiple_Request_Table_Validation_for_replacement_package(String request_type, String user_ID) throws Throwable {
		request_Overview();
		Certificate_Overview();
		select_request_type(request_type);
		req.search_here(prop.getUser_name());
		approver_overview.filter_search(prop.getStatus_pending());
		req.scrollForReason();
//		search_here_UserID(prop.getUser_name());
//		Certificate_Overview__list_of_Column_replacement_package();
		List<String> applicantNumber = getMultipleApplicantNumber();
		
		return applicantNumber;
	}

	public String navigate_to_request_Overview_page_and_verify_approval_status(String approval_status,
			String approval_date, String rejection_txt, String request_type, String user_ID) throws Throwable {
		request_Overview_page(request_type,user_ID,approval_status,approval_date,rejection_txt);
		return Request_Overview_ECU_Qualifier_for_nestT_txt();
	}
	
	public String navigate_to_request_Overview_page_and_verify_approval_status_DA(String approval_status,
			String approval_date, String rejection_txt, String request_type, String user_ID) throws Throwable {
		request_Overview_page(request_type,user_ID,approval_status,approval_date,rejection_txt);
		return Request_Overview_ECU_Qualifier_txt();
	}
	public String navigate_to_request_Overview_page_and_verify_approval_status_DA(String approval_status,
			String approval_date, String rejection_txt, String request_type, String user_ID, String userrole) throws Throwable {
		request_Overview_page(request_type,user_ID,approval_status,approval_date,rejection_txt,userrole);
		return Request_Overview_ECU_Qualifier_txt(); 
	}
	public String navigate_to_request_Overview_page_and_verify_approval_status_Service(String approval_status,
			String approval_date, String rejection_txt, String request_type, String user_ID, String userrole) throws Throwable {
		request_Overview_page_ServicePrincipal(request_type,user_ID,approval_status,approval_date,userrole);
		return Request_Overview_ECU_Qualifier_txt();
	}
	
	public String navigate_to_request_Overview_page_and_verify_approval_status_ER(String approval_status,
			String approval_date, String rejection_txt, String request_type, String id) throws Throwable {
		request_Overview_page(request_type,id,approval_status,approval_date,rejection_txt,"");
		return Request_Overview_ECU_Qualifier_for_ER_txt();
	}
	public String navigate_to_request_Overview_page_and_verify_approval_status_ER(String approval_status,
			String approval_date, String rejection_txt, String request_type, String id,String userRole) throws Throwable {
		request_Overview_page(request_type,id,approval_status,approval_date,rejection_txt,userRole);
		return Request_Overview_ECU_Qualifier_for_ER_txt();
	}

	public String navigate_to_request_Overview_page_and_verify_approval_status_RP_NestT(String approval_status,
			String approval_date, String rejection_txt, String request_type, String user_ID) throws Throwable {
		request_Overview_page(request_type,user_ID,approval_status,approval_date,rejection_txt);
		return Request_Overview_ECU_Qualifier_for_nestT_txt();
	}

	public void request_Overview_page(String request_type, String id, String approval_status,String approval_date, String rejection_txt) throws InterruptedException, Exception {
		request_Overview();
		Thread.sleep(2000);
		select_request_type(request_type);
		search_here(id);
		Thread.sleep(2000);	
		req.scrollForReason();
		Thread.sleep(1000);	
		refresh_button.click();
		Thread.sleep(3000);
		waitForWebElementToAppear(Request_Overview_approval_status_txt);
		click(Request_Overview_approval_status_txt);
		Thread.sleep(3000);
		click(ApprovalLevel2);
		Thread.sleep(3000);
		click(CloseHyperlink);
		
		}
	
	public void clickHyperLink() throws Throwable {
		req.scrollForReason();
		Thread.sleep(1000);	
		refresh_button.click();
		Thread.sleep(3000);
		waitForWebElementToAppear(Request_Overview_approval_status_txt);
		click(Request_Overview_approval_status_txt);
		Thread.sleep(3000);
		click(ApprovalLevel2);
		Thread.sleep(3000);
		click(CloseHyperlink);
	}
	public void request_Overview_page(String request_type, String id, String approval_status,String approval_date, String rejection_txt, String userrole) throws InterruptedException, Exception {
		request_Overview();
		logger.info(request_type);
		Thread.sleep(1000);
		select_request_type(request_type);
		select_Applicant_type("Myself");
		search_here(id);
		Thread.sleep(2000);	
		Scrollright_waitForWebElementToAppear(Request_Overview_approval_status_txt);	
		refresh_button.click();
		Thread.sleep(2000);
		click(Request_Overview_approval_status_txt);
		Thread.sleep(3000);
		click(CloseHyperlink);
		search_here(id);

	}
	public void request_Overview_page_ServicePrincipal(String request_type, String id, String approval_status,String approval_date, String userrole) throws InterruptedException, Exception {
		request_Overview();
		logger.info(request_type);
		Thread.sleep(1000);
		select_request_type(request_type);
	    if (!"FOTA".equals(request_type)) {
	        select_Applicant_type("Service Principal");
	    }
		search_here(id);
		Thread.sleep(2000);	
		Scrollright_waitForWebElementToAppear(Request_Overview_approval_status_txt);	
		refresh_button.click();
		Thread.sleep(2000);
		click(Request_Overview_approval_status_txt);
		Thread.sleep(3000);
		click(CloseHyperlink);
		search_here(id);

	}


	public List<String> request_Overview_table_validation_for_nestT(String request_type, String user_ID)
			throws Throwable {
		request_Overview();
		select_request_type(request_type);
		req.search_here(prop.getUser_name());
		approver_overview.filter_search(prop.getStatus_pending());
		req.scrollForReason();
		Certificate_Overview();
//		search_here_UserID(user_ID);
		Certificate_Overview__list_of_Column_NestT();
		requester_ID = Request_Overview_requester_Id_txt();
		username = Request_Overview_username_txt();
		department = Request_Overview_department_txt();
		applicant_type_txt = Request_Overview_applicant_type_txt();
		applicant_number = Request_Overview_applicant_number_txt();
		Reason_for_nestT_testing_case_txt = Request_Overview_Reason_for_nestT_testing_case_txt();
		Approval_status = Request_Overview_Approval_status_txt();
		ECU_Qualifier_for_nestT_txt = Request_Overview_ECU_Qualifier_for_nestT_txt();
		Reason_for_Rejection = Request_Overview_Reason_for_Rejection_txt();
		Request_date = Request_Overview_Request_date_txt();
		Approval_date = Request_Overview_Approval_date_txt();
		return Arrays.asList(Approval_status, requester_ID, username, department, applicant_type_txt, applicant_number,
				Reason_for_nestT_testing_case_txt, ECU_Qualifier_for_nestT_txt, Reason_for_Rejection, Request_date,
				Approval_date);
	}
	public List<String> request_Overview_table_validation_for_FOTA(String request_type, String user_ID)
			throws Throwable {
		request_Overview();
		refresh();
		Thread.sleep(1000);
		select_request_type(request_type);
		String servicePrincipalID = driver.findElement(By.xpath("//table//tr[1]/td[5]")).getText();
		req.search_here(servicePrincipalID);
		approver_overview.filter_search(prop.getStatus_pending());
		req.scrollForReason();
		Thread.sleep(2000);
		refresh_button.click();
		Thread.sleep(2000);
		Scrollright_waitForWebElementToAppear(Request_Overview_approval_status_txt_link);
		click(Request_Overview_approval_status_txt_link);
		Thread.sleep(2000);
		click(ApprovalLevel2);
		Thread.sleep(2000);
		click(CloseHyperlink);
		Certificate_Overview();
		requester_ID = Request_Overview_requester_Id_txt();
		username = Request_Overview_username_txt();
		department = Request_Overview_department_txt();
		applicant_type_txt = Request_Overview_applicant_type_txt();
		applicant_number = Request_Overview_applicant_number_txt();
//		Reason_for_nestT_testing_case_txt = Request_Overview_Reason_for_nestT_testing_case_txt();
		Approval_status = Request_Overview_Approval_status_txt();
//		ECU_Qualifier_for_nestT_txt = Request_Overview_ECU_Qualifier_for_nestT_txt();
		Reason_for_Rejection = Request_Overview_Reason_for_Rejection_txt();
		Request_date = Request_Overview_Request_date_txt();
		Approval_date = Request_Overview_Approval_date_txt();
		return Arrays.asList(Approval_status, requester_ID, username, department, applicant_type_txt, applicant_number,
				  Reason_for_Rejection, Request_date,
				Approval_date);
	}

	public void navigate_to_request_Overview_page_and_verify_approval_status_FOR_tECHNICAL_USER(String approval_status,
			String rejection_txt, String request_type, String user_ID, String applicant_type) throws Throwable {
		request_Overview();
		select_applicant_type(applicant_type);
		select_request_type(request_type);
		search_here_UserID(prop.getUser_name());
		Assert.assertEquals(Request_Overview_Approval_status_txt(), approval_status);
		Assert.assertEquals(Request_Overview_Reason_for_Rejection_txt(), rejection_txt);
	}

	public List<String> request_Overview_table_FOTA(String request_type, String userID, String applicant_type)
			throws Throwable {
		request_Overview();
		Certificate_Overview();
		select_request_type(request_type);
		Thread.sleep(1000);
		search_here_UserID("PARGAVM");
		Certificate_Overview__list_of_Column_FOTA();
		requester_ID = Request_Overview_requester_Id_txt();
		username = Request_Overview_username_txt();
		usertype = Request_Overview_usertype_txt();
		user_ID = Request_Overview_user_Id_txt();
		department = Request_Overview_department_txt();
		applicant_type_txt = Request_Overview_applicant_type_txt();
		applicant_number = Request_Overview_applicant_number_txt();
		Diagnostic_Permission_txt = Request_Overview_Diagnostic_Permission_txt();
		ECU_Qualifier_for_nestT_txt = Request_Overview_ECU_Qualifier_for_nestT_txt();
		Additional_Service_IDs_txt = Request_Overview_Additional_Service_IDs_txt();
		Permission_Validity_Days_txt = Request_Overview_Permission_Validity_Days_txt();
		Enhance_Cert_validity_txt = Request_Overview_Enhance_Cert_validity_txt();
		Reason_for_FOTA_Request = Request_Overview_Reason_for_FOTA_Request();
		Approval_status = Request_Overview_Approval_status_txt();
		Reason_for_Rejection = Request_Overview_Reason_for_Rejection_txt();
		Request_date = Request_Overview_Request_date_txt();
		Approval_date = Request_Overview_Approval_date_txt();
		return Arrays.asList(Approval_status, requester_ID, username, usertype, user_ID, department, applicant_type_txt,
				applicant_number, Diagnostic_Permission_txt, ECU_Qualifier_for_nestT_txt, Additional_Service_IDs_txt,
				Permission_Validity_Days_txt, Permission_Validity_Status_txt, Enhance_Cert_validity_txt,
				Reason_for_FOTA_Request, Approval_status, Reason_for_Rejection, Request_date, Approval_date);
	}

	public List<Object> request_Overview_table_validation_for_Onboard_new_ECU(String request_type, String userID)
			throws Throwable {
		request_Overview();
		Certificate_Overview();
		select_request_type(request_type);
		search_here_UserID(userID);
		Certificate_Overview__list_of_Column_onboard_new_ECU();
		request_Overview_Review_button_ECU_Cert();
		requester_ID = Request_Overview_requester_Id_txt();
		username = Request_Overview_username_txt();
		department = Request_Overview_department_txt();
		applicant_type_txt = Request_Overview_applicant_type_txt();
		applicant_number = Request_Overview_applicant_number_txt();
		Approval_status = Request_Overview_Approval_status_txt();
		ECU_Qualifier_for_nestT_txt = Request_Overview_ECU_Qualifier_for_nestT_txt();
		onboard_ECU_Owner = Request_Overview_onboard_ECU_Owner();
		onboard_Supplier_Name = Request_Overview_onboard_Supplier_Name();
		onboard_Status_GTC_Acceptance = Request_Overview__onboard_Status_GTC_Acceptance();
		onboard_Supplier_Responsible = Request_Overview__onboard_Supplier_Responsible();
		onboard_CS_Architect_Component_Name = Request_Overview__onboard_CS_Architect_Component_Name();
		Reason_for_Rejection = Request_Overview_Reason_for_Rejection_txt();
		Request_date = Request_Overview_Request_date_txt();
		Approval_date = Request_Overview_Approval_date_txt();
		return Arrays.asList(Approval_status, applicant_number, requester_ID, username, department, applicant_type_txt,
				ECU_Qualifier_for_nestT_txt, onboard_ECU_Owner, onboard_Supplier_Name, onboard_Status_GTC_Acceptance,
				onboard_Supplier_Responsible, onboard_CS_Architect_Component_Name, Reason_for_Rejection, Request_date,
				Approval_date);
	}

	public List<Object> is_review_button_enabled_in_request_Overview_page(String request_type, String userID)
			throws Throwable {
		request_Overview();
		Certificate_Overview();
		select_request_type(request_type);
		search_here_UserID(userID);
		Certificate_Overview__list_of_Column_onboard_new_ECU();
		request_Overview_Review_button_ECU_Cert();
		requester_ID = Request_Overview_requester_Id_txt();
		username = Request_Overview_username_txt();
		department = Request_Overview_department_txt();
		applicant_type_txt = Request_Overview_applicant_type_txt();
		applicant_number = Request_Overview_applicant_number_txt();
		Approval_status = Request_Overview_Approval_status_txt();
		ECU_Qualifier_for_nestT_txt = Request_Overview_ECU_Qualifier_for_nestT_txt();
		onboard_ECU_Owner = Request_Overview_onboard_ECU_Owner();
		onboard_Supplier_Name = Request_Overview_onboard_Supplier_Name();
		onboard_Status_GTC_Acceptance = Request_Overview__onboard_Status_GTC_Acceptance();
		onboard_Supplier_Responsible = Request_Overview__onboard_Supplier_Responsible();
		onboard_CS_Architect_Component_Name = Request_Overview__onboard_CS_Architect_Component_Name();
		Reason_for_Rejection = Request_Overview_Reason_for_Rejection_txt();
		Request_date = Request_Overview_Request_date_txt();
		Approval_date = Request_Overview_Approval_date_txt();
		if (Request_Overview_review_button.isEnabled()) {
			clickJS(Request_Overview_review_button);
		}
		return Arrays.asList(Approval_status, applicant_number, requester_ID, username, department, applicant_type_txt,
				ECU_Qualifier_for_nestT_txt, onboard_ECU_Owner, onboard_Supplier_Name, onboard_Status_GTC_Acceptance,
				onboard_Supplier_Responsible, onboard_CS_Architect_Component_Name, Reason_for_Rejection, Request_date,
				Approval_date);
	}

	public List<String> request_Overview_table_ECU_certificate_request(String request_type, String userID,
			String applicant_type) throws Throwable {
		request_Overview();
		Certificate_Overview();
		select_applicant_type(applicant_type);
		select_request_type(request_type);
		search_here_UserID(userID);
		List<List<String>> firstTableValues = BaseClass.getTableValues(driver, By.xpath("//table/tbody"));
		List<String> ECU_column_values = new ArrayList<>();
		List<WebElement> tableRows = driver.findElements(By.xpath("//table/tbody/tr"));
		for (WebElement row : tableRows) {
			String columnValue = row.findElement(By.cssSelector("td[class*=\"ECU-Qualifier \"]")).getText();
			ECU_column_values.add(columnValue);
		}
		
		requester_ID = Request_Overview_requester_Id_txt();
		username = Request_Overview_username_txt();
		department = Request_Overview_department_txt();
		applicant_type_txt = Request_Overview_applicant_type_txt();
		applicant_number = Request_Overview_applicant_number_txt();
		COT = Request_Overview_COT_txt();
		Approval_status = Request_Overview_Approval_status_txt();
		ECU_Qualifier_for_nestT_txt = Request_Overview_ECU_Qualifier_for_nestT_txt();
		ECU_Qualifier_Group = Request_Overview_ECU_Qualifier_Group_txt();
		ECU_Certificate_Request = Request_Overview_Reason_for_ECU_Certificate_Request_txt();
		Reason_for_Rejection = Request_Overview_Reason_for_Rejection_txt();
		Request_date = Request_Overview_Request_date_txt();
		Approval_date = Request_Overview_Approval_date_txt();
		return Arrays.asList(Approval_status, requester_ID, username, department, applicant_type_txt, applicant_number,
				COT, ECU_Qualifier_for_nestT_txt, ECU_Qualifier_Group, KMS_System_IP_Address, ECU_Certificate_Request,
				Reason_for_Rejection, Request_date, Approval_date);
	}
	
	public List<Object> request_Overview_table_ECU_certificate_request_for_more_than_one(String request_type, String userID,
			String applicant_type) throws Throwable {
		request_Overview();
		Certificate_Overview();
		select_applicant_type(applicant_type);
		select_request_type(request_type);
		List<String> ECU_column_values = new ArrayList<>();
		List<WebElement> tableRows = driver.findElements(By.xpath("//table/tbody/tr"));
		for (WebElement row : tableRows) {
			String columnValue = row.findElement(By.cssSelector("td[class*=\"ECU-Qualifier \"]")).getText();
			ECU_column_values.add(columnValue);
		}
		
		requester_ID = Request_Overview_requester_Id_txt();
		username = Request_Overview_username_txt();
		department = Request_Overview_department_txt();
		applicant_type_txt = Request_Overview_applicant_type_txt();
		applicant_number = Request_Overview_applicant_number_txt();
		COT = Request_Overview_COT_txt();
		Approval_status = Request_Overview_Approval_status_txt();
		ECU_Qualifier_for_nestT_txt = Request_Overview_ECU_Qualifier_for_nestT_txt();
		ECU_Qualifier_Group = Request_Overview_ECU_Qualifier_Group_txt();
		ECU_Certificate_Request = Request_Overview_Reason_for_ECU_Certificate_Request_txt();
		Reason_for_Rejection = Request_Overview_Reason_for_Rejection_txt();
		Request_date = Request_Overview_Request_date_txt();
		Approval_date = Request_Overview_Approval_date_txt();
		return Arrays.asList(Approval_status, requester_ID, username, department, applicant_type_txt, applicant_number,
				COT, ECU_Qualifier_for_nestT_txt, ECU_Qualifier_Group, KMS_System_IP_Address, ECU_Certificate_Request,
				Reason_for_Rejection, Request_date, Approval_date, ECU_column_values);
	}
	
	public List<List<String>> request_Overview_table_values_ECU_certificate_request_for_more_than_one() throws Throwable {
		List<List<String>> firstTableValues = BaseClass.getTableValues(driver, By.xpath("//table/tbody"));
		List<String> ECU_column_values = new ArrayList<>();
		List<WebElement> tableRows = driver.findElements(By.xpath("//table/tbody/tr"));
		for (WebElement row : tableRows) {
			String columnValue = row.findElement(By.cssSelector("td[class*=\"ECU-Qualifier \"]")).getText();
			ECU_column_values.add(columnValue);
		}
		return firstTableValues;
	}

	public String ECU_Request_Overview_table_validation( String request_type) throws Throwable {
		request_Overview();
		select_request_type(request_type);
		approver_overview.filter_search(prop.getStatus_pending());	
		String	ecu=Request_Overview_ECU_Qualifier_for_nestT_txt();
		search_here(ecu);	
		Thread.sleep(1000);	
		refresh_button.click();
		Thread.sleep(3000);
		waitForWebElementToAppear(Request_Overview_approval_status_txt);
		click(Request_Overview_approval_status_txt);
//		click(ApprovalLevel2);
		Thread.sleep(3000);
		click(CloseHyperlink);
		return ecu;
	}
	
	public void Certificate_Overview__list_of_Column_ECU_certificate_request() {
		waitForWebElementToAppear(Request_Overview_Requester_id);
		waitForWebElementToAppear(Request_Overview_username);
		waitForWebElementToAppear(Request_Overview_department);
		waitForWebElementToAppear(Request_Overview_applicant_type);
		waitForWebElementToAppear(Request_Overview_applicant_number);
		waitForWebElementToAppear(Request_Overview_COT);
		waitForWebElementToAppear(Request_Overview_Approval_status);
		waitForWebElementToAppear(Request_Overview_ECU_Qualifier_for_nestT_txt);
		waitForWebElementToAppear(Request_Overview_ECU_Qualifier_Group);
		waitForWebElementToAppear(Request_Overview_KMS_System_IP_Address);
		waitForWebElementToAppear(Request_Overview_Reason_for_ECU_Certificate_Request);
		waitForWebElementToAppear(Request_Overview_Reason_for_Rejection);
		waitForWebElementToAppear(Request_Overview_Request_Date);
		waitForWebElementToAppear(Request_Overview_Approval_Date);

	}
	
	public List<String> getMultipleApplicantNumber() throws InterruptedException {
		List<String> applicantNumber = new ArrayList<>();

		for(WebElement element:Request_Overview_applicant_numbers_txt) {
			Thread.sleep(1000);
			String txt=element.getText();
			if(!txt.isEmpty()) {
			applicantNumber.add(txt);}
		}
		
		return applicantNumber;	
	}
	public List<String> getUserRole() throws InterruptedException {
		List<String> applicantNumber = new ArrayList<>();

		for(WebElement element:Request_Overview_userRole_txts) {
			Thread.sleep(1000);
			String txt=element.getText();
			applicantNumber.add(txt);
		}
		
		return applicantNumber;	
	}
	
	public List<String> request_Overview_table_validationForServicePrincipal( HashMap<String,String>input ,String applicant_type) throws InterruptedException {
		request_Overview();
		Certificate_Overview();
		select_applicant_type(applicant_type);
		search_here_UserID(input.get("PrincipalID"));
		Certificate_Overview__list_of_Column_Diag_Auth();
		Assert.assertNotEquals(Request_Overview_requester_Id_txt(), "N/A", "Requester_Id");
		Assert.assertNotEquals(Request_Overview_usertype_txt(), "N/A", "user_type");
		Assert.assertNotEquals(Request_Overview_username_txt(), "N/A", "username");
		Assert.assertNotEquals(Request_Overview_user_Id_txt(), "N/A", "User Id");
		Assert.assertNotEquals(Request_Overview_applicant_type_txt(), "N/A", "applicant_type");
		Assert.assertNotEquals(Request_Overview_applicant_number_txt(), "N/A", "applicant_number");
		Assert.assertNotEquals(Request_Overview_Functional_role_txt(), "N/A", "Functional_role");
		Assert.assertEquals(Request_Overview_Approval_status_txt(), "PENDING", "approval_status");
		if (Request_Overview_Functional_role_txt().equals("Development ENHANCED")
				|| Request_Overview_Functional_role_txt().equals("Production")) {
			Assert.assertNotEquals(Request_Overview_ECU_Qualifier_txt(), "N/A", "ECu Qualifier");
		}
		Assert.assertEquals(Request_Overview_Reason_for_Rejection_txt(), "N/A", "Reason for rejection");
		//Assert.assertEquals(Request_Overview_Request_date_txt(), BaseClass.todays_date(), "request_date");
		Assert.assertNotEquals(Request_Overview_Reason_for_Diagnostic_Authority_Request_txt(), "N/A",
				"reason_for_request");
		requester_ID = Request_Overview_requester_Id_txt();
		username = Request_Overview_username_txt();
		department = Request_Overview_department_txt();
		applicant_type_txt = Request_Overview_applicant_type_txt();
		applicant_number = Request_Overview_applicant_number_txt();
		Approval_status = Request_Overview_Approval_status_txt();
		Reason_for_Rejection = Request_Overview_Reason_for_Rejection_txt();
		Request_date = Request_Overview_Request_date_txt();
		Approval_date = Request_Overview_Approval_date_txt();
		usertype = Request_Overview_usertype_txt();
		user_ID = Request_Overview_user_Id_txt();
		Functional_role_txt = Request_Overview_Functional_role_txt();
		ECU_Qualifier_txt = Request_Overview_ECU_Qualifier_txt();
		User_role_txt = Request_Overview_User_role_txt();
		Reason_for_Diagnostic_Authority_Request_txt = Request_Overview_Reason_for_Diagnostic_Authority_Request_txt();
		return Arrays.asList(Approval_status, requester_ID, username, department, applicant_type_txt, applicant_number,
				Reason_for_Rejection, Request_date, Approval_date, usertype, user_ID, Functional_role_txt,
				ECU_Qualifier_txt, User_role_txt, Reason_for_Diagnostic_Authority_Request_txt);
	}
	public String validate_Request_Overview_page(String request_type, String id) throws InterruptedException, Exception {
		request_Overview();
		Thread.sleep(2000);
		select_request_type(request_type);
		search_here(id);
		Thread.sleep(2000);	
		req.scrollForReason();
		Thread.sleep(1000);	
		refresh_button.click();
		Thread.sleep(3000);
		waitForWebElementToAppear(Request_Overview_approval_status_txt);
		click(Request_Overview_approval_status_txt);
		Thread.sleep(3000);
		click(ApprovalLevel2);
		Thread.sleep(3000);
		click(CloseHyperlink);	
		return id;
		
		}

}
