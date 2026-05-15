package ducksPageObject.tests;

import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@Listeners(ReportPortalTestNGListener.class)
public class BaseTest {
    protected WebDriver driver;


    @BeforeMethod
    public void setUp() throws MalformedURLException {
        Browser browser = Browser.valueOf(System.getProperty("browser", "chrome"));
        DesiredCapabilities caps = new DesiredCapabilities();

        switch (browser) {
            case chrome -> {
                caps.setBrowserName("chrome");
            }
            case safari -> {
                caps.setBrowserName("safari");
            }
        }
        caps.setAcceptInsecureCerts(true);
        driver = new RemoteWebDriver(new URL("http://192.168.1.34:4444/wd/hub"), caps);

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(getPageUrl());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    protected String getPageUrl() {
        return PageUrls.DUCK_SHOP_URL;
    }

    public class PageUrls {
        static final String DUCK_SHOP_URL = "http://litecart.stqa.ru/en/";
        static final String CATALOG_URL = "http://litecart.stqa.ru/en/rubber-ducks-c-1/";
    }
}

