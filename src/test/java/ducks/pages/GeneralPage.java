package ducks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GeneralPage {

    private static final By CHECKOUT_BUTTON = By.linkText("Checkout »");

    private WebDriver driver;

    public GeneralPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCheckoutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }
}
