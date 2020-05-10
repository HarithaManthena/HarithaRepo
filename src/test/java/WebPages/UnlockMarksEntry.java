package WebPages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Utilities.DriverFactory;
import Utilities.ReportManager;
import WebUtil.WebActions;

public class UnlockMarksEntry {

	public static By examActivity = By.xpath("//span[.= 'Exam Activity']");
	public static By unlockMarksEntry = By.xpath("//span[contains(text(),'Unlock Marks Entry')]");
	public static By unlockMarksEntryPage = By.xpath("//h1[contains(text(),' Marks Entry Lock Unlock ')]");

	public static By Institute = By.id("instituteid");
	public static By registrationCode = By.xpath("//select[@id='regcodeid']");
	public static By examEventCode = By.xpath("//select[@id='exameventid']");
	public static By subjects = By.xpath("//span[contains(text(),'--Select Subjects--')]");
	public static By listOfSubjects = By.xpath("//ul[@class='item2']//li//descendant::div['_ngcontent-c15']");

	public static By getDetailsButton = By.xpath("//button[@class = 'btn btn-success' and @title = 'get details']");
	public static By getDetailsTableHeader = By.xpath("//table[@class='table table-bordered']/thead/tr/td");
	public static By getDetailsTableRows = By.xpath("//table[@class='table table-bordered']/tbody/tr");
	public static By mandatoryField_msg = By.xpath("//h2[text()='Mandatory Field']");
	public static By mandatoryField_missedSubject = By.xpath("//div[text()='First select Subject(s) !']");
	public static By OKButn = By.xpath("//button[text()='OK']");
	public static By instituteDDText = By.xpath("//option[text()='--Select Institute--']");
	public static By resetButton = By.xpath("//button[@title='Reset']");
	public static By cancelButton = By.xpath("//button[@title='Exit']");
	public static By dashboardText = By.xpath("//h1[text()=' Dashboard ']");
	public static By checkBox = By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[1]"); // specified
																										// position
	public static By getDetailsTableCol = By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td");

	public static By fromDate = By.xpath("//input[@id='fromdate']");
	public static By fromDateList = By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td");

	public static By toDate = By.xpath("//input[@id='todate']");
	public static By toDateList = By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td");

	public static By accept = By.xpath("//button[text()='Accept ']");
	public static By Info_ErrorAlert = By.xpath("//div[text()='Please Select Row(s) From the Table.']");
	public static By OK = By.xpath("//button[text()='OK']");

	public static By facultyNameColumnInSearchOutput = By.xpath("//table[@class = 'table table-bordered']//td[6]");
	public static By SNoCheckboxInSearchOutput = By.xpath("//table[@class = 'table table-bordered']//td[1]/input");
	public static By fromDateColumnList = By.xpath("//table[@class = 'table table-bordered']//td[8]");
	public static By toDateColumnList = By.xpath("//table[@class = 'table table-bordered']//td[9]");
	public static By lockExamMarksColumnList = By.xpath("//table[@class = 'table table-bordered']//td[10]//input");

	public static By lockExamMarksCheckbox = By
			.xpath("//table[@class = 'table table-bordered']//td[.='Lock Exam Marks']/input");
	public static By acceptButton = By.xpath("//button[.='Accept ']");
	public static By saveButtonForChanges = By.xpath("//button[@class = 'btn btn-success' and @title = 'save']");
	public static By dataupdatedMsg = By.xpath("//div[text()='Data Updated Successfully. !!!']");

	static WebActions webActions = new WebActions();
	static JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();

	// TC_01
	public static void UnlockMarksEntryPageVrftn() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(unlockMarksEntry, "Unlock Marks Entry");

		Thread.sleep(4000);

		String VerifyUnlockMarksEntryPage = webActions.getText(unlockMarksEntryPage);
		if (VerifyUnlockMarksEntryPage.equalsIgnoreCase("Marks Entry Lock Unlock")) {
			ReportManager.logInfo("<b style=\"color:green;\"> *****Unlock Marks Entry Page is displayed *****</b>");

		}

		else {
			ReportManager.logInfo("<b style=\"color:red;\"> *****Unlock Marks Entry Page is not displayed *****</b>");
		}
	}

