package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FeedbackActivityModule;
import WebPages.LoginPage;

@Listeners({ SuiteEvent.class, WebEvent.class })

public class TC_005_FB_TemplateCreationAndVerification {

	@Test(description = "Creation of new Template in Feeback Template Master and Verify is it displayed in FeedBack Event Manager Question Template Drop down ", groups = { "smoke", "regression",
			"Web Application" })
	
	public static void TemplateCreationAndVerification() throws InterruptedException {
		
		LoginPage homePage = new LoginPage();
		homePage.Login(ConfigReader.getValue("feedBackUserName"), ConfigReader.getValue("feedBackPassword"));
		FeedbackActivityModule.TemplateCreationVerification();
		Thread.sleep(2000);
		homePage.Logout();
	}
}
