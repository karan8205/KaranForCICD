package DAMS.Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
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

    // ─────────────────────────────────────────────────────────────────────────
    // TestContext: all thread-sensitive state lives here — one copy per thread
    // ─────────────────────────────────────────────────────────────────────────
    public static class TestContext {
        public WebDriver driver;
        public PropertyFile prop;
        public PageObjectManager pageObjectManager;
        public ApproverOverview_Page approver_overview;
        public New_Functional_Role_Request_Page newrequest;
        public SoftAssert s;
        public Functional_role_page f;
        public LoginPage l;
        public HomePage h;
        public GTC_Page gtc;
        public Request_overview_page req;
        public MyRequest_Page myreq;
        public NewPermission_Request_Page newper;
        public Onboard_new_ECU_page onboard_new_ECU;
        public MyDeputy_Page deputy;
        public Special_access_page special;
        public ReadView_Permission read;
        public TC02_Requests_STD_GLOBAL fr;
    }

    /** One TestContext per thread — never null after ctx() is called. */
    private static final ThreadLocal<TestContext> threadContext = ThreadLocal.withInitial(TestContext::new);

    /** Returns the calling thread's own TestContext. */
    public static TestContext ctx() {
        return threadContext.get();
    }

    // ─────────────────────────────────────────────────────────────────────────
    // Shared / non-thread-sensitive fields (safe to keep static)
    // ─────────────────────────────────────────────────────────────────────────
    public static Logger logger;
    public static String downloadPath;
    public static String reason_for_rejection = "Rejected for DA request!";

    // ─────────────────────────────────────────────────────────────────────────
    // Legacy static aliases — kept so the 94+ non-parallel TC files compile
    // without any changes. For parallel-safe code use ctx().xxx instead.
    // ─────────────────────────────────────────────────────────────────────────
    public static TC02_Requests_STD_GLOBAL fr;
    public static PropertyFile prop;
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

    /** ThreadLocal for WebDriver — now backed by TestContext.driver. */
    public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    // ─────────────────────────────────────────────────────────────────────────
    // Driver initialisation
    // Stores the new WebDriver ONLY in ctx().driver + threadLocalDriver.
    // Does NOT touch the legacy static `driver` field so parallel threads
    // never overwrite each other's browser reference.
    // ─────────────────────────────────────────────────────────────────────────
    public static WebDriver initializeDriver(String mode) throws IOException {
        logger = Logger.getLogger("DAMS");
        PropertyConfigurator.configure("log4j.properties");

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("./Configuration/config.properties");
        prop.load(fis);

        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            downloadPath = System.getProperty("user.dir");

            Map<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.default_directory", downloadPath);
            chromePrefs.put("download.prompt_for_download", false);
            chromePrefs.put("safebrowsing.enabled", true);

            ChromeOptions options = new ChromeOptions();
            options.setAcceptInsecureCerts(true);
            options.setExperimentalOption("prefs", chromePrefs);
            options.addArguments("--remote-allow-origins=*");

            if ("true".equalsIgnoreCase(prop.getProperty("headless"))) {
                options.addArguments("--headless=new");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-gpu");
            }

            if (mode.equalsIgnoreCase("incognito")) {
                options.addArguments("--incognito", "--disable-popup-blocking");
            }

            WebDriverManager.chromedriver().setup();
            WebDriver drv = new ChromeDriver(options);

            // Store per-thread ONLY — never write the shared static `driver`
            ctx().driver = drv;
            threadLocalDriver.set(drv);

            if ("false".equalsIgnoreCase(prop.getProperty("headless"))) {
                drv.manage().window().maximize();
            }
        }

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().deleteAllCookies();
        return getDriver();
    }

    /**
     * Always use this to get the current thread's WebDriver.
     * Prefers ctx().driver (parallel-safe); falls back to threadLocalDriver.
     */
    public static WebDriver getDriver() {
        WebDriver drv = ctx().driver;
        if (drv == null) {
            drv = threadLocalDriver.get();
        }
        return drv;
    }

    // ─────────────────────────────────────────────────────────────────────────
    // OTP / MFA
    // ─────────────────────────────────────────────────────────────────────────
    public static String generate_OTP_for_MFA(String type) {
        Totp totp;
        logger.info("USER TYPE " + type);
        if ("Internal".equals(type)) {
            logger.info(ctx().prop.getsecurity_key_MFA_Internal());
            totp = new Totp(ctx().prop.getsecurity_key_MFA_Internal());
        } else if ("External".equals(type)) {
            logger.info(ctx().prop.getsecurity_key_MFA_External());
            totp = new Totp(ctx().prop.getsecurity_key_MFA_External());
        } else {
            logger.info(ctx().prop.getsecurity_key_MFA_Supplier());
            totp = new Totp(ctx().prop.getsecurity_key_MFA_Supplier());
        }
        return totp.now();
    }

    // ─────────────────────────────────────────────────────────────────────────
    // Screenshot
    // ─────────────────────────────────────────────────────────────────────────
    public static String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
        File file = new File(path);
        FileUtils.copyFile(source, file);
        return path;
    }

    // ─────────────────────────────────────────────────────────────────────────
    // Utility methods — all use getDriver() for thread safety
    // ─────────────────────────────────────────────────────────────────────────
    public static void windowZoomOut() throws InterruptedException {
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("document.body.style.zoom='70%'");
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

    @BeforeMethod(alwaysRun = true)
    @Parameters({ "env" })
    public void configure(@Optional("stg") String env, Method method) throws IOException {
        String sysEnv = System.getProperty("env");
        if (sysEnv != null && !sysEnv.isEmpty()) {
            PropertyFile.setEnvironment(sysEnv);
        } else {
            PropertyFile.setEnvironment(env);
        }

        // String methodName = method.getName().toLowerCase();
        //
        // if (methodName.contains("internal")) {
        // PropertyFile.writeProperty("User_name", "PU_S_PID1BD7");
        // }
        // if (methodName.contains("external")) {
        // PropertyFile.writeProperty("User_name", "HARNAGA");
        // }
        // if (methodName.contains("supplier")) {
        // PropertyFile.writeProperty("User_name", "HARNAGA");
        // }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Store prop in both ctx() and the legacy static field
        ctx().prop = new PropertyFile();
        prop = ctx().prop;
    }

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
        return today.format(formatter);
    }

    public static void softAssertionALL() throws Throwable {
        s = new SoftAssert();
        s.assertAll();
    }

    // ─────────────────────────────────────────────────────────────────────────
    // Login helpers — use initializeDriver() which stores into ctx().driver
    // ─────────────────────────────────────────────────────────────────────────
    public static void login_MFA_Incognito(String username_MFA, String password_MFA, String url)
            throws IOException, InterruptedException {
        byte[] decodedBytes = Base64.getDecoder().decode(ctx().prop.getUsername_MFA());
        String username = new String(decodedBytes);
        byte[] passwordEncode = Base64.getDecoder().decode(ctx().prop.getPassword_MFA());
        String password = new String(passwordEncode);
        initializeDriver("incognito"); // sets ctx().driver
        login(username, password, url);
    }

    public static void login_MFA_Incognito_Internal()
            throws IOException, InterruptedException {
        byte[] decodedBytes = Base64.getDecoder().decode(ctx().prop.getUsername_MFA_Internal());
        String username = new String(decodedBytes);
        byte[] passwordEncode = Base64.getDecoder().decode(ctx().prop.getPassword_MFA_Internal());
        String password = new String(passwordEncode);
        initializeDriver("incognito"); // sets ctx().driver
        login(username, password, ctx().prop.getUrl());
    }

    public static void login_MFA_Incognito_External()
            throws IOException, InterruptedException {
        byte[] decodedBytes = Base64.getDecoder().decode(ctx().prop.getUsername_MFA_External());
        String username = new String(decodedBytes);
        byte[] passwordEncode = Base64.getDecoder().decode(ctx().prop.getPassword_MFA_External());
        String password = new String(passwordEncode);
        initializeDriver("incognito"); // sets ctx().driver
        login(username, password, ctx().prop.getUrl());
    }

    public static void login_MFA_Incognito_Supplier()
            throws IOException, InterruptedException {
        byte[] decodedBytes = Base64.getDecoder().decode(ctx().prop.getUsername_MFA_Supplier());
        String username = new String(decodedBytes);
        byte[] passwordEncode = Base64.getDecoder().decode(ctx().prop.getPassword_MFA_Supplier());
        String password = new String(passwordEncode);
        initializeDriver("incognito"); // sets ctx().driver
        login_Supplier(username, password, ctx().prop.getUrl());
    }

    public static void login_MFA_Normal(String username_MFA, String password_MFA, String url)
            throws IOException, InterruptedException {
        String encodedUsername = Base64.getEncoder().encodeToString(username_MFA.getBytes());
        String encodedPassword = Base64.getEncoder().encodeToString(password_MFA.getBytes());
        String username = new String(Base64.getDecoder().decode(encodedUsername));
        String password = new String(Base64.getDecoder().decode(encodedPassword));
        initializeDriver("Normal"); // sets ctx().driver
        login(username_MFA, password_MFA, url);
    }

    // ─────────────────────────────────────────────────────────────────────────
    // Core login — page objects stored BOTH in ctx() (parallel-safe)
    // AND in legacy static fields (backward compat for non-parallel TCs)
    // ─────────────────────────────────────────────────────────────────────────
    public static void login(String username_MFA, String password_MFA, String url) throws InterruptedException {
        ctx().pageObjectManager = new PageObjectManager(getDriver());
        ctx().l = ctx().pageObjectManager.getLoginPage();
        ctx().h = ctx().pageObjectManager.getHomePage();
        ctx().gtc = ctx().pageObjectManager.getGtcPage();
        ctx().f = ctx().pageObjectManager.getfunctional_role_page();
        ctx().newrequest = ctx().pageObjectManager.getNewFunctionalRoleRequestPage();
        ctx().approver_overview = ctx().pageObjectManager.getapproverOverview_page();
        ctx().newper = ctx().pageObjectManager.getNewPermission_Request_Page();
        ctx().req = ctx().pageObjectManager.getRequest_overview_page();
        ctx().myreq = ctx().pageObjectManager.getmyRequest_Page();
        ctx().onboard_new_ECU = ctx().pageObjectManager.getonboard_new_ECU_page();
        ctx().deputy = ctx().pageObjectManager.getMyDeputy_page();
        ctx().special = ctx().pageObjectManager.getSpecial_access_page();
        ctx().read = ctx().pageObjectManager.getReadView_Permission_Page();
        ctx().s = creatsoftAssert();

        // Also update legacy static aliases so non-parallel TCs keep working
        pageObjectManager = ctx().pageObjectManager;
        l = ctx().l;
        h = ctx().h;
        gtc = ctx().gtc;
        f = ctx().f;
        newrequest = ctx().newrequest;
        approver_overview = ctx().approver_overview;
        newper = ctx().newper;
        req = ctx().req;
        myreq = ctx().myreq;
        onboard_new_ECU = ctx().onboard_new_ECU;
        deputy = ctx().deputy;
        special = ctx().special;
        read = ctx().read;
        s = ctx().s;

        ctx().l.loginApplicationasRequester_MFA(username_MFA, password_MFA, url);
    }
    
    public static void login_Supplier(String username_MFA, String password_MFA, String url) throws InterruptedException {
        ctx().pageObjectManager = new PageObjectManager(getDriver());
        ctx().l = ctx().pageObjectManager.getLoginPage();
        ctx().h = ctx().pageObjectManager.getHomePage();
        ctx().gtc = ctx().pageObjectManager.getGtcPage();
        ctx().f = ctx().pageObjectManager.getfunctional_role_page();
        ctx().newrequest = ctx().pageObjectManager.getNewFunctionalRoleRequestPage();
        ctx().approver_overview = ctx().pageObjectManager.getapproverOverview_page();
        ctx().newper = ctx().pageObjectManager.getNewPermission_Request_Page();
        ctx().req = ctx().pageObjectManager.getRequest_overview_page();
        ctx().myreq = ctx().pageObjectManager.getmyRequest_Page();
        ctx().onboard_new_ECU = ctx().pageObjectManager.getonboard_new_ECU_page();
        ctx().deputy = ctx().pageObjectManager.getMyDeputy_page();
        ctx().special = ctx().pageObjectManager.getSpecial_access_page();
        ctx().read = ctx().pageObjectManager.getReadView_Permission_Page();
        ctx().s = creatsoftAssert();

        // Also update legacy static aliases so non-parallel TCs keep working
        pageObjectManager = ctx().pageObjectManager;
        l = ctx().l;
        h = ctx().h;
        gtc = ctx().gtc;
        f = ctx().f;
        newrequest = ctx().newrequest;
        approver_overview = ctx().approver_overview;
        newper = ctx().newper;
        req = ctx().req;
        myreq = ctx().myreq;
        onboard_new_ECU = ctx().onboard_new_ECU;
        deputy = ctx().deputy;
        special = ctx().special;
        read = ctx().read;
        s = ctx().s;

        ctx().l.loginApplicationasRequester_MFA_Supplier(username_MFA, password_MFA, url);
    }

    // ─────────────────────────────────────────────────────────────────────────
    // Table utilities
    // ─────────────────────────────────────────────────────────────────────────
    public static List<List<String>> getTableValues(WebDriver driver, By tableLocator) {
        WebElement table = driver.findElement(tableLocator);
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        List<List<String>> tableValues = new ArrayList<>();
        for (WebElement row : rows) {
            if (row.findElements(By.tagName("th")).isEmpty()) {
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
        WebElement table = driver.findElement(tableLocator);
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        List<List<String>> tableValues = new ArrayList<>();
        for (WebElement row : rows) {
            if (row.findElements(By.tagName("th")).isEmpty()) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                List<String> rowValues = new ArrayList<>();
                for (int i = 0; i < cells.size() - 1; i++) {
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
        return (year * DAYS_IN_YEAR) + (month * DAYS_IN_month) + days;
    }

    public static void minimize_window() throws InterruptedException {
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("document.body.style.zoom='80%'");
    }

    public static void ClickTab() throws Throwable {
        Thread.sleep(2000);
        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(getDriver());
        actions.sendKeys(org.openqa.selenium.Keys.TAB).build().perform();
    }

    public static void maximize_window() throws InterruptedException {
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("document.body.style.zoom='100%'");
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
