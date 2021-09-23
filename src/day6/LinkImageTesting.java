package day6;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class LinkImageTesting {
	WebDriver driver;
	Properties prop;
	@Test
  public void linkTest()throws Exception {
	  driver.get(prop.getProperty("url"));
	  List <WebElement> links =driver.findElements(By.tagName("a"));
	  for(int i=0;i<links.size();i++)
	  {
		 String href= links.get(i).getAttribute("href");
		 URL url = new URL(href);
		 URLConnection con = url.openConnection();
		 HttpURLConnection httpcon = (HttpURLConnection)con;
		 httpcon.connect();
		 int code = httpcon.getResponseCode();
		 if(code==200)
		 {
			 System.out.println(url+" Working");
		 }
		 else
		 {
			 System.out.println(url+" Not Working"+code);
		 }
	  }
  }
  @BeforeTest
  public void beforeTest()throws Exception {
	  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	  ChromeOptions op = new ChromeOptions();
	  op.addArguments("--headless");
	  driver=new ChromeDriver(op);
	  prop = new Properties();
	  prop.load(new FileInputStream("settings.property"));
	  
  }

  @AfterTest
  public void afterTest()throws Exception {
	  Thread.sleep(2000);
	  driver.quit();
  }

}
