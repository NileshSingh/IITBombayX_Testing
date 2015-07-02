package iitbombayX.loginPage;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class HeaderLink {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://10.129.50.4/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testHeaderLink() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("HOW IT WORKS")).click();
    driver.findElement(By.xpath("html/body/div[1]/header/nav/h1/a/img")).click();
    driver.findElement(By.linkText("Courses")).click();
    driver.findElement(By.cssSelector("img[alt=\"Home Page\"]")).click();
    driver.findElement(By.linkText("Partners")).click();
    driver.findElement(By.cssSelector("img[alt=\"Home Page\"]")).click();
    driver.findElement(By.linkText("Register Now")).click();
    driver.findElement(By.cssSelector("img[alt=\"Home Page\"]")).click();
    driver.findElement(By.linkText("Language")).click();
    new Select(driver.findElement(By.id("settings-language-value"))).selectByVisibleText("हिन्दी");
    new Select(driver.findElement(By.id("settings-language-value"))).selectByVisibleText("English");
    driver.findElement(By.id("submit-lang")).click();
    driver.findElement(By.linkText("Log in")).click();
    driver.findElement(By.cssSelector("img[alt=\"Home Page\"]")).click();
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