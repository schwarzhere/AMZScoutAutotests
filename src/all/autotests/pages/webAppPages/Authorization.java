package all.autotests.pages.webAppPages;

import all.autotests.pages.GoogleAuthorization;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class Authorization {
    private WebDriver driver;
    private WebDriverWait wait;

    public Authorization(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    private String generateEmail() {
        final var CHARS = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        final var sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 24; i++) {
            if (random.nextInt(3) == 1) {
                continue;
            }
            sb.append(CHARS.charAt(random.nextInt(CHARS.length())));
        }
        return sb.toString();
    }

    private String newTrialUserEmail = generateEmail() + "@amzscout.net";
    private String email = "autotestamz@mail.ru";
    private String password = "kcDyjVPj";

    @FindBy(xpath = "//iframe[@class='login__iframe']")
    public WebElement frameElement;

    @FindBy(xpath = "//a[@class='auth__link']")
    public WebElement signInLink;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement emailInputWebApp;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement authButton;

    @FindBy(css = "button.PgAuth-Social__btn_google")
    public WebElement signUpWithGoogleButton;

    @FindBy(xpath = "//div[@class='PgAuth-TabSection']/button[text()='Sign In']")
    public WebElement signInTab;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordInput;

    public void switchWindow() {
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }

    public void switchToFrame() {
        driver.switchTo().frame(frameElement);
    }

    public void webAppSignUpByEmail() throws InterruptedException {
        driver.navigate().to("https://amzscout.net/");
        signInLink.click();
        Thread.sleep(3000);
        switchToFrame();
        emailInputWebApp.sendKeys(newTrialUserEmail);
        authButton.click();
        driver.switchTo().parentFrame();
        Thread.sleep(2000);
    }

    public void webAppSignUpByGoogle() throws InterruptedException {
        driver.navigate().to("https://amzscout.net/");
        signInLink.click();
        Thread.sleep(3000);
        switchToFrame();
        signUpWithGoogleButton.click();
        var googleAuth = new GoogleAuthorization(driver, wait);
        googleAuth.switchWindow();
        googleAuth.authByGoogleSendEmail();
        googleAuth.confirmEmailButtonAuthByGoogle.click();
        googleAuth.switchWindow();
        googleAuth.authByGoogleSendPassword();
        googleAuth.confirmEmailButtonAuthByGoogle.click();
    }

    public void webAppSignIn() throws InterruptedException {
        driver.navigate().to("https://amzscout.net/");
        signInLink.click();
        Thread.sleep(3000);
        switchToFrame();
        signInTab.click();
        emailInputWebApp.sendKeys(email);
        passwordInput.sendKeys(password);
        authButton.click();
        driver.switchTo().parentFrame();
        Thread.sleep(2000);
    }
}
