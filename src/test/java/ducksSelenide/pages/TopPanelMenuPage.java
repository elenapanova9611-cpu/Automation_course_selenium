package ducksSelenide.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TopPanelMenuPage {

    private static final By HOME_BUTTON = By.cssSelector("i[title='Home']");
    private static final By HOME_PAGE_IMAGE = By.cssSelector("li[id='rslides1_s0']>a>img");
    private static final By RUBBER_DUCK_BUTTON = By.linkText("Rubber Ducks");
    private static final By SUBCATEGORY_BUTTON = By.linkText("Subcategory");

    public static void openHomePage() {
        $(HOME_BUTTON).click();
    }

    public static void openRubberDucksPage() {
        $(RUBBER_DUCK_BUTTON).click();
    }

    public static void openSubcategoryPage() {
        actions().moveToElement($(RUBBER_DUCK_BUTTON)).perform();
        $(SUBCATEGORY_BUTTON).shouldBe(visible, Duration.ofSeconds(5)).click();
    }

    public static SelenideElement getHomePageImageElement() {
        return $(HOME_PAGE_IMAGE);
    }
}
