package day4;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class DataDrivenTesting {
	WebDriver driver;
  @Test(dataProvider = "dp")
  public void loginTest(String user, String pwd) throws Exception{
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  driver.findElement(By.name("txtUsername")).sendKeys(user);
	  driver.findElement(By.name("txtPassword")).sendKeys(pwd);
	  driver.findElement(By.name("Submit")).click();
	  driver.findElement(By.id("welcome")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.linkText("Logout")).click();
  }
  @BeforeTest
  public void beforeTest() {
	  //System.out.println("Before Test");
	  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	  driver=new ChromeDriver();
  }

  @AfterTest
  public void afterTest()throws Exception {
	  Thread.sleep(2000);
	  driver.quit();
	 // System.out.println("After Test");
  }
  @DataProvider
  public Object[][] dp() {
   
	  Object data[][]=new Object[4][2];
	  data[0][0]="admin";
	  data[0][1]="admin123";
	  data[1][0]="hr";
	  data[1][1]="hr123";
	  data[2][0]="admin";
	  data[2][1]="admin123";
	  data[3][0]="demo";
	  data[3][1]="demo123";
	  return data;
    };
  }

