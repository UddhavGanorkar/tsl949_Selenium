package day5;

import org.testng.annotations.Test;

import fw.Excel;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

//import java.io.FileInputStream;

//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class DataDrivenExcel {
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
	  public void afterTest()throws Exception{
		  Thread.sleep(2000);
		  driver.quit();
		 // System.out.println("After Test");
	  }
	  @DataProvider
	  public Object[][] dp() {
		 
		  Excel e = new Excel("C:\\Users\\hp\\Desktop\\Book1.xls");
		  
		  Object data[][]=new Object[e.getRow("Sheet1")][e.getCol("Sheet1")];
		 for(int i=0;i<data.length;i++)
		 {
				 data[i][0] = e.getData("Sheet1", i, 0);
				 data[i][1] = e.getData("Sheet1", i, 1);
			 
		 }
		  return data;
	    };

}
