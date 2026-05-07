package ducks.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;


    @BeforeMethod
    public void setUp() {
        Browser browser = Browser.valueOf(System.getProperty("browser", "chrome"));

        switch (browser) {
            case chrome: {
                ChromeOptions options = new ChromeOptions();
                options.setAcceptInsecureCerts(true);
                driver = new ChromeDriver(options);
                break;
            }
            case safari: {
                SafariOptions options = new SafariOptions();
                options.setAcceptInsecureCerts(true);
                driver = new SafariDriver(options);
                break;
            }
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public class PageUrls {
        static final String DUCK_SHOP_URL = "http://litecart.stqa.ru/en/";
        static final String CATALOG_URL = "http://litecart.stqa.ru/en/rubber-ducks-c-1/";
    }
}

