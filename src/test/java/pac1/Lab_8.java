package pac1;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class Lab_8 {
    private WebDriver driver;
  

    @BeforeMethod
    public void setUp() {
        
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void productNavigationAndAddToCartTest() {
        System.out.println("Title:"+ driver.getTitle());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement desktop = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Desktops")));
        desktop.click();

        WebElement mac = driver.findElement(By.linkText("Mac (1)"));
        mac.click();
        System.out.println("Current Page:"+ driver.getTitle());

        WebElement dropdownElement = driver.findElement(By.id("input-sort"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Name (A - Z)");
        System.out.println("Sorted by Name (A-Z)");

        WebElement addToCartButton = driver.findElement(By.xpath("//div[@class='product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12']//button[contains(@onclick, 'cart.add')]"));
        Assert.assertTrue(addToCartButton.isDisplayed(), "Add to cart button should be displayed");
        System.out.println("Verified product is visible");

        addToCartButton.click();
        
        // Success Message
        WebElement successMsg = driver.findElement(By.cssSelector(".alert-success"));
        Assert.assertTrue(successMsg.getText().contains("Success"), "Add to Cart failed!");
        System.out.println("Verified 'Add to Cart' success message.");

        
        WebElement searchbar = driver.findElement(By.xpath("//*[@id=\"search\"]/input"));
        searchbar.sendKeys("Mobile");
        driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
        
        driver.findElement(By.xpath("//*[@id=\"description\"]")).click();
        
        WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"button-search\"]"));
        searchbox.click();
        
        
        
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("This is Before Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("This is After class");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("This is Before test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("This is After test");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("This is Before suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("This is After suite");
    }
}