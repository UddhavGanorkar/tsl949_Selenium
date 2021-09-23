package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By e_username=By.name("txtUsername");
	By e_pwd=By.id("txtPassword");
	By e_login=By.id("btnLogin");
	By e_forget= By.linkText("Forgot your password?");
	
	public void setUsername(String user)
	{
		driver.findElement(e_username).sendKeys(user);
	}
	public void setpwd(String pwd)
	{
		driver.findElement(e_pwd).sendKeys(pwd);
	}
	public void click_login()
	{
		driver.findElement(e_login).click();
	}
	public void do_login(String user,String pwd)
	{
		setUsername(user);
		setpwd(pwd);
		click_login();
	}
	public void forget()
	{
		driver.findElement(e_forget).click();
	}
}
