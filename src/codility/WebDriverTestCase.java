package codility;

//import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
//import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverTestCase {
	static WebDriver webDriver;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		webDriver = new ChromeDriver();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Thread.sleep(2000);
		webDriver.quit();
	}

}
