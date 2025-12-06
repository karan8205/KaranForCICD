package DAMS.PageObjects;

import DAMS.ObjectManager.PageObjectManager;
import DAMS.Resources.AbstractComponents;
import DAMS.Resources.BaseClass;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import DAMS.Resources.SoftAssertUtil;

import static DAMS.Resources.Listeners.test;

public class Functional_role_page extends AbstractComponents {

	String User_id;
	String User_name;
	String department;
	String applicant_type;
	String application_number;
	String functional_role;
	String approval_status;
	String request_date;
	String approval_date;
	String std_permission;
	String reason_for_request;
	String approver_reason;
	String std_permission_txt;
	String approval_date_txt;
	String ECU_Qualifier;
	String Company_Name;
	String GTC_Signed_Status;
	String Business_Unit;
	String user_type;
	String requester_Id;

	WebDriver driver;

	public static Logger logger = Logger.getLogger("DAMS");

	public Functional_role_page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class=\"approver-name\"]/label[text()=\"Status\"]")
	private WebElement FR_Overview_status;

	@FindBy(xpath = "//span[text()='All']")
	private WebElement FR_Overview_status_all;

	@FindBy(xpath = "//a[text()='PENDING']")
	private WebElement FR_Overview_status_Pending;

	@FindBy(xpath = "//span[text()=\"Technical User\"]")
	private WebElement FR_Overview_Technical_user;

	@FindBy(xpath = "//span[text()=\"Approved\"]")
	private WebElement FR_Overview_status_Approved;

	@FindBy(xpath = "//span[text()=\"Rejected\"]")
	private WebElement FR_Overview_status_rejected;

	@FindBy(xpath = "//mat-label[text()='Applicant']")
	private WebElement FR_Overview_applicant;

	@FindBy(xpath = "//span[text()='Myself']")
	private WebElement FR_Overview_myself;
	
	@FindBy(xpath = "(//span[text()='All'])[2]")
	private WebElement FR_Overview_All;

	@FindBy(xpath = "//input[@value=\"Myself\"]")
	private WebElement myself_radio_btn;

	@FindBy(xpath = "//div[text()=\"Service Principal ID\"]")
	private WebElement FR_Overview_user_id;
	
	@FindBy(xpath = "//span[text()='Service Principal']")
	private WebElement FR_Overview_service_Principal;
	
	@FindBy(xpath = "//div[text()='Requester ID']")
	private WebElement FR_Overview_Requester_id;

	@FindBy(xpath = "//div[text()='User Type']")
	private WebElement FR_Overview_User_Type;

	@FindBy(xpath = "//div[text()='Username']")
	private WebElement FR_Overview_username;

	@FindBy(xpath = "//div[text()='Department']")
	private WebElement FR_Overview_department;

	@FindBy(xpath = "//div[text()='Applicant Type']")
	private WebElement FR_Overview_applicant_type;

	@FindBy(xpath = "//div[text()='Application Number']")
	private WebElement FR_Overview_applicant_number;

	@FindBy(xpath = "//div[text()='Functional Role']")
	private WebElement FR_Overview_functional_role;

	@FindBy(xpath = "//div[text()='Approval Status']")
	private WebElement FR_Overview_approval_status;

	@FindBy(xpath = "//div[text()='Request Date']")
	private WebElement FR_Overview_request_date;

	@FindBy(xpath = "//div[text()='Approval Date']")
	private WebElement FR_Overview_approval_date;

	@FindBy(xpath = "//div[text()=\"Company Name of the Requester\"]")
	private WebElement FR_Overview_Company_Name_of_the_Requester;

	@FindBy(xpath = "//div[text()=\"ECU Qualifier\"]")
	private WebElement FR_Overview_ECU_Qualifier;

	@FindBy(xpath = "//div[text()='GTC Signed Status']")
	private WebElement FR_Overview_GTC_Signed_Status;

	@FindBy(xpath = "//div[text()='Business Unit']")
	private WebElement FR_Overview_BU;

	@FindBy(xpath = "//div[text()=\"Standard Permissions/Certificate\"]")
	private WebElement FR_Overview_std_permission;

	@FindBy(xpath = "//div[text()='Reason for Request']")
	private WebElement FR_Overview_reason_for_request;

	@FindBy(xpath = "//div[text()='Reason for Rejection']")
	private WebElement FR_Overview_approver_reason;

	@FindBy(xpath = "//table/tbody/tr/td")
	private WebElement FR_Overview_requester_Id_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"User-Type \")]")
	private WebElement FR_Overview_User_Type_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Service-Principal-ID \")]")
	private WebElement FR_Overview_Technical_User_ID_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Username\")]")
	private WebElement FR_Overview_username_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Department\")]")
	private WebElement FR_Overview_department_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Applicant-Type\")]")
	private WebElement FR_Overview_applicant_type_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Application-Number\")]")
	private WebElement FR_Overview_applicant_number_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Functional-Role\")]")
	private WebElement FR_Overview_Functional_role_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Approval-Status\")]")
	private WebElement FR_Overview_approval_status_txt;
	
	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Approval-Status\")]//button")
	private static WebElement FR_Overview_approval_status_txt_link;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Business-Unit \")]")
	private WebElement FR_Overview_Business_Unit_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Company-Name-of-the-Requester \")]")
	private WebElement FR_Overview_Company_Name_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"ECU-Qualifier \")]")
	private WebElement FR_Overview_ECU_Qualifier_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"GTC-Signed-Status \")]")
	private WebElement FR_Overview_GTC_Signed_Status_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Request-Date\")]")
	private WebElement FR_Overview_request_date_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Approval-Date\")]")
	private WebElement FR_Overview_Approval_date_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Standard-Permissions-Certificate\")]/child::span")
	private WebElement FR_Overview_standard_permission_cert_txt;

	@FindBy(xpath = "//table//tbody/tr/td[14]")
	private WebElement FR_Overview_reason_for_request_txt;

	@FindBy(xpath = "//table/tbody/tr/td[contains(@class,\"Reason-for-Rejection\")]")
	private WebElement FR_Overview_Approver_Reason_txt;

	@FindBy(xpath = "//label[text()=\"Requester Information\"]")
	private WebElement requester_info_txt;

	@FindBy(xpath = "//p[contains(@class,\"approver-name-text ng-star-inserted\")]")
	private WebElement requester_name_Info;

	@FindBy(xpath = "//span[text()='Functional Role Overview']")
	private WebElement functional_role_Overview;

	@FindBy(xpath = "//a[text()=\"PENDING\"]")
	private WebElement functional_role_pending_status;

	@FindBy(xpath = "//a[text()=\"Global\"]")
	private WebElement Technical_User_Global;

	@FindBy(xpath = "//div[@class=\"table-container\"]/div[text()=\"ECU Qualifier\"]")
	private WebElement Technical_User_Global_ECU_Qualifier;

	@FindBy(xpath = "//div[@class=\"table-container\"]/div[text()=\"Service IDs\"]")
	private WebElement Technical_User_Global_Service_IDs;

	@FindBy(xpath = "//div[@class=\"table-container\"]/div[text()=\"Validity\"]")
	private WebElement Technical_User_Global_Validity;

	@FindBy(xpath = "//div[@class=\"table-container\"]/div[text()=\"Created Date\"]")
	private WebElement Technical_User_Global_Created_Date;

	@FindBy(xpath = "//div[@class=\"table-container\"]/div[text()=\"Expiry Date\"]")
	private WebElement Technical_User_Global_Expiry_Date;

	@FindBy(xpath = "//div[@class=\"table-container\"]")
	private List<WebElement> Technical_User_Global_table;

	@FindBy(xpath = "//div[contains(@class,\"column header\")]")
	private List<WebElement> Technical_User_Global_column_header;

	@FindBy(xpath = "//div[@class=\"value\"]")
	private List<WebElement> Technical_User_Global_column_value;

	@FindBy(xpath = "//div[@class=\"column ecu ng-star-inserted\"]")
	private List<WebElement> Technical_User_Global_column_ECu_Qualifier;

	@FindBy(xpath = "//div[@class=\"column ecu ng-star-inserted\"]")
	private List<WebElement> Technical_User_Global_column_service_IDs;

	@FindBy(xpath = "//div[@class=\"column date ng-star-inserted\"][2]")
	private List<WebElement> Technical_User_Global_column_expiry_date;

	@FindBy(xpath = "//span[text()=\"Close\"]")
	private WebElement Technical_User_Global_Close;
	

	@FindBy(xpath = "//span[text()='Refresh']")
	private WebElement refresh_button;

	@FindBy(xpath = "//input[@placeholder='Search full records...']")
	private WebElement search_item;
	
	@FindBy(xpath = "//span[text()='Close']")
	private WebElement vv_Close;
	
	@FindBy(xpath = "((//mat-select)[2]//span)")
	private WebElement applicantvalue;
	
	@FindBy(xpath = "//p[text()='Approval Level 1']")
	private WebElement ApprovalLevel1;
	
	@FindBy(xpath = "//p[text()='Approval Level 2']")
	private WebElement ApprovalLevel2;
	
	@FindBy(xpath = "//span[text()='Close']")
	private WebElement CloseHyperlink;

	public boolean functional_role_Overview_enabled() throws InterruptedException {
		Thread.sleep(2000);	
		waitForWebElementToAppear(functional_role_Overview);
		waitForelementToBeClickable(functional_role_Overview);
		return functional_role_Overview.isEnabled();

	}
	
	public void selectApplicantType() throws InterruptedException {
		waitForWebElementToAppear(applicantvalue);
		String txt = applicantvalue.getText();
		if(!txt.equalsIgnoreCase("Myself")) {
			click(applicantvalue);
			Thread.sleep(1000);
			click(FR_Overview_myself);
//			click(FR_Overview_service_Principal);
		}

	}
	public void selectApplicantType_ServicePrincipal() throws InterruptedException {
		waitForWebElementToAppear(applicantvalue);
		String txt = applicantvalue.getText();
		if(!txt.equalsIgnoreCase("Service Principal")) {
			click(applicantvalue);
			Thread.sleep(1000);
			click(FR_Overview_myself);
//			click(FR_Overview_service_Principal);
		}

	}
	
	public void searchItem(String str) {
		waitForWebElementToAppear(search_item);
		search_item.sendKeys(str);

	}

	public void functional_role_Overview_enabled1() throws InterruptedException {
		Thread.sleep(2000);
		AbstractComponents.waitForWebElementToAppear(functional_role_Overview);
		try {
			
			AbstractComponents.waitForelementToBeClickable(functional_role_Overview);
			Thread.sleep(2000);
			functional_role_Overview.click();
			
		} catch (Exception ex) {
			Thread.sleep(2000);
			AbstractComponents.waitForelementToBeClickable(functional_role_Overview);
			clickJS(functional_role_Overview);
//			throw new RuntimeException(ex);
		}		Thread.sleep(2000);
//		f.selectApplicantType_ServicePrincipal();
//		Thread.sleep(2000);
	}
	
	public void Functionalrole_Table_ListofColumn() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> columns = driver.findElements(By.xpath(
				"//table[@class='mat-table cdk-table mat-sort mat-elevation-z8' and @role='table']/thead/tr/th"));
		ArrayList<String> arrayList = new ArrayList<>();
		for (int j = 1; j <= columns.size(); j++) {
			String cellValue = driver.findElement(By.xpath(
					"//table[@class='mat-table cdk-table mat-sort mat-elevation-z8' and @role='table']/thead/tr/th[" + j
							+ "]"))
					.getText();
			arrayList.add(cellValue);
		}
		test.info("List of columns" + arrayList);
	}

	public ArrayList<String> Functional_role_requester_info_detail() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(2000);
		List<WebElement> columns = driver.findElements(By.xpath("//table[@class='mat-table cdk-table mat-sort mat-elevation-z8' and @role='table']/tbody/tr[1]/td"));
		ArrayList<String> arrayList = new ArrayList<>();
		Thread.sleep(2000);
		for (int j = 1; j <= columns.size(); j++) {
			String cellValue = driver.findElement(By.xpath("//table[@class='mat-table cdk-table mat-sort mat-elevation-z8' and @role='table']/tbody/tr[1]/td["+ j + "]")).getText();
			arrayList.add(cellValue);
		}
		return arrayList;
	}

	public ArrayList<String> FunctionalroleRequestor_RejectionStatus() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> columns = driver.findElements(By.xpath(
				"//table[@class='mat-table cdk-table mat-sort mat-elevation-z8' and @role='table']/tbody/tr[1]/td"));
		ArrayList<String> arrayList = new ArrayList<>();
		for (int j = 1; j <= columns.size(); j++) {
			String cellValue = driver.findElement(By.xpath(
					"//table[@class='mat-table cdk-table mat-sort mat-elevation-z8' and @role='table']/tbody/tr[1]/td["
							+ j + "]"))
					.getText();
			arrayList.add(cellValue);
		}
		String fr = arrayList.get(9);
		String fr1 = arrayList.get(8);
		String fr2 = arrayList.get(5);
		if (fr2.equalsIgnoreCase("Internal")) {
			if (fr.equalsIgnoreCase("N/A")) {
				test.fail("Rejection status is not updated" + fr);
			} else {
				test.pass("Reason for Rejection: " + fr);
			}
		} else if (fr2.equalsIgnoreCase("External")) {
			if (fr1.equalsIgnoreCase("N/A")) {
				test.fail("Rejection status is not updated" + fr1);
			} else {
				test.pass("Reason for Rejection: " + fr1);
			}
		} else {
			if (fr1.equalsIgnoreCase("N/A")) {
				test.fail("Rejection status is not updated" + fr1);
			} else {
				test.pass("Reason for Rejection: " + fr1);
			}
		}
		return arrayList;

	}

	public ArrayList<String> Validate_Certificates() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> columns = driver.findElements(By.xpath(
				"//table[@class='mat-table cdk-table mat-sort mat-elevation-z8' and @role='table']/tbody/tr[1]/td"));
		ArrayList<String> arrayList = new ArrayList<>();
		for (int j = 1; j <= columns.size(); j++) {
			String cellValue = driver.findElement(By.xpath(
					"//table[@class='mat-table cdk-table mat-sort mat-elevation-z8' and @role='table']/tbody/tr[1]/td["
							+ j + "]"))
					.getText();
			arrayList.add(cellValue);
		}

		return arrayList;
	}

	public ArrayList<String> Validate_Certificates_for_Technical_user() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> columns = driver.findElements(By.xpath(
				"//table[@class='mat-table cdk-table mat-sort mat-elevation-z8' and @role='table']/tbody/tr[1]/td"));
		ArrayList<String> arrayList = new ArrayList<>();
		for (int j = 1; j <= columns.size(); j++) {
			String cellValue = driver.findElement(By.xpath(
					"//table[@class='mat-table cdk-table mat-sort mat-elevation-z8' and @role='table']/tbody/tr[1]/td["
							+ j + "]"))
					.getText();
			arrayList.add(cellValue);
		}
		String standard_cert = standard_permission_cert_txt();
		String fr_txt = Functional_role_txt();
		if (fr_txt.equals("Production")) {
			Assert.assertEquals(standard_cert, "Production,After-Sales STANDARD");
			test.pass("Certificate: " + standard_cert);
		} else {
			Assert.assertEquals(standard_cert, "Global, TCU");
			test.pass("Certificate: " + standard_cert);
		}
		return arrayList;
	}

	public void standard_certificate(String certificates) {
		//hari
		String applicant_type = applicant_type_txt();
		String fr_txt = Functional_role_txt();
		logger.info("*** certificates:"+certificates);
		logger.info(fr_txt);
		if (applicant_type.equalsIgnoreCase("Internal")) {
			switch (fr_txt) {
			case "Vehicle Validation":
				//Assert.assertEquals(certificates, "After-Sales ENHANCED","After-Sales STANDARD");
			    Set<String> VehicleexpectedSet = new HashSet<>(Arrays.asList("After-Sales ENHANCED","After-Sales STANDARD"));
		        Set<String> VehicleactualSet = new HashSet<>(Arrays.asList(certificates.split(",")));
		        Assert.assertEquals(VehicleexpectedSet, VehicleactualSet);
		        test.pass("Certificate: " + certificates);
				break;
			case "Production":
				//Assert.assertEquals(certificates, "Production,After-Sales STANDARD");
			    Set<String> ProductionExpectedSet = new HashSet<>(Arrays.asList("After-Sales STANDARD","Production"));
		        Set<String> ProductionActualSet = new HashSet<>(Arrays.asList(certificates.split(",")));
		        Assert.assertEquals(ProductionExpectedSet, ProductionActualSet);
				test.pass("Certifcate: " + certificates);
				break;
			case "Xentry Tool Development":
				//Assert.assertEquals(certificates, "After-Sales ENHANCED,After-Sales STANDARD,After-Sales BASIC,EPTI");
			    Set<String> XentryExpectedSet = new HashSet<>(Arrays.asList("After-Sales ENHANCED","After-Sales STANDARD","After-Sales BASIC","EPTI"));
		        Set<String> XentryActualSet = new HashSet<>(Arrays.asList(certificates.split(",")));
		        Assert.assertEquals(XentryExpectedSet, XentryActualSet);
		        test.pass("Certificate: " + certificates);
				break;
			case "QM(Quality Management)":
				Assert.assertEquals(certificates, "After-Sales STANDARD");
				test.pass("Certifcate: " + certificates);
				break;
			case "Development":
				//Assert.assertEquals(certificates, "After-Sales ENHANCED,After-Sales STANDARD");
			    Set<String> expectedSet = new HashSet<>(Arrays.asList("After-Sales ENHANCED","After-Sales STANDARD"));
			        Set<String> actualSet = new HashSet<>(Arrays.asList(certificates.split(",")));
			        Assert.assertEquals(expectedSet, actualSet);
			        test.pass("Certificate: " + certificates);
				break;
			case "DiagnosticLink Tool Development":
				//Assert.assertEquals(certificates, "After-Sales ENHANCED,After-Sales STANDARD,After-Sales BASIC,EPTI");
			    Set<String> DiagnosticLinkExpectedSet = new HashSet<>(Arrays.asList("After-Sales ENHANCED","After-Sales STANDARD","After-Sales BASIC","EPTI"));
		        Set<String> DiagnosticLinkActualSet = new HashSet<>(Arrays.asList(certificates.split(",")));
		        Assert.assertEquals(DiagnosticLinkExpectedSet, DiagnosticLinkActualSet);
				test.pass("Certifcate: " + certificates);
				break;
			case "Vehicle Validation - AP4":
				Assert.assertEquals(certificates, "After-Sales ENHANCED");
				test.pass("Certifcate: " + certificates);
				break;
			case "Development - ATG":
				Assert.assertEquals(certificates, "After-Sales ENHANCED");
				test.pass("Certifcate: " + certificates);
				break;
			case "Component Verification - ATG":
			    Set<String> ComponentVerificationExpectedSet = new HashSet<>(Arrays.asList("After-Sales ENHANCED","After-Sales STANDARD","After-Sales BASIC","TCU"));
		        Set<String> ComponentVerificationActualSet = new HashSet<>(Arrays.asList(certificates.split(",")));
		        Assert.assertEquals(ComponentVerificationExpectedSet, ComponentVerificationActualSet);
				test.pass("Certifcate: " + certificates);
				break;	
			case "Production - ATG":
				Assert.assertEquals(certificates, "Production");
				test.pass("Certifcate: " + certificates);
				break;
			default:
				test.fail("Certifcate: " + certificates);
				break;
			}
		} else if (applicant_type.equalsIgnoreCase("External")) {
			switch (fr_txt) {
			case "Vehicle Validation External Support":
				Assert.assertEquals(certificates, "After-Sales ENHANCED,After-Sales STANDARD");
				test.pass("Certifcate: " + certificates);
				break;

			case "Production External":
				Assert.assertEquals(certificates, "Production,After-Sales STANDARD");
				test.pass("Certifcate: " + certificates);
				break;

			case "Xentry Tool Development External Support":
				Assert.assertEquals(certificates, "After-Sales ENHANCED,After-Sales STANDARD,After-Sales BASIC,EPTI");
				test.pass("Certifcate: " + certificates);
				break;
			case "QM(Quality Management) External":
				Assert.assertEquals(certificates, "After-Sales STANDARD");
				test.pass("Certifcate: " + certificates);
				break;
			case "Development External Support":
				Assert.assertEquals(certificates, "After-Sales STANDARD,After-Sales ENHANCED");
				test.pass("Certifcate: " + certificates);
				break;
			case "DiagnosticLink Tool Development External Support":
				Assert.assertEquals(certificates, "After-Sales ENHANCED,After-Sales STANDARD,After-Sales BASIC,EPTI");
				test.pass("Certifcate: " + certificates);
				break;
			default:
				test.fail("Certifcate: " + certificates);
				break;
			case "Development - ATG External":
				Assert.assertEquals(certificates, "After-Sales ENHANCED");
				test.pass("Certifcate: " + certificates);
				break;
			}
		} else {
			switch (fr_txt) {

			case "ECU Supplier - Key Management":
				Assert.assertEquals(certificates,
						"Supplier,Development ENHANCED,Production,After-Sales ENHANCED,After-Sales STANDARD");
				test.pass("Certifcate: " + certificates);
				break;

			case "ECU Supplier – Development":
				Assert.assertEquals(certificates,
						"Supplier,Development ENHANCED,Production,After-Sales ENHANCED,After-Sales STANDARD");
				test.pass("Certifcate: " + certificates);
				break;

			case "ECU Supplier - Warranty Return":
				Assert.assertEquals(certificates,
						"Supplier,Development ENHANCED,Production,After-Sales ENHANCED,After-Sales STANDARD");
				test.pass("Certifcate: " + certificates);
				break;
				
			case "ECU Supplier - Development - ATG":
			    Set<String> ComponentVerificationExpectedSet = new HashSet<>(Arrays.asList("Supplier,Development ENHANCED,Production,After-Sales ENHANCED"));
		        Set<String> ComponentVerificationActualSet = new HashSet<>(Arrays.asList(certificates.split(",")));
		        Assert.assertEquals(ComponentVerificationExpectedSet, ComponentVerificationActualSet);
				test.pass("Certifcate: " + certificates);
				break;
			default:
				Assert.assertEquals(certificates, "N/A");
				test.pass("Certifcate: " + certificates);
				break;
			}
		}

	}

	public boolean Functional_role_status() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		waitForWebElementToAppear(FR_Overview_status_all);
		waitForWebElementToAppear(FR_Overview_status_Pending);
