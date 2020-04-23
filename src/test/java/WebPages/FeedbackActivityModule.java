package WebPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import Utilities.DriverFactory;
import Utilities.ReportManager;
import WebUtil.WebActions;

public class FeedbackActivityModule {
	// ================================FeedbackActivity
	public static By feedbackactivity = By.xpath("//span[contains(text(),'Feedback Activity')]");
	public static By feedbackeventmanager = By.xpath("//span[contains(text(),'Feedback Event Manager')]");

	// ==============================EventCodeCreation and VerifyCreatedEVentCode
	public static By institutecode = By.xpath("//select[@id='instituteid']");
	public static By eventregistrationcode = By.xpath("//select[@id='regcode']");
	public static By facultyradiobutn = By.xpath("//input[@id='faculty']");
	public static By eventcode = By.xpath("//input[@placeholder='Select/Enter Event Code']");
	public static By eventdesc = By.xpath("//input[@id='eventDesc']");
	public static By minCGPA = By.xpath("//input[@id='minCGPA']");
	public static By minAttendance = By.xpath("//input[@id='minAttendance']");
	public static By fromDate = By.xpath("//input[@name='fromDate']");
	public static By fromdatelist = By.xpath("//table[@class='ui-datepicker-calendar']//td");
	public static By todate = By.xpath("//input[@name='toDate']");
	public static By todatelist = By.xpath("//table[@class='ui-datepicker-calendar']//td");
	public static By feedbackbox = By.xpath("//div[@role='textbox']");
	public static By selectallsubjectcheckbox = By.xpath("//input[@title='Select All' and @type='checkbox']");
	public static By questiontemplate = By.xpath("//span[contains(text(),'--Select Question Template--')]");
	public static By ddfacultyfeedback = By.xpath("//div[contains(text(),'faculty feedback')]");
	public static By Save = By.xpath("//button[contains(text(),'Save')]");
	public static By Updated = By.xpath("//h2[contains(text(),'Updated')]");
	public static By UpdateOKbutn = By.xpath("//button[contains(text(),'OK')]");
	public static By eventdropdown = By.xpath("//ul//parent::div[@class='suggestions-container is-visible']//li//descendant::a['_ngcontent-c14']");

	// =================================BroadcastStudent Form
	public static By eventbroadcast = By.xpath("//input[@id='eventBroadcast']");
	public static By studentform = By.xpath(
			"//ul[@style='list-style-type: none;margin-left:-55px;word-wrap: break-word;']//parent::div[@class='box-body']//li//descendant::button[@class='btn  btn-link']");

	//=======================================DeleteCourseOfEvent

	public static By listofsubject = By.xpath("//table[@id='facultyCourseGridFinal']//tr/td[1]");
	public static By listofsubjectdes = By.xpath("//*[@id=\"facultyCourseGridFinal\"]/tbody/tr[1]/td[2]");
	public static By lisfofcomponents = By.xpath("//table[@id='facultyCourseGridFinal']//tr/td[3]");
	public static By deleteoptn = By.xpath("//button[@title='delete']");
	public static By deletealertbox = By.xpath("//h2[contains(text(),'Are you sure to Delete?')]");
	public static By deleteOKbutn = By.xpath("//button[contains(text(),'Yes!')]");
	public static By deletedalert = By.xpath("//div[contains(text(),'Record deleted successfully !!')]");
	public static By deletedalertOK = By.xpath("//button[contains(text(),'OK')]");
	public static By search = By.xpath("//input[@type='search']");
	public static By noresult =By.xpath("//table[@id= 'DataTables_Table_0']//td");
	
	//========================================CreationAndverificationOfTopic
	public static By topicmaster =By.xpath("//span[contains(text(),'Topic Master')]");
	public static By topiccode =By.xpath("//input[@id='topiccode']");
	public static By topicdesc = By.xpath("//input[@id='topicdesc']");
	public static By topicsavebutn= By.xpath("//button[@title='Save']");
	public static By topicconfirmationalert = By.xpath("//h2[contains(text(),'Inserted')]");
	public static By topicOKbutn = By.xpath("//button[contains(text(),'OK')]");
	public static By topicradiobutn = By.xpath("//input[@type='radio' and @id='topic']");
	public static By topicname = By.xpath("//select[@id='topicname']");

	


