package projectTestCases;
 
import org.testng.annotations.Test;

import utilities.ScreenShotUtility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	 WebDriver driver;
	//WebDriver driver;
	ScreenShotUtility scr;
//	public static Properties prop;// reference variable for object
//
//	public static void testBasic() throws IOException {
//		prop = new Properties();// create object for properties
//		FileInputStream ip = new FileInputStream(
//				System.getProperty("user.dir") + "\\src\\main\\resources\\Properties\\Config.properties");
//		prop.load(ip);// load method is used to load the file
//	}
	@BeforeMethod(alwaysRun =true)

	@Parameters("browser")
	
	public void beforeMethod(String browserValue) {
		if (browserValue.equals("chrome")) {
			driver = new ChromeDriver();
	} else if (browserValue.equals("edge")) {
		driver = new EdgeDriver();
		} 
		
		
		//driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));// implicit wait

		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		//driver.get(prop.getProperty("BaseURL"));// getProperty method use to get value from property file
	}

	@AfterMethod(alwaysRun =true)

	public void afterMethod(ITestResult itestResult) throws IOException {
		if (itestResult.getStatus() == ITestResult.FAILURE) {
			scr = new ScreenShotUtility();
			scr.captureFailureScreenShot(driver, itestResult.getName());
		}
		driver.close();
	}

}
