package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private By emailInput = By.id("input-email");
    private By passwordInput = By.id("input-password");
    private By loginButton = By.cssSelector("input.btn-primary");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setEmail(String email){
        driver.findElement(emailInput).sendKeys(email);
    }

    public void setPassword(String password){
        driver.findElement(passwordInput).sendKeys(password);
    }

    public AccountPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new AccountPage(driver);
    }


}
