package DAMS.Testcases.Smoke_Suite_1;


import static DAMS.Resources.Listeners.test;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import DAMS.Resources.AbstractComponents;
import DAMS.Resources.BaseClass;

public class TC47_ReplacementPackage_RootLink_ATG extends BaseClass {

	@Test(dataProvider = "getData_Internal", priority = 0,enabled=false)
	public static void create_replacement_package_Internal(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Replacment package request Internal- status pending" + "</u></i></b>");
		TC07_STD_ATG_FRapproved.Funtional_role_request_approved_Internal(input);
		create_replacement_package_request(input.get("Functional_role_internal"),input.get("SpecialCase"),
				input.get("Orgin_COT"), input.get("Reason_for_RP"), input.get("Target_COT"),
				input.get("ECU_Qualifier_for_RP"));
		test.pass("User is able to create Replacement package request when the status is pending");
		logger.info("User is able to create Replacement package request when the status is pending");
		softAssertionALL();
	}

	@Test(dataProvider = "getData_External", priority = 1)
	public static void create_replacemnet_package_External(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Replacment package request External- status pending" + "</u></i></b>");
		TC07_STD_ATG_FRapproved.create_and_approve_External_FR_request(input);
		create_replacement_package_request(input.get("Functional_role_External"),input.get("SpecialCase"),
				input.get("Orgin_COT"), input.get("Reason_for_RP"), input.get("Target_COT"),
				input.get("ECU_Qualifier_for_RP"));
		test.pass("User is able to create Replacement package request when the status is pending");
		logger.info("User is able to create Replacement package request when the status is pending");
		softAssertionALL();
	}

	@Test(dataProvider = "getData_Supplier", priority = 2,enabled=false)
	public static void create_replacemnet_package_Supplier(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Standard Functional Request-ATG:" + "</u></i></b>");
		TC07_STD_ATG_FRapproved.Funtional_role_request_approved_Supplier(input);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Standard Functional Request for Supplier - status Approved-ATG:" + "</u></i></b>");
		AbstractComponents.refresh();
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Replacement Package - Supplier-ATG" + "</u></i></b>");
		List<String >create_replacement_package_request = create_replacement_package_request_Supplier(input.get("Functional_role_internal"),input.get("SpecialCase"),
				input.get("Orgin_COT"), input.get("Reason_for_RP"), input.get("Target_COT"),
				input.get("ECU_Qualifier_for_RP"));
		softAssertionALL();
	}

	@DataProvider
	public Object[][] getData_Internal() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//ReplacementPackage.json");
		return new Object[][] { { data.get(10) } };
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

	public static List<String> create_replacement_package_request(String functionalrole,String SpecialCase, String Orgin_COT, String Reason_for_RP, String Target_COT, String ECU_Qualifier_for_RP) throws Throwable {
		test.info("Replacement package request");
		logger.info("Replacement package request");
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
	public static List<String> create_replacement_package_request_Supplier(String functionalrole,String SpecialCase, String Orgin_COT, String Reason_for_RP, String Target_COT, String ECU_Qualifier_for_RP) throws Throwable {
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

