package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NotAbbleToAddDuplicateCategoryPage {
	WebDriver driver;

	public NotAbbleToAddDuplicateCategoryPage(WebDriver driver) {
		this.driver = driver;

	}

	// Element Library
	@FindBy(how = How.XPATH, using = "//span[@id='extra']//following::input[@name='categorydata']")
	WebElement ADD_CATEGORY_NAME_FIELD;
	@FindBy(how = How.XPATH, using = "//span[@id='extra']//following::input[@value='Add category']")
	WebElement ADD_CATEGORY_BUTTON_LOCATOR;

	// Methods to interact with the elements

	public void enteredCategoryName(String categoryName) throws InterruptedException {
		ADD_CATEGORY_NAME_FIELD.sendKeys(categoryName);
		BasePage.waitForImplicitWaitly();
	}

	public void clickAddCategoryButton() throws InterruptedException {
		ADD_CATEGORY_BUTTON_LOCATOR.click();
		BasePage.waitForImplicitWaitly();
	}

	public void categoryNameAlreadyExist() throws InterruptedException {
		String ExpectedCategoryName = ("TestNG72");
		System.out.println("The expected category name is :" + ExpectedCategoryName);
		String ActualCategoryName = driver.findElement(By.xpath("/html/body/span[1]")).getText();
		if (ExpectedCategoryName.contains(ActualCategoryName)) {
			System.out.println("The category you want to add already exists:" + ActualCategoryName);
		}
	}

}
