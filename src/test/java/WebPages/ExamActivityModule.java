package WebPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import Utilities.DriverFactory;
import Utilities.ReportManager;
import WebUtil.WebActions;

public class ExamActivityModule {
	
	// ============ Exam activity
		public static By examActivity = By.xpath("//span[.= 'Exam Activity']");
		public static By examEventMaster = By.xpath("//span[.= 'Exam Event Master']");
		public static By marksUpload = By.xpath("//span[.= 'Marks Upload']");
		
		// ============= Creating or Updating an Event
		public static By Institute = By.id("instituteid");
		public static By examEventType = By.id("exameventtype");
		public static By examEventCode = By.id("exameventcode");
		public static By examEventDescription = By.id("exameventdesc");
		public static By weightageTextBox = By.id("weightage");
		public static By maxMarksTextBox = By.id("maxmarks");
		public static By passingMarksTextBox = By.id("passingmarks");
		public static By totalSubEventConductedTextBox = By.id("totalsubeventconducted");
		public static By bestSubEventConsideredTextBox = By.id("bestsubeventconsidered");
		public static By saveButton = By.xpath("//button[@title = 'Save' and @type= 'submit']");
		public static By confirmationBox = By.xpath("//div[@class= 'swal2-container swal2-center swal2-fade swal2-shown']//div[@id = 'swal2-content']");
		public static By okButton = By.xpath("//div[@class= 'swal2-container swal2-center swal2-fade swal2-shown']//div[@class = 'swal2-actions']/button[1]");
		public static By searchButton = By.xpath("//div[@id= 'DataTables_Table_0_filter']//input[@type = 'search']");
		public static By searchOutputOfExamEventCode = By.xpath("//table[@id= 'DataTables_Table_0']//tr/td[3]");
		public static By searchOutputOfExamEventDesc = By.xpath("//table[@id= 'DataTables_Table_0']//tr/td[4]");
		public static By updateButton = By.xpath("//table[@id= 'DataTables_Table_0']//tr//td/button[@id= 'updateExamEventRow']");
		
		// ============= Deleting an Event	
		public static By deleteButton = By.xpath("//table[@id= 'DataTables_Table_0']//tr//td/button[@title= 'delete']");
		public static By yesButton = By.xpath("//div[@class= 'swal2-container swal2-center swal2-fade swal2-shown']//div[@class = 'swal2-actions']/button[1]");		
		public static By emptyResult =By.xpath("//table[@id= 'DataTables_Table_0']//td");
		
		// ============= Event visibility for Coordinator and Subject tagging
		public static By examEventSubjectTagging = By.xpath("//span[. = 'Exam Event Subject Tagging']");
		public static By InstituteInCoordinatorPage = By.id("exinstituteid");
		public static By registrationCode = By.id("regcode");
		public static By subjectCodeDropdown = By.xpath("//span[@class = 'dropdown-down']");
		public static By subjectCodeDropdownContent = By.xpath("//li[contains(@class, 'multiselect-item-checkbox')]/div");
		public static By examEventForSubjectTagging = By.xpath("//div[@id = 'examEventSubjectTaggingTable']//tr/td[3]");
		public static By examEventTypeForSubjectTagging = By.xpath("//div[@id = 'examEventSubjectTaggingTable']//tr/td[2]");
		public static By checkBoxForSubjectTagging = By.xpath("//div[@id = 'examEventSubjectTaggingTable']//tr/td/input[contains(@id, 'exsubid')]");
		public static By tagCoordinatorButtonForSubjectTagging = By.xpath("//div[@id = 'examEventSubjectTaggingTable']//tr/td/input[contains(@id, 'tagcoorbtnid')]");
		public static By selectFacultyDropdown = By.xpath("(//form[@class = 'ng-untouched ng-pristine ng-invalid'])[1]//select[contains(@id,'exfaculty')]");
		public static By batchDropdown = By.xpath("(//select[contains(@id,'exbranch')])[1]");
		public static By marksEntryCheckBox = By.xpath("//input[contains(@id, 'exmarks')]");
		public static By addButton = By.xpath("//input[contains(@id, 'exsetfacbtnid')]");
		public static By totalWeightage = By.xpath("//div[@id= 'wghtid']/span");
		public static By saveButtonForSubjectTagging = By.xpath("//button[@title= 'save']");
		
