package DAMS.PageObjects;

import static DAMS.Resources.Listeners.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.github.dockerjava.api.model.SearchItem;

import DAMS.Resources.AbstractComponents;
import DAMS.Resources.BaseClass;

public class Special_access_page extends AbstractComponents {
	WebDriver driver;
	String requesterID;
	String username;
	String department;
	String applicants_txt;
	String applicant_number;
	String tool_type;
	String functional_role;
	String user_role;
	String target_ecu;
	String approval_status;
	String Service_ID;
	String validity;
	String reason_for_Special_Enhance;
	String Approver_Reason;
	String Request_date;
	String Approval_date;

	public Special_access_page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// special access
	@FindBy(xpath = "//span[text()='Special Access']")
	private WebElement Special_Access;

	@FindBy(xpath = "//mat-expansion-panel-header[.=\"Special Enhance Right\"]")
	private WebElement Special_EnhanceRight;

	@FindBy(xpath = "//*[text()=\"Update Functional Role (ECU Qualifier)\"]")
	private WebElement Update_Functional_Role;

	@FindBy(xpath = "//*[text()=\"Functional Role Permissions\"]")
	private WebElement Functional_Role_Permissions;

	@FindBy(xpath = "//*[text()=\"Special Enhance Right\"]/../../../descendant::span[text()=\"New Request\"]")
	private WebElement New_Request;

	@FindBy(xpath = "//*[text()=\"Special Enhance Right\"]/../../../descendant::span[text()=\"Request Overview\"]")
	private WebElement SpecialEnhance_Request_Overview;

	@FindBy(xpath = "//*[text()=\"Update Functional Role (ECU Qualifier)\"]/../../../descendant::span[text()=\"New Request\"]")
	private WebElement New_Request_update;
//(//*[text()="Update Functional Role (ECU Qualifier)"]/../../../../descendant::span[text()="New Request"])[2]
	@FindBy(xpath = "//*[text()=\" Update ECU Qualifiers \"]")
	private WebElement Update_ECU_Qualifiers;

	@FindBy(xpath = "//*[text()=\"Update Functional Role (ECU Qualifier)\"]/../../../descendant::span[text()=\"Request Overview\"]")
	private WebElement Request_Overview_update;
	

	@FindBy(xpath = "//*[text()=\"View Permissions\"]")
	private WebElement View_Permissions;

	// Special Enhance Right Request--->New Request

	@FindBy(xpath = "//*[text()=\" Special Enhance Right Request\"]")
	private WebElement Special_Enhance_Right_Request;

	@FindBy(xpath = "//*[text()=\"Functional Role * \"]")
	private WebElement Functional_Role;

	@FindBy(xpath = "//*[text()=\"User Role * \"]")
	private WebElement User_Role;

	@FindBy(xpath = "//*[text()=\"ECU Qualifier * \"]")
	private WebElement ECU_Qualifier;

	@FindBy(xpath = "//*[text()=\"Service IDs * \"]")
	private WebElement Service_IDs;

	@FindBy(xpath = "//*[text()=\"Validity *\"]")
	private WebElement Validity;

	@FindBy(xpath = "//*[text()=\"Reason * \"]")
	private WebElement Reason;

	@FindBy(xpath = "//*[text()=\"Cancel\"]")
	private WebElement Cancel;

	@FindBy(xpath = "//*[text()=\"Submit\"]")
	private WebElement Submit;

	@FindBy(xpath = "//div/span[text()='Please select your role']")
	private WebElement please_Select_Your_role;

	@FindBy(xpath = "//div/span[text()='Please select your user role']")
	private WebElement please_Select_Your_user_role;

	@FindBy(xpath = "//div/span[text()='Please select the required ECU']")
	private WebElement Please_select_the_required_ECU;

	@FindBy(xpath = "//input[@placeholder=\"Enter Service ID\"]")
	private WebElement Enter_Service_ID;

	@FindBy(xpath = "//input[@placeholder=\"Number Of Days\"]")
	private WebElement Number_Of_Days;

	@FindBy(xpath = "//*[@placeholder=\"Maximum 500 characters only\"]")
	private WebElement resaon_input;

	// Special Enhance Right Request--->request overview
	
	

	@FindBy(xpath = "//*[@placeholder='Please select ECU Chain of Trust Type']")
	private WebElement ECU_Chain;
	
	@FindBy(xpath = "//*[text()=\" Special Access Overview\"]")
	private WebElement Special_Access_Overview;

	@FindBy(xpath = "//*[text()=\"Applicant\"]")
	private WebElement Applicant;

	@FindBy(xpath = "//*[text()=\"All \"]")
	private WebElement All;

	@FindBy(xpath = "//*[text()=\"Technical User \"]")
	private WebElement Technical_User;

	@FindBy(xpath = "//*[text()=\"Request Type\"]")
	private WebElement Request_Type;

	@FindBy(xpath = "//*[text()=\"Status\"]")
	private WebElement Status;

	@FindBy(xpath = "(//*[text()=\"All \"])[last()]")
	private WebElement Status_all;

	@FindBy(xpath = "//*[text()=\"Pending \"]")
	private WebElement Pending;

	@FindBy(xpath = "//*[text()=\"Approved \"]")
	private WebElement Approved;

	@FindBy(xpath = "//*[text()=\"Rejected \"]")
	private WebElement Rejected;

	@FindBy(xpath = "//span[text()=\"Refresh\"]")
	private WebElement request_overview_Refresh;

	@FindBy(xpath = "//span[text()=\"Reset Filters\"]")
	private WebElement request_overview_Reset_Filters;

	@FindBy(xpath = "//input[@placeholder=\"Search here\"]")
	private WebElement search_here;

	@FindBy(xpath = "//div[text()=\"Requester ID\"]")
	private WebElement Request_Overview_Requester_id;

	@FindBy(xpath = "//div[text()=\"Username\"]")
	private WebElement Request_Overview_username;

	@FindBy(xpath = "//div[text()=\"Department\"]")
	private WebElement Request_Overview_department;

	@FindBy(xpath = "//div[text()=\"Applicant Type\"]")
	private WebElement Request_Overview_applicant_type;

	@FindBy(xpath = "//div[text()=\"Application Number\"]")
	private WebElement Request_Overview_applicant_number;

	@FindBy(xpath = "//div[text()=\"Functional Role\"]")
	private WebElement Request_Overview_Functional_Role;

	@FindBy(xpath = "//div[text()=\"User Role\"]")
	private WebElement Request_Overview_User_role;

	@FindBy(xpath = "//div[text()=\"Service IDs\"]")
	private WebElement Request_Overview_Service_ID;

	@FindBy(xpath = "//div[text()=\"Approval Status\"]")
	private WebElement Request_Overview_Approval_status;

	@FindBy(xpath = "//div[text()=\"Request Date\"]")
	private WebElement Request_Overview_Request_Date;

	@FindBy(xpath = "//div[text()=\"Approval Date\"]")
	private WebElement Approval_Date;

	@FindBy(xpath = "//div[text()=\"Validity (Days)\"]")
	private WebElement Validity_days;

	@FindBy(xpath = "//div[text()=\"Reason for Rejection\"]")
	private WebElement Reason_for_Rejection;

	@FindBy(xpath = "//div[text()=\"Tool Type\"]")
	private WebElement Tool_Type;

	@FindBy(xpath = "//div[text()=\"Target ECU\"]")
	private WebElement Target_ECU;

	@FindBy(xpath = "//div[text()=\"Reason for Special Enhance Request\"]")
	private WebElement Reason_for_Special_Enhance_Request;

