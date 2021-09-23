package day6;

import org.testng.annotations.Test;

import fw.Base;

public class Runner extends Base {
  @Test
  public void f() {
	  Keyword key = new Keyword(driver);
	 /* key.getURL("https://www.facebook.com/");
	  key.sendkeys("name", "email", "abcd@gmail.com");
	  key.click("name", "login");
	  key.getSnap("facebook.png");*/
	  key.getURL("https://blazedemo.com/");
	  key.selectDropDown("name", "toPort","London");
  }
}
