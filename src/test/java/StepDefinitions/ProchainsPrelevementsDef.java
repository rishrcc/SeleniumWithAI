package StepDefinitions;

import Helpers.EcheancierHelper;
import Helpers.ProchainsPrelevementsHelper;
import Utility.BrowserDriver;
import com.epam.healenium.SelfHealingDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ProchainsPrelevementsDef {

    public SelfHealingDriver driver;
    public ProchainsPrelevementsHelper ProchainsPrelevementsSteps;

    public ProchainsPrelevementsDef() {
        driver = BrowserDriver.getDriver();
        ProchainsPrelevementsSteps = new ProchainsPrelevementsHelper(driver);
    }

    @Then("^I should be able to see (.*) and the (.*) on the prochain prelevements screen$")
    public void iShouldSeeProductNameAndIconOnProchainPrelevements(String product, String icon) {
        ProchainsPrelevementsSteps.verifyProductNameAndIconOnProchainsPrelevementsPage(product, icon);
    }
}
