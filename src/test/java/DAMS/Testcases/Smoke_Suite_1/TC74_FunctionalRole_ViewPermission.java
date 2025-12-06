package DAMS.Testcases.Smoke_Suite_1;

import static DAMS.Resources.Listeners.test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import DAMS.Resources.BaseClass;
import DAMS.Resources.PropertyFile;

public class TC74_FunctionalRole_ViewPermission extends BaseClass {
	public static PropertyFile prop = new PropertyFile();

	@Test(dataProvider = "getData1", priority = 1)
	public static void view_FunctionalRolePermission(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Special Enhanced right request"
				+ "</u></i></b>");
		TC01_Login_MFA.login_with_addressing_MFA();
		Thread.sleep(5000);
		BaseClass.minimize_window();	
		ArrayList<String> id=TC56_ServicePrinciple_Production_Pending.CreateFunctionalRoleService(input);
		TC58_ServicePrinciple_Production_Approved.approveServiceRequest(input,id.get(0));
		special.clickSpecialAccess();
		special.selectFR_Permission();	
		viewPermission(input,id.get(1));	
		softAssertionALL();
	}

	@DataProvider
	public Object[][] getData1() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//SpecialAccess.json");
		return new Object[][] { { data.get(2) } };
	}
	
	public static void viewPermission(HashMap<String,String> input,String id) throws Throwable {
		Thread.sleep(1000);
		req.refresh();
		Thread.sleep(2000);
		special.FR_Viewbusiness_unit(input.get("Business_unit"));
		special.FR_View_FuncRole(input.get("Functional_role"));
		logger.info(id);
		special.FR_ViewTechUserId(id);
		special.FR_ViewPermissionType(input.get("PermissionType"));
		special.click_Permission();
	}

}
