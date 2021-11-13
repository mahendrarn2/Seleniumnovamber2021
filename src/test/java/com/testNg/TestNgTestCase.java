package com.testNg;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNgTestCase {

	WebDriver driver;

	@Test(priority = 0)
	public void ValidateGMOonlineLoadedSuccessfully() {

		System.out.println("inside testcase1");
		String GMOtitle = driver.getTitle();
		System.out.println(GMOtitle);
		Assert.assertEquals(GMOtitle, "Welcome to Green Mountain Outpost");
	}

	@Test(priority=1,dependsOnMethods= {"ValidateGMOonlineLoadedSuccessfully"})
	public void ValidateEnterGMOonline() {
		
		System.out.println("Indisde ValidateEnterGMOonline ");
		driver.findElement(By.name("bSubmit")).click();
		
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("inside beforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("inside afterMethod");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("inside beforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("inside afterClass");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("inside beforeTest");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("inside afterTest");
	}

	@BeforeSuite
	public void beforeSuite() {

		/*
		  WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
		 */
		
		/* WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver(); */
		
		WebDriverManager.edgedriver().setup();
		driver =new EdgeDriver();
		 
		driver.get("http://demo.borland.com/gmopost/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		System.out.println("inside beforeSuite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("inside afterSuite");
	}
}
