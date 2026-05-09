package ducksPageObject.tests;

import ducksPageObject.pages.CatalogPage;
import ducksPageObject.pages.ProductInfoPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CatalogTest extends BaseTest {

    @Override
    public String getPageUrl() {
        return PageUrls.CATALOG_URL;
    }

    @Test(description = "Check if Price filter is enabled by default")
    public void priceFilterIsActiveByDefault() {
        // given

        // when

        // then
        Assert.assertTrue(new CatalogPage(driver).isPriceFilterActive(),
                "Price filter is not active by default");
    }

    @Test(description = "Product info page opens when click catalogue item")
    public void clickCatalogItemOpensProductInfoPage() {
        // given
        CatalogPage catalogPage = new CatalogPage(driver);

        // when
        catalogPage.clickCatalogItem();

        // then
        Assert.assertTrue(new ProductInfoPage(driver).isProductInfoBlockDisplayed(), "Product info page is not displayed");
    }
}
