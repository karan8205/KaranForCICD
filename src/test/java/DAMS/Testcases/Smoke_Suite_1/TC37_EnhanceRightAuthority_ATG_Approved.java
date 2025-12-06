package DAMS.Testcases.Smoke_Suite_1;

import static DAMS.Resources.Listeners.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import DAMS.Resources.BaseClass;


public class TC37_EnhanceRightAuthority_ATG_Approved extends BaseClass {

	@Test(dataProvider = "getData_Internal", priority = 0, enabled = false)
	public static void approve_Enhance_right_Authority_Request_Internal_test_case(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Enhance Right AUthority Internal -status Approved" + "</u></i></b>");		
		TC35_EnhanceRightAuthority_ATG.create_Enhance_right_Authority_Request_Internal_test_case(input);
		Thread.sleep(3000);
		req.search_here(prop.getUser_name());
		approve_Enhance_Right_Authority_request(input);
		softAssertionALL();
	}

	@Test(dataProvider = "getData_External", priority = 1)
	public static void approve_Enhance_right_Authority_Request_External_test_case(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Enhance Right AUthority External -status Approved" + "</u></i></b>");
		TC35_EnhanceRightAuthority_ATG.create_Enhance_right_Authority_Request_External_test_case(input);
		req.request_Overview();	
		req.select_Enhance_Right();
		req.search_here(prop.getUser_name());
		approve_Enhance_Right_Authority_request(input);
		softAssertionALL();

	}

	@Test(dataProvider = "getData_Supplier", priority = 2, enabled=false)
	public static void approve_Enhance_right_Authority_Request_Supplier_test_case(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Enhance Right AUthority Supplier -status pending" + "</u></i></b>");
		TC35_EnhanceRightAuthority_ATG.create_Enhance_right_Authority_Request_Supplier_test_case(input);
		TC37_EnhanceRightAuthority_ATG_Approved.approve_Enhance_Right_Authority_request(input);
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
		return new Object[][] { { data.get(13) } };
	}

