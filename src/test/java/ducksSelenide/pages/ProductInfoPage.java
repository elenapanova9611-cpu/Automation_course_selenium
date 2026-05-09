package ducksSelenide.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ProductInfoPage {

    private static final By ADD_TO_CART_BUTTON = By.cssSelector("button[name='add_cart_product'][type='submit']");
    private static final By PRODUCT_INFO_BLOCK = By.cssSelector("div.information");
    private static final By CART_ITEMS_BUTTON = By.cssSelector("span.quantity");

    public static SelenideElement getProductInfoBlockElement() {
        return $(PRODUCT_INFO_BLOCK);
    }

    public static void clickAddToCartButton() {
        $(ADD_TO_CART_BUTTON).click();
        $(CART_ITEMS_BUTTON).shouldNotHave(text("0"));
    }
}
