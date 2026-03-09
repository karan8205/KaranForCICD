package DAMS.Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	public static ExtentReports getReportObject() {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String path = System.getProperty("user.dir") + "//reports//" + timeStamp +"index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("DAMS Smoke Automation Results");
		reporter.config().setDocumentTitle("Test Results");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "HARIHARAN");
		return extent;

	}
	static String timeStamp=null;
	public static String GenarateExcelReport(HashMap<String, String> data,
            String className,
            String methodName) throws IOException {
		
		if(timeStamp==null) {
		timeStamp  = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		}
		// ===== 1. Fixed File Name (Suite Level) =====
		String folderPath = System.getProperty("user.dir") + "/reports/excelReport";

		File folder = new File(folderPath);
		if (!folder.exists()) {
			folder.mkdirs();
		}

String filePath = folderPath + "/ExecutionReport"+timeStamp+".xlsx";
File file = new File(filePath);

Workbook workbook;
Sheet sheet;

// ===== 2. Check File Exists =====
if (file.exists()) {
FileInputStream fis = new FileInputStream(file);
workbook = new XSSFWorkbook(fis);
sheet = workbook.getSheet("TestDataReport");
fis.close();
} else {
workbook = new XSSFWorkbook();
sheet = workbook.createSheet("TestDataReport");
}

// ===== 3. Header Row Handling =====
Row headerRow = sheet.getRow(0);
if (headerRow == null) {
headerRow = sheet.createRow(0);
headerRow.createCell(0).setCellValue("Class Name");
headerRow.createCell(1).setCellValue("Method Name");
}

int lastColumn = headerRow.getLastCellNum();
if (lastColumn < 0) lastColumn = 2;

// ===== 4. Map Existing Headers =====
Map<String, Integer> headerMap = new HashMap<>();

for (int i = 0; i < headerRow.getLastCellNum(); i++) {
Cell cell = headerRow.getCell(i);
if (cell != null) {
headerMap.put(cell.getStringCellValue(), i);
}
}

// ===== 5. Add New Keys As Columns =====
for (String key : data.keySet()) {
if (!headerMap.containsKey(key)) {
int newColIndex = headerRow.getLastCellNum();
headerRow.createCell(newColIndex).setCellValue(key);
headerMap.put(key, newColIndex);
}
}

// ===== 6. Create New Row (Append) =====
int lastRowNum = sheet.getLastRowNum();
int newRowNum = (sheet.getPhysicalNumberOfRows() == 0) ? 1 : lastRowNum + 1;

Row newRow = sheet.createRow(newRowNum);

// ===== 7. Mandatory Columns =====
newRow.createCell(0).setCellValue(className);
newRow.createCell(1).setCellValue(methodName);

// ===== 8. Write Data Values =====
for (Map.Entry<String, String> entry : data.entrySet()) {
int colIndex = headerMap.get(entry.getKey());
newRow.createCell(colIndex).setCellValue(entry.getValue());
}

// ===== 9. Auto-size All Columns =====
for (int i = 0; i < headerRow.getLastCellNum(); i++) {
sheet.autoSizeColumn(i);
}

// ===== 10. Write Back To File =====
FileOutputStream fos = new FileOutputStream(filePath);
workbook.write(fos);
fos.close();
workbook.close();

System.out.println("Excel Updated Successfully: " + filePath);

return filePath;
}
}
