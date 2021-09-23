package day3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JDBC_task {

	public static void main(String[] args)throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","system","Newuser123");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		Statement st=con.createStatement();
		ResultSet result = st.executeQuery("select * from unpwd");
		while(result.next())
		{
			String a= result.getString("username");
			String b =result.getString("password");
			System.out.println(a+" "+b);
			driver.findElement(By.cssSelector("input#txtUsername")).sendKeys(a);
			driver.findElement(By.cssSelector("input[type='password']")).sendKeys(b);
			driver.findElement(By.cssSelector("input[value=LOGIN]")).click();
			
			if(driver.getCurrentUrl().contains("dashboard"))
			{
				System.out.println("Valid Login");
				driver.findElement(By.cssSelector("a.panelTrigger")).click();
				Thread.sleep(3000);
				driver.findElement(By.cssSelector("a[href='/index.php/auth/logout']")).click();
				Thread.sleep(3000);
			}
			else
			{
				System.out.println("Invalid Login");
				
			}
		}
		
		result.close();
		con.close();
		driver.quit();

	}

}
