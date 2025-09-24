package Com.OrangeHrm.Pages;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.OrangeHrm.Keyword;

public class LoginPage {
	
	@FindBy(css = "input[name=\"username\"]")
	WebElement usernameTxt;

	@FindBy(css = "input[name=\"password\"]")
	WebElement passwordTxtbx;

	@FindBy(css = "button[type=\"submit\"]")
	WebElement loginbtn;

	public void enterUsername(String username) {
		usernameTxt.sendKeys(username);
	}

	public LoginPage() {
		PageFactory.initElements(Keyword.driver, this); // this is use for current class instance
	}

	public void enterPassword(String password) {
		passwordTxtbx.sendKeys(password);

	}

	public void clickOnLoginBtn() {
		loginbtn.click();
	}

}
