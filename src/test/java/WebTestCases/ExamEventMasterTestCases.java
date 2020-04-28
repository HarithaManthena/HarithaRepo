package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.ExamEventMaster;
import WebPages.LoginPage;

@Listeners({ SuiteEvent.class, WebEvent.class })
public class ExamEventMasterTestCases {
	
@Test(description = "Exam Event Master TestCases", groups = { "smoke", "regression", "Web Application" })
public void EEMTestCaseExecution() throws InterruptedException {
		
	
	LoginPage homePage = new LoginPage();

		
	homePage.Login(ConfigReader.getValue("examDeanUserName"), ConfigReader.getValue("examDeanPassword"));
	
	/*ExamEventMaster.VerifyExamEventMasterAccess();
	Thread.sleep(2000);	
	homePage.Logout();
	Thread.sleep(3000);
	
	ExamEventMaster.VerifyInstituteDD();
	Thread.sleep(20000);
	homePage.Logout();
	Thread.sleep(3000);

	
	
	ExamEventMaster.VerifyExamEventTypeDD();
	Thread.sleep(2000);
	homePage.Logout();
	Thread.sleep(3000);
	
	ExamEventMaster.VerifyActiveCheckbox();
	Thread.sleep(2000);
	homePage.Logout();
	Thread.sleep(3000);*/
	
	ExamEventMaster.VerifyDeActiveCheckBox();
	Thread.sleep(2000);
	homePage.Logout();
	Thread.sleep(3000);
	
	
	
	}

	

}
