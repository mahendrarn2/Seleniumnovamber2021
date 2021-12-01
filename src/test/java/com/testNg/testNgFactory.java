package com.testNg;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Factory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class testNgFactory {
	
	private String param="";
	
	//Constructor with one argument
	public testNgFactory(String param) {
		this.param=param;
	}
	
  @Test
  public void testCase1() {
	  
	  System.out.println("Inside test case1 parameter value : " + param);
  }
  
  @Test
  public void testCase2() {
	  System.out.println("Inside test case2 parameter value : " + param);
  }
  
  @Factory
  
  public Object[] factoryMethod() {
	  return new Object[] {
			  new testNgFactory("Hello"),
			  new testNgFactory("Hi")
			  
	  };
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
