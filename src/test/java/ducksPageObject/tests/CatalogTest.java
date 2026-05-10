package ducksPageObject.tests;

import ducksPageObject.pages.CatalogPage;
import ducksPageObject.pages.ProductInfoPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CatalogTest extends BaseTest {

    @Override
    public String getPageUrl() {
        return PageUrls.CATALOG_URL;
    }

    @Feature("Catalog")
    @Story("Implement catalog logic")
    @Description("Price filter should be enabled by default when opening Catalog")
    @Test(description = "Open Catalog page")
    public void priceFilterIsActiveByDefault() {
        // given

        // when

        // then
        Assert.assertTrue(new CatalogPage(driver).isPriceFilterActive(),
                "Price filter is not active by default");
    }

    @Feature("Catalog")
    @Story("Implement catalog logic")
    @Description("Product info page opens when click catalogue item")
    @Test(description = "Open Product Info page")
    public void clickCatalogItemOpensProductInfoPage() {
        // given
        CatalogPage catalogPage = new CatalogPage(driver);

        // when
        catalogPage.clickCatalogItem();

        // then
        Assert.assertTrue(new ProductInfoPage(driver).isProductInfoBlockDisplayed(), "Product info page is not displayed");
    }
}
