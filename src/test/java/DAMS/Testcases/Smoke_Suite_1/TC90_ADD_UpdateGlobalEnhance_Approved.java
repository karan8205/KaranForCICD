package DAMS.Testcases.Smoke_Suite_1;

import static DAMS.Resources.Listeners.test;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import DAMS.Resources.BaseClass;
import DAMS.Resources.PropertyFile;

public class TC90_ADD_UpdateGlobalEnhance_Approved extends BaseClass {
	public static PropertyFile prop = new PropertyFile();

	@Test(dataProvider = "getData1", priority = 1)
	public static void approve_add_Update_Global_Enhance_Request(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Update Global Enhance Right request approved"
				+ "</u></i></b>");
		TC01_Login_MFA.login_with_addressing_MFA(); 
		Thread.sleep(8000);
		BaseClass.minimize_window();
		special.clickSpecialAccess();
		Thread.sleep(2000);
		special.selectUpdate_Global_EA();
		 Random rand = new Random();
		    int randomNum = 1000 + rand.nextInt(9000); 
			String Publisher;
			Publisher = "AE" + randomNum;
		
		special.add_UpdateEnhanceRaise(input.get("FunctionalRole"),input.get("ECU_Restriction"),Publisher,input.get("Validity"),input.get("Reason_for_UpdateGlobalEnhance"));
		
		String id =special.Validate_Add_Update_EnhanceRight();
		
	approver_overview.approverOverviewPage_for_Special_Access("Update Global Enhance Rights",id);
	Thread.sleep(2000);
	test.pass("User is able to view the approval status as Approved after 1st level approval");
	logger.info("User is able to view the approval status as Approved after 1st level approval");
	special.navigate_to_request_Overview_page_and_Update_EA(id);
	approver_overview.approverOverviewPage_for_Special_Access("Update Global Enhance Rights",id);
	test.pass("User is able to view the approval status as Approved after 2nd level approval");
	logger.info("User is able to view the approval status as Approved after 2nd level approval");
	special.navigate_to_request_Overview_page_and_Update_EA(id);	
	softAssertionALL();
	}

	@DataProvider
	public Object[][] getData1() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//SpecialAccess.json");
		return new Object[][] { { data.get(1) } };
	}

}
