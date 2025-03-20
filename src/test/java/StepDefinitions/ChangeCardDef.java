package StepDefinitions;

import Helpers.ChangeCardHelper;
import Helpers.DashboardHelper;
import Pages.ChangeCard;
import Utility.BrowserDriver;
import com.epam.healenium.SelfHealingDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class ChangeCardDef {

    public SelfHealingDriver driver;
    public ChangeCardHelper ChangeCardSteps;
    public DashboardHelper DashboardStep;

    public ChangeCardDef(){
        driver = BrowserDriver.getDriver();
        ChangeCardSteps = new ChangeCardHelper(driver);
        DashboardStep = new DashboardHelper(driver);
    }

    @Then("^I should be able to see (.*) and the (.*) on the change of card screen$")
    public void iShouldBeAbleToSeeProductAndTheIconOnTheChangeOfCardScreen(String subtitle, String icon) {

        ChangeCardSteps.verifyProductAndContractTypeOnChangeCard(subtitle, icon);
    }

    @And("^I should be able to cancel the change on the card$")
    public void iShouldBeAbleToCancelTheChangeOnTheCard() {

        ChangeCardSteps.clickOnReturn();
        ChangeCardSteps.clickYesOnAbandonPopUp();
        DashboardStep.verifyWelcomeScreen();
    }
}