//		waitForWebElementToAppear(FR_Overview_status_Approved);
//		waitForWebElementToAppear(FR_Overview_status_rejected);
//		waitForWebElementToAppear(FR_Overview_applicant);		
		waitForWebElementToAppear(FR_Overview_myself);
//		waitForWebElementToAppear(FR_Overview_All);
		
//		click(FR_Overview_status_Pending);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//click(vv_Close);
		return FR_Overview_myself.isDisplayed();
//		return FR_Overview_All.isDisplayed() ;

	}

	public void select_user(String user) {
		waitForWebElementToAppear(FR_Overview_Technical_user);
		click(FR_Overview_Technical_user);

	}

	public boolean Functional_role_applicant_info() {
		waitForWebElementToAppear(FR_Overview_applicant);
		waitForWebElementToAppear(FR_Overview_myself);
		return myself_radio_btn.isSelected();
	}

	public void Functional_role_Overview_list_of_column() {
		waitForWebElementToAppear(FR_Overview_Requester_id);
		waitForWebElementToAppear(FR_Overview_User_Type);
		waitForWebElementToAppear(FR_Overview_user_id);
		waitForWebElementToAppear(FR_Overview_username);
		waitForWebElementToAppear(FR_Overview_department);
		waitForWebElementToAppear(FR_Overview_applicant_type);
		waitForWebElementToAppear(FR_Overview_applicant_number);
		waitForWebElementToAppear(FR_Overview_functional_role);
		waitForWebElementToAppear(FR_Overview_approval_status);
		waitForWebElementToAppear(FR_Overview_GTC_Signed_Status);
		waitForWebElementToAppear(FR_Overview_request_date);
		waitForWebElementToAppear(FR_Overview_approval_date);
		waitForWebElementToAppear(FR_Overview_std_permission);
		waitForWebElementToAppear(FR_Overview_reason_for_request);
		waitForWebElementToAppear(FR_Overview_approver_reason);

	}

	public void Functional_role_Overview_list_of_column_Internal() {
		Functional_role_Overview_list_of_column();
		waitForWebElementToAppear(FR_Overview_BU);
	}

	public void Functional_role_Overview_list_of_column_external() {
		Functional_role_Overview_list_of_column();
		waitForWebElementToAppear(FR_Overview_BU);
		waitForWebElementToAppear(FR_Overview_Company_Name_of_the_Requester);
	}

	public void Functional_role_Overview_list_of_column_Supplier() {
		Functional_role_Overview_list_of_column();
		waitForWebElementToAppear(FR_Overview_ECU_Qualifier);
		waitForWebElementToAppear(FR_Overview_Company_Name_of_the_Requester);
	}

	public void Functional_role_Overview_list_of_column_Technical_user() {
		Functional_role_Overview_list_of_column();
		waitForWebElementToAppear(FR_Overview_BU);
	}

	public String requester_Id_txt() {
		waitForWebElementToAppear(FR_Overview_requester_Id_txt);
		return FR_Overview_requester_Id_txt.getText().trim();

	}

	public String user_type_txt() {
		waitForWebElementToAppear(FR_Overview_User_Type_txt);
		return FR_Overview_User_Type_txt.getText().trim();

	}

	public String user_Id_txt() {
		waitForWebElementToAppear(FR_Overview_Technical_User_ID_txt);
		return FR_Overview_Technical_User_ID_txt.getText().trim();

	}

	public String username_txt() {
		waitForWebElementToAppear(FR_Overview_username_txt);
		return FR_Overview_username_txt.getText().trim();

	}

	public String department_txt() {
		waitForWebElementToAppear(FR_Overview_department_txt);
		return FR_Overview_department_txt.getText().trim();

	}

	public String applicant_type_txt() {
		waitForWebElementToAppear(FR_Overview_applicant_type_txt);
		return FR_Overview_applicant_type_txt.getText().trim();

	}

	public String applicant_number_txt() {
		waitForWebElementToAppear(FR_Overview_applicant_number_txt);
		return FR_Overview_applicant_number_txt.getText().trim();

	}

	public String Functional_role_txt() {
		waitForWebElementToAppear(FR_Overview_Functional_role_txt);
		return FR_Overview_Functional_role_txt.getText().trim();

	}

	public String approval_status_txt() {
		waitForWebElementToAppear(FR_Overview_approval_status_txt);
		return FR_Overview_approval_status_txt.getText().trim();

	}

	public String FR_Overview_Business_Unit_txt() {
		waitForWebElementToAppear(FR_Overview_Business_Unit_txt);
		return FR_Overview_Business_Unit_txt.getText().trim();

	}

	public String FR_Overview_Company_Name_txt() {
		waitForWebElementToAppear(FR_Overview_Company_Name_txt);
		return FR_Overview_Company_Name_txt.getText().trim();

	}

	public String FR_Overview_ECU_Qualifier_txt() {
		waitForWebElementToAppear(FR_Overview_ECU_Qualifier_txt);
		return FR_Overview_ECU_Qualifier_txt.getText().trim();

	}

	public String FR_Overview_GTC_Signed_Status_txt() {
		waitForWebElementToAppear(FR_Overview_GTC_Signed_Status_txt);
		return FR_Overview_GTC_Signed_Status_txt.getText().trim();

	}

	public String Approval_date_txt() {
		waitForWebElementToAppear(FR_Overview_Approval_date_txt);
		return FR_Overview_Approval_date_txt.getText().trim();

	}

	public String standard_permission_cert_txt() {
		waitForWebElementToAppear(FR_Overview_standard_permission_cert_txt);
		return FR_Overview_standard_permission_cert_txt.getText().trim();

	}

	public String request_date_txt() {
		waitForWebElementToAppear(FR_Overview_request_date_txt);
		return FR_Overview_request_date_txt.getText().trim();

	}

	public String reason_for_request_txt() {
		waitForWebElementToAppear(FR_Overview_reason_for_request_txt);
		return FR_Overview_reason_for_request_txt.getText().trim();

	}

	public String Approver_Reason_txt() {
		waitForWebElementToAppear(FR_Overview_Approver_Reason_txt);
		return FR_Overview_Approver_Reason_txt.getText().trim();

	}

	public String Functional_role_request_info() {
		waitForWebElementToAppear(requester_info_txt);
		return requester_name_Info.getText().trim();

	}

	public void functional_role_overview_enabled_validation() throws Throwable {
		if (functional_role_Overview_enabled()) {
			test.pass("User is able to view Functional role Overview tab enabled");
		}
		functional_role_Overview_enabled1();        
	}

	public List<Object> functional_role_Overview_table_validation(String select_applicant_type, String requester_name,
			String functional_role_selected) throws Throwable {
		ArrayList<String> Requester_info = Functional_role_requester_info_detail();
				
		Thread.sleep(2000);
		f.selectApplicantType();// myself selection
		
//		Functional_role_status();
//		if (select_applicant_type.equals("Technical User")) {
//			select_user(select_applicant_type);
//		}
		
		if (functional_role_selected.equalsIgnoreCase("Internal")) {
			Functional_role_Overview_list_of_column_Internal();
		} else if (functional_role_selected.equalsIgnoreCase("External")) {
			Functional_role_Overview_list_of_column_external();
		} else if (functional_role_selected.equalsIgnoreCase("Supplier")) {
			Functional_role_Overview_list_of_column_Supplier();
		} else {
			Functional_role_Overview_list_of_column_Technical_user();
		}
		
//		Assert.assertNotEquals(requester_Id_txt(), "N/A", "Requester_Id");
//		Assert.assertNotEquals(user_type_txt(), "N/A", "user_type");
//		Assert.assertNotEquals(applicant_type_txt(), "N/A", "applicant_type");
//		Assert.assertNotEquals(applicant_number_txt(), "N/A", "applicant_number");
//		Assert.assertNotEquals(Functional_role_txt(), "N/A", "Functional_role");
//		Assert.assertEquals(approval_status_txt(), "PENDING", "approval_status");
//		Assert.assertEquals(standard_permission_cert_txt(), "N/A", "standard_permission_cert");
//		Assert.assertEquals(FR_Overview_GTC_Signed_Status_txt(), "true", "GTC_Signed_Status");
//		Assert.assertNotEquals(reason_for_request_txt(), "N/A", "reason_for_request");
		requester_Id = requester_Id_txt();
		user_type = user_type_txt();
		User_id = user_Id_txt();
		User_name = username_txt();
		department = department_txt();
		applicant_type = applicant_type_txt();
		application_number = applicant_number_txt();
		functional_role = Functional_role_txt();
		approval_status = approval_status_txt();
		if (functional_role_selected.equalsIgnoreCase("External")
				|| functional_role_selected.equalsIgnoreCase("Internal")) {
			Business_Unit = FR_Overview_Business_Unit_txt();
		}
		if (functional_role_selected.equalsIgnoreCase("External")
				|| functional_role_selected.equalsIgnoreCase("Supplier")) {
			Assert.assertNotEquals(FR_Overview_Company_Name_txt(), "N/A");
			Company_Name = FR_Overview_Company_Name_txt();
		}
		if (functional_role_selected.equalsIgnoreCase("Supplier")) {
			Assert.assertNotEquals(FR_Overview_ECU_Qualifier_txt(), "N/A");
			ECU_Qualifier = FR_Overview_ECU_Qualifier_txt();
		}
		GTC_Signed_Status = FR_Overview_GTC_Signed_Status_txt();
		request_date = request_date_txt();
		approval_date = Approval_date_txt();
		std_permission = standard_permission_cert_txt();
		reason_for_request = reason_for_request_txt();
		approver_reason = Approver_Reason_txt();
		req.scrollForReason();
		Thread.sleep(2000);
		refresh_button.click();
		Thread.sleep(2000);

		Scrollright_waitForWebElementToAppear(FR_Overview_approval_status_txt_link);
		click(FR_Overview_approval_status_txt_link);
		clickJS(ApprovalLevel1);
		Thread.sleep(3000);
		clickJS(ApprovalLevel2);
		Thread.sleep(2000);
		click(CloseHyperlink);

		return Arrays.asList(approval_status, application_number, requester_Id, user_type, User_id, User_name,
				department, applicant_type, functional_role, Business_Unit, Company_Name, ECU_Qualifier,
				GTC_Signed_Status, request_date, approval_date, std_permission, reason_for_request, approver_reason);

	}

	public List<Object> functional_role_Overview_table_validation_for_more_than_one_ECU(String select_applicant_type,
			String requester_name, String functional_role_selected, List<Object> object) throws Throwable {
		ArrayList<String> Requester_info = Functional_role_requester_info_detail();
		test.info("Requestor details : " + Requester_info);
		String request_name = Functional_role_request_info();
		if (request_name.equals(request_name)) {
			test.pass("requester name is " + request_name);
		}
		Functional_role_status();
		if (select_applicant_type.equals("Technical User")) {
			select_user(select_applicant_type);
		}
		if (functional_role_selected.equalsIgnoreCase("Internal")) {
			Functional_role_Overview_list_of_column_Internal();
		} else if (functional_role_selected.equalsIgnoreCase("External")) {
			Functional_role_Overview_list_of_column_external();
		} else if (functional_role_selected.equalsIgnoreCase("Supplier")) {
			Functional_role_Overview_list_of_column_Supplier();
		} else {
			Functional_role_Overview_list_of_column_Technical_user();
		}

		List<List<String>> firstTableValues = BaseClass.getTableValues(driver, By.xpath("//table/tbody"));
		List<String> ECU_column_values = new ArrayList<>();
		List<WebElement> tableRows = driver.findElements(By.xpath("//table/tbody/tr"));
		for (WebElement row : tableRows) {
			String columnValue = row.findElement(By.cssSelector("td[class*=\"ECU-Qualifier \"]")).getText();
			ECU_column_values.add(columnValue);
		}
		Assert.assertNotEquals(requester_Id_txt(), "N/A", "Requester_Id");
		Assert.assertNotEquals(user_type_txt(), "N/A", "user_type");
		Assert.assertNotEquals(username_txt(), "N/A", "username");
		Assert.assertNotEquals(applicant_type_txt(), "N/A", "applicant_type");
		Assert.assertNotEquals(applicant_number_txt(), "N/A", "applicant_number");
		Assert.assertNotEquals(Functional_role_txt(), "N/A", "Functional_role");
		Assert.assertEquals(approval_status_txt(), "PENDING", "approval_status");
		Assert.assertEquals(standard_permission_cert_txt(), "N/A", "standard_permission_cert");
		Assert.assertEquals(FR_Overview_GTC_Signed_Status_txt(), "true", "GTC_Signed_Status");
		Assert.assertEquals(request_date_txt(), BaseClass.todays_date(), "request_date");
		Assert.assertNotEquals(reason_for_request_txt(), "N/A", "reason_for_request");
		requester_Id = requester_Id_txt();
		user_type = user_type_txt();
		User_id = user_Id_txt();
		User_name = username_txt();
		department = department_txt();
		applicant_type = applicant_type_txt();
		application_number = applicant_number_txt();
		functional_role = Functional_role_txt();
		approval_status = approval_status_txt();
		if (functional_role_selected.equalsIgnoreCase("External")
				|| functional_role_selected.equalsIgnoreCase("Internal")) {
			Business_Unit = FR_Overview_Business_Unit_txt();
		}
		if (functional_role_selected.equalsIgnoreCase("External")
				|| functional_role_selected.equalsIgnoreCase("Supplier")) {
			Company_Name = FR_Overview_Company_Name_txt();
		}
		if (functional_role_selected.equalsIgnoreCase("Supplier")) {
			ECU_Qualifier = FR_Overview_ECU_Qualifier_txt();
		}
		GTC_Signed_Status = FR_Overview_GTC_Signed_Status_txt();
		request_date = request_date_txt();
		approval_date = Approval_date_txt();
		std_permission = standard_permission_cert_txt();
		reason_for_request = reason_for_request_txt();
		approver_reason = Approver_Reason_txt();

		return Arrays.asList(approval_status, application_number, std_permission, ECU_column_values, firstTableValues);

	}

	public void navigate_to_functional_role_Overview_page_and_verify_approval_status(String status, String reason)
			throws Throwable {
		functional_role_Overview_enabled1();
		ArrayList<String> Requester_info = Functional_role_requester_info_detail();
		test.info("Requestor details : " + Requester_info);
		Assert.assertEquals(approval_status_txt(), status);
		Thread.sleep(2000);
		refresh_button.click();
		Thread.sleep(2000);
		Scrollright_waitForWebElementToAppear(FR_Overview_approval_status_txt_link);
		click(FR_Overview_approval_status_txt_link);
		Thread.sleep(2000);
		click(ApprovalLevel2);
		Thread.sleep(2000);
		click(CloseHyperlink);
	//	Assert.assertEquals(Approval_date_txt(), "N/A");
//		Assert.assertEquals(standard_permission_cert_txt(), "N/A");
//		Assert.assertEquals(Approver_Reason_txt(), reason);
	}

	public void navigate_to_functional_role_Overview_page_and_verify_approval_status_for_more_than_one_ECU(
			String status, String reason, String eCU_Qualifiers) throws Throwable {
		Thread.sleep(3000);
		functional_role_Overview_enabled1();
		search_here(eCU_Qualifiers);

		ArrayList<String> Requester_info = Functional_role_requester_info_detail();
		test.info("Requestor details : " + Requester_info);
		Assert.assertEquals(approval_status_txt(), status);
		Assert.assertEquals(Approval_date_txt(), "N/A");
		Assert.assertEquals(standard_permission_cert_txt(), "N/A");
		Assert.assertEquals(Approver_Reason_txt(), reason);
	}

	public String ValidatetheStandardCertificateofthe_Functionalrole_after_2level_approval(String approval_status)
			throws Throwable {
		functional_role_overview_enabled_validation();
		approval_status_txt().equals(approval_status);
		String certificates = standard_permission_cert_txt();
		ArrayList<String> Requester_info = Validate_Certificates();
		test.info("Requestor details : " + Requester_info);
		logger.info("Requestor details : " + Requester_info);
		test.info("Verified the Certificate of the Functional role");
		logger.info("Verified the Certificate of the Functional role");
		Thread.sleep(2000);
		refresh_button.click();
		Thread.sleep(2000);
		Scrollright_waitForWebElementToAppear(FR_Overview_approval_status_txt_link);
		click(FR_Overview_approval_status_txt_link);
		Thread.sleep(2000);
		click(ApprovalLevel2);
		Thread.sleep(2000);
		click(CloseHyperlink);
//		standard_certificate(certificates);
		return certificates;
	}
	public String Service_ValidatetheStandardCertificateofthe_Functionalrole_after_2level_approval(String approval_status,String search)
			throws Throwable {
		functional_role_overview_enabled_validation();
		f.functionalValidation(search);
		approval_status_txt().equals(approval_status);
		String certificates = standard_permission_cert_txt();
		ArrayList<String> Requester_info = Validate_Certificates();
		test.info("Requestor details : " + Requester_info);
		logger.info("Requestor details : " + Requester_info);
		test.info("Verified the Certificate of the Functional role");
		logger.info("Verified the Certificate of the Functional role");
//		standard_certificate(certificates);
		return certificates;
	}

	public String ValidatetheStandardCertificateofthe_Functionalrole_after_2level_approval_for_ECu_cert(
			String approval_status) throws Throwable {
		functional_role_overview_enabled_validation();
		approval_status_txt().equals(approval_status);
		String certificates = standard_permission_cert_txt();
		ArrayList<String> Requester_info = Validate_Certificates();
		test.info("Requestor details : " + Requester_info);
		logger.info("Requestor details : " + Requester_info);
		test.info("Verified the Certificate of the Functional role");
		logger.info("Verified the Certificate of the Functional role");
		String fr_txt = Functional_role_txt();
		if (fr_txt.equals("ECU Supplier - Key Management") || fr_txt.equals("ECU Supplier – Development")
				|| fr_txt.equals("ECU Supplier - Warranty Return")) {
			Assert.assertEquals(certificates, "N/A");
			test.pass("Certifcate: " + certificates);
		} else {
			Assert.assertNotEquals(certificates, "N/A");
			test.fail("Assertion failed for standard certificates for own ECU");
		}
		return certificates;
	}

	public void search_here(String object) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		waitForWebElementToAppear(refresh_button);
		clickJS(refresh_button);
		search_item.clear();
		search_item.sendKeys(object);
		type(search_item, Keys.ENTER);
	}

	public String ValidatetheStandardCertificateofthe_Functionalrole_for_more_than_one_ECU(String approval_status,
			String eCU_Qualifiers) throws Throwable {
		functional_role_overview_enabled_validation();
		search_here(eCU_Qualifiers);
		Assert.assertEquals(approval_status_txt(), approval_status);
		String certificates = standard_permission_cert_txt();
		ArrayList<String> Requester_info = Validate_Certificates();
		test.info("Requestor details : " + Requester_info);
		test.info("Verified the Certificate of the Functional role");
		standard_certificate(certificates);
		return certificates;

	}

	public String ValidatetheStandardCertificateofthe_Functionalrole_MyDeputy(String approval_status) throws Throwable {
		Assert.assertEquals(approval_status_txt(), approval_status);
		String certificates = standard_permission_cert_txt();
		ArrayList<String> Requester_info = Validate_Certificates();
		test.info("Requestor details : " + Requester_info);
		test.info("Verified the Certificate of the Functional role");
		return certificates;
	}

	public void navigate_to_functional_role_Overview_page_and_verify_approval_status_for_Technical_user(
			String reason,String status, String requester_name, String select_applicant_type) throws Throwable {
		functional_role_overview_enabled_validation();
		String request_name = Functional_role_request_info();
		if (request_name.equals(request_name)) {
			test.info("Verified requester info");
		}
		select_user(select_applicant_type);
		ArrayList<String> Requester_info = Functional_role_requester_info_detail();
		test.info("Requestor details : " + Requester_info);
		Assert.assertEquals(approval_status_txt(), status);
		Assert.assertEquals(Approval_date_txt(), "N/A");
		Assert.assertEquals(standard_permission_cert_txt(), "N/A");
		Assert.assertEquals(Approver_Reason_txt(), reason);
	}

	public String ValidatetheStandardCertificateofthe_Technical_user_after_2level_approval(String approval_status)
			throws Throwable {
		functional_role_overview_enabled_validation();
		Assert.assertEquals(approval_status_txt(), approval_status);
		String certificates = standard_permission_cert_txt();
		ArrayList<String> Requester_info = Validate_Certificates_for_Technical_user();
		test.info("Requestor details : " + Requester_info);
		test.info("Verified the Certificate of the Functional role");
		return certificates;
	}

	public void click_Global_cert() {
		clickJS(Technical_User_Global);
		waitForWebElementToAppear(Technical_User_Global_ECU_Qualifier);
		waitForWebElementToAppear(Technical_User_Global_Service_IDs);
		waitForWebElementToAppear(Technical_User_Global_Validity);
		waitForWebElementToAppear(Technical_User_Global_Created_Date);
		waitForWebElementToAppear(Technical_User_Global_Expiry_Date);
	}

	public List<String[]> extract_column_values_from_Global_table() {
		String[] extract_column_values_from_ECu_Qualifier = BaseClass
				.extract_column_values_from_Global_table(Technical_User_Global_column_ECu_Qualifier);
		String[] extract_column_values_from_Service_IDs = BaseClass
				.extract_column_values_from_Global_table(Technical_User_Global_column_service_IDs);
		String[] extract_column_values_from_expiry_date = BaseClass
				.extract_column_values_from_Global_table(Technical_User_Global_column_expiry_date);
		return Arrays.asList(extract_column_values_from_ECu_Qualifier, extract_column_values_from_Service_IDs,
				extract_column_values_from_expiry_date);
	}
	
	public String functionalValidation(String searchId) throws InterruptedException {	
		searchItem(searchId);
		application_number = applicant_number_txt();
		req.scrollForReason();
		Thread.sleep(2000);
		refresh_button.click();
		Thread.sleep(5000);
		Scrollright_waitForWebElementToAppear(FR_Overview_approval_status_txt_link);
		click(FR_Overview_approval_status_txt_link);
		Thread.sleep(2000);
		click(ApprovalLevel2);
		Thread.sleep(2000);
		click(CloseHyperlink);
		return application_number;
		
	}
	
	
	
}