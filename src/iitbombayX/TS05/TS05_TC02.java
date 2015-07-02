package iitbombayX.TS05;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TS05_TC02 {

	private WebDriver driver;
	  private String baseUrl;
	  Thread thread;
	  
	  @Test
	  public void viewLect_transcript() throws IOException 
	  {
		  try {
		  driver.findElement(By.id("email")).clear();
		    driver.findElement(By.id("email")).sendKeys("raj88.007@gmail.com");
		    driver.findElement(By.id("password")).sendKeys("design12345");
		    driver.findElement(By.id("submit")).click();
		    driver.findElement(By.linkText("ABC101 Introduction to Computer Programming, Part 1")).click();
		    driver.findElement(By.linkText("Courseware")).click();
		    driver.findElement(By.xpath("//ul[@id='ui-accordion-accordion-panel-0']/li[2]/a/p")).click();
		    driver.findElement(By.cssSelector("p")).click();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    
				//thread.sleep(4000);
			
		    driver.findElement(By.xpath(".//*[@id='transcript-captions']/li[15]")).click();
		   // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    thread.sleep(4000);
		    driver.findElement(By.xpath(".//*[@id='transcript-captions']/li[26]")).click();
		  //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    thread.sleep(4000);
		    driver.findElement(By.xpath(".//*[@id='transcript-captions']/li[28]")).click();
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		    driver.findElement(By.xpath(".//*[@id='transcript-captions']/li[49]")).click();
		  } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
	  
	  @BeforeMethod
	    public void beforeMethod() {
	  	  
	  	  // Create a new instance of the Firefox driver
			 baseUrl = "http://10.129.50.4/";
	        driver = new FirefoxDriver();
	        driver.manage().window().maximize();
	        //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception

	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        //Launch the Online Store Website

	        driver.get(baseUrl + "/login");
	       
	    }

	    @AfterMethod
	    public void afterMethod() {
	  	  
	  	  driver.quit();
	    }
}
