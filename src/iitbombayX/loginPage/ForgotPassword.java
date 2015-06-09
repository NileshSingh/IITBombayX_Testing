package iitbombayX.loginPage;

import java.io.File;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ForgotPassword {
	
	 private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @SuppressWarnings("static-access")
	@Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://10.129.50.4/";
	    this.takeSnapShot(driver, "\\home\\iitb\\seleniumsnapshot\\test.png") ;
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	  
	  /**
	  
	     * This function will take screenshot
	 
	     * @param webdriver
	 
	     * @param fileWithPath
	 
	     * @throws Exception
	 
	     */
	 
	    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
	 
	        //Convert web driver object to TakeScreenshot
	 
	        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
	 
	        //Call getScreenshotAs method to create image file
	 
	                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	 
	            //Move image file to new destination
	 
	                File DestFile=new File(fileWithPath);
	 
	                //Copy file at destination
	 
	                FileUtils.copyFile(SrcFile, DestFile);
	 
	             
	 
	    }
	    
	  @Test
	  public void testResetPassword() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.linkText("Log in")).click();
	    
	    
	    driver.findElement(By.id("forgot-password-link")).click();
	    driver.findElement(By.id("pwd_reset_email")).clear();
	    driver.findElement(By.id("pwd_reset_email")).sendKeys("raj88.007@gmail.com");
	    driver.findElement(By.id("pwd_reset_button")).click();
	    driver.findElement(By.cssSelector("button.close-modal")).click();
	    
	    driver.get("https://accounts.google.com/ServiceLogin?service=mail&continue=https://mail.google.com/mail/#identifier");
	    driver.findElement(By.id("Email")).sendKeys("raj88.007");;
	    driver.findElement(By.id("next")).click();
	    driver.findElement(By.id("Passwd")).sendKeys("design12345");
	    driver.findElement(By.id("signIn")).click();
	    driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
	    //selenium.mouseDown("xpath=//div [@class='y6']/span[contains(.,'<your original search text>')]");
	    driver.get(baseUrl + "/");
	    driver.findElement(By.linkText("Login")).click();
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("raj88.007@gmail.com");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("design12345");
	    driver.findElement(By.id("remember-yes")).click();
	    driver.findElement(By.id("submit")).click();
	    driver.findElement(By.linkText("edit")).click();
	    driver.findElement(By.id("new_name_field")).clear();
	    driver.findElement(By.id("new_name_field")).sendKeys("Shivaji");
	    driver.findElement(By.id("name_rationale_field")).clear();
	    driver.findElement(By.id("name_rationale_field")).sendKeys("Real name");
	    driver.findElement(By.cssSelector("fieldset > div.submit > #submit")).click();
	    driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[2]/li[2]/a")).click();
	    driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[2]/li[2]/a")).click();
	    
	    
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
}