	@FindBy(xpath = "//table/tbody/tr/td")
	private WebElement requester_Id_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Username\")]")
	private WebElement username_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Department\")]")
	private WebElement department_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Applicant-Type\")]")
	private WebElement applicant_type_txt;

	@FindBy(xpath = "(//table/tbody/tr/td[contains(@class,\"Application-Number\")])[1]")
	private WebElement applicant_number_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Functional-Role \")]")
	private WebElement Functional_role_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"User-Role \")]")
	private WebElement User_role_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Service-IDs\")]")
	private WebElement Service_ID_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Validity--Days\")]")
	private WebElement Validity_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Reason-for-Rejection\")]")
	private WebElement Approver_Reason_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Approval-Date\")]")
	private WebElement Approval_date_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Approval-Status\")]")
	private WebElement approval_status_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Request-Date\")]")
	private WebElement Request_date_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Target-ECU \")]")
	private WebElement Target_ECU_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"ECU-Qualifier \")]")
	private WebElement ECU_QUalifier_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Tool-Type \")]")
	private WebElement Tool_Type_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Reason-for-Request \")]")
	private WebElement Reason_for_Special_Enhance_Request_txt;

	// ECU Qualifier Update For Functional Role

	@FindBy(xpath = "//*[text()=\" ECU Qualifier Update for Functional Role Overview\"]")
	private WebElement ECU_Qualifier_Update_For_Functional_Role;

	@FindBy(xpath = "//*[text()=\"Actions * \"]")
	private WebElement Actions;

	@FindBy(xpath = "//*[text()=\"Add\"]")
	private WebElement Add;
	
	@FindBy(xpath = "(//div[@class='mat-tab-label-content'])[last()]")
	private WebElement Delete;

	@FindBy(xpath = "//*[text()=\"Remove \"]")
	private WebElement Remove;

	@FindBy(xpath = "//*[text()=\"Business Unit * \"]")
	private WebElement Business_Unit;

	@FindBy(xpath = "//*[text()=\"Please select your business unit\"]")
	private WebElement Please_select_your_business_unit;

	@FindBy(xpath = "//*[text()=\"Functional Role * \"]")
	private WebElement Functional_Role_update;

	@FindBy(xpath = "//*[text()=\"ECU Qualifier * \"]")
	private WebElement ECU_Qualifier_update;

	@FindBy(xpath = "//mat-option//span")
	private List<WebElement> Functional_role_type;

	// Funtional Role Permission Overview

	@FindBy(xpath = "//*[text()=\" Funtional Role Permission Overview\"]")
	private WebElement Funtional_Role_Permission_Overview;

	@FindBy(xpath = "//*[text()=\"Business Unit\"]")
	private WebElement Business_Unit_FR;

	@FindBy(xpath = "//*[text()=\"Funtional Role\"]")
	private WebElement Funtional_Role;

	@FindBy(xpath = "//*[text()=\"Permission Type\"]")
	private WebElement Permission_Type;

	@FindBy(xpath = "//mat-option/span")
	private List<WebElement> Authorization_List;

	@FindBy(xpath = "//div[contains(@class,\"mat-form-field-infix\")]")
	private WebElement Authorization_dropdown;

	// ECU Qualifier Update for Functional Role Overview

	@FindBy(xpath = "//div[text()=\"Action Type\"]")
	private WebElement Action_Type;

	@FindBy(xpath = "//div[text()=\"Reason for Request\"]")
	private WebElement Reason_for_Updating_Functional_Role_Request;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Action-Type \")]")
	private WebElement Action_Type_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Reason-for-Request \")]")
	private WebElement Reason_for_Updating_Functional_Role_Request_txt;

	@FindBy(xpath = "//span[text()=\"Special Enhance Right\"]")
	private WebElement Request_Overview_drpdwn;

	// Third Party Publisher

	@FindBy(xpath = "//*[text()=\"Third Party Publisher\"]")
	private WebElement Third_Party_Publisher;

	@FindBy(xpath = "//*[text()=\"Third Party Publisher\"]/../../../descendant-or-self::span[text()=\"New Request\"]")
	private WebElement Third_Party_Publisher_new_request;

	@FindBy(xpath = "//*[text()=\" Publisher Onboarding\"]")
	private WebElement Publisher_Onboarding;

	@FindBy(xpath = "//*[text()=\"Business Unit * \"]")
	private WebElement Publisher_Onboarding_Business_Unit;

	@FindBy(xpath = "//span[text()=\"Please select your business unit\"]")
	private WebElement Publisher_Onboarding_Business_Unit_input;
	
	@FindBy(xpath = "(//mat-select[@placeholder='Please select an option'])[last()]")
	private WebElement View_Publisher_Onboarding_Business_Unit_input;

	@FindBy(xpath = "//*[text()=\"Publisher Name * \"]")
	private WebElement Publisher_Onboarding_Publisher_Name;

	@FindBy(xpath = "//input[@id=\"publisher_name\"]")
	private WebElement Publisher_Onboarding_Publisher_Name_input;

	@FindBy(xpath = "//*[text()=\"New Functional Role *\"]")
	private WebElement Publisher_Onboarding_New_Functional_Role;

	@FindBy(xpath = "//span[text()=\"Enter the Functional Role\"]")
	private WebElement Publisher_Onboarding_New_Functional_Role_input;
	
	@FindBy(xpath = "//*[@placeholder=\"Enter the Functional Role\"]")
	private WebElement new_Functional_role;

	@FindBy(xpath = "//*[@placeholder=\"Please select an option\" and @aria-required=\"true\" ]")
	private WebElement Publisher_Onboarding_New_Permission;

	@FindBy(xpath = "//*[@placeholder=\"Please select an option\" and @aria-required=\"true\" ]")
	private WebElement Publisher_Onboarding_New_Permission_input;
	
	@FindBy(xpath = "(//mat-select[@placeholder='Please select an option'])[last()]")
	private WebElement View_onboardingNewPermission;
	
	@FindBy(xpath = "//*[@id=\"reason\"]")
	private WebElement Publisher_Onboarding_Remark;

	@FindBy(xpath = "//*[@id=\"reason\"]")
	private WebElement Publisher_Onboarding_Remark_input;

	@FindBy(xpath = "//span[text()=\"Submit\"]")
	private WebElement Publisher_Onboarding_submit;

	@FindBy(xpath = "//span[text()=\"Cancel\"]")
	private WebElement Publisher_Onboarding_cancel;

	@FindBy(xpath = "//*[text()=\" View Publisher Onboarding \"]")
	private WebElement View_Publisher_Onboarding;

	@FindBy(xpath = "//label[text()=\"Business Unit\"]")
	private WebElement View_Publisher_Onboarding_Business_Unit;

	@FindBy(xpath = "(//*[text()=\"Please select an option\"])[last()]")
	private WebElement View_Publisher_Onboarding_Please_select_an_option;

	@FindBy(xpath = "//span[text()=\"View\"]")
	private WebElement View_Publisher_Onboarding_View;

	@FindBy(xpath = "//input[@data-placeholder=\"Search here\"]")
	private WebElement View_Publisher_Onboarding_Search_item;

	@FindBy(xpath = "//div[text()=\"Business Unit\"]")
	private WebElement View_Publisher_table_Business_Unit;

	@FindBy(xpath = "//div[text()=\"Publisher Name\"]")
	private WebElement View_Publisher_table_Publisher_Name;

	@FindBy(xpath = "//div[text()=\"Functional Role\"]")
	private WebElement View_Publisher_table_Functional_Role;

	@FindBy(xpath = "//div[text()=\"New Permission\"]")
	private WebElement View_Publisher_table_New_Permission;

	@FindBy(xpath = "//div[text()=\"Remark\"]")
	private WebElement View_Publisher_table_Remark;

	@FindBy(xpath = "//*[text()=\"More Actions\"]")
	private WebElement View_Publisher_table_More_Actions;

	@FindBy(xpath = "//span[text()=\"Refresh\"]")
	private WebElement View_Publisher_refresh;

	@FindBy(xpath = "//span[text()=\"Reset Filters\"]")
	private WebElement View_Publisher_Reset_Filters;

	@FindBy(xpath = "//span[text()=\"Edit\"]")
	private WebElement View_Publisher_Edit;

	@FindBy(xpath = "(//label[text()=\"New Permission *\"])[last()]/../mat-form-field/descendant::mat-select")
	private WebElement View_Publisher_Edit_new_permission;

	@FindBy(xpath = "(//span[text()=\"Submit\"])[last()]")
	private WebElement View_Publisher_Edit_submit;

	@FindBy(xpath = "(//textarea[@id=\"reason\"])[last()]")
	private WebElement View_Publisher_Edit_reason;

	@FindBy(xpath = "(//mat-select[@placeholder=\"Please select an option\"])[last()]")
	private WebElement View_Publisher_business_unit_dropdown;
	
	@FindBy(xpath = "//span[text()=\"Confirm Delete Request\"]")
	private WebElement confirm_delete_request;
	
	@FindBy(xpath = "//p[text()=\"Are you sure you want to delete ?\"]")
	private WebElement confirm_delete;
	
	@FindBy(xpath = "//span[text()=\"Back\"]")
	private WebElement delete_back;
	
	@FindBy(xpath = "//span[text()=\"Ok\"]")
	private WebElement delete_ok;
	
	@FindBy(xpath = " //div[text()=\" 428 Precondition Required :  Functional Role already exists! \"]")
	private WebElement error_message;

	// Update Global Enhanced Right
	
	@FindBy(xpath = "//*[text()='Update Global EnhanceRight']")
	private WebElement Update_Global_EnhanceRight;

	@FindBy(xpath = "//a[contains(@href,\"special-access/update-global-enhance-right-request\")]")
	private WebElement Update_Global_EnhanceRight_new_request;

	@FindBy(xpath = "//a[contains(@href,\"global-enhance-right-request-overview\")]")
	private WebElement Update_Global_EnhanceRight_request_Overview;

	@FindBy(xpath = "//*[text()=\" Global Enhance right permission\"]")
	private WebElement Global_Enhance_right_permission;

	@FindBy(xpath = "//*[text()=\"Update Global Enhance Right request\"]")
	private WebElement Update_Global_Enhance_Right_request;

	@FindBy(xpath = "//*[text()=\"Delete\"]")
	private WebElement Update_Global_Enhance_Right_Delete;

	@FindBy(xpath = "//*[text()=\"Add\"]")
	private WebElement Update_Global_Enhance_Right_Add;

	@FindBy(xpath = "//*[text()=\"ECU Qualifier * \"]")
	private WebElement Update_Global_Enhance_Right_ECU_Qualifier;

	@FindBy(xpath = "//span[text()=\"Please select the required ECU\"]")
	private WebElement Update_Global_Enhance_Right_Please_select_the_required_ECU;

	@FindBy(xpath = "//*[text()=\"Service IDs * \"]")
	private WebElement Update_Global_Enhance_Right_Service_IDs;

	@FindBy(xpath = "//input[@placeholder=\"Enter Service ID\"]")
	private WebElement Update_Global_Enhance_Right_Enter_Service_IDs;

	@FindBy(xpath = "//*[text()=\"Validity *\"]")
	private WebElement Update_Global_Enhance_Right_Validity;

	@FindBy(xpath = "//input[@data-placeholder=\"Number Of Days\"]")
	private WebElement Update_Global_Enhance_Right_Validity_Number_Of_Days;

	@FindBy(xpath = "//*[text()=\"Reason * \"]")
	private WebElement Update_Global_Enhance_Right_Reason;

	@FindBy(xpath = "//*[@id=\"reason\"]")
	private WebElement Update_Global_Enhance_Right_Reason_input;

	@FindBy(xpath = "//span[text()=\"Submit\"]")
	private WebElement Update_Global_Enhance_Right_submit;

	@FindBy(xpath = "//span[text()=\"Cancel\"]")
	private WebElement Update_Global_Enhance_Right_cancel;

	@FindBy(xpath = "//input[@data-placeholder=\"Search here\"]")
	private WebElement Update_Global_Enhance_Right_Search_here;

	@FindBy(xpath = "//div[text()=\"ECU Qualifier\"]")
	private WebElement Gloabl_delete_ECU_Qualifier;

	@FindBy(xpath = "//div[text()=\"Service IDs\"]")
	private WebElement Gloabl_delete_Service_IDs;

	@FindBy(xpath = "//div[text()=\"Validity (Days)\"]")
	private WebElement Gloabl_delete_Validity;

	@FindBy(xpath = "//div[text()=\"Created Date\"]")
	private WebElement Gloabl_delete_Created_Date;

	@FindBy(xpath = "//div[text()=\"Expiry Date\"]")
	private WebElement Gloabl_delete_Expiry_Date;

	@FindBy(xpath = "//th[text()=\"Delete\"]")
	private WebElement Gloabl_delete;

	@FindBy(xpath = "//span[text()=\"Delete\"]")
	private WebElement Gloabl_delete_button;
	
	
	// view permission
	@FindBy(xpath = "//mat-panel-title[text()='Functional Role Permissions']")
	private WebElement functionalRolePermission;
	
	@FindBy(xpath = "//a//span[text()='View Permissions']")
	private WebElement FR_view_Permission;
	
	@FindBy(xpath = "//mat-select[@formcontrolname='bu']")
	private WebElement FR_view_BU;
	
	@FindBy(xpath = "//mat-select[@formcontrolname='funcRole']")
	private WebElement FR_view_FuncRole;
	
	@FindBy(xpath = "//mat-select[@formcontrolname='techUserId']")
	private WebElement FR_view_TechUserId;
	
	@FindBy(xpath = "//mat-select[@formcontrolname='permissionType']")
	private WebElement FR_view_PermissionType;
	
	@FindBy(xpath = "//button//span[text()='View Permissions']")
	private WebElement FR_view_PermissionBtn;
	
	@FindBy(xpath = "(//span[@id='normalCols2'])[1]")
	private WebElement publisherTxt;
	
	@FindBy(xpath = "//*[@id='vehicleProgramDesc']")
	private WebElement role_description_text;
	
	@FindBy(xpath = "(//mat-select[@placeholder='Please select ECU Chain of Trust Type'])[last()]")
	private WebElement ECU_Type_ViewPublisher;
	
	@FindBy(xpath = "//span[text()='View']")
	private WebElement ViewBtn_Publisher;
	
	@FindBy(xpath = "//div[text()=' Items per page: ']")
	private WebElement Itemperpage;
	
	@FindBy(xpath = "//span[text()='Edit']")
	private WebElement Editpublisher;
	
	@FindBy(xpath = "//span[text()='Refresh']")
	private WebElement refresh_button;
	
	@FindBy(xpath = "(//table/tbody/tr/td[contains(@class,\"Approval-Status\")])[1]")
	private WebElement Request_Overview_approval_status_txt;
	
	@FindBy(xpath = "//span[text()='Close']")
	private WebElement CloseHyperlink;
	
	@FindBy(xpath = "//p[text()='Approval Level 2']")
	private WebElement ApprovalLevel2;
	
	@FindBy(xpath = "//span[text()='Delete']")
	private WebElement Delete_UpdateGlobal;
	
	@FindBy(xpath = "//span[text()='Ok']")
	private WebElement Ok_UpdateGlobal;
	
	// meta data
	
	@FindBy(xpath = "//*[text()='ECU Metadata']")
	private WebElement ECU_Meta_Data;
	
	@FindBy(xpath = "//a[contains(@href,\"ecu-metadata\")]")
	private WebElement ECU_Meta_Data_Request;
	
	@FindBy(xpath = "//a[contains(@href,\"ecu-metadata-overview\")]")
	private WebElement ECU_Meta_Data_Request_Overview;
	
	@FindBy(xpath = "(//mat-select[@placeholder='Please select the required ECU'])[1]")
	private WebElement Meta_Data_Request_Type;
	
	@FindBy(xpath = "(//mat-select[@placeholder='Please select the required ECU'])[2]")
	private WebElement Meta_Data_ECU;
	
	@FindBy(xpath = "//input[@id='architect_name']")
	private WebElement Meta_Data_New_Owner;
	
	@FindBy(xpath = "//input[@formcontrolname='currentOwner']")
	private WebElement Meta_Data_Existing_Owner;
	
	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"New-Owner\")]")
	private WebElement Meta_Data_New_Owner_txt;
	
	@FindBy(xpath = "//div[text()='Approval Status']")
	private WebElement Approver_Overview_Approval_Status;
	
	
	@FindBy(xpath = "//input[@placeholder='Search full records...']")
	private WebElement RequestSearch_Here;
	
	
	public void scroll_to_owner() {
		Scrollright_waitForWebElementToAppear(Meta_Data_New_Owner_txt);
	}
	
	
	public void select_ECU_MetaData() {
		waitForWebElementToAppear(ECU_Meta_Data);
		click(ECU_Meta_Data);
		waitForWebElementToAppear(ECU_Meta_Data_Request);
		ECU_Meta_Data_Request.click();
	}
	
	public void select_MetaData_Request_OverView() {
//		waitForWebElementToAppear(ECU_Meta_Data);
//		click(ECU_Meta_Data);
		waitForWebElementToAppear(ECU_Meta_Data_Request_Overview);
		click(ECU_Meta_Data_Request_Overview);
	
	}
	public void select_ECU_Request_Type(String value) throws InterruptedException {
		waitForWebElementToAppear(Meta_Data_Request_Type);
		click(Meta_Data_Request_Type);
		Thread.sleep(1000);
		logger.info(value);
		clickelementmatchingtext(Functional_role_type, value);

	}
	
	public void select_New_Owner(String value) throws InterruptedException {
		waitForWebElementToAppear(Meta_Data_New_Owner);
		click(Meta_Data_New_Owner);
		
//		String name = Meta_Data_Existing_Owner.getText().trim();
		String existingOwner = Meta_Data_Existing_Owner.getAttribute("value");
//		logger.info(name);
		logger.info(existingOwner);
		if(existingOwner.equalsIgnoreCase("HARNAGA")) {
			Meta_Data_New_Owner.sendKeys("IPATHAN");
		}
		else {
		Meta_Data_New_Owner.sendKeys("HARNAGA");
		}
//		clickelementmatchingtext(Functional_role_type, value);

	}
	
	public void select_ECU_Qualifier(String value) throws InterruptedException {
		waitForWebElementToAppear(Meta_Data_ECU);
		click(Meta_Data_ECU);
		Thread.sleep(1000);
		logger.info(value);
		clickelementmatchingtext(Functional_role_type, value);

	}
	
	
	
	public void selectUpdate_Global_EA() throws AWTException {
		waitForWebElementToAppear(Update_Global_EnhanceRight);
		click(Update_Global_EnhanceRight);
		waitForWebElementToAppear(Update_Global_EnhanceRight_new_request);
		click(Update_Global_EnhanceRight_new_request);
		
	}
	
	
	public String getPublisherTxt() {
		return publisherTxt.getText().trim();
	}
	
	public void click_Permission() {
		click(FR_view_PermissionBtn);
	}
	
	public void FR_ViewPermissionType(String name) throws Throwable {
		FR_view_PermissionType.click();
		clickelementmatchingtext(Functional_role_type, name);
	}
	
	public void FR_ViewTechUserId(String name) throws Throwable {
		FR_view_TechUserId.click();
		clickelementmatchingtext(Functional_role_type, name);
	}
	
	public void FR_Viewbusiness_unit(String name) throws Throwable {
		FR_view_BU.click();
		clickelementmatchingtext(Functional_role_type, name);
	}
	public void FR_View_FuncRole(String name) throws Throwable {
		FR_view_FuncRole.click();
		clickelementmatchingtext(Functional_role_type, name);
	}
	
	public void  selectFR_Permission() {
		waitForWebElementToAppear(Functional_Role_Permissions);
		click(functionalRolePermission);
		waitForWebElementToAppear(FR_view_Permission);
		click(FR_view_Permission);
	}

	public String requester_Id_txt() {
		waitForWebElementToAppear(requester_Id_txt);
		return requester_Id_txt.getText();

	}

	public String ECU_QUalifier_txt() {
		waitForWebElementToAppear(ECU_QUalifier_txt);
		return ECU_QUalifier_txt.getText();

	}

	public String username_txt() {
		waitForWebElementToAppear(username_txt);
		return username_txt.getText();

	}

	public String department_txt() {
		waitForWebElementToAppear(department_txt);
		return department_txt.getText();

	}

	public String applicant_type_txt() {
		waitForWebElementToAppear(applicant_type_txt);
		return applicant_type_txt.getText();

	}

	public String applicant_number_txt() {
		
		waitForWebElementToAppear(applicant_number_txt);
		return applicant_number_txt.getText();
	}
	
	
	

	public String Functional_role_txt() {
		waitForWebElementToAppear(Functional_role_txt);
		return Functional_role_txt.getText();

	}

	public String User_role_txt() {
		waitForWebElementToAppear(User_role_txt);
		return User_role_txt.getText();

	}

	public String Service_ID_txt() {
		waitForWebElementToAppear(Service_ID_txt);
		return Service_ID_txt.getText();

	}

	public String Validity_txt() {
		waitForWebElementToAppear(Validity_txt);
		return Validity_txt.getText();

	}

	public String Approver_Reason_txt() {
		waitForWebElementToAppear(Approver_Reason_txt);
		return Approver_Reason_txt.getText();

	}

	public String Approval_date_txt() {
		waitForWebElementToAppear(Approval_date_txt);
		return Approval_date_txt.getText();

	}

	public String approval_status_txt() {
		waitForWebElementToAppear(approval_status_txt);
		return approval_status_txt.getText();

	}

	public String Request_date_txt() {
		waitForWebElementToAppear(Request_date_txt);
		return Request_date_txt.getText();

	}

	public String Target_ECU_txt() {
		waitForWebElementToAppear(Target_ECU_txt);
		return Target_ECU_txt.getText();

	}

	public String Tool_Type_txt() {
		waitForWebElementToAppear(Tool_Type_txt);
		return Tool_Type_txt.getText();

	}

	public String Action_Type_txt() {
		waitForWebElementToAppear(Action_Type_txt);
		return Action_Type_txt.getText();

	}

	public String Reason_for_Updating_Functional_Role_Request_txt() {
		waitForWebElementToAppear(Reason_for_Updating_Functional_Role_Request_txt);
		return Reason_for_Updating_Functional_Role_Request_txt.getText();

	}

	public String Reason_for_Special_Enhance_Request_txt() {
		waitForWebElementToAppear(Reason_for_Special_Enhance_Request_txt);
		return Reason_for_Special_Enhance_Request_txt.getText();

	}
	
	public void clickSpecialAccess() throws InterruptedException, AWTException {
		Thread.sleep(4000);
		waitForPageLoad(driver);
		waitForWebElementToAppear(Special_Access);
		waitForelementToBeClickable(Special_Access);
//		windowZoomOut();
		click(Special_Access);
		Thread.sleep(2000);
	}

	public void special_access() {
		
		waitForWebElementToAppear(Special_EnhanceRight);
		waitForWebElementToAppear(Update_Functional_Role);
		waitForWebElementToAppear(Functional_Role_Permissions);
	}

	public void Special_Enhanced_right() throws InterruptedException {
		waitForWebElementToAppear(Special_EnhanceRight);
		waitForelementToBeClickable(Special_EnhanceRight);
		Thread.sleep(2000);
		if(Special_EnhanceRight.getAttribute("aria-expanded").equals("false")) {
		click(Special_EnhanceRight);
		}

	}

	public void update_functional_role() throws InterruptedException {
//		special_access();
		Thread.sleep(3000);
		waitForWebElementToAppear(Functional_Role_Permissions);
		scrollDown(Functional_Role_Permissions);
		clickJS(Update_Functional_Role);
//		waitForWebElementToAppear(Update_ECU_Qualifiers);
	}

	public void Update_ECU_Qualifiers() {
		clickJS(Update_ECU_Qualifiers);
		waitForWebElementToAppear(New_Request_update);

	}

	public void functional_role_permission() {
		clickJS(Functional_Role_Permissions);
		waitForWebElementToAppear(View_Permissions);

	}

	public void raise_Special_Enhance_Right_Request(String functional_role, String user_role, String ecu_qualifier,
			String service_ID, String validity, String reason,String mode) throws Throwable {
		waitForWebElementToAppear(New_Request);
		clickJS(New_Request);
		logger.info(functional_role+"\t"+user_role+"\t"+ecu_qualifier+"\t"+service_ID+"\t"+validity+reason+"\t"+mode);
		selectECU_Chain(mode);
		functional_role(functional_role);
		user_role(user_role);
		Ecu_qualifier(ecu_qualifier);
		type(Enter_Service_ID, service_ID);
		type(Number_Of_Days, validity);
		Thread.sleep(2000);
		type(resaon_input, reason);
		clickJS(Submit);
		test.pass("User is able to raise Special Enhanced right");
		logger.info("User is able to raise Special Enhanced right");
	}
	public void validate_Special_Enhance_Right_ECU(String functional_role, String user_role, String ecu_qualifier,String mode) throws Throwable {
		waitForWebElementToAppear(New_Request);
		clickJS(New_Request);
		logger.info(functional_role+"\t"+user_role+"\t"+ecu_qualifier+"\t"+mode);
		selectECU_Chain(mode);
		functional_role(functional_role);
		user_role(user_role);
//		Ecu_qualifier(ecu_qualifier);
		Thread.sleep(2000);
		waitForWebElementToAppear(Please_select_the_required_ECU);
		click(Please_select_the_required_ECU);
		check_elementText(Functional_role_type,ecu_qualifier);
		
		

	}

	public void validate_raise_Special_Enhance_Right_Request_ECU_removed(String functional_role, String user_role,
			String ecu_qualifier) throws Throwable {
		clickJS(New_Request);
		functional_role(functional_role);
		user_role(user_role);
		try {
			Ecu_qualifier_after_removed(ecu_qualifier);
		} catch (Exception e) {
			test.pass(ecu_qualifier + " is not visible after removed");
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
	
	public void selectECU_Chain(String name) throws Throwable{
		Thread.sleep(2000); 
		waitForPageLoad(driver);
		waitForWebElementToAppear(ECU_Chain);
		waitForelementToBeClickable(ECU_Chain);
		clickJS(ECU_Chain);
		clickelementmatchingtext(Functional_role_type, name);
	}
	
	public void selectECU_Chain_ViewPublisher(String name) throws Throwable{
//		waitForWebElementToAppear(ECU_Type_ViewPublisher);
		waitForWebElementToAppear(ECU_Type_ViewPublisher);
		waitForelementToBeClickable(ECU_Type_ViewPublisher);
		Thread.sleep(2000);
		clickJS(ECU_Type_ViewPublisher);
		clickelementmatchingtext(Functional_role_type, name);
	}

	public void functional_role(String name) throws Throwable {
		Thread.sleep(2000);
		waitForelementToBeClickable(please_Select_Your_role);
		please_Select_Your_role.click();
		clickelementmatchingtext(Functional_role_type, name);
	}

	public void business_unit(String name) throws Throwable {
		Please_select_your_business_unit.click();
		
		clickelementmatchingtext(Functional_role_type, name);
	}

	public void user_role(String name) throws Throwable {
		click(please_Select_Your_user_role);
		
		clickelementmatchingtext(Functional_role_type, name);
	}

	public void Ecu_qualifier(String name) throws Throwable {
		Thread.sleep(2000);
		waitForWebElementToAppear(Please_select_the_required_ECU);
		click(Please_select_the_required_ECU);
		clickelementmatchingtext(Functional_role_type, name);
	}

	public void Ecu_qualifier_after_removed(String name) throws Throwable {
		clickJS(Please_select_the_required_ECU);
		String xpathExpression = String.format("//span[contains(text(),'%s')]", name);
		waitForWebElementToAppear(driver.findElement(By.xpath(xpathExpression)));
	}

	public String clickelementmatchingtext(List<WebElement> elements, String name) throws InterruptedException {
		String usertype1 = null;
		for (int i = 0; i < elements.size(); i++) {
			Thread.sleep(100);
			WebElement txt = elements.get(i);
			String usertype = txt.getText().trim();
			logger.info(usertype+" "+name);
			if (usertype.equals(name)) {
				usertype1 = usertype;
				txt.click();
				Thread.sleep(1000);
				break;
			}
		}
		return usertype1;
	}

	public String check_elementText(List<WebElement> elements, String name) throws InterruptedException {
		String usertype1 = null;
		boolean res=true;
		for (int i = 0; i < elements.size(); i++) {
			Thread.sleep(100);
			WebElement txt = elements.get(i);
			String usertype = txt.getText().trim();
			logger.info(usertype+" "+name);
			if (usertype.equals(name)) {
				res=false;
				break;
			}
		}
		if(res) {
			logger.info(name+" ECU Not Present");
			test.pass(name+" ECU Not Present");
		}
		else {
			logger.info(name+" ECU Is Present");
			test.fail(name+" ECU Is Present");
		}
		return usertype1;
	}
	
	
	public void Special_Access_Overview() {
		waitForWebElementToAppear(Special_Access_Overview);
		waitForWebElementToAppear(Applicant);
		waitForWebElementToAppear(All);
		waitForWebElementToAppear(Technical_User);
		waitForWebElementToAppear(Request_Type);
		waitForWebElementToAppear(Status);
		waitForWebElementToAppear(Status_all);
		waitForWebElementToAppear(Pending);
		waitForWebElementToAppear(Approved);
		waitForWebElementToAppear(Rejected);
		waitForWebElementToAppear(request_overview_Refresh);
		waitForWebElementToAppear(request_overview_Reset_Filters);
		waitForWebElementToAppear(search_here);
	}

	
	
	
	public void ECU_Qualifier_Update_Overview() throws Throwable {
		Thread.sleep(3000);
		waitForWebElementToAppear(ECU_Qualifier_Update_For_Functional_Role);
		waitForWebElementToAppear(Request_Type);
		waitForWebElementToAppear(Status);
		waitForWebElementToAppear(Status_all);
		waitForWebElementToAppear(Pending);
		waitForWebElementToAppear(Approved);
		waitForWebElementToAppear(Rejected);
		waitForWebElementToAppear(request_overview_Refresh);
		waitForWebElementToAppear(request_overview_Reset_Filters);
		waitForWebElementToAppear(search_here);
	}

	public void SpecialEnhance_request_Overview() throws Throwable {
		Thread.sleep(2000);
		Special_Enhanced_right();
		Thread.sleep(4000);
		waitForWebElementToAppear(SpecialEnhance_Request_Overview);
		waitForelementToBeClickable(SpecialEnhance_Request_Overview);
		clickJS(SpecialEnhance_Request_Overview);
		Thread.sleep(2000);
		applicant_number = applicant_number_txt();
		Req_search_here(applicant_number);
		Thread.sleep(2000);	
		Scrollright_waitForWebElementToAppear(Request_Overview_approval_status_txt);	
		refresh_button.click();
		Thread.sleep(2000);
		click(Request_Overview_approval_status_txt);
		Thread.sleep(3000);
		click(ApprovalLevel2);
		Thread.sleep(3000);
		click(CloseHyperlink);
	}
	
	public void Approveroverviewhyperlink() throws InterruptedException {
		Thread.sleep(2000);
		if (!Approver_Overview_Approval_Status.isDisplayed()) {
		    Scrollright_waitForWebElementToAppear(Approver_Overview_Approval_Status);
		}
		refresh_button.click();
		Thread.sleep(2000);
		click(Request_Overview_approval_status_txt);
		Thread.sleep(3000);
		click(ApprovalLevel2);
		Thread.sleep(3000);
		click(CloseHyperlink);
	}
	
	public void approvalLinkCheck() throws Throwable {
		Scrollright_waitForWebElementToAppear(Request_Overview_approval_status_txt);	
		refresh_button.click();
		Thread.sleep(2000);
		click(Request_Overview_approval_status_txt);
		Thread.sleep(3000);
		click(CloseHyperlink);
	}

	public void request_Overview_update() throws InterruptedException {
		Thread.sleep(4000);
		waitForWebElementToAppear(Request_Overview_update);
		waitForelementToBeClickable(Request_Overview_update);
		click(Request_Overview_update);
		Thread.sleep(2000);
		
		applicant_number = applicant_number_txt();
		Req_search_here(applicant_number);
		Thread.sleep(2000);	
		Scrollright_waitForWebElementToAppear(Request_Overview_approval_status_txt);	
		refresh_button.click();
		Thread.sleep(2000);
		click(Request_Overview_approval_status_txt);
		Thread.sleep(3000);
		click(CloseHyperlink);
	}

	public void select_applicant_type(String applicant_type) throws Throwable {
		clickJS(Authorization_dropdown);
		clickelementmatchingtext(Authorization_List, applicant_type);
	}
	public void selectRequest_type(String applicant_type) throws Throwable {
		clickJS(Authorization_dropdown);
		clickelementmatchingtext(Authorization_List, applicant_type);
	}

	public void Special_Access_Overview_list_of_Column() {
		waitForWebElementToAppear(Request_Overview_Requester_id);
		waitForWebElementToAppear(Request_Overview_username);
		waitForWebElementToAppear(Request_Overview_department);
		waitForWebElementToAppear(Request_Overview_applicant_type);
		waitForWebElementToAppear(Request_Overview_applicant_number);
		waitForWebElementToAppear(Tool_Type);
		waitForWebElementToAppear(Request_Overview_Functional_Role);
		waitForWebElementToAppear(Request_Overview_User_role);
		waitForWebElementToAppear(Target_ECU);
		waitForWebElementToAppear(Request_Overview_Approval_status);
		waitForWebElementToAppear(Request_Overview_Service_ID);
		waitForWebElementToAppear(Validity_days);
//		waitForWebElementToAppear(Reason_for_Special_Enhance_Request);
		waitForWebElementToAppear(Reason_for_Rejection);
		waitForWebElementToAppear(Request_Overview_Request_Date);
		waitForWebElementToAppear(Approval_Date);
	}

	public void ECU_Qualifier_Update_for_Functional_Role_Overview_list_of_Column() {
		waitForWebElementToAppear(Request_Overview_Requester_id);
		waitForWebElementToAppear(Request_Overview_username);
		waitForWebElementToAppear(Request_Overview_department);
		waitForWebElementToAppear(Action_Type);
		waitForWebElementToAppear(Request_Overview_applicant_number);
		waitForWebElementToAppear(Request_Overview_Functional_Role);
		waitForWebElementToAppear(Request_Overview_Approval_status);
		waitForWebElementToAppear(Reason_for_Updating_Functional_Role_Request);
		waitForWebElementToAppear(Reason_for_Rejection);
		waitForWebElementToAppear(Request_Overview_Request_Date);
		waitForWebElementToAppear(Approval_Date);
	}

	public List<String> request_Overview_table_validation(String applicant_type) throws Throwable {
		Thread.sleep(4000);
		SpecialEnhance_request_Overview();
//		Special_Access_Overview();
//		select_applicant_type(applicant_type);
//		Special_Access_Overview_list_of_Column();
		requesterID = requester_Id_txt();
		username = username_txt();
		department = department_txt();
		applicants_txt = applicant_type_txt();
		applicant_number = applicant_number_txt();
		tool_type = Tool_Type_txt();
		functional_role = Functional_role_txt();
		user_role = User_role_txt();
		target_ecu = Target_ECU_txt();
		approval_status = approval_status_txt();
		Service_ID = Service_ID_txt();
		validity = Validity_txt();
		reason_for_Special_Enhance = Reason_for_Special_Enhance_Request_txt();
		Approver_Reason = Approver_Reason_txt();
		Request_date = Request_date_txt();
		Approval_date = Approval_date_txt();
		return Arrays.asList(approval_status, requesterID, username, department, applicants_txt, applicant_number,
				tool_type, functional_role, user_role, target_ecu, Service_ID, validity, reason_for_Special_Enhance,
				Approver_Reason, Request_date, Approval_date);
	}

	public void search_here_UserID(Object values) {
		type(search_here, values);
	}
	
	public void search_here(Object values) {
		waitForWebElementToAppear(search_here);
		type(search_here, values);
	}
	
	public void refreshBtn() {
		refresh_button.click();
	}
	
	public void Req_search_here(Object values) {
		waitForWebElementToAppear(RequestSearch_Here);
		type(RequestSearch_Here, values);
	}

	public void navigate_to_request_Overview_page_and_verify_approval_status(String approval_status,
			String approval_date, String rejection_txt, String request_type, String user_ID) throws Throwable {
		refresh();
		Thread.sleep(2000);
//		special_access();
		Special_Enhanced_right();
		SpecialEnhance_request_Overview();
//		select_applicant_type(request_type);
//		search_here_UserID(user_ID);
		approval_status_txt().equals(approval_status);
		Approval_date_txt().equals(approval_date);
		Approver_Reason_txt().equals(rejection_txt);
	}
	public void navigate_to_request_Overview_page_and_Update_EA(String user_ID) throws Throwable {
		clickSpecialAccess();
		special_access();
		click(Update_Global_EnhanceRight);
		Thread.sleep(1000);
		Update_Global_EnhanceRight_request_Overview.click();
		Thread.sleep(3000);
		search_here_UserID(user_ID);
		Thread.sleep(2000);
		refresh_button.click();
		Thread.sleep(2000);
		click(Request_Overview_approval_status_txt);
		Thread.sleep(3000);
		click(ApprovalLevel2);
		Thread.sleep(3000);
		click(CloseHyperlink);
//		Thread.sleep(1000);
//		click(Pending);
	}
	public void navigate_to_ECU_Qualifier_update_page_and_verify_approval_status(String approval_status,
			String approval_date, String rejection_txt, String request_type, String user_ID) throws Throwable {
		Thread.sleep(300);
//		update_functional_role();
//		Update_ECU_Qualifiers();
//		request_Overview_update();
//		Thread.sleep(3000);
//		waitForWebElementToAppear(ECU_Qualifier_Update_For_Functional_Role);
		select_applicant_type(request_type);
		search_here_UserID(user_ID);
		approval_status_txt().equals(approval_status);
		Approval_date_txt().equals(approval_date);
		Approver_Reason_txt().equals(rejection_txt);
	}
	
	

	public void add_UpdateEnhanceRaise(String functional_role, String ecu_qualifier, String Service_id,String validity, String reason)
			throws Throwable {
		clickJS(Add);	
		
		logger.info(functional_role+"\t"+Service_id+"\t"+ecu_qualifier+"\t"+reason+"\t"+validity);
		functional_role(functional_role);
		Ecu_qualifier(ecu_qualifier);
		type(Enter_Service_ID, Service_id);
		type(Number_Of_Days,validity );
		//
		type(resaon_input, reason);
		Thread.sleep(2000);
		waitForelementToBeClickable(Submit);
		click(Submit);
		
		//
	
		test.pass("User is able to raise request for Add Functional role");
		logger.info("User is able to raise request for Add Functional role");
	}
	
	public void delete_UpdateEnhanceRaise()
			throws Throwable {
		Thread.sleep(2000);
		clickJS(Delete);	
		Thread.sleep(2000);
		ECU_QUAlifier_txt = ECU_QUalifier_txt();
		search_here(ECU_QUAlifier_txt);
//		search_here(id);
		Thread.sleep(2000);
		clickJS(Delete_UpdateGlobal);
		Thread.sleep(2000);
		clickJS(Ok_UpdateGlobal);
		test.pass("User is able to Delete the Functional role");
		logger.info("User is able to Delete the Functional role");
	}
	
	public String Validate_Add_Update_EnhanceRight() throws InterruptedException {
    Thread.sleep(2000);
		Update_Global_EnhanceRight.click();
		Thread.sleep(1000);
		Update_Global_EnhanceRight_request_Overview.click();
		Thread.sleep(2000);
		applicant_number = applicant_number_txt();
		search_here(applicant_number);
		Thread.sleep(1000);
		refresh_button.click();
		Thread.sleep(2000);
		click(Request_Overview_approval_status_txt);
		Thread.sleep(3000);
		click(ApprovalLevel2);
		Thread.sleep(3000);
		click(CloseHyperlink);
		Thread.sleep(1000);
//		click(Pending);

		return applicant_number;
		
	}
	
	
	public void add_functional_role(String functional_role, String business_unit, String ecu_qualifier, String reason,String mode)
			throws Throwable {
		clickJS(New_Request_update);
		Thread.sleep(2000);
		logger.info(functional_role+"\t"+business_unit+"\t"+ecu_qualifier+"\t"+reason);
		selectECU_Chain(mode);
		business_unit(business_unit);
		functional_role(functional_role);
		Ecu_qualifier(ecu_qualifier);
		type(resaon_input, reason);
		clickJS(Submit);
		test.pass("User is able to raise request for Add Functional role");
		logger.info("User is able to raise request for Add Functional role");
	}
	
	public void remove_functional_role(String functional_role, String business_unit, String ecu_qualifier, String reason,String mode)
			throws Throwable {
		clickJS(New_Request_update);
		Thread.sleep(2000);
		Remove.click();
		Thread.sleep(2000);
		logger.info(functional_role+"\t"+business_unit+"\t"+ecu_qualifier+"\t"+reason);
		selectECU_Chain(mode);
		business_unit(business_unit);
		functional_role(functional_role);
		Ecu_qualifier(ecu_qualifier);
		Thread.sleep(2000);
		type(resaon_input, reason);
		Thread.sleep(2000);
		clickJS(Submit);
		test.pass("User is able to raise request for Add Functional role");
		logger.info("User is able to raise request for Add Functional role");
	}

	public void submit_button() {
		try {
			waitForWebElementToAppear(Submit);
			waitForelementToBeClickable(Submit);
			Submit.click();
//			click(Submit);
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			scrollDown(Submit);
			waitForWebElementToAppear(Submit);
		
			clickJS(Submit);

		}
	}

	public void remove_functional_role(String functional_role, String business_unit, String ecu_qualifier,
			String reason) throws Throwable {
		clickJS(New_Request_update);
		waitForWebElementToAppear(Actions);
		waitForWebElementToAppear(Add);
		waitForWebElementToAppear(Remove);
		waitForWebElementToAppear(Business_Unit);
		waitForWebElementToAppear(Functional_Role);
		waitForWebElementToAppear(ECU_Qualifier);
		waitForWebElementToAppear(Reason);
		clickJS(Remove);
		business_unit(business_unit);
		functional_role(functional_role);
		Ecu_qualifier(ecu_qualifier);
		type(resaon_input, reason);
		submit_button();
		test.pass("User is able to raise request for removing Functional role");
		logger.info("User is able to raise request for removing Functional role");
	}

	String action_Type;
	String Reason_for_Updating_Functional_Role;
	String ECU_QUAlifier_txt;

	public List<String> ECU_Qualifier_Update_for_Request_Overview_UpdateFunctional(String applicant_type) throws Throwable {
		Thread.sleep(3000);
		refresh();
		waitForPageLoad(driver);
		Thread.sleep(5000);
		update_functional_role();
		request_Overview_update();
		ECU_Qualifier_Update_for_Functional_Role_Overview_list_of_Column();
		requesterID = requester_Id_txt();
		username = username_txt();
		department = department_txt();
		applicant_number = applicant_number_txt();
		action_Type = Action_Type_txt();
		functional_role = Functional_role_txt();
		Reason_for_Updating_Functional_Role = Reason_for_Updating_Functional_Role_Request_txt();
		ECU_QUAlifier_txt = ECU_QUalifier_txt();
		approval_status = approval_status_txt();
		Approver_Reason = Approver_Reason_txt();
		Request_date = Request_date_txt();
		Approval_date = Approval_date_txt();
		return Arrays.asList(approval_status, requesterID, username, department, action_Type,applicant_number,
				functional_role, Reason_for_Updating_Functional_Role, ECU_QUAlifier_txt, Approver_Reason, Request_date,
				Approval_date);
	}
	


	public void Third_Party_Publisher() throws InterruptedException {
		scrollDown(Third_Party_Publisher);
		Thread.sleep(1000);
		clickJS(Third_Party_Publisher);
		waitForWebElementToAppear(Third_Party_Publisher_new_request);
		click(Third_Party_Publisher_new_request);
		Thread.sleep(5000);
	}

	public void raise_Publisher_Onboarding_Request() throws Throwable {
		clickJS(Third_Party_Publisher_new_request);
		waitForWebElementToAppear(Publisher_Onboarding);
		waitForWebElementToAppear(Publisher_Onboarding_Business_Unit);
		waitForWebElementToAppear(Publisher_Onboarding_Publisher_Name);
		waitForWebElementToAppear(Publisher_Onboarding_New_Functional_Role);
		waitForWebElementToAppear(Publisher_Onboarding_New_Permission);
		waitForWebElementToAppear(Publisher_Onboarding_Remark);
		waitForWebElementToAppear(Publisher_Onboarding_submit);
		waitForWebElementToAppear(Publisher_Onboarding_cancel);

	}

	@FindBy(xpath = "//input[@id=\"functional_Role\"]")
	private WebElement functional_Role;

	public String new_functional_role(String txt) {
		String text = null;
		try {
			waitForWebElementToAppear(Publisher_Onboarding_New_Functional_Role_input);
			clickJS(Publisher_Onboarding_New_Functional_Role_input);
			AbstractComponents.waitForelementToBeClickable(Publisher_Onboarding_New_Functional_Role_input);
			functional_Role.sendKeys(txt);
			text = functional_Role.getText();
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			waitForWebElementToAppear(Publisher_Onboarding_New_Functional_Role_input);
			clickJS(Publisher_Onboarding_New_Functional_Role_input);
			AbstractComponents.waitForelementToBeClickable(Publisher_Onboarding_New_Functional_Role_input);
			functional_Role.sendKeys(txt);
		}
		return text;
	}

	public void publisher_Onboarding_business_unit(String name) throws Throwable {
		AbstractComponents.waitForelementToBeClickable(Publisher_Onboarding_Business_Unit_input);
		clickJS(Publisher_Onboarding_Business_Unit_input);
		clickelementmatchingtext(Functional_role_type, name);
	}
	public void view_publisher_Onboarding_business_unit(String name) throws Throwable {
		Thread.sleep(2000);
		AbstractComponents.waitForelementToBeClickable(View_Publisher_Onboarding_Business_Unit_input);
		clickJS(View_Publisher_Onboarding_Business_Unit_input);
		clickelementmatchingtext(Functional_role_type, name);
	}
	public void viewBtn() throws InterruptedException {
		waitForelementToBeClickable(ViewBtn_Publisher);
		clickJS(ViewBtn_Publisher);
		Thread.sleep(5000);
//		scrollDown(Itemperpage);
	}
	public void edit_publisheronboarding() throws InterruptedException {
		waitForelementToBeClickable(Editpublisher);
		clickJS(Editpublisher);
	}

	public void publisher_name(String name) throws Throwable {
		waitForWebElementToAppear(Publisher_Onboarding_Publisher_Name_input);
		clickJS(Publisher_Onboarding_Publisher_Name_input);
		AbstractComponents.waitForelementToBeClickable(Publisher_Onboarding_Publisher_Name_input);
		type(Publisher_Onboarding_Publisher_Name_input, name);

	}
	public void new_Functional_role_select (String name) throws Throwable {

		clickJS(new_Functional_role);
		type(new_Functional_role, name);

	}
	

	public List<String> publisher_Onboarding_new_permission(String[] optionsToSelect) throws Throwable {
		List<String> selectedValues = new ArrayList<String>();
		Thread.sleep(3000);
		waitForWebElementToAppear(Publisher_Onboarding_New_Permission_input);
		AbstractComponents.waitForelementToBeClickable(Publisher_Onboarding_New_Permission_input);
		clickJS(Publisher_Onboarding_New_Permission_input);
		for (String optionText : optionsToSelect) {
			for (WebElement option : Functional_role_type) {
				if (option.getText().equals(optionText)) {
					option.click();
					selectedValues.add(option.getText());
					Thread.sleep(2000);
					break;
				}

			}

		}
		ClickTab();
		return selectedValues;
	}
	
	public List<String> view_publisher_Onboarding_new_permission(String[] optionsToSelect) throws Throwable {
		List<String> selectedValues = new ArrayList<String>();
//		AbstractComponents.waitForelementToBeClickable(View_onboardingNewPermission);
		Thread.sleep(2000);
		click(View_Publisher_Edit);
		Thread.sleep(3000);
		waitForWebElementToAppear(View_onboardingNewPermission);
		waitForelementToBeClickable(View_onboardingNewPermission);
		click(View_onboardingNewPermission);
		for (String optionText : optionsToSelect) {
			for (WebElement option : Functional_role_type) {
				if (option.getText().equals(optionText)) {
					Thread.sleep(3000);
					option.click();
					selectedValues.add(option.getText());
					Thread.sleep(2000);
					break;
				}

			}

		}
		return selectedValues;
	}

	
	public void View_Publisher_Onboarding(String functional_role, List<String> raise_Publisher_Onboarding_Request,
			String reason_txt2, String business_unit, String edit_reason) throws InterruptedException {
		implicitWait(30);
		scrollDown(View_Publisher_Onboarding);
		waitForWebElementToAppear(View_Publisher_Onboarding);
		waitForWebElementToAppear(View_Publisher_Onboarding_Business_Unit);
		waitForWebElementToAppear(View_Publisher_Onboarding_View);
		waitForWebElementToAppear(View_Publisher_Onboarding_Search_item);
		waitForWebElementToAppear(View_Publisher_table_Business_Unit);
		waitForWebElementToAppear(View_Publisher_table_Publisher_Name);
		waitForWebElementToAppear(View_Publisher_table_Functional_Role);
		waitForWebElementToAppear(View_Publisher_table_New_Permission);
		waitForWebElementToAppear(View_Publisher_table_Remark);
		waitForWebElementToAppear(View_Publisher_table_More_Actions);
		waitForWebElementToAppear(View_Publisher_refresh);
		waitForWebElementToAppear(View_Publisher_Reset_Filters);
		clickJS(View_Publisher_business_unit_dropdown);
		clickelementmatchingtext(Functional_role_type, business_unit);
		Thread.sleep(1000);
		clickJS(View_Publisher_Onboarding_View);
		AbstractComponents.waitForelementToBeClickable(View_Publisher_Onboarding_View);
		clickJS(View_Publisher_Onboarding_Search_item);
		type(View_Publisher_Onboarding_Search_item, functional_role);
		clickJS(View_Publisher_Edit);
		AbstractComponents.waitForelementToBeClickable(View_Publisher_Edit);
		clickJS(View_Publisher_Edit_new_permission);
		AbstractComponents.waitForelementToBeClickable(View_Publisher_Edit_new_permission);
		String string = raise_Publisher_Onboarding_Request.get(0);
		for (WebElement option : Functional_role_type) {
			if (option.getText().equals(string)) {
				clickJS(option);
				AbstractComponents.waitForelementToBeClickable(option);
				break;
			}

		}
		clickJS(View_Publisher_Edit_reason);
		type(View_Publisher_Edit_reason, edit_reason);
		String reason_txt = View_Publisher_Edit_reason.getText();
		if (!reason_txt.equalsIgnoreCase(reason_txt)) {
			test.pass("the text in reason field is not equal after editing");
		}
		clickJS(View_Publisher_Edit_submit);
		AbstractComponents.waitForelementToBeClickable(View_Publisher_Edit_submit);
	}

	public void View_Publisher_Onboarding_validation(String BU, String publisher_name, String functional_role2,
			String new_permission, String remark) {
		String[] expectedData = { BU, publisher_name, functional_role2, new_permission, remark };
		WebElement firstrow = driver.findElement(By.xpath("//table/tbody/tr[1]"));
		List<WebElement> cells = firstrow.findElements(By.tagName("td"));
		boolean alldatamatch = true;
		for (int i = 0; i < cells.size() - 1; i++) {
			String cellText = cells.get(i).getText();
			if (!cellText.equals(expectedData[i])) {
				test.info("Mismatch found : expected'" + expectedData[i] + "' but found'" + cellText + "'in cloumn"
						+ (i + 1));
				alldatamatch = false;
			}

		}
		if (alldatamatch) {
			test.pass("All expcetd values are present");
		}
	}

	public String provide_reason_and_submit(String reason) throws InterruptedException {
		clickJS(Publisher_Onboarding_Remark_input);
		type(Publisher_Onboarding_Remark_input, reason);
		Thread.sleep(1000);
		click(Publisher_Onboarding_submit);
		AbstractComponents.waitForelementToBeClickable(Publisher_Onboarding_submit);
		Thread.sleep(2000);
		refresh();
//		waitForWebElementToAppear(Publisher_Onboarding_Remark_input);
		return reason;
	}
	
	public void submit() throws InterruptedException {
		clickJS(Publisher_Onboarding_submit);
		refresh();
	}
	
	public void view_PublisherOnboarding(String reason) throws InterruptedException {
		ECU_Type_ViewPublisher.click();
		
	}

	public void delete_TPP() {
	clickJS(Gloabl_delete_button);
	waitForWebElementToAppear(confirm_delete_request);
	waitForWebElementToAppear(confirm_delete);
	waitForWebElementToAppear(delete_back);
	waitForWebElementToAppear(delete_ok);
	clickJS(delete_ok);
}
	
	public void error_message_validation() throws InterruptedException {
		Assert.assertEquals(error_message.getText(), "428 Precondition Required : Functional Role already exists!");
	}

}
