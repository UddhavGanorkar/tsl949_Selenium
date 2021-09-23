package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageScrolling {

	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium.dev/");
		driver.manage().window().maximize();
		
		WebElement e = driver.findElement(By.linkText("@diegofmolina"));//scrolling till particular object
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", e);
		
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-300)");//scroll up vertically by 300 pixels
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,500)");//scroll down vertically by 500 pixels
		
		
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");//scroll down vertically till the end of the page
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");//scroll up vertically till start of the page 
	}

}
