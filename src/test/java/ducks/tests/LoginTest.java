package ducks.tests;

import ducks.pages.LoginMessagePage;
import ducks.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Override
    @BeforeMethod
    public void setUp() {
        super.setUp();
        driver.get(PageUrls.DUCK_SHOP_URL);
    }

    @Test(description = "Success message shows if login with correct credentials")
    public void loginWithCorrectCredentialsTest() {
        // given
        String expectedSuccessMessage = "You are now logged in as Lena Panova.";
        LoginPage loginPage = new LoginPage(driver);
        LoginMessagePage loginMessagePage = new LoginMessagePage(driver);

        // when
        loginPage.login("elena.panova.9611@gmail.com", "Test12345");
        String actualLoginMessage = loginMessagePage.getSuccessMessage();

        // then
        Assert.assertEquals(actualLoginMessage, expectedSuccessMessage,
                "Expected success login message to be displayed.");
    }

    @Test(description = "Error message shows if login with incorrect credentials")
    public void loginWithIncorrectCredentialsTest() {
        // given
        String expectedErrorMessage = "Wrong password or the account is disabled, or does not exist";
        LoginPage loginPage = new LoginPage(driver);
        LoginMessagePage loginMessagePage = new LoginMessagePage(driver);

        // when
        loginPage.login("elena.panova.9611@gmail.com", "asasa");
        String actualLoginMessage = loginMessagePage.getErrorMessage();

        // then
        Assert.assertEquals(actualLoginMessage, expectedErrorMessage,
                "Expected error message to be displayed.");
    }
}
