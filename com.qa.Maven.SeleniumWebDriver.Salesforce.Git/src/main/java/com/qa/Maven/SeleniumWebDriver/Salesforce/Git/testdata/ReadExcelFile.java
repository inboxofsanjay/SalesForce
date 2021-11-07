package com.qa.Maven.SeleniumWebDriver.Salesforce.Git.testdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadExcelFile {
	
	public static void main(String[] args) throws FileNotFoundException{
		String sFile = System.getProperty("user.dir")+"\\src\\main\\java\\salesforce.xls";
	
		try {
			FileInputStream fi = new FileInputStream(sFile);
			HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(sFile));
//			HSSFWorkbook myExcelBook = new HSSFWorkbook(fi);
			HSSFSheet myExcleSheet = myExcelBook.getSheet("TestData");
			HSSFRow login = myExcleSheet.getRow(0);
			System.out.println(login);
			System.out.println(login.getCell(0).getStringCellValue());
			System.out.println(login.getCell(1).getStringCellValue());
			System.out.println(login.getCell(2).getStringCellValue());
			HSSFRow credentials = myExcleSheet.getRow(1);
			System.out.println(credentials.getCell(0).getStringCellValue());
			System.out.println(credentials.getCell(1).getStringCellValue());
			System.out.println(credentials.getCell(2).getStringCellValue());
			System.out.println(credentials);
			myExcelBook.close();
			
		}catch(Exception a) {
			System.out.println(a);
		}

	}
	
	
	
}
