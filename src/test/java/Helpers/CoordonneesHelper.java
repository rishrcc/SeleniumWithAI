package Helpers;

import Pages.MesCoordonees;
import Pages.WeakAuthLogin;
import Utility.BrowserDriver;
import com.epam.healenium.SelfHealingDriver;
import com.epam.healenium.SelfHealingDriverWait;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CoordonneesHelper extends BrowserDriver {

    public WebDriverWait wait;

    public CoordonneesHelper(SelfHealingDriver driver) {
        super(driver);
        wait = new SelfHealingDriverWait(driver, Duration.ofSeconds(30));
    }

    public void verifyFullname(String fullname)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(MesCoordonees.txtFullName)));
        String extractedname = driver.findElement(By.cssSelector(MesCoordonees.txtFullName)).getText();
        Assert.assertEquals(fullname,extractedname);
    }

}
