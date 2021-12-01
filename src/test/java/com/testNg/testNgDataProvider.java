package com.testNg;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class testNgDataProvider {
  @Test(dataProvider = "dp")
  public void add(String user, String pwd) {
	  System.out.println("inside test case add");
	  System.out.println("User: "+user);
	  System.out.println("Pwd : " + pwd);
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before Method executed");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After Method executed");
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "user1", "pwd1" },
      new Object[] { "user2", "pwd2" },
      new Object[] { "user3", "pwd3" },
    };
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before class executed");
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
