package projectTestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.awt.AWTException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.ManageExpensePage;

public class ManageExpenseTestCase extends BaseClass {
	LoginPage lp;
	ManageExpensePage mep;

	@Test
	public void verifyClickManageExpense() {
		lp = new LoginPage(driver);
		mep = new ManageExpensePage(driver);
		lp.clickLogin("admin", "admin");
		mep.clickManageExpenseMain();
	}

	@Test
//	public void verifyActiveStatusOfMExpense()
//	{
//		lp = new LoginPage(driver);
//		mep=new ManageExpensePage(driver);
//		lp.clickLogin("admin", "admin");
//		mep.clickManageExpenseMain();
//		boolean actual=mep.getActiveStatusofMnageExpenseLink();
//		boolean expected=true;
//		Assert.assertEquals(actual, expected);
//	}
	public void verifySearchInList() {
		lp = new LoginPage(driver);
		mep = new ManageExpensePage(driver);
		lp.clickLogin("admin", "admin");
		mep.clickManageExpenseMain();
		mep.clickExpeseCatagory();
		mep.clickSearch1();
		mep.sendKeysToTitleBar();
		mep.clickSearch2();
		boolean actual = mep.searchValue();
		boolean expected = true;
		AssertJUnit.assertEquals(actual, expected);

	}

	@Test
	public void verifyDeleteAndGetTextOfAlert() {

		lp = new LoginPage(driver);
		mep = new ManageExpensePage(driver);
		lp.clickLogin("admin", "admin");
		mep.clickManageExpenseMain();
		mep.clickExpeseCatagory();
		mep.clickDelete();

		String actual = mep.getTextWhileDelete();
		String expected = "Do you want to delete this Category?";
		Assert.assertEquals(actual, expected);
		driver.switchTo().alert().dismiss();

	}
	@Test
	public void verifyClickMnageExpenseSub()
	{
		lp = new LoginPage(driver);
		mep = new ManageExpensePage(driver);
		lp.clickLogin("admin", "admin");
		mep.clickManageExpenseMain();
		mep.clickSubManageExpense();
	}
	@Test
	
	public void verifyFileUpload() throws AWTException
	{
		lp = new LoginPage(driver);
		mep = new ManageExpensePage(driver);
		lp.clickLogin("admin", "admin");
		mep.clickManageExpenseMain();
		mep.clickSubManageExpense();
		mep.clickUpdate();
		mep.rectangleMethod();
		mep.file();
        boolean actual=mep.isDisplayedAlertBox();
        boolean expected=true;
        Assert.assertEquals(actual,expected);
		
	}
	public void verifyAddNewItems()
	{
		lp = new LoginPage(driver);
		mep = new ManageExpensePage(driver);
		lp.clickLogin("admin", "admin");
		mep.clickManageExpenseMain();
		mep.clickExpeseCatagory();
		mep.sendKeysToTitle("achu", "yadhu");
	}

}
