package DAMS.Testcases.Smoke_Suite_1;

import static DAMS.Resources.Listeners.test;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import DAMS.Resources.BaseClass;

public class TC71_OnboardNewECU_Pending extends BaseClass {

	@Test(dataProvider = "getData_Internal", priority = 0)
	public static void OnboardNewEcu_Pending(HashMap<String, String> input)
			throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"+ "Onboard New ECU Request for Internal- status pending:" + "</u></i></b>");
		TC01_Login_MFA.login_with_addressing_MFA();
		Thread.sleep(5000);
		myreq.select_NewPermission_request();	
		onboard_new_ECU.Onboard_ECU_Pending_Request(input);
		softAssertionALL();
	}

	@DataProvider
	public Object[][] getData_Internal() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "\\src\\test\\java\\DAMS\\data\\Onboard_New_ECU.json");
		return new Object[][] { { data.get(1) } };
	}

}
