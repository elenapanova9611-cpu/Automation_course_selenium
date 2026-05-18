package ducksPageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginMessagePage {

    private static final By SUCCESS_LOGIN_MESSAGE = By.cssSelector(".notice.success");
    private static final By ERROR_LOGIN_MESSAGE = By.cssSelector(".notice.errors");

    private WebDriver driver;

    public LoginMessagePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSuccessMessage() {
        return driver.findElement(SUCCESS_LOGIN_MESSAGE).getText();
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_LOGIN_MESSAGE).getText();
    }

}
