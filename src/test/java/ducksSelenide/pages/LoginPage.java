package ducksSelenide.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private static final By EMAIL_INPUT = By.name("email");
    private static final By PASSWORD_INPUT = By.name("password");
    private static final By LOGIN_BUTTON = By.name("login");


    public static void enterEmail(String email) {
        $(EMAIL_INPUT).sendKeys(email);
    }

    public static void enterPassword(String password) {
        $(PASSWORD_INPUT).sendKeys(password);
    }

    public static void clickLoginButton() {
        $(LOGIN_BUTTON).click();
    }

    public static void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
}
