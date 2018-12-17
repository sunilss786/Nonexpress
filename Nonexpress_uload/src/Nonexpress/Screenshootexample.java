package Nonexpress;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.common.io.Files;

public class Screenshootexample 
{
	
	//=new ChromeDriver();
	public void takscreen(WebDriver driver, File path) throws IOException, InterruptedException
	{
		Date d=new Date();
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	      
	      File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   // Now you can do whatever you need to do with it, for example copy somewhere
	      Files.copy(scrFile, new File(path+sdf.format(d)+".png"));
	      

	}

	public static void main(String[] args) throws InterruptedException, AWTException, IOException
	{
		// Chrome
		  System.setProperty("webdriver.chrome.driver", "D:\\seleniumJar\\chromedriver.exe");
			WebDriver  driver=new ChromeDriver();
			driver.get("https://www.google.com");
			driver.manage().window().maximize();
			File path=new File("D:\\seleniumJar\\Selscreen");
	      
	      Screenshootexample s1=new Screenshootexample();
	      s1.takscreen(driver,path);
	      
	      Thread.sleep(2000);
	      driver.close();
	      
	      
	      //WebElement Image =driver.findElement(By.xpath("//*[@id=\"hplogo\"]"));
	   
	     //Actions action= new Actions(driver);
	   
	    // action.contextClick(Image).build().perform();
	      
	     //action.sendKeys(Keys.CONTROL,"s").build().perform();
         

	}

}






