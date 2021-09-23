package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultipleSelectDropDown  {

	public static void main(String[] args)throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.magneticautomation.in/p/dropdown.html");
		Select sc = new Select(driver.findElement(By.name("multi")));
		System.out.println("Is Multiple "+sc.isMultiple());
		sc.selectByVisibleText("One");
		Thread.sleep(2000);
		sc.selectByIndex(3);
		Thread.sleep(2000);
		sc.selectByValue("2");
		Thread.sleep(2000);
		sc.deselectByVisibleText("One");
		Thread.sleep(2000);
		sc.deselectAll();
		driver.quit();

	}

}
