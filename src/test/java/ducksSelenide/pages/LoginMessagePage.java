package ducksSelenide.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginMessagePage {

    private static final By SUCCESS_LOGIN_MESSAGE = By.cssSelector(".notice.success");
    private static final By ERROR_LOGIN_MESSAGE = By.cssSelector(".notice.errors");


    public static String getSuccessMessage() {
        return $(SUCCESS_LOGIN_MESSAGE).getText();
    }

    public static String getErrorMessage() {
        return $(ERROR_LOGIN_MESSAGE).getText();
    }

    public static SelenideElement getSuccessMessageElement() {
        return $(SUCCESS_LOGIN_MESSAGE);
    }

    public static SelenideElement getErrorMessageElement() {
        return $(ERROR_LOGIN_MESSAGE);
    }
}
