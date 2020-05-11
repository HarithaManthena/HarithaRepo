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
//		MarksUpload.MU_VerifyIsExcelFileDownloaded();
//			Thread.sleep(2000);
//		homePage.Logout();
			
//TC_11
//			MarksUpload.MU_UploadSheet_MarksCol_InvalidData_CHARS();
//			Thread.sleep(2000);
//			homePage.Logout();
//TC_12
			//On hold
			
//TC_13 
//			MarksUpload.MU_UploadSheet_MarksCol_INVALIDMarks();
//			Thread.sleep(2000);
//			homePage.Logout();
//			
//TC_14
//			MarksUpload.MU_saveExcel_with_NOERRORS();
//			Thread.sleep(2000);
//			homePage.Logout();
//TC_15
//			MarksUpload.MU_Save_File_OtherThanEXcelFormat();
//			Thread.sleep(2000);
//			homePage.Logout();
			
//TC_16 : ON HOLD
			
//TC_17
//			MarksUpload.MU_Verify_DownloadErrorList_Optn();
//			Thread.sleep(2000);
//			homePage.Logout();
//TC_18
//			MarksUpload.MU_Lock_UploadedMarks();
//			Thread.sleep(2000);
//			homePage.Logout();
//TC_19
//			MarksUpload.MU_Lock_Without_MarksSheet();
//			Thread.sleep(2000);
//			homePage.Logout();
//TC_20
			MarksUpload.MU_Verify_ExcelReports_Optn();
			Thread.sleep(2000);
			
			
			
			
			
		}

	}
}