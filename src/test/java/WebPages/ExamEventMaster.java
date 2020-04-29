package WebPages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;

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
	public static By Problemalert = By.xpath("//div[contains(text(),'Please fill all required fields !!')]");
	public static By problemalertOK = By.xpath("//button[contains(text(),'OK')]");

	public static By subEventRequired = By.xpath("//input[@id='subevent']");
	public static By parentExamEventCode = By.xpath("//select[@id='parentexameventcode']");

	public static By inserted = By.xpath("//h2[contains(text(),'Inserted')]");
	public static By insertOKbutn = By.xpath("//button[contains(text(),'OK')]");

	public static By reset = By.xpath("//button[@title='Reset']");
	public static By noEventlistTable = By.xpath("//td[contains(text(),'No data available in table')]");

	public static By cancelbutn = By.xpath("//button[@title='Exit']");
	public static By dashboard = By.xpath("//h1[contains(text(),'Dashboard')]");
	
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

		if (webActions.isDisplayed(activeText, "Active")) {

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

		if (webActions.isDisplayed(activeText, "Active")) {

			ReportManager.logInfo("<b style=\"color:red;\"> *****Active CheckBox is Enabled*****</b>");

		}

		else {
			ReportManager.logInfo("<b style=\"color:green;\"> *****Active CheckBox is Disabled*****</b>");
		}
	}

//TC_006

	public static void VerifySaveWithoutEventType() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventMaster, "Exam Event Master");
		Thread.sleep(4000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		webActions.sendKeys(examEventCode, "FunctionalTest02");
		webActions.sendKeys(examEventDescription, "FunctionalTest02");
		webActions.sendKeys(weightageTextBox, "45");
		webActions.sendKeys(maxMarksTextBox, "100");
		webActions.sendKeys(passingMarksTextBox, "35");
		webActions.sendKeys(totalSubEventConductedTextBox, "2");
		webActions.sendKeys(bestSubEventConsideredTextBox, "1");
		Thread.sleep(2000);
		webActions.Click(saveButton, "Save Button");
		Thread.sleep(3000);

		String mandatoryfieldsalert = webActions.getText(Problemalert);
		if (mandatoryfieldsalert.equalsIgnoreCase("Please fill all required fields !!")) {
			webActions.Click(problemalertOK, "Ok");
			ReportManager.logInfo(
					"<b style=\"color:green;\"> *****Required Fields should be filled message is displayed-Exam Event Type*****</b>");
		} else {
			ReportManager.logInfo("<b style=\"color:red;\"> *****Alert message not displayed*****</b>");

		}
	}

//TC_007 - Doubt : Failed this Test case as Error message is not displayed
	public static void VerifyFeilds() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventMaster, "Exam Event Master");
		Thread.sleep(4000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");

		if (webActions.isEnabled(examEventCode, "Exam Event Code")) {

			webActions.sendKeys(examEventCode, "FunctionalEventCode01");
			ReportManager.logInfo("<b style=\"color:red;\"> ********No Error Message is Displayed*******</b>");

		} else {
			ReportManager.logInfo("<b style=\"color:green;\"> *****Error message is displayed*****</b>");

		}

		Assert.fail("Failed - As Error message is not suggested");
	}

//TC_008	
	public static void VerifySubEventRequiredChecked() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventMaster, "Exam Event Master");
		Thread.sleep(4000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		webActions.selectByVisibleText(examEventType, "INTERN");

		webActions.Click(subEventRequired, "Sub Event Required check box");

		if (webActions.isEnabled(parentExamEventCode, "Parent Exam code")) {

			webActions.Click(parentExamEventCode, "Parent Exam code");
			ReportManager.logInfo("<b style=\"color:green;\"> *****Parent Exam Event Code is Enabled*****</b>");

		} else {
			ReportManager.logInfo("<b style=\"color:red;\"> *****Parent Exam Event Code is not Enabled*****</b>");

		}

	}

