package ducks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TopPanelMenuPage {

    private static final By HOME_BUTTON = By.cssSelector("i[title='Home']");
    private static final By HOME_PAGE_IMAGE = By.cssSelector("li[id='rslides1_s0']>a>img");
    private static final By RUBBER_DUCK_BUTTON = By.linkText("Rubber Ducks");
    private static final By SUBCATEGORY_BUTTON = By.linkText("Subcategory");

    private WebDriver driver;

    public TopPanelMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openHomePage() {
        driver.findElement(HOME_BUTTON).click();
    }

    public void openRubberDucksPage() {
        driver.findElement(RUBBER_DUCK_BUTTON).click();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void openSubcategoryPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement rubberDuckMenuTab = driver.findElement(RUBBER_DUCK_BUTTON);
        Actions actions = new Actions(driver);
        actions.moveToElement(rubberDuckMenuTab).perform();
        wait.until(ExpectedConditions.elementToBeClickable(SUBCATEGORY_BUTTON)).click();
    }

    public boolean isHomePageImageDisplayed() {
        return driver.findElement(HOME_PAGE_IMAGE).isDisplayed();
    }
}
