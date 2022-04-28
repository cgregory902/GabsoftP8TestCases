
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

public class TestNewUser {
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
  public void testNewUser() throws Exception {
    driver.get("http://jsic.ddns.net:8080/GabSoft/login.html");
    driver.findElement(By.xpath("//input[@value='New User']")).click();
    driver.get("http://jsic.ddns.net:8080/GabSoft/registration.html");
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("newguy");
    driver.findElement(By.id("fname")).clear();
    driver.findElement(By.id("fname")).sendKeys("new");
    driver.findElement(By.id("lname")).clear();
    driver.findElement(By.id("lname")).sendKeys("guy");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("newguy@gmail.com");
    driver.findElement(By.id("pnum")).clear();
    driver.findElement(By.id("pnum")).sendKeys("402-111-1111");
    driver.findElement(By.id("pharm")).clear();
    driver.findElement(By.id("pharm")).sendKeys("walgreens");
    driver.findElement(By.id("pass")).clear();
    driver.findElement(By.id("pass")).sendKeys("newguy");
    driver.findElement(By.id("pass2")).clear();
    driver.findElement(By.id("pass2")).sendKeys("newguy");
    driver.findElement(By.id("pass2")).sendKeys(Keys.ENTER);
    driver.get("http://jsic.ddns.net:8080/GabSoft/Register");
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
