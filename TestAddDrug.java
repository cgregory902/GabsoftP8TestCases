
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//import org.apache.commons.io.FileUtils;
import java.io.File;

public class TestAddDrug {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\cgreg\\OneDrive\\Documents\\SoftwareEngineering\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testAddDrug() throws Exception {
    driver.get("http://jsic.ddns.net:8080/GabSoft/login.html");
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("cg");
    driver.findElement(By.id("pass")).clear();
    driver.findElement(By.id("pass")).sendKeys("12345");
    driver.findElement(By.id("pass")).sendKeys(Keys.ENTER);
    driver.get("http://jsic.ddns.net:8080/GabSoft/UserInfo");
    driver.findElement(By.linkText("Drug Search")).click();
    driver.get("http://jsic.ddns.net:8080/GabSoft/genericsearch.html");
    driver.findElement(By.linkText("Back to add by NDC")).click();
    driver.get("http://jsic.ddns.net:8080/GabSoft/drugsearch.html");
    driver.findElement(By.id("ndc")).click();
    driver.findElement(By.xpath("//*/text()[normalize-space(.)='']/parent::*")).click();
    driver.findElement(By.id("ndc")).click();
    driver.findElement(By.id("ndc")).clear();
    driver.findElement(By.id("ndc")).sendKeys("500901627");
    driver.findElement(By.xpath("//input[@value='Add']")).click();
    driver.get("http://jsic.ddns.net:8080/GabSoft/DBSearch");
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
