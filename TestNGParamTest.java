import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestNGParamTest {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    @Parameters("browserType")
    public void setUp(String browserType) throws Exception {
        if (browserType.equals("Chrome")) {
            driver = new ChromeDriver();
        } else if (browserType.equals("Firefox")) {
            driver = new FirefoxDriver();
        }
        baseUrl = "http://book.theautomatedtester.co.uk/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testcase1() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Chapter1")).click();
        driver.findElement(By.id("radiobutton")).click();
        driver.findElement(By.id("selecttype")).click();
        new Select(driver.findElement(By.id("selecttype"))).selectByVisibleText("Selenium Core");
        driver.findElement(By.id("selecttype")).click();
        driver.findElement(By.linkText("Home Page")).click();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
