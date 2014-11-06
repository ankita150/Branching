package com.company.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

public class excel {
	private FileInputStream file;
	private HSSFWorkbook workbook;
	private HSSFSheet sheet;
	private HSSFCell cell;
	private DataFormatter formatter;
	public void setExcel(String path,String sheetname) throws IOException
	{
		file = new FileInputStream(path);       //File locate
		workbook = new HSSFWorkbook(file);      //workbook create
		sheet = workbook.getSheet(sheetname);
		//we can also give sheetnumber
	}
	public int totalRows(){	
		int noOfRows = sheet.getLastRowNum();
		System.out.println("total rows ="+noOfRows);
		return noOfRows;
	}
	public int totalColumn(int row){	
		int noOfColumn = sheet.getRow(row).getLastCellNum();
		System.out.println("total rows ="+noOfColumn);
		return noOfColumn;
	}
	public String getcellvalue(int row,int col)
	{
		cell = sheet.getRow(row).getCell(col);
		formatter = new DataFormatter();
		return formatter.formatCellValue(cell);
//		return cell.getStringCellValue();
	}
	
	

}

