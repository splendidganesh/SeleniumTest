package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.github.dockerjava.transport.DockerHttpClient.Request.Method;

public class ReadXLSData {
    
	@DataProvider(name ="bvtdata")
    public String[][] getData(Method m) throws EncryptedDocumentException, IOException {
        // Corrected the file path construction
		String excelSheetName  =m.name();
        File f = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\TestData.xlsx");
        FileInputStream fis = new FileInputStream(f);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheetName = wb.getSheet(excelSheetName);
        
        int totalrow = sheetName.getLastRowNum();
        System.out.println(totalrow);
        Row rowCells = sheetName.getRow(0);    
        int totalCols = rowCells.getLastCellNum();
        System.out.println(totalCols);
        DataFormatter format = new DataFormatter();
        String[][] testData = new String[totalrow][totalCols];

        for(int i = 1; i <= totalrow; i++) {
            for(int j = 0; j < totalCols; j++) {
                testData[i-1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
                System.out.println(testData[i-1][j]);
            }
        }
        
        return testData;
    }
}
