package day6;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Keyword {
	WebDriver driver;
	public Keyword(WebDriver driver)
	{
		this.driver=driver;
	}
	public void getURL(String url)
	{
		driver.get(url);
	}
	public WebElement getElement(String locatorType, String locator)
	{
		WebElement E=null;

		if(locatorType.equals("id"))
			E=driver.findElement(By.id(locator));
		else if(locatorType.equals("name"))
			E=driver.findElement(By.name(locator));
		else if(locatorType.equals("link"))
			E=driver.findElement(By.linkText(locator));
		else if(locatorType.equals("css"))
			E=driver.findElement(By.cssSelector(locator));
		else if(locatorType.equals("xpath"))
			E=driver.findElement(By.xpath(locator));
		else
			System.out.println("Invalid Locator");
		return E;
	}
	public void click(String locatorType, String locator)
	{
		getElement(locatorType, locator).click();
	}
	/*public void type(String locatorType, String locator,String data)
	{
		getElement(locatorType, locator).sendKeys(data);
	}*/
	public void sendkeys(String locatorType, String locator, String data)
	{
		getElement(locatorType, locator).sendKeys(data);
	}
	public void getSnap(String pathWithFileName)
	{
	TakesScreenshot tc = (TakesScreenshot)driver;
	File src = tc.getScreenshotAs(OutputType.FILE);
	try {
		FileHandler.copy(src, new File(pathWithFileName));
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	public void selectDropDown(String locatorType,String locator,String data)
	{
		Select s =new Select(getElement(locatorType, locator));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s.selectByVisibleText(data);;
	}
}

