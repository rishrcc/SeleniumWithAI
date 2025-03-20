package Helpers;

import Pages.MesProduits;
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

public class MesProduitsHelper extends BrowserDriver {

    public WebDriverWait wait;

    public MesProduitsHelper(SelfHealingDriver driver) {
        super(driver);
        wait = new SelfHealingDriverWait(driver, Duration.ofSeconds(30));
    }

    public void verifyProductPageTitle(String title) throws InterruptedException {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(MesProduits.titleProduit)));
        String extractedProductTitle = driver.findElement(By.cssSelector(MesProduits.titleProduit)).getText();
        Assert.assertEquals(title, extractedProductTitle);

    }

    public void verifyProductPageSubTitle(String subtitle) {
        String extractedProductSubTitle = driver.findElement(By.cssSelector(MesProduits.subTitleProduit)).getText();
        Assert.assertEquals(subtitle, extractedProductSubTitle);

    }

    public void verifyProductPageLogo(String icon) {
        String extractedProductPageIconPath = driver.findElement(By.cssSelector(MesProduits.iconContractType)).getAttribute("src");

        // Find the position of "_" and ".svg"
        int underscoreIndex = extractedProductPageIconPath.lastIndexOf("_");
        int svgIndex = extractedProductPageIconPath.lastIndexOf(".svg");
        String extractedProductPageIcon = extractedProductPageIconPath.substring(underscoreIndex + 1, svgIndex);

        Assert.assertEquals(icon, extractedProductPageIcon);
    }

    public void verifyProductPageNumberOfInstallment(String number_of_installments) {

        String extractedProductPageNumberOfInstallments = driver.findElement(By.xpath(MesProduits.txtNumberOfInstallments)).getText();
        assert extractedProductPageNumberOfInstallments.contains(number_of_installments);
    }

    public void clickOnChangeCard()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(MesProduits.lnkChangeCarteDePrelevement)));
        driver.findElement(By.cssSelector(MesProduits.lnkChangeCarteDePrelevement)).click();
    }

    public void verifyButtonVerifyCoordonneesAndVerifyInformationBancaire() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MesProduits.btnVerifyCoordonnees)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MesProduits.btnVerifyInformationBancaires)));
    }

    public void verifyTotalAmountUnpaidIsCorrect()
    {
        String extractedDisplayMessage = driver.findElement(By.xpath(MesProduits.txtDisplayMessage)).getText();
        String extractedTotalAmountUnpaid = driver.findElement(By.xpath(MesProduits.txtTotalUnpaid)).getText();
        String ExtractedTotalUnpaidAmountWithDot = extractedTotalAmountUnpaid.replace(",", ".");
        assert extractedDisplayMessage.contains(ExtractedTotalUnpaidAmountWithDot);
    }
    public void verifyProductHeader() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MesProduits.headerFirst)));
        WebElement sectionOne = driver.findElement(By.xpath(MesProduits.headerFirst));
        String headerOne = sectionOne.findElement(By.tagName("h3")).getText();
        assert headerOne.equals("Paiements au comptant en débit différé");

        WebElement sectionTwo = driver.findElement(By.xpath(MesProduits.headerSecond));
        String headerTwo = sectionTwo.findElement(By.tagName("h3")).getText();
        assert headerTwo.equals("Retraits d’argent au comptant");

        WebElement sectionThree = driver.findElement(By.xpath(MesProduits.headerThird));
        String headerThree = sectionThree.findElement(By.tagName("h3")).getText();
        assert headerThree.equals("Crédit renouvelable auquel la carte est associée");

        WebElement sectionFour = driver.findElement(By.xpath(MesProduits.headerForth));
        String headerFour = sectionFour.findElement(By.tagName("h3")).getText();
        assert headerFour.equals("Détail de votre disponible crédit renouvelable de 100,00 €");

        WebElement sectionFive = driver.findElement(By.xpath(MesProduits.headerFifth));
        String headerFive = sectionFive.findElement(By.tagName("h3")).getText();
        assert headerFive.equals("Cagnotte Cashback");
    }

    public void clickOnInformationIconAndVerifyHeader() throws InterruptedException {

        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MesProduits.headerFirst)));
        WebElement sectionOne = driver.findElement(By.xpath(MesProduits.headerFirst));
        sectionOne.findElement(By.tagName("img")).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MesProduits.informationHeaderFirst)));
        String header1Info = driver.findElement(By.xpath(MesProduits.informationHeaderFirst)).getText();
        assert header1Info.equals("Paiements au comptant en débit différé");
        driver.findElement(By.xpath(MesProduits.closeInformationFirst)).click();

        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MesProduits.headerSecond)));
        WebElement sectionTwo = driver.findElement(By.xpath(MesProduits.headerSecond));
        sectionTwo.findElement(By.tagName("img")).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MesProduits.informationHeaderSecond)));
        String header2Info = driver.findElement(By.xpath(MesProduits.informationHeaderSecond)).getText();
        assert header2Info.equals("Retraits d’argent au comptant");
        driver.findElement(By.xpath(MesProduits.closeInformationSecond)).click();

        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MesProduits.headerThird)));
        WebElement sectionThree = driver.findElement(By.xpath(MesProduits.headerThird));
        sectionThree.findElement(By.tagName("img")).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MesProduits.informationHeaderThird)));
        String header3Info = driver.findElement(By.xpath(MesProduits.informationHeaderThird)).getText();
        assert header3Info.equals("Crédit renouvelable auquel la carte est associée");
        driver.findElement(By.xpath(MesProduits.closeInformationThird)).click();

        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MesProduits.headerForth)));
        WebElement sectionFour = driver.findElement(By.xpath(MesProduits.headerForth));
        sectionFour.findElement(By.tagName("img")).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MesProduits.informationHeaderFourth)));
        String header4Info = driver.findElement(By.xpath(MesProduits.informationHeaderFourth)).getText();
        assert header4Info.equals("Crédit renouvelable auquel la carte est associée");
        driver.findElement(By.xpath(MesProduits.closeInformationFourth)).click();

        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MesProduits.headerFifth)));
        WebElement sectionFive = driver.findElement(By.xpath(MesProduits.headerFifth));
        sectionFive.findElement(By.tagName("img")).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MesProduits.informationHeaderFifth)));
        String header5Info = driver.findElement(By.xpath(MesProduits.informationHeaderFifth)).getText();
        assert header5Info.equals("Cagnotte Cashback");
        driver.findElement(By.xpath(MesProduits.closeInformationFifth)).click();
    }

    public void clickOnOptions() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MesProduits.lnkOptions)));
        driver.findElement(By.xpath(MesProduits.lnkOptions)).click();
    }
}
