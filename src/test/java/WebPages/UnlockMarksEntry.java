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
		ReportManager.logInfo("<b style=\"color:green;\"> *****Exam Event code is Selected *****</b>");

		webActions.Click(subjects, "Subjects");
		List<WebElement> List_subjects = webActions.getListOfWebElements(listOfSubjects);
		System.out.println("Total number of search in list" + List_subjects.size());

		for (int i = 0; i < List_subjects.size(); i++) {
			System.out.println(List_subjects.get(i).getText());
			if (List_subjects.get(i).getText().contains("(EECE804L) ANTENNA THEORY AND DESIGN")) {
				List_subjects.get(i).click();
				System.out.println("Selected Subject from DD");
				
				ReportManager.logInfo("<b style=\"color:green;\"> ******(EECE804L) ANTENNA THEORY AND DESIGN Subject is Selected from dropdown *****</b>");

				break;
			} else {

				ReportManager
						.logInfo("<b style=\"color:green;\"> ******Subject is not Selected from dropdown *****</b>");

			}
		}
	}
}