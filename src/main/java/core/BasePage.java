package core;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public void selectCombo(String id, String value) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(value);
	}

	public void write(String id, String text) {
		getDriver().findElement(By.id(id)).sendKeys(text);
	}

	public void click(String id) {
		getDriver().findElement(By.id(id)).click();
	}

	public String getText(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public void click_xpath(String xpath) {
		getDriver().findElement(By.xpath(xpath)).click();
	}
	
	public void wait_visibilityOfAllElementsLocatedBy(String xpath) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 5);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
	}
}