package Nonexpress;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;


public class Upload_file {

	public static void main(String[]args) throws InterruptedException, IOException
	{
	// Chrome
		
		//Change csv data object n function
	    csvwrite cs=new csvwrite();
	    cs.editcsvfile();
		
	  System.setProperty("webdriver.chrome.driver", "D:\\seleniumJar\\chromedriver.exe");
      WebDriver driver=new ChromeDriver();
      
      driver.get("https://dev.grab.in");
      
      driver.manage().window().maximize();
      
      driver.findElement(By.name("username")).sendKeys("sunil");
      
      driver.findElement(By.name("password")).sendKeys("Victory@7777");
      
      driver.findElement(By.xpath(".//*[@id='m_login_signin_submit']")).click();
      
      driver.get("https://dev.grab.in/Admin/Restaurants/myntrafileupload");
      
      Thread.sleep(5000);
      
      // choose file button
      driver.findElement(By.xpath(".//*[@id='container-fluid']/div[2]/div[2]/form/div/div[1]/div/div/div/span/label/span[2]")).click();
      Thread.sleep(3000);
    
      
      //Runtime.getRuntime().exec("D:\\seleniumJar\\AutoIt\\fileuploadecom.exe");
      
     String path = System.getProperty("user.dir") + "\\extension\\Grab_manifest_anderi_west_new.csv";
      
      //String path = System.getProperty("user.dir") + "\\extension\\BOM-andheriwest.XML";
      
      
      
      String extension = null;
      
		int pathOfIndex = path.indexOf(".");
		System.out.println("Index Path : " + pathOfIndex);
		
		String ext = path.substring(pathOfIndex);
		System.out.println(ext);
		
		Select dropnew=new Select(driver.findElement(By.id("client_id")));
	 		
		   
      if(ext.equalsIgnoreCase(".csv"))
      {
    	  System.out.println("csv File");
    	  extension = System.getProperty("user.dir") + "\\AutoIT\\csvAutoIT.exe";
    	  Runtime.getRuntime().exec(extension);
    	  
    	  Thread.sleep(2000);
    	  dropnew.selectByIndex(3);
      }
      else 
      {
    	  System.out.println("xml file");
    	  extension = System.getProperty("user.dir") + "\\AutoIT\\xmlAutoIT.exe";
    	  Runtime.getRuntime().exec(extension);
    	  //dropnew.selectByVisibleText("Aramex");
    	  Thread.sleep(2000);
    	  dropnew.selectByIndex(1);
    	  
      }
      
      driver.findElement(By.xpath(".//*[@id='submit']")).click();
      
      if(ext.equalsIgnoreCase(".csv"))
      {
    	  driver.get("https://dev.grab.in/Api/myntra/extractrunsheetfile");
      }
      else
      {
    	  driver.get("https://dev.grab.in/Api/Aramex/extractrunsheetfile"); 
      }
      Thread.sleep(1000);
      driver.close();	
    }
	
}