//TC_009

	public static void VerifySubEventRequiredUnchecked() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventMaster, "Exam Event Master");
		Thread.sleep(5000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		webActions.selectByVisibleText(examEventType, "INTERN");

		webActions.isEnabled(subEventRequired, "Sub Event Required");

		if (webActions.isEnabled(parentExamEventCode, "Parent Exam code")) {

			ReportManager.logInfo("<b style=\"color:red;\"> *****Parent Exam Event Code is Enabled*****</b>");

		} else {
			ReportManager.logInfo("<b style=\"color:green;\"> *****Parent Exam Event Code is not Enabled*****</b>");

		}
	}

//TC_010
	public static void VerfiyExamEventCode() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventMaster, "Exam Event Master");
		Thread.sleep(5000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		webActions.selectByVisibleText(examEventType, "INTERN");

		if (webActions.isEnabled(examEventCode, "Exam Event Code")) {

			webActions.sendKeys(examEventCode, "FunctionalEventCode01");
			ReportManager.logInfo("<b style=\"color:green;\"> *****EventCode is Accepted*****</b>");

		} else {
			ReportManager.logInfo("<b style=\"color:red;\"> *****EventCode is not accepted*****</b>");

		}

	}

//TC_011
	public static void VerifySaveWithoutEventCode() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventMaster, "Exam Event Master");
		Thread.sleep(4000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		webActions.sendKeys(examEventType, "INTERN");

		webActions.sendKeys(examEventDescription, "FunctionalTest02");
		webActions.sendKeys(weightageTextBox, "45");
		webActions.sendKeys(maxMarksTextBox, "100");
		webActions.sendKeys(passingMarksTextBox, "35");
		webActions.sendKeys(totalSubEventConductedTextBox, "2");
		webActions.sendKeys(bestSubEventConsideredTextBox, "1");
		Thread.sleep(2000);
		webActions.Click(saveButton, "Save Button");
		Thread.sleep(3000);

		String mandatoryfieldsalert = webActions.getText(Problemalert);
		if (mandatoryfieldsalert.equalsIgnoreCase("Please fill all required fields !!")) {
			webActions.Click(problemalertOK, "Ok");
			ReportManager.logInfo(
					"<b style=\"color:green;\"> *****Required Fields should be filled message is displayed - Exam Event Code*****</b>");
		} else {
			ReportManager.logInfo("<b style=\"color:red;\"> *****Alert message not displayed*****</b>");

		}
	}
//TC_012

	public static void VerifyNumericFieldsValidData() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventMaster, "Exam Event Master");
		Thread.sleep(4000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		webActions.selectByVisibleText(examEventType, "INTERN");
		webActions.clearAndSendKeys(examEventCode, "FunctionalTest02");
		webActions.sendKeys(examEventDescription, "FunctionalTest02");
		webActions.sendKeys(weightageTextBox, "45");
		webActions.sendKeys(maxMarksTextBox, "100");
		webActions.sendKeys(passingMarksTextBox, "35");
		webActions.sendKeys(totalSubEventConductedTextBox, "2");
		webActions.sendKeys(bestSubEventConsideredTextBox, "1");
		Thread.sleep(2000);
		webActions.Click(saveButton, "Save Button");
		Thread.sleep(3000);

		String updatepopup = webActions.getText(inserted);
		if (updatepopup.equalsIgnoreCase("Inserted")) {
			webActions.Click(insertOKbutn, "Data Inserted Successfully");

			ReportManager.logInfo(
					"<b style=\"color:green;\"> *****Numeric feilds accepted numbers and Data Inserted Successfully*****</b>");
			Thread.sleep(2000);

		} else {
			ReportManager.logInfo("<b style=\"color:red;\"> *****Data not Updated*****</b>");
			Thread.sleep(2000);
		}
	}

