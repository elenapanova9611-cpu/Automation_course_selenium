package ducksSelenide.tests;

import com.codeborne.selenide.Condition;
import ducksSelenide.pages.TopPanelMenuPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.title;

public class TopPanelMenuTest extends BaseTest {


    @Test(description = "Clicking the Home icon in the top panel opens the home page with the slider image visible.")
    public void homePageButtonClickOpensHomePageTest() {
        // given

        // when
        TopPanelMenuPage.openHomePage();

        // then
        TopPanelMenuPage.getHomePageImageElement().shouldBe(Condition.visible);
    }

    @Test(description = "Clicking Rubber Ducks in the top panel opens the Rubber Ducks category page")
    public void rubberDuckButtonClickOpensRubberDucksPageTest() {
        // given
        String expectedRubberDucksPageTitle = "Rubber Ducks | My Store";

        // when
        TopPanelMenuPage.openRubberDucksPage();

        // then
        webdriver().shouldHave(title(expectedRubberDucksPageTitle));
    }

    // ToDO - flaky test, should be fixed
    @Test(description = "Hovering Rubber Ducks and clicking Subcategory opens the Subcategory page")
    public void subcategoryButtonClickOpensSubcategoryPageTest() {
        // given
        String expectedSubcategoryPageTitle = "Subcategory | My Store";

        // when
        TopPanelMenuPage.openSubcategoryPage();

        // then
        webdriver().shouldHave(title(expectedSubcategoryPageTitle));
    }
}
