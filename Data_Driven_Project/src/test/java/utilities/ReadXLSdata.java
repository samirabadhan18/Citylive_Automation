package utilities;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

public class ReadXLSdata {


    // The following main method is needed for running the excel_sheet individually, total rows and columns

//    public static void main(String[] args) throws IOException {
//
//        ReadXLSdata red = new ReadXLSdata();
//        red.getData("login");
//    }


    // Excel file is the data provider and we're fetching the sheet data here. Find the excel file in the directory then continue process

    @DataProvider(name = "readexceldata")

    //public String[][] getData(String excelSheetname) throws IOException
    public String[][] getData(Method m) throws IOException
    {
        String excelSheetname = m.getName();
        File f = new File(System.getProperty("user.dir")+ "\\src\\test\\resources\\testdata\\Testdata.xlsx");
        FileInputStream fis = new FileInputStream(f);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheetName = wb.getSheet(excelSheetname);

        int totalRows = sheetName.getLastRowNum();
        //System.out.println("Total Rows = " + totalRows);
        Row rowCells = sheetName.getRow(0);
        int totalCols = rowCells.getLastCellNum();
        //System.out.println("Total Columns = " + totalCols);

        DataFormatter format = new DataFormatter();

        String testData[][] = new String[totalRows][totalCols];

        for(int i = 1; i <=totalRows; i++){
            for (int j = 0; j <totalCols; j++){
                testData[i-1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));

                //System.out.println(testData[i-1][j]);
            }
        }

        return testData;


    }
}
