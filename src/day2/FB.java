package day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FB {

	public static void main(String[] args)throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Create New Account")).click();
		driver.findElement(By.cssSelector("input[value='2']")).click();
		List<WebElement> ls = driver.findElements(By.name("sex"));
		System.out.println("Total options are :"+ls.size());
		for(int i=0;i<ls.size();i++)
		{
			Thread.sleep(2000);
			ls.get(i).click();
		}
		
		

	}

}
