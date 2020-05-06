package WebPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

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

	public static By getDetailsTableCol = By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td");

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

		if (webActions.isDisplayed(getDetailsButton, "Get Details")) {
			webActions.Click(getDetailsButton, "get Deatils option");
			Thread.sleep(2000);
			System.out.println("Get Details options selected");
			ReportManager.logInfo("<b style=\"color:green;\"> ******Get Details option selected *****</b>");
		}

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

		if (webActions.isDisplayed(getDetailsButton, "Get Details")) {
			webActions.Click(getDetailsButton, "get Deatils option");
			Thread.sleep(2000);
			System.out.println("Get Details options selected");
		}

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

			ReportManager.logInfo("<b style=\"color:green;\"> ******Grid Table with Required Details are present*****</b>");

		} else {
			ReportManager.logInfo("<b style=\"color:red;\"> ******Grid Table with Required Details not present*****</b>");

		}
	}

}
