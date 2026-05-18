package ducksSelenide.tests;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import ducksSelenide.pages.CartPage;
import ducksSelenide.pages.CatalogPage;
import ducksSelenide.pages.GeneralPage;
import ducksSelenide.pages.ProductInfoPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Override
    protected String startUrl() {
        return PageUrls.CATALOG_URL;
    }

    @Feature("Cart")
    @Story("Implement cart logic")
    @Test(description = "Add product to cart")
    @Description("Product is added to cart when it card button is clicked")
    public void clickAddToCartButtonAddsProductToCart() {
        // given

        // when
        CatalogPage.clickCatalogItem();
        ProductInfoPage.clickAddToCartButton();
        GeneralPage.clickCheckoutButton();

        // then
        AssertionMode previousMode = Configuration.assertionMode;
        Configuration.assertionMode = AssertionMode.SOFT;
        try {
            CartPage.getCustomerDetailsTitleElement().shouldBe(Condition.visible);
            CartPage.getOrderSummaryTitleElement().shouldBe(Condition.visible);
        } finally {
            Configuration.assertionMode = previousMode;
        }
    }

    @Feature("Cart")
    @Story("Implement cart logic")
    @Test(description = "Remove product from cart")
    @Description("Products removed from card when remove button is pressed")
    public void clickRemoveButtonDeletesProductFromCart() {
        // given

        // when
        CatalogPage.clickCatalogItem();
        ProductInfoPage.clickAddToCartButton();
        GeneralPage.clickCheckoutButton();
        CartPage.clickRemoveButton();

        // then
        CartPage.getEmptyCartMessageElement().shouldBe(Condition.visible);
    }
}
