package core;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
}