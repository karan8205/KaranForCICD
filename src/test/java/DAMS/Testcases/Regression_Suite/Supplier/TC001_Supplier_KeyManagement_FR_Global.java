package DAMS.Testcases.Regression_Suite.Supplier;

import static DAMS.Resources.Listeners.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import DAMS.Resources.AbstractComponents;
import DAMS.Resources.BaseClass;
import DAMS.Testcases.Smoke_Suite_1.TC01_Login_MFA;
import DAMS.Testcases.Smoke_Suite_1.TC06_STD_GLOBAL_FRapproved;
import DAMS.Testcases.Smoke_Suite_1.TC11_EnhanceRightAuthority_GLOBAL;
import DAMS.Testcases.Smoke_Suite_1.TC13_EnhanceRightAuthority_GLOBAL_Approved;
import DAMS.Testcases.Smoke_Suite_1.TC17_NestT_TestCOT_GLOBAL;
import DAMS.Testcases.Smoke_Suite_1.TC19_NestT_TestCOT_GLOBAL_Approved;
import DAMS.Testcases.Smoke_Suite_1.TC31_ReplacementPackage_RootBackend_Swap_Swap_GLOBAL_Approved;


public class TC001_Supplier_KeyManagement_FR_Global extends BaseClass {

	@Test(dataProvider = "getData_Supplier", priority = 0)
	public static void development_Global_Regression_E2E_Supplier(
			HashMap<String, String> input) throws Throwable {
//		TC01_Login_MFA.login_with_addressing_MFA();
//		Thread.sleep(7000);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Supplier Standard Functional Request:" + "</u></i></b>");
		TC06_STD_GLOBAL_FRapproved.Functional_role_request_approved_Supplier(input);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Standard Functional Request for Supplier- status Approved:" + "</u></i></b>");
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Diagnostic Authority - Supplier" + "</u></i></b>");
		AbstractComponents.refresh();
		myreq.select_NewPermission_request();
		 //bending DA
		newper.Diagnostic_Authority_Supplier_Created(input);
		req.request_Overview();
		Thread.sleep(1000);
		req.select_Applicant_type("Myself");
		Thread.sleep(2000);
		approver_overview.filter_search(prop.getStatus_pending());
		req.scrollForReason();	
		approve_DA_request(input);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Diagnostic Authority for Supplier- status Approved:" + "</u></i></b>");
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Enhance Right Authority - Supplier" + "</u></i></b>");
		AbstractComponents.refresh();
		// ER Bending
		TC11_EnhanceRightAuthority_GLOBAL.create_Enhance_Right_Authority_request_Supplier(input);
		req.request_Overview();
		req.select_request_type("Enhance Right");
		req.select_Applicant_type("Myself");
		Thread.sleep(2000);
		approver_overview.filter_search(prop.getStatus_pending());
		req.scrollForReason();
		// approve EA
		TC13_EnhanceRightAuthority_GLOBAL_Approved.approve_Enhance_Right_Authority_request(input);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Enhance Right Authority for Supplier- status Approved:" + "</u></i></b>");
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Nest-T Testing - Supplier" + "</u></i></b>");
		AbstractComponents.refresh();	
		List<String >create_replacement_package_request_id_front = create_replacement_package_request_root(input);
		approve_special_cases_Replacement_request(input,create_replacement_package_request_id_front);
		List<String >create_replacement_package_request_id_back = create_replacement_package_request_backend(input);
		approve_special_cases_Replacement_request(input,create_replacement_package_request_id_back);
		List<String >create_replacement_package_request_ids = create_replacement_package_request_rootbackend(input);
		approve_special_cases_Replacement_request(input,create_replacement_package_request_ids);	
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Replacement Package for Supplier- status Approved:" + "</u></i></b>");
		test.info("************************************ Global End to End Completed *************************");
		logger.info("************************************ Global End to End Completed *************************");
		softAssertionALL();
	}
	
