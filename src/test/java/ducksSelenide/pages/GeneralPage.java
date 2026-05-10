package ducksSelenide.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class GeneralPage {

    private static final By CHECKOUT_BUTTON = By.linkText("Checkout »");

    @Step("Go to Checkout page")
    public static void clickCheckoutButton() {
        $(CHECKOUT_BUTTON).click();
    }
}
