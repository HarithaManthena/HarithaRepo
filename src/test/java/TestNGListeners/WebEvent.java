package TestNGListeners;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Utilities.ConfigReader;
import Utilities.DriverFactory;
import Utilities.InitDriver;
import Utilities.ReportManager;
import Utilities.VideoReord;

public class WebEvent implements ITestListener {

	InitDriver initDriver = new InitDriver();
	
	@Override
	public void onTestStart(ITestResult arg0) {
		ReportManager.startTest(arg0.getMethod().getMethodName(), arg0.getMethod().getDescription(),
				ConfigReader.getValue("Execution_Web"));
		try {
			
			initDriver.startWebDriver();
			//VideoReord.startRecord(arg0.getMethod().getMethodName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println("Test Success: " + iTestResult.getMethod().getMethodName());
		System.out.println("--------------------------------");
		ReportManager.logPass("Test case passed");
		ReportManager.endCurrentTest();
		try {
			initDriver.tearDownWebDriver();
		} catch (MalformedURLException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("Test Fail: " + iTestResult.getMethod().getMethodName());
		ReportManager.logFail(iTestResult.getThrowable().toString());
		try {
			ReportManager.logScreenshot(DriverFactory.getInstance().getWebDriver(), iTestResult.getMethod().getMethodName());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ReportManager.logFail("Test case Fail");
		ReportManager.endCurrentTest();
		try {
			//VideoReord.stopRecord();
			initDriver.tearDownWebDriver();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext arg0) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

}
