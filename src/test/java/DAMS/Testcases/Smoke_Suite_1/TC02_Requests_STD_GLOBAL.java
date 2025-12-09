package DAMS.Testcases.Smoke_Suite_1;

import static DAMS.Resources.Listeners.test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import DAMS.Resources.BaseClass;

public class TC02_Requests_STD_GLOBAL extends BaseClass {
	
	@Test(dataProvider = "getData_Internal", priority = 0,enabled=false)
	public static void apply_internal_functional_role_create_test_case(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Internal Functional role request - status pending:" + "</u></i></b>");
		String select_user_type = login_and_select_user_Global(prop.get_user_type_Internal());
		String functional_role_selected = raise_Internal_functional_role(input);
		test.pass("Request created and in pending status " + functional_role_selected);
		logger.info("Request created and in pending status " + functional_role_selected);
		functional_role_Overview_table_validation(select_user_type);
		softAssertionALL();

	}

	@Test(dataProvider = "getData_External", priority = 1,enabled=false)
	public static void apply_External_functional_role_create_test_case(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "External Functional role request - status pending:" + "</u></i></b>");
		String select_user_type = login_and_select_user_Global(prop.get_user_type_external());
		String functional_role_selected = raise_External_functional_role(input);
		test.pass("Request standard External functional role for GLOBAL" + functional_role_selected);
		logger.info("Request standard External functional role for GLOBAL" + functional_role_selected);
		functional_role_Overview_table_validation(select_user_type);
		softAssertionALL();
	}

	@Test(dataProvider = "getData_Supplier", priority = 2)
	public static void apply_supplier_functional_role_create_test_case(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Supplier Functional role request - status pending:" + "</u></i></b>");
	
		String select_user_type = login_and_select_user_Global(prop.get_User_type_Supplier());
		String functional_role_selected = raise_Supplier_functional_role(input);
		test.pass("Raised request for the functional role " + functional_role_selected);
		logger.info("Raised request for the functional role " + functional_role_selected);
		functional_role_Overview_table_validation(select_user_type);
		softAssertionALL();
	}

	@Test(dataProvider = "getData_Supplier",enabled=false)
	public static List<Object> apply_supplier_functional_role_create_test_case_myDeputy(HashMap<String, String> input)
			throws Throwable {
		TC01_Login_MFA.login_with_addressing_MFA();
		String select_user_type = h.select_user_type("Supplier");
		test.pass("User is able to select the type " + select_user_type);
		logger.info("User is able to select the type " + select_user_type);
		gtc.gtc_page_validation();
		test.pass("User is able to validate the gtc page");
		logger.info("User is able to validate the gtc page");

		newrequest.functional_role_page_validation(prop.get_for_whom_txt(), prop.get_myself_txt(),
				prop.get_Functional_role_txt());
		test.pass("User is able to validate the functional role page");
		logger.info("User is able to validate the functional role page");
		String functional_role_selected = raise_Supplier_functional_role(input);
		test.pass("Raised request for the functional role " + functional_role_selected);
		logger.info("Raised request for the functional role " + functional_role_selected);
		List<Object> functional_role_Overview_table_validation = functional_role_Overview_table_validation(
				select_user_type);
		s.assertAll();
		return Arrays.asList(functional_role_Overview_table_validation.get(1), select_user_type);
	}

	@DataProvider
	public Object[][] getData_Internal() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//New_functional_role_Request.json");
		return new Object[][] { { data.get(1) } };

	}

	@DataProvider
	public Object[][] getData_External() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//New_functional_role_Request.json");
		return new Object[][] { { data.get(14) } };

	}

	@DataProvider
	public Object[][] getData_Supplier() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//New_functional_role_Request.json");
		return new Object[][] { { data.get(18) } };

	}

	public static List<Object> functional_role_Overview_table_validation(String select_user_type) throws Throwable {
		f.functional_role_overview_enabled_validation();
		
		List<Object> functional_role_Overview_table_validation = f.functional_role_Overview_table_validation("Myself",
				prop.getUser_name(), select_user_type);
		softassertTrue(s, (boolean) functional_role_Overview_table_validation.get(0).equals(prop.getStatus_pending()));
		test.pass("User is able to view the approval status as pending once the request created");
		logger.info("User is able to view the approval status as pending once the request created");
		test.log(Status.INFO, "Requester details : " + "<span style=\"color: blue;\"><b><i><u>"
				+ functional_role_Overview_table_validation + "</u></i></b>");
		logger.info("Requestor details : " + "<span style=\"color: blue;\"><b><i><u>"
				+ functional_role_Overview_table_validation + "</u></i></b>");
		return functional_role_Overview_table_validation;

	}

	public static String login_and_select_user(String user_type) throws Throwable {
		TC01_Login_MFA.login_with_addressing_MFA();
		h.dropBtn();
		String select_user_type = h.select_user_type(user_type);
		test.log(Status.INFO, "User is able to select the type:" + "<span style=\"color: blue;\"><b><i><u>"
				+ select_user_type + "</u></i></b>");
		gtc.gtc_page_validation();
		test.info("Validate the gtc page");
		logger.info("Validate the gtc page");
		Thread.sleep(2000);
		Robot robot = new Robot();
		logger.info("About to zoom out");
		for (int i = 0; i < 3; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
		newrequest.select_vehicle_program_global();
//		newrequest.select_vehicle_program_AP4();
		
		newrequest.functional_role_page_validation(prop.get_for_whom_txt(), prop.get_myself_txt(),
				prop.get_Functional_role_txt());
		
		test.pass("Validate the functional role page");
		logger.info("Validate the functional role page");
		logger.info("*************"+select_user_type);

		return select_user_type;
	}

	public static String raise_Internal_functional_role(HashMap<String, String> input) throws Throwable {
		String functional_role_selected = newrequest.raise_Internal_functional_role_request(
				prop.get_vehicle_validation(), prop.get_Production(), prop.get_Xentry(), prop.get_QM(),
				prop.get_Development(), prop.get_DiagnosticLink(), input.get("Functional_role_internal"),
				input.get("Reason_for_internal_FR"), input.get("Role_Desc"), prop.get_DTE(), prop.get_dtna(),
				prop.get_fuso(), prop.get_bus(), input.get("BU"));
		return functional_role_selected;

	}

	public static String raise_External_functional_role(HashMap<String, String> input) throws Throwable {
		String functional_role_selected = newrequest.raise_External_functional_role_request(
				input.get("Functional_role_External"), input.get("Reason_for_External_FR"), input.get("Role_Desc"),
				input.get("company_name"), input.get("Daimler_name"), input.get("Daimler_email"), prop.get_DTE(),
				prop.get_dtna(), prop.get_fuso(), prop.get_bus(), input.get("BU"));
		return functional_role_selected;
	}

	public static String raise_Supplier_functional_role(HashMap<String, String> input) throws Throwable {
		String functional_role_selected = newrequest.raise_Supplier_functional_role_request(
				prop.get_Supplier_key_management(), prop.get_supplier_Develepment(),
				prop.get_supplier_warranty_return(), input.get("Functional_role_supplier"), input.get("Role_Desc"),
				input.get("company_name"), input.get("Reason_for_supplier_FR"), input.get("ECU_Supplier"));
		return functional_role_selected;
	}

	public static String raise_Supplier_functional_role_ECU_cert(HashMap<String, String> input, String fileContent)
			throws Throwable {
		String functional_role_selected = newrequest.raise_Supplier_functional_role_request(
				prop.get_Supplier_key_management(), prop.get_supplier_Develepment(),
				prop.get_supplier_warranty_return(), input.get("Functional_role_supplier"), input.get("Role_Desc"),
				input.get("company_name"), input.get("Reason_for_supplier_FR"), fileContent);
		return functional_role_selected;
	}

	public static List<Object> functional_role_Overview_table_validation_for_more_than_one_ECU(String select_user_type,
			List<Object> functional_role_selected) throws Throwable {
		f.functional_role_overview_enabled_validation();
		List<Object> functional_role_Overview_table_validation = f
				.functional_role_Overview_table_validation_for_more_than_one_ECU("Myself", prop.getUser_name(),
						select_user_type, functional_role_selected);
		softassertTrue(s, (boolean) functional_role_Overview_table_validation.get(0).equals(prop.getStatus_pending()));
		test.pass("View approval status as pending once the requests created");
		test.info("Requester details : " + functional_role_Overview_table_validation);
		return functional_role_Overview_table_validation;

	}

	public static String login_and_select_user_Global(String user_type) throws Throwable {
	    TC01_Login_MFA.login_with_addressing_MFA();
	    Thread.sleep(3000);
	    waitForPageLoad(driver);
	    // hari
	    h.dropBtn();

	    String select_user_type = null;

	    if ("Internal".equalsIgnoreCase(user_type)) {
	        h.click_here_to_apply_for_functional_roles_click();
	        select_user_type = user_type;
	    } else {
	        select_user_type = h.select_user_type(user_type);
	        test.log(Status.INFO, "User is selects the type:" + "<span style=\"color: blue;\"><b><i><u>"
	                + select_user_type + "</u></i></b>");
	    }
	    
	    Thread.sleep(8000);
	    gtc.gtc_page_validation();
	    test.info("User validates the gtc page");
	    logger.info("User validates the gtc page");
	    Thread.sleep(5000);

	    Robot robot = new Robot();
	    logger.info("About to zoom out");
	    for (int i = 0; i < 3; i++) {
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_SUBTRACT);
	        robot.keyRelease(KeyEvent.VK_SUBTRACT);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	    }
	    
	    newrequest.select_vehicle_program_global();        
	    newrequest.functional_role_page_validation(prop.get_for_whom_txt(), prop.get_myself_txt(),
	            prop.get_Functional_role_txt());
	    
	    test.pass("validates the functional role page");
	    logger.info("validates the functional role page");
	    logger.info("*************" + select_user_type);
	    
	    return select_user_type;
	}
	public static String select_user_Global(String user_type) throws Throwable {
	    
	    
	    // hari
	    h.dropBtn();

	    String select_user_type = null;

	    if ("Internal".equalsIgnoreCase(user_type)) {
	        h.click_here_to_apply_for_functional_roles_click();
	        select_user_type = user_type;
	    } else {
	        select_user_type = h.select_user_type(user_type);
	        test.log(Status.INFO, "User is selects the type:" + "<span style=\"color: blue;\"><b><i><u>"
	                + select_user_type + "</u></i></b>");
	    }
	    
	    Thread.sleep(3000);
	    gtc.gtc_page_validation();
	    test.info("User validates the gtc page");
	    logger.info("User validates the gtc page");
	    Thread.sleep(5000);

	    Robot robot = new Robot();
	    logger.info("About to zoom out");
	    for (int i = 0; i < 3; i++) {
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_SUBTRACT);
	        robot.keyRelease(KeyEvent.VK_SUBTRACT);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	    }
	    
	    newrequest.select_vehicle_program_global();        
	    newrequest.functional_role_page_validation(prop.get_for_whom_txt(), prop.get_myself_txt(),
	            prop.get_Functional_role_txt());
	    
	    test.pass("validates the functional role page");
	    logger.info("validates the functional role page");
	    logger.info("*************" + select_user_type);
	    
	    return select_user_type;
	}
}