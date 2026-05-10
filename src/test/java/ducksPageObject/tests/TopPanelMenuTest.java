package ducksPageObject.tests;

import ducksPageObject.pages.TopPanelMenuPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TopPanelMenuTest extends BaseTest {

    @Feature("Top Panel Menu")
    @Story("Implement Top Panel Menu")
    @Description("Clicking the Home icon in the top panel opens the home page with the slider image visible.")
    @Test(description = "Click the Home icon in the top panel")
    public void homePageButtonClickOpensHomePageTest() {
        // given
        TopPanelMenuPage topPanelMenuPage = new TopPanelMenuPage(driver);

        // when
        topPanelMenuPage.openHomePage();

        // then
        Assert.assertTrue(topPanelMenuPage.isHomePageImageDisplayed(),
                "Expected the home page image to be visible after clicking Home in the top panel.");
    }

    @Feature("Top Panel Menu")
    @Story("Implement Top Panel Menu")
    @Description("Clicking Rubber Ducks in the top panel opens the Rubber Ducks category page")
    @Test(description = "Click Rubber Ducks in the top panel")
    public void rubberDuckButtonClickOpensRubberDucksPageTest() {
        // given
        String expectedRubberDucksPageTitle = "Rubber Ducks | My Store";
        TopPanelMenuPage topPanelMenuPage = new TopPanelMenuPage(driver);

        // when
        topPanelMenuPage.openRubberDucksPage();
        String actualTitle = topPanelMenuPage.getTitle();

        // then
        Assert.assertEquals(actualTitle, expectedRubberDucksPageTitle,
                "Expected document title 'Rubber Ducks | My Store' after opening Rubber Ducks from the top panel.");
    }

    // ToDO - flaky test, should be fixed
    @Feature("Top Panel Menu")
    @Story("Implement Top Panel Menu")
    @Description("Hovering Rubber Ducks and clicking Subcategory opens the Subcategory page")
    @Test(description = "Hover Rubber Ducks and clicking Subcategory")
    public void subcategoryButtonClickOpensSubcategoryPageTest() {
        // given
        String expectedSubcategoryPageTitle = "Subcategory | My Store";
        TopPanelMenuPage topPanelMenuPage = new TopPanelMenuPage(driver);

        // when
        topPanelMenuPage.openSubcategoryPage();
        String actualTitle = topPanelMenuPage.getTitle();

        // then
        Assert.assertEquals(actualTitle, expectedSubcategoryPageTitle,
                "Expected document title 'Subcategory | My Store' after opening Subcategory from the Rubber Ducks menu.");
    }
}
