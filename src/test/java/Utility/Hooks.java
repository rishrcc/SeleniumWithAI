package Utility;
import com.epam.healenium.SelfHealingDriver;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.net.URISyntaxException;


public class Hooks {
    public static String scenarioName;
    public SelfHealingDriver driver;

    @Before
    public void setup()
    {
        driver = BrowserDriver.getDriver();
    }

/*    @Before
    public void startRecording(Scenario scenario) throws Exception
    {
        scenarioName = scenario.getName();
        TestRecorder.startRecording("src/test/java/Recording/" + scenarioName);
    }*/

    @AfterStep
    public void takeScreenshotAfterEachStep(Scenario scenario)
    {
        BrowserDriver.takeScreenshotAfterStep(scenario);
    }

    @After
    public void tearDown(Scenario scenario) throws Exception {
        System.out.println("Tearing down the scenario...");
        SendResultToTeams.addResultTolist(scenario);
        //TestRecorder.stopRecording();
        BrowserDriver.quitDriver(scenario);
    }

    @AfterAll
    public static void afterAllScenarios() throws URISyntaxException, IOException {
        SendResultToTeams.connect();
    }
}

