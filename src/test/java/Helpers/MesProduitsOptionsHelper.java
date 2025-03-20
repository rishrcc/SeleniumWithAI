package Helpers;

import Pages.MesProduits;
import Pages.MesProduitsOptions;
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

public class MesProduitsOptionsHelper extends BrowserDriver {

    public WebDriverWait wait;

    public MesProduitsOptionsHelper(SelfHealingDriver driver) {
        super(driver);
        wait = new SelfHealingDriverWait(driver, Duration.ofSeconds(30));
    }

    public void verifyProductOptionsAvailable() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MesProduitsOptions.btnConfirmationMobile)));
        String headerOne = driver.findElement(By.xpath(MesProduitsOptions.btnConfirmationMobile)).getText();
        assert headerOne.equals("Confirmation mobile");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MesProduitsOptions.btnFaireOpposition)));
        String headerTwo = driver.findElement(By.xpath(MesProduitsOptions.btnFaireOpposition)).getText();
        assert headerTwo.equals("Faire opposition");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MesProduitsOptions.btnPaiementADistance)));
        String headerThree = driver.findElement(By.xpath(MesProduitsOptions.btnPaiementADistance)).getText();
        assert headerThree.equals("Paiement à distance");

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MesProduitsOptions.btnPaiementSansContact)));
//        String headerFour = driver.findElement(By.xpath(MesProduitsOptions.btnPaiementSansContact)).getText();
//        assert headerFour.equals("Paiement sans contact");
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MesProduitsOptions.btnVerouille)));
//        String headerFive = driver.findElement(By.xpath(MesProduitsOptions.btnVerouille)).getText();
//        assert headerFive.equals("Verrouiller ma carte bancaire");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MesProduitsOptions.btnAfficherMonCodeConfiDentiel)));
        String headerSix = driver.findElement(By.xpath(MesProduitsOptions.btnAfficherMonCodeConfiDentiel)).getText();
        assert headerSix.equals("Afficher mon code confidentiel");
    }

    public void clickOnRetourButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MesProduitsOptions.btnRetour)));
        driver.findElement(By.xpath(MesProduitsOptions.btnRetour)).click();
    }

    public void clickOnConfirmationMobile() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MesProduitsOptions.btnConfirmationMobile)));
        driver.findElement(By.xpath(MesProduitsOptions.btnConfirmationMobile)).click();
    }

    public void clickOnFaireOpposition() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MesProduitsOptions.btnFaireOpposition)));
        driver.findElement(By.xpath(MesProduitsOptions.btnFaireOpposition)).click();
    }

    public void clickOnPaiementADistance() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MesProduitsOptions.btnPaiementADistance)));
        driver.findElement(By.xpath(MesProduitsOptions.btnPaiementADistance)).click();
    }

    public void clickOnPaiementSansContact() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MesProduitsOptions.btnPaiementSansContact)));
        driver.findElement(By.xpath(MesProduitsOptions.btnPaiementSansContact)).click();
    }

    public void clickOnVerouillerMaCarteBancaire() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MesProduitsOptions.btnVerouille)));
        driver.findElement(By.xpath(MesProduitsOptions.btnVerouille)).click();
    }

    public void verifyCardNumberAndCardOwnerNameOnFaireOppositionFirstStep(String name, String card_number) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MesProduitsOptions.txtCardNumberFaireOpposition)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MesProduitsOptions.txtCardOwnerNameFaireOppositions)));

        String actualCardNumber = driver.findElement(By.xpath(MesProduitsOptions.txtCardNumberFaireOpposition)).getText();
        String actualCardOwnerName = driver.findElement(By.xpath(MesProduitsOptions.txtCardOwnerNameFaireOppositions)).getText();

        assert actualCardNumber.equals(card_number) : "Card number is different than expected one";
        assert actualCardOwnerName.equals(name) : "Card holder name is different from expected name";
    }
    public void verifyCardNumberAndCardOwnerNameOnPaiementADistance(String name, String card_number) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MesProduitsOptions.txtCardNumberPaiementADistance)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MesProduitsOptions.txtCardOwnerNamePaiementADistance)));

        String actualCardNumber = driver.findElement(By.xpath(MesProduitsOptions.txtCardNumberPaiementADistance)).getText();
        String actualCardOwnerName = driver.findElement(By.xpath(MesProduitsOptions.txtCardOwnerNamePaiementADistance)).getText();

        assert actualCardNumber.equals(card_number) : "Card number is different than expected one";
        assert actualCardOwnerName.equals(name) : "Card holder name is different from expected name";
    }

    public void verifyCardNumberAndCardOwnerNameOnPaiementSansContact(String name, String card_number) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MesProduitsOptions.txtCardNumberPaiementSansContact)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MesProduitsOptions.txtCardOwnerNamePaiementSansContact)));

        String actualCardNumber = driver.findElement(By.xpath(MesProduitsOptions.txtCardNumberPaiementSansContact)).getText();
        String actualCardOwnerName = driver.findElement(By.xpath(MesProduitsOptions.txtCardOwnerNamePaiementSansContact)).getText();

        assert actualCardNumber.equals(card_number) : "Card number is different than expected one";
        assert actualCardOwnerName.equals(name) : "Card holder name is different from expected name";
    }

    public void verifyCardNumberAndCardOwnerNameOnVerouillerMaCarteBancaire(String name, String card_number) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MesProduitsOptions.txtCardNumberVerouiller)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MesProduitsOptions.txtCardOwnerNameVerouiller)));

        String actualCardNumber = driver.findElement(By.xpath(MesProduitsOptions.txtCardNumberVerouiller)).getText();
        String actualCardOwnerName = driver.findElement(By.xpath(MesProduitsOptions.txtCardOwnerNameVerouiller)).getText();

        assert actualCardNumber.equals(card_number) : "Card number is different than expected one";
        assert actualCardOwnerName.equals(name) : "Card holder name is different from expected name";
    }


}
