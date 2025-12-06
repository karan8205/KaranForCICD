package DAMS.Testcases.Smoke_Suite_1;

import static DAMS.Resources.Listeners.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import DAMS.Resources.BaseClass;


public class TC10_Diagnostic_Authority_GLOBAL_Approved extends BaseClass {

	@Test(dataProvider = "getData_Internal", priority = 0,enabled=false)
	public static void create_and_Approve_Diagnostic_Authority__Request_test_case_Internal(
			HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Diagnostic Authority Request for Internal- status approved:" + "</u></i></b>");
        TC08_Diagnostic_Authority_GLOBAL.create_Diagnostic_Authority__Request_Internal_test_case(input);
		req.search_here(prop.getUser_name());		
		approve_DA_request(input);
		test.pass("Verify selected ecu is not visible when the status is in approved");
		logger.info("Verify selected ecu is not visible when the status is in approved");
		softAssertionALL();
	}

	@Test(dataProvider = "getData_External", priority = 1,enabled=false)
	public static void create_and_Approve_Diagnostic_Authority__Request_test_case_External(
			HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Diagnostic Authority Request for External- status approved:" + "</u></i></b>");
		TC08_Diagnostic_Authority_GLOBAL.create_Diagnostic_Authority__Request_External_test_case(input);
		req.search_here(prop.getUser_name());
	    logger.info("Approver Process");
	    approve_DA_request(input);
		test.pass("Verify selected ecu is not visible when the status is in approved");
		logger.info("Verify selected ecu is not visible when the status is in approved");
		softAssertionALL();
	}
//
	@Test(dataProvider = "getData_Supplier", priority = 2)
	public static void create_and_Approve_Diagnostic_Authority__Request_test_case_Supplier(
			HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Diagnostic Authority Request for Supplier- status approved:" + "</u></i></b>");		
		TC08_Diagnostic_Authority_GLOBAL.create_Diagnostic_Authority__Request_Supplier_test_case(input);
		req.search_here(prop.getUser_name());
		logger.info("Approver Process");
		approve_DA_request(input);
		myreq.select_NewPermission_request();
		test.pass("Verify selected ecu is not visible when the status is in approved");
		logger.info("Verify selected ecu is not visible when the status is in approved");
		softAssertionALL();
	}

