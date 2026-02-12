package DAMS.Testcases.Smoke_Suite_1;

import static DAMS.Resources.Listeners.test;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import DAMS.Resources.BaseClass;
import DAMS.Resources.PropertyFile;

public class TC97_ECU_Certificate_Request_Approved extends BaseClass {
	public static PropertyFile prop = new PropertyFile();

	@Test(dataProvider = "getData1", priority = 1)
	public static void ecu_Certificate_Request_approved(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "ECU Certificate Request Approved"
				+ "</u></i></b>");
		TC01_Login_MFA.login_with_addressing_MFA();
		Thread.sleep(8000);
		myreq.select_NewPermission_request();
		newper.raise_ECU_Certificate_Request(input);
        String id=  req.ECU_Request_Overview_table_validation("ECU Certificate Request");
        approver_overview.Pending_Request_Approval("ECU Certificate Request",id);
		BaseClass.minimize_window();		
		softAssertionALL();
	}
	@DataProvider
	public Object[][] getData1() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
		System.getProperty("user.dir") + "//src//test//java//DAMS//data//ECU_Certificate.json");
		return new Object[][] { { data.get(0) } };
	}
}
