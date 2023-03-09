package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelreadwrite {
private static final int STRING = 0;
private static final int NUMERIC = 0;
String a;

public  String fileRead() throws IOException
{
	String excelfilepath = System.getProperty("user.dir") + "\\src\\main\\resources\\excelfiles\\Book6.xlsx";
	FileInputStream inputstream=new FileInputStream(excelfilepath);
	XSSFWorkbook workbook=new XSSFWorkbook(inputstream);
	XSSFSheet sheet=workbook.getSheetAt(0);
	int rows=sheet.getLastRowNum();
	int cols=sheet.getRow(0).getLastCellNum();
	for(int i=0;i<=rows;i++)
	{
		XSSFRow row=sheet.getRow(i);
		for(int c=0;c<cols;c++)
		{
			XSSFCell cell=row.getCell(c);
			switch (cell.getCellType()) {
			case STRING:
		    a=cell.getStringCellValue() ;
			System.out.print(a);
			break;
			case NUMERIC:
			System.out.print(cell.getNumericCellValue() + "\t");
			break;
			case BOOLEAN:
			System.out.print(cell.getBooleanCellValue() + "\t");
			break;
			default :
			
		}
		System.out.println();
		
	}
		
}
	return a;
}
}

