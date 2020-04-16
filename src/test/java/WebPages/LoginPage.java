package WebPages;

import org.openqa.selenium.By;
import WebUtil.WebActions;

public class LoginPage {

	WebActions webActions = new WebActions();

	// =====================Login=====================
	By userName = By.id("logusername");
	By passWord = By.id("logpassword");
	By loginButton = By.id("loginid");

	// =================Dashboard=====================
	By headingOnPage = By.xpath("//h1");
	
	// ====================Logout=====================
	By profileImg = By.id("profileImg1");
	By logoutButton = By.linkText("Sign out");

	public void Login(String LoginUserName, String LoginPassword) throws InterruptedException {
		webActions.sendKeys(userName, LoginUserName);
		webActions.sendKeys(passWord, LoginPassword);
		webActions.Click(loginButton, "Sign In");
		Thread.sleep(3000);
		String actualHeading = webActions.getText(headingOnPage);
		webActions.verifyText(actualHeading, "Dashboard");
	}
	public void Logout() throws InterruptedException {
		Thread.sleep(3000);
		webActions.Click(profileImg, "User account name");
		webActions.Click(logoutButton, "Sign Out");
	}

}