		// ============= Tagged subject visibility for Faculty and marks upload
		public static By subjectCodeFacultyPage = By.id("subcode");
		public static By subjectCodeDropdownContentFacultyPage = By.xpath("//select[@id='subcode']/option");
		public static By examEventCodeDropdownContentFacultyPage = By.xpath("//select[@id='exameventcode']/option");
		public static By lockStatus = By.xpath("//div[@class='form-group']/label[.= 'Lock Status :']/following-sibling::label");
		
		// ============= To unlock subject for marks upload
			public static By unlockMarksEntry = By.xpath("//span[.= 'Unlock Marks Entry']");
			public static By regCode = By.id("regcodeid");
			public static By examEventCodeMarksUpload = By.id("exameventid");
			public static By getDetailsButton = By.xpath("//button[@class = 'btn btn-success' and @title = 'get details']");
			public static By fromDate = By.id("fromdate");
			public static By toDate = By.id("todate");
			public static By facultyNameColumnInSearchOutput = By.xpath("//table[@class = 'table table-bordered']//td[6]");
			public static By SNoCheckboxInSearchOutput = By.xpath("//table[@class = 'table table-bordered']//td[1]");
			public static By lockExamMarksCheckbox = By.xpath("//table[@class = 'table table-bordered']//td[.='Lock Exam Marks']/input");
			public static By acceptButton = By.xpath("//button[.='Accept ']");
			public static By saveButtonForChanges = By.xpath("//button[@class = 'btn btn-success' and @title = 'save']");
			
			// ============= unlock status and file upload
			public static By chooseFileButton = By.xpath("//input[@class = 'btn btn-success' and @title = 'Browse to upload Marks Excel File']");
			
		static WebActions webActions = new WebActions();
		static JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();
		static EventFiringWebDriver eventFiringWebdriver = new EventFiringWebDriver (DriverFactory.getInstance().getWebDriver());
		
		/**
		 * =============================================================================
		 * Method: CreateEvent | Author: Padmaja | Date:14 Apr 2020 |
		 * Description: This method creates an Event in Exam Activity Module
		 * =============================================================================
		 * @throws InterruptedException 
		 * **/
		
		public static void CreateEvent() throws InterruptedException
		{
			webActions.Click(examActivity, "Exam Activity");
			webActions.Click(examEventMaster, "Exam Event Master");
			Thread.sleep(4000);
			
			webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
			webActions.selectByVisibleText(examEventType, " INTERN ");
			webActions.sendKeys(examEventCode, "Test Automation");
			webActions.sendKeys(examEventDescription, "Created through Automation");
			webActions.sendKeys(weightageTextBox, "50");
			webActions.sendKeys(maxMarksTextBox, "100");
			webActions.sendKeys(passingMarksTextBox, "35");
			webActions.sendKeys(totalSubEventConductedTextBox, "2");
			webActions.sendKeys(bestSubEventConsideredTextBox, "1");
			Thread.sleep(2000);
			webActions.Click(saveButton, "Save Button");	
			Thread.sleep(3000);
			String str_confirmationBox= webActions.getText(confirmationBox);
			webActions.verifyText(str_confirmationBox, "Data Inserted successfully!!");
			webActions.Click(okButton, "OK Button");
			Thread.sleep(2000);
			webActions.Click(searchButton, "Search Button");
			webActions.sendKeys(searchButton, "Test Automation");
			List<WebElement> listOfSearchOutput = webActions.getListOfWebElements(searchOutputOfExamEventCode);
			for(int i=0; i<listOfSearchOutput.size(); i++)
			{
				String searchResult = listOfSearchOutput.get(i).getText();
				System.out.println(searchResult);			
				if(searchResult.equalsIgnoreCase("Test Automation"))
				{
					ReportManager.logInfo("<b style=\"color:green;\"> ***** Successfully event created - "+searchResult+" *****</b>");
				}
			}
		}

