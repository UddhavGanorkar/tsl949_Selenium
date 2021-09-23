package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Drop_down {

	public static void main(String[] args)throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://blazedemo.com/");
		WebElement f=driver.findElement(By.name("fromPort"));
		Select s =new Select(f);
		s.selectByVisibleText("Mexico City");
		Thread.sleep(2000);
		s.selectByIndex(2);
		Thread.sleep(2000);
		s.selectByValue("Portland");
		Thread.sleep(5000);
		driver.quit();
		
	}

}
