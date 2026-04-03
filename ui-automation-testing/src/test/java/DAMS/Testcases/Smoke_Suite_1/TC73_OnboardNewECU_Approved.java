package DAMS.Testcases.Smoke_Suite_1;

import static DAMS.Resources.Listeners.test;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import DAMS.Resources.BaseClass;

public class TC73_OnboardNewECU_Approved extends BaseClass {

	@Test(dataProvider = "getData_Internal", priority = 0)
	public static void OnboardNewEcu_Approved(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"+ "Diagnostic Authority Request for Internal- status pending:" + "</u></i></b>");		
		TC06_STD_GLOBAL_FRapproved.Functional_role_request_approved_Internal(input);
		Thread.sleep(3000);
		myreq.select_NewPermission_request();	
		onboard_new_ECU.Onboard_ECU_Pending_Request(input);
		String id=	req.onBoard_Request_Validation("Onboard New ECU");
		approver_overview.onBoard_Approval("Onboard New ECU", id);
		Thread.sleep(1000);
		req.onBoard_Request_Validation("Onboard New ECU");
		softAssertionALL();
	}
	
	@DataProvider
	public Object[][] getData_Internal() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
		System.getProperty("user.dir") + "\\src\\test\\java\\DAMS\\data\\Onboard_New_ECU.json");
		return new Object[][] { { data.get(1) } };

	}
}
