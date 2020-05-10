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
//		UnlockMarksEntry.UMSubjectsDD();
//		Thread.sleep(2000);
//		homePage.Logout();
//TC_06
//		UnlockMarksEntry.UM_VerifyGetDetailsOptn();
//		Thread.sleep(2000);
//		homePage.Logout();
//TC_07
//		UnlockMarksEntry.UM_GetDetails_Without_ReqFieldSelection();
//		Thread.sleep(2000);
//		homePage.Logout();
//TC_08
//		UnlockMarksEntry.UM_VerifyRestButn();
//		Thread.sleep(2000);
//		homePage.Logout();
//TC_09
//		UnlockMarksEntry.UM_VerifyCancelButn();
//		Thread.sleep(2000);
//		homePage.Logout();

//TC_10
//		UnlockMarksEntry.UM_Verify_GetDetails_TableHeader();
//		Thread.sleep(2000);
//		homePage.Logout();

//TC_11
//		UnlockMarksEntry.UM_Verify_Checkbox_DetailsTable();
//		Thread.sleep(2000);
//		homePage.Logout();

//TC_12
//		UnlockMarksEntry.UM_Save_Without_RowSelection();
//		Thread.sleep(2000);
//		homePage.Logout();
//TC_13 
//		UnlockMarksEntry.UM_EditDates_AfterRwoSelection();
//		Thread.sleep(2000);
//		homePage.Logout();
		
//TC_14 - Doubt - On hold
		
//TC_15
//		UnlockMarksEntry.UM_Lock_LockExamMark();
//		Thread.sleep(2000);
// 		homePage.Logout();
//TC_16 - In progress
		
		UnlockMarksEntry.UM_UnLock_LockExamMark();
		Thread.sleep(2000);
	
	}

}
