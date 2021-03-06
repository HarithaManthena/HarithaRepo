package WebPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
	public static By instituteDDText = By.xpath("//option[text()='--Select Institute--']");

	public static By cancelButton = By.xpath("//button[@title='Exit']");
	public static By dashboardText = By.xpath("//h1[text()=' Dashboard ']");

	public static By downlaodTemplate = By.xpath("//button[@title='Click to Download Template']");
	public static By chooseFile = By.xpath("//input[@type='file']");

	// change position as required
	public static By errorCol = By.xpath(" //td[contains(text(),'Invalid Marks Entry')][1]");
	public static By enrollmentNoList = By.xpath("//table/tbody/tr/td[2]");
	public static By errorColList = By.xpath("//table/tbody/tr/td[9]");

	public static By saveMarks = By.xpath("//button[@title = 'Save Marks']");
	public static By marksSaved = By.xpath("//div[text() = 'Marks saved successfully !!!']");
	public static By OKButn = By.xpath("//button[text()='OK']");

	public static By incorrectFileUpload_Msg = By.xpath("//div[text()='Please upload only excel file. !!!']");
	public static By downloadErrorList = By.xpath("//button[@title='Click to Download Error List']");
	public static By lockStatus = By
			.xpath("//div[@class='form-group']/label[.= 'Lock Status :']/following-sibling::label");
	public static By lockCheckBox = By.xpath("//input[@name='deactive']");
	public static By lockConfirmation_Msg = By
			.xpath("//div[text()='Please save your entry.Once you locked, you are no longer able to edit.']");
	public static By lock_Cnfrm_YES = By.xpath("//button[text()='Yes!']");
	public static By entry_Locked = By.xpath("//div[text()='Entry locked successfully !!!']");
	public static By unableToLock = By
			.xpath("//div[text()='Entry can not be locked, because total student marks not entered. !!']");
	public static By excelReport = By.xpath("//button[@title='Excel Report']");

	public static By printMarksSheet = By.xpath("//button[@title='Print Marks Sheet']");

	static WebActions webActions = new WebActions();
	static JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();

	private static Workbook wb;
	private static Sheet sh;
	private static FileInputStream fis;
	private static FileOutputStream fos;
	private static Row row;
	private static Cell cell;
 public  static   String userName = System.getProperty("user.name");

//TC-01
	public static void MarksUploadPageVerftnc() throws InterruptedException {

		webActions.Click(examActivity, "Exam Activity");
		webActions.Click(marksUpload, "Marks Upload");

		if (webActions.isDisplayed(institute, "Institute Dropdown")) {

			webActions.isDisplayed(registrationCode, "Registration Code Dropdown");
			webActions.isDisplayed(subjectCode, "Subject Code Dropdown");
			webActions.isDisplayed(examEventCode, "Exam Event Code Dropdown");
			System.out.println("Required Dropdowns are present");
			
			System.out.println("Dropdown fields present on page");
			
			System.out.println("*****Verified Marks Entry Page:is displayed*****");
			ReportManager.logInfo("<b style=\"color:blue;\">*****Verified Marks Entry Page:is displayed*****</b>");
			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(3000);
		}

		else {
			System.out.println("Marks Upload page not displayed with required fields");
			ReportManager.logInfo("<b style=\"color:red;\">Marks Upload page not displayed with required fields</b>");

		}
	}

	// TC_02

	public static void MUVerifyInstituteDD() throws InterruptedException {
		//webActions.Click(examActivity, "Exam Activity");
		webActions.Click(marksUpload, "Marks Upload");
		Thread.sleep(2000);

		if (webActions.isDisplayed(institute, "Institute")) {

			webActions.selectByVisibleText(institute, " School of Engineering and Applied Sciences ");
			Thread.sleep(4000);

			System.out.println("*****Veified Institute Dropdown:School of Engineering and Applied Sciences is Selected*****");
			ReportManager.logInfo("<b style=\"color:blue;\">*****Veified Institute Dropdown:School of Engineering and Applied Sciences is Selected*****</b>");
			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(3000);
		} 
		
		else {
			System.out.println("Institute Name is not selectable");
			ReportManager.logInfo("<b style=\"color:red;\">Institute Name is not selectable</b>");
			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(2000);
		}

	}

	// TC_03

	public static void MUVerifyRegistrationDD() throws InterruptedException {
		//webActions.Click(examActivity, "Exam Activity");
		webActions.Click(marksUpload, "Marks Upload");
		Thread.sleep(2000);

		webActions.selectByVisibleText(institute, " School of Engineering and Applied Sciences ");

		if (webActions.isDisplayed(registrationCode, "Registration Code")) {

			webActions.selectByVisibleText(registrationCode, "1920_EVEN_SEMESTER");
			Thread.sleep(2000);

			System.out.println("*****Verified Registration Code Dropdown:is selectable*****");
			ReportManager.logInfo("<b style=\"color:blue;\">*****Verified Registration Code Dropdown:is selectable*****</b>");
			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(3000);

		}
		else {
			System.out.println("Registration Code is not selectable");
			ReportManager.logInfo("<b style=\"color:red;\">Registration Code is not selectable</b>");
			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(2000);
		}

	}
//TC_04

	public static void MUVerifySubjectCodeDD() throws InterruptedException {
	//	webActions.Click(examActivity, "Exam Activity");
		webActions.Click(marksUpload, "Marks Upload");
		Thread.sleep(2000);

		webActions.selectByVisibleText(institute, " School of Engineering and Applied Sciences ");

		webActions.selectByVisibleText(registrationCode, "1920_EVEN_SEMESTER");
		ReportManager.logInfo("Registration code- <b style=\"color:green;\">\"1920_EVEN_SEMESTER\"</b> ");

		if (webActions.isDisplayed(subjectCode, "Subject Code")) {

			webActions.selectByVisibleText(subjectCode, "EBTY801L ( ADVANCED MOLECULAR BIOLOGY)");
			Thread.sleep(2000);

			System.out.println("*****Verified Subject Code Dropdown: is Selectable*****");
			ReportManager.logInfo("<b style=\"color:blue;\">*****Verified Subject Code Dropdown: is Selectable*****</b>");
			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(3000);


		} else
		
		{
			System.out.println("Subject is not Selected from dropdown");
			ReportManager.logInfo("<b style=\"color:red;\">Subject is not Selected from dropdown</b>");
			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(2000);		
			}

	}
