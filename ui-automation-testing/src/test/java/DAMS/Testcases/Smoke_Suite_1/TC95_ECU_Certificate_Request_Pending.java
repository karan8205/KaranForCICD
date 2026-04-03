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

public class TC95_ECU_Certificate_Request_Pending extends BaseClass {
	public static PropertyFile prop = new PropertyFile();

	@Test(dataProvider = "getData1", priority = 1)
	public static void ecu_Certificate_Request_pending(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "ECU Certificate Request Pending"
				+ "</u></i></b>");
		TC06_STD_GLOBAL_FRapproved.Functional_role_request_approved_Supplier(input);
		myreq.select_NewPermission_request();
		newper.raise_ECU_Certificate_Request(input);
        req.ECU_Request_Overview_table_validation("ECU Certificate Request");		
		softAssertionALL();
	}
	@DataProvider
	public Object[][] getData1() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
		System.getProperty("user.dir") + "\\src\\test\\java\\DAMS\\data\\ECU_Certificate.json");
		return new Object[][] { { data.get(0) } };
	}
}
