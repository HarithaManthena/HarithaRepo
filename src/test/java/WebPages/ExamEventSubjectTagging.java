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
	public static By cancel = By.xpath("//button[text()='Cancel']");
//

	public static By examEventForSubjectTagging = By.xpath("//div[@id = 'examEventSubjectTaggingTable']//tr/td[3]");
	public static By examEventTypeForSubjectTagging = By.xpath("//div[@id = 'examEventSubjectTaggingTable']//tr/td[2]");
	public static By weightageForSubjectTagging = By.xpath("//*[starts-with(@id,'eventEXEVNTID1909000')]");
	public static By invalidWeightageAlert = By
			.xpath("//div[contains(text(),'Weightage must not be more than 100 !!')]");
	public static By checkBoxForSubjectTagging = By
			.xpath("//div[@id = 'examEventSubjectTaggingTable']//tr/td/input[contains(@id, 'exsubid')]");
//
	public static By TagCoordinator = By.xpath("//div[@id = 'examEventSubjectTaggingTable']//tr/td[9]");

	public static By selectFacultyDropdown = By
			.xpath("(//form[@class = 'ng-untouched ng-pristine ng-invalid'])[1]//select[contains(@id,'exfaculty')]");

	//// option[text()='--Select Faculty--']//parent::select[@id='exfaculty1']

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

	// public static By tagTable = By.xpath("//*[@id=\"examdetail0\"]/td");
	public static By tagFacutlyText = By
			.xpath("//label[contains(text(),'Faculty')]//following-sibling::select[@id='exfaculty0']");
	public static By tagBatchText = By
			.xpath("//label[contains(text(),'Batch')]//following-sibling::select[@id='exbranch0']");
	public static By tagTableHeaders = By
			.xpath("//table[@class='table table-bordered']//thead[@class='bg-info text-white']/tr/th");

	public static By tagMarksEntryText = By.xpath("//div[contains(text(),' Marks Entry ')]");
	public static By tagGradeEntrydd = By
			.xpath("//option[contains(text(),'--Grade Entry Faculty--')]//parent::select[@id='exgrade3']");

	public static By addButton = By.xpath("//input[contains(@id, 'exsetfacbtnid')]");
	public static By tagAddproblemAlert1 = By.xpath("//div[contains(text(),'Please select any entry !!')]");
	public static By tagAddProblemAlertOKbutn = By.xpath("//button[contains(text(),'OK')]");
	public static By tagAddproblemAlert2 = By.xpath("//div[contains(text(),'Please select Faculty !!')]");

	public static By alertMessage_UnselectCheckbox = By
			.xpath("//div[text()='Please NOTE: All tagging will be deleted after this action !!']");
	public static By yesButton = By.xpath("//button[text()='Yes!']");
	public static By deleted = By.xpath("//div[text()='Record deleted successfully!!']");
	public static By OK = By.xpath("//button[text()='OK']");

	static WebActions webActions = new WebActions();
	static JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();

//TC_001

	public static void EESubjectTaggingAccess() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventSubjectTagging, "Exam Event Subject Tagging");
		Thread.sleep(4000);

		String VerifyEESubjectTag = webActions.getText(SubjectTaggingPageVerftn);
		if (VerifyEESubjectTag.equalsIgnoreCase("Exam Event Subject Tagging")) {
			System.out.println("*****Veriifed Exam Event Subjec Tagging Page:Page is displayed *****");
			ReportManager.logInfo(
					"<b style=\"color:green;\">*****Veriifed Exam Event Subjec Tagging Page:Page is displayed *****</b>");
			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(3000);

		}

		else {
			System.out.println("Exam Event Subject Tagging Page is not displayed");

			ReportManager.logInfo("<b style=\"color:red;\">Exam Event Subject Tagging Page is not displayed</b>");
			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(2000);

		}

	}

