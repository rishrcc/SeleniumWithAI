package Helpers;

import Pages.Dashboard;
import Pages.Echeanciers;
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

public class EcheancierHelper extends BrowserDriver {

    public WebDriverWait wait;
    public DashboardHelper DashboardStep;

    public EcheancierHelper(SelfHealingDriver driver) {
        super(driver);
        wait = new SelfHealingDriverWait(driver, Duration.ofSeconds(30));
        DashboardStep = new DashboardHelper(driver);
    }

    public void verifyEcheancierPageProductIconAndName(String product, String icon) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Echeanciers.txtProductName)));
        List<WebElement> elementsProductName = driver.findElements(By.cssSelector(Echeanciers.txtProductName));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Echeanciers.iconContractType)));
        List<WebElement> elements = driver.findElements(By.xpath(Echeanciers.iconContractType));

        int position = DashboardStep.verifySideMenuProductNameFromList(product);

        String extractedEcheancierMainPageProductName = elementsProductName.get(position).getText();
        String extractedEcheancierMainPageIconPath = elements.get(position).getAttribute("src");

        // Find the position of "_" and ".svg"
        int underscoreIndex = extractedEcheancierMainPageIconPath.lastIndexOf("_");
        int svgIndex = extractedEcheancierMainPageIconPath.lastIndexOf(".svg");

        // Extract the substring between "_" and ".svg"
        String extractedMainPageIcon = extractedEcheancierMainPageIconPath.substring(underscoreIndex + 1, svgIndex);

        Assert.assertEquals(product, extractedEcheancierMainPageProductName);
        Assert.assertEquals(icon, extractedMainPageIcon);
    }

    public void verifyEcheancierInitialAndActualise(String product) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Echeanciers.txtEcheancierInitial)));
        List<WebElement> elementsIni = driver.findElements(By.xpath(Echeanciers.txtEcheancierInitial));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Echeanciers.txtEcheancierActualise)));
        List<WebElement> elementsActu = driver.findElements(By.xpath(Echeanciers.txtEcheancierActualise));

        int position = DashboardStep.verifySideMenuProductNameFromList(product);

        String extractedEcheancierIni = elementsIni.get(position).getText();
        String extractedEcheancierActu = elementsActu.get(position).getText();

        Assert.assertEquals(extractedEcheancierIni, "Échéancier initial");
        Assert.assertEquals(extractedEcheancierActu, "Échéancier actualisé");
    }


    public void clickOnEcheancierInitial(String product) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Echeanciers.txtEcheancierInitial)));
        List<WebElement> elementsIni = driver.findElements(By.xpath(Echeanciers.txtEcheancierInitial));
        int position = DashboardStep.verifySideMenuProductNameFromList(product);
        elementsIni.get(position).click();
    }

    public void clickOnEcheancierActualise(String product) {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Echeanciers.txtEcheancierActualise)));
        //driver.findElement(By.xpath(Echeanciers.txtEcheancierActualise)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Echeanciers.txtEcheancierActualise)));
        List<WebElement> elementsActu = driver.findElements(By.xpath(Echeanciers.txtEcheancierActualise));
        int position = DashboardStep.verifySideMenuProductNameFromList(product);
        elementsActu.get(position).click();
    }

    public void verifyProductNameAndNumberOfInstallmentsUnderEcheancierInitial(String product, String number_of_installments) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Echeanciers.titleProductName)));
        String extractedProductName = driver.findElement(By.cssSelector(Echeanciers.titleProductName)).getText();
        String extractedNumberOfInstallments = driver.findElement(By.cssSelector(Echeanciers.txtNumberOfInstallments)).getText();

        Assert.assertEquals(product, extractedProductName);
        assert extractedNumberOfInstallments.contains(number_of_installments);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Echeanciers.txtInstallment)));
        List<WebElement> elementsNumberOfInstallments = driver.findElements(By.xpath(Echeanciers.txtInstallment));
        int expectedNumberOfInstallments = Integer.parseInt(number_of_installments);

        if (elementsNumberOfInstallments.size() == expectedNumberOfInstallments) {
            assert true;
        } else {
            assert false;
        }

    }

    public void verifyProductNameAndNumberOfInstallmentsUnderEcheancierActualise(String product) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Echeanciers.titleProductName)));
        String extractedProductName = driver.findElement(By.cssSelector(Echeanciers.titleProductName)).getText();
        Assert.assertEquals(product, extractedProductName);
    }
}
