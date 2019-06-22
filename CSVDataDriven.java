import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CSVDataDriven {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();
    private String csvFile;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://newtours.demoaut.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
        csvFile = "C:\\Temp\\users.csv";
    }

    @Test
    public void DataDrivenByCSV() throws Exception {
        String line = "";
        String delimiter = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] user = line.split(delimiter);
                driver.findElement(By.name("userName")).clear();
                driver.findElement(By.name("userName")).sendKeys(user[0]);
                driver.findElement(By.name("password")).clear();
                driver.findElement(By.name("password")).sendKeys(user[1]);
                driver.findElement(By.name("login")).click();
                driver.findElement(By.linkText("SIGN-OFF")).click();
                driver.findElement(By.linkText("Home")).click();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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