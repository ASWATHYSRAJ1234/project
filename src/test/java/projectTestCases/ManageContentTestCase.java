package projectTestCases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.ManageContent;
import elementRepository.ManageExpensePage;

public class ManageContentTestCase extends BaseClass {

	LoginPage lp;
	ManageContent mcp;

	@Test(dataProvider = "data-provider")
	public void verifysendKeysToTitle(String s, int t) {

		lp = new LoginPage(driver);
		mcp = new ManageContent(driver);
		// mep = new ManageExpensePage(driver);
		lp.clickLogin("admin", "admin");
		mcp.clickManageContentandEnterNewValues();
		mcp.clickmanagePages();
		mcp.clickNewButton();
		mcp.sendKeystOtitle(s);
		mcp.sendKeyspage(t);
		mcp.moveToElementSaveButton();
	}

	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() {
		return new Object[][] { { "citrus", 897 } };
	}
	@Test

	public void verifyToolTipDelete() {
		lp = new LoginPage(driver);
		mcp = new ManageContent(driver);
		lp.clickLogin("admin", "admin");
		mcp.clickManageContentandEnterNewValues();
		mcp.clickManageNews();	
		mcp.clickToolTipDelete();
		String actual=mcp.clickToolTipDelete();
		String expected="null";
		driver.switchTo().alert().dismiss();
	}
	public void verifySearchBgColor()
	{
		lp = new LoginPage(driver);
		mcp = new ManageContent(driver);
		lp.clickLogin("admin", "admin");
		mcp.clickManageContentandEnterNewValues();
		mcp.clickmanagePages();
		String bgColorSearh=mcp.getCssOfSearch();
		String expected="#007bff";
		Assert.assertEquals(bgColorSearh, expected);
		
	}

}