	@DataProvider
	public Object[][] getData_Internal() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//Diagnostic_Authority.json");
		return new Object[][] { { data.get(1) } };

	}

	@DataProvider
	public Object[][] getData_External() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//Diagnostic_Authority.json");
		return new Object[][] { { data.get(11) } };

	}

	@DataProvider
	public Object[][] getData_Supplier() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//Diagnostic_Authority.json");
		return new Object[][] { { data.get(18) } };

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
					"View navigate to request overview page and the status is pending after 1st level approval");
			logger.info(
					"View navigate to request overview page and the status is pending after 1st level approval");
			String DA_approval_status_after_level2_approval = approver_overview
					.approvetheDA_Request("Diagnostic Authority", prop.getStatus_pending(), create_DA_request);
			s.assertTrue(DA_approval_status_after_level2_approval.equals(prop.getStatus_Approved()));
			test.pass("View the approval status as Approved after 2nd level approval");
			logger.info("View the approval status as Approved after 2nd level approval");
			String todays_date = todays_date();
			req.navigate_to_request_Overview_page_and_verify_approval_status_DA(prop.getStatus_Approved(), todays_date,
					"N/A", "Diagnostic Authority", prop.getUser_name());
			test.pass(
					"View navigate to request overview page and the status is approved after 2nd level approval");
			logger.info(
					"View navigate to request overview page and the status is approved after 2nd level approval");
		} else {
			String DA_approval_status_after_level2_approval = approver_overview
					.approvetheDA_Request("Diagnostic Authority", prop.getStatus_pending(), create_DA_request);
			s.assertTrue(DA_approval_status_after_level2_approval.equals(prop.getStatus_Approved()));
			test.pass("View the approval status as Approved after 1st level approval");
			logger.info("View the approval status as Approved after 1st level approval");
			String todays_date = todays_date();
			req.navigate_to_request_Overview_page_and_verify_approval_status_DA(prop.getStatus_Approved(), todays_date,
					"N/A", "Diagnostic Authority", prop.getUser_name());
			test.pass(
					"View navigate to FR overview page and status is approved after 1st level approval");
			logger.info(
					"View navigate to FR overview page and status is approved after 1st level approval");
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
		
			test.pass("View the approval status as Approved after 1st level approval");
			logger.info("View the approval status as Approved after 1st level approval");
			req.navigate_to_request_Overview_page_and_verify_approval_status_DA(prop.getStatus_pending(), "N/A", "N/A",
					"Diagnostic Authority", id);
		
			test.pass(
					"View navigate to request overview page and status is pending after 1st level approval");
			logger.info(
					"View navigate to request overview page and status is pending after 1st level approval");
			String DA_approval_status_after_level2_approval = approver_overview
					.approvetheDA_Request("Diagnostic Authority", prop.getStatus_pending(), id);
			s.assertTrue(DA_approval_status_after_level2_approval.equals(prop.getStatus_Approved()));
			test.pass("View the approval status as Approved after 2nd level approval");
			logger.info("View the approval status as Approved after 2nd level approval");
			String todays_date = todays_date();
			req.navigate_to_request_Overview_page_and_verify_approval_status_DA(prop.getStatus_Approved(), todays_date,
					"N/A", "Diagnostic Authority", id);
			test.pass(
					"View navigae to request overview page and status is approved after 2nd level approval");
			logger.info(
					"View navigae to request overview page and status is approved after 2nd level approval");
		} else {
			String DA_approval_status_after_level2_approval = approver_overview
					.approvetheDA_Request("Diagnostic Authority", prop.getStatus_pending(), create_DA_request);
			s.assertTrue(DA_approval_status_after_level2_approval.equals(prop.getStatus_Approved()));
			test.pass("View the approval status as Approved after 1st level approval");
			logger.info("View the approval status as Approved after 1st level approval");
			String todays_date = todays_date();
			req.navigate_to_request_Overview_page_and_verify_approval_status_DA(prop.getStatus_Approved(), todays_date,
					"N/A", "Diagnostic Authority", id,input.get("User_role"));
			test.pass(
					"View navigate to FR overview page and check if the status is approved after 1st level approval");
			logger.info(
					"View navigate to FR overview page and check if the status is approved after 1st level approval");
		}
		}

	}
	
	public static void approve_DA_request(HashMap<String, String> input,String userRole,String id)
			throws Throwable {
		if (userRole.equals("Development ENHANCED") || userRole.equals("Production")
				||userRole.equals("After-Sales ENHANCED")) {
			String DA_approval_status_after_level1_approval = approver_overview
					.approvetheDA_Request("Diagnostic Authority", prop.getStatus_pending(), id);
			s.assertTrue(DA_approval_status_after_level1_approval.equals(prop.getStatus_Approved()));
			test.pass("User is able to view the approval status as Approved after 1st level approval");
			logger.info("User is able to view the approval status as Approved after 1st level approval");
			req.navigate_to_request_Overview_page_and_verify_approval_status_DA(prop.getStatus_pending(), "N/A", "N/A",
					"Diagnostic Authority", id);
			test.pass(
					"View navigate to request overview page and the status is pending after 1st level approval");
			logger.info(
					"View navigate to request overview page and the status is pending after 1st level approval");
			String DA_approval_status_after_level2_approval = approver_overview
					.approvetheDA_Request("Diagnostic Authority", prop.getStatus_pending(), id);
			s.assertTrue(DA_approval_status_after_level2_approval.equals(prop.getStatus_Approved()));
			test.pass("View the approval status as Approved after 2nd level approval");
			logger.info("View the approval status as Approved after 2nd level approval");
			String todays_date = todays_date();
			req.navigate_to_request_Overview_page_and_verify_approval_status_DA(prop.getStatus_Approved(), todays_date,
					"N/A", "Diagnostic Authority", prop.getUser_name());
			test.pass(
					"View navigate to request overview page and the status is approved after 2nd level approval");
			logger.info(
					"View navigate to request overview page and the status is approved after 2nd level approval");
		} else {
			String DA_approval_status_after_level2_approval = approver_overview
					.approvetheDA_Request("Diagnostic Authority", prop.getStatus_pending(), id);
			s.assertTrue(DA_approval_status_after_level2_approval.equals(prop.getStatus_Approved()));
			test.pass("View the approval status as Approved after 1st level approval");
			logger.info("View the approval status as Approved after 1st level approval");
			String todays_date = todays_date();
			req.navigate_to_request_Overview_page_and_verify_approval_status_DA(prop.getStatus_Approved(), todays_date,
					"N/A", "Diagnostic Authority", prop.getUser_name());
			test.pass(
					"View navigate to FR overview page and status is approved after 1st level approval");
			logger.info(
					"View navigate to FR overview page and status is approved after 1st level approval");
		}

	}
}
