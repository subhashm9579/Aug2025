package pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab_Demo_5_Part_4 {
	public static void main (String [] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
		
		//Enter First Name
		driver.findElement(By.xpath("//*[@id=\"input-firstname\"]")).sendKeys("Subhash");
		//Enter Last Name
		driver.findElement(By.xpath("//*[@id=\"input-lastname\"]")).sendKeys("Murugesan");
		//Enter Email
		driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("subhashm99579@gmail.com");
		//Enter Telephone
		driver.findElement(By.xpath("//*[@id=\"input-telephone\"]")).sendKeys("9876543210");
		//Enter Password
		WebElement password = driver.findElement(By.xpath("//*[@id=\"input-password\"]"));
		password.sendKeys("Hello@123");
		//Enter Confirm Password
		WebElement confirm = driver.findElement(By.xpath("//*[@id=\"input-confirm\"]"));
		confirm.sendKeys("Hello@123");
		
	//Check both passwords are same
		if (password.equals(confirm)) {
			System.out.print("Passed");
		
		}
		//Newsletter
		WebElement yesRadio = driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']"));
		yesRadio.click();

		//privacy policy
		WebElement privacy = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]"));
		privacy.click();
		
		//Continue
		WebElement proceed = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
		proceed.click();

		
	     WebElement accountCreatedMessage = driver.findElement(By.xpath("//*[@id='content']/h1"));
	     System.out.println("Account Created Message: " + accountCreatedMessage.getText());

	     // Click on 'Continue' after account creation
	     driver.findElement(By.xpath("//*[@id='content']/div/div/a")).click();

	     // Click on 'View your order history' under 'My Orders'
	     driver.findElement(By.xpath("//*[@id='content']/ul[2]/li[1]/a")).click();

	       
	    
	
	}

}