	/***********************************************************************************************************/
		
		
		/**
		 * =============================================================================
		 * Method: UpdateEvent | Author: Padmaja | Date:15 Apr 2020 |
		 * Description: This method edit/update any Event details created in Exam Activity Module
		 * =============================================================================
		 * @throws InterruptedException 
		 **/
		public static void UpdateEvent() throws InterruptedException
		{
			webActions.Click(examActivity, "Exam Activity");
			webActions.Click(examEventMaster, "Exam Event Master");
			Thread.sleep(4000);
			
			webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
			webActions.selectByVisibleText(examEventType, " INTERN ");
			Thread.sleep(3000);
			webActions.Click(searchButton, "Search Button");
			webActions.sendKeys(searchButton, "Test Event");
			List<WebElement> listOfSearchOutput = webActions.getListOfWebElements(searchOutputOfExamEventCode);
			List<WebElement> listOfUpdateButton = webActions.getListOfWebElements(updateButton);
			
			for(int i=0; i<listOfSearchOutput.size(); i++)
			{
				String searchResult = listOfSearchOutput.get(i).getText();
				System.out.println(searchResult);			
				if(searchResult.equalsIgnoreCase("Test Event"))
				{
					listOfUpdateButton.get(i).click();
				}
			}
			webActions.clearAndSendKeys(examEventDescription, "updated through automation");
			webActions.clearAndSendKeys(weightageTextBox, "35");
			webActions.clearAndSendKeys(maxMarksTextBox, "50");
			webActions.clearAndSendKeys(passingMarksTextBox, "15");
			webActions.Click(saveButton, "Save Button");
			String str_confirmationBox= webActions.getText(confirmationBox);
			webActions.verifyText(str_confirmationBox, "Data updated successfully!!");
			webActions.Click(okButton, "OK Button");
			Thread.sleep(5000);
			webActions.Click(searchButton, "Search Button");
			webActions.sendKeys(searchButton, "Test Event");
			
			List<WebElement> listOfSearchOutputAfterUpdate = webActions.getListOfWebElements(searchOutputOfExamEventCode);
			List<WebElement> listOfExamEventDesc = webActions.getListOfWebElements(searchOutputOfExamEventDesc);
			for(int i=0; i<listOfSearchOutputAfterUpdate.size(); i++)
			{
				String searchOutputAfterUpdate = listOfSearchOutputAfterUpdate.get(i).getText();
				System.out.println(searchOutputAfterUpdate);			
				if(searchOutputAfterUpdate.equalsIgnoreCase("Test Event"))
				{
					String examEventDesc = listOfExamEventDesc.get(i).getText();
					if(examEventDesc.equalsIgnoreCase("updated through automation"))
					{
						ReportManager.logInfo("Successfully event updated - <b style=\"color:green;\">"+examEventDesc+"</b>");
					}
				}
			}
		}
		
		
	/***********************************************************************************************************/
		
		/**
		 * ===================================================================================
		 * Method: DeleteEvent | Author: Padmaja | Date:15 Apr 2020 |
		 * Description: This method Delete any Event details created in Exam Activity Module
		 * ===================================================================================
		 * @throws InterruptedException 
		 **/
		public static void DeleteEvent() throws InterruptedException
		{
			webActions.Click(examActivity, "Exam Activity");
			webActions.Click(examEventMaster, "Exam Event Master");
			Thread.sleep(4000);
			
			webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
			webActions.selectByVisibleText(examEventType, " INTERN ");
			
			webActions.Click(searchButton, "Search Button");
			webActions.sendKeys(searchButton, "Test Automation");
			List<WebElement> listOfSearchOutput = webActions.getListOfWebElements(searchOutputOfExamEventCode);
			List<WebElement> listOfDeleteButton = webActions.getListOfWebElements(deleteButton);
			
			for(int i=0; i<listOfSearchOutput.size(); i++)
			{
				String searchResult = listOfSearchOutput.get(i).getText();
				System.out.println(searchResult);			
				if(searchResult.equalsIgnoreCase("Test Automation"))
				{
					listOfDeleteButton.get(i).click();
				}
			}
			String str_confirmationBox= webActions.getText(confirmationBox);
			webActions.verifyText(str_confirmationBox, "Please NOTE: This entry might be used in other source !!");
			webActions.Click(yesButton, "Yes Button");
			Thread.sleep(3000);
			String str_confirmationBox2= webActions.getText(confirmationBox);
			webActions.verifyText(str_confirmationBox2, "Record deleted successfully !!");
			webActions.Click(okButton, "OK Button");
			Thread.sleep(3000);
			webActions.Click(searchButton, "Search Button");
			webActions.sendKeys(searchButton, "Test Automation");
			String str_emptyResult = webActions.getText(emptyResult);
			webActions.verifyText(str_emptyResult, "No matching records found");
			if(str_emptyResult.equalsIgnoreCase("No matching records found"))
			{
				ReportManager.logInfo("<b style=\"color:green;\"> ***** Event Successfully deleted *****</b>");	
			}
			else {
				ReportManager.logInfo("<b style=\"color:red;\"> ***** Event couldn't be deleted *****</b>");	
			}
		}
		
			
	/***********************************************************************************************************/
		
