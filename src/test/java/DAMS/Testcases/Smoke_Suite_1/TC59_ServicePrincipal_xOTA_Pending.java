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

public class TC59_ServicePrincipal_xOTA_Pending extends BaseClass{

	@Test(dataProvider = "getData_Service", priority = 0)
	public static void servicePrincipal_STD_XOTA_Pending(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Special Case Functional Role - status pending:" + "</u></i></b>");
		TC01_Login_MFA.login_with_addressing_MFA();
		CreateFunctionalRoleService(input);
		softAssertionALL();
	}
	@DataProvider
	public Object[][] getData_Service() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//TechnicalUser.json");
		return new Object[][] { { data.get(1) } };
	}
	
	public static List<String> CreateFunctionalRoleService(HashMap<String,String> input) throws Throwable {
		Thread.sleep(3000);
        h.selectServicePrincipal();
        Thread.sleep(4000);
		gtc.gtc_page_validation();
		test.pass("User is able to validate the gtc page");
		logger.info("User is able to validate the gtc page");	
	    String serviceId = newrequest.raiseFunctionalForService(input.get("BU"), input.get("Reason"), input.get("Chain_Trust"),input.get("Functional_role"));
		f.functional_role_Overview_enabled1();
		String id =f.functionalValidation(serviceId);
		ArrayList<String> num = new ArrayList<>();
		num.add(id);
		num.add(serviceId);
		return num;
	}	
}
