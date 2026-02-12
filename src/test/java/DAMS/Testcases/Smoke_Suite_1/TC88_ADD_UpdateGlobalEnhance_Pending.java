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

public class TC88_ADD_UpdateGlobalEnhance_Pending extends BaseClass {
	public static PropertyFile prop = new PropertyFile();

	@Test(dataProvider = "getData1", priority = 1)
	public static void raise_add_Update_Global_Enhance_Request(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Update Global Enhance Right request Pending"
				+ "</u></i></b>");
		TC01_Login_MFA.login_with_addressing_MFA();
		Thread.sleep(5000);
		waitForPageLoad(driver);
		BaseClass.minimize_window();
		special.clickSpecialAccess(); 
		Thread.sleep(2000);
		special.selectUpdate_Global_EA();
		special.add_UpdateEnhanceRaise(input.get("FunctionalRole"),input.get("ECU_Restriction"),input.get("ServiceID"),input.get("Validity"),input.get("Reason_for_UpdateGlobalEnhance"));	
		special.Validate_Add_Update_EnhanceRight();	
		softAssertionALL();
	}

	@DataProvider
	public Object[][] getData1() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//SpecialAccess.json");
		return new Object[][] { { data.get(1) } };

	}

}
