package com.testNg;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNgTestCasesPractice {
	WebDriver driver;

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

		driver.findElement(By.name("bSubmit")).click();
		driver.findElement(By.name("QTY_TENTS")).clear();
		driver.findElement(By.name("QTY_TENTS")).sendKeys("5");
		String OnlineCatalogText = driver.findElement(By.xpath("//h1[contains(text(),'OnLine Catalog')]")).getText();
		System.out.println(OnlineCatalogText);

		String OnlineCatalogUnitPrice = driver
				.findElement(By.xpath("//strong[contains(text(),'Dome Tent')]/../../following-sibling::td")).getText();
		System.out.println(OnlineCatalogUnitPrice);

		driver.findElement(By.name("bSubmit")).click();

		String placeOrderUnitPrice = driver
				.findElement(
						By.xpath("(//strong[contains(text(),'3 Person Dome Tent')]/../../following-sibling::td)[2]"))
				.getText();
		System.out.println(placeOrderUnitPrice);

		String totalPlaceOrderPrice = driver
				.findElement(
						By.xpath("(//strong[contains(text(),'3 Person Dome Tent')]/../../following-sibling::td)[3]"))
				.getText();

		totalPlaceOrderPrice = totalPlaceOrderPrice.substring(2).trim();

		Float totalPlaceOrderPrice1 = Float.parseFloat(totalPlaceOrderPrice);
		System.out.println("totalPlaceOrderPrice  " + totalPlaceOrderPrice1);

		placeOrderUnitPrice = placeOrderUnitPrice.substring(2).trim();
		System.out.println("placeOrderUnitPrice  " + placeOrderUnitPrice);

		Float CaluculatedTotalPrice = Float.parseFloat(placeOrderUnitPrice) * 5;
		System.out.println("CaluculatedTotalPrice " + CaluculatedTotalPrice);

		SoftAssert obj=new SoftAssert();
		obj.assertEquals(CaluculatedTotalPrice, totalPlaceOrderPrice1);
		
		String ShippingHandle = driver.findElement(By.xpath(
				"(//strong[contains(text(),'3 Person Dome Tent')]/../../following-sibling::td)[3]/../following-sibling::tr[2]/td[2]"))
				.getText();
		ShippingHandle = ShippingHandle.substring(2).trim();
		System.out.println("ShippingHandle  " + ShippingHandle);

		String SalesTax = driver.findElement(By.xpath(
				"(//strong[contains(text(),'3 Person Dome Tent')]/../../following-sibling::td)[3]/../following-sibling::tr[3]/td[2]"))
				.getText();
		SalesTax = SalesTax.substring(2).trim();
		System.out.println("SalesTax  " + SalesTax);

		CaluculatedTotalPrice = CaluculatedTotalPrice + Float.parseFloat(ShippingHandle) + Float.parseFloat(SalesTax);
		System.out.println("CaluculatedTotalPrice  " + CaluculatedTotalPrice);

		String GrandTotalPrice = driver.findElement(By.xpath(
				"(//strong[contains(text(),'3 Person Dome Tent')]/../../following-sibling::td)[3]/../following-sibling::tr[4]/td[2]"))
				.getText();
		GrandTotalPrice = GrandTotalPrice.substring(2).trim();
		Float GrandTotalPrice1 = Float.parseFloat(GrandTotalPrice);
		System.out.println("GrandTotalPrice1  " + GrandTotalPrice1);

		Assert.assertEquals(CaluculatedTotalPrice, GrandTotalPrice1);

		driver.findElement(By.name("bSubmit")).click();
		driver.findElement(By.name("bSubmit")).click();
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
		driver.close();

	};

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
	}

	@AfterTest
	public void afterTest() {
	}

	@BeforeSuite
	public void beforeSuite() {

		System.out.println();

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("http://demo.borland.com/gmopost/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@AfterSuite
	public void afterSuite() {
	}

}
