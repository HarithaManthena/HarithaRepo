package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FeedbackActivityModule;
import WebPages.LoginPage;

@Listeners({ SuiteEvent.class, WebEvent.class })

public class TC_004_FB_TopicCreationAndVerification {
	

	@Test(description = "Creation of topic under Topic Master and verify created Topic under TopicName dropdown in Feedback Event Maanger", groups = { "smoke", "regression",
			"Web Application" })
	public void TopicCreationAndVerification() throws InterruptedException {
		LoginPage homePage = new LoginPage();

		homePage.Login(ConfigReader.getValue("feedBackUserName"), ConfigReader.getValue("feedBackPassword"));
		Thread.sleep(2000);
		FeedbackActivityModule.CreationofEventByTopic();
		homePage.Logout();
		Thread.sleep(3000);
		
		homePage.Login(ConfigReader.getValue("feedBackUserName"), ConfigReader.getValue("feedBackPassword"));
		Thread.sleep(2000);
		FeedbackActivityModule.verifyCreatedTopic();
		Thread.sleep(2000);
		homePage.Logout();



		

	}

}
