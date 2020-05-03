package com.cts.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead 
{
	XSSFWorkbook wb;
	public ExcelRead(String excelPath) throws IOException
	{
		File f=new File(excelPath);
		FileInputStream fi=new FileInputStream(f);
		wb=new XSSFWorkbook(fi);
	}
	public Object getDataCell(String sheetName,int row,int col)
	{
		XSSFSheet sht=wb.getSheet(sheetName);
		String cellData=sht.getRow(row).getCell(col).getStringCellValue();
		return cellData;
	}
	public int rowcnt(String sheetName)
	{
		int row=wb.getSheet(sheetName).getLastRowNum();
		row=row+1;
		return row;
	}
}
