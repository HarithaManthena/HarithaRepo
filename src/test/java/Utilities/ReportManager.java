package Utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportManager {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static Map<Long, ExtentTest> testMap = new HashMap<>();

	public static void startReport() {
		
		if (htmlReporter == null) {
			String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
			String dateStamp = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/WebReports/"+dateStamp+"/"+"Bennett-"+timeStamp+".html");
			// Create an object of Extent Reports
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("Host Name", "Bennett");
			extent.setSystemInfo("Environment", "Production");
			extent.setSystemInfo("User Name", "Tester 1");
			htmlReporter.config().setDocumentTitle("Bennett Application");
			// Name of the report
			htmlReporter.config().setReportName("Bennett Application");
			htmlReporter.config().enableTimeline(true);
			htmlReporter.config().setAutoCreateRelativePathMedia(true);
			// Dark Theme
			htmlReporter.config().setTheme(Theme.STANDARD);

		}

	}

	public static void startTest(String testName, String description, String categories) {

		ExtentTest test = extent.createTest(testName, description);
		test.assignCategory(categories);
		testMap.put(Thread.currentThread().getId(), test);

	}

	/**
	* =============================================================================
	* Method: logScreenShot | Author: Rajesh Buddha | Date:30 Jan 2020 | Description:
	* This method log take screenshot | Parameters: message | Return: none
	* =============================================================================
	* @param driver
	* @throws IOException
	*/
	public static void logScreenshot(WebDriver driver, String message) throws IOException {
	getCurrentTest().addScreenCaptureFromBase64String(ScreenshotUtil.takeScreenshot(driver), message);

	}

	public static void logPass(String message) {
		getCurrentTest().log(Status.PASS, message);

	}

	public static void logFail(String message) {
		getCurrentTest().log(Status.FAIL, message);

	}

	public static void logInfo(String message) {
		getCurrentTest().log(Status.INFO, message);

	}

	public static void endCurrentTest() {
		getCurrentTest().getExtent().flush();

		testMap.remove(Thread.currentThread().getId());
	}

	public static ExtentTest getCurrentTest() {
		return testMap.get(Thread.currentThread().getId());

	}

	public static void endReport() {

		extent.flush();
	}
	
	
	public static ExtentHtmlReporter htmlReporterMobile;
	public static ExtentReports extentMobile;
	public static Map<Long, ExtentTest> testMapMobile = new HashMap<>();

	public static void startReportMobile() {
		if (htmlReporter == null) {
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/MobileReports/Reliance.html");
			// Create an object of Extent Reports
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("Host Name", "Reliance");
			extent.setSystemInfo("Environment", "Production");
			extent.setSystemInfo("User Name", "Tester 1");
			htmlReporter.config().setDocumentTitle("Reliance POS Application");
			// Name of the report
			htmlReporter.config().setReportName("Reliance POS Application");
			htmlReporter.config().enableTimeline(true);
			htmlReporter.config().setAutoCreateRelativePathMedia(true);
			// Dark Theme
			htmlReporter.config().setTheme(Theme.STANDARD);

		}

	}

	public static void startTestMobile(String testName, String description, String categories) {

		ExtentTest test = extent.createTest(testName, description);
		test.assignCategory(categories);
		testMap.put(Thread.currentThread().getId(), test);

	}

	public static void logPassMobile(String message) {
		getCurrentTest().log(Status.PASS, message);

	}

	public static void logFailMobile(String message) {
		getCurrentTest().log(Status.FAIL, message);

	}

	public static void logInfoMobile(String message) {
		getCurrentTest().log(Status.INFO, message);

	}

	public static void endCurrentTestMobile() {
		getCurrentTest().getExtent().flush();

		testMap.remove(Thread.currentThread().getId());
	}

	public static ExtentTest getCurrentTestMobile() {
		return testMap.get(Thread.currentThread().getId());

	}

	public static void endReportMobile() {

		extent.flush();
	}

}
