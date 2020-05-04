package WebPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import Utilities.DriverFactory;
import Utilities.ReportManager;
import WebUtil.WebActions;

public class ExamEventSubjectTagging {

	public static By examActivity = By.xpath("//span[.= 'Exam Activity']");
	public static By examEventSubjectTagging = By.xpath("//span[. = 'Exam Event Subject Tagging']");
	public static By SubjectTaggingPageVerftn = By.xpath("//h1[contains(text(),' Exam Event Subject Tagging ')]");

	public static By Institute = By.id("exinstituteid");
	public static By registrationCode = By.id("regcode");

	public static By subjectCodeDropdown = By.xpath("//span[contains(text(),'--Select Event Subject --')]");
	public static By subjectCodeDropdownContent = By.xpath("//li[contains(@class, 'multiselect-item-checkbox')]/div");

	public static By tableEventType = By.xpath("//b[contains(text(),'Event Type')]");
	public static By listOfEventType = By.xpath("//*[@id=\"examEventSubjectTaggingTable\"]/div/table/thead/tr/th[2]");
	public static By tableRows = By.xpath("//*[@id=\"examEventSubjectTaggingTable\"]/div/table/tbody");

	public static By tableExamEvent = By.xpath("//b[contains(text(),'Exam Event')]");
	public static By tableMaxMarks = By.xpath("//b[contains(text(),'Max Marks')]");

	public static By tableWeightageField = By.xpath("//input[@id='eventEXEVNTID190900001910']");
//

	public static By examEventForSubjectTagging = By.xpath("//div[@id = 'examEventSubjectTaggingTable']//tr/td[3]");
	public static By examEventTypeForSubjectTagging = By.xpath("//div[@id = 'examEventSubjectTaggingTable']//tr/td[2]");
	public static By weightageForSubjectTagging = By.xpath("//*[starts-with(@id,'eventEXEVNTID1909000')]");
	public static By invalidWeightageAlert = By.xpath("//div[contains(text(),'Weightage must not be more than 100 !!')]");
	public static By checkBoxForSubjectTagging = By
			.xpath("//div[@id = 'examEventSubjectTaggingTable']//tr/td/input[contains(@id, 'exsubid')]");
//
	public static By TagCoordinator = By.xpath("//div[@id = 'examEventSubjectTaggingTable']//tr/td[9]");

	public static By selectFacultyDropdown = By
			.xpath("(//form[@class = 'ng-untouched ng-pristine ng-invalid'])[1]//select[contains(@id,'exfaculty')]");
	public static By batchDropdown = By.xpath("(//select[contains(@id,'exbranch')])[1]");
	public static By confirmationBox = By
			.xpath("//div[@class= 'swal2-container swal2-center swal2-fade swal2-shown']//div[@id = 'swal2-content']");
	public static By okButton = By.xpath(
			"//div[@class= 'swal2-container swal2-center swal2-fade swal2-shown']//div[@class = 'swal2-actions']/button[1]");
	public static By tagCoordinatorButtonForSubjectTagging = By
			.xpath("//div[@id = 'examEventSubjectTaggingTable']//tr/td/input[contains(@id, 'tagcoorbtnid')]");

	public static By totalWeightage = By.xpath("//div[@id= 'wghtid']/span");
	public static By saveButtonForSubjectTagging = By.xpath("//button[@title= 'save']");
	public static By saveProblemAlert = By
			.xpath("//div[contains(text(),'Please check atleast one event should be selected !!')]");
	public static By marksEntryCheckBox = By.xpath("//input[contains(@id, 'exmarks')]");

	public static By saveProblemAlertOK = By.xpath("//button[contains(text(),'OK')]");

	public static By tagTable = By.xpath("//*[@id=\"examdetail0\"]/td");
	public static By tagFacutlyText = By
			.xpath("//label[contains(text(),'Faculty')]//following-sibling::select[@id='exfaculty0']");
	public static By tagBatchText = By
			.xpath("//label[contains(text(),'Batch')]//following-sibling::select[@id='exbranch0']");
	public static By tagTableHeaders = By.xpath("//*[@id=\"examdetail0\"]/td/table[2]/thead/tr/th");

	public static By tagMarksEntryText = By.xpath("//div[contains(text(),' Marks Entry ')]");
	public static By tagGradeEntrydd = By
			.xpath("//option[contains(text(),'--Grade Entry Faculty--')]//parent::select[@id='exgrade3']");

	public static By addButton = By.xpath("//input[contains(@id, 'exsetfacbtnid')]");
	public static By tagAddproblemAlert1 = By.xpath("//div[contains(text(),'Please select any entry !!')]");
	public static By tagAddProblemAlertOKbutn = By.xpath("//button[contains(text(),'OK')]");
	public static By tagAddproblemAlert2 = By.xpath("//div[contains(text(),'Please select Faculty !!')]");

	static WebActions webActions = new WebActions();
	static JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();

//TC_001

	public static void EESubjectTaggingAccess() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventSubjectTagging, "Exam Event Subject Tagging");
		Thread.sleep(4000);

		String VerifyEESubjectTag = webActions.getText(SubjectTaggingPageVerftn);
		if (VerifyEESubjectTag.equalsIgnoreCase("Exam Event Subject Tagging")) {
			ReportManager
					.logInfo("<b style=\"color:green;\"> *****Exam Event Subject Tagging Page is displayed *****</b>");

		}

		else {
			ReportManager
					.logInfo("<b style=\"color:red;\"> *****Exam Event Subject Tagging is not displayed *****</b>");
		}

	}

