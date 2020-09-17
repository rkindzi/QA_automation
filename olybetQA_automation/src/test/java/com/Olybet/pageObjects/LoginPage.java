package com.Olybet.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Olybet.testCases.TxtFiles;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	private static By TabPrisijungti = By
			.cssSelector("div.flex.items-center.py-2.cursor-pointer.h-full.justify-between.flex-wrap.text-white.px-3");
	private static By UserNameInput = By.id("user_name");
	private static By PasswordInput = By.id("password");
	private static By ButtonPrisijungti = By
			.cssSelector("button.btn.btn-green.w-full.items-center.hidden.md\\:block.mt-2.text-sm.md\\:h-10");
	private static By LanguageDropdown = By
			.cssSelector("div.flex.items-center.py-2.cursor-pointer.h-full.justify-between.flex-wrap.text-white.px-4");
//	private static By LanguageEn = By.cssSelector(
//			"div.flex.border-b.border-red-dark.justify-end.hidden.xl\\:flex > div:nth-child(5) > div.absolute.w-full.z-40.bg-white.shadow-md.cursor-pointer > div > div:nth-child(1)");
	private static By CookieApprove = By.id("onesignal-slidedown-allow-button");
	private static By ClientIcon = By.cssSelector(
			"div.flex.border-b.border-red-dark.justify-end.hidden.xl\\:flex > div:nth-child(4) > div.flex.items-center.py-2.cursor-pointer.h-full.justify-between.flex-wrap.text-white.px-3");
	private static By UserProfile = By.cssSelector(
			"div.flex.border-b.border-red-dark.justify-end.hidden.xl\\:flex > div:nth-child(4) > div.absolute.w-full.z-40.bg-white.shadow-md.cursor-pointer > div > div > div > div:nth-child(1) > a:nth-child(1)");
	private static By ContactInformation = By.cssSelector("div.flex.flex-row.w-full div.flex.flex-col.w-full.px-8");
	private static By ButtonChangePass = By.cssSelector(
			"div.flex.p-4.border.flex-col.w-full.mb-4.md\\:ml-3 > div.flex.flex-col.w-full > div.from-group > button");
	private static By CorrectPassInput = By.cssSelector(
			"body > div.flex.flex-col > div > div.shadow-lg.container > div.bg-white > div > div.flex.flex-col.w-full.w-3\\/4.pl-0.mb-6.pl-6 > div.relative.min-h-64.pt-3.min-h-128 > div.flex.flex-col.py-4.px-0 > div:nth-child(3) > div > div.overflow-y-scroll.scrolling-touch.md\\:overflow-y-hidden.h-full.p-4 > div > div > div:nth-child(1) > div > div > input");
	private static By NewtPassInput = By.cssSelector(
			"body > div.flex.flex-col > div > div.shadow-lg.container > div.bg-white > div > div.flex.flex-col.w-full.w-3\\/4.pl-0.mb-6.pl-6 > div.relative.min-h-64.pt-3.min-h-128 > div.flex.flex-col.py-4.px-0 > div:nth-child(3) > div > div.overflow-y-scroll.scrolling-touch.md\\:overflow-y-hidden.h-full.p-4 > div > div > div:nth-child(2) > div > div > input");
	private static By ButtonConfirm = By.cssSelector(
			"body > div.flex.flex-col > div > div.shadow-lg.container > div.bg-white > div > div.flex.flex-col.w-full.w-3\\/4.pl-0.mb-6.pl-6 > div.relative.min-h-64.pt-3.min-h-128 > div.flex.flex-col.py-4.px-0 > div:nth-child(3) > div > div.overflow-y-scroll.scrolling-touch.md\\:overflow-y-hidden.h-full.p-4 > div > div > div:nth-child(3) > button");
	private static By LinkTextAfterPasswordChange = By.cssSelector("body > div.flex.flex-col > div > div.shadow-lg.container > div.bg-white > div > div.flex.flex-col.w-full.w-3\\/4.pl-0.mb-6.pl-6 > div.relative.min-h-64.pt-3.min-h-128 > div.flex.flex-col.py-4.px-0 > div:nth-child(3) > div > div.flex.flex-shrink-0.h-14.relative.border-grey.border-b.font-semibold.leading-none.align-middle > div > div");
	private static By LogoutLink = By.cssSelector("div.flex.border-b.border-red-dark.justify-end.hidden.xl\\:flex > div:nth-child(4) > div.absolute.w-full.z-40.bg-white.shadow-md.cursor-pointer > div > div > div > div:nth-child(2) > a:nth-child(4) > div > div");
	private static By LTflag = By.xpath("//img[contains(@src,'img/flags/lt.png')]");
	private static By Enflag = By.xpath("//img[contains(@src,'img/flags/en.png')]");
	private static By Ruflag = By.xpath("//img[contains(@src,'img/flags/ru.png')]");
	
	public void LoginToSystem(String UserName, String Password) {
		ldriver.findElement(TabPrisijungti).click();
		ldriver.findElement(UserNameInput).sendKeys(UserName);
		ldriver.findElement(PasswordInput).sendKeys(Password);
		ldriver.findElement(ButtonPrisijungti).click();
		CheckIfLoginSuccess();
	}

	public void CheckIfLoginSuccess() {
		if (ldriver.getTitle().equals("Mano profilis | Olybet - Lažybos")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(false);
		}
	}

	public void ChangeLanguage() throws InterruptedException {
		Thread.sleep(4000);
		ldriver.findElement(CookieApprove).click();
		if(ldriver.findElement(LTflag).isDisplayed() || ldriver.findElement(Ruflag).isDisplayed()) {
			ldriver.findElement(LanguageDropdown).click();
			ldriver.findElement(Enflag).click();	
		} 
	}

	public void OpenClientInformation() {
		ldriver.findElement(ClientIcon).click();
		ldriver.findElement(UserProfile).click();

	}

	public void CheckInformationAboutClient() {
		String ClientContactInfo = ldriver.findElement(ContactInformation).getText();
		Assert.assertEquals(ClientContactInfo, "Test770089\n" + "User770089\n" + "30101010007\n" + "-\n"
				+ "1901-01-01\n" + "Lithuania\n" + "Lithuania");
	}

	public void ChangePassword(String newPass, String oldPass) {
		ldriver.findElement(ButtonChangePass).click();
		ldriver.findElement(CorrectPassInput).sendKeys(oldPass);
		ldriver.findElement(NewtPassInput).sendKeys(newPass);
		ldriver.findElement(ButtonConfirm).click();
		
		TxtFiles txtFiles = new TxtFiles();
		txtFiles.writeFile(newPass);
		
		ldriver.findElement(LinkTextAfterPasswordChange).click();
	}
	
	public void Logout() {
		ldriver.findElement(ClientIcon).click();	
		ldriver.findElement(LogoutLink).click();
	}
	
	

}
