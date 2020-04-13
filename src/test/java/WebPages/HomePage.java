package WebPages;

import org.openqa.selenium.By;
import Utilities.ReportManager;
import WebUtil.WebActions;

public class HomePage {

	WebActions webActions = new WebActions();

	// =====================Login=====================
	By userName = By.id("logusername");
	By passWord = By.id("logpassword");
	By login = By.id("loginid");

	// ====================Logout=====================
	By profileImg = By.id("profileImg1");
	By logout = By.linkText("Sign out");

	public void Login(String username, String password) {
		webActions.sendKeys(userName, username);
		webActions.sendKeys(passWord, password);
		webActions.Click(login, "login");

	}

	public void Logout() throws InterruptedException {
		Thread.sleep(3000);
		webActions.Click(profileImg, "My account");
		webActions.Click(logout, "Logout");

	}

}
