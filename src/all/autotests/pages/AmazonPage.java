package all.autotests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public AmazonPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void zipCodeInputSendKeys(String text) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div#GLUXZipInputSection input[type='text']")));
        zipCodeInput.sendKeys(text);
    }

    public void applyZipCode() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("span#GLUXZipUpdate input")));
        applyZipCodeButton.click();
    }

    public void submitZipCode() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//input[@id='GLUXConfirmClose'])[2]")));
        submitZipCodeButton.click();
    }

    @FindBy(xpath = "//th[text()=' ASIN ']/parent::tr//td")
    public WebElement productAsin;

    @FindBy(id = "productTitle")
    public WebElement productTitle;

    @FindBy(xpath = "//a[contains(text(),'See Top 100')]/parent::span")
    public WebElement productBestSellersRank;

    @FindBy(id = "bylineInfo")
    public WebElement brandLink;

    @FindBy(xpath = "//div[@class='olp-text-box']/parent::div")
    public WebElement openAllSellersButton;

    @FindBy(id = "nav-global-location-popover-link")
    public WebElement deliverToButton;

    @FindBy(css = "div#GLUXZipInputSection input[type='text']")
    public WebElement zipCodeInput;

    @FindBy(css = "span#GLUXZipUpdate input")
    public WebElement applyZipCodeButton;

    @FindBy(xpath = "(//input[@id='GLUXConfirmClose'])[2]")
    public WebElement submitZipCodeButton;
}
