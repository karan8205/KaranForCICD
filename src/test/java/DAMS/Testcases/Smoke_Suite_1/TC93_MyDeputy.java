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

public class TC93_MyDeputy extends BaseClass {
	public static PropertyFile prop = new PropertyFile();

	@Test(dataProvider = "getData1", priority = 1)
	public static void my_Deputy(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "My Deputy"
				+ "</u></i></b>");
		TC01_Login_MFA.login_with_addressing_MFA();
		Thread.sleep(8000);
		BaseClass.minimize_window();
		deputy.Mydeputy_enabled();
		deputy.Validate_Mydeputy(input.get("Delegator_name"));
		deputy.my_Delegator_list(input.get("Delegator_name"),input.get("Deputy_email"),input.get("Delegator_username"));
		softAssertionALL();
	}

	@DataProvider
	public Object[][] getData1() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//MyDeputy.json");
		return new Object[][] { { data.get(0) } };
	}

}