//TC_013 : No alert message is displayed to verify

	public static void VerifyNumericfiedlswithCHARACTERS() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventMaster, "Exam Event Master");
		Thread.sleep(4000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		webActions.selectByVisibleText(examEventType, "INTERN");
		webActions.clearAndSendKeys(examEventCode, "FunctionalTest02");
		webActions.sendKeys(examEventDescription, "FunctionalTest02");
		webActions.sendKeys(weightageTextBox, "abcd");
		webActions.sendKeys(maxMarksTextBox, "abcd");
		webActions.sendKeys(passingMarksTextBox, "abcd");
		webActions.sendKeys(totalSubEventConductedTextBox, "abc");
		webActions.sendKeys(bestSubEventConsideredTextBox, "abc");
		Thread.sleep(2000);
		webActions.Click(saveButton, "Save Button");
		Thread.sleep(3000);

		try {
			String alert = webActions.getText(inserted);
			System.out.println("alert is present");
			ReportManager.logInfo("<b style=\"color:green;\"> *****Data Inserted Successfully*****</b>");
			Thread.sleep(2000);
		}

		catch (NoAlertPresentException e) {
			System.out.println("alert is not present");
			ReportManager.logInfo("<b style=\"color:green;\"> *****No Error Message is displayed*****</b>");
			Thread.sleep(2000);
		}
	}

//TC_014: No alert message is displayed to verify

	public static void VerifyNumericfiedlswithALPHANUMERICS() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventMaster, "Exam Event Master");
		Thread.sleep(4000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		webActions.selectByVisibleText(examEventType, "INTERN");
		webActions.clearAndSendKeys(examEventCode, "FunctionalTest02");
		webActions.sendKeys(examEventDescription, "FunctionalTest02");
		webActions.sendKeys(weightageTextBox, "abcd12");
		webActions.sendKeys(maxMarksTextBox, "abcd12");
		webActions.sendKeys(passingMarksTextBox, "abcd");
		webActions.sendKeys(totalSubEventConductedTextBox, "abc12");
		webActions.sendKeys(bestSubEventConsideredTextBox, "abc12");
		Thread.sleep(2000);
		webActions.Click(saveButton, "Save Button");
		Thread.sleep(3000);

		try {
			String alert = webActions.getText(inserted);
			System.out.println("alert is present");
			ReportManager.logInfo("<b style=\"color:green;\"> *****Data Inserted Successfully*****</b>");
			Thread.sleep(2000);
		}

		catch (NoAlertPresentException e) {
			System.out.println("alert is not present");
			ReportManager.logInfo("<b style=\"color:green;\"> *****No Error Message is displayed*****</b>");
			Thread.sleep(2000);
		}
	}

//TC_015: No alert message is displayed to verify

	public static void VerifyNumericfiedlswithSPECIALCHARS() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventMaster, "Exam Event Master");
		Thread.sleep(4000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		webActions.selectByVisibleText(examEventType, "INTERN");
		webActions.clearAndSendKeys(examEventCode, "FunctionalTest02");
		webActions.sendKeys(examEventDescription, "FunctionalTest02");
		webActions.sendKeys(weightageTextBox, "@#$");
		webActions.sendKeys(maxMarksTextBox, "$$$");
		webActions.sendKeys(passingMarksTextBox, "@@@");
		webActions.sendKeys(totalSubEventConductedTextBox, "$#@");
		webActions.sendKeys(bestSubEventConsideredTextBox, "#$@");
		Thread.sleep(2000);
		webActions.Click(saveButton, "Save Button");
		Thread.sleep(3000);

		try {
			String alert = webActions.getText(inserted);
			System.out.println("alert is present");
			ReportManager.logInfo("<b style=\"color:green;\"> *****Data Inserted Successfully*****</b>");
			Thread.sleep(2000);
		}

		catch (NoAlertPresentException e) {
			System.out.println("alert is not present");
			ReportManager.logInfo("<b style=\"color:green;\"> *****No Error Message is displayed*****</b>");
			Thread.sleep(2000);
		}
	}

//TC_16
	public static void VerifySaveOption() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventMaster, "Exam Event Master");
		Thread.sleep(5000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		webActions.selectByVisibleText(examEventType, "INTERN");
		webActions.clearAndSendKeys(examEventCode, "FunctionalTest03");
		webActions.sendKeys(examEventDescription, "FunctionalTest03");
		webActions.sendKeys(weightageTextBox, "45");
		webActions.sendKeys(maxMarksTextBox, "100");
		webActions.sendKeys(passingMarksTextBox, "35");
		webActions.sendKeys(totalSubEventConductedTextBox, "2");
		webActions.sendKeys(bestSubEventConsideredTextBox, "1");
		Thread.sleep(2000);
		webActions.Click(saveButton, "Save Button");
		Thread.sleep(3000);

		String updatepopup = webActions.getText(inserted);
		if (updatepopup.equalsIgnoreCase("Inserted")) {
			webActions.Click(insertOKbutn, "Data Inserted Successfully");

			ReportManager.logInfo("<b style=\"color:green;\"> *****Data Inserted Successfully*****</b>");
			Thread.sleep(2000);

		} else {
			ReportManager.logInfo("<b style=\"color:red;\"> *****Data not Updated*****</b>");
			Thread.sleep(2000);
		}
	}