//TC_002
	public static void STInstitutedd() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventSubjectTagging, "Exam Event Subject Tagging");
		Thread.sleep(4000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		Thread.sleep(5000);

		String str_Institutedd = webActions.getText(Institute);
		if (str_Institutedd.contains("School of Engineering and Applied Sciences")) {
			ReportManager.logInfo("<b style=\"color:green;\"> *****Institute Name is Selected *****</b>");

		}

		else {
			ReportManager.logInfo("<b style=\"color:red;\"> *****Institute Name is not Selected*****</b>");
		}
	}

//TC_003
	public static void STRegistrationdd() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventSubjectTagging, "Exam Event Subject Tagging");
		Thread.sleep(4000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		Thread.sleep(5000);

		webActions.selectByVisibleText(registrationCode, "1920_EVEN_SEMESTER");

		webActions.Click(registrationCode, "Registration Code");
		List<WebElement> list = webActions.getListOfWebElements(registrationCode);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().contains("1920_EVEN_SEMESTER")) {
				list.get(i).click();
				System.out.println("Registration Code Dropdown is working");
				ReportManager.logInfo(
						"<b style=\"color:green;\"> *****Able to select Registration Code from Dropdown*******</b>");

				break;
			} else {
				ReportManager
						.logInfo("<b style=\"color:red;\"> *****Registration Code Dropdown is not  working* *****</b>");

			}
		}

	}

//TC_04
	public static void STSubjectCodedd() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventSubjectTagging, "Exam Event Subject Tagging");
		Thread.sleep(4000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		Thread.sleep(5000);

		webActions.selectByVisibleText(registrationCode, "1920_EVEN_SEMESTER");

		webActions.Click(subjectCodeDropdown, "Subject Code");
		List<WebElement> list = webActions.getListOfWebElements(subjectCodeDropdownContent);

		for (int i = 0; i < list.size(); i++) {

			System.out.println(list.get(i).getText());
			if (list.get(i).getText().contains("(ECSE102L)OBJECT ORIENTED PROGRAMMING WITH JAVA")) {
				list.get(i).click();
				System.out.println("Subject Code Dropdown is working");
				ReportManager.logInfo(
						"<b style=\"color:green;\"> *****Able to select Subject Code from Dropdown*******</b>");
				break;

			}

			else {
				ReportManager.logInfo(
						"<b style=\"color:red;\"> *****Unable to select Subject Code from Dropdown*******</b>");

			}
		}
	}

//TC_005

	public static void STSaveWithoutInstitute() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventSubjectTagging, "Exam Event Subject Tagging");
		Thread.sleep(4000);

		webActions.Click(registrationCode, "Registration Code");
		List<WebElement> list = webActions.getListOfWebElements(registrationCode);

		for (int i = 0; i < list.size(); i++) {

			System.out.println(list.get(i).getText());
			if (list.get(i).getText().contains("--Select Registration Code--")) {
				list.get(i).click();
				System.out.println("Empty Dropdown");
				ReportManager.logInfo(
						"<b style=\"color:green;\"> ********unable to select Registration Code without Institute *******</b>");
				break;

			}

			else {
				ReportManager.logInfo(
						"<b style=\"color:red;\"> *****Able to select Registration Code without Institute*******</b>");

			}

		}
	}

	// TC_06
	public static void STPresenceOfEETable() throws InterruptedException {
		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventSubjectTagging, "Exam Event Subject Tagging");
		Thread.sleep(4000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		Thread.sleep(5000);

		List<WebElement> rows = webActions.getListOfWebElements(tableRows);

		for (int rnum = 0; rnum < rows.size(); rnum++) {

			System.out.println(rows.get(rnum).getText());

		}
		ReportManager.logInfo("<b style=\"color:green;\"> *****Event Table is Present*******</b>");

	}

//TC_07

	public static void STWeightageWithValidData() throws InterruptedException {
		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventSubjectTagging, "Exam Event Subject Tagging");
		Thread.sleep(4000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		Thread.sleep(5000);

		webActions.selectByVisibleText(registrationCode, " 1920_EVEN_SEMESTER ");
		webActions.Click(subjectCodeDropdown, "Subject Code Dropdown");
		List<WebElement> list_SubjectCodeDropdownContent = webActions.getListOfWebElements(subjectCodeDropdownContent);

		for (int i = 0; i < list_SubjectCodeDropdownContent.size(); i++) {
			String str_SubjectCodeDropdownContent = list_SubjectCodeDropdownContent.get(i).getText();
			System.out.println(str_SubjectCodeDropdownContent);

			if (str_SubjectCodeDropdownContent.equalsIgnoreCase("(EECE349J)MINI PROJECT")) {
				list_SubjectCodeDropdownContent.get(i).click();
				ReportManager.logInfo(
						"Clicked on Subject - <b style=\"color:green;\">" + str_SubjectCodeDropdownContent + "</b>");
			}
		}
		Thread.sleep(2000);

		List<WebElement> list_ExamEventForSubjectTagging = webActions.getListOfWebElements(examEventForSubjectTagging);
		List<WebElement> list_CheckBoxForSubjectTagging = webActions.getListOfWebElements(checkBoxForSubjectTagging);
		List<WebElement> list_ExamEventTypeForSubjectTagging = webActions.getListOfWebElements(examEventTypeForSubjectTagging);


		webActions.getText(totalWeightage);

		for (int i = 0; i < list_ExamEventForSubjectTagging.size(); i++) {
			String str_ExamEventForSubjectTagging = list_ExamEventForSubjectTagging.get(i).getText();
			System.out.println(str_ExamEventForSubjectTagging);

			if (str_ExamEventForSubjectTagging.equalsIgnoreCase("Mid Term Examination")) 
			{
				String str_ExamEventTypeForSubjectTagging = list_ExamEventTypeForSubjectTagging.get(i).getText();
				if (str_ExamEventTypeForSubjectTagging.equalsIgnoreCase("Internal Exam")) 
				{
					list_CheckBoxForSubjectTagging.get(i).click();
					webActions.clearAndSendKeys(By.id("eventEXEVNTID190900001910"), "80"); // Change xpath accordingly 
					Thread.sleep(20000);
					
					String totalWeightageText= webActions.getText(totalWeightage);
					
					ReportManager.logInfo("Exam Event - <b style=\"color:green;\">"+str_ExamEventForSubjectTagging+"</b>"
							+ ", Event Type - <b style=\"color:green;\">"+str_ExamEventTypeForSubjectTagging+"</b>"
							+ ", <b style=\"color:green;\">"+totalWeightageText+"");
					
					webActions.Click(saveButtonForSubjectTagging, "Save Button");
					String str_confirmationBox = webActions.getText(confirmationBox);
					webActions.verifyText(str_confirmationBox, "Record updated successfully !!");
					webActions.Click(okButton, "OK Button");
					
					
					
					ReportManager.logInfo("<b style=\"color:green;\"> *****Weighage field accepted valid numeric data*******</b>");

				}
			}

		}

	}
