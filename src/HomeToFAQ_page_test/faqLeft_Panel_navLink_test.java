package HomeToFAQ_page_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class faqLeft_Panel_navLink_test {

	 private WebDriver driver;
	 
	 @Test
	  public void testFAQLeftPanel() throws Exception {
	   // driver.get(baseUrl + "/faq");
	    driver.findElement(By.linkText("ABOUT")).click();
	    driver.findElement(By.id("faq")).click();
	    driver.findElement(By.linkText("RESEARCH & PEDAGOGY")).click();
	    driver.findElement(By.id("faq")).click();
	    driver.findElement(By.linkText("BLOG")).click();
	    driver.findElement(By.linkText("NEWS")).click();
	    driver.findElement(By.linkText("LEARNERS FAQ")).click();
	  
	    driver.findElement(By.id("faq")).click();
	    driver.findElement(By.linkText("CONTACT US")).click();
	    driver.findElement(By.id("faq")).click();
	    
	    
	  }
	 @BeforeMethod
	  public void beforeMethod() {
		  
		  // Create a new instance of the Firefox driver

	      driver = new FirefoxDriver();

	      //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception

	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	      //Launch the Online Store Website

	      driver.get("http://10.129.50.4/faq");

	  }

	  @AfterMethod
	  public void afterMethod() {
		  
		  driver.quit();
	  }
	
	
		 }
