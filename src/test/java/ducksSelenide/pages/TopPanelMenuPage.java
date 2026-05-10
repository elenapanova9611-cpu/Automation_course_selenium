package ducksSelenide.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TopPanelMenuPage {

    private static final By HOME_BUTTON = By.cssSelector("i[title='Home']");
    private static final By HOME_PAGE_IMAGE = By.cssSelector("li[id='rslides1_s0']>a>img");
    private static final By RUBBER_DUCK_BUTTON = By.linkText("Rubber Ducks");
    private static final By SUBCATEGORY_BUTTON = By.linkText("Subcategory");

    @Step("Open home page")
    public static void openHomePage() {
        $(HOME_BUTTON).click();
    }

    @Step("Open Rubber Ducks page")
    public static void openRubberDucksPage() {
        $(RUBBER_DUCK_BUTTON).click();
    }

    @Step("Open Subcategory page")
    public static void openSubcategoryPage() {
        actions().moveToElement($(RUBBER_DUCK_BUTTON)).perform();
        $(SUBCATEGORY_BUTTON).shouldBe(visible, Duration.ofSeconds(5)).click();
    }

    public static SelenideElement getHomePageImageElement() {
        return $(HOME_PAGE_IMAGE);
    }
}