			/**
			 * =======================================================================================
			 * Method: CreatedEventVisibleToCoordinator | Author: Padmaja | Date:16 Apr 2020 |
			 * Description: This method is to verify event created by Dean is visible to Coordinator
			 * =======================================================================================
			 * @throws InterruptedException 
			 * 
			 **/
			public static void CreatedEventVisibleToCoordinator() throws InterruptedException
			{
				webActions.Click(examActivity, "Exam Activity");
				webActions.Click(examEventSubjectTagging, "Exam Event Subject Tagging");
				Thread.sleep(4000);
				webActions.selectByVisibleText(InstituteInCoordinatorPage, " School of Engineering and Applied Sciences ");
				Thread.sleep(4000);
				
				List<WebElement> list_ExamEventForSubjectTagging = webActions.getListOfWebElements(examEventForSubjectTagging);
				for(int i=0; i<list_ExamEventForSubjectTagging.size(); i++)
				{
					String str_ExamEventForSubjectTagging = list_ExamEventForSubjectTagging.get(i).getText();
					System.out.println(str_ExamEventForSubjectTagging);
							
				if(str_ExamEventForSubjectTagging.equalsIgnoreCase("Test Event3"))
				{
					ReportManager.logInfo("<b style=\"color:green;\"> ***** Created Event Test Event3 is visible*****</b>");	
				}
				else {
					
				}
				}
			}
			
			
	/***********************************************************************************************************/
			
			/**
			 * =======================================================================================
			 * Method: TaggingSubjectsToFaculties | Author: Padmaja | Date:17 Apr 2020 |
			 * Description: This method is to verify Coordinator is able to tag subjects to the faculties
			 * =======================================================================================
			 * @throws InterruptedException 
			 **/
			