	@DataProvider
	public Object[][] getData_Supplier() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data_Regression///03_Supplier_End_to-end_functionality.json");
		return new Object[][] { { data.get(0) } };
	}
	
	public static void approve_DA_request(HashMap<String, String> input)
			throws Throwable {
		String create_DA_requests=input.get("User_role");
		List<String> applicantNumber=req.getMultipleApplicantNumber();
		
		String[] DA_requests=create_DA_requests.split("/");
		
		List<String> DA_req= new ArrayList<>();
		logger.info(""+DA_requests.length);
		for(int i=DA_requests.length-1;i>=0;i--) {
			DA_req.add(DA_requests[i]);
		}

		for(int i=0;i<DA_req.size();i++) {		
		String create_DA_request = DA_req.get(i);
		String id=applicantNumber.get(i);
		
		logger.info(" ************* "+create_DA_request);
		logger.info(" ************* "+id);
		if (create_DA_request.equals("Development ENHANCED") || create_DA_request.equals("Production")
				|| create_DA_request.equals("After-Sales ENHANCED")) {
			String DA_approval_status_after_level1_approval = approver_overview
					.approvetheDA_Request("Diagnostic Authority", prop.getStatus_pending(), id);
			s.assertTrue(DA_approval_status_after_level1_approval.equals(prop.getStatus_Approved()));
		
			test.pass("User is able to view the approval status as Approved after 1st level approval");
			logger.info("User is able to view the approval status as Approved after 1st level approval");
			req.navigate_to_request_Overview_page_and_verify_approval_status_DA(prop.getStatus_pending(), "N/A", "N/A",
					"Diagnostic Authority", id);		
			test.pass(
					"User is able to view navigate to request overview page and check if the status is pending after 1st level approval");
			logger.info(
					"User is able to view navigate to request overview page and check if the status is pending after 1st level approval");
			String DA_approval_status_after_level2_approval = approver_overview
					.approvetheDA_Request("Diagnostic Authority", prop.getStatus_pending(), id);
			s.assertTrue(DA_approval_status_after_level2_approval.equals(prop.getStatus_Approved()));
			test.pass("User is able to view the approval status as Approved after 2nd level approval");
			logger.info("User is able to view the approval status as Approved after 2nd level approval");
			String todays_date = todays_date();
			req.navigate_to_request_Overview_page_and_verify_approval_status_DA(prop.getStatus_Approved(), todays_date,
					"N/A", "Diagnostic Authority", id);
			test.pass(
					"User is able to view navigae to request overview page and check if the status is approved after 2nd level approval");
			logger.info(
					"User is able to view navigae to request overview page and check if the status is approved after 2nd level approval");
		} else {
			String DA_approval_status_after_level2_approval = approver_overview
					.approvetheDA_Request("Diagnostic Authority", prop.getStatus_pending(), create_DA_request);
			s.assertTrue(DA_approval_status_after_level2_approval.equals(prop.getStatus_Approved()));
			test.pass("User is able to view the approval status as Approved after 1st level approval");
			logger.info("User is able to view the approval status as Approved after 1st level approval");
			String todays_date = todays_date();
			req.navigate_to_request_Overview_page_and_verify_approval_status_DA(prop.getStatus_Approved(), todays_date,
					"N/A", "Diagnostic Authority", id,input.get("User_role"));
			test.pass(
					"User is able to view navigae to Functioanl role overview page and check if the status is approved after 1st level approval");
			logger.info(
					"User is able to view navigae to Functioanl role overview page and check if the status is approved after 1st level approval");
		}
		}
	}	
	public static void approve_Multiple_special_cases_nestT_request(HashMap<String, String> input) throws Throwable {
		req.request_Overview();	
		String NestT_approval_status_after_level1_approval = approver_overview.approve_Multiple_nestT_Request("Nest T Testing","Nest-T Testing",prop.getStatus_pending());
//		s.assertTrue(NestT_approval_status_after_level1_approval.equals(prop.getStatus_Approved()));
		test.pass("User is able to view the approval status as Approved after 1st level approval");
		logger.info("User is able to view the approval status as Approved after 1st level approval");
		req.navigate_to_request_Overview_page_and_verify_approval_status_RP_NestT(prop.getStatus_pending(), "N/A", "N/A",
				"Nest-T Testing", prop.getUser_name()); 
		test.pass(
				"User is able to view navigate to request role overview page and check if the status is pending after 1st level approval");
		logger.info(
				"User is able to view navigate to request role overview page and check if the status is pending after 1st level approval");
		String NestT_approval_status_after_level2_approval = approver_overview.approve_Multiple_nestT_Request("Nest T Testing","Nest-T Testing",prop.getStatus_pending());
		s.assertTrue(NestT_approval_status_after_level2_approval.equals(prop.getStatus_Approved()));
		test.pass("User is able to view the approval status as Approved after 2nd level approval");
		logger.info("User is able to view the approval status as Approved after 2nd level approval");
		String todays_date = todays_date();
		req.navigate_to_request_Overview_page_and_verify_approval_status_RP_NestT(prop.getStatus_Approved(), todays_date, "N/A",
				"Nest-T Testing", prop.getUser_name());
		test.pass(
				"User is able to view navigate to request role overview page and check if the status is approved after 2nd level approval");
		logger.info(
				"User is able to view navigate to request role overview page and check if the status is appproved after 2nd level approval");
	}

	public static List<String> create_replacement_package_request_rootbackend(HashMap<String, String> input) throws Throwable {
		test.info("Replacement package request");
		logger.info("Replacement package request");
		myreq.select_NewPermission_request();		
		boolean request_Overview_enabled = newper.raise_Multiple_replacement_package_Request_Supplier(input);
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
	
	public static List<String> create_replacement_package_request_root(HashMap<String, String> input) throws Throwable {
		test.info("Replacement package request");
		logger.info("Replacement package request");
		myreq.select_NewPermission_request();		
		boolean request_Overview_enabled = newper.raise_replacement_package_Request(input.get("Functional_role_Certificate"),input.get("SpecialCase"),
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
		boolean request_Overview_enabled = newper.raise_replacement_package_Request(input.get("Functional_role_Certificate"),input.get("SpecialCase"), input.get("Reason_for_RP"),
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
	
	
}
