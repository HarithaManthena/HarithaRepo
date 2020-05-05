package WebUtil;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertEquals;

import Utilities.DriverFactory;
import Utilities.ReportManager;

public class WebActions {

	JavascriptExecutor scrollBarPresent = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();
	/*
	 * @SuppressWarnings("deprecation") public WebElement waitForVisible(By locator)
	 * { WebDriverWait wait = new
	 * WebDriverWait(DriverFactory.getInstance().getWebDriver(), 60);
	 * wait.pollingEvery(5, TimeUnit.SECONDS); return
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); }
	 * 
	 * public void Click(By locator, String info) { WebElement elm =
	 * waitForVisible(locator); elm.click();
	 * ReportManager.logInfo("Successfully clicked on - " + info); }
	 * 
	 * public void sendKeys(By locator, String text) { WebElement elm =
	 * waitForVisible(locator); elm.sendKeys(text);
	 * ReportManager.logInfo("Successfully Entered text - " + text); }
	 * 
	 * public void clearAndSendKeys(By locator, String text) { WebElement elm =
	 * waitForVisible(locator); elm.clear(); elm.sendKeys(text);
	 * ReportManager.logInfo("Successfully Entered text - " + text); }
	 */
	

	Actions action = new Actions(DriverFactory.getInstance().getWebDriver());

