package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.LoginPage;

@Listeners({ SuiteEvent.class, WebEvent.class })
public class TC_001_VerifyLogin {
	

	@Test(description = "Verify Login functionality for all users", groups = { "smoke", "regression", "Web Application" })
	public void TC_001_Verify_Login() throws InterruptedException {

		LoginPage homePage = new LoginPage();
		
		//=================Login with Dean Credentials
		homePage.Login(ConfigReader.getValue("examDeanUserName"), ConfigReader.getValue("examDeanPassword"));
		homePage.Logout();
		Thread.sleep(4000);
		
		//=================Login with Coordinator Credentials
		homePage.Login(ConfigReader.getValue("coordinatorUserName"), ConfigReader.getValue("coordinatorPassword"));
		homePage.Logout();
		Thread.sleep(4000);
				
		//=================Login with Faculty Credentials
		homePage.Login(ConfigReader.getValue("facultyUserName"), ConfigReader.getValue("facultyPassword"));
		homePage.Logout();
	}

}