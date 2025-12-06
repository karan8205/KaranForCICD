package DAMS.Testcases.Smoke_Suite_1;

import static DAMS.Resources.Listeners.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import DAMS.Resources.BaseClass;
import DAMS.Resources.SoftAssertUtil;

public class TC66_ServicePrincipal_Production_EA_Rejected  extends BaseClass{

	
	@Test(dataProvider = "getData_Service", priority = 0)
	public static void servicePrincipal_EnhanceRight_Production_Rejected(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"+ "Diagnostic Authority Request for Service Principal- status pending:" + "</u></i></b>");		
		TC01_Login_MFA.login_with_addressing_MFA();
		ArrayList<String> application_Number=TC56_ServicePrinciple_Production_Pending.CreateFunctionalRoleService(input);
		logger.info(application_Number);
        TC58_ServicePrinciple_Production_Approved.approveServiceRequest(input,application_Number.get(0));
	    String id = create_Enhance_Right_Authority_request(input,application_Number.get(1));        
		approver_overview.Reject_Request_Approval("Enhance Right", id);
		special.Approveroverviewhyperlink();
		softAssertionALL();
	}

	@DataProvider
	public Object[][] getData_Service() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//TechnicalUser.json");
		return new Object[][] { { data.get(0) } };
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
