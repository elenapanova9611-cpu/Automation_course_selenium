package ducksSelenide.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebElementCondition;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import ducksSelenide.pages.CartPage;
import ducksSelenide.pages.CatalogPage;
import ducksSelenide.pages.GeneralPage;
import ducksSelenide.pages.ProductInfoPage;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Override
    protected String startUrl() {
        return PageUrls.CATALOG_URL;
    }

    @Test(description = "Product is added to cart when it card button is clicked")
    public void clickAddToCartButtonAddsProductToCart() {
        // given

        // when
        CatalogPage.clickCatalogItem();
        ProductInfoPage.clickAddToCartButton();
        GeneralPage.clickCheckoutButton();

        // then
        CartPage.getCustomerDetailsTitle().shouldBe(Condition.visible);
        CartPage.getOrderSummaryTitle().shouldBe(Condition.visible);
    }

    @Test(description = "Products removed from card when remove button is pressed")
    public void clickRemoveButtonDeletesProductFromCart() {
        // given

        // when
        CatalogPage.clickCatalogItem();
        ProductInfoPage.clickAddToCartButton();
        GeneralPage.clickCheckoutButton();
        CartPage.clickRemoveButton();

        // then
        CartPage.getEmptyCartMessage().shouldBe(Condition.visible);
    }
}
