package WebPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;

import Utilities.DriverFactory;
import Utilities.ReportManager;
import WebUtil.WebActions;

public class MarksUpload {

	public static By examActivity = By.xpath("//span[.= 'Exam Activity']");
	public static By marksUpload = By.xpath("//span[.= 'Marks Upload']");

	public static By instituteLable = By.xpath("//label[contains(text(),'Institute')]");
	public static By registrationCodeLable = By.xpath("//label[contains(text(),'Registration Code')]");
	public static By subjectCodeLabel = By.xpath("//label[contains(text(),'Subject Code')][1]");
	public static By examEventCodeLabel = By.xpath("//label[contains(text(),'Exam Event Code')][1]");

	public static By institute = By.xpath("//select[@id='instituteid']");

	public static By registrationCode = By.xpath("//select[@id='regcode']");
	public static By subjectCode = By.xpath("//select[@id='subcode']");
	public static By examEventCode = By.xpath("//select[@id='exameventcode']");
	public static By resetButton = By.xpath("//button[@title='Reset']");
	public static By istituteDDText = By.xpath("//option[text()='--Select Institute--']");

	public static By cancelButton = By.xpath("//button[@title='Exit']");
	public static By dashboardText = By.xpath("//h1[text()=' Dashboard ']");

	public static By downlaodTemplate = By.xpath("//button[@title='Click to Download Template']");
	public static By chooseFile = By.xpath("//input[@type='file']");

	// change position as required
	public static By errorCol = By.xpath(" //td[contains(text(),'Invalid Marks Entry')][1]");
	public static By enrollmentNoList = By.xpath("//table/tbody/tr/td[2]");
	public static By errorColList = By.xpath("//table/tbody/tr/td[9]");

	// //*[@id="marksEntryGrid"]/div[2]/table/tbody/tr[1]/td[9]

	static WebActions webActions = new WebActions();
	static JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();

//TC-01
	public static void MarksUploadPageVerftnc() {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(marksUpload, "Marks Upload");

		if (webActions.isDisplayed(institute, "Institute Dropdown")) {

			webActions.isDisplayed(registrationCode, "Registration Code Dropdown");
			webActions.isDisplayed(subjectCode, "Subject Code Dropdown");
			webActions.isDisplayed(examEventCode, "Exam Event Code Dropdown");
			System.out.println("Required Dropdowns are present");
			ReportManager.logInfo("<b style=\"color:green;\"> *****Dropdown Fields Present*****</b>");

		}

		else {
			System.out.println("Required Dropdowns are  not present");

			ReportManager.logInfo("<b style=\"color:red;\"> *****Dropdowns not Present*****</b>");

		}
	}

	// TC_02

	public static void MUVerifyInstituteDD() throws InterruptedException {
		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(marksUpload, "Marks Upload");
		Thread.sleep(2000);

		if (webActions.isDisplayed(institute, "Institute")) {

			webActions.selectByVisibleText(institute, " School of Engineering and Applied Sciences ");
			Thread.sleep(4000);

			ReportManager.logInfo("<b style=\"color:green;\"> *****Institute Name is Selected *****</b>");

		} else {
			ReportManager.logInfo("<b style=\"color:green;\"> *****Institute Name is not Selected *****</b>");

		}

	}

	// TC_03

	public static void MUVerifyRegistrationDD() throws InterruptedException {
		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(marksUpload, "Marks Upload");
		Thread.sleep(2000);

		webActions.selectByVisibleText(institute, " School of Engineering and Applied Sciences ");

		if (webActions.isDisplayed(registrationCode, "Registration Code")) {

			webActions.selectByVisibleText(registrationCode, "1920_EVEN_SEMESTER");
			Thread.sleep(2000);

			ReportManager.logInfo("<b style=\"color:green;\"> *****Registration Code is Selected *****</b>");

		} else {
			ReportManager.logInfo("<b style=\"color:green;\"> *****Registration Code is not Selected *****</b>");
		}

	}
//TC_04

