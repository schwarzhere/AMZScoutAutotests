package all.autotests.pages.proExtPages;

import all.autotests.pages.GoogleAuthorization;
import all.autotests.testsBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProExtension extends TestBase {
    private WebDriver driver;
    private WebDriverWait wait;

    public ProExtension(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public String randomAmazonPage = "https://www.amazon.com/s?k=Outdoor+Plastic+Straw+Rug&rh=n%3A21487702011%2Cn%3A68\" +\n" +
            "                \"4541011&dc&qid=1655207004&rnid=2941120011&ref=sr_nr_n_5";

    public void switchWindow() {
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }

    public void authByEmailSendEmail() {
        emailFieldAuthByEmail.sendKeys("vlad.b@amzscout.net");
    }

    public void authByEmailSendPassword() {
        passwordFieldAuthByEmail.sendKeys("djnx3rfrjq");
    }

    public void waitForHiddenLoader() {
        new WebDriverWait(driver, 30).until(ExpectedConditions.
                presenceOfElementLocated(By.cssSelector(".spinner.centered.ng-hide")));
    }

    public void switchToFrame() {
        driver.switchTo().frame(frameElementPricing);
    }

    public void authByEmail() {
        var pro = new ProExtension(driver, wait);
        var proExtWindow = driver.getWindowHandle();

        pro.signInByEmailButton.click();
        pro.switchWindow();

        pro.authByEmailSendEmail();
        pro.confirmEmailButtonAuthByEmail.click();
        pro.switchWindow();

        pro.authByEmailSendPassword();
        pro.authButtonByEmail.click();
        driver.switchTo().window(proExtWindow);
    }

    public void authByGoogle() {
        var pro = new ProExtension(driver, wait);
        var proExtWindow = driver.getWindowHandle();

        pro.signInByGoogleButton.click();
        pro.switchWindow();

        var googleAuth = new GoogleAuthorization(driver, wait);

        googleAuth.authByGoogleSendEmail();
        googleAuth.confirmEmailButtonAuthByGoogle.click();
        googleAuth.switchWindow();

        googleAuth.authByGoogleSendPassword();
        googleAuth.confirmEmailButtonAuthByGoogle.click();
        driver.switchTo().window(proExtWindow);
    }

    public void authByChrome() {
        var pro = new ProExtension(driver, wait);
        var proExtWindow = driver.getWindowHandle();

        pro.signInByChromeButton.click();
        pro.switchWindow();

        var googleAuth = new GoogleAuthorization(driver, wait);

        googleAuth.authByGoogleSendEmail();
        googleAuth.confirmEmailButtonAuthByGoogle.click();
        googleAuth.switchWindow();

        googleAuth.authByGoogleSendPassword();
        googleAuth.confirmEmailButtonAuthByGoogle.click();
        driver.switchTo().window(proExtWindow);
    }

    @FindBy(css = ".amzs-signin-email")
    public WebElement signInByEmailButton;

    @FindBy(css = ".amzs-signin-google")
    public WebElement signInByGoogleButton;

    @FindBy(css = ".amzs-signin-chrome")
    public WebElement signInByChromeButton;

    @FindBy(css = "#email")
    public WebElement emailFieldAuthByEmail;

    @FindBy(css = "#password")
    public WebElement passwordFieldAuthByEmail;

    @FindBy(css = "#button-signup")
    public WebElement confirmEmailButtonAuthByEmail;

    @FindBy(css = "#button-auth")
    public WebElement authButtonByEmail;

    @FindBy(css = ".spinner.centered")
    public WebElement loaderProductList;

    @FindBy(css = ".spinner.centered.ng-hide")
    public WebElement hiddenLoaderProductList;

    @FindBy(xpath = "//os-circle")
    public WebElement launchBubble;

    @FindBy(xpath = "//div[@class='animated as-pro-container']")
    public WebElement activeProExtWindow;

    @FindBy(xpath = "//div[@class='l-header__buy']//a")
    public WebElement buyButtonTrialUser;

    @FindBy(css = "#js_newPricingBlock")
    public WebElement pricing;

    @FindBy(css = "main.paywall-iframe-modal__main iframe")
    public WebElement frameElementPricing;

    @FindBy(xpath = "(//a[@data-event-action='BuyNow'])[4]")
    public WebElement buyNowPricingButton;

    @FindBy(css = "#score-item")
    public WebElement nicheScore;

    @FindBy(css = ".agmodal__wrapper--visible .os-progress-circle__overlay")
    public WebElement nicheScoreCircleOverlay;

    @FindBy(xpath = "//div[@ng-if='options.nicheHistory']")
    public WebElement nicheHistory;

    @FindBy(css = ".agmodal__wrapper--visible .modal--history")
    public WebElement nicheHistoryDiagram;

    @FindBy(xpath = "//i[@class='i-keywords-cloud']/ancestor::a")
    public WebElement nicheKeywords;

    @FindBy(css = ".agmodal__wrapper--visible .modal--keywords-cloud")
    public WebElement nicheKeywordsCloud;

}
