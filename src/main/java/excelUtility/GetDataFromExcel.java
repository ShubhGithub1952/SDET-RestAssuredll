package excelUtility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetDataFromExcel {
    public String getDataFromExcelFile(String sheetName,int rowNum,int cellNum) throws Throwable {
    	Workbook workbook = WorkbookFactory.create(new FileInputStream("./src/test/resources/BDDProject.xlsx"));
    	Sheet sheet = workbook.getSheet(sheetName);
    	Row row = sheet.getRow(rowNum);
    	Cell cell = row.getCell(cellNum);
    	//String cellValue = cell.getStringCellValue();//Should not use 
    	DataFormatter Format = new DataFormatter();
    	 String value = Format.formatCellValue(cell);
    	 return value;
    }
}
