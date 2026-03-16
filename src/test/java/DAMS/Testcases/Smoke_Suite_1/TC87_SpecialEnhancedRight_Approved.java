package DAMS.Testcases.Smoke_Suite_1;

import static DAMS.Resources.Listeners.test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import DAMS.Resources.BaseClass;
import DAMS.Resources.PropertyFile;

public class TC87_SpecialEnhancedRight_Approved extends BaseClass {
	public static PropertyFile prop = new PropertyFile();

	@Test(dataProvider = "getData1", priority = 1)
	public static void approve_Special_Enhance_Right_Request(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "Special Enhance Right"
				+ "</u></i></b>");
		TC01_Login_MFA.login_with_addressing_MFA_External();
		Thread.sleep(8000);
		waitForPageLoad(BaseClass.getDriver());
		special.clickSpecialAccess();
		windowZoomOut(); 
		SpecialEnhanceRight_Approve(input);
		softAssertionALL();
	}

	@DataProvider
	public Object[][] getData1() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//SpecialAccess.json");
		return new Object[][] { { data.get(4) } };
	}
	
	public static void SpecialEnhanceRight_Approve(HashMap<String, String> input) throws Throwable {
		special.Special_Enhanced_right();
		test.pass("User is able to select special access and Special Enhanced right");
		logger.info("User is able to select special access and Special Enhanced right");
		special.raise_Special_Enhance_Right_Request_Multiple(input);
		List<String> request_Overview_table_validation = special
				.request_Overview_table_validation("Special Enhance Right");
		softassertTrue(s, (boolean) request_Overview_table_validation.get(0).equals("PENDING"));
		test.pass("User is able to view the sttaus as pending once the request created");
		logger.info("User is able to view the sttaus as pending once the request created");
		approver_overview.search_here(prop.getUser_name());
		Thread.sleep(2000);
		approver_overview.filter_search(prop.getStatus_pending());
		Thread.sleep(1000);
		List<String> applicantNumber=req.getMultipleApplicantNumber();
		logger.info(applicantNumber);
		for(String id : applicantNumber) {
		String approval_status_after_level1_approval = approver_overview.approve_Multiple_special_enhanced_right_Request(
				"Special Enhance Rights", "PENDING", id);
		s.assertTrue(approval_status_after_level1_approval.equals("APPROVED"));
		test.pass("User is able to view the approval status as Approved after 1st level approval");
		logger.info("User is able to view the approval status as Approved after 1st level approval");
		special.clickSpecialAccess();
		special.Special_Enhanced_right();
		special.SpecialEnhance_request_Overview();
		test.pass("Navigate to request overview page and check if the status is pending after 1st level approval");
		logger.info("Navigate to request overview page and check if the status is pending after 1st level approval");
		String level2_approval = approver_overview.approve_Multiple_special_enhanced_right_Request("Special Enhance Rights",
				"PENDING", id);
		s.assertTrue(level2_approval.equals("APPROVED"));
		test.pass("User is able to view the approval status as Approved after 2nd level approval");
		logger.info("User is able to view the approval status as Approved after 2nd level approval");
		special.clickSpecialAccess();
		special.SpecialEnhance_request_Overview();
		test.pass("Navigate to request overview page and check if the status is approved after 2nd level approval");
		logger.info("Navigate to request overview page and check if the status is approved after 2nd level approval");
	}
	}
	public static void SpecialEnhanceRight_Approve_1(HashMap<String, String> input) throws Throwable {
		special.Special_Enhanced_right();
		test.pass("User is able to select special access and Special Enhanced right");
		logger.info("User is able to select special access and Special Enhanced right");
		special.raise_Special_Enhance_Right_Request(input.get("Functional_role"),input.get("User_role"),
				input.get("ECu-Qualifier"), input.get("Service_ID"), input.get("Validity"), input.get("Reason_for_DA"),input.get("Mode"));
		List<String> request_Overview_table_validation = special
				.request_Overview_table_validation("Special Enhance Right");
		softassertTrue(s, (boolean) request_Overview_table_validation.get(0).equals("PENDING"));
		test.pass("User is able to view the sttaus as pending once the request created");
		logger.info("User is able to view the sttaus as pending once the request created");
		String approval_status_after_level1_approval = approver_overview.approve_special_enhanced_right_Request(
				"Special Enhance Rights", "PENDING", request_Overview_table_validation);
		s.assertTrue(approval_status_after_level1_approval.equals("APPROVED"));
		test.pass("User is able to view the approval status as Approved after 1st level approval");
		logger.info("User is able to view the approval status as Approved after 1st level approval");
		special.clickSpecialAccess();
		special.Special_Enhanced_right();
		special.SpecialEnhance_request_Overview();
		test.pass("Navigate to request overview page and check if the status is pending after 1st level approval");
		logger.info("Navigate to request overview page and check if the status is pending after 1st level approval");
		String level2_approval = approver_overview.approve_special_enhanced_right_Request("Special Enhance Rights",
				"PENDING", request_Overview_table_validation);
		s.assertTrue(level2_approval.equals("APPROVED"));
		test.pass("User is able to view the approval status as Approved after 2nd level approval");
		logger.info("User is able to view the approval status as Approved after 2nd level approval");
		special.clickSpecialAccess();
		special.SpecialEnhance_request_Overview();
		test.pass("Navigate to request overview page and check if the status is approved after 2nd level approval");
		logger.info("Navigate to request overview page and check if the status is approved after 2nd level approval");
	}
	
}
