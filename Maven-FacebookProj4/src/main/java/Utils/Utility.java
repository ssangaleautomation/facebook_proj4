package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	

	public static void captureScreenshot(WebDriver driver,String TESTID) throws IOException, InterruptedException {
	
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	
	Date d=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat(" dd-MM-YYYY HH-mm-sss");
	
	String timestamp=sdf.format(d);
	File tar=new File("C:\\Users\\sanja\\git\\facebook_proj4\\Maven-FacebookProj4\\test-output\\FailTestScreenshots\\"+TESTID+" "+ timestamp +".png");
	
//	FileUtils.copyFile(src, tar);
	FileHandler.copy(src, tar);
	Thread.sleep(800);
	
	} 
		
	public static String getExcelData(String sheetName,int rowNo,int cellNo) throws IOException  {
			
 String path="";
		
	FileInputStream file= new FileInputStream(path);
  
    Workbook book=WorkbookFactory.create(file);
   Sheet sheet=book.getSheet(sheetName); 
   Row row=sheet.getRow(rowNo);
  Cell cell=row.getCell(cellNo);
   String ExcelData;
    	
	try {
	      ExcelData =cell.getStringCellValue();
        }

	catch(IllegalStateException e) {
		 double value=cell.getNumericCellValue();
		 ExcelData=String.valueOf(value);
	   //ExcelData=Double.toString(value);
	}
	return ExcelData;	
	
	
	}	
	
}


