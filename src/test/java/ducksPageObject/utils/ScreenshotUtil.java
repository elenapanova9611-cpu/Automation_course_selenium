package ducksPageObject.utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static void attachScreenshot(WebDriver driver) {
        if (!(driver instanceof TakesScreenshot takesScreenshot)) {
            return;
        }
        byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        Allure.getLifecycle().addAttachment("Page screenshot on failure", "image/png", "png", screenshot);
    }
}
