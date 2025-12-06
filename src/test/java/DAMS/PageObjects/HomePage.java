package DAMS.PageObjects;

import DAMS.ObjectManager.PageObjectManager;
import DAMS.Resources.AbstractComponents;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static DAMS.Resources.Listeners.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage extends AbstractComponents {
	WebDriver driver;
	public static Logger logger = Logger.getLogger("DAMS");

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By productsBy = By.xpath("//div[@class=\"docs-navbar-header\"]");

	@FindBy(xpath = "//span[contains(text(),'Hello, ')]")
	private WebElement user_Name;

	@FindBy(xpath = "//div[@class=\"docs-navbar-header\"]")
	private WebElement header;

	@FindBy(xpath = "//span[text()=\"Home\"]")
	private WebElement menu_Id_Home;

	@FindBy(xpath = "//span[text()='Click here to apply for functional roles']")
	private  WebElement click_here_to_apply_for_Functional_roles;

	@FindBy(xpath = "//span[text()='Functional Role Overview']")
	private WebElement menu_Id_functional_role_Overview;

	@FindBy(xpath = "//button[contains(@class,\"mat-focus-indicator\")][3]")
	private WebElement menu_Id_new_Permission_Request;

	@FindBy(xpath = "//button[contains(@class,\"mat-focus-indicator\")][4]")
	private WebElement menu_Id_Permission_Request_Overview;

	@FindBy(xpath = "//p[contains(text(),\" Register in DAM with new Functional Roles\")]")
	private WebElement register_in_DAMS_text;

	@FindBy(xpath = "(//span[text()='Please select your user type'])[1]")
	private WebElement please_select_your_user_type;

	@FindBy(xpath = "//div[@role='listbox']/mat-option/span")
	private List<WebElement> user_type_list;

	@FindBy(xpath = "//span[@class=\"mat-option-text\"]")
	private List<WebElement> user_type;

	@FindBy(xpath = "//div/mat-toolbar/mat-toolbar-row/div[3]/button/span[1]")
	private WebElement Logout;

	@FindBy(xpath = "//button[text()='Logout']")
	private WebElement Logout_btn;

	@FindBy(xpath = "//span[text()=\"Reject\"]")
	private WebElement reject;

	@FindBy(xpath = "(//span[contains(@class,\"mat-form-field-label-wrapper\")])[last()]")
	private WebElement reason_for_rejection;

	@FindBy(xpath = "//span[text()=\"Submit\"]")
	private WebElement submit_button;

	@FindBy(xpath = "//h2[text()=\"Logged off\"]")
	private WebElement logged_off_txt;

	@FindBy(xpath = "//span[text()='Functional Role Overview ']")
	private WebElement functional_role_Overview1;

	@FindBy(xpath = "//header/nav/app-menu/mat-toolbar/button[2]/span[1]")
	private WebElement functional_role_Overview;

	@FindBy(xpath = "//span[text()=\"Technical User\"]")
	private WebElement Technical_User;

	@FindBy(xpath = "//div[text()=\"Already requested for functional role\"]")
	private WebElement Already_requested_for_functional_role;

	@FindBy(xpath = "//span[@class=\"mat-button-toggle-label-content\"]")
	private WebElement myself;
	
	@FindBy(xpath = "//input[contains(@id,'mat-mdc-checkbox')]")
	private WebElement dropconfirmBox;
	
	@FindBy(xpath = "//span[text()='Ok']")
	private WebElement dropOk;
	
	
	
	@FindBy(xpath = "//span[@class='button-text']")
	private List<WebElement> apply_for_Functional_roles;
	
	@FindBy(xpath = "//span[text()='Service Principal']")
	private WebElement servicePrincipal;

	public String user_Name() {
		String Username = user_Name.getText();
		String[] st = Username.split(",");
		String user_name = st[1].trim();
		return user_name;

	}

	public boolean home_tab() throws InterruptedException {
		Thread.sleep(3000);
		return menu_Id_Home.isDisplayed();

	}

	public void select_home_tab() {
		menu_Id_Home.click();
		AbstractComponents.waitForelementToBeClickable(menu_Id_Home);

	}

	public boolean functional_role_Overview_tab() {
		return menu_Id_functional_role_Overview.getAttribute("class").contains("mat-button-disabled");

	}

	public boolean new_Permission_Request_tab() {
		return menu_Id_new_Permission_Request.getAttribute("class").contains("mat-button-disabled");

	}

	public boolean permission_Request_Overview_tab() {
		return menu_Id_Permission_Request_Overview.getAttribute("class").contains("mat-button-disabled");

	}

	public String register_in_DAMS_text() {
		return getText(register_in_DAMS_text);

	}

	public boolean click_here_to_apply_for_functional_roles() {
		return click_here_to_apply_for_Functional_roles.getAttribute("class").contains("mat-button-disabled");

	}

	public void please_select_your_user_type() throws InterruptedException {
		Thread.sleep(2000);
		click(please_select_your_user_type);
		Thread.sleep(1000);
		//please_select_your_user_type.click();
	}

	public String user_type(String name) throws InterruptedException {
		clickelementmatchingtext(user_type_list, name);
		return name;
	}

	public void clickelementmatchingtext(List<WebElement> elements, String User_type) {
		for (int i = 0; i < user_type_list.size(); i++) {
			if (elements.get(i).getText().equalsIgnoreCase(User_type)) {
				elements.get(i).click();
				break;
			}

		}

	}

	public String logout_btn() {
		waitForWebElementToAppear(Logout);
		clickJS(Logout);
		clickJS(Logout_btn);
		return logged_off_txt.getText();

	}

	public void user_type_list() {
		for(int i = 0; i < user_type_list.size(); i++) {
			test.pass(user_type_list.get(i).getText());
			logger.info(user_type_list.get(i).getText());
		}

	}

	public void dropBtn() throws InterruptedException {  //span[@class='button-text']
		Thread.sleep(4000);
	int size=	apply_for_Functional_roles.size();
	logger.info(size);
	Thread.sleep(2000);
	boolean res=false;
	if(size>1) {
		res=true;
	}
	else {
		res= false;
	}
	if(res) {
		Thread.sleep(1000);
		WebElement element = apply_for_Functional_roles.get(size-1);
		element.click();
		Thread.sleep(1000);
		dropconfirmBox.click();
		Thread.sleep(500);
		dropOk.click();
		Thread.sleep(9000);
	}
	}
	
	public void click_here_to_apply_for_functional_roles_click() {
		waitForWebElementToAppear(click_here_to_apply_for_Functional_roles);
		waitForWebElementToAppear(click_here_to_apply_for_Functional_roles);
		waitForWebElementToAppear(click_here_to_apply_for_Functional_roles);
		click_here_to_apply_for_Functional_roles.click();
	}

	public void click_here_to_apply_for_functional_roles_click_TechnicalUser() {
		Technical_User.click();
		click_here_to_apply_for_Functional_roles.click();
	}

	public String select_user_type(String type) throws InterruptedException {
			Thread.sleep(3000);
			please_select_your_user_type();
			user_type_list();
			test.pass("User is able to click on dropdown and view list of user types");
			logger.info("User is able to view User_types in dropdown");
		String user_type = user_type(type);
		click_here_to_apply_for_functional_roles_click();
		test.pass("Click here to apply for functional roles is enabled");
		logger.info("Click here to apply for functional roles is enabled");
		return user_type;
	}
	
	//
	public void selectServicePrincipal() throws InterruptedException {
		waitForWebElementToAppear(servicePrincipal);
		waitForelementToBeClickable(servicePrincipal);
		Thread.sleep(2000);
		click(servicePrincipal);
		click_here_to_apply_for_functional_roles_click();
		
		
	}

	public boolean click_here_to_apply_for_FR(String usertype) {
		select_home_tab();
		return click_here_to_apply_for_functional_roles();

	}

	public void click_here_to_apply_for_Functional_roles_disabled() throws InterruptedException {
		select_home_tab();
		clickJS(myself);
		moveToElement(click_here_to_apply_for_Functional_roles);
		waitForWebElementToAppear(Already_requested_for_functional_role);

	}
}