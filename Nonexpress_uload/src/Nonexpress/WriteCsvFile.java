package Nonexpress;

//import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteCsvFile {

    public static void main(String[] args) throws IOException 
    {
    	
    	
 
        DateFormat dateformat=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        
        Date date=new Date();
        
        String date1=dateformat.format(date);

    	 File file =new File("D:\\sunil\\Non-express_runsheet\\Grab_manifest_anderi_west_new1.xlsx");

    	 FileInputStream inputStream = new FileInputStream(file);

    	 Workbook workbook = null;

    	    //Find the file extension by splitting file name in substring  and getting only extension name
    	    String fileName = "Grab_manifest_anderi_west_new1.xlsx";
			String fileExtensionName = fileName.substring(fileName.indexOf("."));

    	    //Check condition if the file is xlsx file

    	    if(fileExtensionName.equals(".xlsx"))
    	    {

    	    //If it is xlsx file then create object of XSSFWorkbook class

    	    workbook = new XSSFWorkbook(inputStream);

    	    }

    	    //Check condition if the file is xls file

    	    else if(fileExtensionName.equals(".xls"))
    	    {

    	        //If it is xls file then create object of XSSFWorkbook class

    	       workbook = new HSSFWorkbook(inputStream);

    	    }

    	    //Read sheet inside the workbook by its name

    	    Sheet sheet = workbook.getSheet("Grab_manifest_anderi_west_new");

    	    //Find number of rows in excel file

    	    int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
    	    System.out.println(rowCount);
    	    


    	    //Create a loop over all the rows of excel file to read it

    	    for (int i = 1; i < rowCount+1; i++) 
    	    {

    	        Row row = sheet.getRow(i);
    	        //Row newRow = sheet.createRow(i);

    	        //Create a loop to print cell values in a row
 
    	        Random r=new Random();
    	        int b=r.nextInt(9000000)+1000000;
    	        
    	        for (int j = 0; j < 1; j++)
    	        {

    	            //Print Excel data in console
    	        	System.out.println(row.getCell(j).getNumericCellValue());
    	        	Cell cell=row.createCell(j);
    	        	cell.setCellValue(b);
    	            System.out.print(row.getCell(j+1).getStringCellValue());
    	            Cell cell1=row.createCell(j+1);
    	        	cell1.setCellValue(date1);

    	        }

    	        System.out.println("sunil"+date1);
    	        inputStream.close();
    	    	  
    	    	  //Create an object of FileOutputStream class to create write data in excel file

    	    	    FileOutputStream outputStream = new FileOutputStream(file);

    	    	    //write data in the excel file

    	    	    workbook.write(outputStream);

    	    	    //close output stream

    	    	    outputStream.close();

    	    }	
    	    
    	   
    }
    
}