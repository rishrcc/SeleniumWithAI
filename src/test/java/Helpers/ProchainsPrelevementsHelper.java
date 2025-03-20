package Helpers;

import Pages.Dashboard;
import Pages.Echeanciers;
import Pages.ProchainsPrelevements;
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
import java.util.List;

public class ProchainsPrelevementsHelper extends BrowserDriver {

    public WebDriverWait wait;
    public DashboardHelper DashboardStep;

    public ProchainsPrelevementsHelper(SelfHealingDriver driver) {
        super(driver);
        wait = new SelfHealingDriverWait(driver, Duration.ofSeconds(30));
        DashboardStep = new DashboardHelper(driver);
    }

    public void verifyProductNameAndIconOnProchainsPrelevementsPage(String product, String icon) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ProchainsPrelevements.txtProductNameProchainPrelevement)));
        List<WebElement> elementsProductName = driver.findElements(By.cssSelector(ProchainsPrelevements.txtProductNameProchainPrelevement));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ProchainsPrelevements.iconContractTypeProchainPrelevement)));
        List<WebElement> elements = driver.findElements(By.cssSelector(ProchainsPrelevements.iconContractTypeProchainPrelevement));

        int position = DashboardStep.verifySideMenuProductNameFromList(product);

        String extractedMainPageProductName = elementsProductName.get(position).getText();
        String extractedMainPageIconPath = elements.get(position).getAttribute("src");

        // Find the position of "_" and ".svg"
        int underscoreIndex = extractedMainPageIconPath.lastIndexOf("_");
        int svgIndex = extractedMainPageIconPath.lastIndexOf(".svg");

        // Extract the substring between "_" and ".svg"
        String extractedMainPageIcon = extractedMainPageIconPath.substring(underscoreIndex + 1, svgIndex);

        Assert.assertEquals(product, extractedMainPageProductName);
        Assert.assertEquals(icon, extractedMainPageIcon);
    }
}
