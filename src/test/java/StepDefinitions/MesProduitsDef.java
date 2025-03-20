package StepDefinitions;

import Helpers.MesProduitsHelper;
import Utility.BrowserDriver;
import com.epam.healenium.SelfHealingDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class MesProduitsDef {

    public SelfHealingDriver driver;
    public MesProduitsHelper MesProduitsStep;

    public MesProduitsDef(){
        driver = BrowserDriver.getDriver();
        MesProduitsStep = new MesProduitsHelper(driver);
    }

    @Then("^I should see (.*) as title$")
    public void verifyProductPageTitle(String title) throws InterruptedException {
        MesProduitsStep.verifyProductPageTitle(title);
    }

    @And("^I should see (.*) as subtitle$")
    public void verifyProductPageSubTitle(String subtitle)
    {
        MesProduitsStep.verifyProductPageSubTitle(subtitle);
    }

    @And("^I should see (.*) as logo$")
    public void verifyProductPageLogo(String icon)
    {
        MesProduitsStep.verifyProductPageLogo(icon);
    }

    @And("^I should see (.*) as number of installments in the payment information$")
    public void i_should_see_number_of_installments_in_payment_info(String number_of_installments)
    {
        MesProduitsStep.verifyProductPageNumberOfInstallment(number_of_installments);
    }

    @Then("^I click on change card$")
    public void i_click_on_change_card_link()
    {
        MesProduitsStep.clickOnChangeCard();
    }

    @And("^I should see actions verifier mes coordonnees and verifier mes informations bancaires$")
    public void iShouldSeeActionsVerifierMesCoordonneesAndVerifierMesInformationsBancaires() {
        MesProduitsStep.verifyButtonVerifyCoordonneesAndVerifyInformationBancaire();
    }

    @And("^I should see that amount paid in the message displayed matches the total amount unpaid$")
    public void iShouldSeeThatAmountPaidInTheMessageDisplayedMatchesTheTotalAmountUnpaid() {
        MesProduitsStep.verifyTotalAmountUnpaidIsCorrect();
    }

    @Then("^I should be able to see the correct headers displayed on the screen$")
    public void iShouldBeAbleToSeeTheSectionHeaderDisplayedOnTheScreen() {
        MesProduitsStep.verifyProductHeader();
    }

    @And("^I should be able to see the correct infoheader after clicking on the information icon$")
    public void iShouldBeAbleToSeeTheCorrectHeaderAfterClickingOnTheInformationIcon() throws InterruptedException {
        MesProduitsStep.clickOnInformationIconAndVerifyHeader();
    }

    @And("^I click on options menu$")
    public void iClickOnOptionsMenu() throws InterruptedException {
        MesProduitsStep.clickOnOptions();
    }
}
