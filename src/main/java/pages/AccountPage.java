package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {

    private WebDriver driver;
    private By logoutLink = By.linkText("Logout");

    public AccountPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isLogoutLinkDisplayed(){
        return driver.findElement(logoutLink).isDisplayed();
    }


}
