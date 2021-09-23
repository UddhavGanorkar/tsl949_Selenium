package day5_factory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	@FindBy(name="txtUsername") WebElement e_user;	
	@FindBy(id="txtPassword") WebElement e_pwd;
	@FindBy(id="btnLogin") WebElement e_login;
	@FindBy(linkText="Forgot your password?") WebElement e_forget;
	
	public void setUsername(String user)
	{
		e_user.sendKeys(user);
	}
	public void setpwd(String pwd)
	{
		e_pwd.sendKeys(pwd);
	}
	public void click_login()
	{
		e_login.click();
	}
	public void do_login(String user,String pwd)
	{
		setUsername(user);
		setpwd(pwd);
		click_login();
	}
	public void forget()
	{
		e_forget.click();
	}
}
