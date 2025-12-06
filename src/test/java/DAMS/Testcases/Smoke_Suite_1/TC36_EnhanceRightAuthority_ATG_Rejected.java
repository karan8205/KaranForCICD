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

public class TC36_EnhanceRightAuthority_ATG_Rejected extends BaseClass {

	@Test(dataProvider = "getData_Internal", priority = 0)
	public static void reject_Enhance_right_Authority_Request_Internal_test_case(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Enhance Right AUthority Internal -status Rejected" + "</u></i></b>");

		TC35_EnhanceRightAuthority_ATG.create_Enhance_right_Authority_Request_Internal_test_case(input);
		req.search_here(prop.getUser_name());		
		reject_Enhance_Right_Authority_request(input);
		test.pass("User is able to create Enhance right request when the status is rejected");
		logger.info("User is able to create Enhance right request when the status is rejected");
		softAssertionALL();
	}
	@Test(dataProvider = "getData_External", priority = 1,enabled=false)
	public static void approve_Enhance_right_Authority_Request_External_test_case(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Enhance Right AUthority External -status Approved" + "</u></i></b>");
		TC35_EnhanceRightAuthority_ATG.create_Enhance_right_Authority_Request_External_test_case(input);
		req.request_Overview();	
		req.select_Enhance_Right();
		req.search_here(prop.getUser_name());
		reject_Enhance_Right_Authority_request(input);
		softAssertionALL();
	}

	@Test(dataProvider = "getData_Supplier", priority = 2, enabled=false)
	public static void approve_Enhance_right_Authority_Request_Supplier_test_case(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Enhance Right AUthority Supplier -status pending" + "</u></i></b>");
		TC35_EnhanceRightAuthority_ATG.create_Enhance_right_Authority_Request_Supplier_test_case(input);
        reject_Enhance_Right_Authority_request(input);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Enhance Right Authority for Supplier- status Approved-ATG:" + "</u></i></b>");
		logger.info("User is able to create Enhance right request when the status is approved");
		softAssertionALL();

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
		return new Object[][] { { data.get(1) } };
	}

	@DataProvider
	public Object[][] getData_Supplier() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//EnhanceRight_Authority.json");
		return new Object[][] { { data.get(2) } };
	}

	public static void reject_Enhance_Right_Authority_request(HashMap<String, String> input,
			List<Object> create_Enhance_Right_Authority_request) throws Throwable {
		String approval_status_after_level1_rejection = approver_overview.reject_Enhance_right_Request(
				create_Enhance_Right_Authority_request.get(7), "Enhance Right", reason_for_rejection,
				create_Enhance_Right_Authority_request);
		SoftAssertUtil.assertTrue(approval_status_after_level1_rejection.equals(prop.getStatus_rejected()));
		test.pass("User is able to view the approval status as rejected in approver page");
		logger.info("User is able to view the approval status as rejected in approver page");
		req.navigate_to_request_Overview_page_and_verify_approval_status_ER(prop.getStatus_rejected(), "N/A",
				reason_for_rejection, "Enhance Right", prop.getUser_name());
		test.pass("User is able to view the approval status as rejected in request overview page");
		logger.info("User is able to view the approval status as rejected in request overview page");

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
		test.pass("User is able to view the approval status as rejected in approver page");
		logger.info("User is able to view the approval status as rejected in approver page");
		for(String searchId:applicantNumber) {
		req.navigate_to_request_Overview_page_and_verify_approval_status_ER(prop.getStatus_rejected(), "N/A",
				reason_for_rejection, "Enhance Right", searchId);
		test.pass("User is able to view the approval status as rejected in request overview page");
		logger.info("User is able to view the approval status as rejected in request overview page");
	}
	}

}
