package day3;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangePoiIntegration {

	public static void main(String[] args)throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream("C:\\Users\\hp\\Desktop\\Book1.xls"));
		HSSFSheet sh = wb.getSheet("Sheet1");
		String data[][]= new String[3][2];
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<2;j++)
			{
				data[i][j]=sh.getRow(i).getCell(j).toString();
			}
		}

		for(int i=0;i<4;i++)
		{
			int j=0;
			driver.findElement(By.cssSelector("input#txtUsername")).sendKeys(data[i][j]);
			System.out.println(data[i][j]);
			j++;
			driver.findElement(By.cssSelector("input[type='password']")).sendKeys(data[i][j]);
			System.out.println(data[i][j]);
			driver.findElement(By.cssSelector("input[value=LOGIN]")).click();
			Thread.sleep(3000);
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
		driver.quit();
		
		
	}

}
