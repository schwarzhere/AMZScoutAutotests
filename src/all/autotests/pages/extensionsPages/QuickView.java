package all.autotests.pages.extensionsPages;

import all.autotests.pages.GoogleAuthorization;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QuickView {
    private WebDriver driver;
    private WebDriverWait wait;

    public QuickView(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void switchWindow() {
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }

    @FindBy(xpath = "//div[text()='Google']")
    public WebElement signInByGoogleButton;

    @FindBy(xpath = "(//img[@title='Close'])[2]")
    public WebElement closeBigBannerButton;

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

    @FindBy(xpath = "//quick-view")
    public WebElement qvBlock;

    @FindBy(xpath = "//a[text()='Получить полную версию']")
    public WebElement getFullVersionButton;

    @FindBy(xpath = "//img[@title='Close']")
    public WebElement closeAuthWindow;

    public void authByEmailSendPassword() {
        passwordFieldAuthByEmail.sendKeys("djnx3rfrjq");
    }



    public void closeBigBanner() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("(//img[@title='Close'])[2]")));
        closeBigBannerButton.click();
    }

    public void authByEmailSendEmail() {
        emailFieldAuthByEmail.sendKeys("vlad.b@amzscout.net");
    }

    public void authByGoogle() {
        var qv = new QuickView(driver, wait);
        var qvExt = driver.getWindowHandle();

        qv.signInByGoogleButton.click();
        qv.switchWindow();

        var googleAuth = new GoogleAuthorization(driver, wait);

        googleAuth.authByGoogleSendEmail();
        googleAuth.confirmEmailButtonAuthByGoogle.click();
        googleAuth.switchWindow();

        googleAuth.authByGoogleSendPassword();
        googleAuth.confirmEmailButtonAuthByGoogle.click();
        driver.switchTo().window(qvExt);
    }

    public void authByEmail() {
        var qv = new QuickView(driver, wait);
        var qvExt = driver.getWindowHandle();

        qv.signInByEmailButton.click();
        qv.switchWindow();

        qv.authByEmailSendEmail();
        qv.confirmEmailButtonAuthByEmail.click();
        qv.switchWindow();

        qv.authByEmailSendPassword();
        qv.authButtonByEmail.click();
        driver.switchTo().window(qvExt);
    }
}
