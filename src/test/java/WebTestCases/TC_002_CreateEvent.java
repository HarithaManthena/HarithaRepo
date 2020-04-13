package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.HomePage;

@Listeners({ SuiteEvent.class, WebEvent.class })
public class TC_002_CreateEvent {

	@Test(description = "Create Event", groups = { "smoke", "regression", "Web Application" })
	public void TC_002_Create_Event() throws InterruptedException {

		HomePage homePage = new HomePage();
		homePage.Login(ConfigReader.getValue("examDeanUserName"), ConfigReader.getValue("examDeanPassword"));
		homePage.Logout();

	}

}