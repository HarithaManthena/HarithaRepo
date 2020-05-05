package WebTestCases;

import java.awt.AWTException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.LoginPage;
import WebPages.MarksUpload;

public class MarksUploadTestCases {

	@Listeners({ SuiteEvent.class, WebEvent.class })
	public class MarksUploadTestcases {

		@Test(description = "MarksUpload Functional Testcases", groups = { "smoke", "regression", "Web Application" })
		public void MarksUploadTCExecution() throws InterruptedException, AWTException {

			LoginPage homePage = new LoginPage();

			homePage.Login(ConfigReader.getValue("facultyUserName"), ConfigReader.getValue("facultyPassword"));
//TC_01
		
//			MarksUpload.MarksUploadPageVerftnc();
//			Thread.sleep(2000);
//			homePage.Logout();
			
			
//TC_02
//			MarksUpload.MUVerifyInstituteDD();
//			Thread.sleep(2000);
//			homePage.Logout();

//TC_03
//			MarksUpload.MUVerifyRegistrationDD();
//			Thread.sleep(2000);
//			homePage.Logout();
//TC_04
//			MarksUpload.MUVerifySubjectCodeDD();
//			Thread.sleep(2000);
//			homePage.Logout();
			
//TC_05
//			MarksUpload.MUVerifyExamEventCodeDD();
//			Thread.sleep(2000);
//			homePage.Logout();
			
//TC-06
//			MarksUpload.MUVerifyRestButton();
//			Thread.sleep(2000);
//			homePage.Logout();
//TC_07
//			MarksUpload.MUVerifyCancelButton();
//			Thread.sleep(2000);
//			homePage.Logout();
//TC_08
			
//			MarksUpload.MUDownloadTemplateOptn();
//			Thread.sleep(2000);	
//			homePage.Logout();
//	TC_09
//			MarksUpload.MU_isTemplateDownloaded();
//			Thread.sleep(2000);
//			homePage.Logout();
//TC_10
//			MarksUpload.MU_VerifyIsExcelFileDownloaded();
//			Thread.sleep(2000);
//			homePage.Logout();
			
//TC_11
//			MarksUpload.MU_UploadMarksSheetWithInvalidData();
//			Thread.sleep(2000);
//			homePage.Logout();
//TC_12
			//On hold
			
//TC_13
			MarksUpload.MU_UploadSheet_MarksCol_With_INVALID_Data();
			Thread.sleep(2000);
			
		}

	}
}