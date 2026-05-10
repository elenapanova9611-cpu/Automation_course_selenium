package ducksPageObject.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogPage {

    private static final By PRODUCT_LINK = By.xpath("//a[@class='link'][contains(@title, 'Duck')]");
    private static final By FILTER_PRICE = By.xpath("//nav[@class='filter']/*[text()='Price']");

    private WebDriver driver;

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Check if Price filter ia active by default")
    public boolean isPriceFilterActive() {
        return driver.findElement(FILTER_PRICE).getAttribute("class").contains("active");
    }

    @Step("Click catalog item")
    public void clickCatalogItem() {
        driver.findElement(PRODUCT_LINK).click();
    }
}