	public static void MUVerifySubjectCodeDD() throws InterruptedException {
		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(marksUpload, "Marks Upload");
		Thread.sleep(2000);

		webActions.selectByVisibleText(institute, " School of Engineering and Applied Sciences ");

		webActions.selectByVisibleText(registrationCode, "1920_EVEN_SEMESTER");
		ReportManager.logInfo("Registration code- <b style=\"color:green;\">\"1920_EVEN_SEMESTER\"</b> ");

		if (webActions.isDisplayed(subjectCode, "Subject Code")) {

			webActions.selectByVisibleText(subjectCode, "EBTY801L ( ADVANCED MOLECULAR BIOLOGY)");
			Thread.sleep(2000);

			ReportManager.logInfo(
					"Subject Code - <b style=\"color:green;\">\"EBTY801L ( ADVANCED MOLECULAR BIOLOGY)\"</b> ");
			ReportManager.logInfo("<b style=\"color:green;\"> *****Subject Code is Selected *****</b>");

		} else {
			ReportManager.logInfo("<b style=\"color:green;\"> *****Subject Code is not Selected *****</b>");
		}

	}
//TC_05

	public static void MUVerifyExamEventCodeDD() throws InterruptedException {
		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(marksUpload, "Marks Upload");
		Thread.sleep(2000);

		webActions.selectByVisibleText(institute, " School of Engineering and Applied Sciences ");

		webActions.selectByVisibleText(registrationCode, "1920_EVEN_SEMESTER");
		ReportManager.logInfo("Registration Code - <b style=\"color:green;\">\"1920_EVEN_SEMESTER\"</b> ");

		webActions.selectByVisibleText(subjectCode, "EBTY801L ( ADVANCED MOLECULAR BIOLOGY)");
		ReportManager
				.logInfo("Subject Code - <b style=\"color:green;\">\"EBTY801L ( ADVANCED MOLECULAR BIOLOGY)\"</b> ");

		if (webActions.isDisplayed(examEventCode, "Exam Event Code")) {

			webActions.selectByVisibleText(examEventCode, " Presentation ( Presentation) ");
			Thread.sleep(4000);

			ReportManager.logInfo("<b style=\"color:green;\"> *****Exam Event code is Selected *****</b>");

		} else {
			ReportManager.logInfo("<b style=\"color:green;\"> *****Exam Event code is not Selected *****</b>");
		}

	}

//TC_06
	public static void MUVerifyRestButton() throws InterruptedException {
		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(marksUpload, "Marks Upload");
		Thread.sleep(2000);

		webActions.selectByVisibleText(institute, " School of Engineering and Applied Sciences ");

		webActions.selectByVisibleText(registrationCode, "1920_EVEN_SEMESTER");
		ReportManager.logInfo("Registration Code - <b style=\"color:green;\">\"1920_EVEN_SEMESTER\"</b> ");

		webActions.selectByVisibleText(subjectCode, "EBTY801L ( ADVANCED MOLECULAR BIOLOGY)");
		ReportManager
				.logInfo("Subject Code - <b style=\"color:green;\">\"EBTY801L ( ADVANCED MOLECULAR BIOLOGY)\"</b> ");

		webActions.selectByVisibleText(examEventCode, " Presentation ( Presentation) ");
		Thread.sleep(5000);
		webActions.Click(resetButton, "Rest Button");

		if (webActions.isDisplayed(istituteDDText, "Select Institute")) {

			ReportManager.logInfo("<b style=\"color:green;\"> *****Fields got reset *****</b>");

		} else {
			ReportManager.logInfo("<b style=\"color:red;\"> *****Fields didn't got reset *****</b>");

		}

	}
//TC_07

	public static void MUVerifyCancelButton() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(marksUpload, "Marks Upload");
		Thread.sleep(2000);

		webActions.selectByVisibleText(institute, " School of Engineering and Applied Sciences ");

		webActions.selectByVisibleText(registrationCode, "1920_EVEN_SEMESTER");
		ReportManager.logInfo("Registration Code - <b style=\"color:green;\">\"1920_EVEN_SEMESTER\"</b> ");

