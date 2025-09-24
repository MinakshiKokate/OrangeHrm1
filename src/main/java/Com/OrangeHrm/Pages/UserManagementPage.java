package Com.OrangeHrm.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.OrangeHrm.Keyword;

public class UserManagementPage {

	@FindBy(css = "div.orangehrm-header-container button]")
	private WebElement addBtn;

	@FindBy(css = "div.oxd-select-text")
	private WebElement userRoleList;

	@FindBy(css = "div[role='listbox'] div>span")
	private List<WebElement> roleList;

	@FindBy(css = "input[placeholder=\"Type for hints...\"")
	private WebElement employeeName;

	@FindBy(xpath = "//div[@role='option']/span")
	private List<WebElement> employeenames;
	
	public void clickOnAddBtn() {
		addBtn.click();
	}
	public UserManagementPage() {
		PageFactory.initElements(Keyword.driver, this);
	}

	public void clickOnSelectbtn() {
		userRoleList.click();

	}

	public void selectRole(String roleName) {
		userRoleList.click();
		for (WebElement role : roleList) {
			if (role.getText().equalsIgnoreCase(roleName)) {
				role.click();
				break;
			}
		}
	}
	

	public void enterEmployeeName(String employeeName) throws InterruptedException {
		this.employeeName.sendKeys(employeeName);
		Thread.sleep(3000);
	}
	
	public List<String> getEmployeeNames() {
		List<String> names = new ArrayList<String>();
		for (WebElement employeeName : employeenames) {
			names.add(employeeName.getText());
		}
		return names;
	}	
	
}


