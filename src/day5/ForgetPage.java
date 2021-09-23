package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgetPage {
	WebDriver driver;
	public ForgetPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	By e_username=By.name("securityAuthentication[userName]");
	By e_reset = By.id("btnSearchValues");
	By e_cancel = By.id("btnCancel");
	
	public void doReset(String username)
	{
		driver.findElement(e_username).sendKeys(username);
		driver.findElement(e_reset).click();
	}
	public void doCancel()
	{
		driver.findElement(e_cancel).click();
	}
}
