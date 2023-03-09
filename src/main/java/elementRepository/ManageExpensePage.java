package elementRepository;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.GeneralUtilities;

public class ManageExpensePage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageExpensePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "Manage Expense")
	WebElement manageExpenseMain;
	@FindBy(linkText = "Expense Category")
	WebElement expenseCatagory;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement search1;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement search2;
	@FindBy(xpath = "//input[@id='un']")
	WebElement title;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> list;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[2]//a[2]//i")
	WebElement deleteButton;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-expense']//i[@class='far fa-circle nav-icon']")
	WebElement manageExpeseSubb;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[9]//a//i")
	WebElement updateDetailsInTable;
	@FindBy(xpath = "//input[@name='userfile']")
	WebElement chooseFileButton;
	@FindBy(xpath = "//button[@name='update']")
	WebElement updateAfterFileUpload;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertWhileDelete;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement addNewItems;
	@FindBy(xpath = "//input[@id='name']")
	WebElement titleSendKeys;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement save;

	public void clickManageExpenseMain() {
		gu.clickWebElement(manageExpenseMain);
	}

	public Boolean getActiveStatusofMnageExpenseLink() {
		return gu.activeStatus(manageExpenseMain, "class", "nav-link active");
	}

	public void clickExpeseCatagory() {
		gu.clickWebElement(expenseCatagory);
	}

	public void clickSearch1() {
		gu.clickWebElement(search1);
	}

	public void sendKeysToTitleBar() {
		gu.sendKeysToElement(title, "achu");
	}

	public void clickSearch2() {
		gu.clickWebElement(search2);
	}

	public boolean searchValue() {
		return gu.iterateAndFindElementBySerach(list, "achu");
	}

	public void clickDelete() {
		gu.clickWebElement(deleteButton);
	}

	public String getTextWhileDelete() {
		return gu.getTextAlert(driver, deleteButton);
	}
    public void clickSubManageExpense()
    {
    	gu.clickWebElement(manageExpeseSubb);
    }
    public void clickUpdate()
    {
    	gu.clickWebElement(updateDetailsInTable);
    }
    public String file() throws AWTException 
    {
    	return gu.fileUpload(driver, chooseFileButton, updateAfterFileUpload,"C:\\Users\\ADMIN\\OneDrive\\Pictures\\Picture1.png");
    }
    public void rectangleMethod()
    {
    	gu.scrollToElement(chooseFileButton, driver);
    }
    public Boolean isDisplayedAlertBox()
    {
		return gu.isDisplayedElement(alertWhileDelete);
    	
    }
  
    public void sendKeysToTitle(String a,String b)
    {
    	gu.clickWebElement(addNewItems);
    	titleSendKeys.sendKeys(a);
    	gu.clickWebElement(save);
    	gu.clickWebElement(addNewItems);    	
    	titleSendKeys.sendKeys(b);
    	gu.clickWebElement(save);
    }
    
}
