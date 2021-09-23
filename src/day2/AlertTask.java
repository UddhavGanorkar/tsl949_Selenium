package day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTask {

	public static void main(String[] args)throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.easemytrip.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("Editbox13_show")).clear();
		driver.findElement(By.id("Editbox13_show")).click();
		driver.findElement(By.cssSelector("span#spn12")).click();
		driver.findElement(By.cssSelector("input[onclick='SearchFlightWithArmy();']")).click();
		//driver.findElement(By.cssSelector("input.src_btn")).click();
		//driver.findElement(By.xpath("1")).click();;
		Alert a= driver.switchTo().alert();
		System.out.println(a.getText());
		a.accept();
		Thread.sleep(2000);
		driver.quit();

	}

}
