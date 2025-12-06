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

public class TC23_ReplacementPackage_RootLink_GLOBAL extends BaseClass {

	@Test(dataProvider = "getData_Internal", priority = 0,enabled = false)
	public static void create_replacement_package_Internal(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Replacment package request Internal- status pending" + "</u></i></b>");
		TC06_STD_GLOBAL_FRapproved.Functional_role_request_approved_Internal(input);
		create_replacement_package_request(input.get("Functional_role_internal"),input.get("SpecialCase"),
				input.get("Orgin_COT"), input.get("Reason_for_RP"), input.get("Target_COT"),
				input.get("ECU_Qualifier_for_RP"));
		test.pass("User is able to create Replacement package request when the status is pending");
		logger.info("User is able to create Replacement package request when the status is pending");
		softAssertionALL();
	}

	@Test(dataProvider = "getData_External", priority = 1,enabled=false)
	public static void create_replacemnet_package_External(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Replacment package request External- status pending" + "</u></i></b>");
		String select_user_type = TC02_Requests_STD_GLOBAL.login_and_select_user_Global(input.get("User_Type"));
		String functional_role_selected =TC02_Requests_STD_GLOBAL. raise_External_functional_role(input);
		TC06_STD_GLOBAL_FRapproved.create_and_approve_External_FR_request(input);
		create_replacement_package_request(input.get("Functional_role_External"),input.get("SpecialCase"),
				input.get("Orgin_COT"), input.get("Reason_for_RP"), input.get("Target_COT"),
				input.get("ECU_Qualifier_for_RP"));
		test.pass("User is able to create Replacement package request when the status is pending");
		logger.info("User is able to create Replacement package request when the status is pending");
		softAssertionALL();
	}

	@Test(dataProvider = "getData_Supplier", priority = 2)
	public static void create_replacemnet_package_Supplier(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Replacment package request Supplier- status pending" + "</u></i></b>");
		cleanup_before(prop.getUsername_MFA(), prop.getPassword_MFA(), prop.getcleanupUrl());
		test.pass("User is able to clean data");
		logger.info("User is able to clean data");
		TC06_STD_GLOBAL_FRapproved.create_and_approve_Supplier_FR_request(input);
		create_replacement_package_request(input.get("Functional_role_supplier"),input.get("SpecialCase"),
				input.get("Orgin_COT"), input.get("Reason_for_supplier_FR"), input.get("Target_COT"),
				input.get("ECU_Supplier"));
		test.pass("User is able to create Replacement package request when the status is pending");
		logger.info("User is able to create Replacement package request when the status is pending");
		softAssertionALL();
	}

	@DataProvider
	public Object[][] getData_Internal() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//ReplacementPackage.json");
		return new Object[][] { { data.get(1) } };

	}

	@DataProvider
	public Object[][] getData_External() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//ReplacementPackage.json");
		return new Object[][] { { data.get(18) } };

	}

	@DataProvider
	public Object[][] getData_Supplier() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//ReplacementPackage.json");
		return new Object[][] { { data.get(6) } };

	}

	public static List<String> create_replacement_package_request(String functionalrole,String SpecialCase, String Orgin_COT, String Reason_for_RP, String Target_COT, String ECU_Qualifier_for_RP) throws Throwable {
		test.info("Replacement package request");
		logger.info("Replacement package request");
		Thread.sleep(2000);
		 myreq.select_NewPermission_request();
		boolean request_Overview_enabled = newper.raise_replacement_package_Request(functionalrole ,SpecialCase,Orgin_COT,  Reason_for_RP, Target_COT, ECU_Qualifier_for_RP);
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

}

