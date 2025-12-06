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

public class TC12_EnhanceRightAuthority_GLOBAL_Rejected extends BaseClass {

	@Test(dataProvider = "getData_Internal", priority = 0)
	public static void reject_Enhance_right_Authority_Request_Internal_test_case(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Enhance Right Authority Internal -status Rejected" + "</u></i></b>");
		TC11_EnhanceRightAuthority_GLOBAL.create_Enhance_right_Authority_Request_Internal_test_case	(input);
		req.search_here(prop.getUser_name());		
		reject_Enhance_Right_Authority_request(input);
		test.pass("Create Enhance right request when the status is rejected");
		logger.info("Create Enhance right request when the status is rejected");
		softAssertionALL();
	}

	@Test(dataProvider = "getData_External", priority = 1,enabled=false)
	public static void reject_Enhance_right_Authority_Request_External_test_case(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Enhance Right Authority External -status Rejected" + "</u></i></b>");
		TC11_EnhanceRightAuthority_GLOBAL.create_Enhance_Right_Authority_request_External(input);
		req.search_here(prop.getUser_name());	
		reject_Enhance_Right_Authority_request(input);
		test.pass("Create Enhance right request when the status is rejected");
		logger.info("Create Enhance right request when the status is rejected");
		softAssertionALL();
	}
	@Test(dataProvider = "getData_Supplier", priority = 2,enabled=false)
	public static void reject_Enhance_right_Authority_Request_Supplier_test_case(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Enhance Right Authority Supplier -status Rejected" + "</u></i></b>");	
		TC11_EnhanceRightAuthority_GLOBAL.create_Enhance_right_Authority_Request_Supplier_test_case(input);
		req.search_here(prop.getUser_name());	
		reject_Enhance_Right_Authority_request(input);
		test.pass("Create Enhance right request when the status is rejected");
		logger.info("Create Enhance right request when the status is rejected");
		softAssertionALL();
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
		return new Object[][] { { data.get(1) } };

	}

	@DataProvider
	public Object[][] getData_Supplier() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//EnhanceRight_Authority.json");
		return new Object[][] { { data.get(14) } };

	}

	public static void reject_Enhance_Right_Authority_request(HashMap<String, String> input,
			List<Object> create_Enhance_Right_Authority_request) throws Throwable {
		String approval_status_after_level1_rejection = approver_overview.reject_Enhance_right_Request(
				create_Enhance_Right_Authority_request.get(7), "Enhance Right", reason_for_rejection,
				create_Enhance_Right_Authority_request);
		SoftAssertUtil.assertTrue(approval_status_after_level1_rejection.equals(prop.getStatus_rejected()));
		test.pass("View the approval status as rejected in approver page");
		logger.info("View the approval status as rejected in approver page");
		req.navigate_to_request_Overview_page_and_verify_approval_status_ER(prop.getStatus_rejected(), "N/A",
				reason_for_rejection, "Enhance Right", prop.getUser_name());
		test.pass("View the approval status as rejected in request overview page");
		logger.info("View the approval status as rejected in request overview page");

	}
	public static void reject_Enhance_Right_Authority_request(HashMap<String, String> input) throws Throwable {
		List<String> applicantNumber=req.getMultipleApplicantNumber();
		for(String search : applicantNumber) {
		approver_overview.approver_Overview_enabled1();
		Thread.sleep(2000);
		approver_overview.Authorization_roledropdown("Enhance Right");
		Thread.sleep(2000);
		approver_overview.search_here(search);		
		String approval_status_after_level1_rejection = approver_overview.reject_Enhance_right_Request("Rejected for DA request!");
		SoftAssertUtil.assertTrue(approval_status_after_level1_rejection.equals(prop.getStatus_rejected()));		
		}
		test.pass("View the approval status as rejected in approver page");
		logger.info("View the approval status as rejected in approver page");
		for(String searchId:applicantNumber) {
			req.navigate_to_request_Overview_page_and_verify_approval_status_ER(prop.getStatus_rejected(), "N/A",
					reason_for_rejection, "Enhance Right", prop.getUser_name(),input.get("User_Role"));
		test.pass("View the approval status as rejected in request overview page");
		logger.info("View the approval status as rejected in request overview page");

	}
	}
	public static void approve_ER_request(HashMap<String, String> input,String userRole,String id)
			throws Throwable {
		if (userRole.equals("Development ENHANCED") || userRole.equals("Production")
				||userRole.equals("After-Sales ENHANCED")) {
			String DA_approval_status_after_level1_approval = approver_overview
					.approvetheDA_Request("Enhance Right", prop.getStatus_pending(), id);
			s.assertTrue(DA_approval_status_after_level1_approval.equals(prop.getStatus_Approved()));
			test.pass("User is able to view the approval status as Approved after 1st level approval");
			logger.info("User is able to view the approval status as Approved after 1st level approval");
			req.navigate_to_request_Overview_page_and_verify_approval_status_DA(prop.getStatus_pending(), "N/A", "N/A",
					"Enhance Right", id);
			test.pass(
					"View navigate to request overview page and the status is pending after 1st level approval");
			logger.info(
					"View navigate to request overview page and the status is pending after 1st level approval");
			String DA_approval_status_after_level2_approval = approver_overview
					.approvetheDA_Request("Enhance Right", prop.getStatus_pending(), id);
			s.assertTrue(DA_approval_status_after_level2_approval.equals(prop.getStatus_Approved()));
			test.pass("View the approval status as Approved after 2nd level approval");
			logger.info("View the approval status as Approved after 2nd level approval");
			String todays_date = todays_date();
			req.navigate_to_request_Overview_page_and_verify_approval_status_DA(prop.getStatus_Approved(), todays_date,
					"N/A", "Enhance Right", id);
			test.pass(
					"View navigate to request overview page and the status is approved after 2nd level approval");
			logger.info(
					"View navigate to request overview page and the status is approved after 2nd level approval");
		} else {
			String DA_approval_status_after_level2_approval = approver_overview
					.approvetheDA_Request("Enhance Right", prop.getStatus_pending(), id);
			s.assertTrue(DA_approval_status_after_level2_approval.equals(prop.getStatus_Approved()));
			test.pass("View the approval status as Approved after 1st level approval");
			logger.info("View the approval status as Approved after 1st level approval");
			String todays_date = todays_date();
			req.navigate_to_request_Overview_page_and_verify_approval_status_DA(prop.getStatus_Approved(), todays_date,
					"N/A", "Enhance Right", id);
			test.pass(
					"View navigate to FR overview page and status is approved after 1st level approval");
			logger.info(
					"View navigate to FR overview page and status is approved after 1st level approval");
		}

	}
	public static void reject_ER_request(HashMap<String, String> input, String create_DA_request)
			throws Throwable {
		String DA_approval_status_after_level1_approval = approver_overview.rejecttheDA_Request("Enhance Right",reason_for_rejection,create_DA_request);
		s.assertTrue(DA_approval_status_after_level1_approval.equals(prop.getStatus_rejected()));
		test.pass("View the approval status as rejected in approver page");
		logger.info("View the approval status as rejected in approver page");
		req.navigate_to_request_Overview_page_and_verify_approval_status_DA(prop.getStatus_rejected(), "N/A",
				reason_for_rejection, "Enhance Right", prop.getUser_name());
		test.pass("View the approval status as rejected in FR overview page");
		logger.info("View the approval status as rejected in FR overview page");
	}

}
