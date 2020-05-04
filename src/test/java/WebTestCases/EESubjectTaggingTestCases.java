package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.ExamEventSubjectTagging;
import WebPages.LoginPage;

@Listeners({ SuiteEvent.class, WebEvent.class })
public class EESubjectTaggingTestCases {
	@Test(description = "Exam Event Subject Tagging Functional TestCases", groups = { "smoke", "regression", "Web Application" })
	
	public void EESubjectTagging() throws InterruptedException {
		

		LoginPage homePage = new LoginPage();
		homePage.Login(ConfigReader.getValue("coordinatorUserName"), ConfigReader.getValue("coordinatorPassword"));
//TC_001
		
	/*	ExamEventSubjectTagging.EESubjectTaggingAccess();
		Thread.sleep(2000);
		homePage.Logout();
		Thread.sleep(2000);
//TC_002
		ExamEventSubjectTagging.STInstitutedd();
		Thread.sleep(2000);
		homePage.Logout();
		Thread.sleep(2000);
		
		
		
//TC_003
		ExamEventSubjectTagging.STRegistrationdd();
		Thread.sleep(2000);
		homePage.Logout();
		Thread.sleep(2000);
		}
		
		
//TC_04
	ExamEventSubjectTagging.STSubjectCodedd();
	Thread.sleep(2000);
	homePage.Logout();
	Thread.sleep(2000);
	

//TC_05
		ExamEventSubjectTagging.STSaveWithoutInstitute();
		Thread.sleep(2000);
		homePage.Logout();
		Thread.sleep(2000);
		
	
		
//TC_06
		ExamEventSubjectTagging.STPresenceOfEETable();
		Thread.sleep(2000);		
		homePage.Logout();
		Thread.sleep(2000);
		
	
		
//TC_07 and 08 are in progress
		ExamEventSubjectTagging.STWeightageWithValidData();
		Thread.sleep(2000);
		homePage.Logout();
		Thread.sleep(2000);
		
		
//TC_08
		
		ExamEventSubjectTagging.STWeightageWithINVALIDDATA();
		Thread.sleep(2000);
		homePage.Logout();
		Thread.sleep(2000);
		
		
		
		
		
//TC_09
		ExamEventSubjectTagging.STVerifyPresenceOfTagCordinator();
		Thread.sleep(2000);
		homePage.Logout();
		Thread.sleep(2000);
		
//TC_10
		ExamEventSubjectTagging.STSaveWithoutTag();
		Thread.sleep(2000);
		homePage.Logout();
		Thread.sleep(2000);
		*/
		
//TC_11 
		ExamEventSubjectTagging.STVerifyPassingMarksWithZero();
		Thread.sleep(2000);
		homePage.Logout();
		Thread.sleep(2000);
		
		/*
		
//TC_12
		ExamEventSubjectTagging.STVerifyTagCoordinatorDetails();
		Thread.sleep(2000);
		homePage.Logout();
		Thread.sleep(2000);
		
		
//TC_13		
		ExamEventSubjectTagging.STFacultyAndBatchDD();
		Thread.sleep(2000);
		homePage.Logout();
		Thread.sleep(2000);
	
//TC_14
		ExamEventSubjectTagging.STVerifyMarksOption();
		Thread.sleep(2000);
		homePage.Logout();
		Thread.sleep(2000);
		
		
//TC_15
		ExamEventSubjectTagging.STVerifyGaradEntryOption();
		Thread.sleep(2000);
		homePage.Logout();
		Thread.sleep(2000);
		
//TC_16
		ExamEventSubjectTagging.STSaveWithoutMarksAndGrade();
		Thread.sleep(2000);
		homePage.Logout();
		Thread.sleep(2000);
		
//TC_17
		ExamEventSubjectTagging.STSaveWithAllDetails();
		Thread.sleep(2000);
		homePage.Logout();
		Thread.sleep(2000);
		

//TC_18
		ExamEventSubjectTagging.STAddWithoutFaculty();
		Thread.sleep(2000);
		homePage.Logout();
		Thread.sleep(2000);
		*/
		
		
		
}
}