		webActions.selectByVisibleText(subjectCode, "EBTY801L ( ADVANCED MOLECULAR BIOLOGY)");
		ReportManager
				.logInfo("Subject Code - <b style=\"color:green;\">\"EBTY801L ( ADVANCED MOLECULAR BIOLOGY)\"</b> ");

		webActions.selectByVisibleText(examEventCode, " Presentation ( Presentation) ");
		Thread.sleep(5000);

		webActions.Click(cancelButton, "Cancel");

		String Dashboard = webActions.getText(dashboardText);
		if (Dashboard.equalsIgnoreCase("Dashboard")) {

			ReportManager.logInfo(
					"<b style=\"color:green;\"> *********Marks Upload page cancelled and returned to Dashboard page********</b>");

		} else {
			ReportManager.logInfo("<b style=\"color:red;\"> *********Cancel Button not working********</b>");

		}
	}

//TC_08

	public static void MUDownloadTemplateOptn() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(marksUpload, "Marks Upload");
		Thread.sleep(2000);

		webActions.selectByVisibleText(institute, " School of Engineering and Applied Sciences ");

		webActions.selectByVisibleText(registrationCode, "1920_EVEN_SEMESTER");
		ReportManager.logInfo("Registration Code - <b style=\"color:green;\">\"1920_EVEN_SEMESTER\"</b> ");

		webActions.selectByVisibleText(subjectCode, "EBTY801L ( ADVANCED MOLECULAR BIOLOGY)");
		ReportManager
				.logInfo("Subject Code - <b style=\"color:green;\">\"EBTY801L ( ADVANCED MOLECULAR BIOLOGY)\"</b> ");

		webActions.selectByVisibleText(examEventCode, " Presentation ( Presentation) ");
		Thread.sleep(5000);

		String DownloadTemplate = webActions.getText(downlaodTemplate);
		if (DownloadTemplate.contains("Download Template")) {

			ReportManager
					.logInfo("<b style=\"color:green;\"> *********Download Template option is present********</b>");

		} else {
			ReportManager
					.logInfo("<b style=\"color:red;\"> *********Download Template option is not present********</b>");

		}
	}

//TC_09

	public static void MU_isTemplateDownloaded() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(marksUpload, "Marks Upload");
		Thread.sleep(2000);

		webActions.selectByVisibleText(institute, " School of Engineering and Applied Sciences ");

		webActions.selectByVisibleText(registrationCode, "1920_EVEN_SEMESTER");
		ReportManager.logInfo("Registration Code - <b style=\"color:green;\">\"1920_EVEN_SEMESTER\"</b> ");

		webActions.selectByVisibleText(subjectCode, "EBTY801L ( ADVANCED MOLECULAR BIOLOGY)");
		ReportManager
				.logInfo("Subject Code - <b style=\"color:green;\">\"EBTY801L ( ADVANCED MOLECULAR BIOLOGY)\"</b> ");

		webActions.selectByVisibleText(examEventCode, " Presentation ( Presentation) ");
		Thread.sleep(5000);

		webActions.Click(downlaodTemplate, "Download link");
		Thread.sleep(6000);

//Need to know Xls file name: [ ExamEventCode_SubjectCode = FileName]

		File fileLocation = new File("C:/Users/LENOVO/Downloads");
		File[] totalfiles = fileLocation.listFiles();

		for (File file : totalfiles) {
			if (file.getName().equals("Presentation_EBTY801L.xls")) {
				System.out.println("File is downloaded");
				ReportManager.logInfo("<b style=\"color:green;\"> *********File is present in downloads********</b>");
				break;
			} else {

				ReportManager.logInfo("<b style=\"color:red;\"> *********File is not present in downloads********</b>");
			}
		}

	}
