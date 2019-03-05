package com.liquidation.utils;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.CellType;
import jxl.DateCell;
import jxl.LabelCell;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcelData {

	public static String fileName;
	public static Workbook workbook;
	public static Sheet sheet;

	public String readData(String searchString)
	{
		Cell cell = null;
		String str = null;
		
		File dir = new File(".//");
		
		try 
		{
			/*
			 * Loading the Inputreader.xls Data File
			 */
			fileName = dir.getCanonicalPath() + "//src//test/resources//InputReader.xls";
			
			/*
			 * Workbook object to load file name
			 */
			workbook = Workbook.getWorkbook(new File(fileName));
			
			// Loading the Sheet from Excel File
			sheet = workbook.getSheet(0);
			
			LabelCell lc = sheet.findLabelCell(searchString);
			
			int column = lc.getColumn();
			int row = lc.getRow();
			
			cell = sheet.getCell(++column, row);
			
			if(cell.getType() == CellType.LABEL)
			{
				LabelCell labelCell = (LabelCell) cell;
				str = labelCell.getContents();
			} else if(cell.getType() == CellType.NUMBER)
			{
				NumberCell numberCell = (NumberCell) cell;
				str = numberCell.getContents();
			} else if(cell.getType() == CellType.LABEL)
			{
				DateCell dateCell = (DateCell) cell;
				str = dateCell.getContents();
			} 
			
			
		} catch(IOException e)
		{
			e.printStackTrace();
		} catch(BiffException e)
		{
			e.printStackTrace();
		} catch(NullPointerException ne)
		{
			ne.printStackTrace();
		}
		return str;
	}

}
