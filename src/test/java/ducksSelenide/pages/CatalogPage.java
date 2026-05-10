package ducksSelenide.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CatalogPage {

    private static final By PRODUCT_LINK = By.xpath("//a[@class='link'][contains(@title, 'Duck')]");
    private static final By FILTER_PRICE = By.xpath("//nav[@class='filter']/*[text()='Price']");


    public static SelenideElement getFilterPriceElement() {
        return $(FILTER_PRICE);
    }

    @Step("Click catalog item")
    public static void clickCatalogItem() {
        $(PRODUCT_LINK).click();
    }
}
