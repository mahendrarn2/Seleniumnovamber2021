package com.testNg;

import java.util.HashMap;
import java.util.List;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.SelectorDocument.Selector;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.utility.ORep;
import com.utility.constants;
import com.utility.library;

public class TestNgTestCasesPractice2 extends library {

	HashMap<String, String> TestData=new HashMap<String,String>();
	
	private static final String priority = null;

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

		ExtTest=ExtReport.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
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

		Float CaluculatedTotalPrice = Float.parseFloat(placeOrderUnitPrice) * constants.CaluculatedTotalPrice1;
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
		ExtTest=ExtReport.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
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
		ExtTest=ExtReport.createTest(new Object() {}.getClass().getEnclosingMethod().getName());

		Thread.sleep(5000);
		// driver.close();

	};

	@Test(priority = 3)

	public void HandlingFrames() {
		
		ExtTest=ExtReport.createTest(new Object() {}.getClass().getEnclosingMethod().getName()); 
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

	@Test(priority = 4)
	public void HandlingWindows() {
		
		ExtTest=ExtReport.createTest(new Object() {}.getClass().getEnclosingMethod().getName()); 
		System.out.println("Inside HandlingWindows");
		driver.navigate().to(propObj.getProperty("WindowsURL"));
		WaitForPageLoad();
		
		String ParentWindow=driver.getWindowHandle();
		Set<String> AllWindows = driver.getWindowHandles();

		for (String SingleWindow : AllWindows) {

			driver.switchTo().window(SingleWindow);
			String title = driver.getTitle();
			System.out.println(title);

			if (title.equals("Tech Mahindra")) {
				driver.manage().window().maximize();
				driver.close();

			} 
				  else if (title.equals("Tech Mahindra")) {
				  driver.manage().window().maximize();
				  
				  }else if (title.equals("Jobs - Recruitment - Job Search - Employment -Job Vacancies - Naukri.com")) {
					  
				  }
				
		}
driver.switchTo().window(ParentWindow);
	}

	@Test(priority = 5)

	public void HandlingTables() {

		System.out.println("Inside of the HandlingTables");
		ExtTest=ExtReport.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
		driver.navigate().to(propObj.getProperty("WebTableURL"));
		WaitForPageLoad();
		List<WebElement> AllLastNames = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));
		System.out.println(AllLastNames);

		int size = AllLastNames.size();

		for (int i = 1; i <= size; i++) {

			String LastName = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + i + "]/td[3]")).getText();
			System.out.println(LastName);

			if (LastName.equals("Williamson")) {
				String Salary = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + i + "]/td[7]"))
						.getText();
				String Location = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + i + "]/td[5]"))
						.getText();
				String Position = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + i + "]/td[4]"))
						.getText();

				System.out.println("Employee Name is " + LastName + "His Salary is " + Salary + "office location is "
						+ Location + "And position is " + Position);

			}
		}

	}
	
	@Test (priority=6)
	public void MouseOperationRightClick() {
		System.out.println("Inside of the Mouse Operation Right Click");
		ExtTest=ExtReport.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
		driver.navigate().to(propObj.getProperty("mouseOperationRightClick"));
		WaitForPageLoad();
		
		WebElement rightClick=library.findElementByLocator(ORep.rightClick);
		
		Actions Obj=new Actions(driver);
		//Obj.contextClick(rightClick).build().perform();
		library.javaScriptExecutorScroolIntoViewAndDoubleClickWithContext(rightClick, Obj);
		
		library.findElementByLocator(ORep.CopytheRightClick).click();
		
		String SwitchToAlertText=library.SwitchToAlertAndReturnText();
		
		if(SwitchToAlertText.equals("clicked: copy")) {
			
			Assert.assertEquals(SwitchToAlertText, "clicked: copy");
			library.AlertAccept();
			
		}
		
		}
		
	@Test (priority=7)
	public void MouseOperationDoubleClick() {
		System.out.println("Inter MouseOperationDoubleClick ");
		ExtTest=ExtReport.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
		driver.navigate().to(propObj.getProperty("mouseOperationDoubleClick"));
		WaitForPageLoad();
		
		WebElement element=library.findElementByLocator(ORep.DoubleClick_frame);
		library.SwitchToFramesUsingWebElement(element);
		
		WebElement Ele=library.findElementByLocator(ORep.DoubleClickThe_block);
		Actions obj=new Actions(driver);
		library.javaScriptExecutorScroolIntoViewAndDoubleClick(Ele, obj);
	}
	
	@Test (priority=8)
	
	public void MouseOperationDragAndDrog() {
		System.out.println("MouseOperationDragAndDrog");
		ExtTest=ExtReport.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
		driver.navigate().to(propObj.getProperty("mouseOperationDragAndDrop"));
		WaitForPageLoad();
		
		WebElement frame=library.findElementByLocator(ORep.DragAndDropFrame);
		library.SwitchToFramesUsingWebElement(frame);
		
		WebElement drag=library.findElementByLocator(ORep.Drag);
		WebElement drop=library.findElementByLocator(ORep.Drop);
		
		library.DragAndDrop(drag, drop);
		String DropText=library.findElementByLocator(ORep.DropText).getText();
		Assert.assertEquals(DropText, "Dropped!");
		
	}
	
	@Test(priority=9)
	public void AlertBoxTesting() throws InterruptedException {
		System.out.println("Inside of AlertBoxTesting");
		ExtTest=ExtReport.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
		driver.navigate().to(propObj.getProperty("AlertURL1"));
		
		library.findElementByLocator(ORep.AlertButton).click();
		String str=library.SwitchToAlertAndReturnText();
		System.out.println(str);
		Thread.sleep(5000);
		library.AlertAccept();
		SoftAssert sft=new SoftAssert();
		sft.assertEquals(str, "I am alert");
		
		library.findElementByLocator(ORep.ConfirmButton).click();
		String SwitchtoConfirmButton=library.SwitchToAlertAndReturnText();
		System.out.println(SwitchtoConfirmButton);
		Thread.sleep(5000);
		library.AlertDismiss();
		sft.assertEquals(SwitchtoConfirmButton, "I am confirm");
		
		library.findElementByLocator(ORep.PromptButton).click();
		/*
		 * library.SwitchToAlert(); driver.switchTo().alert().sendKeys("Mahendra");
		 */
		Alert obj2 = driver.switchTo().alert();
		System.out.println(obj2.getText());
		obj2.sendKeys("Mahendra");
		//library.AlertSendKeys("Mahendra");
		Thread.sleep(5000);
		library.AlertAccept();
		
		sft.assertAll();	
		
	}
	
	@Test (priority=10)
	public void validateFileUpload() throws AWTException, InterruptedException {
		System.out.println("Inside validateFileUpload");
		ExtTest=ExtReport.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
		driver.navigate().to(propObj.getProperty("FileUpload"));
		WaitForPageLoad();
		
		WebElement element=library.findElementByLocator(ORep.Fileupload);
		library.javaScriptExecutorScroolIntoViewAndClick(element);
		
		//StringSelection objStringSelection = new StringSelection(System.getProperty("user.dir") + "\\C:\\Users\\MAHI\\Desktop\\main.txt");
		StringSelection objStringSelection = new StringSelection("\\C:\\Users\\MAHI\\Desktop\\main.txt");
		Clipboard objClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		objClipboard.setContents(objStringSelection, null);
		
		try {
		Transferable objTransferable = objClipboard.getContents(null);
		if (objTransferable.isDataFlavorSupported(DataFlavor.stringFlavor))
			System.out.println(objTransferable.getTransferData(DataFlavor.stringFlavor));
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		Robot objRobot=new Robot();
		objRobot.delay(250);
		objRobot.keyPress(KeyEvent.VK_ENTER);
		objRobot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		objRobot.keyPress(KeyEvent.VK_CONTROL);
		objRobot.keyPress(KeyEvent.VK_V);
		Thread.sleep(2000);
		objRobot.keyRelease(KeyEvent.VK_V);
		objRobot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		objRobot.keyPress(KeyEvent.VK_ENTER);
		objRobot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		
	}
	
	@Test (priority=11)
	
	public void FileDownload() throws InterruptedException {
		System.out.println("Inside of the FileDownload");
		ExtTest=ExtReport.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
		driver.navigate().to(propObj.getProperty("FileDownload1"));
		WaitForPageLoad();
		
		//driver.findElement(By.xpath("//*[@id=\"page-top\"]/ins[2]/ins[1]/span/svg/path")).click();
		Thread.sleep(5000);
		library.findElementByLocator(ORep.FileDownload).click();
		File objFile=new File(System.getProperty("user.dir"));
		File listOfFiles[]=objFile.listFiles();
		
		 boolean fileFound=false;
		 File obj_file=null;
		 
		for (File IndividualFileName : listOfFiles) {
			String FileName=IndividualFileName.getName();
			System.out.println(FileName);
			
			if(FileName.contains("samplefile")) {
				fileFound=true;
				obj_file=new File(FileName);
			}
		}
	Assert.assertTrue(fileFound, "Downloaded file is not found");
	obj_file.deleteOnExit();
		
	}
		
	@Test (priority=12)
	
	public void validateBrokenLinks() {
		
		System.out.println("Inside of the validateBrokenLinks");
		ExtTest=ExtReport.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
		driver.navigate().to(propObj.getProperty("BrokenLinks"));
		WaitForPageLoad();
		List<WebElement> AllLinks=library.findElementsByLocator(ORep.Links); 
		
		for(int i=1; i<AllLinks.size(); i++) {
			WebElement IndividualLink = AllLinks.get(i);
			String IndividualLinkUrl = IndividualLink.getAttribute("href");
			try {
				library.verifyinglinks(IndividualLinkUrl);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Test(priority=13)
	
	public void validateDataDriven() throws IOException {
		System.out.println("Inside of the validateDataDriven");
		ExtTest=ExtReport.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
		driver.navigate().to(propObj.getProperty("AutomationRegister"));
		WaitForPageLoad();
		try {
			FileInputStream objFileInputStream=new FileInputStream (new File(System.getProperty("user.dir") + "//src//test//resources//AutomationDemoSite.xlsx"));
			XSSFWorkbook objXSSFWorkbook=new XSSFWorkbook(objFileInputStream);
			XSSFSheet objXSSFSheet= objXSSFWorkbook.getSheet("TestData");
			int AllRows=objXSSFSheet.getLastRowNum();
			
			for (int rowNumber=1; rowNumber<=AllRows; rowNumber++) {
				TestData = readExcelFile(objXSSFSheet, rowNumber);
				if(TestData.get("RunMode").equals("Yes")){
				/*System.out.println(TestData.get("LastName"));
				System.out.println(TestData.get("FirstName"));
				System.out.println(TestData.get("Address"));*/
				
				library.findElementByLocator(ORep.RegisterFirstName).clear();
				library.findElementByLocator(ORep.RegisterFirstName).sendKeys(TestData.get("FirstName"));
				
				library.findElementByLocator(ORep.RegisterLastName).clear();
				library.findElementByLocator(ORep.RegisterLastName).sendKeys(TestData.get("LastName"));  
				
				library.findElementByLocator(ORep.RegisterAdress).clear();
				library.findElementByLocator(ORep.RegisterAdress).sendKeys(TestData.get("Address"));  
				
				library.findElementByLocator(ORep.RegisterEmailAdress).clear();
				library.findElementByLocator(ORep.RegisterEmailAdress).sendKeys(TestData.get("EmailAddress"));  
				
				library.findElementByLocator(ORep.RegisterPhone).clear();
				library.findElementByLocator(ORep.RegisterPhone).sendKeys(TestData.get("Phone"));  
				
				library.findElementByLocator(ORep.RegisterEmailAdress).clear();
				library.findElementByLocator(ORep.RegisterEmailAdress).sendKeys(TestData.get("EmailAddress"));
				
				if (TestData.get("Gender").equals("Male")) {
					library.findElementByLocator(ORep.RegisterGenderMale).click();
				}else {
					library.findElementByLocator(ORep.RegisterGenderFeMale).click();
				}
				
				if (TestData.get("Hobbies").equals("Cricket")) {
					library.findElementByLocator(ORep.RegisterHobbiesCricket).click();
					
				}else if (TestData.get("Hobbies").equals("Movies")) {
					library.findElementByLocator(ORep.RegisterHobbiesMovies).click();
					
				}else if (TestData.get("Hobbies").equals("Hockey")) {
					library.findElementByLocator(ORep.RegisterHobbiesHockey).click();
				}
				 
				if (rowNumber > 1) {
					library.findElementByLocator(ORep.RegisterLanguageClose).click();
				}
				WebElement LanguageEle=library.findElementByLocator(ORep.RegisterLanguages);
				LanguageEle.click(); 
				
				List<WebElement> AllLanguages=library.findElementsByLocator(ORep.RegisterLanguages_DropDownItems);
				library.SelectValueFromDropDown(AllLanguages, TestData.get("Languages"));
				library.findElementByLocator(ORep.Register_Skills_Label).click();
			
				WebElement SkillsEle=library.findElementByLocator(ORep.RegisterSkills);
				SkillsEle.click();
				List<WebElement> AllSkills=library.findElementsByLocator(ORep.Register_Skills_DropDownItem);
				library.SelectValueFromDropDown(AllSkills, TestData.get("Skills"));
				
				WebElement SelectCountryEle=library.findElementByLocator(ORep.RegisterSelect_Country);
				SelectCountryEle.click();
				library.findElementByLocator(ORep.RegisterSelect_Country_Search).sendKeys(TestData.get("SelectCountry"));
				try {
					Robot obj = new Robot();
					obj.keyPress(KeyEvent.VK_ENTER);
					obj.keyRelease(KeyEvent.VK_ENTER);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				WebElement DOB_Year=library.findElementByLocator(ORep.RegisterDOBYear);
				DOB_Year.click();
				List<WebElement> AllYears=library.findElementsByLocator(ORep.RegisterDOBYear_DropDownItem);
				library.SelectValueFromDropDown(AllYears, TestData.get("DOB_YY"));
				
				WebElement DOB_Month=library.findElementByLocator(ORep.RegisterDOBMonth);
				DOB_Month.click();
				List<WebElement> AllMonths=library.findElementsByLocator(ORep.RegisterDOBMonth_DropDownItem);
				library.SelectValueFromDropDown(AllMonths, TestData.get("DOB_MM"));
				
				WebElement DOB_DD=library.findElementByLocator(ORep.RegisterDOBDate);
				DOB_DD.click();
				List<WebElement> AllDays=library.findElementsByLocator(ORep.RegisterDOBDate_DropDownItem);
				library.SelectValueFromDropDown(AllDays, TestData.get("DOB_DD"));
				
				library.findElementByLocator(ORep.RegisterPassword).clear();
				library.findElementByLocator(ORep.RegisterPassword).sendKeys(TestData.get("Password"));
				
				library.findElementByLocator(ORep.RegisterConfirmPassword).clear();
				library.findElementByLocator(ORep.RegisterConfirmPassword).sendKeys(TestData.get("ConfirmPassword"));
				
				//Pushing the data into excel(Writing the data into excel)  
				FileOutputStream ObjeFileOut = new FileOutputStream(
						new File(System.getProperty("user.dir") + "//src//test//resources//AutomationDemoSite.xlsx"));

				WriteTheResultToExcel(objXSSFWorkbook, rowNumber);
				objXSSFWorkbook.write(ObjeFileOut);
				ObjeFileOut.close();
				}else{
					System.out.println("RunMode is not marked as Yes . Hence Skipiing this Row/TestCase");
				}
				}
			
			objXSSFWorkbook.close();
			objFileInputStream.close();
		}   catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Pushing the data into excel(Writing the data into excel) 
	private void WriteTheResultToExcel(XSSFWorkbook objXSSFWorkbook, int rowNumber) {
		// TODO Auto-generated method stub
		XSSFSheet objSheet = objXSSFWorkbook.getSheet("TestData");
		XSSFCellStyle CellStyle = objXSSFWorkbook.createCellStyle();
		// CellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		System.out.println("Row Number in excel is :" + rowNumber);

		objSheet.getRow(rowNumber).createCell(18).setCellValue("PASS");
		objSheet.getRow(rowNumber).getCell(18).setCellStyle(CellStyle);
		
	}
	//Getting the data from excel  
	private HashMap<String, String> readExcelFile(XSSFSheet objXSSFSheet, int rowNumber) {
		DataFormatter Format = new DataFormatter();
		TestData.put("RunMode", objXSSFSheet.getRow(rowNumber).getCell(0).getStringCellValue());
		TestData.put("TestCaseName", objXSSFSheet.getRow(rowNumber).getCell(1).getStringCellValue());
		TestData.put("FirstName", objXSSFSheet.getRow(rowNumber).getCell(2).getStringCellValue());
		TestData.put("LastName", objXSSFSheet.getRow(rowNumber).getCell(3).getStringCellValue());
		TestData.put("Address", objXSSFSheet.getRow(rowNumber).getCell(4).getStringCellValue());
		TestData.put("EmailAddress", objXSSFSheet.getRow(rowNumber).getCell(5).getStringCellValue());
		
		String PhoneNumber = Format.formatCellValue(objXSSFSheet.getRow(rowNumber).getCell(6));
		TestData.put("Phone", PhoneNumber);
		
		TestData.put("Gender", objXSSFSheet.getRow(rowNumber).getCell(7).getStringCellValue());
		TestData.put("Hobbies", objXSSFSheet.getRow(rowNumber).getCell(8).getStringCellValue());
		TestData.put("Languages", objXSSFSheet.getRow(rowNumber).getCell(9).getStringCellValue());
		TestData.put("Skills", objXSSFSheet.getRow(rowNumber).getCell(10).getStringCellValue());
		TestData.put("Country", objXSSFSheet.getRow(rowNumber).getCell(11).getStringCellValue());
		TestData.put("SelectCountry", objXSSFSheet.getRow(rowNumber).getCell(12).getStringCellValue());
		
		String Year = Format.formatCellValue(objXSSFSheet.getRow(rowNumber).getCell(13));
		TestData.put("DOB_YY", Year);
		
		TestData.put("DOB_MM", objXSSFSheet.getRow(rowNumber).getCell(14).getStringCellValue());
		
		String Day=Format.formatCellValue(objXSSFSheet.getRow(rowNumber).getCell(15));
		TestData.put("DOB_DD", Day);
		
		TestData.put("Password", objXSSFSheet.getRow(rowNumber).getCell(16).getStringCellValue());
		TestData.put("ConfirmPassword", objXSSFSheet.getRow(rowNumber).getCell(17).getStringCellValue());
		
		return TestData;
		
	}
	
	@Test (priority=14)
	public void validateCalendar() {
		System.out.println("Inside of the ValidateCalendar");
		ExtTest=ExtReport.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
		driver.navigate().to(propObj.getProperty("Calendar"));
		WaitForPageLoad();
		
		WebElement ele = library.findElementByLocator(ORep.CalendarFrame);
		library.SwitchToFramesUsingWebElement(ele);
		
		library.findElementByLocator(ORep.Cal_From).click();
		 WebElement from_month =library.findElementByLocator(ORep.Cal_FromMonth);
		from_month.click();
		Select from_month_select = new Select(from_month);
		from_month_select.selectByVisibleText("Sep");
		library.findElementByLocator(ORep.Cal_FromDate).click();
		
		library.findElementByLocator(ORep.Cal_to).click();
		WebElement  to_month=library.findElementByLocator(ORep.Cal_ToMonth);
		to_month.click();
		Select to_month_select = new Select(to_month);
		to_month_select.selectByVisibleText("Oct");
		library.findElementByLocator(ORep.Cal_ToDate).click();
		
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod(ITestResult Result) {
		if(Result.getStatus() == ITestResult.FAILURE) {
			ExtTest.log(Status.FAIL, "Test case failed is: "+ Result.getName());
			ExtTest.log(Status.FAIL, "Test case failed is: "+ Result.getThrowable());
			
			try {
				String ScreencastPath=library.takeScreenshot(driver, Result.getName());
				ExtTest.addScreenCaptureFromPath(ScreencastPath);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if (Result.getStatus()==ITestResult.SUCCESS) {
			ExtTest.log(Status.PASS, "Test Case pass is: "+Result.getName());
		}else if(Result.getStatus()==ITestResult.SKIP) {
			ExtTest.log(Status.SKIP, "Test Case pass is: "+Result.getName());
			
		}
		
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Inside before class");
		library.StartExtentReport();
		
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
		ExtReport.flush();
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
}
