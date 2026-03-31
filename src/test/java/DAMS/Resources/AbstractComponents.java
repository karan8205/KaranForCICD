package DAMS.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import javax.net.ssl.SSLContext;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.BasicHttpClientConnectionManager;
import org.apache.hc.client5.http.socket.ConnectionSocketFactory;
import org.apache.hc.client5.http.socket.PlainConnectionSocketFactory;
import org.apache.hc.client5.http.ssl.NoopHostnameVerifier;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.config.Registry;
import org.apache.hc.core5.http.config.RegistryBuilder;
import org.apache.hc.core5.ssl.SSLContexts;
import org.apache.hc.core5.ssl.TrustStrategy;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents extends BaseClass{
	public AbstractComponents(WebDriver driver) {
		PageFactory.initElements(new ThreadLocalElementLocatorFactory(), this);
	}

	public void waitForElementToAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	} 

	public static void waitForWebElementToAppear(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Duration.ofSeconds(45));
		wait.until(ExpectedConditions.visibilityOf(findBy));

	}
	
	public static void waitForurltext(String text) {

		WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.urlContains(text));

	}

	public static void waitForelementToBeClickable(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(findBy));

	}

	public void waitForWebElementnotToAppear(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfAllElements(findBy));

	}

	public void switchToFrameByindex(int index) {
		BaseClass.getDriver().switchTo().frame(index);
	}

	public void switchToFrameByName(String name) {
		BaseClass.getDriver().switchTo().frame(name);
	}

	public void switchToFrameByElement(WebElement element) {
		BaseClass.getDriver().switchTo().frame(element);
	}

	public void switchToFrameById(String id) {
		BaseClass.getDriver().switchTo().frame(id);
	}

	public void switchToDefault() {
		BaseClass.getDriver().switchTo().parentFrame();
	}

	public boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public boolean isEnabled(WebElement element) {
		return element.isEnabled();
	}

	public void loadUrl(String Url) {
		BaseClass.getDriver().get(Url);
	}

	public void maximize() {
		BaseClass.getDriver().manage().window().maximize();
	}

	public void implicitWait(long time) {
		BaseClass.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}

	public void type(WebElement element, Object values) {
		if (isDisplayed(element) && isEnabled(element) && values != null) {
			element.sendKeys(values.toString());
		}
	}

	public void type(WebElement element, String data) {
		if (isDisplayed(element) && isEnabled(element) && data != null) {
			element.sendKeys(data);
		}
	}

	public void click(WebElement element) {
		if (isDisplayed(element) && isEnabled(element)) {
			element.click();
		}
		else {
			logger.info("Element Not Enabled");
		}
	}
	public void clickElement(WebElement element) {
		try {
			element.click();
		}
		catch(Exception e) {
			clickJS(element);
		}
	}

	public int framesCount() {
		List<WebElement> framescount = BaseClass.getDriver().findElements(By.tagName("iframe"));
		return framescount.size();
	}

	public void quit() {
		BaseClass.getDriver().quit();
	}

	public void close() {
		BaseClass.getDriver().close();
	}

	public void selectBytext(WebElement element, String data) {
		new Select(element).selectByVisibleText(data);

	}

	public void selectByAttribute(WebElement element, String data) {
		new Select(element).selectByValue(data);

	}

	public void selectByIndex(WebElement element, int index) {
		new Select(element).selectByIndex(index);

	}

	public String getAttributeValue(WebElement element) {
		return element.getAttribute("value");

	}

	public String getText(WebElement element) {
		return element.getText();
	}

	public String getTitle() {
		return BaseClass.getDriver().getTitle();
	}

	public String getUrl() {
		return BaseClass.getDriver().getCurrentUrl();
	}

	public static void scrollDown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.getDriver();
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public void scrollUp(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.getDriver();
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}

	public void typeJS(WebElement element, String data) {
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.getDriver();
		js.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
	}

	public void clickJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.getDriver();
		waitForelementToBeClickable(element);
		js.executeScript("arguments[0].click()", element);
		
	}
	public void focusClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.getDriver();
		waitForelementToBeClickable(element);
		js.executeScript("arguments[0].focus();", element);
		element.click();
		
	}
	public void moveToElement(WebElement element) {
		Actions ac = new Actions(BaseClass.getDriver());
		ac.moveToElement(element).perform();

	}
	public void actionClick(WebElement element) {
		Actions ac = new Actions(BaseClass.getDriver());
		ac.moveToElement(element).click().perform();

	}

	public void dragAndDrop(WebElement scr, WebElement desc) {
		Actions ac = new Actions(BaseClass.getDriver());
		ac.dragAndDrop(scr, desc).perform();

	}

	public void rightClick(WebElement element) {
		Actions ac = new Actions(BaseClass.getDriver());
		ac.contextClick(element).perform();

	}

	public void doubleClick(WebElement element) {
		Actions ac = new Actions(BaseClass.getDriver());
		ac.doubleClick(element).perform();

	}

	public void actionsType(WebElement element, String data) {
		Actions ac = new Actions(BaseClass.getDriver());
		ac.sendKeys(element, data).perform();

	}

	public void acceptAlert() {
		Alert al = BaseClass.getDriver().switchTo().alert();
		al.accept();

	}

	public void dismissAlert() {
		Alert al = BaseClass.getDriver().switchTo().alert();
		al.dismiss();

	}

	public String getTextAlert() {
		Alert al = BaseClass.getDriver().switchTo().alert();
		return al.getText();

	}

	public void navigateBack() {
		BaseClass.getDriver().navigate().back();

	}

	public void navigateURL(String url) {
		BaseClass.getDriver().navigate().to(url);

	}

	public void navigateForward() {
		BaseClass.getDriver().navigate().forward();

	}

	public static void refresh() {
		BaseClass.getDriver().navigate().refresh();

	}

	public static void Scrollright_waitForWebElementToAppear(WebElement findBy) {
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.getDriver();
		js.executeScript("arguments[0].scrollIntoView();", findBy);
		WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(findBy));

	}

	public InputStream httpclientMethod(String url)
			throws ParseException, IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
		final TrustStrategy acceptingTrustStrategy = (cert, authType) -> true;
		final SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy).build();
		final SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext,
				NoopHostnameVerifier.INSTANCE);
		final Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder
				.<ConnectionSocketFactory>create().register("https", sslsf)
				.register("http", new PlainConnectionSocketFactory()).build();
		final BasicHttpClientConnectionManager connectionManager = new BasicHttpClientConnectionManager(
				socketFactoryRegistry);
		CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connectionManager).build();

		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse response = httpClient.execute(httpGet);
		HttpEntity entity = null;
		if (response.getCode() == 200) {
			entity = response.getEntity();

		} else {
			logger.info("Res" + response.getCode());
		}
		return entity.getContent();
	}

	public WebElement dynmaic_xpath(String textvalue) {
		String xpath = String.format("//span[contains(text(),'%s')]", textvalue);
		return BaseClass.getDriver().findElement(By.xpath(xpath));
	}
	
	public String getRandomServiceId() {
		
		 String prefix = "BF";

	        Random random = new Random();
	        int number = random.nextInt(9000) + 1000; // ensures 4-digit number (1000–9999)

	        String result = prefix + number;
	        return result;
	}
	
	
	
	
	
	

}
