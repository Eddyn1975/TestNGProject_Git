package test;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.BasePage;
import page.DashboardPage;
import page.ValidatethemonthdropdownPage;
import util.BrowserFactory;

public class ValidatethemonthdropddownTest {

	public class AddCategoryTest {
		WebDriver driver;
		DashboardPage dashboard;
		ValidatethemonthdropdownPage validatedropdownmonthlist;

		@Test
		public void StartFirst() {
			driver = BrowserFactory.startBrowser();
			dashboard = PageFactory.initElements(driver, DashboardPage.class);
			// Dashboard validation
			dashboard.dashboardValidation();

		}

		@Test
		public void validateThedropDownMonthList() throws InterruptedException {
			validatedropdownmonthlist = PageFactory.initElements(driver, ValidatethemonthdropdownPage.class);
			validatedropdownmonthlist.selectMonthFromDropdown();

		}

		@After
		public void close() throws InterruptedException {
			BasePage.waitForImplicitWaitly();
			driver.close();
			driver.quit();
		}
	}
}