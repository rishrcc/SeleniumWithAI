package Utility;

import com.epam.healenium.SelfHealingDriver;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;

public class BrowserDriver {
    //public static WebDriver driver;
    public static SelfHealingDriver driver;


    //WebDriver
    public BrowserDriver(SelfHealingDriver driver)
    {

        BrowserDriver.driver = driver;
    }

    //WebDriver
    public static SelfHealingDriver getDriver()
    {
        if (driver == null) {
            //System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--headless"); // If running in a headless environment
            options.addArguments("--disable-gpu");
            options.addArguments("--remote-allow-origins=*");

            WebDriver delegateDriver = new ChromeDriver(options);
            driver = SelfHealingDriver.create(delegateDriver);
            //driver = new ChromeDriver();
        }
        return driver;
    }

    public static void takeScreenshotAfterStep(Scenario scenario)
    {
        WebDriver actualDriver = driver.getDelegate();
        if (actualDriver instanceof TakesScreenshot) {
            byte[] screenshot = ((TakesScreenshot) actualDriver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Step Screenshot", new ByteArrayInputStream(screenshot));
        }
    }

    
    public static void takeScreenshot(Scenario scenario) {
        if (driver != null) {
            try {
                if (scenario.isFailed()) {
                    // Access the underlying WebDriver and cast it to TakesScreenshot
                    WebDriver actualDriver = driver.getDelegate();
                    if (actualDriver instanceof TakesScreenshot) {
                        byte[] screenshot = ((TakesScreenshot) actualDriver).getScreenshotAs(OutputType.BYTES);
                        Allure.addAttachment("Failed Screenshot", new ByteArrayInputStream(screenshot));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void quitDriver(Scenario scenario)
    {
        if (driver != null) {
            if (scenario.isFailed())
            {
                takeScreenshot(scenario);
            }
            driver.close();
            driver.quit();
            driver = null;
        }
    }
}
