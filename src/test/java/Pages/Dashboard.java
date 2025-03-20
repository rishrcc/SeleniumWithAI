package Pages;

public class Dashboard {

    public static String lnkCoordonnees = "//span[normalize-space()='Coordonnées']"; //Xpath
    public static String lnkEcheanciers = "//span[normalize-space()='Échéanciers']"; //Xpath
    public static String lnkProchainsPrelevements = "//span[normalize-space()='Prochains prélèvements']"; //Xpath
    public static String txtFirstName = "div[class='name-area'] p strong"; //CSS
    public static String titlePopMobileAppDownload = "//div[contains(text(),'Téléchargez l’application Oney')]"; //Xpath
    public static String btnCloseMobileAppDownloadPopUp = "//div[@class='modal encouragement-modal']//p[@class='close']"; //Xpath
    public static String txtSideMenuProductName = "div[id='content-wrapper-body'] div:nth-child(2) div:nth-child(2) ul:nth-child(1) li:nth-child(1) a:nth-child(1) span:nth-child(1)"; //CSS
    public static String txtMainPageProductName = ".text-bold.ng-star-inserted"; //css
    public static String iconMainPageProduct = ".product-heading-icon"; //css
    public static String txtMesProchainsPrelevements = "div[class='popup-container tblt'] span[class='product']"; //CSS
    public static String txtNumberOfInstallments = "div[class='popup-container tblt'] span[class='installment-of ng-star-inserted']"; //CSS
    public static String txtWelcome ="body app-root app-welcome-container p:nth-child(1)"; //CSS
    public static String listProductsSideMenu = "//*[@id=\"content-wrapper-body\"]/app-private-area/div[1]/app-private-area-entrypoint/div/app-menu/div/div[2]/div[2]/ul/li/a"; //xpath
    public static String lblUnpaidSchedule = "/html/body/app-root/app-oney-site-pages/app-header/div/div[1]/div/div[1]/label"; //xpath
    public static String lblClassUnpaid = "//*[@id=\"content-wrapper-body\"]/app-private-area/div[1]/app-private-area-entrypoint/div/app-menu/div/div[2]/div[2]/ul/li/a/i"; //xpath
}
