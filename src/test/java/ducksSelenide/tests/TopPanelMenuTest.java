package ducksSelenide.tests;

import com.codeborne.selenide.Condition;
import ducksSelenide.pages.TopPanelMenuPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.title;

public class TopPanelMenuTest extends BaseTest {


    @Feature("Top Panel Menu")
    @Story("Implement Top Panel Menu")
    @Description("Clicking the Home icon in the top panel opens the home page with the slider image visible.")
    @Test(description = "Click the Home icon in the top panel")
    public void homePageButtonClickOpensHomePageTest() {
        // given

        // when
        TopPanelMenuPage.openHomePage();

        // then
        TopPanelMenuPage.getHomePageImageElement().shouldBe(Condition.visible);
    }

    @Feature("Top Panel Menu")
    @Story("Implement Top Panel Menu")
    @Description("Clicking Rubber Ducks in the top panel opens the Rubber Ducks category page")
    @Test(description = "Click Rubber Ducks in the top panel")
    public void rubberDuckButtonClickOpensRubberDucksPageTest() {
        // given
        String expectedRubberDucksPageTitle = "Rubber Ducks | My Store";

        // when
        TopPanelMenuPage.openRubberDucksPage();

        // then
        webdriver().shouldHave(title(expectedRubberDucksPageTitle));
    }

    // ToDO - flaky test, should be fixed
    @Feature("Top Panel Menu")
    @Story("Implement Top Panel Menu")
    @Description("Hovering Rubber Ducks and clicking Subcategory opens the Subcategory page")
    @Test(description = "Hover Rubber Ducks and clicking Subcategory")
    public void subcategoryButtonClickOpensSubcategoryPageTest() {
        // given
        String expectedSubcategoryPageTitle = "Subcategory | My Store";

        // when
        TopPanelMenuPage.openSubcategoryPage();

        // then
        webdriver().shouldHave(title(expectedSubcategoryPageTitle));
    }
}
