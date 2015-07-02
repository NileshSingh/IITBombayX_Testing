package iitbombayX.TS04;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TS04_TC02 {
	
	private WebDriver driver;
	  private String baseUrl;
	 
	  WebElement element;
	
	@Test
	public void logout_fromAccount() throws Exception
	{
		driver.findElement(By.id("email")).sendKeys("raj88.007@gmail.com");
		driver.findElement(By.id("password")).sendKeys("design12345");
		driver.findElement(By.id("submit")).click();
		//driver.findElement(By.linkText("FIND COURSES"));
		driver.findElement(By.xpath("html/body/div[3]/header/nav/ol[2]/li[2]/a")).click();
	    driver.findElement(By.xpath("html/body/div[3]/header/nav/ol[2]/li[2]/ul/li[2]/a")).click();
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
