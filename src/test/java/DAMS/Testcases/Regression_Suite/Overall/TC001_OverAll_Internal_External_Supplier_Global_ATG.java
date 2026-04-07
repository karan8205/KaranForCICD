package DAMS.Testcases.Regression_Suite.Overall;

import static DAMS.Resources.Listeners.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import DAMS.Resources.AbstractComponents;
import DAMS.Resources.BaseClass;
import DAMS.Resources.Listeners;
import DAMS.Resources.PropertyFile;
import DAMS.Testcases.Smoke_Suite_1.TC01_Login_MFA;
import DAMS.Testcases.Smoke_Suite_1.TC02_Requests_STD_GLOBAL;
import DAMS.Testcases.Smoke_Suite_1.TC03_Requests_STD_ATG_FR;
import DAMS.Testcases.Smoke_Suite_1.TC06_STD_GLOBAL_FRapproved;
import DAMS.Testcases.Smoke_Suite_1.TC07_STD_ATG_FRapproved;
import DAMS.Testcases.Smoke_Suite_1.TC10_Diagnostic_Authority_GLOBAL_Approved;
import DAMS.Testcases.Smoke_Suite_1.TC11_EnhanceRightAuthority_GLOBAL;
import DAMS.Testcases.Smoke_Suite_1.TC13_EnhanceRightAuthority_GLOBAL_Approved;

public class TC001_OverAll_Internal_External_Supplier_Global_ATG extends BaseClass {
	
	// public static Map<String, Object> input;

	@Test(dataProvider = "getData_Internal", priority = 0)
	public static void Overall_Global_ATG_Regression_E2E_Internal(HashMap<String, String> input) throws Throwable {
		try {
		String	select_user_type = String.valueOf(input.get("User_Type")).trim().toLowerCase();
			if (select_user_type.equals("internal")) {

				TC01_Login_MFA.login_with_addressing_MFA_Internal();

			} else {
				System.out.println("Wrong User Type : " + select_user_type);
			}

			System.out.println("\n" + input + "\n");
			String Functional_Role = input.get("Functional_role_internal");
			String mode = input.get("Mode");
			if (mode.equalsIgnoreCase("Global")) {
				select_user_type = TC02_Requests_STD_GLOBAL.select_user_Global(ctx().prop.get_user_type_Internal());
				String functional_role_selected = TC02_Requests_STD_GLOBAL.raise_Internal_functional_role(input);
				test.pass("Request created and in pending status " + functional_role_selected);
				logger.info("Request created and in pending status " + functional_role_selected);
				TC02_Requests_STD_GLOBAL.functional_role_Overview_table_validation(select_user_type,
						ctx().prop.getInternalName());
				TC06_STD_GLOBAL_FRapproved.create_and_approve_Internal_FR_request(input);
			} else if (mode.equalsIgnoreCase("ATG")) {
				  login_and_select_user_ATG(ctx().prop.get_user_type_Internal());
				String functional_role_selected = TC03_Requests_STD_ATG_FR.raise_Internal_functional_role(input);
				test.pass("User is able to raise the request for the functional role " + functional_role_selected);
				logger.info("User is able to raise the request for the functional role " + functional_role_selected);
				TC07_STD_ATG_FRapproved.create_and_approve_Internal_FR_request(input);
			}
			test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>" + "***************" + Functional_Role
					+ " Functional Role Approved *************" + "</u></i></b>");
			// --------------------------------------------
			AbstractComponents.refresh();
			waitForPageLoad(BaseClass.getDriver());
			ctx().myreq.select_NewPermission_request();
			if (!Functional_Role.equalsIgnoreCase("Production - ATG")) {
				ctx().newper.Diagnostic_Authority_ECU_Visible_or_not_for_pending_Approved(input);
				ctx().req.request_Overview();
				Thread.sleep(3000);
				ctx().req.select_Applicant_type("Myself");
				Thread.sleep(2000);
				ctx().approver_overview.filter_search(ctx().prop.getStatus_pending());
				ctx().req.scrollForReason();
				List<String> applicantNumber = req.getMultipleApplicantNumber();
				TC10_Diagnostic_Authority_GLOBAL_Approved.approve_DA_request(input);
				test.log(Status.PASS, "<span style=\"color: blue;\"><b><i><u>" + "***************" + applicantNumber
						+ " DA Approved *************" + "</u></i></b>");
				logger.info("Verify selected ecu is not visible when the status is in approved");
			}
			test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
					+ "Creation of Enhance Right Authority - Internal" + "</u></i></b>");
			AbstractComponents.refresh();
			ctx().myreq.select_NewPermission_request();
			ctx().newper.raise_Enhance_Right_Request(input);
			Thread.sleep(5000);
			ctx().req.request_Overview();
			ctx().req.select_request_type("Enhance Right");
			ctx().req.select_Applicant_type("Myself");
			Thread.sleep(2000);
			ctx().approver_overview.filter_search(ctx().prop.getStatus_pending());
			ctx().req.scrollForReason();
			List<String> EA_applicantNumber = req.getMultipleApplicantNumber();