//TC_08 - In progress 
	
	public static void STWeightageWithINVALIDDATA() throws InterruptedException {
		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventSubjectTagging, "Exam Event Subject Tagging");
		Thread.sleep(4000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		Thread.sleep(5000);

		webActions.selectByVisibleText(registrationCode, " 1920_EVEN_SEMESTER ");
		webActions.Click(subjectCodeDropdown, "Subject Code Dropdown");
		List<WebElement> list_SubjectCodeDropdownContent = webActions.getListOfWebElements(subjectCodeDropdownContent);

		for (int i = 0; i < list_SubjectCodeDropdownContent.size(); i++) {
			String str_SubjectCodeDropdownContent = list_SubjectCodeDropdownContent.get(i).getText();
			System.out.println(str_SubjectCodeDropdownContent);

			if (str_SubjectCodeDropdownContent.equalsIgnoreCase("(EECE349J)MINI PROJECT")) {
				list_SubjectCodeDropdownContent.get(i).click();
				ReportManager.logInfo(
						"Clicked on Subject - <b style=\"color:green;\">" + str_SubjectCodeDropdownContent + "</b>");
			}
		}
		Thread.sleep(2000);

		List<WebElement> list_ExamEventForSubjectTagging = webActions.getListOfWebElements(examEventForSubjectTagging);
		List<WebElement> list_CheckBoxForSubjectTagging = webActions.getListOfWebElements(checkBoxForSubjectTagging);
		List<WebElement> list_ExamEventTypeForSubjectTagging = webActions.getListOfWebElements(examEventTypeForSubjectTagging);


		webActions.getText(totalWeightage);

		for (int i = 0; i < list_ExamEventForSubjectTagging.size(); i++) {
			String str_ExamEventForSubjectTagging = list_ExamEventForSubjectTagging.get(i).getText();
			System.out.println(str_ExamEventForSubjectTagging);

			if (str_ExamEventForSubjectTagging.equalsIgnoreCase("End Term Lab")) 
			{
				String str_ExamEventTypeForSubjectTagging = list_ExamEventTypeForSubjectTagging.get(i).getText();
				if (str_ExamEventTypeForSubjectTagging.equalsIgnoreCase("Internal Exam")) 
				{
					list_CheckBoxForSubjectTagging.get(i).click();
					webActions.clearAndSendKeys(By.id("eventEXEVNTID190900001932"), "120"); // Change xpath accordingly 
					Thread.sleep(20000);
					
					String InvalidWeightageAlert= webActions.getText(invalidWeightageAlert);
					webActions.verifyText(InvalidWeightageAlert, "Weightage must not be more than 100 !!");
					webActions.Click(okButton, "OK Button");

					
					
					ReportManager.logInfo("Exam Event - <b style=\"color:green;\">"+str_ExamEventForSubjectTagging+"</b>"
							+ ", Event Type - <b style=\"color:green;\">"+str_ExamEventTypeForSubjectTagging+"</b>");
					
					
					
					ReportManager.logInfo("<b style=\"color:green;\"> *****Weighage field not accepting Invalid numeric data*******</b>");

				}
			}

		}

	}
//TC_09
	public static void STVerifyPresenceOfTagCordinator() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventSubjectTagging, "Exam Event Subject Tagging");
		Thread.sleep(4000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		Thread.sleep(5000);

		webActions.selectByVisibleText(registrationCode, " 1920_EVEN_SEMESTER ");
		webActions.Click(subjectCodeDropdown, "Subject Code Dropdown");
		List<WebElement> list_SubjectCodeDropdownContent = webActions.getListOfWebElements(subjectCodeDropdownContent);

		for (int i = 0; i < list_SubjectCodeDropdownContent.size(); i++) {
			String str_SubjectCodeDropdownContent = list_SubjectCodeDropdownContent.get(i).getText();
			System.out.println(str_SubjectCodeDropdownContent);

			if (str_SubjectCodeDropdownContent.equalsIgnoreCase("(ECSE440L)DEEP LEARNING")) {
				list_SubjectCodeDropdownContent.get(i).click();
				ReportManager.logInfo(
						"Clicked on Subject - <b style=\"color:green;\">" + str_SubjectCodeDropdownContent + "</b>");
			}
		}
		Thread.sleep(2000);

		String tc = webActions.getText(TagCoordinator);
		if (tc.contains("Tag Coordinator")) {
			ReportManager.logInfo("<b style=\"color:green;\"> *****Tag Coordinator option is present*******</b>");

		} else {
			ReportManager.logInfo("<b style=\"color:green;\"> *****Tag Coordinator option is not present*******</b>");

		}
	}

