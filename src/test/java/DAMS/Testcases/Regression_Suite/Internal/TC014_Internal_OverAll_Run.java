package DAMS.Testcases.Regression_Suite.Internal;

import static DAMS.Resources.Listeners.test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import DAMS.Resources.AbstractComponents;
import DAMS.Resources.BaseClass;
import DAMS.Resources.Listeners;
import DAMS.Testcases.Smoke_Suite_1.TC01_Login_MFA;
import DAMS.Testcases.Smoke_Suite_1.TC02_Requests_STD_GLOBAL;
import DAMS.Testcases.Smoke_Suite_1.TC03_Requests_STD_ATG_FR;
import DAMS.Testcases.Smoke_Suite_1.TC06_STD_GLOBAL_FRapproved;
import DAMS.Testcases.Smoke_Suite_1.TC07_STD_ATG_FRapproved;
import DAMS.Testcases.Smoke_Suite_1.TC10_Diagnostic_Authority_GLOBAL_Approved;
import DAMS.Testcases.Smoke_Suite_1.TC11_EnhanceRightAuthority_GLOBAL;
import DAMS.Testcases.Smoke_Suite_1.TC13_EnhanceRightAuthority_GLOBAL_Approved;


public class TC014_Internal_OverAll_Run extends BaseClass {

	
	public static String select_user_type ="";
	
