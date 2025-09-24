package Com.OrangeHrm.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.OrangeHrm.Keyword;

public class MyInformation {

	@FindBy(css = "a[href=\"/web/index.php/pim/viewMyDetails\"]")
	public WebElement MyInfo;

	@FindBy(css = "input[name=\"firstName\"]")
	public WebElement FirstName;

	@FindBy(css = "input[name=\"middleName\"]")
	public WebElement middleName;

	@FindBy(css = "input[name=\"lastName\"]")
	public WebElement lastName;

	public void ClickToMyInfo() {
		MyInfo.click();
	}

	public void EnterTheFirstName(String Firstname) {
		FirstName.sendKeys(Firstname);
	}

	public MyInformation() {
		PageFactory.initElements(Keyword.driver, this);
	}

	public void EnterMiddleName(String Middlename) {
		middleName.sendKeys(Middlename);
	}

	public void EnterLastName(String LastName) {
		lastName.sendKeys(LastName);
	}
}
