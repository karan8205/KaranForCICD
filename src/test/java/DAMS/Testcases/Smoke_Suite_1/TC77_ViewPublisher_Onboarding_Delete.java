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

public class TC77_ViewPublisher_Onboarding_Delete extends BaseClass {
	public static PropertyFile prop = new PropertyFile();

	@Test(dataProvider = "getData1", priority = 1)
	public static void raise_Delete_ThirdParty_ViewPublisher_Onboarding_Request(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Third Party request and view/edit/delete publisher Onboarding "
				+ "</u></i></b>");
		TC01_Login_MFA.login_with_addressing_MFA();
		Thread.sleep(8000);
		special.clickSpecialAccess();
		special.Third_Party_Publisher();
		String [] optionsToSelect = input.get("new_Permission").split("/");
		String [] viewoptionsToSelect = input.get("New_Permission_View").split("/");
		raise_View_third_party_publisher_request(input, optionsToSelect,viewoptionsToSelect);
		softAssertionALL();
	}

	@DataProvider
	public Object[][] getData1() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//SpecialAccess.json");
		return new Object[][] { { data.get(0) } };
	}
	
	public static void raise_View_third_party_publisher_request(HashMap<String, String> input, String[] optionsToSelect,String[] viewoptionsToSelect) throws Throwable {
		BaseClass.minimize_window();
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
		Thread.sleep(3000);
		special.selectECU_Chain_ViewPublisher(input.get("ECU_Mode"));
		Thread.sleep(2000);
		special.view_publisher_Onboarding_business_unit(input.get("Business_unit"));
		special.viewBtn();
		special.search_here(Publisher);
		Thread.sleep(2000);
		special.refreshBtn();
		Thread.sleep(6000);
		special.view_publisher_Onboarding_new_permission(viewoptionsToSelect);
		special.submit();
		special.submit();
	}
}
