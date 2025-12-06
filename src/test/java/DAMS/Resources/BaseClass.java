package DAMS.Resources;

import static DAMS.Resources.Listeners.test;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import DAMS.ObjectManager.PageObjectManager;
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
import DAMS.Testcases.Smoke_Suite_1.TC02_Requests_STD_GLOBAL;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
    public static WebDriver driver;
    public static Logger logger;
    public static String downloadPath;
    public static String reason_for_rejection = "Rejected for DA request!";
    public static TC02_Requests_STD_GLOBAL fr;
    public static PropertyFile prop = new PropertyFile();
    public static PageObjectManager pageObjectManager;
    public static ApproverOverview_Page approver_overview;
    public static New_Functional_Role_Request_Page newrequest;
    public static SoftAssert s;
    public static Functional_role_page f;
    public static LoginPage l;
    public static HomePage h;
    public static GTC_Page gtc;
    public static Request_overview_page req;
    public static MyRequest_Page myreq;
    public static NewPermission_Request_Page newper;
    public static Onboard_new_ECU_page onboard_new_ECU;
    public static MyDeputy_Page deputy;
    public static Special_access_page special;
    public static ReadView_Permission read;
    public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();


    public static WebDriver initializeDriver(String mode) throws IOException {
        logger = Logger.getLogger("DAMS");
        PropertyConfigurator.configure("log4j.properties");
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("./Configuration/config.properties");
        prop.load(fis);
//			String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            downloadPath = System.getProperty("user.dir");
            System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
            Map<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.default_directory", downloadPath);
            chromePrefs.put("download.prompt_for_download", false);
            chromePrefs.put("download.directory_upgarde", true);
            chromePrefs.put("safebrowsing.enabled", true);
            
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.setAcceptInsecureCerts(true);
            options.setExperimentalOption("prefs", chromePrefs);
            options.addArguments("--force-device-scale-factor=1.2");
//			 options.addArguments("--headless");
         // *** IMPORTANT FOR JENKINS ***
//            options.addArguments("--headless=new");   // Headless mode
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            if (mode.equals("incognito")) {
                options.addArguments("--incognito", "--disable-popup-blocking");
            }
            WebDriverManager.chromedriver().setup();
            WebDriverManager.chromedriver().clearResolutionCache();
           
            driver = new ChromeDriver(options);
            threadLocalDriver.set(driver);
        } else if (browserName.equals("edge")) {
            System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
            driver = new EdgeDriver();

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        return driver;
    }

    public static WebDriver getDriver() {
        return threadLocalDriver.get();  // Retrieve WebDriver instance specific to the current thread
    }

    public static String generate_OTP_for_MFA() {
        Totp totp = new Totp(prop.getProperty("security_key_MFA"));
        return totp.now();
    }

    public static String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
        File file = new File(path);
        FileUtils.copyFile(source, file);
        return path;
    }
    
//    public static String getScreenshot(String FileName) throws IOException {
//        TakesScreenshot ts = (TakesScreenshot) driver;
//        File source = ts.getScreenshotAs(OutputType.FILE);
//        String path = System.getProperty("user.dir") + "\\reports\\" + FileName + ".png";
//        File file = new File(path);
//        FileUtils.copyFile(source, file);
//        return path;
//
//    }

    public static void windowZoomOut() throws AWTException, InterruptedException {
    	Thread.sleep(2000);
        Robot robot = new Robot();
        logger.info("About to zoom out");
        for (int i = 0; i < 3; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }
    }

    public static SoftAssert creatsoftAssert() {
        return new SoftAssert();
    }

    public static void softassertAll(SoftAssert s) {

        s.assertAll();
    }

    public static void softassertTrue(SoftAssert s, boolean condition) {

        s.assertTrue(condition);
    }

    public static void softassertFalse(SoftAssert s, boolean condition) {

        s.assertFalse(condition);
    }

    public static void assertEquals(SoftAssert s, Object actual, Object expected) {
        s.assertEquals(actual, expected);

    }

    public static String generateRandomString(int length, String text) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));

        }
        return text.concat(sb.toString());

    }

