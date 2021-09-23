package day2;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Rediff_task {

	public static void main(String[] args)throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.rediff.com/");
		String mid= driver.getWindowHandle();
		System.out.println("Parent id: "+mid);
		driver.manage().window().maximize();
		
	
		
		driver.switchTo().frame("moneyiframe");	
		driver.findElement(By.id("query")).sendKeys("Yes Bank LTD");
		driver.findElement(By.className("getqbtn")).click();
		Set<String> allwin=driver.getWindowHandles();
		for(String id :allwin)
		{
			System.out.println(id);
			if(!id.equals(mid))
			{
				driver.switchTo().window(id);
				System.out.println("Second Windows title is"+driver.getTitle());
				driver.close();
			}
		}
		Thread.sleep(2000);
		driver.quit();
	
	}
}

/*List <String>allid= new ArrayList<>(driver.getWindowHandle());
driver.switchTo().window(allid.get(1));*/
