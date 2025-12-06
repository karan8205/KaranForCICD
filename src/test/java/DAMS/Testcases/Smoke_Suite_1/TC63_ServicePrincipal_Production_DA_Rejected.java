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

public class TC63_ServicePrincipal_Production_DA_Rejected extends BaseClass{
	

	@Test(dataProvider = "getData_Service", priority = 0)
	public static void servicePrincipal_DiagnosticAuthority_Production_Rejected(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"+ "Diagnostic Authority Request for Internal- status pending:" + "</u></i></b>");	
		TC01_Login_MFA.login_with_addressing_MFA();
		ArrayList<String> application_Number=TC56_ServicePrinciple_Production_Pending.CreateFunctionalRoleService(input);
		logger.info(application_Number);
		TC58_ServicePrinciple_Production_Approved.approveServiceRequest(input,application_Number.get(0));			
		String id =createDA_Request(input,application_Number.get(1));		
		approver_overview.Reject_Request_Approval("Diagnostic Authority", id);	
		test.pass("User is able to verify selected ecu is not visible when the sttaus is in pending");
		logger.info("User is able to verify selected ecu is not visible when the sttaus is in pending");
		special.Approveroverviewhyperlink();
		softAssertionALL();
	}

	
	@DataProvider
	public Object[][] getData_Service() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//TechnicalUser.json");
		return new Object[][] { { data.get(0) } };
	}
	public static String createDA_Request(HashMap<String,String > input,String id) throws Throwable {	
		test.info("Diagnostic Authority request");
		logger.info("Diagnostic Authority request");
		myreq.select_NewPermission_request();
		boolean request_Overview_enabled=newper.Diagnostic_Authority_ServicePrincipal_Created(input);
		s.assertTrue(request_Overview_enabled);
		List<String> request_Overview_input = req.request_Overview_table_validation(id, "ALL");
		s.assertTrue(request_Overview_input.get(0).equals(prop.getStatus_pending()));
		test.pass("User is able to view the approval status as pending once the DA request created");
		logger.info("User is able to view the approval status as pending once the DA request created");
	return request_Overview_input.get(5);
	}

}
