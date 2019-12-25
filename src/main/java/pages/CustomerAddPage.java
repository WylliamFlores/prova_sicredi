package pages;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BasePage;
import core.DriverFactory;

public class CustomerAddPage extends BasePage {

	public void setName(String text) {
		write("field-customerName", text);
	}

	public void setLastName(String text) {
		write("field-contactLastName", text);
	}

	public void setContactName(String text) {
		write("field-contactFirstName", text);
	}

	public void setPhone(String text) {
		write("field-phone", text);
	}

	public void setAddressLine1(String text) {
		write("field-addressLine1", text);
	}

	public void setAddressLine2(String text) {
		write("field-addressLine2", text);
	}

	public void setCity(String text) {
		write("field-city", text);
	}

	public void setState(String text) {
		write("field-state", text);
	}

	public void setPostalCode(String text) {
		write("field-postalCode", text);
	}

	public void setCountry(String text) {
		write("field-country", text);
	}

	public void selectFromEmployeer(String text) {
		getDriver().findElement(By.xpath("//*[@class='chosen-single chosen-default']//span")).click();
		getDriver().findElement(By.xpath("//*[@id='field_salesRepEmployeeNumber_chosen']//input")).sendKeys(text);
		getDriver().findElement(By.xpath("//*[@id='field_salesRepEmployeeNumber_chosen']//ul//li")).click();
	}

	public void setCreditLimit(String text) {
		write("field-creditLimit", text);
	}

	public void clickSave() {
		click("form-button-save");
	}

	public boolean getMessageSuccess() {
		return getText(By.xpath("//div[@id='report-success']")).startsWith("Your data has been successfully stored into the database.");
	}

	public void clickGoBackList() {
		getDriver().findElement(By.xpath("//div[@id='report-success']//p//a[@href='/demo/bootstrap_theme_v4/']"))
				.click();
	}

	public void waitMessageSuccess() {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 5);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='report-success']//p")));
	}
}