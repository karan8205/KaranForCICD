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
import DAMS.Resources.SoftAssertUtil;

public class TC35_EnhanceRightAuthority_ATG extends BaseClass {

	@Test(dataProvider = "getData_Internal", priority = 0,enabled=false)
	public static void create_Enhance_right_Authority_Request_Internal_test_case(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Enhance Right AUthority Internal -status pending" + "</u></i></b>");
		TC07_STD_ATG_FRapproved.Funtional_role_request_approved_Internal(input);
		Thread.sleep(3000);
		create_Enhance_Right_Authority_request(input);
		test.pass("User is able to create Enhance right request when the status is pending");
		logger.info("User is able to create Enhance right request when the status is pending");
		req.request_Overview();
		req.select_request_type("Enhance Right");
		softAssertionALL();
	}
	@Test(dataProvider = "getData_External", priority = 1)
	public static void create_Enhance_right_Authority_Request_External_test_case(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Enhance Right Authority External -status pending" + "</u></i></b>");
		create_and_approve_External_FR_request(input);
		create_Enhance_Right_Authority_request_External(input);
		softAssertionALL();
	}

	@Test(dataProvider = "getData_Supplier", priority = 2,enabled=false)
	public static void create_Enhance_right_Authority_Request_Supplier_test_case(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Standard Functional Request-ATG:" + "</u></i></b>");
		TC07_STD_ATG_FRapproved.Funtional_role_request_approved_Supplier(input);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Standard Functional Request for Supplier - status Approved-ATG:" + "</u></i></b>");
		AbstractComponents.refresh();
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Enhance Right Authority - Supplier-ATG" + "</u></i></b>");
		TC35_EnhanceRightAuthority_ATG.create_Enhance_Right_Authority_request_Supplier(input);
		req.request_Overview();
		req.select_request_type("Enhance Right");
		Thread.sleep(3000);
		req.search_here("HARNAGA");
		approver_overview.filter_search(prop.getStatus_pending());
		req.scrollForReason();
		softAssertionALL();
	}

	public static List<Object> create_Enhance_Right_Authority_request(HashMap<String, String> input, List<Object> cert)
			throws Throwable {
		test.info("Enhance_Right_Authority_request");
		logger.info("Enhance_Right_Authority_request");
		myreq.select_NewPermission_request();
		List<Object> request_Overview_enabled = newper.raise_Enhance_Right_Request(input);
		request_Overview_enabled.get(0);
		SoftAssertUtil.assertTrue((boolean) request_Overview_enabled.get(0));
		List<Object> request_Overview_table_validation = req
				.request_Overview_table_validation_for_Enhanced_right("Enhance Right", prop.getUser_name(), "ALL",request_Overview_enabled);
		SoftAssertUtil.assertTrue(request_Overview_table_validation.get(0).equals(prop.getStatus_pending()));
		test.pass("User is able to view the approval status as pending once the DA request created");
		logger.info("User is able to view the approval status as pending once the DA request created");
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
		test.pass("User is able to view the approval status as pending once the DA request created");
		logger.info("User is able to view the approval status as pending once the DA request created");
		return request_Overview_enabled;

	}
	
	public static List<Object> create_Enhance_Right_Authority_request_External(HashMap<String, String> input)
			throws Throwable {
		test.info("Enhance_Right_Authority_request");
		logger.info("Enhance_Right_Authority_request");
		myreq.select_NewPermission_request();
		List<Object> request_Overview_enabled = newper.raise_Enhance_Right_Request_External(input);
		request_Overview_enabled.get(0);
		SoftAssertUtil.assertTrue((boolean) request_Overview_enabled.get(0));
		test.pass("User is able to view the approval status as pending once the DA request created");
		logger.info("User is able to view the approval status as pending once the DA request created");
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
		test.pass("User is able to view the approval status as pending once the DA request created");
		return request_Overview_enabled;

	}

	@DataProvider
	public Object[][] getData_Internal() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//EnhanceRight_Authority.json");
		return new Object[][] { { data.get(8) } };

	}

	@DataProvider
	public Object[][] getData_External() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//EnhanceRight_Authority.json");
		return new Object[][] { { data.get(13) } };

	}

	@DataProvider
	public Object[][] getData_Supplier() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//EnhanceRight_Authority.json");
		return new Object[][] { { data.get(2) } };

	}
	public static List<Object> create_and_approve_External_FR_request(HashMap<String, String> input) throws Throwable {
		String select_user_type = TC03_Requests_STD_ATG_FR
				.login_and_select_user_ATG(input.get("User_Type"));
		String functional_role_selected = TC03_Requests_STD_ATG_FR
				.raise_External_functional_role(input);
		List<Object> funational_role_Overview_table_input = TC03_Requests_STD_ATG_FR
				.functional_role_Overview_table_validation(select_user_type);
		String[] standard_cert = functional_role(select_user_type, funational_role_Overview_table_input,
				functional_role_selected);
		return Arrays.asList(standard_cert, functional_role_selected, select_user_type);
	}
	public static String[] functional_role(String usertype, List<Object> funational_role_Overview_table_input,
			String functional_role_selected) throws Throwable {
		test.pass("User is able to raise the request for the functional role " + functional_role_selected);
		logger.info("User is able to raise the request for the functional role " + functional_role_selected);
		String approval_status_after_level1_approval = approver_overview.approvetheFR_Request("Functional Role",
				funational_role_Overview_table_input, usertype, prop.getStatus_pending());
		s.assertTrue(approval_status_after_level1_approval.equals(prop.getStatus_Approved()));
		test.pass("User is able to approve 1st level approval");
		logger.info("User is able to approve 1st level approval");
		f.navigate_to_functional_role_Overview_page_and_verify_approval_status(prop.getStatus_pending(), "N/A");
		test.pass("User navigate to Functional role overview page and check if the status is pending after 1st level approval");
		logger.info("User navigate to Functional role overview page and check if the status is pending after 1st level approval");
		String approval_status_after_level2_approval = approver_overview.approvetheFR_Request("Functional Role",
				funational_role_Overview_table_input, usertype, prop.getStatus_pending());
		s.assertTrue(approval_status_after_level2_approval.equals(prop.getStatus_Approved()));
		test.pass("User is able to approve 2nd level approval");
		logger.info("User is able to approve 2nd level approval");
		String cert = f
				.ValidatetheStandardCertificateofthe_Functionalrole_after_2level_approval(prop.getStatus_Approved());
		String[] standard_cert = cert.split(",");
		test.pass("User is able to view the Standard Certificate for the raised functional role" + cert);
		logger.info("User is able to view the Standard Certificate for the raised functional role" + cert);
		return standard_cert;
	}

}
