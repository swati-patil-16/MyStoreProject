package com.mystore.actiondriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;

import com.mystore.base.BaseClass;

public  class Action extends BaseClass {

	public static void scrollbyVisibilityOfElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", ele);
	}

	public static void click(WebDriver ldriver, WebElement locatorName) {

		Actions act = new Actions(ldriver);
		act.moveToElement(locatorName).click().build().perform();

	}

	public static  boolean findElement(WebDriver ldriver, WebElement ele) {
		boolean flag = false;
		try {
			if (ele.isDisplayed())
				flag = true;
		} catch (Exception e) {
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Successfully found element " + ele);
			} else {
				System.out.println("Unable to locate element " + ele);
			}
		}

		return flag;
	}

	public static boolean isDisplayed(WebDriver ldriver, WebElement ele) {
		boolean flag = findElement(ldriver, ele);
		if (flag) {
			System.out.println("Element is displayed");
		} else
			System.out.println("Element is not displayed");
		return flag;

	}

	public static boolean isSelected(WebDriver ldriver, WebElement ele) {
		boolean flag = findElement(ldriver, ele);
		if (flag) {
			if (ele.isSelected()) {
				flag = true;
				System.out.println("Element is selected");
			}

			else {
				System.out.println("Element is not selected");
			}
		} else {
			System.out.println("Unable to locate element");

		}

		return flag;
	}

	public static boolean isEnabled(WebDriver ldriver, WebElement ele) {
		boolean flag = findElement(ldriver, ele);
		if (flag) {
			if (ele.isEnabled()) {
				flag = true;
				System.out.println("Element is enabled");
			}

			else {
				System.out.println("Element is not enabled");
			}
		} else {
			System.out.println("Unable to locate element");

		}

		return flag;
	}
	
	public static boolean type(WebElement ele, String text) {
		boolean flag = false;
		try {
			 flag = ele.isDisplayed();
			if(flag) {
				ele.clear();
				ele.sendKeys(text);
				flag = true;
			}
		}
		catch(Exception e)
		{
			System.out.println("Location not found");
			flag = false;
		}
		finally {
			if(flag)
			{
				System.out.println("Successfully entered value");
			}
			else
				System.out.println("Could not enter the value");
		}
		return flag;
	}
	
	public static boolean selectBySendkeys(String value,WebElement ele)
	{   
		boolean flag = false;
		try {
			ele.sendKeys(value);
			flag = true;
    	}
		catch(Exception e) {
			e.printStackTrace();
			flag = false;
		}
		finally {
			if(flag)
			{
				System.out.println("Selected value from dropdown");
			}
			else {
				System.out.println("Could not select value from dropdown due to exception");
			}
		}
		return flag;
	}
	
	public static boolean selectByIndex(WebElement element, int index)
	{
		boolean flag = false;
		Select s = new Select(element);
		try {
			s.selectByIndex(index);
			flag = true;
    	}
		catch(Exception e) {
			e.printStackTrace();
			flag = false;
		}
		finally {
			if(flag)
			{
				System.out.println("Selected value from dropdown");
			}
			else {
				System.out.println("Could not select value from dropdown due to exception");
			}
		}
		return flag;
	}
	
	public static boolean selectByValue(WebElement element,String value)
	{
		boolean flag = false;
		Select s = new Select(element);
		try {
			s.selectByValue(value);
			flag = true;
    	}
		catch(Exception e) {
			e.printStackTrace();
			flag = false;
		}
		finally {
			if(flag)
			{
				System.out.println("Selected value from dropdown");
			}
			else {
				System.out.println("Could not select value from dropdown due to exception");
			}
		}
		return flag;
	}
	
	public static boolean selectByVisibleText(String visibletext, WebElement ele)
	{
		boolean flag = false;
		Select s = new Select(ele);
		try {
			s.selectByVisibleText(visibletext);
			flag = true;
    	}
		catch(Exception e) {
			e.printStackTrace();
			flag = false;
		}
		finally {
			if(flag)
			{
				System.out.println("Selected value from dropdown");
			}
			else {
				System.out.println("Could not select value from dropdown due to exception");
			}
		}
		return flag;
	}
	
	public static boolean mouseHoverByJavaScript(WebElement ele)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		boolean flag = false;
		try {
			WebElement mo = ele;
			String javaScript = "var evObj = document.createEvent('MouseEvents');"
					+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
					+ "arguments[0].dispatchEvent(evObj);";
			js.executeScript(javaScript, mo);
			flag = true;
		}
		catch(Exception e)
		{
			flag = false;
		}
		finally {
			if (flag) {
				System.out.println("MouseOver Action is performed");
			} else {
				System.out.println("MouseOver Action is not performed");
			}
		}
		
		return flag;
	}
	
	public static boolean JSClick(WebDriver driver, WebElement ele)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		boolean flag = false;
        try {
        	js.executeScript("argument[0].click()", ele);
        	flag = true;
        }
        catch(Exception e)
		{
			flag = false;
		}
		finally {
			if (flag) {
				System.out.println("Element is clicked");
			} else {
				System.out.println("Element is not clicked");
			}
		}
		
		return flag;
	}
	
	public static boolean switchToFrameByIndex(WebDriver driver,int index)
	{
		boolean flag = false;
        try {
        	WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(15));
        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
        	 driver.switchTo().frame(index);
        	flag = true;
        }
        catch(Exception e)
		{
			flag = false;
		}
		finally {
			if (flag) {
				System.out.println("Switched to the frame");
			} else {
				System.out.println("Could not switch to the frame");
			}
		}
		
		return flag;
	}


	public static boolean switchToFrameById(WebDriver driver,String idValue)
	{
		{
			boolean flag = false;
	        try {
	        	WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(15));
	        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
	        	 driver.switchTo().frame(idValue);
	        	flag = true;
	        }
	        catch(Exception e)
			{
				flag = false;
			}
			finally {
				if (flag) {
					System.out.println("Switched to the frame");
				} else {
					System.out.println("Could not switch to the frame");
				}
			}
			
			return flag;
		}
	}
	public static boolean switchToFrameByName(WebDriver driver,String nameValue)
	{
		{
			boolean flag = false;
	        try {
	        	WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(15));
	        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
	        	 driver.switchTo().frame(nameValue);
	        	flag = true;
	        }
	        catch(Exception e)
			{
				flag = false;
			}
			finally {
				if (flag) {
					System.out.println("switched to frame");
				} else {
					System.out.println("Could not switch to frame");
				}
			}
			
			return flag;
		}
	}
	
	public static boolean switchToDefaultFrame(WebDriver driver) {
		boolean flag = false;
		try {
			driver.switchTo().defaultContent();
			flag = true;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (flag) {
				// SuccessReport("SelectFrame ","Frame with Name is selected");
			} else if (!flag) {
				// failureReport("SelectFrame ","The Frame is not selected");
			}
		}
	}

	 
	public static void mouseOverElement(WebDriver driver,WebElement element) {
		boolean flag = false;
		try {
			new Actions(driver).moveToElement(element).build().perform();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				System.out.println(" MouserOver Action is performed on ");
			} else {
				System.out.println("MouseOver action is not performed on");
			}
		}
	}

	 
	public static boolean moveToElement(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			// WebElement element = driver.findElement(locator);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", ele);
			Actions actions = new Actions(driver);
			// actions.moveToElement(driver.findElement(locator)).build().perform();
			actions.moveToElement(ele).build().perform();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	 
	public static boolean mouseover(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			new Actions(driver).moveToElement(ele).build().perform();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			/*
			 * if (flag) {
			 * SuccessReport("MouseOver ","MouserOver Action is performed on \""+locatorName
			 * +"\""); } else {
			 * failureReport("MouseOver","MouseOver action is not performed on \""
			 * +locatorName+"\""); }
			 */
		}
	}
	 
	public static boolean draggable(WebDriver driver,WebElement source, int x, int y) {
		boolean flag = false;
		try {
			new Actions(driver).dragAndDropBy(source, x, y).build().perform();
			Thread.sleep(5000);
			flag = true;
			return true;

		} catch (Exception e) {
		
			return false;
			
		} finally {
			if (flag) {
				System.out.println("Draggable Action is performed on \""+source+"\"");			
			} else if(!flag) {
				System.out.println("Draggable action is not performed on \""+source+"\"");
			}
		}
	}
	 
	public static boolean draganddrop(WebDriver driver,WebElement source, WebElement target) {
		boolean flag = false;
		try {
			new Actions(driver).dragAndDrop(source, target).perform();
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("DragAndDrop Action is performed");
			} else if(!flag) {
				System.out.println("DragAndDrop Action is not performed");
			}
		}
	}
	
	 
	public static boolean slider(WebDriver driver,WebElement ele, int x, int y) {
		boolean flag = false;
		try {
			// new Actions(driver).dragAndDropBy(dragitem, 400, 1).build()
			// .perform();
			new Actions(driver).dragAndDropBy(ele, x, y).build().perform();// 150,0
			Thread.sleep(5000);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Slider Action is performed");
			} else {
				System.out.println("Slider Action is not performed");
			}
		}
	}
	
	 
	public static boolean rightclick(WebDriver driver,WebElement ele) {
		boolean flag = false;
		try {
			Actions clicker = new Actions(driver);
			clicker.contextClick(ele).perform();
			flag = true;
			return true;
			// driver.findElement(by1).sendKeys(Keys.DOWN);
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("RightClick Action is performed");
			} else {
				System.out.println("RightClick Action is not performed");
			}
		}
	}
	
	 
	public static boolean switchWindowByTitle(WebDriver driver,String windowTitle, int count) {
		boolean flag = false;
		try {
			Set<String> windowList = driver.getWindowHandles();

			String[] array = windowList.toArray(new String[0]);

			driver.switchTo().window(array[count-1]);

			if (driver.getTitle().contains(windowTitle)){
				flag = true;
			}else{
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			//flag = true;
			return false;
		} finally {
			if (flag) {
				System.out.println("Navigated to the window with title");
			} else {
				System.out.println("The Window with title is not Selected");
			}
		}
	}
	 
	public static boolean switchToNewWindow(WebDriver driver) {
		boolean flag = false;
		try {

			Set<String> s=driver.getWindowHandles();
			Object popup[]=s.toArray();
			driver.switchTo().window(popup[1].toString());
			flag = true;
			return flag;
		} catch (Exception e) {
			flag = false;
			return flag;
		} finally {
			if (flag) {
				System.out.println("Window is Navigated with title");				
			} else {
				System.out.println("The Window with title: is not Selected");
			}
		}
	}
	 
	public static boolean switchToOldWindow(WebDriver driver) {
		boolean flag = false;
		try {

			Set<String> s=driver.getWindowHandles();
			Object popup[]=s.toArray();
			driver.switchTo().window(popup[0].toString());
			flag = true;
			return flag;
		} catch (Exception e) {
			flag = false;
			return flag;
		} finally {
			if (flag) {
				System.out.println("Focus navigated to the window with title");			
			} else {
				System.out.println("The Window with title: is not Selected");
			}
		}
	}
	 
	public static int getColumncount(WebElement row) {
		List<WebElement> columns = row.findElements(By.tagName("td"));
		int a = columns.size();
		System.out.println(columns.size());
		for (WebElement column : columns) {
			System.out.print(column.getText());
			System.out.print("|");
		}
		return a;
	}
	
	 
	public static int getRowCount(WebElement table) {
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int a = rows.size() - 1;
		return a;
	}
	
	
	/**
	 * Verify alert present or not
	 * 
	 * @return: Boolean (True: If alert preset, False: If no alert)
	 * 
	 */
	 
	public static boolean Alert(WebDriver driver) {
		boolean presentFlag = false;
		WebDriverWait wait;
		Alert alert = null; 

		try {
			// Check the presence of alert
			 alert = driver.switchTo().alert();
			// if present consume the alert
			alert.accept();
			presentFlag = true;
		} catch (NoAlertPresentException ex) {
			// Alert present; set the flag

			// Alert not present
			ex.printStackTrace();
		} finally {
			if (!presentFlag) {
				System.out.println("The Alert is handled successfully");		
			} else{
				System.out.println("There was no alert to handle");
			}
		}

		return presentFlag;
	}
	 
	public static boolean launchUrl(WebDriver driver,String url) {
		boolean flag = false;
		try {
			driver.navigate().to(url);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Successfully launched \""+url+"\"");				
			} else {
				System.out.println("Failed to launch \""+url+"\"");
			}
		}
	}
	
	 
	public static boolean isAlertPresent(WebDriver driver) 
	{ 
		try 
		{ 
			driver.switchTo().alert(); 
			return true; 
		}   // try 
		catch (NoAlertPresentException Ex) 
		{ 
			return false; 
		}   // catch 
	}
	
	 
	public static String getTitle(WebDriver driver) {
		boolean flag = false;

		String text = driver.getTitle();
		if (flag) {
			System.out.println("Title of the page is: \""+text+"\"");
		}
		return text;
	}
	
	 
	public static String getCurrentURL(WebDriver driver)  {
		boolean flag = false;

		String text = driver.getCurrentUrl();
		if (flag) {
			System.out.println("Current URL is: \""+text+"\"");
		}
		return text;
	}
	
	 
	public static boolean click1(WebElement locator, String locatorName) {
		boolean flag = false;
		try {
			locator.click();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Able to click on \""+locatorName+"\"");
			} else {
				System.out.println("Click Unable to click on \""+locatorName+"\"");
			}
		}

	}
	
	 
	public static void fluentWait(WebDriver driver,WebElement element, int timeOut) {
	    Wait<WebDriver> wait = null;
	    try {
	        wait = new FluentWait<WebDriver>((WebDriver) driver)
	        		.withTimeout(Duration.ofSeconds(20))
	        	    .pollingEvery(Duration.ofSeconds(2))
	        	    .ignoring(Exception.class);
	        wait.until(ExpectedConditions.visibilityOf(element));
	        element.click();
	    }catch(Exception e) {
	    }
	}
	 
	public static void implicitWait(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
	}
	 
	public static void explicitWait(WebDriver driver, WebElement element, int timeOut ) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	 
	public static void pageLoadTimeOut(WebDriver driver, int timeOut) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeOut));
	}
	 
	public static String screenShot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		// This new path for jenkins
		String newImageString = "http://localhost:8082/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + filename + "_"
				+ dateName + ".png";
		return newImageString;
	}
	 
	public static String getCurrentTime() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
	}
	

}
