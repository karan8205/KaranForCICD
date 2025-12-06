package DAMS.Testcases.Smoke_Suite_1;

import static DAMS.Resources.Listeners.test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import DAMS.Resources.AbstractComponents;
import DAMS.Resources.BaseClass;

public class TC09_Diagnostic_Authority_GLOBAL_Rejected extends BaseClass {

	@Test(dataProvider = "getData_Internal", priority = 0)
	public static void create_and_reject_Diagnostic_Authority__Request_test_case_Internal(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Diagnostic Authority Request for Internal- status rejected:" + "</u></i></b>");
		TC08_Diagnostic_Authority_GLOBAL.create_Diagnostic_Authority__Request_Internal_test_case(input);
		req.search_here(prop.getUser_name());
		reject_DA_request(input);
		test.pass("Verify selected ecu is visible when the status is rejected");
		logger.info("Verify selected ecu is visible when the status is rejected");
		softAssertionALL();
	}

	@Test(dataProvider = "getData_External", priority = 1,enabled=false)
	public static void create_and_reject_Diagnostic_Authority__Request_test_case_External(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Diagnostic Authority Request for External- status rejected:" + "</u></i></b>");
		 TC08_Diagnostic_Authority_GLOBAL.create_Diagnostic_Authority__Request_External_test_case(input);
			req.search_here(prop.getUser_name());
		reject_DA_request(input);
		myreq.select_NewPermission_request();
		test.pass("Verify selected ecu is visible when the status is rejected");
		logger.info("Verify selected ecu is visible when the status is rejected");
		softAssertionALL();
	}

	@Test(dataProvider = "getData_Supplier", priority = 2,enabled=false)
	public static void create_and_reject_Diagnostic_Authority__Request_test_case_Supplier(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Diagnostic Authority Request for Supplier- status rejected:" + "</u></i></b>");
		TC08_Diagnostic_Authority_GLOBAL.create_Diagnostic_Authority__Request_Supplier_test_case(input);
		 req.search_here(prop.getUser_name());
			logger.info("Approver Process");
		reject_DA_request(input);
		myreq.select_NewPermission_request();
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
		return new Object[][] { { data.get(12) } };

	}

	@DataProvider
	public Object[][] getData_Supplier() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//Diagnostic_Authority.json");
		return new Object[][] { { data.get(18) } };

	}

	public static void reject_DA_request(HashMap<String, String> input, List<String> create_DA_request)
			throws Throwable {
		String DA_approval_status_after_level1_approval = approver_overview.rejecttheDA_Request("Diagnostic Authority",
				create_DA_request, reason_for_rejection);
		s.assertTrue(DA_approval_status_after_level1_approval.equals(prop.getStatus_rejected()));
		test.pass("View the approval status as rejected in approver page");
		logger.info("View the approval status as rejected in approver page");
		req.navigate_to_request_Overview_page_and_verify_approval_status_DA(prop.getStatus_rejected(), "N/A",
				reason_for_rejection, "Diagnostic Authority", "HARNAGA");
		test.pass("View the approval status as rejected in FR overview page");
		logger.info("View the approval status as rejected in FR overview page");
	}
	public static void reject_DA_request(HashMap<String, String> input)
			throws Throwable {
		List<String> applicantNumber=req.getMultipleApplicantNumber();
		for(String id:applicantNumber) {
		String DA_approval_status_after_level1_approval = approver_overview.rejecttheDA_Request("Diagnostic Authority", reason_for_rejection,id);
		s.assertTrue(DA_approval_status_after_level1_approval.equals(prop.getStatus_rejected()));
		}
		test.pass("View the approval status as rejected in approver page");
		logger.info("View the approval status as rejected in approver page");
		String userrole = input.get("User_role");
		String[] urArr=userrole.split("/");		
		logger.info("urArr size "+urArr.length+" values : "+Arrays.toString(urArr));
		logger.info("Applicant Number Size : "+applicantNumber.size()+" values : "+applicantNumber);
		for(int i=0;i<applicantNumber.size();i++) {
			String userrole1 = urArr[i];
			String id = applicantNumber.get(i);			
		req.navigate_to_request_Overview_page_and_verify_approval_status_DA(prop.getStatus_rejected(), "N/A",
				reason_for_rejection, "Diagnostic Authority", id,userrole1);
		}
		
		test.pass("View the approval status as rejected in FR overview page");
		logger.info("View the approval status as rejected in FR overview page");
	}
	public static void reject_DA_request(HashMap<String, String> input, String create_DA_request)
			throws Throwable {
		String DA_approval_status_after_level1_approval = approver_overview.rejecttheDA_Request("Diagnostic Authority",reason_for_rejection,create_DA_request);
		s.assertTrue(DA_approval_status_after_level1_approval.equals(prop.getStatus_rejected()));
		test.pass("View the approval status as rejected in approver page");
		logger.info("View the approval status as rejected in approver page");
		req.navigate_to_request_Overview_page_and_verify_approval_status_DA(prop.getStatus_rejected(), "N/A",
				reason_for_rejection, "Diagnostic Authority", create_DA_request);
		test.pass("View the approval status as rejected in FR overview page");
		logger.info("View the approval status as rejected in FR overview page");
	}

}
