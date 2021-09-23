package codility;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class BingTask extends WebDriverTestCase {

	@Test
	public void test1() {
		webDriver.get("https://www.bing.com/");
		assertEquals("Bing",webDriver.getTitle());
		
	}
	@Test
	public void test2()throws Exception{
		webDriver.findElement(By.name("q")).sendKeys("Codility");
		webDriver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		List<WebElement> ls =webDriver.findElements(By.xpath("//ol[@id='b_results']/li"));
		System.out.println("Total links: "+ls.size());
		assertEquals(true,ls.size()>1);//check for at least one option
		assertTrue(ls.size()>1);//check for At least one option
		
	}
		
	}


