package DAMS.Testcases.Smoke_Suite_1;

import static DAMS.Resources.Listeners.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import DAMS.Resources.BaseClass;
import DAMS.Resources.SoftAssertUtil;

public class TC11_EnhanceRightAuthority_GLOBAL extends BaseClass {

	@Test(dataProvider = "getData_Internal", priority = 0)
	public static void create_Enhance_right_Authority_Request_Internal_test_case(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Enhance Right Authority Internal -status pending" + "</u></i></b>");
		TC06_STD_GLOBAL_FRapproved.Functional_role_request_approved_Internal(input);
		Thread.sleep(3000);
//		myreq.select_NewPermission_request(); 
		create_Enhance_Right_Authority_request(input);
		test.pass("Create Enhance right request when the status is pending");
		logger.info("Create Enhance right request when the status is pending");
		req.request_Overview();
		req.select_request_type("Enhance Right");
		softAssertionALL();
		

	}

	@Test(dataProvider = "getData_External", priority = 1,enabled=false)
	public static void create_Enhance_right_Authority_Request_External_test_case(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Enhance Right Authority External -status pending" + "</u></i></b>");
		TC06_STD_GLOBAL_FRapproved.Functional_role_request_approved_External(input);
		create_Enhance_Right_Authority_request_External(input);
		test.pass("Create Enhance right request when the status is pending");
		logger.info("Create Enhance right request when the status is pending");
		req.request_Overview();
		req.select_request_type("Enhance Right");
		softAssertionALL();
	}

	@Test(dataProvider = "getData_Supplier", priority = 2,enabled=false)
	public static void create_Enhance_right_Authority_Request_Supplier_test_case(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Enhance Right AUthority Supplier -status pending" + "</u></i></b>");

		TC06_STD_GLOBAL_FRapproved.Functional_role_request_approved_Supplier(input);
		create_Enhance_Right_Authority_request_Supplier(input);
		myreq.select_NewPermission_request();
		test.pass("Create Enhance right request when the status is pending");
		logger.info("Create Enhance right request when the status is pending");
		req.request_Overview();
		req.select_request_type("Enhance Right");
		softAssertionALL();

	}

	public static List<Object> create_Enhance_Right_Authority_request(HashMap<String, String> input, List<Object> cert)
			throws Throwable {
		test.info("Enhance_Right_Authority_request");
		logger.info("Enhance_Right_Authority_request");
		myreq.select_NewPermission_request();
		List<Object> request_Overview_enabled = newper.raise_Enhance_Right_Request(input, (String[]) cert.get(0),
				cert.get(1), input.get("Target_ECU"), input.get("Service_ID"), input.get("Validity"),
				input.get("Reason_for_ER"));
		request_Overview_enabled.get(0);
		SoftAssertUtil.assertTrue((boolean) request_Overview_enabled.get(0));
		List<Object> request_Overview_table_validation = req
				.request_Overview_table_validation_for_Enhanced_right("Enhance Right", prop.getUser_name(), "ALL",request_Overview_enabled);
		SoftAssertUtil.assertTrue(request_Overview_table_validation.get(0).equals(prop.getStatus_pending()));
		test.pass("View the approval status as pending once the DA request created");
		logger.info("View the approval status as pending once the DA request created");
		return request_Overview_table_validation;

	}
	
	public static List<Object> create_Enhance_Right_Authority_request(HashMap<String, String> input)
			throws Throwable {
		test.info("Enhance_Right_Authority_request");
		logger.info("Enhance_Right_Authority_request");
		myreq.select_NewPermission_request();	
		List<Object> request_Overview_enabled = newper.raise_Enhance_Right_Request(input);
		request_Overview_enabled.get(0);
		SoftAssertUtil.assertTrue((boolean) request_Overview_enabled.get(0));
		test.pass("View the approval status as pending once the DA request created");
		logger.info("View the approval status as pending once the DA request created");
		return request_Overview_enabled;

	}

	@DataProvider
	public Object[][] getData_Internal() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//EnhanceRight_Authority.json");
		return new Object[][] { { data.get(1) } };

	}

	@DataProvider
	public Object[][] getData_External() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//EnhanceRight_Authority.json");
		return new Object[][] { { data.get(3) } };

	}

	@DataProvider
	public Object[][] getData_Supplier() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//EnhanceRight_Authority.json");
		return new Object[][] { { data.get(2) } };

	}
	public static List<Object> create_Enhance_Right_Authority_request_External(HashMap<String, String> input)
			throws Throwable {
		test.info("Enhance_Right_Authority_request");
		logger.info("Enhance_Right_Authority_request");
		myreq.select_NewPermission_request();
		List<Object> request_Overview_enabled = newper.raise_Enhance_Right_Request_External(input);
		request_Overview_enabled.get(0);
		SoftAssertUtil.assertTrue((boolean) request_Overview_enabled.get(0));
		test.pass("View the approval status as pending once the DA request created");
		return request_Overview_enabled;

	}
	public static List<Object> create_Enhance_Right_Authority_request_Supplier(HashMap<String, String> input)
			throws Throwable {
		test.info("Enhance_Right_Authority_request");
		logger.info("Enhance_Right_Authority_request");
		myreq.select_NewPermission_request();
		List<Object> request_Overview_enabled = newper.raise_Enhance_Right_Request_Supplier(input);
		request_Overview_enabled.get(0);
		SoftAssertUtil.assertTrue((boolean) request_Overview_enabled.get(0));
		test.pass("View the approval status as pending once the DA request created");
		return request_Overview_enabled;

	}

}
