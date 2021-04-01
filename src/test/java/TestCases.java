import base.BaseTests;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;

import static org.testng.Assert.*;

public class TestCases extends BaseTests {

    /**
     * account created by me
     * all 3 steps running in same method as a whole process.
     */

    private String email = "johndoe@johndoe.com";
    private String password = "admin123";

    @Test
    public void testSearch(){
        var search = homePage.searchText("mac");
        String itemName = search.addItemToCart(1);
        String text = search.getAlertText();
        assertTrue(text.contains(itemName), "Item which added to cart is incorrect");

        var loginPage = search.goToLoginPage();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        var accountPage = loginPage.clickLoginButton();
        assertTrue(accountPage.isLogoutLinkDisplayed(),"Login is not successful");
    }

}
