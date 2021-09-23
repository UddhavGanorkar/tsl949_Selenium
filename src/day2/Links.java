package day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Links {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		List<WebElement> ls = driver.findElements(By.tagName("a"));
		System.out.println("Total links available are "+ls.size());
		for(int i=0;i<ls.size();i++)
		{
			System.out.println(i+1 +" Link have href as: ");
			System.out.println(ls.get(i).getAttribute("href"));
			
		}
	}

}
