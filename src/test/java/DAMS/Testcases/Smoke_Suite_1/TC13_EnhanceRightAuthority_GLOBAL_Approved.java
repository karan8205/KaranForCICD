package DAMS.Testcases.Smoke_Suite_1;

import static DAMS.Resources.Listeners.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import DAMS.Resources.BaseClass;


public class TC13_EnhanceRightAuthority_GLOBAL_Approved extends BaseClass {

	@Test(dataProvider = "getData_Internal", priority = 0,enabled=false)
	public static void approve_Enhance_right_Authority_Request_Internal_test_case(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Enhance Right Authority Internal -status Approved" + "</u></i></b>");		
		TC11_EnhanceRightAuthority_GLOBAL.create_Enhance_right_Authority_Request_Internal_test_case(input);
		Thread.sleep(3000);
		req.search_here(prop.getUser_name());
		approve_Enhance_Right_Authority_request(input);
		softAssertionALL();
	}

	@Test(dataProvider = "getData_External", priority = 1,enabled=false)
	public static void approve_Enhance_right_Authority_Request_External_test_case(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Enhance Right Authority External -status Approved" + "</u></i></b>");

		TC11_EnhanceRightAuthority_GLOBAL.create_Enhance_right_Authority_Request_External_test_case(input);
		req.request_Overview();	
		req.select_Enhance_Right();
		req.search_here(prop.getUser_name());
		approve_Enhance_Right_Authority_request(input);
		test.pass("Create Enhance right request when the status is approved");
		logger.info("Create Enhance right request when the status is approved");
		softAssertionALL();

	}
	
	@Test(dataProvider = "getData_Supplier", priority = 2)
	public static void approve_Enhance_right_Authority_Request_Supplier_test_case(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Enhance Right Authority Supplier -status Approved" + "</u></i></b>");
		

		TC11_EnhanceRightAuthority_GLOBAL.create_Enhance_right_Authority_Request_Supplier_test_case(input);
		req.search_here(prop.getUser_name());	
		
		approve_Enhance_Right_Authority_request(input,prop.getUser_name());
		test.pass("Create Enhance right request when the status is approved");
		logger.info("Create Enhance right request when the status is approved");
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
		return new Object[][] { { data.get(12) } };

	}

