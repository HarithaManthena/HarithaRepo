package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.ExamActivityModule;
import WebPages.LoginPage;

@Listeners({ SuiteEvent.class, WebEvent.class })
public class TC_005_CreatedEventIsVisibleToCoordinator {

	@Test(description = "Created Event created by Dean should be visible to Coordinator", groups = { "smoke", "regression", "Web Application" })
	public void TC_002_Created_Event_visible_to_Coordinator() throws InterruptedException {

		LoginPage homePage = new LoginPage();
		
		//*********************To Delete any event**************
		homePage.Login(ConfigReader.getValue("coordinatorUserName"), ConfigReader.getValue("coordinatorPassword"));
		ExamActivityModule.CreatedEventVisibleToCoordinator();
		Thread.sleep(10000);
		homePage.Logout();

	}

}