	/**
	 * =============================================================================
	 * Methods:Eventcodecreation and VerifyEventCode | Author: Haritha | Date:22 Apr
	 * 2020 | Description EventcodeCreation method creates Event Code in Feedback
	 * module and VerifyEventCode method Verifies created event code
	 * =============================================================================
	 * 
	 * @throws InterruptedException
	 **/

	static WebActions webActions = new WebActions();
	static JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();

	public static void Eventcodecreation() throws InterruptedException {

		webActions.Click(feedbackactivity, "Feedback Activity");
		Thread.sleep(2000);
		webActions.Click(feedbackeventmanager, "Feedback Event Manager");
		Thread.sleep(6000);

		webActions.Click(institutecode, "School of Engineering and Applied Sciences");
		webActions.selectByVisibleText(institutecode, "School of Engineering and Applied Sciences");
		Thread.sleep(5000);

		webActions.Click(eventregistrationcode, "1920_EVEN_SEMESTER");
		webActions.selectByVisibleText(eventregistrationcode, "1920_EVEN_SEMESTER");
		Thread.sleep(5000);

		webActions.Click(facultyradiobutn, "faculty radio button");
		Thread.sleep(6000);

		//provide unique event code
		webActions.Click(eventcode, "Event code");
		Thread.sleep(4000);
		webActions.clearAndSendKeys(eventcode, "Event05");
		Thread.sleep(2000);

		//provide unique event description
		webActions.Click(eventdesc, "Event Description");
		Thread.sleep(3000);
		webActions.clearAndSendKeys(eventdesc, "Desc of Event05");
		Thread.sleep(3000);

		webActions.Click(minCGPA, "Min CGPA");
		Thread.sleep(2000);
		webActions.clearAndSendKeys(minCGPA, "5");
		Thread.sleep(2000);

		webActions.Click(minAttendance, "Min Attendance");
		Thread.sleep(3000);
		webActions.clearAndSendKeys(minAttendance, "70");
		Thread.sleep(2000);

		webActions.Click(fromDate, "22-04-2020");
		List<WebElement> allDates = webActions.getListOfWebElements(fromdatelist);

		for (WebElement ele : allDates) {

			String date = ele.getText();

			if (date.equalsIgnoreCase("22")) {
				ele.click();
				break;
			}

		}
		Thread.sleep(3000);
		webActions.Click(todate, "30-04-2020");
		List<WebElement> allToDates = webActions.getListOfWebElements(todatelist);

		for (WebElement ele : allToDates) {

			String date = ele.getText();

			if (date.equalsIgnoreCase("30")) {
				ele.click();
				break;
			}
		}

		webActions.Click(feedbackbox, "Feedback Instructions box");
		Thread.sleep(3000);

		webActions.clearAndSendKeys(feedbackbox, "Automation generated feedback");
		Thread.sleep(4000);

		webActions.Click(selectallsubjectcheckbox, "Checked all options under factuly/course table");
		Thread.sleep(3000);

		Thread.sleep(3000);
		webActions.scrollDown();
		Thread.sleep(4000);

		webActions.Click(questiontemplate, "question template dropdown");
		Thread.sleep(4000);

		webActions.Click(ddfacultyfeedback, "faculty feedback option under dropdown");
		Thread.sleep(3000);

		webActions.Click(Save, "Save Button");
		Thread.sleep(4000);

		String updatepopup = webActions.getText(Updated);
		if (updatepopup.equalsIgnoreCase("Updated")) {
			webActions.Click(UpdateOKbutn, "Update Ok button");
			ReportManager.logInfo("Data updated Successfully - <b style=\"color:green;\">" + updatepopup + "</b>");
			Thread.sleep(2000);

		}

	}

