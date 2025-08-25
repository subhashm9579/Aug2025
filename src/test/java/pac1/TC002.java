package pac1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		System.out.println("Current Url is :"+ driver.getCurrentUrl());
		System.out.println("Page Source is :"+ driver.getPageSource());
		/* System.out.println("Title is :"+ driver.getTitle());
		driver.navigate().to("https://yahoo.com");
		System.out.println("Title is :"+ driver.getTitle());
		driver.navigate().back();
		System.out.println("After Backward Title is :"+ driver.getTitle());
		driver.navigate().forward();
		System.out.println("After Forward Title is :"+ driver.getTitle());
		*/
	}

}
