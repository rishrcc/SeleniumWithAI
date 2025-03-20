# Oney France - Test Auto

- Setup
- Framework
- Execution
- Test Data
- Test Reports in Microsoft Teams

# Setup

### Step 1: Download the IDE

1. Visit the Intellij IDEA downloage page : https://www.jetbrains.com/idea/download/?section=windows
2. Download the community edition.
3. Run the downloaded installer (`.exe` file).
4. Follow the installation wizard instructions.
5. Complete the installation process.

## Congratulations! You have successfully installed the Intellij IDE on your Windows machine.

---
# To install the Allure TestOps support, Cucumber for Java, and Gherkin plugins in IntelliJ IDEA, follow these steps:

### Step 1: Open IntelliJ IDEA

Launch IntelliJ IDEA on your computer.

### Step 2: Access Plugin Marketplace

1. Click on "File" in the top menu bar.
2. Navigate to "Settings".
3. In the Settings window, select "Plugins" from the left-hand menu.

### Step 3: Install Allure TestOps Support Plugin

1. In the Plugins window, click on the "Marketplace" tab.
2. Search for "Allure TestOps Support" in the search bar.
3. Click on the plugin in the search results.
4. Click the "Install" button next to the plugin.
5. Follow the prompts to install the plugin.
6. Restart IntelliJ IDEA to apply the changes.

### Step 4: Install Cucumber for Java Plugin

1. In the Plugins window, click on the "Marketplace" tab.
2. Search for "Cucumber for Java" in the search bar.
3. Click on the plugin in the search results.
4. Click the "Install" button next to the plugin.
5. Follow the prompts to install the plugin.
6. Restart IntelliJ IDEA to apply the changes.

### Step 5: Install Gherkin Plugin

1. In the Plugins window, click on the "Marketplace" tab.
2. Search for "Gherkin" in the search bar.
3. Click on the plugin in the search results.
4. Click the "Install" button next to the plugin.
5. Follow the prompts to install the plugin.
6. Restart IntelliJ IDEA to apply the changes.

## Congratulations! You have successfully installed the Allure TestOps Support, Cucumber for Java, and Gherkin plugins in IntelliJ IDEA. You can now use these plugins to enhance your Cucumber and Gherkin development experience.
---

# Here's a manual on how to install the JDK (Java Development Kit) on a Windows machine and add it to the system's environment variables:

### Step 1: Download the JDK

