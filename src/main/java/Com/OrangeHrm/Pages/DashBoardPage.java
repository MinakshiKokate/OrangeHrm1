package Com.OrangeHrm.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.OrangeHrm.Keyword;

public class DashBoardPage {
	@FindBy(css = "a[href*='PimMod']")
	WebElement pimMenu;
	
	@FindBy(css = "a[href*='AdminMod']")
	WebElement adminMenu;
	
	@FindBy(css = "a[href*='LeaveMod']")
	WebElement leaveMenu;
	
	
	public DashBoardPage() {
		PageFactory.initElements(Keyword.driver, this);
	}
	public void clickOnPimMenu() {
		pimMenu.click();
	}
	
	public void waitForPimMenuToBeVisible() {
		Keyword keyword = new Keyword();
		keyword.waitForElementToBeVisible(pimMenu);
	}
	public void clickOnAdminMenu() {
		adminMenu.click();
	}
}
