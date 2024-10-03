package Utility;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

import com.google.gson.Gson;
import com.jayway.jsonpath.JsonPath;


import comp_LoginPage.LoginPageWebElement;

public class DataUtils {
	
	public final static String CONFIG_PATH = "./Resources/";

	public static String Login_Data_Jason_Path = "./Resources/";

	public String userName;

	public String Password;
	
	public static String getExcelData(String excelFilePath, String excelFilename, String sheetName, int rowNum,
			int colNum) {
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		String cellData = null;

		try {
			// Load the Excel file
			FileInputStream file = new FileInputStream(excelFilePath + excelFilename);
			workbook = new XSSFWorkbook(file);

			sheet = workbook.getSheet(sheetName);

			// Get the data from the specified cell
			//cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			 Row row = sheet.getRow(rowNum);
		        if (row != null) {
		            
		            Cell cell = row.getCell(colNum);
		            if (cell != null) {
		                
		                switch (cell.getCellType()) {
		                    case STRING:
		                        cellData = cell.getStringCellValue();
		                        break;
		                    case NUMERIC:
		                        cellData = String.valueOf(cell.getNumericCellValue());
		                        break;
		                    case BOOLEAN:
		                        cellData = String.valueOf(cell.getBooleanCellValue());
		                        break;
		                    case FORMULA:
		                        cellData = cell.getCellFormula();
		                        break;
		                    default:
		                        cellData = "";
		                }
		            } else {
		                System.out.println("Cell at row " + rowNum + " and column " + colNum + " is null.");
		            }
		        } else {
		            System.out.println("Row " + rowNum + " is null.");
		        }

			workbook.close();
			return cellData;
		} catch (IOException e) {
			System.out.println("Error reading Excel file: " + e.getMessage());
			return null;
		}
	}
	
	public static String getAllExcelData(String excelFilePath, String excelFilename, String sheetName) {
		try {
			// Load the Excel file
			FileInputStream file = new FileInputStream(excelFilePath + excelFilename);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(sheetName);
 
			// Iterate through all the rows in the Excel sheet
			Iterator<Row> rowIterator = sheet.iterator();
 
 
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
 
				// Fetch username and password from the current row
				String userName = row.getCell(0).getStringCellValue();  // ---> Column 0 (Username)
				String Password = row.getCell(1).getStringCellValue();  // ---> Column 1 (Password)
 
 
 
 
				System.out.println("Username: " + userName + ", Password: " + Password);
 
				LoginPageWebElement webElement = new LoginPageWebElement();
				WebElement userNameElement= webElement.getUserNameField();
				WebElement PasswordElement = webElement.getPassField();
				WebElement loginButton = webElement.getLoginBtnField();
 
				userNameElement.clear();
				userNameElement.sendKeys(userName);
				PasswordElement.clear();
				PasswordElement.sendKeys(Password);
				loginButton.click();
				settingUpWebDriver.getDriver().navigate().back();
 
			}
 
 
			workbook.close();
 
 
		} catch (IOException e) {
			System.out.println("Error reading Excel file: " + e.getMessage());
		}
 
		return null;
	}
	
	
	public static String getJsonValue(String jsonFilename, String field) {
	    try {
	    	// reading the json file
	        FileReader reader = new FileReader(Login_Data_Jason_Path + jsonFilename + ".json");
	        // pasrsing the json file content into a generic object
	        Object jsonData = new Gson().fromJson(reader, Object.class);
	        // using JsonPath to extract the value of the specifed field from the JSON object
	        return JsonPath.read(jsonData, "$." + field);
	    } catch (Exception e) {
	        return "";
	    }
	}

}
