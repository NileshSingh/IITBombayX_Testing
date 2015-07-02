package iitbombayX.TS04;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TS04_TC01 {
	
	 private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  WebElement element;
	
	
	@Test
	  public void courseStructure() throws Exception {
	    //driver.get(baseUrl + "/");
		//driver.get(baseUrl + "/courses/IITB/ABC101/2015-16/courseware/69e79228b2ee49988900ab45c555eedb/");
		driver.findElement(By.id("email")).sendKeys("raj88.007@gmail.com");
		driver.findElement(By.id("password")).sendKeys("design12345");
		driver.findElement(By.id("submit")).click();
		
	    driver.findElement(By.linkText("Course Info")).click();
	    driver.findElement(By.linkText("Courseware")).click();
	    driver.findElement(By.linkText("Discussion")).click();
	    driver.findElement(By.linkText("Courseware")).click();
	    driver.findElement(By.linkText("Wiki")).click();
	    driver.findElement(By.linkText("Courseware")).click();
	    driver.findElement(By.linkText("Progress")).click();
	    driver.findElement(By.linkText("Courseware")).click();
	    driver.findElement(By.linkText("Week 2: Sequential and Conditional execution of Programs")).click();
	    driver.findElement(By.cssSelector("#ui-accordion-accordion-header-0 > a")).click();
	    driver.findElement(By.cssSelector("p")).click();
	    driver.findElement(By.xpath("//ul[@id='ui-accordion-accordion-panel-0']/li[2]/a/p")).click();
	    driver.findElement(By.linkText("Click here to view slides for Session 2: Introduction")).click();
	    driver.findElement(By.xpath("//ul[@id='ui-accordion-accordion-panel-0']/li[3]/a/p")).click();
	    driver.findElement(By.xpath("//ul[@id='ui-accordion-accordion-panel-0']/li[4]/a/p")).click();
	    driver.findElement(By.xpath("//ul[@id='ui-accordion-accordion-panel-0']/li[5]/a/p")).click();
	    driver.findElement(By.xpath("//ul[@id='ui-accordion-accordion-panel-0']/li[6]/a/p")).click();;
		
		
		
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

        driver.get(baseUrl + "/courses/IITB/ABC101/2015-16/courseware/69e79228b2ee49988900ab45c555eedb/");
       
    }

    @AfterMethod
    public void afterMethod() {
  	  
  	  driver.quit();
    }
}
