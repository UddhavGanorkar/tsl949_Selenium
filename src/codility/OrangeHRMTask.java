package codility;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OrangeHRMTask extends WebDriverTestCase{

	@Test
	public void test1() {
		webDriver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		webDriver.findElement(By.id("btnLogin")).click();
		assertEquals("Username cannot be empty", webDriver.findElement(By.id("spanMessage")).getText());
	}
	@Test
	public void test2() {
		webDriver.findElement(By.name("txtUsername")).sendKeys("Admin");
		webDriver.findElement(By.id("btnLogin")).click();
		assertEquals("Password cannot be empty", webDriver.findElement(By.id("spanMessage")).getText());
	}
	@Test
	public void test3() {
		webDriver.findElement(By.name("txtUsername")).clear();
		webDriver.findElement(By.name("txtUsername")).sendKeys("Admin123");
		webDriver.findElement(By.name("txtPassword")).sendKeys("admin433");
		webDriver.findElement(By.id("btnLogin")).click();
		assertEquals("Invalid credentials", webDriver.findElement(By.id("spanMessage")).getText());
	}

}
