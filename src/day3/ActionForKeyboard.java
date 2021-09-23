package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionForKeyboard {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://bing.com");
		WebElement e = driver.findElement(By.name("q"));
		Actions ac = new Actions(driver);
		Action act=ac.keyDown(Keys.SHIFT)
		.sendKeys(e, "lti")
		.doubleClick(e)
		.contextClick(e)
		.build();
		act.perform();
	}

}
