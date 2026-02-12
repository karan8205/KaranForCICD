package DAMS.Testcases.Smoke_Suite_1;

import static DAMS.Resources.Listeners.test;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import DAMS.Resources.BaseClass;

public class TC05_STD_GLOBAL_FRrejected extends BaseClass {
	// Creating and rejecting Functional role request-Internal,External and Supplier

	@Test(dataProvider = "getData_Internal", priority = 0)
	public static void Funtional_role_request_rejected_Internal(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Internal Functional role request - status rejected:" + "</u></i></b>");
		String select_user_type = TC02_Requests_STD_GLOBAL.login_and_select_user_Global(prop.get_user_type_Internal());
		String functional_role_selected =TC02_Requests_STD_GLOBAL. raise_Internal_functional_role(input);
		
		FR_reject(select_user_type,functional_role_selected);
	}

	@Test(dataProvider = "getData_External", priority = 1,enabled=false)
	public static void Funtional_role_request_rejected_External(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "External Functional role request - status rejected:" + "</u></i></b>");
		String select_user_type = TC02_Requests_STD_GLOBAL
				.login_and_select_user_Global(prop.get_user_type_external());
		String functional_role_selected = TC02_Requests_STD_GLOBAL
				.raise_External_functional_role(input);
		FR_reject(functional_role_selected, select_user_type);
	}

	@Test(dataProvider = "getData_Supplier", priority = 2,enabled=false)
	public static void Funtional_role_request_rejected_Supplier(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Supplier Functional role request - status rejected:" + "</u></i></b>");
		String select_user_type = TC02_Requests_STD_GLOBAL
				.login_and_select_user_Global(prop.get_User_type_Supplier());
		String functional_role_selected = TC02_Requests_STD_GLOBAL
				.raise_Supplier_functional_role(input);
		FR_reject(functional_role_selected, select_user_type);
	}

	@DataProvider
	public Object[][] getData_Internal() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//New_functional_role_Request.json");
		return new Object[][] { { data.get(1)} };

	}

	@DataProvider
	public Object[][] getData_External() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//New_functional_role_Request.json");
		return new Object[][] { { data.get(10) } };

	}

	@DataProvider
	public Object[][] getData_Supplier() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//New_functional_role_Request.json");
		return new Object[][] { { data.get(18) }};

	}

	public static void functional_role_reject(String usertype, List<Object> functional_role_selected) throws Throwable {
		String approval_status_after_rejecting_request = approver_overview.reject_FR_Request(reason_for_rejection,
				"Functional Role", functional_role_selected, usertype);
		test.pass("User is able to reject the request");
		logger.info("User is able to reject the request");
		s.assertTrue(approval_status_after_rejecting_request.equals(prop.getStatus_rejected()));
		f.navigate_to_functional_role_Overview_page_and_verify_approval_status(prop.getStatus_rejected(),
				reason_for_rejection);
		test.pass("User navigate to functional role overview page and check status changed to rejected");
		logger.info("User navigate to functional role overview page and check status changed to rejected");
		softAssertionALL();
	}

	public static void FR_reject(String functional_role_selected, String select_user_type) throws Throwable {
		test.pass("User is able to raise the request for the functional role " + functional_role_selected);
		List<Object> funational_role_Overview_table_input = TC02_Requests_STD_GLOBAL
				.functional_role_Overview_table_validation(select_user_type);
		s.assertTrue((boolean) funational_role_Overview_table_input.get(0).equals(prop.getStatus_pending()));
		functional_role_reject(select_user_type, funational_role_Overview_table_input);
		softAssertionALL();
	}
	


}
