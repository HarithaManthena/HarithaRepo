package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FeedbackActivityModule;
import WebPages.LoginPage;

@Listeners({ SuiteEvent.class, WebEvent.class })

public class TC_001_FB_EventCreation {

	@Test(description = "FeedBack Event Code creation", groups = { "smoke", "regression", "Web Application" })
	public void EventCodeCreation() throws Exception {

		LoginPage homePage = new LoginPage();

		// *********************To Create any event**************

		homePage.Login(ConfigReader.getValue("feedBackUserName"), ConfigReader.getValue("feedBackPassword"));
		FeedbackActivityModule.Eventcodecreation();
		Thread.sleep(2000);
		homePage.Logout();
		Thread.sleep(3000);

		homePage.Login(ConfigReader.getValue("feedBackUserName"), ConfigReader.getValue("feedBackPassword"));
		FeedbackActivityModule.VerifyEventCode();
		Thread.sleep(3000);
		homePage.Logout();


	}

}