//TC_010
	public static void STSaveWithoutTag() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventSubjectTagging, "Exam Event Subject Tagging");
		Thread.sleep(4000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		Thread.sleep(5000);

		webActions.selectByVisibleText(registrationCode, " 1920_EVEN_SEMESTER ");
		webActions.Click(subjectCodeDropdown, "Subject Code Dropdown");
		List<WebElement> list_SubjectCodeDropdownContent = webActions.getListOfWebElements(subjectCodeDropdownContent);

		for (int i = 0; i < list_SubjectCodeDropdownContent.size(); i++) {
			String str_SubjectCodeDropdownContent = list_SubjectCodeDropdownContent.get(i).getText();
			System.out.println(str_SubjectCodeDropdownContent);

			if (str_SubjectCodeDropdownContent.equalsIgnoreCase("(ECSE440L)DEEP LEARNING")) {
				list_SubjectCodeDropdownContent.get(i).click();
				ReportManager.logInfo(
						"Clicked on Subject - <b style=\"color:green;\">" + str_SubjectCodeDropdownContent + "</b>");
			}
		}
		Thread.sleep(2000);

		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);

		webActions.Click(saveButtonForSubjectTagging, "Save");
		Thread.sleep(2000);

		String problemAlert = webActions.getText(saveProblemAlert);
		if (problemAlert.equalsIgnoreCase("Please check atleast one event should be selected !!")) {

			webActions.Click(saveProblemAlertOK, "OK");

			ReportManager.logInfo("<b style=\"color:red;\"> *****Error Reason:No Event is selected*******</b>");

		}

		else {
			ReportManager.logInfo("<b style=\"color:red;\"> *****No Tagging alert displayed*******</b>");

		}

	}
//TC_11 
	public static void STVerifyPassingMarksWithZero() throws InterruptedException {
		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventSubjectTagging, "Exam Event Subject Tagging");
		Thread.sleep(4000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		Thread.sleep(5000);

		webActions.selectByVisibleText(registrationCode, " 1920_EVEN_SEMESTER ");
		webActions.Click(subjectCodeDropdown, "Subject Code Dropdown");
		List<WebElement> list_SubjectCodeDropdownContent = webActions.getListOfWebElements(subjectCodeDropdownContent);

		for (int i = 0; i < list_SubjectCodeDropdownContent.size(); i++) {
			String str_SubjectCodeDropdownContent = list_SubjectCodeDropdownContent.get(i).getText();
			System.out.println(str_SubjectCodeDropdownContent);

			if (str_SubjectCodeDropdownContent.equalsIgnoreCase("(EECE349J)MINI PROJECT")) {
				list_SubjectCodeDropdownContent.get(i).click();
				ReportManager.logInfo(
						"Clicked on Subject - <b style=\"color:green;\">" + str_SubjectCodeDropdownContent + "</b>");
			}
		}
		Thread.sleep(2000);

		List<WebElement> list_ExamEventForSubjectTagging = webActions.getListOfWebElements(examEventForSubjectTagging);
		List<WebElement> list_CheckBoxForSubjectTagging = webActions.getListOfWebElements(checkBoxForSubjectTagging);
		List<WebElement> list_ExamEventTypeForSubjectTagging = webActions.getListOfWebElements(examEventTypeForSubjectTagging);


		for (int i = 0; i < list_ExamEventForSubjectTagging.size(); i++) {
			String str_ExamEventForSubjectTagging = list_ExamEventForSubjectTagging.get(i).getText();
			System.out.println(str_ExamEventForSubjectTagging);

			if (str_ExamEventForSubjectTagging.equalsIgnoreCase("Assignment -01 (Assignment)")) 
			{
				String str_ExamEventTypeForSubjectTagging = list_ExamEventTypeForSubjectTagging.get(i).getText();
				if (str_ExamEventTypeForSubjectTagging.equalsIgnoreCase("Internal Exam")) 
				{
					list_CheckBoxForSubjectTagging.get(i).click();
					webActions.clearAndSendKeys(By.xpath("//input[@id='taggEXEVNTID190900001917event'][1]"), "0"); // Change xpath accordingly 
					Thread.sleep(20000);
					
					
					ReportManager.logInfo("Exam Event - <b style=\"color:green;\">"+str_ExamEventForSubjectTagging+"</b>"
							+ ", Event Type - <b style=\"color:green;\">"+str_ExamEventTypeForSubjectTagging+"</b>");
					
					webActions.Click(saveButtonForSubjectTagging, "Save Button");
					String str_confirmationBox = webActions.getText(confirmationBox);
					webActions.verifyText(str_confirmationBox, "Record updated successfully !!");
					webActions.Click(okButton, "OK Button");
					
					
					
					ReportManager.logInfo("<b style=\"color:green;\"> *****Passing Marks as Zero Accepted*******</b>");

				}
			}

		}

	}
	

