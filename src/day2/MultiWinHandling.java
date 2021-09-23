package day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiWinHandling {

	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		
		String pid= driver.getWindowHandle();
		System.out.println("Parent window id: "+pid);
		
		Set<String> allwin=driver.getWindowHandles();
		
		/*for(String id:allwin) //it works for every value in set/list/array
		{
			System.out.println(id);
			if(!id.equals(pid))
			{
				driver.switchTo().window(id);
				System.out.println(driver.getTitle());
				Thread.sleep(2000);
				driver.close();//it is for closing highlighted tab or window
			}
		}*/
		List<String> allwin2=new ArrayList<>(allwin);//converting set into list
		driver.switchTo().window(allwin2.get(1));//focusing on second window
		System.out.println("Second Windows title is"+driver.getTitle());
		for(int i=0;i<allwin2.size();i++)
		{
			String id=allwin2.get(i);
			if(!id.equals(pid))//if it is not a parent id (if it is a parent id)
			{
				driver.switchTo().window(id);
				System.out.println(driver.getTitle());
				Thread.sleep(2000);
				driver.close();
			}
		}
		
		Thread.sleep(2000);
		driver.quit();

	}

}
