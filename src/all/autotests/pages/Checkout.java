package all.autotests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkout {
    private WebDriver driver;
    private WebDriverWait wait;

    public Checkout(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    public void switchToCardNumberFrame() {
        driver.switchTo().frame(cardNumberFrame);
    }

    public void switchToCardExpiryFrame() {
        driver.switchTo().frame(cardExpiryFrame);
    }

    public void switchToCardCvvFrame() {
        driver.switchTo().frame(cardCvvFrame);
    }

    @FindBy(css = "#js-paymentForm")
    public WebElement paymentForm;

    @FindBy(css = "#js-authForm")
    public WebElement paymentFormNoAuth;

    @FindBy(xpath = "(//iframe)[1]")
    public WebElement cardNumberFrame;

    @FindBy(xpath = "//div[@class='CardNumberField-input-wrapper']//input")
    public WebElement cardNumberInput;

    @FindBy(xpath = "(//iframe)[2]")
    public WebElement cardExpiryFrame;

    @FindBy(xpath = "//span[@class='InputContainer']//input")
    public WebElement cardExpiryInput;

    @FindBy(xpath = "(//iframe)[3]")
    public WebElement cardCvvFrame;

    @FindBy(xpath = "//span[@class='InputContainer']//input")
    public WebElement cardCvvInput;

    @FindBy(id = "newCheckout-payBtn")
    public WebElement subscribeButton;

    @FindBy(id = "js-paymentStatus__description")
    public WebElement paymentStatusDescription;

    public String getPaymentStatusDescriptionText() {
        return paymentStatusDescription.getText();
    }
}
