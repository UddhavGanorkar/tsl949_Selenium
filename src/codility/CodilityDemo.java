package codility;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CodilityDemo extends WebDriverTestCase {

	@Test
	public void test() {
		webDriver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_search/6f03f4361b080eeb747193aadd94cd2b/static/attachments/reference_page.html");
		
		   boolean x = webDriver.findElement(By.id("search-input")).isDisplayed();
	       boolean y = webDriver.findElement(By.id("search-button")).isDisplayed();
	        assertTrue(x);
	        assertTrue(y);
	    }
	    @Test
	    public void test2() {
	       webDriver.findElement(By.id("search-button")).click();
	       String str = webDriver.findElement(By.id("error-empty-query")).getText();
	        assertEquals("Provide some query",str);
	        
	    }
	    @Test
	    public void test3() throws Exception{
	       webDriver.findElement(By.id("search-input")).sendKeys("isla");
	       webDriver.findElement(By.id("search-button")).click();
	       Thread.sleep(2000);
	       List<WebElement> ls =webDriver.findElements(By.xpath("//ul[@id='search-results']/li"));
	       assertTrue(ls.size()>1);
	        
	    }
	    @Test
	    public void test4() {
	       webDriver.findElement(By.id("search-input")).clear();
	       webDriver.findElement(By.id("search-input")).sendKeys("castle");
	       webDriver.findElement(By.id("search-button")).click();
	       String str = webDriver.findElement(By.id("error-no-results")).getText();
	        assertEquals("No results",str);
	        
	    }
	    @Test
	    public void test5() throws Exception{
	       webDriver.findElement(By.id("search-input")).clear();
	       webDriver.findElement(By.id("search-input")).sendKeys("port");
	       webDriver.findElement(By.id("search-button")).click();
	       Thread.sleep(2000);
	       List<WebElement> ls =webDriver.findElements(By.xpath("//ul[@id='search-results']/li"));
	       assertTrue(ls.size()==1);
	        
	    }
	}