//TC_002
	public static void STInstitutedd() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventSubjectTagging, "Exam Event Subject Tagging");
		Thread.sleep(4000);

		if (webActions.isDisplayed(Institute, "Institute")) {
			webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
			Thread.sleep(5000);

			System.out.println(
					"*****Veified Institute Dropdown:School of Engineering and Applied Sciences is Selected*****");
			ReportManager.logInfo(
					"<b style=\"color:green;\"> *****Veified Institute Dropdown:School of Engineering and Applied Sciences is Selected *****</b>");
			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(3000);

		}

		else {
			System.out.println("Institute Name is not Selected");
			ReportManager.logInfo("<b style=\"color:red;\"> Institute Name is not Selected</b>");
			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(2000);
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
			if (list.get(i).getText().contains("1920_EVEN_SEMESTER")) {
				list.get(i).click();
				System.out.println("*****Verified Registration Code Dropdown: Able to select Registration Code*****");
				ReportManager.logInfo(
						"<b style=\"color:green;\">*****Verified Registration Code Dropdown: Able to select Registration Code*****</b>");
				DriverFactory.getInstance().getWebDriver().navigate().refresh();
				Thread.sleep(3000);

				break;
			} else {

				System.out.println("Registration Code is not selected from Dropdown");
				ReportManager.logInfo("<b style=\"color:red;\">Registration Code is not selected from Dropdown</b>");
				DriverFactory.getInstance().getWebDriver().navigate().refresh();
				Thread.sleep(2000);

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
			if (list.get(i).getText().contains("(ECSE102L)OBJECT ORIENTED PROGRAMMING WITH JAVA")) {
				list.get(i).click();
				System.out.println("*****Verifed Subject Code Dropdown: Able to select Subject Code*****");
				ReportManager.logInfo(
						"<b style=\"color:green;\">*****Verifed Subject Code Dropdown: Able to select Subject Code*****</b>");
				DriverFactory.getInstance().getWebDriver().navigate().refresh();
				Thread.sleep(3000);
				break;

			}

			else {
				System.out.println("Subject Code is not selected");
				ReportManager.logInfo("<b style=\"color:red;\">Subject Code is not selected</b>");
				DriverFactory.getInstance().getWebDriver().navigate().refresh();
				Thread.sleep(2000);

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
				System.out.println("*****Unable to select Registration Code without Institute*****");
				ReportManager.logInfo(
						"<b style=\"color:green;\">*****Unable to select Registration Code without Institute*****</b>");
				DriverFactory.getInstance().getWebDriver().navigate().refresh();
				Thread.sleep(3000);
				break;

			}

			else {
				System.out.println("Able to select Registration Code without Institute");
				ReportManager.logInfo("<b style=\"color:red;\">Able to select Registration Code without Institute</b>");

				DriverFactory.getInstance().getWebDriver().navigate().refresh();
				Thread.sleep(2000);

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

			System.out.println("*****Event Table is Present*****");
			ReportManager.logInfo("<b style=\"color:green;\">*****Event Table is Present*****</b>");
			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(3000);
			break;
		}

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
			if (str_SubjectCodeDropdownContent.equalsIgnoreCase("(EECE349J)MINI PROJECT")) {
				list_SubjectCodeDropdownContent.get(i).click();
				ReportManager.logInfo("Clicked on Subject -" + str_SubjectCodeDropdownContent + "</b>");
			}
		}
		Thread.sleep(2000);

		List<WebElement> list_ExamEventForSubjectTagging = webActions.getListOfWebElements(examEventForSubjectTagging);
		List<WebElement> list_ExamEventTypeForSubjectTagging = webActions
				.getListOfWebElements(examEventTypeForSubjectTagging);

		for (int i = 0; i < list_ExamEventForSubjectTagging.size(); i++) {
			String str_ExamEventForSubjectTagging = list_ExamEventForSubjectTagging.get(i).getText();

			if (str_ExamEventForSubjectTagging.equalsIgnoreCase("Mid Term Examination")) {
				String str_ExamEventTypeForSubjectTagging = list_ExamEventTypeForSubjectTagging.get(i).getText();
				if (str_ExamEventTypeForSubjectTagging.equalsIgnoreCase("Internal Exam")) {
					webActions.clearAndSendKeys(By.id("eventEXEVNTID190900001910"), "70"); // Change xpath accordingly
					Thread.sleep(2000);

					String totalWeightageText = webActions.getText(totalWeightage);

					ReportManager.logInfo("Exam Event -" + str_ExamEventForSubjectTagging + "</b>" + ", Event Type - "
							+ str_ExamEventTypeForSubjectTagging + "</b>" + "" + totalWeightageText + "");

					System.out.println("*****Verified Weigghtage Field:Accepted valid Numeric data*****");
					ReportManager.logInfo(
							"<b style=\"color:green;\">*****Verified Weigghtage Field :Accepted valid Numeric data*****</b>");
					DriverFactory.getInstance().getWebDriver().navigate().refresh();
					Thread.sleep(3000);
					break;

				} else {
					System.out.println("Weightage field is not accepted valid data");
					ReportManager.logInfo("<b style=\"color:red;\">Weightage field is not accepted valid data</b>");
					DriverFactory.getInstance().getWebDriver().navigate().refresh();
					Thread.sleep(2000);

				}
			}

		}

	}