			public static void TaggingSubjectToFaculty() throws InterruptedException
			{
				webActions.Click(examActivity, "Exam Activity");
				webActions.Click(examEventSubjectTagging, "Exam Event Subject Tagging");
				Thread.sleep(4000);
				webActions.selectByVisibleText(InstituteInCoordinatorPage, " School of Engineering and Applied Sciences ");
				webActions.selectByVisibleText(registrationCode, " 1920_EVEN_SEMESTER ");
				webActions.Click(subjectCodeDropdown, "Subject Code Dropdown");
				
				List<WebElement> list_SubjectCodeDropdownContent = webActions.getListOfWebElements(subjectCodeDropdownContent);
				
				for(int i=0; i<list_SubjectCodeDropdownContent.size(); i++)
				{
					String str_SubjectCodeDropdownContent = list_SubjectCodeDropdownContent.get(i).getText();
					System.out.println(str_SubjectCodeDropdownContent);
					
					if(str_SubjectCodeDropdownContent.equalsIgnoreCase("(ECSE440L)DEEP LEARNING"))
					{
						list_SubjectCodeDropdownContent.get(i).click();
						ReportManager.logInfo("Clicked on Subject - <b style=\"color:green;\">"+str_SubjectCodeDropdownContent+"</b>");
					}
				}
				Thread.sleep(2000);
				List<WebElement> list_ExamEventForSubjectTagging = webActions.getListOfWebElements(examEventForSubjectTagging);
				
				webActions.getText(totalWeightage);	
				
				for(int i=0; i<list_ExamEventForSubjectTagging.size(); i++)
				{
					String str_ExamEventForSubjectTagging = list_ExamEventForSubjectTagging.get(i).getText();
					System.out.println(str_ExamEventForSubjectTagging);
					
					List<WebElement> list_ExamEventTypeForSubjectTagging = webActions.getListOfWebElements(examEventTypeForSubjectTagging);
					List<WebElement> list_CheckBoxForSubjectTagging = webActions.getListOfWebElements(checkBoxForSubjectTagging);
					List<WebElement> list_TagCoordinatorButtonForSubjectTagging = webActions.getListOfWebElements(tagCoordinatorButtonForSubjectTagging);	
				
					if(str_ExamEventForSubjectTagging.equalsIgnoreCase("Mid Term Examination")||(str_ExamEventForSubjectTagging.equalsIgnoreCase("End Term Examination"))||(str_ExamEventForSubjectTagging.equalsIgnoreCase("Project Report")))
					{
						list_CheckBoxForSubjectTagging.get(i).click();
						ReportManager.logInfo("Clicked on - <b style=\"color:green;\">Check box</b>");
						
						String totalWeightageText= webActions.getText(totalWeightage);
						String str_ExamEventTypeForSubjectTagging = list_ExamEventTypeForSubjectTagging.get(i).getText();
										
						ReportManager.logInfo("Exam Event - <b style=\"color:green;\">"+str_ExamEventForSubjectTagging+"</b>"
								+ ", Event Type - <b style=\"color:green;\">"+str_ExamEventTypeForSubjectTagging+"</b>"
								+ ", <b style=\"color:green;\">"+totalWeightageText+"");
					}
				}
				jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				Thread.sleep(2000);
				jse.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
				for(int i=0; i<list_ExamEventForSubjectTagging.size(); i++)
				{
				String str_ExamEventForSubjectTagging = list_ExamEventForSubjectTagging.get(i).getText();
				System.out.println(str_ExamEventForSubjectTagging);
				
				List<WebElement> list_TagCoordinatorButtonForSubjectTagging = webActions.getListOfWebElements(tagCoordinatorButtonForSubjectTagging);	
			
				if(str_ExamEventForSubjectTagging.equalsIgnoreCase("Mid Term Examination"))
				{
					
					list_TagCoordinatorButtonForSubjectTagging.get(i).click();
					ReportManager.logInfo("Clicked on - <b style=\"color:green;\">Tag Coordinator</b>");
					
					webActions.selectByVisibleText(selectFacultyDropdown, " ARVIND  KUMAR ");
					webActions.selectByVisibleText(batchDropdown, " 1718-B.Tech.-MECH-BT_MECH-BATCH_1718-6 ");
					webActions.Click(marksEntryCheckBox, "Marks Entry Checkbox");
					webActions.Click(addButton, "Add button");	
					
					webActions.selectByVisibleText(selectFacultyDropdown, " Kiran Sudha ");
					webActions.selectByVisibleText(batchDropdown, " 1718-B.Tech.-CSE-BT_CSE-BATCH_1718-6 ");
					webActions.Click(addButton, "Add button");
					
					list_TagCoordinatorButtonForSubjectTagging.get(i).click();	
								
					//eventFiringWebdriver.executeScript("document.getElementById('examEventSubjectTaggingTable').scrollTop=10000");
				}
				}
				webActions.Click(saveButtonForSubjectTagging, "Save Button");
				String str_confirmationBox = webActions.getText(confirmationBox);
				webActions.verifyText(str_confirmationBox, "Record updated successfully !!");
				webActions.Click(okButton, "OK Button");
			}
			
			
	/***********************************************************************************************************/
			
			/**
			 * =======================================================================================
			 * Method: VerifyViewingTaggedSubjects | Author: Padmaja | Date:21 Apr 2020 |
			 * Description: This method is to verify that faculty is able to view tagged subjects
			 * =======================================================================================
			 * @throws InterruptedException 
			 **/
			
