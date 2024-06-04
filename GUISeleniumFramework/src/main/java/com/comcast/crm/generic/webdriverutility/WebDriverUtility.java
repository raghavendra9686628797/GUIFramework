package com.comcast.crm.generic.webdriverutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Deepak
 *
 */
public class WebDriverUtility {

	/**
	 * wait for DOM page to load element before identifying the element in each page
	 * 
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	/**
	 * maximize the Browser window
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * Wait for element visibility in DOM document
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	/**
	 * Wait for element to be Clickable
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitUntillElementClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitUntillElementisInvisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void waitUntillElementisvisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * wait for element until element to be active and click
	 * 
	 * @param driver
	 * @param elemnet
	 * @throws InterruptedException
	 */
	public void waitandClickAjaxElement(WebDriver driver, By element) throws InterruptedException {
		int count = 20;
		while (count < 20) {
			try {
				driver.findElement(element).click();
			} catch (Exception e) {
				Thread.sleep(1000);
				count++;
				break;
			}
		}
	}

	/**
	 * wait for element until element to be active and type data
	 * 
	 * @param driver
	 * @param elemnet
	 * @throws InterruptedException
	 */
	public void waitandTypeAjaxElement(WebDriver driver, By element, String data) throws InterruptedException {
		int count = 20;
		while (count < 20) {
			try {
				driver.findElement(element).sendKeys(data);
				;
			} catch (Exception e) {
				Thread.sleep(1000);
				count++;
				break;
			}
		}
	}

	/**
	 * switch to New TAB based on URL
	 * 
	 * @param driver
	 * @param partailURL
	 */
	public void switchToTabOnURL(WebDriver driver, String partailURL) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);

			String actUrl = driver.getCurrentUrl();
			if (actUrl.contains(partailURL)) {
				break;
			}
		}
	}

	/**
	 * switch to New TAB based on TITLE
	 * 
	 * @param driver
	 * @param partailTitle
	 */
	public void switchToTabOnTitle(WebDriver driver, String partailTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);

			String actUrl = driver.getTitle();
			if (actUrl.contains(partailTitle)) {
				break;
			}
		}
	}

	/**
	 * switch to frame based on frame index
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchtoFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * switch to frame based on frame name
	 * 
	 * @param driver
	 * @param nameID
	 */
	public void switchtoFrame(WebDriver driver, String nameID) {
		driver.switchTo().frame(nameID);
	}

	/**
	 * switch to frame based on frame element
	 * 
	 * @param driver
	 * @param element
	 */
	public void switchtoFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * switch to Alert Window and accept
	 * 
	 * @param driver
	 */
	public void switchtoAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * switch to Alert Window and cancel
	 * 
	 * @param driver
	 */
	public void switchtoAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * Switch to Alert window and get Alert message
	 * 
	 * @param driver
	 * @return
	 */

	public String switchtoAlertAndGetAlertMsg(WebDriver driver) {
		String alertMsg = driver.switchTo().alert().getText();
		return alertMsg;
	}

	/**
	 * select the value from the dropDown based on visible text
	 * 
	 * @param webElement
	 * @param text
	 */
	public void select(WebElement webElement, String text) {
		Select sel = new Select(webElement);
		sel.selectByVisibleText(text);
	}

	/**
	 * select the value from the dropDown based on index
	 * 
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * select the value from the dropDown based on value attribute
	 * 
	 * @param element
	 * @param value
	 */
	public void selectByValue(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	/**
	 * select the value from dynamic dropdown based on text
	 * 
	 * @param element
	 * @param text
	 * @return
	 */
	public boolean selectDynamicValue(WebElement element, String text) {
		boolean flag = false;
		Select sel = new Select(element);
		List<WebElement> lst = sel.getOptions();
		for (WebElement opt : lst) {
			if (opt.getText().equals(text)) {
				sel.selectByVisibleText(text);
			} else {
				flag = true;
				break;
			}
		}
		return flag;
	}

	/**
	 * mouse movement on the element
	 * 
	 * @param driver
	 * @param element
	 */
	public void mousemoveOnElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * mouse movement on the element based on x and y location
	 * 
	 * @param driver
	 * @param element
	 * @param xLoaction
	 * @param Yloaction
	 */
	public void mousemoveOnElement(WebDriver driver, WebElement element, int xLoaction, int Yloaction) {
		Actions act = new Actions(driver);
		act.moveToElement(element, xLoaction, Yloaction).perform();
	}

	/**
	 * double click on the element
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleclick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	/**
	 * right click on the element
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	/**
	 * drag and drag the element based on source to destination location
	 * 
	 * @param driver
	 * @param element
	 */
	public void dragAndDrop(WebDriver driver, WebElement srcElemnet, WebElement dstElement) {
		Actions act = new Actions(driver);
		act.dragAndDrop(srcElemnet, dstElement).perform();
	}

	/**
	 * drag and drag the element based on source to destination location x and y
	 * location
	 * 
	 * @param driver
	 * @param element
	 */
	public void dragAndDrop(WebDriver driver, WebElement srcElemnet, int xLoaction, int Yloaction) {
		Actions act = new Actions(driver);
		act.dragAndDropBy(srcElemnet, xLoaction, Yloaction).perform();
	}

	/**
	 * take screenshot
	 * 
	 * @param driver
	 * @param testName
	 * @throws IOException
	 */
	public void getScrrenshot(WebDriver driver, String testName) throws IOException {
		TakesScreenshot eDriver = (TakesScreenshot) driver;
		File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("./screenshot/" + testName + ".png"));

	}

	/**
	 * Verify whether the Element is displayed or not
	 * 
	 * @param driver
	 * @param xpath
	 * @return
	 */
	public boolean verifyElementDisplayedOrNot(WebDriver driver, String xpath) {
		Duration getImplicitWait = driver.manage().timeouts().getImplicitWaitTimeout();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		boolean isDisplayedOrNot = false;
		try {
			WebElement ele = driver.findElement(By.xpath(xpath));
			isDisplayedOrNot = ele.isDisplayed();
		} catch (Exception e) {
		} finally {
			driver.manage().timeouts().implicitlyWait(getImplicitWait);
		}
		return isDisplayedOrNot;
	}

	/**
	 * Verify whether the Element is displayed or not
	 * 
	 * @param driver
	 * @param xpath
	 * @return
	 */
	public boolean verifyElementDisplayedOrNot(WebDriver driver, WebElement element) {
		Duration getImplicitWait = driver.manage().timeouts().getImplicitWaitTimeout();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		boolean isDisplayedOrNot = false;
		try {
			isDisplayedOrNot = element.isDisplayed();
		} catch (Exception e) {
		} finally {
			driver.manage().timeouts().implicitlyWait(getImplicitWait);
		}
		return isDisplayedOrNot;
	}

	/**
	 * @author Magendran Single Click on the Element
	 */
	public void singleClick(WebElement ele) {
		ele.click();
	}

	/**
	 * 
	 * @author Magendran
	 * @return text of the element
	 */
	public String pageVerification(WebElement fetchText) {
		String data = fetchText.getText();
		return data;
	}

	/**
	 * @author Magendran Scroll until the element;
	 */

	public void scrollTillElement(WebDriver driver, WebElement ELement) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ELement);
	}

	/**
	 * Scroll till element is visible
	 * 
	 * @param driver
	 * @param element
	 */
	public void scrollUntilElementIsVisible(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		// Scroll to the element using JavaScript
	}

	/**
	 * 
	 * @author Magendran accepts the alerts
	 */
	public void handleAlerts(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

}
