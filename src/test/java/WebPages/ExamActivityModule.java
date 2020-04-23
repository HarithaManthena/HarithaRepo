package WebPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import Utilities.DriverFactory;
import Utilities.ReportManager;
import WebUtil.WebActions;

public class ExamActivityModule {
	
	 // ============ Exam activity
	public static By examActivity = By.xpath("//span[.= 'Exam Activity']");
	public static By examEventMaster = By.xpath("//span[.= 'Exam Event Master']");
	
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
	
	
	
	static WebActions webActions = new WebActions();
	static JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();
	
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
		 * 
		 **/
		public static void CreatedEventVisibleToCoordinator()
		{
			
		}
}