	@BeforeSuite
	public void login() throws Throwable {
		try {
			 if (Listeners.test == null) {
			        Listeners.test = Listeners.extent.createTest("Login setup");
			    }
		System.out.println("**************** Started ***************");
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Internal Functional role request - status pending:" + "</u></i></b>");
		TC01_Login_MFA.login_with_addressing_MFA();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	
	@Test(dataProvider = "getData_Internal", priority = 0)
	public static void development_Global_Regression_E2E_Internal(HashMap<String, String> input) throws Throwable {
		try {
		System.out.println("\n"+input+"\n");
		String Functional_Role = input.get("Functional_role_internal");
		String mode = input.get("Mode");
		if(mode.equalsIgnoreCase("Global")) {
		select_user_type = TC02_Requests_STD_GLOBAL.select_user_Global(prop.get_user_type_Internal());
		String functional_role_selected =TC02_Requests_STD_GLOBAL. raise_Internal_functional_role(input);
		test.pass("Request created and in pending status " + functional_role_selected);
		logger.info("Request created and in pending status " + functional_role_selected);
		TC02_Requests_STD_GLOBAL.functional_role_Overview_table_validation(select_user_type);
		TC06_STD_GLOBAL_FRapproved.create_and_approve_Internal_FR_request(input);
		}
		else if(mode.equalsIgnoreCase("ATG")) {
			String select_user_type =login_and_select_user_ATG(prop.get_user_type_Internal());
			String functional_role_selected = TC03_Requests_STD_ATG_FR.raise_Internal_functional_role(input);
			test.pass("User is able to raise the request for the functional role " + functional_role_selected);
			logger.info("User is able to raise the request for the functional role " + functional_role_selected);
			TC07_STD_ATG_FRapproved.create_and_approve_Internal_FR_request(input);
		}
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"+ "***************"+Functional_Role+" Functional Role Approved *************" + "</u></i></b>");
	// --------------------------------------------
//		AbstractComponents.refresh();
//		waitForPageLoad(driver);
//		myreq.select_NewPermission_request();
//		newper.Diagnostic_Authority_ECU_Visible_or_not_for_pending_Approved(input);
//		req.request_Overview();
//			Thread.sleep(3000);
//			req.select_Applicant_type("Myself");
//			Thread.sleep(2000);
//			approver_overview.filter_search(prop.getStatus_pending());
//			req.scrollForReason();	
//			List<String> applicantNumber=req.getMultipleApplicantNumber();
//			TC10_Diagnostic_Authority_GLOBAL_Approved.approve_DA_request(input);
//			test.log(Status.PASS, "<span style=\"color: blue;\"><b><i><u>"+ "***************"+applicantNumber+" DA Approved *************" + "</u></i></b>");
//			logger.info("Verify selected ecu is not visible when the status is in approved");
//			test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
//					+ "Creation of Enhance Right Authority - Internal" + "</u></i></b>");
//			AbstractComponents.refresh();
//			TC11_EnhanceRightAuthority_GLOBAL.create_Enhance_Right_Authority_request(input);
//			Thread.sleep(5000);
//			req.request_Overview();
//			req.select_request_type("Enhance Right");
//			req.select_Applicant_type("Myself");
//			Thread.sleep(2000);
//			approver_overview.filter_search(prop.getStatus_pending());
//			req.scrollForReason();
//			List<String> EA_applicantNumber=req.getMultipleApplicantNumber();
//
//			TC13_EnhanceRightAuthority_GLOBAL_Approved.approve_Enhance_Right_Authority_request(input);
//			test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"+EA_applicantNumber+ "Enhance Right Authority for Internal- status Approved:" + "</u></i></b>");
//			AbstractComponents.refresh();
	  if(!Functional_Role.equalsIgnoreCase("Production")) {
		  if(Functional_Role.equalsIgnoreCase("Development")||Functional_Role.equalsIgnoreCase("Development - ATG")) {
//				AbstractComponents.refresh();
//				myreq.select_NewPermission_request();
//				newper.raise_nestT_Request_Multiple(input);
//				approve_Multiple_special_cases_nestT_request(input);	
//				test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"+ "Nest-T Testing for Internal- status Approved:" + "</u></i></b>");
//				test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"+ "Creation of Replacement Package - Internal" + "</u></i></b>");
//				AbstractComponents.refresh();
		  }
				List<String >create_replacement_package_request_id_front = create_replacement_package_request_root(input);
				waitForPageLoad(driver);
				Thread.sleep(3000);
				approve_special_cases_Replacement_request(input,create_replacement_package_request_id_front);
				waitForPageLoad(driver);
				Thread.sleep(3000);
				List<String >create_replacement_package_request_id_back = create_replacement_package_request_backend(input);
				approve_special_cases_Replacement_request(input,create_replacement_package_request_id_back);
				waitForPageLoad(driver);
				Thread.sleep(3000);
				List<String >create_replacement_package_request_ids = create_replacement_package_request_rootbackend(input);
				waitForPageLoad(driver);
				Thread.sleep(3000);
				approve_special_cases_Replacement_request(input,create_replacement_package_request_ids);	
				test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"+ "Replacement Package for Internal- status Approved:" + "</u></i></b>");
			}
			
	  AbstractComponents.refresh();
	  waitForPageLoad(driver);
	  Thread.sleep(5000);
	  approver_overview. approver_Overview_enabled1();
	  approver_overview.search_here(prop.getUser_name());
	  getScreenshot(input.get("Mode")+"_"+input.get("User_Type")+"_ All Request", driver);
		}
		catch(Exception e) {
			e.printStackTrace();
			String filePath = null;
			filePath = getScreenshot(input.get("Functional_role_internal")+ "error page", driver);
		}
	// after 1 data run
		AbstractComponents.refresh();
		Thread.sleep(5000);
		myreq. clickHomeButton();
	} 
//	
	
	
	@DataProvider
	public Object[][] getData_Internal() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data_Regression//01_Internal_End_to-end_functionality.json");
		return new Object[][] { { data.get(0) },{data.get(7)} };
	}
	
	public static void approve_Multiple_special_cases_nestT_request(HashMap<String, String> input) throws Throwable {
		req.request_Overview();	
		String NestT_approval_status_after_level1_approval = approver_overview.approve_Multiple_nestT_Request("Nest T Testing","Nest-T Testing",prop.getStatus_pending());
//		s.assertTrue(NestT_approval_status_after_level1_approval.equals(prop.getStatus_Approved()));
		test.pass("User is able to view the approval status as Approved after 1st level approval");
		logger.info("User is able to view the approval status as Approved after 1st level approval");
		req.navigate_to_request_Overview_page_and_verify_approval_status_RP_NestT(prop.getStatus_pending(), "N/A", "N/A","Nest-T Testing", prop.getUser_name()); 
		test.pass("User is able to view navigate to request role overview page and check if the status is pending after 1st level approval");
		logger.info("User is able to view navigate to request role overview page and check if the status is pending after 1st level approval");
		String NestT_approval_status_after_level2_approval = approver_overview.approve_Multiple_nestT_Request("Nest T Testing","Nest-T Testing",prop.getStatus_pending());
		s.assertTrue(NestT_approval_status_after_level2_approval.equals(prop.getStatus_Approved()));
		test.pass("User is able to view the approval status as Approved after 2nd level approval");
		logger.info("User is able to view the approval status as Approved after 2nd level approval");
		String todays_date = todays_date();
		req.navigate_to_request_Overview_page_and_verify_approval_status_RP_NestT(prop.getStatus_Approved(), todays_date, "N/A","Nest-T Testing", prop.getUser_name());
		test.pass("User is able to view navigate to request role overview page and check if the status is approved after 2nd level approval");
		logger.info("User is able to view navigate to request role overview page and check if the status is appproved after 2nd level approval");
	}

	public static List<String> create_replacement_package_request_rootbackend(HashMap<String, String> input) throws Throwable {
		test.info("Replacement package request");
		logger.info("Replacement package request");
		myreq.select_NewPermission_request();		
		boolean request_Overview_enabled = newper.raise_Multiple_replacement_package_Request(input);
		Assert.assertTrue(request_Overview_enabled);
		test.info("Request overview tab enabled");
		logger.info("Request overview tab enabled"); 
		List<String> replacement_package_table_input = req.multiple_Request_Table_Validation_for_replacement_package("Replacement Package", prop.getUser_name());
//		Assert.assertTrue(replacement_package_table_input.get(0).equals(prop.getStatus_pending()));
		test.pass("User is able to view the approval status as pending once the Replacement package request created");
		logger.info("User is able to view the approval status as pending once the Replacement package request created");
		return replacement_package_table_input;
	}
	
	public static List<String> create_replacement_package_request_root(HashMap<String, String> input) throws Throwable {
		test.info("Replacement package request");
		logger.info("Replacement package request");
		myreq.select_NewPermission_request();		
		boolean request_Overview_enabled = newper.raise_replacement_package_Request(input.get("Functional_role_internal"),input.get("SpecialCase"),
				input.get("Orgin_COT"), input.get("Reason_for_RP"), input.get("Target_COT"),
				input.get("ECU_Qualifier_for_Root_link"));
		Assert.assertTrue(request_Overview_enabled);
		test.info("Request overview tab enabled");
		logger.info("Request overview tab enabled"); 
		List<String> replacement_package_table_input = req
				.multiple_Request_Table_Validation_for_replacement_package("Replacement Package", prop.getUser_name());
//		Assert.assertTrue(replacement_package_table_input.get(0).equals(prop.getStatus_pending()));
		test.pass("User is able to view the approval status as pending once the Replacement package request created");
		logger.info("User is able to view the approval status as pending once the Replacement package request created");
		return replacement_package_table_input;
	}
	
	public static List<String> create_replacement_package_request_backend(HashMap<String, String> input) throws Throwable {
		test.info("Replacement package request");
		logger.info("Replacement package request");
		myreq.select_NewPermission_request();		
		boolean request_Overview_enabled = newper.raise_replacement_package_Request(input.get("Functional_role_internal"),input.get("SpecialCase"), input.get("Reason_for_RP"),
				input.get("ECU_Qualifier_for_Backend_link"),input.get("BackendRoot_COT"),input.get("BackendOrigin_COT"),input.get("BackendTarget_COT"));
		Assert.assertTrue(request_Overview_enabled);
		test.info("Request overview tab enabled");
		logger.info("Request overview tab enabled"); 
		List<String> replacement_package_table_input = req
				.multiple_Request_Table_Validation_for_replacement_package("Replacement Package", prop.getUser_name());
//		Assert.assertTrue(replacement_package_table_input.get(0).equals(prop.getStatus_pending()));
		test.pass("User is able to view the approval status as pending once the Replacement package request created");
		logger.info("User is able to view the approval status as pending once the Replacement package request created");
		return replacement_package_table_input;
	}
	
	
	public static void approve_special_cases_Replacement_request(HashMap<String, String> input,
			List<String> create_special_cases_Replacement_request) throws Throwable {
		String Replacement_approval_status_after_level1_approval = approver_overview.multiple_Approve_Request("Replacement Package", prop.getStatus_pending(),create_special_cases_Replacement_request);
		s.assertTrue(Replacement_approval_status_after_level1_approval.equals(prop.getStatus_Approved()));
		test.pass("User is able to view the approval status as Approved after 1st level approval");
		logger.info("User is able to view the approval status as Approved after 1st level approval");
		req.navigate_to_request_Overview_page_and_verify_approval_status_RP_NestT(prop.getStatus_pending(), "N/A", "N/A",
				input.get("SpecialCase"), prop.getUser_name());
		test.pass(
				"User is able to view navigate to request role overview page and check if the status is pending after 1st level approval");
		logger.info(
				"User is able to view navigate to request role overview page and check if the status is pending after 1st level approval");
		String Replacement_approval_status_after_level2_approval = approver_overview.multiple_Approve_Request("Replacement Package", prop.getStatus_pending(),create_special_cases_Replacement_request);
		s.assertTrue(Replacement_approval_status_after_level2_approval.equals(prop.getStatus_Approved()));
		test.pass("User is able to view the approval status as Approved after 2nd level approval");
		logger.info("User is able to view the approval status as Approved after 2nd level approval");
		String todays_date = todays_date();
		req.navigate_to_request_Overview_page_and_verify_approval_status_RP_NestT(prop.getStatus_Approved(), todays_date, "N/A",
				input.get("SpecialCase"), prop.getUser_name());
		test.pass(
				"User is able to view navigate to request role overview page and check if the status is approved after 2nd level approval");
		logger.info(
				"User is able to view navigate to request role overview page and check if the status is appproved after 2nd level approval");
	}
	public static String login_and_select_user_ATG(String user_type) throws Throwable {
	    // hari
	    h.dropBtn();
	    Thread.sleep(3000);	 
	    String select_user_type = null;

	    if ("Internal".equalsIgnoreCase(user_type)) {
	        h.click_here_to_apply_for_functional_roles_click();
	        select_user_type = user_type;
	    } else {
	        select_user_type = h.select_user_type(user_type);
	        test.log(Status.INFO, "User is selects the type:" + "<span style=\"color: blue;\"><b><i><u>"
	                + select_user_type + "</u></i></b>");
	    }
	    
	    Thread.sleep(3000);
	    gtc.gtc_page_validation();
	    test.info("User validates the gtc page");
	    logger.info("User validates the gtc page");
	    Thread.sleep(5000);

	    Robot robot = new Robot();
	    logger.info("About to zoom out");
	    for (int i = 0; i < 2; i++) {
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_SUBTRACT);
	        robot.keyRelease(KeyEvent.VK_SUBTRACT);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	    }	    
	    newrequest.select_vehicle_program_ATG();      
	    newrequest.functional_role_page_validation(prop.get_for_whom_txt(), prop.get_myself_txt(),
	            prop.get_Functional_role_txt());	    
	    test.pass("validates the functional role page");
	    logger.info("validates the functional role page");
	    logger.info("*************" + select_user_type);    
	    return select_user_type;
	}
	
}