1. Visit the Oracle JDK download page: [Oracle JDK Download](https://www.oracle.com/java/technologies/downloads/#jdk22-windows). => x64 Installer
2. Accept the license agreement.
3. Download the JDK installer for Windows.

### Step 2: Install the JDK

1. Run the downloaded JDK installer (`.exe` file).
2. Follow the installation wizard instructions.
3. Choose a directory for installation (e.g., `C:\Program Files\Java\jdk-21`).
4. Complete the installation process.

### Step 3: Set JAVA_HOME Environment Variable

1. Right-click on "This PC" or "My Computer" and select "Properties".
2. Click on "Advanced system settings" on the left-hand side.
3. In the System Properties window, click on the "Environment Variables..." button.
4. Under the "System variables" section, click "New" to add a new environment variable.
5. Set the Variable Name to `JAVA_HOME`.
6. Set the Variable Value to the JDK installation directory path (e.g., `C:\Program Files\Java\jdk-21`).
7. Click "OK" to save the environment variable.

### Step 4: Update Path Environment Variable

1. In the Environment Variables window, under the "System variables" section, find the `Path` variable and select it.
2. Click "Edit..." to edit the Path variable.
3. Click "New" to add a new entry.
4. Add `%JAVA_HOME%\bin` to the list of paths. This allows Windows to find the `java`, `javac`, and other JDK executables.
5. Click "OK" to save the changes.
6. Restart your machine.

### Step 5: Verify JDK Installation

1. Open Command Prompt (cmd.exe).
2. Type `java -version` and press Enter.
3. Verify that the installed JDK version is displayed.

## Congratulations! You have successfully installed the JDK on your Windows machine and added it to the system's environment variables. You can now develop and run Java applications on your computer.

---

# Here's a manual on how to install Apache Maven on a Windows machine and add it to the system's environment variables:

### Step 1: Download Apache Maven

1. Visit the Apache Maven download page: [Apache Maven Download](https://maven.apache.org/download.cgi). => apache-maven-3.9.6-bin.zip
2. Under "Files," download the latest version of Apache Maven

### Step 2: Extract Maven Archive

1. Once the download is complete, locate the downloaded ZIP file
2. Right-click on the ZIP file and select "Extract All...".
3. Choose a destination folder for the extracted Maven files (e.g., `C:\Program Files\Apache\`).
4. Click "Extract" to extract the contents of the ZIP file.

### Step 3: Set Up Maven Environment Variables

1. Right-click on "This PC" or "My Computer" and select "Properties".
2. Click on "Advanced system settings" on the left-hand side.
3. In the System Properties window, click on the "Environment Variables..." button.
4. Under the "System variables" section, click "New" to add a new environment variable.
5. Set the Variable Name to `MAVEN_HOME`.
6. Set the Variable Value to the Maven installation directory path (e.g., `C:\Program Files\Apache\apache-maven-3.8.4`).
7. Click "OK" to save the environment variable.

### Step 4: Update Path Environment Variable

1. In the Environment Variables window, under the "System variables" section, find the `Path` variable and select it.
2. Click "Edit..." to edit the Path variable.
3. Click "New" to add a new entry.
4. Add `%MAVEN_HOME%\bin` to the list of paths. This allows Windows to find the Maven executables.
5. Click "OK" to save the changes.
6. Restart your machine.

### Step 5: Verify Maven Installation

1. Open Command Prompt (cmd.exe).
2. Type `mvn -v` and press Enter.
3. Verify that Maven is installed and the version is displayed.

## Congratulations! You have successfully installed Apache Maven on your Windows machine and added it to the system's environment variables. You can now use Maven to manage your Java projects and dependencies.

# Framework

# Execution

# Test Data

# Test Reports in Microsoft Teams

### Step 1: Create an Incoming Webhook

1. https://learn.microsoft.com/en-us/microsoftteams/platform/webhooks-and-connectors/how-to/add-incoming-webhook?tabs=newteams%2Cdotnet#create-an-incoming-webhook
2. Connector url for channel "Automated Test Summary" : https://oney.webhook.office.com/webhookb2/0c33b65f-0294-4c71-945b-d00a93066903@1cbcfc5b-bfc4-46cf-9dd1-b61140309b99/IncomingWebhook/ef011baa0dd24c0a9e1e3c86638af214/fa66b1a7-a129-4096-98d7-145366081afc

### Step 2: Saving results after each sceanarios

    @After
    public void tearDown(Scenario scenario) throws Exception {
        SendResultToTeams.addResultTolist(scenario);
    }

### Step 3: Sending the results after all executions are completed

    @AfterAll
    public static void afterAllScenarios() throws URISyntaxException, IOException {
        SendResultToTeams.connect();
    }

---
# AI
## Healenium infrastructure contains several components:
1. healenium-web — Java library that integrates with Test Automation Framework
Implements Selenium WebDriver
Overwrites findElement() method
Catch NoSuchElementException
Activates LCS algorithm in Tree-comparing library

2. healenium-backend — docker container that manage healings and includes PostgreSql database that stores element info
Save reference element path to storage
Get reference element path from storage
Collect data for report generation

#### RESOURCE GROUP: https://portal.azure.com/#@oney.onmicrosoft.com/resource/subscriptions/fd474ff2-89e0-432b-9906-e652220f5073/resourceGroups/RG_QA_ODB_SERVICES/overview
#### HEALING REPORT: https://qa-helium-service-a2atdjfre7ftfre3.westeurope-01.azurewebsites.net/healenium/healenium/report/

---

# Continuous Integration
#### PIPELINE:https://dev.azure.com/OneyPay/OneyPay-API/_build?definitionId=158