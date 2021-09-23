package day4;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class FirstScriptNG {
	WebDriver driver;
  @Test(priority=1,description="Verifying title of search page")
  public void googleTitleTest() {
	  System.out.println("Test1");
	  driver.get("https://google.com");
	  String actual_title = driver.getTitle();
	  Assert.assertEquals(actual_title, "Google India"); 
  }
  @Test(priority=2, description="Verifying title of search result page")
  public void googleSearchTest() {
	  System.out.println("Test2");
	  driver.findElement(By.name("q")).sendKeys("LTI");
	  driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	  String actual_title = driver.getTitle();
	  Assert.assertEquals(actual_title, "LTI - Google Search"); 
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before Method");
  }
  @AfterMethod
  public void afterMethod(ITestResult resp)throws Exception {
	  System.out.println("After Method");
	  if(resp.getStatus()==ITestResult.FAILURE)
	  {
		  TakesScreenshot tc = (TakesScreenshot)driver;
		  File src = tc.getScreenshotAs(OutputType.FILE);
		  FileHandler.copy(src, new File(resp.getName()+ ".png"));
	  }
  }
  @BeforeTest
  public void beforeTest() {
	  System.out.println("Before Test");
	  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	  driver=new ChromeDriver();
  }

  @AfterTest
  public void afterTest()throws Exception {
	  Thread.sleep(2000);
	  driver.quit();
	  System.out.println("After Test");
  }

}
