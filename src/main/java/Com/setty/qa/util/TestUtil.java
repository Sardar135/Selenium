package Com.setty.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Com.setty.qa.base.TestBase;
import Com.setty.qa.pages.LoginPage;

public class TestUtil extends TestBase{

	public TestUtil() throws IOException {
		super();
		PageFactory.initElements(driver, this);

	}

	public static long Page_Load_Timeout= 20;
	public static long Implicit_wait= 15;
	
	
	public static String TESTDATA_SHEET_PATH = "/Users/admin/Desktop/eclipse-workspace/ProjectRahulsetty/src/main/java/Com/setty/qa/testdata/Book 1.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	
	
	public static Object[][] getTestData(String sheetName) {   ///datadriven 
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		
//		TakesScreenshot scrShot =((TakesScreenshot)driver);
//		File SrcFile= scrShot.getScreenshotAs(OutputType.FILE);
//		File DestFile=new File(fileWithPath);
//		FileUtils.copyFile (SrcFile, DestFile);
//		


	}
	
}
