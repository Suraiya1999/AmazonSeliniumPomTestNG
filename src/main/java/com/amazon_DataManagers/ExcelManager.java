package com.amazon_DataManagers;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelManager {
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	private int column;

	public ExcelManager(String excelPath, String sheetName) {
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getRowCount() {
		int rowCount = 0;
		rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("number of rows>>>>" + rowCount);
		return rowCount;
	}

	public int getColumnCount() {
		int colCount = 0;
		colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("number of column is  " + colCount);
		return colCount;
	}

	public String getStringCellData(int row, int column) {
		String cellData = null;
		cellData = sheet.getRow(row).getCell(column).getStringCellValue();
		System.out.println(cellData);
		return cellData;
	}

	public Double getNumericCellData(int row, int column) {
		Double cellData = null;
		cellData = sheet.getRow(row).getCell(column).getNumericCellValue();
		System.out.println(cellData);
		return cellData;
	}

	public static void main(String[] args) {
		String projectpath = System.getProperty("user.dir");
		String filepath = "\\src\\main\\resources\\config\\data.xlsx";
		String excelPath = projectpath + filepath;
		ExcelManager excel = new ExcelManager(excelPath, "Sheet1");
		excel.getRowCount();
		excel.getColumnCount();		
		excel.getStringCellData(1, 0);
		excel.getStringCellData(4, 1);
	
		
	}
}




