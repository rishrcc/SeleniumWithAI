package StepDefinitions;

import Helpers.EcheancierHelper;
import Utility.BrowserDriver;
import com.epam.healenium.SelfHealingDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class EcheancierDef {

    public SelfHealingDriver driver;
    public EcheancierHelper EcheancierStep;

    public EcheancierDef() {
        driver = BrowserDriver.getDriver();
        EcheancierStep = new EcheancierHelper(driver);
    }

    @Then("^I should be able to see (.*) and the (.*) on the echeancier main screen$")
    public void iShouldBeAbleToSeeProductAndIconOnEcheancierMainScreen(String product, String icon) {
        EcheancierStep.verifyEcheancierPageProductIconAndName(product, icon);
    }

    @And("^I should see echeancier initial and echeancier actualise for (.*)$")
    public void iShouldSeeEcheancierInitialAndEcheancierActualise(String product) {
        EcheancierStep.verifyEcheancierInitialAndActualise(product);
    }

    @And("^I click on echeancier initial for the product (.*)$")
    public void iClickOnEcheancierInitial(String product) {
        EcheancierStep.clickOnEcheancierInitial(product);
    }

    @Then("^I should be able to see (.*) and the (.*) on the echeancier initial screen$")
    public void iShouldSeeProductAndNumberOfInstallmentsOnEcheancierInitialScreen(String product, String number_of_installments) {
        EcheancierStep.verifyProductNameAndNumberOfInstallmentsUnderEcheancierInitial(product, number_of_installments);
    }

    @And("^I click on echeancier actualise for the product (.*)$")
    public void iClickOnEcheancierActualise(String product) {
        EcheancierStep.clickOnEcheancierActualise(product);
    }

    @Then("^I should be able to see (.*) on the echeancier actualise screen$")
    public void iShouldSeeProductAndNumberOfInstallmentsOnEcheancierActualiseScreen(String product) {
        EcheancierStep.verifyProductNameAndNumberOfInstallmentsUnderEcheancierActualise(product);
    }
}
