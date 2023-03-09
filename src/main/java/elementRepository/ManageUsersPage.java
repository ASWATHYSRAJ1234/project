package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageUsersPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(linkText = "Manage Users")
	WebElement manageUsers;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[3]//td[2]")
	WebElement getUserIdOfSecodColoMN;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> row;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> row1;
	

	public void clickManageUsers() {
		gu.clickWebElement(manageUsers);
	}

	public String getUserIdofUserOFsecondColoumn() {
		return gu.getTextOfElement(getUserIdOfSecodColoMN);
	}
	public String getFindTextDynamaically()
	{
		return gu.dynamicallyfinfElements(driver, row,"Harikrishnan G");
	}
	public String dynamicallyClickDropdownLikeSymbolInColoumNContainString()
	{
		
		return gu.dynamicallyfinfElements2ToolTip(driver, row1,"sreelekshmi gopan");
	}

}