//TC_08 

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
			if (str_SubjectCodeDropdownContent.equalsIgnoreCase("(EECE349J)MINI PROJECT")) {
				list_SubjectCodeDropdownContent.get(i).click();
				ReportManager.logInfo("Clicked on Subject -" + str_SubjectCodeDropdownContent + "</b>");
			}
		}
		Thread.sleep(2000);

		List<WebElement> list_ExamEventForSubjectTagging = webActions.getListOfWebElements(examEventForSubjectTagging);
		List<WebElement> list_ExamEventTypeForSubjectTagging = webActions
				.getListOfWebElements(examEventTypeForSubjectTagging);
		List<WebElement> list_CheckBoxForSubjectTagging = webActions.getListOfWebElements(checkBoxForSubjectTagging);

		for (int i = 0; i < list_ExamEventForSubjectTagging.size(); i++) {
			String str_ExamEventForSubjectTagging = list_ExamEventForSubjectTagging.get(i).getText();

			if (str_ExamEventForSubjectTagging.equalsIgnoreCase("Mid Term Examination")) {
				String str_ExamEventTypeForSubjectTagging = list_ExamEventTypeForSubjectTagging.get(i).getText();
				if (str_ExamEventTypeForSubjectTagging.equalsIgnoreCase("Internal Exam")) {
					list_CheckBoxForSubjectTagging.get(i).click();
					
					webActions.clearAndSendKeys(By.id("eventEXEVNTID190900001910"), "120"); // Change xpath accordingly
					Thread.sleep(2000);

					String InvalidWeightageAlert= webActions.getText(invalidWeightageAlert);
					webActions.verifyText(InvalidWeightageAlert, "Weightage must not be more than 100 !!");
					webActions.Click(okButton, "OK Button");
					

					ReportManager.logInfo("Exam Event -" + str_ExamEventForSubjectTagging + "</b>" + ", Event Type - "
							+ str_ExamEventTypeForSubjectTagging + "</b>" + "");

					System.out.println("*****Alert Message Displayed for Invalid Data:Weightage must not be more than 100 !! *****");
					ReportManager.logInfo(
							"<b style=\"color:green;\">*****Alert Message Displayed for Invalid Data:Weightage must not be more than 100 !! *****</b>");
					DriverFactory.getInstance().getWebDriver().navigate().refresh();
					Thread.sleep(3000);
					break;

				} else {
					System.out.println("Weightage field is not accepted valid data");
					ReportManager.logInfo("<b style=\"color:red;\">Weightage field is not accepted valid data</b>");
					DriverFactory.getInstance().getWebDriver().navigate().refresh();
					Thread.sleep(2000);

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

		if (webActions.isDisplayed(TagCoordinator, "Tag coordinator")) {

			System.out.println("*****Tag Coordinator option is present*****");
			ReportManager.logInfo("<b style=\"color:green;\">*****Tag Coordinator option is present*****</b>");
			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(2000);

		}

		else {

			System.out.println("Tag Coordinator option is not present");
			ReportManager.logInfo("<b style=\"color:red;\">Tag Coordinator option is not present</b>");
			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(2000);
		}
	}

//TC_10
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

			if (str_SubjectCodeDropdownContent.equalsIgnoreCase("(EECE349J)MINI PROJECT")) {
				list_SubjectCodeDropdownContent.get(i).click();
				ReportManager.logInfo("Clicked on Subject -" + str_SubjectCodeDropdownContent + "</b>");
			}
		}
		Thread.sleep(2000);

		List<WebElement> list_ExamEventForSubjectTagging = webActions.getListOfWebElements(examEventForSubjectTagging);
		List<WebElement> list_CheckBoxForSubjectTagging = webActions.getListOfWebElements(checkBoxForSubjectTagging);
		List<WebElement> list_ExamEventTypeForSubjectTagging = webActions
				.getListOfWebElements(examEventTypeForSubjectTagging);

		for (int i = 0; i < list_ExamEventForSubjectTagging.size(); i++) {
			String str_ExamEventForSubjectTagging = list_ExamEventForSubjectTagging.get(i).getText();

			if (str_ExamEventForSubjectTagging.equalsIgnoreCase("Assignment -01 (Assignment)")) {
				String str_ExamEventTypeForSubjectTagging = list_ExamEventTypeForSubjectTagging.get(i).getText();
				if (str_ExamEventTypeForSubjectTagging.equalsIgnoreCase("Internal Exam")) {
					list_CheckBoxForSubjectTagging.get(i).click();
					webActions.clearAndSendKeys(By.xpath("//input[@id='taggEXEVNTID190900001917event'][1]"), "0");// Change
																													// Xpath
																													// accordingly
					Thread.sleep(2000);

					ReportManager.logInfo("Exam Event -" + str_ExamEventForSubjectTagging + "</b>" + ", Event Type -"
							+ str_ExamEventTypeForSubjectTagging + "</b>");

					System.out.println("*****Passing Marks as Zero Accepted*******");
					ReportManager.logInfo("<b style=\"color:green;\">*****Passing Marks as Zero Accepted*******</b>");
					DriverFactory.getInstance().getWebDriver().navigate().refresh();
					Thread.sleep(2000);
					break;

				} else {
					System.out.println("Passing Marks as zero not accepted");
					ReportManager.logInfo("Passing Marks as zero not accepted");
					DriverFactory.getInstance().getWebDriver().navigate().refresh();
					Thread.sleep(2000);
					break;

				}
			}

		}

	}

