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

public class TC85_SpecialEnhancedRight_Pending extends BaseClass {
	public static PropertyFile prop = new PropertyFile();

	@Test(dataProvider = "getData1", priority = 1)
	public static void raise_Special_Enhance_Right_Request(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Special Enhance Right"
				+ "</u></i></b>");
		TC01_Login_MFA.login_with_addressing_MFA();
		Thread.sleep(8000);
		special.clickSpecialAccess();
		windowZoomOut(); 
		special.Special_Enhanced_right();
		test.pass("User is able to select special access and Special Enhanced right");
		logger.info("User is able to select special access and Special Enhanced right");
		special.raise_Special_Enhance_Right_Request(input.get("Functional_role"), input.get("User_role"),
				input.get("ECu-Qualifier"), input.get("Service_ID"), input.get("Validity"), input.get("Reason_for_DA"),input.get("Mode"));
		List<String> request_Overview_table_validation = special
				.request_Overview_table_validation("Special Enhance Right");
		softassertTrue(s, (boolean) request_Overview_table_validation.get(0).equals("PENDING"));
		test.pass("User is able to view the sttaus as pending once the request created");
		logger.info("User is able to view the sttaus as pending once the request created");
		softAssertionALL();
	}

	@DataProvider
	public Object[][] getData1() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//SpecialAccess.json");
		return new Object[][] { { data.get(4) } };
	}
}
