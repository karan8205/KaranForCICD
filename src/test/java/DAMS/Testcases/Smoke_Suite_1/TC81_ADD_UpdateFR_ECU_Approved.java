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

public class TC81_ADD_UpdateFR_ECU_Approved extends BaseClass {
	public static PropertyFile prop = new PropertyFile();

	@Test(dataProvider = "getData1", priority = 0)
	public static void add_functional_role_SpecialAccess_Approved(HashMap<String, String> input,String Functional) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Add functional role"
				+ "</u></i></b>");
		TC01_Login_MFA.login_with_addressing_MFA();
		Thread.sleep(8000);
		waitForPageLoad(driver);
		special.clickSpecialAccess();
		windowZoomOut(); 
		AddFunctionalRole_Approve(input,Functional);
		softAssertionALL();
	}

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//SpecialAccess.json");
		return new Object[][] { { data.get(4) } };
	}

	@DataProvider
	public Object[][] getData1() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//SpecialAccess.json");
		return new Object[][] { { data.get(4) } };
	}
	public static void AddFunctionalRole_Approve(HashMap<String, String> input,String Functional) throws Throwable {
		special.update_functional_role();
		test.pass("User is able to select Update Functional role and Update ECu Qualifier");
		logger.info("User is able to select Update Functional role and Update ECu Qualifier");
		special.add_functional_role(Functional, input.get("Business_unit"),
				input.get("Ecu-Qualifier"), input.get("Reason_for_DA"),input.get("Mode"));
		List<String> ecu_Qualifier_Update_for_Functional_Role_Overview = special
				.ECU_Qualifier_Update_for_Request_Overview_UpdateFunctional("Update Functional Role");
		softassertTrue(s, (boolean) ecu_Qualifier_Update_for_Functional_Role_Overview.get(0).equals("PENDING"));
		test.pass("User is able to view the sttaus as pending in request overview page once the request created");
		logger.info("User is able to view the sttaus as pending in request overview page once the request created");
		String approval_status_after_level1_approval = approver_overview.approve_special_enhanced_right_Request(
				"Update Functional Role", "PENDING", ecu_Qualifier_Update_for_Functional_Role_Overview);
		s.assertTrue(approval_status_after_level1_approval.equals("APPROVED"));
		test.pass("User is able to view the approval status as Approved after 1st level approval");
		logger.info("User is able to view the approval status as Approved after 1st level approval");
		test.pass(
				"Navigate to request Overview page and check if the status is still pending after 1st level approval");
		logger.info(
				"Navigate to request Overview page and check if the status is still pending after 1st level approval");
		special.clickSpecialAccess();
		special.update_functional_role();
		special.request_Overview_update();
		String approval_status_after_level2_approval = approver_overview.approve_special_enhanced_right_Request(
				"Update Functional Role", "PENDING", ecu_Qualifier_Update_for_Functional_Role_Overview);
		s.assertTrue(approval_status_after_level2_approval.equals("APPROVED"));
		test.pass("User is able to view the approval status as Approved after 2nd level approval");
		logger.info("User is able to view the approval status as Approved after 2nd level approval");
		test.pass("Navigate to request Overview page and check if the status is approved after 2nd level approval");
		logger.info("Navigate to request Overview page and check if the status is approved after 2nd level approval");
		special.clickSpecialAccess();
		special.update_functional_role();
		special.request_Overview_update();
	}

}