//TC_11
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

			if (str_SubjectCodeDropdownContent.equalsIgnoreCase("(EECE349J)MINI PROJECT")) {
				list_SubjectCodeDropdownContent.get(i).click();
				ReportManager.logInfo("Clicked on Subject - " + str_SubjectCodeDropdownContent + "</b>");
				break;
			}
		}
		Thread.sleep(2000);

		List<WebElement> list_ExamEventForSubjectTagging = webActions.getListOfWebElements(examEventForSubjectTagging);
		List<WebElement> list_CheckBoxForSubjectTagging = webActions.getListOfWebElements(checkBoxForSubjectTagging);
		List<WebElement> list_TagCoordinatorButtonForSubjectTagging = webActions
				.getListOfWebElements(tagCoordinatorButtonForSubjectTagging);

		for (int i = 0; i < list_ExamEventForSubjectTagging.size(); i++) {
			String str_ExamEventForSubjectTagging = list_ExamEventForSubjectTagging.get(i).getText();
			if (str_ExamEventForSubjectTagging.equalsIgnoreCase("Mid Term Examination")) {
				boolean checkboxSelected = list_CheckBoxForSubjectTagging.get(i).isSelected();
				if (!checkboxSelected) {
					list_CheckBoxForSubjectTagging.get(i).click();
					Thread.sleep(2000);
					list_TagCoordinatorButtonForSubjectTagging.get(i).click();

					System.out.println("checkbox was not selected - now clicked on checkbox and Tagcoordinator");

				} else {

			//		System.out.println("check was already selected");
					list_TagCoordinatorButtonForSubjectTagging.get(i).click();
				//	System.out.println("Tag coordinator selected");

				}
				break;

			}

		}

		if (webActions.isDisplayed(tagTableHeaders, "Tag Table optioins")) {

			webActions.getElementSizeUsingFindElements(tagTableHeaders);
		}

		List<WebElement> list_tagTableHeaders = webActions.getListOfWebElements(tagTableHeaders);

		for (int i = 0; i < list_tagTableHeaders.size(); i++) {
			String str_tagTableHeaders = list_tagTableHeaders.get(i).getText();
			System.out.println(str_tagTableHeaders);
			ReportManager.logInfo(str_tagTableHeaders);
		}

		if (webActions.isDisplayed(tagTableHeaders, "Tag Table optioins")) {

			System.out.println("*****Tag coordinator Table details are displayed*****");
			ReportManager
					.logInfo("<b style=\"color:green;\">*****Tag coordinator Table details are displayed*****</b>");
			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(2000);
		}

		else {
			System.out.println("Tag coordinator table details are not displayed");

			ReportManager.logInfo("<b style=\"color:red;\">Tag coordinator table details are not displayed</b>");

			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(2000);

		}

	}

