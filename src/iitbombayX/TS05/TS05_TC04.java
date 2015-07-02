package iitbombayX.TS05;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TS05_TC04 {
	
	private WebDriver driver;
	private String baseurl;
	private static String downloadPath  = "/home/iitb/";;
	
	
	@Test
	public void download_transcript_video() throws Exception
	{
		driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("raj88.007@gmail.com");
	    driver.findElement(By.id("password")).sendKeys("design12345");
	    driver.findElement(By.id("submit")).click();
	    driver.findElement(By.linkText("ABC101 Introduction to Computer Programming, Part 1")).click();
	    driver.findElement(By.linkText("Courseware")).click();
	    driver.findElement(By.xpath("//ul[@id='ui-accordion-accordion-panel-0']/li[2]/a/p")).click();
	    driver.findElement(By.cssSelector("p")).click();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	    driver.findElement(By.linkText("Download video")).click();
	    Thread.sleep(5000);
	    
		
	}
	
	public static FirefoxProfile FirefoxDriverProfile() throws Exception {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference("browser.download.dir", downloadPath);
		profile.setPreference("browser.helperApps.neverAsk.openFile",
				"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
		profile.setPreference("browser.download.manager.focusWhenStarting", false);
		profile.setPreference("browser.download.manager.useWindow", false);
		profile.setPreference("browser.download.manager.showAlertOnComplete", false);
		profile.setPreference("browser.download.manager.closeWhenDone", false);
		return profile;
		
		
	}

	
	@BeforeMethod
	public void beforeMethod()
	{
		try {
		baseurl = "http://10.129.50.4";
		
		 
			driver = new FirefoxDriver(FirefoxDriverProfile());
		
	        driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(baseurl + "/login");

	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	@AfterMethod
	public void afterMethod()
	{
		driver.quit();
	}
}
