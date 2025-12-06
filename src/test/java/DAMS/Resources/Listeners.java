package DAMS.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends BaseClass implements ITestListener {

    public static ExtentReports extent = ExtentReporterNG.getReportObject();
    public static ExtentTest test;   // KEEP STATIC for your existing project

    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, result.getMethod().getMethodName() + " Passed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().log(Status.SKIP, result.getMethod().getMethodName() + " Skipped");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        extentTest.get().fail(result.getThrowable());

        try {
            WebDriver driver = (WebDriver) result.getTestClass()
                    .getRealClass()
                    .getField("driver")
                    .get(result.getInstance());

            String path = getScreenshot(result.getMethod().getMethodName(), driver);

            extentTest.get().addScreenCaptureFromPath(path);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
