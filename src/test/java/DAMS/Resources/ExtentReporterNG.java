package DAMS.Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

    public static ExtentReports getReportObject() {
        String timeStamp = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date());
        String path = System.getProperty("user.dir") + "//reports//" + timeStamp + "index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("DAMS Smoke Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "HARIHARAN");

        return extent;
    }

    static String timeStamp = null;

    public static String GenarateExcelReport(HashMap<String, String> data,
                                             String className,
                                             String methodName) throws IOException {

        // Safe + clean format for filenames
        if (timeStamp == null) {
            timeStamp = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date());
        }

        String folderPath = System.getProperty("user.dir") + "/reports/excelReport";

        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String filePath = folderPath + "/ExecutionReport_" + timeStamp + ".xlsx";
        File file = new File(filePath);

        Workbook workbook;
        Sheet sheet;

        // Load existing Excel or create new one
        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet("TestDataReport");
            fis.close();
        } else {
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet("TestDataReport");
        }

        // Create header row if not exists
        Row headerRow = sheet.getRow(0);
        if (headerRow == null) {
            headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Class Name");
            headerRow.createCell(1).setCellValue("Method Name");
        }

        // ===== HEADER STYLE =====
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 11);
        headerStyle.setFont(headerFont);

        headerStyle.setAlignment(HorizontalAlignment.CENTER);

        headerStyle.setBorderTop(BorderStyle.THIN);
        headerStyle.setBorderBottom(BorderStyle.THIN);
        headerStyle.setBorderLeft(BorderStyle.THIN);
        headerStyle.setBorderRight(BorderStyle.THIN);

        // Build header map
        Map<String, Integer> headerMap = new HashMap<>();
        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
            Cell cell = headerRow.getCell(i);
            if (cell != null) {
                headerMap.put(cell.getStringCellValue(), i);
                cell.setCellStyle(headerStyle); // apply highlight
            }
        }

        // Add new keys as headers if required
        for (String key : data.keySet()) {
            if (!headerMap.containsKey(key)) {
                int newColIndex = headerRow.getLastCellNum();
                Cell newHeaderCell = headerRow.createCell(newColIndex);
                newHeaderCell.setCellValue(key);
                newHeaderCell.setCellStyle(headerStyle); // highlight new header
                headerMap.put(key, newColIndex);
            }
        }

        // Create new row
        int lastRowNum = sheet.getLastRowNum();
        int newRowNum = (sheet.getPhysicalNumberOfRows() == 0) ? 1 : lastRowNum + 1;

        Row newRow = sheet.createRow(newRowNum);

        // Mandatory fields
        newRow.createCell(0).setCellValue(className);
        newRow.createCell(1).setCellValue(methodName);

        // Fill dynamic data
        for (Map.Entry<String, String> entry : data.entrySet()) {
            int colIndex = headerMap.get(entry.getKey());
            newRow.createCell(colIndex).setCellValue(entry.getValue());
        }

        // Auto size all columns
        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
            sheet.autoSizeColumn(i);
        }

        // Save Excel
        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);
        fos.close();
        workbook.close();

        System.out.println("Excel Updated Successfully: " + filePath);
        return filePath;
    }
}