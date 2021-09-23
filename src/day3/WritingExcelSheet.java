package day3;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class WritingExcelSheet {

	public static void main(String[] args)throws Exception {
		HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream("C:\\Users\\hp\\Desktop\\Book1.xls"));
		HSSFSheet sh = wb.getSheet("Sheet1");
		sh.getRow(1).getCell(1).setCellValue("dummy");
		sh.getRow(2).createCell(2).setCellValue("LTI");
		sh.createRow(4).createCell(2).setCellValue("Hello");
		
		wb.write(new FileOutputStream("C:\\Users\\hp\\Desktop\\Book1_copy.xls"));

	}

}
