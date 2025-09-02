package pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class TC009_TestNG2 {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("This is Before Method");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("This is After Method");
        if (driver != null) driver.quit();
    }

    @DataProvider(name = "logindata")
    public Object[][] logindata() {
        return new Object[][] {
                {"Admin", "admin123"},
                {"Subhash", "welcome"}
        };
    }

    @Test(dataProvider = "logindata")
    public void loginTest(String username, String password) {
        System.out.println("This is the test");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement uname = driver.findElement(By.name("username"));
        Assert.assertTrue(uname.isDisplayed(), "Username field not displayed");
        uname.sendKeys(username);
        System.out.println("Get placeholder: " + uname.getAttribute("placeholder"));

        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("username")).sendKeys(Keys.ENTER);

        // simple assert that Dashboard header appears
        WebElement dashboard = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
        Assert.assertTrue(dashboard.isDisplayed(), "Dashboard not displayed");
    }

    @BeforeClass public void beforeClass() { System.out.println("This is Before Class"); }
    @AfterClass  public void afterClass()  { System.out.println("This is After Class"); }
    @BeforeTest  public void beforeTest()  { System.out.println("This is Before Test"); }
    @AfterTest   public void afterTest()   { System.out.println("This is After Test"); }
    @BeforeSuite public void beforeSuite() { System.out.println("This is Before Suite"); }
    @AfterSuite  public void afterSuite()  { System.out.println("This is After Suite"); }
}