package ducksSelenide.tests;

import ducksSelenide.pages.LoginMessagePage;
import ducksSelenide.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;

public class LoginTest extends BaseTest {


    @Feature("Authentication")
    @Story("Implement authentication logic")
    @Description("Success message shows if login with correct credentials")
    @Test(description = "Login with correct credentials")
    public void loginWithCorrectCredentialsTest() {
        // given
        String expectedSuccessMessage = "You are now logged in as Lena Panova.";

        // when
        LoginPage.login("elena.panova.9611@gmail.com", "Test12345");

        // then
        LoginMessagePage.getSuccessMessageElement().shouldHave(text(expectedSuccessMessage));
    }

    @Feature("Authentication")
    @Story("Implement authentication logic")
    @Description("Error message shows if login with incorrect credentials")
    @Test(description = "Login with incorrect credentials")
    public void loginWithIncorrectCredentialsTest() {
        // given
        String expectedErrorMessage = "Wrong password or the account is disabled, or does not exist";

        // when
        LoginPage.login("elena.panova.9611@gmail.com", "asasa");

        // then
        LoginMessagePage.getErrorMessageElement().shouldHave(text(expectedErrorMessage));
    }
}
