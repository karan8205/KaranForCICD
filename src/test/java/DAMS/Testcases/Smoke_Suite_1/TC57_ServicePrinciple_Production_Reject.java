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

public class TC57_ServicePrinciple_Production_Reject extends BaseClass{
	@Test(dataProvider = "getData_Service", priority = 0)
	public static void servicePrincipal_STD_Procudtion_Rejected(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Special Case Functional Role - status pending:" + "</u></i></b>");
		TC01_Login_MFA.login_with_addressing_MFA();	
		ArrayList<String> application_Number=TC56_ServicePrinciple_Production_Pending.CreateFunctionalRoleService(input);
		approver_overview.Reject_Request(application_Number.get(0));
		f.functional_role_Overview_enabled1();
		 f.functionalValidation(application_Number.get(1));	
		softAssertionALL();
	}
	@DataProvider
	public Object[][] getData_Service() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//TechnicalUser.json");
		return new Object[][] { { data.get(0) } };
	}	
}
