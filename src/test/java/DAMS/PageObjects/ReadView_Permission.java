package DAMS.PageObjects;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import DAMS.Resources.AbstractComponents;

public class ReadView_Permission extends AbstractComponents {
	WebDriver driver;

	public ReadView_Permission(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Read View Permission']")
	private WebElement Read_View_Permission;
	
	@FindBy(xpath = "(//span[text()='Please select your user type'])[last()-1]")
	private WebElement Read_View_UserType;
	
	@FindBy(xpath = "//mat-option/span")
	private List<WebElement> Functional_role_type;
	
	@FindBy(xpath = "//input[@id='search']")
	private WebElement Read_View_SearchUser;
	
	@FindBy(xpath = "//input[@id='search']")
	private WebElement search_input;
	
	@FindBy(xpath = "//span[text()='Search']")
	private WebElement searchBtn;
	
	@FindBy(xpath = "(//mat-icon[text()='filter_list'])[2]")
	private WebElement ApplicationNumberfilter;
	
	@FindBy(xpath = "(//input[@data-placeholder='Search here'])[last()]")
	private WebElement filtersearch;
	
	@FindBy(xpath = "//span[text()='Apply Filter']")
	private WebElement applyfiltersearch;
	
	@FindBy(xpath = "(//span[@class='mat-checkbox-inner-container'])[2]")
	private WebElement applyfiltercheckbox2;
	
	@FindBy(xpath = "//button[@class='inherited-btn ng-star-inserted']/child::div")
	private WebElement CebidBE_Hyperlink;
	
	
	public void readviewpermissionEnabled() throws InterruptedException {
		Thread.sleep(3000);
		waitForWebElementToAppear(Read_View_Permission);
		waitForelementToBeClickable(Read_View_Permission);
		clickJS(Read_View_Permission);
		Thread.sleep(2000);
	}
	
	public void readviewpermissionUserType(String name) throws InterruptedException {
		Thread.sleep(3000);
		waitForWebElementToAppear(Read_View_UserType);
		click(Read_View_UserType);
		clickelementmatchingtext(Functional_role_type, name);
	}
	
	public String clickelementmatchingtext(List<WebElement> elements, String name) throws InterruptedException {
		String usertype1 = null;
		for (int i = 0; i < elements.size(); i++) {
			WebElement txt = elements.get(i);
			String usertype = txt.getText();
			if (usertype.equals(name)) {
				usertype1 = usertype;
				Thread.sleep(1000);
				clickJS(txt);
			}
		}
		return usertype1;
	}
	
	public String clickelementmatchingcheckboxtext(List<WebElement> elements, String name) throws InterruptedException {
	    String matchedText = null;
	    for (WebElement element : elements) {
	        String text = element.getText().trim();
	        if (text.equals(name)) {
	            matchedText = text;
	            Thread.sleep(1000);
	            WebElement checkbox = element.findElement(By.xpath("//span[@class='mat-checkbox-inner-container']"));
	            if (checkbox != null && !checkbox.isSelected()) {
	                checkbox.click();
	            } else {
	                element.click();
	            }
	            break;  
	        }
	    }
	    return matchedText;
	}
	public void readviewpermissionSearchUser(String name) throws InterruptedException {
		waitForWebElementToAppear(Read_View_SearchUser);
		click(Read_View_SearchUser);
		type(search_input, name);
		Thread.sleep(2000);
		String searchid = "Dummy Dummy (" + name + " )";
		clickelementmatchingtext(Functional_role_type, searchid);
	}
	
	public void type(WebElement element, String data) {
		if (isDisplayed(element) && isEnabled(element) && data != null) {
			element.sendKeys(data);
		}
	}
	
	public void searchBtn() throws InterruptedException {
		waitForelementToBeClickable(searchBtn);
		click(searchBtn);
		Thread.sleep(15000);
	}
	
	public void applicationNumber_FilterSearch(String number) throws InterruptedException {
		Thread.sleep(10000);
		waitForWebElementToAppear(ApplicationNumberfilter);
		clickJS(ApplicationNumberfilter);
		clickJS(filtersearch);
		type(filtersearch, number);
		waitForelementToBeClickable(applyfiltercheckbox2);
		clickJS(applyfiltercheckbox2);
		Thread.sleep(2000);
		click(applyfiltersearch);
		
	}
	
	public void CeBE_Hyperlink() throws InterruptedException {
		waitForelementToBeClickable(CebidBE_Hyperlink);
		Thread.sleep(2000);
		clickJS(CebidBE_Hyperlink);
	}
	
	

}
