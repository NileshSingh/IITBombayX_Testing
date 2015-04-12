package iitbombayX_homePage_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class home_footer_nav_link {
  private WebDriver driver;
  
  

  @Test
  public void testHomeFooterNav() {
    //driver.get(baseUrl + "/");
    driver.findElement(By.id("about")).click();
    driver.findElement(By.cssSelector("img[alt=\"Home Page\"]")).click();
    driver.findElement(By.id("news")).click();
    driver.findElement(By.id("blog")).click();
    driver.findElement(By.id("faq")).click();
    driver.findElement(By.cssSelector("img[alt=\"Home Page\"]")).click();
    driver.findElement(By.id("contact")).click();
    driver.findElement(By.cssSelector("img[alt=\"Home Page\"]")).click();
  }

  @BeforeMethod
  public void beforeMethod() {
	  
	  // Create a new instance of the Firefox driver

      driver = new FirefoxDriver();

      //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception

      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      //Launch the Online Store Website

      driver.get("http://10.129.50.4/");

  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }
}