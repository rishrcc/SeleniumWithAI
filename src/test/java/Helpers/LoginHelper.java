package Helpers;

import Pages.WeakAuthLogin;
import Pages.Dashboard;
import TestData.LoginData;
import Utility.BrowserDriver;
import com.epam.healenium.SelfHealingDriver;
import com.epam.healenium.SelfHealingDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginHelper extends BrowserDriver {

    public WebDriverWait wait;

    public LoginHelper(SelfHealingDriver driver) {
        super(driver);
        wait = new SelfHealingDriverWait(driver, Duration.ofSeconds(20));
    }

    public void weakAuthenticationNavigateToUrl() {
        driver.get(LoginData.weakAuthUrl);
        driver.manage().window().maximize();
    }

    public void weakAuthenticationLogin(String username, String password) {
        driver.findElement(By.cssSelector(WeakAuthLogin.txtWeakAuthUsername)).sendKeys(username);
        driver.findElement(By.cssSelector(WeakAuthLogin.txtWeakAuthPassword)).sendKeys(password);
        driver.findElement(By.xpath(WeakAuthLogin.btnWeakLogin)).click();
    }

    public void weakAuthenticationLogin(String icon) {
        switch (icon) {
            case "3x":
                driver.findElement(By.cssSelector(WeakAuthLogin.txtWeakAuthUsername)).sendKeys(LoginData.Customer_3x.USER_IAD.getValue());
                driver.findElement(By.cssSelector(WeakAuthLogin.txtWeakAuthPassword)).sendKeys(LoginData.Customer_3x.USER_PASSWORD.getValue());
                break;

            case "4x":
                driver.findElement(By.cssSelector(WeakAuthLogin.txtWeakAuthUsername)).sendKeys(LoginData.Customer_4x.USER_IAD.getValue());
                driver.findElement(By.cssSelector(WeakAuthLogin.txtWeakAuthPassword)).sendKeys(LoginData.Customer_4x.USER_PASSWORD.getValue());
                break;

            case "RCP":
                driver.findElement(By.cssSelector(WeakAuthLogin.txtWeakAuthUsername)).sendKeys(LoginData.Customer_RCP.USER_IAD.getValue());
                driver.findElement(By.cssSelector(WeakAuthLogin.txtWeakAuthPassword)).sendKeys(LoginData.Customer_RCP.USER_PASSWORD.getValue());
                break;

            default:
                driver.findElement(By.cssSelector(WeakAuthLogin.txtWeakAuthUsername)).sendKeys("306073628");
                driver.findElement(By.cssSelector(WeakAuthLogin.txtWeakAuthPassword)).sendKeys("12345");
        }
        driver.findElement(By.xpath(WeakAuthLogin.btnWeakLogin)).click();
    }

    public void weakAuthenticationUnpaidUserPrecontentieux() {
        driver.findElement(By.cssSelector(WeakAuthLogin.txtWeakAuthUsername)).sendKeys(LoginData.Customer_pre_contentieux.USER_IAD.getValue());
        driver.findElement(By.cssSelector(WeakAuthLogin.txtWeakAuthPassword)).sendKeys(LoginData.Customer_pre_contentieux.USER_PASSWORD.getValue());
        driver.findElement(By.xpath(WeakAuthLogin.btnWeakLogin)).click();
    }

    public void closePopUp() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(WeakAuthLogin.titlePopUpPrivate)));
        driver.findElement(By.xpath(WeakAuthLogin.btnAcceptTraceurs)).click();
    }
}
