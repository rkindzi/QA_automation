package com.Olybet.testCases;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {

	public String OlybetUrl = "https://www.olybet.lt/";
	public String userName = "assignmenttaskt@oit.lt";
	public String password;
	public static WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		Dimension size = new Dimension(1920, 1080);
		driver.manage().window().setSize(size);
		password = new TxtFiles().readFile();
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		driver.quit();
	}

}