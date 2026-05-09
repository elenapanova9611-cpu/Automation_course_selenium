package ducksPageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private static final By REMOVE_BUTTON = By.cssSelector("button[name='remove_cart_item'][type='submit']");
    private static final By CUSTOMER_DETAILS_TITLE = By.xpath("//h2[@class='title'][text()='Customer Details']");
    private static final By ORDER_SUMMARY_TITLE = By.xpath("//h2[@class='title'][text()='Order Summary']");
    private static final By EMPTY_CART_MESSAGE = By.xpath("//em[contains(text(),'There are no items in your cart.')]");

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCartNotEmpty() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(CUSTOMER_DETAILS_TITLE)).isDisplayed()
                && wait.until(ExpectedConditions.visibilityOfElementLocated(ORDER_SUMMARY_TITLE)).isDisplayed();
    }

    public boolean isCartEmpty() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(EMPTY_CART_MESSAGE)).isDisplayed();
    }

    public void clickRemoveButton() {
        driver.findElement(REMOVE_BUTTON).click();
    }
}