			TC13_EnhanceRightAuthority_GLOBAL_Approved.approve_Enhance_Right_Authority_request(input);
			test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>" + EA_applicantNumber
					+ "Enhance Right Authority for Internal- status Approved:" + "</u></i></b>");
			AbstractComponents.refresh();
			if (!Functional_Role.equalsIgnoreCase("Production")) {
				if (Functional_Role.equalsIgnoreCase("Development")
						|| Functional_Role.equalsIgnoreCase("Development - ATG")) {
					AbstractComponents.refresh();
					ctx().myreq.select_NewPermission_request();
					ctx().newper.raise_nestT_Request_Multiple(input);
					approve_Multiple_special_cases_nestT_request(input,ctx().prop.getInternalName());
					test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
							+ "Nest-T Testing for Internal- status Approved:" + "</u></i></b>");
					test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
							+ "Creation of Replacement Package - Internal" + "</u></i></b>");
					AbstractComponents.refresh();
				}
				if (!Functional_Role.equalsIgnoreCase("Production")) {
					List<String> create_replacement_package_request_id_front = create_replacement_package_request_root(
							input);
					waitForPageLoad(BaseClass.getDriver());
					Thread.sleep(3000);
					approve_special_cases_Replacement_request(input, create_replacement_package_request_id_front,ctx().prop.getInternalName());
					waitForPageLoad(BaseClass.getDriver());
					Thread.sleep(3000);
					List<String> create_replacement_package_request_id_back = create_replacement_package_request_backend(
							input);
					approve_special_cases_Replacement_request(input, create_replacement_package_request_id_back,ctx().prop.getInternalName());
					waitForPageLoad(BaseClass.getDriver());
					Thread.sleep(3000);
					List<String> create_replacement_package_request_ids = create_replacement_package_request_rootbackend(
							input);
					waitForPageLoad(BaseClass.getDriver());
					Thread.sleep(3000);
					approve_special_cases_Replacement_request(input, create_replacement_package_request_ids,ctx().prop.getInternalName());
					test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
							+ "Replacement Package for Internal- status Approved:" + "</u></i></b>");
				}
			}

			AbstractComponents.refresh();
			waitForPageLoad(BaseClass.getDriver());
			Thread.sleep(5000);
			approver_overview.approver_Overview_enabled1();
			approver_overview.search_here(ctx().prop.getInternalName());
			getScreenshot(input.get("Mode") + "_" + input.get("User_Type") + "_ All Request", BaseClass.getDriver());
		} catch (Exception e) {
			e.printStackTrace();
			String filePath = null;
			filePath = getScreenshot(input.get("Functional_role_internal") + "error page", BaseClass.getDriver());
		}
		// after 1 data run
		AbstractComponents.refresh();
		Thread.sleep(5000);
		ctx().myreq.clickHomeButton();
	}
	//

	@Test(dataProvider = "getData_External", priority = 1,enabled=false)
	public static void Overall_Global_ATG_Regression_E2E_External(HashMap<String, String> input) throws Throwable {
		try {

		String	select_user_type = String.valueOf(input.get("User_Type")).trim().toLowerCase();
			if (select_user_type.equals("external")) {

				TC01_Login_MFA.login_with_addressing_MFA_External();

			} else {
				System.out.println("Wrong User Type : " + select_user_type);
			}
			System.out.println("\n\n" + input + "\n\n");
			String Functional_Role = input.get("Functional_role_External");
			String mode = input.get("Mode");
			if (mode.equalsIgnoreCase("Global")) {
				select_user_type = TC02_Requests_STD_GLOBAL.select_user_Global(input.get("User_Type"));
				String functional_role_selected = TC02_Requests_STD_GLOBAL.raise_External_functional_role(input);
				test.pass("Request created and in pending status " + functional_role_selected);
				logger.info("Request created and in pending status " + functional_role_selected);
				TC02_Requests_STD_GLOBAL.functional_role_Overview_table_validation(select_user_type,
						ctx().prop.getExternalName());
				TC06_STD_GLOBAL_FRapproved.create_and_approve_Internal_FR_request(input);
			} else if (mode.equalsIgnoreCase("ATG")) {
				 login_and_select_user_ATG(ctx().prop.get_user_type_Internal());
				String functional_role_selected = TC03_Requests_STD_ATG_FR.raise_External_functional_role(input);
				test.pass("User is able to raise the request for the functional role " + functional_role_selected);
				logger.info("User is able to raise the request for the functional role " + functional_role_selected);
				TC07_STD_ATG_FRapproved.create_and_approve_Internal_FR_request(input);
			}
			test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>" + "***************" + Functional_Role
					+ " Functional Role Approved *************" + "</u></i></b>");
			// --------------------------------------------
			AbstractComponents.refresh();
			waitForPageLoad(BaseClass.getDriver());
			ctx().myreq.select_NewPermission_request();
			if (!Functional_Role.equalsIgnoreCase("Production - ATG External")) {
				ctx().newper.Diagnostic_Authority_External_Created(input);
				ctx().req.request_Overview();
				Thread.sleep(3000);
				ctx().req.select_Applicant_type("Myself");
				Thread.sleep(2000);
				ctx().approver_overview.filter_search(ctx().prop.getStatus_pending());
				ctx().req.scrollForReason();
				List<String> applicantNumber = req.getMultipleApplicantNumber();
				TC10_Diagnostic_Authority_GLOBAL_Approved.approve_DA_request(input);
				test.log(Status.PASS, "<span style=\"color: blue;\"><b><i><u>" + "***************" + applicantNumber
						+ " DA Approved *************" + "</u></i></b>");
				logger.info("Verify selected ecu is not visible when the status is in approved");
			}
			test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
					+ "Creation of Enhance Right Authority - Internal" + "</u></i></b>");
			AbstractComponents.refresh();
			TC11_EnhanceRightAuthority_GLOBAL.create_Enhance_Right_Authority_request_External(input);
			Thread.sleep(5000);
			ctx().req.request_Overview();
			ctx().req.select_request_type("Enhance Right");
			ctx().req.select_Applicant_type("Myself");
			Thread.sleep(2000);
			ctx().approver_overview.filter_search(ctx().prop.getStatus_pending());
			ctx().req.scrollForReason();
			List<String> EA_applicantNumber = req.getMultipleApplicantNumber();

			TC13_EnhanceRightAuthority_GLOBAL_Approved.approve_Enhance_Right_Authority_request(input);
			test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>" + EA_applicantNumber
					+ "Enhance Right Authority for Internal- status Approved:" + "</u></i></b>");
			AbstractComponents.refresh();
			if (!Functional_Role.equalsIgnoreCase("Production External")) {
				if (Functional_Role.equalsIgnoreCase("Development External Support")
						|| Functional_Role.equalsIgnoreCase("Development - ATG External")) {
					AbstractComponents.refresh();
					ctx().myreq.select_NewPermission_request();
					ctx().newper.raise_nestT_Request_Supplier_Multiple(input);
					approve_Multiple_special_cases_nestT_request(input,ctx().prop.getExternalName());
					test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
							+ "Nest-T Testing for Internal- status Approved:" + "</u></i></b>");
					test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
							+ "Creation of Replacement Package - Internal" + "</u></i></b>");
					AbstractComponents.refresh();
				}
				List<String> create_replacement_package_request_id_front = create_replacement_package_request_root_External(
						input);
				waitForPageLoad(BaseClass.getDriver());
				Thread.sleep(3000);
				approve_special_cases_Replacement_request(input, create_replacement_package_request_id_front,ctx().prop.getExternalName());
				waitForPageLoad(BaseClass.getDriver());
				Thread.sleep(3000);
				List<String> create_replacement_package_request_id_back = create_replacement_package_request_backend_External(
						input);
				approve_special_cases_Replacement_request(input, create_replacement_package_request_id_back,ctx().prop.getExternalName());
				waitForPageLoad(BaseClass.getDriver());
				Thread.sleep(3000);
				List<String> create_replacement_package_request_ids = create_replacement_package_request_rootbackend(
						input);
				waitForPageLoad(BaseClass.getDriver());
				Thread.sleep(3000);
				approve_special_cases_Replacement_request(input, create_replacement_package_request_ids,ctx().prop.getExternalName());
				test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
						+ "Replacement Package for Internal- status Approved:" + "</u></i></b>");
			}

			AbstractComponents.refresh();
			waitForPageLoad(BaseClass.getDriver());
			Thread.sleep(5000);
			ctx().approver_overview.approver_Overview_enabled1();
			ctx().approver_overview.search_here(ctx().prop.getExternalName());
			getScreenshot(input.get("Mode") + "_" + input.get("User_Type") + "_ All Request", BaseClass.getDriver());
		} catch (Exception e) {
			e.printStackTrace();
			String filePath = null;
			filePath = getScreenshot(input.get("Functional_role_External") + "error page", BaseClass.getDriver());
		}
		// after 1 data run
		AbstractComponents.refresh();
		Thread.sleep(5000);
		ctx().myreq.clickHomeButton();
	}

	@Test(dataProvider = "getData_Supplier", priority = 2,enabled=false)
	public static void Overall_Global_ATG_Regression_E2E_Supplier(HashMap<String, String> input) throws Throwable {
		try {

			String select_user_type = String.valueOf(input.get("User_Type")).trim().toLowerCase();
			if (select_user_type.equals("supplier")) {
				TC01_Login_MFA.login_with_addressing_MFA_Supplier();
			} else {
				System.out.println("Wrong User Type : " + select_user_type);
			}
			System.out.println("\n" + input + "\n");
			String Functional_Role = input.get("Functional_role_supplier");
			String mode = input.get("Mode");
			if (mode.equalsIgnoreCase("Global")) {
				select_user_type = TC02_Requests_STD_GLOBAL.select_user_Global(input.get("User_Type"));
				String functional_role_selected = TC02_Requests_STD_GLOBAL.raise_Supplier_functional_role(input);
				test.pass("Request created and in pending status " + functional_role_selected);
				logger.info("Request created and in pending status " + functional_role_selected);
				TC06_STD_GLOBAL_FRapproved.approve_Supplier_FR_request(input);
			} else if (mode.equalsIgnoreCase("ATG")) {
				 login_and_select_user_ATG(ctx().prop.get_User_type_Supplier());
				String functional_role_selected = TC02_Requests_STD_GLOBAL
						.raise_Supplier_functional_role(input);
				List<Object> funational_role_Overview_table_input = TC02_Requests_STD_GLOBAL
						.functional_role_Overview_table_validation(select_user_type, ctx().prop.getSupplierName());
				String[] standard_cert = functional_role(select_user_type, funational_role_Overview_table_input,
						functional_role_selected);

			}
			test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>" + "***************" + Functional_Role
					+ " Functional Role Approved *************" + "</u></i></b>");
			// --------------------------------------------
			AbstractComponents.refresh();
			waitForPageLoad(BaseClass.getDriver());
			ctx().myreq.select_NewPermission_request();
			ctx().newper.Diagnostic_Authority_Supplier_Created(input);
			ctx().req.request_Overview();
			Thread.sleep(3000);
			ctx().req.select_Applicant_type("Myself");
			Thread.sleep(2000);
			ctx().approver_overview.filter_search(ctx().prop.getStatus_pending());
			ctx().req.scrollForReason();
			List<String> applicantNumber = req.getMultipleApplicantNumber();
			TC10_Diagnostic_Authority_GLOBAL_Approved.approve_DA_request(input);
			test.log(Status.PASS, "<span style=\"color: blue;\"><b><i><u>" + "***************" + applicantNumber
					+ " DA Approved *************" + "</u></i></b>");
			logger.info("Verify selected ecu is not visible when the status is in approved");
			test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
					+ "Creation of Enhance Right Authority - Internal" + "</u></i></b>");
			AbstractComponents.refresh();
			TC11_EnhanceRightAuthority_GLOBAL.create_Enhance_Right_Authority_request_Supplier(input);
			Thread.sleep(5000);
			ctx().req.request_Overview();
			ctx().req.select_request_type("Enhance Right");
			ctx().req.select_Applicant_type("Myself");
			Thread.sleep(2000);
			ctx().approver_overview.filter_search(ctx().prop.getStatus_pending());
			ctx().req.scrollForReason();
			List<String> EA_applicantNumber = req.getMultipleApplicantNumber();

			TC13_EnhanceRightAuthority_GLOBAL_Approved.approve_Enhance_Right_Authority_request(input);
			test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>" + EA_applicantNumber
					+ "Enhance Right Authority for Internal- status Approved:" + "</u></i></b>");
			AbstractComponents.refresh();
			if (!Functional_Role.equalsIgnoreCase("Production")) {
				if (Functional_Role.equalsIgnoreCase("ECU Supplier – Development")
						|| Functional_Role.equalsIgnoreCase("ECU Supplier - Development - ATG")) {
					AbstractComponents.refresh();
					ctx().myreq.select_NewPermission_request();
					ctx().newper.raise_nestT_Request_Supplier_Multiple(input);
					approve_Multiple_special_cases_nestT_request(input,ctx().prop.getSupplierName());
					test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
							+ "Nest-T Testing for Internal- status Approved:" + "</u></i></b>");
					test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
							+ "Creation of Replacement Package - Internal" + "</u></i></b>");
					AbstractComponents.refresh();
				}
				List<String> create_replacement_package_request_id_front = create_replacement_package_request_root_Supplier(
						input);
				waitForPageLoad(BaseClass.getDriver());
				Thread.sleep(3000);
				approve_special_cases_Replacement_request(input, create_replacement_package_request_id_front,ctx().prop.getSupplierName());
				waitForPageLoad(BaseClass.getDriver());
				Thread.sleep(3000);
				List<String> create_replacement_package_request_id_back = create_replacement_package_request_backend_Supplier(
						input);
				approve_special_cases_Replacement_request(input, create_replacement_package_request_id_back,ctx().prop.getSupplierName());
				waitForPageLoad(BaseClass.getDriver());
				Thread.sleep(3000);
				List<String> create_replacement_package_request_ids = create_replacement_package_request_rootbackend(
						input);
				waitForPageLoad(BaseClass.getDriver());
				Thread.sleep(3000);
				approve_special_cases_Replacement_request(input, create_replacement_package_request_ids,ctx().prop.getSupplierName());
				test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
						+ "Replacement Package for Internal- status Approved:" + "</u></i></b>");
			}

			AbstractComponents.refresh();
			waitForPageLoad(BaseClass.getDriver());
			Thread.sleep(5000);
			ctx().approver_overview.approver_Overview_enabled1();
			ctx().approver_overview.search_here(ctx().prop.getSupplierName());
			getScreenshot(input.get("Mode") + "_" + input.get("User_Type") + "_ All Request", BaseClass.getDriver());
		} catch (Exception e) {
			e.printStackTrace();
			String filePath = null;
			filePath = getScreenshot(input.get("Functional_role_External") + "error page", BaseClass.getDriver());
		}
		// after 1 data run
		AbstractComponents.refresh();
		Thread.sleep(5000);
		ctx().myreq.clickHomeButton();
	}

	@DataProvider
	public Object[][] getData_Internal() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir")
						+ "//src//test//java//DAMS//data_Regression//01_Internal_End_to-end_functionality.json");
		// return new Object[][]
		// {{data.get(0)},{data.get(1)},{data.get(2)},{data.get(3)},{data.get(4)},{data.get(5)},
		// {data.get(6)},{data.get(7)},{data.get(8)},{data.get(9)},{data.get(10)}};
		return new Object[][] { { data.get(0) } };
	}

	@DataProvider
	public Object[][] getData_External() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir")
						+ "//src//test//java//DAMS//data_Regression//02_External_End_to-end_functionality.json");
		// return new Object[][]
		// {{data.get(0)},{data.get(1)},{data.get(2)},{data.get(3)},{data.get(4)},{data.get(5)},
		// {data.get(6)},{data.get(7)},{data.get(8)},{data.get(9)},{data.get(10)}};
		return new Object[][] { { data.get(0) } };
	}

	@DataProvider
	public Object[][] getData_Supplier() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir")
						+ "//src//test//java//DAMS//data_Regression//03_Supplier_End_to-end_functionality.json");
		// return new Object[][]
		// {{data.get(0)},{data.get(1)},{data.get(2)},{data.get(3)},{data.get(4)},{data.get(5)}};
		return new Object[][] { { data.get(0) } };
	}

	public static void approve_Multiple_special_cases_nestT_request(HashMap<String, String> input, String UserName)
			throws Throwable {
		ctx().req.request_Overview();
		String NestT_approval_status_after_level1_approval = approver_overview.approve_Multiple_nestT_Request(
				"Nest T Testing", "Nest-T Testing", ctx().prop.getStatus_pending(), UserName);
		// ctx().s.assertTrue(NestT_approval_status_after_level1_approval.equals(ctx().prop.getStatus_Approved()));
		test.pass("User is able to view the approval status as Approved after 1st level approval");
		logger.info("User is able to view the approval status as Approved after 1st level approval");
		ctx().req.navigate_to_request_Overview_page_and_verify_approval_status_RP_NestT(ctx().prop.getStatus_pending(),
				"N/A", "N/A", "Nest-T Testing", UserName);
		test.pass(
				"User is able to view navigate to request role overview page and check if the status is pending after 1st level approval");
		logger.info(
				"User is able to view navigate to request role overview page and check if the status is pending after 1st level approval");
		String NestT_approval_status_after_level2_approval = approver_overview.approve_Multiple_nestT_Request(
				"Nest T Testing", "Nest-T Testing", ctx().prop.getStatus_pending(), UserName);
		ctx().s.assertTrue(NestT_approval_status_after_level2_approval.equals(ctx().prop.getStatus_Approved()));
		test.pass("User is able to view the approval status as Approved after 2nd level approval");
		logger.info("User is able to view the approval status as Approved after 2nd level approval");
		String todays_date = todays_date();
		ctx().req.navigate_to_request_Overview_page_and_verify_approval_status_RP_NestT(ctx().prop.getStatus_Approved(),
				todays_date, "N/A", "Nest-T Testing", UserName);
		test.pass(
				"User is able to view navigate to request role overview page and check if the status is approved after 2nd level approval");
		logger.info(
				"User is able to view navigate to request role overview page and check if the status is appproved after 2nd level approval");
	}

	public static List<String> create_replacement_package_request_rootbackend(HashMap<String, String> input)
			throws Throwable {
		test.info("Replacement package request");
		logger.info("Replacement package request");
		ctx().myreq.select_NewPermission_request();
		boolean request_Overview_enabled = newper.raise_Multiple_replacement_package_Request_Supplier(input);
		Assert.assertTrue(request_Overview_enabled);
		test.info("Request overview tab enabled");
		logger.info("Request overview tab enabled");
		List<String> replacement_package_table_input = req.multiple_Request_Table_Validation_for_replacement_package(
				"Replacement Package", ctx().prop.getUser_name(),ctx().prop.getInternalName());
		// Assert.assertTrue(replacement_package_table_input.get(0).equals(ctx().prop.getStatus_pending()));
		test.pass("User is able to view the approval status as pending once the Replacement package request created");
		logger.info("User is able to view the approval status as pending once the Replacement package request created");
		return replacement_package_table_input;
	}

	public static List<String> create_replacement_package_request_root(HashMap<String, String> input) throws Throwable {
		test.info("Replacement package request");
		logger.info("Replacement package request");
		ctx().myreq.select_NewPermission_request();
		boolean request_Overview_enabled = newper.raise_replacement_package_Request(
				input.get("Functional_role_internal"), input.get("SpecialCase"),
				input.get("Orgin_COT"), input.get("Reason_for_RP"), input.get("Target_COT"),
				input.get("ECU_Qualifier_for_Root_link"));
		Assert.assertTrue(request_Overview_enabled);
		test.info("Request overview tab enabled");
		logger.info("Request overview tab enabled");
		List<String> replacement_package_table_input = req
				.multiple_Request_Table_Validation_for_replacement_package("Replacement Package",
						ctx().prop.getUser_name(),ctx().prop.getInternalName());
		// Assert.assertTrue(replacement_package_table_input.get(0).equals(ctx().prop.getStatus_pending()));
		test.pass("User is able to view the approval status as pending once the Replacement package request created");
		logger.info("User is able to view the approval status as pending once the Replacement package request created");
		return replacement_package_table_input;
	}

	public static List<String> create_replacement_package_request_backend(HashMap<String, String> input)
			throws Throwable {
		test.info("Replacement package request");
		logger.info("Replacement package request");
		ctx().myreq.select_NewPermission_request();
		boolean request_Overview_enabled = newper.raise_replacement_package_Request(
				input.get("Functional_role_internal"), input.get("SpecialCase"), input.get("Reason_for_RP"),
				input.get("ECU_Qualifier_for_Backend_link"), input.get("BackendRoot_COT"),
				input.get("BackendOrigin_COT"), input.get("BackendTarget_COT"));
		Assert.assertTrue(request_Overview_enabled);
		test.info("Request overview tab enabled");
		logger.info("Request overview tab enabled");
		List<String> replacement_package_table_input = req
				.multiple_Request_Table_Validation_for_replacement_package("Replacement Package",
						ctx().prop.getUser_name(),ctx().prop.getInternalName());
		// Assert.assertTrue(replacement_package_table_input.get(0).equals(ctx().prop.getStatus_pending()));
		test.pass("User is able to view the approval status as pending once the Replacement package request created");
		logger.info("User is able to view the approval status as pending once the Replacement package request created");
		return replacement_package_table_input;
	}

	public static void approve_special_cases_Replacement_request(HashMap<String, String> input,
			List<String> create_special_cases_Replacement_request,String userName) throws Throwable {
		String Replacement_approval_status_after_level1_approval = approver_overview.multiple_Approve_Request(
				"Replacement Package", ctx().prop.getStatus_pending(), create_special_cases_Replacement_request);
		ctx().s.assertTrue(Replacement_approval_status_after_level1_approval.equals(ctx().prop.getStatus_Approved()));
		test.pass("User is able to view the approval status as Approved after 1st level approval");
		logger.info("User is able to view the approval status as Approved after 1st level approval");
		ctx().req.navigate_to_request_Overview_page_and_verify_approval_status_RP_NestT(ctx().prop.getStatus_pending(),
				"N/A", "N/A",
				input.get("SpecialCase"),userName);
		test.pass(
				"User is able to view navigate to request role overview page and check if the status is pending after 1st level approval");
		logger.info(
				"User is able to view navigate to request role overview page and check if the status is pending after 1st level approval");
		String Replacement_approval_status_after_level2_approval = approver_overview.multiple_Approve_Request(
				"Replacement Package", ctx().prop.getStatus_pending(), create_special_cases_Replacement_request);
		ctx().s.assertTrue(Replacement_approval_status_after_level2_approval.equals(ctx().prop.getStatus_Approved()));
		test.pass("User is able to view the approval status as Approved after 2nd level approval");
		logger.info("User is able to view the approval status as Approved after 2nd level approval");
		String todays_date = todays_date();
		ctx().req.navigate_to_request_Overview_page_and_verify_approval_status_RP_NestT(ctx().prop.getStatus_Approved(),
				todays_date, "N/A",
				input.get("SpecialCase"), ctx().prop.getUser_name());
		test.pass(
				"User is able to view navigate to request role overview page and check if the status is approved after 2nd level approval");
		logger.info(
				"User is able to view navigate to request role overview page and check if the status is appproved after 2nd level approval");
	}

	public static String login_and_select_user_ATG(String user_type) throws Throwable {
		// hari
		h.dropBtn();
		Thread.sleep(3000);
		String select_user_type = null;

		if ("Internal".equalsIgnoreCase(user_type)) {
			ctx().h.click_here_to_apply_for_functional_roles_click();
			select_user_type = user_type;
		} else {
			select_user_type = ctx().h.select_user_type(user_type);
			test.log(Status.INFO, "User is selects the type:" + "<span style=\"color: blue;\"><b><i><u>"
					+ select_user_type + "</u></i></b>");
		}

		Thread.sleep(3000);
		ctx().gtc.gtc_page_validation();
		test.info("User validates the gtc page");
		logger.info("User validates the gtc page");
		Thread.sleep(5000);

		logger.info("About to zoom out");
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.getDriver();
		js.executeScript("document.body.style.zoom='80%'");
		newrequest.select_vehicle_program_ATG(user_type);
		newrequest.functional_role_page_validation(ctx().prop.get_for_whom_txt(), ctx().prop.get_myself_txt(),
				ctx().prop.get_Functional_role_txt());
		test.pass("validates the functional role page");
		logger.info("validates the functional role page");
		logger.info("*************" + select_user_type);
		return select_user_type;
	}

	public static List<String> create_replacement_package_request_root_External(HashMap<String, String> input)
			throws Throwable {
		test.info("Replacement package request");
		logger.info("Replacement package request");
		ctx().myreq.select_NewPermission_request();
		boolean request_Overview_enabled = newper.raise_replacement_package_Request(
				input.get("Functional_role_External"), input.get("SpecialCase"),
				input.get("Orgin_COT"), input.get("Reason_for_RP"), input.get("Target_COT"),
				input.get("ECU_Qualifier_for_Root_link"));
		Assert.assertTrue(request_Overview_enabled);
		test.info("Request overview tab enabled");
		logger.info("Request overview tab enabled");
		List<String> replacement_package_table_input = req
				.multiple_Request_Table_Validation_for_replacement_package("Replacement Package",
						ctx().prop.getUser_name(),ctx().prop.getExternalName());
		// Assert.assertTrue(replacement_package_table_input.get(0).equals(ctx().prop.getStatus_pending()));
		test.pass("User is able to view the approval status as pending once the Replacement package request created");
		logger.info("User is able to view the approval status as pending once the Replacement package request created");
		return replacement_package_table_input;
	}

	public static List<String> create_replacement_package_request_backend_External(HashMap<String, String> input)
			throws Throwable {
		test.info("Replacement package request");
		logger.info("Replacement package request");
		ctx().myreq.select_NewPermission_request();
		boolean request_Overview_enabled = newper.raise_replacement_package_Request(
				input.get("Functional_role_External"), input.get("SpecialCase"), input.get("Reason_for_RP"),
				input.get("ECU_Qualifier_for_Backend_link"), input.get("BackendRoot_COT"),
				input.get("BackendOrigin_COT"), input.get("BackendTarget_COT"));
		Assert.assertTrue(request_Overview_enabled);
		test.info("Request overview tab enabled");
		logger.info("Request overview tab enabled");
		List<String> replacement_package_table_input = req
				.multiple_Request_Table_Validation_for_replacement_package("Replacement Package",
						ctx().prop.getUser_name(),ctx().prop.getExternalName());
		// Assert.assertTrue(replacement_package_table_input.get(0).equals(ctx().prop.getStatus_pending()));
		test.pass("User is able to view the approval status as pending once the Replacement package request created");
		logger.info("User is able to view the approval status as pending once the Replacement package request created");
		return replacement_package_table_input;
	}

	public static String[] functional_role(String usertype, List<Object> funational_role_Overview_table_input,
			String functional_role_selected) throws Throwable {
		test.pass("Raise the request for the functional role " + functional_role_selected);
		logger.info("Raise the request for the functional role " + functional_role_selected);
		String approval_status_after_level1_approval = approver_overview.approvetheFR_Request("Functional Role",
				funational_role_Overview_table_input, usertype, ctx().prop.getStatus_pending());
		ctx().s.assertTrue(approval_status_after_level1_approval.equals(ctx().prop.getStatus_Approved()));
		test.pass("User is able to approve 1st level approval");
		logger.info("User is able to approve 1st level approval");
		f.navigate_to_functional_role_Overview_page_and_verify_approval_status(ctx().prop.getStatus_pending(), "N/A");
		test.pass("Navigate to FR overview page and status is pending after 1st level approval");
		logger.info("Navigate to FR overview page and status is pending after 1st level approval");
		String approval_status_after_level2_approval = approver_overview.approvetheFR_Request("Functional Role",
				funational_role_Overview_table_input, usertype, ctx().prop.getStatus_pending());
		ctx().s.assertTrue(approval_status_after_level2_approval.equals(ctx().prop.getStatus_Approved()));
		test.pass("User is able to approve 2nd level approval");
		logger.info("User is able to approve 2nd level approval");
		String cert = f
				.ValidatetheStandardCertificateofthe_Functionalrole_after_2level_approval(
						ctx().prop.getStatus_Approved());
		String[] standard_cert = cert.split(",");
		test.pass("View the Standard Certificate for the raised functional role" + cert);
		logger.info("View the Standard Certificate for the raised functional role" + cert);
		return standard_cert;
	}

	public static List<String> create_replacement_package_request_root_Supplier(HashMap<String, String> input)
			throws Throwable {
		test.info("Replacement package request");
		logger.info("Replacement package request");
		ctx().myreq.select_NewPermission_request();
		boolean request_Overview_enabled = newper.raise_replacement_package_Request(
				input.get("Functional_role_Certificate"), input.get("SpecialCase"),
				input.get("Orgin_COT"), input.get("Reason_for_RP"), input.get("Target_COT"),
				input.get("ECU_Qualifier_for_Root_link"));
		Assert.assertTrue(request_Overview_enabled);
		test.info("Request overview tab enabled");
		logger.info("Request overview tab enabled");
		List<String> replacement_package_table_input = req
				.multiple_Request_Table_Validation_for_replacement_package("Replacement Package",
						ctx().prop.getUser_name(),ctx().prop.getSupplierName());
		// Assert.assertTrue(replacement_package_table_input.get(0).equals(ctx().prop.getStatus_pending()));
		test.pass("User is able to view the approval status as pending once the Replacement package request created");
		logger.info("User is able to view the approval status as pending once the Replacement package request created");
		return replacement_package_table_input;
	}

	public static List<String> create_replacement_package_request_backend_Supplier(HashMap<String, String> input)
			throws Throwable {
		test.info("Replacement package request");
		logger.info("Replacement package request");
		ctx().myreq.select_NewPermission_request();
		boolean request_Overview_enabled = newper.raise_replacement_package_Request(
				input.get("Functional_role_Certificate"), input.get("SpecialCase"), input.get("Reason_for_RP"),
				input.get("ECU_Qualifier_for_Backend_link"), input.get("BackendRoot_COT"),
				input.get("BackendOrigin_COT"), input.get("BackendTarget_COT"));
		Assert.assertTrue(request_Overview_enabled);
		test.info("Request overview tab enabled");
		logger.info("Request overview tab enabled");
		List<String> replacement_package_table_input = req
				.multiple_Request_Table_Validation_for_replacement_package("Replacement Package",
						ctx().prop.getUser_name(),ctx().prop.getSupplierName());
		// Assert.assertTrue(replacement_package_table_input.get(0).equals(ctx().prop.getStatus_pending()));
		test.pass("User is able to view the approval status as pending once the Replacement package request created");
		logger.info("User is able to view the approval status as pending once the Replacement package request created");
		return replacement_package_table_input;
	}

}
