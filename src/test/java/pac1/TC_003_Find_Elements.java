package pac1;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_003_Find_Elements {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://amazon.in");
		
		List<WebElement> alllinks = driver.findElements(By.tagName("a"));
		System.out.println("Total Links: "+ alllinks.size());
		
		for (WebElement link:alllinks) {
			System.out.println ("The Link is : " + link.getText());
		}
		

}
}