//TC_05

	public static void MUVerifyExamEventCodeDD() throws InterruptedException {
		//webActions.Click(examActivity, "Exam Activity");
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

			System.out.println("*****Verified Exam Event code Dropdown :  is selectable*****");
			ReportManager.logInfo("<b style=\"color:blue;\">*****Verified Exam Event code Dropdown : is selectable*****</b>");
			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(3000);

		} else {

			System.out.println("Exam Event code is not selectable");
			ReportManager.logInfo("<b style=\"color:red;\">Exam Event code is not selectable</b>");
			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(2000);
		}

	}

//TC_06
	public static void MUVerifyRestButton() throws InterruptedException {
	//	webActions.Click(examActivity, "Exam Activity");
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

		if (webActions.isDisplayed(instituteDDText, "Select Institute")) {

			System.out.println("*****Verified Rest Button: Fields got reset*****");
			ReportManager.logInfo("<b style=\"color:blue;\">*****Verified Rest Button: Fields got reset*****</b>");
			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(2000);

		} else {
			System.out.println("Fields didn't got reset");
			ReportManager.logInfo("<b style=\"color:red;\">Fields didn't got reset</b>");
			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(2000);


		}

	}
//TC_07

	public static void MUVerifyCancelButton() throws InterruptedException {

		//webActions.Click(examActivity, "Exam Activity");
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

			System.out.println(
					"*****Verified Cancel Button:Marks Upload page cancelled and returned to Dashboard page*****");
			ReportManager.logInfo(
					"<b style=\"color:blue;\">*****Verified Cancel Button:Marks Upload page cancelled and returned to Dashboard page*****</b>");
			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(2000);

		} else {


			System.out.println("Cancel Button funtionality not working");

			ReportManager.logInfo("<b style=\"color:red;\">Cancel Button funtionality not working</b>");
			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(2000);
			
		}
	}

//TC_08

	public static void MUDownloadTemplateOptn() throws InterruptedException {

	//	webActions.Click(examActivity, "Exam Activity");
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

			System.out.println("*****Download Template option is present*****");
			ReportManager.logInfo("<b style=\"color:blue;\">*****Download Template option is present*****</b>");
			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(2000);

		} else {
			
			System.out.println("Download Template option not displayed");
			ReportManager.logInfo("<b style=\"color:red;\">Download Template option not displayed</b>");
			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(2000);
			
		}
	}

	//TC_09

			public static void MU_isTemplateDownloaded() throws InterruptedException {

	//			webActions.Click(examActivity, "Exam Activity");
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

				
				File fileLocation = new File("C:/Users/"+userName+"/Downloads");
				File[] totalfiles = fileLocation.listFiles();

				for (File file : totalfiles) {
					Thread.sleep(3000);

					if (file.getName().equals("Presentation_EBTY801L.xls")) {
						System.out.println("File is downloaded");
						
						System.out.println("*****Download Template:File present in downloads*****");
						ReportManager.logInfo("<b style=\"color:blue;\">*****Download Template:File present in downloads*****</b>");
						DriverFactory.getInstance().getWebDriver().navigate().refresh();
						Thread.sleep(2000);
						}
						else {
							System.out.println("Download Template:File not present in downloads");
							ReportManager.logInfo("<b style=\"color:red;\">Download Template:File not present in downloads</b>");
							DriverFactory.getInstance().getWebDriver().navigate().refresh();
							Thread.sleep(2000);
							break;
						}
					}
				
			}
			
			
			

//TC_10

	public static void MU_VerifyIsExcelFileDownloaded() throws InterruptedException {
		File f1 = null;
		String path = "";
		boolean bool = false;


		//webActions.Click(examActivity, "Exam Activity");
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

		
        
		File fileLocation = new File("C:/Users/"+userName+"/Downloads");
		File[] totalfiles = fileLocation.listFiles();

		for (File file : totalfiles) {
			if (file.getName().equals("Presentation_EBTY801L.xls")) {
				System.out.println("File is downloaded");

				f1 = file.getAbsoluteFile();
				bool = file.exists();
				path = file.getAbsolutePath();
				if (path.contains(".xls")) {
				System.out.print(path + "Exists" + bool);
					
					ReportManager.logInfo("<b style=\"color:blue;\">*****Successfully verified, downloaded file is excel*****</b>");
					DriverFactory.getInstance().getWebDriver().navigate().refresh();
					Thread.sleep(2000);
					
					break;
				}
				else {
					System.out.println("File Present not present in Excel format"); 
					ReportManager.logInfo("<b style=\"color:red;\">File Present not present in Excel format</b>");
					DriverFactory.getInstance().getWebDriver().navigate().refresh();
					Thread.sleep(2000);
				}
			}
		}
	}
	
		

