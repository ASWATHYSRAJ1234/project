package elementRepository;

import java.awt.Rectangle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.GeneralUtilities;

public class ManageContent {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageContent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "Manage Content")
	WebElement manageContent;
	@FindBy(xpath = "//*[@id=\"title\"]")
	WebElement title;
	@FindBy(linkText = "Manage Pages")
	WebElement managePages;
	@FindBy(xpath = "/html/body/div/div[1]/section/div[1]/a[1]")
	WebElement newButton;
	@FindBy(xpath = "//input[@id='page']")
	WebElement enterPage;
	@FindBy(xpath = "//*[@id=\"form\"]/div/div[5]/button")
	
	WebElement saveButton;
	@FindBy(linkText = "Manage News")
	WebElement manageNews;
	//WebDriverWait wait;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	WebElement deleteToolButton;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchButton;

	public void clickManageContentandEnterNewValues() {
		gu.clickWebElement(manageContent);

	}

	public void clickmanagePages() {
		gu.clickWebElement(managePages);

	}

	public void clickNewButton() {
		gu.clickWebElement(newButton);
	}

	public void clickSaveButton() {
		gu.clickWebElement(saveButton);
	}

	public void sendKeystOtitle(String s) {
		gu.sendKeysToElement(title, s);
	}

	public void sendKeyspage(int a) {
		gu.sendKeysToElementintegers(enterPage, a);
	}

	public void moveToElementSaveButton() {
        gu.scrollToEle(saveButton, driver);
		gu.moveToElemet(saveButton, driver);
	}
	public void clickManageNews() {
		gu.clickWebElement(manageNews);

	}
	public String clickToolTipDelete()
	{
		return gu.verifyToolTipForDeleteandgetStrign(deleteToolButton, driver,"Investor Program Developer");
		
	    
		
		
	}
	public String getCssOfSearch()
	{
		return gu.getCssValueOfElements(searchButton,"background-color");
	}


	
}