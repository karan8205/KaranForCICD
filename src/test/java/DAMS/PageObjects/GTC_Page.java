package DAMS.PageObjects;

import DAMS.Resources.AbstractComponents;
import org.apache.hc.core5.http.ParseException;
import org.apache.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static DAMS.Resources.Listeners.test;

import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class GTC_Page extends AbstractComponents {

	WebDriver driver;
	public static Logger logger = Logger.getLogger("DAMS");

	public GTC_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div/mat-grid-tile-header[text()=\" General Terms and Conditions\"]")
	private WebElement GTC_header;

	@FindBy(xpath = "//p[contains(text(),\"This tool is used to request diagnostic permissions\")]")
	private WebElement GTC_text;

	@FindBy(xpath = "//div[@class='read-gtc']/label")
	private WebElement read_and_accept_GTC;

	@FindBy(xpath = "//ul[@class=\"gtc-content\"]/li")
	private List<WebElement> General_terms_and_conditions_message;

	@FindBy(xpath = "//span[@class='mat-checkbox-label']")
	private WebElement confirmation_message;

	@FindBy(xpath = "//mat-checkbox[contains(@id,'checkbox')]")
	private WebElement checkbox;

	@FindBy(xpath = "//span[text()='Proceed']//parent::button")
	private WebElement proceed_button;

	@FindBy(xpath = "//span[text()=\"Proceed\"]")
	private WebElement proceed_button_txt;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	private WebElement download_button;

	public String getGTCUrl() {
		return getUrl();

	}

	public String gtc_header() {
		waitForWebElementToAppear(GTC_header);
		return GTC_header.getText();

	}

	public String gtc_txt() {
		return GTC_text.getText();

	}

	public void read_and_accept_GTC() throws InterruptedException {
		waitForWebElementToAppear(read_and_accept_GTC);
		Thread.sleep(3000);
		waitForelementToBeClickable(read_and_accept_GTC);
		waitForelementToBeClickable(read_and_accept_GTC);
//		if (read_and_accept_GTC.isEnabled()) {
//			read_and_accept_GTC.click();
		waitForWebElementToAppear(read_and_accept_GTC);

		click(read_and_accept_GTC);
		}

//	}

	public String gtc_message() {
		String res = " ";
		for (int i = 0; i < General_terms_and_conditions_message.size(); i++) {
			String txt = General_terms_and_conditions_message.get(i).getText();
			res = res + txt;
		}
		return res;

	}

	public void confirmation_checkbox_bfselected() throws InterruptedException {
//		waitForWebElementToAppear(confirmation_message);
//		if (!checkbox.isSelected() && proceed_button.isEnabled()) {
        if(!checkbox.isSelected()) {
        	waitForWebElementToAppear(checkbox);
        	Thread.sleep(1000);
			click(checkbox);

		}
	}

	public void confirmation_checkbox_afselected() {
		if (proceed_button.isEnabled()) {
			waitForWebElementToAppear(proceed_button_txt);
//			try {
//			clickJS(proceed_button_txt);
//			}catch(Exception e) {
//				doubleClick(proceed_button_txt);
//			}
			proceed_button_txt.click();
			logger.info("Proceed Button Clicked");
		}
	}

	public void download_bfcheckbox_selected() {
		if (!checkbox.isSelected() && proceed_button.isEnabled()) {

			clickJS(download_button);

		}
	}

	public String readPDFInDiffBrowser()
			throws IOException, ParseException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
		String pdfFullText = null;
		try {
			File f = new File("./DaimlerTruck-GTC.pdf");
			if(f.exists()) {
			PDDocument pdDocument = PDDocument.load(f);
			int pageCount = pdDocument.getNumberOfPages();
			logger.info("pages count: " + pageCount);
			logger.info(pdDocument.getCurrentAccessPermission().canPrint());
			logger.info(pdDocument.getCurrentAccessPermission().isReadOnly());
			PDFTextStripper pdfStripper = new PDFTextStripper();
			pdfFullText = pdfStripper.getText(pdDocument);
			System.out.println(pdfFullText);
			pdDocument.close();
			if(f.delete()) {
				System.out.println("file deleted");
			}
			}
		} catch (IOException e) {
			System.err.println("Error reading PDF file: " + e.getMessage());
		}
		return pdfFullText;

	}
	
	public void gtc_page_validation() throws InterruptedException {
		if (getGTCUrl().contains("gtc")) {
			test.pass("User is successfully redirected into GTC Page");
			logger.info("User is successfully redirected into GTC Page");
			Thread.sleep(6000);
			read_and_accept_GTC();
			confirmation_checkbox_bfselected();
//			test.pass("User is able to see the proceed button disabled without selecting the checkbox");
//			logger.info("User is able to see the proceed button disabled without selecting the checkbox");
			confirmation_checkbox_afselected();//proceed btn
			test.pass("User is able to see the proceed button enabled after selecting the checkbox");
			logger.info("User is able to see the proceed button enabled after selecting the checkbox");
		}

	}

}