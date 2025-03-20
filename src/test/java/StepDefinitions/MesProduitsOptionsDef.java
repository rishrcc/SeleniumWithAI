package StepDefinitions;

import Helpers.DashboardHelper;
import Helpers.MesProduitsHelper;
import Helpers.MesProduitsOptionsHelper;
import Utility.BrowserDriver;
import com.epam.healenium.SelfHealingDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class MesProduitsOptionsDef {

    public SelfHealingDriver driver;
    public MesProduitsOptionsHelper MesProduitsOptionsStep;
    public DashboardHelper DashboardStep;

    public MesProduitsOptionsDef(){
        driver = BrowserDriver.getDriver();
        MesProduitsOptionsStep = new MesProduitsOptionsHelper(driver);
        DashboardStep = new DashboardHelper(driver);
    }


    @Then("^I should be able to see the correct options headers displayed on the screen$")
    public void iShouldBeAbleToSeeTheCorrectOptionsHeadersDisplayedOnTheScreen() {
        MesProduitsOptionsStep.verifyProductOptionsAvailable();
    }

    @When("^I click on retour button$")
    public void iClickOnRetourButton() {
        MesProduitsOptionsStep.clickOnRetourButton();
    }

    @When("^I click on Confirmation mobile$")
    public void iClickOnConfirmationMobile() {
        MesProduitsOptionsStep.clickOnConfirmationMobile();
    }

    @Then("^I should see a popup to download the mobile app$")
    public void iShouldSeeAPopupToDownloadTheMobileApp() {
        DashboardStep.closeMobileDownloadPopUp();
    }

    @When("^I click on Faire opposition$")
    public void iClickOnFaireOpposition() {
        MesProduitsOptionsStep.clickOnFaireOpposition();
    }

    @Then("^I should see on faire opposition screen the name of cart owner (.*) and correct card number (.*)$")
    public void iShouldSeeNameOfCartOwnerNameAndCorrectCardNumberCard_number(String name, String card_number) {
        MesProduitsOptionsStep.verifyCardNumberAndCardOwnerNameOnFaireOppositionFirstStep(name, card_number);
    }

    @When("I click on paiement a distance")
    public void iClickOnPaiementADistance() {
        MesProduitsOptionsStep.clickOnPaiementADistance();
    }

    @When("I click on paiement sans contact")
    public void iClickOnPaiementSansContact() {
        MesProduitsOptionsStep.clickOnPaiementSansContact();
    }

    @Then("^I should see on paiement a distance page the name of cart owner (.*) and correct card number (.*)$")
    public void iShouldSeeOnPaiementADistancePageTheNameOfCartOwnerNameAndCorrectCardNumberCard_number(String name, String card_number) {
        MesProduitsOptionsStep.verifyCardNumberAndCardOwnerNameOnPaiementADistance(name,card_number);
    }

    @Then("^I should see on paiement sans contact page the name of cart owner (.*) and correct card number (.*)$")
    public void iShouldSeeOnPaiementSansContactPageTheNameOfCartOwnerNameAndCorrectCardNumberCard_number(String name, String card_number) {
        MesProduitsOptionsStep.verifyCardNumberAndCardOwnerNameOnPaiementSansContact(name,card_number);
    }

    @When("^I click on verouiller ma carte bancaire$")
    public void iClickOnVerouillerMaCarteBancaire() {
        MesProduitsOptionsStep.clickOnVerouillerMaCarteBancaire();
    }

    @Then("^I should see on verouiller ma carte bancaire page the name of cart owner (.*) and correct card number (.*)$")
    public void iShouldSeeOnVerouillerMaCarteBancairePageTheNameOfCartOwnerNameAndCorrectCardNumberCard_number(String name, String card_number) {
        MesProduitsOptionsStep.verifyCardNumberAndCardOwnerNameOnVerouillerMaCarteBancaire(name, card_number);
    }
}
