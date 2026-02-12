package DAMS.Testcases.Smoke_Suite_1;

import static DAMS.Resources.Listeners.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import DAMS.Resources.BaseClass;

public class TC17_NestT_TestCOT_GLOBAL extends BaseClass {
	// Creating Nest-T Request-Internal,Supplier

	@Test(dataProvider = "getData_Internal", priority = 0,enabled=false)
	public static void create_NestT_Request_Internal_test_case(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>" + "Nest_T Request for Internal- status pending:"
				+ "</u></i></b>");
		TC06_STD_GLOBAL_FRapproved.Functional_role_request_approved_Internal(input);
 		create_special_cases_nestT_request(input);
		test.pass("User is able to verify Nest-T request creation when the status is in pending");
		logger.info("User is able to verify Nest-T request creation when the status is in pending");
		softAssertionALL();

	}
	@Test(dataProvider = "getData_External", priority = 0,enabled=false)
	public static void create_NestT_Request_External_test_case(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>" + "Nest_T Request for Internal- status pending:"
				+ "</u></i></b>");
		TC06_STD_GLOBAL_FRapproved.Functional_role_request_approved_External(input);
		create_special_cases_nestT_request_External(input);
		test.pass("User is able to verify Nest-T request creation when the status is in pending");
		logger.info("User is able to verify Nest-T request creation when the status is in pending");
		softAssertionALL();

	}

	@Test(dataProvider = "getData_Supplier", priority = 1)
	public static void create_NestT_Request_Supplier_test_case(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Nest_T Request for Supplier- status approved:" + "</u></i></b>");
		List<Object> create_and_approve_Internal_FR_request = TC06_STD_GLOBAL_FRapproved.create_and_approve_Supplier_FR_request(input);

		List<String> create_special_cases_nestT_request = TC17_NestT_TestCOT_GLOBAL
				.create_special_cases_nestT_request_Supplier(input);
		test.pass("User is able to verify Nest-T request creation when the status is in pending");
		logger.info("User is able to verify Nest-T request creation when the status is in pending");
		softAssertionALL();

	}

	@DataProvider
	public Object[][] getData_Internal() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//Nest_T_Testing.json");
		return new Object[][] { { data.get(1) } };

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

	public static List<String> create_special_cases_nestT_request(HashMap<String, String> input) throws Throwable {
		myreq.select_NewPermission_request();
		boolean request_Overview_enabled = newper.raise_nestT_Request(input.get("SpecialCase_nestT"),
				input.get("NestT_TestingCase"), input.get("ECU_Qualifier_nestT"), input.get("Reason_for_nestT"),input.get("Functional_role_internal"));
		s.assertTrue(request_Overview_enabled);
		List<String> request_Overview_table_input = req.request_Overview_table_validation_for_nestT("Nest-T Testing",prop.getUser_name());
		s.assertTrue(request_Overview_table_input.get(0).equals(prop.getStatus_pending()));
		test.pass("User is able to view the approval status as pending once the nestT request created");
		logger.info("User is able to view the approval status as pending once the nestT request created");
		return request_Overview_table_input;
	}
	public static List<String> create_special_cases_nestT_request_External(HashMap<String, String> input) throws Throwable {
		myreq.select_NewPermission_request();
		boolean request_Overview_enabled = newper.raise_nestT_Request(input.get("SpecialCase_nestT"),
				input.get("NestT_TestingCase"), input.get("ECU_Qualifier_nestT"), input.get("Reason_for_nestT"),input.get("Functional_role_External"));
		s.assertTrue(request_Overview_enabled);
//		List<String> request_Overview_table_input = req.request_Overview_table_validation_for_nestT("Nest-T Testing",prop.getUser_name());
		List<String> request_Overview_table_input = req.multiple_Request_Table_Validation_for_replacement_package("Nest-T Testing", prop.getUser_name());

//		s.assertTrue(request_Overview_table_input.get(0).equals(prop.getStatus_pending()));
		test.pass("User is able to view the approval status as pending once the nestT request created");
		logger.info("User is able to view the approval status as pending once the nestT request created");
		return request_Overview_table_input;
	}
	
	public static List<String> create_special_cases_nestT_request_Supplier(HashMap<String, String> input) throws Throwable {
		myreq.select_NewPermission_request();
		boolean request_Overview_enabled = newper.raise_nestT_Request(input.get("SpecialCase_nestT"),
				input.get("NestT_TestingCase"), input.get("ECU_Qualifier_nestT"), input.get("Reason_for_nestT"),input.get("Functional_role_Certificate"));
		s.assertTrue(request_Overview_enabled);
		List<String> request_Overview_table_input = req.request_Overview_table_validation_for_nestT("Nest-T Testing",prop.getUser_name());
		s.assertTrue(request_Overview_table_input.get(0).equals(prop.getStatus_pending()));
		test.pass("User is able to view the approval status as pending once the nestT request created");
		logger.info("User is able to view the approval status as pending once the nestT request created");
		return request_Overview_table_input;
	}

}
