package projectTestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Constant.Constant;
import elementRepository.LoginPage;
import utilities.Excelreadwrite;

public class LoginTestCases extends BaseClass {
	LoginPage lp;
	Excelreadwrite er;
	

	@Test(groups = {"Critical"})
	public void verifyLogin() {
		lp = new LoginPage(driver);
		lp.clickLogin("admin", "admin");

	}
	@Test(groups = {"High"})

	public void verifySignInGetText() {
		lp = new LoginPage(driver);
		//lp.clickLogin("admin", "admin");
		String actual = lp.getTextOfSignIn();
		String expected = "Sign In";
		Assert.assertEquals(actual, expected,Constant.ERRORWHILECOMPARINGBUTTONTEXT);
	}
	@Test
	public void verifyremberMeunSelected()
	{
		lp = new LoginPage(driver);
		Boolean actual=lp.isRememberMeunSelected();
		Boolean expected=false;
		Assert.assertEquals(actual, expected);
		
	}
	@Test
	public void verifyCSSValueofSignIn()
	{
		lp = new LoginPage(driver);
		String actual=lp.getCSSvalueoFSinINButton();
		String expected="rgba(52, 58, 64, 1)";
		Assert.assertEquals(actual, expected);
	}
	@Test(groups = {"Critical"})
	public void verifyDataFromExcel() throws IOException
	{
		er=new Excelreadwrite();
		String actual=er.fileRead();
		String expected="admin";
		Assert.assertEquals(actual, expected,Constant.ERRORWHILEEXCELREAD);
		
	}
}
