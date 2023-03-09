package utilities;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

public class GeneralUtilities {
	public void moveToElemet(WebElement element,WebDriver driver)
	{
		
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
	}
	public String getTextOfElement(WebElement element) {
		String a = element.getText();
		return a;

	}

	public Boolean isSelectedCheckBox(WebElement element) {
		boolean b = element.isSelected();
		return b;

	}

	public void clickWebElement(WebElement element) {
		element.click();

	}

	public String getCssValueOfElements(WebElement element, String propertyVlaue) {
		return element.getCssValue(propertyVlaue);
	}

	public Boolean activeStatus(WebElement element, String attribute, String value) {
		boolean b = element.getAttribute(attribute).contains(value);
		return b;

	}

	public void sendKeysToElement(WebElement element, String value) {
		element.sendKeys(value);
	}

	public boolean iterateAndFindElementBySerach(List<WebElement> list, String inputText) {
		boolean b = true;
		for (int i = 0; i < list.size(); i++) {
			String a = list.get(i).getText();
			if (!(a.contains(inputText))) {
				b = false;
			}
		}
		return b;

	}

	public String getTextAlert(WebDriver driver, WebElement element) {

		// driver.switchTo().alert().accept(); //to click ok option in alert
		String a = driver.switchTo().alert().getText();// to read the text while click on alert button
		return a;

	}
	public String fileUpload(WebDriver driver,WebElement element,WebElement update2,String filePath) throws AWTException
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(element).perform();
		actions.click(element).perform();//we choose action click beacse the tag name is not button its input tag

		//Java Code for copy file path to system clipboard // copying File path to Clipboard
		StringSelection ss = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		// creating object of Robot class
		Robot obj=new Robot();
		obj.delay(250);
		// press Contol+V for path pasting
		obj.keyPress(KeyEvent.VK_CONTROL);
		obj.keyPress(KeyEvent.VK_V);
		obj.delay(250);
		// release Contol+V for pasting everytie when we are pressing corresposing key release is mandatory 
		obj.keyRelease(KeyEvent.VK_CONTROL);
		obj.keyRelease(KeyEvent.VK_V);
		obj.delay(250);
		//for pressing and releasing Enter
		obj.keyPress(KeyEvent.VK_ENTER);
		obj.keyRelease(KeyEvent.VK_ENTER);
		update2.click();
		String a="file upload successfully";
	    return a;
		
	}
	public static WebElement scrollToElement(WebElement elementToScroll, WebDriver webDriver) {

	    org.openqa.selenium.Rectangle rect = elementToScroll.getRect();
	    int deltaY = rect.y + rect.height;
	    new Actions(webDriver)
	      .scrollByAmount(0, deltaY)
	      .perform();
	    return elementToScroll;

	}
	public Boolean isDisplayedElement(WebElement element)
	{
		boolean b=element.isDisplayed();
		return b;
	}
	public String dynamicallyfinfElements(WebDriver driver,List<WebElement> list,String uniqueValue)
	{
		
		String locator=null;
		for(int i=0;i<list.size();i++)
		{
			String a=list.get(i).getText();
			if(a.equals(uniqueValue))
			{
				locator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+(i+1)+"]//td[2]"; //i+1 beacuse as per index starts from 0 but as per xpath it should be count from 1 
				break;
			}
		}
		WebElement cellValue=driver.findElement(By.xpath(locator));
		String cellValuetext=cellValue.getText();
		System.out.println(cellValuetext);
		return cellValuetext;
	}
	public  WebElement scrollToEle(WebElement elementToScroll, WebDriver webDriver) {

	    org.openqa.selenium.Rectangle rect = elementToScroll.getRect();
	    int deltaY = rect.y + rect.height;
	    new Actions(webDriver)
	      .scrollByAmount(0, deltaY)
	      .perform();
	    return elementToScroll;

	}
	public void sendKeysToElementintegers(WebElement element, int value) {
		element.sendKeys("value");
	}
	public String verifyToolTipForDeleteandgetStrign(WebElement element,WebDriver driver,String name) {
		
		
		
		String locator = null;
		List<WebElement> list = driver
				.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[2]//a[2]//i"));
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());

			if (list.get(i).getText().equals(name)) {
				locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (i + 1)
						+ "]//td[2]//a[2]";
				break;
			}

		}

		WebElement cellvalue1 = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action.moveToElement(cellvalue1).perform();
		String toolTipValue=cellvalue1.getText();
		return toolTipValue;
		

	}
	public String dynamicallyfinfElements2ToolTip(WebDriver driver,List<WebElement> list,String uniqueValue)
	{
		
		String locator=null;
		for(int j=0;j<list.size();j++)
		{
			String a=list.get(j).getText();
			if(a.equals(uniqueValue))
			{
				locator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[\"+(j+1)+\"]//td[3]//div//a"; //i+1 beacuse as per index starts from 0 but as per xpath it should be count from 1 
				break;
			}
		}
		//WebElement cellValue=driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		
		  

		// Performing the mouse hover action on the target element.
//		action.moveToElement(cellValue).perform();
//		// driver.switchTo().alert().accept();
		Actions actions = new Actions(driver);
        //Retrieve WebElemnt 'slider' to perform mouse hover 
    	WebElement slider = driver.findElement(By.xpath(locator));
    	//Move mouse to x offset 50 i.e. in horizontal direction
    	actions.moveToElement(slider,50,0).perform();
    	//slider.click();
    	System.out.println("Moved slider in horizontal directions");
		String a=slider.getAttribute("title");
		return a;
		
		
	}


	
	
	

}
