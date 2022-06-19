package all.autotests.pages.mainPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver, WebDriverWait wait) {
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

    @FindBy(xpath = "//div[@class='container newPricingBlock__switch']/button[1]")
    public WebElement payMonthlyButtonPricing;

    @FindBy(xpath = "(//a[@class='bt_static offer__btn'])[1]")
    public WebElement leftBuyButton;

    @FindBy(xpath = "//input[@type='email']")
    public WebElement emailInputMainPageCta;

    @FindBy(xpath = "//button[@type='button']")
    public WebElement submitButtonMainPageCta;

    @FindBy(id = "button-signup")
    public WebElement signUpButton;

    public void openMainPage() {
        driver.navigate().to("https://amzscout.net/");
    }

    public void openSellersBundlePage() {
        driver.navigate().to("https://amzscout.net/amazon-sellers-bundle/");
    }

    public void switchWindow() {
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }

    public void mainPageSignUpCta() {
        emailInputMainPageCta.sendKeys(newTrialUserEmail);
        submitButtonMainPageCta.click();
    }
}