			public static void VerifyTaggedSubjects() throws InterruptedException
			{
				webActions.Click(examActivity, "Exam Activity");
				webActions.Click(marksUpload, "Marks Upload");
				Thread.sleep(3000);
				
				webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
				webActions.selectByVisibleText(registrationCode, " 1920_EVEN_SEMESTER ");
				Thread.sleep(3000);
				webActions.Click(subjectCodeFacultyPage, "Subject Code Dropdown");
				Thread.sleep(3000);
				List<WebElement> list_subjectCodeDropdownContentFacultyPage = webActions.getListOfWebElements(subjectCodeDropdownContentFacultyPage);
				System.out.println(list_subjectCodeDropdownContentFacultyPage.size());
				
				for(int i=0; i<list_subjectCodeDropdownContentFacultyPage.size(); i++)
				{
					String str_subjectCodeDropdownContentFacultyPage= list_subjectCodeDropdownContentFacultyPage.get(i).getText();
					System.out.println(str_subjectCodeDropdownContentFacultyPage);
					
					if(str_subjectCodeDropdownContentFacultyPage.equalsIgnoreCase("ECSE440L ( DEEP LEARNING)"))
					{
						ReportManager.logInfo("Subject code present in the list - <b style=\"color:green;\">"+str_subjectCodeDropdownContentFacultyPage+"</b>");
					}
				}
				webActions.selectByVisibleText(subjectCodeFacultyPage, " ECSE440L ( DEEP LEARNING) ");
				
				Thread.sleep(1000);
				webActions.Click(examEventCode, "Exam Event Code Dropdown");
				
				List<WebElement> list_examEventCodeDropdownContentFacultyPage = webActions.getListOfWebElements(examEventCodeDropdownContentFacultyPage);
				System.out.println(list_examEventCodeDropdownContentFacultyPage.size());
				
				for(int i=0; i<list_examEventCodeDropdownContentFacultyPage.size(); i++)
				{
					String str_examEventCodeDropdownContentFacultyPage= list_examEventCodeDropdownContentFacultyPage.get(i).getText();
					System.out.println(str_examEventCodeDropdownContentFacultyPage);
					
					if(str_examEventCodeDropdownContentFacultyPage.equalsIgnoreCase(" Mid Term Examination ( Mid Term Examination) "))
					{
						//list_examEventCodeDropdownContentFacultyPage.get(i).click();
						ReportManager.logInfo("Event code present in the list - <b style=\"color:green;\">"+str_examEventCodeDropdownContentFacultyPage+"</b>");
					}
				}
				Thread.sleep(2000);			
			}
			
			
	/***********************************************************************************************************/
			
			/**
			 * =======================================================================================
			 * Method: MarksUploadWhenStatusLocked | Author: Padmaja | Date:22 Apr 2020 |
			 * Description: This method is to verify upload marks when status is Locked
			 * =======================================================================================
			 * @throws InterruptedException 
			 **/
			
			public static void MarksUploadWhenStatusLocked() throws InterruptedException
			{
				webActions.Click(examActivity, "Exam Activity");
				webActions.Click(marksUpload, "Marks Upload");
				Thread.sleep(3000);
				
				webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
				webActions.selectByVisibleText(registrationCode, " 1920_EVEN_SEMESTER ");
				Thread.sleep(3000);
				webActions.Click(subjectCodeFacultyPage, "Subject Code Dropdown");
				Thread.sleep(2000);
				webActions.selectByVisibleText(subjectCodeFacultyPage, " ECSE440L ( DEEP LEARNING) ");
				Thread.sleep(2000);
				webActions.Click(examEventCode, "Exam Event Code Dropdown");
				Thread.sleep(2000);
				webActions.selectByVisibleText(examEventCode, " Mid Term Examination ( Mid Term Examination) ");
				webActions.Click(confirmationBox, "Pop up");
				webActions.Click(okButton, "OK Button");
				String lockStatusText = webActions.getText(lockStatus);
				if(lockStatusText.equalsIgnoreCase("Locked"))
				{
					ReportManager.logInfo("Lock Status is - <b style=\"color:green;\"> "+lockStatusText+"</b>");
				}
				else {
					ReportManager.logInfo("Lock Status is - <b style=\"color:red;\"> "+lockStatusText+"</b>");
				}
			}


	/***********************************************************************************************************/

	/**
	 * =======================================================================================
	 * Method: UnlockSubjectForMarksUpload | Author: Padmaja | Date:22 Apr 2020 |
	 * Description: This method is to verify that Dean is able to Unlock subject for marks upload
	 * =======================================================================================
	 * @throws InterruptedException 
	 **/

