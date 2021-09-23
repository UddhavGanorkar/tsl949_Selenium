package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class Locator_exp {

	public static void main(String[] args) throws Exception{
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		/*driver.get("https://selenium.dev");
		String s= driver.getTitle();
		System.out.println("You are on "+s+" page!!");
		driver.findElement(By.linkText("Downloads")).click();
		String title2 = driver.getTitle();
		System.out.println("You are on "+title2+" page!!");
		Thread.sleep(3000);
		driver.quit();*/
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("welcome")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(3000);
		driver.quit();
		
	}

}
