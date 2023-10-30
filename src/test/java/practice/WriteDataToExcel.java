package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToExcel 
{
	public static void main(String[] args) throws IOException
	{
		// step 1: open the document in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\WriteData.xlsx.xlsx");
		
		// step 2: Create workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		// step 3: Navigate to required sheet
		Sheet sh = wb.getSheet("Sheet1");
		
		// step 4: Navigate to required row
		Row rw = sh.createRow(1);
		
		// step 5: Navigate to required cell
		Cell cl = rw.createCell(2);
		
		// step 6: Capture the value
		cl.setCellValue("Kumar");
		
		// create an object for the fileoutstream
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\WriteData.xlsx.xlsx");
		
		wb.write(fos);

	}

}
