package DAMS.Testcases.Smoke_Suite_1;

import static DAMS.Resources.Listeners.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import DAMS.Resources.AbstractComponents;
import DAMS.Resources.BaseClass;


public class TC002_ATG_Smoke_TestSuite_E2E extends BaseClass {
	@Test(dataProvider = "getData_Internal", priority = 0)
	public static void atg_Smoke_TestSuite_E2E_Internal(
			HashMap<String, String> input) throws Throwable {
//		TC01_Login_MFA.login_with_addressing_MFA();
//		Thread.sleep(5000);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Standard Functional Request-ATG:" + "</u></i></b>");
		TC07_STD_ATG_FRapproved.Funtional_role_request_approved_Internal(input);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Standard Functional Request for Internal- status Approved-ATG:" + "</u></i></b>");
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Diagnostic Authority - Internal-ATG" + "</u></i></b>");
		AbstractComponents.refresh();
		myreq.select_NewPermission_request();
		newper.Diagnostic_Authority_ECU_Visible_or_not_for_pending_Approved(input);
		req.request_Overview();
		Thread.sleep(1000);
		req.select_Applicant_type("Myself");
		approver_overview.filter_search(prop.getStatus_pending());
		req.scrollForReason();
		approve_DA_request(input);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Diagnostic Authority for Internal- status Approved-ATG:" + "</u></i></b>");
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Enhance Right Authority - Internal-ATG" + "</u></i></b>");
		AbstractComponents.refresh();
		TC35_EnhanceRightAuthority_ATG.create_Enhance_Right_Authority_request(input);
		req.request_Overview();
		req.select_request_type("Enhance Right");
		req.select_Applicant_type("Myself");
		req.search_here(prop.getUser_name());
		approver_overview.filter_search(prop.getStatus_pending());
		req.scrollForReason();
		TC37_EnhanceRightAuthority_ATG_Approved.approve_Enhance_Right_Authority_request(input);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Enhance Right Authority for Internal- status Approved-ATG:" + "</u></i></b>");
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Nest-T Testing - Internal-ATG" + "</u></i></b>");
		AbstractComponents.refresh();
		
		List<String >create_special_cases_nestT_request=TC41_NestT_TestCOT_ATG. create_special_cases_nestT_request(input);
		TC43_NestT_TestCOT_ATG_Approved.approve_specail_cases_nestT_request(input, create_special_cases_nestT_request);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Nest-T Testing for Internal- status Approved-ATG:" + "</u></i></b>");
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Replacement Package - Internal-ATG" + "</u></i></b>");
		AbstractComponents.refresh();
		List<String >create_replacement_package_request = TC55_ReplacementPackage_RootBackend_Swap_ATG_Approved.create_replacement_package_request(input);
		TC55_ReplacementPackage_RootBackend_Swap_ATG_Approved.approve_special_cases_Replacement_request(input,create_replacement_package_request);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Replacement Package for Internal- status Approved-ATG:" + "</u></i></b>");
		softAssertionALL();
		driver.close();
	}

	@Test(dataProvider = "getData_External", priority = 1,enabled=false)
	public static void atg_Smoke_TestSuite_E2E_External(
			HashMap<String, String> input) throws Throwable {
//		TC01_Login_MFA.login_with_addressing_MFA();
//		Thread.sleep(5000);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Standard Functional Request-ATG:" + "</u></i></b>");
		TC07_STD_ATG_FRapproved.Funtional_role_request_approved_External(input);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Standard Functional Request for External - status Approved-ATG:" + "</u></i></b>");
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Diagnostic Authority - External-ATG" + "</u></i></b>");
		AbstractComponents.refresh();
		myreq.select_NewPermission_request();
		newper.Diagnostic_Authority_External_Created(input);
		req.request_Overview();
		Thread.sleep(1000);
		req.select_Applicant_type("Myself");
		approver_overview.filter_search(prop.getStatus_pending());
		req.scrollForReason();
		approve_DA_request(input);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Diagnostic Authority for External- status Approved-ATG:" + "</u></i></b>");
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Enhance Right Authority - External-ATG" + "</u></i></b>");
		AbstractComponents.refresh();
		TC35_EnhanceRightAuthority_ATG.create_Enhance_Right_Authority_request_External(input);
		req.request_Overview();
		req.select_request_type("Enhance Right");
		req.select_Applicant_type("Myself");
		req.search_here(prop.getUser_name());
		approver_overview.filter_search(prop.getStatus_pending());
		req.scrollForReason();
		TC37_EnhanceRightAuthority_ATG_Approved.approve_Enhance_Right_Authority_request(input);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Enhance Right Authority for External- status Approved-ATG:" + "</u></i></b>");
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Nest-T Testing - External-ATG" + "</u></i></b>");
		AbstractComponents.refresh();
		List<String >create_special_cases_nestT_request=TC41_NestT_TestCOT_ATG. create_special_cases_nestT_request_External(input);
		TC43_NestT_TestCOT_ATG_Approved.approve_specail_cases_nestT_request(input, create_special_cases_nestT_request);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Nest-T Testing for External- status Approved-ATG:" + "</u></i></b>");
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Replacement Package - External-ATG" + "</u></i></b>");
		AbstractComponents.refresh();
		List<String >create_replacement_package_request = TC55_ReplacementPackage_RootBackend_Swap_ATG_Approved.create_replacement_package_request_External(input);
		TC55_ReplacementPackage_RootBackend_Swap_ATG_Approved.approve_special_cases_Replacement_request(input,create_replacement_package_request);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Replacement Package for External- status Approved-ATG:" + "</u></i></b>");
		softAssertionALL();
//		driver.close();
	}

