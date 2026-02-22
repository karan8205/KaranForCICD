package DAMS.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReporterNG {

    public static ExtentReports getReportObject() {

        String reportPath;

        // Detect Jenkins
        String jenkinsWorkspace = System.getenv("WORKSPACE");

        if (jenkinsWorkspace != null) {
            // CI/CD run
            reportPath = System.getProperty("user.dir") + "/reports/ExtentReport.html";
            System.out.println("Running in Jenkins - Single Report");
        } else {
            // Local run
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            reportPath = System.getProperty("user.dir") + "/reports/ExtentReport_" + timeStamp + ".html";
            System.out.println("Running Locally - Separate Report");
        }

        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        reporter.config().setReportName("DAMS Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "HARIHARAN");

        return extent;
    }
}