//TC_02
	public static void UMInsitituteDD() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(unlockMarksEntry, "Unlock Marks Entry");
		Thread.sleep(4000);

		if (webActions.isDisplayed(Institute, "Institute")) {

			webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
			Thread.sleep(4000);

			ReportManager.logInfo("<b style=\"color:green;\"> *****Institute Name is Selected *****</b>");

		} else {
			ReportManager.logInfo("<b style=\"color:green;\"> *****Institute Name is not Selected *****</b>");

		}

	}
//TC_03

	public static void UMRegistrationDD() throws InterruptedException {
		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(unlockMarksEntry, "Unlock Marks Entry");
		Thread.sleep(5000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");

		if (webActions.isDisplayed(registrationCode, "Registration Code")) {

			webActions.selectByVisibleText(registrationCode, "1920_EVEN_SEMESTER");
			Thread.sleep(2000);

			ReportManager.logInfo("<b style=\"color:green;\"> *****Registration Code is Selected *****</b>");

		} else {
			ReportManager.logInfo("<b style=\"color:green;\"> *****Registration Code is not Selected *****</b>");
		}

	}

//TC_004
	public static void UMExamEventCodeDD() throws InterruptedException {
		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(unlockMarksEntry, "Unlock Marks Entry");
		Thread.sleep(4000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");

		webActions.selectByVisibleText(registrationCode, "1920_EVEN_SEMESTER");
		ReportManager.logInfo("Registration Code - <b style=\"color:green;\">\"1920_EVEN_SEMESTER\"</b> ");

		if (webActions.isDisplayed(examEventCode, "Exam Event Code")) {

			webActions.selectByVisibleText(examEventCode, " Presentation - Presentation ");
			Thread.sleep(3000);

			ReportManager.logInfo("<b style=\"color:green;\"> *****Exam Event code is Selected *****</b>");

		} else {
			ReportManager.logInfo("<b style=\"color:green;\"> *****Exam Event code is not Selected *****</b>");
		}

	}

	// TC_05
	public static void UMSubjectsDD() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(unlockMarksEntry, "Unlock Marks Entry");
		Thread.sleep(4000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");

		webActions.selectByVisibleText(registrationCode, "1920_EVEN_SEMESTER");
		ReportManager.logInfo("Registration Code - <b style=\"color:green;\">\"1920_EVEN_SEMESTER\"</b> ");

		webActions.selectByVisibleText(examEventCode, " Presentation - Presentation ");
		Thread.sleep(3000);
		// ReportManager.logInfo("<b style=\"color:green;\"> *****Exam Event code is
		// Selected *****</b>");

		webActions.Click(subjects, "Subjects");
		List<WebElement> List_subjects = webActions.getListOfWebElements(listOfSubjects);
		System.out.println("Total number of search in list" + List_subjects.size());

		for (int i = 0; i < List_subjects.size(); i++) {
			System.out.println(List_subjects.get(i).getText());
			if (List_subjects.get(i).getText().contains("(EECE804L) ANTENNA THEORY AND DESIGN")) {
				List_subjects.get(i).click();
				System.out.println("Selected Subject from DD");

				ReportManager.logInfo(
						"<b style=\"color:green;\"> ******(EECE804L) ANTENNA THEORY AND DESIGN Subject is Selected from dropdown *****</b>");

				break;
			} else {

				ReportManager
						.logInfo("<b style=\"color:green;\"> ******Subject is not Selected from dropdown *****</b>");

			}
		}
	}

	// TC_06
	public static void UM_VerifyGetDetailsOptn() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(unlockMarksEntry, "Unlock Marks Entry");
		Thread.sleep(6000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		Thread.sleep(4000);

		webActions.selectByVisibleText(registrationCode, "1920_EVEN_SEMESTER");
		ReportManager.logInfo("Registration Code - <b style=\"color:green;\">\"1920_EVEN_SEMESTER\"</b> ");
		Thread.sleep(3000);

		webActions.selectByVisibleText(examEventCode, " Presentation - Presentation ");
		Thread.sleep(3000);

		webActions.Click(subjects, "Subjects");
		List<WebElement> List_subjects = webActions.getListOfWebElements(listOfSubjects);
		System.out.println("Total number of search in list" + List_subjects.size());

		for (int i = 0; i < List_subjects.size(); i++) {
			System.out.println(List_subjects.get(i).getText());
			if (List_subjects.get(i).getText().contains("(EECE804L) ANTENNA THEORY AND DESIGN")) {
				List_subjects.get(i).click();
				System.out.println("Selected Subject from DD");
				ReportManager.logInfo(
						"Subject Code - <b style=\"color:green;\">\"(EECE804L) ANTENNA THEORY AND DESIGN\"</b> ");
				Thread.sleep(3000);

			}
			if (webActions.isDisplayed(getDetailsButton, "Get Details")) {
				webActions.Click(getDetailsButton, "get Deatils option");
				Thread.sleep(2000);
				System.out.println("Get Details options selected");
				ReportManager.logInfo("<b style=\"color:green;\"> ******Get Details option selected *****</b>");
			}

			if (webActions.isDisplayed(getDetailsTableHeader, "Table Header")) {
				List<WebElement> TotalTableRows = webActions.getListOfWebElements(getDetailsTableRows);
				int count = TotalTableRows.size();
				System.out.println("No. of rows in table " + count + " ");

				ReportManager.logInfo("<b style=\"color:green;\"> ****** Details table is displayed*****</b>");
				break;
			} else {
				ReportManager.logInfo("<b style=\"color:red;\"> ******Get Details Option not Clicked*****</b>");

			}
		}
	}

//TC_07

	public static void UM_GetDetails_Without_ReqFieldSelection() throws InterruptedException {
		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(unlockMarksEntry, "Unlock Marks Entry");
		Thread.sleep(6000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		Thread.sleep(4000);

		webActions.selectByVisibleText(registrationCode, "1920_EVEN_SEMESTER");
		ReportManager.logInfo("Registration Code - <b style=\"color:green;\">\"1920_EVEN_SEMESTER\"</b> ");
		Thread.sleep(3000);

		webActions.selectByVisibleText(examEventCode, " Presentation - Presentation ");
		Thread.sleep(3000);

		webActions.Click(getDetailsButton, "get Deatils option");
		Thread.sleep(2000);

		String Mandatory_Msg = webActions.getText(mandatoryField_missedSubject);
		if (Mandatory_Msg.equalsIgnoreCase("First select Subject(s) !")) {
			System.out.println("Mandatory Field is not selected");
			ReportManager.logInfo("<b style=\"color:red;\"> ****Please Select Mandatory Fields****</b>");

		} else {
			ReportManager.logInfo("<b style=\"color:red;\"> ****No Error Alert Displayed****</b>");

		}
	}

//TC_08
	public static void UM_VerifyRestButn() throws InterruptedException {
		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(unlockMarksEntry, "Unlock Marks Entry");
		Thread.sleep(6000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		Thread.sleep(4000);

		webActions.selectByVisibleText(registrationCode, "1920_EVEN_SEMESTER");
		ReportManager.logInfo("Registration Code - <b style=\"color:green;\">\"1920_EVEN_SEMESTER\"</b> ");
		Thread.sleep(3000);

		webActions.selectByVisibleText(examEventCode, " Presentation - Presentation ");
		Thread.sleep(3000);

		webActions.Click(resetButton, "Rest Button");
		Thread.sleep(2000);

		if (webActions.isDisplayed(instituteDDText, "Select Institute")) {

			ReportManager.logInfo("<b style=\"color:green;\"> *****Fields got reset *****</b>");

		} else {
			ReportManager.logInfo("<b style=\"color:red;\"> *****Fields didn't got reset *****</b>");

		}
	}

//TC_09
	public static void UM_VerifyCancelButn() throws InterruptedException {
		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(unlockMarksEntry, "Unlock Marks Entry");
		Thread.sleep(6000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		Thread.sleep(4000);

		webActions.selectByVisibleText(registrationCode, "1920_EVEN_SEMESTER");
		ReportManager.logInfo("Registration Code - <b style=\"color:green;\">\"1920_EVEN_SEMESTER\"</b> ");
		Thread.sleep(3000);

		webActions.selectByVisibleText(examEventCode, " Presentation - Presentation ");
		Thread.sleep(3000);

		webActions.Click(subjects, "Subjects");
		List<WebElement> List_subjects = webActions.getListOfWebElements(listOfSubjects);
		System.out.println("Total number of search in list" + List_subjects.size());

		for (int i = 0; i < List_subjects.size(); i++) {
			System.out.println(List_subjects.get(i).getText());
			if (List_subjects.get(i).getText().contains("(EECE804L) ANTENNA THEORY AND DESIGN")) {
				List_subjects.get(i).click();
				System.out.println("Selected Subject from DD");
				ReportManager.logInfo(
						"Subject Code - <b style=\"color:green;\">\"(EECE804L) ANTENNA THEORY AND DESIGN\"</b> ");
				Thread.sleep(3000);

			}
			if (webActions.isDisplayed(getDetailsButton, "Get Details")) {
				webActions.Click(getDetailsButton, "get Deatils option");
				Thread.sleep(2000);
				System.out.println("Get Details options selected");
				ReportManager.logInfo("<b style=\"color:green;\"> ******Get Details option selected *****</b>");
			}

			webActions.Click(cancelButton, "Cancel Button");
			Thread.sleep(2000);

			String Dashboard = webActions.getText(dashboardText);
			if (Dashboard.equalsIgnoreCase("Dashboard")) {

				ReportManager.logInfo(
						"<b style=\"color:green;\"> *********Marks Upload page cancelled and returned to Dashboard page********</b>");
				break;

			} else {
				ReportManager.logInfo("<b style=\"color:red;\"> *********Cancel Button not working********</b>");

			}
		}
	}
//TC_10

	public static void UM_Verify_GetDetails_TableHeader() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(unlockMarksEntry, "Unlock Marks Entry");
		Thread.sleep(6000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		Thread.sleep(4000);

		webActions.selectByVisibleText(registrationCode, "1920_EVEN_SEMESTER");
		ReportManager.logInfo("Registration Code - <b style=\"color:green;\">\"1920_EVEN_SEMESTER\"</b> ");
		Thread.sleep(3000);

		webActions.selectByVisibleText(examEventCode, " Presentation - Presentation ");
		Thread.sleep(3000);

		webActions.Click(subjects, "Subjects");
		List<WebElement> List_subjects = webActions.getListOfWebElements(listOfSubjects);

		for (int i = 0; i < List_subjects.size(); i++) {
			String str_subj = List_subjects.get(i).getText();

			if (str_subj.equalsIgnoreCase("(EECE804L) ANTENNA THEORY AND DESIGN")) {
				List_subjects.get(i).click();
				System.out.println("Selected Subject from DD");
				ReportManager.logInfo(
						"Subject Code - <b style=\"color:green;\">\"(EECE804L) ANTENNA THEORY AND DESIGN\"</b> ");
			}
		}

		webActions.Click(getDetailsButton, "get Deatils option");

		List<WebElement> list_TableHeaders = webActions.getListOfWebElements(getDetailsTableHeader);
		for (int j = 0; j < list_TableHeaders.size(); j++) {

			String str_TableHeaders = list_TableHeaders.get(j).getText();
			ReportManager.logInfo("Table Headers - <b style=\"color:green;\">" + str_TableHeaders + "</b>");
		}

		if ((webActions.isDisplayed(getDetailsTableHeader, "Table Header"))) {

			List<WebElement> TotalTableRows = webActions.getListOfWebElements(getDetailsTableRows);
			int rowcount = TotalTableRows.size();
			System.out.println("No. of rows in table " + rowcount + " ");

			ReportManager.logInfo("No. of rows in table - <b style=\"color:green;\">" + rowcount + "</b>");
		}

		if ((webActions.isDisplayed(getDetailsTableHeader, "Table Header"))) {
			List<WebElement> TotalTablecolumns = webActions.getListOfWebElements(getDetailsTableCol);
			int Colcount = TotalTablecolumns.size();
			System.out.println("No. of columns in table " + Colcount + " ");
			ReportManager.logInfo("No. of columns in table - <b style=\"color:green;\">" + Colcount + "</b>");

			ReportManager
					.logInfo("<b style=\"color:green;\"> ******Grid Table with Required Details are present*****</b>");

		} else {
			ReportManager
					.logInfo("<b style=\"color:red;\"> ******Grid Table with Required Details not present*****</b>");

		}
	}

//TC_11

	public static void UM_Verify_Checkbox_DetailsTable() throws InterruptedException {
		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(unlockMarksEntry, "Unlock Marks Entry");
		Thread.sleep(6000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		Thread.sleep(4000);

		webActions.selectByVisibleText(registrationCode, "1920_EVEN_SEMESTER");
		ReportManager.logInfo("Registration Code - <b style=\"color:green;\">\"1920_EVEN_SEMESTER\"</b> ");
		Thread.sleep(3000);

		webActions.selectByVisibleText(examEventCode, " Presentation - Presentation ");
		Thread.sleep(3000);

		webActions.Click(subjects, "Subjects");
		List<WebElement> List_subjects = webActions.getListOfWebElements(listOfSubjects);

		for (int i = 0; i < List_subjects.size(); i++) {
			String str_subj = List_subjects.get(i).getText();

			if (str_subj.equalsIgnoreCase("(EECE804L) ANTENNA THEORY AND DESIGN")) {
				List_subjects.get(i).click();
				System.out.println("Selected Subject from DD");
				ReportManager.logInfo(
						"Subject Code - <b style=\"color:green;\">\"(EECE804L) ANTENNA THEORY AND DESIGN\"</b> ");
			}
		}

		webActions.Click(getDetailsButton, "get Deatils option");
		Thread.sleep(2000);
		System.out.println("Get Details options selected");

		if (webActions.isSelected(checkBox, "Check Box")) {
			webActions.Click(checkBox, "check Box");
			ReportManager.logInfo("<b style=\"color:green;\"> ******CheckBox is enabled and Checked*****</b>");
		} else {
			ReportManager.logInfo("<b style=\"color:green;\"> ******CheckBox is not Checked*****</b>");

		}
	}

//TC_12 
	public static void UM_Save_Without_RowSelection() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(unlockMarksEntry, "Unlock Marks Entry");
		Thread.sleep(6000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		Thread.sleep(4000);

		webActions.selectByVisibleText(registrationCode, "1920_EVEN_SEMESTER");
		ReportManager.logInfo("Registration Code - <b style=\"color:green;\">\"1920_EVEN_SEMESTER\"</b> ");
		Thread.sleep(2000);

		webActions.selectByVisibleText(examEventCode, " Presentation - Presentation ");
		Thread.sleep(3000);

		webActions.Click(subjects, "Subjects");
		List<WebElement> List_subjects = webActions.getListOfWebElements(listOfSubjects);

		for (int i = 0; i < List_subjects.size(); i++) {
			String str_subj = List_subjects.get(i).getText();

			if (str_subj.equalsIgnoreCase("(EECE804L) ANTENNA THEORY AND DESIGN")) {
				List_subjects.get(i).click();
				System.out.println("Selected Subject from DD");
				ReportManager.logInfo(
						"Subject Code - <b style=\"color:green;\">\"(EECE804L) ANTENNA THEORY AND DESIGN\"</b> ");
			}
		}

		webActions.Click(getDetailsButton, "get Deatils option");
		Thread.sleep(2000);

		webActions.Click(fromDate, "1-05-2020");
		Thread.sleep(2000);
		List<WebElement> allFromDates = webActions.getListOfWebElements(fromDateList);

		for (WebElement ele : allFromDates) {

			String date = ele.getText();

			if (date.contains("1")) {
				ele.click();
				break;
			}
		}

		webActions.Click(toDate, "7-05-2020");
		Thread.sleep(2000);
		List<WebElement> alltoDates = webActions.getListOfWebElements(toDateList);

		for (WebElement ele : alltoDates) {

			String date = ele.getText();

			if (date.contains("7")) {
				ele.click();
				Thread.sleep(2000);
				break;
			}
		}

		Thread.sleep(2000);
		webActions.Click(accept, "Accept");

		String InfoAlert = webActions.getText(Info_ErrorAlert);
		if (InfoAlert.equalsIgnoreCase("Please Select Row(s) From the Table.")) {
			webActions.Click(OK, "OK");
			ReportManager
					.logInfo("Error Alert - <b style=\"color:red;\">\"Please Select Row(s) From the Table.\"</b> ");

		}

		else {
			ReportManager.logInfo("<b style=\"color:red;\">\"No Error Message is Displayed\"</b> ");

		}
	}

//TC_13
	public static void UM_EditDates_AfterRwoSelection() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(unlockMarksEntry, "Unlock Marks Entry");
		Thread.sleep(3000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		Thread.sleep(3000);

		webActions.selectByVisibleText(registrationCode, "1920_EVEN_SEMESTER");
		ReportManager.logInfo("Registration Code - <b style=\"color:green;\">\"1920_EVEN_SEMESTER\"</b> ");
		Thread.sleep(3000);

		webActions.selectByVisibleText(examEventCode, " Presentation - Presentation ");
		Thread.sleep(3000);

		webActions.Click(subjects, "Subjects");
		List<WebElement> List_subjects = webActions.getListOfWebElements(listOfSubjects);

		for (int i = 0; i < List_subjects.size(); i++) {
			String str_subj = List_subjects.get(i).getText();

			if (str_subj.equalsIgnoreCase("(EECE804L) ANTENNA THEORY AND DESIGN")) {
				List_subjects.get(i).click();
				System.out.println("Selected Subject from DD");
				ReportManager.logInfo(
						"Subject Code - <b style=\"color:green;\">\"(EECE804L) ANTENNA THEORY AND DESIGN\"</b> ");

			}
		}

		webActions.Click(getDetailsButton, "get Deatils option");
		System.out.println("Clicked Get Details Option");
		Thread.sleep(5000);

		List<WebElement> list_facultyName = webActions.getListOfWebElements(facultyNameColumnInSearchOutput);
		List<WebElement> list_checkbox = webActions.getListOfWebElements(SNoCheckboxInSearchOutput);

		for (int j = 0; j < list_facultyName.size(); j++) {
			String str_facultyName = list_facultyName.get(j).getText();

			System.out.println(str_facultyName);
			if (str_facultyName.equalsIgnoreCase("(15120047) ARVIND KUMAR")) {
				System.out.println("mentioned faculty is present");
				list_checkbox.get(j).click();
				ReportManager.logInfo("Row got selected");
			}

		}

		Thread.sleep(1000);

		webActions.Click(fromDate, "1-05-2020");
		Thread.sleep(2000);
		List<WebElement> allFromDates = webActions.getListOfWebElements(fromDateList);

		for (WebElement ele : allFromDates) {

			String date = ele.getText();

			if (date.contains("1")) {
				ele.click();
				break;
			}
		}

		webActions.Click(toDate, "7-05-2020");
		Thread.sleep(2000);
		List<WebElement> alltoDates = webActions.getListOfWebElements(toDateList);

		for (WebElement ele : alltoDates) {

			String date = ele.getText();

			if (date.contains("7")) {
				ele.click();
				Thread.sleep(2000);
				break;
			}
		}

		Thread.sleep(2000);
		webActions.Click(accept, "Accept");
		ReportManager.logInfo("<b style=\"color:green;\">\"Dates updated Successfully\"</b> ");

		List<WebElement> FacultyNameCol = webActions.getListOfWebElements(facultyNameColumnInSearchOutput);
		List<WebElement> CheckBoxCol = webActions.getListOfWebElements(SNoCheckboxInSearchOutput);
		List<WebElement> fromDateCol = webActions.getListOfWebElements(fromDateColumnList);
		List<WebElement> toDateCol = webActions.getListOfWebElements(toDateColumnList);

		for (int i = 0; i < FacultyNameCol.size(); i++) {
			String str_FacultyName = FacultyNameCol.get(i).getText();
			if (str_FacultyName.equalsIgnoreCase("(15120047) ARVIND KUMAR"))
				System.out.println("Faculty is present");
			CheckBoxCol.get(i).click();

			String fromdateVrftn = fromDateCol.get(i).getText();
			if (fromdateVrftn.equalsIgnoreCase("01/05/2020")) {
				ReportManager
						.logInfo("From Date after updating:- <b style=\"color:green;\">" + fromdateVrftn + "</b> ");

				String todateVrftn = toDateCol.get(i).getText();
				if (todateVrftn.equalsIgnoreCase("07/05/2020")) {
					ReportManager
							.logInfo("To Date after updating:- <b style=\"color:green;\">" + todateVrftn + "</b> ");

					ReportManager.logInfo(
							"FromDate and ToDate- <b style=\"color:green;\">\"Dates are Displayed Correctly\"</b> ");

				}
			}
		}

	}
//TC-14 - Doubt in test case on hold

//TC-15
	public static void UM_Lock_LockExamMark() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(unlockMarksEntry, "Unlock Marks Entry");
		Thread.sleep(3000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		Thread.sleep(3000);

		webActions.selectByVisibleText(registrationCode, "1920_EVEN_SEMESTER");
		ReportManager.logInfo("Registration Code - <b style=\"color:green;\">\"1920_EVEN_SEMESTER\"</b> ");
		Thread.sleep(3000);

		webActions.selectByVisibleText(examEventCode, " Presentation - Presentation ");
		Thread.sleep(3000);

		webActions.Click(subjects, "Subjects");
		List<WebElement> List_subjects = webActions.getListOfWebElements(listOfSubjects);

		for (int i = 0; i < List_subjects.size(); i++) {
			String str_subj = List_subjects.get(i).getText();

			if (str_subj.equalsIgnoreCase("(EECE804L) ANTENNA THEORY AND DESIGN")) {
				List_subjects.get(i).click();
				System.out.println("Selected Subject from DD");
				ReportManager.logInfo(
						"Subject Code - <b style=\"color:green;\">\"(EECE804L) ANTENNA THEORY AND DESIGN\"</b> ");

			}
		}

		webActions.Click(getDetailsButton, "get Deatils option");
		System.out.println("Clicked Get Details Option");
		Thread.sleep(5000);

		List<WebElement> list_facultyName = webActions.getListOfWebElements(facultyNameColumnInSearchOutput);
		List<WebElement> list_checkbox = webActions.getListOfWebElements(SNoCheckboxInSearchOutput);

		for (int j = 0; j < list_facultyName.size(); j++) {
			String str_facultyName = list_facultyName.get(j).getText();

			System.out.println(str_facultyName);
			if (str_facultyName.contains("(15120047) ARVIND KUMAR")) {

				list_checkbox.get(j).click();
				System.out.println("Lock exam got selected");
				ReportManager.logInfo("Row selected");

			}

		}

		jse.executeScript("document.getElementById('fromdate').removeAttribute('readonly',0);");
		webActions.clearAndSendKeys(fromDate, "01/07/2020");
		Thread.sleep(2000);
		jse.executeScript("document.getElementById('todate').removeAttribute('readonly',0);");
		webActions.clearAndSendKeys(toDate, "30/07/2020");
		Thread.sleep(1000);

		List<WebElement> LockExam_checkbox = webActions.getListOfWebElements(lockExamMarksColumnList);

		for (int j = 0; j < list_facultyName.size(); j++) {
			String str_facultyName = list_facultyName.get(j).getText();

			System.out.println(str_facultyName);
			if (str_facultyName.contains("(15120047) ARVIND KUMAR")) {

				LockExam_checkbox.get(j).click();
				System.out.println("Lock exam got selected");
				ReportManager.logInfo("Lock Marks Exam checkbox is selected");

			}

		}

		webActions.Click(acceptButton, "Accept Button");
		webActions.Click(saveButtonForChanges, "Save Button");

		String updatedMsg = webActions.getText(dataupdatedMsg);
		webActions.verifyText(updatedMsg, "Data Updated Successfully. !!!");
		webActions.Click(OK, "OK Button");
		Thread.sleep(2000);
		ReportManager.logInfo("Locked Exam Marks for select faculty");

	}

//TC_16
	public static void UM_UnLock_LockExamMark() throws InterruptedException {
		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(unlockMarksEntry, "Unlock Marks Entry");
		Thread.sleep(3000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		Thread.sleep(3000);

		webActions.selectByVisibleText(registrationCode, "1920_EVEN_SEMESTER");
		ReportManager.logInfo("Registration Code - <b style=\"color:green;\">\"1920_EVEN_SEMESTER\"</b> ");
		Thread.sleep(3000);

		webActions.selectByVisibleText(examEventCode, " Presentation - Presentation ");
		Thread.sleep(3000);

		webActions.Click(subjects, "Subjects");
		List<WebElement> List_subjects = webActions.getListOfWebElements(listOfSubjects);

		for (int i = 0; i < List_subjects.size(); i++) {
			String str_subj = List_subjects.get(i).getText();

			if (str_subj.equalsIgnoreCase("(EECE804L) ANTENNA THEORY AND DESIGN")) {
				
				List_subjects.get(i).click();
				System.out.println("Selected Subject from DD");
				ReportManager.logInfo(
						"Subject Code - <b style=\"color:green;\">\"(EECE804L) ANTENNA THEORY AND DESIGN\"</b> ");

			}
		}

		webActions.Click(getDetailsButton, "get Deatils option");
		System.out.println("Clicked Get Details Option");
		Thread.sleep(5000);
//		
//		List<WebElement> list_facultyName = webActions.getListOfWebElements(facultyNameColumnInSearchOutput);
//		List<WebElement> list_checkbox = webActions.getListOfWebElements(SNoCheckboxInSearchOutput);
//		
//		for (int j = 0; j < list_facultyName.size(); j++) {
//			String str_facultyName = list_facultyName.get(j).getText();
//
//			System.out.println(str_facultyName);
//			if (str_facultyName.contains("(15120126) Arjun Kumar")) {
//			
//				
//				List_subjects.get(j).isSelected();
//				List_subjects.get(j).click();
//				Thread.sleep(2000);
//
//				List_subjects.get(j).click();
//
//
//			}
//
//		}
		
		jse.executeScript("document.getElementById('fromdate').removeAttribute('readonly',0);");
		webActions.clearAndSendKeys(fromDate, "05/05/2020");
		Thread.sleep(2000);
		jse.executeScript("document.getElementById('todate').removeAttribute('readonly',0);");
		webActions.clearAndSendKeys(toDate, "25/05/2020");
		Thread.sleep(4000);
		
		List<WebElement> list_facultyName = webActions.getListOfWebElements(facultyNameColumnInSearchOutput);
		List<WebElement> list_checkbox = webActions.getListOfWebElements(SNoCheckboxInSearchOutput);
		List<WebElement> LockExam_checkbox = webActions.getListOfWebElements(lockExamMarksColumnList);

		for (int j = 0; j < list_facultyName.size(); j++) {
			String str_facultyName = list_facultyName.get(j).getText();

			System.out.println(str_facultyName);
			if (str_facultyName.contains("(15120126) Arjun Kumar")) {
				
				DriverFactory.getInstance().getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 

				list_checkbox.get(j).click();
				Thread.sleep(2000);
				ReportManager.logInfo("Row selected");
				
				DriverFactory.getInstance().getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
				webActions.Click(acceptButton, "Accept");
				
				LockExam_checkbox.get(j).isSelected();
				LockExam_checkbox.get(j).click();
				Thread.sleep(3000);

				System.out.println("Lock exam unchecked");
				ReportManager.logInfo("UnLock Marks Exam checkbox is unchecked");
				ReportManager.logInfo(" <b style=\"color:green;\">\" Exam Marks Entry unlocked\"</b> ");


			}

		}
		
		webActions.Click(saveButtonForChanges, "Save Button");

		String updatedMsg = webActions.getText(dataupdatedMsg);
		webActions.verifyText(updatedMsg, "Data Updated Successfully. !!!");
		webActions.Click(OK, "OK Button");
		Thread.sleep(2000);

	}
}
