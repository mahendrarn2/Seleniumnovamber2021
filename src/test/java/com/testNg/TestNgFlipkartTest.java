package com.testNg;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNgFlipkartTest {
	WebDriver driver;
	
	@Test
	
	public void ValidateFlipkartTitle() {
		
		String FlipkartTitle=driver.getTitle();
		
		System.out.println(FlipkartTitle);
		Assert.assertEquals(FlipkartTitle, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		
	}
	
  @Test 
  public void loginToFlipKartAndLogOut() throws InterruptedException {
	  
	  //driver.findElement(By.name("bSubmit")).click();
	  //driver.findElement(By.name("QTY_TENTS")).clear();
	  driver.findElement(By.xpath("//span[contains(text(),'Enter Email/Mobile number')]/../preceding-sibling::input")).sendKeys("9113934576");
	  driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys("Mahi.9177");
	  driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button/span")).click();
	  String URL = driver.getCurrentUrl();
	  System.out.println(URL);
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("(//div[contains(text(),'Grocery')]/../../following-sibling::div/a/div)[2]")).click();
		
		  Thread.sleep(5000); WebElement ele = driver.findElement(By.xpath("//body/div[@id='container']/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/*[1]"));
		  
		  //Creating object of an Actions class 
		  Actions action = new Actions(driver);
		  
		  //Performing the mouse hover action on the target element.
		  action.moveToElement(ele).perform();
		 
	
	Thread.sleep(5000);
	driver.findElement(By.xpath("//div[contains(text(),'Logout')]")).click();
	
	Thread.sleep(5000);
	driver.findElement(By.xpath("//span[contains(text(),'Enter Email/Mobile number')]/../../../../../../../preceding-sibling::button")).click();
	  
	  //driver.close();
	  //driver.navigate().back();
	  //driver.navigate().forward();
	  //driver.navigate().refresh();
	  System.out.println("Thread Id" + Thread.currentThread().getId());
	  
	  
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
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
	  
	  System.out.println();
	  
	  WebDriverManager.chromedriver().setup();
	  
	  driver= new ChromeDriver();
	  driver.get("https://www.flipkart.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  
  }

  @AfterSuite
  public void afterSuite() {
  }

}