//	@AfterMethod(alwaysRun = true)
//	public void tearDown() {
//	 driver = threadLocalDriver.get();
//		driver.quit();
//		threadLocalDriver.remove();
//	}

    public static String generateRandomString_with_specialchar(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()_+{}-=[];'/.?><";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));

        }
        return sb.toString();

    }

    public static String generateRandomString_OnBoardECU_Grouping(int length, String start, String end) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));

        }

        return start.concat(sb.toString()).concat(end);

    }

    public static String todays_date() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = today.format(formatter);
        return formattedDate;
    }

    public static void softAssertionALL() throws Throwable {
        s = new SoftAssert();
        s.assertAll();
    }

    public static void cleanup_before(String username, String password, String url) throws Throwable {
        s = new SoftAssert();
        driver = initializeDriver("openBrowser");
        pageObjectManager = new PageObjectManager(driver);
        l = pageObjectManager.getLoginPage();
        l.cleanup(username, password, url);
        AbstractComponents.waitForurltext("clean-up");
        s.assertTrue(l.getUrl().contains("clean-up"));
        driver.close();
    }

    public static void login_MFA_Incognito(String username_MFA, String password_MFA, String url)
            throws IOException, InterruptedException {
        // Encode username, password
        String encodedUsername = Base64.getEncoder().encodeToString(username_MFA.getBytes());
        String encodedPassword = Base64.getEncoder().encodeToString(password_MFA.getBytes());

        // Decode username, password
        String username = new String(Base64.getDecoder().decode(encodedUsername));
        String password = new String(Base64.getDecoder().decode(encodedPassword));

        driver = initializeDriver("incognito");
        login(username_MFA, password_MFA, url);
    }

    public static void login_MFA_Normal(String username_MFA, String password_MFA, String url)
            throws IOException, InterruptedException {
        // Encode username, password
        String encodedUsername = Base64.getEncoder().encodeToString(username_MFA.getBytes());
        String encodedPassword = Base64.getEncoder().encodeToString(password_MFA.getBytes());

        // Decode username, password
        String username = new String(Base64.getDecoder().decode(encodedUsername));
        String password = new String(Base64.getDecoder().decode(encodedPassword));

        driver = initializeDriver("Normal");
        login(username_MFA, password_MFA, url);

    }

    public static void login(String username_MFA, String password_MFA, String url) throws InterruptedException {
        pageObjectManager = new PageObjectManager(driver);
        l = pageObjectManager.getLoginPage();
        h = pageObjectManager.getHomePage();
        gtc = pageObjectManager.getGtcPage();
        f = pageObjectManager.getfunctional_role_page();
        newrequest = pageObjectManager.getNewFunctionalRoleRequestPage();
        approver_overview = pageObjectManager.getapproverOverview_page();
        newper = pageObjectManager.getNewPermission_Request_Page();
        req = pageObjectManager.getRequest_overview_page();
        myreq = pageObjectManager.getmyRequest_Page();
        onboard_new_ECU = pageObjectManager.getonboard_new_ECU_page();
        deputy = pageObjectManager.getMyDeputy_page();
        special = pageObjectManager.getSpecial_access_page();
        read = pageObjectManager.getReadView_Permission_Page();
        s = creatsoftAssert();
        l.loginApplicationasRequester_MFA(username_MFA, password_MFA, url);
//        test.pass("User is able to successfully login to application");

    }

