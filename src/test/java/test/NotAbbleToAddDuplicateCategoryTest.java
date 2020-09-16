package test;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.BasePage;
import page.DashboardPage;
import page.NotAbbleToAddDuplicateCategoryPage;
import util.BrowserFactory;

public class NotAbbleToAddDuplicateCategoryTest {
	WebDriver driver;
	DashboardPage dashboard;
	NotAbbleToAddDuplicateCategoryPage notabbletoaddcategorypage;

	@Test
	public void StartFirst() {
		driver = BrowserFactory.startBrowser();
		dashboard = PageFactory.initElements(driver, DashboardPage.class);
		// Dashboard validation
		dashboard.dashboardValidation();

	}

	@Test
	public void userShouldNotBeAbbleToAddAcategory() throws InterruptedException {
		notabbletoaddcategorypage = PageFactory.initElements(driver, NotAbbleToAddDuplicateCategoryPage.class);
		notabbletoaddcategorypage.enteredCategoryName("TestNG72");
		notabbletoaddcategorypage.clickAddCategoryButton();
		notabbletoaddcategorypage.categoryNameAlreadyExist();

	}

	@After
	public void close() throws InterruptedException {
		BasePage.waitForImplicitWaitly();
		driver.close();
		driver.quit();
	}
}
