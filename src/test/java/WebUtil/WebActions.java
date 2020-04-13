package WebUtil;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.DriverFactory;
import Utilities.ReportManager;

public class WebActions {

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
		ReportManager.logInfo("Successfully clicked on - " + info);
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
		ReportManager.logInfo("Successfully Entered text - "+" <b style=\"color:green;\"> : "+text+"</b>");
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
		ReportManager.logInfo("Successfully captured elemnt size is - " + lst_Elm.size());
		return lst_Elm;
	}
}
