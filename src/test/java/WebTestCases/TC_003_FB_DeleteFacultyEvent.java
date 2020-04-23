package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FeedbackActivityModule;
import WebPages.LoginPage;

@Listeners({ SuiteEvent.class, WebEvent.class })
public class TC_003_FB_DeleteFacultyEvent {

	@Test(description = "Delete Subject under Facutly/course table for created Event", groups = { "smoke", "regression",
			"Web Application" })
	public static void DeleteSubject() throws InterruptedException {

		LoginPage homePage = new LoginPage();
		homePage.Login(ConfigReader.getValue("feedBackUserName"), ConfigReader.getValue("feedBackPassword"));
		FeedbackActivityModule.DeleteCourseOfEvent();
		Thread.sleep(2000);
		homePage.Logout();

	}

}
