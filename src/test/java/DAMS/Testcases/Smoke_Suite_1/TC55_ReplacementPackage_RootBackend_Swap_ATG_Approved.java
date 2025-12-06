package DAMS.Testcases.Smoke_Suite_1;


import static DAMS.Resources.Listeners.test;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import DAMS.Resources.BaseClass;

public class TC55_ReplacementPackage_RootBackend_Swap_ATG_Approved extends BaseClass {

	@Test(dataProvider = "getData_Internal", priority = 0,enabled=false)
	public static void replacementPackage_ATG_RootBackend_Internal_Approved(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Replacment package request Internal- status pending" + "</u></i></b>");
		TC07_STD_ATG_FRapproved.Funtional_role_request_approved_Internal(input);
		List<String >create_replacement_package_request = create_replacement_package_request(input);
		approve_special_cases_Replacement_request(input,create_replacement_package_request);	
		test.pass("User is able to create Replacement package request when the status is pending");
		logger.info("User is able to create Replacement package request when the status is pending");
		softAssertionALL();
	}

	@Test(dataProvider = "getData_External", priority = 1)
	public static void replacementPackage_ATG_RootBackend_External_Approved(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Replacment package request External- status pending" + "</u></i></b>");
		TC07_STD_ATG_FRapproved.Funtional_role_request_approved_External(input);
		List<String >create_replacement_package_request = create_replacement_package_request_External(input);
		approve_special_cases_Replacement_request(input,create_replacement_package_request);		
		test.pass("User is able to create Replacement package request when the status is pending");
		logger.info("User is able to create Replacement package request when the status is pending");
		softAssertionALL();
	}

	@Test(dataProvider = "getData_Supplier", priority = 2,enabled=false)
	public static void replacementPackage_ATG_RootBackend_Supplier_Approved(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Replacment package request Supplier- status pending" + "</u></i></b>");
		List<String >create_replacement_package_request = TC53_ReplacementPackage_RootBackend_Swap_ATG.create_replacement_package_request_Supplier(input);
		approve_special_cases_Replacement_request(input,create_replacement_package_request);
		test.pass("User is able to create Replacement package request when the status is Approved");
		logger.info("User is able to create Replacement package request when the status is Approved");
		softAssertionALL();
	}

	@DataProvider
	public Object[][] getData_Internal() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//ReplacementPackage.json");
		return new Object[][] { { data.get(12) } };
	}

	@DataProvider
	public Object[][] getData_External() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//ReplacementPackage.json");
		return new Object[][] { { data.get(19) } };
	}

	@DataProvider
	public Object[][] getData_Supplier() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//ReplacementPackage.json");
		return new Object[][] { { data.get(6) } };
	}
	public static List<String> create_replacement_package_request(HashMap<String, String> input) throws Throwable {
		test.info("Replacement package request");
		logger.info("Replacement package request");
		myreq.select_NewPermission_request();
		boolean request_Overview_enabled = newper.raise_replacement_package_Request(input.get("Functional_role_internal"),input.get("SpecialCase"),
				input.get("Orgin_COT"), input.get("Reason_for_RP"), input.get("Target_COT"),
				input.get("ECU_Qualifier_for_RP"),input.get("BackendRoot_COT"),input.get("BackendOrigin_COT"),input.get("BackendTarget_COT"));
		Assert.assertTrue(request_Overview_enabled);
		test.info("Request overview tab enabled");
		logger.info("Request overview tab enabled");
		List<String> replacement_package_table_input = req
				.request_Overview_table_validation_for_replacement_package("Replacement Package", prop.getUser_name());
		Assert.assertTrue(replacement_package_table_input.get(0).equals(prop.getStatus_pending()));
		test.pass("User is able to view the approval status as pending once the Replacement package request created");
		logger.info("User is able to view the approval status as pending once the Replacement package request created");
		return replacement_package_table_input;
	}
	public static List<String> create_replacement_package_request_External(HashMap<String, String> input) throws Throwable {
		test.info("Replacement package request");
		logger.info("Replacement package request");
		myreq.select_NewPermission_request();
		boolean request_Overview_enabled = newper.raise_replacement_package_Request(input.get("Functional_role_External"),input.get("SpecialCase"),
				input.get("Orgin_COT"), input.get("Reason_for_RP"), input.get("Target_COT"),
				input.get("ECU_Qualifier_for_RP"),input.get("BackendRoot_COT"),input.get("BackendOrigin_COT"),input.get("BackendTarget_COT"));
		Assert.assertTrue(request_Overview_enabled);
		test.info("Request overview tab enabled");
		logger.info("Request overview tab enabled");
		List<String> replacement_package_table_input = req
				.request_Overview_table_validation_for_replacement_package("Replacement Package", prop.getUser_name());
		Assert.assertTrue(replacement_package_table_input.get(0).equals(prop.getStatus_pending()));
		test.pass("User is able to view the approval status as pending once the Replacement package request created");
		logger.info("User is able to view the approval status as pending once the Replacement package request created");
		return replacement_package_table_input;
	}
	
	public static void approve_special_cases_Replacement_request(HashMap<String, String> input,
			List<String> create_special_cases_Replacement_request) throws Throwable {
		String Replacement_approval_status_after_level1_approval = approver_overview.approve_replacement_Package_Request(prop.get_user_type_Internal(),prop.getStatus_pending(),input.get("SpecialCase"), create_special_cases_Replacement_request);
		s.assertTrue(Replacement_approval_status_after_level1_approval.equals(prop.getStatus_Approved()));
		test.pass("User is able to view the approval status as Approved after 1st level approval");
		logger.info("User is able to view the approval status as Approved after 1st level approval");
		req.navigate_to_request_Overview_page_and_verify_approval_status_RP_NestT(prop.getStatus_pending(), "N/A", "N/A",
				input.get("SpecialCase"), prop.getUser_name());
		test.pass(
				"User is able to view navigate to request role overview page and check if the status is pending after 1st level approval");
		logger.info(
				"User is able to view navigate to request role overview page and check if the status is pending after 1st level approval");
		String Replacement_approval_status_after_level2_approval = approver_overview.approve_replacement_Package_Request(prop.get_user_type_Internal(),prop.getStatus_pending(),input.get("SpecialCase"), create_special_cases_Replacement_request);
		s.assertTrue(Replacement_approval_status_after_level2_approval.equals(prop.getStatus_Approved()));
		test.pass("User is able to view the approval status as Approved after 2nd level approval");
		logger.info("User is able to view the approval status as Approved after 2nd level approval");
		String todays_date = todays_date();
		req.navigate_to_request_Overview_page_and_verify_approval_status_RP_NestT(prop.getStatus_Approved(), todays_date, "N/A",
				input.get("SpecialCase"), prop.getUser_name());
		test.pass(
				"User is able to view navigate to request role overview page and check if the status is approved after 2nd level approval");
		logger.info(
				"User is able to view navigate to request role overview page and check if the status is appproved after 2nd level approval");
	}
}

