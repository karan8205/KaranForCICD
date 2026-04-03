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

public class TC64_ServicePrincipal_Production_DA_Approved  extends BaseClass{

	
	@Test(dataProvider = "getData_Service", priority = 0)
	public static void servicePrincipal_DiagnosticAuthority_Production_Approved(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"+ "ServicePrincipal DA request Created- status pending:" + "</u></i></b>");
		TC01_Login_MFA.login_with_addressing_MFA();
		ArrayList<String> application_Number=TC56_ServicePrinciple_Production_Pending.CreateFunctionalRoleService(input);
		logger.info(application_Number);			
        TC58_ServicePrinciple_Production_Approved.approveServiceRequest(input,application_Number.get(0));	
		String id = TC62_ServicePrincipal_Production_DA_Pending.createDA_Request(input,application_Number.get(1));
		logger.info(id);
		approveServiceRequest(input,id);
		test.pass("******************* Test Case Pass *******************");
		logger.info("************** Service Principal DA Approved ****************");
		softAssertionALL();
	}

	
	@DataProvider
	public Object[][] getData_Service() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//TechnicalUser.json");
		return new Object[][] { { data.get(0) } };

	}

public static void approveServiceRequest(HashMap<String,String> input,String applicationNumber) throws Throwable {		
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
		req.search_here(applicationNumber);
	}
}
