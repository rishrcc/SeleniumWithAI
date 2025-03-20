package Utility;


import io.cucumber.core.logging.LoggerFactory;
import io.cucumber.java.Scenario;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class SendResultToTeams {

    public static SendResultToTeams instance;
    public List<String> results;

    public static final String RESET = "</span>";
    public static final String RED = "<span style='color:red'>";
    public static final String GREEN = "<span style='color:green'>";
    public static final String BLUE = "<span style='color:blue'>";

    public SendResultToTeams()
    {
        results = new ArrayList<>();

        EnvProperties envProperties = new EnvProperties();
        String buildId = envProperties.getProperty("buildId");
        String buildUrl = String.format("https://dev.azure.com/OneyPay/OneyPay-API/_build/results?buildId=%s&view=ms.vss-test-web.build-test-results-tab", buildId);
        String headerMessage = String.format("<b>Result for <a href='%s'>%s</a></b>%n", buildUrl, buildId);
        this.addResult(headerMessage);
    }

    public static synchronized SendResultToTeams getInstance() {
        if (instance == null) {
            instance = new SendResultToTeams();
        }
        return instance;
    }

    public void addResult(String result) {
        results.add(result);
    }

    public List<String> getResults() {
        return results;
    }

    public static void addResultTolist(Scenario scenario) {

        String status = scenario.isFailed() ? "FAILED" : "PASSED";
        String coloredStatus;

        switch (status) {
            case "FAILED":
                coloredStatus = RED + "FAILED" + RESET;
                break;
            case "PASSED":
                coloredStatus = GREEN + "PASSED" + RESET;
                break;
            default:
                coloredStatus = BLUE + "WARNING" + RESET;
                break;
        }

        String message = String.format("%s - %s%n", scenario.getName(),coloredStatus);
        SendResultToTeams.getInstance().addResult(message);
    }

    public static void connect() throws URISyntaxException, IOException {

        //https://hooks.slack.com/services/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
        //https://oney.webhook.office.com/webhookb2/0c33b65f-0294-4c71-945b-d00a93066903@1cbcfc5b-bfc4-46cf-9dd1-b61140309b99/IncomingWebhook/ef011baa0dd24c0a9e1e3c86638af214/fa66b1a7-a129-4096-98d7-145366081afc
        //https://prod-199.westeurope.logic.azure.com:443/workflows/7db655e7caac403285791de4dd0491ec/triggers/manual/paths/invoke?api-version=2016-06-01&sp=%2Ftriggers%2Fmanual%2Frun&sv=1.0&sig=XA1-T0aGDJPSRzLAyMAvbrhg5gQbNvSetDsh1vnVXFE

        String apiUrl = "https://oney.webhook.office.com/webhookb2/0c33b65f-0294-4c71-945b-d00a93066903@1cbcfc5b-bfc4-46cf-9dd1-b61140309b99/IncomingWebhook/ef011baa0dd24c0a9e1e3c86638af214/fa66b1a7-a129-4096-98d7-145366081afc/V24f53Zo93R3UjV67u2ntytUzYQY-EDqN45v6L1_N7yus1";
        List<String> results = SendResultToTeams.getInstance().getResults();
        String message = String.join("\n", results);

        URI url = new URI(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.toURL().openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        String jsonPayload = "{\"text\": \"" + message + "\"}";

        try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
            outputStream.writeBytes(jsonPayload);
            outputStream.flush();
        }
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);
    }
}
