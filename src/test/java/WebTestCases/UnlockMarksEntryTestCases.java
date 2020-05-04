package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.LoginPage;
import WebPages.UnlockMarksEntry;

@Listeners({ SuiteEvent.class, WebEvent.class })

public class UnlockMarksEntryTestCases {

	@Test(description = "Unlock Marks Entry Page Functional TestCases", groups = { "smoke", "regression",
			"Web Application" })

	public void UnlockMarksEntryExe() throws InterruptedException {

		LoginPage homePage = new LoginPage();

		homePage.Login(ConfigReader.getValue("examDeanUserName"), ConfigReader.getValue("examDeanPassword"));
		
//TC_01
//		UnlockMarksEntry.UnlockMarksEntryPageVrftn();
//		Thread.sleep(2000);
//		homePage.Logout();
		
//TC_02
//		UnlockMarksEntry.UMInsitituteDD();
//		Thread.sleep(2000);
//		homePage.Logout();

//TC_03
//		UnlockMarksEntry.UMRegistrationDD();
//		Thread.sleep(2000);
//		homePage.Logout();
	
//TC_04
//		UnlockMarksEntry.UMExamEventCodeDD();
//		Thread.sleep(2000);
//		homePage.Logout();
//TC_05
		UnlockMarksEntry.UMSubjectsDD();
		Thread.sleep(2000);
		
		
		
	}

}