//    public static String generate_OTP_for_MFA()
//            throws InterruptedException, TimeProviderException, CodeGenerationException {
//        // Encode and decode SecretKey
//        // This key should match the key used by your app
//        String encodedSecretKey = Base64.getEncoder().encodeToString(prop.getsecurityKEY_MFA().getBytes());
//        String secretKey = new String(Base64.getDecoder().decode(encodedSecretKey));
//        // Generate TOTP
//        TimeProvider timeProvider = new SystemTimeProvider();
//        CodeGenerator codeGenerator = new DefaultCodeGenerator(HashingAlgorithm.SHA1);
//        int timeStep = 30; // Time step in seconds, usually 30
//        String otp = codeGenerator.generate(secretKey, timeProvider.getTime() / timeStep);
//        Thread.sleep(3000);
//        return otp;
//    }

    public static List<List<String>> getTableValues(WebDriver driver, By tableLocator) {
        // Locate the table
        WebElement table = driver.findElement(tableLocator);

        // Get all rows from the table body
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        // List to store all table values
        List<List<String>> tableValues = new ArrayList<>();

        // Extract values from each cell in each row, excluding the header row
        for (WebElement row : rows) {
            if (row.findElements(By.tagName("th")).isEmpty()) { // Skip header row
                List<WebElement> cells = row.findElements(By.tagName("td"));
                List<String> rowValues = new ArrayList<>();
                for (WebElement cell : cells) {
                    rowValues.add(cell.getText());
                }
                tableValues.add(rowValues);
            }
        }

        return tableValues;
    }

    public static List<List<String>> getTableValuesExcludingLastColumn(WebDriver driver, By tableLocator) {
        // Locate the table
        WebElement table = driver.findElement(tableLocator);
        // Get all rows from the table body
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        // List to store all table values excluding last column
        List<List<String>> tableValues = new ArrayList<>();
        // Extract values from each cell in each row, excluding the header row and the
        // last column
        for (WebElement row : rows) {
            if (row.findElements(By.tagName("th")).isEmpty()) { // Skip header row
                List<WebElement> cells = row.findElements(By.tagName("td"));
                List<String> rowValues = new ArrayList<>();
                for (int i = 0; i < cells.size() - 1; i++) { // Exclude the last column
                    rowValues.add(cells.get(i).getText());
                }
                tableValues.add(rowValues);
            }
        }

        return tableValues;
    }

    public static boolean compareTableValues(List<List<String>> firstTable, List<List<String>> secondTable) {
        if (firstTable.size() != secondTable.size()) {
            return false;
        }
        for (int i = 0; i < firstTable.size(); i++) {
            List<String> firstRow = firstTable.get(i);
            List<String> secondRow = secondTable.get(i);

            if (firstRow.size() != secondRow.size()) {
                return false;
            }
            for (int j = 0; j < firstRow.size(); j++) {
                if (!firstRow.get(j).equals(secondRow.get(j))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean checkFirstTableValuesPresenceSkippingCertainColumns(List<List<String>> firstTable,
                                                                              List<List<String>> secondTable) {
        for (List<String> firstRow : firstTable) {
            boolean found = false;
            // Check if any column in the first row is present in any row of the second
            // table
            for (List<String> secondRow : secondTable) {
                if (containsAnyColumnValue(firstRow, secondRow)) {
                    found = true;
                    break;
                }
            }
            

            if (!found) {
                return false;
            }
        }
        return true;
    }

    // Helper method to check if any column value from firstRow is present in
    // secondRow
    private static boolean containsAnyColumnValue(List<String> firstRow, List<String> secondRow) {
        for (String value : firstRow) {
            if (secondRow.contains(value)) {
                return true;
            }
        }
        return false;
    }

    public static int calculate_Total_Days(String validity_year, String validity_month, String validity_days) {
        final int DAYS_IN_YEAR = 366;
        final int DAYS_IN_month = 31;
        int year = Integer.valueOf(validity_year);
        int month = Integer.valueOf(validity_month);
        int days = Integer.valueOf(validity_days);
        int totalDays = (year * DAYS_IN_YEAR) + (month * DAYS_IN_month) + days;
        return totalDays;

    }

    public static void minimize_window() throws AWTException {
        Robot robot = new Robot();
        for (int i = 0; i < 3; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

    }
    public static void ClickTab() throws Throwable {
    	  Robot robot = new Robot();
          Thread.sleep(2000);
          robot.keyPress(KeyEvent.VK_TAB);
          robot.keyRelease(KeyEvent.VK_TAB);
    }

    public static void maximize_window() throws AWTException {
        Robot robot = new Robot();
        for (int i = 0; i < 3; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ADD);
            robot.keyRelease(KeyEvent.VK_ADD);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

    }

    public static String[] extract_column_values_from_Global_table(List<WebElement> element) {
        String[] columnValues = new String[element.size()];
        for (int i = 0; i < element.size(); i++) {
            columnValues[i] = element.get(i).getText();
        }
        for (String value : columnValues) {
            System.out.println(value);
        }
        return columnValues;
    }

    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
        String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent,
                new TypeReference<List<HashMap<String, String>>>() {
                });
        return data;

    }
    public static void waitForPageLoad(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    } 
  
}
