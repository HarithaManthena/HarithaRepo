package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.ExamActivityModule;
import WebPages.LoginPage;

@Listeners({ SuiteEvent.class, WebEvent.class })
public class TC_003_UpdateEvent {

	@Test(description = "Update Event", groups = { "smoke", "regression", "Web Application" })
	public void TC_002_Update_Event() throws InterruptedException {

		LoginPage homePage = new LoginPage();
		
		//*********************To Update any event**************
		homePage.Login(ConfigReader.getValue("examDeanUserName"), ConfigReader.getValue("examDeanPassword"));
		ExamActivityModule.UpdateEvent();
		Thread.sleep(10000);
		homePage.Logout();
	}

}