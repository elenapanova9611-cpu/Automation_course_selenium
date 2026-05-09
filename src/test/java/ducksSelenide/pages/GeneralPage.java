package ducksSelenide.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class GeneralPage {

    private static final By CHECKOUT_BUTTON = By.linkText("Checkout »");

    public static void clickCheckoutButton() {
        $(CHECKOUT_BUTTON).click();
    }
}
