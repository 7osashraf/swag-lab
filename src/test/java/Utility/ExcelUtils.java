package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils{

	 // Full Excel File
    public Workbook workbook;

    // Constructor to load the Excel file
    public ExcelUtils(String excelFilePath) throws IOException {
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        workbook = new XSSFWorkbook(inputStream);
    }

    // Method to read login data (username and password)
    public String[][] getLoginData(String sheetName) throws IOException {
        Sheet sheet = workbook.getSheet(sheetName);
        int TotalNumberOfRow = sheet.getLastRowNum();
        int TotalNumberOfColumn = sheet.getRow(0).getLastCellNum();
        
        String[][] data = new String[TotalNumberOfRow][TotalNumberOfColumn];

        for (int i = 1; i <= TotalNumberOfRow; i++) { // Start from row 1 to skip header
            Row row = sheet.getRow(i);

            data[i - 1][0] = row.getCell(0).getStringCellValue(); // Username
            data[i - 1][1] = row.getCell(1).getStringCellValue(); // Password
        }

        workbook.close();

        return data;
    }
}
