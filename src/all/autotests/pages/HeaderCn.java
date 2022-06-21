package all.autotests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderCn {
    private WebDriver driver;
    private WebDriverWait wait;

    public HeaderCn(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    private String url = "https://amzscout.net/cn/";

    public void open() {
        driver.navigate().to(url);
    }

    @FindBy(css = "header.CnHeaderNewVersion")
    public WebElement header;

    @FindBy(xpath = "//a[text()='价格']")
    public WebElement pricing;

    @FindBy(xpath = "//div[text()='$349.99一年']/ancestor::div[contains(@class,'tariffs-list-offer')]//a")
    public WebElement annualBundleBuyNowButton;
}
