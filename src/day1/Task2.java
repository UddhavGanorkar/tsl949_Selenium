package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {

	public static void main(String[] args)throws Exception {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.frontaccounting.eu/");
		WebElement un =driver.findElement(By.name("user_name_entry_field"));
		WebElement pwd=driver.findElement(By.name("password"));
		/*driver.findElement(By.name("user_name_entry_field")).clear();
		driver.findElement(By.name("password")).clear();*/
		un.clear();
		pwd.clear();
		un.sendKeys("demouser");
		pwd.sendKeys("password");
		/*driver.findElement(By.name("user_name_entry_field")).sendKeys("demouser");
		driver.findElement(By.name("password")).sendKeys("password");*/
		driver.findElement(By.name("SubmitUser")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(3000);
		driver.quit();
	}

}
