package iitbombayX.registrationPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class registrationPage_header_link {
	
	 private WebDriver driver;
	 
	 @Test
	  public void registration_header_nav() throws Exception {
		 
		    driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[1]/li[4]/a")).click();
		    //driver.findElement(By.linkText("Register Now")).click();
		    driver.findElement(By.linkText("HOW IT WORKS")).click();
		    driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[1]/li[4]/a")).click();
		    driver.findElement(By.linkText("COURSES")).click();
		    driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[1]/li[4]/a")).click();
		    driver.findElement(By.linkText("PARTNERS")).click();
		    driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[1]/li[4]/a")).click();
		    driver.findElement(By.linkText("LANGUAGE")).click();
		    driver.findElement(By.id("submit-lang")).click();
		    driver.findElement(By.cssSelector("img[alt=\"Home Page\"]")).click();
		    driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[1]/li[4]/a")).click();
		    driver.findElement(By.linkText("Log in")).click();
		    driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[1]/li[4]/a")).click();
		 
	 }
	 @BeforeMethod
	  public void beforeMethod() {
		  
		  // Create a new instance of the Firefox driver

	      driver = new FirefoxDriver();

	      //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception

	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	      //Launch the Online Store Website

	      driver.get("http://10.105.24.28/");

	  }

	  @AfterMethod
	  public void afterMethod() {
		  
		  driver.quit();
	  }

	  
}