//TC_10

	public static void MU_VerifyIsExcelFileDownloaded() throws InterruptedException {
		File f1 = null;
		String path = "";
		boolean bool = false;

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(marksUpload, "Marks Upload");
		Thread.sleep(2000);

		webActions.selectByVisibleText(institute, " School of Engineering and Applied Sciences ");

		webActions.selectByVisibleText(registrationCode, "1920_EVEN_SEMESTER");
		ReportManager.logInfo("Registration Code - <b style=\"color:green;\">\"1920_EVEN_SEMESTER\"</b> ");

		webActions.selectByVisibleText(subjectCode, "EBTY801L ( ADVANCED MOLECULAR BIOLOGY)");
		ReportManager
				.logInfo("Subject Code - <b style=\"color:green;\">\"EBTY801L ( ADVANCED MOLECULAR BIOLOGY)\"</b> ");

		webActions.selectByVisibleText(examEventCode, " Presentation ( Presentation) ");
		Thread.sleep(5000);

		webActions.Click(downlaodTemplate, "Download link");
		Thread.sleep(6000);

//Need to know Xls file name: [ ExamEventCode_SubjectCode = FileName]

		File fileLocation = new File("C:/Users/LENOVO/Downloads");
		File[] totalfiles = fileLocation.listFiles();

		for (File file : totalfiles) {
			if (file.getName().equals("Presentation_EBTY801L.xls")) {
				System.out.println("File is downloaded");

				f1 = file.getAbsoluteFile();
				bool = file.exists();
				path = file.getAbsolutePath();
				if (path.contains(".xls")) {
					System.out.print(path + "Exists" + bool);
					ReportManager
							.logInfo("<b style=\"color:green;\"> *********Excel File exists- " + path + "********</b>");
					break;
				}
			}
		}
	}

//TC_11

	public static void MU_UploadMarksSheetWithInvalidData() throws InterruptedException, AWTException {

		webActions.Click(examActivity, "Exam Activity");
		Thread.sleep(2000);
		webActions.Click(marksUpload, "Marks Upload");
		Thread.sleep(2000);

		webActions.selectByVisibleText(institute, " School of Engineering and Applied Sciences ");

		webActions.selectByVisibleText(registrationCode, "1920_EVEN_SEMESTER");
		ReportManager.logInfo("Registration Code - <b style=\"color:green;\">\"1920_EVEN_SEMESTER\"</b> ");

		webActions.selectByVisibleText(subjectCode, "EBTY801L ( ADVANCED MOLECULAR BIOLOGY)");
		ReportManager
				.logInfo("Subject Code - <b style=\"color:green;\">\"EBTY801L ( ADVANCED MOLECULAR BIOLOGY)\"</b> ");

		webActions.selectByVisibleText(examEventCode, " Presentation ( Presentation) ");
		Thread.sleep(5000);

		WebElement upload = DriverFactory.getInstance().getWebDriver().findElement(chooseFile);
		upload.sendKeys("c:/Users/LENOVO/downloads/Presentation_EBTY801L.xls");

		Thread.sleep(8000);

		String Str_err = webActions.getText(errorCol);
		if (Str_err.contains("Invalid Marks Entry")) {

			ReportManager.logInfo("<b style=\"color:red;\">****Invalid Marks Entry-Error ****</b>");

		} else {
			ReportManager.logInfo("<b style=\"color:red;\"> *********No error message********</b>");

		}

//Using Robot class
//		String file = "c:/Users/LENOVO/downloads/Presentation_EBTY801L.xls";
//		StringSelection selection = new StringSelection(file);
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null); 
//		
//		Robot robot = new Robot();
//		
//	    robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_V);
//		robot.keyRelease(KeyEvent.VK_V);
//	    robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//		System.out.println("File Got Uploaded");
//		ReportManager
//		.logInfo("Subject Code - <b style=\"color:green;\">\"File Got Uploaded\"</b> ");

	}