//TC_12 : Change Faculty and Batch Drop down xpath accordingly
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
			if (str_SubjectCodeDropdownContent.equalsIgnoreCase("(EECE349J)MINI PROJECT")) {
				list_SubjectCodeDropdownContent.get(i).click();
				ReportManager.logInfo("Clicked on Subject-" + str_SubjectCodeDropdownContent + "</b>");
				break;

			}
		}
		Thread.sleep(2000);

		List<WebElement> list_ExamEventForSubjectTagging = webActions.getListOfWebElements(examEventForSubjectTagging);
		List<WebElement> list_CheckBoxForSubjectTagging = webActions.getListOfWebElements(checkBoxForSubjectTagging);
		List<WebElement> list_TagCoordinatorButtonForSubjectTagging = webActions
				.getListOfWebElements(tagCoordinatorButtonForSubjectTagging);

		for (int i = 0; i < list_ExamEventForSubjectTagging.size(); i++) {
			String str_ExamEventForSubjectTagging = list_ExamEventForSubjectTagging.get(i).getText();
			if (str_ExamEventForSubjectTagging.equalsIgnoreCase("Mid Term Examination")) {
				boolean checkboxSelected = list_CheckBoxForSubjectTagging.get(i).isSelected();
				if (!checkboxSelected) {
					list_CheckBoxForSubjectTagging.get(i).click();
					Thread.sleep(2000);
					list_TagCoordinatorButtonForSubjectTagging.get(i).click();

					System.out.println("checkbox was not selected - now clicked on checkbox and Tagcoordinator");

				} else {

				//	System.out.println("check was already selected");
					list_TagCoordinatorButtonForSubjectTagging.get(i).click();
					//System.out.println("Tag coordinator selected");

				}
				break;

			}

		}

		if (webActions.isDisplayed(tagTableHeaders, "Tag Table optioins")) {

			webActions.Click(By.xpath("//option[text()='--Select Faculty--']//parent::select[@id='exfaculty1']"),
					" Faculty DropDown");
			webActions.selectByVisibleText(
					By.xpath("//option[text()='--Select Faculty--']//parent::select[@id='exfaculty1']"),
					" ARVIND  KUMAR ");
			Thread.sleep(3000);

			webActions.Click(By.xpath("//option[text()='--All Batch--']//parent::select[@id='exbranch1']"),
					"Batch DropDown");
			webActions.selectByVisibleText(
					By.xpath("//option[text()='--All Batch--']//parent::select[@id='exbranch1']"),
					"1617-B.Tech.-ECE-ECE-BATCH-8");
			Thread.sleep(3000);

			System.out.println("*****Faculty,Batch Dropdowns are selectable*****");
			ReportManager.logInfo("<b style=\"color:green;\">*****Faculty,Batch Dropdowns are selectable*****</b>");

			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(2000);

		}

		else {
			System.out.println("Faculty,Batch Dropdowns are not selectable");

			ReportManager.logInfo("<b style=\"color:red;\">Faculty,Batch Dropdowns are not selectable</b>");

			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(2000);

		}

	}

//TC_013 - Change Marks Entry checkbox xpath
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
			if (str_SubjectCodeDropdownContent.equalsIgnoreCase("(EECE349J)MINI PROJECT")) {
				list_SubjectCodeDropdownContent.get(i).click();
				ReportManager.logInfo("Clicked on Subject-" + str_SubjectCodeDropdownContent + "</b>");
				break;

			}
		}
		Thread.sleep(2000);

		List<WebElement> list_ExamEventForSubjectTagging = webActions.getListOfWebElements(examEventForSubjectTagging);
		List<WebElement> list_CheckBoxForSubjectTagging = webActions.getListOfWebElements(checkBoxForSubjectTagging);
		List<WebElement> list_TagCoordinatorButtonForSubjectTagging = webActions
				.getListOfWebElements(tagCoordinatorButtonForSubjectTagging);

		for (int i = 0; i < list_ExamEventForSubjectTagging.size(); i++) {
			String str_ExamEventForSubjectTagging = list_ExamEventForSubjectTagging.get(i).getText();
			if (str_ExamEventForSubjectTagging.equalsIgnoreCase("Mid Term Examination")) {
				boolean checkboxSelected = list_CheckBoxForSubjectTagging.get(i).isSelected();
				if (!checkboxSelected) {
					list_CheckBoxForSubjectTagging.get(i).click();
					Thread.sleep(2000);
					list_TagCoordinatorButtonForSubjectTagging.get(i).click();

					System.out.println("checkbox was not selected - now clicked on checkbox and Tagcoordinator");

				} else {

					System.out.println("check was already selected");
					list_TagCoordinatorButtonForSubjectTagging.get(i).click();
					System.out.println("Tag coordinator selected");

				}
				break;

			}

		}

		if (webActions.isDisplayed(tagTableHeaders, "Tag Table optioins")) {

//	boolean marksEntry_isSelected = DriverFactory.getInstance().getWebDriver().findElement(By.xpath("//input[@id='exmarks1']")).isSelected();
//
//			if (!marksEntry_isSelected) {

			webActions.Click(By.xpath("//input[@id='exmarks1']"), "Marks Entry");
			System.out.println("******Verified Marks Entry : Able to select MarksEntry checkbox******");
			ReportManager.logInfo(
					"<b style=\"color:green;\">******Verified Marks Entry : Able to select MarksEntry checkbox******</b>");

			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(2000);

		}

		else {
			System.out.println("MarksEntry checkbox not checked");

			ReportManager.logInfo("<b style=\"color:red;\">MarksEntry checkbox not checked</b>");
			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(2000);

		}

	}

