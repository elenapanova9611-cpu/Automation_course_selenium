package ducksSelenide.tests;

import com.codeborne.selenide.Condition;
import ducksSelenide.pages.CatalogPage;
import ducksSelenide.pages.ProductInfoPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.cssClass;

public class CatalogTest extends BaseTest {

    @Override
    protected String startUrl() {
        return PageUrls.CATALOG_URL;
    }

    @Test(description = "Check if Price filter is enabled by default")
    public void priceFilterIsActiveByDefault() {
        // given

        // when

        // then
        CatalogPage.getFilterPriceElement().shouldHave(cssClass("active"));
    }

    @Test(description = "Product info page opens when click catalogue item")
    public void clickCatalogItemOpensProductInfoPage() {
        // given

        // when
        CatalogPage.clickCatalogItem();

        // then
        ProductInfoPage.getProductInfoBlockElement().shouldBe(Condition.visible);
    }
}