//TC_12: Inprogress what type of error message should be shown exactly

	public static void MU_UploadSheet_BranchAndPrgrm_With_INVALID_Data() throws InterruptedException {
		webActions.Click(examActivity, "Exam Activity");
		Thread.sleep(2000);
		webActions.Click(marksUpload, "Marks Upload");
		Thread.sleep(2000);

		webActions.selectByVisibleText(institute, " School of Engineering and Applied Sciences ");

		webActions.selectByVisibleText(registrationCode, "1920_EVEN_SEMESTER");
		ReportManager.logInfo("Registration Code - <b style=\"color:green;\">\"1920_EVEN_SEMESTER\"</b> ");

		webActions.selectByVisibleText(subjectCode, "EBTY801L ( ADVANCED MOLECULAR BIOLOGY)");
		ReportManager
				.logInfo("Subject Code - <b style=\"color:green;\">\"EBTY801L ( ADVANCED MOLECULAR BIOLOGY)\"</b> ");

		webActions.selectByVisibleText(examEventCode, " Presentation ( Presentation) ");
		Thread.sleep(5000);

		WebElement upload = DriverFactory.getInstance().getWebDriver().findElement(chooseFile);
		upload.sendKeys("c:/Users/LENOVO/downloads/Presentation_EBTY801L.xls");

		Thread.sleep(8000);

		String Str_err = webActions.getText(errorCol);
		if (Str_err.contains("Invalid Marks Entry")) {

			ReportManager.logInfo("<b style=\"color:red;\">****Error: Invalid Marks Entry****</b>");

		} else {
			ReportManager.logInfo("<b style=\"color:red;\"> *********No error message********</b>");

		}

	}

//TC_13
	public static void MU_UploadSheet_MarksCol_With_INVALID_Data() throws InterruptedException {
		webActions.Click(examActivity, "Exam Activity");
		Thread.sleep(2000);
		webActions.Click(marksUpload, "Marks Upload");
		Thread.sleep(2000);

		webActions.selectByVisibleText(institute, " School of Engineering and Applied Sciences ");

		webActions.selectByVisibleText(registrationCode, "1920_EVEN_SEMESTER");
		ReportManager.logInfo("Registration Code - <b style=\"color:green;\">\"1920_EVEN_SEMESTER\"</b> ");

		webActions.selectByVisibleText(subjectCode, "EBTY801L ( ADVANCED MOLECULAR BIOLOGY)");
		ReportManager
				.logInfo("Subject Code - <b style=\"color:green;\">\"EBTY801L ( ADVANCED MOLECULAR BIOLOGY)\"</b> ");

		webActions.selectByVisibleText(examEventCode, " Presentation ( Presentation) ");
		Thread.sleep(5000);

		WebElement upload = DriverFactory.getInstance().getWebDriver().findElement(chooseFile);
		upload.sendKeys("c:/Users/LENOVO/downloads/Presentation_EBTY801L.xls");
		Thread.sleep(8000);


		String expected = "#dd4b39";
		WebElement field =	DriverFactory.getInstance().getWebDriver().findElement(By.xpath("//table/tbody/tr[1]/td[9]"));
		String Bcolor = field.getCssValue("background-color");
		System.out.println("color "+Bcolor);
		
		String hexcolor	= Color.fromString(Bcolor).asHex();
		System.out.println("hexcolor "+hexcolor);
		String actual = hexcolor;
		Assert.assertEquals(actual, expected);
		System.out.println("Background color is red");
		
//		String color = DriverFactory.getInstance().getWebDriver().findElement(By.xpath("//table/tbody/tr[1]/td[9]")).getCssValue("color");
//		System.out.println("Color: "+color);
		
//		
//		String Bcolor = DriverFactory.getInstance().getWebDriver().findElement(By.xpath("//table/tbody/tr[1]/td[9]")).getCssValue("Background-color");
//		System.out.println("BColor: "+Bcolor);
		
//		String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");
//
//		int hexValue1 = Integer.parseInt(hexValue[0]);
//		System.out.println(hexValue1);
//		hexValue[1] = hexValue[1].trim();
//		int hexValue2 = Integer.parseInt(hexValue[1]);
//		System.out.println(hexValue2);
//		hexValue[2] = hexValue[2].trim();
//		int hexValue3 = Integer.parseInt(hexValue[2]);
//		System.out.println(hexValue3);
//
//
//		String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
//		System.out.println(actualColor);
//
//		Assert.assertEquals("#255dc1", actualColor);
//
//	
		//Color: rgba(255, 255, 255, 1)

	
	
	
	
	
		
	}

}