//TC_014: change Marks entry xpath - id of xpath should be changed
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
			if (str_SubjectCodeDropdownContent.equalsIgnoreCase("(EECE349J)MINI PROJECT")) {
				list_SubjectCodeDropdownContent.get(i).click();
				ReportManager.logInfo("Clicked on Subject-" + str_SubjectCodeDropdownContent + "</b>");
				break;

			}
		}
		Thread.sleep(2000);

		List<WebElement> list_ExamEventForSubjectTagging = webActions.getListOfWebElements(examEventForSubjectTagging);
		List<WebElement> list_CheckBoxForSubjectTagging = webActions.getListOfWebElements(checkBoxForSubjectTagging);
		List<WebElement> list_TagCoordinatorButtonForSubjectTagging = webActions
				.getListOfWebElements(tagCoordinatorButtonForSubjectTagging);

		for (int i = 0; i < list_ExamEventForSubjectTagging.size(); i++) {
			String str_ExamEventForSubjectTagging = list_ExamEventForSubjectTagging.get(i).getText();
			if (str_ExamEventForSubjectTagging.contains("Supplementary Exam")) {
				boolean checkboxSelected = list_CheckBoxForSubjectTagging.get(i).isSelected();
				if (!checkboxSelected) {
					list_CheckBoxForSubjectTagging.get(i).click();
					Thread.sleep(2000);
					list_TagCoordinatorButtonForSubjectTagging.get(i).click();

					System.out.println("checkbox was not selected - now clicked on checkbox and Tagcoordinator");

				} else {

					System.out.println("check was already selected");
					list_TagCoordinatorButtonForSubjectTagging.get(i).click();
					System.out.println("Tag coordinator selected");

				}
				break;

			}

		}

		if (webActions.isDisplayed(tagTableHeaders, "Tag Table optioins")) {

			webActions.selectByVisibleText(
					By.xpath("//option[contains(text(),'--Grade Entry Faculty--')]//parent::select[@id='exgrade3']"),
					" ARVIND  KUMAR ");
			System.out.println("*****Grade Entry are selectable*****");

			ReportManager.logInfo("<b style=\"color:green;\">*****Grade Entry are selectable*****</b>");
			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(2000);

		}

		else {
			System.out.println("Grade Entry  are not selected");

			ReportManager.logInfo("<b style=\"color:red;\">Grade Entry  are not selected</b>");
			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(2000);

		}

	}

//TC_15 : Change Xpaths
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
			if (str_SubjectCodeDropdownContent.equalsIgnoreCase("(EECE349J)MINI PROJECT")) {
				list_SubjectCodeDropdownContent.get(i).click();
				ReportManager.logInfo("Clicked on Subject-" + str_SubjectCodeDropdownContent + "</b>");
				break;

			}
		}
		Thread.sleep(2000);

		List<WebElement> list_ExamEventForSubjectTagging = webActions.getListOfWebElements(examEventForSubjectTagging);
		List<WebElement> list_CheckBoxForSubjectTagging = webActions.getListOfWebElements(checkBoxForSubjectTagging);
		List<WebElement> list_TagCoordinatorButtonForSubjectTagging = webActions
				.getListOfWebElements(tagCoordinatorButtonForSubjectTagging);

		for (int i = 0; i < list_ExamEventForSubjectTagging.size(); i++) {
			String str_ExamEventForSubjectTagging = list_ExamEventForSubjectTagging.get(i).getText();
			if (str_ExamEventForSubjectTagging.contains("Supplementary Exam")) {
				boolean checkboxSelected = list_CheckBoxForSubjectTagging.get(i).isSelected();
				if (!checkboxSelected) {
					list_CheckBoxForSubjectTagging.get(i).click();
					Thread.sleep(2000);
					list_TagCoordinatorButtonForSubjectTagging.get(i).click();

					System.out.println("checkbox was not selected - now clicked on checkbox and Tagcoordinator");

				} else {

					System.out.println("check was already selected");
					list_TagCoordinatorButtonForSubjectTagging.get(i).click();
					System.out.println("Tag coordinator selected");

				}
				break;

			}

		}

		if (webActions.isDisplayed(tagTableHeaders, "Tag Table optioins")) {

			webActions.Click(By.xpath("//option[text()='--Select Faculty--']//parent::select[@id='exfaculty3']"),
					" Faculty DropDown");
			webActions.selectByVisibleText(
					By.xpath("//option[text()='--Select Faculty--']//parent::select[@id='exfaculty3']"),
					" ARVIND  KUMAR ");
			Thread.sleep(3000);

			webActions.Click(By.xpath("//option[text()='--All Batch--']//parent::select[@id='exbranch3']"),
					"Batch DropDown");
			webActions.selectByVisibleText(
					By.xpath("//option[text()='--All Batch--']//parent::select[@id='exbranch3']"),
					"1617-B.Tech.-ECE-ECE-BATCH-8");
			Thread.sleep(3000);

			webActions.Click(addButton, "Add Button");
			String ErrorAlert = webActions.getText(tagAddproblemAlert1);
			webActions.verifyText(ErrorAlert, "Please select any entry !!");
			webActions.Click(tagAddProblemAlertOKbutn, "OK Button");
			System.out.println("*****Alert Message Dispalyed: Please fill all required fields*****");
			ReportManager.logInfo(
					"<b style=\"color:green;\">*****Alert Message Dispalyed: Please fill all required fields*****</b>");
			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(2000);

		} else {

			System.out.println("No Alert message is displayed to select Grade and Marks Entry");
			ReportManager.logInfo(
					"<b style=\"color:red;\">No Alert message is displayed to select Grade and Marks Entry</b>");
			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(2000);

		}

	}

