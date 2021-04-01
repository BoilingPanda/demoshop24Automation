package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultPage {

    private WebDriver driver;
    private By addToCartButton = By.cssSelector(".button-group button i.fa-shopping-cart");
    private By successAlert = By.className("alert-success");
    private By itemName = By.cssSelector(".product-thumb div.caption h4");
    private By accountButton = By.linkText("My Account");
    private By dropDownMenu = By.cssSelector(".dropdown.open");


    public SearchResultPage(WebDriver driver){
        this.driver = driver;
    }


    /**
     * If index is bigger than number of buttons
     * than test will click the last item's add to cart button
     * and returns added items name
     * @param index starts at 1
     */
    public String addItemToCart(int index){
        List<WebElement> buttons = driver.findElements(addToCartButton);
        List<WebElement> names = driver.findElements(itemName);
        while (index > buttons.size()) {
            index--;
        }
        buttons.get(index - 1).click();
        return names.get(index - 1).getText();
    }

    public String getAlertText(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(successAlert));
        return driver.findElement(successAlert).getText();
    }

    public LoginPage goToLoginPage(){
        driver.findElement(accountButton).click();
        driver.findElement(dropDownMenu).findElement(By.linkText("Login")).click();
        return new LoginPage(driver);
    }
}
