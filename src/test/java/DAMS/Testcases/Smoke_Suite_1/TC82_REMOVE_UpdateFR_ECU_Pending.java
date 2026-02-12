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

public class TC82_REMOVE_UpdateFR_ECU_Pending extends BaseClass {
	public static PropertyFile prop = new PropertyFile();

	@Test(dataProvider = "getData1", priority = 0)
	public static void remove_functional_role_SpecialAccess_Pending(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Remove functional role"
				+ "</u></i></b>");
		TC01_Login_MFA.login_with_addressing_MFA();
		Thread.sleep(8000);
		waitForPageLoad(driver);
		special.clickSpecialAccess();
		windowZoomOut(); 
		special.update_functional_role();
		test.pass("User is able to select Update Functional role and Update ECu Qualifier");
		logger.info("User is able to select Update Functional role and Update ECu Qualifier");
		special.remove_functional_role(input.get("Functional_role"), input.get("Business_unit"),
				input.get("ECu-Qualifier"), input.get("Reason_for_DA"),input.get("Mode"));
		List<String> ecu_Qualifier_Update_for_Functional_Role_Overview = special
				.ECU_Qualifier_Update_for_Request_Overview_UpdateFunctional("Update Functional Role");
		softassertTrue(s, (boolean) ecu_Qualifier_Update_for_Functional_Role_Overview.get(0).equals("PENDING"));
		test.pass("User is able to view the status as pending in request overview page once the request created");
		logger.info("User is able to view the status as pending in request overview page once the request created");
		softAssertionALL();
	}

	@DataProvider
	public Object[][] getData1() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//SpecialAccess.json");
		return new Object[][] { { data.get(4) } };
	}

}
