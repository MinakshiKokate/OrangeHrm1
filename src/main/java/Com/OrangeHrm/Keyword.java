package Com.OrangeHrm;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import Com.OrangeHrm.Error.InvalidBrowserError;

public class Keyword {

	public static RemoteWebDriver driver = null;// object hai jo browser ko control karega
	public static FluentWait<WebDriver> wait = null;// object hai jo element milne tak wait karta hai

	public void LaunchBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
			System.out.println("Launched Chrome Browser");

		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			System.out.println("Launched firefox Browser");

		} else if (browserName.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
			System.out.println("Launched safari Browser");
		} else {

			throw new InvalidBrowserError(browserName);
		}

		wait = new FluentWait<WebDriver>(Keyword.driver);
		wait.withTimeout(Duration.ofSeconds(60));
		wait.pollingEvery(Duration.ofMillis(500));
		wait.ignoring(NoSuchElementException.class);/*
													 * Browser का नाम पास करके Chrome, Firefox या Safari launch करता है।
													 * 
													 * अगर गलत नाम दिया, तो custom InvalidBrowserError throw करता है।
													 * 
													 * FluentWait को configure करता है (60 seconds तक wait करेगा, हर
													 * 500ms में check करेगा)।
													 */

	}

	public void launchUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();//rowser में URL open करता है और window को maximize करता है।
	}

	public void enterText(String locator, String textToEnter) {
		driver.findElement(By.xpath(locator)).sendKeys(textToEnter);//केवल XPath locator से text डालता है।

	}

	public void enterText(String locatorType, String locatorValue, String textToEnter) {// do method ke name same hai
		// list of arguments differnt
		// hai iss hai overloading
		// kahate hai
		if (locatorType.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(locatorValue)).sendKeys(textToEnter);

		} else if (locatorType.equalsIgnoreCase("css")) {
			driver.findElement(By.cssSelector(locatorValue)).sendKeys(textToEnter);
		} else if (locatorType.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locatorValue)).sendKeys(textToEnter);

		} else if (locatorType.equalsIgnoreCase("name")) {
			driver.findElement(By.name(locatorValue)).sendKeys(textToEnter);
		} else if (locatorType.equalsIgnoreCase("tagname")) {
			driver.findElement(By.tagName(locatorValue)).sendKeys(textToEnter);
		} else if (locatorType.equalsIgnoreCase("linktext")) {
			driver.findElement(By.linkText(locatorValue)).sendKeys(textToEnter);
		} else if (locatorType.equalsIgnoreCase("partiallinktext")) {
			driver.findElement(By.partialLinkText(locatorValue)).sendKeys(textToEnter);
		} else {
			throw new InvalidSelectorException(locatorType);
		}//Overloading है: एक method सिर्फ XPath से text डालता है, 
		//दूसरा multiple locator types (id, name, css, आदि) handle करता है।
	}

	public void click(String locator) {
		driver.findElement(By.xpath(locator)).click();
	}//Simple click सिर्फ XPath locator से करता है।

	public void click(String LocatorType, String LocatorValue) {
		if (LocatorType.equalsIgnoreCase("id")) {
			driver.findElement(By.id(LocatorValue)).click();
		} else if (LocatorType.equalsIgnoreCase("css")) {
			driver.findElement(By.cssSelector(LocatorValue)).click();
		} else if (LocatorType.equalsIgnoreCase("name")) {
			driver.findElement(By.name(LocatorValue)).click();
		} else if (LocatorType.equalsIgnoreCase("tagname")) {
			driver.findElement(By.tagName(LocatorValue)).click();
		} else if (LocatorType.equalsIgnoreCase("classname")) {
			driver.findElement(By.className(LocatorValue)).click();
		} else if (LocatorType.equalsIgnoreCase("linktext")) {
			driver.findElement(By.linkText(LocatorValue)).click();
		} else if (LocatorType.equalsIgnoreCase("partiallinktext")) {
			driver.findElement(By.partialLinkText(LocatorValue)).click();
		} else if (LocatorType.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(LocatorValue)).click();
		} else {
			throw new InvalidSelectorException(LocatorType);
		}

	}//Overloaded method multiple locator type से click करता है।

	public WebElement waitForElementToBeVisible(By by) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return driver.findElement(by);
	}//Element visible होने तक wait करता है।

//By locator या WebElement दोनों को support करता है।

	public WebElement waitForElementToBeVisible(WebElement element) {

		return wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void TakeScreenSh() throws IOException {
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("sussfullylogin.png");

		// Copy file to destination
		FileUtils.copyFile(srcFile, destFile);

	}//Screenshot लेकर sussfullylogin.png में save करता है।

}
