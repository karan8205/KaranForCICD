package DAMS.Testcases.Smoke_Suite_1;

import static DAMS.Resources.Listeners.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import DAMS.Resources.AbstractComponents;
import DAMS.Resources.BaseClass;
import DAMS.Resources.SoftAssertUtil;
import jdk.internal.org.jline.utils.Log;


public class TC004_SpecialAccess_TestSuite_E2E extends BaseClass {

	@Test(dataProvider = "getData_SpecialAccess", priority = 0)
	public static void Special_Access_E2E(

			HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"+ "SpecialAccess request Creation - status pending:" + "</u></i></b>");
//		TC01_Login_MFA.login_with_addressing_MFA();
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Raise and View Third Party request"
				+ "</u></i></b>");
		TC01_Login_MFA.login_with_addressing_MFA();
		Thread.sleep(3000);
		waitForPageLoad(driver);
		Thread.sleep(10000);	
		special.clickSpecialAccess();
		windowZoomOut();
		special.Third_Party_Publisher();
		String [] optionsToSelect = input.get("new_Permission").split("/");
		String [] viewoptionsToSelect = input.get("New_Permission_View").split("/");
		String Functional = TC76_ViewPublisher_Onboarding_Edit.raise_View_third_party_publisher_request(input, optionsToSelect,viewoptionsToSelect);
		logger.info("Thrid Party Publisher completed");
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Add Update Functional Role Ecu Qualifier" + "</u></i></b>");
		TC81_ADD_UpdateFR_ECU_Approved.AddFunctionalRole_Approve(input,Functional);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Creation of Special Enhance Right Request" + "</u></i></b>");
		TC87_SpecialEnhancedRight_Approved.SpecialEnhanceRight_Approve(input);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Remove Update Functional Role Ecu Qualifier" + "</u></i></b>");
		TC84_REMOVE_UpdateFR_ECU_Approved.removeFunctionalRole_Approve(input,Functional);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Special Access End to End Completed" + "</u></i></b>");
		validate_Update_Special_Enhance_Right(input);
		logger.info("************************************ Special Access End to End Completed *************************");
		softAssertionALL();
	}

	@DataProvider
	public Object[][] getData_SpecialAccess() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//End_to-end_functionality.json");
		return new Object[][] { { data.get(16) } };
	}
	
	
	public static void validate_Update_Special_Enhance_Right(HashMap<String, String> input) throws Throwable {
		special.Special_Enhanced_right();
		special.validate_Special_Enhance_Right_ECU(input.get("Functional_role"), input.get("User_role"),input.get("Ecu-Qualifier"),input.get("Mode"));
		
		
	}
}

