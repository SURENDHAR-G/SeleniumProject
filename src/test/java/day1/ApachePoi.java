package day1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ApachePoi {

	public static void readExcelData() throws IOException
	{
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testData\\data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int row = sheet.getLastRowNum();
		int cell = sheet.getRow(0).getLastCellNum();
		System.out.println(cell);
		for(int i=0;i<=row;i++)
		{
			XSSFRow row1 = sheet.getRow(i); 
			for(int j=0;j<cell;j++)
			{
				XSSFCell cell1 = row1.getCell(j);
				String cellData = cell1.toString();
				System.out.print(cellData+" ");
			}
			System.out.println();
		}
		workbook.close();
		file.close();
	}
	public static void writeData() throws IOException
	{
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testData\\myfile1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Data");
		for(int i=0;i<=3;i++)
		{
			XSSFRow row=sheet.createRow(i);
			for(int j=0;j<10;j++)
			{
				XSSFCell cell=row.createCell(j);
				cell.setCellValue("1");
			}
		}
		workbook.write(file);
		workbook.close();
		file.close();
	}
	public static void main(String[] args) throws IOException {
		readExcelData();
		writeData();

	}

}
