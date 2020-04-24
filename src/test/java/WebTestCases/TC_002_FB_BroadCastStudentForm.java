package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FeedbackActivityModule;
import WebPages.LoginPage;

@Listeners({ SuiteEvent.class, WebEvent.class })

public class TC_002_FB_BroadCastStudentForm {
	
	@Test(description = "Verifying Student Form by selection EventBroadcast option in Feedback Event Creation and verify it's availablity for student", groups = { "smoke", "regression", "Web Application" })
	public void StudentFromBroadcast() throws InterruptedException {
		LoginPage homePage = new LoginPage();

		
		homePage.Login(ConfigReader.getValue("feedBackUserName"), ConfigReader.getValue("feedBackPassword"));
		FeedbackActivityModule.BroadcastStudentForm();
		Thread.sleep(2000);
		homePage.Logout();
		Thread.sleep(6000);

		homePage.Login(ConfigReader.getValue("studentUsername"), ConfigReader.getValue("studentPassword"));
		FeedbackActivityModule.VerifyStudentForm();
		Thread.sleep(4000);
		homePage.Logout();
		
	}

}
