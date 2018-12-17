package Nonexpress;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

import java.util.Date;

import com.csvreader.CsvWriter;
import com.google.common.collect.Table.Cell;


import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class csvwritee 
{
    public void editcsvfile()
    {
    
        DateFormat dateformat=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        
        Date date = new Date();
        String date1=dateformat.format(date);
        
        System.out.println("Current Date = " +date1);
    	
    	//For runsheet name
    	
	        Random ransheet=new Random();
	        int bs=ransheet.nextInt(900)+100;
	        
	         String ransheetnm=String.valueOf(bs);
    	
    	     String csvOutputFile = "D:\\sunil\\Non-express_runsheet\\Grab_manifest_anderi_west.csv";
             //check if file exist
             boolean isFileExist = new File(csvOutputFile).exists();
            try {
                    //create a FileWriter constructor to open a file in appending mode
                     CsvWriter testcases = new CsvWriter(new FileWriter(csvOutputFile,false), ',');
                     //write header column if the file did not already exist
                     
                     String[] str={"Order_ID","trip_date","code","ML_Tracking_No","SDA_Name_Kirana_ID","Trip_No","Customer_Name",
                    		"Mobile_No_1","Mobile_No_2","Adress","Pincode","City","State","Weight","Dimensions","Product_Des",
                    		"Payment_Type","Shipment_Value","COD_Value","Kiosk_Number","delivery_staff_type"};
                     
                     if(isFileExist)
                     {
                        for(String abc : str) 
                        {
                        	testcases.write(abc);
                        }
                    	
                        testcases.endRecord();
                      }
                     
                     //add record to the file
    	               
                     for(int i=1;i<=20;i++)
                     {
            	         // for generate unique id  
       	                Random r=new Random();
       	                int b=r.nextInt(90000000)+10000000;
       	                //Convert int to string
       	             String ran=String.valueOf(b);
       	        
       	             String[] str1 = {ran,date1,"anw","ML0"+b,"Ganesh Prasad","sunil-"+ransheetnm,"Ekta chaturvedi","1234567894",
    	                		"1234567890","D2112 indira nagar lucknow, Indira Nagar  (Lucknow), ","400053","UP","0","0","DressBerry Women Red Printed Top:Tops",
    	                		"COD","629.37","629","NA","Store"};
                     
       	             //using with for each with string of array
       	             for(String aa:str1)
       	             {
       	            	testcases.write(aa) ;
       	             }
       	            str1=null;
       	            
       	            //Using with for 
                       /*for(int j=0;j<str1.length;j++)
       	                 {
       	            	
       	            	     testcases.write(str1[j]);
       	                  }*/
       	             
       	                
                        testcases.endRecord();
                      }
                        //close the file
                         testcases.close();
                    } 
                    catch (IOException e) 
                    {
                         e.printStackTrace();
                    }
            

            
          }
    
    public static void main(String[]args)
    {
    	
    	csvwritee css=new csvwritee();
    	css.editcsvfile();
    }
}
