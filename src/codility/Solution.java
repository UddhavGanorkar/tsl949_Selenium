package codility;

import java.util.List;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Solution extends WebDriverTestCase{

	@Test
	public void test() {
		webDriver.get("https://jmeter.apache.org/");
		List<WebElement> ls =webDriver.findElements(By.xpath("//div[@class='nav']/ul[3]/li/ul/li/a"));
		
		assertEquals(10,ls.size());//check for exact match
		
		assertEquals(true,ls.size()>1);//check for at least one option
		assertTrue(ls.size()>1);//check for At least one option
		
		
	}

}
