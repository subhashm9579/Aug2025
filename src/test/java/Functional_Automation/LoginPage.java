package Functional_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
	this.driver=driver;
	}
	By loginLink = By.xpath("//a[contains(text(),'Signup / Login')]");
    By emailInput = By.xpath("//input[@data-qa='login-email']");
    By passwordInput = By.xpath("//input[@data-qa='login-password']");
    By loginButton = By.xpath("//button[@data-qa='login-button']");
    By logoutLink = By.xpath("//a[contains(text(),'Logout')]");
    
    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public boolean isLogoutDisplayed() {
        return driver.findElement(logoutLink).isDisplayed();
    }

    public void clickLogout() {
        driver.findElement(logoutLink).click();
    }
}
    
	
	


