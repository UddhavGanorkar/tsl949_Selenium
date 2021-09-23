package day3;



import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class MouseHoverOrangeHRM {

	public static void main(String[] args)throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("admin");

		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("admin123");

		driver.findElement(By.cssSelector("input[value=LOGIN]")).click();
		
		Actions ac =new Actions(driver);//Action class is used to work with mouse hover and keyboard controlling
		WebElement e = driver.findElement(By.linkText("Recruitment"));
		ac.moveToElement(e).perform();
		ac.click(driver.findElement(By.linkText("Vacancies"))).perform();
		TakesScreenshot tc=(TakesScreenshot)driver;
		File src = tc.getScreenshotAs(OutputType.FILE);//After taking ss it will store it in buffer memory
		FileHandler.copy(src, new File ("Orange.png"));//copying file from buffer memory to actual memory
		/*Thread.sleep(2000);
		
		driver.quit();*/
		
	}

}
