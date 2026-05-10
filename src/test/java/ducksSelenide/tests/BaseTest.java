package ducksSelenide.tests;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Browsers.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeMethod
    // полностью разобрать
    public void setUp() {
        Browser browser = Browser.valueOf(System.getProperty("browser", "chrome"));

        switch (browser) {
            case chrome: {
                ChromeOptions options = new ChromeOptions();
                options.setAcceptInsecureCerts(true);
                Configuration.browser = CHROME;
                Configuration.browserCapabilities = options;
                break;
            }
            case safari: {
                SafariOptions options = new SafariOptions();
                options.setAcceptInsecureCerts(true);
                Configuration.browser = SAFARI;
                Configuration.browserCapabilities = options;
                break;
            }
        }

        Configuration.pageLoadTimeout = 5000;
        Configuration.timeout = 5000;
        Configuration.browserSize = "1800x1000";

        open(startUrl());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        closeWebDriver();
    }

    protected String startUrl() {
        return PageUrls.DUCK_SHOP_URL;
    }

    public static class PageUrls {
        static final String DUCK_SHOP_URL = "http://litecart.stqa.ru/en/";
        static final String CATALOG_URL = "http://litecart.stqa.ru/en/rubber-ducks-c-1/";
    }
}

