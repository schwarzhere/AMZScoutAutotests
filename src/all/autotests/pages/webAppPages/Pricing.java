package all.autotests.pages.webAppPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pricing {

    private WebDriver driver;
    private WebDriverWait wait;

    public Pricing(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void switchToFrame() {
        driver.switchTo().frame(frameElement);
    }

    @FindBy(xpath = "//button[@data-id='tab1']")
    public WebElement payMonthlyButtonPricing;

    @FindBy(xpath = "//button[@data-id='tab2']")
    public WebElement payYearlyButtonPricing;

    @FindBy(xpath = "//button[@data-id='tab3']")
    public WebElement payForALifetimeButtonPricing;

    @FindBy(xpath = "(//div[@class='newPricingBlock__part-border'])[1]//a[@class='bt bt_static offer__btn']")
    public WebElement monthlyBundleBuyNowButton;

    @FindBy(xpath = "//div[@class='plans__modal']//iframe")
    public WebElement frameElement;

}
