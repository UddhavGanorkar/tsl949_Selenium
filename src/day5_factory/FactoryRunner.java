package day5_factory;



import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FactoryRunner {
	WebDriver driver;
	@Test
  public void forgetLinkTest() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		lp.forget();
		Assert.assertTrue(driver.getCurrentUrl().contains("requestPasswordResetCode"));
  }
	@Test
	  public void loginTest()throws Exception {
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			WebDriverWait wt = new WebDriverWait(driver,20); 
			driver.get("https://opensource-demo.orangehrmlive.com/");
			LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
			lp.do_login("Admin", "admin123");
			Assert.assertEquals(driver.getCurrentUrl().contains("dashboard"),true);
			driver.findElement(By.id("welcome")).click();
			 //Thread.sleep(2000);
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
			driver.findElement(By.linkText("Logout")).click();
	  }
	/*Implicit wait:
	 * 1.No condition is specified here.
	 * 2.It waits only for visibility of the object.
	 * 3.It is specified once at the beginning.
	 * 4.It is always present in your program.
	 * 
	 * Explicit wait:
	 * 1.Condition is specified here.
	 * 2.It can wait for visibility,invisibility,alert,number of windows,title,etc.
	 * 3.It is specified multiple times.
	 * 4.It may or may not be present in your program.*/
	
	
	 @BeforeTest
	 @Parameters("browser")
	  public void beforeTest(String browser) {
		 if(browser.equals("chrome"))
		 {
		  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		  driver=new ChromeDriver();
		 }
		/* else if(browser.equals("firefox"))
		 {
		  System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		  driver=new FirefoxDriver();
		 }*/
		 else 
		 {
			 System.out.println("Invalid browser");
		 }
	  }

	  @AfterTest
	  public void afterTest() throws Exception{
		  Thread.sleep(2000);
		  driver.quit();
	  }
}