//TC_16 - Change Xpaths

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
			if (str_SubjectCodeDropdownContent.equalsIgnoreCase("(EECE349J)MINI PROJECT")) {
				list_SubjectCodeDropdownContent.get(i).click();
				ReportManager.logInfo("Clicked on Subject-" + str_SubjectCodeDropdownContent + "</b>");
				break;

			}
		}
		Thread.sleep(2000);

		List<WebElement> list_ExamEventForSubjectTagging = webActions.getListOfWebElements(examEventForSubjectTagging);
		List<WebElement> list_CheckBoxForSubjectTagging = webActions.getListOfWebElements(checkBoxForSubjectTagging);
		List<WebElement> list_TagCoordinatorButtonForSubjectTagging = webActions
				.getListOfWebElements(tagCoordinatorButtonForSubjectTagging);

		for (int i = 0; i < list_ExamEventForSubjectTagging.size(); i++) {
			String str_ExamEventForSubjectTagging = list_ExamEventForSubjectTagging.get(i).getText();
			if (str_ExamEventForSubjectTagging.equalsIgnoreCase("Mid Term Examination")) {
				boolean checkboxSelected = list_CheckBoxForSubjectTagging.get(i).isSelected();
				if (!checkboxSelected) {
					list_CheckBoxForSubjectTagging.get(i).click();
					Thread.sleep(2000);
					list_TagCoordinatorButtonForSubjectTagging.get(i).click();

					System.out.println("checkbox was not selected - now clicked on checkbox and Tagcoordinator");

				} else {

					System.out.println("check was already selected");
					list_TagCoordinatorButtonForSubjectTagging.get(i).click();
					System.out.println("Tag coordinator selected");

				}
				break;

			}

		}

		if (webActions.isDisplayed(tagTableHeaders, "Tag Table optioins")) {

			webActions.Click(By.xpath("//option[text()='--All Batch--']//parent::select[@id='exbranch1']"),
					"Batch DropDown");
			webActions.selectByVisibleText(
					By.xpath("//option[text()='--All Batch--']//parent::select[@id='exbranch1']"),
					"1617-B.Tech.-ECE-ECE-BATCH-8");
			Thread.sleep(3000);
			webActions.Click(By.xpath("//input[@id='exmarks1']"), "Marks Entry");

			webActions.Click(addButton, "Add Button");

			String Str_FacultyAlert = webActions.getText(tagAddproblemAlert2);

			webActions.verifyText(Str_FacultyAlert, "Please select Faculty !!");
			webActions.Click(tagAddProblemAlertOKbutn, "OK Button");
			System.out.println("******Alert Displayed:Please select Faculty !!*******");
			ReportManager
					.logInfo("<b style=\"color:green;\">******Alert Displayed:Please select Faculty !!*******</b>");

			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(2000);

		}

		else {
			System.out.println("No alert displayed: To select factuly");

			ReportManager.logInfo("<b style=\"color:red;\">No alert displayed: To select factuly</b>");

			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(2000);

		}

	}

	// TC_17 : Make sure that tag coordinators are empty
	public static void STSaveWithoutTag() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(examEventSubjectTagging, "Exam Event Subject Tagging");
		Thread.sleep(4000);

		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		Thread.sleep(4000);

		webActions.selectByVisibleText(registrationCode, " 1920_EVEN_SEMESTER ");
		Thread.sleep(4000);
		webActions.Click(subjectCodeDropdown, "Subject Code Dropdown");
		List<WebElement> list_SubjectCodeDropdownContent = webActions.getListOfWebElements(subjectCodeDropdownContent);

		for (int i = 0; i < list_SubjectCodeDropdownContent.size(); i++) {
			String str_SubjectCodeDropdownContent = list_SubjectCodeDropdownContent.get(i).getText();
			if (str_SubjectCodeDropdownContent.equalsIgnoreCase("(ECSE440L)DEEP LEARNING")) {
				list_SubjectCodeDropdownContent.get(i).click();
				ReportManager.logInfo("Clicked on Subject -" + str_SubjectCodeDropdownContent + "</b>");
				break;
			}
		}
		Thread.sleep(4000);

		List<WebElement> list_CheckBoxForSubjectTagging = webActions.getListOfWebElements(checkBoxForSubjectTagging);

		for (int i = 0; i < list_CheckBoxForSubjectTagging.size(); i++) 
		{
			boolean checkbox_isSelected = list_CheckBoxForSubjectTagging.get(i).isSelected();
			System.out.println(checkbox_isSelected);

			if (checkbox_isSelected == true) {
				
				list_CheckBoxForSubjectTagging.get(i).click();

				webActions.Click(yesButton, "Yes button");
				Thread.sleep(4000);
				webActions.Click(OK, "OK Button");
				Thread.sleep(4000);

				System.out.println("Enabled checkbox -Unchecked");

			} 
				  else 
				  { System.out.println("list of checkboxes which are selected");
				  
				  }
				 

		}

			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(2000);
			
		webActions.Click(saveButtonForSubjectTagging, "Save");
		Thread.sleep(2000);

		String problemAlert = webActions.getText(saveProblemAlert);
		if (problemAlert.equalsIgnoreCase("Please check atleast one event should be selected !!")) {

			webActions.Click(saveProblemAlertOK, "OK");

			System.out.println("*****Error Reason:No Event is selected*****");
			ReportManager.logInfo("<b style=\"color:green;\">*****Error Reason:No Event is selected*****</b>");
			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(2000);

		}

		else {
			System.out.println("No Tagging alert displayed");
			ReportManager.logInfo("<b style=\"color:red;\">No Tagging alert displayed</b>");
			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(2000);

		}

	}

	// TC_018 - Change Xpaths

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
			if (str_SubjectCodeDropdownContent.equalsIgnoreCase("(EECE349J)MINI PROJECT")) {
				list_SubjectCodeDropdownContent.get(i).click();
				ReportManager.logInfo("Clicked on Subject-" + str_SubjectCodeDropdownContent + "</b>");
				break;

			}
		}
		Thread.sleep(2000);

		List<WebElement> list_ExamEventForSubjectTagging = webActions.getListOfWebElements(examEventForSubjectTagging);
		List<WebElement> list_CheckBoxForSubjectTagging = webActions.getListOfWebElements(checkBoxForSubjectTagging);
		List<WebElement> list_TagCoordinatorButtonForSubjectTagging = webActions
				.getListOfWebElements(tagCoordinatorButtonForSubjectTagging);

		for (int i = 0; i < list_ExamEventForSubjectTagging.size(); i++) {
			String str_ExamEventForSubjectTagging = list_ExamEventForSubjectTagging.get(i).getText();
			if (str_ExamEventForSubjectTagging.equalsIgnoreCase("Mid Term Examination")) {
				boolean checkboxSelected = list_CheckBoxForSubjectTagging.get(i).isSelected();
				if (!checkboxSelected) {
					list_CheckBoxForSubjectTagging.get(i).click();
					Thread.sleep(2000);
					list_TagCoordinatorButtonForSubjectTagging.get(i).click();

					System.out.println("checkbox was not selected - now clicked on checkbox and Tagcoordinator");

				} else {

					System.out.println("check was already selected");
					list_TagCoordinatorButtonForSubjectTagging.get(i).click();
					System.out.println("Tag coordinator selected");

				}
				break;

			}

		}

		if (webActions.isDisplayed(tagTableHeaders, "Tag Table optioins")) {

			webActions.Click(By.xpath("//option[text()='--Select Faculty--']//parent::select[@id='exfaculty1']"),
					" Faculty DropDown");
			webActions.selectByVisibleText(
					By.xpath("//option[text()='--Select Faculty--']//parent::select[@id='exfaculty1']"),
					" ARVIND  KUMAR ");
			Thread.sleep(3000);

			webActions.Click(By.xpath("//option[text()='--All Batch--']//parent::select[@id='exbranch1']"),
					"Batch DropDown");
			webActions.selectByVisibleText(
					By.xpath("//option[text()='--All Batch--']//parent::select[@id='exbranch1']"),
					"1617-B.Tech.-ECE-ECE-BATCH-8");
			Thread.sleep(3000);

			webActions.Click(By.xpath("//input[@id='exmarks1']"), "Marks Entry");
			webActions.Click(addButton, "Add button");

			webActions.Click(saveButtonForSubjectTagging, "Save Button");
			String str_confirmationBox = webActions.getText(confirmationBox);
			webActions.verifyText(str_confirmationBox, "Record updated successfully !!");
			webActions.Click(okButton, "OK Button");

			System.out.println("******Record updated successfully*******");
			ReportManager.logInfo("<b style=\"color:green;\">******Record updated successfully*******</b>");

			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(2000);
		} else {
			System.out.println("Record was not updated");
			ReportManager.logInfo("<b style=\"color:red;\">Record was not updated</b>");
			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(2000);
		}
	}

}
