package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.ExamEventMaster;
import WebPages.LoginPage;

@Listeners({ SuiteEvent.class, WebEvent.class })
public class ExamEventMasterTestCases {
	
@Test(description = "Exam Event Master TestCases", groups = { "smoke", "regression", "Web Application" })
public void EEMTestCaseExecution() throws InterruptedException {
		
	
	LoginPage homePage = new LoginPage();

		
	homePage.Login(ConfigReader.getValue("examDeanUserName"), ConfigReader.getValue("examDeanPassword"));
//TC_01	
	/*ExamEventMaster.VerifyExamEventMasterAccess();
	Thread.sleep(2000);	
	homePage.Logout();
	Thread.sleep(3000);
//TC_02	
	ExamEventMaster.VerifyInstituteDD();
	Thread.sleep(20000);
	homePage.Logout();
	Thread.sleep(3000);

//TC_03
	ExamEventMaster.VerifyExamEventTypeDD();
	Thread.sleep(2000);
	homePage.Logout();
	Thread.sleep(3000);
	
//TC_04	
	ExamEventMaster.VerifyActiveCheckbox();
	Thread.sleep(2000);
	homePage.Logout();
	Thread.sleep(3000);
	
//TC_05	
	ExamEventMaster.VerifyDeActiveCheckBox();
	Thread.sleep(2000);
	homePage.Logout();
	Thread.sleep(3000);
	
//TC_06
	ExamEventMaster.VerifySaveWithoutEventType();
	Thread.sleep(2000);
	homePage.Logout();
	Thread.sleep(3000); */

/*TC_07
  ExamEventMaster.VerifyFeilds();
  Thread.sleep(2000);
	

 //TC_08
	ExamEventMaster.VerifySubEventRequiredChecked();
	Thread.sleep(3000);
	homePage.Logout();
	Thread.sleep(3000);
//TC_09
	ExamEventMaster.VerifySubEventRequiredUnchecked();
	Thread.sleep(3000);
	homePage.Logout();
	Thread.sleep(3000);

//tC_10
	ExamEventMaster.VerfiyExamEventCode();
	Thread.sleep(3000);
	homePage.Logout();
	Thread.sleep(3000);
	
	
//TC_11
	ExamEventMaster.VerifySaveWithoutEventCode();
	Thread.sleep(3000);
	homePage.Logout();
	Thread.sleep(3000);
	

//TC_12
	ExamEventMaster.VerifyNumericFieldsValidData();
	Thread.sleep(3000);
	homePage.Logout();
	Thread.sleep(3000);
	
	
//TC_13 ,14,15 In-Progress as not alert is displayed to verify
	ExamEventMaster.VerifyNumericfiedlswithCHARACTERS();
	Thread.sleep(2000);
	homePage.Logout();
	Thread.sleep(3000);
//TC_14	
	ExamEventMaster.VerifyNumericfiedlswithALPHANUMERICS();
	Thread.sleep(2000);
	homePage.Logout();
	Thread.sleep(3000);
//TC_15
	ExamEventMaster.VerifyNumericfiedlswithSPECIALCHARS();
	Thread.sleep(2000);
	homePage.Logout();
	Thread.sleep(3000); 
	
	
//TC_16
	ExamEventMaster.VerifySaveOption();
	Thread.sleep(2000);
	homePage.Logout();
	Thread.sleep(3000);
	
//TC_17
	
	ExamEventMaster.VerifySaveWithBlankData();
	Thread.sleep(2000);
	homePage.Logout();
	Thread.sleep(3000);
	
	
//TC_18
	
	ExamEventMaster.VerifyRestButton();
	Thread.sleep(2000);
	homePage.Logout();
	Thread.sleep(3000);
	*/
//TC_19
	ExamEventMaster.VerifyCancelButton();
	Thread.sleep(2000);
	homePage.Logout();
	Thread.sleep(3000);
		
	
	
	
}
}

	


