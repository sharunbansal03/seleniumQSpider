package com.timeKeeping.actiTime.Selenium.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String fetchDataFromExcelFile(String sheetName, int rowNo, int cellNo) throws IOException {

		FileInputStream fis = new FileInputStream("./src/test/resources/ExcelTestData.xlsx");
		Workbook workBook = WorkbookFactory.create(fis);
		Sheet sheet = workBook.getSheet(sheetName);
		return sheet.getRow(rowNo).getCell(cellNo).getStringCellValue();
	}
}

//abstraction -- implementation provided by RemoteWebDriver class
//takescreenshot
//webdriver method

//inheritancde - a;; TS extending baseclass
//pom classes - encaplsulation
//exception