//TC_12
	public static void STVerifyTagCoordinatorDetails() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventSubjectTagging, "Exam Event Subject Tagging");
		Thread.sleep(4000);
		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		webActions.selectByVisibleText(registrationCode, " 1920_EVEN_SEMESTER ");

		webActions.Click(subjectCodeDropdown, "Subject Code Dropdown");

		List<WebElement> list_SubjectCodeDropdownContent = webActions.getListOfWebElements(subjectCodeDropdownContent);

		for (int i = 0; i < list_SubjectCodeDropdownContent.size(); i++) {
			String str_SubjectCodeDropdownContent = list_SubjectCodeDropdownContent.get(i).getText();
			System.out.println(str_SubjectCodeDropdownContent);

			if (str_SubjectCodeDropdownContent.equalsIgnoreCase("(EECE349J)MINI PROJECT")) {
				list_SubjectCodeDropdownContent.get(i).click();
				ReportManager.logInfo(
						"Clicked on Subject - <b style=\"color:green;\">" + str_SubjectCodeDropdownContent + "</b>");
			}
		}
		Thread.sleep(2000);

		List<WebElement> list_ExamEventForSubjectTagging = webActions.getListOfWebElements(examEventForSubjectTagging);

		for (int i = 0; i < list_ExamEventForSubjectTagging.size(); i++) {
			String str_ExamEventForSubjectTagging = list_ExamEventForSubjectTagging.get(i).getText();
			System.out.println(str_ExamEventForSubjectTagging);

			List<WebElement> list_CheckBoxForSubjectTagging = webActions
					.getListOfWebElements(checkBoxForSubjectTagging);

			if (str_ExamEventForSubjectTagging.equalsIgnoreCase("Mid Term Examination")) {
				list_CheckBoxForSubjectTagging.get(i).click();
				ReportManager.logInfo("Clicked on - <b style=\"color:green;\">Check box</b>");

			}
		}

		for (int i = 0; i < list_ExamEventForSubjectTagging.size(); i++) {
			String str_ExamEventForSubjectTagging = list_ExamEventForSubjectTagging.get(i).getText();
			System.out.println(str_ExamEventForSubjectTagging);

			List<WebElement> list_TagCoordinatorButtonForSubjectTagging = webActions
					.getListOfWebElements(tagCoordinatorButtonForSubjectTagging);

			if (str_ExamEventForSubjectTagging.equalsIgnoreCase("Mid Term Examination")) {

				list_TagCoordinatorButtonForSubjectTagging.get(i).click();
				Thread.sleep(2000);
				ReportManager.logInfo("Clicked on - <b style=\"color:green;\">Tag Coordinator</b>");

				webActions.isDisplayed(tagTable, "Event Table is displayed");

				if (webActions.isDisplayed(tagFacutlyText, "Faculty")
						&& webActions.isDisplayed(tagBatchText, "Batch Text")) {

					webActions.getElementSizeUsingFindElements(tagTableHeaders);
					ReportManager.logInfo(
							"<b style=\"color:green;\">********Tag coordinator Table details are displayed******</b>");

				} else {
					ReportManager.logInfo(
							"<b style=\"color:red;\">********Tag coordinator table details are not displayed******</b>");

				}

			}
		}
	}

//TC_13
	public static void STFacultyAndBatchDD() throws InterruptedException {
		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventSubjectTagging, "Exam Event Subject Tagging");
		Thread.sleep(4000);
		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		webActions.selectByVisibleText(registrationCode, " 1920_EVEN_SEMESTER ");

		webActions.Click(subjectCodeDropdown, "Subject Code Dropdown");
		List<WebElement> list_SubjectCodeDropdownContent = webActions.getListOfWebElements(subjectCodeDropdownContent);

		for (int i = 0; i < list_SubjectCodeDropdownContent.size(); i++) {
			String str_SubjectCodeDropdownContent = list_SubjectCodeDropdownContent.get(i).getText();
			System.out.println(str_SubjectCodeDropdownContent);

			if (str_SubjectCodeDropdownContent.equalsIgnoreCase("(EECE349J)MINI PROJECT")) {
				list_SubjectCodeDropdownContent.get(i).click();
				ReportManager.logInfo(
						"Clicked on Subject - <b style=\"color:green;\">" + str_SubjectCodeDropdownContent + "</b>");
			}
		}
		Thread.sleep(2000);

		List<WebElement> list_ExamEventForSubjectTagging = webActions.getListOfWebElements(examEventForSubjectTagging);

		for (int i = 0; i < list_ExamEventForSubjectTagging.size(); i++) {
			String str_ExamEventForSubjectTagging = list_ExamEventForSubjectTagging.get(i).getText();
			System.out.println(str_ExamEventForSubjectTagging);

			List<WebElement> list_CheckBoxForSubjectTagging = webActions
					.getListOfWebElements(checkBoxForSubjectTagging);

			if (str_ExamEventForSubjectTagging.equalsIgnoreCase("Mid Term Examination")) {
				list_CheckBoxForSubjectTagging.get(i).click();
				ReportManager.logInfo("Clicked on - <b style=\"color:green;\">Check box</b>");

			}

		}

		for (int i = 0; i < list_ExamEventForSubjectTagging.size(); i++) {
			String str_ExamEventForSubjectTagging = list_ExamEventForSubjectTagging.get(i).getText();
			System.out.println(str_ExamEventForSubjectTagging);

			List<WebElement> list_TagCoordinatorButtonForSubjectTagging = webActions
					.getListOfWebElements(tagCoordinatorButtonForSubjectTagging);

			if (str_ExamEventForSubjectTagging.equalsIgnoreCase("Mid Term Examination")) {

				list_TagCoordinatorButtonForSubjectTagging.get(i).click();
				Thread.sleep(2000);

				ReportManager.logInfo("Clicked on - <b style=\"color:green;\">Tag Coordinator</b>");

				webActions.selectByVisibleText(selectFacultyDropdown, " ARVIND  KUMAR ");
				Thread.sleep(3000);
				webActions.Click(batchDropdown, "Batch Dropdown");

				webActions.selectByVisibleText(batchDropdown, "1617-B.Tech.-ECE-ECE-BATCH-8");
				Thread.sleep(2000);

				ReportManager.logInfo(
						"<b style=\"color:green;\">********Faculty,Batch Dropdowns are selectable********</b>");
				break;

			}

			/*
			 * else { ReportManager.logInfo(
			 * "<b style=\"color:red;\">********Faculty,Batch Dropdowns are not selectable******</b>"
			 * );
			 * 
			 * }
			 */

		}
	}

