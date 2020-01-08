package pages;

import static core.DriverFactory.getDriver;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BasePage;

public class CustomersLlistPage extends BasePage {

	public void selectVersion(String name) {
		selectCombo("switch-version-select", name);
	}

	public void clickAddCustomer() {
		click_xpath("//a[@href='/demo/bootstrap_theme_v4/add']");
	}

	public void search(String text) {
		getDriver().findElement(By.xpath("//div[@class='floatR']//a[3]//i")).click();
		getDriver().findElement(By.name("search")).sendKeys(text);
		getDriver().findElement(By.name("search")).sendKeys(Keys.ENTER);
	}

	public void clickCheck() {
		click_xpath("//div[@class='scroll-if-required']//tbody//tr//td//input");
	}

	public void clickDelete() {
		click_xpath("//a[@class='btn btn-outline-dark delete-selected-button']");
	}

	public String getMessageConfirmDelete() {
		return getText(By.xpath("//p[@class='alert-delete-multiple-one']"));
	}

	public void clickConfirmDelete() {
		click_xpath("//button[@class='btn btn-danger delete-multiple-confirmation-button']");
	}

	public String getMessageDelete() {
		return getText(By.xpath("//div[@class='alert alert-success growl-animated animated bounceInDown']//p"));
	}

	public void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(getDriver(), 30);
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
	}

	public void waitMessageConfirmDelete() {
		wait_visibilityOfAllElementsLocatedBy("//p[@class='alert-delete-multiple-one']");
	}

	public void waitMessageDelete() {
		wait_visibilityOfAllElementsLocatedBy(
				"//div[@class='alert alert-success growl-animated animated bounceInDown']//p");
	}
}