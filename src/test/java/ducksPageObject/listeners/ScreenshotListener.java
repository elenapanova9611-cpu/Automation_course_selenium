package ducksPageObject.listeners;

import ducksPageObject.tests.BaseTest;
import ducksPageObject.utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class ScreenshotListener implements IInvokedMethodListener {

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult result) {
        if (!method.isTestMethod() || result.getThrowable() == null) {
            return;
        }
        Object instance = result.getInstance();
        if (instance instanceof BaseTest baseTest) {
            WebDriver driver = baseTest.getDriver();
            ScreenshotUtil.attachScreenshot(driver);
        }
    }
}
