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

public class TC58_ServicePrinciple_Production_Approved extends BaseClass{
	@Test(dataProvider = "getData_Service", priority = 0)
	public static void servicePrincipal_STD_Procudtion_Approved(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Special Case Functional Role - status pending:" + "</u></i></b>");	
		TC01_Login_MFA.login_with_addressing_MFA();	
		ArrayList<String> application_Number=TC56_ServicePrinciple_Production_Pending.CreateFunctionalRoleService(input);
		approveServiceRequest(input,application_Number.get(0));	
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
		approver_overview.TwoLevelApprovel_Service(applicationNumber);
		test.pass("User is able to approve 2nd level approval");
		logger.info("User is able to approve 2nd level approval");
		f.search_here(applicationNumber);
		String cert = f.Service_ValidatetheStandardCertificateofthe_Functionalrole_after_2level_approval(prop.getStatus_Approved(),applicationNumber);	
	}
	
}