//TC_11

	public static void MU_UploadSheet_MarksCol_InvalidData_CHARS() throws InterruptedException, AWTException {

	//	webActions.Click(examActivity, "Exam Activity");
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

		webActions.Click(downlaodTemplate, "Download link");
		Thread.sleep(6000);

		File fileLocation = new File("C:/Users/"+userName+"/Downloads");
		File[] totalfiles = fileLocation.listFiles();

		for (File file : totalfiles) {
			if (file.getName().equals("Presentation_EBTY801L.xls")) {
				System.out.println("File is downloaded");

				// File f1 = file.getAbsoluteFile();
				Boolean bool = file.exists();
				String path = file.getAbsolutePath();
				if (path.contains(".xls")) {
					System.out.print(path + "Exists" + bool);
					ReportManager.logInfo("Excel File exists- " + path + "");

				}
			}
		}

		try {

			File excel = new File("c:/Users/"+userName+"/downloads/Presentation_EBTY801L.xls");
			fis = new FileInputStream(excel);
			wb = new HSSFWorkbook(fis);
			sh = wb.getSheet("Marks Entry Template");

			int NumOfRows = sh.getLastRowNum();
			System.out.println(NumOfRows);
			
			// To read data in cell
			System.out.println(sh.getRow(2).getCell(8).getStringCellValue());
			System.out.println(sh.getRow(3).getCell(8).getStringCellValue());

			// To write into cell

			sh.getRow(3).createCell(8).setCellValue("abc");
			sh.getRow(4).createCell(8).setCellValue("def");
			sh.getRow(5).createCell(8).setCellValue("ghi");

			String E19SOE820 = sh.getRow(3).getCell(8).getStringCellValue();
			String E19SOE822 = sh.getRow(4).getCell(8).getStringCellValue();
			String E19SOE824 = sh.getRow(5).getCell(8).getStringCellValue();

			System.out.println(E19SOE820);
			System.out.println(E19SOE822);
			System.out.println(E19SOE824);

			ReportManager.logInfo("Below Data Entered in Marks Column");
			ReportManager.logInfo("E19SOE820 <b style=\"color:green;\"> " + E19SOE820 + " </b>");
			ReportManager.logInfo("E19SOE822 <b style=\"color:green;\"> " + E19SOE822 + " </b>");
			ReportManager.logInfo("E19SOE824 <b style=\"color:green;\"> " + E19SOE824 + " </b>");

			FileOutputStream fos = new FileOutputStream(
					new File("c:/Users/LENOVO/downloads/Presentation_EBTY801L.xls"));
			wb.write(fos);
			wb.close();

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		WebElement upload = DriverFactory.getInstance().getWebDriver().findElement(chooseFile);
		upload.sendKeys("c:/Users/LENOVO/downloads/Presentation_EBTY801L.xls");
		ReportManager.logInfo("Uploaded Excel File with data");

		Thread.sleep(8000);

		String Redexpected = "#dd4b39";

		List<WebElement> list_errorCol = webActions.getListOfWebElements(errorColList);
		List<WebElement> list_enrollment = webActions.getListOfWebElements(enrollmentNoList);

		for (int i = 0; i < list_errorCol.size(); i++) {
			String str_Bcolor = list_errorCol.get(i).getCssValue("background-color");

			String hexcolorRed = Color.fromString(str_Bcolor).asHex();
			String actual = hexcolorRed;

			if (actual.equalsIgnoreCase(Redexpected)) {
				String Str_enrolcol = list_errorCol.get(i).getText();
				System.out.println("Error Text:" + Str_enrolcol);

				if (actual.equalsIgnoreCase(Redexpected)) {
					String str_enrollment = list_enrollment.get(i).getText();
					System.out.println("Enrollment Number:" + str_enrollment);

					ReportManager.logInfo("ErrorList - <b style=\"color:Red;\">" + Str_enrolcol + "</b>"
							+ ", Enrollment Number - <b style=\"color:green;\">" + str_enrollment + "</b>");
					
					System.out.println("****Verification completed Invalid Marks by Chars****");

				}
			}
		}
		ReportManager.logInfo("<b style=\"color:blue;\">****Verification completed by uploading marks as chars - Invalid data****</b>");	

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
	public static void MU_UploadSheet_MarksCol_INVALIDMarks() throws InterruptedException {

		DriverFactory.getInstance().getWebDriver().navigate().refresh();
		Thread.sleep(2000);
		
	//	webActions.Click(examActivity, "Exam Activity");
		Thread.sleep(2000);
		webActions.Click(marksUpload, "Marks Upload");
		Thread.sleep(6000);

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

		File fileLocation = new File("C:/Users/"+userName+"/Downloads");
		File[] totalfiles = fileLocation.listFiles();

		for (File file : totalfiles) {
			if (file.getName().equals("Presentation_EBTY801L.xls")) {
				System.out.println("File is downloaded");

				// File f1 = file.getAbsoluteFile();
				Boolean bool = file.exists();
				String path = file.getAbsolutePath();
				if (path.contains(".xls")) {
					System.out.print(path + "Exists" + bool);
					ReportManager.logInfo("***Excel File exists- " + path + "*****");
					
				}
			}
		}

		try {

			File excel = new File("c:/Users/"+userName+"/downloads/Presentation_EBTY801L.xls");
			fis = new FileInputStream(excel);
			wb = new HSSFWorkbook(fis);
			sh = wb.getSheet("Marks Entry Template");

			int NumOfRows = sh.getLastRowNum();
			System.out.println(NumOfRows);
			
			// To read data in cell
			System.out.println(sh.getRow(2).getCell(8).getStringCellValue());
			System.out.println(sh.getRow(3).getCell(8).getStringCellValue());

			// To write into cell

			sh.getRow(3).createCell(8).setCellValue("-100");
			sh.getRow(4).createCell(8).setCellValue("-50");
			sh.getRow(5).createCell(8).setCellValue("50");

			String E19SOE820 = sh.getRow(3).getCell(8).getStringCellValue();
			String E19SOE822 = sh.getRow(4).getCell(8).getStringCellValue();
			String E19SOE824 = sh.getRow(5).getCell(8).getStringCellValue();

			System.out.println(E19SOE820);
			System.out.println(E19SOE822);
			System.out.println(E19SOE824);

			ReportManager.logInfo("E19SOE820 <b style=\"color:green;\"> " + E19SOE820 + " </b>");
			ReportManager.logInfo("E19SOE822 <b style=\"color:green;\"> " + E19SOE822 + " </b>");
			ReportManager.logInfo("E19SOE824 <b style=\"color:green;\"> " + E19SOE824 + " </b>");

			FileOutputStream fos = new FileOutputStream(
					new File("c:/Users/LENOVO/downloads/Presentation_EBTY801L.xls"));
			wb.write(fos);
			wb.close();

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		WebElement upload = DriverFactory.getInstance().getWebDriver().findElement(chooseFile);
		upload.sendKeys("c:/Users/LENOVO/downloads/Presentation_EBTY801L.xls");
		ReportManager.logInfo("Uploaded Excel File");
		Thread.sleep(8000);
		String Redexpected = "#dd4b39";

		List<WebElement> list_errorCol = webActions.getListOfWebElements(errorColList);
		List<WebElement> list_enrollment = webActions.getListOfWebElements(enrollmentNoList);

		for (int i = 0; i < list_errorCol.size(); i++) {
			String str_Bcolor = list_errorCol.get(i).getCssValue("background-color");

			String hexcolorRed = Color.fromString(str_Bcolor).asHex();
			String actual = hexcolorRed;

			if (actual.equalsIgnoreCase(Redexpected)) {
				String Str_enrolcol = list_errorCol.get(i).getText();
				System.out.println("Error Text:" + Str_enrolcol);

				if (actual.equalsIgnoreCase(Redexpected)) {
					String str_enrollment = list_enrollment.get(i).getText();
					System.out.println("Enrollment Number:" + str_enrollment);

					ReportManager.logInfo("ErrorList - <b style=\"color:Red;\">" + Str_enrolcol + "</b>"
							+ ", Enrollment Number - <b style=\"color:green;\">" + str_enrollment + "</b>");


					System.out.println("****Verification completed by uploading invalid marks****");

				}
			}
		}
		ReportManager.logInfo("<b style=\"color:blue;\">****Verification completed by uploading invalid marks****</b>");	
	}

	// TC_14
	public static void MU_saveExcel_with_NOERRORS() throws InterruptedException {

		DriverFactory.getInstance().getWebDriver().navigate().refresh();
		Thread.sleep(2000);
		
		//webActions.Click(examActivity, "Exam Activity");
		Thread.sleep(2000);
		
		webActions.Click(marksUpload, "Marks Upload");
		Thread.sleep(2000);

		webActions.selectByVisibleText(institute, " School of Engineering and Applied Sciences ");

		webActions.selectByVisibleText(registrationCode, "1920_EVEN_SEMESTER");
		ReportManager.logInfo("Registration Code - <b style=\"color:green;\">\"1920_EVEN_SEMESTER\"</b> ");

		webActions.selectByVisibleText(subjectCode, "EBTY801L ( ADVANCED MOLECULAR BIOLOGY)");
		ReportManager
				.logInfo("Subject Code - <b style=\"color:green;\">\"EBTY801L ( ADVANCED MOLECULAR BIOLOGY)\"</b> ");

		webActions.selectByVisibleText(examEventCode, " Project ( Project) ");
		Thread.sleep(5000);

		webActions.Click(downlaodTemplate, "Download link");
		Thread.sleep(6000);

		File fileLocation = new File("C:/Users/"+userName+"/Downloads");
		File[] totalfiles = fileLocation.listFiles();

		for (File file : totalfiles) {
			if (file.getName().equals("Project_EBTY801L.xls")) {
				System.out.println("File is downloaded");
				ReportManager.logInfo("Excel File Downloaded");

				// File f1 = file.getAbsoluteFile();
				Boolean bool = file.exists();
				String path = file.getAbsolutePath();
				if (path.contains(".xls")) {
					System.out.print(path + "Exists" + bool);
					ReportManager.logInfo("Excel File exists- " + path + "");

				}
			}
		}

		try {

			File excel = new File("c:/Users/"+userName+"/downloads/Project_EBTY801L.xls");
			fis = new FileInputStream(excel);
			wb = new HSSFWorkbook(fis);
			sh = wb.getSheet("Marks Entry Template");

			int NumOfRows = sh.getLastRowNum();
			System.out.println(NumOfRows);

			// To read data in cell
			System.out.println(sh.getRow(2).getCell(8).getStringCellValue());
			System.out.println(sh.getRow(3).getCell(8).getStringCellValue());

			// To write into cell

			sh.getRow(3).createCell(8).setCellValue("90");
			sh.getRow(4).createCell(8).setCellValue("90");
			sh.getRow(5).createCell(8).setCellValue("90");

			String E19SOE820 = sh.getRow(3).getCell(8).getStringCellValue();
			String E19SOE822 = sh.getRow(4).getCell(8).getStringCellValue();
			String E19SOE824 = sh.getRow(5).getCell(8).getStringCellValue();

			System.out.println(E19SOE820);
			System.out.println(E19SOE822);
			System.out.println(E19SOE824);

			ReportManager.logInfo("E19SOE820 <b style=\"color:green;\"> " + E19SOE820 + " </b>");
			ReportManager.logInfo("E19SOE822 <b style=\"color:green;\"> " + E19SOE822 + " </b>");
			ReportManager.logInfo("E19SOE824 <b style=\"color:green;\"> " + E19SOE824 + " </b>");

			FileOutputStream fos = new FileOutputStream(new File("c:/Users/LENOVO/downloads/Project_EBTY801L.xls"));
			wb.write(fos);
			wb.close();

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		WebElement upload = DriverFactory.getInstance().getWebDriver().findElement(chooseFile);
		upload.sendKeys("c:/Users/LENOVO/downloads/Project_EBTY801L.xls");
		ReportManager.logInfo("Uploaded Excel File with data");

		Thread.sleep(8000);

		webActions.Click(saveMarks, "Save Marks");
		Thread.sleep(2000);

		String Str_MarksSavedMsg = webActions.getText(marksSaved);
		webActions.verifyText(Str_MarksSavedMsg, "Marks saved successfully !!!");
		webActions.Click(OKButn, "OK button");
		
		System.out.println("*****Uploaded and Saved Successfully*****");
		ReportManager.logInfo("<b style=\"color:blue;\">*****Uploaded and Saved Successfully*****</b>");

		DriverFactory.getInstance().getWebDriver().navigate().refresh();
		Thread.sleep(2000);
	}

	// TC_15

	public static void MU_Save_File_OtherThanEXcelFormat() throws InterruptedException {

	//	webActions.Click(examActivity, "Exam Activity");
		Thread.sleep(2000);
		webActions.Click(marksUpload, "Marks Upload");
		Thread.sleep(2000);

		webActions.selectByVisibleText(institute, " School of Engineering and Applied Sciences ");

		webActions.selectByVisibleText(registrationCode, "1920_EVEN_SEMESTER");
		ReportManager.logInfo("Registration Code - <b style=\"color:green;\">\"1920_EVEN_SEMESTER\"</b> ");

		webActions.selectByVisibleText(subjectCode, "EBTY801L ( ADVANCED MOLECULAR BIOLOGY)");
		ReportManager
				.logInfo("Subject Code - <b style=\"color:green;\">\"EBTY801L ( ADVANCED MOLECULAR BIOLOGY)\"</b> ");

		webActions.selectByVisibleText(examEventCode, " Project ( Project) ");
		Thread.sleep(5000);

		WebElement upload = DriverFactory.getInstance().getWebDriver().findElement(chooseFile);
		upload.sendKeys("c:/Users/"+userName+"/downloads/TempFile.txt");
		Thread.sleep(2000);
		ReportManager.logInfo("Uploaded Excel File with data");

		String Str_InCorrectFile = webActions.getText(incorrectFileUpload_Msg);

		if (Str_InCorrectFile.contains("Please upload only excel file. !!!")) {
			webActions.Click(OKButn, "OK");
			ReportManager.logInfo("Error Message - <b style=\"color:green;\">\"Please upload only excel file. !!!\"</b>");
			ReportManager.logInfo("<b style=\"color:blue;\">***verification completed successfully:Error Msg Displayd - Please upload excel File***</b>");
			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(2000);

		}

		else {
			ReportManager.logInfo("<b style=\"color:red;\">\"No Error Message is displayed\"</b> ");
			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(2000);

		}
	}

//TC_16 - Duplicate
	
//TC_17

	public static void MU_Verify_DownloadErrorList_Optn() throws InterruptedException {
	//	webActions.Click(examActivity, "Exam Activity");
		Thread.sleep(2000);
		webActions.Click(marksUpload, "Marks Upload");
		Thread.sleep(2000);

		webActions.selectByVisibleText(institute, " School of Engineering and Applied Sciences ");

		webActions.selectByVisibleText(registrationCode, "1920_EVEN_SEMESTER");
		ReportManager.logInfo("Registration Code - <b style=\"color:green;\">\"1920_EVEN_SEMESTER\"</b> ");

		webActions.selectByVisibleText(subjectCode, "EBTY801L ( ADVANCED MOLECULAR BIOLOGY)");
		ReportManager
				.logInfo("Subject Code - <b style=\"color:green;\">\"EBTY801L ( ADVANCED MOLECULAR BIOLOGY)\"</b> ");

		webActions.selectByVisibleText(examEventCode, " Project ( Project) ");
		Thread.sleep(5000);

		webActions.Click(downlaodTemplate, "Download link");
		Thread.sleep(6000);

		File fileLocation = new File("C:/Users/"+userName+"/Downloads");
		File[] totalfiles = fileLocation.listFiles();

		for (File file : totalfiles) {
			if (file.getName().equals("Project_EBTY801L.xls")) {
				System.out.println("Excel File is downloaded");
				ReportManager.logInfo("Excel File Downloaded");

				// File f1 = file.getAbsoluteFile();
				Boolean bool = file.exists();
				String path = file.getAbsolutePath();
				if (path.contains(".xls")) {
					System.out.print(path + "Exists" + bool);
					ReportManager.logInfo("Excel File exists- " + path + " ");

				}
			}
		}

		try

		{

			File excel = new File("c:/Users/"+userName+"/downloads/Project_EBTY801L.xls");
			fis = new FileInputStream(excel);
			wb = new HSSFWorkbook(fis);
			sh = wb.getSheet("Marks Entry Template");

			int NumOfRows = sh.getLastRowNum();
			System.out.println(NumOfRows);

			// To read data in cell
			System.out.println(sh.getRow(2).getCell(8).getStringCellValue());
			System.out.println(sh.getRow(3).getCell(8).getStringCellValue());

			// To write into cell

			sh.getRow(3).createCell(8).setCellValue("-90");
			sh.getRow(4).createCell(8).setCellValue("90");
			sh.getRow(5).createCell(8).setCellValue("-80");

			String E19SOE820 = sh.getRow(3).getCell(8).getStringCellValue();
			String E19SOE822 = sh.getRow(4).getCell(8).getStringCellValue();
			String E19SOE824 = sh.getRow(5).getCell(8).getStringCellValue();

			System.out.println(E19SOE820);
			System.out.println(E19SOE822);
			System.out.println(E19SOE824);

			ReportManager.logInfo("E19SOE820 <b style=\"color:green;\"> " + E19SOE820 + " </b>");
			ReportManager.logInfo("E19SOE822 <b style=\"color:green;\"> " + E19SOE822 + " </b>");
			ReportManager.logInfo("E19SOE824 <b style=\"color:green;\"> " + E19SOE824 + " </b>");

			FileOutputStream fos = new FileOutputStream(new File("c:/Users/LENOVO/downloads/Project_EBTY801L.xls"));
			wb.write(fos);
			wb.close();

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

		WebElement upload = DriverFactory.getInstance().getWebDriver().findElement(chooseFile);
		upload.sendKeys("c:/Users/LENOVO/downloads/Project_EBTY801L.xls");
		ReportManager.logInfo("Uploaded Excel File with data");

		Thread.sleep(8000);

		String Redexpected = "#dd4b39";

		List<WebElement> list_errorCol = webActions.getListOfWebElements(errorColList);

		for (int i = 0; i < list_errorCol.size(); i++) {
			String str_Bcolor = list_errorCol.get(i).getCssValue("background-color");

			String hexcolorRed = Color.fromString(str_Bcolor).asHex();
			String actual = hexcolorRed;

			if (actual.equalsIgnoreCase(Redexpected)) {

				System.out.println("Error Exists in uploded sheet");
				ReportManager.logInfo("Error Exists in uploded sheet");

				webActions.Click(downloadErrorList, "Download Error List");
				Thread.sleep(6000);
				break;
			}

		}

		File ErroListfileLocation = new File("C:/Users/LENOVO/Downloads");
		File[] TotalFiles = ErroListfileLocation.listFiles();

		for (File file : TotalFiles) {
			if (file.getName().equals("Project_EBTY801L_Error.xls")) {
				System.out.println("Error List File is downloaded");
				System.out.println("***verification completed successfully: Dwonload Error List - Error File is Downloaded***");
				ReportManager.logInfo("<b style=\"color:blue;\">***verification completed successfully: Download Error List - Error File is Downloaded***</b>");
				break;
			}
		}
		
		DriverFactory.getInstance().getWebDriver().navigate().refresh();
		Thread.sleep(2000);
	}

//TC_18
	public static void MU_Lock_UploadedMarks() throws InterruptedException {
	//	webActions.Click(examActivity, "Exam Activity");
		Thread.sleep(2000);
		webActions.Click(marksUpload, "Marks Upload");
		Thread.sleep(2000);

		webActions.selectByVisibleText(institute, " School of Engineering and Applied Sciences ");

		webActions.selectByVisibleText(registrationCode, "1920_EVEN_SEMESTER");
		ReportManager.logInfo("Registration Code - <b style=\"color:green;\">\"1920_EVEN_SEMESTER\"</b> ");

		webActions.selectByVisibleText(subjectCode, "EBTY801L ( ADVANCED MOLECULAR BIOLOGY)");
		ReportManager
				.logInfo("Subject Code - <b style=\"color:green;\">\"EBTY801L ( ADVANCED MOLECULAR BIOLOGY)\"</b> ");

		webActions.selectByVisibleText(examEventCode, " Class Participation ( Class Participation) ");
		Thread.sleep(5000);

		webActions.Click(downlaodTemplate, "Download link");
		Thread.sleep(6000);

		File fileLocation = new File("C:/Users/"+userName+"/Downloads");
		File[] totalfiles = fileLocation.listFiles();

		for (File file : totalfiles) {
			if (file.getName().equals("Class_Participation_EBTY801L.xls")) {
				System.out.println("File is downloaded");
				ReportManager.logInfo("Excel File Downloaded</b>");

				// File f1 = file.getAbsoluteFile();
				Boolean bool = file.exists();
				String path = file.getAbsolutePath();
				if (path.contains(".xls")) {
					System.out.print(path + "Exists" + bool);
					ReportManager.logInfo("Excel File exists- " + path + " ");

				}
			}
		}

		try {

			File excel = new File("c:/Users/"+userName+"/downloads/Class_Participation_EBTY801L.xls");
			fis = new FileInputStream(excel);
			wb = new HSSFWorkbook(fis);
			sh = wb.getSheet("Marks Entry Template");

			int NumOfRows = sh.getLastRowNum();
			System.out.println(NumOfRows);
			ReportManager.logInfo("Total Rows <b style=\"color:green;\"> " + NumOfRows + " </b>");

			// To read data in cell
			System.out.println(sh.getRow(2).getCell(8).getStringCellValue());
			System.out.println(sh.getRow(3).getCell(8).getStringCellValue());

			// To write into cell

			sh.getRow(3).createCell(8).setCellValue("40");
			sh.getRow(4).createCell(8).setCellValue("40");
			sh.getRow(5).createCell(8).setCellValue("30");

			String E19SOE820 = sh.getRow(3).getCell(8).getStringCellValue();
			String E19SOE822 = sh.getRow(4).getCell(8).getStringCellValue();
			String E19SOE824 = sh.getRow(5).getCell(8).getStringCellValue();

			System.out.println(E19SOE820);
			System.out.println(E19SOE822);
			System.out.println(E19SOE824);

			ReportManager.logInfo("E19SOE820 <b style=\"color:green;\"> " + E19SOE820 + " </b>");
			ReportManager.logInfo("E19SOE822 <b style=\"color:green;\"> " + E19SOE822 + " </b>");
			ReportManager.logInfo("E19SOE824 <b style=\"color:green;\"> " + E19SOE824 + " </b>");

			FileOutputStream fos = new FileOutputStream(
					new File("c:/Users/LENOVO/downloads/Class_Participation_EBTY801L.xls"));
			wb.write(fos);
			wb.close();

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		WebElement upload = DriverFactory.getInstance().getWebDriver().findElement(chooseFile);
		upload.sendKeys("c:/Users/"+userName+"/downloads/Class_Participation_EBTY801L.xls");
		ReportManager.logInfo("Uploaded Excel File</b>");

		Thread.sleep(8000);

		webActions.Click(saveMarks, "Save Marks");
		Thread.sleep(2000);

		String Str_MarksSavedMsg = webActions.getText(marksSaved);
		webActions.verifyText(Str_MarksSavedMsg, "Marks saved successfully !!!");
		webActions.Click(OKButn, "OK button");
		ReportManager.logInfo("Uploaded and Saved Successfully");
		Thread.sleep(4000);

		webActions.Click(lockCheckBox, "Lock checkBox");
		Thread.sleep(2000);

		String LockMsg = webActions.getText(lockConfirmation_Msg);
		webActions.verifyText(LockMsg, "Please save your entry.Once you locked, you are no longer able to edit.");
		webActions.Click(lock_Cnfrm_YES, "YES");

		String Locked_text = webActions.getText(entry_Locked);

		if (Locked_text.equalsIgnoreCase(""))
			webActions.verifyText(Locked_text, "Entry locked successfully !!!");

		webActions.Click(OKButn, "OK");
		Thread.sleep(2000);

		String lockStatusText = webActions.getText(lockStatus);
		if (lockStatusText.equalsIgnoreCase("Locked")) {
			ReportManager.logInfo("Lock Status is - <b style=\"color:green;\"> " + lockStatusText + "</b>");
			System.out.println("*****Uploaded and Locked Exam Marks Successfully*****");
			ReportManager.logInfo("Lock Status is - <b style=\"color:blue;\">*****Uploaded and Locked Exam Marks Successfully*****</b>");

			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(2000);
		} else {
			ReportManager.logInfo("Lock Status is - <b style=\"color:red;\"> " + lockStatusText + "</b>");
			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(2000);
		}

	}

//TC_19
	public static void MU_Lock_Without_MarksSheet() throws InterruptedException {

		//webActions.Click(examActivity, "Exam Activity");
		Thread.sleep(2000);
		webActions.Click(marksUpload, "Marks Upload");
		Thread.sleep(2000);

		webActions.selectByVisibleText(institute, " School of Engineering and Applied Sciences ");

		webActions.selectByVisibleText(registrationCode, "1920_EVEN_SEMESTER");
		ReportManager.logInfo("Registration Code - <b style=\"color:green;\">\"1920_EVEN_SEMESTER\"</b> ");

		webActions.selectByVisibleText(subjectCode, "EBTY801L ( ADVANCED MOLECULAR BIOLOGY)");
		ReportManager
				.logInfo("Subject Code - <b style=\"color:green;\">\"EBTY801L ( ADVANCED MOLECULAR BIOLOGY)\"</b> ");

		webActions.selectByVisibleText(examEventCode, " Assignment -01 ( Assignment -01) ");
		Thread.sleep(5000);

		webActions.Click(lockCheckBox, "Lock CheckBox");
		webActions.Click(lock_Cnfrm_YES, "YES");

		String Str_unabletolock = webActions.getText(unableToLock);
		if (Str_unabletolock.equalsIgnoreCase("Entry can not be locked, because total student marks not entered. !!")) {
			webActions.Click(OKButn, "OK");
			System.out.println("***Error Msg Displayed : Entry can not be locked, because total student marks not entered. !!***");
			ReportManager.logInfo("<b style=\"color:blue;\">\"***Error Msg Displayed : Entry can not be locked, because total student marks not entered. !!***\"</b> ");
			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(2000);

		} else {
			ReportManager.logInfo("<b style=\"color:red;\">\"No Error Message is displayed\"</b> ");
			DriverFactory.getInstance().getWebDriver().navigate().refresh();
			Thread.sleep(2000);
		}

	}

	// TC_20
	public static void MU_Verify_ExcelReports_Optn() throws InterruptedException {

		//webActions.Click(examActivity, "Exam Activity");
		Thread.sleep(2000);

		webActions.Click(marksUpload, "Marks Upload");
		Thread.sleep(2000);

		webActions.selectByVisibleText(institute, " School of Engineering and Applied Sciences ");

		webActions.selectByVisibleText(registrationCode, "1920_EVEN_SEMESTER");
		ReportManager.logInfo("Registration Code - <b style=\"color:green;\">\"1920_EVEN_SEMESTER\"</b> ");

		webActions.selectByVisibleText(subjectCode, "EBTY801L ( ADVANCED MOLECULAR BIOLOGY)");
		ReportManager
				.logInfo("Subject Code - <b style=\"color:green;\">\"EBTY801L ( ADVANCED MOLECULAR BIOLOGY)\"</b> ");

		webActions.selectByVisibleText(examEventCode, " Class Participation ( Class Participation) ");
		Thread.sleep(5000);

		webActions.Click(downlaodTemplate, "Download link");
		Thread.sleep(6000);

		File fileLocation = new File("C:/Users/"+userName+"/Downloads");
		File[] totalfiles = fileLocation.listFiles();

		for (File file : totalfiles) {
			if (file.getName().equals("Class_Participation_EBTY801L.xls")) {
				System.out.println("File is downloaded");
				ReportManager.logInfo("Excel File Downloaded");

				// File f1 = file.getAbsoluteFile();
				Boolean bool = file.exists();
				String path = file.getAbsolutePath();
				if (path.contains(".xls")) {
					System.out.print(path + "Exists" + bool);
					ReportManager.logInfo("Excel present at location- " + path + " ");

				}
			}
		}

		try {

			File excel = new File("c:/Users/"+userName+"/downloads/Class_Participation_EBTY801L.xls");
			fis = new FileInputStream(excel);
			wb = new HSSFWorkbook(fis);
			sh = wb.getSheet("Marks Entry Template");

			int NumOfRows = sh.getLastRowNum();
			System.out.println(NumOfRows);

			// To read data in cell
			System.out.println(sh.getRow(2).getCell(8).getStringCellValue());
			System.out.println(sh.getRow(3).getCell(8).getStringCellValue());

			// To write into cell

			sh.getRow(3).createCell(8).setCellValue("40");
			sh.getRow(4).createCell(8).setCellValue("40");
			sh.getRow(5).createCell(8).setCellValue("30");

			String E19SOE820 = sh.getRow(3).getCell(8).getStringCellValue();
			String E19SOE822 = sh.getRow(4).getCell(8).getStringCellValue();
			String E19SOE824 = sh.getRow(5).getCell(8).getStringCellValue();

			System.out.println(E19SOE820);
			System.out.println(E19SOE822);
			System.out.println(E19SOE824);

			ReportManager.logInfo("E19SOE820 <b style=\"color:green;\"> " + E19SOE820 + " </b>");
			ReportManager.logInfo("E19SOE822 <b style=\"color:green;\"> " + E19SOE822 + " </b>");
			ReportManager.logInfo("E19SOE824 <b style=\"color:green;\"> " + E19SOE824 + " </b>");

			FileOutputStream fos = new FileOutputStream(
					new File("c:/Users/LENOVO/downloads/Class_Participation_EBTY801L.xls"));
			wb.write(fos);
			wb.close();

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		WebElement upload = DriverFactory.getInstance().getWebDriver().findElement(chooseFile);
		upload.sendKeys("c:/Users/LENOVO/downloads/Class_Participation_EBTY801L.xls");
		ReportManager.logInfo("Uploaded Excel File with valid data");

		Thread.sleep(8000);

		String Redexpected = "#dd4b39";

		List<WebElement> list_errorCol = webActions.getListOfWebElements(errorColList);

		for (int i = 0; i < list_errorCol.size(); i++) {
			String str_Bcolor = list_errorCol.get(i).getCssValue("background-color");

			String hexcolorRed = Color.fromString(str_Bcolor).asHex();
			String actual = hexcolorRed;

			if (!actual.equalsIgnoreCase(Redexpected)) {
				System.out.println("Verified uploaded file - No Error Exists");
				ReportManager.logInfo("Verified uploaded file - No Error Exists");
				

			}
			
		}
		webActions.Click(excelReport, "Excel Report");
		Thread.sleep(6000);

		File downloadLocation = new File("C:/Users/LENOVO/Downloads");
		File[] AllFiles = downloadLocation.listFiles();

		for (File file : AllFiles) {
			if (file.getName().equals("EBTY801L_(_ADVANCED_MOLECULAR_BIOLOGY)_Report.xls")) {
				System.out.println("Excel Report is downloaded");
				ReportManager.logInfo("Excel Report is downloaded");

				// File f1 = file.getAbsoluteFile();
				Boolean bool = file.exists();
				String path = file.getAbsolutePath();
				if (path.contains("EBTY801L_(_ADVANCED_MOLECULAR_BIOLOGY)_Report.xls")) {
					System.out.print(path + "Exists" + bool);
					ReportManager.logInfo("Excel Report present at- " + path + " ");
					System.out.println("*****Excel Report Present in Downloads*****");
					ReportManager.logInfo("<b style=\"color:blue;\">*****Verification completed succssfully - Excel Report Present in Downloads*****</b>");
					DriverFactory.getInstance().getWebDriver().navigate().refresh();
					Thread.sleep(2000);

				}
			}
		}

	}
	
//TC_21

	public static void MU_Verify_PrintMarksSheet_Option() throws InterruptedException {
	//	webActions.Click(examActivity, "Exam Activity");
		Thread.sleep(2000);

		webActions.Click(marksUpload, "Marks Upload");
		Thread.sleep(2000);

		webActions.selectByVisibleText(institute, " School of Engineering and Applied Sciences ");

		webActions.selectByVisibleText(registrationCode, "1920_EVEN_SEMESTER");
		ReportManager.logInfo("Registration Code - <b style=\"color:green;\">\"1920_EVEN_SEMESTER\"</b> ");

		webActions.selectByVisibleText(subjectCode, "EBTY801L ( ADVANCED MOLECULAR BIOLOGY)");
		ReportManager
				.logInfo("Subject Code - <b style=\"color:green;\">\"EBTY801L ( ADVANCED MOLECULAR BIOLOGY)\"</b> ");

		webActions.selectByVisibleText(examEventCode, " Class Participation ( Class Participation) ");
		Thread.sleep(5000);

		webActions.Click(downlaodTemplate, "Download link");
		Thread.sleep(6000);

		File fileLocation = new File("C:/Users/"+userName+"/Downloads");
		File[] totalfiles = fileLocation.listFiles();

		for (File file : totalfiles) {
			if (file.getName().equals("Class_Participation_EBTY801L.xls")) {
				System.out.println("File is downloaded");
				ReportManager.logInfo("Excel File Downloaded");

				// File f1 = file.getAbsoluteFile();
				Boolean bool = file.exists();
				String path = file.getAbsolutePath();
				if (path.contains(".xls")) {
					System.out.print(path + "Exists" + bool);
					ReportManager.logInfo("Excel present at location- " + path + " ");

				}
			}
		}

		try {

			File excel = new File("c:/Users/"+userName+"/downloads/Class_Participation_EBTY801L.xls");
			fis = new FileInputStream(excel);
			wb = new HSSFWorkbook(fis);
			sh = wb.getSheet("Marks Entry Template");

			int NumOfRows = sh.getLastRowNum();
			System.out.println(NumOfRows);
			ReportManager.logInfo("Total Rows <b style=\"color:green;\"> " + NumOfRows + " </b>");

			// To read data in cell
			System.out.println(sh.getRow(2).getCell(8).getStringCellValue());
			System.out.println(sh.getRow(3).getCell(8).getStringCellValue());

			// To write into cell

			sh.getRow(3).createCell(8).setCellValue("40");
			sh.getRow(4).createCell(8).setCellValue("40");
			sh.getRow(5).createCell(8).setCellValue("30");

			String E19SOE820 = sh.getRow(3).getCell(8).getStringCellValue();
			String E19SOE822 = sh.getRow(4).getCell(8).getStringCellValue();
			String E19SOE824 = sh.getRow(5).getCell(8).getStringCellValue();

			System.out.println(E19SOE820);
			System.out.println(E19SOE822);
			System.out.println(E19SOE824);

			ReportManager.logInfo("Marks uploaded for E19SOE820 <b style=\"color:green;\"> " + E19SOE820 + " </b>");
			ReportManager.logInfo("Marks uploaded for E19SOE822 <b style=\"color:green;\"> " + E19SOE822 + " </b>");
			ReportManager.logInfo("Marks uploaded for E19SOE824 <b style=\"color:green;\"> " + E19SOE824 + " </b>");

			FileOutputStream fos = new FileOutputStream(
					new File("c:/Users/LENOVO/downloads/Class_Participation_EBTY801L.xls"));
			wb.write(fos);
			wb.close();

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		WebElement upload = DriverFactory.getInstance().getWebDriver().findElement(chooseFile);
		upload.sendKeys("c:/Users/LENOVO/downloads/Class_Participation_EBTY801L.xls");
		ReportManager.logInfo("Uploaded Excel File with data");

		Thread.sleep(8000);

		String Redexpected = "#dd4b39";

		List<WebElement> list_errorCol = webActions.getListOfWebElements(errorColList);

		for (int i = 0; i < list_errorCol.size(); i++) {
			String str_Bcolor = list_errorCol.get(i).getCssValue("background-color");

			String hexcolorRed = Color.fromString(str_Bcolor).asHex();
			String actual = hexcolorRed;

			if (!actual.equalsIgnoreCase(Redexpected)) {
				System.out.println("Verified uploaded file - No Error Exists");
				ReportManager.logInfo("Verified uploaded file - No Error Exists");				

			}

		}

		webActions.Click(printMarksSheet, "Print Marks Sheet");
		Thread.sleep(6000);

		File downloadLocation = new File("C:/Users/LENOVO/Downloads");
		File[] AllFiles = downloadLocation.listFiles();

		for (File file : AllFiles) {
			if (file.getName().equals("EBTY801L_(_ADVANCED_MOLECULAR_BIOLOGY)_Report.pdf")) {
				System.out.println("pdf Report is downloaded");
				ReportManager.logInfo("pdf Report is downloaded");

				// File f1 = file.getAbsoluteFile();
				Boolean bool = file.exists();
				String path = file.getAbsolutePath();
				if (path.contains("EBTY801L_(_ADVANCED_MOLECULAR_BIOLOGY)_Report.pdf")) {
					System.out.print(path + "Exists" + bool);
					ReportManager.logInfo("PDF Report present at- " + path + " ");
					System.out.println("***Verification completed successfully - PrintMarksSheet - PDF Report is downloaded***");
					ReportManager.logInfo("<b style=\"color:blue;\">***Verification completed successfully - PrintMarksSheet - PDF Report is downloaded***</b>");
					DriverFactory.getInstance().getWebDriver().navigate().refresh();
					Thread.sleep(2000);

				}
			}
		}

	}
	
}
