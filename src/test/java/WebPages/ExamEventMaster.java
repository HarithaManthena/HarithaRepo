package WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import Utilities.DriverFactory;
import Utilities.ReportManager;
import WebUtil.WebActions;

public class ExamEventMaster {

	// Exam Event Master Test cases

	public static By examActivity = By.xpath("//span[.= 'Exam Activity']");
	public static By examEventMaster = By.xpath("//span[.= 'Exam Event Master']");
	public static By examEventMasterPage = By.xpath("//h1[contains(text(),'Exam Event Master ')]");

	public static By Institute = By.id("instituteid");
	public static By examEventCode = By.id("exameventcode");
	public static By examEventType = By.id("exameventtype");

	public static By activeCheckBox = By.xpath("//input[@name='deactive']");
	public static By activeText = By.xpath("//label[contains(text(),'Active')]");

	public static By examEventDescription = By.id("exameventdesc");
	public static By weightageTextBox = By.id("weightage");
	public static By maxMarksTextBox = By.id("maxmarks");
	public static By passingMarksTextBox = By.id("passingmarks");
	public static By totalSubEventConductedTextBox = By.id("totalsubeventconducted");
	public static By bestSubEventConsideredTextBox = By.id("bestsubeventconsidered");
	public static By saveButton = By.xpath("//button[@title = 'Save' and @type= 'submit']");

	static WebActions webActions = new WebActions();
	static JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();

	// TC_001
	public static void VerifyExamEventMasterAccess() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventMaster, "Exam Event Master");
		Thread.sleep(4000);

		String VerifyExamEventMasterPage = webActions.getText(examEventMasterPage);
		if (VerifyExamEventMasterPage.equalsIgnoreCase("Exam Event Master")) {
			ReportManager.logInfo("<b style=\"color:green;\"> *****Exam Event Master Page is displayed *****</b>");

		}

		else {
			ReportManager.logInfo("<b style=\"color:red;\"> *****Exam Event Master Page is not displayed *****</b>");
		}

	}

	// TC_002
	public static void VerifyInstituteDD() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventMaster, "Exam Event Master");
		Thread.sleep(4000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		Thread.sleep(4000);

		String str_InstituteDD = webActions.getText(Institute);
		if (str_InstituteDD.contains("School of Engineering and Applied Sciences")) {
			ReportManager.logInfo("<b style=\"color:green;\"> *****Institute Name is Selected *****</b>");

		}

		else {
			ReportManager.logInfo("<b style=\"color:red;\"> *****Institute Name is not Selected*****</b>");
		}
	}

//TC_003

	public static void VerifyExamEventTypeDD() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventMaster, "Exam Event Master");
		Thread.sleep(4000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		Thread.sleep(2000);
		webActions.selectByVisibleText(examEventType, "INTERN");

		String String_ExamEventDD = webActions.getText(examEventType);
		if (String_ExamEventDD.contains("INTERN")) {
			ReportManager.logInfo("<b style=\"color:green;\"> *****Exam Event Type is Selected*****</b>");

		}

		else {
			ReportManager.logInfo("<b style=\"color:red;\"> *****Exam Event Type is not Selected*****</b>");
		}
	}

//TC_004

	public static void VerifyActiveCheckbox() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventMaster, "Exam Event Master");
		Thread.sleep(4000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		Thread.sleep(2000);
		webActions.selectByVisibleText(examEventType, "INTERN");

		if(webActions.isDisplayed(activeText, "Active")) {

			ReportManager.logInfo("<b style=\"color:green;\"> *****Active CheckBox is checked*****</b>");

		}

		else {
			ReportManager.logInfo("<b style=\"color:red;\"> *****Active CheckBox is Unchecked*****</b>");
		}

	}

	
	// TC_005
	
	public static void VerifyDeActiveCheckBox() throws InterruptedException {
		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventMaster, "Exam Event Master");
		Thread.sleep(4000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		Thread.sleep(2000);
		
		if(webActions.isDisplayed(activeText, "Active")) {

			ReportManager.logInfo("<b style=\"color:red;\"> *****Active CheckBox is Enabled*****</b>");

		}

		else {
			ReportManager.logInfo("<b style=\"color:green;\"> *****Active CheckBox is Disabled*****</b>");
		}
		}

//TC_006
	
	public static void VerifySaveWithoutEventType() {
		
		
		
	}


}
