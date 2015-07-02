package iitbombayX.TS04;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TS04_TC03 {
	
	private WebDriver driver;
	private String baseUrl;
	
	@Test
	  public void findCourses() throws Exception {
	   // driver.get(baseUrl + "/");
	   // driver.findElement(By.linkText("Log in")).click();
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("raj88.007@gmail.com");
	    driver.findElement(By.id("password")).sendKeys("design12345");
	    driver.findElement(By.id("submit")).click();
	    driver.findElement(By.cssSelector("img[alt=\"Home Page\"]")).click();
	    driver.findElement(By.linkText("FIND COURSES")).click();
	    driver.findElement(By.linkText("OraTest")).click();
	    driver.findElement(By.linkText("FIND COURSES")).click();
	    driver.findElement(By.linkText("Demo Course")).click();
	    driver.findElement(By.cssSelector("strong")).click();
	    driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[2]/li[2]/a")).click();
	    driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[2]/li[2]/ul/li[2]/a")).click();
	  }

	@BeforeMethod
	public void beforeMethod()
	{
		baseUrl = "http://10.129.50.4/";
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl + "/courses/IITB/ABC101/2015-16/courseware/69e79228b2ee49988900ab45c555eedb/");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		driver.quit();
		
	}

}
