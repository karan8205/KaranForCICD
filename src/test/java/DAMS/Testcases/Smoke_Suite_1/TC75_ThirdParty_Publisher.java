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

public class TC75_ThirdParty_Publisher extends BaseClass {
	public static PropertyFile prop = new PropertyFile();

	@Test(dataProvider = "getData1", priority = 1)
	public static void raise_Third_Party_Request(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Third Party request"
				+ "</u></i></b>");
		TC01_Login_MFA.login_with_addressing_MFA();
		Thread.sleep(8000);
		waitForPageLoad(driver);
		special.clickSpecialAccess();
		special.Third_Party_Publisher();
		String [] optionsToSelect = input.get("new_Permission").split("/");
		raise_third_party_publisher_request(input, optionsToSelect);
		softAssertionALL();
	}

	@DataProvider
	public Object[][] getData1() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//SpecialAccess.json");
		return new Object[][] { { data.get(0) } };
	}	
	public static void raise_third_party_publisher_request(HashMap<String, String> input, String[] optionsToSelect) throws Throwable {
		special.selectECU_Chain(input.get("ECU_Mode"));
		String role_Desc = special.role_desc_text();
		role_Desc.equalsIgnoreCase(input.get("Role_Description"));
		test.pass("Verified the role description in Functional Overview page");
		special.publisher_Onboarding_business_unit(input.get("Business_unit"));
		 Random rand = new Random();
		    int randomNum = 1000 + rand.nextInt(9000); 
			String Publisher;
			Publisher = "ROBERT_DEMO_" + randomNum;
			String Functional = "DEVELOPTEST"+randomNum;
		special.publisher_name(Publisher);
		special.new_Functional_role_select(Functional);		
		List<String> publisher_Onboarding_new_permission2 = special
				.publisher_Onboarding_new_permission(optionsToSelect);
		String reason_txt = special.provide_reason_and_submit(input.get("Reason_for_ThirdParty"));		
	}

}
