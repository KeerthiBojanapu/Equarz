package com.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import com.Pageobjects.Homepage;
import com.base.Testbase;

public class AddressUtils extends Testbase{
@DataProvider
	
	public String[][] setdata() throws IOException
	{
		File file=new File("C:\\Users\\Dell\\git\\Eccomerce_Project\\com.Equarz.Ecommerce\\src\\main\\java\\com\\testdata\\Address (1).xlsx");
		FileInputStream stream=new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(stream);
		XSSFSheet sheet=workbook.getSheetAt(0);
		int rows=sheet.getPhysicalNumberOfRows();
		int columns=sheet.getRow(1).getLastCellNum();
		String[][] data=new String[rows-1][columns];
		for(int i=0;i<rows-1;i++) {
			for(int j=0;j<columns;j++)
			{
				DataFormatter df=new DataFormatter();
				data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}
			
			
		}
		return data;
		
	}
	public static Homepage dropdown(WebElement value, String text) {
		Select sel = new Select(value);
		sel.selectByValue(text);
        return new Homepage();
	

}

}
