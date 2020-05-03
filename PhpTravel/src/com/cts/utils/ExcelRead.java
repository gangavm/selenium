package com.cts.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead
{
	XSSFWorkbook wb;
	public ExcelRead(String excel_path) throws IOException
	{
		File f=new File(excel_path);
		FileInputStream fi=new FileInputStream(f);
		wb=new XSSFWorkbook(fi);
	}
	public Object getData(String sheet_name,int row,int col)
	{
		XSSFSheet sht=wb.getSheet(sheet_name);
		String cell_data=sht.getRow(row).getCell(col).getStringCellValue();
		return cell_data;
	}
	public int rowcnt(String sheet_name)
	{
		int row=wb.getSheet(sheet_name).getLastRowNum();
		row=row+1;
		return row;
	}
}
