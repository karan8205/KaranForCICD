package DAMS.ObjectManager;

import org.openqa.selenium.WebDriver;

import DAMS.PageObjects.ApproverOverview_Page;
import DAMS.PageObjects.Functional_role_page;
import DAMS.PageObjects.GTC_Page;
import DAMS.PageObjects.HomePage;
import DAMS.PageObjects.LoginPage;
import DAMS.PageObjects.MyDeputy_Page;
import DAMS.PageObjects.MyRequest_Page;
import DAMS.PageObjects.NewPermission_Request_Page;
import DAMS.PageObjects.New_Functional_Role_Request_Page;
import DAMS.PageObjects.Onboard_new_ECU_page;
import DAMS.PageObjects.ReadView_Permission;
import DAMS.PageObjects.Request_overview_page;
import DAMS.PageObjects.Special_access_page;
import DAMS.Resources.AbstractComponents;
import DAMS.Resources.BaseClass;

public class PageObjectManager extends AbstractComponents {
	private WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;
	private GTC_Page gtcPage;
	private New_Functional_Role_Request_Page newFunctionalRoleRequest;
	private Functional_role_page functional_role_page;
	private ApproverOverview_Page approverOverview;
	private MyRequest_Page myRequest;
	private NewPermission_Request_Page newPermission_Request;
	private Request_overview_page request_overview;
	private Onboard_new_ECU_page onboard_new_ECU;
	private MyDeputy_Page myDeputy_page;
	private Special_access_page special_access_page;
	private ReadView_Permission read;
	
	public PageObjectManager(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}

	public LoginPage getLoginPage() {

		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;

	}

	public HomePage getHomePage() {

		return (homePage == null) ? homePage = new HomePage(driver) : homePage;

	}

	public GTC_Page getGtcPage() {

		return (gtcPage == null) ? gtcPage = new GTC_Page(driver) : gtcPage;

	}

	public New_Functional_Role_Request_Page getNewFunctionalRoleRequestPage() {

		return (newFunctionalRoleRequest == null)
				? newFunctionalRoleRequest = new New_Functional_Role_Request_Page(driver)
				: newFunctionalRoleRequest;

	}

	public Functional_role_page getfunctional_role_page() {

		return (functional_role_page == null) ? functional_role_page = new Functional_role_page(driver)
				: functional_role_page;

	}

	public ApproverOverview_Page getapproverOverview_page() {

		return (approverOverview == null) ? approverOverview = new ApproverOverview_Page(driver) : approverOverview;

	}

	public MyRequest_Page getmyRequest_Page() {

		return (myRequest == null) ? myRequest = new MyRequest_Page(driver) : myRequest;

	}

	public NewPermission_Request_Page getNewPermission_Request_Page() {

		return (newPermission_Request == null) ? newPermission_Request = new NewPermission_Request_Page(driver)
				: newPermission_Request;

	}

	public Request_overview_page getRequest_overview_page() {

		return (request_overview == null) ? request_overview = new Request_overview_page(driver) : request_overview;

	}

	public Onboard_new_ECU_page getonboard_new_ECU_page() {

		return (onboard_new_ECU == null) ? onboard_new_ECU = new Onboard_new_ECU_page(driver) : onboard_new_ECU;

	}

	public MyDeputy_Page getMyDeputy_page() {

		return (myDeputy_page == null) ? myDeputy_page = new MyDeputy_Page(driver) : myDeputy_page;

	}

	public Special_access_page getSpecial_access_page() {

		return (special_access_page == null) ? special_access_page = new Special_access_page(driver)
				: special_access_page;

	}
	
	public ReadView_Permission getReadView_Permission_Page() {

		return (read == null) ? read = new ReadView_Permission(driver)
				: read;
	}

}