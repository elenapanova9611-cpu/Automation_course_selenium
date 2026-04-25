package ducks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

public class DuckShopTopMenuTests extends BaseTest {

    static final String HOME_BUTTON = "i[title='Home']";
    static final String HOME_PAGE_IMAGE = "li[id='rslides1_s0']>a>img";
    static final String RUBBER_DUCK_BUTTON = "Rubber Ducks";
    static final String SUBCATEGORY_BUTTON = "Subcategory";


    @Test
    public void openHomePageTest() {
        driver.findElement(By.cssSelector(HOME_BUTTON)).click();
        Assert.assertTrue(driver.findElement(By.cssSelector(HOME_PAGE_IMAGE)).isDisplayed());
    }

    @Test
    public void openRubberDucksTabTest() {
        driver.findElement(By.linkText(RUBBER_DUCK_BUTTON)).click();

        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Rubber Ducks | My Store");
    }

    @Test
    public void openSubcategoryTabTest() {
        WebElement rubberDuckMenuTab = driver.findElement(By.linkText(RUBBER_DUCK_BUTTON));
        Actions actions = new Actions(driver);
        actions.moveToElement(rubberDuckMenuTab).perform();
        driver.findElement(By.linkText(SUBCATEGORY_BUTTON)).click();

        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Subcategory | My Store");
    }
}
