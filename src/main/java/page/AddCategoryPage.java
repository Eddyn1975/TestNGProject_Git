package page;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddCategoryPage extends BasePage {
	WebDriver driver;

	public AddCategoryPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library
	@FindBy(how = How.XPATH, using = "//span[@id='extra']//following::input[@name='categorydata']")
	WebElement ADD_CATEGORY_NAME_FIELD;
	@FindBy(how = How.XPATH, using = "//span[@id='extra']//following::input[@value='Add category']")
	WebElement ADD_CATEGORY_BUTTON_LOCATOR;
	
	// Methods to interact with the elements

	String enteredcategoryname;

	public void enteredCategoryName(String categoryName) throws InterruptedException {
		enteredcategoryname = categoryName + randomNumGenerator();
		ADD_CATEGORY_NAME_FIELD.sendKeys(enteredcategoryname);
		System.out.println("The entered category name is :" + enteredcategoryname);
		BasePage.waitForImplicitWaitly();
	}

	public void clickAddCategoryButton() throws InterruptedException {
		ADD_CATEGORY_BUTTON_LOCATOR.click();
		BasePage.waitForImplicitWaitly();
	}

	public void categoryNameShouldDisplay() throws InterruptedException {

		List<WebElement> elements = driver.findElements(By.xpath("/html/body/div[3]"));
		BasePage.waitForImplicitWaitly();
		int Size = elements.size();
		for (int i = 0; i <= Size - 1; i++) {
			String ExistingCategoryName = elements.get(i).getText();
			System.out.println("The existing category list name is :" + ExistingCategoryName);
			if (ExistingCategoryName.contains(enteredcategoryname)) {
				System.out.println("The category name exist!!!");
			} else {
				System.out.println("The category name does not exist!!!''");

			}
		}
	}

}
