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

public class TC92_ECU_MetaData extends BaseClass {
	public static PropertyFile prop = new PropertyFile();

	@Test(dataProvider = "getData1", priority = 1)
	public static void request_ECU_MetaData(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "ECU Metadata"
				+ "</u></i></b>");
		TC01_Login_MFA.login_with_addressing_MFA();
		Thread.sleep(5000);	
		special.clickSpecialAccess();
		raise_MetaData_Request(input);
		String id =validate_Meta_Data();
        approver_overview.Pending_Request_Approval("ECU Metadata",id);
        special.select_ECU_MetaData();
        validate_Meta_Data();	
		softAssertionALL();
	}

	@DataProvider
	public Object[][] getData1() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//SpecialAccess.json");
		return new Object[][] { { data.get(3) } };

	}
	
    public static void raise_MetaData_Request(HashMap<String,String> input) throws InterruptedException {
		special.select_ECU_MetaData();
		special.select_ECU_Request_Type(input.get("Request_Type"));
		special.select_ECU_Qualifier(input.get("ECU"));
		special.select_New_Owner(input.get("new_Owner"));
		special.submit_button();
	}
    
    public static String validate_Meta_Data() throws Throwable {
    	special.select_MetaData_Request_OverView();
    	special.approvalLinkCheck();
    	String id = special.applicant_number_txt();
        special.scroll_to_owner();
        
    	return id;
    }
}
