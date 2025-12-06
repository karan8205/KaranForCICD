package DAMS.Testcases.Smoke_Suite_1;

import static DAMS.Resources.Listeners.test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import DAMS.Resources.BaseClass;

public class TC07_STD_ATG_FRapproved extends BaseClass {
	// Creating and approving Functional role request-Internal,External and Supplier

	@Test(dataProvider = "getData_Internal", priority = 0, enabled=false)
	public static void Funtional_role_request_approved_Internal(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Internal Functional role request - status approved:" + "</u></i></b>");
		String select_user_type =TC03_Requests_STD_ATG_FR. login_and_select_user_ATG(prop.get_user_type_Internal());
		String functional_role_selected = TC03_Requests_STD_ATG_FR.raise_Internal_functional_role(input);
		test.pass("User is able to raise the request for the functional role " + functional_role_selected);
		logger.info("User is able to raise the request for the functional role " + functional_role_selected);
		create_and_approve_Internal_FR_request(input);
	}

	@Test(dataProvider = "getData_External", priority = 1)
	public static void Funtional_role_request_approved_External(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "External Functional role request - status approved:" + "</u></i></b>");
		create_and_approve_External_FR_request(input);
		test.pass("User is able to verify click here to apply for functional role disbled for approved request");
		logger.info("User is able to verify click here to apply for functional role disbled for approved request");
		softAssertionALL();
	}

	@Test(dataProvider = "getData_Supplier", priority = 2,enabled=false)
	public static void Funtional_role_request_approved_Supplier(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Supplier Functional role request - status approved:" + "</u></i></b>");
		create_and_approve_Supplier_FR_request(input);
		test.pass("User is able to verify click here to apply for functional role disbled for approved request");
		logger.info("User is able to verify click here to apply for functional role disbled for approved request");
		softAssertionALL();
	}

	@DataProvider
	public Object[][] getData_Internal() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//New_functional_role_Request.json");
		return new Object[][] { { data.get(8) } };

	}

	@DataProvider
	public Object[][] getData_External() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//New_functional_role_Request.json");
		return new Object[][] { { data.get(17) } };

	}

	@DataProvider
	public Object[][] getData_Supplier() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//New_functional_role_Request.json");
		return new Object[][] { { data.get(12) } };

	}

	public static List<Object> create_and_approve_Internal_FR_request(HashMap<String, String> input) throws Throwable {
		List<Object> funational_role_Overview_table_input = TC03_Requests_STD_ATG_FR.functional_role_Overview_table_validation(prop.get_user_type_Internal());
		String select_user_type=input.get("User_Type");
		String functional_role_selected =input.get("Functional_role_internal");
		String[] standard_cert = functional_role(select_user_type, funational_role_Overview_table_input,
				functional_role_selected);
		return Arrays.asList(standard_cert, functional_role_selected, select_user_type);
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

	public static List<Object> create_and_approve_Supplier_FR_request(HashMap<String, String> input) throws Throwable {
		String select_user_type = TC03_Requests_STD_ATG_FR
				.login_and_select_user_ATG(prop.get_User_type_Supplier());
		String functional_role_selected = TC03_Requests_STD_ATG_FR
				.raise_Supplier_functional_role(input);
		List<Object> funational_role_Overview_table_input = TC03_Requests_STD_ATG_FR
				.functional_role_Overview_table_validation(select_user_type);
		String[] standard_cert = functional_role(select_user_type, funational_role_Overview_table_input,
				functional_role_selected);
		return Arrays.asList(standard_cert, functional_role_selected, select_user_type);
	}

	public static List<Object> create_and_approve_Supplier_FR_request_for_more_than_one_ECU(
			HashMap<String, String> input) throws Throwable {
		String select_user_type = TC02_Requests_STD_GLOBAL
				.login_and_select_user(prop.get_User_type_Supplier());
		String functional_role_selected = TC02_Requests_STD_GLOBAL
				.raise_Supplier_functional_role(input);
		List<Object> funational_role_Overview_table_input = TC02_Requests_STD_GLOBAL
				.functional_role_Overview_table_validation(select_user_type);
		String[] standard_cert = functional_role(select_user_type, funational_role_Overview_table_input,
				functional_role_selected);
		return Arrays.asList(standard_cert, functional_role_selected, select_user_type);
	}

	public static List<Object> create_and_approve_Supplier_FR_request_for_ECU_Cert(HashMap<String, String> input,
			String fileContent) throws Throwable {
		String select_user_type = TC02_Requests_STD_GLOBAL
				.login_and_select_user(prop.get_User_type_Supplier());
		String functional_role_selected = TC02_Requests_STD_GLOBAL
				.raise_Supplier_functional_role_ECU_cert(input, fileContent);
		List<Object> funational_role_Overview_table_input = TC02_Requests_STD_GLOBAL
				.functional_role_Overview_table_validation(select_user_type);
		String[] standard_cert = functional_role_for_ECU_cert(select_user_type, funational_role_Overview_table_input,
				functional_role_selected);
		return Arrays.asList(standard_cert, functional_role_selected, select_user_type);
	}

	public static String[] functional_role(String usertype, List<Object> funational_role_Overview_table_input,
			String functional_role_selected) throws Throwable {
		test.pass("Raise the request for the functional role " + functional_role_selected);
		logger.info("Raise the request for the functional role " + functional_role_selected);
		String approval_status_after_level1_approval = approver_overview.approvetheFR_Request("Functional Role",
				funational_role_Overview_table_input, usertype, prop.getStatus_pending());
		s.assertTrue(approval_status_after_level1_approval.equals(prop.getStatus_Approved()));
		test.pass("User is able to approve 1st level approval");
		logger.info("User is able to approve 1st level approval");
		f.navigate_to_functional_role_Overview_page_and_verify_approval_status(prop.getStatus_pending(), "N/A");
		test.pass("Navigate to FR overview page and status is pending after 1st level approval");
		logger.info("Navigate to FR overview page and status is pending after 1st level approval");
		String approval_status_after_level2_approval = approver_overview.approvetheFR_Request("Functional Role",
				funational_role_Overview_table_input, usertype, prop.getStatus_pending());
		s.assertTrue(approval_status_after_level2_approval.equals(prop.getStatus_Approved()));
		test.pass("User is able to approve 2nd level approval");
		logger.info("User is able to approve 2nd level approval");
		String cert = f
				.ValidatetheStandardCertificateofthe_Functionalrole_after_2level_approval(prop.getStatus_Approved());
		String[] standard_cert = cert.split(",");
		test.pass("View the Standard Certificate for the raised functional role" + cert);
		logger.info("View the Standard Certificate for the raised functional role" + cert);
		return standard_cert;
	}
	
	public static String[] functional_role_for_ECU_cert(String usertype, List<Object> funational_role_Overview_table_input,
			String functional_role_selected) throws Throwable {
		test.pass("Raise the request for the functional role " + functional_role_selected);
		logger.info("Raise the request for the functional role " + functional_role_selected);
		String approval_status_after_level1_approval = approver_overview.approvetheFR_Request("Functional Role",
				funational_role_Overview_table_input, usertype, prop.getStatus_pending());
		s.assertTrue(approval_status_after_level1_approval.equals(prop.getStatus_Approved()));
		test.pass("View the approval status as Approved after 1st level approval");
		logger.info("View the approval status as Approved after 1st level approval");
		f.navigate_to_functional_role_Overview_page_and_verify_approval_status(prop.getStatus_pending(), "N/A");
		test.pass(
				"View navigate to FR overview page and status is pending after 1st level approval");
		logger.info(
				"View navigate to FR overview page and status is pending after 1st level approval");
		String approval_status_after_level2_approval = approver_overview.approvetheFR_Request("Functional Role",
				funational_role_Overview_table_input, usertype, prop.getStatus_pending());
		s.assertTrue(approval_status_after_level2_approval.equals(prop.getStatus_Approved()));
		test.pass("View the approval status as Approved after 2nd level approval");
		logger.info("View the approval status as Approved after 2nd level approval");
		String cert = f
				.ValidatetheStandardCertificateofthe_Functionalrole_after_2level_approval_for_ECu_cert(prop.getStatus_Approved());
		String[] standard_cert = cert.split(",");
		test.pass("View the Standard Certificate for the raised functional role" + cert);
		logger.info("View the Standard Certificate for the raised functional role" + cert);
		return standard_cert;
	}

	public static String[] functional_role_for_more_than_one_values(String usertype,
			List<Object> funational_role_Overview_table_input, List<Object> functional_role_selected,
			String[] eCU_Qualifiers) throws Throwable {
		test.pass("Raise the request for the functional role " + functional_role_selected);
		logger.info("Raise the request for the functional role " + functional_role_selected);
		String[] standard_cert = null;
		for (int i = 0; i < eCU_Qualifiers.length; i++) {
			String approval_status_after_level1_approval = approver_overview.approvetheFR_Request_for_more_than_one_ECU(
					"Functional Role", funational_role_Overview_table_input, usertype, prop.getStatus_pending(),
					eCU_Qualifiers[i]);
			s.assertTrue(approval_status_after_level1_approval.equals(prop.getStatus_Approved()));
			test.pass("View the approval status as Approved after 1st level approval");
			logger.info("View the approval status as Approved after 1st level approval");
			f.navigate_to_functional_role_Overview_page_and_verify_approval_status_for_more_than_one_ECU(
					prop.getStatus_pending(), "N/A", eCU_Qualifiers[i]);
			test.pass(
					"View navigate to Functional role overview page and status is pending after 1st level approval");
			logger.info(
					"View navigate to Functional role overview page and status is pending after 1st level approval");
			String approval_status_after_level2_approval = approver_overview.approvetheFR_Request_for_more_than_one_ECU(
					"Functional Role", funational_role_Overview_table_input, usertype, prop.getStatus_pending(),
					eCU_Qualifiers[i]);
			s.assertTrue(approval_status_after_level2_approval.equals(prop.getStatus_Approved()));
			test.pass("View the approval status as Approved after 2nd level approval");
			logger.info("View the approval status as Approved after 2nd level approval");
			String cert = f.ValidatetheStandardCertificateofthe_Functionalrole_for_more_than_one_ECU(
					prop.getStatus_Approved(), eCU_Qualifiers[i]);
			standard_cert = cert.split(",");
			test.pass("View the Standard Certificate for raised functional role" + cert);
			logger.info("View the Standard Certificate for raised functional role" + cert);
		}
		return standard_cert;
	}

}
