package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/hp/Desktop/iframe.html");
		driver.switchTo().frame("front");
		driver.findElement(By.name("user_name_entry_field")).clear();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(1);
		driver.findElement(By.name("q")).sendKeys("admin");
		driver.switchTo().defaultContent();
		
		WebElement e = driver.findElement(By.className("dummy"));
		driver.switchTo().frame(e);
		driver.findElement(By.cssSelector("button[aria-label='Search']")).click();
	}

}
