package com.testNg;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utility.library;

import io.github.bonigarcia.wdm.WebDriverManager;
import sun.net.ftp.FtpDirEntry.Type;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AlertBoxTesting {

	WebDriver driver;

	@Test(priority = 0)
	public void ValidateAlerts() throws Exception {

		// Alert Box

		driver.navigate().to("https://demoqa.com/alerts");
		WaitForPageLoad();
		driver.findElement(By.xpath("//button[@id='alertButton']")).click();
		Alert obj = driver.switchTo().alert();
		System.out.println(obj.getText());
		obj.accept();

		driver.findElement(By.id("confirmButton")).click();
		Alert obj1 = driver.switchTo().alert();
		System.out.println(obj1.getText());
		Thread.sleep(5000); // obj1.accept(); obj1.dismiss();

		String ActualResults = driver.findElement(By.id("confirmResult")).getText();
		// String ExpectedResult="You selected Cancel";

		SoftAssert sft = new SoftAssert();
		sft.assertEquals(ActualResults, "You selected Cancel");

		driver.findElement(By.id("promtButton")).click();
		Alert obj2 = driver.switchTo().alert();
		System.out.println(obj2.getText());
		obj2.sendKeys("Mahendra");
		obj.accept();
		String ActualPromtResults = driver.findElement(By.id("promptResult")).getText();
		Assert.assertEquals(ActualPromtResults, "You entered Mahendra");

		takeScreenshot(driver);

		sft.assertAll();

	}
	
	@Test (priority=2)
	public void HandlingFrames() {
	System.out.println("Inside HandlingFrames");
	driver.navigate().to("https://netbanking.hdfcbank.com/netbanking/");
	WebElement element=driver.findElement(By.xpath("/html/frameset/frameset/frame"));
	driver.switchTo().frame(element);
	driver.findElement(By.xpath("//input[@name='fldLoginUserId']")).sendKeys("Mahi");
	driver.findElement(By.xpath("//a[text()='CONTINUE']")).click();
	//driver.switchTo().defaultContent();
	driver.findElement(By.xpath("//*[@id=\"fldPasswordDispId\"]")).sendKeys("Mahi");
		
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeTest
	public void beforeTest() {
		/* library.LaunchBrowser(); */
	}

	@AfterTest
	public void afterTest() {
	}

	@BeforeSuite
	public void beforeSuite() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("http://demo.borland.com/gmopost/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/*
		 * try { library.ReadPropertyFile(); } catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

	}

	@AfterSuite
	public void afterSuite() {

	}

	// Helper methods
	public void WaitForPageLoad() {

		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {

			public Boolean apply(WebDriver driver) {

				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}

		};

		// Explicit wait -->Applicable for one webElement
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(pageLoadCondition);

	}

	public static String takeScreenshot(WebDriver driver) throws Exception {

		File Source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String dateName = new SimpleDateFormat("YYYYMMddhhmmss").format(new Date());

		System.out.println("dateName");
		String destination = System.getProperty("user.dir") + "//src//test//resources//ScreenShots//" + dateName
				+ "captured.png";
		FileUtils.copyFile(Source, new File(destination));
		return destination;

	}

	public static String takeScreenshot(WebDriver driver, String name) throws Exception {

		File Source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String dateName = new SimpleDateFormat("YYYYMMddhhmmss").format(new Date());

		System.out.println("dateName");
		String destination = System.getProperty("user.dir") + "//src//test//resources//ScreenShots//" + dateName + name
				+ "captured.png";
		FileUtils.copyFile(Source, new File(destination));
		return destination;

	}

}