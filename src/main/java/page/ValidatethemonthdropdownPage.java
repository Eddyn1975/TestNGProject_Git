package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ValidatethemonthdropdownPage {
	WebDriver driver;

	public ValidatethemonthdropdownPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library
	@FindBy(how = How.XPATH, using = "//*[@id='extra']/select[3]")
	By MONTH_DROPDOWN_FIELD;

	// Methods to interact with the elements
	public void selectMonthFromDropdown() throws InterruptedException {
		List<WebElement> allMonth = driver.findElements(By.xpath("//div[@class='advance-controls']//descendant::select[@name='due_month']"));

		for (WebElement elements : allMonth) {

			String Month = elements.getText();
			System.out.println("The list of months in the drop down list is : " + Month);

		}

	}
}