//TC_17
	public static void VerifySaveWithBlankData() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventMaster, "Exam Event Master");
		Thread.sleep(4000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		webActions.selectByVisibleText(examEventType, "INTERN");
		webActions.clearAndSendKeys(examEventCode, "");
		webActions.sendKeys(examEventDescription, "");
		webActions.sendKeys(weightageTextBox, "");
		webActions.sendKeys(maxMarksTextBox, "");
		webActions.sendKeys(passingMarksTextBox, "");
		webActions.sendKeys(totalSubEventConductedTextBox, "");
		webActions.sendKeys(bestSubEventConsideredTextBox, "");
		Thread.sleep(2000);
		webActions.Click(saveButton, "Save Button");
		Thread.sleep(3000);

		String mandatoryfieldsalert = webActions.getText(Problemalert);
		if (mandatoryfieldsalert.equalsIgnoreCase("Please fill all required fields !!")) {
			webActions.Click(problemalertOK, "Ok");
			ReportManager.logInfo(
					"<b style=\"color:green;\"> *****Required Fields should be filled message is displayed - Exam Event Code*****</b>");
		} else {
			ReportManager.logInfo("<b style=\"color:red;\"> *****Alert message not displayed*****</b>");

		}
	}

//TC_18
	public static void VerifyRestButton() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventMaster, "Exam Event Master");
		Thread.sleep(5000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		webActions.selectByVisibleText(examEventType, "INTERN");
		webActions.clearAndSendKeys(examEventCode, "FunctionalTest03");
		webActions.sendKeys(examEventDescription, "FunctionalTest03");
		webActions.sendKeys(weightageTextBox, "45");
		webActions.sendKeys(maxMarksTextBox, "100");
		webActions.sendKeys(passingMarksTextBox, "35");
		webActions.sendKeys(totalSubEventConductedTextBox, "2");
		webActions.sendKeys(bestSubEventConsideredTextBox, "1");
		Thread.sleep(2000);
		webActions.Click(reset, "Rest");
		String NoEventsList = webActions.getText(noEventlistTable);
		if (NoEventsList.equalsIgnoreCase("No data available in table")) {

			ReportManager.logInfo("<b style=\"color:green;\"> *********All fields got reset********</b>");

		} else {
			ReportManager.logInfo("<b style=\"color:red;\"> *********Rest Button not working********</b>");

		}

	}
//TC_20
	
	public static void VerifyCancelButton() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventMaster, "Exam Event Master");
		Thread.sleep(5000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		webActions.selectByVisibleText(examEventType, "INTERN");
		webActions.clearAndSendKeys(examEventCode, "FunctionalTest03");
		webActions.sendKeys(examEventDescription, "FunctionalTest03");
		webActions.sendKeys(weightageTextBox, "45");
		webActions.sendKeys(maxMarksTextBox, "100");
		webActions.sendKeys(passingMarksTextBox, "35");
		webActions.sendKeys(totalSubEventConductedTextBox, "2");
		webActions.sendKeys(bestSubEventConsideredTextBox, "1");
		Thread.sleep(2000);
		
		webActions.Click(cancelbutn, "Cancel");
		
		String Dashboard = webActions.getText(dashboard);
		if (Dashboard.equalsIgnoreCase("Dashboard")) {

			ReportManager.logInfo("<b style=\"color:green;\"> *********Exam Event Master Page cancelled and returned to Dashboard page********</b>");

		} else {
			ReportManager.logInfo("<b style=\"color:red;\"> *********Cancel Button not working********</b>");

		}
		
}
}
