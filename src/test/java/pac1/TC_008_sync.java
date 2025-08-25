package pac1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_008_sync {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//Impliitly Wait 
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Explicity Wait 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement uname=wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
		
		if (uname.isDisplayed()) {
			uname.sendKeys("Admin");
			System.out.println("Placeholder: "+uname.getAttribute("placeholder"));
		}
		else {
			System.out.println("Not displayed");
		}
		driver.findElement(By.name("username")).sendKeys(Keys.TAB);
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("alert, ('Hello')");
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

	}

}
