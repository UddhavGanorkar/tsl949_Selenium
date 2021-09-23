package fw;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Base {
	public WebDriver driver;
	@BeforeTest
	  public void beforeTest()throws Exception {
		  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		  driver=new ChromeDriver();	  
	  }

	  @AfterTest
	  public void afterTest()throws Exception {
		  Thread.sleep(2000);
		  driver.quit();
	  }

}
