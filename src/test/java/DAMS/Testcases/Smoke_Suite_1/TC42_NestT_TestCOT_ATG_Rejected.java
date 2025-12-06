package DAMS.Testcases.Smoke_Suite_1;

import static DAMS.Resources.Listeners.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import DAMS.Resources.BaseClass;


public class TC42_NestT_TestCOT_ATG_Rejected extends BaseClass {

	@Test(dataProvider = "getData_Internal", priority = 0,enabled=false)
	public static void create_and_reject_NestT__Request_Internal_test_case(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Nest_T Request for Internal- status rejected:" + "</u></i></b>");
		TC07_STD_ATG_FRapproved.Funtional_role_request_approved_Internal(input);
 		List<String >create_special_cases_nestT_request=TC41_NestT_TestCOT_ATG. create_special_cases_nestT_request(input);		
		reject_special_cases_nestT_request(input, create_special_cases_nestT_request);
		test.pass("User is able to verify Nest-T request creation when the status is rejected");
		logger.info("User is able to verify Nest-T request creation when the status is rejected");
		softAssertionALL();

	}

	@Test(dataProvider = "getData_Supplier", priority = 1,enabled=false)
	public static void create_and_Approve_NestT__Request_Supplier_test_case(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Nest_T Request for Supplier - status pending:" + "</u></i></b>");
		List<String >create_special_cases_nestT_request=TC41_NestT_TestCOT_ATG.create_special_cases_nestT_request_Supplier(input);
		reject_special_cases_nestT_request(input, create_special_cases_nestT_request);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Nest-T Testing for Supplier- status Approved-ATG:" + "</u></i></b>");
		softAssertionALL();
	}

	@DataProvider
	public Object[][] getData_Internal() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//Nest_T_Testing.json");
		return new Object[][] { { data.get(4) } };

	}
	
	@DataProvider
	public Object[][] getData_External() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//Nest_T_Testing.json");
		return new Object[][] { { data.get(6) } };

	}

	@DataProvider
	public Object[][] getData_Supplier() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//Nest_T_Testing.json");
		return new Object[][] { { data.get(2) } };

	}

	public static void reject_special_cases_nestT_request(HashMap<String, String> input,
			List<String> create_special_cases_nestT_request) throws Throwable {
		String NestT_approval_status_after_level1_approval = approver_overview
				.rejecttheNestT_Request(reason_for_rejection, "Nest T Testing", create_special_cases_nestT_request);
		s.assertTrue(NestT_approval_status_after_level1_approval.equals(prop.getStatus_rejected()));
		test.pass("User is able to view the approval status as rejected in approver page");
		logger.info("User is able to view the approval status as rejected in approver page");
		req.navigate_to_request_Overview_page_and_verify_approval_status(prop.getStatus_rejected(), "N/A",
				reason_for_rejection, "Nest-T Testing", prop.getUser_name());
		test.pass("User is able to view the approval status as rejected in request overview page");
		logger.info("User is able to view the approval status as rejected in request overview page");
	}

}
