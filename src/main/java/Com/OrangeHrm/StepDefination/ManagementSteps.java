package Com.OrangeHrm.StepDefination;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import Com.OrangeHrm.Keyword;
import Com.OrangeHrm.Pages.DashBoardPage;
import Com.OrangeHrm.Pages.LoginPage;

import Com.OrangeHrm.Pages.PIMPage;
import Com.OrangeHrm.Pages.UserManagementPage;
import Com.OrangeHrm.Utile.App;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManagementSteps {

	@Given("Application url is launched")
	public void launchAppUrl() {
		Keyword keyword = new Keyword();
		keyword.LaunchBrowser("Chrome");
		keyword.launchUrl(App.getAppUrl("qa"));

	}

	@And("User is logged into the system")
	public void loginToSystem() throws InterruptedException {
		LoginPage loginPage = new LoginPage();
		Thread.sleep(3000);
		loginPage.enterUsername("Admin");
		loginPage.enterPassword("admin123");
		loginPage.clickOnLoginBtn();
	}

	@When("User clicks on PIM menu")
	public void user_clicks_on_pim_menu() throws InterruptedException {
		DashBoardPage dashboard = new DashBoardPage();
		Thread.sleep(3000);

		dashboard.clickOnPimMenu();
	}

	@And("User clicks on Add button")
	public void user_clicks_on_add_button() throws InterruptedException {
		PIMPage pimpage = new PIMPage();
		Thread.sleep(5000);
		pimpage.clickAddButton();
	}

	@And("Creates and user with valid details")
	public void creates_and_user_with_valid_details() throws InterruptedException {
		PIMPage pimpage = new PIMPage();
		Thread.sleep(6000);
		pimpage.setFirstName("Minakshi");
		pimpage.setLastName("kokate");
		pimpage.clickOnSaveBtn();
	}

	@When("User clicks in Admin menu")
	public void user_clicks_in_admin_menu() throws InterruptedException {
		DashBoardPage dashboard = new DashBoardPage();
		Thread.sleep(6000);
		dashboard.clickOnAdminMenu();

	}

	@And("Click on Add button on user management  page")
	public void click_on_add_button_on_user_management_page() throws InterruptedException {
		PIMPage pimpage = new PIMPage();
		Thread.sleep(6000);
		pimpage.clickAddButton();

	}

	@When("User selects role as ESS")
	public void user_selects_role_as_ess() throws InterruptedException {
		UserManagementPage usermgmt = new UserManagementPage();
		Thread.sleep(9000);
		usermgmt.selectRole("Admin");

	}

	@And("Enters name as Employe name")
	public void enters_name_as_employe_name() throws InterruptedException {
		UserManagementPage usermgmt = new UserManagementPage();
		Thread.sleep(10000);
		usermgmt.enterEmployeeName("Minakshi");

	}

	@Then("Populated list must contain newly created users name")
	public void populated_list_must_contain_newly_created_user_s_name() {
		UserManagementPage userMgmt = new UserManagementPage();
		List<String> names = userMgmt.getEmployeeNames();
		System.out.println(names);
		 Assert.assertTrue(names.contains("Minakshi kokate"));
	}
}
