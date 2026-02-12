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

public class TC32_DiagnosticAuthority_ATG extends BaseClass {

	@Test(dataProvider = "getData_Internal", priority = 0, enabled=false)
	public static void create_Diagnostic_Authority__Request_Internal_test_case(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"+ "Diagnostic Authority Request for Internal- status pending:" + "</u></i></b>");		
		TC07_STD_ATG_FRapproved.Funtional_role_request_approved_Internal(input);
		Thread.sleep(3000);
		myreq.select_NewPermission_request();
		newper.Diagnostic_Authority_ECU_Visible_or_not_for_pending_Approved(input);
		req.request_Overview();
		test.pass("User is able to verify selected ecu is not visible when the sttaus is in pending");
		logger.info("User is able to verify selected ecu is not visible when the sttaus is in pending");
		softAssertionALL();

	}

	@Test(dataProvider = "getData_External", priority = 1, enabled=false)
	public static void create_Diagnostic_Authority__Request_External_test_case(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Diagnostic Authority Request for External- status pending:" + "</u></i></b>");	
		String select_user_type = TC03_Requests_STD_ATG_FR.login_and_select_user_ATG(prop.get_user_type_external());
		String functional_role_selected =TC03_Requests_STD_ATG_FR. raise_External_functional_role(input);
		List<Object> functional_role= create_and_approve_External_FR_request(input);
		create_DA_request(input, functional_role);
		test.pass("User is able to verify selected ecu is not visible when the sttaus is in pending");
		logger.info("User is able to verify selected ecu is not visible when the sttaus is in pending");
		softAssertionALL();
	}

	@Test(dataProvider = "getData_Supplier", priority = 2)
	public static void create_Diagnostic_Authority__Request_Supplier_test_case(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Standard Functional Request-ATG:" + "</u></i></b>");
		TC07_STD_ATG_FRapproved.Funtional_role_request_approved_Supplier(input);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Standard Functional Request for Supplier - status Approved-ATG:" + "</u></i></b>");
		AbstractComponents.refresh();
		myreq.select_NewPermission_request();
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Diagnostic Authority - Supplier-ATG" + "</u></i></b>");
		newper.Diagnostic_Authority_Supplier_Created(input);
		req.request_Overview();
		req.search_here("HARNAGA");
		approver_overview.filter_search(prop.getStatus_pending());
		req.scrollForReason();
		softAssertionALL();

	}

	@DataProvider
	public Object[][] getData_Internal() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//Diagnostic_Authority.json");
		return new Object[][] { { data.get(8) } };

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
	public static List<Object> create_and_approve_External_FR_request(HashMap<String, String> input) throws Throwable {
		List<Object> funational_role_Overview_table_input = TC02_Requests_STD_GLOBAL.functional_role_Overview_table_validation(input.get("User_Type"));
		String select_user_type=input.get("User_Type");
		String functional_role_selected =input.get("Functional_role_External");
		String[] standard_cert = functional_role(select_user_type, funational_role_Overview_table_input,
				functional_role_selected);
		return Arrays.asList(standard_cert, functional_role_selected, select_user_type);
	}

	public static List<String> create_DA_request(HashMap<String, String> input, List<Object> functional_role)
			throws Throwable {
		test.info("Diagnostic AUthority request");
		logger.info("Diagnostic AUthority request");
		myreq.select_NewPermission_request();
		boolean request_Overview_enabled = newper.raise_Diagnostic_Authority_Request(input,
				(String) functional_role.get(1), input.get("User_role"), input.get("ECU_Restriction"),
				input.get("Reason_for_DA"));
		s.assertTrue(request_Overview_enabled);
		List<String> request_Overview_input = req.request_Overview_table_validation(prop.getUser_name(), "ALL");
		s.assertTrue(request_Overview_input.get(0).equals(prop.getStatus_pending()));
		test.pass("User is able to view the approval status as pending once the DA request created");
		logger.info("User is able to view the approval status as pending once the DA request created");
		return request_Overview_input;
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
