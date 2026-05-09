package ducksPageObject.tests;

import ducksPageObject.pages.TopPanelMenuPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TopPanelMenuTest extends BaseTest {

    @Test(description = "Clicking the Home icon in the top panel opens the home page with the slider image visible.")
    public void homePageButtonClickOpensHomePageTest() {
        // given
        TopPanelMenuPage topPanelMenuPage = new TopPanelMenuPage(driver);

        // when
        topPanelMenuPage.openHomePage();

        // then
        Assert.assertTrue(topPanelMenuPage.isHomePageImageDisplayed(),
                "Expected the home page image to be visible after clicking Home in the top panel.");
    }

    @Test(description = "Clicking Rubber Ducks in the top panel opens the Rubber Ducks category page")
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
    @Test(description = "Hovering Rubber Ducks and clicking Subcategory opens the Subcategory page")
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
