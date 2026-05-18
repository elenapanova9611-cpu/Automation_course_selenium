package ducksPageObject.tests;

import ducksPageObject.pages.LoginMessagePage;
import ducksPageObject.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Feature("Authentication")
    @Story("Implement authentication logic")
    @Description("Success message shows if login with correct credentials")
    @Test(description = "Login with correct credentials")
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

    @Feature("Authentication")
    @Story("Implement authentication logic")
    @Description("Error message shows if login with incorrect credentials")
    @Test(description = "Login with incorrect credentials")
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
