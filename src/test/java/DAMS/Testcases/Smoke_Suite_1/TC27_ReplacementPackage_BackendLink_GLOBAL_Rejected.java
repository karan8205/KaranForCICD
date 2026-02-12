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

public class TC27_ReplacementPackage_BackendLink_GLOBAL_Rejected extends BaseClass {

	@Test(dataProvider = "getData_Internal", priority = 0)
	public static void create_and_reject_Replacement_Request_Internal_test_case(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Replacment package request Internal- status pending" + "</u></i></b>");
		TC06_STD_GLOBAL_FRapproved.Functional_role_request_approved_Internal(input);
		List<String >create_replacement_package_request = create_replacement_package_request(input);
		reject_special_cases_Replacement_request(input,create_replacement_package_request);		
		test.pass("User is able to create Replacement package request when the status is pending");
		logger.info("User is able to create Replacement package request when the status is pending");
		softAssertionALL();
	}

	@Test(dataProvider = "getData_External", priority = 1,enabled=false)
	public static void create_replacemnet_package_External(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Replacment package request External- status pending" + "</u></i></b>");
		List<String >create_replacement_package_request=create_replacemnet_package_External1(input);
		reject_special_cases_Replacement_request(input,create_replacement_package_request);
		test.pass("User is able to create Replacement package request when the status is pending");
		logger.info("User is able to create Replacement package request when the status is pending");
		softAssertionALL();
	}

	@Test(dataProvider = "getData_Supplier", priority = 2,enabled=false)
	public static void create_replacemnet_package_Supplier(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Replacment package request Supplier- status pending" + "</u></i></b>");
		TC06_STD_GLOBAL_FRapproved.create_and_approve_Supplier_FR_request(input);
		List<String >create_replacement_package_request=create_replacement_package_request_Supplier(input.get("Functional_role_internal"),input.get("SpecialCase"),
				input.get("Orgin_COT"), input.get("Reason_for_RP"), input.get("Target_COT"),
				input.get("ECU_Qualifier_for_RP"),input.get("BackendRoot_COT"));
		reject_special_cases_Replacement_request(input,create_replacement_package_request);
		test.pass("User is able to create Replacement package request when the status is Approved");
		logger.info("User is able to create Replacement package request when the status is Approved");
		softAssertionALL();
	}

	@DataProvider
	public Object[][] getData_Internal() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//ReplacementPackage.json");
		return new Object[][] { { data.get(2) } };

	}

	@DataProvider
	public Object[][] getData_External() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//ReplacementPackage.json");
		return new Object[][] { { data.get(5) } };

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
		boolean request_Overview_enabled = newper.raise_replacement_package_Request(input.get("Functional_role_internal"),input.get("SpecialCase"), input.get("Reason_for_RP"),
				input.get("ECU_Qualifier_for_RP"),input.get("BackendRoot_COT"),input.get("BackendOrigin_COT"),input.get("BackendTarget_COT"));
		test.pass("User is able to create Replacement package request when the status is pending");
		Assert.assertTrue(request_Overview_enabled);
		test.info("Request overview tab enabled");
		logger.info("Request overview tab enabled");
		List<String> replacement_package_table_input = req
				.request_Overview_table_validation_for_replacement_package("Replacement Package", "HARNAGA");
		Assert.assertTrue(replacement_package_table_input.get(0).equals(prop.getStatus_pending()));
		test.pass("User is able to view the approval status as pending once the Replacement package request created");
		logger.info("User is able to view the approval status as pending once the Replacement package request created");
		return replacement_package_table_input;
	}
	
	public static List<String> create_replacemnet_package_External1(HashMap<String, String> input) throws Throwable {
		test.info("Replacement package request");
		logger.info("Replacement package request");
		myreq.select_NewPermission_request();
		boolean request_Overview_enabled = newper.raise_replacement_package_Request(input.get("Functional_role_External"),input.get("SpecialCase"), input.get("Reason_for_RP"),
				input.get("ECU_Qualifier_for_RP"),input.get("BackendRoot_COT"),input.get("BackendOrigin_COT"),input.get("BackendTarget_COT"));
		test.pass("User is able to create Replacement package request when the status is pending");
		Assert.assertTrue(request_Overview_enabled);
		test.info("Request overview tab enabled");
		logger.info("Request overview tab enabled");
		List<String> replacement_package_table_input = req
				.request_Overview_table_validation_for_replacement_package("Replacement Package", "HARNAGA");
		Assert.assertTrue(replacement_package_table_input.get(0).equals(prop.getStatus_pending()));
		test.pass("User is able to view the approval status as pending once the Replacement package request created");
		logger.info("User is able to view the approval status as pending once the Replacement package request created");
		return replacement_package_table_input;
	}
	public static List<String> create_replacement_package_request_Supplier(String functionalrole,String SpecialCase, String Reason_for_RP, String ECU_Qualifier_for_RP,String BackendRoot_COT,String BackendOrigin_COT,String BackendTarget_COT) throws Throwable {
		test.info("Replacement package request");
		logger.info("Replacement package request");
		myreq.select_NewPermission_request();
		boolean request_Overview_enabled = newper.raise_replacement_package_Request(functionalrole,SpecialCase,Reason_for_RP, ECU_Qualifier_for_RP,BackendRoot_COT,BackendOrigin_COT,BackendTarget_COT);
		Assert.assertTrue(request_Overview_enabled);
		test.info("Request overview tab enabled");
		logger.info("Request overview tab enabled");
		List<String> replacement_package_table_input = req
				.request_Overview_table_validation_for_replacement_package("Replacement Package", "HARNAGA");
		Assert.assertTrue(replacement_package_table_input.get(0).equals(prop.getStatus_pending()));
		test.pass("User is able to view the approval status as pending once the Replacement package request created");
		logger.info("User is able to view the approval status as pending once the Replacement package request created");
		return replacement_package_table_input;
	}
	
	public static void reject_special_cases_Replacement_request(HashMap<String, String> input,
			List<String> create_replacement_package_request) throws Throwable {
		String Replacement_approval_status_after_level1_approval = approver_overview
				.reject_replacement_package_Request(input.get("Reason_for_RP"), input.get("SpecialCase"),prop.get_user_type_Internal(), create_replacement_package_request);
		s.assertTrue(Replacement_approval_status_after_level1_approval.equals(prop.getStatus_rejected()));
		test.pass("User is able to view the approval status as rejected in approver page");
		logger.info("User is able to view the approval status as rejected in approver page");
		req.navigate_to_request_Overview_page_and_verify_approval_status(prop.getStatus_rejected(), "N/A",
				reason_for_rejection, input.get("SpecialCase"), prop.getUser_name());
		test.pass("User is able to view the approval status as rejected in request overview page");
		logger.info("User is able to view the approval status as rejected in request overview page");
	}
	


}