	@DataProvider
	public Object[][] getData_Supplier() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//EnhanceRight_Authority.json");
		return new Object[][] {{ data.get(14) }};

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
	public static void approve_Enhance_Right_Authority_request(HashMap<String, String> input,String userName)
			throws Throwable {
		one_level_approval_Enhance_right(input);
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
						"View navigate to request overview page and status is approved after 1st level approval");
				logger.info(
						"View navigate to request overview page and status is approved after 1st level approval");
			}
			
		} 
	

	public static void two_level_approval_Enhance_right(HashMap<String, String> input,
			List<Object> create_and_approve_Internal_FR_request, List<Object> create_Enhance_Right_Authority_request) throws Throwable {
		String enhance_right_approval_status_after_level1_approval = approver_overview
				.approveEnhanceRight_authority_Request(create_Enhance_Right_Authority_request.get(7),
						"Enhance Right", prop.getStatus_pending(), create_Enhance_Right_Authority_request);
		s.assertTrue(enhance_right_approval_status_after_level1_approval.equals(prop.getStatus_Approved()));
		test.pass("View the approval status as Approved after 1st level approval");
		logger.info("View the approval status as Approved after 1st level approval");
		req.navigate_to_request_Overview_page_and_verify_approval_status_ER(prop.getStatus_pending(), "N/A",
				"N/A", "Enhance Right", prop.getUser_name());
		test.pass(
				"View navigate to request overview page and status is pending after 1st level approval");
		logger.info(
				"View navigate to request overview page and status is pending after 1st level approval");
		String enhance_right_approval_status_after_level2_approval = approver_overview
				.approveEnhanceRight_authority_Request(create_Enhance_Right_Authority_request.get(7),
						"Enhance Right", prop.getStatus_pending(), create_Enhance_Right_Authority_request);
		s.assertTrue(enhance_right_approval_status_after_level2_approval.equals(prop.getStatus_Approved()));
		test.pass("View the approval status as Approved after 2nd level approval");
		logger.info("View the approval status as Approved after 2nd level approval");
		String todays_date = todays_date();
		req.navigate_to_request_Overview_page_and_verify_approval_status_ER(prop.getStatus_Approved(),
				todays_date, "N/A", "Enhance Right", prop.getUser_name());
		test.pass(
				"View navigate to request overview page and status is approved after 2nd level approval");
		logger.info(
				"View navigate to request overview page and status is approved after 2nd level approval");

	}
	public static void two_level_approval_Enhance_right(HashMap<String, String> input) throws Throwable {
		
		List<String> applicantNumber=req.getMultipleApplicantNumber();
		String userrole = input.get("User_role_EA");
		String[] user = userrole.split("/");
		logger.info(user);
		for(int i=0;((i<user.length)&&(i<applicantNumber.size()));i++) {
			String id = applicantNumber.get(i);
			String u = user[i];
		if(u.equalsIgnoreCase("Development ENHANCED")||u.equalsIgnoreCase("After-Sales ENHANCED")||u.equalsIgnoreCase("After-Sales STANDARD")) { //Development ENHANCED
		String enhance_right_approval_status_after_level1_approval = approver_overview
				.approveEnhanceRight_authority_Request(input,id);
		s.assertTrue(enhance_right_approval_status_after_level1_approval.equals(prop.getStatus_Approved()));
		test.pass("View the approval status as Approved after 1st level approval");
		logger.info("View the approval status as Approved after 1st level approval");
				
		req.navigate_to_request_Overview_page_and_verify_approval_status_ER(prop.getStatus_pending(), "N/A",
				"N/A", "Enhance Right",id);
		test.pass(
				"View navigate to request overview page and status is pending after 1st level approval");
		logger.info(
				"View navigate to request overview page and status is pending after 1st level approval");
		String enhance_right_approval_status_after_level2_approval = approver_overview.approveEnhanceRight_authority_Request(input,id);
		s.assertTrue(enhance_right_approval_status_after_level2_approval.equals(prop.getStatus_Approved()));
		test.pass("View the approval status as Approved after 2nd level approval");
		logger.info("View the approval status as Approved after 2nd level approval");
		String todays_date = todays_date();
		req.navigate_to_request_Overview_page_and_verify_approval_status_ER(prop.getStatus_Approved(),
				todays_date, "N/A", "Enhance Right",id);
		test.pass(
				"View navigate to request overview page and status is approved after 2nd level approval");
		logger.info(
				"View navigate to request overview page and status is approved after 2nd level approval");
		}
		else {
			String enhance_right_approval_status_after_level1_approval = approver_overview
					.approveEnhanceRight_authority_Request(input,id);
			s.assertTrue(enhance_right_approval_status_after_level1_approval.equals(prop.getStatus_Approved()));
			test.pass("View the approval status as Approved after 1st level approval");
			logger.info("View the approval status as Approved after 1st level approval");
					
			req.navigate_to_request_Overview_page_and_verify_approval_status_ER(prop.getStatus_pending(), "N/A",
					"N/A", "Enhance Right",id);
			test.pass(
					"View navigate to request overview page and status is pending after 1st level approval");
			logger.info(
					"View navigate to request overview page and status is pending after 1st level approval");	
		}
		}
	}
	
	
public static void one_level_approval_Enhance_right(HashMap<String, String> input) throws Throwable {
		
		List<String> applicantNumber=req.getMultipleApplicantNumber();
		for(String id:applicantNumber) {
		String enhance_right_approval_status_after_level1_approval = approver_overview
				.approveEnhanceRight_authority_Request(input,id);
		s.assertTrue(enhance_right_approval_status_after_level1_approval.equals(prop.getStatus_Approved()));
		test.pass("View the approval status as Approved after 1st level approval");
		logger.info("View the approval status as Approved after 1st level approval");		
		req.navigate_to_request_Overview_page_and_verify_approval_status_ER(prop.getStatus_pending(), "N/A",
				"N/A", "Enhance Right",id);		
		logger.info(
				"View navigate to request overview page and status is approved after 2nd level approval");
		}
	}
}
