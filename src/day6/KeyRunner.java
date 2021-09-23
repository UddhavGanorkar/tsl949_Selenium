package day6;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fw.Base;
import fw.Excel;

public class KeyRunner extends Base {
  @Test(dataProvider= "dp")
  public void excelKeyRunner(String exKey,String locatorType,String locator,String locatorValue,String data) {
	/*  Keyword key = new Keyword(driver);
	  if(exKey.equals("getURL"))
		  key.getURL(data);
	  else if (exKey.equals("click"))
		  key.click(locatorType, locatorValue);
	  else if(exKey.equals("type"))
		  key.sendkeys(locatorType,locator,data);
	  else if(exKey.equals("selectFromDropDown"))
		  key.selectDropDown(locatorType, locatorValue, data);
	  else if(exKey.equals("getSnap"))
		  key.getSnap(data);
	  else
		  System.out.println("Invalid");
	  */
	  
  }
  
  
  @DataProvider
  public Object[][] dp() {
	  Excel ex = new Excel("Book1.xlsx");
	  Object data[][]= new Object[ex.getRow("Sheet5")-1][ex.getCol("Sheet5")];
	  for(int i=0;i<data.length;i++)
	  {
		  	data[i][0]=ex.getData("Sheet5",i+1,0);
			data[i][1]=ex.getData("Sheet5",i+1,1);
			data[i][2]=ex.getData("Sheet5",i+1,2);	
			data[i][3]=ex.getData("Sheet5",i+1,3);
		  
	  }
	  return data;
  }
}
