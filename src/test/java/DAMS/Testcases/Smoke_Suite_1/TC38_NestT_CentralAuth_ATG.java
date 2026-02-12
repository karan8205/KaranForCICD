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

public class TC38_NestT_CentralAuth_ATG extends BaseClass {
	// Creating Nest-T Request-Internal,Supplier

	@Test(dataProvider = "getData_Internal", priority = 0)
	public static void create_NestT_Request_Internal_test_case(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>" + "Nest_T Request for Internal- status pending:"
				+ "</u></i></b>");
		TC07_STD_ATG_FRapproved.Funtional_role_request_approved_Internal(input);
 		create_special_cases_nestT_request(input);
		test.pass("User is able to verify Nest-T request creation when the status is in pending");
		logger.info("User is able to verify Nest-T request creation when the status is in pending");
		softAssertionALL();
	}

	@Test(dataProvider = "getData_Supplier", priority = 1,enabled=false)
	public static void create_NestT_Request_Supplier_test_case(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Standard Functional Request-ATG:" + "</u></i></b>");
		TC07_STD_ATG_FRapproved.Funtional_role_request_approved_Supplier(input);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Standard Functional Request for Supplier - status Approved-ATG:" + "</u></i></b>");
		AbstractComponents.refresh();
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Nest-T Testing - Supplier-ATG" + "</u></i></b>");
		List<String >create_special_cases_nestT_request=create_special_cases_nestT_request_Supplier(input);
		softAssertionALL();
	}

	@DataProvider
	public Object[][] getData_Internal() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//Nest_T_Testing.json");
		return new Object[][] { { data.get(3) } };
	}

	@DataProvider
	public Object[][] getData_Supplier() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//Nest_T_Testing.json");
		return new Object[][] { { data.get(2) } };
	}

	public static List<String> create_special_cases_nestT_request(HashMap<String, String> input) throws Throwable {
		myreq.select_NewPermission_request();
		boolean request_Overview_enabled = newper.raise_nestT_Request_Central(input.get("SpecialCase_nestT"),
				input.get("NestT_TestingCase"), input.get("ECU_Qualifier_nestT"), input.get("Reason_for_nestT"),input.get("Functional_role_internal"));
		s.assertTrue(request_Overview_enabled);
		List<String> request_Overview_table_input = req.request_Overview_table_validation_for_nestT("Nest-T Testing",prop.getUser_name());
		s.assertTrue(request_Overview_table_input.get(0).equals(prop.getStatus_pending()));
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
