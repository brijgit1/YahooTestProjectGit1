package testUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.YahooTestBBS.Base.TestBase;

public class TestUtilities extends TestBase{
	
	//public static String TestDataSheetPath="C:\\Users\\Dell\\workspace\\SeleniumProject_Marse\\YahooTestProject\\src\\main\\java\\dataTables\\DataSheet.xlsx";
	public static String TestDataSheetPath="\\src\\main\\java\\dataTables\\DataSheet.xlsx";

	static Workbook workbook;
	static Sheet sheet;
	static Method method;
	
	public static Object[][] xlsDataReader(String sheetName){
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(System.getProperty("user.dir")+TestDataSheetPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			workbook=WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet=workbook.getSheet(sheetName);
		
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i<sheet.getLastRowNum();i++){
			for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++){
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				
			}
			
		}
		
		return data;
	}
	
	public static void captureScreen(){
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currDir=System.getProperty("user.dir");
		try {
			FileUtils.copyFile(file, new File(currDir+"/screenShots/"+System.currentTimeMillis()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
