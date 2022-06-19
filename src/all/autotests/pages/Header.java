package all.autotests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header {
    private WebDriver driver;
    private WebDriverWait wait;

    public Header(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    private String url = "https://amzscout.net/";

    public void open() {
        driver.navigate().to(url);
    }

    @FindBy(xpath = "//div[@class='title'][text()='Pricing']")
    public WebElement pricing;

    @FindBy(xpath = "(//div[@class='newPricingBlock__part'])[2]//a[@class='bt_static offer__btn']")
    public WebElement annualBundleBuyNowButton;
}
