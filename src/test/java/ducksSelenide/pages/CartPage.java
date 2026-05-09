package ducksSelenide.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CartPage {

    private static final By REMOVE_BUTTON = By.cssSelector("button[name='remove_cart_item'][type='submit']");
    private static final By CUSTOMER_DETAILS_TITLE = By.xpath("//h2[@class='title'][text()='Customer Details']");
    private static final By ORDER_SUMMARY_TITLE = By.xpath("//h2[@class='title'][text()='Order Summary']");
    private static final By EMPTY_CART_MESSAGE = By.xpath("//em[contains(text(),'There are no items in your cart.')]");


    public static SelenideElement getCustomerDetailsTitle() {
        return $(CUSTOMER_DETAILS_TITLE);
    }

    public static SelenideElement getOrderSummaryTitle() {
        return $(ORDER_SUMMARY_TITLE);
    }

    public static SelenideElement getEmptyCartMessage() {
        return $(EMPTY_CART_MESSAGE);
    }

    public static void clickRemoveButton() {
        $(REMOVE_BUTTON).click();
    }
}
