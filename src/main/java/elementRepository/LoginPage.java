package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class LoginPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement signInButton;
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement userName;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement passWord;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement rememberMe;
	public void clickLogin(String username, String password) {
		userName.sendKeys(username);
		passWord.sendKeys(password);
		signInButton.click();
	}
	public String getTextOfSignIn()
	{
		return gu.getTextOfElement(signInButton);
	}
	public Boolean isRememberMeunSelected()
	{
		gu.clickWebElement(rememberMe);
		return gu.isSelectedCheckBox(rememberMe);
	}
	public String getCSSvalueoFSinINButton()
	{
		return gu.getCssValueOfElements(signInButton,"background-color");
	}

}
