package pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab_5{

    public static void main(String[] args) {
    	
        // Setup WebDriver and launch the browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Navigate to the URL
        driver.get("https://tutorialsninja.com/demo/index.php?");
        System.out.println("The title is: " + driver.getTitle());

        // Click on My Account
        driver.findElement(By.linkText("My Account")).click();

        // Select Register 
        driver.findElement(By.linkText("Register")).click();
        System.out.println("The title is: " + driver.getTitle());

        // Verify the heading Register Account
        WebElement heading = driver.findElement(By.xpath("//h1[contains(text(),'Register Account')]"));
        System.out.println("Heading is displayed: " + heading.isDisplayed());

        // Part 2: Personal Details Form
        driver.findElement(By.xpath("//*[@id='input-firstname']")).sendKeys("Subhash");
        driver.findElement(By.xpath("//*[@id='input-lastname']")).sendKeys("Murugesan");
        driver.findElement(By.xpath("//*[@id='input-email']")).sendKeys("abcdsubhash@example.com");
        driver.findElement(By.xpath("//*[@id='input-telephone']")).sendKeys("98663773");

        driver.findElement(By.xpath("//*[@id='input-password']")).sendKeys("Hello@123");
        driver.findElement(By.xpath("//*[@id='input-confirm']")).sendKeys("Hello@123");

        // Part 4: Newsletter Section
        driver.findElement(By.xpath("//*[@id='content']/form/fieldset[3]/div/div/label[1]")).click();
        driver.findElement(By.xpath("//*[@id='content']/form/div/div/input[1]")).click();

        // Now that all fields are filled, click the 'Continue' button
        driver.findElement(By.xpath("//*[@id='content']/form/div/div/input[2]")).click();

        // Verify message 'Your Account Has Been Created!'
        WebElement accountCreatedMessage = driver.findElement(By.xpath("//*[@id='content']/h1"));
        System.out.println("Account Created Message: " + accountCreatedMessage.getText());

        // Click on 'Continue' after account creation
        driver.findElement(By.xpath("//*[@id='content']/div/div/a")).click();

        // Click on 'View your order history' under 'My Orders'
        driver.findElement(By.xpath("//*[@id='content']/ul[2]/li[1]/a")).click();

        // Close the browser after execution
        driver.quit();
    }
}