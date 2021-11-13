package com.testNg;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNg1 {
	public WebDriver driver;
	
	  @Test (priority=1)
	  public void testcase1() {
		  System.out.println("inside testcase1");
		  Assert.assertEquals("Mahendra","Mahendra");
	  }
	  
	  @Test(priority=-11)
	  public void Testcase2() {
		  System.out.println("inside testcase2");
		  driver=new ChromeDriver();
	  }
	  
	  @Test (priority=-11,invocationCount=4,dependsOnMethods= {"testcase1"},enabled=false)
	  public void testcase3() {
		  System.out.println("inside testcase3");
	  }
	  
	  @Test
	  public void testcase4() {
		  System.out.println("inside testcase4");
	  }
	  
	  @Test
	  public void Bestcase5() {
		  System.out.println("inside testcase5");
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
		  
		  System.setProperty("webDriver.chrome.driver", "");
		  driver=new ChromeDriver();
		  
	  }

	  @AfterTest
	  public void afterTest() {
		  System.out.println("inside afterTest");
	  }

	  @BeforeSuite
	  public void beforeSuite() {
		  System.out.println("inside beforeSuite");
	  }

	  @AfterSuite
	  public void afterSuite() {
		  System.out.println("inside afterSuite");
	  }
}
