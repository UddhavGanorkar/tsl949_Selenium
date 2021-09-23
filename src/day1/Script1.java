package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class Script1 {

	public static void main(String[] args) throws Exception{
		
		  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		  ChromeDriver driver = new ChromeDriver();
		 
			/*
			 * System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
			 * FirefoxDriver driver = new FirefoxDriver();
			 */
		driver.get("https://www.twitch.tv/valorant");
		String s= driver.getTitle();
		System.out.println("You are on "+s+" page!!");
		driver.findElement(By.className("ScInputBase-sc-1wz0osy-0 ScTextArea-sc-1ywwys8-0 kYJGMC InjectLayout-sc-588ddc-0 iZLAMf tw-textarea tw-textarea--no-resize")).sendKeys("Lets go");
		driver.findElement(By.className("Layout-sc-nxg1ff-0 fLjesT")).click();
		//Thread.sleep(3000);
		//driver.quit();
	}

}
