package com.Olybet.testCases;

import org.testng.annotations.Test;

import com.Olybet.pageObjects.LoginPage;

public class LoginTestsCases extends Base {
	@Test
	public void loginTest() throws InterruptedException {
		driver.navigate().to(OlybetUrl);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.LoginToSystem(userName, password);
		loginPage.ChangeLanguage();
		loginPage.OpenClientInformation();
		loginPage.CheckInformationAboutClient();
		loginPage.ChangePassword(new PasswordGenerator().getNewPassword(10), password);
		loginPage.Logout();
	}
}
