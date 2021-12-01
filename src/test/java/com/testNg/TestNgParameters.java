package com.testNg;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNgParameters {
	@Parameters({ "BrowserName" })
	@Test
	public void openBrowser(String BrowserName) {
		System.out.println("Inside test method");
		System.out.println("Browser passed as :-" + BrowserName);
		WebDriver driver = null;
		if(BrowserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(BrowserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
	}

	@Parameters({ "UserName", "Passcode" })
	@Test
	public void FillLoginForm(String UserName , String Passcode) {
		System.out.println("Inside FillLoginForm");
		System.out.println("Browser passed as :-" + UserName);
		System.out.println("Browser passed as :-" + Passcode);
	}
	
	@BeforeSuite
	@Parameters({ "BrowserName" })
	public void beforeSuite(String BrowserName) {
		System.out.println("Inside before suite");
		System.out.println("browser passed as :-" + BrowserName);
	}

}
