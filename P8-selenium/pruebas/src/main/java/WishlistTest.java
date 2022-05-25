// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class WishlistTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    System.setProperty("webdriver.gecko.driver","C:/Users/Israel/Desktop/Codigos/Mingeso/PEP2/P8-selenium/geckodriver.exe");
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void wishlist() {
    driver.get("http://automationpractice.com/index.php");
    driver.manage().window().setSize(new Dimension(948, 858));
    driver.findElement(By.linkText("Sign in")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("iariaspanez@gmail.com");
    driver.findElement(By.id("login_form")).click();
    driver.findElement(By.id("passwd")).click();
    driver.findElement(By.id("passwd")).sendKeys("qwerty");
    driver.findElement(By.cssSelector("#SubmitLogin > span")).click();
    driver.findElement(By.cssSelector(".lnk_wishlist span")).click();
    driver.findElement(By.id("name")).click();
    driver.findElement(By.id("name")).sendKeys("lista");
    driver.findElement(By.cssSelector("#submitWishlist > span")).click();
    driver.findElement(By.xpath("//a[contains(text(),\'Women\')]")).click();
    driver.findElement(By.cssSelector("li:nth-child(2) > .subcategory-image .replace-2x")).click();
    driver.findElement(By.cssSelector("li:nth-child(1) > .subcategory-image .replace-2x")).click();
    driver.findElement(By.cssSelector(".product_img_link > .replace-2x")).click();
    driver.findElement(By.id("wishlist_button")).click();
    new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".fancybox-item"))).click();
    //driver.findElement(By.cssSelector(".fancybox-item")).click();
    new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='fancybox-overlay fancybox-overlay-fixed']"))));
    new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".account > span"))).click();
    //driver.findElement(By.cssSelector(".account > span")).click();
    driver.findElement(By.cssSelector(".lnk_wishlist span")).click();
    assertThat(driver.findElement(By.cssSelector(".bold")).getText(), is("1"));
  }
}
