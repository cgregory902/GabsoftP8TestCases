
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

public class TestUpdateInfo {
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
  public void testUpdateInfo() throws Exception {
    driver.get("http://jsic.ddns.net:8080/GabSoft/login.html");
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("cg");
    driver.findElement(By.id("pass")).clear();
    driver.findElement(By.id("pass")).sendKeys("12345");
    driver.findElement(By.id("pass")).sendKeys(Keys.ENTER);
    driver.get("http://jsic.ddns.net:8080/GabSoft/UserInfo");
    driver.findElement(By.name("FIRSTNAME")).click();
    driver.findElement(By.name("FIRSTNAME")).click();
    //ERROR: Caught exception [ERROR: Unsupported command [doubleClick | name=FIRSTNAME | ]]
    driver.findElement(By.name("FIRSTNAME")).clear();
    driver.findElement(By.name("FIRSTNAME")).sendKeys("Cole");
    driver.findElement(By.name("LASTNAME")).clear();
    driver.findElement(By.name("LASTNAME")).sendKeys("Gregory");
    driver.findElement(By.name("EMAIL")).clear();
    driver.findElement(By.name("EMAIL")).sendKeys("email@gmail.com");
    driver.findElement(By.name("PHONE")).clear();
    driver.findElement(By.name("PHONE")).sendKeys("402-111-3323");
    driver.findElement(By.name("PHARMACY")).clear();
    driver.findElement(By.name("PHARMACY")).sendKeys("Walgreens");
    driver.findElement(By.xpath("//input[@value='Update Info']")).click();
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
