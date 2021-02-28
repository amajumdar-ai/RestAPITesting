package utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class exceldata {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	public exceldata(String excelPath,XSSFSheet sheet ) throws IOException
	{
		String excelPath1="/Users/manish/RestAPITesting/RestAPITesting/src/main/java/Data/Book.xlsx";
		 workbook= new XSSFWorkbook(excelPath1);
		 sheet=workbook.getSheet("Sheet1");
		int no=sheet.getPhysicalNumberOfRows();
		System.out.print("no of rows="+no);
		
		DataFormatter d=new DataFormatter();
		Object value=d.formatCellValue(sheet.getRow(1).getCell(2));
		System.out.print("no of cell="+value);
		
	}
	public static void main(String [] args) throws IOException {
		rowCount();
	}
	private static void rowCount() {
		// TODO Auto-generated method stub
		
	}

}
