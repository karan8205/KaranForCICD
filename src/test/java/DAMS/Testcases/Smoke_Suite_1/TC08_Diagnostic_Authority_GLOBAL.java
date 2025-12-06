package DAMS.Testcases.Smoke_Suite_1;

import static DAMS.Resources.Listeners.test;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import DAMS.Resources.BaseClass;

public class TC08_Diagnostic_Authority_GLOBAL extends BaseClass {

	@Test(dataProvider = "getData_Internal", priority = 0)
	public static void create_Diagnostic_Authority__Request_Internal_test_case(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
			+ "Diagnostic Authority Request for Internal- status pending:" + "</u></i></b>");		
		TC06_STD_GLOBAL_FRapproved.Functional_role_request_approved_Internal(input);
		Thread.sleep(3000);
		myreq.select_NewPermission_request();
		newper.Diagnostic_Authority_ECU_Visible_or_not_for_pending_Approved(input);
		req.request_Overview();
		softAssertionALL();
	}

	@Test(dataProvider = "getData_External", priority = 1,enabled=false)
	public static void create_Diagnostic_Authority__Request_External_test_case(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Diagnostic Authority Request for External- status pending:" + "</u></i></b>");	
		String select_user_type = TC02_Requests_STD_GLOBAL.login_and_select_user_Global(prop.get_user_type_external());
		String functional_role_selected =TC02_Requests_STD_GLOBAL. raise_External_functional_role(input);
		List<Object> functional_role=	TC06_STD_GLOBAL_FRapproved.create_and_approve_External_FR_request(input);
		create_DA_request(input, functional_role);
		softAssertionALL();
	}

	@Test(dataProvider = "getData_Supplier", priority = 2,enabled=false)
	public static void create_Diagnostic_Authority__Request_Supplier_test_case(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Diagnostic Authority Request for Supplier- status pending:" + "</u></i></b>");
		List<Object> functional_role_selected=TC06_STD_GLOBAL_FRapproved.create_and_approve_Supplier_FR_request(input);
		create_DA_request_For_Supplier(input, functional_role_selected);
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
		return new Object[][] { { data.get(10) } };

	}

	public static List<String> create_DA_request(HashMap<String, String> input, List<Object> functional_role)
			throws Throwable {
		test.info("Diagnostic Authority request");
		logger.info("Diagnostic Authority request");
		myreq.select_NewPermission_request();
		boolean request_Overview_enabled=newper.Diagnostic_Authority_External_Created(input);
		s.assertTrue(request_Overview_enabled);
		List<String> request_Overview_input = req.request_Overview_table_validation(prop.getUser_name(), "ALL");
		s.assertTrue(request_Overview_input.get(0).equals(prop.getStatus_pending()));
		test.pass("View the approval status as pending once the DA request created");
		logger.info("View the approval status as pending once the DA request created");
		return request_Overview_input;
	}
	
	public static List<String> create_DA_request_For_Supplier(HashMap<String, String> input, List<Object> functional_role)
			throws Throwable {
		test.info("Diagnostic Authority request");
		logger.info("Diagnostic Authority request");
		myreq.select_NewPermission_request();
		boolean request_Overview_enabled=newper.Diagnostic_Authority_Supplier_Created(input);
		s.assertTrue(request_Overview_enabled);
		List<String> request_Overview_input = req.request_Overview_table_validation(prop.getUser_name(), "ALL");
		s.assertTrue(request_Overview_input.get(0).equals(prop.getStatus_pending()));
		test.pass("View the approval status as pending once the DA request created");
		logger.info("View the approval status as pending once the DA request created");
		return request_Overview_input;
	}

}
