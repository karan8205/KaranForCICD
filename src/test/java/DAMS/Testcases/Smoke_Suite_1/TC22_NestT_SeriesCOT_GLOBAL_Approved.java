package DAMS.Testcases.Smoke_Suite_1;

import static DAMS.Resources.Listeners.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import DAMS.Resources.BaseClass;


public class TC22_NestT_SeriesCOT_GLOBAL_Approved extends BaseClass {
	// Creating and Approving Nest-T Request-Internal,External and Supplier

	@Test(dataProvider = "getData_Internal", priority = 0,enabled=false)
	public static void create_and_Approve_NestT__Request_Internal_test_case(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Nest_T Request for Internal- status approved:" + "</u></i></b>");
		TC06_STD_GLOBAL_FRapproved.Functional_role_request_approved_Internal(input);
 		List<String >create_special_cases_nestT_request=TC20_NestT_SeriesCOT_GLOBAL. create_special_cases_nestT_request(input);
		approve_special_cases_nestT_request(input, create_special_cases_nestT_request);
		test.pass("User is able to create Nest-T request when the status is approved");
		logger.info("User is able to create Nest-T request when the status is approved");
		softAssertionALL();
	}
	@Test(dataProvider = "getData_External", priority = 0)
	public static void create_and_reject_NestT__Request_External_test_case(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Nest_T Request for Internal- status rejected:" + "</u></i></b>");
		TC06_STD_GLOBAL_FRapproved.Functional_role_request_approved_External(input);
 		List<String >create_special_cases_nestT_request=TC20_NestT_SeriesCOT_GLOBAL. create_special_cases_nestT_request_External(input);		
		approve_special_cases_nestT_request(input, create_special_cases_nestT_request);		
		test.pass("User is able to verify Nest-T request creation when the status is rejected");
		logger.info("User is able to verify Nest-T request creation when the status is rejected");
		softAssertionALL();

	}

	@Test(dataProvider = "getData_Supplier", priority = 1,enabled=false)
	public static void create_and_Approve_NestT__Request_Supplier_test_case(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Nest_T Request for Supplier- status approved:" + "</u></i></b>");
            List<Object> create_and_approve_Internal_FR_request = TC06_STD_GLOBAL_FRapproved.create_and_approve_Supplier_FR_request(input);	
		List<String >create_special_cases_nestT_request=TC20_NestT_SeriesCOT_GLOBAL.create_special_cases_nestT_request_Suplier(input);
		approve_special_cases_nestT_request(input, create_special_cases_nestT_request);
		test.pass("User is able to verify Nest-T request creation when the status is approved");
		logger.info("User is able to verify Nest-T request creation when the status is approved");
		softAssertionALL();
	}

	@DataProvider
	public Object[][] getData_Internal() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//Nest_T_Testing.json");
		return new Object[][] { { data.get(2) } };

	}
	
	@DataProvider
	public Object[][] getData_External() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//Nest_T_Testing.json");
		return new Object[][] { { data.get(7) } };

	}

	@DataProvider
	public Object[][] getData_Supplier() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//Nest_T_Testing.json");
		return new Object[][] { { data.get(2) } };

	}

	public static void approve_special_cases_nestT_request(HashMap<String, String> input,
			List<String> create_special_cases_nestT_request) throws Throwable {
		String NestT_approval_status_after_level1_approval = approver_overview.approvethenestT_Request("Nest T Testing",
				prop.getStatus_pending(), create_special_cases_nestT_request);
		s.assertTrue(NestT_approval_status_after_level1_approval.equals(prop.getStatus_Approved()));
		test.pass("User is able to view the approval status as Approved after 1st level approval");
		logger.info("User is able to view the approval status as Approved after 1st level approval");
		req.navigate_to_request_Overview_page_and_verify_approval_status_RP_NestT(prop.getStatus_pending(), "N/A", "N/A",
				"Nest-T Testing", prop.getUser_name());
		test.pass(
				"User is able to view navigate to request role overview page and check if the status is pending after 1st level approval");
		logger.info(
				"User is able to view navigate to request role overview page and check if the status is pending after 1st level approval");
		String NestT_approval_status_after_level2_approval = approver_overview.approvethenestT_Request("Nest T Testing",
				prop.getStatus_pending(), create_special_cases_nestT_request);
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

}
