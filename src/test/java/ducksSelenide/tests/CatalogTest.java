package ducksSelenide.tests;

import com.codeborne.selenide.Condition;
import ducksSelenide.pages.CatalogPage;
import ducksSelenide.pages.ProductInfoPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.cssClass;

public class CatalogTest extends BaseTest {

    @Override
    protected String startUrl() {
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
        CatalogPage.getFilterPriceElement().shouldHave(cssClass("active"));
    }

    @Feature("Catalog")
    @Story("Implement catalog logic")
    @Description("Product info page opens when click catalogue item")
    @Test(description = "Open Product Info page")
    public void clickCatalogItemOpensProductInfoPage() {
        // given

        // when
        CatalogPage.clickCatalogItem();

        // then
        ProductInfoPage.getProductInfoBlockElement().shouldBe(Condition.visible);
    }
}
