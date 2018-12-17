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
import org.openqa.selenium.interactions.Keyboard;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.google.common.io.Files;

public class downloadimage {
	
	//=new ChromeDriver();


	public static void main(String[] args) throws InterruptedException, AWTException, IOException
	{
		
		// Chrome
		  System.setProperty("webdriver.chrome.driver", "D:\\seleniumJar\\chromedriver.exe");
		  WebDriver  driver=new ChromeDriver();
		  
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  //driver.get("http://only-testing-blog.blogspot.in/2014/09/selectable.html");
		  driver.get("https://www.google.com");
		/*
			driver.get("https://www.google.com");

		      driver.manage().window().maximize();
		      
	      WebElement Image =driver.findElement(By.xpath("//*[@id=\"hplogo\"]"));
	   
	     Actions action= new Actions(driver);
	   
	    action.contextClick(Image).build().perform();
	      
	    action.sendKeys(Keys.CONTROL,"S").build().perform();*/
		
		//Locate Image
		  //WebElement Image =driver.findElement(By.xpath("//img[@border='0']"));
		  WebElement Image =driver.findElement(By.xpath("//*[@id=\"hplogo\"]"));
		  //Rihgt click on Image using contextClick() method.
		  Actions action= new Actions(driver);
		  action.contextClick(Image).build().perform();
		  Thread.sleep(2000);
		  
		  for(int i=1;i<=6;i++)
		  {
			  //Image.sendKeys(Keys.ARROW_DOWN);
			  //To perform press Ctrl + v keyboard button action.
			  action.sendKeys(Keys.ARROW_DOWN).build().perform();  
			  System.out.println(i);
		  }
		  action.sendKeys(Keys.ENTER).build().perform();

		/*  Thread.sleep(3000);
		  Robot robot = new Robot();
		  // To press D key.
		  robot.keyPress(KeyEvent.VK_D);
		  // To press : key.
		  robot.keyPress(KeyEvent.VK_SHIFT);
		  robot.keyPress(KeyEvent.VK_SEMICOLON);
		  robot.keyRelease(KeyEvent.VK_SHIFT);
		  // To press \ key.
		  robot.keyPress(KeyEvent.VK_BACK_SLASH);
		  // To press "test" key one by one.
		  robot.keyPress(KeyEvent.VK_T);
		  robot.keyPress(KeyEvent.VK_E);
		  robot.keyPress(KeyEvent.VK_S);
		  robot.keyPress(KeyEvent.VK_T);
		  // To press Save button.
		  robot.keyPress(KeyEvent.VK_ENTER); */
		  System.out.println("Reached");
         

	}

}






