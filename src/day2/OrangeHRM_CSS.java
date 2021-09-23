/*What is CSS:
------------
It is Used for controlling color, font, size, allingment etc. It is Used to controll GUI.
 
1.Using id  >  tagname#id
 
2.Using name/value/type/any other property> tagname[name/type/value='prop value']
    input[value='Find Flights']

3.Using ClassName > tagname.className*/
package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRM_CSS {

	public static void main(String[] args)throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		//tagname#id
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("admin");
		//input[type='']
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("admin123");
		//input[value=' ']
		driver.findElement(By.cssSelector("input[value=LOGIN]")).click();
		//tagname.classname
		driver.findElement(By.cssSelector("a.panelTrigger")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("a[href='/index.php/auth/logout']")).click();
		Thread.sleep(3000);
		driver.quit();
		
	}

}
