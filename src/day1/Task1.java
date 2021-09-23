package day1;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Task1 {

	public static void main(String[] args)throws Exception {
		Scanner s= new Scanner(System.in);
		System.out.println("Select the browser: 1.Chrome 2.Firefox");
		int x=s.nextInt();
		WebDriver driver=null;
		switch(x)
		{
		case 1:
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			 driver = new ChromeDriver();
			break;
		case 2:
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
			 driver = new FirefoxDriver();
			break;
		}
		if(driver!=null)
		{
		driver.get("https://selenium.dev");
		String a1= driver.getTitle();
		System.out.println("You are on "+a1+" page!!");
		Thread.sleep(3000);
		driver.quit();
		}

	}

}