//TC_014
	public static void STVerifyMarksOption() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventSubjectTagging, "Exam Event Subject Tagging");
		Thread.sleep(4000);
		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		webActions.selectByVisibleText(registrationCode, " 1920_EVEN_SEMESTER ");

		webActions.Click(subjectCodeDropdown, "Subject Code Dropdown");
		List<WebElement> list_SubjectCodeDropdownContent = webActions.getListOfWebElements(subjectCodeDropdownContent);

		for (int i = 0; i < list_SubjectCodeDropdownContent.size(); i++) {
			String str_SubjectCodeDropdownContent = list_SubjectCodeDropdownContent.get(i).getText();
			System.out.println(str_SubjectCodeDropdownContent);

			if (str_SubjectCodeDropdownContent.equalsIgnoreCase("(EECE349J)MINI PROJECT")) {
				list_SubjectCodeDropdownContent.get(i).click();
				ReportManager.logInfo(
						"Clicked on Subject - <b style=\"color:green;\">" + str_SubjectCodeDropdownContent + "</b>");
			}
		}
		Thread.sleep(2000);

		List<WebElement> list_ExamEventForSubjectTagging = webActions.getListOfWebElements(examEventForSubjectTagging);

		for (int i = 0; i < list_ExamEventForSubjectTagging.size(); i++) {
			String str_ExamEventForSubjectTagging = list_ExamEventForSubjectTagging.get(i).getText();
			System.out.println(str_ExamEventForSubjectTagging);

			List<WebElement> list_CheckBoxForSubjectTagging = webActions
					.getListOfWebElements(checkBoxForSubjectTagging);

			if (str_ExamEventForSubjectTagging.equalsIgnoreCase("Supplementary Exam")) {
				list_CheckBoxForSubjectTagging.get(i).click();
				ReportManager.logInfo("Clicked on - <b style=\"color:green;\">Check box</b>");

			}

		}

		for (int i = 0; i < list_ExamEventForSubjectTagging.size(); i++) {
			String str_ExamEventForSubjectTagging = list_ExamEventForSubjectTagging.get(i).getText();
			System.out.println(str_ExamEventForSubjectTagging);

			List<WebElement> list_TagCoordinatorButtonForSubjectTagging = webActions
					.getListOfWebElements(tagCoordinatorButtonForSubjectTagging);

			if (str_ExamEventForSubjectTagging.equalsIgnoreCase("Supplementary Exam")) {

				list_TagCoordinatorButtonForSubjectTagging.get(i).click();
				Thread.sleep(2000);

				ReportManager.logInfo("Clicked on - <b style=\"color:green;\">Tag Coordinator</b>");

				webActions.Click(marksEntryCheckBox, "Marks Entry Checkbox");

				ReportManager.logInfo("<b style=\"color:green;\">******MarksEntry checkbox checked******</b>");
				break;

			}

			/*
			 * else { ReportManager.
			 * logInfo("<b style=\"color:red;\">********MarksEntry checkbox not checked******</b>"
			 * );
			 * 
			 * }
			 */

		}
	}

//TC_015
	public static void STVerifyGaradEntryOption() throws InterruptedException {
		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventSubjectTagging, "Exam Event Subject Tagging");
		Thread.sleep(4000);
		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		webActions.selectByVisibleText(registrationCode, " 1920_EVEN_SEMESTER ");

		webActions.Click(subjectCodeDropdown, "Subject Code Dropdown");
		List<WebElement> list_SubjectCodeDropdownContent = webActions.getListOfWebElements(subjectCodeDropdownContent);

		for (int i = 0; i < list_SubjectCodeDropdownContent.size(); i++) {
			String str_SubjectCodeDropdownContent = list_SubjectCodeDropdownContent.get(i).getText();
			System.out.println(str_SubjectCodeDropdownContent);

			if (str_SubjectCodeDropdownContent.equalsIgnoreCase("(EECE349J)MINI PROJECT")) {
				list_SubjectCodeDropdownContent.get(i).click();
				ReportManager.logInfo(
						"Clicked on Subject - <b style=\"color:green;\">" + str_SubjectCodeDropdownContent + "</b>");
			}
		}
		Thread.sleep(2000);

		List<WebElement> list_ExamEventForSubjectTagging = webActions.getListOfWebElements(examEventForSubjectTagging);

		for (int i = 0; i < list_ExamEventForSubjectTagging.size(); i++) {
			String str_ExamEventForSubjectTagging = list_ExamEventForSubjectTagging.get(i).getText();
			System.out.println(str_ExamEventForSubjectTagging);

			List<WebElement> list_CheckBoxForSubjectTagging = webActions
					.getListOfWebElements(checkBoxForSubjectTagging);

			if (str_ExamEventForSubjectTagging.equalsIgnoreCase("Supplementary Exam")) {
				list_CheckBoxForSubjectTagging.get(i).click();
				ReportManager.logInfo("Clicked on - <b style=\"color:green;\">Check box</b>");

			}

		}

		for (int i = 0; i < list_ExamEventForSubjectTagging.size(); i++) {
			String str_ExamEventForSubjectTagging = list_ExamEventForSubjectTagging.get(i).getText();
			System.out.println(str_ExamEventForSubjectTagging);

			List<WebElement> list_TagCoordinatorButtonForSubjectTagging = webActions
					.getListOfWebElements(tagCoordinatorButtonForSubjectTagging);

			if (str_ExamEventForSubjectTagging.equalsIgnoreCase("Supplementary Exam")) {

				list_TagCoordinatorButtonForSubjectTagging.get(i).click();
				Thread.sleep(2000);

				ReportManager.logInfo("Clicked on - <b style=\"color:green;\">Tag Coordinator</b>");

				webActions.Click(marksEntryCheckBox, "Marks Entry Checkbox");
				webActions.selectByVisibleText(tagGradeEntrydd, " ARVIND  KUMAR ");

				ReportManager.logInfo("<b style=\"color:green;\">******Grade Entry are selected*******</b>");
				break;

			}
			/*
			 * else { ReportManager.
			 * logInfo("<b style=\"color:red;\">********Grade Entry are not selected******</b>"
			 * );
			 * 
			 * }
			 */
		}

	}