	@Test(dataProvider = "getData_Supplier", priority = 2,enabled=false)
	public static void atg_Smoke_TestSuite_E2E_Supplier(
			HashMap<String, String> input) throws Throwable {
//		TC01_Login_MFA.login_with_addressing_MFA();
//		Thread.sleep(5000);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Standard Functional Request-ATG:" + "</u></i></b>");
		TC07_STD_ATG_FRapproved.Funtional_role_request_approved_Supplier(input);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Standard Functional Request for Supplier - status Approved-ATG:" + "</u></i></b>");
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Diagnostic Authority - Supplier-ATG" + "</u></i></b>");
		AbstractComponents.refresh();
		myreq.select_NewPermission_request();
		newper.Diagnostic_Authority_Supplier_Created(input);
		req.request_Overview();
		req.select_Applicant_type("Myself");
//		req.search_here(prop.getUser_name());
		approver_overview.filter_search(prop.getStatus_pending());
		req.scrollForReason();
		approve_DA_request(input);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Diagnostic Authority for Supplier- status Approved-ATG:" + "</u></i></b>");
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Enhance Right Authority - Supplier-ATG" + "</u></i></b>");
		AbstractComponents.refresh();
		TC35_EnhanceRightAuthority_ATG.create_Enhance_Right_Authority_request_Supplier(input);
		req.request_Overview();
		req.select_request_type("Enhance Right");
		req.select_Applicant_type("Myself");
		approver_overview.filter_search(prop.getStatus_pending());
		req.scrollForReason();
		TC37_EnhanceRightAuthority_ATG_Approved.approve_Enhance_Right_Authority_request(input);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Enhance Right Authority for Supplier- status Approved-ATG:" + "</u></i></b>");
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Nest-T Testing - Supplier-ATG" + "</u></i></b>");
		AbstractComponents.refresh();
		List<String >create_special_cases_nestT_request=TC41_NestT_TestCOT_ATG. create_special_cases_nestT_request_Supplier(input);
		TC43_NestT_TestCOT_ATG_Approved.approve_specail_cases_nestT_request(input, create_special_cases_nestT_request);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Nest-T Testing for Supplier- status Approved-ATG:" + "</u></i></b>");
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Replacement Package - Supplier-ATG" + "</u></i></b>");
		AbstractComponents.refresh();
		List<String >create_replacement_package_request = TC53_ReplacementPackage_RootBackend_Swap_ATG.create_replacement_package_request_Supplier(input);
		TC55_ReplacementPackage_RootBackend_Swap_ATG_Approved.approve_special_cases_Replacement_request(input,create_replacement_package_request);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Replacement Package for Supplier- status Approved-ATG:" + "</u></i></b>");
		softAssertionALL();
//		driver.close();
	}

	@DataProvider
	public Object[][] getData_Internal() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//End_to-end_functionality.json");
		return new Object[][] { { data.get(7) } };

	}

	@DataProvider
	public Object[][] getData_External() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//End_to-end_functionality.json");
		return new Object[][] { { data.get(9) } };

	}

	@DataProvider
	public Object[][] getData_Supplier() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//End_to-end_functionality.json");
		return new Object[][] { { data.get(11) } };

	}
	
	public static void approve_DA_request(HashMap<String, String> input)
			throws Throwable {
		String create_DA_requests=input.get("User_role_DA");
		List<String> applicantNumber=req.getMultipleApplicantNumber();
		
		String[] DA_requests=create_DA_requests.split("/");

		for(int i=0;i<DA_requests.length;i++) {
			
		String create_DA_request = DA_requests[i];
		String id=applicantNumber.get(i);
		
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
}
