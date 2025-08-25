package pac1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab_6 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		
		// Login Email
		driver.findElement(By.id("input-email")).sendKeys("subhashm9579@gmail.com");
		
		//Login Password
		driver.findElement(By.id("input-password")).sendKeys("Hello@123");
		
		// Enter login button
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
        //2 Click on Components tab
        driver.findElement(By.linkText("Components")).click();
        
        //3 Click on Monitor from the drop down
        driver.findElement(By.linkText("Monitors (2)")).click();
        
        //4S elect 25 from the drop down
        driver.findElement(By.xpath("//*[@id=\"input-limit\"]/option[2]")).click();
        
	    // 5 Add to Cart 
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/div/div[2]/div[1]/h4/a")).click();
		driver.findElement(By.xpath("//*[@id=\"button-cart\"]")).click();
		
		//6 Click on Specification Tab
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1500)");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/ul[2]/li[2]/a")).click();
		
		//7 Verify Details present
		System.out.println("Details are:" + driver.getTitle());
		
		//8 Wish list
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[1]/button[1]")).click();
		
		//9 Verify Success Message
		WebElement wishlistMsg = driver.findElement(By.xpath("//*[@id=\"product-product\"]/div[1]"));
		   if(wishlistMsg.isDisplayed()) {
	            System.out.println("Wishlist Message verified ");
	        } else {
	            System.out.println(" Wishlist Message not displayed.");
	        }
		
		// 10Enter Mobile in Search
		driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys("Mobile");
		
		// 11Enter Search
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		
		// 12 Check tick Search in product descriptions
		driver.findElement(By.xpath("//*[@id=\"description\"]")).click();
		// Search Bar
		driver.findElement(By.xpath("//*[@id=\"button-search\"]")).click();
		
		//13 click on HTC Mobile
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[1]/h4/a")).click();
		
		//14 Clear quantity 
		driver.findElement(By.xpath("//*[@id=\"input-quantity\"]")).clear();
		//Add Quantity 3
		driver.findElement(By.xpath("//*[@id=\"input-quantity\"]")).sendKeys("3");
		
		// 15 Click on add to cart
		driver.findElement(By.xpath("//*[@id=\"button-cart\"]")).click();
		
		// 16 Verify Cart message
	    WebElement successMsg = driver.findElement(By.xpath("//*[@id=\"product-product\"]/div[1]"));

        // 17 Verify if success message  is displayed
        if(successMsg.isDisplayed()) {
            System.out.println("Success Message verified ");
        } else {
            System.out.println(" Success Message not displayed.");
        }
        
        // 18 Verify mobile name added to the cart
        driver.findElement(By.xpath("//*[@id=\"cart\"]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/p/a[1]/strong")).click();
        WebElement productName = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[2]/a"));
        if(productName.isDisplayed()){
            System.out.println("HTC Touch HD is available in the cart");
        } else {
            System.out.println("HTC Touch HD is NOT available in the cart.");
        }
        
        // 20 Click on Checkout Button
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/a")).click();
        
        //20 Click My Account
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
        
        //21. Select Log out
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")).click();
        
        //22. Verify Logout Message
        WebElement logoutmessage = driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
        if (logoutmessage.isDisplayed()) {
        	System.out.println("Account Logout heading is verified");
        }else {
        	System.out.println("Account Logout heading is not verified");
        }
        
        //23 Click on Continue
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
 
	}

}
