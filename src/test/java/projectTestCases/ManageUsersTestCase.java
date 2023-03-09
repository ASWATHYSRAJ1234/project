package projectTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.ManageExpensePage;
import elementRepository.ManageUsersPage;

public class ManageUsersTestCase extends BaseClass {
	LoginPage lp;
	ManageUsersPage mus;

	
	@Test
	public void verifyTextOfDynamicFindTableElement() {
		lp = new LoginPage(driver);
		mus = new ManageUsersPage(driver);

		lp.clickLogin("admin", "admin");
		mus.clickManageUsers();
		String actual = mus.getFindTextDynamaically();
		String expected = "9037628453\n" + "gopiharikrishnan@mailnater.com\n" + "User id : 287";
		Assert.assertEquals(actual, expected);

	}
	@Test
	public void verifySreelakshmiGopanandClickDROPDownLikeSymbol()
	{
		lp = new LoginPage(driver);
		mus = new ManageUsersPage(driver);

		lp.clickLogin("admin", "admin");
		mus.clickManageUsers();
		String actual=mus.dynamicallyClickDropdownLikeSymbolInColoumNContainString();
		String expected="Show Details";
	    Assert.assertEquals(actual, expected);
		
}
}
