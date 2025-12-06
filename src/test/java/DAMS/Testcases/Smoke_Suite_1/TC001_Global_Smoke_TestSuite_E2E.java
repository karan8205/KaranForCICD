package DAMS.Testcases.Smoke_Suite_1;

import static DAMS.Resources.Listeners.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import DAMS.Resources.AbstractComponents;
import DAMS.Resources.BaseClass;


public class TC001_Global_Smoke_TestSuite_E2E extends BaseClass {

	@Test(dataProvider = "getData_Internal")
	public static void global_Smoke_TestSuite_E2E_Internal(
			HashMap<String, String> input) throws Throwable {
//		TC01_Login_MFA.login_with_addressing_MFA();
//		Thread.sleep(5000);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Internal Standard Functional Request:" + "</u></i></b>");
		TC06_STD_GLOBAL_FRapproved.Functional_role_request_approved_Internal(input);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Standard Functional Request for Internal- status Approved:" + "</u></i></b>");
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Diagnostic Authority - Internal" + "</u></i></b>");
		AbstractComponents.refresh();
		myreq.select_NewPermission_request();
		newper.Diagnostic_Authority_ECU_Visible_or_not_for_pending_Approved(input);
		req.request_Overview();
		Thread.sleep(1000);
		req.select_Applicant_type("Myself");
		Thread.sleep(2000);
		approver_overview.filter_search(prop.getStatus_pending());
		req.scrollForReason();	
		approve_DA_request(input);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Diagnostic Authority for Internal- status Approved:" + "</u></i></b>");
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Enhance Right Authority - Internal" + "</u></i></b>");
		AbstractComponents.refresh();
		TC11_EnhanceRightAuthority_GLOBAL.create_Enhance_Right_Authority_request(input);
		req.request_Overview();
		req.select_request_type("Enhance Right");
		req.select_Applicant_type("Myself");
		Thread.sleep(2000);
		approver_overview.filter_search(prop.getStatus_pending());
		req.scrollForReason();
		TC13_EnhanceRightAuthority_GLOBAL_Approved.approve_Enhance_Right_Authority_request(input);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Enhance Right Authority for Internal- status Approved:" + "</u></i></b>");
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Nest-T Testing - Internal" + "</u></i></b>");
		AbstractComponents.refresh();
		List<String >create_special_cases_nestT_request=TC17_NestT_TestCOT_GLOBAL. create_special_cases_nestT_request(input);
		TC19_NestT_TestCOT_GLOBAL_Approved.approve_specail_cases_nestT_request(input, create_special_cases_nestT_request);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Nest-T Testing for Internal- status Approved:" + "</u></i></b>");
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Replacement Package - Internal" + "</u></i></b>");
		AbstractComponents.refresh();
		List<String >create_replacement_package_request = TC31_ReplacementPackage_RootBackend_Swap_Swap_GLOBAL_Approved.create_replacement_package_request(input);
		TC31_ReplacementPackage_RootBackend_Swap_Swap_GLOBAL_Approved.approve_special_cases_Replacement_request(input,create_replacement_package_request);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Replacement Package for Internal- status Approved:" + "</u></i></b>");
		logger.info("************************************ Global End to End Completed *************************");
		softAssertionALL();
//		driver.quit();
	}

