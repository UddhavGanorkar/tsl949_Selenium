package day4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRM_Task {

	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		List<WebElement> ls = driver.findElements(By.tagName("img"));
		System.out.println("Total images available are "+ls.size());
		HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream("C:\\Users\\hp\\Desktop\\Book1.xls"));
		HSSFSheet sh = wb.getSheet("Sheet2");
		for(int i=0;i<ls.size();i++)
		{
			System.out.println(i+1 +" Image have src as: ");
			System.out.println(ls.get(i).getAttribute("src"));
			sh.createRow(i).createCell(0).setCellValue(ls.get(i).getAttribute("src")); 
			 
		}
		 
		wb.write(new FileOutputStream("C:\\Users\\hp\\Desktop\\Book3.xls"));
		
	}

}
