package DAMS.Testcases.Smoke_Suite_1;

import static DAMS.Resources.Listeners.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import DAMS.Resources.BaseClass;

public class TC69_xOTA_FOTA_Rejected extends BaseClass {

	@Test(dataProvider = "getData_Service", priority = 0)
	public static void create_FOTA_Request_ServicePrincipal_Rejected(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>" + "xOTA for FOTA request - status pending:"
				+ "</u></i></b>");
		TC61_ServicePrincipal_xOTA_Approved.servicePrincipal_STD_XOTA_Approved(input);
		List<String> request_overview_table =createFOTA_Request(input);
		approver_overview.Reject_Request_Approval("FOTA", request_overview_table.get(5));
		req.validate_Request_Overview_page("FOTA",request_overview_table.get(5));
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

}
