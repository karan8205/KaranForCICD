package DAMS.Testcases.Smoke_Suite_1;

import static DAMS.Resources.Listeners.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import DAMS.Resources.BaseClass;
import DAMS.Resources.SoftAssertUtil;

public class TC65_ServicePrincipal_Production_EA_Pending  extends BaseClass{

	
	@Test(dataProvider = "getData_Service", priority = 0)
	public static void servicePrincipal_EnhanceRight_Production_Pending(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"+ "Diagnostic Authority Request for Service Principal- status pending:" + "</u></i></b>");		
		TC58_ServicePrinciple_Production_Approved.servicePrincipal_STD_Procudtion_Approved(input);		
		create_Enhance_Right_Authority_request(input);	
		softAssertionALL();
	}

	
	@DataProvider
	public Object[][] getData_Service() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//TechnicalUser.json");
		return new Object[][] { { data.get(0) } };

	}

	public static List<Object> create_Enhance_Right_Authority_request(HashMap<String, String> input)
			throws Throwable {
		test.info("Enhance_Right_Authority_request");
		logger.info("Enhance_Right_Authority_request");
		myreq.select_NewPermission_request();
		List<Object> request_Overview_enabled = newper.raise_Enhance_Right_Request_Supplier(input);
		request_Overview_enabled.get(0);
		SoftAssertUtil.assertTrue((boolean) request_Overview_enabled.get(0));
		test.pass("User is able to view the approval status as pending once the DA request created");
		return request_Overview_enabled;

	}
}
