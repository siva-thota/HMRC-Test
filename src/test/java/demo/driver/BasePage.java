package demo.driver;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import demo.utils.Config;

import java.io.File;
import java.time.Duration;

public class BasePage {

    public WebDriver driver;

    Config config = new Config();
    public WebDriverWait wait;

    public BasePage () {
        driver = Driver.getDriver();
        int timeout = Integer.parseInt(config.getProperty("explicit_wait"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        PageFactory.initElements(driver, this);
    }

    public void openUrl(String url) {
        driver.navigate().to(url);
    }

    public void waitForElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForPage(String pageName) {
        wait.until(ExpectedConditions.titleIs(pageName));
    }

    public void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException("InterruptedException: ", e);
        }
    }

    public boolean validatePage(String pageTite) {
        return driver.getTitle().equalsIgnoreCase(pageTite);
    }

    public File takeScreenShot() {
        return ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
    }

    public File takeScreenShot(WebElement element) {
        return element.getScreenshotAs(OutputType.FILE);
    }

}
