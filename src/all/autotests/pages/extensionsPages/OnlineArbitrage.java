package all.autotests.pages.extensionsPages;

import all.autotests.pages.GoogleAuthorization;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnlineArbitrage {
    private WebDriver driver;
    private WebDriverWait wait;

    public OnlineArbitrage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void switchWindow() {
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }

    public void switchToBannerFrame() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//iframe[@class='c0111']")));
        driver.switchTo().frame(iFrameBigBanner);
    }

    @FindBy(xpath = "//iframe[@class='c0111']")
    public WebElement iFrameBigBanner;

    @FindBy(css = "div.c0129.c0127")
    public WebElement signInByGoogleButton;

    @FindBy(css = "div.c0132.c0127")
    public WebElement signInByEmailButton;

    @FindBy(css = "#email")
    public WebElement emailFieldAuthByEmail;

    @FindBy(css = "#button-signup")
    public WebElement confirmEmailButtonAuthByEmail;

    @FindBy(css = "#password")
    public WebElement passwordFieldAuthByEmail;

    @FindBy(css = "#button-auth")
    public WebElement authButtonByEmail;

    @FindBy(xpath = "(//img[@title='Close'])[2]")
    public WebElement closeBanner;

    @FindBy(id = "quickView")
    public WebElement oaWindow;

    @FindBy(xpath = "//div[@class='c01308']")
    public WebElement rankAndPriceHistory;

    @FindBy(id = "buybox-history")
    public WebElement buyBoxHistory;

    @FindBy(id = "tour")
    public WebElement onboardingNewUser;

    @FindBy(xpath = "//button[@class='c01467']")
    public WebElement skipOnboardingButton;

    @FindBy(xpath = "//input[@name='fbmPrice']")
    public WebElement fbmBuyBoxPriceInput;

    @FindBy(xpath = "//input[@name='fbmFees']")
    public WebElement fbmFeesInput;

    @FindBy(xpath = "//input[@name='fbmNetProfit']")
    public WebElement fbmNetProfitInput;

    @FindBy(xpath = "(//div[text()='Minimum Net']/parent::div/input)[1]")
    public WebElement fbmMinimumNetInput;

    @FindBy(xpath = "//input[@name='fbaPrice']")
    public WebElement fbaBuyBoxPriceInput;

    @FindBy(xpath = "//input[@name='fbaFees']")
    public WebElement fbaFeesInput;

    @FindBy(xpath = "//input[@name='fbaNetProfit']")
    public WebElement fbaNetProfitInput;

    @FindBy(xpath = "(//div[text()='Profit Margin']/parent::div/input)[2]")
    public WebElement fbaProfitMarginInput;

    @FindBy(xpath = "(//div[text()='Minimum Net']/parent::div/input)[2]")
    public WebElement fbaMinimumNetInput;

    public void authByEmailSendEmail() {
        emailFieldAuthByEmail.sendKeys("vlad.b@amzscout.net");
    }

    public void authByEmailSendPassword() {
        passwordFieldAuthByEmail.sendKeys("djnx3rfrjq");
    }

    public void closeBigBanner() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("(//img[@title='Close'])[2]")));
        closeBanner.click();
    }

    public String getFbmBuyBoxPrice() {
        return fbmBuyBoxPriceInput.getAttribute("value");
    }

    public String getFbmFees() {
        return fbmFeesInput.getAttribute("value");
    }

    public String getFbmNetProfit() {
        return fbmNetProfitInput.getAttribute("value");
    }

    public String getFbmMinimumNet() {
        return fbmMinimumNetInput.getAttribute("value");
    }

    public String getFbaBuyBoxPrice() {
        return fbaBuyBoxPriceInput.getAttribute("value");
    }

    public String getFbaFees() {
        return fbaFeesInput.getAttribute("value");
    }

    public String getFbaNetProfit() {
        return fbaNetProfitInput.getAttribute("value");
    }

    public String getFbaProfitMargin() {
        return fbaMinimumNetInput.getAttribute("value");
    }

    public String getFbaMinimumNet() {
        return fbaMinimumNetInput.getAttribute("value");
    }

    public void authByEmail() {
        var oa = new OnlineArbitrage(driver, wait);
        var oaExt = driver.getWindowHandle();

        oa.signInByEmailButton.click();
        oa.switchWindow();

        oa.authByEmailSendEmail();
        oa.confirmEmailButtonAuthByEmail.click();
        oa.switchWindow();

        oa.authByEmailSendPassword();
        oa.authButtonByEmail.click();
        driver.switchTo().window(oaExt);
    }

    public void authByGoogle() {
        var oa = new OnlineArbitrage(driver, wait);
        var oaExt = driver.getWindowHandle();

        oa.signInByGoogleButton.click();
        oa.switchWindow();

        var googleAuth = new GoogleAuthorization(driver, wait);

        googleAuth.authByGoogleSendEmail();
        googleAuth.confirmEmailButtonAuthByGoogle.click();
        googleAuth.switchWindow();

        googleAuth.authByGoogleSendPassword();
        googleAuth.confirmEmailButtonAuthByGoogle.click();
        driver.switchTo().window(oaExt);
    }


}