	@DataProvider
	public Object[][] getData_Supplier() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//EnhanceRight_Authority.json");
		return new Object[][] {{ data.get(3) }};
	}

	public static void approve_Enhance_Right_Authority_request(HashMap<String, String> input,
			List<Object> create_and_approve_Internal_FR_request, List<Object> create_Enhance_Right_Authority_request)
			throws Throwable {
		two_level_approval_Enhance_right(input, create_and_approve_Internal_FR_request, create_Enhance_Right_Authority_request);
	}
	
	public static void approve_Enhance_Right_Authority_request(HashMap<String, String> input)
			throws Throwable {
		two_level_approval_Enhance_right(input);
	}
	
	
	public static void approve_Enhance_Right_Authority_request_Supplier(HashMap<String, String> input,
			List<Object> create_and_approve_Internal_FR_request, List<Object> create_Enhance_Right_Authority_request)
			throws Throwable {
			if (create_Enhance_Right_Authority_request.get(14).toString()
					.equals(create_Enhance_Right_Authority_request.get(15).toString())){
				two_level_approval_Enhance_right(input, create_and_approve_Internal_FR_request, create_Enhance_Right_Authority_request);
			} else {
				String enhance_right_approval_status_after_level1_approval = approver_overview
						.approveEnhanceRight_authority_Request(create_Enhance_Right_Authority_request.get(7),
								"Enhance Right", prop.getStatus_pending(), create_Enhance_Right_Authority_request);
				s.assertTrue(enhance_right_approval_status_after_level1_approval.equals(prop.getStatus_Approved()));
				test.pass("User is able to view the approval status as Approved after 1st level approval");
				logger.info("User is able to view the approval status as Approved after 1st level approval");
				req.navigate_to_request_Overview_page_and_verify_approval_status_ER(prop.getStatus_Approved(), "N/A",
						"N/A", "Enhance Right", prop.getUser_name());
				test.pass(
						"User is able to view navigate to request overview page and check if the status is approved after 1st level approval");
				logger.info(
						"User is able to view navigate to request overview page and check if the status is approved after 1st level approval");
			}
			
		} 
	

	public static void two_level_approval_Enhance_right(HashMap<String, String> input,
			List<Object> create_and_approve_Internal_FR_request, List<Object> create_Enhance_Right_Authority_request) throws Throwable {
		String enhance_right_approval_status_after_level1_approval = approver_overview
				.approveEnhanceRight_authority_Request(create_Enhance_Right_Authority_request.get(7),
						"Enhance Right", prop.getStatus_pending(), create_Enhance_Right_Authority_request);
		s.assertTrue(enhance_right_approval_status_after_level1_approval.equals(prop.getStatus_Approved()));
		test.pass("User is able to view the approval status as Approved after 1st level approval");
		logger.info("User is able to view the approval status as Approved after 1st level approval");
		req.navigate_to_request_Overview_page_and_verify_approval_status_ER(prop.getStatus_pending(), "N/A",
				"N/A", "Enhance Right", prop.getUser_name());
		test.pass(
				"User is able to view navigate to request overview page and check if the status is pending after 1st level approval");
		logger.info(
				"User is able to view navigate to request overview page and check if the status is pending after 1st level approval");
		String enhance_right_approval_status_after_level2_approval = approver_overview
				.approveEnhanceRight_authority_Request(create_Enhance_Right_Authority_request.get(7),
						"Enhance Right", prop.getStatus_pending(), create_Enhance_Right_Authority_request);
		s.assertTrue(enhance_right_approval_status_after_level2_approval.equals(prop.getStatus_Approved()));
		test.pass("User is able to view the approval status as Approved after 2nd level approval");
		logger.info("User is able to view the approval status as Approved after 2nd level approval");
		String todays_date = todays_date();
		req.navigate_to_request_Overview_page_and_verify_approval_status_ER(prop.getStatus_Approved(),
				todays_date, "N/A", "Enhance Right", prop.getUser_name());
		test.pass(
				"User is able to view navigate to request overview page and check if the status is approved after 2nd level approval");
		logger.info(
				"User is able to view navigate to request overview page and check if the status is approved after 2nd level approval");

	}
	public static void two_level_approval_Enhance_right(HashMap<String, String> input) throws Throwable {
		
		Thread.sleep(4000);
		List<String> applicantNumber=req.getMultipleApplicantNumber();
		System.out.println(applicantNumber);
		for(String id:applicantNumber) {
			if(!(id.trim().isEmpty())) {
		String enhance_right_approval_status_after_level1_approval = approver_overview
				.approveEnhanceRight_authority_Request(input,id);
		s.assertTrue(enhance_right_approval_status_after_level1_approval.equals(prop.getStatus_Approved()));
		test.pass("User is able to view the approval status as Approved after 1st level approval");
		logger.info("User is able to view the approval status as Approved after 1st level approval");
		
		
		req.navigate_to_request_Overview_page_and_verify_approval_status_ER(prop.getStatus_pending(), "N/A",
				"N/A", "Enhance Right",id);
		test.pass(
				"User is able to view navigate to request overview page and check if the status is pending after 1st level approval");
		logger.info(
				"User is able to view navigate to request overview page and check if the status is pending after 1st level approval");
		String enhance_right_approval_status_after_level2_approval = approver_overview.approveEnhanceRight_authority_Request(input,id);
		s.assertTrue(enhance_right_approval_status_after_level2_approval.equals(prop.getStatus_Approved()));
		test.pass("User is able to view the approval status as Approved after 2nd level approval");
		logger.info("User is able to view the approval status as Approved after 2nd level approval");
		String todays_date = todays_date();
		req.navigate_to_request_Overview_page_and_verify_approval_status_ER(prop.getStatus_Approved(),
				todays_date, "N/A", "Enhance Right",id);
		test.pass(
				"User is able to view navigate to request overview page and check if the status is approved after 2nd level approval");
		logger.info(
				"User is able to view navigate to request overview page and check if the status is approved after 2nd level approval");
		}
		}
	}
}
