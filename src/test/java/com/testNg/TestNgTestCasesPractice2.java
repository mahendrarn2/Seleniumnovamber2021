package com.testNg;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utility.ORep;
import com.utility.constants;
import com.utility.library;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNgTestCasesPractice2 extends library {

	/*
	 * @Test
	 * 
	 * public void ValidateFlipkartTitle() {
	 * 
	 * 
	 * String FlipkartTitle=driver.getTitle();
	 * 
	 * System.out.println(FlipkartTitle); Assert.assertEquals(FlipkartTitle,
	 * "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"
	 * );
	 * 
	 * }
	 */

	@Test(priority = 0)
	public void ValidateEnterGMOonline() {

		library.findElementByLocator(ORep.ValidateEnterGMOonlineButtonWithName).click();
		library.findElementByLocator(ORep.TableColumnFieldsClearAndSendKeys).clear();
		library.findElementByLocator(ORep.TableColumnFieldsClearAndSendKeys).sendKeys("5");
		String OnlineCatalogText = library.findElementByLocator(ORep.OnlineCatalogText).getText();
		System.out.println(OnlineCatalogText);

		String OnlineCatalogUnitPrice = library.findElementByLocator(ORep.OnlineCatalogUnitPrice).getText();
		System.out.println(OnlineCatalogUnitPrice);

		library.findElementByLocator(ORep.ValidateEnterGMOonlineButtonWithName).click();

		String placeOrderUnitPrice = library.findElementByLocator(ORep.placeOrderUnitPrice).getText();
		System.out.println(placeOrderUnitPrice);

		String totalPlaceOrderPrice = library.findElementByLocator(ORep.totalPlaceOrderPrice).getText();

		totalPlaceOrderPrice = totalPlaceOrderPrice.substring(2).trim();

		Float totalPlaceOrderPrice1 = Float.parseFloat(totalPlaceOrderPrice);
		System.out.println("totalPlaceOrderPrice  " + totalPlaceOrderPrice1);

		placeOrderUnitPrice = placeOrderUnitPrice.substring(2).trim();
		System.out.println("placeOrderUnitPrice  " + placeOrderUnitPrice);

		Float CaluculatedTotalPrice = Float.parseFloat(placeOrderUnitPrice) *constants.CaluculatedTotalPrice1;
		System.out.println("CaluculatedTotalPrice " + CaluculatedTotalPrice);

		SoftAssert obj = new SoftAssert();
		obj.assertEquals(CaluculatedTotalPrice, totalPlaceOrderPrice1);

		String ShippingHandle = library.findElementByLocator(ORep.ShippingHandle).getText();
		ShippingHandle = ShippingHandle.substring(2).trim();
		System.out.println("ShippingHandle  " + ShippingHandle);

		String SalesTax = library.findElementByLocator(ORep.SalesTax).getText();
		SalesTax = SalesTax.substring(2).trim();
		System.out.println("SalesTax  " + SalesTax);

		CaluculatedTotalPrice = CaluculatedTotalPrice + Float.parseFloat(ShippingHandle) + Float.parseFloat(SalesTax);
		System.out.println("CaluculatedTotalPrice  " + CaluculatedTotalPrice);

		String GrandTotalPrice = library.findElementByLocator(ORep.GrandTotalPrice).getText();
		GrandTotalPrice = GrandTotalPrice.substring(2).trim();
		Float GrandTotalPrice1 = Float.parseFloat(GrandTotalPrice);
		System.out.println("GrandTotalPrice1  " + GrandTotalPrice1);

		Assert.assertEquals(CaluculatedTotalPrice, GrandTotalPrice1);

		library.findElementByLocator(ORep.ValidateEnterGMOonlineButtonWithName).click();
		library.findElementByLocator(ORep.ValidateEnterGMOonlineButtonWithName).click();
		System.out.println("Thread Id" + Thread.currentThread().getId());

		OnlineCatalogUnitPrice = OnlineCatalogUnitPrice.substring(2).trim();
		System.out.println("OnlineCatalogUnitPrice  " + OnlineCatalogUnitPrice);
		obj.assertAll();

	}

	@Test(priority = 1, dependsOnMethods = { "ValidateEnterGMOonline" })
	public void VerifyalertBox() throws InterruptedException {
		String alert = driver.switchTo().alert().getText();
		System.out.println(alert);
		driver.switchTo().alert().accept();
		System.out.println("Thread Id" + Thread.currentThread().getId());
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(5000);
		driver.navigate().forward();
		Thread.sleep(5000);
		// driver.navigate().refresh();

	}

	@Test(priority = 2)

	public void verifyTheCalculations() throws InterruptedException {

		Thread.sleep(5000);
		// driver.close();

	};

	@Test(priority = 3)

	public void HandlingFrames() {

		driver.navigate().to(propObj.getProperty("iFramesURL"));
		WaitForPageLoad();
		library.SwitchToFramesUsingIdOrName("singleframe");
		library.findElementByLocator(ORep.HandlingFramesField).sendKeys("I am entering the text");
		driver.switchTo().defaultContent();
		library.findElementByLocator(ORep.iFrameWithInAnFrameButton).click();
		WebElement parentFrameElement = library.findElementByLocator(ORep.parentFrameElement);
		library.SwitchToFramesUsingWebElement(parentFrameElement);
		WebElement childFrameElement = library.findElementByLocator(ORep.childFrameElement);
		library.SwitchToFramesUsingWebElement(childFrameElement);
		library.findElementByLocator(ORep.HandlingFramesField).sendKeys("Hi I am entering the text");
		driver.switchTo().defaultContent();

	}

	@Test(priority =4 )
	public void HandlingWindows() {
		
		System.out.println("Inside HandlingWindows");
		driver.navigate().to(propObj.getProperty("WindowsURL"));
		WaitForPageLoad();
		Set<String> AllWindows=driver.getWindowHandles();
		
		for (String SingleWindow : AllWindows) {
			
			driver.switchTo().window(SingleWindow);
			String title=driver.getTitle();
			System.out.println(title);
			
			if (title.equals("Cognizant")) {
				driver.manage().window().maximize();
				
			}else if (title.equals("Tech Mahindra")){
				driver.manage().window().maximize();
				
			}else if (title.equals("Tech Mahindra")) {
				driver.manage().window().maximize();
				
			}
		}
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
		library.LaunchBrowser();

	}

	@AfterTest
	public void afterTest() {
	}

	@BeforeSuite
	public void beforeSuite() {

		System.out.println();

		/*
		 * WebDriverManager.chromedriver().setup();
		 * 
		 * 
		 * driver = new ChromeDriver(); driver.get("http://demo.borland.com/gmopost/");
		 * driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 */

		try {
			library.ReadPropertyFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

}
