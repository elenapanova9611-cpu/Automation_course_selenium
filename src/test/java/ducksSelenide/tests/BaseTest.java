package ducksSelenide.tests;

import com.codeborne.selenide.Configuration;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Browsers.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

@Listeners(ReportPortalTestNGListener.class)
public class BaseTest {

    @BeforeMethod
    public void setUp() {
        Browser browser = Browser.valueOf(System.getProperty("browser", "chrome"));
        DesiredCapabilities caps = new DesiredCapabilities();

        switch (browser) {
            case chrome: {
                Configuration.browser = CHROME;
                break;
            }
            case safari: {
                Configuration.browser = SAFARI;
                break;
            }
        }

        caps.setAcceptInsecureCerts(true);
        Configuration.remote = "http://192.168.1.34:4444/wd/hub";
        Configuration.browserCapabilities = caps;

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

