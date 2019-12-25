package core;

import static core.DriverFactory.getDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {

	@Before
	public void initializeDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Informatica\\eclipse-workspace\\driver\\chromedriver.exe");
		getDriver().get("https://www.grocerycrud.com/demo/bootstrap_theme");
	}

	@Rule
	public TestName testName = new TestName();

	@After
	public void ScreenshotAndFinalizeDriver() throws IOException {
		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File archive = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(archive, new File("src" + File.separator + "main" + File.separator + "java" + File.separator
				+ "screenshot" + File.separator + testName.getMethodName() + ".jpg"));
		DriverFactory.killDriver();
	}
}