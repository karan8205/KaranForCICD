package DAMS.Testcases.Smoke_Suite_1;

import static DAMS.Resources.Listeners.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import DAMS.Resources.BaseClass;

public class TC70_xOTA_FOTA_Approved extends BaseClass {

	@Test(dataProvider = "getData_Service", priority = 0)
	public static void create_FOTA_Request_ServicePrincipal_Approved(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>" + "xOTA for FOTA request - status pending:"
				+ "</u></i></b>");
		TC61_ServicePrincipal_xOTA_Approved.servicePrincipal_STD_XOTA_Approved(input);
		List<String> id = createFOTA_Request(input);
		logger.info(id);
		approveServiceRequest(input,id.get(5));
		test.pass("******************* Test Case Pass *******************");
		logger.info("************** FOTA Approved ****************");	
		softAssertionALL();
	}

	@DataProvider
	public Object[][] getData_Service() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//TechnicalUser.json");
		return new Object[][] { { data.get(1) } };
	}
	public static List<String> createFOTA_Request(HashMap<String, String> input) throws Throwable {
		myreq.select_NewPermission_request();
		boolean request_Overview_enabled = newper.raise_FOTA_Request_xOTA(input.get("Special_Case"),
				input.get("Diagnostic_Permission"), input.get("ECU_Restriction"), input.get("Reason_for_FOTA"),input.get("Functional_role"),
				input.get("Service_ID"),input.get("Validity"),input.get("Enhance_Validity"));
		s.assertTrue(request_Overview_enabled);
		List<String> request_Overview_table_input = req.request_Overview_table_validation_for_FOTA("FOTA",prop.getUser_name());
		test.pass("User is able to view the approval status as pending once the FOTA request created");
		logger.info("User is able to view the approval status as pending once the FOTA request created");
		return request_Overview_table_input;
	}
	public static void approveServiceRequest(HashMap<String,String> input,String applicationNumber) throws Throwable {	
		approver_overview.approver_Overview_enabled1();
		approver_overview.search_here(applicationNumber);
		approver_overview.TwoLevelApprovel_Service_DA_EA(applicationNumber,"FOTA",prop.getStatus_pending(),
				"N/A",input.get("User_role"));
		test.pass("User is able to approve 2nd level approval");
		logger.info("User is able to approve 2nd level approval");
		String todays_date = todays_date();
		req.navigate_to_request_Overview_page_and_verify_approval_status_Service(prop.getStatus_Approved(), todays_date,
				"N/A", "FOTA", applicationNumber,input.get("User_role"));
		
	}

}
