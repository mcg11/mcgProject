package com.ziroom.account.APITest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileUtil {

	public static void main(String[] args) throws IOException {

		InputStream is = new FileInputStream("d:\\111.xlsx");
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
		XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
		int rowNum = xssfSheet.getLastRowNum();
		
		for(int i =1;i<=rowNum;i++){
			List<Object> list = new ArrayList<Object>();
			Object obj = null;
			XSSFRow xssfRow = xssfSheet.getRow(i);
			if (xssfRow != null) {
				for (int colNum = 0; colNum < xssfRow.getLastCellNum(); colNum++) {
					obj = getValue(xssfRow.getCell(colNum)).trim();
					list.add(obj);
				}
			}
			System.out.println("解析出的list：=====" + list);
		}
	}
	
	public static String getValue(XSSFCell xssfRow) {
		if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
			return String.valueOf(xssfRow.getBooleanCellValue());
		} else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
			DecimalFormat df = new DecimalFormat("0");  
		     String strCell = df.format(xssfRow.getNumericCellValue()); 
//			xssfRow.setCellType(xssfRow.CELL_TYPE_STRING);
//			return String.valueOf(xssfRow.getStringCellValue());
			return strCell;
		} else {
			return String.valueOf(xssfRow.getStringCellValue());
		}
	}

}
