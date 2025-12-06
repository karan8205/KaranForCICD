package DAMS.Testcases.Smoke_Suite_1;

import static DAMS.Resources.Listeners.test;

import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import DAMS.Resources.BaseClass;
import DAMS.Resources.PropertyFile;

public class TC94_ReadView_Permission extends BaseClass {
	public static PropertyFile prop = new PropertyFile();

	@Test(dataProvider = "getData1", priority = 1)
	public static void read_View_Permission(HashMap<String, String> input) throws Throwable {
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "ReadView Permission"
				+ "</u></i></b>");
		TC01_Login_MFA.login_with_addressing_MFA();
		Thread.sleep(8000);
		ReadViewPermission(input);
		test.log(Status.INFO, "<span style=\"color: blue;\"><b><i><u>"
				+ "*****ReadView Permission Validated done*******"
				+ "</u></i></b>");
		softAssertionALL();
	}

	@DataProvider
	public Object[][] getData1() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//DAMS//data//ReadView_Permission.json");
		return new Object[][] { { data.get(0) } };

	}	
	public static void ReadViewPermission(HashMap<String,String > input) throws InterruptedException, AWTException {
		read.readviewpermissionEnabled();
		BaseClass.minimize_window();
		read.readviewpermissionUserType(input.get("UserType"));	
		read.readviewpermissionSearchUser(input.get("ShortID"));
		read.searchBtn();
		read.applicationNumber_FilterSearch(input.get("Application_Number"));
		read.CeBE_Hyperlink();
	}

}
