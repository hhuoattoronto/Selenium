import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumExample {
	public static void main(String[] args) {
		// Create a new instance of the Firefox driver
		// Notice that the remainder of the code relies on the interface,
		// not the implementation.
		WebDriver driver = new FirefoxDriver();

		// And now use this to visit a website
		driver.get("http://book.theautomatedtester.co.uk/");
		// Alternatively the same thing can be done like this
		// driver.navigate().to("http://book.theautomatedtester.co.uk/");
		wait(2);

		// Find Chapter 1's link and click it
		driver.findElement(By.linkText("Chapter1")).click();
		wait(2);

		// Close the browser
		driver.quit();
	}

	private static void wait(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}