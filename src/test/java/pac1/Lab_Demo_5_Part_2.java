package pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab_Demo_5_Part_2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
		
		//First Name
		WebElement firstname = driver.findElement(By.name("firstname"));
		firstname.sendKeys("Subhash");
		//Enter long first name
		String longfirstname = "ABCDEFGHIJKLMNOPQRSTUVWXYZSU";
		firstname.clear();
		firstname.sendKeys(longfirstname);

        // Click Continue button
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        // Verify error message for exceeding character limit
        WebElement firstNameError1 = driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]"));
        if (firstNameError1.isDisplayed()) {
            System.out.println(" Validation Passed: First Name greater than 32 chars are not allowed.");
        }
        // Last Name
        WebElement lastName = driver.findElement(By.xpath("//*[@id=\"input-lastname\"]"));
        lastName.sendKeys("Murugesan");
        String longlastname = "ABCDEFGHIJKLMNOPQRSTUVWXYZSUBHASH";
		lastName.clear();
		lastName.sendKeys(longfirstname);
		
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

        // Verify error message for exceeding character limit
        WebElement lastNameError = driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]"));
        if (lastNameError.isDisplayed()) {
            System.out.println(" Validation Passed: Last Name greater than 32 chars are not allowed.");
        }
        
        // Enter valid 'E-mail'
        WebElement emailField = driver.findElement(By.xpath("//*[@id='input-email']"));
        emailField.sendKeys("test@example.com");

        // Enter 'Telephone' which must be between 3 and 32 characters
        WebElement telephoneField = driver.findElement(By.xpath("//*[@id='input-telephone']"));
        telephoneField.sendKeys("1234567890");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        driver.quit();
    }
}