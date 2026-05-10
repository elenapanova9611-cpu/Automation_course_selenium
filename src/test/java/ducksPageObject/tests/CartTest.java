package ducksPageObject.tests;

import ducksPageObject.pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Override
    public String getPageUrl() {
        return PageUrls.CATALOG_URL;
    }

    @Feature("Cart")
    @Story("Implement cart logic")
    @Test(description = "Add product to cart")
    @Description("Product is added to cart when it card button is clicked")
    public void clickAddToCartButtonAddsProductToCart() {
        // given
        CatalogPage catalogPage = new CatalogPage(driver);
        ProductInfoPage productInfoPage = new ProductInfoPage(driver);
        GeneralPage generalPage = new GeneralPage(driver);

        // when
        catalogPage.clickCatalogItem();
        productInfoPage.clickAddToCartButton();
        generalPage.clickCheckoutButton();

        // then
        Assert.assertTrue(new CartPage(driver).isCartNotEmpty(), "Cart is empty");
    }

    @Feature("Cart")
    @Story("Implement cart logic")
    @Test(description = "Remove product from cart")
    @Description("Products removed from card when remove button is pressed")
    public void clickRemoveButtonDeletesProductFromCart() {
        // given
        CatalogPage catalogPage = new CatalogPage(driver);
        ProductInfoPage productInfoPage = new ProductInfoPage(driver);
        GeneralPage generalPage = new GeneralPage(driver);
        CartPage cartPage = new CartPage(driver);

        // when
        catalogPage.clickCatalogItem();
        productInfoPage.clickAddToCartButton();
        generalPage.clickCheckoutButton();
        cartPage.clickRemoveButton();

        // then
        Assert.assertTrue(cartPage.isCartEmpty(), "Cart is not empty");
    }
}