	@Test(dataProvider = "getData_External", priority = 1,enabled=false)
	public static void global_Smoke_TestSuite_E2E_External(
			HashMap<String, String> input) throws Throwable {
//		TC01_Login_MFA.login_with_addressing_MFA();
//		Thread.sleep(5000);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of External Standard Functional Request:" + "</u></i></b>");
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
				+ "Creation of Nest-T Testing - External" + "</u></i></b>");
		List<String >create_special_cases_nestT_request=TC17_NestT_TestCOT_GLOBAL. create_special_cases_nestT_request_External(input);
		TC19_NestT_TestCOT_GLOBAL_Approved.approve_specail_cases_nestT_request(input, create_special_cases_nestT_request);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Nest-T Testing for External- status Approved:" + "</u></i></b>");
		AbstractComponents.refresh();
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Replacement Package - External" + "</u></i></b>");
		List<String >create_replacement_package_request = TC31_ReplacementPackage_RootBackend_Swap_Swap_GLOBAL_Approved.create_replacement_package_request_External(input);
		TC31_ReplacementPackage_RootBackend_Swap_Swap_GLOBAL_Approved.approve_special_cases_Replacement_request_External(input,create_replacement_package_request);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Replacement Package for External- status Approved:" + "</u></i></b>");
		logger.info("************************************ Global End to End Completed *************************");
		softAssertionALL();
//		driver.quit();
	}

	@Test(dataProvider = "getData_Supplier", priority = 2,enabled=false)
	public static void global_Smoke_TestSuite_E2E_Supplier(
			HashMap<String, String> input) throws Throwable {
//		TC01_Login_MFA.login_with_addressing_MFA();
//		Thread.sleep(5000);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Standard Functional Request:" + "</u></i></b>");
		TC06_STD_GLOBAL_FRapproved.Functional_role_request_approved_Supplier(input);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Standard Functional Request for Supplier- status Approved:" + "</u></i></b>");
		AbstractComponents.refresh();
		myreq.select_NewPermission_request();
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Diagnostic Authority - Supplier" + "</u></i></b>");
		newper.Diagnostic_Authority_Supplier_Created(input);
		req.request_Overview();
		req.select_Applicant_type("Myself");
		req.search_here(prop.getUser_name());
		approver_overview.filter_search(prop.getStatus_pending());
		req.scrollForReason();
		approve_DA_request(input);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Diagnostic Authority for Supplier- status Approved:" + "</u></i></b>");
		AbstractComponents.refresh();
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Enhance Right Authority - Supplier" + "</u></i></b>");
		TC11_EnhanceRightAuthority_GLOBAL.create_Enhance_Right_Authority_request_Supplier(input);
		req.request_Overview();
		req.select_request_type("Enhance Right");
		req.select_Applicant_type("Myself");
		req.search_here(prop.getUser_name());
		approver_overview.filter_search(prop.getStatus_pending());
		req.scrollForReason();
		TC13_EnhanceRightAuthority_GLOBAL_Approved.approve_Enhance_Right_Authority_request(input);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Enhance Right Authority for Supplier- status Approved:" + "</u></i></b>");
		AbstractComponents.refresh();
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Nest-T Testing - Supplier" + "</u></i></b>");
		List<String >create_special_cases_nestT_request=TC17_NestT_TestCOT_GLOBAL. create_special_cases_nestT_request_Supplier(input);
		TC19_NestT_TestCOT_GLOBAL_Approved.approve_specail_cases_nestT_request(input, create_special_cases_nestT_request);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Nest-T Testing for Supplier- status Approved:" + "</u></i></b>");
		AbstractComponents.refresh();
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Replacement Package - Supplier" + "</u></i></b>");
		List<String >create_replacement_package_request = TC31_ReplacementPackage_RootBackend_Swap_Swap_GLOBAL_Approved.create_replacement_package_request_Supplier(input);
		TC31_ReplacementPackage_RootBackend_Swap_Swap_GLOBAL_Approved.approve_special_cases_Replacement_request_Supplier(input,create_replacement_package_request);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Replacement Package for Supplier- status Approved:" + "</u></i></b>");
		logger.info("************************************ Global End to End Completed *************************");
		softAssertionALL();
//		driver.quit();		
	}

	@DataProvider
	public Object[][] getData_Internal() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//End_to-end_functionality.json");
		return new Object[][] { { data.get(1) } };

	}

	@DataProvider
	public Object[][] getData_External() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//End_to-end_functionality.json");
		return new Object[][] { { data.get(8) } };

	}

	@DataProvider
	public Object[][] getData_Supplier() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//End_to-end_functionality.json");
		return new Object[][] { { data.get(10) } };

	}

	public static void approve_DA_request(HashMap<String, String> input, List<String> create_DA_request)
			throws Throwable {
		if (create_DA_request.get(13).equals("Development ENHANCED") || create_DA_request.get(13).equals("Production")
				|| create_DA_request.get(13).equals("After-Sales ENHANCED")) {
			String DA_approval_status_after_level1_approval = approver_overview
					.approvetheDA_Request("Diagnostic Authority", prop.getStatus_pending(), create_DA_request);
			s.assertTrue(DA_approval_status_after_level1_approval.equals(prop.getStatus_Approved()));
			test.pass("User is able to view the approval status as Approved after 1st level approval");
			logger.info("User is able to view the approval status as Approved after 1st level approval");
			req.navigate_to_request_Overview_page_and_verify_approval_status_DA(prop.getStatus_pending(), "N/A", "N/A",
					"Diagnostic Authority", prop.getUser_name());
			test.pass(
					"User is able to view navigate to request overview page and check if the status is pending after 1st level approval");
			logger.info(
					"User is able to view navigate to request overview page and check if the status is pending after 1st level approval");
			String DA_approval_status_after_level2_approval = approver_overview
					.approvetheDA_Request("Diagnostic Authority", prop.getStatus_pending(), create_DA_request);
			s.assertTrue(DA_approval_status_after_level2_approval.equals(prop.getStatus_Approved()));
			test.pass("User is able to view the approval status as Approved after 2nd level approval");
			logger.info("User is able to view the approval status as Approved after 2nd level approval");
			String todays_date = todays_date();
			req.navigate_to_request_Overview_page_and_verify_approval_status_DA(prop.getStatus_Approved(), todays_date,
					"N/A", "Diagnostic Authority", prop.getUser_name());
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
					"N/A", "Diagnostic Authority", prop.getUser_name());
			test.pass(
					"User is able to view navigae to Functioanl role overview page and check if the status is approved after 1st level approval");
			logger.info(
					"User is able to view navigae to Functioanl role overview page and check if the status is approved after 1st level approval");
		}

	}
	public static void approve_DA_request(HashMap<String, String> input)
			throws Throwable {
		String create_DA_requests=input.get("User_role_DA");
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
}
