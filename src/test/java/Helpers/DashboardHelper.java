package Helpers;

import Pages.Dashboard;
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


public class DashboardHelper extends BrowserDriver {

    public WebDriverWait wait;

    public DashboardHelper(SelfHealingDriver driver) {
        super(driver);
        wait = new SelfHealingDriverWait(driver, Duration.ofSeconds(30));
    }

    public void verifyNameOnDashboard(String fullname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Dashboard.txtFirstName)));
        String extractedFirstName = driver.findElement(By.cssSelector(Dashboard.txtFirstName)).getText();
        String[] nameParts = fullname.split(" ");
        String firstName = nameParts[0];
        Assert.assertEquals(firstName, extractedFirstName);
    }

    public void clickOnCoordonnees() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Dashboard.lnkCoordonnees)));
        driver.findElement(By.xpath(Dashboard.lnkCoordonnees)).click();
    }

    public void clickOnEcheanciers() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Dashboard.lnkEcheanciers)));
        driver.findElement(By.xpath(Dashboard.lnkEcheanciers)).click();
    }

    public void clickOnProchainsPrelevements() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Dashboard.lnkProchainsPrelevements)));
        driver.findElement(By.xpath(Dashboard.lnkProchainsPrelevements)).click();
    }

    public void closeMobileDownloadPopUp() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Dashboard.titlePopMobileAppDownload)));
            driver.findElement(By.xpath(Dashboard.btnCloseMobileAppDownloadPopUp)).click();
        } catch (Exception e) {
            System.out.println("User not registered to mobile app");
        }

    }

    public int verifySideMenuProductNameFromList(String product) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Dashboard.listProductsSideMenu)));

        // Locate the elements using XPath
        List<WebElement> elements = driver.findElements(By.xpath(Dashboard.listProductsSideMenu));
        int position = -1;

        // Iterate through the elements and check their text content
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().equals(product)) {
                position = i;
                assert true;
                break;
            }
        }
        return position;
    }

    public void clickOnSideMenuProductNameFromList(String subtitle) throws InterruptedException {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Dashboard.listProductsSideMenu)));
        // Locate the elements using XPath
        List<WebElement> elements = driver.findElements(By.xpath(Dashboard.listProductsSideMenu));

        // Iterate through the elements and check their text content
        for (WebElement element : elements) {
            if (element.getText().contains(subtitle)) {
                element.click();
                return;
            }
        }
    }

    public void verifyProductHasUnpaidClass(String subtitle) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Dashboard.listProductsSideMenu)));
        // Locate the elements using XPath
        List<WebElement> elements = driver.findElements(By.xpath(Dashboard.listProductsSideMenu));

        // Iterate through the elements and check their text content
        for (WebElement element : elements) {
            if (element.getText().contains(subtitle)) {
                String unpaidClass = element.getAttribute("class");
                assert unpaidClass.contains("unpaid");
                return;
            }
        }
    }

    public void verifyMainPageProductIconAndName(String product, String icon) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Dashboard.txtMainPageProductName)));
        List<WebElement> elementsProductName = driver.findElements(By.cssSelector(Dashboard.txtMainPageProductName));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Dashboard.iconMainPageProduct)));
        List<WebElement> elements = driver.findElements(By.cssSelector(Dashboard.iconMainPageProduct));

        int position = verifySideMenuProductNameFromList(product);

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

    public void verifyProductAndInstallmentsOnProchainsPrelevement(String product, String number_of_installments) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Dashboard.txtMesProchainsPrelevements)));
        List<WebElement> elementsProductName = driver.findElements(By.cssSelector(Dashboard.txtMesProchainsPrelevements));
        List<WebElement> elementsMensuality = driver.findElements(By.cssSelector(Dashboard.txtNumberOfInstallments));

        int position = verifySideMenuProductNameFromList(product);

        String extractedProductName = elementsProductName.get(position).getText();
        String extractedNumberOfInstallments = elementsMensuality.get(position).getText();

        assert extractedProductName.contains(product);
        assert extractedNumberOfInstallments.contains(number_of_installments);
    }


    public void verifyWelcomeScreen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Dashboard.txtWelcome)));
        String txtWelcomeName = driver.findElement(By.cssSelector(Dashboard.txtWelcome)).getText();
        assert txtWelcomeName.contains("Bienvenue");

    }

    public void verifyLabelForUnpaidSchedule()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Dashboard.lblUnpaidSchedule)));
        String txtWelcomeName = driver.findElement(By.xpath(Dashboard.lblUnpaidSchedule)).getText();
        assert txtWelcomeName.contains("Un de vos produits se trouve en situation d’impayé.");
    }
}
