package Helpers;

import Pages.ChangeCard;
import Pages.Dashboard;
import Utility.BrowserDriver;
import com.epam.healenium.SelfHealingDriver;
import com.epam.healenium.SelfHealingDriverWait;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChangeCardHelper extends BrowserDriver {

    public WebDriverWait wait;


    public ChangeCardHelper(SelfHealingDriver driver) {
        super(driver);
        wait = new SelfHealingDriverWait(driver, Duration.ofSeconds(30));
    }

    public void verifyProductAndContractTypeOnChangeCard(String product, String icon)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ChangeCard.txtProductName)));

        String extractedProductName = driver.findElement(By.cssSelector(ChangeCard.txtProductName)).getText();
        String extractedIconPath = driver.findElement(By.cssSelector(ChangeCard.iconContractType)).getAttribute("src");

        // Find the position of "_" and ".svg"
        int underscoreIndex = extractedIconPath.lastIndexOf("_");
        int svgIndex = extractedIconPath.lastIndexOf(".svg");

        // Extract the substring between "_" and ".svg"
        String extractedIcon = extractedIconPath.substring(underscoreIndex + 1, svgIndex);

        //Assert.assertEquals(product,extractedProductName);
        Assert.assertEquals(icon,extractedIcon);
        assert extractedProductName.contains(product);
    }

    public void clickOnReturn()
    {
        driver.findElement(By.xpath(ChangeCard.btnReturn)).click();
    }

    public void clickYesOnAbandonPopUp()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ChangeCard.btnOuiAbandonnerPopUp)));
        driver.findElement(By.xpath(ChangeCard.btnOuiAbandonnerPopUp)).click();
    }
}
