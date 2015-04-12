package iitbombayX.registrationPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test_registration_page {
  private WebDriver driver;
  

  @Test
  public void testRegPage() throws Exception {
    //driver.get(baseUrl + "/");
    driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[1]/li[4]/a")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("raj88.007@gmail.com");
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("nilesh1234589");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("SinghNileshANG");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("design1234");
    new Select(driver.findElement(By.id("state"))).selectByVisibleText("Arunachal Pradesh");
    driver.findElement(By.id("city")).clear();
    driver.findElement(By.id("city")).sendKeys("mumbai");
    driver.findElement(By.id("pincode")).clear();
    driver.findElement(By.id("pincode")).sendKeys("453453");
    driver.findElement(By.id("aadhar")).clear();
    driver.findElement(By.id("aadhar")).sendKeys("354634646346");
    new Select(driver.findElement(By.id("education-level"))).selectByVisibleText("Associate's degree");
    new Select(driver.findElement(By.id("education-level"))).selectByVisibleText("Master's or professional degree");
    new Select(driver.findElement(By.id("gender"))).selectByVisibleText("Male");
    new Select(driver.findElement(By.id("yob"))).selectByVisibleText("1984");
    driver.findElement(By.id("address-mailing")).clear();
    driver.findElement(By.id("address-mailing")).sendKeys("rasghdrshgfmgh,mgj,mhj,h,h,,,\nfnjdfygjdfmnjdfmjgfmdmg\nmnghfmndfmndmgm");
    driver.findElement(By.id("goals")).clear();
    driver.findElement(By.id("goals")).sendKeys("mghmghfmghmghmgmgfmg\ndgfjmndfmnjghfmghmghm\nghmghmghfmghmgj,hk,.,.hfj,,jfjukjsfhdtshdrtsbdbd");
    driver.findElement(By.id("tos-yes")).click();
    driver.findElement(By.id("honorcode-yes")).click();
    driver.findElement(By.id("submit")).click();
    driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[2]/li[2]/a")).click();
    driver.findElement(By.linkText("Log Out")).click();
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