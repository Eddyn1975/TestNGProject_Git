package test;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page.AddCategoryPage;
import page.BasePage;
import page.DashboardPage;
import util.BrowserFactory;

public class AddCategoryTest {
	WebDriver driver;
	DashboardPage dashboard;
	AddCategoryPage addcategorypage;

	@Test
	public void StartFirst() {
		driver = BrowserFactory.startBrowser();
		dashboard = PageFactory.initElements(driver, DashboardPage.class);
		// Dashboard validation
		dashboard.dashboardValidation();

	}

	@Test
	public void userShouldBeAbbleToAddAcategory() throws InterruptedException {
		addcategorypage = PageFactory.initElements(driver, AddCategoryPage.class);
		addcategorypage.enteredCategoryName("TestNGProject");
		addcategorypage.clickAddCategoryButton();
		addcategorypage.categoryNameShouldDisplay();

	}

	@After
	public void close() throws InterruptedException {
		BasePage.waitForImplicitWaitly();
		driver.close();
		driver.quit();
	}

}
