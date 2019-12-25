package core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	private static WebDriver browser;

	private DriverFactory() {

	}

	public static WebDriver getDriver() {
		if (browser == null) {
			browser = new ChromeDriver();
			browser.manage().window().setSize(new Dimension(1200, 800));
		}
		return browser;
	}

	public static void killDriver() {
		if (browser != null) {
			browser.quit();
			browser = null;
		}
	}
}