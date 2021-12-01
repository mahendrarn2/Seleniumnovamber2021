package com.testNg;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNgGroup {
  @Test (groups={"Sanity"})
  public void testMethodOne() {
	  System.out.println("Test method one belongs to Sanity");
  }
  
  @Test (groups={"Sanity","Regression"})
  public void testMethodTwo() {
	  System.out.println("Test method one belongs to Sanity and Regression");
  }
  

  @Test (groups={"Regression"})
  public void testMethodThree() {
	  System.out.println("Test method three belongs to Regression");
  }
  
  @Test (groups={"Sanity"})
  public void testMethodFour() {
	  System.out.println("Test method four belongs to Sanity");
  }
  
  @Test (groups={"Regression"})
  public void testMethodFive() {
	  System.out.println("Test method five belongs to Regression");
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
  }

  @AfterSuite
  public void afterSuite() {
  }

}
