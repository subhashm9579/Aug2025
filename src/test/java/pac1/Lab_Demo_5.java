package pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab_Demo_5 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?");
		System.out.println("Title : "+ driver.getTitle());
		driver.findElement(By.linkText("My Account")).click();
		
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
		WebElement heading = driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
		System.out.println("Title : "+ driver.getTitle());

		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		WebElement alert1 = driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]"));
		
		String actualWarning = alert1.getText();
		String expectedWarning = "Warning: You must agree to the Privacy Policy!";

		if (actualWarning.equals(expectedWarning)) {
		    System.out.println("Warning message verified successfully.");
		} else {
		    System.out.println("Warning message failed to verify");
		}
		
		
		
		
		

	}

}