	public static void VerifyEventCode() throws InterruptedException {

		webActions.Click(feedbackactivity, "Feebback Activity");
		Thread.sleep(2000);
		webActions.Click(feedbackeventmanager, "Feebback Event Manager");
		Thread.sleep(4000);

		webActions.Click(institutecode, "School of Engineering and Applied Sciences");
		webActions.selectByVisibleText(institutecode, "School of Engineering and Applied Sciences");
		Thread.sleep(5000);

		webActions.Click(eventregistrationcode, "1920_EVEN_SEMESTER");
		webActions.selectByVisibleText(eventregistrationcode, "1920_EVEN_SEMESTER");
		Thread.sleep(5000);

		webActions.Click(facultyradiobutn, "selection of faculty radio button");
		Thread.sleep(6000);

		webActions.Click(eventcode, "Event code");
		Thread.sleep(4000);

		
		//Change text comparison
		List<WebElement> list = webActions.getListOfWebElements(eventdropdown);
		System.out.println("Total number of search in list" + list.size());

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().contains("Event04")) {
				list.get(i).click();
				System.out.println("Event is present");

				break;
			}
		}

		ReportManager.logInfo("Created Event05 is present in Dropdown<b style=\"color:green;\"</b>");

	}

	/**
	 * =======================================================================================================================
	 * Methods:BroadcastStudentForm and VerifyStudentForm | Author: Haritha | Date:23 Apr 2020 | 
	 * Description BroadcastStudentForm method creates Event Code
	 * in Feedback module with Event Broadcast option and VerifyStudentForm method
	 * Verifies Feedback form for student
	 * =======================================================================================================================
	 * 
	 * @throws InterruptedException
	 **/

	public static void BroadcastStudentForm() throws InterruptedException

	{

		webActions.Click(feedbackactivity, "Feedback Activity");
		Thread.sleep(2000);
		webActions.Click(feedbackeventmanager, "Feedback Event Manager");
		Thread.sleep(7000);

		webActions.Click(institutecode, "School of Engineering and Applied Sciences");
		webActions.selectByVisibleText(institutecode, "School of Engineering and Applied Sciences");
		Thread.sleep(6000);

		webActions.Click(eventregistrationcode, "1920_EVEN_SEMESTER");
		webActions.selectByVisibleText(eventregistrationcode, "1920_EVEN_SEMESTER");
		Thread.sleep(6000);

		webActions.Click(facultyradiobutn, "faculty radio button");
		Thread.sleep(6000);

		//provide unique event code
		webActions.clearAndSendKeys(eventcode, "EventBroadcast04");
		Thread.sleep(3000);
		
		//provide unique event code
		webActions.clearAndSendKeys(eventdesc, "Testing Student Form 04");  
		Thread.sleep(3000);

		webActions.Click(eventbroadcast, "Event Broadcast");
		Thread.sleep(3000);

		webActions.clearAndSendKeys(minCGPA, "5");
		Thread.sleep(3000);

		webActions.clearAndSendKeys(minAttendance, "70");
		Thread.sleep(3000);

		webActions.Click(fromDate, "22-04-2020");
		List<WebElement> allDates = webActions.getListOfWebElements(fromdatelist);

		for (WebElement ele : allDates) {

			String date = ele.getText();

			if (date.equalsIgnoreCase("22")) {
				ele.click();
				break;
			}

		}
		Thread.sleep(3000);
		webActions.Click(todate, "30-04-2020");
		List<WebElement> allToDates = webActions.getListOfWebElements(todatelist);

		for (WebElement ele : allToDates) {

			String date = ele.getText();

			if (date.equalsIgnoreCase("30")) {
				ele.click();
				break;
			}
		}

		webActions.Click(feedbackbox, "Feedback Instructions box");
		Thread.sleep(3000);
		webActions.clearAndSendKeys(feedbackbox, "Automation generated feedback");
		Thread.sleep(4000);

		webActions.Click(selectallsubjectcheckbox, "Checked all options under factuly/course table");
		Thread.sleep(3000);

		webActions.scrollDown();
		Thread.sleep(4000);

		webActions.Click(questiontemplate, "question template dropdown");
		Thread.sleep(4000);

		webActions.Click(ddfacultyfeedback, "faculty feedback option under dropdown");
		Thread.sleep(3000);

		webActions.Click(Save, "Save Button");
		Thread.sleep(4000);

		String updatepopup = webActions.getText(Updated);
		if (updatepopup.equalsIgnoreCase("Updated")) {
			webActions.Click(UpdateOKbutn, "Update Ok button");
			ReportManager.logInfo("Data updated Successfully - <b style=\"color:green;\">" + updatepopup + "</b>");
			Thread.sleep(3000);

		}

	}

	public static void VerifyStudentForm() throws InterruptedException {
		
		// comparison text should be changed for run
		
		List<WebElement> ListOfForms = webActions.getListOfWebElements(studentform);
		System.out.println("Total number Student Forms on Page" + ListOfForms.size());

		for (int i = 0; i < ListOfForms.size(); i++) {
			System.out.println(ListOfForms.get(i).getText());
			if (ListOfForms.get(i).getText().contains("Testing Student Form 04")) {
				ListOfForms.get(i).click();
				System.out.println("Testing Student Form is present");

				break;
			}
		}
		
		ReportManager.logInfo("<b style=\"color:green;\"> ***** Required Student Form is Present *****</b>");
		Thread.sleep(2000);
		
		
	}

	/**
	 * =============================================================================
	 * Methods:DeleteCourseOfEvent | Author: Haritha | Date:23 Apr 2020
	 *Description of this method is to delete as subject from created EveNT
	 * =============================================================================
	 * 
	 * @throws InterruptedException
	 **/

	public static void DeleteCourseOfEvent() throws InterruptedException {

		webActions.Click(feedbackactivity, "Feedback Activity");
		Thread.sleep(2000);
		webActions.Click(feedbackeventmanager, "Feedback Event Manager");
		Thread.sleep(6000);

		webActions.selectByVisibleText(institutecode, "School of Engineering and Applied Sciences");
		Thread.sleep(5000);

		webActions.selectByVisibleText(eventregistrationcode, "1920_EVEN_SEMESTER");
		Thread.sleep(5000);

		webActions.Click(facultyradiobutn, "Faculty Radio Button");
		Thread.sleep(4000);
		
		webActions.Click(eventcode, "Event Code");
		Thread.sleep(2000);
		
		// Comparison event code should be changed
		List<WebElement> list = webActions.getListOfWebElements(eventdropdown);
		System.out.println("Total number of search in list" + list.size());

		for (int i = 0; i < list.size(); i++) 
		{
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().contains("Event03"))
			{
				list.get(i).click();
				System.out.println("Event is present");
				break;
			}
		
		}
		
		Thread.sleep(5000);
		
		webActions.scrollDown();
		
		Thread.sleep(5000);
		
	//Recored details should be mentioned like subject and component for every run
		
		List<WebElement> subjectlist = webActions.getListOfWebElements(listofsubject);
		List<WebElement> subjectdeslist = webActions.getListOfWebElements(listofsubjectdes);

		List<WebElement> componentlist = webActions.getListOfWebElements(lisfofcomponents);
		
		
		for (int i = 0; i < subjectlist.size(); i++) {
			String subject = subjectlist.get(i).getText();
			System.out.println(subject);

			if (subject.equalsIgnoreCase("EBTY103L"))
			{
				String subjectdes =subjectdeslist.get(i).getText();
				if (subjectdes.equalsIgnoreCase("CHEMISTRY OF BIOMOLECULES")) 
				{
					String component = componentlist.get(i).getText();
					if (component.equalsIgnoreCase("T")) 
					{
						webActions.Click(deleteoptn, "Delete");
					}

				
			}
		}
		
		}
		
		
		String ConfirmDeletepopup1 = webActions.getText(deletealertbox);
		webActions.verifyText(ConfirmDeletepopup1, "Are you sure to Delete?");
		webActions.Click(deleteOKbutn, "Yes");
		Thread.sleep(3000);
		
		String ConfirmDeletepopup2 = webActions.getText(deletedalert);
		webActions.verifyText(ConfirmDeletepopup2, "Record deleted successfully !!");
		Thread.sleep(2000);
		webActions.Click(deletedalertOK, "OK");
		Thread.sleep(5000);
		

		
	
		/*jse.executeScript("window.scrollTo(0,document.body.scrollTop)");
		Thread.sleep(4000);
		
		webActions.Click(search, "Search Box");		
		webActions.clearAndSendKeys(search, "CIE101L");
		
		String NoRecords = webActions.getText(noresult);
		webActions.verifyText(NoRecords, "No matching records found");
		if(NoRecords.equalsIgnoreCase("No matching records found"))
		{
			ReportManager.logInfo("<b style=\"color:green;\"> ***** Event Successfully deleted *****</b>");	
		}
		else {
			ReportManager.logInfo("<b style=\"color:red;\"> ***** Event not deleted *****</b>");	
		}*/
		
	}
	
	/**
	 * =============================================================================
	 * Methods:CreationofEventByTopic and verifyCreatedTopic | Author: Haritha | Date:23 April 2020 |
	 * Description Creation of topic and verification of created topic under topic name drop down
	 * =============================================================================
	 * 
	 * @throws InterruptedException
	 **/
	
	public static void CreationofEventByTopic() throws InterruptedException 
	{
		
		webActions.Click(feedbackactivity, "FeedBack Activity");
		Thread.sleep(3000);
		webActions.Click(topicmaster, "Topic Master");
		Thread.sleep(3000);
		
		webActions.Click(institutecode, "School of Engineering and Applied Sciences");
		webActions.selectByVisibleText(institutecode, "School of Engineering and Applied Sciences");
		Thread.sleep(6000);
		
		// unique topic code for Every Run
		webActions.clearAndSendKeys(topiccode, "Topic04");  
		Thread.sleep(2000);
		// unique topic desc for Every Run
		webActions.clearAndSendKeys(topicdesc, "Testing Topic04"); 
		Thread.sleep(3000);
		
		webActions.Click(topicsavebutn, "Save");
		
		
		String topicCreated=webActions.getText(topicconfirmationalert);
		webActions.verifyText(topicCreated, "Inserted");
		webActions.Click(topicOKbutn, "OK");
		Thread.sleep(3000);
		
		ReportManager.logInfo("<b style=\"color:green;\"> ***** Topic Instered Successfully *****</b>");	

	}
		public static void verifyCreatedTopic() throws InterruptedException {
			
			webActions.Click(feedbackactivity, "Feedback Activity");
			Thread.sleep(2000);
			webActions.Click(feedbackeventmanager, "Feedback Event Manager");
			Thread.sleep(6000);

			webActions.selectByVisibleText(institutecode, "School of Engineering and Applied Sciences");
			Thread.sleep(5000);

			webActions.selectByVisibleText(eventregistrationcode, "1920_EVEN_SEMESTER");
			Thread.sleep(5000);

			webActions.Click(topicradiobutn, "Topic Radio Button");
			Thread.sleep(3000);
			
			webActions.Click(topicname, "Topic name Dropdown");
			Thread.sleep(2000);
			
			// select as per topic name creation 
			webActions.selectByVisibleText(topicname, "TOPIC04-TESTING TOPIC03"); 
			Thread.sleep(3000);
			
			//Topic name should be changed in display message
			ReportManager.logInfo("<b style=\"color:green;\"> ***** Topic04 Present in Topicname Dropdown *****</b>");
			Thread.sleep(2000);
			
		}
				
		
	}
		
	