//TC_16
	public static void STSaveWithoutMarksAndGrade() throws InterruptedException {
		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventSubjectTagging, "Exam Event Subject Tagging");
		Thread.sleep(4000);
		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		webActions.selectByVisibleText(registrationCode, " 1920_EVEN_SEMESTER ");

		webActions.Click(subjectCodeDropdown, "Subject Code Dropdown");
		List<WebElement> list_SubjectCodeDropdownContent = webActions.getListOfWebElements(subjectCodeDropdownContent);

		for (int i = 0; i < list_SubjectCodeDropdownContent.size(); i++) {
			String str_SubjectCodeDropdownContent = list_SubjectCodeDropdownContent.get(i).getText();
			System.out.println(str_SubjectCodeDropdownContent);

			if (str_SubjectCodeDropdownContent.equalsIgnoreCase("(EECE349J)MINI PROJECT")) {
				list_SubjectCodeDropdownContent.get(i).click();
				ReportManager.logInfo(
						"Clicked on Subject - <b style=\"color:green;\">" + str_SubjectCodeDropdownContent + "</b>");
			}
		}
		Thread.sleep(2000);

		List<WebElement> list_ExamEventForSubjectTagging = webActions.getListOfWebElements(examEventForSubjectTagging);

		for (int i = 0; i < list_ExamEventForSubjectTagging.size(); i++) {
			String str_ExamEventForSubjectTagging = list_ExamEventForSubjectTagging.get(i).getText();
			System.out.println(str_ExamEventForSubjectTagging);

			List<WebElement> list_CheckBoxForSubjectTagging = webActions
					.getListOfWebElements(checkBoxForSubjectTagging);

			if (str_ExamEventForSubjectTagging.equalsIgnoreCase("Supplementary Exam")) {
				list_CheckBoxForSubjectTagging.get(i).click();
				ReportManager.logInfo("Clicked on - <b style=\"color:green;\">Check box</b>");

			}

		}

		for (int i = 0; i < list_ExamEventForSubjectTagging.size(); i++) {
			String str_ExamEventForSubjectTagging = list_ExamEventForSubjectTagging.get(i).getText();
			System.out.println(str_ExamEventForSubjectTagging);

			List<WebElement> list_TagCoordinatorButtonForSubjectTagging = webActions
					.getListOfWebElements(tagCoordinatorButtonForSubjectTagging);

			if (str_ExamEventForSubjectTagging.equalsIgnoreCase("Supplementary Exam")) {

				list_TagCoordinatorButtonForSubjectTagging.get(i).click();
				Thread.sleep(2000);

				webActions.selectByVisibleText(selectFacultyDropdown, " ARVIND  KUMAR ");
				Thread.sleep(3000);
				webActions.Click(addButton, "Add Button");
				String ErrorAlert = webActions.getText(tagAddproblemAlert1);
				webActions.verifyText(ErrorAlert, "Please select any entry !!");
				webActions.Click(tagAddProblemAlertOKbutn, "OK Button");

				ReportManager.logInfo("<b style=\"color:green;\">******Grade Entry are selected*******</b>");
				break;

			}

		}
	}