	/**
	 * =============================================================================
	 * Method: waitForVisible | Author: Rajesh Buddha | Date:16 Jan 2020 |
	 * Description: This method wait for element it will check every 5 sec its
	 * present or not until 60 sec | Parameters: locator | Return: element
	 * =============================================================================
	 */
	@SuppressWarnings("deprecation")
	public WebElement waitForVisible(By locator) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getWebDriver(), 100);
		wait.pollingEvery(5, TimeUnit.SECONDS);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}



	/**
	 * =============================================================================
	 * Method: Click | Author: Rajesh Buddha | Date:16 Jan 2020 | Description: This
	 * method click on element | Parameters: locator, info | Return: none
	 * =============================================================================
	 */
	public void Click(By locator, String info) {
		WebElement elm = waitForVisible(locator);
		elm.click();
		ReportManager.logInfo("Clicked on -: " + info);
		//LogClass.loginfo("Successfully clicked on -"+ info);
	}
	
	
	
	/**
	 * =============================================================================
	 * Method: sendKeys | Author: Rajesh Buddha | Date:16 Jan 2020 | Description:
	 * This method enter text input text using element | Parameters: locator, text |
	 * Return: none
	 * =============================================================================
	 */
	public void sendKeys(By locator, String text) {
		WebElement elm = waitForVisible(locator);
		elm.click();
		elm.sendKeys(text);
		ReportManager.logInfo("Entered text -: "+" <b style=\"color:green;\"> "+text+"</b>");
		//LogClass.loginfo(info+" :"+text);
	}

	/**
	 * =============================================================================
	 * Method: clearAndSendKeys | Author: Rajesh Buddha | Date:16 Jan 2020 |
	 * Description: This method clear text in text box after that enter text using
	 * element | Parameters: locator, text | Return: none
	 * =============================================================================
	 */
	public void clearAndSendKeys(By locator, String text) {
		WebElement elm = waitForVisible(locator);
		elm.clear();
		elm.sendKeys(text);
		ReportManager.logInfo("Successfully Entered text -<b style=\"color:green;\"> " + text+"</b>");
		//LogClass.loginfo("Successfully Entered text - " + text);
	}

	
	/**
	 * =============================================================================
	 * Method: getText | Author: Rajesh Buddha | Date:16 Jan 2020 | Description:
	 * This method get the text of element | Parameters: locator | Return: elmText
	 * =============================================================================
	 */
	public String getText(By locator) {
		WebElement elm = waitForVisible(locator);
		String elmText = elm.getText();
		ReportManager.logInfo("Successfully get text - <b style=\"color:green;\">" + elmText+"</b>");
		System.out.println("Successfully get text - " + elmText);
		//LogClass.loginfo("Successfully get text - " + elmText);
		return elmText;
	}
	
	/**
	 * =============================================================================
	 * Method: pressKeyboardValues | Author: Rajesh Buddha | Date:16 Jan 2020 |
	 * Description: This method meant for static wait | Parameters: locator, text |
	 * Return: none
	 * =============================================================================
	 * 
	 * @throws InterruptedException
	 */
	public void pressKeyboardValues(Keys value) throws InterruptedException {
		action.sendKeys(value).build().perform();
		ReportManager.logInfo("Successfully performed keyboard action - <b style=\"color:green;\">" + value+"</b>");
		//LogClass.loginfo("Successfully performed keyboard action - " + value);
	}

		
	/**
	 * =============================================================================
	 * Method: getText | Author: Rajesh Buddha | Date:16 Jan 2020 | Description:
	 * This method get the text of element | Parameters: locator | Return: elmText
	 * =============================================================================
	 */
	public int getTextByInt(By locator) {
		WebElement elm = waitForVisible(locator);
		String elmText = elm.getText();
		int elmIntTxt=Integer.parseInt(elmText);
		ReportManager.logInfo("Successfully get Integer text - <b style=\"color:green;\">" + elmIntTxt+"</b>");
		System.out.println("Successfully get Integer text- " + elmIntTxt);
		return elmIntTxt;
	}

	
	
	/**
	 * =============================================================================
	 * Method: getElementSizeUsingFindElements | Author: Rajesh Buddha | Date:16 Jan
	 * 2020 | Description: This method returns size of elements by using
	 * findelements | Parameters: locator, text | Return: none
	 * =============================================================================
	 * 
	 * @param size
	 * @param locator
	 * @param xcordinate
	 * @param ycordinate
	 * 
	 * @param fromLocator
	 * @param toLocator
	 * 
	 * @throws InterruptedException
	 */
	public List<WebElement> getElementSizeUsingFindElements(By locator) throws InterruptedException {
		List<WebElement> lst_Elm = DriverFactory.getInstance().getWebDriver().findElements(locator);
		ReportManager.logInfo("Captured element size is - " + lst_Elm.size());
		return lst_Elm;
	}
	
	
	

	public boolean isDisplayed(By locator, String info) {
		WebElement elm = waitForVisible(locator);
		boolean isPresent = elm.isDisplayed();
		if (isPresent) {
			ReportManager.logInfo("Successfully element displyed: " + info);
		} else {
			ReportManager.logInfo("element not displyed: " + info);
		}
		return isPresent;
	}

	

	public void verifyText(String actualText, String expectedText) {
		ReportManager.logInfo("Actual Text - " + actualText);
		ReportManager.logInfo("Expected Text - " + expectedText);
		assertEquals(actualText, expectedText);
	}

	public String getAttributeValue(By locator, String name) {
		WebElement elm = waitForVisible(locator);
		String attributeText = elm.getAttribute(name);
		ReportManager.logInfo("Successfully get attribute text - " + attributeText);
		return attributeText;
	}

	public boolean isScrollPresent() throws Exception {
		String execScript = "return document.documentElement.scrollHeight>document.documentElement.clientHeight;";
		Boolean isScroll_Present = (Boolean) (scrollBarPresent.executeScript(execScript));
		return isScroll_Present;

	}
	
	public boolean selectByVisibleText(By locator, String value) {
		Select sel = new Select(DriverFactory.getInstance().getWebDriver().findElement(locator));
		sel.selectByVisibleText(value);
		sel = new Select(DriverFactory.getInstance().getWebDriver().findElement(locator));
		
		if (sel.getFirstSelectedOption().getText().equalsIgnoreCase(value)) {
			
			ReportManager.logInfo("Selected from drop down - <b style=\"color:green;\">"+value+"</b>");
			return true;
		} 
		else {
			return false;
		}
	}
	
	public static boolean clickJSElm(WebElement elm, String text) {
		Object obj = ((JavascriptExecutor) DriverFactory.getInstance().getWebDriver()).executeScript("arguments[0].click();", elm);
		ReportManager.logInfo("Clicked on: " + text);
		return obj == null;
	}
	
	/**
	 * @param locator
	 * @return
	 */
	public List<WebElement> getListOfWebElements(By locator) {
		
		List<WebElement> list_Elm = DriverFactory.getInstance().getWebDriver().findElements(locator);
		return list_Elm;
	}
	
	

	
	//Haritha
	
	public boolean isEnabled(By locator, String info) {
		WebElement elm = waitForVisible(locator);
		boolean Enabled = elm.isEnabled();
		if (Enabled) {
			ReportManager.logInfo("Element is Enabled: " + info);
		} else {
			ReportManager.logInfo("Element is not Enabled: " + info);
		}
		return Enabled;
	}
	
	
	
	public boolean isSelected(By locator, String info) {
		WebElement elm = waitForVisible(locator);
		boolean Selected = elm.isEnabled();
		if (Selected) {
			ReportManager.logInfo("Element is Selected: " + info);
		} else {
			ReportManager.logInfo("Element is not Selected: " + info);
		}
		return Selected;
	}
	
	
	}
	

