package com.crm.qa.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;

	 
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

public static void takeScreenshotAtEndOfTest() {
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(src, new File("screenshot//"+System.currentTimeMillis()+ ".png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
	
	
public static Object[][] getData(String fileName, String sheetName)
{

	FileInputStream fis = null;
	try {
		fis = new FileInputStream("src//main//java//com//crm//qa//testdata//"+ fileName);
	} catch (FileNotFoundException e) {

		e.printStackTrace();
	} 
	XSSFWorkbook workbook = null;
	try {
		workbook = new XSSFWorkbook(fis);
	} catch (IOException e) {
		e.printStackTrace();
	} 
	
	//Getting the right sheet
	XSSFSheet sheet = null;  //creating a sheet obj
	int sheets = workbook.getNumberOfSheets();
	System.out.println("There are " + sheets + " sheets in the excel file you chose");
	
	sheet = workbook.getSheet(sheetName);
	int n = sheet.getLastRowNum();
	System.out.println(n + " - Rows");
	int m = sheet.getRow(0).getLastCellNum();
	System.out.println(m + " - Columns");

	
	Object[][] data = new Object[n][m];
	
	for(int i = 0 ; i<n ; i++) {
		for( int j = 0 ; j<m ; j++)
		{
			data[i][j] = sheet.getRow(i+1).getCell(j).toString();
		}
	}
	return data;
}
	
	
}
