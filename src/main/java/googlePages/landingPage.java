package googlePages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class landingPage {
    protected static WebDriver driver;

    public landingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,1500)");

    }
}