	public static void UnlockSubjectForMarksUpload() throws InterruptedException
	{
		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(unlockMarksEntry, "Unlock Marks Entry");
		Thread.sleep(4000);
		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		webActions.selectByVisibleText(regCode, " 1920_EVEN_SEMESTER ");
		webActions.selectByVisibleText(examEventCodeMarksUpload, " Mid Term Examination - Mid Term Examination ");
		
		webActions.Click(subjectCodeDropdown, "Subject Code Dropdown");
		List<WebElement> list_SubjectCodeDropdownContent = webActions.getListOfWebElements(subjectCodeDropdownContent);
		
		for(int i=0; i<list_SubjectCodeDropdownContent.size(); i++)
		{
			String str_SubjectCodeDropdownContent = list_SubjectCodeDropdownContent.get(i).getText();
			System.out.println(str_SubjectCodeDropdownContent);
			
			if(str_SubjectCodeDropdownContent.equalsIgnoreCase("(ECSE440L) DEEP LEARNING"))
			{
				list_SubjectCodeDropdownContent.get(i).click();
				ReportManager.logInfo("Clicked on Subject - <b style=\"color:green;\">"+str_SubjectCodeDropdownContent+"</b>");
			}
		}
		
		webActions.Click(getDetailsButton, "Get Details Button");
		jse.executeScript ("document.getElementById('fromdate').removeAttribute('readonly',0);"); 
		webActions.clearAndSendKeys(fromDate, "20/04/2020");
		Thread.sleep(2000);
		jse.executeScript ("document.getElementById('todate').removeAttribute('readonly',0);"); 
		webActions.clearAndSendKeys(toDate, "30/04/2020");
		Thread.sleep(1000);
		List<WebElement> list_facultyName = webActions.getListOfWebElements(facultyNameColumnInSearchOutput);
		List<WebElement> list_checkbox = webActions.getListOfWebElements(SNoCheckboxInSearchOutput);
		
		for(int i=0; i<list_facultyName.size(); i++)
		{
			String str_facultyName = list_facultyName.get(i).getText();
			if(str_facultyName.equalsIgnoreCase("(15120047) ARVIND KUMAR"))
			{
				list_checkbox.get(i).click();
				ReportManager.logInfo("Clicked on SNo. checkbox for - <b style=\"color:green;\"> ARVIND KUMAR</b>");
			}
		}
//		webActions.isEnabled(lockExamMarksCheckbox, "Lock Exam Marks");
		webActions.Click(lockExamMarksCheckbox, "Lock Exam Marks Checkbox to Disable");
		webActions.Click(acceptButton, "Accept Button");
		webActions.Click(saveButtonForChanges, "Save Button");
		
		String str_confirmationBox= webActions.getText(confirmationBox);
		webActions.verifyText(str_confirmationBox, "Data Updated Successfully. !!!");
		webActions.Click(okButton, "OK Button");
		Thread.sleep(2000);
	}


	/***********************************************************************************************************/

	/**
	 * =======================================================================================
	 * Method: UnlockStatusVisibleToFaculty | Author: Padmaja | Date:22 Apr 2020 |
	 * Description: This method is to verify that Faculty is able to view Unlocked status and 
	 * Upload excel file option for marks upload
	 * =======================================================================================
	 * @throws InterruptedException 
	 **/

