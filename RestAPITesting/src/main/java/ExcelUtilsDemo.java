import utils.exceldata;

public class ExcelUtilsDemo {
	public static void main(String[] args) {
		
		String projectPath = System.getProperty("user.dir");
		exceldata excel = new exceldata(projectPath+"/Data/Book.xlsx", "Sheet1");
		
		excel.getRowCount();
		excel.getCellDataString(1, 0);
		excel.getCellDataNumber(1, 1);
	
	}

}
