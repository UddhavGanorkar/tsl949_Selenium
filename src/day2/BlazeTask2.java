package day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BlazeTask2 {

	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://blazedemo.com/");
		
		WebElement f1=driver.findElement(By.name("fromPort"));
		Select s =new Select(f1);
		s.selectByVisibleText("Mexico City");
		Thread.sleep(2000);
		WebElement f2=driver.findElement(By.name("toPort"));
		Select s2 =new Select(f2);
		s2.selectByVisibleText("London");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[value='Find Flights']")).click();
		List<WebElement> ls = driver.findElements(By.cssSelector("input[value='Choose This Flight']"));
		System.out.println("Total Flight options are: "+ls.size());
		ls.get(1).click();
	}

}
