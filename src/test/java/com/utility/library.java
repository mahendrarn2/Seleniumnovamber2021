package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme; 

public class library {

	public static WebDriver driver;
	public static Properties propObj = new Properties();
	
	//ExtentsReports
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports ExtReport;
	public static ExtentTest ExtTest;
	
	//To Start extent Report
	public static void StartExtentReport() {
	htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/ExtentReportV4.html");
	htmlReporter.config().setDocumentTitle("AutomationReport");
	htmlReporter.config().setReportName("Selenium");
	htmlReporter.config().setTheme(Theme.STANDARD);
	ExtReport = new ExtentReports();
	ExtReport.attachReporter(htmlReporter);
	ExtReport.setSystemInfo("Host Name", "LocalHost");
	ExtReport.setSystemInfo("user", "Trainer:");
	ExtReport.setSystemInfo("Environemnet", (String) propObj.get("environment"));
	ExtReport.setSystemInfo("Browser", (String) propObj.get("browser"));
	
	}

	public static void ReadPropertyFile() throws IOException {

		FileInputStream ObjInputStream;

		try {
			ObjInputStream = new FileInputStream(
					new File(System.getProperty("user.dir") + "//src//test//resources//config.features"));
			propObj.load(ObjInputStream);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void LaunchBrowser() {

		String browser = propObj.getProperty("browser");
		System.out.println("browser: " + browser);

		if (browser.equals("chrome")) {
		
			
			  WebDriverManager.chromedriver().setup(); ChromeOptions objChromeOptions=new
			  ChromeOptions(); objChromeOptions.setAcceptInsecureCerts(true);
			  HashMap<String,Object> ChromePrefs=new HashMap<String, Object>();
			  ChromePrefs.put("profile.default_content_settings.popups", 0);
			  ChromePrefs.put("download.prompt_for_download", false);
			  ChromePrefs.put("download.default_directory",System.getProperty("user.dir"));
			  
			  objChromeOptions.setExperimentalOption("prefs", ChromePrefs); driver=new
			  ChromeDriver(objChromeOptions); DesiredCapabilities
			  ObjDesiredCap=DesiredCapabilities.chrome();
			  ObjDesiredCap.setCapability(ChromeOptions.CAPABILITY, objChromeOptions);
			  ObjDesiredCap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			 

		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browser.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();

		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else if (browser.equals("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();

		}
		driver.get(propObj.getProperty("GmoOnlineURL_SIT"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public static void SwitchToFramesUsingIdOrName(String name_id) {

		driver.switchTo().frame(name_id);

	}

	public static void SwitchToFramesUsingWebElement(WebElement element) {
		driver.switchTo().frame(element);
	}

	public static void SwitchToAlert() {
		driver.switchTo().alert();
	}

	public static String SwitchToAlertAndReturnText() {

		Alert obj = driver.switchTo().alert();
		String SwitchToAlertText = obj.getText();
		return SwitchToAlertText;
	}

	public static void AlertAccept() {
		Alert obj1 = driver.switchTo().alert();
		obj1.accept();

	}
	
	public static void AlertDismiss() {
		Alert Obj=driver.switchTo().alert();
		Obj.dismiss();
	}
	
	public static void AlertSendKeys(String name) {
		driver.switchTo().alert().sendKeys(name);
		
	}

	public static void javaScriptExecutorScroolIntoView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);

	}
	
	public static void javaScriptExecutorScroolIntoViewAndClick(WebElement element) {
		Actions Obj=new Actions(driver);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
		Obj.click(element).build().perform();
		
	}

	public static void javaScriptExecutorScroolIntoViewAndDoubleClick(WebElement element, Actions obj) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
		obj.doubleClick(element).build().perform();

	}

	public static void javaScriptExecutorScroolIntoViewAndDoubleClickWithContext(WebElement element, Actions obj) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
		obj.contextClick(element).build().perform();
	}

	public static void DragAndDrop(WebElement source, WebElement target) {
		Actions obj = new Actions(driver);
		obj.dragAndDrop(source, target).build().perform();
		// obj.clickAndHold(drag).build().perform();
		// obj.moveToElement(drop).build().perform();
	}

	//For Email Reports
	public static String takeScreenshot(WebDriver driver) throws Exception {

		File Source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String dateName = new SimpleDateFormat("YYYYMMddhhmmss").format(new Date());

		System.out.println("dateName");
		String destination = System.getProperty("user.dir") + "//src//test//resources//ScreenShots//" + dateName
				+ "captured.png";
		FileUtils.copyFile(Source, new File(destination));
		return destination;

	}

	//For Extent Reports
	public static String takeScreenshot(WebDriver driver, String name) throws Exception {

		File Source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String dateName = new SimpleDateFormat("YYYYMMddhhmmss").format(new Date());

		System.out.println("dateName");
		String destination = System.getProperty("user.dir") + "//src//test//resources//ScreenShots//" + dateName + name
				+ "captured.png";
		FileUtils.copyFile(Source, new File(destination));
		return destination;

	}
	
	// Helper methods
		public static void WaitForPageLoad() {

			ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {

				public Boolean apply(WebDriver driver) {

					return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
				}

			};

			// Explicit wait -->Applicable for one webElement
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(pageLoadCondition);

		}

	
	public static WebElement findElementByLocator(String ObjRepLocator) {

		// System.out.println(ObjRepLocator);
		String locator = ObjRepLocator.split("&")[0];
		String value = ObjRepLocator.split("&")[1];
		// System.out.println(locator);
		// System.out.println(value);
		//WebElement element = null;

		By search = null;

		if (locator.equals("id")) {
			search = By.id(value);
		} else if (locator.equals("name")) {
			search = By.name(value);
		} else if (locator.equals("className")) {
			search = By.className(value);
		} else if (locator.equals("xpath")) {
			search = By.xpath(value);
		} else if (locator.equals("linkText")) {
			search = By.linkText(value);
		} else if (locator.equals("partialLinkText")) {
			search = By.partialLinkText(value);
		} else if (locator.equals("tagName")) {
			search = By.tagName(value);
		}

		return driver.findElement(search);
	}
	
	public static List<WebElement> findElementsByLocator(String ObjRepLocator) {

		// System.out.println(ObjRepLocator);
		String locator = ObjRepLocator.split("&")[0];
		String value = ObjRepLocator.split("&")[1];
		// System.out.println(locator);
		// System.out.println(value);
		WebElement element = null;

		By search = null;

		if (locator.equals("id")) {
			search = By.id(value);
		} else if (locator.equals("name")) {
			search = By.name(value);
		} else if (locator.equals("className")) {
			search = By.className(value);
		} else if (locator.equals("xpath")) {
			search = By.xpath(value);
		} else if (locator.equals("linkText")) {
			search = By.linkText(value);
		} else if (locator.equals("partialLinkText")) {
			search = By.partialLinkText(value);
		} else if (locator.equals("tagName")) {
			search = By.tagName(value);
		}

		return driver.findElements(search);
	}

public static void verifyinglinks(String Url) throws IOException {
	
	try {
		URL obj = new URL(Url);
		HttpURLConnection objHttpConnection = (HttpURLConnection) obj.openConnection();
		objHttpConnection.connect();
		int ResponseCode=objHttpConnection.getResponseCode();
		if (ResponseCode > 400 && ResponseCode<6000) {
			System.out.println(Url + ": " +"ResponseCode:" + ResponseCode + "is not a valid Link");
		}else if (ResponseCode > 200 && ResponseCode < 400) {
			System.out.println(Url + ": " +"ResponseCode:" + ResponseCode + "is a valid Link");
		}
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static void SelectValueFromDropDown (List<WebElement> AllDropDownItems, String DropDownValue) {
	
	for (int i=0; i<AllDropDownItems.size(); i++) {
		String DropDownIndividualValue=AllDropDownItems.get(i).getText();
		//Select obj = new Select(AllDropDownItems.get(i));
		//obj.selectByVisibleText(DropDownValue);
		if (DropDownIndividualValue.equals(DropDownValue)) {
			AllDropDownItems.get(i).click();
		}
	}
}
	
}
