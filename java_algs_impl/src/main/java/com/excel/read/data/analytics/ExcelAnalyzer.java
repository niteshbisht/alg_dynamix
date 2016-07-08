package com.excel.read.data.analytics;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//..

public class ExcelAnalyzer {

	public static void main(String[] args) throws IOException {
		FileInputStream file = new FileInputStream(new File("D:\\pocs\\file1.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook (file);

		//Get first sheet from the workbook
		XSSFSheet sheet = workbook.getSheetAt(0);

		//Get iterator to all the rows in current sheet
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = (Row) rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = (Cell) cellIterator.next();
				System.out.println(cell.getCellStyle().toString());
				//System.out.print(cell.toString()+" ");
				if(cell.getAddress().toString().contains("F")){
					
				}
			}
			System.out.println();
		}
		
	}
	
}
