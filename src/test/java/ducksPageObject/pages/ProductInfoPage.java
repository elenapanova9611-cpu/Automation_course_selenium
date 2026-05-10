package ducksPageObject.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductInfoPage {

    private static final By ADD_TO_CART_BUTTON = By.cssSelector("button[name='add_cart_product'][type='submit']");
    private static final By PRODUCT_INFO_BLOCK = By.cssSelector("div.information");
    private static final By CART_ITEMS_BUTTON = By.cssSelector("span.quantity");

    private WebDriver driver;

    public ProductInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Check if Product Info page is displayed when catalog item is clicked")
    public boolean isProductInfoBlockDisplayed() {
        return driver.findElement(PRODUCT_INFO_BLOCK).isDisplayed();
    }

    @Step("Add product to cart")
    public void clickAddToCartButton() {
        driver.findElement(ADD_TO_CART_BUTTON).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(CART_ITEMS_BUTTON, "0")));
    }
}
