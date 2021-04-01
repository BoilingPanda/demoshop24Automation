package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private By searchInput = By.cssSelector("#search input");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public SearchResultPage searchText(String text){
        driver.findElement(searchInput).sendKeys(text+ Keys.RETURN);
        return new SearchResultPage(driver);
    }

}
