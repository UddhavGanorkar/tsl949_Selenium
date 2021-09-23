package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BlazeDemoTask {

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
		driver.findElement(By.cssSelector("input[value='Choose This Flight']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#inputName")).sendKeys("Cristiano");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#address")).sendKeys("123 Duplicate street");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[name='city']")).sendKeys("Lisbon");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[name='state']")).sendKeys("Portugal");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#zipCode")).sendKeys("231312");
		Thread.sleep(2000);
		WebElement f3=driver.findElement(By.name("cardType"));
		Select s3 =new Select(f3);
		s3.selectByVisibleText("American Express");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[name='creditCardNumber']")).sendKeys("12123124");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[name='creditCardMonth']")).clear();
		driver.findElement(By.cssSelector("input[name='creditCardMonth']")).sendKeys("10");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[name='creditCardYear']")).clear();
		driver.findElement(By.cssSelector("input[name='creditCardYear']")).sendKeys("2021");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#nameOnCard")).sendKeys("Cristiano Ronaldo");
		Thread.sleep(2000);
		WebElement e= driver.findElement(By.cssSelector("input[name='rememberMe']"));
		boolean x=e.isDisplayed();
		boolean y=e.isEnabled();
		boolean z=e.isSelected();
		System.out.println("Displaying on screen:"+x);
		System.out.println("Enabled on screen:"+y);
		System.out.println("By default selected on screen:"+z);
		e.click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[value='Purchase Flight']")).click();
		Thread.sleep(3000);
		driver.quit();
		
	}

}
