package day4Junit;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstJunitTest {
	static WebDriver driver;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver=new ChromeDriver();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void test() {
		driver.get("https://rediff.com");
		String actual_title = driver.getTitle();
		assertEquals("Rediff.com: News | Rediffmail | Stock Quotes | Shopping", actual_title);
		//fail("Not yet implemented");
	}

}
