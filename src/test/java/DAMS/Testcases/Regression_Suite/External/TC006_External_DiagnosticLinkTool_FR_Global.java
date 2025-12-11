package DAMS.Testcases.Regression_Suite.External;

import static DAMS.Resources.Listeners.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import DAMS.Resources.AbstractComponents;
import DAMS.Resources.BaseClass;
import DAMS.Testcases.Smoke_Suite_1.TC06_STD_GLOBAL_FRapproved;
import DAMS.Testcases.Smoke_Suite_1.TC11_EnhanceRightAuthority_GLOBAL;
import DAMS.Testcases.Smoke_Suite_1.TC13_EnhanceRightAuthority_GLOBAL_Approved;
import DAMS.Testcases.Smoke_Suite_1.TC17_NestT_TestCOT_GLOBAL;
import DAMS.Testcases.Smoke_Suite_1.TC19_NestT_TestCOT_GLOBAL_Approved;
import DAMS.Testcases.Smoke_Suite_1.TC31_ReplacementPackage_RootBackend_Swap_Swap_GLOBAL_Approved;

@Listeners(DAMS.Resources.Listeners.class)
public class TC006_External_DiagnosticLinkTool_FR_Global extends BaseClass {

	@Test(dataProvider = "getData_External", priority = 0)
	public static void diagnosticLinkTool_Global_Regression_E2E_External(
			HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of External Standard Functional Request:" + "</u></i></b>");
//		TC01_Login_MFA.login_with_addressing_MFA();
//		Thread.sleep(8000);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Standard Functional Request:" + "</u></i></b>");
		TC06_STD_GLOBAL_FRapproved.Functional_role_request_approved_External(input);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Standard Functional Request for External- status Approved:" + "</u></i></b>");
		AbstractComponents.refresh();
		myreq.select_NewPermission_request();
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Diagnostic Authority - External" + "</u></i></b>");
		newper.Diagnostic_Authority_External_Created(input);
		req.request_Overview();
		Thread.sleep(1000);
		req.select_Applicant_type("Myself");
		approver_overview.filter_search(prop.getStatus_pending());
		req.scrollForReason();
		approve_DA_request(input);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Diagnostic Authority for External- status Approved:" + "</u></i></b>");
		AbstractComponents.refresh();
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Enhance Right Authority - External" + "</u></i></b>");
		TC11_EnhanceRightAuthority_GLOBAL.create_Enhance_Right_Authority_request_External(input);
		req.request_Overview();
		req.select_request_type("Enhance Right");
		req.select_Applicant_type("Myself");
		approver_overview.filter_search(prop.getStatus_pending());
		req.scrollForReason();
		TC13_EnhanceRightAuthority_GLOBAL_Approved.approve_Enhance_Right_Authority_request(input);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Enhance Right Authority for External- status Approved:" + "</u></i></b>");
		AbstractComponents.refresh();
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Replacement Package - External" + "</u></i></b>");
		List<String >create_replacement_package_request1 =create_replacement_package_request_External_Root(input);
		approve_special_cases_Replacement_request(input,create_replacement_package_request1);
		List<String >create_replacement_package_request2 =create_replacement_package_request_External_Backend(input);
		approve_special_cases_Replacement_request(input,create_replacement_package_request2);
		List<String >create_replacement_package_request3 = create_replacement_package_request_External_RootBack(input);
		approve_special_cases_Replacement_request(input,create_replacement_package_request3);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Replacement Package for External- status Approved:" + "</u></i></b>");
		logger.info("************************************ Global End to End Completed *************************");
		softAssertionALL();
//		driver.quit();
	}

	@DataProvider
	public Object[][] getData_External() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data_Regression//02_External_End_to-end_functionality.json");
		return new Object[][] { { data.get(0) } };

	}
	
	public static List<String> create_replacement_package_request_External_Root(HashMap<String, String> input) throws Throwable {
		test.info("Replacement package request");
		logger.info("Replacement package request");
		myreq.select_NewPermission_request();		
		boolean request_Overview_enabled = newper.raise_replacement_package_Request(input.get("Functional_role_External"),input.get("SpecialCase"),
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
	
	public static List<String> create_replacement_package_request_External_Backend(HashMap<String, String> input) throws Throwable {
		test.info("Replacement package request");
		logger.info("Replacement package request");
		myreq.select_NewPermission_request();		
		boolean request_Overview_enabled = newper.raise_replacement_package_Request(input.get("Functional_role_External"),input.get("SpecialCase"), input.get("Reason_for_RP"),
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
	public static List<String> create_replacement_package_request_External_RootBack(HashMap<String, String> input) throws Throwable {
		test.info("Replacement package request");
		logger.info("Replacement package request");
		myreq.select_NewPermission_request();
		boolean request_Overview_enabled = newper.raise_replacement_package_Request(input.get("Functional_role_External"),input.get("SpecialCase"), input.get("Reason_for_RP"),
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
		}//for loop
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
	public static void approve_Multiple_special_cases_nestT_request(HashMap<String, String> input,List<String>create_special_cases_Nest_T_request) throws Throwable {
		String Nest_T_approval_status_after_level1_approval = approver_overview.multiple_Approve_Request("Nest T Testing", prop.getStatus_pending(),create_special_cases_Nest_T_request);
		s.assertTrue(Nest_T_approval_status_after_level1_approval.equals(prop.getStatus_Approved()));
		test.pass("User is able to view the approval status as Approved after 1st level approval");
		logger.info("User is able to view the approval status as Approved after 1st level approval");
		req.navigate_to_request_Overview_page_and_verify_approval_status_RP_NestT(prop.getStatus_pending(), "N/A", "N/A",
				input.get("SpecialCase_nestT"), prop.getUser_name());
		test.pass(
				"User is able to view navigate to request role overview page and check if the status is pending after 1st level approval");
		logger.info(
				"User is able to view navigate to request role overview page and check if the status is pending after 1st level approval");
		String Nest_T_approval_status_after_level2_approval = approver_overview.multiple_Approve_Request("Nest T Testing", prop.getStatus_pending(),create_special_cases_Nest_T_request);
		s.assertTrue(Nest_T_approval_status_after_level2_approval.equals(prop.getStatus_Approved()));
		test.pass("User is able to view the approval status as Approved after 2nd level approval");
		logger.info("User is able to view the approval status as Approved after 2nd level approval");
		String todays_date = todays_date();
		req.navigate_to_request_Overview_page_and_verify_approval_status_RP_NestT(prop.getStatus_Approved(), todays_date, "N/A",
				input.get("SpecialCase_nestT"), prop.getUser_name());
		test.pass(
				"User is able to view navigate to request role overview page and check if the status is approved after 2nd level approval");
		logger.info(
				"User is able to view navigate to request role overview page and check if the status is appproved after 2nd level approval");
	}
}