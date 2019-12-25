package pages;

import static core.DriverFactory.getDriver;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BasePage;
import core.DriverFactory;

public class CustomersLlistPage extends BasePage {

	public void selectVersion(String name) {
		selectCombo("switch-version-select", name);
	}

	public void clickAddCustomer() {
		getDriver().findElement(By.xpath("//a[@href='/demo/bootstrap_theme_v4/add']")).click();
	}

	public void search(String text) {
		getDriver().findElement(By.xpath("//div[@class='floatR']/a[3]/i")).click();
		getDriver().findElement(By.name("search")).sendKeys(text);
		getDriver().findElement(By.name("search")).sendKeys(Keys.ENTER);
	}

	public void clickCheck() {
		getDriver().findElement(By.xpath("//div[@class='scroll-if-required']//table//tbody//tr//td//input")).click();
	}

	public void clickDelete() {
		getDriver().findElement(By.xpath("//a[@class='btn btn-outline-dark delete-selected-button']")).click();
	}

	public String getMessageConfirmDelete() {
		return getText(By.xpath(
				"//*[@class='delete-multiple-confirmation modal fade in show']//p[@class='alert-delete-multiple-one']"));
	}

	public void clickConfirmDelete() {
		getDriver().findElement(By.xpath(
				"//*[@class='delete-multiple-confirmation modal fade in show']//button[@class='btn btn-danger delete-multiple-confirmation-button']"))
				.click();
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
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 5);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
				"//*[@class='delete-multiple-confirmation modal fade in show']//p[@class='alert-delete-multiple-one']")));
	}

	public void waitMessageDelete() {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 5);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//div[@class='alert alert-success growl-animated animated bounceInDown']//p")));
	}
}