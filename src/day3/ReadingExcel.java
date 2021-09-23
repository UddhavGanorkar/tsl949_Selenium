package day3;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcel {

	public static void main(String[] args)throws Exception {
		HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream("C:\\Users\\hp\\Desktop\\Book1.xls"));
		HSSFSheet sh = wb.getSheet("Sheet1");
		//String data = sh.getRow(0).getCell(1).toString();
		//String data[][]= new String[3][2];
		//System.out.println(data);
		
		for(int i=0;i<4;i++)
		{
			String user = sh.getRow(i).getCell(0).toString();
			System.out.print(user+" ");
			String pwd = sh.getRow(i).getCell(1).toString();
			System.out.println(pwd+" ");
		}
	}

}
