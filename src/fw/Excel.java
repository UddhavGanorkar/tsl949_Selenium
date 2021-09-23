package fw;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	Workbook wb;
	public Excel(String pathwithfilename)
	{
		try
		{
			if(pathwithfilename.endsWith(".xls"))
			{
				 wb = new HSSFWorkbook(new FileInputStream(pathwithfilename));
			}
			else if(pathwithfilename.endsWith(".xlsx"))
			{
				 wb = new XSSFWorkbook(new FileInputStream(pathwithfilename));
			}
		}
		catch(Exception E)
		{
			System.out.println(" "+E.getMessage());
		}
	}
	public String getData(String sheetname,int row,int col)
	{
		String data = wb.getSheet(sheetname).getRow(row).getCell(col).toString();
		return data;
	}
	public int getRow(String sheetname)
	{
		int row = wb.getSheet(sheetname).getLastRowNum()+1;
		return row;
	}
	public int getCol(String sheetname)
	{
		int col = wb.getSheet(sheetname).getRow(0).getLastCellNum();
		return col;
	}
}