	public static void UnlockStatusVisibleToFaculty() throws InterruptedException
	{
		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(marksUpload, "Marks Upload");
		Thread.sleep(4000);
		
		webActions.selectByVisibleText(Institute, " School of Engineering and Applied Sciences ");
		webActions.selectByVisibleText(registrationCode, " 1920_EVEN_SEMESTER ");
		Thread.sleep(3000);
		webActions.Click(subjectCodeFacultyPage, "Subject Code Dropdown");
		Thread.sleep(2000);
		webActions.selectByVisibleText(subjectCodeFacultyPage, " ECSE440L ( DEEP LEARNING) ");
		Thread.sleep(2000);
		webActions.Click(examEventCode, "Exam Event Code Dropdown");
		Thread.sleep(2000);
		webActions.selectByVisibleText(examEventCode, " Mid Term Examination ( Mid Term Examination) ");
		
		webActions.isDisplayed(chooseFileButton, "Choose File option");
		
		String lockStatusText = webActions.getText(lockStatus);
		if(lockStatusText.equalsIgnoreCase("Locked"))
		{
			ReportManager.logInfo("Lock Status is - <b style=\"color:green;\"> "+lockStatusText+"</b>");
		}
		else {
			ReportManager.logInfo("Lock Status is - <b style=\"color:green;\"> "+lockStatusText+"</b>");
		}
		
	}
	


// ======================================================Excel file Uploading in-progress(Haritha)

public void UploadMarksExcel() throws InterruptedException {
	
	webActions.Click(examActivity, "Exam Activity");
	webActions.Click(examEventSubjectTagging, "Exam Event Subject Tagging");
	Thread.sleep(5000);
	
	webActions.selectByVisibleText(InstituteInCoordinatorPage, " School of Engineering and Applied Sciences ");
	webActions.selectByVisibleText(registrationCode, " 1920_EVEN_SEMESTER ");
	webActions.Click(subjectCodeDropdown, "Subject Code Dropdown");
	
	List<WebElement> ListOfSubjectCodes = webActions.getListOfWebElements(subjectCodeDropdownContent);
	
	for(int i=0; i<ListOfSubjectCodes.size(); i++)
	{
		String Str_SubjectCode = ListOfSubjectCodes.get(i).getText();
		System.out.println(Str_SubjectCode);
		
		if(Str_SubjectCode.equalsIgnoreCase("(ECSE205L)SOFTWARE ENGINEERING"))
		{
			ListOfSubjectCodes.get(i).click();
			ReportManager.logInfo("Clicked on Subject - <b style=\"color:green;\">"+Str_SubjectCode+"</b>");
		}
	}
	
	Thread.sleep(3000);
	
	List<WebElement> list_ExamEventForSubjectTagging = webActions.getListOfWebElements(examEventForSubjectTagging);
	List<WebElement> list_ExamEventTypeForSubjectTagging = webActions.getListOfWebElements(examEventTypeForSubjectTagging);
	List<WebElement> list_CheckBoxForSubjectTagging = webActions.getListOfWebElements(checkBoxForSubjectTagging);
	
	webActions.getText(totalWeightage);	
	
	for(int i=0; i<list_ExamEventForSubjectTagging.size(); i++)
	{
		String str_ExamEventForSubjectTagging = list_ExamEventForSubjectTagging.get(i).getText();
		System.out.println(str_ExamEventForSubjectTagging);
		
		if(str_ExamEventForSubjectTagging.equalsIgnoreCase("Mid Term Examination")||(str_ExamEventForSubjectTagging.equalsIgnoreCase("End Term Examination"))||(str_ExamEventForSubjectTagging.equalsIgnoreCase("Project Report")))
		{
			list_CheckBoxForSubjectTagging.get(i).click();
			ReportManager.logInfo("Clicked on - <b style=\"color:green;\">Check box</b>");
			
			String totalWeightageText= webActions.getText(totalWeightage);
			
			String str_ExamEventTypeForSubjectTagging = list_ExamEventTypeForSubjectTagging.get(i).getText();
							
			ReportManager.logInfo("Exam Event - <b style=\"color:green;\">"+str_ExamEventForSubjectTagging+"</b>"
					+ ", Event Type - <b style=\"color:green;\">"+str_ExamEventTypeForSubjectTagging+"</b>"
					+ ", <b style=\"color:green;\">"+totalWeightageText+"");
		}
	}
	jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	Thread.sleep(2000);
	
	jse.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
	
	
	
	
	for(int i=0; i<list_ExamEventForSubjectTagging.size(); i++)
	{
	String str_ExamEventForSubjectTagging = list_ExamEventForSubjectTagging.get(i).getText();
	System.out.println(str_ExamEventForSubjectTagging);
	
	List<WebElement> list_TagCoordinatorButtonForSubjectTagging = webActions.getListOfWebElements(tagCoordinatorButtonForSubjectTagging);	

	if(str_ExamEventForSubjectTagging.equalsIgnoreCase("Mid Term Examination"))
	{
		
		list_TagCoordinatorButtonForSubjectTagging.get(i).click();
		ReportManager.logInfo("Clicked on - <b style=\"color:green;\">Tag Coordinator</b>");
		
		webActions.selectByVisibleText(selectFacultyDropdown, " ARVIND  KUMAR ");
		webActions.selectByVisibleText(batchDropdown, " 1718-B.Tech.-MECH-BT_MECH-BATCH_1718-6 ");
		webActions.Click(marksEntryCheckBox, "Marks Entry Checkbox");
		webActions.Click(addButton, "Add button");	
		
		webActions.selectByVisibleText(selectFacultyDropdown, " Kiran Sudha ");
		webActions.selectByVisibleText(batchDropdown, " 1718-B.Tech.-CSE-BT_CSE-BATCH_1718-6 ");
		webActions.Click(addButton, "Add button");
		
		list_TagCoordinatorButtonForSubjectTagging.get(i).click();	
					
		//eventFiringWebdriver.executeScript("document.getElementById('examEventSubjectTaggingTable').scrollTop=10000");
	}
	}	
	
	
}
}