//TC_017

	public static void STSaveWithAllDetails() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventSubjectTagging, "Exam Event Subject Tagging");
		Thread.sleep(4000);
		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		webActions.selectByVisibleText(registrationCode, " 1920_EVEN_SEMESTER ");
		webActions.Click(subjectCodeDropdown, "Subject Code Dropdown");

		List<WebElement> list_SubjectCodeDropdownContent = webActions.getListOfWebElements(subjectCodeDropdownContent);

		for (int i = 0; i < list_SubjectCodeDropdownContent.size(); i++) {
			String str_SubjectCodeDropdownContent = list_SubjectCodeDropdownContent.get(i).getText();
			System.out.println(str_SubjectCodeDropdownContent);

			if (str_SubjectCodeDropdownContent.equalsIgnoreCase("(EECE349J)MINI PROJECT")) {
				list_SubjectCodeDropdownContent.get(i).click();
				ReportManager.logInfo(
						"Clicked on Subject - <b style=\"color:green;\">" + str_SubjectCodeDropdownContent + "</b>");
			}
		}
		Thread.sleep(2000);

		List<WebElement> list_ExamEventForSubjectTagging = webActions.getListOfWebElements(examEventForSubjectTagging);

		webActions.getText(totalWeightage);

		for (int i = 0; i < list_ExamEventForSubjectTagging.size(); i++) {
			String str_ExamEventForSubjectTagging = list_ExamEventForSubjectTagging.get(i).getText();
			System.out.println(str_ExamEventForSubjectTagging);
			List<WebElement> list_CheckBoxForSubjectTagging = webActions
					.getListOfWebElements(checkBoxForSubjectTagging);

			if (str_ExamEventForSubjectTagging.equalsIgnoreCase("Mid Term Examination")) {
				list_CheckBoxForSubjectTagging.get(i).click();

				ReportManager.logInfo("Clicked on - <b style=\"color:green;\">Check box</b>");

				String totalWeightageText = webActions.getText(totalWeightage);

				ReportManager.logInfo("Exam Event - <b style=\"color:green;\">" + str_ExamEventForSubjectTagging
						+ "</b>" + ", <b style=\"color:green;\">" + totalWeightageText + "");
			}
		}
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		jse.executeScript("window.scrollTo(document.body.scrollHeight, 0)");

		for (int i = 0; i < list_ExamEventForSubjectTagging.size(); i++) {
			String str_ExamEventForSubjectTagging = list_ExamEventForSubjectTagging.get(i).getText();
			System.out.println(str_ExamEventForSubjectTagging);
			List<WebElement> list_TagCoordinatorButtonForSubjectTagging = webActions
					.getListOfWebElements(tagCoordinatorButtonForSubjectTagging);

			if (str_ExamEventForSubjectTagging.equalsIgnoreCase("Mid Term Examination")) {

				list_TagCoordinatorButtonForSubjectTagging.get(i).click();
				ReportManager.logInfo("Clicked on - <b style=\"color:green;\">Tag Coordinator</b>");

				webActions.selectByVisibleText(selectFacultyDropdown, " ARVIND  KUMAR ");
				webActions.selectByVisibleText(batchDropdown, " 1718-B.Tech.-ECE-BT_ECE-BATCH_1718-6 ");
				webActions.Click(marksEntryCheckBox, "Marks Entry Checkbox");
				webActions.Click(addButton, "Add button");

				list_TagCoordinatorButtonForSubjectTagging.get(i).click();

				// eventFiringWebdriver.executeScript("document.getElementById('examEventSubjectTaggingTable').scrollTop=10000");
			}
		}
		webActions.Click(saveButtonForSubjectTagging, "Save Button");
		String str_confirmationBox = webActions.getText(confirmationBox);
		webActions.verifyText(str_confirmationBox, "Record updated successfully !!");
		webActions.Click(okButton, "OK Button");
	}

//TC_18

	public static void STAddWithoutFaculty() throws InterruptedException {
		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventSubjectTagging, "Exam Event Subject Tagging");
		Thread.sleep(4000);
		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		webActions.selectByVisibleText(registrationCode, " 1920_EVEN_SEMESTER ");

		webActions.Click(subjectCodeDropdown, "Subject Code Dropdown");
		List<WebElement> list_SubjectCodeDropdownContent = webActions.getListOfWebElements(subjectCodeDropdownContent);

		for (int i = 0; i < list_SubjectCodeDropdownContent.size(); i++) {
			String str_SubjectCodeDropdownContent = list_SubjectCodeDropdownContent.get(i).getText();
			System.out.println(str_SubjectCodeDropdownContent);

			if (str_SubjectCodeDropdownContent.equalsIgnoreCase("(EECE349J)MINI PROJECT")) {
				list_SubjectCodeDropdownContent.get(i).click();
				ReportManager.logInfo(
						"Clicked on Subject - <b style=\"color:green;\">" + str_SubjectCodeDropdownContent + "</b>");
			}
		}
		Thread.sleep(2000);

		List<WebElement> list_ExamEventForSubjectTagging = webActions.getListOfWebElements(examEventForSubjectTagging);

		for (int i = 0; i < list_ExamEventForSubjectTagging.size(); i++) {
			String str_ExamEventForSubjectTagging = list_ExamEventForSubjectTagging.get(i).getText();
			System.out.println(str_ExamEventForSubjectTagging);

			List<WebElement> list_CheckBoxForSubjectTagging = webActions
					.getListOfWebElements(checkBoxForSubjectTagging);

			if (str_ExamEventForSubjectTagging.equalsIgnoreCase("Mid Term Examination")) {
				list_CheckBoxForSubjectTagging.get(i).click();
				ReportManager.logInfo("Clicked on - <b style=\"color:green;\">Check box</b>");

			}

		}

		for (int i = 0; i < list_ExamEventForSubjectTagging.size(); i++) {
			String str_ExamEventForSubjectTagging = list_ExamEventForSubjectTagging.get(i).getText();
			System.out.println(str_ExamEventForSubjectTagging);

			List<WebElement> list_TagCoordinatorButtonForSubjectTagging = webActions
					.getListOfWebElements(tagCoordinatorButtonForSubjectTagging);

			if (str_ExamEventForSubjectTagging.equalsIgnoreCase("Mid Term Examination")) {

				list_TagCoordinatorButtonForSubjectTagging.get(i).click();
				Thread.sleep(2000);

				webActions.selectByVisibleText(batchDropdown, "1617-B.Tech.-ECE-ECE-BATCH-8");
				Thread.sleep(2000);

				webActions.Click(marksEntryCheckBox, "Marks Entry Checkbox");
				Thread.sleep(4000);
				webActions.Click(addButton, "Add Button");

				String Str_FacultyAlert = webActions.getText(tagAddproblemAlert2);

				webActions.verifyText(Str_FacultyAlert, "Please select Faculty !!");
				webActions.Click(tagAddProblemAlertOKbutn, "OK Button");

				ReportManager
						.logInfo("<b style=\"color:green;\">******Error Reason: Faculty was not selected*******</b>");
				break;

			}

		}
	}
}