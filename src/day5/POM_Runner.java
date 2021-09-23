package day5;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.junit.Assert;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class POM_Runner {
  WebDriver driver;
  LoginPage lp;
	@Test(description="Checking forget link of login page")
  public void forgetpagetest() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		 lp = new LoginPage(driver);
		lp.forget();
		Assert.assertTrue(driver.getCurrentUrl().contains("requestPasswordResetCode"));
  }
	@Test(dependsOnMethods="forgetpagetest",description="Checking cancel button on forget page")
	  public void cancelButtontest() {
			
			ForgetPage fp = new ForgetPage(driver);
			fp.doCancel();;
			Assert.assertTrue(driver.getCurrentUrl().contains("auth/login"));
	  }
	@Test(dependsOnMethods="cancelButtontest",description="Checking login to home page")
	  public void logintest()throws Exception {
		lp.do_login("Admin","admin123");
		Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard"));
	  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	  driver=new ChromeDriver();
  }

  @AfterTest
  public void afterTest() throws Exception{
	  Thread.sleep(2000);
	  driver.quit();
  }

}
