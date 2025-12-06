package DAMS.Testcases.Smoke_Suite_1;

import static DAMS.Resources.Listeners.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import DAMS.Resources.AbstractComponents;
import DAMS.Resources.BaseClass;
import DAMS.Resources.SoftAssertUtil;


public class TC003_ServicePrincipal_TestSuite_E2E extends BaseClass {

	@Test(dataProvider = "getData_ServicePrincipal_Production", priority = 0,enabled=false)
	public static void service_Principal_Production_E2E(
			HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"+ "ServicePrincipal DA request Created- status pending:" + "</u></i></b>");
		TC01_Login_MFA.login_with_addressing_MFA();
		ArrayList<String> application_Number=TC56_ServicePrinciple_Production_Pending.CreateFunctionalRoleService(input);
		logger.info(application_Number);			
        TC58_ServicePrinciple_Production_Approved.approveServiceRequest(input,application_Number.get(0));
		String id = TC62_ServicePrincipal_Production_DA_Pending.createDA_Request(input,application_Number.get(1));
		logger.info(id);
		approveServiceRequestDA(input,id);
        String id1 =	create_Enhance_Right_Authority_request(input,application_Number.get(1));
		logger.info(id1);
		approveServiceRequestEA(input,id1);
		logger.info("************************************ Service Principal Production End to End Completed *************************");
		softAssertionALL();
	}

	@Test(dataProvider = "getData_ServicePrincipal_XOTA", priority = 1)
	public static void service_Principal_XOTA_FOTA_E2E(
			HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>" + "xOTA for FOTA request - status pending:"
				+ "</u></i></b>");
		TC61_ServicePrincipal_xOTA_Approved.servicePrincipal_STD_XOTA_Approved(input);
		List<String> id = TC70_xOTA_FOTA_Approved.createFOTA_Request(input);
		logger.info(id);
		TC70_xOTA_FOTA_Approved.approveServiceRequest(input,id.get(5));
		test.pass("******************* Test Case Pass *******************");
		logger.info("************************************ Service Principal XOTA FOTA End to End Completed *************************");
		softAssertionALL();
	}

	@DataProvider
	public Object[][] getData_ServicePrincipal_Production() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//End_to-end_functionality.json");
		return new Object[][] { { data.get(14) } };
	}

	@DataProvider
	public Object[][] getData_ServicePrincipal_XOTA() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//End_to-end_functionality.json");
		return new Object[][] { { data.get(15) } };

	}
	public static void approveServiceRequestDA(HashMap<String,String> input,String applicationNumber) throws Throwable {
		approver_overview.approver_Overview_enabled1();
		approver_overview.search_here(applicationNumber);
		String todays_date = todays_date();
		approver_overview.TwoLevelApprovel_Service_DA_EA(applicationNumber,"Diagnostic Authority",prop.getStatus_pending(),
				"N/A",input.get("User_role"));
	
		test.pass("User is able to approve 2nd level approval");
		logger.info("User is able to approve 2nd level approval");
		f.search_here(applicationNumber);
		req.navigate_to_request_Overview_page_and_verify_approval_status_Service(prop.getStatus_Approved(), todays_date,
				"N/A", "Diagnostic Authority", applicationNumber,input.get("User_role"));
	}
	public static void approveServiceRequestEA(HashMap<String,String> input,String applicationNumber) throws Throwable {
		approver_overview.approver_Overview_enabled1();
		approver_overview.search_here(applicationNumber);
		String todays_date = todays_date();
		approver_overview.TwoLevelApprovel_Service_DA_EA(applicationNumber,"Enhance Right",prop.getStatus_pending(),
				"N/A",input.get("User_role"));

		test.pass("User is able to approve 2nd level approval");
		logger.info("User is able to approve 2nd level approval");
		f.search_here(applicationNumber);
		req.navigate_to_request_Overview_page_and_verify_approval_status_Service(prop.getStatus_Approved(), todays_date,
				"N/A", "Enhance Right", applicationNumber,input.get("User_role"));
	}
	public static String create_Enhance_Right_Authority_request(HashMap<String, String> input,String principalId)
			throws Throwable {
		test.info("Enhance_Right_Authority_request");
		logger.info("Enhance_Right_Authority_request");
		myreq.select_NewPermission_request();
		List<Object> request_Overview_enabled = newper.raise_Enhance_Right_Request_ServicePrincipal(input);
		request_Overview_enabled.get(0);
		SoftAssertUtil.assertTrue((boolean) request_Overview_enabled.get(0));
		test.pass("User is able to view the approval status as pending once the DA request created");
		List<Object> request_Overview_input = req.request_Overview_table_validation_for_Enhanced_right_for_TU("Enhance Right", principalId,"ALL");
		s.assertTrue(request_Overview_input.get(0).equals(prop.getStatus_pending()));
		return (String) request_Overview_input.get(7);

	}
}

